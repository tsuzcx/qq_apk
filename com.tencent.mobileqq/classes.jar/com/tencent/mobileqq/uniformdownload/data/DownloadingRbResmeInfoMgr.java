package com.tencent.mobileqq.uniformdownload.data;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class DownloadingRbResmeInfoMgr
{
  private DownloadingRbResmeInfo a(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("DownloadingRbResmeInfoMgr", 1, "[UniformDL] rBobjectOfString err, str=null");
      return null;
    }
    String[] arrayOfString = paramString.split("\\^");
    if (arrayOfString.length < 4)
    {
      QLog.e("DownloadingRbResmeInfoMgr", 1, "[UniformDL] rBobjectOfString err,l=" + arrayOfString.length + " str=" + paramString);
      return null;
    }
    paramString = new DownloadingRbResmeInfo();
    paramString.jdField_a_of_type_Int = Integer.parseInt(arrayOfString[0]);
    paramString.jdField_a_of_type_JavaLangString = arrayOfString[1];
    paramString.jdField_a_of_type_Long = Long.parseLong(arrayOfString[2]);
    paramString.jdField_a_of_type_Boolean = Boolean.parseBoolean(arrayOfString[3]);
    if (arrayOfString.length > 4)
    {
      paramString.b = arrayOfString[4];
      return paramString;
    }
    paramString.b = paramString.jdField_a_of_type_JavaLangString;
    return paramString;
  }
  
  private String a(DownloadingRbResmeInfo paramDownloadingRbResmeInfo)
  {
    if (paramDownloadingRbResmeInfo == null)
    {
      QLog.e("DownloadingRbResmeInfoMgr", 1, "[UniformDL] stringOfRbObject err, obj=null");
      return null;
    }
    return String.valueOf(paramDownloadingRbResmeInfo.jdField_a_of_type_Int) + "^" + paramDownloadingRbResmeInfo.jdField_a_of_type_JavaLangString + "^" + String.valueOf(paramDownloadingRbResmeInfo.jdField_a_of_type_Long) + "^" + String.valueOf(paramDownloadingRbResmeInfo.jdField_a_of_type_Boolean) + "^" + paramDownloadingRbResmeInfo.b;
  }
  
  public SharedPreferences a()
  {
    return BaseApplication.getContext().getSharedPreferences("downloading_rb_resume_info", 0);
  }
  
  public Map<String, DownloadingRbResmeInfo> a()
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      String str;
      try
      {
        Object localObject1 = a().getAll();
        if (localObject1 != null) {
          QLog.i("DownloadingRbResmeInfoMgr", 1, "[UniformDL] getDownloadingRbResmeInfo, size:[" + ((Map)localObject1).size() + "]");
        }
        if ((localObject1 != null) && (((Map)localObject1).size() > 0))
        {
          localObject1 = ((Map)localObject1).entrySet().iterator();
          if (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
            str = (String)((Map.Entry)localObject2).getKey();
            localObject2 = a((String)((Map.Entry)localObject2).getValue());
            if (localObject2 == null) {
              break label210;
            }
            QLog.i("DownloadingRbResmeInfoMgr", 1, "[UniformDL] getDownloadingRbResmeInfo, url:[" + str + "]] nId:[" + ((DownloadingRbResmeInfo)localObject2).jdField_a_of_type_Int + "] w:[" + ((DownloadingRbResmeInfo)localObject2).jdField_a_of_type_Boolean + "]");
            localHashMap.put(str, localObject2);
            continue;
          }
        }
        return localHashMap;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      label210:
      QLog.e("DownloadingRbResmeInfoMgr", 1, "[UniformDL] getDownloadingRbResmeInfo, value error. url:[" + str + "]");
    }
  }
  
  public void a()
  {
    try
    {
      QLog.i("DownloadingRbResmeInfoMgr", 1, "[UniformDL] clearDownloadingRbResmeInfo...");
      SharedPreferences.Editor localEditor = a().edit();
      localEditor.clear();
      localEditor.apply();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      QLog.i("DownloadingRbResmeInfoMgr", 1, "[UniformDL] removeDownloadingRbResmeInfo, url:[" + paramString + "]");
      SharedPreferences.Editor localEditor = a().edit();
      localEditor.remove(paramString);
      localEditor.apply();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, Bundle paramBundle, int paramInt, boolean paramBoolean)
  {
    try
    {
      QLog.i("DownloadingRbResmeInfoMgr", 1, "[UniformDL] saveDownloadingRbResmeInfo, url:[" + paramString1 + "] nId:[" + paramInt + "] w:[" + paramBoolean + "]");
      SharedPreferences.Editor localEditor = a().edit();
      DownloadingRbResmeInfo localDownloadingRbResmeInfo = new DownloadingRbResmeInfo();
      localDownloadingRbResmeInfo.jdField_a_of_type_Int = paramInt;
      localDownloadingRbResmeInfo.jdField_a_of_type_JavaLangString = paramString2;
      if (!TextUtils.isEmpty(paramString3)) {}
      for (localDownloadingRbResmeInfo.b = paramString3;; localDownloadingRbResmeInfo.b = paramString2)
      {
        localDownloadingRbResmeInfo.jdField_a_of_type_Long = paramLong;
        localDownloadingRbResmeInfo.jdField_a_of_type_Boolean = paramBoolean;
        localDownloadingRbResmeInfo.jdField_a_of_type_AndroidOsBundle = paramBundle;
        localEditor.putString(paramString1, a(localDownloadingRbResmeInfo));
        localEditor.apply();
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.data.DownloadingRbResmeInfoMgr
 * JD-Core Version:    0.7.0.1
 */