package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class RefreshView
  extends ImageView
{
  private LottieDrawable a;
  private String b = "refreshLottie/";
  private String c = "refresh.json";
  private String d = "refresh_night.json";
  
  public RefreshView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RefreshView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public RefreshView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  protected String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getLottieDir());
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  protected void a()
  {
    ThreadManager.post(new RefreshView.1(this), 5, null, true);
  }
  
  protected void a(Context paramContext, String paramString)
  {
    paramString = new File(getLottieDir());
    if (!paramString.exists())
    {
      paramString.mkdir();
      FileUtils.copyAssetDirsToSdcard(paramContext, "refresh_lottie", getLottieDir());
    }
  }
  
  public void a(RefreshView.OnLottieEndListener paramOnLottieEndListener)
  {
    LottieDrawable localLottieDrawable = this.a;
    if (localLottieDrawable == null) {
      return;
    }
    localLottieDrawable.addAnimatorUpdateListener(new RefreshView.3(this, paramOnLottieEndListener));
  }
  
  protected void b()
  {
    if (QQTheme.isNowThemeIsNight())
    {
      b(this.d);
      return;
    }
    b(this.c);
  }
  
  protected void b(String paramString)
  {
    try
    {
      paramString = new BufferedInputStream(new FileInputStream(a(paramString)));
      LottieComposition.Factory.fromInputStream(getContext(), paramString, new RefreshView.2(this));
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("RefreshView", 1, "loadEllipsisAnimation fail.", paramString);
    }
  }
  
  public void c()
  {
    LottieDrawable localLottieDrawable = this.a;
    if (localLottieDrawable != null) {
      localLottieDrawable.resumeAnimation();
    }
  }
  
  protected String getLottieDir()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
  
  public void setProgress(float paramFloat)
  {
    LottieDrawable localLottieDrawable = this.a;
    if (localLottieDrawable == null) {
      return;
    }
    localLottieDrawable.setProgress(paramFloat);
  }
  
  public void setSpeed(float paramFloat)
  {
    LottieDrawable localLottieDrawable = this.a;
    if (localLottieDrawable == null) {
      return;
    }
    localLottieDrawable.setSpeed(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RefreshView
 * JD-Core Version:    0.7.0.1
 */