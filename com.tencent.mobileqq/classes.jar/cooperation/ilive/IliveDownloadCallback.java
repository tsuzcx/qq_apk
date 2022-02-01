package cooperation.ilive;

public abstract interface IliveDownloadCallback
{
  public abstract void onFail(int paramInt, String paramString);
  
  public abstract void onProgress(float paramFloat);
  
  public abstract void onSuccess();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.IliveDownloadCallback
 * JD-Core Version:    0.7.0.1
 */