package cooperation.qzone.contentbox;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import awjx;
import bhtq;
import bmxt;
import bmxu;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgBody;
import cooperation.qzone.contentbox.model.MQPhotoCell;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public abstract class BaseMsgView
  extends FrameLayout
{
  private static final int c = bhtq.a() - bhtq.b(24.0F);
  private static final int d = bhtq.b(230.0F);
  protected int a;
  public Context a;
  protected bmxu a;
  protected QQAppInterface a;
  protected QzoneMsgPagerAdapter a;
  protected QzoneMsgViewPager a;
  public MQMsg a;
  private WeakReference<ViewPager> a;
  protected int b;
  
  public BaseMsgView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public BaseMsgView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BaseMsgView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static URLDrawable a(AppRuntime paramAppRuntime, String paramString1, String paramString2, Drawable paramDrawable, int[] paramArrayOfInt, String paramString3, Bundle paramBundle)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    paramAppRuntime = paramBundle;
    if (paramBundle == null) {}
    try
    {
      paramAppRuntime = new Bundle();
      boolean bool = paramAppRuntime.getBoolean("key_play_apng", true);
      int i = paramAppRuntime.getInt("key_loop");
      paramBundle = URLDrawable.URLDrawableOptions.obtain();
      paramBundle.mUseApngImage = bool;
      paramBundle.mUseMemoryCache = true;
      paramBundle.mMemoryCacheKeySuffix = (bool + "," + i);
      i = paramAppRuntime.getInt("key_width", 0);
      int j = paramAppRuntime.getInt("key_height", 0);
      if ((i > 0) && (j > 0)) {
        paramBundle.mRequestWidth = i;
      }
      for (paramBundle.mRequestHeight = j;; paramBundle.mRequestHeight = d)
      {
        paramBundle.mLoadingDrawable = paramDrawable;
        paramBundle.mFailedDrawable = paramDrawable;
        paramAppRuntime.putIntArray("key_tagId_arr", paramArrayOfInt);
        paramAppRuntime.putString("key_name", paramString3);
        paramBundle.mExtraInfo = paramAppRuntime;
        paramAppRuntime = URLDrawable.getDrawable(new URL("qzonecontentboxdownloader", paramString1, paramString2), paramBundle);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QZoneMsgManager.BaseMsgView", 2, "getApngDrawable ApngImage ok path:" + paramString1 + ", name=" + paramString3);
        break;
        paramBundle.mRequestWidth = c;
      }
      return paramAppRuntime;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.e("QZoneMsgManager.BaseMsgView", 1, "getApngDrawable ApngImage err:" + paramAppRuntime.toString() + ", path:" + paramString1 + ", name=" + paramString3);
      return null;
    }
  }
  
  protected URLDrawable a()
  {
    String str1 = this.jdField_a_of_type_AndroidContentContext.getFilesDir() + "/qzone_msg_content_box/";
    Object localObject = new File(str1);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
    localObject = ((MQPhotoCell)this.jdField_a_of_type_CooperationQzoneContentboxModelMQMsg.msgBody.photolist.get(0)).coverUrl;
    String str2 = MD5.toMD5((String)localObject).substring(0, 20);
    this.jdField_a_of_type_Int = (this.b + 10000);
    return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1 + str2, (String)localObject, null, new int[] { this.jdField_a_of_type_Int }, "content-box", null);
  }
  
  protected URLDrawable a(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = c;
    localURLDrawableOptions.mRequestHeight = d;
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bmxu == null) {
      return;
    }
    if ((this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgViewPager != null) && (this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgViewPager.getVisibility() == 0) && (this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgPagerAdapter != null) && (this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgPagerAdapter.getCount() > 1))
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgViewPager);
      Message localMessage = this.jdField_a_of_type_Bmxu.obtainMessage(10000, this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgPagerAdapter.getCount(), 0, this.jdField_a_of_type_JavaLangRefWeakReference);
      this.jdField_a_of_type_Bmxu.removeMessages(10000);
      this.jdField_a_of_type_Bmxu.sendMessageDelayed(localMessage, 3000L);
      return;
    }
    ApngImage.playByTag(this.jdField_a_of_type_Int);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_CooperationQzoneContentboxModelMQMsg == null) {}
    while (this.jdField_a_of_type_CooperationQzoneContentboxModelMQMsg.msgType == 6) {
      return false;
    }
    return true;
  }
  
  public boolean a(Message paramMessage)
  {
    return false;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bmxu == null) || (this.jdField_a_of_type_JavaLangRefWeakReference == null)) {
      return;
    }
    this.jdField_a_of_type_Bmxu.removeMessages(10000, this.jdField_a_of_type_JavaLangRefWeakReference);
    ApngImage.pauseByTag(this.jdField_a_of_type_Int);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bmxu == null) {
      return;
    }
    this.jdField_a_of_type_Bmxu.removeMessages(10000);
  }
  
  protected void d()
  {
    try
    {
      Field localField = Class.forName("android.support.v4.view.ViewPager").getDeclaredField("mScroller");
      bmxt localbmxt = new bmxt(this.jdField_a_of_type_AndroidContentContext, new awjx(0.25D, 0.1000000014901161D, 0.25D, 1.0D));
      localbmxt.a(400);
      localField.setAccessible(true);
      localField.set(this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgViewPager, localbmxt);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QZoneMsgManager.BaseMsgView", 1, "initViewPager error:", localException);
    }
  }
  
  public void e()
  {
    c();
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgViewPager = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgPagerAdapter = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_CooperationQzoneContentboxModelMQMsg = null;
  }
  
  public void setApp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void setPosition(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.BaseMsgView
 * JD-Core Version:    0.7.0.1
 */