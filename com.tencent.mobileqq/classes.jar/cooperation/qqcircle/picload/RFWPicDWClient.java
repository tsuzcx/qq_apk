package cooperation.qqcircle.picload;

import com.tencent.mobileqq.qcircle.api.data.Option;

public class RFWPicDWClient
{
  public void toDownLoad(Option paramOption, RFWAbsPicDW.ICallBackListener paramICallBackListener)
  {
    RFWOkHttpDW localRFWOkHttpDW = new RFWOkHttpDW();
    RFWHttpUrlDW localRFWHttpUrlDW = new RFWHttpUrlDW();
    RFWHttpEngineDW localRFWHttpEngineDW = new RFWHttpEngineDW();
    localRFWOkHttpDW.setNextDw(localRFWHttpUrlDW);
    localRFWHttpUrlDW.setNextDw(localRFWHttpEngineDW);
    localRFWOkHttpDW.handlerDownLoad(paramOption, paramICallBackListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.picload.RFWPicDWClient
 * JD-Core Version:    0.7.0.1
 */