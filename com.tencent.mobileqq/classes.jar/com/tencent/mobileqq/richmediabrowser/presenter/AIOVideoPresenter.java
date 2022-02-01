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
  public AIOVideoView a;
  public MqqHandler a;
  public ConcurrentHashMap<Integer, URLDrawable> b = new ConcurrentHashMap();
  
  public AIOVideoPresenter()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new AIOVideoPresenter.1(this);
    QQVideoPlaySDKManager.a();
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
  
  public long a()
  {
    AIOVideoView localAIOVideoView = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView;
    if (localAIOVideoView != null) {
      return localAIOVideoView.a();
    }
    return 0L;
  }
  
  public long a(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101)) {
      return ((AIOVideoData)localRichMediaBrowserInfo.baseData).jdField_f_of_type_Long;
    }
    return 0L;
  }
  
  public AIOVideoData a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel != null))
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101)) {
        return (AIOVideoData)localRichMediaBrowserInfo.baseData;
      }
    }
    return null;
  }
  
  public VideoPlayMedioInfo a(AIOVideoData paramAIOVideoData)
  {
    Object localObject2 = null;
    if (paramAIOVideoData == null) {
      return null;
    }
    Object localObject1 = new File(paramAIOVideoData.b);
    long l = 0L;
    if (((File)localObject1).exists())
    {
      l = ((File)localObject1).length();
      if ((((IBrowserDepend)QRoute.api(IBrowserDepend.class)).isShortVideoType(paramAIOVideoData.d)) || (l >= paramAIOVideoData.c))
      {
        bool = false;
        break label98;
      }
    }
    else
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
    }
    boolean bool = true;
    label98:
    localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("getVideoPlayMedioInfo longvideo GetUrlAction =");
    ((StringBuilder)localObject3).append(bool);
    ((IBrowserLog)localObject1).d("AIOVideoPresenter", 4, ((StringBuilder)localObject3).toString());
    if (bool)
    {
      localObject3 = LongVideoUrlCacheManager.a().a(paramAIOVideoData.jdField_a_of_type_Long);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((LongVideoUrlCacheManager.UrlsCacheBean)localObject3).a())
        {
          localObject1 = new VideoPlayMedioInfo();
          ((VideoPlayMedioInfo)localObject1).jdField_a_of_type_Boolean = true;
          ((VideoPlayMedioInfo)localObject1).jdField_a_of_type_ArrayOfJavaLangString = ((LongVideoUrlCacheManager.UrlsCacheBean)localObject3).jdField_a_of_type_ArrayOfJavaLangString;
          ((VideoPlayMedioInfo)localObject1).jdField_a_of_type_JavaLangString = paramAIOVideoData.b;
          ((VideoPlayMedioInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((LongVideoUrlCacheManager.UrlsCacheBean)localObject3).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          ((VideoPlayMedioInfo)localObject1).jdField_a_of_type_Int = ((LongVideoUrlCacheManager.UrlsCacheBean)localObject3).jdField_a_of_type_Int;
          ((VideoPlayMedioInfo)localObject1).jdField_a_of_type_Long = paramAIOVideoData.jdField_a_of_type_Long;
          ((VideoPlayMedioInfo)localObject1).b = paramAIOVideoData.jdField_a_of_type_Int;
        }
      }
      return localObject1;
    }
    localObject1 = new VideoPlayMedioInfo();
    ((VideoPlayMedioInfo)localObject1).jdField_a_of_type_Boolean = false;
    ((VideoPlayMedioInfo)localObject1).jdField_a_of_type_Long = paramAIOVideoData.jdField_a_of_type_Long;
    ((VideoPlayMedioInfo)localObject1).b = paramAIOVideoData.jdField_a_of_type_Int;
    ((VideoPlayMedioInfo)localObject1).jdField_a_of_type_JavaLangString = paramAIOVideoData.b;
    ((VideoPlayMedioInfo)localObject1).d = l;
    return localObject1;
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.b.remove(Integer.valueOf(paramInt));
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
  
  public void a(int paramInt, long paramLong)
  {
    VideoPlayMedioInfo localVideoPlayMedioInfo = a(a());
    if (localVideoPlayMedioInfo != null) {
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).updateMsgStatus(paramInt, paramLong, localVideoPlayMedioInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localVideoPlayMedioInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.getParamsBuilder().a());
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
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_AndroidContentContext, 2, 2131718258, 0).a();
    } else {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_AndroidContentContext, 1, 2131718261, 0).a();
    }
    ReportController.b(null, "CliOper", "", "", "0X800610F", "0X800610F", 0, 0, "", "", "", "");
  }
  
  public void a(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101))
    {
      ((AIOVideoData)localRichMediaBrowserInfo.baseData).g = false;
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.updateItem(localRichMediaBrowserInfo);
    }
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
      if (this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null) {
        this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.updateItem(localRichMediaBrowserInfo);
      }
    }
    if ((this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView != null))
    {
      localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOVideoData)) && (((AIOVideoData)localRichMediaBrowserInfo.baseData).jdField_a_of_type_Long == paramLong1)) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.a();
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
      if (this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null) {
        this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.updateItem((RichMediaBrowserInfo)localObject1);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.getSelectedItem();
      if ((localObject1 != null) && ((((RichMediaBrowserInfo)localObject1).baseData instanceof AIOVideoData)) && (((AIOVideoData)((RichMediaBrowserInfo)localObject1).baseData).jdField_a_of_type_Long == paramLong))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.a();
        if (paramInt2 == 256)
        {
          localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("save video result resultStr = ");
          ((StringBuilder)localObject2).append(paramString);
          ((IBrowserLog)localObject1).d("AIOVideoPresenter", 4, ((StringBuilder)localObject2).toString());
          if (paramInt3 == 1)
          {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_AndroidContentContext, 2, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_AndroidContentContext.getString(2131718258), 0).a();
            return;
          }
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_AndroidContentContext.getString(2131718261), 0).a();
          return;
        }
        if ((paramInt2 == 1) || (paramInt2 == 0))
        {
          if (paramInt3 != 1) {
            paramString = "I:E";
          }
          a(paramLong, paramInt1, paramInt2, paramString);
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_ComTencentRichmediabrowserViewBrowserBaseView != null) {
            this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.a(this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedIndex(), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_ComTencentRichmediabrowserViewBrowserBaseView.mBrowserItemView, paramBoolean);
          }
        }
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageRecord paramMessageRecord, int paramInt3, Bundle paramBundle)
  {
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView;
    if (paramBundle != null) {
      paramBundle.a(paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageRecord, paramInt3);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101))
    {
      ((AIOVideoData)localRichMediaBrowserInfo.baseData).jdField_f_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.updateItem(localRichMediaBrowserInfo);
    }
  }
  
  public void a(AIOVideoData paramAIOVideoData)
  {
    if ((paramAIOVideoData != null) && ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.getParamsBuilder().a() instanceof IProvider)))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "dealSaveVideo");
      ((IProvider)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.getParamsBuilder().a()).a(paramAIOVideoData.jdField_a_of_type_Long, paramAIOVideoData.jdField_a_of_type_Int, 256);
    }
  }
  
  public void a(IDecoratorView paramIDecoratorView)
  {
    super.a(paramIDecoratorView);
    if ((paramIDecoratorView instanceof AIOVideoView)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView = ((AIOVideoView)paramIDecoratorView);
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_AndroidContentContext, this);
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
          this.b.put(Integer.valueOf(paramInt3), (URLDrawable)paramString);
        }
        paramImageView.setImageDrawable(paramString);
        return;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "url  is null");
    }
  }
  
  public boolean a(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101)) {
      return ((AIOVideoData)localRichMediaBrowserInfo.baseData).h;
    }
    return false;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a() != null))
    {
      if (LiuHaiUtils.b()) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a().a((int)Utils.a(LiuHaiUtils.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_AndroidContentContext.getResources()) + 46);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a().a(46);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a().d();
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a().c();
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.a();
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101))
    {
      ((AIOVideoData)localRichMediaBrowserInfo.baseData).h = paramBoolean;
      this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.updateItem(localRichMediaBrowserInfo);
    }
  }
  
  public void b(AIOVideoData paramAIOVideoData)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) && ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.getParamsBuilder().a() instanceof IProvider))) {
      ((IProvider)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.getParamsBuilder().a()).a(paramAIOVideoData.jdField_a_of_type_Long, paramAIOVideoData.jdField_a_of_type_Int, 1);
    }
  }
  
  public boolean b()
  {
    boolean bool = ImmersiveConfProcessor.b();
    IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isImmersionOpen:");
    localStringBuilder.append(bool);
    localIBrowserLog.d("AIOVideoPresenter", 4, localStringBuilder.toString());
    return bool;
  }
  
  public boolean b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel != null))
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.getItem(paramInt);
      if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101)) {
        return ((AIOVideoData)localRichMediaBrowserInfo.baseData).jdField_f_of_type_Boolean;
      }
    }
    return false;
  }
  
  public boolean b(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101)) {
      return ((AIOVideoData)localRichMediaBrowserInfo.baseData).g;
    }
    return false;
  }
  
  public boolean c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem();
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOBrowserBaseData))
        {
          localObject = (AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData;
          bool1 = bool2;
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(((AIOBrowserBaseData)localObject).d)) != null)
          {
            bool1 = bool2;
            if (((Set)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(((AIOBrowserBaseData)localObject).d))).size() > 0) {
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
    LongVideoUrlCacheManager.a().a();
    AIOVideoView localAIOVideoView = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView;
    if (localAIOVideoView != null) {
      localAIOVideoView.b();
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
    LongVideoUrlCacheManager.a().a();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNetNone2Mobile s = ");
    localStringBuilder.append(paramString);
    localIBrowserLog.d("AIOVideoPresenter", 4, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.m();
    LongVideoUrlCacheManager.a().a();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNetNone2Wifi s = ");
    localStringBuilder.append(paramString);
    localIBrowserLog.d("AIOVideoPresenter", 4, localStringBuilder.toString());
    LongVideoUrlCacheManager.a().a();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNetWifi2Mobile s = ");
    localStringBuilder.append(paramString);
    localIBrowserLog.d("AIOVideoPresenter", 4, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.m();
    LongVideoUrlCacheManager.a().a();
  }
  
  public void onNetWifi2None()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoPresenter", 4, "onNetWifi2None");
  }
  
  public void onResume()
  {
    super.onResume();
    AIOVideoView localAIOVideoView = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView;
    if (localAIOVideoView != null) {
      localAIOVideoView.k();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    AIOVideoView localAIOVideoView = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView;
    if (localAIOVideoView != null) {
      localAIOVideoView.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOVideoPresenter
 * JD-Core Version:    0.7.0.1
 */