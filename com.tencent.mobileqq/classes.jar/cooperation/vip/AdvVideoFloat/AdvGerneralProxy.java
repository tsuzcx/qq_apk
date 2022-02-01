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
    if (this.mEngineImpl != null) {
      return this.mEngineImpl.getCallBackData(paramString);
    }
    return null;
  }
  
  public int getFirstKey()
  {
    if (this.mEngineImpl != null) {
      return this.mEngineImpl.getFirstKey();
    }
    return 0;
  }
  
  public int getFourthKey()
  {
    if (this.mEngineImpl != null) {
      return this.mEngineImpl.getFourthKey();
    }
    return 0;
  }
  
  public int getSecondKey()
  {
    if (this.mEngineImpl != null) {
      return this.mEngineImpl.getSecondKey();
    }
    return 0;
  }
  
  public void notifyH5PageReady(String paramString)
  {
    if (this.mEngineImpl != null) {
      this.mEngineImpl.notifyH5PageReady(paramString);
    }
  }
  
  public void notifyOnlyReportClick(String paramString)
  {
    if (this.mEngineImpl != null) {
      this.mEngineImpl.notifyOnlyReportClick(paramString);
    }
  }
  
  public void notifyOnlyReportClickArea(int paramInt)
  {
    if (this.mEngineImpl != null) {
      this.mEngineImpl.notifyOnlyReportClickArea(paramInt);
    }
  }
  
  public void notifyVideoBlankClick(String paramString)
  {
    if (this.mEngineImpl != null) {
      this.mEngineImpl.notifyVideoBlankClick(paramString);
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