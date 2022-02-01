package com.tencent.mobileqq.qzonealbumreddot;

import NS_MOBILE_PHOTO.operation_red_touch_req;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.util.PhotoUtils;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class QzoneAlbumRedTouchManager
  implements Manager
{
  QQAppInterface a;
  
  public QzoneAlbumRedTouchManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private SharedPreferences a()
  {
    String str2 = "";
    String str1 = str2;
    if (this.a != null)
    {
      str1 = str2;
      if (this.a.getCurrentAccountUin() != null) {
        str1 = this.a.getCurrentAccountUin();
      }
    }
    str1 = str1 + "_QZoneAlbumRedTouch";
    return BaseApplication.getContext().getSharedPreferences(str1, 0);
  }
  
  public static boolean c()
  {
    long l = 0L;
    if (QLog.isColorLevel()) {
      l = System.currentTimeMillis();
    }
    if (PhotoUtils.get().checkNewImages())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneAlbumRedTouchManager", 2, "checkNewImages cost:" + (System.currentTimeMillis() - l));
      }
      return true;
    }
    return false;
  }
  
  public long a()
  {
    return a().getLong("key_photo_guide_has_red_date", 0L);
  }
  
  public void a()
  {
    if (this.a == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneAlbumRedTouchManager", 2, "setRedTouch");
    }
    NewIntent localNewIntent = new NewIntent(this.a.getApplication(), QzoneAlbumRedTouchServlet.class);
    localNewIntent.putExtra("req", new operation_red_touch_req(1L));
    this.a.startServlet(localNewIntent);
  }
  
  @TargetApi(9)
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramAppInfo == null) || (paramAppInfo.iNewFlag.get() == 0) || (this.a == null)) {
      return;
    }
    QZoneClickReport.startReportImediately(this.a.getCurrentAccountUin(), "443", "1");
    ThreadManager.getSubThreadHandler().post(new QzoneAlbumRedTouchManager.2(this));
  }
  
  public boolean a()
  {
    long l2 = a();
    if (l2 <= 0L) {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneAlbumRedTouchManager", 2, "isShowedRedTouchToday false");
      }
    }
    do
    {
      return false;
      long l1 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoUploadRedPointTimeInterval", 24) * 60 * 60 * 1000;
      l2 = System.currentTimeMillis() - l2;
      if ((l2 <= l1) && (l2 >= 0L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QzoneAlbumRedTouchManager", 2, "isShowedRedTouchToday false");
    return false;
    if (QLog.isColorLevel()) {
      QLog.d("QzoneAlbumRedTouchManager", 2, "isShowedRedTouchToday true");
    }
    return true;
  }
  
  public void b()
  {
    if (this.a == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneAlbumRedTouchManager", 2, "clearRedTouch");
    }
    ThreadManager.getSubThreadHandler().post(new QzoneAlbumRedTouchManager.1(this));
  }
  
  public boolean b()
  {
    if (this.a == null) {
      return false;
    }
    Object localObject = (RedTouchManager)this.a.getManager(QQManagerFactory.MGR_RED_TOUCH);
    if (localObject == null) {
      return false;
    }
    localObject = ((RedTouchManager)localObject).a(String.valueOf(100180));
    return (localObject != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 1);
  }
  
  public void c()
  {
    if ((!PhotoUtils.isCurrentDayInQzone()) && (PhotoUtils.isOverLastCheck()) && (PhotoUtils.isInCheckTimeQuantum()))
    {
      LocalMultiProcConfig.putLong("key_photo_guide_last_check", System.currentTimeMillis());
      if (b()) {
        break label65;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QzoneAlbumRedTouchManager", 2, "not red");
      }
      if ((!a()) && (c())) {
        d();
      }
    }
    label65:
    while (c()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneAlbumRedTouchManager", 2, "has Red but clear Red Touch");
    }
    b();
  }
  
  @TargetApi(9)
  public void d()
  {
    int i = QzoneConfig.getInstance().getConfig("PhotoUpload", "GuideSelectPhotoSendRedJumpToQzone", 0);
    SharedPreferences.Editor localEditor = a().edit().putLong("key_photo_guide_has_red_date", System.currentTimeMillis());
    if (Build.VERSION.SDK_INT < 9) {
      localEditor.commit();
    }
    while ((i == 1) && (this.a != null) && (this.a.getApp() != null) && (QzonePhotoGuideNotifyService.a(this.a.getApp(), 84)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneAlbumRedTouchManager", 2, "GetQZonePhotoGuideCheck supportJumpToQzone");
      }
      new QzonePhotoGuideNotifyService(this.a, this).a();
      return;
      localEditor.apply();
    }
    a();
  }
  
  public void onDestroy()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager
 * JD-Core Version:    0.7.0.1
 */