package com.tencent.mobileqq.richmediabrowser.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.IProvider;
import com.tencent.mobileqq.richmediabrowser.api.IFileDepend;
import com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.richmediabrowser.api.decorator.IDecoratorModel;
import com.tencent.richmediabrowser.api.depend.IBrowserProvider;
import com.tencent.richmediabrowser.core.IBaseModelBuilder;
import java.io.File;

public class AIOFileVideoModel
  implements IDecoratorModel
{
  private void b(AIOFileVideoData paramAIOFileVideoData, Context paramContext, AIOFileVideoView paramAIOFileVideoView)
  {
    paramAIOFileVideoData = new AIOFileVideoModel.1(this, paramContext, paramAIOFileVideoData, paramAIOFileVideoView);
    FMDialogUtil.a(paramContext, paramContext.getString(2131915739), paramContext.getString(2131915740), paramAIOFileVideoData);
  }
  
  private boolean f(AIOFileVideoData paramAIOFileVideoData)
  {
    if (c(paramAIOFileVideoData)) {
      return false;
    }
    if (paramAIOFileVideoData != null)
    {
      if (paramAIOFileVideoData.x) {
        return false;
      }
      if (!AppNetConnInfo.isMobileConn()) {
        return false;
      }
      if ((!TextUtils.isEmpty(paramAIOFileVideoData.j)) && (paramAIOFileVideoData.d > 0L) && (paramAIOFileVideoData.d > paramAIOFileVideoData.m)) {
        return true;
      }
      if (paramAIOFileVideoData.d > 1048576L) {
        return true;
      }
    }
    return false;
  }
  
  public VideoPlayMedioInfo a(AIOFileVideoData paramAIOFileVideoData, boolean paramBoolean)
  {
    VideoPlayMedioInfo localVideoPlayMedioInfo = new VideoPlayMedioInfo();
    localVideoPlayMedioInfo.c = new String[] { paramAIOFileVideoData.p };
    localVideoPlayMedioInfo.d = paramAIOFileVideoData.q;
    localVideoPlayMedioInfo.a = (c(paramAIOFileVideoData) ^ true);
    String str;
    if (localVideoPlayMedioInfo.a) {
      str = "";
    } else {
      str = paramAIOFileVideoData.l;
    }
    localVideoPlayMedioInfo.b = str;
    localVideoPlayMedioInfo.o = paramAIOFileVideoData.progress;
    localVideoPlayMedioInfo.h = true;
    localVideoPlayMedioInfo.n = paramAIOFileVideoData.d;
    localVideoPlayMedioInfo.k = paramAIOFileVideoData.a;
    localVideoPlayMedioInfo.l = paramAIOFileVideoData.b;
    localVideoPlayMedioInfo.m = paramBoolean;
    localVideoPlayMedioInfo.r = paramAIOFileVideoData.G;
    return localVideoPlayMedioInfo;
  }
  
  public String a(AIOFileVideoData paramAIOFileVideoData)
  {
    if ((paramAIOFileVideoData != null) && (!TextUtils.isEmpty(paramAIOFileVideoData.k)))
    {
      if (!paramAIOFileVideoData.k.startsWith("/"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("file:/");
        localStringBuilder.append(paramAIOFileVideoData.k);
        return localStringBuilder.toString();
      }
      if (paramAIOFileVideoData.k.startsWith("//"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("file:");
        localStringBuilder.append(paramAIOFileVideoData.k);
        return localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file:");
      localStringBuilder.append(paramAIOFileVideoData.k);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public void a(AIOFileVideoData paramAIOFileVideoData, Context paramContext, AIOFileVideoView paramAIOFileVideoView)
  {
    if (f(paramAIOFileVideoData))
    {
      if (((IFileDepend)QRoute.api(IFileDepend.class)).doWithWifiChecked(paramContext, false, new AIOFileVideoModel.2(this, paramAIOFileVideoView))) {
        b(paramAIOFileVideoData, paramContext, paramAIOFileVideoView);
      }
    }
    else {
      paramAIOFileVideoView.o();
    }
  }
  
  public void a(IBaseModelBuilder paramIBaseModelBuilder) {}
  
  public boolean a(AIOFileVideoData paramAIOFileVideoData, IBrowserProvider paramIBrowserProvider)
  {
    if ((paramAIOFileVideoData != null) && (!c(paramAIOFileVideoData)))
    {
      if (!(paramIBrowserProvider instanceof IProvider)) {
        return false;
      }
      if ((paramAIOFileVideoData.q != null) && (!TextUtils.isEmpty(paramAIOFileVideoData.p))) {
        return false;
      }
      ((IProvider)paramIBrowserProvider).a(paramAIOFileVideoData.a, paramAIOFileVideoData.b, 16842753);
      return true;
    }
    return false;
  }
  
  public File b(AIOFileVideoData paramAIOFileVideoData)
  {
    if ((paramAIOFileVideoData != null) && (FileUtils.fileExistsAndNotEmpty(paramAIOFileVideoData.k))) {
      return new File(paramAIOFileVideoData.k);
    }
    return null;
  }
  
  public boolean c(AIOFileVideoData paramAIOFileVideoData)
  {
    if (paramAIOFileVideoData != null)
    {
      if ((TextUtils.isEmpty(paramAIOFileVideoData.l)) && (paramAIOFileVideoData.G != null)) {
        paramAIOFileVideoData.l = paramAIOFileVideoData.G.getString("savepath");
      }
      if (FileUtils.fileExistsAndNotEmpty(paramAIOFileVideoData.l))
      {
        paramAIOFileVideoData.t = true;
        return true;
      }
    }
    if ((paramAIOFileVideoData != null) && (paramAIOFileVideoData.p == null)) {
      paramAIOFileVideoData.t = false;
    }
    return false;
  }
  
  public boolean d(AIOFileVideoData paramAIOFileVideoData)
  {
    return TextUtils.isEmpty(paramAIOFileVideoData.w) ^ true;
  }
  
  public Drawable e(AIOFileVideoData paramAIOFileVideoData)
  {
    File localFile = b(paramAIOFileVideoData);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
    if ((localFile != null) && (GlobalImageCache.a.get(a(paramAIOFileVideoData)) != null)) {
      return URLDrawable.getDrawable(a(paramAIOFileVideoData), localURLDrawableOptions);
    }
    if (localFile != null)
    {
      paramAIOFileVideoData = URLDrawable.getDrawable(a(paramAIOFileVideoData), localURLDrawableOptions);
      paramAIOFileVideoData.downloadImediatly();
      return paramAIOFileVideoData;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoModel
 * JD-Core Version:    0.7.0.1
 */