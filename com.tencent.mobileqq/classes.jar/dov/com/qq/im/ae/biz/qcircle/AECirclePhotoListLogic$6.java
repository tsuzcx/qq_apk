package dov.com.qq.im.ae.biz.qcircle;

import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class AECirclePhotoListLogic$6
  implements Runnable
{
  AECirclePhotoListLogic$6(AECirclePhotoListLogic paramAECirclePhotoListLogic, ArrayList paramArrayList1, ArrayList paramArrayList2, boolean paramBoolean) {}
  
  public void run()
  {
    AEQLog.b("AECirclePhotoListLogic", "serialCompressVideos---begin, need compress count=" + this.jdField_a_of_type_JavaUtilArrayList.size());
    AECirclePhotoListLogic.b(this.this$0, false);
    AECirclePhotoListLogic.a(this.this$0, this.jdField_a_of_type_JavaUtilArrayList);
    AEQLog.b("AECirclePhotoListLogic", "serialCompressVideos---end, canceled=" + AECirclePhotoListLogic.a(this.this$0));
    if ((!AECirclePhotoListLogic.a(this.this$0)) && (!AECirclePhotoListLogic.b(this.this$0))) {
      ThreadManager.getUIHandler().post(new AECirclePhotoListLogic.6.1(this));
    }
    for (;;)
    {
      AECirclePhotoListLogic.a(this.this$0, false);
      AECirclePhotoListLogic.b(this.this$0, false);
      return;
      ThreadManager.getUIHandler().post(new AECirclePhotoListLogic.6.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.AECirclePhotoListLogic.6
 * JD-Core Version:    0.7.0.1
 */