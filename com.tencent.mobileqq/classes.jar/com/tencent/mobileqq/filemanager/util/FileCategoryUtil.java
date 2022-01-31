package com.tencent.mobileqq.filemanager.util;

import adpk;
import adpl;
import adpm;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import android.util.TypedValue;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public class FileCategoryUtil
{
  private static Comparator a = new adpk();
  
  public static int a(Context paramContext)
  {
    localObject = null;
    localContext = null;
    int j = 0;
    try
    {
      paramContext = b(paramContext, "1=1 )GROUP BY (_data", null, 0);
      localContext = paramContext;
      localObject = paramContext;
      int i = paramContext.getCount();
      j = i;
      if (paramContext != null)
      {
        paramContext.close();
        j = i;
      }
    }
    catch (Exception paramContext)
    {
      do
      {
        localObject = localContext;
        paramContext.printStackTrace();
      } while (localContext == null);
      localContext.close();
      return 0;
    }
    finally
    {
      if (localObject == null) {
        break label77;
      }
      ((Cursor)localObject).close();
    }
    return j;
  }
  
  private static Cursor a(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    return paramContext.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "bucket_display_name", "_data", "bucket_id", "bucket_display_name" }, paramString, paramArrayOfString, "date_added desc");
  }
  
  public static Drawable a(Context paramContext, String paramString)
  {
    ApplicationInfo localApplicationInfo = null;
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramContext = localPackageManager.getPackageArchiveInfo(paramString, 1);
    if (paramContext == null) {
      paramString = localApplicationInfo;
    }
    for (;;)
    {
      return paramString;
      localApplicationInfo = paramContext.applicationInfo;
      localApplicationInfo.sourceDir = paramString;
      localApplicationInfo.publicSourceDir = paramString;
      for (;;)
      {
        try
        {
          paramString = localPackageManager.getResourcesForApplication(localApplicationInfo);
          localTypedValue = new TypedValue();
          paramString.getValue(localApplicationInfo.icon, localTypedValue, true);
          str = localTypedValue.string.toString();
        }
        catch (PackageManager.NameNotFoundException paramContext)
        {
          TypedValue localTypedValue;
          String str;
          paramContext = null;
          continue;
          continue;
        }
        try
        {
          paramContext = Drawable.createFromResourceStream(paramString, localTypedValue, new BufferedInputStream(paramString.getAssets().openNonAssetFd(localTypedValue.assetCookie, str).createInputStream()), null);
          if (paramContext == null)
          {
            try
            {
              AssetManager localAssetManager = paramString.getAssets();
              Method localMethod = localAssetManager.getClass().getDeclaredMethod("openNonAsset", new Class[] { Integer.TYPE, String.class, Integer.TYPE });
              localMethod.setAccessible(true);
              paramString = Drawable.createFromResourceStream(paramString, localTypedValue, (InputStream)localMethod.invoke(localAssetManager, new Object[] { Integer.valueOf(localTypedValue.assetCookie), str, Integer.valueOf(2) }), null);
              paramContext = paramString;
              paramString = paramContext;
            }
            catch (Exception localException)
            {
              paramString = paramContext;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("qfile", 2, localException.getMessage() + "---------- apk icon null, can not find openNonAsset method");
              paramString = paramContext;
              continue;
            }
            catch (PackageManager.NameNotFoundException paramString)
            {
              continue;
            }
            paramContext = paramString;
            paramString = paramContext;
            if (paramContext != null) {
              break;
            }
            return localApplicationInfo.loadIcon(localPackageManager);
          }
        }
        catch (Exception paramContext)
        {
          if (QLog.isColorLevel()) {
            QLog.i("qfile", 2, paramContext.getMessage() + "---------- apk icon null, will get icon with reflect");
          }
          paramContext = null;
        }
      }
    }
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    PackageManager localPackageManager = BaseApplicationImpl.getContext().getPackageManager();
    PackageInfo localPackageInfo = localPackageManager.getPackageArchiveInfo(paramString, 1);
    if (localPackageInfo != null) {
      return localPackageInfo.applicationInfo.loadLabel(localPackageManager).toString();
    }
    return FileManagerUtil.a(paramString);
  }
  
  public static List a(Context paramContext)
  {
    localArrayList = new ArrayList();
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getInstalledPackages(1024);
      int i = 0;
      while (i < paramContext.size())
      {
        PackageInfo localPackageInfo = (PackageInfo)paramContext.get(i);
        int j = localPackageInfo.applicationInfo.flags;
        ApplicationInfo localApplicationInfo = localPackageInfo.applicationInfo;
        if (((j & 0x1) <= 0) && (FileUtil.a(localPackageInfo.applicationInfo.publicSourceDir))) {
          localArrayList.add(localPackageInfo);
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramContext) {}
  }
  
  @TargetApi(9)
  public static List a(Context paramContext, QfileBaseTabView paramQfileBaseTabView)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = a(paramContext);
    paramContext = paramContext.getPackageManager();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      PackageInfo localPackageInfo = (PackageInfo)((Iterator)localObject).next();
      try
      {
        FileInfo localFileInfo = new FileInfo(localPackageInfo.applicationInfo.publicSourceDir);
        localFileInfo.b(5);
        localFileInfo.d(localPackageInfo.applicationInfo.loadLabel(paramContext).toString());
        localFileInfo.c(localPackageInfo.applicationInfo.packageName + ".apk");
        if (Build.VERSION.SDK_INT >= 9) {
          localFileInfo.b(localPackageInfo.lastUpdateTime);
        }
        localFileInfo.a("已安装");
        localArrayList.add(localFileInfo);
        if (paramQfileBaseTabView != null) {
          paramQfileBaseTabView.a(localFileInfo);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    Collections.sort(localArrayList, a);
    return localArrayList;
  }
  
  public static Map a(Context paramContext)
  {
    paramContext = a(paramContext, "1=1 )GROUP BY (_data", 0);
    if (paramContext != null) {
      a(paramContext);
    }
    return paramContext;
  }
  
  /* Error */
  public static Map a(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: aload_1
    //   5: aconst_null
    //   6: iload_2
    //   7: invokestatic 26	com/tencent/mobileqq/filemanager/util/FileCategoryUtil:b	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   10: astore_0
    //   11: aload_0
    //   12: astore_1
    //   13: aload_0
    //   14: iconst_0
    //   15: invokestatic 341	com/tencent/mobileqq/filemanager/util/FileCategoryUtil:a	(Landroid/database/Cursor;I)Ljava/util/Map;
    //   18: astore_3
    //   19: aload_3
    //   20: astore_1
    //   21: aload_0
    //   22: ifnull +11 -> 33
    //   25: aload_0
    //   26: invokeinterface 35 1 0
    //   31: aload_3
    //   32: astore_1
    //   33: aload_1
    //   34: areturn
    //   35: astore_3
    //   36: aconst_null
    //   37: astore_0
    //   38: aload_0
    //   39: astore_1
    //   40: aload_3
    //   41: invokevirtual 38	java/lang/Exception:printStackTrace	()V
    //   44: aload 4
    //   46: astore_1
    //   47: aload_0
    //   48: ifnull -15 -> 33
    //   51: aload_0
    //   52: invokeinterface 35 1 0
    //   57: aconst_null
    //   58: areturn
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull +9 -> 72
    //   66: aload_1
    //   67: invokeinterface 35 1 0
    //   72: aload_0
    //   73: athrow
    //   74: astore_0
    //   75: goto -13 -> 62
    //   78: astore_3
    //   79: goto -41 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramContext	Context
    //   0	82	1	paramString	String
    //   0	82	2	paramInt	int
    //   18	14	3	localMap	Map
    //   35	6	3	localException1	Exception
    //   78	1	3	localException2	Exception
    //   1	44	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	11	35	java/lang/Exception
    //   3	11	59	finally
    //   13	19	74	finally
    //   40	44	74	finally
    //   13	19	78	java/lang/Exception
  }
  
  private static Map a(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.getCount() <= 0) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    int i;
    int j;
    int k;
    int m;
    String str2;
    switch (paramInt)
    {
    default: 
      i = 0;
      j = 0;
      k = 0;
      m = 0;
      if (SystemUtil.a()) {
        str2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath() + File.separator + "Camera";
      }
      break;
    }
    for (;;)
    {
      label100:
      if (paramCursor.moveToNext())
      {
        Object localObject = paramCursor.getString(m);
        int n = paramCursor.getInt(k);
        paramCursor.getInt(j);
        String str1;
        if (paramInt != 1) {
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && ((((String)localObject).contains(str2)) || (((String)localObject).contains("/storage/sdcard1/DCIM/Camera")))) {
            str1 = "camera";
          }
        }
        for (;;)
        {
          if (localObject == null) {
            break label100;
          }
          localObject = FileInfo.a((String)localObject);
          if (localObject == null) {
            break label100;
          }
          ((FileInfo)localObject).a(n);
          ((FileInfo)localObject).b(paramInt);
          ((FileInfo)localObject).a(str1);
          if (!localHashMap.containsKey(str1)) {
            localHashMap.put(str1, new ArrayList());
          }
          ((List)localHashMap.get(str1)).add(localObject);
          break label100;
          m = paramCursor.getColumnIndexOrThrow("_data");
          k = paramCursor.getColumnIndexOrThrow("_id");
          i = 0;
          j = 0;
          break;
          m = paramCursor.getColumnIndexOrThrow("_data");
          k = paramCursor.getColumnIndexOrThrow("_id");
          j = paramCursor.getColumnIndexOrThrow("bucket_id");
          i = paramCursor.getColumnIndexOrThrow("bucket_display_name");
          break;
          m = paramCursor.getColumnIndexOrThrow("_data");
          k = paramCursor.getColumnIndexOrThrow("_id");
          j = paramCursor.getColumnIndexOrThrow("bucket_id");
          i = paramCursor.getColumnIndexOrThrow("bucket_display_name");
          break;
          str1 = paramCursor.getString(i);
          continue;
          str1 = "音乐";
        }
      }
      return localHashMap;
      str2 = "/storage/emulated/0/DCIM/Camera";
    }
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    while ((paramFileManagerEntity.nFileType != 5) || (paramFileManagerEntity.getCloudType() != 3)) {
      return;
    }
    ThreadManager.post(new adpl(paramFileManagerEntity), 8, null, false);
  }
  
  public static void a(Map paramMap)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext()) {
        Collections.sort((List)paramMap.get((String)localIterator.next()), a);
      }
    }
  }
  
  public static void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, HashMap paramHashMap, QfileBaseTabView paramQfileBaseTabView)
  {
    if (paramString1 == null) {}
    do
    {
      for (;;)
      {
        return;
        if ((paramQfileBaseTabView == null) || (!paramQfileBaseTabView.c())) {
          try
          {
            Thread.sleep(0L);
            File localFile = new File(paramString1);
            if (localFile.isDirectory())
            {
              if (localFile.getName().indexOf(".") == 0) {
                continue;
              }
              paramString1 = localFile.listFiles();
              if (paramString1 == null) {
                continue;
              }
              int i = 0;
              while (i < paramString1.length)
              {
                if ((!new File(paramString1[i].getAbsolutePath()).isDirectory()) || (paramBoolean)) {
                  a(paramBoolean, paramString1[i].getAbsolutePath(), paramString2, paramString3, paramHashMap, paramQfileBaseTabView);
                }
                i += 1;
              }
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              localInterruptedException.printStackTrace();
            }
            if (QLog.isColorLevel()) {
              QLog.i("scanFileList", 2, "inFilter[" + paramString2 + "],outOfFilter[" + paramString3 + "],path[" + paramString1 + "]");
            }
            String str = FileUtil.a(paramString1);
            Object localObject = str;
            if (paramString2 != null)
            {
              localObject = str;
              if (paramString2.length() > 0)
              {
                if ((str == null) || (str.length() <= 1)) {
                  continue;
                }
                localObject = str.toLowerCase();
                if (paramString2.indexOf((String)localObject) < 0) {
                  continue;
                }
              }
            }
            paramString2 = (String)localObject;
            if (localObject != null)
            {
              paramString2 = (String)localObject;
              if (((String)localObject).length() > 1)
              {
                paramString2 = (String)localObject;
                if (paramString3 != null)
                {
                  paramString2 = (String)localObject;
                  if (paramString3.length() > 0)
                  {
                    paramString2 = ((String)localObject).toLowerCase();
                    if (paramString3.indexOf(paramString2) >= 0) {
                      continue;
                    }
                  }
                }
              }
            }
            paramString1 = FileInfo.a(paramString1);
          }
        }
      }
    } while (paramString1 == null);
    if (!paramHashMap.containsKey(paramString2)) {
      paramHashMap.put(paramString2, new ArrayList());
    }
    if (paramQfileBaseTabView != null) {
      paramQfileBaseTabView.a(paramString1);
    }
    ((List)paramHashMap.get(paramString2)).add(paramString1);
  }
  
  public static boolean a(String paramString, FileCategoryUtil.GetApkPackageInfoCallback paramGetApkPackageInfoCallback)
  {
    if (paramString == null) {
      return false;
    }
    FileManagerUtil.FileExecutor.a().execute(new adpm(paramString, paramGetApkPackageInfoCallback));
    return true;
  }
  
  public static int b(Context paramContext)
  {
    localObject = null;
    localContext = null;
    int j = 0;
    try
    {
      paramContext = c(paramContext, "1=1 )GROUP BY (_data", null, 0);
      localContext = paramContext;
      localObject = paramContext;
      int i = paramContext.getCount();
      j = i;
      if (paramContext != null)
      {
        paramContext.close();
        j = i;
      }
    }
    catch (Exception paramContext)
    {
      do
      {
        localObject = localContext;
        paramContext.printStackTrace();
      } while (localContext == null);
      localContext.close();
      return 0;
    }
    finally
    {
      if (localObject == null) {
        break label77;
      }
      ((Cursor)localObject).close();
    }
    return j;
  }
  
  private static Cursor b(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    return paramContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "_data", "bucket_id", "bucket_display_name" }, paramString, paramArrayOfString, "date_added desc");
  }
  
  public static Map b(Context paramContext)
  {
    paramContext = b(paramContext, "1=1 )GROUP BY (_data", 0);
    if (paramContext != null) {
      a(paramContext);
    }
    return paramContext;
  }
  
  /* Error */
  public static Map b(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: aload_1
    //   5: aconst_null
    //   6: iload_2
    //   7: invokestatic 520	com/tencent/mobileqq/filemanager/util/FileCategoryUtil:a	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   10: astore_0
    //   11: aload_0
    //   12: astore_1
    //   13: aload_0
    //   14: iconst_2
    //   15: invokestatic 341	com/tencent/mobileqq/filemanager/util/FileCategoryUtil:a	(Landroid/database/Cursor;I)Ljava/util/Map;
    //   18: astore_3
    //   19: aload_3
    //   20: astore_1
    //   21: aload_0
    //   22: ifnull +11 -> 33
    //   25: aload_0
    //   26: invokeinterface 35 1 0
    //   31: aload_3
    //   32: astore_1
    //   33: aload_1
    //   34: areturn
    //   35: astore_3
    //   36: aconst_null
    //   37: astore_0
    //   38: aload_0
    //   39: astore_1
    //   40: aload_3
    //   41: invokevirtual 38	java/lang/Exception:printStackTrace	()V
    //   44: aload 4
    //   46: astore_1
    //   47: aload_0
    //   48: ifnull -15 -> 33
    //   51: aload_0
    //   52: invokeinterface 35 1 0
    //   57: aconst_null
    //   58: areturn
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull +9 -> 72
    //   66: aload_1
    //   67: invokeinterface 35 1 0
    //   72: aload_0
    //   73: athrow
    //   74: astore_0
    //   75: goto -13 -> 62
    //   78: astore_3
    //   79: goto -41 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramContext	Context
    //   0	82	1	paramString	String
    //   0	82	2	paramInt	int
    //   18	14	3	localMap	Map
    //   35	6	3	localException1	Exception
    //   78	1	3	localException2	Exception
    //   1	44	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	11	35	java/lang/Exception
    //   3	11	59	finally
    //   13	19	74	finally
    //   40	44	74	finally
    //   13	19	78	java/lang/Exception
  }
  
  public static int c(Context paramContext)
  {
    localObject = null;
    localContext = null;
    int j = 0;
    try
    {
      paramContext = a(paramContext, "1=1 )GROUP BY (_data", null, 0);
      localContext = paramContext;
      localObject = paramContext;
      int i = paramContext.getCount();
      j = i;
      if (paramContext != null)
      {
        paramContext.close();
        j = i;
      }
    }
    catch (Exception paramContext)
    {
      do
      {
        localObject = localContext;
        paramContext.printStackTrace();
      } while (localContext == null);
      localContext.close();
      return 0;
    }
    finally
    {
      if (localObject == null) {
        break label77;
      }
      ((Cursor)localObject).close();
    }
    return j;
  }
  
  private static Cursor c(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    return paramContext.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "_display_name", "_data" }, paramString, paramArrayOfString, "date_added desc");
  }
  
  public static Map c(Context paramContext)
  {
    paramContext = c(paramContext, "1=1 )GROUP BY (_data", 0);
    if (paramContext != null) {
      a(paramContext);
    }
    return paramContext;
  }
  
  /* Error */
  public static Map c(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: aload_1
    //   5: aconst_null
    //   6: iload_2
    //   7: invokestatic 513	com/tencent/mobileqq/filemanager/util/FileCategoryUtil:c	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   10: astore_0
    //   11: aload_0
    //   12: astore_1
    //   13: aload_0
    //   14: iconst_1
    //   15: invokestatic 341	com/tencent/mobileqq/filemanager/util/FileCategoryUtil:a	(Landroid/database/Cursor;I)Ljava/util/Map;
    //   18: astore_3
    //   19: aload_3
    //   20: astore_1
    //   21: aload_0
    //   22: ifnull +11 -> 33
    //   25: aload_0
    //   26: invokeinterface 35 1 0
    //   31: aload_3
    //   32: astore_1
    //   33: aload_1
    //   34: areturn
    //   35: astore_3
    //   36: aconst_null
    //   37: astore_0
    //   38: aload_0
    //   39: astore_1
    //   40: aload_3
    //   41: invokevirtual 38	java/lang/Exception:printStackTrace	()V
    //   44: aload 4
    //   46: astore_1
    //   47: aload_0
    //   48: ifnull -15 -> 33
    //   51: aload_0
    //   52: invokeinterface 35 1 0
    //   57: aconst_null
    //   58: areturn
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull +9 -> 72
    //   66: aload_1
    //   67: invokeinterface 35 1 0
    //   72: aload_0
    //   73: athrow
    //   74: astore_0
    //   75: goto -13 -> 62
    //   78: astore_3
    //   79: goto -41 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramContext	Context
    //   0	82	1	paramString	String
    //   0	82	2	paramInt	int
    //   18	14	3	localMap	Map
    //   35	6	3	localException1	Exception
    //   78	1	3	localException2	Exception
    //   1	44	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	11	35	java/lang/Exception
    //   3	11	59	finally
    //   13	19	74	finally
    //   40	44	74	finally
    //   13	19	78	java/lang/Exception
  }
  
  public static int d(Context paramContext)
  {
    return a(paramContext).size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileCategoryUtil
 * JD-Core Version:    0.7.0.1
 */