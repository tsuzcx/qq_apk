package com.tencent.mobileqq.doutu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.FrameAnimationState;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.ImageUtil;
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
  public static volatile boolean a;
  private static volatile boolean b = false;
  Context jdField_a_of_type_AndroidContentContext;
  CustomFrameAnimationDrawable jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ChatMessage a;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public DuiButtonImageView(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "doOnShowFirst");
    }
    b = true;
    if ((jdField_a_of_type_JavaLangRefWeakReference != null) && (jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (((DuiButtonImageView)jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable != null) && (((DuiButtonImageView)jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isDui) && (!((DuiButtonImageView)jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqDataChatMessage.hasPlayedDui)) {
      ((DuiButtonImageView)jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.c();
    }
  }
  
  public static boolean a()
  {
    Object localObject1 = new File(DoutuManager.jdField_a_of_type_JavaLangString + "dui_icon");
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
              break label112;
            }
            jdField_a_of_type_JavaUtilList.add(localObject2);
            break label112;
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
      label112:
      i += 1;
    }
  }
  
  public static boolean a(DuiButtonImageView paramDuiButtonImageView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "startAnim");
    }
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDuiButtonImageView);
    if (!b) {}
    do
    {
      return false;
      paramDuiButtonImageView.f();
    } while (paramDuiButtonImageView.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable == null);
    paramDuiButtonImageView.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.h();
    paramDuiButtonImageView.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a();
    paramDuiButtonImageView.setImageDrawable(paramDuiButtonImageView.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable);
    paramDuiButtonImageView.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.c();
    DoutuConfigReporter.a();
    return true;
  }
  
  public static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "doOnFinish");
    }
    b = false;
    if ((jdField_a_of_type_JavaLangRefWeakReference != null) && (jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (((DuiButtonImageView)jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable != null)) {
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
    if ((jdField_a_of_type_JavaLangRefWeakReference != null) && (jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (((DuiButtonImageView)jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable != null)) {
      ((DuiButtonImageView)jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.f();
    }
  }
  
  public static void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "doOnScrollStop");
    }
    b = true;
    if ((jdField_a_of_type_JavaLangRefWeakReference != null) && (jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (((DuiButtonImageView)jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable != null) && (((DuiButtonImageView)jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isDui) && (((DuiButtonImageView)jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqDataChatMessage.hasPlayedDui)) {
      ((DuiButtonImageView)jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.d();
    }
  }
  
  private void f()
  {
    int i = 0;
    try
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      ((BitmapFactory.Options)localObject).inMutable = true;
      if ((jdField_a_of_type_JavaUtilList != null) && (jdField_a_of_type_JavaUtilList.size() > 0))
      {
        localObject = ImageUtil.a(((File)jdField_a_of_type_JavaUtilList.get(0)).getAbsolutePath(), (BitmapFactory.Options)localObject);
        if (localObject == null)
        {
          jdField_a_of_type_Boolean = false;
          DoutuManager.a(this.jdField_a_of_type_AndroidContentContext);
        }
        DoutuManager localDoutuManager = (DoutuManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DOUTU_MAGAGER);
        if (localDoutuManager == null) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable = new CustomFrameAnimationDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject, localDoutuManager.jdField_a_of_type_MqqOsMqqHandler);
        while (i < jdField_a_of_type_JavaUtilList.size())
        {
          localObject = (File)jdField_a_of_type_JavaUtilList.get(i);
          if (localObject != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(i, 77, ((File)localObject).getAbsolutePath());
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a.a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a.a.size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.d();
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("DuiButtonImageView", 2, "showLastFrame");
      }
      try
      {
        Object localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inSampleSize = 1;
        ((BitmapFactory.Options)localObject).inMutable = true;
        if (jdField_a_of_type_JavaUtilList.size() <= 0) {
          continue;
        }
        localObject = ImageUtil.a(((File)jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_JavaUtilList.size() - 1)).getAbsolutePath(), (BitmapFactory.Options)localObject);
        if (localObject == null)
        {
          jdField_a_of_type_Boolean = false;
          DoutuManager.a(this.jdField_a_of_type_AndroidContentContext);
        }
        setImageBitmap((Bitmap)localObject);
        return true;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("DuiButtonImageView", 1, "oom occur!");
        System.gc();
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel()) {
        QLog.e("DuiButtonImageView", 2, "resumeAnim error!", localException);
      }
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DuiButtonImageView", 2, "stopAnim");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DuiButtonImageView
 * JD-Core Version:    0.7.0.1
 */