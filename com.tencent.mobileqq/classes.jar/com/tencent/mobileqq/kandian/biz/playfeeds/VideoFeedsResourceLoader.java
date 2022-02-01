package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.view.widget.LayoutInflateProcessor;
import com.tencent.mobileqq.kandian.base.view.widget.LayoutInflateProcessor.InflateParams;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class VideoFeedsResourceLoader
{
  private static int a;
  private static LayoutInflateProcessor b;
  private static HashMap<Integer, Drawable> c;
  private Handler d;
  
  public VideoFeedsResourceLoader(Context paramContext)
  {
    b = new LayoutInflateProcessor(paramContext.getApplicationContext());
    c = new HashMap();
    this.d = new Handler();
    a += 1;
    a(paramContext);
  }
  
  public static Drawable a(Context paramContext, int paramInt)
  {
    Object localObject = c;
    if (localObject == null) {
      return null;
    }
    if (((HashMap)localObject).containsKey(Integer.valueOf(paramInt))) {
      return (Drawable)c.get(Integer.valueOf(paramInt));
    }
    try
    {
      paramContext = paramContext.getResources().getDrawable(paramInt);
      c.put(Integer.valueOf(paramInt), paramContext);
      return paramContext;
    }
    catch (OutOfMemoryError paramContext)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("innerGetDrawableFromCache() OutOfMemoryError e=");
        ((StringBuilder)localObject).append(paramContext.getMessage());
        QLog.d("VideoFeedsResourceLoader", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public static View a(int paramInt, boolean paramBoolean, ViewGroup.LayoutParams paramLayoutParams)
  {
    Object localObject = b;
    if (localObject != null) {
      return ((LayoutInflateProcessor)localObject).a(paramInt, paramBoolean, paramLayoutParams);
    }
    if (paramBoolean)
    {
      localObject = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(paramInt, null, false);
      ((View)localObject).setLayoutParams(paramLayoutParams);
      return localObject;
    }
    return null;
  }
  
  public static LayoutInflateProcessor a()
  {
    return b;
  }
  
  private void a(Context paramContext)
  {
    ThreadManager.excute(new VideoFeedsResourceLoader.1(this, new WeakReference(paramContext)), 16, null, true);
  }
  
  private LayoutInflateProcessor.InflateParams b(int paramInt)
  {
    if (ReadInJoyHelper.b()) {
      return new LayoutInflateProcessor.InflateParams(2131626403, paramInt, null, new VideoFeedsResourceLoader.3(this));
    }
    return new LayoutInflateProcessor.InflateParams(2131626387, paramInt, null, new VideoFeedsResourceLoader.4(this));
  }
  
  private LayoutInflateProcessor.InflateParams c()
  {
    return new LayoutInflateProcessor.InflateParams(2131626383, null, new VideoFeedsResourceLoader.2(this));
  }
  
  public void a(int paramInt)
  {
    LayoutInflateProcessor.InflateParams localInflateParams1;
    if (paramInt == 0) {
      localInflateParams1 = new LayoutInflateProcessor.InflateParams(2131626419, null, null);
    } else {
      localInflateParams1 = null;
    }
    LayoutInflateProcessor.InflateParams localInflateParams2 = new LayoutInflateProcessor.InflateParams(2131626162, null, null);
    LayoutInflateProcessor.InflateParams localInflateParams3 = new LayoutInflateProcessor.InflateParams(2131626316, null, null);
    LayoutInflateProcessor.InflateParams localInflateParams4 = b(1);
    LayoutInflateProcessor.InflateParams localInflateParams5 = c();
    LayoutInflateProcessor.InflateParams localInflateParams6 = b(2);
    b.a(new LayoutInflateProcessor.InflateParams[] { localInflateParams1, localInflateParams2, localInflateParams3, localInflateParams4, localInflateParams5, localInflateParams6 });
  }
  
  public void b()
  {
    Object localObject = b;
    if (localObject != null) {
      ((LayoutInflateProcessor)localObject).a();
    }
    localObject = c;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    this.d.removeCallbacksAndMessages(null);
    a -= 1;
    if (a <= 0)
    {
      b = null;
      c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsResourceLoader
 * JD-Core Version:    0.7.0.1
 */