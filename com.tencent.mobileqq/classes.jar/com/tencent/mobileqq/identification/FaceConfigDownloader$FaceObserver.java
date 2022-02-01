package com.tencent.mobileqq.identification;

public final class FaceConfigDownloader$FaceObserver
  implements IResourceObserver
{
  private final FaceConfigDownloader.IConfigObserver a;
  
  public FaceConfigDownloader$FaceObserver(FaceConfigDownloader.IConfigObserver paramIConfigObserver)
  {
    this.a = paramIConfigObserver;
  }
  
  public void a(int paramInt)
  {
    FaceConfigDownloader.IConfigObserver localIConfigObserver = this.a;
    if (localIConfigObserver != null) {
      localIConfigObserver.a(paramInt, String.valueOf(paramInt));
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 0)
    {
      localIConfigObserver = this.a;
      if (localIConfigObserver != null) {
        localIConfigObserver.a(FaceConfigManager.a());
      }
      return;
    }
    FaceConfigDownloader.IConfigObserver localIConfigObserver = this.a;
    if (localIConfigObserver != null) {
      localIConfigObserver.a(paramInt, String.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.identification.FaceConfigDownloader.FaceObserver
 * JD-Core Version:    0.7.0.1
 */