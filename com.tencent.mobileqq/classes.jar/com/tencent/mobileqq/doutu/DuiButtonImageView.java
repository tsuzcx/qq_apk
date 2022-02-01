package com.tencent.mobileqq.doutu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.FrameAnimationState;
import com.tencent.mobileqq.doutu.api.IDoutuService;
import com.tencent.mobileqq.doutu.api.IDoutuUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DuiButtonImageView
  extends ImageView
{
  static WeakReference<DuiButtonImageView> a;
  public static volatile boolean b = false;
  private static volatile boolean g = false;
  private static List<File> h = new ArrayList();
  CustomFrameAnimationDrawable c;
  Context d;
  BaseQQAppInterface e;
  public DoutuMsgItem f;
  
  public DuiButtonImageView(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, DoutuMsgItem paramDoutuMsgItem)
  {
    super(paramContext);
    this.d = paramContext;
    this.e = paramBaseQQAppInterface;
    this.f = paramDoutuMsgItem;
  }
  
  public static boolean a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(IDoutuUtils.DOUTU_ANIMA_RES_PATH);
    ((StringBuilder)localObject1).append("dui_icon");
    localObject1 = new File(((StringBuilder)localObject1).toString());
    if (((File)localObject1).exists()) {}
    for (;;)
    {
      int i;
      try
      {
        localObject1 = ((File)localObject1).listFiles();
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          int j = localObject1.length;
          i = 0;
          if (i < j)
          {
            Object localObject2 = localObject1[i];
            if (localObject2 == null) {
              break label118;
            }
            h.add(localObject2);
            break label118;
          }
          if (h.size() > 1) {
            Collections.sort(h);
          }
          b = true;
          return true;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return false;
      label118:
      i += 1;
    }
  }
  
  public static boolean a(DuiButtonImageView paramDuiButtonImageView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "startAnim");
    }
    a = new WeakReference(paramDuiButtonImageView);
    if (!g) {
      return false;
    }
    paramDuiButtonImageView.h();
    CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = paramDuiButtonImageView.c;
    if (localCustomFrameAnimationDrawable != null)
    {
      localCustomFrameAnimationDrawable.i();
      paramDuiButtonImageView.c.a();
      paramDuiButtonImageView.setImageDrawable(paramDuiButtonImageView.c);
      paramDuiButtonImageView.c.c();
      ReportController.b(null, "dc00898", "", "", "0X800B547", "0X800B547", 0, 0, "", "", "", "");
      return true;
    }
    return false;
  }
  
  public static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "doOnShowFirst");
    }
    g = true;
    WeakReference localWeakReference = a;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (((DuiButtonImageView)a.get()).c != null) && (((DuiButtonImageView)a.get()).f.l) && (!((DuiButtonImageView)a.get()).f.j)) {
      ((DuiButtonImageView)a.get()).c.c();
    }
  }
  
  public static void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "doOnFinish");
    }
    g = false;
    WeakReference localWeakReference = a;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (((DuiButtonImageView)a.get()).c != null)) {
      ((DuiButtonImageView)a.get()).c.g();
    }
    a = null;
  }
  
  public static void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "doOnScroll");
    }
    g = false;
    WeakReference localWeakReference = a;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (((DuiButtonImageView)a.get()).c != null)) {
      ((DuiButtonImageView)a.get()).c.f();
    }
  }
  
  public static void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "doOnScrollStop");
    }
    g = true;
    WeakReference localWeakReference = a;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (((DuiButtonImageView)a.get()).c != null) && (((DuiButtonImageView)a.get()).f.l) && (((DuiButtonImageView)a.get()).f.j)) {
      ((DuiButtonImageView)a.get()).c.d();
    }
  }
  
  private void h()
  {
    try
    {
      Object localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inSampleSize = 1;
      ((BitmapFactory.Options)localObject1).inMutable = true;
      if ((h != null) && (h.size() > 0))
      {
        Object localObject2 = h;
        int i = 0;
        localObject1 = BaseImageUtil.a(((File)((List)localObject2).get(0)).getAbsolutePath(), (BitmapFactory.Options)localObject1);
        localObject2 = (IDoutuService)this.e.getRuntimeService(IDoutuService.class, "");
        if (localObject2 == null) {
          return;
        }
        if (localObject1 == null)
        {
          b = false;
          ((IDoutuUtils)QRoute.api(IDoutuUtils.class)).markResDamaged(this.d);
        }
        this.c = new CustomFrameAnimationDrawable(this.d.getResources(), (Bitmap)localObject1, ((IDoutuService)localObject2).getDoutuAnimationHandler());
        while (i < h.size())
        {
          localObject1 = (File)h.get(i);
          if (localObject1 != null) {
            this.c.a(i, 77, ((File)localObject1).getAbsolutePath());
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "stopAnim");
    }
    CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = this.c;
    if (localCustomFrameAnimationDrawable != null) {
      localCustomFrameAnimationDrawable.g();
    }
  }
  
  public boolean g()
  {
    a = null;
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "resumeAnim");
    }
    Object localObject = this.c;
    if ((localObject != null) && (((CustomFrameAnimationDrawable)localObject).b != null) && (this.c.b.b != null) && (this.c.b.b.size() > 0))
    {
      this.c.d();
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "showLastFrame");
    }
    try
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      ((BitmapFactory.Options)localObject).inMutable = true;
      if (h.size() > 0)
      {
        localObject = BaseImageUtil.a(((File)h.get(h.size() - 1)).getAbsolutePath(), (BitmapFactory.Options)localObject);
        if (localObject == null)
        {
          b = false;
          ((IDoutuUtils)QRoute.api(IDoutuUtils.class)).markResDamaged(this.d);
        }
        setImageBitmap((Bitmap)localObject);
        return true;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("DuiButtonImageView", 2, "resumeAnim error!", localException);
        return false;
        QLog.e("DuiButtonImageView", 1, "oom occur!");
        System.gc();
      }
      return false;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label194:
      break label194;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DuiButtonImageView
 * JD-Core Version:    0.7.0.1
 */