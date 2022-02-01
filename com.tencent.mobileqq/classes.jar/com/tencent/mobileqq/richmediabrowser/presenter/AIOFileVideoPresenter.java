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
  public AIOFileVideoView a;
  public MqqHandler a;
  
  public AIOFileVideoPresenter()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new AIOFileVideoPresenter.1(this);
    QQVideoPlaySDKManager.a();
  }
  
  public long a()
  {
    AIOFileVideoView localAIOFileVideoView = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView;
    if (localAIOFileVideoView != null) {
      return localAIOFileVideoView.a();
    }
    return 0L;
  }
  
  public Intent a(AIOFileVideoData paramAIOFileVideoData, Activity paramActivity)
  {
    if ((paramAIOFileVideoData != null) && ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.getParamsBuilder().a() instanceof IProvider)))
    {
      Object localObject = (IProvider)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.getParamsBuilder().a();
      if (((IProvider)localObject).a())
      {
        localObject = ((IProvider)localObject).a(paramAIOFileVideoData.jdField_a_of_type_Long, paramAIOFileVideoData.jdField_a_of_type_Int, 0);
        if (localObject != null)
        {
          int i = paramAIOFileVideoData.b;
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
  
  public AIOFileVideoData a()
  {
    if (this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103)) {
        return (AIOFileVideoData)localRichMediaBrowserInfo.baseData;
      }
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.mActiveDrawable.remove(Integer.valueOf(paramInt));
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
  
  public void a(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103))
    {
      ((AIOFileVideoData)localRichMediaBrowserInfo.baseData).h = false;
      this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.updateItem(localRichMediaBrowserInfo);
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong1);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103))
    {
      AIOFileVideoData localAIOFileVideoData = (AIOFileVideoData)localRichMediaBrowserInfo.baseData;
      localAIOFileVideoData.g = ((paramInt3 / 10000.0F * (float)localAIOFileVideoData.jdField_c_of_type_Long));
      localRichMediaBrowserInfo.baseData = localAIOFileVideoData;
      if (this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null) {
        this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.updateItem(localRichMediaBrowserInfo);
      }
    }
    if (this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null)
    {
      localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOFileVideoData)) && (((AIOFileVideoData)localRichMediaBrowserInfo.baseData).jdField_a_of_type_Long == paramLong1)) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.a();
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
          ((AIOFileVideoData)localObject2).jdField_c_of_type_JavaLangString = paramString;
        }
        ((AIOFileVideoData)localObject2).f = true;
      }
      else if (paramInt3 == 2)
      {
        ((AIOFileVideoData)localObject2).f = false;
      }
      ((AIOFileVideoData)localObject2).h = false;
      if (((AIOFileVideoData)localObject2).j) {
        ((AIOFileVideoData)localObject2).status = 4;
      } else {
        ((AIOFileVideoData)localObject2).status = 3;
      }
      boolean bool = ((AIOFileVideoData)localObject2).j;
      ((RichMediaBrowserInfo)localObject1).baseData = ((RichMediaBaseData)localObject2);
      paramBoolean = bool;
      if (this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null)
      {
        this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.updateItem((RichMediaBrowserInfo)localObject1);
        paramBoolean = bool;
      }
    }
    else
    {
      paramBoolean = false;
    }
    if ((paramInt2 == 269484034) && (this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null))
    {
      paramString = this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem();
      if ((paramString != null) && ((paramString.baseData instanceof AIOBrowserBaseData)) && (((AIOBrowserBaseData)paramString.baseData).jdField_a_of_type_Long == paramLong))
      {
        if (paramBoolean) {
          if (paramInt3 == 1) {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.a, 2, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.a.getString(2131718258), 0).a();
          } else if (paramInt3 == 2) {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.a, 1, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.a.getString(2131718261), 0).a();
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.a();
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoPresenterXOXO", 4, "-----------> recv download finish set playing!");
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageRecord paramMessageRecord, int paramInt3, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.a(paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageRecord, paramInt3, paramBundle);
  }
  
  public void a(AIOFileVideoData paramAIOFileVideoData)
  {
    IBrowserProvider localIBrowserProvider = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.getParamsBuilder().a();
    if (!(localIBrowserProvider instanceof IProvider))
    {
      QLog.e("AIOFileVideoPresenterXOXO", 1, "handleUnDownloadVideo failed : provider null");
      return;
    }
    ((IProvider)localIBrowserProvider).a(paramAIOFileVideoData.jdField_a_of_type_Long, 11, paramAIOFileVideoData.jdField_a_of_type_AndroidOsBundle);
  }
  
  public void a(IDecoratorView paramIDecoratorView)
  {
    super.a(paramIDecoratorView);
    if ((paramIDecoratorView instanceof AIOFileVideoView)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView = ((AIOFileVideoView)paramIDecoratorView);
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a() != null))
    {
      boolean bool = false;
      AIOFileVideoData localAIOFileVideoData = a();
      if (localAIOFileVideoData != null) {
        bool = FileUtils.fileExistsAndNotEmpty(localAIOFileVideoData.jdField_c_of_type_JavaLangString);
      }
      if (bool)
      {
        if (LiuHaiUtils.b()) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a().a((int)Utils.a(LiuHaiUtils.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.a.getResources()) + 46);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a().a(46);
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a().c();
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a().e();
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a.a();
      }
    }
  }
  
  public void b(long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong);
    if ((localRichMediaBrowserInfo != null) && (this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103))
    {
      ((AIOFileVideoData)localRichMediaBrowserInfo.baseData).i = false;
      this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.updateItem(localRichMediaBrowserInfo);
    }
  }
  
  public void b(AIOFileVideoData paramAIOFileVideoData)
  {
    IBrowserProvider localIBrowserProvider = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.getParamsBuilder().a();
    if (!(localIBrowserProvider instanceof IProvider))
    {
      QLog.e("AIOFileVideoPresenterXOXO", 1, "cancelDownload failed : provider null");
      return;
    }
    ((IProvider)localIBrowserProvider).a(paramAIOFileVideoData.jdField_a_of_type_Long, 12, paramAIOFileVideoData.jdField_a_of_type_AndroidOsBundle);
  }
  
  public boolean b()
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
  
  public boolean b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getItem(paramInt);
      if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103)) {
        return ((AIOFileVideoData)localRichMediaBrowserInfo.baseData).h;
      }
    }
    return false;
  }
  
  public void c(AIOFileVideoData paramAIOFileVideoData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null)
    {
      if (paramAIOFileVideoData == null) {
        return;
      }
      IBrowserProvider localIBrowserProvider = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.getParamsBuilder().a();
      if (!(localIBrowserProvider instanceof IProvider))
      {
        QLog.e("AIOFileVideoPresenterXOXO", 1, "handleVideoStopPlay failed : provider null");
        return;
      }
      ((IProvider)localIBrowserProvider).a(paramAIOFileVideoData.jdField_a_of_type_Long, 10, paramAIOFileVideoData.jdField_a_of_type_AndroidOsBundle);
    }
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
  
  public void d(AIOFileVideoData paramAIOFileVideoData)
  {
    IBrowserProvider localIBrowserProvider = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.getParamsBuilder().a();
    if (!(localIBrowserProvider instanceof IProvider))
    {
      QLog.e("AIOFileVideoPresenterXOXO", 1, "handleVideoStopPlay failed : provider null");
      return;
    }
    ((IProvider)localIBrowserProvider).a(paramAIOFileVideoData.jdField_a_of_type_Long, 14, paramAIOFileVideoData.jdField_a_of_type_AndroidOsBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    AIOFileVideoView localAIOFileVideoView = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView;
    if (localAIOFileVideoView != null) {
      localAIOFileVideoView.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    AIOFileVideoView localAIOFileVideoView = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView;
    if (localAIOFileVideoView != null) {
      localAIOFileVideoView.k();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    AIOFileVideoView localAIOFileVideoView = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView;
    if (localAIOFileVideoView != null) {
      localAIOFileVideoView.l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOFileVideoPresenter
 * JD-Core Version:    0.7.0.1
 */