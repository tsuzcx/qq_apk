package com.tencent.mobileqq.qzonealbumreddot;

import NS_MOBILE_PHOTO.operation_red_touch_req;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import mqq.app.NewIntent;

class QzoneAlbumRedTouchManager$1
  implements Runnable
{
  QzoneAlbumRedTouchManager$1(QzoneAlbumRedTouchManager paramQzoneAlbumRedTouchManager) {}
  
  public void run()
  {
    if (this.this$0.a == null) {
      return;
    }
    Object localObject = (RedTouchManager)this.this$0.a.getManager(QQManagerFactory.MGR_RED_TOUCH);
    String str = String.valueOf(100180);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)localObject).a(str);
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1))
    {
      ((RedTouchManager)localObject).c(str);
      LocalMultiProcConfig.putBool("key_photo_guide_is_red", false);
      QZoneClickReport.startReportImediately(this.this$0.a.getCurrentAccountUin(), "443", "2");
      return;
    }
    localObject = new NewIntent(this.this$0.a.getApplication(), QzoneAlbumRedTouchServlet.class);
    ((NewIntent)localObject).putExtra("req", new operation_red_touch_req(2L));
    this.this$0.a.startServlet((NewIntent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager.1
 * JD-Core Version:    0.7.0.1
 */