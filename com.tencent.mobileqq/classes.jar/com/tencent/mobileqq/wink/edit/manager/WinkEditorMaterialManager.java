package com.tencent.mobileqq.wink.edit.manager;

import android.os.Build.VERSION;
import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.edit.log.WinkQLog;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

public class WinkEditorMaterialManager
{
  private static volatile WinkEditorMaterialManager c;
  public ArrayList<MetaMaterial> a;
  public ArrayList<String> b;
  private final Object d = new Object();
  private WeakReference<WinkEditorMaterialManager.RecommendListener> e;
  private boolean f = false;
  
  public static WinkEditorMaterialManager a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new WinkEditorMaterialManager();
        }
      }
      finally {}
    }
    return c;
  }
  
  public static String a(File paramFile)
  {
    paramFile = FileUtils.fileToBytes(paramFile);
    if (paramFile != null)
    {
      if (paramFile.length <= 0) {
        return null;
      }
      if (Build.VERSION.SDK_INT <= 8) {
        return new String(paramFile);
      }
      try
      {
        paramFile = new String(paramFile, "UTF-8");
        return paramFile;
      }
      catch (UnsupportedEncodingException paramFile)
      {
        WinkQLog.a("[AEEditor2]AEditorMaterialManager_PTV", "loadFileContent error, ", paramFile);
      }
    }
    return null;
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: invokestatic 75	com/tencent/mobileqq/wink/QQWinkEnvironment:a	()Landroid/content/Context;
    //   7: invokevirtual 81	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   10: aload_0
    //   11: invokevirtual 87	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   14: astore_3
    //   15: aload_3
    //   16: astore_1
    //   17: aload_3
    //   18: astore_2
    //   19: aload_3
    //   20: invokestatic 92	com/tencent/biz/common/util/Util:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   23: astore 4
    //   25: aload 4
    //   27: astore_0
    //   28: aload_3
    //   29: ifnull +91 -> 120
    //   32: aload_3
    //   33: invokevirtual 97	java/io/InputStream:close	()V
    //   36: aload 4
    //   38: areturn
    //   39: astore_0
    //   40: aload_0
    //   41: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   44: aload 4
    //   46: areturn
    //   47: astore_0
    //   48: goto +74 -> 122
    //   51: astore_3
    //   52: aload_2
    //   53: astore_1
    //   54: new 102	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   61: astore 4
    //   63: aload_2
    //   64: astore_1
    //   65: aload 4
    //   67: ldc 105
    //   69: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_2
    //   74: astore_1
    //   75: aload 4
    //   77: aload_0
    //   78: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_2
    //   83: astore_1
    //   84: ldc 111
    //   86: aload 4
    //   88: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: aload_3
    //   92: invokestatic 65	com/tencent/mobileqq/wink/edit/log/WinkQLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   95: aload_2
    //   96: astore_1
    //   97: aload_3
    //   98: invokevirtual 116	java/lang/Throwable:printStackTrace	()V
    //   101: aload_2
    //   102: ifnull +15 -> 117
    //   105: aload_2
    //   106: invokevirtual 97	java/io/InputStream:close	()V
    //   109: goto +8 -> 117
    //   112: astore_0
    //   113: aload_0
    //   114: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   117: ldc 118
    //   119: astore_0
    //   120: aload_0
    //   121: areturn
    //   122: aload_1
    //   123: ifnull +15 -> 138
    //   126: aload_1
    //   127: invokevirtual 97	java/io/InputStream:close	()V
    //   130: goto +8 -> 138
    //   133: astore_1
    //   134: aload_1
    //   135: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   138: aload_0
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramString	String
    //   3	124	1	localObject1	Object
    //   133	2	1	localIOException	java.io.IOException
    //   1	105	2	localObject2	Object
    //   14	19	3	localInputStream	java.io.InputStream
    //   51	47	3	localThrowable	java.lang.Throwable
    //   23	64	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   32	36	39	java/io/IOException
    //   4	15	47	finally
    //   19	25	47	finally
    //   54	63	47	finally
    //   65	73	47	finally
    //   75	82	47	finally
    //   84	95	47	finally
    //   97	101	47	finally
    //   4	15	51	java/lang/Throwable
    //   19	25	51	java/lang/Throwable
    //   105	109	112	java/io/IOException
    //   126	130	133	java/io/IOException
  }
  
  private static List<MetaCategory> b(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = a(paramFile);
    if (TextUtils.isEmpty(paramFile)) {
      return localArrayList;
    }
    paramFile = (ArrayList)new Gson().fromJson(paramFile, new WinkEditorMaterialManager.2().getType());
    if (paramFile != null)
    {
      if (paramFile.isEmpty()) {
        return localArrayList;
      }
      localArrayList.clear();
      localArrayList.addAll(paramFile);
    }
    return localArrayList;
  }
  
  private static List<MetaCategory> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = a(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    paramString = (ArrayList)new Gson().fromJson(paramString, new WinkEditorMaterialManager.1().getType());
    if (paramString != null)
    {
      if (paramString.isEmpty()) {
        return localArrayList;
      }
      localArrayList.clear();
      localArrayList.addAll(paramString);
    }
    return localArrayList;
  }
  
  public String a(String paramString1, String paramString2)
  {
    synchronized (this.d)
    {
      paramString1 = new File(paramString1);
      if (!paramString1.exists()) {
        paramString1.mkdirs();
      }
      paramString1 = new File(paramString1.getPath(), paramString2).getPath();
      return paramString1;
    }
  }
  
  public List<MetaCategory> a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("readAndParseConfigFile... parent:");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(" newjson:");
    ((StringBuilder)localObject1).append(paramString2);
    ((StringBuilder)localObject1).append(" oldjson:");
    ((StringBuilder)localObject1).append(paramString3);
    WinkQLog.a("[AEEditor2]AEditorMaterialManager", ((StringBuilder)localObject1).toString());
    synchronized (this.d)
    {
      localObject1 = new ArrayList();
      File localFile1 = new File(paramString1, paramString2);
      File localFile2 = new File(paramString1, paramString3);
      if (!localFile1.exists())
      {
        if (!localFile2.exists())
        {
          WinkQLog.a("[AEEditor2]AEditorMaterialManager", "readAndParseConfigFile -> oldJson not exist, newJson not exist ");
          paramString1 = b(paramString3);
        }
        else
        {
          paramString1 = (String)localObject1;
          try
          {
            paramString2 = b(localFile2);
            paramString1 = paramString2;
            WinkQLog.a("[AEEditor2]AEditorMaterialManager", "readAndParseConfigFile -> oldJson exists, newJson not exist, use oldJson");
            paramString1 = paramString2;
          }
          catch (Exception paramString2)
          {
            FileUtils.deleteFile(localFile2.getPath());
            AECameraPrefsUtil.a().a(AECameraPrefsUtil.d, 4);
            paramString3 = new StringBuilder();
            paramString3.append("readAndParseConfigFile -> oldJson exists, newJson not exist, exception:");
            paramString3.append(paramString2.toString());
            WinkQLog.d("[AEEditor2]AEditorMaterialManager", paramString3.toString());
          }
        }
      }
      else
      {
        paramString1 = (String)localObject1;
        try
        {
          paramString2 = b(localFile1);
          if (paramBoolean)
          {
            paramString1 = paramString2;
            FileUtils.moveFile(localFile1.getPath(), localFile2.getPath());
          }
          paramString1 = paramString2;
          paramString3 = new StringBuilder();
          paramString1 = paramString2;
          paramString3.append("readAndParseConfigFile -> oldJson not exist, use newJson isNeedMove:");
          paramString1 = paramString2;
          paramString3.append(paramBoolean);
          paramString1 = paramString2;
          WinkQLog.a("[AEEditor2]AEditorMaterialManager", paramString3.toString());
          paramString1 = paramString2;
        }
        catch (Exception paramString2)
        {
          FileUtils.deleteFile(localFile1.getPath());
          paramString3 = new StringBuilder();
          paramString3.append("readAndParseConfigFile -> oldJson not exists: exception:");
          paramString3.append(paramString2.toString());
          WinkQLog.d("[AEEditor2]AEditorMaterialManager", paramString3.toString());
          AECameraPrefsUtil.a().a(AECameraPrefsUtil.d, 4);
        }
      }
      return paramString1;
    }
  }
  
  public void a(ArrayList<MetaMaterial> paramArrayList, ArrayList<String> paramArrayList1)
  {
    this.a = paramArrayList;
    this.b = paramArrayList1;
    paramArrayList = this.e;
    if ((paramArrayList != null) && (paramArrayList.get() != null)) {
      ((WinkEditorMaterialManager.RecommendListener)this.e.get()).a();
    }
    this.f = true;
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public MetaCategory b()
  {
    Object localObject = this.a;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = new MetaCategory();
      ((MetaCategory)localObject).name = "推荐";
      ((MetaCategory)localObject).id = "recommend";
      ((MetaCategory)localObject).materials = this.a;
      return localObject;
    }
    return null;
  }
  
  public boolean c()
  {
    return this.f;
  }
  
  public void d()
  {
    WeakReference localWeakReference = this.e;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((WinkEditorMaterialManager.RecommendListener)this.e.get()).b();
    }
    this.f = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.manager.WinkEditorMaterialManager
 * JD-Core Version:    0.7.0.1
 */