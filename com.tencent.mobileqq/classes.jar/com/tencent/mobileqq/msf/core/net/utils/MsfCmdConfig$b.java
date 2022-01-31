package com.tencent.mobileqq.msf.core.net.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class MsfCmdConfig$b
  extends MsfCmdConfig.a
{
  private static final String e = "file_del_time";
  private static final String f = "key_delete_version";
  private boolean d;
  private final Set g = new b(this);
  
  MsfCmdConfig$b(String paramString, List paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(null);
    this.a = paramString;
    this.b = paramList;
    this.c = paramBoolean1;
    this.d = paramBoolean2;
  }
  
  private String a(String paramString)
  {
    String str1 = File.separator + paramString + File.separator;
    String str2 = BaseApplication.getContext().getFilesDir().getAbsolutePath();
    if ("${FILE_DIR}".equals(paramString)) {
      str1 = str2 + File.separator;
    }
    do
    {
      return str1;
      if ("${SP_DIR}".equals(paramString)) {
        return str2.replace("files", "shared_prefs") + File.separator;
      }
      if ("${DATA_DIR}".equals(paramString)) {
        return str2.replace("files", "");
      }
    } while (!"${SDCARD_DIR}".equals(paramString));
    return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
  }
  
  private void a(ArrayList paramArrayList, String paramString1, int paramInt, String paramString2)
  {
    if (paramInt >= paramArrayList.size())
    {
      paramArrayList = new File(paramString1);
      if ((paramArrayList.isFile()) && (paramArrayList.exists()))
      {
        paramArrayList.delete();
        MsfPullConfigUtil.showToastForSafeModeTest("执行删除文件指令，修复闪退");
      }
    }
    Object localObject;
    do
    {
      do
      {
        return;
        if (paramInt != 0) {
          break;
        }
        paramString1 = a((String)paramArrayList.get(paramInt));
      } while ((TextUtils.isEmpty(paramString1)) || (!new File(paramString1).exists()));
      a(paramArrayList, paramString1, paramInt + 1, paramString2);
      return;
      localObject = (String)paramArrayList.get(paramInt);
      if ("plain".equals(paramString2))
      {
        localObject = new StringBuilder().append(paramString1).append((String)localObject);
        if (paramInt == paramArrayList.size() - 1) {}
        for (paramString1 = "";; paramString1 = File.separator)
        {
          a(paramArrayList, paramString1, paramInt + 1, paramString2);
          return;
        }
      }
      localObject = new File(paramString1).listFiles(new c(this, (String)localObject));
    } while ((localObject == null) || (localObject.length <= 0));
    int j = localObject.length;
    int i = 0;
    label212:
    StringBuilder localStringBuilder;
    if (i < j)
    {
      paramString1 = localObject[i];
      localStringBuilder = new StringBuilder().append(paramString1.getAbsolutePath());
      if (paramInt != paramArrayList.size() - 1) {
        break label282;
      }
    }
    label282:
    for (paramString1 = "";; paramString1 = File.separator)
    {
      a(paramArrayList, paramString1, paramInt + 1, paramString2);
      i += 1;
      break label212;
      break;
    }
  }
  
  protected void a(int paramInt, List paramList)
  {
    try
    {
      if (this.d)
      {
        localObject = BaseApplication.getContext().getSharedPreferences("file_del_time", 0);
        i = ((SharedPreferences)localObject).getInt("key_delete_version", 0);
        if (i == paramInt) {
          break label201;
        }
        localObject = ((SharedPreferences)localObject).edit();
        if (localObject != null)
        {
          ((SharedPreferences.Editor)localObject).putInt("key_delete_version", paramInt);
          ((SharedPreferences.Editor)localObject).commit();
        }
        QLog.d("MsfCmdConfig", 1, "One Time Mode,just delete file one times,localversion =" + i + ",version = " + paramInt);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject;
        int i;
        String[] arrayOfString;
        ArrayList localArrayList;
        label201:
        QLog.e("MsfCmdConfig", 1, "execute faild", localThrowable);
        continue;
        a(localArrayList, "", 0, (String)localThrowable.first);
      }
    }
    QLog.d("MsfCmdConfig", 1, "safe mode delete file");
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      localObject = (Pair)paramList.next();
      arrayOfString = ((String)((Pair)localObject).second).split(File.separator);
      localArrayList = new ArrayList();
      i = arrayOfString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        String str = arrayOfString[paramInt];
        if (!TextUtils.isEmpty(str)) {
          localArrayList.add(str);
        }
        paramInt += 1;
      }
      QLog.d("MsfCmdConfig", 1, "One Time Mode,don't delete file one more times,localversion =" + i + ",version = " + paramInt);
    }
  }
  
  protected boolean a()
  {
    return ("rm".equals(this.a)) && (this.b != null) && (this.b.size() > 0);
  }
  
  protected boolean a(Pair paramPair)
  {
    if (!this.g.contains(paramPair.first)) {}
    while (TextUtils.isEmpty((CharSequence)paramPair.second)) {
      return false;
    }
    paramPair = ((String)paramPair.second).split(File.separator);
    int m = paramPair.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (!TextUtils.isEmpty(paramPair[i])) {
        k = j + 1;
      }
      i += 1;
    }
    if (j >= 2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig.b
 * JD-Core Version:    0.7.0.1
 */