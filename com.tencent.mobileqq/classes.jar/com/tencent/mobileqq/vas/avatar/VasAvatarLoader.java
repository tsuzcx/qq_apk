package com.tencent.mobileqq.vas.avatar;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloAvatarFileManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.VasManager.CompleteListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import java.lang.ref.WeakReference;
import java.net.URL;
import mqq.os.MqqHandler;

public class VasAvatarLoader
  implements VasManager.CompleteListener<String>
{
  private static IdleGetDynamic a;
  private static final Drawable b;
  public int a;
  public long a;
  public Drawable a;
  public String a;
  public WeakReference<VasAvatar> a;
  public boolean a;
  public int b;
  public String b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVasAvatarIdleGetDynamic = new IdleGetDynamic();
    jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(16777215);
  }
  
  public VasAvatarLoader(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public VasAvatarLoader(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void a(String paramString)
  {
    if (paramString == null) {
      QLog.e("Q.qqhead.VasFaceManager", 1, "VasAvatar get null path");
    }
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((this.jdField_b_of_type_Int == -1) && (DeviceInfoUtils.b()));
      localObject = (VasAvatar)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localObject == null) || (((VasAvatar)localObject).jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatarLoader != this));
    try
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      localObject = URLDrawable.getFileDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      ThreadManager.getUIHandler().post(new VasAvatarLoader.2(this, (URLDrawable)localObject));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Q.qqhead.VasFaceManager", 1, "getGifDrawable GifImage err, path:" + paramString, localException);
    }
  }
  
  void a(VasAvatar paramVasAvatar)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVasAvatar);
    if (this.jdField_b_of_type_Int == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.VasFaceManager", 2, "delay getAvatar uin: " + this.jdField_a_of_type_JavaLangString);
      }
      jdField_a_of_type_ComTencentMobileqqVasAvatarIdleGetDynamic.a(this);
      return;
    }
    a(false);
  }
  
  public void a(VasAvatar paramVasAvatar, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVasAvatar);
    if (this.jdField_b_of_type_Int == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.VasFaceManager", 2, "delay getAvatar uin: " + this.jdField_a_of_type_JavaLangString);
      }
      jdField_a_of_type_ComTencentMobileqqVasAvatarIdleGetDynamic.a(this);
      return;
    }
    a(ApolloAvatarFileManager.a().a(paramInt));
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (paramObject == jdField_b_of_type_AndroidGraphicsDrawableDrawable) {
      a(true);
    }
    Object localObject;
    do
    {
      do
      {
        return;
        if (paramString == null)
        {
          QLog.e("Q.qqhead.VasFaceManager", 1, "VasAvatar get null path");
          return;
        }
      } while ((this.jdField_b_of_type_Int == -1) && (DeviceInfoUtils.b()));
      localObject = (VasAvatar)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localObject == null) || (((VasAvatar)localObject).jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatarLoader != this));
    try
    {
      paramObject = new URL("vasapngdownloader", paramString, "-vas-face-");
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseApngImage = true;
      localURLDrawableOptions.mUseMemoryCache = true;
      localURLDrawableOptions.mMemoryCacheKeySuffix = Long.toString(this.jdField_a_of_type_Long);
      localObject = ((VasAvatar)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mExtraInfo = VasFaceManager.a(this.jdField_a_of_type_Boolean);
      VasFaceManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(paramObject, localURLDrawableOptions);
      paramObject = URLDrawable.getDrawable(paramObject, localURLDrawableOptions);
      ThreadManager.getUIHandler().post(new VasAvatarLoader.1(this, paramObject));
      return;
    }
    catch (Exception paramObject)
    {
      QLog.e("Q.qqhead.VasFaceManager", 1, "getApngDrawable ApngImage err, path:" + paramString, paramObject);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = (VasAvatar)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localObject1 == null) || (((VasAvatar)localObject1).jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatarLoader != this)) {}
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      } while (!(localObject1 instanceof QQAppInterface));
      localObject2 = (QQAppInterface)localObject1;
      localObject1 = ((VasExtensionManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a;
      if (this.jdField_a_of_type_Int > 0)
      {
        ((VasFaceManager)localObject1).a(this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString, this, null);
        return;
      }
      localObject2 = ((QQAppInterface)localObject2).getExtensionInfo(this.jdField_a_of_type_JavaLangString, paramBoolean);
      if ((localObject2 == null) || (((ExtensionInfo)localObject2).faceIdUpdateTime == 0L))
      {
        ((VasFaceManager)localObject1).b(this.jdField_a_of_type_JavaLangString, this, jdField_b_of_type_AndroidGraphicsDrawableDrawable);
        return;
      }
    } while (((ExtensionInfo)localObject2).faceId <= 0);
    ((VasFaceManager)localObject1).a(((ExtensionInfo)localObject2).faceId, this.jdField_b_of_type_JavaLangString, this, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.VasAvatarLoader
 * JD-Core Version:    0.7.0.1
 */