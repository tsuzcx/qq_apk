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
  
  /* Error */
  private static void copy(java.io.InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 32	java/io/File:getParentFile	()Ljava/io/File;
    //   4: invokevirtual 36	java/io/File:mkdirs	()Z
    //   7: pop
    //   8: new 38	java/io/FileOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 41	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   16: astore_3
    //   17: sipush 4096
    //   20: newarray byte
    //   22: astore_1
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 47	java/io/InputStream:read	([B)I
    //   28: istore_2
    //   29: iload_2
    //   30: ifle +13 -> 43
    //   33: aload_3
    //   34: aload_1
    //   35: iconst_0
    //   36: iload_2
    //   37: invokevirtual 53	java/io/OutputStream:write	([BII)V
    //   40: goto -17 -> 23
    //   43: aload_0
    //   44: ifnull +7 -> 51
    //   47: aload_0
    //   48: invokevirtual 56	java/io/InputStream:close	()V
    //   51: aload_3
    //   52: invokevirtual 57	java/io/OutputStream:close	()V
    //   55: return
    //   56: astore_1
    //   57: goto +6 -> 63
    //   60: astore_1
    //   61: aconst_null
    //   62: astore_3
    //   63: aload_0
    //   64: ifnull +10 -> 74
    //   67: aload_0
    //   68: invokevirtual 56	java/io/InputStream:close	()V
    //   71: goto +3 -> 74
    //   74: aload_3
    //   75: ifnull +7 -> 82
    //   78: aload_3
    //   79: invokevirtual 57	java/io/OutputStream:close	()V
    //   82: goto +5 -> 87
    //   85: aload_1
    //   86: athrow
    //   87: goto -2 -> 85
    //   90: astore_0
    //   91: goto -40 -> 51
    //   94: astore_0
    //   95: return
    //   96: astore_0
    //   97: goto -23 -> 74
    //   100: astore_0
    //   101: goto -19 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramInputStream	java.io.InputStream
    //   0	104	1	paramFile	File
    //   28	9	2	i	int
    //   16	63	3	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   17	23	56	finally
    //   23	29	56	finally
    //   33	40	56	finally
    //   8	17	60	finally
    //   47	51	90	java/io/IOException
    //   51	55	94	java/io/IOException
    //   67	71	96	java/io/IOException
    //   78	82	100	java/io/IOException
  }
  
  private static void downloadAndVerifyPatch(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.optBoolean("enable", false)) {
      return;
    }
    Object localObject2 = paramJSONObject.optJSONArray("patchItemConfigs");
    if (localObject2 != null)
    {
      if (((JSONArray)localObject2).length() <= 0) {
        return;
      }
      int i = 0;
      Object localObject1;
      String str;
      while (i < ((JSONArray)localObject2).length())
      {
        localObject1 = ((JSONArray)localObject2).optJSONObject(i);
        if (localObject1 != null)
        {
          str = ((JSONObject)localObject1).optString("systemVersion", "");
          paramJSONObject = (JSONObject)localObject1;
          if (TextUtils.isEmpty(str)) {
            break label111;
          }
          if (str.contains(String.valueOf(Build.VERSION.SDK_INT)))
          {
            paramJSONObject = (JSONObject)localObject1;
            break label111;
          }
        }
        i += 1;
      }
      paramJSONObject = null;
      label111:
      if (paramJSONObject != null)
      {
        localObject2 = paramJSONObject.optString("patchName", null);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          return;
        }
        localObject1 = PatchCommonUtil.getPatchPath((String)localObject2);
        boolean bool1 = paramJSONObject.optBoolean("relaxEnable", false);
        boolean bool2 = paramJSONObject.optBoolean("nPatchEnable", false);
        if ((Build.VERSION.SDK_INT >= 24) && (bool2) && (!bool1)) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          paramJSONObject = paramJSONObject.optString("patch7zUrl", null);
        } else {
          paramJSONObject = paramJSONObject.optString("patchUrl", null);
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(paramJSONObject)))
        {
          str = PatchCommonUtil.getPatchPath(paramJSONObject.substring(paramJSONObject.lastIndexOf(File.separator) + 1));
          if (!TextUtils.isEmpty(str))
          {
            bool1 = f.a(paramJSONObject, str);
            paramJSONObject = new StringBuilder();
            paramJSONObject.append("download patch result=");
            paramJSONObject.append(bool1);
            QLog.d("MsfHandlePatchUtils", 1, paramJSONObject.toString());
            if (bool1)
            {
              if (i != 0) {
                bool2 = releaseZipPatch(str, (String)localObject2);
              } else {
                bool2 = true;
              }
              bool1 = bool2;
              if (bool2) {
                bool1 = PatchChecker.checkPatchValid("dex", (String)localObject2);
              }
              bool2 = bool1;
              if (bool1) {
                bool2 = releaseZipPatch((String)localObject1, (String)localObject2);
              }
              paramJSONObject = new StringBuilder();
              paramJSONObject.append("verify patch result=");
              paramJSONObject.append(bool2);
              QLog.d("MsfHandlePatchUtils", 1, paramJSONObject.toString());
              if (bool2)
              {
                MsfPullConfigUtil.showToastForSafeModeTest("补丁下载并校验成功，下次启动修复闪退");
                new DexClassLoader((String)localObject1, BaseApplication.getContext().getDir("dex", 0).getAbsolutePath(), (String)localObject1, BaseApplication.getContext().getClassLoader());
                return;
              }
              paramJSONObject = new File((String)localObject1);
              if (paramJSONObject.exists()) {
                paramJSONObject.delete();
              }
            }
          }
        }
      }
    }
  }
  
  private static JSONObject getLatestPatchConfig(List paramList)
  {
    Iterator localIterator = null;
    JSONObject localJSONObject = null;
    Object localObject = localIterator;
    if (paramList != null)
    {
      localObject = localIterator;
      if (paramList.size() > 0)
      {
        localIterator = paramList.iterator();
        int i = 0;
        paramList = localJSONObject;
        for (;;)
        {
          localObject = paramList;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (String)localIterator.next();
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            try
            {
              JSONArray localJSONArray = new JSONArray((String)localObject);
              int k = 0;
              for (;;)
              {
                localObject = paramList;
                j = i;
                try
                {
                  if (k >= localJSONArray.length()) {
                    break label191;
                  }
                  localJSONObject = localJSONArray.getJSONObject(k);
                  localObject = paramList;
                  j = i;
                  if (localJSONObject != null)
                  {
                    int m = localJSONObject.optInt("patchVersion", 0);
                    localObject = paramList;
                    j = i;
                    if (m > i)
                    {
                      localObject = localJSONObject;
                      j = m;
                    }
                  }
                  k += 1;
                  paramList = (List)localObject;
                  i = j;
                }
                catch (JSONException localJSONException1) {}
              }
              localObject = paramList;
            }
            catch (JSONException localJSONException2) {}
            int j = i;
            if (QLog.isColorLevel())
            {
              QLog.e("MsfHandlePatchUtils", 2, "getLatestPatchConfig JSONException", localJSONException2);
              j = i;
              localObject = paramList;
            }
            label191:
            paramList = (List)localObject;
            i = j;
          }
        }
      }
    }
    return localObject;
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
      localObject1 = getLatestPatchConfig(new ArrayList((Collection)localObject2));
    }
    else
    {
      localObject1 = null;
    }
    if (paramInt != localSharedPreferences.getInt("key_config_version_patch", 0))
    {
      paramList = getLatestPatchConfig(paramList);
      if ((paramList != null) && ((localObject1 == null) || (paramList.optInt("patchVersion", 0) > ((JSONObject)localObject1).optInt("patchVersion", 0))))
      {
        localObject1 = new JSONArray();
        ((JSONArray)localObject1).put(paramList);
        localSharedPreferences.edit().putString("key_config_patch_dex", ((JSONArray)localObject1).toString()).commit();
        localObject1 = paramList;
      }
      localSharedPreferences.edit().putInt("key_config_version_patch", paramInt).commit();
      if (localObject1 != null) {
        downloadAndVerifyPatch((JSONObject)localObject1);
      }
    }
    else if (localObject1 != null)
    {
      paramList = ((JSONObject)localObject1).optString("patchName", null);
      if (!TextUtils.isEmpty(paramList))
      {
        localObject2 = PatchCommonUtil.getPatchPath(paramList);
        File localFile = new File((String)localObject2);
        boolean bool1 = localFile.exists();
        int j = 1;
        int i = j;
        if (bool1)
        {
          boolean bool2 = PatchChecker.checkPatchValid("dex", paramList);
          bool1 = bool2;
          if (bool2) {
            bool1 = releaseZipPatch((String)localObject2, paramList);
          }
          if (!bool1)
          {
            localFile.delete();
            i = j;
          }
          else
          {
            i = 0;
          }
        }
        if (i != 0) {
          downloadAndVerifyPatch((JSONObject)localObject1);
        }
      }
    }
    if (localSharedPreferences.getInt("key_config_version_patch", 0) != paramInt) {
      localSharedPreferences.edit().putInt("key_config_version_patch", 0).commit();
    }
  }
  
  /* Error */
  private static boolean releaseZipPatch(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore_3
    //   7: new 313	com/tencent/commonsdk/zip/QZipFile
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 314	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   15: astore 4
    //   17: new 28	java/io/File
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 210	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: invokevirtual 317	java/io/File:getParent	()Ljava/lang/String;
    //   28: astore_0
    //   29: aload 4
    //   31: ldc_w 319
    //   34: invokevirtual 323	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   37: astore_3
    //   38: aload 4
    //   40: ldc_w 325
    //   43: invokevirtual 323	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   46: astore 5
    //   48: aload 4
    //   50: ldc_w 327
    //   53: invokevirtual 323	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   56: astore 6
    //   58: aload_3
    //   59: ifnull +84 -> 143
    //   62: aload 5
    //   64: ifnull +79 -> 143
    //   67: aload 6
    //   69: ifnull +74 -> 143
    //   72: ldc 17
    //   74: iconst_1
    //   75: ldc_w 329
    //   78: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload 4
    //   83: aload_3
    //   84: invokevirtual 333	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   87: new 28	java/io/File
    //   90: dup
    //   91: aload_0
    //   92: ldc_w 319
    //   95: invokespecial 336	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: invokestatic 338	com/tencent/mobileqq/msf/core/net/utils/MsfHandlePatchUtils:copy	(Ljava/io/InputStream;Ljava/io/File;)V
    //   101: aload 4
    //   103: aload 5
    //   105: invokevirtual 333	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   108: new 28	java/io/File
    //   111: dup
    //   112: aload_0
    //   113: ldc_w 325
    //   116: invokespecial 336	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: invokestatic 338	com/tencent/mobileqq/msf/core/net/utils/MsfHandlePatchUtils:copy	(Ljava/io/InputStream;Ljava/io/File;)V
    //   122: aload 4
    //   124: aload 6
    //   126: invokevirtual 333	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   129: new 28	java/io/File
    //   132: dup
    //   133: aload_0
    //   134: ldc_w 327
    //   137: invokespecial 336	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: invokestatic 338	com/tencent/mobileqq/msf/core/net/utils/MsfHandlePatchUtils:copy	(Ljava/io/InputStream;Ljava/io/File;)V
    //   143: aload 4
    //   145: ldc_w 340
    //   148: invokevirtual 323	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   151: astore_3
    //   152: aload_3
    //   153: ifnull +67 -> 220
    //   156: ldc 17
    //   158: iconst_1
    //   159: ldc_w 342
    //   162: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: new 28	java/io/File
    //   168: dup
    //   169: aload_0
    //   170: ldc_w 340
    //   173: invokespecial 336	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: astore 5
    //   178: aload 5
    //   180: invokevirtual 213	java/io/File:exists	()Z
    //   183: ifne +17 -> 200
    //   186: aload 4
    //   188: aload_3
    //   189: invokevirtual 333	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   192: aload 5
    //   194: invokestatic 338	com/tencent/mobileqq/msf/core/net/utils/MsfHandlePatchUtils:copy	(Ljava/io/InputStream;Ljava/io/File;)V
    //   197: goto +23 -> 220
    //   200: aload 4
    //   202: aload_3
    //   203: invokevirtual 333	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   206: new 28	java/io/File
    //   209: dup
    //   210: aload_0
    //   211: ldc_w 344
    //   214: invokespecial 336	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: invokestatic 338	com/tencent/mobileqq/msf/core/net/utils/MsfHandlePatchUtils:copy	(Ljava/io/InputStream;Ljava/io/File;)V
    //   220: aload 4
    //   222: aload_1
    //   223: invokevirtual 323	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   226: astore_3
    //   227: aload_3
    //   228: ifnull +30 -> 258
    //   231: ldc 17
    //   233: iconst_1
    //   234: ldc_w 346
    //   237: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: aload 4
    //   242: aload_3
    //   243: invokevirtual 333	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   246: new 28	java/io/File
    //   249: dup
    //   250: aload_0
    //   251: aload_1
    //   252: invokespecial 336	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: invokestatic 338	com/tencent/mobileqq/msf/core/net/utils/MsfHandlePatchUtils:copy	(Ljava/io/InputStream;Ljava/io/File;)V
    //   258: aload 4
    //   260: invokevirtual 347	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   263: iconst_1
    //   264: ireturn
    //   265: astore_0
    //   266: aload_0
    //   267: invokevirtual 350	java/io/IOException:printStackTrace	()V
    //   270: iload_2
    //   271: ireturn
    //   272: astore_0
    //   273: goto +45 -> 318
    //   276: astore_1
    //   277: aload 4
    //   279: astore_0
    //   280: goto +14 -> 294
    //   283: astore_0
    //   284: aload_3
    //   285: astore 4
    //   287: goto +31 -> 318
    //   290: astore_1
    //   291: aload 5
    //   293: astore_0
    //   294: aload_0
    //   295: astore_3
    //   296: ldc 17
    //   298: iconst_1
    //   299: ldc_w 352
    //   302: aload_1
    //   303: invokestatic 354	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   306: iconst_0
    //   307: istore_2
    //   308: aload_0
    //   309: ifnull +7 -> 316
    //   312: aload_0
    //   313: invokevirtual 347	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   316: iconst_0
    //   317: ireturn
    //   318: aload 4
    //   320: ifnull +16 -> 336
    //   323: aload 4
    //   325: invokevirtual 347	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   328: goto +8 -> 336
    //   331: astore_1
    //   332: aload_1
    //   333: invokevirtual 350	java/io/IOException:printStackTrace	()V
    //   336: aload_0
    //   337: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	paramString1	String
    //   0	338	1	paramString2	String
    //   1	307	2	bool	boolean
    //   6	290	3	localObject1	Object
    //   15	309	4	localObject2	Object
    //   3	289	5	localObject3	Object
    //   56	69	6	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   258	263	265	java/io/IOException
    //   312	316	265	java/io/IOException
    //   17	58	272	finally
    //   72	143	272	finally
    //   143	152	272	finally
    //   156	197	272	finally
    //   200	220	272	finally
    //   220	227	272	finally
    //   231	258	272	finally
    //   17	58	276	java/lang/Throwable
    //   72	143	276	java/lang/Throwable
    //   143	152	276	java/lang/Throwable
    //   156	197	276	java/lang/Throwable
    //   200	220	276	java/lang/Throwable
    //   220	227	276	java/lang/Throwable
    //   231	258	276	java/lang/Throwable
    //   7	17	283	finally
    //   296	306	283	finally
    //   7	17	290	java/lang/Throwable
    //   323	328	331	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.utils.MsfHandlePatchUtils
 * JD-Core Version:    0.7.0.1
 */