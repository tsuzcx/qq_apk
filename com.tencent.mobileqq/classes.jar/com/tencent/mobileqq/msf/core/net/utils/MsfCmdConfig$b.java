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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(File.separator);
    localObject = ((StringBuilder)localObject).toString();
    String str = BaseApplication.getContext().getFilesDir().getAbsolutePath();
    if ("${FILE_DIR}".equals(paramString))
    {
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(File.separator);
      return paramString.toString();
    }
    if ("${SP_DIR}".equals(paramString))
    {
      paramString = new StringBuilder();
      paramString.append(str.replace("files", "shared_prefs"));
      paramString.append(File.separator);
      return paramString.toString();
    }
    if ("${DATA_DIR}".equals(paramString)) {
      return str.replace("files", "");
    }
    if ("${SDCARD_DIR}".equals(paramString))
    {
      paramString = new StringBuilder();
      paramString.append(Environment.getExternalStorageDirectory().getAbsolutePath());
      paramString.append(File.separator);
      localObject = paramString.toString();
    }
    return localObject;
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
    else if (paramInt == 0)
    {
      paramString1 = a((String)paramArrayList.get(paramInt));
      if ((!TextUtils.isEmpty(paramString1)) && (new File(paramString1).exists())) {
        a(paramArrayList, paramString1, paramInt + 1, paramString2);
      }
    }
    else
    {
      String str = (String)paramArrayList.get(paramInt);
      boolean bool = "plain".equals(paramString2);
      Object localObject = "";
      StringBuilder localStringBuilder;
      if (bool)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append(str);
        if (paramInt == paramArrayList.size() - 1) {
          paramString1 = (String)localObject;
        } else {
          paramString1 = File.separator;
        }
        localStringBuilder.append(paramString1);
        a(paramArrayList, localStringBuilder.toString(), paramInt + 1, paramString2);
        return;
      }
      localObject = new File(paramString1).listFiles(new c(this, str));
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          paramString1 = localObject[i];
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString1.getAbsolutePath());
          if (paramInt == paramArrayList.size() - 1) {
            paramString1 = "";
          } else {
            paramString1 = File.separator;
          }
          localStringBuilder.append(paramString1);
          a(paramArrayList, localStringBuilder.toString(), paramInt + 1, paramString2);
          i += 1;
        }
      }
    }
  }
  
  protected void a(int paramInt, List paramList)
  {
    try
    {
      if (this.d)
      {
        Object localObject = BaseApplication.getContext().getSharedPreferences("file_del_time", 0);
        i = ((SharedPreferences)localObject).getInt("key_delete_version", 0);
        if (i != paramInt)
        {
          localObject = ((SharedPreferences)localObject).edit();
          if (localObject != null)
          {
            ((SharedPreferences.Editor)localObject).putInt("key_delete_version", paramInt);
            ((SharedPreferences.Editor)localObject).commit();
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("One Time Mode,just delete file one times,localversion =");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(",version = ");
          ((StringBuilder)localObject).append(paramInt);
          QLog.d("MsfCmdConfig", 1, ((StringBuilder)localObject).toString());
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("One Time Mode,don't delete file one more times,localversion =");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(",version = ");
          ((StringBuilder)localObject).append(paramInt);
          QLog.d("MsfCmdConfig", 1, ((StringBuilder)localObject).toString());
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      int i;
      QLog.e("MsfCmdConfig", 1, "execute faild", localThrowable);
      QLog.d("MsfCmdConfig", 1, "safe mode delete file");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Pair localPair = (Pair)paramList.next();
        String[] arrayOfString = ((String)localPair.second).split(File.separator);
        ArrayList localArrayList = new ArrayList();
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
        a(localArrayList, "", 0, (String)localPair.first);
      }
    }
  }
  
  protected boolean a()
  {
    return ("rm".equals(this.a)) && (this.b != null) && (this.b.size() > 0);
  }
  
  protected boolean a(Pair paramPair)
  {
    boolean bool2 = this.g.contains(paramPair.first);
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (TextUtils.isEmpty((CharSequence)paramPair.second)) {
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
    if (j >= 2) {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig.b
 * JD-Core Version:    0.7.0.1
 */