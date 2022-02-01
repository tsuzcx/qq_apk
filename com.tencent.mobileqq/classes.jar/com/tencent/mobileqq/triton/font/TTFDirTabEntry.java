package com.tencent.mobileqq.triton.font;

import java.io.UnsupportedEncodingException;

public class TTFDirTabEntry
{
  private long length;
  private long offset;
  private final byte[] tag = new byte[4];
  
  TTFDirTabEntry() {}
  
  public TTFDirTabEntry(long paramLong1, long paramLong2)
  {
    this.offset = paramLong1;
    this.length = paramLong2;
  }
  
  public long getLength()
  {
    return this.length;
  }
  
  public long getOffset()
  {
    return this.offset;
  }
  
  public byte[] getTag()
  {
    return this.tag;
  }
  
  public String getTagString()
  {
    try
    {
      String str = new String(this.tag, "ISO-8859-1");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label16:
      break label16;
    }
    return toString();
  }
  
  public String read(FontFileReader paramFontFileReader)
  {
    this.tag[0] = paramFontFileReader.readTTFByte();
    this.tag[1] = paramFontFileReader.readTTFByte();
    this.tag[2] = paramFontFileReader.readTTFByte();
    this.tag[3] = paramFontFileReader.readTTFByte();
    paramFontFileReader.skip(4L);
    this.offset = paramFontFileReader.readTTFULong();
    this.length = paramFontFileReader.readTTFULong();
    return new String(this.tag, "ISO-8859-1");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Read dir tab [");
    localStringBuilder.append(this.tag[0]);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.tag[1]);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.tag[2]);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.tag[3]);
    localStringBuilder.append("] offset: ");
    localStringBuilder.append(this.offset);
    localStringBuilder.append(" bytesToUpload: ");
    localStringBuilder.append(this.length);
    localStringBuilder.append(" name: ");
    localStringBuilder.append(this.tag);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.font.TTFDirTabEntry
 * JD-Core Version:    0.7.0.1
 */