package cooperation.qqcircle.picload;

import com.tencent.mobileqq.qcircle.api.data.Option;

public abstract class RFWAbsPicDW
{
  protected static final int DATA_BLOCK_LENGTH = 8192;
  protected static final String TAG = "QCircleFeedPicLoader";
  private RFWAbsPicDW mNextDw;
  
  public RFWAbsPicDW getNextDw()
  {
    return this.mNextDw;
  }
  
  public abstract void handlerDownLoad(Option paramOption, RFWAbsPicDW.ICallBackListener paramICallBackListener);
  
  public void setNextDw(RFWAbsPicDW paramRFWAbsPicDW)
  {
    this.mNextDw = paramRFWAbsPicDW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.picload.RFWAbsPicDW
 * JD-Core Version:    0.7.0.1
 */