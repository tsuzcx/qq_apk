import com.tencent.av.ui.redbag.AVRedBag;
import com.tencent.av.ui.redbag.AVRedBagMgr;
import com.tencent.qphone.base.util.QLog;

class kei
  implements Runnable
{
  kei(keh paramkeh) {}
  
  public void run()
  {
    AVRedBagMgr localAVRedBagMgr = this.a.a.a();
    if (localAVRedBagMgr == null) {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.a.a.i, 1, "onAVActivityResume, AVRedBagMgr为空");
      }
    }
    do
    {
      return;
      if (localAVRedBagMgr.a()) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.w("AVRedBag", 1, "onAVActivityResume, 不是GameMode");
    return;
    localAVRedBagMgr.c("onAVActivityResume");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kei
 * JD-Core Version:    0.7.0.1
 */