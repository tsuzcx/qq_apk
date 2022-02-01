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
    String str = "";
    try
    {
      File localFile = paramContext.getExternalCacheDir();
      paramContext = str;
      if (localFile != null) {
        paramContext = localFile.getParent();
      }
      return paramContext;
    }
    catch (Exception paramContext)
    {
      b.a("TMAssistantFile", "getExternalPath failed:", paramContext);
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {}
    String str;
    do
    {
      return null;
      str = b();
      Log.i("TMAssistantFile", "getSaveFilePath rootDirString=" + str);
    } while (str == null);
    return str + File.separator + paramString;
  }
  
  public static String b()
  {
    Object localObject = GlobalUtil.getInstance().getContext();
    if (localObject == null) {
      return null;
    }
    boolean bool = c();
    String str = a((Context)localObject);
    b.a("TMAssistantFile", "hasExternalStorage=" + bool + ", externalPath=" + str);
    if ((bool) && (!TextUtils.isEmpty(str)))
    {
      localObject = ((Context)localObject).getPackageName();
      localObject = "/tencent/TMAssistantSDK/Download/" + (String)localObject;
      return str + (String)localObject;
    }
    return ((Context)localObject).getFilesDir().getAbsolutePath() + "/TMAssistantSDK/Download";
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = b();
    } while (paramString == null);
    return paramString;
  }
  
  public static boolean c()
  {
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public long a()
  {
    long l = 0L;
    Object localObject = a(this.b);
    if (localObject != null)
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {
        break label82;
      }
      localObject = c(this.a);
      if (localObject != null)
      {
        localObject = new File((String)localObject);
        if (((File)localObject).exists()) {
          break label71;
        }
        this.e = 0L;
      }
    }
    for (;;)
    {
      l = this.e;
      return l;
      label71:
      this.e = ((File)localObject).length();
      continue;
      label82:
      this.e = ((File)localObject).length();
    }
  }
  
  public String c(String paramString)
  {
    if (paramString == null) {}
    String str;
    do
    {
      return null;
      str = b();
    } while (str == null);
    return str + "/.tmp/" + paramString + ".tmp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.storage.d
 * JD-Core Version:    0.7.0.1
 */