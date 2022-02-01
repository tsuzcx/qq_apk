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
  private long a = 0L;
  private boolean b;
  private List<SFU.UpdateSection> c;
  private QQAppInterface d;
  private SharedPreferences e = null;
  
  public QPUpdateConfig(QQAppInterface paramQQAppInterface)
  {
    this.d = paramQQAppInterface;
    this.c = new ArrayList();
    this.e = this.d.getApp().getSharedPreferences("qp_sfu_config", 0);
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
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals("1")))
    {
      if (paramString1.equals("2")) {
        paramString1 = this.d.getApp().getExternalFilesDir(null).getParent();
      } else {
        paramString1 = "";
      }
    }
    else {
      paramString1 = this.d.getApp().getFilesDir().getParent();
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
  
  private String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d.getApp().getDir("qqprotect", 0).toString());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("SFU/");
    localStringBuilder.append("qp_sfu_config.dat");
    return localStringBuilder.toString();
  }
  
  private boolean b(String paramString)
  {
    try
    {
      Object localObject1 = new ArrayList();
      paramString = new JSONObject(paramString);
      this.a = paramString.getLong("version");
      this.b = paramString.getBoolean("forceupdate");
      JSONArray localJSONArray = paramString.getJSONArray("sections");
      int i = 0;
      paramString = (String)localObject1;
      while (i < localJSONArray.length())
      {
        localObject1 = new SFU.UpdateSection();
        Object localObject2 = localJSONArray.getJSONObject(i);
        ((SFU.UpdateSection)localObject1).a = ((JSONObject)localObject2).getLong("sid");
        ((SFU.UpdateSection)localObject1).b = ((JSONObject)localObject2).getLong("bid");
        ((SFU.UpdateSection)localObject1).c = ((JSONObject)localObject2).getLong("size");
        ((SFU.UpdateSection)localObject1).d = ((JSONObject)localObject2).getString("name");
        ((SFU.UpdateSection)localObject1).e = ((JSONObject)localObject2).getString("md5");
        ((SFU.UpdateSection)localObject1).f = ((JSONObject)localObject2).getString("url");
        ((SFU.UpdateSection)localObject1).g = ((JSONObject)localObject2).getLong("osminver");
        ((SFU.UpdateSection)localObject1).h = ((JSONObject)localObject2).getLong("osmaxver");
        ((SFU.UpdateSection)localObject1).k = ((JSONObject)localObject2).getString("cpuabi");
        ((SFU.UpdateSection)localObject1).i = ((JSONObject)localObject2).getString("qqminver");
        ((SFU.UpdateSection)localObject1).j = ((JSONObject)localObject2).getString("qqmaxver");
        ((SFU.UpdateSection)localObject1).l = ((JSONObject)localObject2).getString("os");
        ((SFU.UpdateSection)localObject1).n = a(((SFU.UpdateSection)localObject1).l, ((SFU.UpdateSection)localObject1).g, ((SFU.UpdateSection)localObject1).h);
        ((SFU.UpdateSection)localObject1).o = c(((SFU.UpdateSection)localObject1).k);
        ((SFU.UpdateSection)localObject1).m = b(((SFU.UpdateSection)localObject1).i, ((SFU.UpdateSection)localObject1).j);
        if (((JSONObject)localObject2).has("flag")) {
          ((SFU.UpdateSection)localObject1).v = ((JSONObject)localObject2).getInt("flag");
        }
        localObject2 = ((JSONObject)localObject2).getJSONArray("files");
        int j = 0;
        while (j < ((JSONArray)localObject2).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(j);
          SFU.FileInfo localFileInfo = new SFU.FileInfo();
          localFileInfo.i = localJSONObject.getLong("size");
          localFileInfo.d = localJSONObject.getString("root");
          localFileInfo.e = localJSONObject.getString("path");
          localFileInfo.a = localJSONObject.getString("name");
          localFileInfo.f = a(localFileInfo.d, localFileInfo.e, localFileInfo.a);
          localFileInfo.b = localJSONObject.getString("md5");
          localFileInfo.j = localJSONObject.getLong("rptid");
          if (localJSONObject.has("extra")) {
            localFileInfo.k = localJSONObject.getString("extra");
          }
          ((SFU.UpdateSection)localObject1).p.add(localFileInfo);
          j += 1;
        }
        paramString.add(localObject1);
        i += 1;
      }
      this.c = paramString;
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
  
  private boolean b(String paramString1, String paramString2)
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
      str = DeviceInfoUtil.a(this.d.getApp());
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      if ((!bool1) || (bool3)) {}
    }
    try
    {
      if (a(str, paramString2) > 0) {
        break label181;
      }
      return true;
    }
    catch (Exception paramString1)
    {
      int i;
      label175:
      label181:
      break label175;
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
    return this.c;
  }
  
  public List<SFU.UpdateSection> a(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.e.getString("last_update_bids", "");
    String str = this.e.getString("last_update_sections", "");
    if ((((String)localObject).indexOf(String.format("#%d#", new Object[] { Long.valueOf(paramLong) })) != -1) && (a(b())) && (!this.c.isEmpty()))
    {
      int i = 0;
      while (i < this.c.size())
      {
        localObject = (SFU.UpdateSection)this.c.get(i);
        if (((SFU.UpdateSection)localObject).b == paramLong) {
          if (str.indexOf(String.format("#%d#", new Object[] { Long.valueOf(((SFU.UpdateSection)localObject).a) })) != -1)
          {
            int j = 0;
            SFU.FileInfo localFileInfo;
            while (j < ((SFU.UpdateSection)localObject).p.size())
            {
              localFileInfo = (SFU.FileInfo)((SFU.UpdateSection)localObject).p.get(j);
              localFileInfo.g = this.e.getString(localFileInfo.f, "");
              j += 1;
            }
            j = 0;
            while (j < ((SFU.UpdateSection)localObject).r.size())
            {
              localFileInfo = (SFU.FileInfo)((SFU.UpdateSection)localObject).r.get(j);
              localFileInfo.g = this.e.getString(localFileInfo.f, "");
              j += 1;
            }
            j = 0;
            while (j < ((SFU.UpdateSection)localObject).q.size())
            {
              localFileInfo = (SFU.FileInfo)((SFU.UpdateSection)localObject).q.get(j);
              localFileInfo.g = this.e.getString(localFileInfo.f, "");
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
    byte[] arrayOfByte = VerifyFileUtil.b(new File(paramString), null);
    if (arrayOfByte != null) {
      return b(new String(arrayOfByte));
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] invalid sig of config: %s", new Object[] { paramString }));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPUpdateConfig
 * JD-Core Version:    0.7.0.1
 */