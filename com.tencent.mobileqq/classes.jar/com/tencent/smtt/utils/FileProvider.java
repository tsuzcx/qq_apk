package com.tencent.smtt.utils;

import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider
  extends ContentProvider
{
  private static final String[] a = { "_display_name", "_size" };
  private static final File b = new File("/");
  private static HashMap<String, FileProvider.a> c = new HashMap();
  private FileProvider.a d;
  
  private static int a(String paramString)
  {
    if ("r".equals(paramString)) {
      return 268435456;
    }
    if ((!"w".equals(paramString)) && (!"wt".equals(paramString)))
    {
      if ("wa".equals(paramString)) {
        return 704643072;
      }
      if ("rw".equals(paramString)) {
        return 939524096;
      }
      if ("rwt".equals(paramString)) {
        return 1006632960;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid mode: ");
      localStringBuilder.append(paramString);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return 738197504;
  }
  
  static Uri a(Context paramContext, File paramFile)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      String str;
      try
      {
        Object localObject1 = new ComponentName(paramContext.getPackageName(), "android.support.v4.content.FileProvider");
        localObject1 = paramContext.getPackageManager().getProviderInfo((ComponentName)localObject1, 0).authority;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        str = "";
      }
      if (!TextUtils.isEmpty(str)) {
        try
        {
          Object localObject2 = Class.forName("android.support.v4.content.FileProvider");
          if (localObject2 != null)
          {
            localObject2 = ((Class)localObject2).getDeclaredMethod("getUriForFile", new Class[] { Context.class, String.class, File.class });
            if (localObject2 != null)
            {
              paramContext = ((Method)localObject2).invoke(null, new Object[] { paramContext, str, paramFile });
              if ((paramContext instanceof Uri))
              {
                paramContext = (Uri)paramContext;
                return paramContext;
              }
            }
          }
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public static Uri a(Context paramContext, String paramString)
  {
    Uri localUri = null;
    if ((paramContext != null) && (paramContext.getApplicationContext() != null) && ("com.tencent.mobileqq".equals(paramContext.getApplicationContext().getApplicationInfo().packageName))) {
      try
      {
        localObject = Class.forName("com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper");
        paramString = new File(paramString);
        paramContext = (Uri)i.a((Class)localObject, "getUriForFile", new Class[] { Context.class, File.class }, new Object[] { paramContext, paramString });
        return paramContext;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
    }
    Object localObject = localUri;
    if (paramContext != null)
    {
      localObject = localUri;
      if (paramContext.getApplicationInfo().targetSdkVersion >= 24)
      {
        localObject = localUri;
        if (Build.VERSION.SDK_INT >= 24)
        {
          localUri = a(paramContext, new File(paramString));
          localObject = localUri;
          if (localUri == null)
          {
            localObject = localUri;
            if (QbSdk.checkContentProviderPrivilage(paramContext))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramContext.getApplicationInfo().packageName);
              ((StringBuilder)localObject).append(".provider");
              localObject = a(paramContext, ((StringBuilder)localObject).toString(), new File(paramString));
            }
          }
        }
      }
    }
    if (localObject == null) {
      try
      {
        paramContext = Uri.fromFile(new File(paramString));
        return paramContext;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        Log.e("FileProvider", "create uri failed,please check again");
      }
    }
    return localObject;
  }
  
  public static Uri a(Context paramContext, String paramString, File paramFile)
  {
    return b(paramContext, paramString).a(paramFile);
  }
  
  private static File a(File paramFile, String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      File localFile = paramFile;
      if (str != null) {
        localFile = new File(paramFile, str);
      }
      i += 1;
      paramFile = localFile;
    }
    return paramFile;
  }
  
  private static Object[] a(Object[] paramArrayOfObject, int paramInt)
  {
    Object[] arrayOfObject = new Object[paramInt];
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramInt);
    return arrayOfObject;
  }
  
  private static String[] a(String[] paramArrayOfString, int paramInt)
  {
    String[] arrayOfString = new String[paramInt];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramInt);
    return arrayOfString;
  }
  
  private static FileProvider.a b(Context paramContext, String paramString)
  {
    synchronized (c)
    {
      FileProvider.a locala2 = (FileProvider.a)c.get(paramString);
      FileProvider.a locala1 = locala2;
      if (locala2 == null) {
        try
        {
          locala1 = c(paramContext, paramString);
          c.put(paramString, locala1);
        }
        catch (XmlPullParserException paramContext)
        {
          throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", paramContext);
        }
        catch (IOException paramContext)
        {
          throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", paramContext);
        }
      }
      return locala1;
    }
  }
  
  private static FileProvider.a c(Context paramContext, String paramString)
  {
    FileProvider.b localb = new FileProvider.b(paramString);
    paramString = paramContext.getPackageManager().resolveContentProvider(paramString, 128);
    if (paramString != null)
    {
      XmlResourceParser localXmlResourceParser = paramString.loadXmlMetaData(paramContext.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
      if (localXmlResourceParser != null)
      {
        for (;;)
        {
          int i = localXmlResourceParser.next();
          if (i == 1) {
            break;
          }
          if (i == 2)
          {
            String str2 = localXmlResourceParser.getName();
            paramString = null;
            String str1 = localXmlResourceParser.getAttributeValue(null, "name");
            String str3 = localXmlResourceParser.getAttributeValue(null, "path");
            if ("root-path".equals(str2)) {
              paramString = a(b, new String[] { str3 });
            } else if ("files-path".equals(str2)) {
              paramString = a(paramContext.getFilesDir(), new String[] { str3 });
            } else if ("cache-path".equals(str2)) {
              paramString = a(paramContext.getCacheDir(), new String[] { str3 });
            } else if ("external-path".equals(str2)) {
              paramString = a(Environment.getExternalStorageDirectory(), new String[] { str3 });
            }
            if (paramString != null) {
              localb.a(str1, paramString);
            }
          }
        }
        return localb;
      }
      throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    }
    paramContext = new RuntimeException("Must declare com.tencent.smtt.utils.FileProvider in AndroidManifest above Android 7.0,please view document in x5.tencent.com");
    for (;;)
    {
      throw paramContext;
    }
  }
  
  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    super.attachInfo(paramContext, paramProviderInfo);
    if (!paramProviderInfo.exported)
    {
      if (paramProviderInfo.grantUriPermissions)
      {
        this.d = b(paramContext, paramProviderInfo.authority);
        return;
      }
      throw new SecurityException("Provider must grant uri permissions");
    }
    throw new SecurityException("Provider must not be exported");
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public String getType(Uri paramUri)
  {
    paramUri = this.d.a(paramUri);
    int i = paramUri.getName().lastIndexOf('.');
    if (i >= 0)
    {
      paramUri = paramUri.getName().substring(i + 1);
      paramUri = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramUri);
      if (paramUri != null) {
        return paramUri;
      }
    }
    return "application/octet-stream";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("No external inserts");
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    return ParcelFileDescriptor.open(this.d.a(paramUri), a(paramString));
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramString1 = this.d.a(paramUri);
    paramUri = paramArrayOfString1;
    if (paramArrayOfString1 == null) {
      paramUri = a;
    }
    paramArrayOfString2 = new String[paramUri.length];
    paramArrayOfString1 = new Object[paramUri.length];
    int m = paramUri.length;
    int j = 0;
    int k;
    for (int i = 0; j < m; i = k)
    {
      paramString2 = paramUri[j];
      if ("_display_name".equals(paramString2))
      {
        paramArrayOfString2[i] = "_display_name";
        k = i + 1;
        paramArrayOfString1[i] = paramString1.getName();
      }
      for (i = k;; i = k)
      {
        k = i;
        break;
        k = i;
        if (!"_size".equals(paramString2)) {
          break;
        }
        paramArrayOfString2[i] = "_size";
        k = i + 1;
        paramArrayOfString1[i] = Long.valueOf(paramString1.length());
      }
      j += 1;
    }
    paramUri = a(paramArrayOfString2, i);
    paramArrayOfString1 = a(paramArrayOfString1, i);
    paramUri = new MatrixCursor(paramUri, 1);
    paramUri.addRow(paramArrayOfString1);
    return paramUri;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("No external updates");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.utils.FileProvider
 * JD-Core Version:    0.7.0.1
 */