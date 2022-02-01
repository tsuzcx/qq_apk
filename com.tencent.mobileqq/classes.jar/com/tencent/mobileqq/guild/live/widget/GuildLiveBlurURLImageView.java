package com.tencent.mobileqq.guild.live.widget;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManagerV2;

public class GuildLiveBlurURLImageView
  extends AppCompatImageView
{
  private static final Bitmap.Config a = Bitmap.Config.ARGB_8888;
  
  public GuildLiveBlurURLImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GuildLiveBlurURLImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GuildLiveBlurURLImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Drawable paramDrawable, int paramInt)
  {
    if (paramDrawable != null) {
      paramDrawable.setAlpha(paramInt);
    }
    setImageDrawable(paramDrawable);
  }
  
  private void a(URLDrawable paramURLDrawable, int paramInt1, int paramInt2)
  {
    if (getContext() == null) {
      return;
    }
    if (paramInt1 == 0)
    {
      setImageDrawableOnUiThread(paramURLDrawable, paramInt2);
      return;
    }
    ThreadManagerV2.excute(new GuildLiveBlurURLImageView.2(this, paramURLDrawable, paramInt1, paramInt2), 16, null, true);
  }
  
  public void a(String paramString)
  {
    a(paramString, null);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, 0);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    a(paramString1, paramString2, paramInt, 255);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString2 = URLDrawable.getDrawable(paramString2, null);
      localURLDrawableOptions.mLoadingDrawable = paramString2;
      localURLDrawableOptions.mFailedDrawable = paramString2;
    }
    else
    {
      localURLDrawableOptions.mLoadingDrawable = null;
      localURLDrawableOptions.mFailedDrawable = null;
    }
    paramString1 = URLDrawable.getDrawable(paramString1, localURLDrawableOptions);
    int i = paramString1.getStatus();
    if ((i != 1) && (i != 4))
    {
      paramString1.setURLDrawableListener(new GuildLiveBlurURLImageView.1(this, paramInt1, paramInt2));
      paramString1.restartDownload();
      a(paramString1, 0);
      return;
    }
    a(paramString1, paramInt1, paramInt2);
  }
  
  public void setImageDrawableOnUiThread(@Nullable Drawable paramDrawable, int paramInt)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      a(paramDrawable, paramInt);
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new GuildLiveBlurURLImageView.3(this, paramDrawable, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.widget.GuildLiveBlurURLImageView
 * JD-Core Version:    0.7.0.1
 */