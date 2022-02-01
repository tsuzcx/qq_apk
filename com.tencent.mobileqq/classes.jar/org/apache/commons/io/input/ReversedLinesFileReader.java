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
    if (localCharset.newEncoder().maxBytesPerChar() == 1.0F)
    {
      this.byteDecrement = 1;
    }
    else if (localCharset == StandardCharsets.UTF_8)
    {
      this.byteDecrement = 1;
    }
    else if ((localCharset != Charset.forName("Shift_JIS")) && (localCharset != Charset.forName("windows-31j")) && (localCharset != Charset.forName("x-windows-949")) && (localCharset != Charset.forName("gbk")) && (localCharset != Charset.forName("x-windows-950")))
    {
      if ((localCharset != StandardCharsets.UTF_16BE) && (localCharset != StandardCharsets.UTF_16LE))
      {
        if (localCharset == StandardCharsets.UTF_16) {
          throw new UnsupportedEncodingException("For UTF-16, you need to specify the byte order (use UTF-16BE or UTF-16LE)");
        }
        paramFile = new StringBuilder();
        paramFile.append("Encoding ");
        paramFile.append(paramCharset);
        paramFile.append(" is not supported yet (feel free to submit a patch)");
        throw new UnsupportedEncodingException(paramFile.toString());
      }
      this.byteDecrement = 2;
    }
    else
    {
      this.byteDecrement = 1;
    }
    this.newLineSequences = new byte[][] { "\r\n".getBytes(paramCharset), "\n".getBytes(paramCharset), "\r".getBytes(paramCharset) };
    this.avoidNewlineSplitBufferSize = this.newLineSequences[0].length;
    this.randomAccessFile = new RandomAccessFile(paramFile, "r");
    this.totalByteLength = this.randomAccessFile.length();
    long l1 = this.totalByteLength;
    long l2 = paramInt;
    int i = (int)(l1 % l2);
    if (i > 0)
    {
      this.totalBlockCount = (l1 / l2 + 1L);
    }
    else
    {
      this.totalBlockCount = (l1 / l2);
      if (l1 > 0L) {
        break label335;
      }
    }
    paramInt = i;
    label335:
    this.currentFilePart = new ReversedLinesFileReader.FilePart(this, this.totalBlockCount, paramInt, null, null);
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
    for (String str = ReversedLinesFileReader.FilePart.access$100(this.currentFilePart); str == null; str = ReversedLinesFileReader.FilePart.access$100((ReversedLinesFileReader.FilePart)localObject))
    {
      this.currentFilePart = ReversedLinesFileReader.FilePart.access$200(this.currentFilePart);
      localObject = this.currentFilePart;
      if (localObject == null) {
        break;
      }
    }
    Object localObject = str;
    if ("".equals(str))
    {
      localObject = str;
      if (!this.trailingNewlineOfFileSkipped)
      {
        this.trailingNewlineOfFileSkipped = true;
        localObject = readLine();
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.input.ReversedLinesFileReader
 * JD-Core Version:    0.7.0.1
 */