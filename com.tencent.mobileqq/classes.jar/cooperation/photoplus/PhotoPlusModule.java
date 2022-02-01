package cooperation.photoplus;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

public class PhotoPlusModule
  extends QIPCModule
{
  private static PhotoPlusModule a;
  
  private PhotoPlusModule()
  {
    super("PhotoPlusModule");
  }
  
  public static PhotoPlusModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new PhotoPlusModule();
        }
      }
      finally {}
    }
    return a;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onCall] action = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", params = ");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append(", callbackId=");
      localStringBuilder.append(paramInt);
      QLog.d("PhotoPlusModule", 2, localStringBuilder.toString());
    }
    paramBundle = BaseApplicationImpl.sApplication.getRuntime();
    if (!QQAppInterface.class.isInstance(paramBundle))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoPlusModule", 2, "[onCall] get app failed.");
      }
      return null;
    }
    paramBundle = (PhotoPlusManager)paramBundle.getManager(QQManagerFactory.PHOTO_PLUS_MANAGER);
    if ("action_get_sticker_templates".equals(paramString))
    {
      paramBundle.b(true);
      ThreadManager.postImmediately(new PhotoPlusModule.1(this, paramBundle, paramInt), null, true);
      return null;
    }
    if ("action_exit_sticker".equals(paramString))
    {
      paramBundle.b(false);
      return null;
    }
    if ("action_jump_to_shortvideo".equals(paramString)) {
      paramBundle.c(true);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.photoplus.PhotoPlusModule
 * JD-Core Version:    0.7.0.1
 */