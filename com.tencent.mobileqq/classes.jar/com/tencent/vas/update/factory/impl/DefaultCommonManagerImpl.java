package com.tencent.vas.update.factory.impl;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.vas.update.factory.api.ICommonManager;
import com.tencent.vas.update.util.FileUtil;
import com.tencent.vas.update.util.MD5Utils;

public class DefaultCommonManagerImpl
  implements ICommonManager
{
  public long a()
  {
    return 500L;
  }
  
  public String a(int paramInt, String paramString)
  {
    return FileUtil.unZipFile(paramString);
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return MD5Utils.encodeFileHexStr(paramString);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return FileUtil.filePatch(paramString1, paramString2);
  }
  
  public Context b()
  {
    return null;
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    return FileUtil.copyFile(paramString1, paramString2);
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append("/A_VasUpdateSystem/seq/");
    return localStringBuilder.toString();
  }
  
  public String d()
  {
    return "1.0.0";
  }
  
  public String e()
  {
    return d();
  }
  
  public int f()
  {
    return 1;
  }
  
  public long g()
  {
    return System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.factory.impl.DefaultCommonManagerImpl
 * JD-Core Version:    0.7.0.1
 */