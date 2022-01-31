package com.tencent.tmdownloader.internal.storage;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.tencent.tmassistantbase.util.GlobalUtil;
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
    if (c())
    {
      localObject = ((Context)localObject).getPackageName();
      localObject = "/tencent/TMAssistantSDK/Download/" + (String)localObject;
      return Environment.getExternalStorageDirectory().getAbsolutePath() + (String)localObject;
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
    return ("mounted".equals(Environment.getExternalStorageState())) && (Environment.getExternalStorageDirectory().canWrite());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.storage.d
 * JD-Core Version:    0.7.0.1
 */