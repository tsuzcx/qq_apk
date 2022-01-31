package com.tencent.mobileqq.util;

import ajzi;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.avatar.dynamicavatar.VasFaceManager;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.VasManager.CompleteListener;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class DynamicFaceDrawable
  implements VasManager.CompleteListener
{
  public static long a;
  public static IdleGetDynamic a;
  public static Object a;
  public static int[] a;
  public static boolean b;
  public int a;
  public Drawable a;
  public URLDrawable a;
  public DynamicAvatarManager a;
  public String a;
  public WeakReference a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public WeakReference b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public boolean e;
  public boolean f;
  public boolean g;
  public boolean h;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2, 3, 5, 0, 4, 6, 1 };
    jdField_a_of_type_ComTencentMobileqqUtilIdleGetDynamic = new IdleGetDynamic();
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public DynamicFaceDrawable()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public DynamicFaceDrawable(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener, int paramInt4, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt5)
  {
    this.jdField_a_of_type_Boolean = true;
    a(paramAppInterface, null, paramInt1, paramInt2, paramString, paramInt4, paramInt3, paramBoolean3, paramInt5, paramBoolean2, paramBoolean5, paramBoolean1, null, false);
    if ((paramAppInterface instanceof QQAppInterface)) {}
    for (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new FaceDrawableImpl(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramInt4, paramBoolean1, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean4);; this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new NearByFaceDrawable(paramAppInterface, paramInt1, paramInt2, paramString, (byte)1, paramInt3, paramBoolean1, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean4))
    {
      this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(this);
      a(paramAppInterface, paramBoolean4, null);
      return;
    }
  }
  
  public DynamicFaceDrawable(AppInterface paramAppInterface, Drawable paramDrawable, int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean1, DynamicAvatar paramDynamicAvatar, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt4, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    a(paramAppInterface, paramDrawable, paramInt1, paramInt2, paramString, paramInt3, 0, paramBoolean1, paramInt4, paramBoolean5, paramBoolean4, paramBoolean2, paramDynamicAvatar, false);
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(this);
    a(paramAppInterface, paramBoolean3, paramDynamicAvatar);
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_b_of_type_Boolean = true;
      AbstractVideoImage.pauseAll();
      paramAppInterface = (DynamicAvatarManager)paramAppInterface.getManager(179);
      if (paramAppInterface != null)
      {
        paramAppInterface.d();
        ThreadManager.getSubThreadHandler().removeCallbacks(paramAppInterface.a);
      }
      return;
    }
  }
  
  public static void b(AppInterface paramAppInterface)
  {
    int i;
    if (jdField_a_of_type_Long <= 0L)
    {
      i = DeviceInfoUtil.b();
      if (i < 8) {
        break label50;
      }
      jdField_a_of_type_Long = 100L;
    }
    for (;;)
    {
      paramAppInterface = (DynamicAvatarManager)paramAppInterface.getManager(179);
      ThreadManager.getSubThreadHandler().postDelayed(paramAppInterface.a, jdField_a_of_type_Long);
      return;
      label50:
      if (i >= 4) {
        jdField_a_of_type_Long = 200L;
      } else if (i >= 3) {
        jdField_a_of_type_Long = 400L;
      } else if (i >= 2) {
        jdField_a_of_type_Long = 800L;
      } else {
        jdField_a_of_type_Long = 1000L;
      }
    }
  }
  
  private static boolean c()
  {
    long l = DeviceInfoUtil.e();
    if (l < 1073741824L)
    {
      QLog.d("Q.dynamicAvatar", 1, "isLowDevice: totalMemory below 1G: " + l / 1024L / 1024L + "M");
      return true;
    }
    Runtime localRuntime = Runtime.getRuntime();
    float f1 = (float)localRuntime.maxMemory();
    float f2 = (float)(localRuntime.totalMemory() - localRuntime.freeMemory());
    float f3 = f2 / f1 * 100.0F;
    if (f3 > 85.0F)
    {
      QLog.e("Q.dynamicAvatar", 1, "isLowDevice: used: " + f2 + " max: " + f1 + " percent: " + f3);
      return true;
    }
    return false;
  }
  
  public Drawable a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentImageURLDrawable == null) {
        return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      }
      return this.jdField_a_of_type_ComTencentImageURLDrawable;
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public void a()
  {
    if (!b()) {}
    while (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      return;
    }
    ((DynamicAvatarView)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
  }
  
  public void a(AppInterface paramAppInterface, Drawable paramDrawable, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, boolean paramBoolean1, int paramInt5, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, DynamicAvatar paramDynamicAvatar, boolean paramBoolean5)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt4;
    this.jdField_e_of_type_Int = paramInt5;
    this.jdField_d_of_type_Boolean = paramBoolean3;
    this.jdField_c_of_type_Boolean = paramBoolean4;
    this.g = paramBoolean2;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (paramInt2 == 200)
    {
      this.jdField_c_of_type_Int = 17;
      if (paramInt1 != 32) {
        break label154;
      }
    }
    label154:
    for (this.jdField_b_of_type_Int = 18;; this.jdField_b_of_type_Int = 17)
    {
      this.jdField_d_of_type_Int = paramInt3;
      this.f = paramBoolean1;
      this.jdField_b_of_type_JavaLangString = "";
      this.jdField_c_of_type_JavaLangString = "";
      this.jdField_e_of_type_Boolean = false;
      this.jdField_d_of_type_JavaLangString = DynamicAvatarManager.b(paramInt1, paramInt2, paramString, paramInt3);
      this.h = QQAppInterface.a(paramInt1, paramInt2);
      if (!paramBoolean5) {
        this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager = ((DynamicAvatarManager)paramAppInterface.getManager(179));
      return;
      this.jdField_c_of_type_Int = 18;
      break;
    }
  }
  
  public void a(AppInterface paramAppInterface, boolean paramBoolean, DynamicAvatar paramDynamicAvatar)
  {
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a(this);
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a(this.jdField_e_of_type_Int)))
    {
      paramBoolean = true;
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (this.jdField_a_of_type_Boolean) {
        break label46;
      }
    }
    label46:
    while ((!this.g) && (!NetworkUtil.h(BaseApplicationImpl.getContext())) && (this.jdField_d_of_type_Boolean))
    {
      return;
      paramBoolean = false;
      break;
    }
    if ((this.jdField_e_of_type_Int == 8) || (this.jdField_e_of_type_Int == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "delay getDynamicAvatar uin: " + this.jdField_a_of_type_JavaLangString);
      }
      jdField_a_of_type_ComTencentMobileqqUtilIdleGetDynamic.a(this, paramDynamicAvatar);
      return;
    }
    ThreadManager.post(new ajzi(this, paramDynamicAvatar), 5, null, true);
  }
  
  public void a(DynamicAvatar paramDynamicAvatar)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.dynamicAvatar", 2, "getDynamicAvatar uin: " + this.jdField_a_of_type_JavaLangString + " source: " + this.jdField_e_of_type_Int);
    }
    Object localObject1;
    Object localObject2;
    if ((this.jdField_e_of_type_Int != 0) && (this.jdField_e_of_type_Int != 1))
    {
      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 instanceof QQAppInterface))
      {
        localObject2 = (QQAppInterface)localObject1;
        if (this.h)
        {
          localObject1 = ((VasExtensionManager)((QQAppInterface)localObject2).getManager(234)).a;
          localObject2 = ((QQAppInterface)localObject2).a(this.jdField_a_of_type_JavaLangString, true);
          if ((localObject2 == null) || (((ExtensionInfo)localObject2).faceIdUpdateTime == 0L)) {
            ((VasFaceManager)localObject1).a(this.jdField_a_of_type_JavaLangString, this, new DynamicAvatar[] { paramDynamicAvatar });
          }
        }
      }
    }
    do
    {
      do
      {
        return;
        if (((ExtensionInfo)localObject2).faceId > 0)
        {
          ((VasFaceManager)localObject1).a(((ExtensionInfo)localObject2).faceId, this.jdField_d_of_type_Int, this, null);
          return;
        }
      } while (this.jdField_e_of_type_Int == 8);
      if ((this.g) || (paramDynamicAvatar == null))
      {
        this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.b(this);
        return;
      }
      if (paramDynamicAvatar != null)
      {
        this.jdField_b_of_type_JavaLangString = DynamicAvatarManager.a(this.jdField_b_of_type_Int, this.jdField_d_of_type_Int, paramDynamicAvatar);
        this.jdField_c_of_type_JavaLangString = DynamicAvatarManager.a(this.jdField_b_of_type_Int, 640, paramDynamicAvatar);
        if ((this.jdField_c_of_type_Boolean) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
        {
          this.jdField_b_of_type_JavaLangString = DynamicAvatarManager.a(17, this.jdField_d_of_type_Int, paramDynamicAvatar);
          this.jdField_c_of_type_JavaLangString = DynamicAvatarManager.a(17, 640, paramDynamicAvatar);
        }
        if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          this.jdField_e_of_type_Boolean = true;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.dynamicAvatar", 2, "initValue url: " + this.jdField_b_of_type_JavaLangString);
        }
      }
    } while (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.b(this);
  }
  
  public void a(String paramString, Object paramObject)
  {
    if ((paramObject instanceof DynamicAvatar[])) {
      a(((DynamicAvatar[])(DynamicAvatar[])paramObject)[0]);
    }
    while ((paramString == null) || ((this.jdField_e_of_type_Int == 8) && (c()))) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    paramObject = localObject;
    if ((localObject instanceof FaceDrawable)) {
      paramObject = ((FaceDrawable)localObject).a();
    }
    if (!VasApngUtil.a(BaseApplicationImpl.getApplication().getRuntime()))
    {
      QLog.e("Q.dynamicAvatar", 1, "apng.so load fail");
      return;
    }
    try
    {
      localObject = new URL("vasapngdownloader", paramString, VasFaceManager.a(this.jdField_b_of_type_Long));
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseApngImage = true;
      localURLDrawableOptions.mUseMemoryCache = true;
      localURLDrawableOptions.mFailedDrawable = paramObject;
      localURLDrawableOptions.mLoadingDrawable = paramObject;
      localURLDrawableOptions.mExtraInfo = VasFaceManager.a();
      paramObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
      localObject = paramObject.getCurrDrawable();
      if ((this.jdField_e_of_type_Int != 8) && ((localObject instanceof ApngDrawable))) {
        VasFaceManager.a((ApngDrawable)localObject);
      }
      a(paramObject, true);
      return;
    }
    catch (Exception paramObject)
    {
      QLog.e("Q.dynamicAvatar", 1, "getApngDrawable ApngImage err, path:" + paramString, paramObject);
    }
  }
  
  public boolean a()
  {
    return a() == this.jdField_a_of_type_ComTencentImageURLDrawable;
  }
  
  public boolean a(URLDrawable paramURLDrawable, boolean paramBoolean)
  {
    if (!b()) {
      return false;
    }
    if ((!paramBoolean) && (this.jdField_b_of_type_JavaLangString.equals(((DynamicAvatarView)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.dynamicAvatar", 2, "setVideoDrawable url equals currentUrl");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.dynamicAvatar", 2, "truly setVideoDrawable, isFromStore is " + paramBoolean);
    }
    ((DynamicAvatarView)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentImageURLDrawable = paramURLDrawable;
    if (!jdField_b_of_type_Boolean)
    {
      a();
      return true;
    }
    return false;
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null)) {
      return false;
    }
    DynamicAvatarView localDynamicAvatarView = (DynamicAvatarView)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localDynamicAvatarView.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable != this)
    {
      QLog.e("Q.dynamicAvatar", 1, "mDynamicFaceDrawable is changed : " + this + " " + localDynamicAvatarView.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.util.DynamicFaceDrawable
 * JD-Core Version:    0.7.0.1
 */