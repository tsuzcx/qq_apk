package com.tencent.mobileqq.guild;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.drawable.BitmapDrawableWithMargin;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.BaseGuildPicBuilder.DrawURL;
import com.tencent.mobileqq.guild.pic.api.IGuildPicAIO;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.net.URL;

public class GuildAIOPicThumbDrawableObject
{
  MessageForPic a;
  ChatThumbView b;
  BaseGuildPicBuilder.DrawURL c;
  
  private GuildAIOPicThumbDrawableObject(GuildAIOPicThumbDrawableObject.Builder paramBuilder)
  {
    this.a = paramBuilder.a;
    this.b = paramBuilder.b;
    this.c = paramBuilder.d;
  }
  
  private URLDrawable a(File paramFile)
  {
    Resources localResources = BaseApplication.getContext().getResources();
    float f3 = 6.0F * localResources.getDisplayMetrics().density;
    Object localObject = this.c.a;
    boolean bool = this.c.b;
    ((IPicUtil)QRoute.api(IPicUtil.class)).isDynamicImg(this.a.imageType);
    if (bool) {
      try
      {
        paramFile = NativeGifImage.getImageSize(paramFile, false);
      }
      catch (Throwable paramFile)
      {
        paramFile.printStackTrace();
      }
    } else {
      paramFile = null;
    }
    int i;
    int j;
    if (paramFile != null)
    {
      i = paramFile.width();
      j = paramFile.height();
    }
    else
    {
      bool = ((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion(this.a);
      int[] arrayOfInt = ((IGuildPicAIO)QRoute.api(IGuildPicAIO.class)).getThumbSize(this.a.width, this.a.height, bool);
      i = arrayOfInt[0];
      j = arrayOfInt[1];
    }
    float f1 = f3;
    if (paramFile != null)
    {
      if (paramFile.width() < i) {
        f1 = paramFile.width();
      }
      for (float f2 = i;; f2 = j)
      {
        f1 = f3 * (f1 / f2);
        break;
        f1 = f3;
        if (paramFile.height() >= j) {
          break;
        }
        f1 = paramFile.height();
      }
    }
    if (QLog.isColorLevel())
    {
      paramFile = new StringBuilder();
      paramFile.append("getThumbDrawable,roundCornor:");
      paramFile.append(f1);
      paramFile.append("  w:");
      paramFile.append(i);
      paramFile.append(" h:");
      paramFile.append(j);
      QLog.d("GuildAIOPicThumbDrawableObject", 2, paramFile.toString());
    }
    paramFile = URLDrawableHelper.getLoadingDrawable();
    if ((URLDrawableHelper.getLoadingDrawable() instanceof SkinnableBitmapDrawable)) {}
    for (paramFile = new BitmapDrawableWithMargin(localResources, ((SkinnableBitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap(), i, j, -921103, 6.0F);; paramFile = new BitmapDrawableWithMargin(localResources, ((BitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap(), i, j, -921103, 6.0F))
    {
      break;
      if (!(URLDrawableHelper.getLoadingDrawable() instanceof BitmapDrawable)) {
        break;
      }
    }
    paramFile = a((URL)localObject, i, j, paramFile, URLDrawableHelper.getFailedDrawable(), true, f1);
    paramFile.setProgressDrawable(new PhotoProgressDrawable(URLDrawableHelper.getCommonProgressBitmap(), 0, false));
    paramFile.setIgnorePause(true);
    paramFile.setFadeInImage(true);
    localObject = this.b;
    if (localObject != null) {
      ((ChatThumbView)localObject).b = true;
    }
    return paramFile;
  }
  
  private static URLDrawable a(URL paramURL, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean, float paramFloat)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramInt1;
    localURLDrawableOptions.mRequestHeight = paramInt2;
    localURLDrawableOptions.mLoadingDrawable = paramDrawable1;
    localURLDrawableOptions.mFailedDrawable = paramDrawable2;
    localURLDrawableOptions.mPlayGifImage = paramBoolean;
    localURLDrawableOptions.mGifRoundCorner = paramFloat;
    localURLDrawableOptions.mMemoryCacheKeySuffix = "guildStuff";
    return URLDrawable.getDrawable(paramURL, localURLDrawableOptions);
  }
  
  private URLDrawable b()
  {
    Object localObject1 = BaseApplication.getContext().getResources();
    URL localURL = this.c.a;
    boolean bool1 = this.c.b;
    boolean bool2 = ((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion(this.a);
    Object localObject2 = ((IGuildPicAIO)QRoute.api(IGuildPicAIO.class)).getThumbSize(this.a.width, this.a.height, bool2);
    int i = localObject2[0];
    int j = localObject2[1];
    localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = i;
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = j;
    ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "guildStuff";
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelper.getLoadingDrawable();
    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = URLDrawableHelper.getFailedDrawable();
    ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = bool1;
    ((URLDrawable.URLDrawableOptions)localObject2).mGifRoundCorner = 6.0F;
    ((URLDrawable.URLDrawableOptions)localObject2).mImgType = this.a.imageType;
    if ((URLDrawableHelper.getLoadingDrawable() instanceof SkinnableBitmapDrawable)) {
      localObject1 = new BitmapDrawableWithMargin((Resources)localObject1, ((SkinnableBitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap(), i, j, -921103, 6.0F);
    } else if ((URLDrawableHelper.getLoadingDrawable() instanceof BitmapDrawable)) {
      localObject1 = new BitmapDrawableWithMargin((Resources)localObject1, ((BitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap(), i, j, -921103, 6.0F);
    } else {
      localObject1 = null;
    }
    if (localObject1 != null) {
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
    }
    localObject1 = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject2);
    ((URLDrawable)localObject1).setAutoDownload(true);
    ((URLDrawable)localObject1).setProgressDrawable(new PhotoProgressDrawable(URLDrawableHelper.getCommonProgressBitmap(), 0, false));
    return localObject1;
  }
  
  private URLDrawable c()
  {
    float f = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi / 160.0F;
    return a(this.c.a, 0, 0, null, null, true, f * 6.0F);
  }
  
  public URLDrawable a()
  {
    if (this.c == null) {
      this.c = new BaseGuildPicBuilder.DrawURL(this.a);
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getThumbDrawable url:");
    ((StringBuilder)localObject2).append(this.c.a);
    ((StringBuilder)localObject2).append(" index:");
    if (this.a.picExtraData != null) {
      localObject1 = this.a.picExtraData.mDownloadIndex;
    } else {
      localObject1 = "";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.i("GuildAIOPicThumbDrawableObject<gld>", 1, ((StringBuilder)localObject2).toString());
    Object localObject1 = this.c.a.toString();
    localObject2 = this.b;
    if (localObject2 != null) {
      ((ChatThumbView)localObject2).b = false;
    }
    localObject2 = GlobalImageCache.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append('#');
    localStringBuilder.append("guildStuff");
    if (((MQLruCache)localObject2).get(localStringBuilder.toString()) != null)
    {
      localObject1 = c();
    }
    else
    {
      localObject1 = AbsDownloader.getFile((String)localObject1);
      if (localObject1 != null) {
        localObject1 = a((File)localObject1);
      } else {
        localObject1 = b();
      }
    }
    ((URLDrawable)localObject1).setTag(this.a);
    if ((((URLDrawable)localObject1).getCurrDrawable() instanceof GifDrawable)) {
      ((URLDrawable)localObject1).getCurrDrawable().mutate();
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.GuildAIOPicThumbDrawableObject
 * JD-Core Version:    0.7.0.1
 */