package cooperation.vip.AdvVideoFloat;

public class AdvGerneralProxy
  implements IAdvGerneralVideo
{
  private static AdvGerneralProxy mInstance;
  private IAdvGerneralVideo mEngineImpl;
  
  public static AdvGerneralProxy getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new AdvGerneralProxy();
      }
      AdvGerneralProxy localAdvGerneralProxy = mInstance;
      return localAdvGerneralProxy;
    }
    finally {}
  }
  
  public String getCallBackData(String paramString)
  {
    IAdvGerneralVideo localIAdvGerneralVideo = this.mEngineImpl;
    if (localIAdvGerneralVideo != null) {
      return localIAdvGerneralVideo.getCallBackData(paramString);
    }
    return null;
  }
  
  public int getFirstKey()
  {
    IAdvGerneralVideo localIAdvGerneralVideo = this.mEngineImpl;
    if (localIAdvGerneralVideo != null) {
      return localIAdvGerneralVideo.getFirstKey();
    }
    return 0;
  }
  
  public int getFourthKey()
  {
    IAdvGerneralVideo localIAdvGerneralVideo = this.mEngineImpl;
    if (localIAdvGerneralVideo != null) {
      return localIAdvGerneralVideo.getFourthKey();
    }
    return 0;
  }
  
  public int getSecondKey()
  {
    IAdvGerneralVideo localIAdvGerneralVideo = this.mEngineImpl;
    if (localIAdvGerneralVideo != null) {
      return localIAdvGerneralVideo.getSecondKey();
    }
    return 0;
  }
  
  public void notifyH5PageReady(String paramString)
  {
    IAdvGerneralVideo localIAdvGerneralVideo = this.mEngineImpl;
    if (localIAdvGerneralVideo != null) {
      localIAdvGerneralVideo.notifyH5PageReady(paramString);
    }
  }
  
  public void notifyOnlyReportClick(String paramString)
  {
    IAdvGerneralVideo localIAdvGerneralVideo = this.mEngineImpl;
    if (localIAdvGerneralVideo != null) {
      localIAdvGerneralVideo.notifyOnlyReportClick(paramString);
    }
  }
  
  public void notifyOnlyReportClickArea(int paramInt)
  {
    IAdvGerneralVideo localIAdvGerneralVideo = this.mEngineImpl;
    if (localIAdvGerneralVideo != null) {
      localIAdvGerneralVideo.notifyOnlyReportClickArea(paramInt);
    }
  }
  
  public void notifyVideoBlankClick(String paramString)
  {
    IAdvGerneralVideo localIAdvGerneralVideo = this.mEngineImpl;
    if (localIAdvGerneralVideo != null) {
      localIAdvGerneralVideo.notifyVideoBlankClick(paramString);
    }
  }
  
  public void setmEngineImpl(IAdvGerneralVideo paramIAdvGerneralVideo)
  {
    this.mEngineImpl = paramIAdvGerneralVideo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.AdvVideoFloat.AdvGerneralProxy
 * JD-Core Version:    0.7.0.1
 */