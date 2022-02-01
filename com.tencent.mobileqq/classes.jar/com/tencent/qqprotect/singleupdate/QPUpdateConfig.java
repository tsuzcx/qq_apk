package com.tencent.qqprotect.singleupdate;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class QPUpdateConfig
{
  private long jdField_a_of_type_Long = 0L;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<SFU.UpdateSection> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public QPUpdateConfig(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("qp_sfu_config", 0);
  }
  
  private int a(String paramString1, String paramString2)
  {
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int i;
    if (paramString1.length < paramString2.length) {
      i = paramString1.length;
    } else {
      i = paramString2.length;
    }
    int j = 0;
    while (j < i)
    {
      int k = Integer.parseInt(paramString1[j]);
      int m = Integer.parseInt(paramString2[j]);
      if (k > m) {
        return 1;
      }
      if (k < m) {
        return -1;
      }
      j += 1;
    }
    return 0;
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getDir("qqprotect", 0).toString());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("SFU/");
    localStringBuilder.append("qp_sfu_config.dat");
    return localStringBuilder.toString();
  }
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals("1")))
    {
      if (paramString1.equals("2")) {
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getExternalFilesDir(null).getParent();
      } else {
        paramString1 = "";
      }
    }
    else {
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getFilesDir().getParent();
    }
    Object localObject = paramString1;
    if (!paramString1.endsWith(File.separator))
    {
      localObject = paramString1;
      if (!paramString2.startsWith(File.separator))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(File.separator);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    paramString1 = new StringBuilder();
    paramString1.append((String)localObject);
    paramString1.append(paramString2);
    paramString1 = paramString1.toString();
    if (paramString2.endsWith(File.separator))
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(paramString3);
      return paramString2.toString();
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append(File.separator);
    paramString2.append(paramString3);
    return paramString2.toString();
  }
  
  private boolean a(String paramString, long paramLong1, long paramLong2)
  {
    if (paramString != null)
    {
      if (!paramString.equals("android")) {
        return false;
      }
      if (paramLong1 >= 0L)
      {
        if (paramLong2 < 0L) {
          return false;
        }
        long l = Build.VERSION.SDK_INT;
        if ((paramLong1 == 0L) && (paramLong2 == 0L)) {
          return true;
        }
        if ((paramLong1 == 0L) && (paramLong2 > 0L)) {
          return l <= paramLong2;
        }
        if ((paramLong1 > 0L) && (paramLong2 == 0L)) {
          return l >= paramLong1;
        }
        if ((paramLong1 > 0L) && (paramLong2 > 0L)) {
          return (l >= paramLong1) && (l <= paramLong2);
        }
      }
    }
    return false;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1;
    boolean bool3;
    String str;
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return false;
      }
      paramString1 = paramString1.replace(" ", "");
      paramString2 = paramString2.replace(" ", "");
      bool1 = paramString1.equals("*");
      bool3 = paramString2.equals("*");
      if ((bool1) && (bool3)) {
        return true;
      }
      str = DeviceInfoUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      if ((!bool1) || (bool3)) {}
    }
    try
    {
      if (a(str, paramString2) > 0) {
        break label177;
      }
      return true;
    }
    catch (Exception paramString1)
    {
      int i;
      label171:
      label177:
      break label171;
    }
    if ((!bool1) && (bool3))
    {
      if (a(str, paramString1) >= 0) {
        return true;
      }
    }
    else
    {
      if ((!bool1) && (!bool3))
      {
        bool1 = bool2;
        if (a(str, paramString2) <= 0)
        {
          i = a(str, paramString1);
          bool1 = bool2;
          if (i >= 0) {
            bool1 = true;
          }
        }
        return bool1;
        paramString1.printStackTrace();
      }
      return false;
      return false;
    }
    return false;
  }
  
  private boolean b(String paramString)
  {
    try
    {
      Object localObject1 = new ArrayList();
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_Long = paramString.getLong("version");
      this.jdField_a_of_type_Boolean = paramString.getBoolean("forceupdate");
      JSONArray localJSONArray = paramString.getJSONArray("sections");
      int i = 0;
      paramString = (String)localObject1;
      while (i < localJSONArray.length())
      {
        localObject1 = new SFU.UpdateSection();
        Object localObject2 = localJSONArray.getJSONObject(i);
        ((SFU.UpdateSection)localObject1).jdField_a_of_type_Long = ((JSONObject)localObject2).getLong("sid");
        ((SFU.UpdateSection)localObject1).jdField_b_of_type_Long = ((JSONObject)localObject2).getLong("bid");
        ((SFU.UpdateSection)localObject1).jdField_c_of_type_Long = ((JSONObject)localObject2).getLong("size");
        ((SFU.UpdateSection)localObject1).jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).getString("name");
        ((SFU.UpdateSection)localObject1).jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).getString("md5");
        ((SFU.UpdateSection)localObject1).jdField_c_of_type_JavaLangString = ((JSONObject)localObject2).getString("url");
        ((SFU.UpdateSection)localObject1).jdField_d_of_type_Long = ((JSONObject)localObject2).getLong("osminver");
        ((SFU.UpdateSection)localObject1).jdField_e_of_type_Long = ((JSONObject)localObject2).getLong("osmaxver");
        ((SFU.UpdateSection)localObject1).f = ((JSONObject)localObject2).getString("cpuabi");
        ((SFU.UpdateSection)localObject1).jdField_d_of_type_JavaLangString = ((JSONObject)localObject2).getString("qqminver");
        ((SFU.UpdateSection)localObject1).jdField_e_of_type_JavaLangString = ((JSONObject)localObject2).getString("qqmaxver");
        ((SFU.UpdateSection)localObject1).g = ((JSONObject)localObject2).getString("os");
        ((SFU.UpdateSection)localObject1).jdField_b_of_type_Boolean = a(((SFU.UpdateSection)localObject1).g, ((SFU.UpdateSection)localObject1).jdField_d_of_type_Long, ((SFU.UpdateSection)localObject1).jdField_e_of_type_Long);
        ((SFU.UpdateSection)localObject1).jdField_c_of_type_Boolean = c(((SFU.UpdateSection)localObject1).f);
        ((SFU.UpdateSection)localObject1).jdField_a_of_type_Boolean = a(((SFU.UpdateSection)localObject1).jdField_d_of_type_JavaLangString, ((SFU.UpdateSection)localObject1).jdField_e_of_type_JavaLangString);
        if (((JSONObject)localObject2).has("flag")) {
          ((SFU.UpdateSection)localObject1).jdField_b_of_type_Int = ((JSONObject)localObject2).getInt("flag");
        }
        localObject2 = ((JSONObject)localObject2).getJSONArray("files");
        int j = 0;
        while (j < ((JSONArray)localObject2).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(j);
          SFU.FileInfo localFileInfo = new SFU.FileInfo();
          localFileInfo.jdField_a_of_type_Long = localJSONObject.getLong("size");
          localFileInfo.jdField_d_of_type_JavaLangString = localJSONObject.getString("root");
          localFileInfo.jdField_e_of_type_JavaLangString = localJSONObject.getString("path");
          localFileInfo.jdField_a_of_type_JavaLangString = localJSONObject.getString("name");
          localFileInfo.f = a(localFileInfo.jdField_d_of_type_JavaLangString, localFileInfo.jdField_e_of_type_JavaLangString, localFileInfo.jdField_a_of_type_JavaLangString);
          localFileInfo.jdField_b_of_type_JavaLangString = localJSONObject.getString("md5");
          localFileInfo.jdField_b_of_type_Long = localJSONObject.getLong("rptid");
          if (localJSONObject.has("extra")) {
            localFileInfo.i = localJSONObject.getString("extra");
          }
          ((SFU.UpdateSection)localObject1).jdField_a_of_type_JavaUtilList.add(localFileInfo);
          j += 1;
        }
        paramString.add(localObject1);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilList = paramString;
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, "[SFU] parsing config error");
      }
    }
    return false;
  }
  
  private boolean c(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    Object localObject = paramString.replace(" ", "");
    if (((String)localObject).equals("*")) {
      return true;
    }
    paramString = Build.CPU_ABI;
    localObject = ((String)localObject).split(",");
    if (localObject == null) {
      return false;
    }
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.contains(localObject[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public List<SFU.UpdateSection> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List<SFU.UpdateSection> a(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("last_update_bids", "");
    String str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("last_update_sections", "");
    if ((((String)localObject).indexOf(String.format("#%d#", new Object[] { Long.valueOf(paramLong) })) != -1) && (a(a())) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (SFU.UpdateSection)this.jdField_a_of_type_JavaUtilList.get(i);
        if (((SFU.UpdateSection)localObject).jdField_b_of_type_Long == paramLong) {
          if (str.indexOf(String.format("#%d#", new Object[] { Long.valueOf(((SFU.UpdateSection)localObject).jdField_a_of_type_Long) })) != -1)
          {
            int j = 0;
            SFU.FileInfo localFileInfo;
            while (j < ((SFU.UpdateSection)localObject).jdField_a_of_type_JavaUtilList.size())
            {
              localFileInfo = (SFU.FileInfo)((SFU.UpdateSection)localObject).jdField_a_of_type_JavaUtilList.get(j);
              localFileInfo.g = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(localFileInfo.f, "");
              j += 1;
            }
            j = 0;
            while (j < ((SFU.UpdateSection)localObject).jdField_c_of_type_JavaUtilList.size())
            {
              localFileInfo = (SFU.FileInfo)((SFU.UpdateSection)localObject).jdField_c_of_type_JavaUtilList.get(j);
              localFileInfo.g = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(localFileInfo.f, "");
              j += 1;
            }
            j = 0;
            while (j < ((SFU.UpdateSection)localObject).jdField_b_of_type_JavaUtilList.size())
            {
              localFileInfo = (SFU.FileInfo)((SFU.UpdateSection)localObject).jdField_b_of_type_JavaUtilList.get(j);
              localFileInfo.g = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(localFileInfo.f, "");
              j += 1;
            }
            localArrayList.add(localObject);
          }
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public boolean a(String paramString)
  {
    byte[] arrayOfByte = VerifyFileUtil.a(new File(paramString), null);
    if (arrayOfByte != null) {
      return b(new String(arrayOfByte));
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] invalid sig of config: %s", new Object[] { paramString }));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPUpdateConfig
 * JD-Core Version:    0.7.0.1
 */