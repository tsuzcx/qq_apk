package org.apache.commons.io.input;

import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.Charsets;

public class ReversedLinesFileReader
  implements Closeable
{
  private final int avoidNewlineSplitBufferSize;
  private final int blockSize;
  private final int byteDecrement;
  private ReversedLinesFileReader.FilePart currentFilePart;
  private final Charset encoding;
  private final byte[][] newLineSequences;
  private final RandomAccessFile randomAccessFile;
  private final long totalBlockCount;
  private final long totalByteLength;
  private boolean trailingNewlineOfFileSkipped = false;
  
  @Deprecated
  public ReversedLinesFileReader(File paramFile)
  {
    this(paramFile, 4096, Charset.defaultCharset());
  }
  
  public ReversedLinesFileReader(File paramFile, int paramInt, String paramString)
  {
    this(paramFile, paramInt, Charsets.toCharset(paramString));
  }
  
  public ReversedLinesFileReader(File paramFile, int paramInt, Charset paramCharset)
  {
    this.blockSize = paramInt;
    this.encoding = paramCharset;
    Charset localCharset = Charsets.toCharset(paramCharset);
    int i;
    if (localCharset.newEncoder().maxBytesPerChar() == 1.0F)
    {
      this.byteDecrement = 1;
      this.newLineSequences = new byte[][] { "\r\n".getBytes(paramCharset), "\n".getBytes(paramCharset), "\r".getBytes(paramCharset) };
      this.avoidNewlineSplitBufferSize = this.newLineSequences[0].length;
      this.randomAccessFile = new RandomAccessFile(paramFile, "r");
      this.totalByteLength = this.randomAccessFile.length();
      i = (int)(this.totalByteLength % paramInt);
      if (i <= 0) {
        break label311;
      }
      this.totalBlockCount = (this.totalByteLength / paramInt + 1L);
    }
    for (;;)
    {
      this.currentFilePart = new ReversedLinesFileReader.FilePart(this, this.totalBlockCount, i, null, null);
      return;
      if (localCharset == StandardCharsets.UTF_8)
      {
        this.byteDecrement = 1;
        break;
      }
      if ((localCharset == Charset.forName("Shift_JIS")) || (localCharset == Charset.forName("windows-31j")) || (localCharset == Charset.forName("x-windows-949")) || (localCharset == Charset.forName("gbk")) || (localCharset == Charset.forName("x-windows-950")))
      {
        this.byteDecrement = 1;
        break;
      }
      if ((localCharset == StandardCharsets.UTF_16BE) || (localCharset == StandardCharsets.UTF_16LE))
      {
        this.byteDecrement = 2;
        break;
      }
      if (localCharset == StandardCharsets.UTF_16) {
        throw new UnsupportedEncodingException("For UTF-16, you need to specify the byte order (use UTF-16BE or UTF-16LE)");
      }
      throw new UnsupportedEncodingException("Encoding " + paramCharset + " is not supported yet (feel free to submit a patch)");
      label311:
      this.totalBlockCount = (this.totalByteLength / paramInt);
      if (this.totalByteLength > 0L) {
        i = paramInt;
      }
    }
  }
  
  public ReversedLinesFileReader(File paramFile, Charset paramCharset)
  {
    this(paramFile, 4096, paramCharset);
  }
  
  public void close()
  {
    this.randomAccessFile.close();
  }
  
  public String readLine()
  {
    for (String str1 = ReversedLinesFileReader.FilePart.access$100(this.currentFilePart); str1 == null; str1 = ReversedLinesFileReader.FilePart.access$100(this.currentFilePart))
    {
      this.currentFilePart = ReversedLinesFileReader.FilePart.access$200(this.currentFilePart);
      if (this.currentFilePart == null) {
        break;
      }
    }
    String str2 = str1;
    if ("".equals(str1))
    {
      str2 = str1;
      if (!this.trailingNewlineOfFileSkipped)
      {
        this.trailingNewlineOfFileSkipped = true;
        str2 = readLine();
      }
    }
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.apache.commons.io.input.ReversedLinesFileReader
 * JD-Core Version:    0.7.0.1
 */