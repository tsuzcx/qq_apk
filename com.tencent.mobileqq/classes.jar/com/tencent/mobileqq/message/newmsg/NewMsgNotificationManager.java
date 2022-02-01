package com.tencent.mobileqq.message.newmsg;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.growth.GrowthUtil;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpToNotificationSettingUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.io.File;
import mqq.manager.Manager;

public class NewMsgNotificationManager
  implements Manager
{
  QQAppInterface a;
  boolean b = true;
  CompoundButton.OnCheckedChangeListener c;
  
  public NewMsgNotificationManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = a();
  }
  
  public static Bitmap a(String paramString)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      QLog.e("NewMsgNotificationManager", 1, new Object[] { "getBitmapFromUrl: failed. can't run in ui thread. ", paramString });
      return null;
    }
    String str = AbsDownloader.getFilePath(paramString);
    Object localObject = new File(str);
    long l1 = SystemClock.uptimeMillis();
    localObject = new DownloadTask(paramString, (File)localObject);
    ((DownloadTask)localObject).J = true;
    ((DownloadTask)localObject).e = 2;
    ((DownloadTask)localObject).b = str;
    ((DownloadTask)localObject).b(512);
    int i = DownloaderFactory.a((DownloadTask)localObject, null, null);
    long l2 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download cost ");
      localStringBuilder.append(l2 - l1);
      localStringBuilder.append(" result ");
      localStringBuilder.append(i);
      localStringBuilder.append(" key ");
      localStringBuilder.append(((DownloadTask)localObject).b);
      localStringBuilder.append(" iconUrl: ");
      localStringBuilder.append(paramString);
      QLog.i("NewMsgNotificationManager", 2, localStringBuilder.toString());
    }
    return SafeBitmapFactory.decodeFile(str);
  }
  
  public static NewMsgNotificationManager a(QQAppInterface paramQQAppInterface)
  {
    return (NewMsgNotificationManager)paramQQAppInterface.getManager(QQManagerFactory.NEW_MSG_NOTIFICATION_MANAGER);
  }
  
  private static boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (paramInt != 1)
      {
        bool1 = bool2;
        if (paramInt != 3000)
        {
          bool1 = bool2;
          if (paramInt != 1009)
          {
            bool1 = bool2;
            if (paramInt != 1001)
            {
              bool1 = bool2;
              if (paramInt != 10002)
              {
                bool1 = bool2;
                if (paramInt != 10004)
                {
                  bool1 = bool2;
                  if (paramInt != 1003)
                  {
                    bool1 = bool2;
                    if (paramInt != 1004)
                    {
                      bool1 = bool2;
                      if (paramInt != 1005)
                      {
                        bool1 = bool2;
                        if (paramInt != 1020)
                        {
                          bool1 = bool2;
                          if (paramInt != 1000)
                          {
                            bool1 = bool2;
                            if (paramInt != 1023)
                            {
                              bool1 = bool2;
                              if (paramInt != 1024)
                              {
                                bool1 = bool2;
                                if (paramInt != 1025)
                                {
                                  bool1 = bool2;
                                  if (paramInt != 7220)
                                  {
                                    bool1 = bool2;
                                    if (paramInt != 7120)
                                    {
                                      bool1 = bool2;
                                      if (paramInt != 7200)
                                      {
                                        bool1 = bool2;
                                        if (paramInt != 1008)
                                        {
                                          bool1 = bool2;
                                          if (paramInt != 3001)
                                          {
                                            bool1 = bool2;
                                            if (paramInt != 7210)
                                            {
                                              bool1 = bool2;
                                              if (paramInt != 7230)
                                              {
                                                bool1 = bool2;
                                                if (paramInt != 7)
                                                {
                                                  bool1 = bool2;
                                                  if (paramInt != 6000)
                                                  {
                                                    bool1 = bool2;
                                                    if (paramInt != 6003)
                                                    {
                                                      bool1 = bool2;
                                                      if (paramInt != 7000)
                                                      {
                                                        bool1 = bool2;
                                                        if (paramInt != 10007)
                                                        {
                                                          bool1 = bool2;
                                                          if (paramInt != 10008)
                                                          {
                                                            bool1 = bool2;
                                                            if (paramInt != 10014)
                                                            {
                                                              if (paramInt == 10010) {
                                                                return true;
                                                              }
                                                              bool1 = false;
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean a(int paramInt, String paramString)
  {
    boolean bool = c();
    if (QLog.isColorLevel()) {
      QLog.d("NewMsgNotificationManager", 2, new Object[] { "newMsgNotificationEnabled: invoked. ", " systemNotificationEnabled: ", Boolean.valueOf(bool) });
    }
    if ((!a(paramInt)) && (!b(paramString))) {
      return true;
    }
    return b();
  }
  
  private void b(BaseActivity paramBaseActivity)
  {
    Intent localIntent = JumpToNotificationSettingUtil.a(this.a.getApp());
    if (BaseActivity.sTopActivity != null)
    {
      BaseActivity.sTopActivity.startActivity(localIntent);
      return;
    }
    paramBaseActivity.startActivity(localIntent);
  }
  
  private static boolean b(String paramString)
  {
    return AppConstants.FRIEND_SYSTEM_MSG_UIN.equals(paramString);
  }
  
  private Bitmap c(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("NewMsgNotificationManager", 2, new Object[] { "getBitmapFromLocal: invoked. ", " id: ", Integer.valueOf(i), " iconUrl: ", paramString });
      }
      i = GrowthUtil.a(i);
      paramString = BitmapFactory.decodeResource(this.a.getApp().getResources(), i);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("NewMsgNotificationManager", 2, "getBitmapFromLocal: failed. ", paramString);
      }
    }
    catch (Exception paramString)
    {
      QLog.e("NewMsgNotificationManager", 1, "getBitmapFromLocal: failed. ", paramString);
    }
    return null;
  }
  
  public Bitmap a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return paramBitmap;
    }
    if ("2".equals(paramString1)) {
      return a(paramString2);
    }
    if ("1".equals(paramString1)) {
      return c(paramString2);
    }
    return paramBitmap;
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    NewMsgNotificationManager.3 local3 = new NewMsgNotificationManager.3(this);
    NewMsgNotificationManager.4 local4 = new NewMsgNotificationManager.4(this, paramBaseActivity);
    DialogUtil.a(paramBaseActivity, 230, null, paramBaseActivity.getString(2131891077), paramBaseActivity.getString(2131887648), paramBaseActivity.getString(2131891076), local4, local3).show();
  }
  
  public void a(BaseActivity paramBaseActivity, TextView paramTextView)
  {
    Object localObject = this.a.getApp().getResources();
    int i = paramTextView.getCurrentTextColor();
    String str = ((Resources)localObject).getString(2131892705);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("允许QQ通知");
    localStringBuilder.append(((Resources)localObject).getString(2131892706));
    localObject = new SpannableString(localStringBuilder.toString());
    paramBaseActivity = new NewMsgNotificationManager.2(this, paramBaseActivity);
    int j = str.length();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("允许QQ通知");
    ((SpannableString)localObject).setSpan(paramBaseActivity, j, localStringBuilder.toString().length(), 17);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
    paramTextView.setClickable(true);
    paramTextView.setTextColor(i);
  }
  
  public void a(FormSwitchItem paramFormSwitchItem1, TextView paramTextView, FormSwitchItem paramFormSwitchItem2, FormSwitchItem paramFormSwitchItem3)
  {
    boolean bool1 = c();
    boolean bool2 = this.b;
    int i = 0;
    if (bool1 != bool2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewMsgNotificationManager", 2, new Object[] { "onNotifyPushActivityResume: invoked. ", " curSystemState[系统设置发生了变化]: ", Boolean.valueOf(bool1), " systemNotificationEnabled: ", Boolean.valueOf(this.b) });
      }
      this.b = bool1;
      SettingCloneUtil.writeValue(this.a.getApp(), this.a.getCurrentUin(), null, "system_notification_enabled_key", bool1);
    }
    else
    {
      bool2 = b();
      if (QLog.isColorLevel()) {
        QLog.d("NewMsgNotificationManager", 2, new Object[] { "onNotifyPushActivityResume: invoked. [系统设置未变化]", " curSystemState: ", Boolean.valueOf(bool1), " globalSwitchOn: ", Boolean.valueOf(bool2) });
      }
    }
    paramFormSwitchItem1 = paramFormSwitchItem1.getSwitch();
    paramFormSwitchItem2 = paramFormSwitchItem2.getSwitch();
    paramFormSwitchItem3 = paramFormSwitchItem3.getSwitch();
    if (!bool1)
    {
      paramFormSwitchItem1.setAlpha(0.5F);
      paramFormSwitchItem2.setAlpha(0.5F);
      paramFormSwitchItem3.setAlpha(0.5F);
    }
    else
    {
      paramFormSwitchItem1.setAlpha(1.0F);
      paramFormSwitchItem2.setAlpha(1.0F);
      paramFormSwitchItem3.setAlpha(1.0F);
    }
    if (bool1) {
      i = 8;
    }
    paramTextView.setVisibility(i);
  }
  
  public boolean a()
  {
    if (SettingCloneUtil.isContainValue(this.a.getApp(), this.a.getCurrentUin(), null, "system_notification_enabled_key")) {
      return SettingCloneUtil.readValue(this.a.getApp(), this.a.getCurrentUin(), null, "system_notification_enabled_key", true);
    }
    return c();
  }
  
  public boolean a(Message paramMessage)
  {
    if (paramMessage == null) {
      return true;
    }
    return a(paramMessage.istroop, paramMessage.frienduin);
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return true;
    }
    return a(paramMessageRecord.istroop, paramMessageRecord.frienduin);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewMsgNotificationManager", 2, new Object[] { "needDecodeIcon: invoked. ", " iconType: ", paramString1, " iconUrl: ", paramString2 });
    }
    return (("1".equals(paramString1)) || ("2".equals(paramString1))) && (!TextUtils.isEmpty(paramString2));
  }
  
  public boolean b()
  {
    boolean bool = SettingCloneUtil.readValue(this.a.getApp(), this.a.getCurrentUin(), null, "new_msg_notification_key", true);
    if (QLog.isColorLevel()) {
      QLog.d("NewMsgNotificationManager", 2, new Object[] { "globalSwitchOn: invoked. ", " enable: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public boolean c()
  {
    boolean bool = QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplicationImpl.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("NewMsgNotificationManager", 2, new Object[] { "systemNotificationEnabled: invoked. ", " enable: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public void d()
  {
    this.c = null;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.message.newmsg.NewMsgNotificationManager
 * JD-Core Version:    0.7.0.1
 */