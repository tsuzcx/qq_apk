package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.haoliyou.orion.XorCipher;
import com.tencent.mobileqq.haoliyou.orion.XorCipherException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class JumpForwardPkgManager
{
  private static JumpForwardPkgManager jdField_a_of_type_ComTencentMobileqqUtilsJumpForwardPkgManager;
  private ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  private JumpForwardPkgManager()
  {
    String str = a();
    int i = a();
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("LocalConfig: version= ");
        localStringBuilder.append(i);
        QLog.d("JumpForwardPkgManager", 2, localStringBuilder.toString());
      }
      b(str);
    }
  }
  
  public static int a()
  {
    return BaseApplication.getContext().getSharedPreferences("jump_pkg_toast_cfg_798", 4).getInt("jump_pkg_toast_cfg_version", 0);
  }
  
  public static JumpForwardPkgManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqUtilsJumpForwardPkgManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqUtilsJumpForwardPkgManager == null) {
          jdField_a_of_type_ComTencentMobileqqUtilsJumpForwardPkgManager = new JumpForwardPkgManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqUtilsJumpForwardPkgManager;
  }
  
  private static String a()
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("jump_pkg_toast_cfg", 4);
    if (!TextUtils.isEmpty(((SharedPreferences)localObject).getString("short_video_res_config_key", ""))) {
      ((SharedPreferences)localObject).edit().putString("short_video_res_config_key", "").commit();
    }
    localObject = BaseApplication.getContext().getSharedPreferences("jump_pkg_toast_cfg_798", 4).getString("short_video_res_config_key", "");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      localObject = XorCipher.b((String)localObject);
      return localObject;
    }
    catch (XorCipherException localXorCipherException) {}
    return null;
    return "";
  }
  
  public static String a(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      if (paramActivity.isFinishing()) {
        return null;
      }
      if (Build.VERSION.SDK_INT < 22) {}
    }
    try
    {
      localObject = Class.forName("android.app.Activity").getDeclaredField("mReferrer");
      ((Field)localObject).setAccessible(true);
      localObject = (String)((Field)localObject).get(paramActivity);
      localObject = a().a((String)localObject);
      bool = TextUtils.isEmpty((CharSequence)localObject);
      if (!bool) {
        return localObject;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          boolean bool;
          localObject = paramActivity.getReferrer();
          if (localObject != null)
          {
            localObject = ((Uri)localObject).getAuthority();
            localObject = a().a((String)localObject);
            bool = TextUtils.isEmpty((CharSequence)localObject);
            if (!bool) {
              return localObject;
            }
          }
        }
        catch (Exception localException2)
        {
          Object localObject;
          String str;
          continue;
        }
        try
        {
          str = paramActivity.getCallingPackage();
          localObject = str;
          if (TextUtils.isEmpty(str))
          {
            paramActivity = paramActivity.getCallingActivity();
            localObject = str;
            if (paramActivity != null) {
              localObject = paramActivity.getPackageName();
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramActivity = a().a((String)localObject);
            return paramActivity;
          }
          return null;
        }
        catch (Exception paramActivity) {}
        localException1 = localException1;
      }
    }
    return null;
  }
  
  public static HashSet<String> a(Activity paramActivity)
  {
    HashSet localHashSet;
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      localHashSet = new HashSet();
      if (Build.VERSION.SDK_INT < 22) {}
    }
    try
    {
      Object localObject = Class.forName("android.app.Activity").getDeclaredField("mReferrer");
      ((Field)localObject).setAccessible(true);
      localObject = (String)((Field)localObject).get(paramActivity);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localHashSet.add(localObject);
      }
      try
      {
        label68:
        localObject = paramActivity.getReferrer();
        if (localObject != null)
        {
          localObject = ((Uri)localObject).getAuthority();
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localHashSet.add(localObject);
          }
        }
      }
      catch (Exception localException2)
      {
        label95:
        String str;
        label138:
        break label95;
      }
      try
      {
        str = paramActivity.getCallingPackage();
        localObject = str;
        if (TextUtils.isEmpty(str))
        {
          paramActivity = paramActivity.getCallingActivity();
          localObject = str;
          if (paramActivity != null) {
            localObject = paramActivity.getPackageName();
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localHashSet.add(localObject);
        }
      }
      catch (Exception paramActivity)
      {
        break label138;
      }
      if (QLog.isColorLevel()) {
        QLog.d("JumpForwardPkgManager", 2, "getCallerReferrerPkg :");
      }
      return localHashSet;
      return null;
    }
    catch (Exception localException1)
    {
      break label68;
    }
  }
  
  public static final boolean a(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      if (paramActivity.isFinishing()) {
        return false;
      }
      if ((a().a()) && (!TextUtils.isEmpty(a(paramActivity))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpForwardPkgManager", 2, "needHidePreview true");
        }
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("jump_pkg_toast_cfg_798", 4).edit();
    try
    {
      paramString = XorCipher.a(paramString);
      localEditor.putString("short_video_res_config_key", paramString);
      localEditor.putInt("jump_pkg_toast_cfg_version", paramInt);
      return localEditor.commit();
    }
    catch (XorCipherException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  private boolean b(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONArray(paramString);
        int j = paramString.length();
        if (j <= 0) {
          return false;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        i = 0;
        if (i < j)
        {
          Object localObject = paramString.getJSONObject(i);
          String str = ((JSONObject)localObject).optString("pkgName");
          localObject = ((JSONObject)localObject).optString("toastWording");
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject);
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("parseConfigData list size= ");
            paramString.append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
            QLog.d("JumpForwardPkgManager", 2, paramString.toString());
          }
          return true;
        }
      }
      catch (Exception paramString)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        if (QLog.isColorLevel()) {
          QLog.d("JumpForwardPkgManager", 2, "parseConfigData[JSONException]", paramString);
        }
        return false;
      }
      i += 1;
    }
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("JumpForwardPkgManager", 2, "getPkgShareToast: ");
    }
    ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localConcurrentHashMap != null)
    {
      if (localConcurrentHashMap.size() == 0) {
        return null;
      }
      return (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearConfig list size= ");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      QLog.d("JumpForwardPkgManager", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    a("", paramInt);
  }
  
  public void a(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("updateConfigFromServer|received version: ");
      paramContext.append(paramInt);
      QLog.d("JumpForwardPkgManager", 2, paramContext.toString());
    }
    if (TextUtils.isEmpty(paramString))
    {
      a(paramInt);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("updateConfigFromServer| version=");
        paramContext.append(paramInt);
        paramContext.append(",config_content is null, clear");
        QLog.d("JumpForwardPkgManager", 2, paramContext.toString());
      }
    }
    else if (b(paramString))
    {
      boolean bool = a(paramString, paramInt);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("updateConfigFromServer| saveContentOK=");
        paramContext.append(bool);
        QLog.d("JumpForwardPkgManager", 2, paramContext.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("JumpForwardPkgManager", 2, "updateConfigFromServer| parseConfigData false");
    }
  }
  
  public boolean a()
  {
    ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    return (localConcurrentHashMap != null) && (localConcurrentHashMap.size() > 0);
  }
  
  public boolean a(String paramString)
  {
    boolean bool;
    for (;;)
    {
      try
      {
        String str = Uri.parse(paramString).getHost();
        if (!TextUtils.isEmpty(paramString))
        {
          if (TextUtils.isEmpty(str)) {
            return false;
          }
          if (a())
          {
            if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
              break label123;
            }
            if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
              break label118;
            }
            break label123;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("JumpForwardPkgManager", 2, new Object[] { "contain :", Boolean.valueOf(bool) });
            return bool;
          }
          if (QLog.isColorLevel()) {
            QLog.d("JumpForwardPkgManager", 2, "needCheckPkg false");
          }
        }
        return false;
      }
      catch (Throwable paramString)
      {
        QLog.e("JumpForwardPkgManager", 1, paramString, new Object[0]);
        return false;
      }
      label118:
      bool = false;
      continue;
      label123:
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpForwardPkgManager
 * JD-Core Version:    0.7.0.1
 */