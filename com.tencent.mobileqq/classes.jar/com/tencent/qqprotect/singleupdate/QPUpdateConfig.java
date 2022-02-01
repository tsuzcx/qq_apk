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
    int j;
    if (paramString1.length < paramString2.length)
    {
      i = paramString1.length;
      j = 0;
    }
    for (;;)
    {
      if (j >= i) {
        break label84;
      }
      int k = Integer.parseInt(paramString1[j]);
      int m = Integer.parseInt(paramString2[j]);
      if (k > m)
      {
        return 1;
        i = paramString2.length;
        break;
      }
      if (k < m) {
        return -1;
      }
      j += 1;
    }
    label84:
    return 0;
  }
  
  private String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getDir("qqprotect", 0).toString() + File.separator + "SFU/" + "qp_sfu_config.dat";
  }
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    String str = "";
    if ((TextUtils.isEmpty(paramString1)) || (paramString1.equals("1"))) {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getFilesDir().getParent();
    }
    for (;;)
    {
      paramString1 = str;
      if (!str.endsWith(File.separator))
      {
        paramString1 = str;
        if (!paramString2.startsWith(File.separator)) {
          paramString1 = str + File.separator;
        }
      }
      paramString1 = paramString1 + paramString2;
      if (!paramString2.endsWith(File.separator)) {
        break;
      }
      return paramString1 + paramString3;
      if (paramString1.equals("2")) {
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getExternalFilesDir(null).getParent();
      }
    }
    return paramString1 + File.separator + paramString3;
  }
  
  private boolean a(String paramString, long paramLong1, long paramLong2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramString == null) || (!paramString.equals("android"))) {
      bool1 = false;
    }
    long l;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            if ((paramLong1 < 0L) || (paramLong2 < 0L)) {
              return false;
            }
            l = Build.VERSION.SDK_INT;
            if (paramLong1 != 0L) {
              break;
            }
            bool1 = bool2;
          } while (paramLong2 == 0L);
          if ((paramLong1 != 0L) || (paramLong2 <= 0L)) {
            break;
          }
          bool1 = bool2;
        } while (l <= paramLong2);
        return false;
        if ((paramLong1 <= 0L) || (paramLong2 != 0L)) {
          break;
        }
        bool1 = bool2;
      } while (l >= paramLong1);
      return false;
      if ((paramLong1 <= 0L) || (paramLong2 <= 0L)) {
        break label147;
      }
      if (l < paramLong1) {
        break;
      }
      bool1 = bool2;
    } while (l <= paramLong2);
    return false;
    label147:
    return false;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramString1 == null) || (paramString2 == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        for (;;)
        {
          return bool1;
          paramString1 = paramString1.replace(" ", "");
          paramString2 = paramString2.replace(" ", "");
          boolean bool3 = paramString1.equals("*");
          boolean bool4 = paramString2.equals("*");
          String str;
          if (bool3)
          {
            bool1 = bool2;
            if (bool4) {}
          }
          else
          {
            str = DeviceInfoUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
            if (TextUtils.isEmpty(str)) {
              return false;
            }
            if ((bool3) && (!bool4)) {
              bool1 = bool2;
            }
          }
          try
          {
            if (a(str, paramString2) > 0) {
              return false;
            }
          }
          catch (Exception paramString1)
          {
            int i;
            paramString1.printStackTrace();
          }
        }
        if ((bool3) || (!bool4)) {
          break;
        }
        bool1 = bool2;
      } while (a(str, paramString1) >= 0);
      return false;
      if ((bool3) || (bool4)) {
        break label182;
      }
      if (a(str, paramString2) > 0) {
        break;
      }
      i = a(str, paramString1);
      bool1 = bool2;
    } while (i >= 0);
    return false;
    label182:
    return false;
  }
  
  private boolean b(String paramString)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_Long = paramString.getLong("version");
      this.jdField_a_of_type_Boolean = paramString.getBoolean("forceupdate");
      paramString = paramString.getJSONArray("sections");
      int i = 0;
      while (i < paramString.length())
      {
        SFU.UpdateSection localUpdateSection = new SFU.UpdateSection();
        Object localObject = paramString.getJSONObject(i);
        localUpdateSection.jdField_a_of_type_Long = ((JSONObject)localObject).getLong("sid");
        localUpdateSection.jdField_b_of_type_Long = ((JSONObject)localObject).getLong("bid");
        localUpdateSection.jdField_c_of_type_Long = ((JSONObject)localObject).getLong("size");
        localUpdateSection.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("name");
        localUpdateSection.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).getString("md5");
        localUpdateSection.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).getString("url");
        localUpdateSection.jdField_d_of_type_Long = ((JSONObject)localObject).getLong("osminver");
        localUpdateSection.jdField_e_of_type_Long = ((JSONObject)localObject).getLong("osmaxver");
        localUpdateSection.f = ((JSONObject)localObject).getString("cpuabi");
        localUpdateSection.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).getString("qqminver");
        localUpdateSection.jdField_e_of_type_JavaLangString = ((JSONObject)localObject).getString("qqmaxver");
        localUpdateSection.g = ((JSONObject)localObject).getString("os");
        localUpdateSection.jdField_b_of_type_Boolean = a(localUpdateSection.g, localUpdateSection.jdField_d_of_type_Long, localUpdateSection.jdField_e_of_type_Long);
        localUpdateSection.jdField_c_of_type_Boolean = c(localUpdateSection.f);
        localUpdateSection.jdField_a_of_type_Boolean = a(localUpdateSection.jdField_d_of_type_JavaLangString, localUpdateSection.jdField_e_of_type_JavaLangString);
        if (((JSONObject)localObject).has("flag")) {
          localUpdateSection.jdField_b_of_type_Int = ((JSONObject)localObject).getInt("flag");
        }
        localObject = ((JSONObject)localObject).getJSONArray("files");
        int j = 0;
        while (j < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
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
          localUpdateSection.jdField_a_of_type_JavaUtilList.add(localFileInfo);
          j += 1;
        }
        localArrayList.add(localUpdateSection);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilList = localArrayList;
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
    if (paramString == null) {}
    for (;;)
    {
      return false;
      Object localObject = paramString.replace(" ", "");
      if (((String)localObject).equals("*")) {
        return true;
      }
      paramString = Build.CPU_ABI;
      localObject = ((String)localObject).split(",");
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (paramString.contains(localObject[i])) {
            return true;
          }
          i += 1;
        }
      }
    }
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
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (SFU.UpdateSection)this.jdField_a_of_type_JavaUtilList.get(i);
        if (((SFU.UpdateSection)localObject).jdField_b_of_type_Long == paramLong) {
          if (str.indexOf(String.format("#%d#", new Object[] { Long.valueOf(((SFU.UpdateSection)localObject).jdField_a_of_type_Long) })) != -1) {
            break label167;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label167:
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
    }
    return localArrayList;
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    byte[] arrayOfByte = VerifyFileUtil.a(new File(paramString), null);
    if (arrayOfByte != null) {
      bool = b(new String(arrayOfByte));
    }
    while (!QLog.isColorLevel()) {
      return bool;
    }
    QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] invalid sig of config: %s", new Object[] { paramString }));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPUpdateConfig
 * JD-Core Version:    0.7.0.1
 */