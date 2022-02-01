package com.tencent.mobileqq.filemanager.util;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.api.ITabViewEvent;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.SkinnableNinePatchDrawable;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
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
  private static Comparator<FileInfo> a = new FileCategoryUtil.1();
  
  /* Error */
  public static int a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: aconst_null
    //   5: astore 4
    //   7: aconst_null
    //   8: astore 5
    //   10: aload_0
    //   11: ldc 23
    //   13: aconst_null
    //   14: iconst_0
    //   15: invokestatic 27	com/tencent/mobileqq/filemanager/util/FileCategoryUtil:b	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   18: astore_0
    //   19: aload_0
    //   20: astore 5
    //   22: aload_0
    //   23: astore 4
    //   25: aload_0
    //   26: invokeinterface 33 1 0
    //   31: istore_1
    //   32: iload_1
    //   33: istore_2
    //   34: aload_0
    //   35: ifnull +37 -> 72
    //   38: aload_0
    //   39: invokeinterface 36 1 0
    //   44: iload_1
    //   45: ireturn
    //   46: astore_0
    //   47: goto +27 -> 74
    //   50: astore_0
    //   51: aload 4
    //   53: astore 5
    //   55: aload_0
    //   56: invokevirtual 39	java/lang/Exception:printStackTrace	()V
    //   59: aload 4
    //   61: ifnull +11 -> 72
    //   64: iload_3
    //   65: istore_1
    //   66: aload 4
    //   68: astore_0
    //   69: goto -31 -> 38
    //   72: iload_2
    //   73: ireturn
    //   74: aload 5
    //   76: ifnull +10 -> 86
    //   79: aload 5
    //   81: invokeinterface 36 1 0
    //   86: goto +5 -> 91
    //   89: aload_0
    //   90: athrow
    //   91: goto -2 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramContext	Context
    //   31	35	1	i	int
    //   1	72	2	j	int
    //   3	62	3	k	int
    //   5	62	4	localContext1	Context
    //   8	72	5	localContext2	Context
    // Exception table:
    //   from	to	target	type
    //   10	19	46	finally
    //   25	32	46	finally
    //   55	59	46	finally
    //   10	19	50	java/lang/Exception
    //   25	32	50	java/lang/Exception
  }
  
  private static Cursor a(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    return paramContext.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "bucket_display_name", "_data", "bucket_id", "bucket_display_name" }, paramString, paramArrayOfString, "date_added desc");
  }
  
  public static Drawable a(Context paramContext, String paramString)
  {
    try
    {
      Object localObject = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 1);
      if (localObject != null)
      {
        if (((PackageInfo)localObject).applicationInfo == null) {
          return null;
        }
        localObject = ((PackageInfo)localObject).applicationInfo;
        AssetManager localAssetManager = (AssetManager)AssetManager.class.newInstance();
        new ReflectBuilder().a(8192).a(true).a("addAssetPath").a(AssetManager.class, localAssetManager).a(new Class[] { String.class }).a(new Object[] { paramString }).a();
        paramContext = new Resources(localAssetManager, paramContext.getResources().getDisplayMetrics(), paramContext.getResources().getConfiguration()).getDrawable(((ApplicationInfo)localObject).icon);
        try
        {
          if (a(paramContext)) {
            return null;
          }
          paramString = paramContext;
          if (Build.VERSION.SDK_INT < 26) {
            return paramString;
          }
          paramString = paramContext;
          if (!(paramContext instanceof AdaptiveIconDrawable)) {
            return paramString;
          }
          paramString = (AdaptiveIconDrawable)paramContext;
          boolean bool = a(paramString.getForeground(), paramString.getBackground());
          paramString = paramContext;
          if (!bool) {
            return paramString;
          }
          return null;
        }
        catch (NoSuchMethodException paramString) {}catch (InvocationTargetException paramString)
        {
          break label211;
        }
        catch (ReflectBuilder.WrongParamException paramString)
        {
          break label220;
        }
        catch (IllegalAccessException paramString)
        {
          break label229;
        }
        catch (InstantiationException paramString)
        {
          break label238;
        }
      }
      else
      {
        return null;
      }
    }
    catch (NoSuchMethodException paramString)
    {
      paramContext = null;
      paramString.printStackTrace();
      return paramContext;
    }
    catch (InvocationTargetException paramString)
    {
      paramContext = null;
      paramString.printStackTrace();
      return paramContext;
    }
    catch (ReflectBuilder.WrongParamException paramString)
    {
      paramContext = null;
      paramString.printStackTrace();
      return paramContext;
    }
    catch (IllegalAccessException paramString)
    {
      paramContext = null;
      paramString.printStackTrace();
      return paramContext;
    }
    catch (InstantiationException paramString)
    {
      label211:
      label220:
      label229:
      paramContext = null;
      label238:
      paramString.printStackTrace();
      paramString = paramContext;
    }
    return paramString;
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    PackageManager localPackageManager = BaseApplication.getContext().getPackageManager();
    PackageInfo localPackageInfo = localPackageManager.getPackageArchiveInfo(paramString, 1);
    if (localPackageInfo != null) {
      return localPackageInfo.applicationInfo.loadLabel(localPackageManager).toString();
    }
    return QQFileManagerUtil.e(paramString);
  }
  
  public static List<PackageInfo> a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
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
        if (((j & 0x1) <= 0) && (FileUtils.fileExists(localPackageInfo.applicationInfo.publicSourceDir))) {
          localArrayList.add(localPackageInfo);
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramContext) {}
    return localArrayList;
  }
  
  @TargetApi(9)
  public static List<FileInfo> a(Context paramContext, ITabViewEvent paramITabViewEvent)
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localPackageInfo.applicationInfo.packageName);
        localStringBuilder.append(".apk");
        localFileInfo.c(localStringBuilder.toString());
        if (Build.VERSION.SDK_INT >= 9) {
          localFileInfo.b(localPackageInfo.lastUpdateTime);
        }
        localFileInfo.a(HardCodeUtil.a(2131692289));
        localArrayList.add(localFileInfo);
        if (paramITabViewEvent != null) {
          paramITabViewEvent.a(localFileInfo);
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
  
  public static Map<String, List<FileInfo>> a(Context paramContext)
  {
    paramContext = a(paramContext, null, 0);
    if (paramContext != null) {
      a(paramContext);
    }
    return paramContext;
  }
  
  /* Error */
  public static Map<String, List<FileInfo>> a(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: aload_1
    //   8: aconst_null
    //   9: iload_2
    //   10: invokestatic 27	com/tencent/mobileqq/filemanager/util/FileCategoryUtil:b	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   13: astore_0
    //   14: aload_0
    //   15: astore_1
    //   16: aload_0
    //   17: iconst_0
    //   18: invokestatic 325	com/tencent/mobileqq/filemanager/util/FileCategoryUtil:a	(Landroid/database/Cursor;I)Ljava/util/Map;
    //   21: astore_3
    //   22: aload_3
    //   23: astore_1
    //   24: aload_0
    //   25: ifnull +47 -> 72
    //   28: aload_0
    //   29: invokeinterface 36 1 0
    //   34: aload_3
    //   35: areturn
    //   36: astore_0
    //   37: goto +37 -> 74
    //   40: astore_3
    //   41: goto +12 -> 53
    //   44: astore_0
    //   45: aconst_null
    //   46: astore_1
    //   47: goto +27 -> 74
    //   50: astore_3
    //   51: aconst_null
    //   52: astore_0
    //   53: aload_0
    //   54: astore_1
    //   55: aload_3
    //   56: invokevirtual 39	java/lang/Exception:printStackTrace	()V
    //   59: aload 5
    //   61: astore_1
    //   62: aload_0
    //   63: ifnull +9 -> 72
    //   66: aload 4
    //   68: astore_3
    //   69: goto -41 -> 28
    //   72: aload_1
    //   73: areturn
    //   74: aload_1
    //   75: ifnull +9 -> 84
    //   78: aload_1
    //   79: invokeinterface 36 1 0
    //   84: goto +5 -> 89
    //   87: aload_0
    //   88: athrow
    //   89: goto -2 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramContext	Context
    //   0	92	1	paramString	String
    //   0	92	2	paramInt	int
    //   21	14	3	localMap	Map
    //   40	1	3	localException1	Exception
    //   50	6	3	localException2	Exception
    //   68	1	3	localObject1	Object
    //   4	63	4	localObject2	Object
    //   1	59	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   16	22	36	finally
    //   55	59	36	finally
    //   16	22	40	java/lang/Exception
    //   6	14	44	finally
    //   6	14	50	java/lang/Exception
  }
  
  private static Map<String, List<FileInfo>> a(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.getCount() <= 0) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    int m = 0;
    int i;
    int j;
    int k;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          i = 0;
          j = 0;
          k = 0;
        }
        else
        {
          m = paramCursor.getColumnIndexOrThrow("_data");
          k = paramCursor.getColumnIndexOrThrow("_id");
          j = paramCursor.getColumnIndexOrThrow("bucket_id");
          i = paramCursor.getColumnIndexOrThrow("bucket_display_name");
        }
      }
      else
      {
        m = paramCursor.getColumnIndexOrThrow("_data");
        k = paramCursor.getColumnIndexOrThrow("_id");
        i = 0;
        j = 0;
      }
    }
    else
    {
      m = paramCursor.getColumnIndexOrThrow("_data");
      k = paramCursor.getColumnIndexOrThrow("_id");
      j = paramCursor.getColumnIndexOrThrow("bucket_id");
      i = paramCursor.getColumnIndexOrThrow("bucket_display_name");
    }
    Object localObject1;
    String str;
    if (SystemUtil.a())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath());
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("Camera");
      str = ((StringBuilder)localObject1).toString();
    }
    else
    {
      str = "/storage/emulated/0/DCIM/Camera";
    }
    while (paramCursor.moveToNext())
    {
      Object localObject2 = paramCursor.getString(m);
      int n = paramCursor.getInt(k);
      paramCursor.getInt(j);
      if (paramInt != 1)
      {
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ((((String)localObject2).contains(str)) || (((String)localObject2).contains("/storage/sdcard1/DCIM/Camera")))) {
          localObject1 = "camera";
        } else {
          localObject1 = paramCursor.getString(i);
        }
      }
      else {
        localObject1 = HardCodeUtil.a(2131692584);
      }
      if (localObject2 != null)
      {
        localObject2 = FileInfo.a((String)localObject2);
        if (localObject2 != null)
        {
          ((FileInfo)localObject2).a(n);
          ((FileInfo)localObject2).b(paramInt);
          ((FileInfo)localObject2).a((String)localObject1);
          if (!localHashMap.containsKey(localObject1)) {
            localHashMap.put(localObject1, new ArrayList());
          }
          ((List)localHashMap.get(localObject1)).add(localObject2);
        }
      }
    }
    return localHashMap;
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return;
    }
    if (paramFileManagerEntity.nFileType != 5) {
      return;
    }
    if (paramFileManagerEntity.getCloudType() != 3) {
      return;
    }
    ThreadManager.post(new FileCategoryUtil.2(paramFileManagerEntity), 8, null, false);
  }
  
  public static void a(Map<String, List<FileInfo>> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext()) {
      Collections.sort((List)paramMap.get((String)localIterator.next()), a);
    }
  }
  
  public static void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, HashMap<String, List<FileInfo>> paramHashMap, ITabViewEvent paramITabViewEvent)
  {
    if (paramString1 == null) {
      return;
    }
    if ((paramITabViewEvent != null) && (paramITabViewEvent.d())) {
      return;
    }
    try
    {
      Thread.sleep(0L);
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
    Object localObject = new File(paramString1);
    if (((File)localObject).isDirectory())
    {
      if (((File)localObject).getName().indexOf(".") == 0) {
        return;
      }
      paramString1 = ((File)localObject).listFiles();
      if (paramString1 == null) {
        return;
      }
      int i = 0;
      while (i < paramString1.length)
      {
        if ((!new File(paramString1[i].getAbsolutePath()).isDirectory()) || (paramBoolean)) {
          a(paramBoolean, paramString1[i].getAbsolutePath(), paramString2, paramString3, paramHashMap, paramITabViewEvent);
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("inFilter[");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("],outOfFilter[");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append("],path[");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("]");
      QLog.i("scanFileList", 2, ((StringBuilder)localObject).toString());
    }
    String str = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getExtension(paramString1);
    localObject = str;
    if (paramString2 != null)
    {
      localObject = str;
      if (paramString2.length() > 0) {
        if (str != null)
        {
          if (str.length() <= 1) {
            return;
          }
          str = str.toLowerCase();
          localObject = str;
          if (paramString2.indexOf(str) >= 0) {}
        }
        else
        {
          return;
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
            localObject = ((String)localObject).toLowerCase();
            paramString2 = (String)localObject;
            if (paramString3.indexOf((String)localObject) >= 0) {
              return;
            }
          }
        }
      }
    }
    paramString1 = FileInfo.a(paramString1);
    if (paramString1 == null) {
      return;
    }
    if (!paramHashMap.containsKey(paramString2)) {
      paramHashMap.put(paramString2, new ArrayList());
    }
    if (paramITabViewEvent != null) {
      paramITabViewEvent.a(paramString1);
    }
    ((List)paramHashMap.get(paramString2)).add(paramString1);
  }
  
  private static boolean a(Drawable paramDrawable)
  {
    boolean bool = true;
    if (paramDrawable == null) {
      return true;
    }
    if (!(paramDrawable instanceof SkinnableBitmapDrawable))
    {
      if ((paramDrawable instanceof SkinnableNinePatchDrawable)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private static boolean a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramDrawable1 != null)
    {
      if (paramDrawable2 == null) {
        return true;
      }
      bool1 = bool2;
      if (!(paramDrawable1 instanceof SkinnableBitmapDrawable))
      {
        bool1 = bool2;
        if (!(paramDrawable1 instanceof SkinnableNinePatchDrawable))
        {
          bool1 = bool2;
          if (!(paramDrawable2 instanceof SkinnableNinePatchDrawable))
          {
            if ((paramDrawable2 instanceof SkinnableBitmapDrawable)) {
              return true;
            }
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString, GetApkPackageInfoCallback paramGetApkPackageInfoCallback)
  {
    if (paramString == null) {
      return false;
    }
    QQFileManagerUtil.FileExecutor.a().execute(new FileCategoryUtil.3(paramString, paramGetApkPackageInfoCallback));
    return true;
  }
  
  public static int b(Context paramContext)
  {
    return a(paramContext).size();
  }
  
  private static Cursor b(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    return paramContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "_data", "bucket_id", "bucket_display_name" }, paramString, paramArrayOfString, "date_added desc");
  }
  
  public static Map<String, List<FileInfo>> b(Context paramContext)
  {
    paramContext = b(paramContext, null, 0);
    if (paramContext != null) {
      a(paramContext);
    }
    return paramContext;
  }
  
  /* Error */
  public static Map<String, List<FileInfo>> b(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: aload_1
    //   8: aconst_null
    //   9: iload_2
    //   10: invokestatic 527	com/tencent/mobileqq/filemanager/util/FileCategoryUtil:a	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   13: astore_0
    //   14: aload_0
    //   15: astore_1
    //   16: aload_0
    //   17: iconst_2
    //   18: invokestatic 325	com/tencent/mobileqq/filemanager/util/FileCategoryUtil:a	(Landroid/database/Cursor;I)Ljava/util/Map;
    //   21: astore_3
    //   22: aload_3
    //   23: astore_1
    //   24: aload_0
    //   25: ifnull +47 -> 72
    //   28: aload_0
    //   29: invokeinterface 36 1 0
    //   34: aload_3
    //   35: areturn
    //   36: astore_0
    //   37: goto +37 -> 74
    //   40: astore_3
    //   41: goto +12 -> 53
    //   44: astore_0
    //   45: aconst_null
    //   46: astore_1
    //   47: goto +27 -> 74
    //   50: astore_3
    //   51: aconst_null
    //   52: astore_0
    //   53: aload_0
    //   54: astore_1
    //   55: aload_3
    //   56: invokevirtual 39	java/lang/Exception:printStackTrace	()V
    //   59: aload 5
    //   61: astore_1
    //   62: aload_0
    //   63: ifnull +9 -> 72
    //   66: aload 4
    //   68: astore_3
    //   69: goto -41 -> 28
    //   72: aload_1
    //   73: areturn
    //   74: aload_1
    //   75: ifnull +9 -> 84
    //   78: aload_1
    //   79: invokeinterface 36 1 0
    //   84: goto +5 -> 89
    //   87: aload_0
    //   88: athrow
    //   89: goto -2 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramContext	Context
    //   0	92	1	paramString	String
    //   0	92	2	paramInt	int
    //   21	14	3	localMap	Map
    //   40	1	3	localException1	Exception
    //   50	6	3	localException2	Exception
    //   68	1	3	localObject1	Object
    //   4	63	4	localObject2	Object
    //   1	59	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   16	22	36	finally
    //   55	59	36	finally
    //   16	22	40	java/lang/Exception
    //   6	14	44	finally
    //   6	14	50	java/lang/Exception
  }
  
  private static Cursor c(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    return paramContext.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "_display_name", "_data" }, paramString, paramArrayOfString, "date_added desc");
  }
  
  public static Map<String, List<FileInfo>> c(Context paramContext)
  {
    paramContext = c(paramContext, "1=1 )GROUP BY (_data", 0);
    if (paramContext != null) {
      a(paramContext);
    }
    return paramContext;
  }
  
  /* Error */
  public static Map<String, List<FileInfo>> c(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: aload_1
    //   8: aconst_null
    //   9: iload_2
    //   10: invokestatic 536	com/tencent/mobileqq/filemanager/util/FileCategoryUtil:c	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   13: astore_0
    //   14: aload_0
    //   15: astore_1
    //   16: aload_0
    //   17: iconst_1
    //   18: invokestatic 325	com/tencent/mobileqq/filemanager/util/FileCategoryUtil:a	(Landroid/database/Cursor;I)Ljava/util/Map;
    //   21: astore_3
    //   22: aload_3
    //   23: astore_1
    //   24: aload_0
    //   25: ifnull +47 -> 72
    //   28: aload_0
    //   29: invokeinterface 36 1 0
    //   34: aload_3
    //   35: areturn
    //   36: astore_0
    //   37: goto +37 -> 74
    //   40: astore_3
    //   41: goto +12 -> 53
    //   44: astore_0
    //   45: aconst_null
    //   46: astore_1
    //   47: goto +27 -> 74
    //   50: astore_3
    //   51: aconst_null
    //   52: astore_0
    //   53: aload_0
    //   54: astore_1
    //   55: aload_3
    //   56: invokevirtual 39	java/lang/Exception:printStackTrace	()V
    //   59: aload 5
    //   61: astore_1
    //   62: aload_0
    //   63: ifnull +9 -> 72
    //   66: aload 4
    //   68: astore_3
    //   69: goto -41 -> 28
    //   72: aload_1
    //   73: areturn
    //   74: aload_1
    //   75: ifnull +9 -> 84
    //   78: aload_1
    //   79: invokeinterface 36 1 0
    //   84: goto +5 -> 89
    //   87: aload_0
    //   88: athrow
    //   89: goto -2 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramContext	Context
    //   0	92	1	paramString	String
    //   0	92	2	paramInt	int
    //   21	14	3	localMap	Map
    //   40	1	3	localException1	Exception
    //   50	6	3	localException2	Exception
    //   68	1	3	localObject1	Object
    //   4	63	4	localObject2	Object
    //   1	59	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   16	22	36	finally
    //   55	59	36	finally
    //   16	22	40	java/lang/Exception
    //   6	14	44	finally
    //   6	14	50	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileCategoryUtil
 * JD-Core Version:    0.7.0.1
 */