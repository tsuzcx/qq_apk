package cooperation.qqcircle.picload;

public abstract class AbsPicDW
{
  protected static String TAG = QCircleFeedPicLoader.TAG;
  private AbsPicDW mNextDw;
  
  public AbsPicDW getNextDw()
  {
    return this.mNextDw;
  }
  
  public abstract void handlerDownLoad(Option paramOption, AbsPicDW.ICallBackListener paramICallBackListener);
  
  public void setNextDw(AbsPicDW paramAbsPicDW)
  {
    this.mNextDw = paramAbsPicDW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.picload.AbsPicDW
 * JD-Core Version:    0.7.0.1
 */