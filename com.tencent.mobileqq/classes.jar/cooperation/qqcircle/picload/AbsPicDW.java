package cooperation.qqcircle.picload;

import com.tencent.mobileqq.qcircle.api.data.Option;

public abstract class AbsPicDW
{
  protected static final int DATA_BLOCK_LENGTH = 8192;
  protected static final String TAG = "QCircleFeedPicLoader";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.picload.AbsPicDW
 * JD-Core Version:    0.7.0.1
 */