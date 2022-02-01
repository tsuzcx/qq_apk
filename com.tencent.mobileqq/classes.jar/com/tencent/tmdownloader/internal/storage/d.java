package com.tencent.tmdownloader.internal.storage;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.b.b;
import java.io.File;
import java.io.FileOutputStream;

public class d
{
  protected String a = null;
  protected String b = null;
  protected FileOutputStream c = null;
  protected byte[] d = null;
  protected long e = 0L;
  protected int f = 0;
  public boolean g = false;
  
  public d(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.e = a();
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getExternalCacheDir();
      if (paramContext != null)
      {
        paramContext = paramContext.getParent();
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      b.a("TMAssistantFile", "getExternalPath failed:", paramContext);
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getSaveFilePath rootDirString=");
    localStringBuilder.append(str);
    Log.i("TMAssistantFile", localStringBuilder.toString());
    if (str == null) {
      return null;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String b()
  {
    Object localObject2 = GlobalUtil.getInstance().getContext();
    if (localObject2 == null) {
      return null;
    }
    boolean bool = c();
    Object localObject1 = a((Context)localObject2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hasExternalStorage=");
    localStringBuilder.append(bool);
    localStringBuilder.append(", externalPath=");
    localStringBuilder.append((String)localObject1);
    b.a("TMAssistantFile", localStringBuilder.toString());
    if ((bool) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      localObject2 = ((Context)localObject2).getPackageName();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("/tencent/TMAssistantSDK/Download/");
      localStringBuilder.append((String)localObject2);
      localObject2 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append((String)localObject2);
      return localStringBuilder.toString();
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(((Context)localObject2).getFilesDir().getAbsolutePath());
    ((StringBuilder)localObject1).append("/TMAssistantSDK/Download");
    return ((StringBuilder)localObject1).toString();
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = b();
    if (paramString == null) {
      return null;
    }
    return paramString;
  }
  
  public static boolean c()
  {
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      return bool;
    }
    catch (Exception localException)
    {
      label11:
      break label11;
    }
    return false;
  }
  
  public long a()
  {
    Object localObject = a(this.b);
    if (localObject != null)
    {
      localObject = new File((String)localObject);
      if (!((File)localObject).exists())
      {
        localObject = c(this.a);
        if (localObject != null)
        {
          localObject = new File((String)localObject);
          if (!((File)localObject).exists()) {
            this.e = 0L;
          } else {
            this.e = ((File)localObject).length();
          }
        }
      }
      else
      {
        this.e = ((File)localObject).length();
      }
      return this.e;
    }
    return 0L;
  }
  
  public String c(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    String str = b();
    if (str == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("/.tmp/");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".tmp");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.storage.d
 * JD-Core Version:    0.7.0.1
 */