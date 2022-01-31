package com.tencent.tmdownloader.internal.storage;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.r;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

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
    this.e = c();
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {}
    String str;
    do
    {
      return null;
      str = d();
      Log.i("TMAssistantFile", "getSaveFilePath rootDirString=" + str);
    } while (str == null);
    return str + File.separator + paramString;
  }
  
  private boolean a(File paramFile1, File paramFile2)
  {
    try
    {
      paramFile1 = new GZIPInputStream(new FileInputStream(paramFile1));
      paramFile2 = new FileOutputStream(paramFile2);
      byte[] arrayOfByte = new byte[4069];
      for (;;)
      {
        int i = paramFile1.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        paramFile2.write(arrayOfByte, 0, i);
      }
      paramFile1.close();
    }
    catch (IOException paramFile1)
    {
      paramFile1.printStackTrace();
      return false;
    }
    paramFile2.flush();
    paramFile2.close();
    return true;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool = false;
    r.c("TMAssistantFile", "enter");
    if ((paramString1 != null) && (paramString2 != null))
    {
      paramString1 = new File(paramString1);
      if (paramString1.exists() == true)
      {
        File localFile = new File(paramString2);
        if (this.g) {
          if (localFile.exists()) {}
        }
        for (bool = a(paramString1, localFile);; bool = paramString1.renameTo(localFile))
        {
          if (bool) {
            GlobalUtil.updateFilePathAuthorized(paramString2);
          }
          r.c("TMAssistantFile", "moveFileFromTmpToSavaPath result: " + bool);
          return bool;
        }
      }
    }
    r.c("TMAssistantFile", "moveFileFromTmpToSavaPath failed ");
    r.c("TMAssistantFile", "exit");
    return false;
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = d();
    } while (paramString == null);
    return paramString;
  }
  
  public static String d()
  {
    Object localObject = GlobalUtil.getInstance().getContext();
    if (localObject == null) {
      return null;
    }
    if (f())
    {
      localObject = ((Context)localObject).getPackageName();
      localObject = "/tencent/TMAssistantSDK/Download/" + (String)localObject;
      return Environment.getExternalStorageDirectory().getAbsolutePath() + (String)localObject;
    }
    return ((Context)localObject).getFilesDir().getAbsolutePath() + "/TMAssistantSDK/Download";
  }
  
  public static boolean f()
  {
    return ("mounted".equals(Environment.getExternalStorageState())) && (Environment.getExternalStorageDirectory().canWrite());
  }
  
  public void a()
  {
    String str = a(this.b);
    r.c("TMAssistantFile", "deleteFile 1 finalFilePathString: " + str);
    if (!TextUtils.isEmpty(str))
    {
      File localFile = new File(str);
      r.c("TMAssistantFile", "deleteFile 2 file: " + localFile);
      if ((localFile != null) && (localFile.exists()))
      {
        boolean bool = localFile.delete();
        r.c("TMAssistantFile", "deleteFile result:" + bool + ",filename:" + str);
      }
    }
    else
    {
      return;
    }
    r.c("TMAssistantFile", "deleteFile 3");
  }
  
  public void b()
  {
    String str = c(this.a);
    r.c("TMAssistantFile", "deleteFile 1 tmpFilePathString: " + str);
    if (!TextUtils.isEmpty(str))
    {
      File localFile = new File(str);
      r.c("TMAssistantFile", "deleteFile 2 file: " + localFile);
      if ((localFile != null) && (localFile.exists()))
      {
        boolean bool = localFile.delete();
        r.c("TMAssistantFile", "deleteFile result:" + bool + ",filename:" + str);
      }
    }
    else
    {
      return;
    }
    r.c("TMAssistantFile", "deleteFile 3");
  }
  
  public long c()
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
      str = d();
    } while (str == null);
    return str + "/.tmp/" + paramString + ".tmp";
  }
  
  public void e()
  {
    a(c(this.a), a(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.storage.d
 * JD-Core Version:    0.7.0.1
 */