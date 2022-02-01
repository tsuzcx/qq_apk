package okhttp3.internal.ws;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.Buffer.UnsafeCursor;
import okio.BufferedSource;
import okio.Timeout;

final class WebSocketReader
{
  boolean closed;
  private final Buffer controlFrameBuffer = new Buffer();
  final WebSocketReader.FrameCallback frameCallback;
  long frameLength;
  final boolean isClient;
  boolean isControlFrame;
  boolean isFinalFrame;
  private final Buffer.UnsafeCursor maskCursor;
  private final byte[] maskKey;
  private final Buffer messageFrameBuffer = new Buffer();
  int opcode;
  final BufferedSource source;
  
  WebSocketReader(boolean paramBoolean, BufferedSource paramBufferedSource, WebSocketReader.FrameCallback paramFrameCallback)
  {
    if (paramBufferedSource == null) {
      throw new NullPointerException("source == null");
    }
    if (paramFrameCallback == null) {
      throw new NullPointerException("frameCallback == null");
    }
    this.isClient = paramBoolean;
    this.source = paramBufferedSource;
    this.frameCallback = paramFrameCallback;
    if (paramBoolean)
    {
      paramBufferedSource = null;
      this.maskKey = paramBufferedSource;
      if (!paramBoolean) {
        break label103;
      }
    }
    label103:
    for (paramBufferedSource = localObject;; paramBufferedSource = new Buffer.UnsafeCursor())
    {
      this.maskCursor = paramBufferedSource;
      return;
      paramBufferedSource = new byte[4];
      break;
    }
  }
  
  private void readControlFrame()
  {
    if (this.frameLength > 0L)
    {
      this.source.readFully(this.controlFrameBuffer, this.frameLength);
      if (!this.isClient)
      {
        this.controlFrameBuffer.readAndWriteUnsafe(this.maskCursor);
        this.maskCursor.seek(0L);
        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
        this.maskCursor.close();
      }
    }
    switch (this.opcode)
    {
    default: 
      throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.opcode));
    case 9: 
      this.frameCallback.onReadPing(this.controlFrameBuffer.readByteString());
      return;
    case 10: 
      this.frameCallback.onReadPong(this.controlFrameBuffer.readByteString());
      return;
    }
    int i = 1005;
    String str1 = "";
    long l = this.controlFrameBuffer.size();
    if (l == 1L) {
      throw new ProtocolException("Malformed close payload length of 1.");
    }
    if (l != 0L)
    {
      i = this.controlFrameBuffer.readShort();
      str1 = this.controlFrameBuffer.readUtf8();
      String str2 = WebSocketProtocol.closeCodeExceptionMessage(i);
      if (str2 != null) {
        throw new ProtocolException(str2);
      }
    }
    this.frameCallback.onReadClose(i, str1);
    this.closed = true;
  }
  
  private void readHeader()
  {
    boolean bool2 = true;
    if (this.closed) {
      throw new IOException("closed");
    }
    long l = this.source.timeout().timeoutNanos();
    this.source.timeout().clearTimeout();
    boolean bool1;
    for (;;)
    {
      try
      {
        i = this.source.readByte();
        k = i & 0xFF;
        this.source.timeout().timeout(l, TimeUnit.NANOSECONDS);
        this.opcode = (k & 0xF);
        if ((k & 0x80) != 0)
        {
          bool1 = true;
          this.isFinalFrame = bool1;
          if ((k & 0x8) == 0) {
            break label175;
          }
          bool1 = true;
          this.isControlFrame = bool1;
          if ((!this.isControlFrame) || (this.isFinalFrame)) {
            break;
          }
          throw new ProtocolException("Control frames must be final.");
        }
      }
      finally
      {
        this.source.timeout().timeout(l, TimeUnit.NANOSECONDS);
      }
      bool1 = false;
      continue;
      label175:
      bool1 = false;
    }
    int j;
    if ((k & 0x40) != 0)
    {
      i = 1;
      if ((k & 0x20) == 0) {
        break label235;
      }
      j = 1;
      label199:
      if ((k & 0x10) == 0) {
        break label240;
      }
    }
    label235:
    label240:
    for (int k = 1;; k = 0)
    {
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label245;
      }
      throw new ProtocolException("Reserved flags are unsupported.");
      i = 0;
      break;
      j = 0;
      break label199;
    }
    label245:
    int i = this.source.readByte() & 0xFF;
    if ((i & 0x80) != 0)
    {
      bool1 = bool2;
      if (bool1 != this.isClient) {
        break label314;
      }
      if (!this.isClient) {
        break label307;
      }
    }
    label307:
    for (String str = "Server-sent frames must not be masked.";; str = "Client-sent frames must be masked.")
    {
      throw new ProtocolException(str);
      bool1 = false;
      break;
    }
    label314:
    this.frameLength = (i & 0x7F);
    if (this.frameLength == 126L) {
      this.frameLength = (this.source.readShort() & 0xFFFF);
    }
    while ((this.isControlFrame) && (this.frameLength > 125L))
    {
      throw new ProtocolException("Control frame must be less than 125B.");
      if (this.frameLength == 127L)
      {
        this.frameLength = this.source.readLong();
        if (this.frameLength < 0L) {
          throw new ProtocolException("Frame length 0x" + Long.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
        }
      }
    }
    if (bool1) {
      this.source.readFully(this.maskKey);
    }
  }
  
  private void readMessage()
  {
    do
    {
      if (this.closed) {
        throw new IOException("closed");
      }
      if (this.frameLength > 0L)
      {
        this.source.readFully(this.messageFrameBuffer, this.frameLength);
        if (!this.isClient)
        {
          this.messageFrameBuffer.readAndWriteUnsafe(this.maskCursor);
          this.maskCursor.seek(this.messageFrameBuffer.size() - this.frameLength);
          WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
          this.maskCursor.close();
        }
      }
      if (this.isFinalFrame) {
        return;
      }
      readUntilNonControlFrame();
    } while (this.opcode == 0);
    throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.opcode));
  }
  
  private void readMessageFrame()
  {
    int i = this.opcode;
    if ((i != 1) && (i != 2)) {
      throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i));
    }
    readMessage();
    if (i == 1)
    {
      this.frameCallback.onReadMessage(this.messageFrameBuffer.readUtf8());
      return;
    }
    this.frameCallback.onReadMessage(this.messageFrameBuffer.readByteString());
  }
  
  private void readUntilNonControlFrame()
  {
    for (;;)
    {
      if (!this.closed)
      {
        readHeader();
        if (this.isControlFrame) {}
      }
      else
      {
        return;
      }
      readControlFrame();
    }
  }
  
  void processNextFrame()
  {
    readHeader();
    if (this.isControlFrame)
    {
      readControlFrame();
      return;
    }
    readMessageFrame();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.internal.ws.WebSocketReader
 * JD-Core Version:    0.7.0.1
 */