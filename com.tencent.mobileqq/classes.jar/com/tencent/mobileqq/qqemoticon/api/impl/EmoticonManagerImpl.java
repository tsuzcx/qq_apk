package com.tencent.mobileqq.qqemoticon.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.qqemoticon.api.IEmoticonManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class EmoticonManagerImpl
  implements IEmoticonManager
{
  public static final String TAG = "EmoticonManagerImpl";
  private EmoticonManager mEmoMgr = null;
  
  public String getSmallEmoticonDescription(String paramString1, String paramString2)
  {
    String str = "";
    if (this.mEmoMgr != null) {
      str = this.mEmoMgr.a(paramString1, paramString2);
    }
    return str;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    boolean bool1 = true;
    boolean bool2;
    if (QLog.isColorLevel())
    {
      bool2 = paramAppRuntime instanceof QQAppInterface;
      if (paramAppRuntime != null) {
        break label77;
      }
    }
    for (;;)
    {
      QLog.d("EmoticonManagerImpl", 2, new Object[] { "onCreate is QQApp ", Boolean.valueOf(bool2), "app is null: ", Boolean.valueOf(bool1) });
      if (paramAppRuntime != null) {}
      try
      {
        if (!(paramAppRuntime instanceof NearbyAppInterface)) {
          this.mEmoMgr = ((EmoticonManager)paramAppRuntime.getManager(QQManagerFactory.EMOTICON_MANAGER));
        }
        return;
      }
      catch (Throwable paramAppRuntime)
      {
        label77:
        paramAppRuntime.printStackTrace();
      }
      bool1 = false;
    }
  }
  
  public void onDestroy()
  {
    this.mEmoMgr = null;
  }
  
  public String syncGetEmoticonDescriptionById(String paramString1, String paramString2)
  {
    String str2 = "";
    String str1 = str2;
    if (this.mEmoMgr != null)
    {
      paramString1 = this.mEmoMgr.a(paramString1, paramString2);
      str1 = str2;
      if (paramString1 != null) {
        str1 = paramString1.character;
      }
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqemoticon.api.impl.EmoticonManagerImpl
 * JD-Core Version:    0.7.0.1
 */