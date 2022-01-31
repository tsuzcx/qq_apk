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
  private static final String ATTR_NAME = "name";
  private static final String ATTR_PATH = "path";
  private static final String[] COLUMNS = { "_display_name", "_size" };
  private static final File DEVICE_ROOT = new File("/");
  private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
  private static final String TAG_CACHE_PATH = "cache-path";
  private static final String TAG_EXTERNAL = "external-path";
  private static final String TAG_FILES_PATH = "files-path";
  private static final String TAG_ROOT_PATH = "root-path";
  private static HashMap<String, FileProvider.PathStrategy> sCache = new HashMap();
  private FileProvider.PathStrategy mStrategy;
  
  private static File buildPath(File paramFile, String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    if (i < j)
    {
      String str = paramVarArgs[i];
      if (str == null) {
        break label40;
      }
      paramFile = new File(paramFile, str);
    }
    label40:
    for (;;)
    {
      i += 1;
      break;
      return paramFile;
    }
  }
  
  public static Uri convertFilePathToUri(Context paramContext, String paramString)
  {
    Object localObject;
    if ((paramContext != null) && (paramContext.getApplicationContext() != null) && ("com.tencent.mobileqq".equals(paramContext.getApplicationContext().getApplicationInfo().packageName))) {
      try
      {
        localObject = Class.forName("com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper");
        paramString = new File(paramString);
        localObject = (Uri)ReflectionUtils.invokeStatic((Class)localObject, "getUriForFile", new Class[] { Context.class, File.class }, new Object[] { paramContext, paramString });
        return localObject;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
    }
    if ((paramContext != null) && (paramContext.getApplicationInfo().targetSdkVersion >= 24) && (Build.VERSION.SDK_INT >= 24))
    {
      localObject = getContentUri(paramContext, new File(paramString));
      if ((localObject == null) && (QbSdk.checkContentProviderPrivilage(paramContext))) {
        paramContext = getUriForFile(paramContext, paramContext.getApplicationInfo().packageName + ".provider", new File(paramString));
      }
    }
    for (;;)
    {
      localObject = paramContext;
      if (paramContext != null) {
        break;
      }
      try
      {
        paramString = Uri.fromFile(new File(paramString));
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        Log.e("FileProvider", "create uri failed,please check again");
        return paramContext;
      }
      paramContext = (Context)localObject;
      continue;
      paramContext = null;
    }
  }
  
  private static Object[] copyOf(Object[] paramArrayOfObject, int paramInt)
  {
    Object[] arrayOfObject = new Object[paramInt];
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramInt);
    return arrayOfObject;
  }
  
  private static String[] copyOf(String[] paramArrayOfString, int paramInt)
  {
    String[] arrayOfString = new String[paramInt];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramInt);
    return arrayOfString;
  }
  
  static Uri getContentUri(Context paramContext, File paramFile)
  {
    Object localObject3 = null;
    Object localObject1 = "";
    Object localObject2 = localObject3;
    if (Build.VERSION.SDK_INT >= 24) {}
    try
    {
      localObject2 = new ComponentName(paramContext.getPackageName(), "android.support.v4.content.FileProvider");
      localObject2 = paramContext.getPackageManager().getProviderInfo((ComponentName)localObject2, 0).authority;
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          localObject2 = Class.forName("android.support.v4.content.FileProvider");
          if (localObject2 == null) {
            break;
          }
          localObject2 = ((Class)localObject2).getDeclaredMethod("getUriForFile", new Class[] { Context.class, String.class, File.class });
          if (localObject2 == null) {
            break;
          }
          paramContext = ((Method)localObject2).invoke(null, new Object[] { paramContext, localObject1, paramFile });
          if (!(paramContext instanceof Uri)) {
            break;
          }
          paramContext = (Uri)paramContext;
          localObject2 = paramContext;
          return localObject2;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          return null;
        }
        localException = localException;
        localException.printStackTrace();
      }
    }
    localObject2 = localObject3;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      paramContext = null;
    }
  }
  
  private static FileProvider.PathStrategy getPathStrategy(Context paramContext, String paramString)
  {
    FileProvider.PathStrategy localPathStrategy1;
    synchronized (sCache)
    {
      FileProvider.PathStrategy localPathStrategy2 = (FileProvider.PathStrategy)sCache.get(paramString);
      localPathStrategy1 = localPathStrategy2;
      if (localPathStrategy2 != null) {}
    }
    try
    {
      localPathStrategy1 = parsePathStrategy(paramContext, paramString);
      sCache.put(paramString, localPathStrategy1);
      return localPathStrategy1;
    }
    catch (IOException paramContext)
    {
      throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", paramContext);
      paramContext = finally;
      throw paramContext;
    }
    catch (XmlPullParserException paramContext)
    {
      throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", paramContext);
    }
  }
  
  public static Uri getUriForFile(Context paramContext, String paramString, File paramFile)
  {
    return getPathStrategy(paramContext, paramString).getUriForFile(paramFile);
  }
  
  private static int modeToMode(String paramString)
  {
    if ("r".equals(paramString)) {
      return 268435456;
    }
    if (("w".equals(paramString)) || ("wt".equals(paramString))) {
      return 738197504;
    }
    if ("wa".equals(paramString)) {
      return 704643072;
    }
    if ("rw".equals(paramString)) {
      return 939524096;
    }
    if ("rwt".equals(paramString)) {
      return 1006632960;
    }
    throw new IllegalArgumentException("Invalid mode: " + paramString);
  }
  
  private static FileProvider.PathStrategy parsePathStrategy(Context paramContext, String paramString)
  {
    FileProvider.SimplePathStrategy localSimplePathStrategy = new FileProvider.SimplePathStrategy(paramString);
    paramString = paramContext.getPackageManager().resolveContentProvider(paramString, 128);
    if (paramString == null) {
      throw new RuntimeException("Must declare com.tencent.smtt.utils.FileProvider in AndroidManifest above Android 7.0,please view document in x5.tencent.com");
    }
    XmlResourceParser localXmlResourceParser = paramString.loadXmlMetaData(paramContext.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
    if (localXmlResourceParser == null) {
      throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    }
    label244:
    for (;;)
    {
      int i = localXmlResourceParser.next();
      String str1;
      String str2;
      if (i != 1)
      {
        if (i != 2) {
          continue;
        }
        paramString = localXmlResourceParser.getName();
        str1 = localXmlResourceParser.getAttributeValue(null, "name");
        str2 = localXmlResourceParser.getAttributeValue(null, "path");
        if ("root-path".equals(paramString)) {
          paramString = buildPath(DEVICE_ROOT, new String[] { str2 });
        }
      }
      for (;;)
      {
        if (paramString == null) {
          break label244;
        }
        localSimplePathStrategy.addRoot(str1, paramString);
        break;
        if ("files-path".equals(paramString))
        {
          paramString = buildPath(paramContext.getFilesDir(), new String[] { str2 });
        }
        else if ("cache-path".equals(paramString))
        {
          paramString = buildPath(paramContext.getCacheDir(), new String[] { str2 });
        }
        else if ("external-path".equals(paramString))
        {
          paramString = buildPath(Environment.getExternalStorageDirectory(), new String[] { str2 });
          continue;
          return localSimplePathStrategy;
        }
        else
        {
          paramString = null;
        }
      }
    }
  }
  
  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    super.attachInfo(paramContext, paramProviderInfo);
    if (paramProviderInfo.exported) {
      throw new SecurityException("Provider must not be exported");
    }
    if (!paramProviderInfo.grantUriPermissions) {
      throw new SecurityException("Provider must grant uri permissions");
    }
    this.mStrategy = getPathStrategy(paramContext, paramProviderInfo.authority);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (this.mStrategy.getFileForUri(paramUri).delete()) {
      return 1;
    }
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    paramUri = this.mStrategy.getFileForUri(paramUri);
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
    return ParcelFileDescriptor.open(this.mStrategy.getFileForUri(paramUri), modeToMode(paramString));
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramString1 = this.mStrategy.getFileForUri(paramUri);
    paramUri = paramArrayOfString1;
    if (paramArrayOfString1 == null) {
      paramUri = COLUMNS;
    }
    paramArrayOfString2 = new String[paramUri.length];
    paramArrayOfString1 = new Object[paramUri.length];
    int m = paramUri.length;
    int j = 0;
    int i = 0;
    int k;
    if (j < m)
    {
      paramString2 = paramUri[j];
      if ("_display_name".equals(paramString2))
      {
        paramArrayOfString2[i] = "_display_name";
        k = i + 1;
        paramArrayOfString1[i] = paramString1.getName();
        i = k;
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if ("_size".equals(paramString2))
      {
        paramArrayOfString2[i] = "_size";
        k = i + 1;
        paramArrayOfString1[i] = Long.valueOf(paramString1.length());
        i = k;
        continue;
        paramUri = copyOf(paramArrayOfString2, i);
        paramArrayOfString1 = copyOf(paramArrayOfString1, i);
        paramUri = new MatrixCursor(paramUri, 1);
        paramUri.addRow(paramArrayOfString1);
        return paramUri;
      }
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("No external updates");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.utils.FileProvider
 * JD-Core Version:    0.7.0.1
 */