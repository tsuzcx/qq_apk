package com.tencent.mobileqq.qzonealbumreddot;

import NS_MOBILE_PHOTO.operation_red_touch_req;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
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
    Object localObject = this.a;
    if ((localObject != null) && (((QQAppInterface)localObject).getCurrentAccountUin() != null)) {
      localObject = this.a.getCurrentAccountUin();
    } else {
      localObject = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_QZoneAlbumRedTouch");
    localObject = localStringBuilder.toString();
    return BaseApplication.getContext().getSharedPreferences((String)localObject, 0);
  }
  
  public static boolean c()
  {
    long l;
    if (QLog.isColorLevel()) {
      l = System.currentTimeMillis();
    } else {
      l = 0L;
    }
    if (PhotoUtils.get().checkNewImages())
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkNewImages cost:");
        localStringBuilder.append(System.currentTimeMillis() - l);
        QLog.d("QzoneAlbumRedTouchManager", 2, localStringBuilder.toString());
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
    if ((paramAppInfo != null) && (paramAppInfo.iNewFlag.get() != 0))
    {
      paramAppInfo = this.a;
      if (paramAppInfo == null) {
        return;
      }
      QZoneClickReport.startReportImediately(paramAppInfo.getCurrentAccountUin(), "443", "1");
      ThreadManager.getSubThreadHandler().post(new QzoneAlbumRedTouchManager.2(this));
    }
  }
  
  public boolean a()
  {
    long l2 = a();
    if (l2 <= 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneAlbumRedTouchManager", 2, "isShowedRedTouchToday false");
      }
      return false;
    }
    long l1 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoUploadRedPointTimeInterval", 24) * 60 * 60 * 1000;
    l2 = System.currentTimeMillis() - l2;
    if ((l2 <= l1) && (l2 >= 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneAlbumRedTouchManager", 2, "isShowedRedTouchToday true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneAlbumRedTouchManager", 2, "isShowedRedTouchToday false");
    }
    return false;
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
    Object localObject = this.a;
    if (localObject == null) {
      return false;
    }
    localObject = (IRedTouchManager)((QQAppInterface)localObject).getRuntimeService(IRedTouchManager.class, "");
    if (localObject == null) {
      return false;
    }
    localObject = ((IRedTouchManager)localObject).getAppInfoByPath(String.valueOf(100180));
    return (localObject != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 1);
  }
  
  public void c()
  {
    if ((!PhotoUtils.isCurrentDayInQzone()) && (PhotoUtils.isOverLastCheck()) && (PhotoUtils.isInCheckTimeQuantum()))
    {
      LocalMultiProcConfig.putLong("key_photo_guide_last_check", System.currentTimeMillis());
      if (!b())
      {
        if (QLog.isColorLevel()) {
          QLog.d("QzoneAlbumRedTouchManager", 2, "not red");
        }
        if ((!a()) && (c())) {
          d();
        }
      }
      else if (!c())
      {
        if (QLog.isColorLevel()) {
          QLog.d("QzoneAlbumRedTouchManager", 2, "has Red but clear Red Touch");
        }
        b();
      }
    }
  }
  
  @TargetApi(9)
  public void d()
  {
    int i = QzoneConfig.getInstance().getConfig("PhotoUpload", "GuideSelectPhotoSendRedJumpToQzone", 0);
    Object localObject = a().edit().putLong("key_photo_guide_has_red_date", System.currentTimeMillis());
    if (Build.VERSION.SDK_INT < 9) {
      ((SharedPreferences.Editor)localObject).commit();
    } else {
      ((SharedPreferences.Editor)localObject).apply();
    }
    if (i == 1)
    {
      localObject = this.a;
      if ((localObject != null) && (((QQAppInterface)localObject).getApp() != null) && (QzonePhotoGuideNotifyService.a(this.a.getApp(), 84)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QzoneAlbumRedTouchManager", 2, "GetQZonePhotoGuideCheck supportJumpToQzone");
        }
        new QzonePhotoGuideNotifyService(this.a, this).a();
        return;
      }
    }
    a();
  }
  
  public void onDestroy()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager
 * JD-Core Version:    0.7.0.1
 */