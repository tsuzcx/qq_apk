package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okio.BufferedSource;
import okio.ByteString;

final class Http2Reader
  implements Closeable
{
  static final Logger logger = Logger.getLogger(Http2.class.getName());
  private final boolean client;
  private final Http2Reader.ContinuationSource continuation;
  final Hpack.Reader hpackReader;
  private final BufferedSource source;
  
  Http2Reader(BufferedSource paramBufferedSource, boolean paramBoolean)
  {
    this.source = paramBufferedSource;
    this.client = paramBoolean;
    this.continuation = new Http2Reader.ContinuationSource(this.source);
    this.hpackReader = new Hpack.Reader(4096, this.continuation);
  }
  
  static int lengthWithoutPadding(int paramInt, byte paramByte, short paramShort)
  {
    short s = paramInt;
    if ((paramByte & 0x8) != 0) {
      s = paramInt - 1;
    }
    if (paramShort <= s) {
      return (short)(s - paramShort);
    }
    throw Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", new Object[] { Short.valueOf(paramShort), Integer.valueOf(s) });
  }
  
  private void readData(Http2Reader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
  {
    short s = 0;
    if (paramInt2 != 0)
    {
      int i = 1;
      boolean bool;
      if ((paramByte & 0x1) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      if ((paramByte & 0x20) == 0) {
        i = 0;
      }
      if (i == 0)
      {
        if ((paramByte & 0x8) != 0) {
          s = (short)(this.source.readByte() & 0xFF);
        }
        paramInt1 = lengthWithoutPadding(paramInt1, paramByte, s);
        paramHandler.data(bool, paramInt2, this.source, paramInt1);
        this.source.skip(s);
        return;
      }
      throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
    }
    throw Http2.ioException("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
  }
  
  private void readGoAway(Http2Reader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt1 >= 8)
    {
      if (paramInt2 == 0)
      {
        paramByte = this.source.readInt();
        paramInt2 = this.source.readInt();
        paramInt1 -= 8;
        ErrorCode localErrorCode = ErrorCode.fromHttp2(paramInt2);
        if (localErrorCode != null)
        {
          ByteString localByteString = ByteString.EMPTY;
          if (paramInt1 > 0) {
            localByteString = this.source.readByteString(paramInt1);
          }
          paramHandler.goAway(paramByte, localErrorCode, localByteString);
          return;
        }
        throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", new Object[] { Integer.valueOf(paramInt2) });
      }
      throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
    }
    throw Http2.ioException("TYPE_GOAWAY length < 8: %s", new Object[] { Integer.valueOf(paramInt1) });
  }
  
  private List<Header> readHeaderBlock(int paramInt1, short paramShort, byte paramByte, int paramInt2)
  {
    Http2Reader.ContinuationSource localContinuationSource = this.continuation;
    localContinuationSource.left = paramInt1;
    localContinuationSource.length = paramInt1;
    localContinuationSource.padding = paramShort;
    localContinuationSource.flags = paramByte;
    localContinuationSource.streamId = paramInt2;
    this.hpackReader.readHeaders();
    return this.hpackReader.getAndResetHeaderList();
  }
  
  private void readHeaders(Http2Reader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
  {
    short s = 0;
    if (paramInt2 != 0)
    {
      boolean bool;
      if ((paramByte & 0x1) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      if ((paramByte & 0x8) != 0) {
        s = (short)(this.source.readByte() & 0xFF);
      }
      int i = paramInt1;
      if ((paramByte & 0x20) != 0)
      {
        readPriority(paramHandler, paramInt2);
        i = paramInt1 - 5;
      }
      paramHandler.headers(bool, paramInt2, -1, readHeaderBlock(lengthWithoutPadding(i, paramByte, s), s, paramByte, paramInt2));
      return;
    }
    throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
  }
  
  static int readMedium(BufferedSource paramBufferedSource)
  {
    int i = paramBufferedSource.readByte();
    int j = paramBufferedSource.readByte();
    return paramBufferedSource.readByte() & 0xFF | (i & 0xFF) << 16 | (j & 0xFF) << 8;
  }
  
  private void readPing(Http2Reader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
  {
    boolean bool = false;
    if (paramInt1 == 8)
    {
      if (paramInt2 == 0)
      {
        paramInt1 = this.source.readInt();
        paramInt2 = this.source.readInt();
        if ((paramByte & 0x1) != 0) {
          bool = true;
        }
        paramHandler.ping(bool, paramInt1, paramInt2);
        return;
      }
      throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
    }
    throw Http2.ioException("TYPE_PING length != 8: %s", new Object[] { Integer.valueOf(paramInt1) });
  }
  
  private void readPriority(Http2Reader.Handler paramHandler, int paramInt)
  {
    int i = this.source.readInt();
    boolean bool;
    if ((0x80000000 & i) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramHandler.priority(paramInt, i & 0x7FFFFFFF, (this.source.readByte() & 0xFF) + 1, bool);
  }
  
  private void readPriority(Http2Reader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt1 == 5)
    {
      if (paramInt2 != 0)
      {
        readPriority(paramHandler, paramInt2);
        return;
      }
      throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
    }
    throw Http2.ioException("TYPE_PRIORITY length: %d != 5", new Object[] { Integer.valueOf(paramInt1) });
  }
  
  private void readPushPromise(Http2Reader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
  {
    short s = 0;
    if (paramInt2 != 0)
    {
      if ((paramByte & 0x8) != 0) {
        s = (short)(this.source.readByte() & 0xFF);
      }
      paramHandler.pushPromise(paramInt2, this.source.readInt() & 0x7FFFFFFF, readHeaderBlock(lengthWithoutPadding(paramInt1 - 4, paramByte, s), s, paramByte, paramInt2));
      return;
    }
    throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
  }
  
  private void readRstStream(Http2Reader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt1 == 4)
    {
      if (paramInt2 != 0)
      {
        paramInt1 = this.source.readInt();
        ErrorCode localErrorCode = ErrorCode.fromHttp2(paramInt1);
        if (localErrorCode != null)
        {
          paramHandler.rstStream(paramInt2, localErrorCode);
          return;
        }
        throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", new Object[] { Integer.valueOf(paramInt1) });
      }
      throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
    }
    throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", new Object[] { Integer.valueOf(paramInt1) });
  }
  
  private void readSettings(Http2Reader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      if ((paramByte & 0x1) != 0)
      {
        if (paramInt1 == 0)
        {
          paramHandler.ackSettings();
          return;
        }
        throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
      }
      if (paramInt1 % 6 == 0)
      {
        Settings localSettings = new Settings();
        paramInt2 = 0;
        while (paramInt2 < paramInt1)
        {
          byte b = this.source.readShort() & 0xFFFF;
          int i = this.source.readInt();
          paramByte = b;
          switch (b)
          {
          default: 
            paramByte = b;
            break;
          case 5: 
            if ((i >= 16384) && (i <= 16777215)) {
              paramByte = b;
            } else {
              throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[] { Integer.valueOf(i) });
            }
            break;
          case 4: 
            paramByte = 7;
            if (i < 0) {
              throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
            }
            break;
          case 3: 
            paramByte = 4;
            break;
          case 2: 
            paramByte = b;
            if (i != 0) {
              if (i == 1) {
                paramByte = b;
              } else {
                throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
              }
            }
            break;
          }
          localSettings.set(paramByte, i);
          paramInt2 += 6;
        }
        paramHandler.settings(false, localSettings);
        return;
      }
      throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", new Object[] { Integer.valueOf(paramInt1) });
    }
    paramHandler = Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
    for (;;)
    {
      throw paramHandler;
    }
  }
  
  private void readWindowUpdate(Http2Reader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt1 == 4)
    {
      long l = this.source.readInt() & 0x7FFFFFFF;
      if (l != 0L)
      {
        paramHandler.windowUpdate(paramInt2, l);
        return;
      }
      throw Http2.ioException("windowSizeIncrement was 0", new Object[] { Long.valueOf(l) });
    }
    throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", new Object[] { Integer.valueOf(paramInt1) });
  }
  
  public void close()
  {
    this.source.close();
  }
  
  public boolean nextFrame(boolean paramBoolean, Http2Reader.Handler paramHandler)
  {
    try
    {
      this.source.require(9L);
      int i = readMedium(this.source);
      if ((i >= 0) && (i <= 16384))
      {
        byte b1 = (byte)(this.source.readByte() & 0xFF);
        if ((paramBoolean) && (b1 != 4)) {
          throw Http2.ioException("Expected a SETTINGS frame but was %s", new Object[] { Byte.valueOf(b1) });
        }
        byte b2 = (byte)(this.source.readByte() & 0xFF);
        int j = this.source.readInt() & 0x7FFFFFFF;
        if (logger.isLoggable(Level.FINE)) {
          logger.fine(Http2.frameLog(true, j, i, b1, b2));
        }
        switch (b1)
        {
        default: 
          this.source.skip(i);
          return true;
        case 8: 
          readWindowUpdate(paramHandler, i, b2, j);
          return true;
        case 7: 
          readGoAway(paramHandler, i, b2, j);
          return true;
        case 6: 
          readPing(paramHandler, i, b2, j);
          return true;
        case 5: 
          readPushPromise(paramHandler, i, b2, j);
          return true;
        case 4: 
          readSettings(paramHandler, i, b2, j);
          return true;
        case 3: 
          readRstStream(paramHandler, i, b2, j);
          return true;
        case 2: 
          readPriority(paramHandler, i, b2, j);
          return true;
        case 1: 
          readHeaders(paramHandler, i, b2, j);
          return true;
        }
        readData(paramHandler, i, b2, j);
        return true;
      }
      throw Http2.ioException("FRAME_SIZE_ERROR: %s", new Object[] { Integer.valueOf(i) });
    }
    catch (IOException paramHandler) {}
    return false;
  }
  
  public void readConnectionPreface(Http2Reader.Handler paramHandler)
  {
    if (this.client)
    {
      if (nextFrame(true, paramHandler)) {
        return;
      }
      throw Http2.ioException("Required SETTINGS preface not received", new Object[0]);
    }
    paramHandler = this.source.readByteString(Http2.CONNECTION_PREFACE.size());
    if (logger.isLoggable(Level.FINE)) {
      logger.fine(Util.format("<< CONNECTION %s", new Object[] { paramHandler.hex() }));
    }
    if (Http2.CONNECTION_PREFACE.equals(paramHandler)) {
      return;
    }
    throw Http2.ioException("Expected a connection header but was %s", new Object[] { paramHandler.utf8() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Reader
 * JD-Core Version:    0.7.0.1
 */