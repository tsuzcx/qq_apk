package com.tencent.mobileqq.util;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.util.AvatarDownloadUtil;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil.HttpDownloadListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class QQAvatarFHDDecoder
  implements Handler.Callback, HttpDownloadUtil.HttpDownloadListener
{
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new QQAvatarFHDDecoder.1(this);
  private volatile String jdField_a_of_type_JavaLangString;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private volatile WeakReference<QQAvatarFHDDecoder.OnQQAvatarFHDListener> jdField_b_of_type_MqqUtilWeakReference;
  private volatile boolean jdField_b_of_type_Boolean = false;
  
  public QQAvatarFHDDecoder(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramQQAppInterface);
    a();
  }
  
  private QQAppInterface a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null) {
      return (QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get();
    }
    return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  }
  
  private void a()
  {
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  private void a(String paramString)
  {
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      paramString = new BitmapDrawable(a().getApp().getResources(), paramString);
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("downloadFHDAvatar getDrawable ");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.i("QQAvatarFHDDecoder", 2, ((StringBuilder)localObject).toString());
      }
      paramString = null;
    }
    Object localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1);
    ((Message)localObject).obj = paramString;
    ((Message)localObject).sendToTarget();
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQAvatarFHDDecoder", 2, "getLocalThumbFile ");
    }
    paramString = a().getCustomFaceFilePath(1, paramString, 0);
    if (new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQAvatarFHDDecoder", 2, "getLocalThumbFile exist");
      }
      a(paramString);
    }
  }
  
  protected void a(Setting paramSetting)
  {
    Object localObject1;
    if ((paramSetting != null) && (!TextUtils.isEmpty(paramSetting.uin)) && (!TextUtils.isEmpty(paramSetting.url)))
    {
      localObject1 = FaceUtil.b(paramSetting.uin);
      if (FileUtil.b((String)localObject1))
      {
        if (QLog.isColorLevel())
        {
          paramSetting = new StringBuilder();
          paramSetting.append("downloadFHDAvatar already exist ");
          paramSetting.append((String)localObject1);
          QLog.i("QQAvatarFHDDecoder", 2, paramSetting.toString());
        }
        a((String)localObject1);
        return;
      }
      String str = AvatarDownloadUtil.get1080QQHeadDownLoadUrl(paramSetting.url, paramSetting.bFaceFlags);
      paramSetting = new File((String)localObject1);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramSetting.getPath());
      ((StringBuilder)localObject2).append(System.currentTimeMillis());
      localObject2 = new File(((StringBuilder)localObject2).toString());
      QQAppInterface localQQAppInterface = a();
      str = MsfSdkUtils.insertMtype("friendlist", str);
      boolean bool1 = false;
      if (HttpDownloadUtil.downloadData(localQQAppInterface, new DownloadInfo(str, (File)localObject2, 0), this) == 0) {
        bool1 = true;
      }
      boolean bool2;
      if (bool1)
      {
        if (((File)localObject2).exists()) {
          bool1 = ((File)localObject2).renameTo(paramSetting);
        }
        if (QLog.isColorLevel())
        {
          paramSetting = new StringBuilder();
          paramSetting.append("downloadFHDAvatar suc ");
          paramSetting.append(bool1);
          paramSetting.append(" ");
          paramSetting.append((String)localObject1);
          QLog.i("QQAvatarFHDDecoder", 2, paramSetting.toString());
        }
        bool2 = bool1;
        if (bool1)
        {
          a((String)localObject1);
          bool2 = bool1;
        }
      }
      else
      {
        bool2 = bool1;
        if (((File)localObject2).exists())
        {
          ((File)localObject2).delete();
          bool2 = bool1;
        }
      }
      if (!bool2) {
        b(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("downloadFHDAvatar return ");
      if (paramSetting != null) {
        paramSetting = paramSetting.toString();
      } else {
        paramSetting = "";
      }
      ((StringBuilder)localObject1).append(paramSetting);
      QLog.i("QQAvatarFHDDecoder", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHttpStart ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramInt);
      QLog.i("QQAvatarFHDDecoder", 2, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2) {}
  
  public boolean a(String paramString, boolean paramBoolean, QQAvatarFHDDecoder.OnQQAvatarFHDListener paramOnQQAvatarFHDListener)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFHDAvatar ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" mIsGettingHead：");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(" mCurrentUin：");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" forceUpdate：");
      localStringBuilder.append(paramBoolean);
      QLog.i("QQAvatarFHDDecoder", 2, localStringBuilder.toString());
    }
    if ((!this.jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(paramString)))
    {
      if (!Friends.isValidUin(paramString)) {
        return false;
      }
      if (!NetworkUtil.isNetSupport(a().getApp()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQAvatarFHDDecoder", 2, "getFHDAvatar no network");
        }
        return false;
      }
      if (this.jdField_a_of_type_Boolean) {
        return false;
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(paramOnQQAvatarFHDListener);
      ThreadManagerV2.excute(new QQAvatarFHDDecoder.2(this, paramString, paramBoolean), 128, null, true);
      return true;
    }
    return false;
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHttpEnd ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramInt);
      QLog.i("QQAvatarFHDDecoder", 2, localStringBuilder.toString());
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return true;
    }
    if ((paramMessage.obj instanceof Drawable)) {
      paramMessage = (Drawable)paramMessage.obj;
    } else {
      paramMessage = null;
    }
    if (this.jdField_b_of_type_MqqUtilWeakReference != null)
    {
      QQAvatarFHDDecoder.OnQQAvatarFHDListener localOnQQAvatarFHDListener = (QQAvatarFHDDecoder.OnQQAvatarFHDListener)this.jdField_b_of_type_MqqUtilWeakReference.get();
      if (localOnQQAvatarFHDListener != null)
      {
        String str = this.jdField_a_of_type_JavaLangString;
        boolean bool;
        if (paramMessage != null) {
          bool = true;
        } else {
          bool = false;
        }
        localOnQQAvatarFHDListener.a(str, bool, paramMessage);
      }
      this.jdField_b_of_type_MqqUtilWeakReference = null;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = null;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.QQAvatarFHDDecoder
 * JD-Core Version:    0.7.0.1
 */