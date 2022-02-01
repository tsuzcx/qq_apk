package com.tencent.video.decode;

public class AVideoException
  extends RuntimeException
{
  private static final long serialVersionUID = -3387516993124229948L;
  public int mErrCode = 0;
  public int mErrSubcode = 0;
  
  public AVideoException(int paramInt1, int paramInt2, String paramString)
  {
    super(paramString);
    this.mErrCode = paramInt1;
    this.mErrSubcode = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.video.decode.AVideoException
 * JD-Core Version:    0.7.0.1
 */