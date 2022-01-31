package com.tencent.mobileqq.msf.core.net.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.net.patch.PatchChecker;
import com.tencent.mobileqq.msf.core.net.patch.PatchCommonUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MsfHandlePatchUtils
{
  private static final String KEY_PATCH_CONFIG = "key_config_patch_dex";
  private static final String KEY_PATCH_VERSION = "key_config_version_patch";
  private static final String SP_PATCH = "hotpatch_preference";
  private static final String TAG = "MsfHandlePatchUtils";
  
  private static void copy(InputStream paramInputStream, File paramFile)
  {
    paramFile.getParentFile().mkdirs();
    for (;;)
    {
      try
      {
        localFileOutputStream = new FileOutputStream(paramFile);
        try
        {
          paramFile = new byte[4096];
          int i = paramInputStream.read(paramFile);
          if (i > 0)
          {
            localFileOutputStream.write(paramFile, 0, i);
            continue;
            if (paramInputStream == null) {}
          }
        }
        finally {}
      }
      finally
      {
        FileOutputStream localFileOutputStream = null;
        continue;
      }
      try
      {
        paramInputStream.close();
        if (localFileOutputStream == null) {}
      }
      catch (IOException paramInputStream)
      {
        try
        {
          localFileOutputStream.close();
          throw paramFile;
          if (paramInputStream == null) {}
        }
        catch (IOException paramInputStream)
        {
          try
          {
            paramInputStream.close();
            if (localFileOutputStream != null) {}
            try
            {
              localFileOutputStream.close();
              return;
            }
            catch (IOException paramInputStream)
            {
              return;
            }
            paramInputStream = paramInputStream;
            continue;
            paramInputStream = paramInputStream;
          }
          catch (IOException paramInputStream) {}
        }
      }
    }
  }
  
  private static void downloadAndVerifyPatch(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.optBoolean("enable", false)) {}
    label388:
    label396:
    for (;;)
    {
      return;
      Object localObject = paramJSONObject.optJSONArray("patchItemConfigs");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        int i = 0;
        String str1;
        if (i < ((JSONArray)localObject).length())
        {
          paramJSONObject = ((JSONArray)localObject).optJSONObject(i);
          if (paramJSONObject == null) {}
          do
          {
            i += 1;
            break;
            str1 = paramJSONObject.optString("systemVersion", "");
          } while ((!TextUtils.isEmpty(str1)) && (!str1.contains(String.valueOf(Build.VERSION.SDK_INT))));
        }
        for (;;)
        {
          if (paramJSONObject == null) {
            break label396;
          }
          localObject = paramJSONObject.optString("patchName", null);
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          str1 = PatchCommonUtil.getPatchPath((String)localObject);
          boolean bool1 = paramJSONObject.optBoolean("relaxEnable", false);
          boolean bool2 = paramJSONObject.optBoolean("nPatchEnable", false);
          label155:
          label167:
          String str2;
          if ((Build.VERSION.SDK_INT >= 24) && (bool2) && (!bool1))
          {
            i = 1;
            if (i == 0) {
              break label354;
            }
            paramJSONObject = paramJSONObject.optString("patch7zUrl", null);
            if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(paramJSONObject))) {
              break label363;
            }
            str2 = PatchCommonUtil.getPatchPath(paramJSONObject.substring(paramJSONObject.lastIndexOf(File.separator) + 1));
            if (TextUtils.isEmpty(str2)) {
              break;
            }
            bool1 = e.a(paramJSONObject, str2);
            QLog.d("MsfHandlePatchUtils", 1, "download patch result=" + bool1);
            if (!bool1) {
              break;
            }
            if (i == 0) {
              break label388;
            }
          }
          for (bool2 = releaseZipPatch(str2, (String)localObject);; bool2 = true)
          {
            bool1 = bool2;
            if (bool2) {
              bool1 = PatchChecker.checkPatchValid("dex", (String)localObject);
            }
            bool2 = bool1;
            if (bool1) {
              bool2 = releaseZipPatch(str1, (String)localObject);
            }
            QLog.d("MsfHandlePatchUtils", 1, "verify patch result=" + bool2);
            if (bool2)
            {
              MsfPullConfigUtil.showToastForSafeModeTest("补丁下载并校验成功，下次启动修复闪退");
              new DexClassLoader(str1, BaseApplication.getContext().getDir("dex", 0).getAbsolutePath(), str1, BaseApplication.getContext().getClassLoader());
              return;
              i = 0;
              break label155;
              label354:
              paramJSONObject = paramJSONObject.optString("patchUrl", null);
              break label167;
              label363:
              break;
            }
            paramJSONObject = new File(str1);
            if (!paramJSONObject.exists()) {
              break;
            }
            paramJSONObject.delete();
            return;
          }
          paramJSONObject = null;
        }
      }
    }
  }
  
  private static JSONObject getLatestPatchConfig(List paramList)
  {
    Iterator localIterator = null;
    Object localObject2 = null;
    Object localObject1 = localIterator;
    int j;
    int m;
    if (paramList != null)
    {
      localObject1 = localIterator;
      if (paramList.size() > 0)
      {
        localIterator = paramList.iterator();
        j = 0;
        paramList = (List)localObject2;
        do
        {
          localObject1 = paramList;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (String)localIterator.next();
        } while (TextUtils.isEmpty((CharSequence)localObject1));
        m = j;
        localObject2 = paramList;
      }
    }
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray((String)localObject1);
        int k = 0;
        localObject1 = paramList;
        int i = j;
        j = i;
        paramList = (List)localObject1;
        m = i;
        localObject2 = localObject1;
        if (k >= localJSONArray.length()) {
          break;
        }
        m = i;
        localObject2 = localObject1;
        paramList = localJSONArray.getJSONObject(k);
        if (paramList == null) {
          break label204;
        }
        m = i;
        localObject2 = localObject1;
        j = paramList.optInt("patchVersion", 0);
        if (j <= i) {
          break label204;
        }
        i = j;
        k += 1;
        localObject1 = paramList;
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (JSONException localJSONException)
      {
        j = m;
        paramList = (List)localObject2;
      }
      QLog.e("MsfHandlePatchUtils", 2, "getLatestPatchConfig JSONException", localJSONException);
      j = m;
      paramList = (List)localObject2;
      break;
      return localJSONException;
      label204:
      paramList = localJSONException;
    }
  }
  
  static int getPatchConfigVersion()
  {
    return BaseApplication.getContext().getSharedPreferences("hotpatch_preference", 4).getInt("key_config_version_patch", 0);
  }
  
  static void handlePatchConfig(int paramInt, List paramList)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("hotpatch_preference", 4);
    Object localObject1 = localSharedPreferences.getString("key_config_patch_dex", null);
    Object localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new ArrayList();
      ((List)localObject2).add(localObject1);
    }
    for (localObject1 = getLatestPatchConfig(new ArrayList((Collection)localObject2));; localObject1 = null)
    {
      if (paramInt != localSharedPreferences.getInt("key_config_version_patch", 0))
      {
        localObject2 = getLatestPatchConfig(paramList);
        paramList = (List)localObject1;
        if (localObject2 != null) {
          if (localObject1 != null)
          {
            paramList = (List)localObject1;
            if (((JSONObject)localObject2).optInt("patchVersion", 0) <= ((JSONObject)localObject1).optInt("patchVersion", 0)) {}
          }
          else
          {
            paramList = new JSONArray();
            paramList.put(localObject2);
            localSharedPreferences.edit().putString("key_config_patch_dex", paramList.toString()).commit();
            paramList = (List)localObject2;
          }
        }
        localSharedPreferences.edit().putInt("key_config_version_patch", paramInt).commit();
        if (paramList != null) {
          downloadAndVerifyPatch(paramList);
        }
      }
      label324:
      label327:
      for (;;)
      {
        if (localSharedPreferences.getInt("key_config_version_patch", 0) != paramInt) {
          localSharedPreferences.edit().putInt("key_config_version_patch", 0).commit();
        }
        return;
        if (localObject1 != null)
        {
          paramList = ((JSONObject)localObject1).optString("patchName", null);
          if (!TextUtils.isEmpty(paramList))
          {
            localObject2 = PatchCommonUtil.getPatchPath(paramList);
            File localFile = new File((String)localObject2);
            int i;
            if (localFile.exists())
            {
              boolean bool2 = PatchChecker.checkPatchValid("dex", paramList);
              boolean bool1 = bool2;
              if (bool2) {
                bool1 = releaseZipPatch((String)localObject2, paramList);
              }
              if (bool1) {
                break label324;
              }
              localFile.delete();
              i = 1;
            }
            for (;;)
            {
              if (i == 0) {
                break label327;
              }
              downloadAndVerifyPatch((JSONObject)localObject1);
              break;
              i = 1;
              continue;
              i = 0;
            }
          }
        }
      }
    }
  }
  
  /* Error */
  private static boolean releaseZipPatch(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: iconst_1
    //   4: istore_3
    //   5: new 313	com/tencent/commonsdk/zip/QZipFile
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 314	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   13: astore 6
    //   15: aload 6
    //   17: astore 5
    //   19: new 28	java/io/File
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 210	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: invokevirtual 317	java/io/File:getParent	()Ljava/lang/String;
    //   30: astore_0
    //   31: aload 6
    //   33: astore 5
    //   35: aload 6
    //   37: ldc_w 319
    //   40: invokevirtual 323	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   43: astore 7
    //   45: aload 6
    //   47: astore 5
    //   49: aload 6
    //   51: ldc_w 325
    //   54: invokevirtual 323	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   57: astore 8
    //   59: aload 6
    //   61: astore 5
    //   63: aload 6
    //   65: ldc_w 327
    //   68: invokevirtual 323	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   71: astore 9
    //   73: aload 7
    //   75: ifnull +101 -> 176
    //   78: aload 8
    //   80: ifnull +96 -> 176
    //   83: aload 9
    //   85: ifnull +91 -> 176
    //   88: aload 6
    //   90: astore 5
    //   92: ldc 17
    //   94: iconst_1
    //   95: ldc_w 329
    //   98: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: aload 6
    //   103: astore 5
    //   105: aload 6
    //   107: aload 7
    //   109: invokevirtual 333	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   112: new 28	java/io/File
    //   115: dup
    //   116: aload_0
    //   117: ldc_w 319
    //   120: invokespecial 336	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: invokestatic 338	com/tencent/mobileqq/msf/core/net/utils/MsfHandlePatchUtils:copy	(Ljava/io/InputStream;Ljava/io/File;)V
    //   126: aload 6
    //   128: astore 5
    //   130: aload 6
    //   132: aload 8
    //   134: invokevirtual 333	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   137: new 28	java/io/File
    //   140: dup
    //   141: aload_0
    //   142: ldc_w 325
    //   145: invokespecial 336	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: invokestatic 338	com/tencent/mobileqq/msf/core/net/utils/MsfHandlePatchUtils:copy	(Ljava/io/InputStream;Ljava/io/File;)V
    //   151: aload 6
    //   153: astore 5
    //   155: aload 6
    //   157: aload 9
    //   159: invokevirtual 333	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   162: new 28	java/io/File
    //   165: dup
    //   166: aload_0
    //   167: ldc_w 327
    //   170: invokespecial 336	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: invokestatic 338	com/tencent/mobileqq/msf/core/net/utils/MsfHandlePatchUtils:copy	(Ljava/io/InputStream;Ljava/io/File;)V
    //   176: aload 6
    //   178: astore 5
    //   180: aload 6
    //   182: ldc_w 340
    //   185: invokevirtual 323	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   188: astore 7
    //   190: aload 7
    //   192: ifnull +61 -> 253
    //   195: aload 6
    //   197: astore 5
    //   199: ldc 17
    //   201: iconst_1
    //   202: ldc_w 342
    //   205: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: aload 6
    //   210: astore 5
    //   212: new 28	java/io/File
    //   215: dup
    //   216: aload_0
    //   217: ldc_w 340
    //   220: invokespecial 336	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: astore 8
    //   225: aload 6
    //   227: astore 5
    //   229: aload 8
    //   231: invokevirtual 213	java/io/File:exists	()Z
    //   234: ifne +88 -> 322
    //   237: aload 6
    //   239: astore 5
    //   241: aload 6
    //   243: aload 7
    //   245: invokevirtual 333	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   248: aload 8
    //   250: invokestatic 338	com/tencent/mobileqq/msf/core/net/utils/MsfHandlePatchUtils:copy	(Ljava/io/InputStream;Ljava/io/File;)V
    //   253: aload 6
    //   255: astore 5
    //   257: aload 6
    //   259: aload_1
    //   260: invokevirtual 323	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   263: astore 7
    //   265: aload 7
    //   267: ifnull +39 -> 306
    //   270: aload 6
    //   272: astore 5
    //   274: ldc 17
    //   276: iconst_1
    //   277: ldc_w 344
    //   280: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: aload 6
    //   285: astore 5
    //   287: aload 6
    //   289: aload 7
    //   291: invokevirtual 333	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   294: new 28	java/io/File
    //   297: dup
    //   298: aload_0
    //   299: aload_1
    //   300: invokespecial 336	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: invokestatic 338	com/tencent/mobileqq/msf/core/net/utils/MsfHandlePatchUtils:copy	(Ljava/io/InputStream;Ljava/io/File;)V
    //   306: iload_3
    //   307: istore_2
    //   308: aload 6
    //   310: ifnull +10 -> 320
    //   313: aload 6
    //   315: invokevirtual 345	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   318: iload_3
    //   319: istore_2
    //   320: iload_2
    //   321: ireturn
    //   322: aload 6
    //   324: astore 5
    //   326: aload 6
    //   328: aload 7
    //   330: invokevirtual 333	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   333: new 28	java/io/File
    //   336: dup
    //   337: aload_0
    //   338: ldc_w 347
    //   341: invokespecial 336	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: invokestatic 338	com/tencent/mobileqq/msf/core/net/utils/MsfHandlePatchUtils:copy	(Ljava/io/InputStream;Ljava/io/File;)V
    //   347: goto -94 -> 253
    //   350: astore_1
    //   351: aload 6
    //   353: astore_0
    //   354: aload_0
    //   355: astore 5
    //   357: ldc 17
    //   359: iconst_1
    //   360: ldc_w 349
    //   363: aload_1
    //   364: invokestatic 351	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   367: iconst_0
    //   368: istore_3
    //   369: iconst_0
    //   370: istore_2
    //   371: aload_0
    //   372: ifnull -52 -> 320
    //   375: aload_0
    //   376: invokevirtual 345	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   379: iconst_0
    //   380: ireturn
    //   381: astore_0
    //   382: iload_3
    //   383: istore_2
    //   384: aload_0
    //   385: invokevirtual 354	java/io/IOException:printStackTrace	()V
    //   388: iload_2
    //   389: ireturn
    //   390: astore_0
    //   391: aconst_null
    //   392: astore 5
    //   394: aload 5
    //   396: ifnull +8 -> 404
    //   399: aload 5
    //   401: invokevirtual 345	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   404: aload_0
    //   405: athrow
    //   406: astore_1
    //   407: aload_1
    //   408: invokevirtual 354	java/io/IOException:printStackTrace	()V
    //   411: goto -7 -> 404
    //   414: astore_0
    //   415: iload 4
    //   417: istore_2
    //   418: goto -34 -> 384
    //   421: astore_0
    //   422: goto -28 -> 394
    //   425: astore_1
    //   426: aconst_null
    //   427: astore_0
    //   428: goto -74 -> 354
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	paramString1	String
    //   0	431	1	paramString2	String
    //   307	111	2	bool1	boolean
    //   4	379	3	bool2	boolean
    //   1	415	4	bool3	boolean
    //   17	383	5	localObject1	Object
    //   13	339	6	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   43	286	7	localZipEntry1	java.util.zip.ZipEntry
    //   57	192	8	localObject2	Object
    //   71	87	9	localZipEntry2	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   19	31	350	java/lang/Throwable
    //   35	45	350	java/lang/Throwable
    //   49	59	350	java/lang/Throwable
    //   63	73	350	java/lang/Throwable
    //   92	101	350	java/lang/Throwable
    //   105	126	350	java/lang/Throwable
    //   130	151	350	java/lang/Throwable
    //   155	176	350	java/lang/Throwable
    //   180	190	350	java/lang/Throwable
    //   199	208	350	java/lang/Throwable
    //   212	225	350	java/lang/Throwable
    //   229	237	350	java/lang/Throwable
    //   241	253	350	java/lang/Throwable
    //   257	265	350	java/lang/Throwable
    //   274	283	350	java/lang/Throwable
    //   287	306	350	java/lang/Throwable
    //   326	347	350	java/lang/Throwable
    //   375	379	381	java/io/IOException
    //   5	15	390	finally
    //   399	404	406	java/io/IOException
    //   313	318	414	java/io/IOException
    //   19	31	421	finally
    //   35	45	421	finally
    //   49	59	421	finally
    //   63	73	421	finally
    //   92	101	421	finally
    //   105	126	421	finally
    //   130	151	421	finally
    //   155	176	421	finally
    //   180	190	421	finally
    //   199	208	421	finally
    //   212	225	421	finally
    //   229	237	421	finally
    //   241	253	421	finally
    //   257	265	421	finally
    //   274	283	421	finally
    //   287	306	421	finally
    //   326	347	421	finally
    //   357	367	421	finally
    //   5	15	425	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.utils.MsfHandlePatchUtils
 * JD-Core Version:    0.7.0.1
 */