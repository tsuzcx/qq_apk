package com.tencent.mobileqq.richmediabrowser.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.comment.config.ImmersiveConfProcessor;
import com.tencent.mobileqq.comment.danmaku.CommentDanmakuManager;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.IProvider;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureModel;
import com.tencent.mobileqq.richmediabrowser.utils.RichMediaBrowserUtils;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserScene;
import com.tencent.mobileqq.richmediabrowser.view.AIOPictureView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.richmediabrowser.api.BrowserParamsBuilder;
import com.tencent.richmediabrowser.api.decorator.IDecoratorView;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.BrowserURLImageView;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import com.tencent.util.LiuHaiUtils;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class AIOPicturePresenter
  extends AIOBrowserBasePresenter
{
  public AIOPictureView e;
  
  private void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    Object localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("TYPE_ORIGINAL_IMAGE result = ");
    ((StringBuilder)localObject2).append(paramInt3);
    ((StringBuilder)localObject2).append(", resultStr = ");
    ((StringBuilder)localObject2).append(paramString);
    ((IBrowserLog)localObject1).d("AIOPicturePresenter", 2, ((StringBuilder)localObject2).toString());
    if (paramInt3 == 1) {
      localObject1 = paramString;
    } else {
      localObject1 = "I:E";
    }
    a(paramLong, paramInt1, paramInt2, (String)localObject1);
    if (paramInt3 == 1)
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      localObject1 = null;
      paramString = (String)localObject1;
      try
      {
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        paramString = (String)localObject1;
        ((URLDrawable.URLDrawableOptions)localObject2).mUseExifOrientation = false;
        paramString = (String)localObject1;
        URLDrawable localURLDrawable = URLDrawable.getFileDrawable(((AIOPictureData)paramRichMediaBrowserInfo.baseData).k, null);
        if (localURLDrawable != null)
        {
          paramString = (String)localObject1;
          localURLDrawable.downloadImediatly();
          paramString = (String)localObject1;
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localURLDrawable;
        }
        else
        {
          paramString = (String)localObject1;
          localURLDrawable = URLDrawable.getFileDrawable(((AIOPictureData)paramRichMediaBrowserInfo.baseData).j, null);
          if (localURLDrawable != null)
          {
            paramString = (String)localObject1;
            localURLDrawable.downloadImediatly();
            paramString = (String)localObject1;
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localURLDrawable;
          }
        }
        paramString = (String)localObject1;
        paramRichMediaBrowserInfo = URLDrawable.getDrawable(new AIOPictureModel().b((AIOPictureData)paramRichMediaBrowserInfo.baseData, 4), (URLDrawable.URLDrawableOptions)localObject2);
        paramString = paramRichMediaBrowserInfo;
        paramRichMediaBrowserInfo.setTag(Integer.valueOf(1));
        paramString = paramRichMediaBrowserInfo;
      }
      catch (Throwable paramRichMediaBrowserInfo)
      {
        paramRichMediaBrowserInfo.printStackTrace();
      }
      if (paramString == null)
      {
        QQToast.makeText(this.e.c, this.e.c.getString(2131915746), 0).show();
        return;
      }
      paramRichMediaBrowserInfo = (GalleryUrlImageView)this.e.h.mBrowserItemView.findViewById(2131435357);
      if (paramRichMediaBrowserInfo != null)
      {
        paramRichMediaBrowserInfo.setGalleryImageListener(new AIOPicturePresenter.1(this, paramString));
        paramRichMediaBrowserInfo.setImageDrawable(paramString);
        paramRichMediaBrowserInfo = this.e;
        paramRichMediaBrowserInfo.z = RichMediaBrowserUtils.a(paramRichMediaBrowserInfo.y, paramString);
      }
    }
    else if (!"TroopFileError".equals(paramString))
    {
      QQToast.makeText(this.e.c, this.e.c.getString(2131915746), 0).show();
    }
  }
  
  public static Intent b(RichMediaBrowserInfo paramRichMediaBrowserInfo, Activity paramActivity, int paramInt)
  {
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null) && (paramRichMediaBrowserInfo.baseData.getType() == 100))
    {
      AIOPictureData localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
      AIOPictureModel localAIOPictureModel = new AIOPictureModel();
      paramInt = 4;
      File localFile = localAIOPictureModel.c(localAIOPictureData, 4);
      boolean bool;
      if (localFile == null)
      {
        localFile = localAIOPictureModel.c(localAIOPictureData, 2);
        bool = false;
      }
      else
      {
        bool = true;
      }
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", localAIOPictureModel.b(localAIOPictureData, 1));
      if ((paramRichMediaBrowserInfo.baseData instanceof AIOPictureData))
      {
        paramRichMediaBrowserInfo = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
        localAIOPictureModel = new AIOPictureModel();
        if (!bool) {
          paramInt = 2;
        }
        localBundle.putString("forward_urldrawable_big_url", localAIOPictureModel.b(paramRichMediaBrowserInfo, paramInt));
      }
      return ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).getFriendPickerForForwardIntent(localFile, bool, localAIOPictureData, localBundle, paramActivity);
    }
    return null;
  }
  
  public static void c(RichMediaBrowserInfo paramRichMediaBrowserInfo, Activity paramActivity, int paramInt)
  {
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null))
    {
      if (paramRichMediaBrowserInfo.baseData.getType() != 100) {
        return;
      }
      AIOPictureData localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
      AIOPictureModel localAIOPictureModel = new AIOPictureModel();
      int i = 4;
      File localFile = localAIOPictureModel.c(localAIOPictureData, 4);
      boolean bool;
      if (localFile == null)
      {
        localFile = localAIOPictureModel.c(localAIOPictureData, 2);
        bool = false;
      }
      else
      {
        bool = true;
      }
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", localAIOPictureModel.b(localAIOPictureData, 1));
      if ((paramRichMediaBrowserInfo.baseData instanceof AIOPictureData))
      {
        paramRichMediaBrowserInfo = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
        localAIOPictureModel = new AIOPictureModel();
        if (!bool) {
          i = 2;
        }
        localBundle.putString("forward_urldrawable_big_url", localAIOPictureModel.b(paramRichMediaBrowserInfo, i));
      }
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).showFriendPickerForForward(localFile, bool, localAIOPictureData, localBundle, paramActivity, paramInt);
    }
  }
  
  public Intent a(RichMediaBrowserInfo paramRichMediaBrowserInfo, Activity paramActivity)
  {
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null) && (AIOPictureData.class.isInstance(paramRichMediaBrowserInfo.baseData)))
    {
      AIOPictureData localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
      int i = localAIOPictureData.f;
      boolean bool = false;
      if ((i == 1) && (localAIOPictureData.A))
      {
        if (((this.a.getParamsBuilder().a() instanceof IProvider)) && (((IProvider)this.a.getParamsBuilder().a()).c()))
        {
          paramRichMediaBrowserInfo = ((IProvider)this.a.getParamsBuilder().a()).c(localAIOPictureData.a, localAIOPictureData.b, 0);
          if (paramRichMediaBrowserInfo == null)
          {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "forwardPicToFriend getForwardData is null!");
            return null;
          }
          paramRichMediaBrowserInfo.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
          if (localAIOPictureData.f == 1) {
            bool = true;
          }
          return ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).getForwardToFriendIntent(paramActivity, paramRichMediaBrowserInfo, bool);
        }
      }
      else {
        return a(paramRichMediaBrowserInfo, paramActivity, 0);
      }
    }
    return null;
  }
  
  public Intent a(RichMediaBrowserInfo paramRichMediaBrowserInfo, Activity paramActivity, int paramInt)
  {
    int i = ParamsManager.a().o();
    if ((i != 1) && (i != 2) && (i != 3) && (i != 5) && (i != 6)) {
      return b(paramRichMediaBrowserInfo, paramActivity, paramInt);
    }
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null) && (paramRichMediaBrowserInfo.baseData.getType() == 100))
    {
      AIOPictureData localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
      AIOPictureModel localAIOPictureModel = new AIOPictureModel();
      paramInt = 4;
      paramRichMediaBrowserInfo = localAIOPictureModel.c(localAIOPictureData, 4);
      boolean bool;
      if (paramRichMediaBrowserInfo == null)
      {
        paramRichMediaBrowserInfo = localAIOPictureModel.c(localAIOPictureData, 2);
        bool = false;
      }
      else
      {
        bool = true;
      }
      Bundle localBundle = new Bundle(paramActivity.getIntent().getExtras());
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", localAIOPictureModel.b(localAIOPictureData, 1));
      if (!bool) {
        paramInt = 2;
      }
      localBundle.putString("forward_urldrawable_big_url", localAIOPictureModel.b(localAIOPictureData, paramInt));
      return ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).getForwardPicToFriendIntent(paramRichMediaBrowserInfo, bool, localAIOPictureData, localBundle, paramActivity);
    }
    return null;
  }
  
  public void a(int paramInt, View paramView, boolean paramBoolean)
  {
    if (((paramView instanceof BrowserURLImageView)) && (this.c != null))
    {
      paramView = (BrowserURLImageView)paramView;
      Object localObject1 = this.c.getItem(paramInt);
      if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 100) && ((((RichMediaBrowserInfo)localObject1).baseData instanceof AIOPictureData)))
      {
        Object localObject2 = (AIOPictureData)((RichMediaBrowserInfo)localObject1).baseData;
        Object localObject3 = new AIOPictureModel();
        if ((paramBoolean) && (((AIOPictureModel)localObject3).c((AIOPictureData)localObject2, 8) != null))
        {
          localObject1 = paramView.getDrawable();
          localObject2 = ((AIOPictureModel)localObject3).b((AIOPictureData)localObject2, 8);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append("#");
          ((StringBuilder)localObject3).append("DISPLAY");
          localObject2 = ((StringBuilder)localObject3).toString();
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
          ((URLDrawable.URLDrawableOptions)localObject3).mUseExifOrientation = false;
          localObject1 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
          paramView.setDecodingDrawble((URLDrawable)localObject1);
          ((URLDrawable)localObject1).startDownload();
          paramView = BrowserLogHelper.getInstance().getGalleryLog();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("updateDisplayView(): Update dp image, position=");
          ((StringBuilder)localObject1).append(paramInt);
          paramView.d("AIOPicturePresenter", 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
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
    Object localObject = a(paramLong1, paramInt1);
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 100) && ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOPictureData)))
    {
      AIOPictureData localAIOPictureData = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
      int i = 0;
      if (paramInt2 != 2)
      {
        if (paramInt2 != 4)
        {
          if (paramInt2 == 24) {
            i = 4;
          }
        }
        else {
          i = 3;
        }
      }
      else {
        i = 1;
      }
      localAIOPictureData.status = i;
      localAIOPictureData.progress = paramInt3;
      ((RichMediaBrowserInfo)localObject).baseData = localAIOPictureData;
      if (this.c != null) {
        this.c.updateItem((RichMediaBrowserInfo)localObject);
      }
    }
    if (this.c != null)
    {
      localObject = this.c.getSelectedItem();
      if ((localObject != null) && ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOPictureData)))
      {
        localObject = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
        if ((((AIOPictureData)localObject).a == paramLong1) && (((AIOPictureData)localObject).b == paramInt1))
        {
          localObject = this.e;
          if (localObject != null)
          {
            ((AIOPictureView)localObject).a();
            if ((paramBoolean) && (paramInt2 == 2) && (this.e.h != null) && (this.e.h.mBrowserItemView != null)) {
              a(this.c.getSelectedIndex(), this.e.h.mBrowserItemView, true);
            }
          }
        }
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
    ((IBrowserLog)localObject1).d("AIOPicturePresenter", 2, ((StringBuilder)localObject2).toString());
    long l = paramInt1;
    localObject1 = a(paramLong, l);
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 100) && ((((RichMediaBrowserInfo)localObject1).baseData instanceof AIOPictureData)))
    {
      localObject2 = (AIOPictureData)((RichMediaBrowserInfo)localObject1).baseData;
      ((AIOPictureData)localObject2).status = 0;
      ((AIOPictureData)localObject2).progress = 0;
      ((RichMediaBrowserInfo)localObject1).baseData = ((RichMediaBaseData)localObject2);
      if (this.c != null) {
        this.c.updateItem((RichMediaBrowserInfo)localObject1);
      }
    }
    if (this.a.browserModel != null)
    {
      localObject1 = this.a.browserModel.getSelectedItem();
      if ((this.e != null) && (localObject1 != null) && ((((RichMediaBrowserInfo)localObject1).baseData instanceof AIOPictureData)) && (((AIOPictureData)((RichMediaBrowserInfo)localObject1).baseData).a == paramLong) && (((AIOPictureData)((RichMediaBrowserInfo)localObject1).baseData).b == paramInt1))
      {
        if (paramInt2 == 2)
        {
          if (paramInt3 != 1) {
            paramString = "I:E";
          }
          paramInt1 = a(paramLong, paramInt1, paramInt2, paramString);
          paramString = BrowserLogHelper.getInstance().getGalleryLog();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("notifyImageResult(): TYPE_LARGE_IMAGE Gallery position is ");
          ((StringBuilder)localObject1).append(paramInt1);
          paramString.d("AIOPicturePresenter", 2, ((StringBuilder)localObject1).toString());
          paramString = a(paramLong, l);
          if ((paramString != null) && (paramString.baseData != null) && (paramString.baseData.getType() == 100) && (paramInt3 == 1))
          {
            paramString = (AIOPictureData)paramString.baseData;
            if (!paramString.w)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(paramString.j);
              ((StringBuilder)localObject1).append("_hd");
              if (new File(((StringBuilder)localObject1).toString()).exists())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(paramString.j);
                ((StringBuilder)localObject1).append("_hd");
                paramString.j = ((StringBuilder)localObject1).toString();
              }
            }
          }
          this.c.onLoadFinish(paramInt1, true);
          this.e.a(paramInt1, paramBoolean);
        }
        else if (paramInt2 == 24)
        {
          localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("save pic result = ");
          ((StringBuilder)localObject2).append(paramInt3);
          ((StringBuilder)localObject2).append(", resultStr = ");
          ((StringBuilder)localObject2).append(paramString);
          ((IBrowserLog)localObject1).d("AIOPicturePresenter", 2, ((StringBuilder)localObject2).toString());
          if (paramInt3 == 1) {
            QQToast.makeText(this.e.c, this.e.c.getString(2131915750), 0).show();
          } else {
            QQToast.makeText(this.e.c, this.e.c.getString(2131915749), 0).show();
          }
          this.e.j();
        }
        else if (paramInt2 == 4)
        {
          a(paramLong, paramInt1, paramInt2, paramInt3, paramString, (RichMediaBrowserInfo)localObject1);
          this.e.j();
        }
        this.e.a();
      }
    }
  }
  
  public void a(AIOPictureData paramAIOPictureData)
  {
    if ((paramAIOPictureData != null) && (this.e.F != null))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 2, "dealSaveOriginalImage");
      this.e.F.a(paramAIOPictureData.a, paramAIOPictureData.b, 24);
    }
  }
  
  public void a(IDecoratorView paramIDecoratorView)
  {
    super.a(paramIDecoratorView);
    if ((paramIDecoratorView instanceof AIOPictureView)) {
      this.e = ((AIOPictureView)paramIDecoratorView);
    }
  }
  
  protected void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, Activity paramActivity, int paramInt1, AIOPicturePresenter.ActionSheetForwardActionInfo paramActionSheetForwardActionInfo, int paramInt2, String paramString)
  {
    int i = ParamsManager.a().o();
    if ((i != 1) && (i != 2) && (i != 3) && (i != 5) && (i != 6))
    {
      c(paramRichMediaBrowserInfo, paramActivity, paramInt1);
      return;
    }
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null))
    {
      if (paramRichMediaBrowserInfo.baseData.getType() != 100) {
        return;
      }
      AIOPictureData localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
      AIOPictureModel localAIOPictureModel = new AIOPictureModel();
      paramInt1 = 4;
      paramRichMediaBrowserInfo = localAIOPictureModel.c(localAIOPictureData, 4);
      boolean bool;
      if (paramRichMediaBrowserInfo == null)
      {
        paramRichMediaBrowserInfo = localAIOPictureModel.c(localAIOPictureData, 2);
        bool = false;
      }
      else
      {
        bool = true;
      }
      Bundle localBundle = new Bundle(paramActivity.getIntent().getExtras());
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", localAIOPictureModel.b(localAIOPictureData, 1));
      if (!bool) {
        paramInt1 = 2;
      }
      localBundle.putString("forward_urldrawable_big_url", localAIOPictureModel.b(localAIOPictureData, paramInt1));
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).forwardPicToFriend(paramRichMediaBrowserInfo, bool, localAIOPictureData, localBundle, paramActivity, paramActionSheetForwardActionInfo.a, paramActionSheetForwardActionInfo.b, paramActionSheetForwardActionInfo.c, paramInt2, paramString);
    }
  }
  
  public void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, Activity paramActivity, AIOPicturePresenter.ActionSheetForwardActionInfo paramActionSheetForwardActionInfo, int paramInt, String paramString)
  {
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null) && (AIOPictureData.class.isInstance(paramRichMediaBrowserInfo.baseData)))
    {
      AIOPictureData localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
      if ((localAIOPictureData.f == 1) && (localAIOPictureData.A))
      {
        if ((this.e.F != null) && (this.e.F.c()))
        {
          paramRichMediaBrowserInfo = this.e.F.c(localAIOPictureData.a, localAIOPictureData.b, 0);
          if (paramRichMediaBrowserInfo == null)
          {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "forwardPicToFriend getForwardData is null!");
            return;
          }
          paramRichMediaBrowserInfo.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
          boolean bool;
          if (localAIOPictureData.f == 1) {
            bool = true;
          } else {
            bool = false;
          }
          ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).forwardToFriend(paramActivity, paramRichMediaBrowserInfo, bool, paramInt, paramString);
        }
      }
      else {
        a(paramRichMediaBrowserInfo, paramActivity, 0, paramActionSheetForwardActionInfo, paramInt, paramString);
      }
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
      localIBrowserLog.d("AIOPicturePresenter", 4, localStringBuilder.toString());
    }
  }
  
  public void e()
  {
    if ((this.e != null) && (this.a != null) && (this.a.a != null) && (this.a.d() != null))
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
    boolean bool = ImmersiveConfProcessor.a();
    IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isImmersionOpen:");
    localStringBuilder.append(bool);
    localIBrowserLog.d("AIOPicturePresenter", 4, localStringBuilder.toString());
    return bool;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    AIOPictureView localAIOPictureView = this.e;
    if ((localAIOPictureView != null) && (localAIOPictureView.z != null)) {
      this.e.y.removeCallbacks(this.e.z);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOPicturePresenter
 * JD-Core Version:    0.7.0.1
 */