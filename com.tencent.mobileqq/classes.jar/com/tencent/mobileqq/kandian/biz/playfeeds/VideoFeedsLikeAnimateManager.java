package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.video.LikeAnimationInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import mqq.app.AppRuntime;

public class VideoFeedsLikeAnimateManager
{
  private static int a;
  private static URLDrawable[] h;
  private int[] b;
  private Random c;
  private ViewGroup d;
  private VideoFeedsLikeAnimateHandler e;
  private VideoFeedsLikeAnimateManager.LikeAnimateObserver f;
  private LikeAnimationInfo g;
  private boolean i;
  
  public VideoFeedsLikeAnimateManager(Activity paramActivity, int paramInt)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null) && (paramActivity.getWindow().getDecorView() != null))
    {
      this.d = ((ViewGroup)paramActivity.getWindow().getDecorView().findViewById(16908290));
      if (this.d == null) {
        return;
      }
      this.b = new int[2];
      a = AIOUtils.b(28.0F, paramActivity.getResources());
      this.d.getLocationInWindow(this.b);
      this.c = new Random();
      paramActivity = d();
      if (paramActivity != null)
      {
        this.e = ((VideoFeedsLikeAnimateHandler)paramActivity.getBusinessHandler(BusinessHandlerFactory.VIDEO_FEEDS_LIKE_ANIMATION_CONFIG));
        this.f = new VideoFeedsLikeAnimateManager.LikeAnimateObserver(this);
        paramActivity.addObserver(this.f);
      }
      this.g = ReadInJoyHelper.g();
      paramActivity = this.g;
      if (paramActivity != null)
      {
        if ((this.e != null) && (ReadInJoyHelper.a(paramActivity.b)))
        {
          this.e.a(paramInt);
          ReadInJoyHelper.a(System.currentTimeMillis());
          if (QLog.isColorLevel()) {
            QLog.d("VideoFeedsLikeAnimateManager", 2, "fetch icon list");
          }
        }
        else
        {
          a(this.g, false);
          if (QLog.isColorLevel()) {
            QLog.d("VideoFeedsLikeAnimateManager", 2, "use local icon list");
          }
        }
      }
      else
      {
        paramActivity = this.e;
        if (paramActivity != null)
        {
          paramActivity.a(paramInt);
          ReadInJoyHelper.a(System.currentTimeMillis());
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsLikeAnimateManager", 2, "activity in a invalid state");
    }
  }
  
  private void a(LikeAnimationInfo paramLikeAnimationInfo, boolean paramBoolean)
  {
    if ((paramLikeAnimationInfo != null) && (paramLikeAnimationInfo.a != null))
    {
      if (paramLikeAnimationInfo.a.length == 0) {
        return;
      }
      if ((h != null) && (!paramBoolean))
      {
        QLog.d("VideoFeedsLikeAnimateManager", 1, "use cache icon");
        return;
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      int j = a;
      localURLDrawableOptions.mRequestWidth = j;
      localURLDrawableOptions.mRequestHeight = j;
      h = new URLDrawable[paramLikeAnimationInfo.a.length];
      j = 0;
      while (j < paramLikeAnimationInfo.a.length)
      {
        String str = paramLikeAnimationInfo.a[j];
        if (!TextUtils.isEmpty(str)) {}
        try
        {
          localObject = URLDrawable.getDrawable(new URL(str), localURLDrawableOptions);
          ((URLDrawable)localObject).startDownload();
          h[j] = localObject;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          Object localObject;
          label129:
          break label129;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("illegal url format: ");
          ((StringBuilder)localObject).append(str);
          QLog.d("VideoFeedsLikeAnimateManager", 2, ((StringBuilder)localObject).toString());
        }
        j += 1;
      }
      QLog.d("VideoFeedsLikeAnimateManager", 1, "start download icon");
    }
    else
    {
      return;
    }
  }
  
  private boolean c()
  {
    Object localObject1 = h;
    boolean bool2 = false;
    boolean bool1 = false;
    if (localObject1 != null)
    {
      if (localObject1.length == 0) {
        return false;
      }
      int n = localObject1.length;
      int j = 0;
      int m;
      for (int k = 0; j < n; k = m)
      {
        Object localObject2 = localObject1[j];
        m = k;
        if (localObject2 != null)
        {
          m = k;
          if (localObject2.getStatus() == 1) {
            m = k + 1;
          }
        }
        j += 1;
      }
      if (k == h.length) {
        bool1 = true;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("isHit: ");
        ((StringBuilder)localObject1).append(bool1);
        QLog.d("VideoFeedsLikeAnimateManager", 2, ((StringBuilder)localObject1).toString());
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  private QQAppInterface d()
  {
    AppRuntime localAppRuntime = ReadInJoyUtils.b();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void a()
  {
    this.d = null;
    QQAppInterface localQQAppInterface = d();
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.f);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.d;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsLikeAnimateManager", 2, "parent view is null");
      }
      return;
    }
    int[] arrayOfInt = this.b;
    localObject = new VideoFeedsLikeAnimate((ViewGroup)localObject, paramFloat1 - arrayOfInt[0], paramFloat2 - arrayOfInt[1], this.c);
    if (c())
    {
      ((VideoFeedsLikeAnimate)localObject).a(h, 4, a);
      this.i = true;
    }
    else
    {
      ((VideoFeedsLikeAnimate)localObject).a(5);
      this.i = false;
    }
    ((VideoFeedsLikeAnimate)localObject).a();
  }
  
  public int b()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsLikeAnimateManager
 * JD-Core Version:    0.7.0.1
 */