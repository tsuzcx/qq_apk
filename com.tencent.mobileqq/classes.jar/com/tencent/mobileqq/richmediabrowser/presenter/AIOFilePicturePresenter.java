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
  public AIOFilePictureView e;
  
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
      localObject2 = new AIOFilePictureModel().b((AIOFilePictureData)paramRichMediaBrowserInfo.baseData, 20);
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOFilePicPresenter", 2, "null url");
        return;
      }
      Object localObject3 = ((AIOFilePictureData)paramRichMediaBrowserInfo.baseData).l;
      paramString = null;
      localObject3 = URLDrawable.getFileDrawable((String)localObject3, null);
      if (localObject3 != null)
      {
        ((URLDrawable)localObject3).downloadImediatly();
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject3);
      }
      else
      {
        paramRichMediaBrowserInfo = URLDrawable.getFileDrawable(((AIOFilePictureData)paramRichMediaBrowserInfo.baseData).k, null);
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
        QQToast.makeText(this.e.c, this.e.c.getString(2131915746), 0).show();
        return;
      }
      paramRichMediaBrowserInfo = (GalleryUrlImageView)this.e.h.mBrowserItemView.findViewById(2131435357);
      if (paramRichMediaBrowserInfo != null)
      {
        paramRichMediaBrowserInfo.setGalleryImageListener(new AIOFilePicturePresenter.1(this, paramString));
        paramRichMediaBrowserInfo.setImageDrawable(paramString);
        paramRichMediaBrowserInfo = this.e;
        paramRichMediaBrowserInfo.u = RichMediaBrowserUtils.a(paramRichMediaBrowserInfo.t, paramString);
      }
      if (!g().a)
      {
        g().b();
        g().a();
      }
    }
    else
    {
      if (!"TroopFileError".equals(paramString)) {
        if (this.e.c.getString(2131915734).equals(paramString)) {
          QQToast.makeText(this.e.c, paramString, 0).show();
        } else {
          QQToast.makeText(this.e.c, this.e.c.getString(2131915746), 0).show();
        }
      }
      this.e.g(true);
    }
  }
  
  public Intent a(AIOFilePictureData paramAIOFilePictureData, Activity paramActivity)
  {
    if ((paramAIOFilePictureData != null) && ((this.a.getParamsBuilder().a() instanceof IProvider)) && (((IProvider)this.a.getParamsBuilder().a()).c()))
    {
      Intent localIntent = ((IProvider)this.a.getParamsBuilder().a()).c(paramAIOFilePictureData.a, paramAIOFilePictureData.b, 0);
      if (localIntent != null)
      {
        int i = paramAIOFilePictureData.f;
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
  
  public void a(int paramInt, URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (this.c != null))
    {
      this.c.mActiveDrawable.put(Integer.valueOf(paramInt), paramURLDrawable);
      if ((this.e != null) && (paramInt == this.c.getCurrentPosition())) {
        this.e.a(paramInt);
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
      if (this.a.browserModel != null) {
        this.a.browserModel.updateItem(localRichMediaBrowserInfo);
      }
    }
    if (this.a.browserModel != null)
    {
      localRichMediaBrowserInfo = this.a.browserModel.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).a == paramLong1)) {
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
    ((IBrowserLog)localObject1).d("AIOFilePicPresenter", 2, ((StringBuilder)localObject2).toString());
    localObject1 = a(paramLong);
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 102))
    {
      localObject2 = (AIOFilePictureData)((RichMediaBrowserInfo)localObject1).baseData;
      ((AIOFilePictureData)localObject2).status = 0;
      ((AIOFilePictureData)localObject2).progress = 0;
      ((RichMediaBrowserInfo)localObject1).baseData = ((RichMediaBaseData)localObject2);
      if (this.a.browserModel != null) {
        this.a.browserModel.updateItem((RichMediaBrowserInfo)localObject1);
      }
    }
    if (this.a.browserModel != null)
    {
      localObject2 = this.a.browserModel.getSelectedItem();
      if ((localObject2 != null) && (((RichMediaBrowserInfo)localObject2).baseData != null) && (((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject2).baseData).a == paramLong))
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
          if (this.e.h != null)
          {
            paramString = this.e;
            paramString.a(paramInt1, paramString.h.mBrowserItemView, paramBoolean);
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
        this.e.a();
      }
    }
  }
  
  public void a(IDecoratorView paramIDecoratorView)
  {
    super.a(paramIDecoratorView);
    if ((paramIDecoratorView instanceof AIOFilePictureView)) {
      this.e = ((AIOFilePictureView)paramIDecoratorView);
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
      localIBrowserLog.d("AIOFilePicPresenter", 4, localStringBuilder.toString());
    }
  }
  
  public void e()
  {
    if ((this.a != null) && (this.a.a != null) && (this.a.d() != null))
    {
      this.d.clear();
      if (LiuHaiUtils.b()) {
        this.a.d().a((int)Utils.a(LiuHaiUtils.d, this.e.c.getResources()) + 40);
      } else {
        this.a.d().a(40);
      }
      this.a.d().d();
      this.a.d().g();
      this.a.a.b();
    }
  }
  
  public boolean h()
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
    if (this.e.u != null) {
      this.e.t.removeCallbacks(this.e.u);
    }
  }
  
  public AIOFilePictureData r()
  {
    if (this.a.b != null)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.a.b.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOFilePictureData)) && (localRichMediaBrowserInfo.baseData.getType() == 102)) {
        return (AIOFilePictureData)localRichMediaBrowserInfo.baseData;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOFilePicturePresenter
 * JD-Core Version:    0.7.0.1
 */