import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.KingsMomentVideoDeliverController;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;

public class mcy
  extends TransProcessorHandler
{
  public mcy(KingsMomentVideoDeliverController paramKingsMomentVideoDeliverController) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || (localFileMsg.b != 24) || (localFileMsg.c != 10)) {}
    while (localFileMsg.f.equals(KingsMomentVideoDeliverController.a(this.a))) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1002: 
      KingsMomentVideoDeliverController.a(this.a, (float)localFileMsg.e * 100.0F / (float)localFileMsg.a);
      return;
    case 1003: 
      if (QLog.isColorLevel()) {
        QLog.d("KingsMomentVideoDeliveControllerr", 2, "mPicTransProcessorHandler send finished!");
      }
      KingsMomentVideoDeliverController.a(this.a, localFileMsg.f);
      KingsMomentVideoDeliverController.b(this.a, localFileMsg.i);
      if (QLog.isColorLevel()) {
        QLog.d("KingsMomentVideoDeliveControllerr", 2, "mPicTransProcessorHandler mImageMd5=" + KingsMomentVideoDeliverController.a(this.a) + ", mImageUrl=" + KingsMomentVideoDeliverController.b(this.a));
      }
      KingsMomentVideoDeliverController.a(this.a, 0, KingsMomentVideoDeliverController.b(this.a), KingsMomentVideoDeliverController.a(this.a), null, null, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("KingsMomentVideoDeliveControllerr", 2, "upload king moment cover failed");
    }
    KingsMomentVideoDeliverController.a(this.a, 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mcy
 * JD-Core Version:    0.7.0.1
 */