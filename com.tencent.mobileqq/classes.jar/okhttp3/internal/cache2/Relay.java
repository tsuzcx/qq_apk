package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;

final class Relay
{
  private static final long FILE_HEADER_SIZE = 32L;
  static final ByteString PREFIX_CLEAN = ByteString.encodeUtf8("OkHttp cache v1\n");
  static final ByteString PREFIX_DIRTY = ByteString.encodeUtf8("OkHttp DIRTY :(\n");
  private static final int SOURCE_FILE = 2;
  private static final int SOURCE_UPSTREAM = 1;
  final Buffer buffer = new Buffer();
  final long bufferMaxSize;
  boolean complete;
  RandomAccessFile file;
  private final ByteString metadata;
  int sourceCount;
  Source upstream;
  final Buffer upstreamBuffer = new Buffer();
  long upstreamPos;
  Thread upstreamReader;
  
  private Relay(RandomAccessFile paramRandomAccessFile, Source paramSource, long paramLong1, ByteString paramByteString, long paramLong2)
  {
    this.file = paramRandomAccessFile;
    this.upstream = paramSource;
    if (paramSource == null) {}
    for (boolean bool = true;; bool = false)
    {
      this.complete = bool;
      this.upstreamPos = paramLong1;
      this.metadata = paramByteString;
      this.bufferMaxSize = paramLong2;
      return;
    }
  }
  
  public static Relay edit(File paramFile, Source paramSource, ByteString paramByteString, long paramLong)
  {
    paramFile = new RandomAccessFile(paramFile, "rw");
    paramSource = new Relay(paramFile, paramSource, 0L, paramByteString, paramLong);
    paramFile.setLength(0L);
    paramSource.writeHeader(PREFIX_DIRTY, -1L, -1L);
    return paramSource;
  }
  
  public static Relay read(File paramFile)
  {
    paramFile = new RandomAccessFile(paramFile, "rw");
    FileOperator localFileOperator = new FileOperator(paramFile.getChannel());
    Buffer localBuffer = new Buffer();
    localFileOperator.read(0L, localBuffer, 32L);
    if (!localBuffer.readByteString(PREFIX_CLEAN.size()).equals(PREFIX_CLEAN)) {
      throw new IOException("unreadable cache file");
    }
    long l1 = localBuffer.readLong();
    long l2 = localBuffer.readLong();
    localBuffer = new Buffer();
    localFileOperator.read(32L + l1, localBuffer, l2);
    return new Relay(paramFile, null, l1, localBuffer.readByteString(), 0L);
  }
  
  private void writeHeader(ByteString paramByteString, long paramLong1, long paramLong2)
  {
    Buffer localBuffer = new Buffer();
    localBuffer.write(paramByteString);
    localBuffer.writeLong(paramLong1);
    localBuffer.writeLong(paramLong2);
    if (localBuffer.size() != 32L) {
      throw new IllegalArgumentException();
    }
    new FileOperator(this.file.getChannel()).write(0L, localBuffer, 32L);
  }
  
  private void writeMetadata(long paramLong)
  {
    Buffer localBuffer = new Buffer();
    localBuffer.write(this.metadata);
    new FileOperator(this.file.getChannel()).write(32L + paramLong, localBuffer, this.metadata.size());
  }
  
  void commit(long paramLong)
  {
    writeMetadata(paramLong);
    this.file.getChannel().force(false);
    writeHeader(PREFIX_CLEAN, paramLong, this.metadata.size());
    this.file.getChannel().force(false);
    try
    {
      this.complete = true;
      Util.closeQuietly(this.upstream);
      this.upstream = null;
      return;
    }
    finally {}
  }
  
  boolean isClosed()
  {
    return this.file == null;
  }
  
  public ByteString metadata()
  {
    return this.metadata;
  }
  
  public Source newSource()
  {
    try
    {
      if (this.file == null) {
        return null;
      }
      this.sourceCount += 1;
      return new Relay.RelaySource(this);
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.internal.cache2.Relay
 * JD-Core Version:    0.7.0.1
 */