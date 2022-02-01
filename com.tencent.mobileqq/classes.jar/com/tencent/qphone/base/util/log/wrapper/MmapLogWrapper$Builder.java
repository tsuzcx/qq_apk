package com.tencent.qphone.base.util.log.wrapper;

public class MmapLogWrapper$Builder
{
  private String bufferFilePath;
  private int bufferSize = 8192;
  private boolean compress;
  private boolean encrypt;
  private String logFilePath;
  
  public MmapLogWrapper create()
  {
    if (this.logFilePath != null)
    {
      if (this.bufferFilePath != null) {
        return new MmapLogWrapper(this);
      }
      throw new RuntimeException("need bufferFilePath path");
    }
    throw new IllegalArgumentException("logFilePath cannot be null");
  }
  
  public Builder setBufferFilePath(String paramString)
  {
    this.bufferFilePath = paramString;
    return this;
  }
  
  public Builder setBufferSize(int paramInt)
  {
    this.bufferSize = paramInt;
    return this;
  }
  
  public Builder setCompress(boolean paramBoolean)
  {
    this.compress = paramBoolean;
    return this;
  }
  
  public Builder setEncrypt(boolean paramBoolean)
  {
    this.encrypt = paramBoolean;
    return this;
  }
  
  public Builder setLogFilePath(String paramString)
  {
    this.logFilePath = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.wrapper.MmapLogWrapper.Builder
 * JD-Core Version:    0.7.0.1
 */