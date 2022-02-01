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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL] rBobjectOfString err,l=");
      localStringBuilder.append(arrayOfString.length);
      localStringBuilder.append(" str=");
      localStringBuilder.append(paramString);
      QLog.e("DownloadingRbResmeInfoMgr", 1, localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramDownloadingRbResmeInfo.jdField_a_of_type_Int));
    localStringBuilder.append("^");
    localStringBuilder.append(paramDownloadingRbResmeInfo.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("^");
    localStringBuilder.append(String.valueOf(paramDownloadingRbResmeInfo.jdField_a_of_type_Long));
    localStringBuilder.append("^");
    localStringBuilder.append(String.valueOf(paramDownloadingRbResmeInfo.jdField_a_of_type_Boolean));
    localStringBuilder.append("^");
    localStringBuilder.append(paramDownloadingRbResmeInfo.b);
    return localStringBuilder.toString();
  }
  
  public SharedPreferences a()
  {
    return BaseApplication.getContext().getSharedPreferences("downloading_rb_resume_info", 0);
  }
  
  public Map<String, DownloadingRbResmeInfo> a()
  {
    localHashMap = new HashMap();
    try
    {
      Object localObject1 = a().getAll();
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[UniformDL] getDownloadingRbResmeInfo, size:[");
        ((StringBuilder)localObject2).append(((Map)localObject1).size());
        ((StringBuilder)localObject2).append("]");
        QLog.i("DownloadingRbResmeInfoMgr", 1, ((StringBuilder)localObject2).toString());
      }
      if ((localObject1 != null) && (((Map)localObject1).size() > 0))
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
          localObject2 = (String)((Map.Entry)localObject3).getKey();
          localObject3 = a((String)((Map.Entry)localObject3).getValue());
          if (localObject3 != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[UniformDL] getDownloadingRbResmeInfo, url:[");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append("]] nId:[");
            localStringBuilder.append(((DownloadingRbResmeInfo)localObject3).jdField_a_of_type_Int);
            localStringBuilder.append("] w:[");
            localStringBuilder.append(((DownloadingRbResmeInfo)localObject3).jdField_a_of_type_Boolean);
            localStringBuilder.append("]");
            QLog.i("DownloadingRbResmeInfoMgr", 1, localStringBuilder.toString());
            localHashMap.put(localObject2, localObject3);
          }
          else
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("[UniformDL] getDownloadingRbResmeInfo, value error. url:[");
            ((StringBuilder)localObject3).append((String)localObject2);
            ((StringBuilder)localObject3).append("]");
            QLog.e("DownloadingRbResmeInfoMgr", 1, ((StringBuilder)localObject3).toString());
          }
        }
      }
      return localHashMap;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[UniformDL] removeDownloadingRbResmeInfo, url:[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.i("DownloadingRbResmeInfoMgr", 1, ((StringBuilder)localObject).toString());
      localObject = a().edit();
      ((SharedPreferences.Editor)localObject).remove(paramString);
      ((SharedPreferences.Editor)localObject).apply();
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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[UniformDL] saveDownloadingRbResmeInfo, url:[");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("] nId:[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("] w:[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.i("DownloadingRbResmeInfoMgr", 1, ((StringBuilder)localObject).toString());
      localObject = a().edit();
      DownloadingRbResmeInfo localDownloadingRbResmeInfo = new DownloadingRbResmeInfo();
      localDownloadingRbResmeInfo.jdField_a_of_type_Int = paramInt;
      localDownloadingRbResmeInfo.jdField_a_of_type_JavaLangString = paramString2;
      if (!TextUtils.isEmpty(paramString3)) {
        localDownloadingRbResmeInfo.b = paramString3;
      } else {
        localDownloadingRbResmeInfo.b = paramString2;
      }
      localDownloadingRbResmeInfo.jdField_a_of_type_Long = paramLong;
      localDownloadingRbResmeInfo.jdField_a_of_type_Boolean = paramBoolean;
      localDownloadingRbResmeInfo.jdField_a_of_type_AndroidOsBundle = paramBundle;
      ((SharedPreferences.Editor)localObject).putString(paramString1, a(localDownloadingRbResmeInfo));
      ((SharedPreferences.Editor)localObject).apply();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.data.DownloadingRbResmeInfoMgr
 * JD-Core Version:    0.7.0.1
 */