package com.tencent.mobileqq.richmediabrowser.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.comment.config.ImmersiveConfProcessor;
import com.tencent.mobileqq.comment.danmaku.CommentDanmakuManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.IProvider;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserScene;
import com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.api.BrowserParamsBuilder;
import com.tencent.richmediabrowser.api.decorator.IDecoratorView;
import com.tencent.richmediabrowser.api.depend.IBrowserProvider;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.util.LiuHaiUtils;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class AIOFileVideoPresenter
  extends AIOBrowserBasePresenter
{
  public AIOFileVideoView e;
  public MqqHandler f = new AIOFileVideoPresenter.1(this);
  
  public AIOFileVideoPresenter()
  {
    QQVideoPlaySDKManager.initQQImp();
  }
  
  public Intent a(AIOFileVideoData paramAIOFileVideoData, Activity paramActivity)
  {
    if ((paramAIOFileVideoData != null) && ((this.a.getParamsBuilder().a() instanceof IProvider)))
    {
      Object localObject = (IProvider)this.a.getParamsBuilder().a();
      if (((IProvider)localObject).c())
      {
        localObject = ((IProvider)localObject).c(paramAIOFileVideoData.a, paramAIOFileVideoData.b, 0);
        if (localObject != null)
        {
          int i = paramAIOFileVideoData.f;
          boolean bool = true;
          if (i != 1) {
            bool = false;
          }
          ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).getForwardToFriendIntent(paramActivity, (Intent)localObject, bool);
          ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_jc_file");
          return localObject;
        }
      }
    }
    return null;
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong1);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103))
    {
      AIOFileVideoData localAIOFileVideoData = (AIOFileVideoData)localRichMediaBrowserInfo.baseData;
      localAIOFileVideoData.I = ((paramInt3 / 10000.0F * (float)localAIOFileVideoData.d));
      localRichMediaBrowserInfo.baseData = localAIOFileVideoData;
      if (this.c != null) {
        this.c.updateItem(localRichMediaBrowserInfo);
      }
    }
    if (this.c != null)
    {
      localRichMediaBrowserInfo = this.c.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOFileVideoData)) && (((AIOFileVideoData)localRichMediaBrowserInfo.baseData).a == paramLong1)) {
        this.e.a();
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    Object localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("notifyImageResult result = ");
    ((StringBuilder)localObject2).append(paramInt3);
    ((StringBuilder)localObject2).append(", type = ");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append(", resultStr = ");
    ((StringBuilder)localObject2).append(paramString);
    ((IBrowserLog)localObject1).d("AIOFileVideoPresenterXOXO", 2, ((StringBuilder)localObject2).toString());
    localObject1 = a(paramLong);
    if ((paramInt2 == 269484034) && (localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 103))
    {
      localObject2 = (AIOFileVideoData)((RichMediaBrowserInfo)localObject1).baseData;
      IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-----------> recv download finish:");
      localStringBuilder.append(paramLong);
      localIBrowserLog.d("AIOFileVideoPresenterXOXO", 4, localStringBuilder.toString());
      if (paramInt3 == 1)
      {
        if (!TextUtils.isEmpty(paramString)) {
          ((AIOFileVideoData)localObject2).l = paramString;
        }
        ((AIOFileVideoData)localObject2).v = true;
      }
      else if (paramInt3 == 2)
      {
        ((AIOFileVideoData)localObject2).v = false;
      }
      ((AIOFileVideoData)localObject2).y = false;
      if (((AIOFileVideoData)localObject2).A) {
        ((AIOFileVideoData)localObject2).status = 4;
      } else {
        ((AIOFileVideoData)localObject2).status = 3;
      }
      boolean bool = ((AIOFileVideoData)localObject2).A;
      ((RichMediaBrowserInfo)localObject1).baseData = ((RichMediaBaseData)localObject2);
      paramBoolean = bool;
      if (this.c != null)
      {
        this.c.updateItem((RichMediaBrowserInfo)localObject1);
        paramBoolean = bool;
      }
    }
    else
    {
      paramBoolean = false;
    }
    if ((paramInt2 == 269484034) && (this.c != null))
    {
      paramString = this.c.getSelectedItem();
      if ((paramString != null) && ((paramString.baseData instanceof AIOBrowserBaseData)) && (((AIOBrowserBaseData)paramString.baseData).a == paramLong))
      {
        if (paramBoolean) {
          if (paramInt3 == 1) {
            QQToast.makeText(this.e.c, 2, this.e.c.getString(2131915750), 0).show();
          } else if (paramInt3 == 2) {
            QQToast.makeText(this.e.c, 1, this.e.c.getString(2131915753), 0).show();
          }
        }
        this.e.a();
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoPresenterXOXO", 4, "-----------> recv download finish set playing!");
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageRecord paramMessageRecord, int paramInt3, Bundle paramBundle)
  {
    this.e.a(paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageRecord, paramInt3, paramBundle);
  }
  
  public void a(AIOFileVideoData paramAIOFileVideoData)
  {
    IBrowserProvider localIBrowserProvider = this.a.getParamsBuilder().a();
    if (!(localIBrowserProvider instanceof IProvider))
    {
      QLog.e("AIOFileVideoPresenterXOXO", 1, "handleUnDownloadVideo failed : provider null");
      return;
    }
    ((IProvider)localIBrowserProvider).a(paramAIOFileVideoData.a, 11, paramAIOFileVideoData.G);
  }
  
  public void a(IDecoratorView paramIDecoratorView)
  {
    super.a(paramIDecoratorView);
    if ((paramIDecoratorView instanceof AIOFileVideoView)) {
      this.e = ((AIOFileVideoView)paramIDecoratorView);
    }
  }
  
  public void b(int paramInt)
  {
    try
    {
      this.c.mActiveDrawable.remove(Integer.valueOf(paramInt));
      return;
    }
    catch (Exception localException)
    {
      IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRevokeMsg exception = ");
      localStringBuilder.append(localException.getMessage());
      localIBrowserLog.d("AIOFileVideoPresenterXOXO", 4, localStringBuilder.toString());
    }
  }
  
  public void b(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (this.c != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103))
    {
      ((AIOFileVideoData)localRichMediaBrowserInfo.baseData).y = false;
      this.c.updateItem(localRichMediaBrowserInfo);
    }
  }
  
  public void b(AIOFileVideoData paramAIOFileVideoData)
  {
    IBrowserProvider localIBrowserProvider = this.a.getParamsBuilder().a();
    if (!(localIBrowserProvider instanceof IProvider))
    {
      QLog.e("AIOFileVideoPresenterXOXO", 1, "cancelDownload failed : provider null");
      return;
    }
    ((IProvider)localIBrowserProvider).a(paramAIOFileVideoData.a, 12, paramAIOFileVideoData.G);
  }
  
  public void c(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (this.c != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103))
    {
      ((AIOFileVideoData)localRichMediaBrowserInfo.baseData).z = false;
      this.c.updateItem(localRichMediaBrowserInfo);
    }
  }
  
  public void c(AIOFileVideoData paramAIOFileVideoData)
  {
    if (this.a != null)
    {
      if (paramAIOFileVideoData == null) {
        return;
      }
      IBrowserProvider localIBrowserProvider = this.a.getParamsBuilder().a();
      if (!(localIBrowserProvider instanceof IProvider))
      {
        QLog.e("AIOFileVideoPresenterXOXO", 1, "handleVideoStopPlay failed : provider null");
        return;
      }
      ((IProvider)localIBrowserProvider).a(paramAIOFileVideoData.a, 10, paramAIOFileVideoData.G);
    }
  }
  
  public boolean c(int paramInt)
  {
    if (this.c != null)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.c.getItem(paramInt);
      if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103)) {
        return ((AIOFileVideoData)localRichMediaBrowserInfo.baseData).y;
      }
    }
    return false;
  }
  
  public long d()
  {
    AIOFileVideoView localAIOFileVideoView = this.e;
    if (localAIOFileVideoView != null) {
      return localAIOFileVideoView.t();
    }
    return 0L;
  }
  
  public void d(AIOFileVideoData paramAIOFileVideoData)
  {
    IBrowserProvider localIBrowserProvider = this.a.getParamsBuilder().a();
    if (!(localIBrowserProvider instanceof IProvider))
    {
      QLog.e("AIOFileVideoPresenterXOXO", 1, "handleVideoStopPlay failed : provider null");
      return;
    }
    ((IProvider)localIBrowserProvider).a(paramAIOFileVideoData.a, 14, paramAIOFileVideoData.G);
  }
  
  public void e()
  {
    if ((this.a != null) && (this.a.a != null) && (this.a.d() != null))
    {
      boolean bool = false;
      AIOFileVideoData localAIOFileVideoData = r();
      if (localAIOFileVideoData != null) {
        bool = FileUtils.fileExistsAndNotEmpty(localAIOFileVideoData.l);
      }
      if (bool)
      {
        if (LiuHaiUtils.b()) {
          this.a.d().a((int)Utils.a(LiuHaiUtils.d, this.e.c.getResources()) + 46);
        } else {
          this.a.d().a(46);
        }
        this.a.d().d();
        this.a.d().g();
        this.a.a.b();
      }
    }
  }
  
  public boolean h()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isImmersionOpen, ImmersiveConfProcessor.isVideoEnable() = ");
      localStringBuilder.append(ImmersiveConfProcessor.b());
      QLog.d("AIOFileVideoPresenterXOXO", 2, localStringBuilder.toString());
    }
    return ImmersiveConfProcessor.b();
  }
  
  public boolean i()
  {
    Object localObject = this.c;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = this.c.getSelectedItem();
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOBrowserBaseData))
        {
          localObject = (AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData;
          bool1 = bool2;
          if (this.d.get(Long.valueOf(((AIOBrowserBaseData)localObject).e)) != null)
          {
            bool1 = bool2;
            if (((Set)this.d.get(Long.valueOf(((AIOBrowserBaseData)localObject).e))).size() > 0) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    AIOFileVideoView localAIOFileVideoView = this.e;
    if (localAIOFileVideoView != null) {
      localAIOFileVideoView.c();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    AIOFileVideoView localAIOFileVideoView = this.e;
    if (localAIOFileVideoView != null) {
      localAIOFileVideoView.m();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    AIOFileVideoView localAIOFileVideoView = this.e;
    if (localAIOFileVideoView != null) {
      localAIOFileVideoView.n();
    }
  }
  
  public AIOFileVideoData r()
  {
    if (this.c != null)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.c.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103)) {
        return (AIOFileVideoData)localRichMediaBrowserInfo.baseData;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOFileVideoPresenter
 * JD-Core Version:    0.7.0.1
 */