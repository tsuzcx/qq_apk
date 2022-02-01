package com.tencent.mobileqq.extendfriend.limitchat;

import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSignalBombDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.math.BigDecimal;
import mqq.app.QQPermissionCallback;

public class SignalBombHelper
{
  public static String a(int paramInt)
  {
    if (paramInt < 1000) {
      return paramInt + "m";
    }
    float f = new BigDecimal(paramInt / 1000.0F).setScale(1, 1).floatValue();
    return f + "km";
  }
  
  public static void a(BaseActivity paramBaseActivity, QQPermissionCallback paramQQPermissionCallback, int paramInt)
  {
    if ((paramBaseActivity != null) && (paramQQPermissionCallback != null)) {
      paramBaseActivity.requestPermissions(paramQQPermissionCallback, paramInt, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface != null) {
      SharedPreUtils.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").edit().putBoolean("sp_extend_friend_signal_guide", paramBoolean).commit();
    }
  }
  
  public static boolean a()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (BaseApplicationImpl.getApplication().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SignalBombHelper", 2, "hasLocationPermission no permission " + Build.VERSION.SDK_INT);
      }
      return false;
    }
    return true;
  }
  
  public static boolean a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface)
  {
    if ((paramBaseActivity != null) && (paramQQAppInterface != null) && (!paramBaseActivity.isFinishing()))
    {
      if (((ExtendFriendManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).l())
      {
        if (QLog.isColorLevel()) {
          QLog.d("SignalBombHelper", 2, "checkIsSignalBombWaiting waiting");
        }
        return false;
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if ((paramBaseActivity != null) && (paramQQAppInterface != null) && (!paramBaseActivity.isFinishing()))
    {
      paramQQAppInterface = (ExtendFriendManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (!paramQQAppInterface.l()) {
        break label49;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SignalBombHelper", 2, "checkAndShowSignalBombCardDialogIfNeed waiting");
      }
    }
    label49:
    do
    {
      return false;
      paramQQAppInterface = paramQQAppInterface.a();
    } while (paramQQAppInterface == null);
    if (QLog.isColorLevel()) {
      QLog.d("SignalBombHelper", 2, "checkAndShowSignalBombCardDialogIfNeed show dialog");
    }
    ExtendFriendSignalBombDialog.a(paramBaseActivity, paramQQAppInterface, paramOnDismissListener);
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    if (paramQQAppInterface != null) {
      bool = SharedPreUtils.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getBoolean("sp_extend_friend_signal_guide", false);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.SignalBombHelper
 * JD-Core Version:    0.7.0.1
 */