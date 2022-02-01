package cooperation.vip.AdvVideoFloat;

public abstract interface IAdvGerneralVideo
{
  public abstract String getCallBackData(String paramString);
  
  public abstract int getFirstKey();
  
  public abstract int getFourthKey();
  
  public abstract int getSecondKey();
  
  public abstract void notifyH5PageReady(String paramString);
  
  public abstract void notifyOnlyReportClick(String paramString);
  
  public abstract void notifyOnlyReportClickArea(int paramInt);
  
  public abstract void notifyVideoBlankClick(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.AdvVideoFloat.IAdvGerneralVideo
 * JD-Core Version:    0.7.0.1
 */