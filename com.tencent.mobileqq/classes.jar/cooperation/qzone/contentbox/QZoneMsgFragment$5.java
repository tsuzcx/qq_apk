package cooperation.qzone.contentbox;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneRuntimeService;
import com.tencent.qzonehub.model.QZoneMsgEntityNew;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class QZoneMsgFragment$5
  implements Runnable
{
  QZoneMsgFragment$5(QZoneMsgFragment paramQZoneMsgFragment) {}
  
  public void run()
  {
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    if (localObject == null) {
      return;
    }
    localObject = ((IQzoneRuntimeService)((AppRuntime)localObject).getRuntimeService(IQzoneRuntimeService.class, "")).loadMsgFromDB();
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      if (!QZoneMsgFragment.access$000(this.this$0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "onActivityCreated  刷新结果还没有返回，使用本地缓存显示");
        }
        QZoneMsgFragment.access$100(this.this$0, (QZoneMsgEntityNew)((ArrayList)localObject).get(0));
        QZoneMsgFragment.access$400(this.this$0).post(new QZoneMsgFragment.5.1(this, (ArrayList)localObject));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "onActivityCreated  界面已经刷新，不再使用本地缓存");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "onActivityCreated  本地没有缓存 qzoneMessageRsp==null ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.5
 * JD-Core Version:    0.7.0.1
 */