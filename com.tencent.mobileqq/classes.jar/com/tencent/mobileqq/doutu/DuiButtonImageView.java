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
  static WeakReference<DuiButtonImageView> jdField_a_of_type_JavaLangRefWeakReference;
  private static List<File> jdField_a_of_type_JavaUtilList = new ArrayList();
  public static volatile boolean a = false;
  private static volatile boolean b = false;
  Context jdField_a_of_type_AndroidContentContext;
  BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
  CustomFrameAnimationDrawable jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable;
  public DoutuMsgItem a;
  
  public DuiButtonImageView(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, DoutuMsgItem paramDoutuMsgItem)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuMsgItem = paramDoutuMsgItem;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "doOnShowFirst");
    }
    b = true;
    WeakReference localWeakReference = jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (((DuiButtonImageView)jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable != null) && (((DuiButtonImageView)jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqDoutuDoutuMsgItem.f) && (!((DuiButtonImageView)jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqDoutuDoutuMsgItem.e)) {
      ((DuiButtonImageView)jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.c();
    }
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
            jdField_a_of_type_JavaUtilList.add(localObject2);
            break label118;
          }
          if (jdField_a_of_type_JavaUtilList.size() > 1) {
            Collections.sort(jdField_a_of_type_JavaUtilList);
          }
          jdField_a_of_type_Boolean = true;
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
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDuiButtonImageView);
    if (!b) {
      return false;
    }
    paramDuiButtonImageView.f();
    CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = paramDuiButtonImageView.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable;
    if (localCustomFrameAnimationDrawable != null)
    {
      localCustomFrameAnimationDrawable.h();
      paramDuiButtonImageView.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a();
      paramDuiButtonImageView.setImageDrawable(paramDuiButtonImageView.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable);
      paramDuiButtonImageView.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.c();
      ReportController.b(null, "dc00898", "", "", "0X800B547", "0X800B547", 0, 0, "", "", "", "");
      return true;
    }
    return false;
  }
  
  public static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "doOnFinish");
    }
    b = false;
    WeakReference localWeakReference = jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (((DuiButtonImageView)jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable != null)) {
      ((DuiButtonImageView)jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.g();
    }
    jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public static void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "doOnScroll");
    }
    b = false;
    WeakReference localWeakReference = jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (((DuiButtonImageView)jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable != null)) {
      ((DuiButtonImageView)jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.f();
    }
  }
  
  public static void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "doOnScrollStop");
    }
    b = true;
    WeakReference localWeakReference = jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (((DuiButtonImageView)jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable != null) && (((DuiButtonImageView)jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqDoutuDoutuMsgItem.f) && (((DuiButtonImageView)jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqDoutuDoutuMsgItem.e)) {
      ((DuiButtonImageView)jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.d();
    }
  }
  
  private void f()
  {
    try
    {
      Object localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inSampleSize = 1;
      ((BitmapFactory.Options)localObject1).inMutable = true;
      if ((jdField_a_of_type_JavaUtilList != null) && (jdField_a_of_type_JavaUtilList.size() > 0))
      {
        Object localObject2 = jdField_a_of_type_JavaUtilList;
        int i = 0;
        localObject1 = BaseImageUtil.a(((File)((List)localObject2).get(0)).getAbsolutePath(), (BitmapFactory.Options)localObject1);
        localObject2 = (IDoutuService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IDoutuService.class, "");
        if (localObject2 == null) {
          return;
        }
        if (localObject1 == null)
        {
          jdField_a_of_type_Boolean = false;
          ((IDoutuUtils)QRoute.api(IDoutuUtils.class)).markResDamaged(this.jdField_a_of_type_AndroidContentContext);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable = new CustomFrameAnimationDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject1, ((IDoutuService)localObject2).getDoutuAnimationHandler());
        while (i < jdField_a_of_type_JavaUtilList.size())
        {
          localObject1 = (File)jdField_a_of_type_JavaUtilList.get(i);
          if (localObject1 != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(i, 77, ((File)localObject1).getAbsolutePath());
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
  
  public boolean b()
  {
    jdField_a_of_type_JavaLangRefWeakReference = null;
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "resumeAnim");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable;
    if ((localObject != null) && (((CustomFrameAnimationDrawable)localObject).a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a.a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a.a.size() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.d();
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
      if (jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject = BaseImageUtil.a(((File)jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_JavaUtilList.size() - 1)).getAbsolutePath(), (BitmapFactory.Options)localObject);
        if (localObject == null)
        {
          jdField_a_of_type_Boolean = false;
          ((IDoutuUtils)QRoute.api(IDoutuUtils.class)).markResDamaged(this.jdField_a_of_type_AndroidContentContext);
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
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "stopAnim");
    }
    CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable;
    if (localCustomFrameAnimationDrawable != null) {
      localCustomFrameAnimationDrawable.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DuiButtonImageView
 * JD-Core Version:    0.7.0.1
 */