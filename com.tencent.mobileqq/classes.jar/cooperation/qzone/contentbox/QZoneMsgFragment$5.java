package cooperation.qzone.contentbox;

import android.os.Handler;
import bmyi;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;
import java.util.ArrayList;

class QZoneMsgFragment$5
  implements Runnable
{
  QZoneMsgFragment$5(QZoneMsgFragment paramQZoneMsgFragment, bmyi parambmyi) {}
  
  public void run()
  {
    ArrayList localArrayList = this.a.a();
    if ((localArrayList == null) || (localArrayList.size() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "onActivityCreated  本地没有缓存 qzoneMessageRsp==null ");
      }
    }
    do
    {
      return;
      if (!QZoneMsgFragment.a(this.this$0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "onActivityCreated  刷新结果还没有返回，使用本地缓存显示");
        }
        QZoneMsgFragment.a(this.this$0, (QZoneMsgEntityNew)localArrayList.get(0));
        QZoneMsgFragment.a(this.this$0).post(new QZoneMsgFragment.5.1(this, localArrayList));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "onActivityCreated  界面已经刷新，不再使用本地缓存");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.5
 * JD-Core Version:    0.7.0.1
 */