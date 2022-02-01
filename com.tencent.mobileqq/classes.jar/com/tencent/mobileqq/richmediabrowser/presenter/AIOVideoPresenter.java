package com.tencent.mobileqq.richmediabrowser.presenter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.comment.config.ImmersiveConfProcessor;
import com.tencent.mobileqq.comment.danmaku.CommentDanmakuManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.IProvider;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOBrowserModel;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.richmediabrowser.model.VideoPlayMedioInfo;
import com.tencent.mobileqq.richmediabrowser.utils.LongVideoUrlCacheManager;
import com.tencent.mobileqq.richmediabrowser.utils.LongVideoUrlCacheManager.UrlsCacheBean;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserScene;
import com.tencent.mobileqq.richmediabrowser.view.AIOVideoView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.richmediabrowser.api.BrowserParamsBuilder;
import com.tencent.richmediabrowser.api.decorator.IDecoratorView;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.EmptyDrawable;
import com.tencent.util.LiuHaiUtils;
import java.io.File;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class AIOVideoPresenter
  extends AIOBrowserBasePresenter
  implements INetInfoHandler
{
  public AIOVideoView e;
  public ConcurrentHashMap<Integer, URLDrawable> f = new ConcurrentHashMap();
  public MqqHandler g = new AIOVideoPresenter.1(this);
  
  public AIOVideoPresenter()
  {
    QQVideoPlaySDKManager.initQQImp();
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    EmptyDrawable localEmptyDrawable = new EmptyDrawable(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localEmptyDrawable, localEmptyDrawable);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCoverDrawable():  getDrawable Exception, coverUrl=");
        localStringBuilder.append(paramString);
        localStringBuilder.append("exception = ");
        localStringBuilder.append(localException.getMessage());
        localIBrowserLog.d("AIOVideoPresenter", 4, localStringBuilder.toString());
      }
    }
    return localEmptyDrawable;
  }
  
  public void a(int paramInt, long paramLong)
  {
    VideoPlayMedioInfo localVideoPlayMedioInfo = b(r());
    if (localVideoPlayMedioInfo != null) {
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).updateMsgStatus(paramInt, paramLong, localVideoPlayMedioInfo.f, localVideoPlayMedioInfo.g, this.a.getParamsBuilder().a());
    }
  }
  
  public void a(int paramInt, File paramFile)
  {
    if (paramInt != 1) {
      if (paramInt != 2) {
        str = null;
      }
    }
    for (;;)
    {
      break;
      str = "0X8007A25";
      continue;
      str = "0X8007A24";
    }
    if (str != null) {
      ReportController.b(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }
    String str = ((IShortVideoDepend)QRoute.api(IShortVideoDepend.class)).getLocalShortVideoPath();
    if (((IBrowserDepend)QRoute.api(IBrowserDepend.class)).saveVideoToAlbum(BaseApplication.getContext(), paramFile.getAbsolutePath(), str)) {
      QQToast.makeText(this.e.c, 2, 2131915750, 0).show();
    } else {
      QQToast.makeText(this.e.c, 1, 2131915753, 0).show();
    }
    ReportController.b(null, "CliOper", "", "", "0X800610F", "0X800610F", 0, 0, "", "", "", "");
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong1);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData.getType() == 101) && ((localRichMediaBrowserInfo.baseData instanceof AIOVideoData)))
    {
      AIOVideoData localAIOVideoData = (AIOVideoData)localRichMediaBrowserInfo.baseData;
      if (paramInt2 == 256) {
        localAIOVideoData.status = 7;
      }
      localAIOVideoData.progress = paramInt3;
      localRichMediaBrowserInfo.baseData = localAIOVideoData;
      if (this.c != null) {
        this.c.updateItem(localRichMediaBrowserInfo);
      }
    }
    if ((this.c != null) && (this.e != null))
    {
      localRichMediaBrowserInfo = this.c.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOVideoData)) && (((AIOVideoData)localRichMediaBrowserInfo.baseData).a == paramLong1)) {
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
    ((IBrowserLog)localObject1).d("AIOVideoPresenter", 2, ((StringBuilder)localObject2).toString());
    localObject1 = a(paramLong);
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 101) && ((((RichMediaBrowserInfo)localObject1).baseData instanceof AIOVideoData)))
    {
      localObject2 = (AIOVideoData)((RichMediaBrowserInfo)localObject1).baseData;
      ((AIOVideoData)localObject2).status = 0;
      ((AIOVideoData)localObject2).progress = 0;
      ((RichMediaBrowserInfo)localObject1).baseData = ((RichMediaBaseData)localObject2);
      if (this.c != null) {
        this.c.updateItem((RichMediaBrowserInfo)localObject1);
      }
    }
    if ((this.a != null) && (this.a.b != null) && (this.e != null))
    {
      localObject1 = this.a.b.getSelectedItem();
      if ((localObject1 != null) && ((((RichMediaBrowserInfo)localObject1).baseData instanceof AIOVideoData)) && (((AIOVideoData)((RichMediaBrowserInfo)localObject1).baseData).a == paramLong))
      {
        this.e.a();
        if (paramInt2 == 256)
        {
          localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("save video result resultStr = ");
          ((StringBuilder)localObject2).append(paramString);
          ((IBrowserLog)localObject1).d("AIOVideoPresenter", 4, ((StringBuilder)localObject2).toString());
          if (paramInt3 == 1)
          {
            QQToast.makeText(this.e.c, 2, this.e.c.getString(2131915750), 0).show();
            return;
          }
          QQToast.makeText(this.e.c, 1, this.e.c.getString(2131915753), 0).show();
          return;
        }
        if ((paramInt2 == 1) || (paramInt2 == 0))
        {
          if (paramInt3 != 1) {
            paramString = "I:E";
          }
          a(paramLong, paramInt1, paramInt2, paramString);
          if (this.e.h != null) {
            this.e.a(this.c.getSelectedIndex(), this.e.h.mBrowserItemView, paramBoolean);
          }
        }
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageRecord paramMessageRecord, int paramInt3, Bundle paramBundle)
  {
    paramBundle = this.e;
    if (paramBundle != null) {
      paramBundle.a(paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageRecord, paramInt3);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (this.a != null) && (this.a.b != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101))
    {
      ((AIOVideoData)localRichMediaBrowserInfo.baseData).v = paramBoolean;
      this.a.b.updateItem(localRichMediaBrowserInfo);
    }
  }
  
  public void a(AIOVideoData paramAIOVideoData)
  {
    if ((paramAIOVideoData != null) && ((this.a.getParamsBuilder().a() instanceof IProvider)))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "dealSaveVideo");
      ((IProvider)this.a.getParamsBuilder().a()).a(paramAIOVideoData.a, paramAIOVideoData.b, 256);
    }
  }
  
  public void a(IDecoratorView paramIDecoratorView)
  {
    super.a(paramIDecoratorView);
    if ((paramIDecoratorView instanceof AIOVideoView)) {
      this.e = ((AIOVideoView)paramIDecoratorView);
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this.e.c, this);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, ImageView paramImageView, int paramInt3)
  {
    if (FileUtils.fileExistsAndNotEmpty(paramString))
    {
      paramString = ((IShortVideoDepend)QRoute.api(IShortVideoDepend.class)).getThumbUrl(paramString);
      if (paramString != null)
      {
        paramString = a(paramString.toString(), paramInt1, paramInt2);
        if ((paramString instanceof URLDrawable)) {
          this.f.put(Integer.valueOf(paramInt3), (URLDrawable)paramString);
        }
        paramImageView.setImageDrawable(paramString);
        return;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "url  is null");
    }
  }
  
  public VideoPlayMedioInfo b(AIOVideoData paramAIOVideoData)
  {
    Object localObject2 = null;
    if (paramAIOVideoData == null) {
      return null;
    }
    Object localObject1 = new File(paramAIOVideoData.k);
    long l = 0L;
    if (((File)localObject1).exists())
    {
      l = ((File)localObject1).length();
      if ((((IBrowserDepend)QRoute.api(IBrowserDepend.class)).isShortVideoType(paramAIOVideoData.m)) || (l >= paramAIOVideoData.d))
      {
        bool = false;
        break label99;
      }
    }
    else
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
    }
    boolean bool = true;
    label99:
    localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("getVideoPlayMedioInfo longvideo GetUrlAction =");
    ((StringBuilder)localObject3).append(bool);
    ((IBrowserLog)localObject1).d("AIOVideoPresenter", 4, ((StringBuilder)localObject3).toString());
    if (bool)
    {
      localObject3 = LongVideoUrlCacheManager.a().a(paramAIOVideoData.a);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((LongVideoUrlCacheManager.UrlsCacheBean)localObject3).a())
        {
          localObject1 = new VideoPlayMedioInfo();
          ((VideoPlayMedioInfo)localObject1).a = true;
          ((VideoPlayMedioInfo)localObject1).c = ((LongVideoUrlCacheManager.UrlsCacheBean)localObject3).a;
          ((VideoPlayMedioInfo)localObject1).b = paramAIOVideoData.k;
          ((VideoPlayMedioInfo)localObject1).f = ((LongVideoUrlCacheManager.UrlsCacheBean)localObject3).c;
          ((VideoPlayMedioInfo)localObject1).g = ((LongVideoUrlCacheManager.UrlsCacheBean)localObject3).d;
          ((VideoPlayMedioInfo)localObject1).k = paramAIOVideoData.a;
          ((VideoPlayMedioInfo)localObject1).l = paramAIOVideoData.b;
        }
      }
      return localObject1;
    }
    localObject1 = new VideoPlayMedioInfo();
    ((VideoPlayMedioInfo)localObject1).a = false;
    ((VideoPlayMedioInfo)localObject1).k = paramAIOVideoData.a;
    ((VideoPlayMedioInfo)localObject1).l = paramAIOVideoData.b;
    ((VideoPlayMedioInfo)localObject1).b = paramAIOVideoData.k;
    ((VideoPlayMedioInfo)localObject1).p = l;
    return localObject1;
  }
  
  public void b(int paramInt)
  {
    try
    {
      this.f.remove(Integer.valueOf(paramInt));
      return;
    }
    catch (Exception localException)
    {
      IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRevokeMsg exception = ");
      localStringBuilder.append(localException.getMessage());
      localIBrowserLog.d("AIOVideoPresenter", 4, localStringBuilder.toString());
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (this.c != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101))
    {
      ((AIOVideoData)localRichMediaBrowserInfo.baseData).y = paramBoolean;
      this.c.updateItem(localRichMediaBrowserInfo);
    }
  }
  
  public boolean b(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101)) {
      return ((AIOVideoData)localRichMediaBrowserInfo.baseData).y;
    }
    return false;
  }
  
  public void c(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (this.a != null) && (this.a.b != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101))
    {
      ((AIOVideoData)localRichMediaBrowserInfo.baseData).w = false;
      this.a.b.updateItem(localRichMediaBrowserInfo);
    }
  }
  
  public void c(AIOVideoData paramAIOVideoData)
  {
    if ((this.a != null) && ((this.a.getParamsBuilder().a() instanceof IProvider))) {
      ((IProvider)this.a.getParamsBuilder().a()).a(paramAIOVideoData.a, paramAIOVideoData.b, 1);
    }
  }
  
  public boolean c(int paramInt)
  {
    if ((this.a != null) && (this.a.b != null))
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.a.b.getItem(paramInt);
      if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101)) {
        return ((AIOVideoData)localRichMediaBrowserInfo.baseData).v;
      }
    }
    return false;
  }
  
  public long d()
  {
    AIOVideoView localAIOVideoView = this.e;
    if (localAIOVideoView != null) {
      return localAIOVideoView.t();
    }
    return 0L;
  }
  
  public long d(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101)) {
      return ((AIOVideoData)localRichMediaBrowserInfo.baseData).x;
    }
    return 0L;
  }
  
  public void e()
  {
    if ((this.a != null) && (this.a.a != null) && (this.a.d() != null))
    {
      if (LiuHaiUtils.b()) {
        this.a.d().a((int)Utils.a(LiuHaiUtils.d, this.e.c.getResources()) + 46);
      } else {
        this.a.d().a(46);
      }
      this.a.d().f();
      this.a.d().d();
      this.a.a.b();
    }
  }
  
  public boolean e(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101)) {
      return ((AIOVideoData)localRichMediaBrowserInfo.baseData).w;
    }
    return false;
  }
  
  public boolean h()
  {
    boolean bool = ImmersiveConfProcessor.b();
    IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isImmersionOpen:");
    localStringBuilder.append(bool);
    localIBrowserLog.d("AIOVideoPresenter", 4, localStringBuilder.toString());
    return bool;
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
    AppNetConnInfo.unregisterNetInfoHandler(this);
    LongVideoUrlCacheManager.a().b();
    AIOVideoView localAIOVideoView = this.e;
    if (localAIOVideoView != null) {
      localAIOVideoView.c();
    }
  }
  
  public void onNetMobile2None()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetMobile2None");
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNetMobile2Wifi s = ");
    localStringBuilder.append(paramString);
    localIBrowserLog.d("AIOVideoPresenter", 4, localStringBuilder.toString());
    LongVideoUrlCacheManager.a().b();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNetNone2Mobile s = ");
    localStringBuilder.append(paramString);
    localIBrowserLog.d("AIOVideoPresenter", 4, localStringBuilder.toString());
    this.e.s();
    LongVideoUrlCacheManager.a().b();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNetNone2Wifi s = ");
    localStringBuilder.append(paramString);
    localIBrowserLog.d("AIOVideoPresenter", 4, localStringBuilder.toString());
    LongVideoUrlCacheManager.a().b();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNetWifi2Mobile s = ");
    localStringBuilder.append(paramString);
    localIBrowserLog.d("AIOVideoPresenter", 4, localStringBuilder.toString());
    this.e.s();
    LongVideoUrlCacheManager.a().b();
  }
  
  public void onNetWifi2None()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetWifi2None");
  }
  
  public void onResume()
  {
    super.onResume();
    AIOVideoView localAIOVideoView = this.e;
    if (localAIOVideoView != null) {
      localAIOVideoView.n();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    AIOVideoView localAIOVideoView = this.e;
    if (localAIOVideoView != null) {
      localAIOVideoView.m();
    }
  }
  
  public AIOVideoData r()
  {
    if ((this.a != null) && (this.a.b != null))
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.a.b.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101)) {
        return (AIOVideoData)localRichMediaBrowserInfo.baseData;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOVideoPresenter
 * JD-Core Version:    0.7.0.1
 */