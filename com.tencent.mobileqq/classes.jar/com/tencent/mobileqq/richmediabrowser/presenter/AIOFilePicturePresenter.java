package com.tencent.mobileqq.richmediabrowser.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.comment.config.ImmersiveConfProcessor;
import com.tencent.mobileqq.comment.danmaku.CommentDanmakuManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.IProvider;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOBrowserModel;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureModel;
import com.tencent.mobileqq.richmediabrowser.utils.RichMediaBrowserUtils;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserScene;
import com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.api.BrowserParamsBuilder;
import com.tencent.richmediabrowser.api.decorator.IDecoratorView;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import com.tencent.util.LiuHaiUtils;
import java.util.concurrent.ConcurrentHashMap;

public class AIOFilePicturePresenter
  extends AIOBrowserBasePresenter
{
  public AIOFilePictureView a;
  
  private void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if (paramInt3 == 1) {
      localObject1 = paramString;
    } else {
      localObject1 = "I:E";
    }
    a(paramLong, paramInt1, paramInt2, (String)localObject1);
    Object localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("AIOFilePicData.TYPE_ORIGINAL_IMAGE,result:");
    ((StringBuilder)localObject2).append(paramInt3);
    ((StringBuilder)localObject2).append(",resultStr: ");
    ((StringBuilder)localObject2).append(paramString);
    ((IBrowserLog)localObject1).d("AIOFilePicPresenter", 2, ((StringBuilder)localObject2).toString());
    if (paramInt3 == 1)
    {
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject1).mUseExifOrientation = false;
      localObject2 = new AIOFilePictureModel().a((AIOFilePictureData)paramRichMediaBrowserInfo.baseData, 20);
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOFilePicPresenter", 2, "null url");
        return;
      }
      Object localObject3 = ((AIOFilePictureData)paramRichMediaBrowserInfo.baseData).jdField_b_of_type_JavaLangString;
      paramString = null;
      localObject3 = URLDrawable.getFileDrawable((String)localObject3, null);
      if (localObject3 != null)
      {
        ((URLDrawable)localObject3).downloadImediatly();
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject3);
      }
      else
      {
        paramRichMediaBrowserInfo = URLDrawable.getFileDrawable(((AIOFilePictureData)paramRichMediaBrowserInfo.baseData).jdField_a_of_type_JavaLangString, null);
        if (paramRichMediaBrowserInfo != null)
        {
          paramRichMediaBrowserInfo.downloadImediatly();
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = paramRichMediaBrowserInfo;
        }
      }
      try
      {
        paramRichMediaBrowserInfo = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        paramString = paramRichMediaBrowserInfo;
        paramRichMediaBrowserInfo.setTag(Integer.valueOf(1));
        paramString = paramRichMediaBrowserInfo;
      }
      catch (Throwable paramRichMediaBrowserInfo)
      {
        localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("URLDrawable.getDrawable failed : ");
        ((StringBuilder)localObject2).append(paramRichMediaBrowserInfo.getMessage());
        ((IBrowserLog)localObject1).d("AIOFilePicPresenter", 4, ((StringBuilder)localObject2).toString());
      }
      if (paramString == null)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_AndroidContentContext.getString(2131718254), 0).a();
        return;
      }
      paramRichMediaBrowserInfo = (GalleryUrlImageView)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_ComTencentRichmediabrowserViewBrowserBaseView.mBrowserItemView.findViewById(2131368461);
      if (paramRichMediaBrowserInfo != null)
      {
        paramRichMediaBrowserInfo.setGalleryImageListener(new AIOFilePicturePresenter.1(this, paramString));
        paramRichMediaBrowserInfo.setImageDrawable(paramString);
        paramRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView;
        paramRichMediaBrowserInfo.jdField_a_of_type_JavaLangRunnable = RichMediaBrowserUtils.a(paramRichMediaBrowserInfo.b, paramString);
      }
      if (!a().a)
      {
        a().b();
        a().a();
      }
    }
    else
    {
      if (!"TroopFileError".equals(paramString)) {
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_AndroidContentContext.getString(2131718242).equals(paramString)) {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_AndroidContentContext, paramString, 0).a();
        } else {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_AndroidContentContext.getString(2131718254), 0).a();
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.g(true);
    }
  }
  
  public Intent a(AIOFilePictureData paramAIOFilePictureData, Activity paramActivity)
  {
    if ((paramAIOFilePictureData != null) && ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.getParamsBuilder().a() instanceof IProvider)) && (((IProvider)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.getParamsBuilder().a()).a()))
    {
      Intent localIntent = ((IProvider)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.getParamsBuilder().a()).a(paramAIOFilePictureData.jdField_a_of_type_Long, paramAIOFilePictureData.jdField_a_of_type_Int, 0);
      if (localIntent != null)
      {
        int i = paramAIOFilePictureData.jdField_b_of_type_Int;
        boolean bool = true;
        if (i != 1) {
          bool = false;
        }
        ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).getForwardToFriendIntent(paramActivity, localIntent, bool);
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_file");
        return localIntent;
      }
    }
    return null;
  }
  
  public AIOFilePictureData a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel != null)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOFilePictureData)) && (localRichMediaBrowserInfo.baseData.getType() == 102)) {
        return (AIOFilePictureData)localRichMediaBrowserInfo.baseData;
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
      localIBrowserLog.d("AIOFilePicPresenter", 4, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt, URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null))
    {
      this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.mActiveDrawable.put(Integer.valueOf(paramInt), paramURLDrawable);
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView != null) && (paramInt == this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getCurrentPosition())) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.a(paramInt);
      }
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong1);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 102))
    {
      AIOFilePictureData localAIOFilePictureData = (AIOFilePictureData)localRichMediaBrowserInfo.baseData;
      paramInt1 = 0;
      if (paramInt2 != 18)
      {
        if (paramInt2 == 20) {
          paramInt1 = 3;
        }
      }
      else {
        paramInt1 = 1;
      }
      localAIOFilePictureData.status = paramInt1;
      localAIOFilePictureData.progress = paramInt3;
      localRichMediaBrowserInfo.baseData = localAIOFilePictureData;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.browserModel != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.browserModel.updateItem(localRichMediaBrowserInfo);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.browserModel != null)
    {
      localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.browserModel.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).jdField_a_of_type_Long == paramLong1)) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.a();
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
    ((IBrowserLog)localObject1).d("AIOFilePicPresenter", 2, ((StringBuilder)localObject2).toString());
    localObject1 = a(paramLong);
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 102))
    {
      localObject2 = (AIOFilePictureData)((RichMediaBrowserInfo)localObject1).baseData;
      ((AIOFilePictureData)localObject2).status = 0;
      ((AIOFilePictureData)localObject2).progress = 0;
      ((RichMediaBrowserInfo)localObject1).baseData = ((RichMediaBaseData)localObject2);
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.browserModel != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.browserModel.updateItem((RichMediaBrowserInfo)localObject1);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.browserModel != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.browserModel.getSelectedItem();
      if ((localObject2 != null) && (((RichMediaBrowserInfo)localObject2).baseData != null) && (((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject2).baseData).jdField_a_of_type_Long == paramLong))
      {
        if (paramInt2 == 18)
        {
          if (paramInt3 == 1) {
            localObject1 = paramString;
          } else {
            localObject1 = "I:E";
          }
          paramInt1 = a(paramLong, paramInt1, paramInt2, (String)localObject1);
          if ((paramInt3 == 2) && (!TextUtils.isEmpty(paramString))) {
            new AIOFilePictureModel().b((AIOFilePictureData)((RichMediaBrowserInfo)localObject2).baseData, paramInt2, paramString);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_ComTencentRichmediabrowserViewBrowserBaseView != null)
          {
            paramString = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView;
            paramString.a(paramInt1, paramString.jdField_a_of_type_ComTencentRichmediabrowserViewBrowserBaseView.mBrowserItemView, paramBoolean);
          }
          else
          {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOFilePicPresenter", 2, "notifyImageResult(): decoratorView is null");
          }
          paramString = BrowserLogHelper.getInstance().getGalleryLog();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("notifyImageResult(): Gallery position is ");
          ((StringBuilder)localObject1).append(paramInt1);
          paramString.d("AIOFilePicPresenter", 2, ((StringBuilder)localObject1).toString());
        }
        else if (paramInt2 == 20)
        {
          a(paramLong, paramInt1, paramInt2, paramInt3, paramString, (RichMediaBrowserInfo)localObject2);
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.a();
      }
    }
  }
  
  public void a(IDecoratorView paramIDecoratorView)
  {
    super.a(paramIDecoratorView);
    if ((paramIDecoratorView instanceof AIOFilePictureView)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView = ((AIOFilePictureView)paramIDecoratorView);
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a() != null))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      if (LiuHaiUtils.b()) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a().a((int)Utils.a(LiuHaiUtils.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_AndroidContentContext.getResources()) + 40);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a().a(40);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a().c();
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a().e();
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.a();
    }
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isImmersionOpen, ImmersiveConfProcessor.isImageEnable() = ");
      localStringBuilder.append(ImmersiveConfProcessor.a());
      QLog.d("AIOFilePicPresenter", 2, localStringBuilder.toString());
    }
    return ImmersiveConfProcessor.a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.b.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFilePictureView.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOFilePicturePresenter
 * JD-Core Version:    0.7.0.1
 */