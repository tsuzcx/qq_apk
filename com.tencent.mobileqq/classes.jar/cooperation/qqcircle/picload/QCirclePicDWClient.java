package cooperation.qqcircle.picload;

import com.tencent.mobileqq.qcircle.api.data.Option;

public class QCirclePicDWClient
{
  public void toDownLoad(Option paramOption, AbsPicDW.ICallBackListener paramICallBackListener)
  {
    QCircleOkHttpDW localQCircleOkHttpDW = new QCircleOkHttpDW();
    QCircleHttpUrlDW localQCircleHttpUrlDW = new QCircleHttpUrlDW();
    QCircleHttpEngineDW localQCircleHttpEngineDW = new QCircleHttpEngineDW();
    localQCircleOkHttpDW.setNextDw(localQCircleHttpUrlDW);
    localQCircleHttpUrlDW.setNextDw(localQCircleHttpEngineDW);
    localQCircleOkHttpDW.handlerDownLoad(paramOption, paramICallBackListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCirclePicDWClient
 * JD-Core Version:    0.7.0.1
 */