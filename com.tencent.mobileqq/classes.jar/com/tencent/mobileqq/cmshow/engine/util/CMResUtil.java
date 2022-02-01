package com.tencent.mobileqq.cmshow.engine.util;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.EngineType;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/util/CMResUtil;", "", "()V", "ACTION_RES_NONE_PREFIX", "", "ACTION_RES_PREFIX", "BASE_JS_PREFIX", "DRESS_RES_PREFIX", "EXTENSION_RES_PREFIX", "POSTFIX_ANDROID", "POSTFIX_AUDIO", "POSTFIX_ZIP", "ROLE_RES_PREFIX", "SLAVE_RES_PREFIX", "TAG", "anySceneRunOnBKEngine", "", "anySceneRunOnCrossEngine", "compareResVersion", "localArray", "Lorg/json/JSONArray;", "needDownloadRes", "serverId", "", "serverVersion", "", "fileToString", "file", "Ljava/io/File;", "is3DRes", "id", "isCEEngine", "isFileExistAndLenNot0", "fileFullPath", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CMResUtil
{
  public static final CMResUtil a = new CMResUtil();
  
  @JvmStatic
  public static final boolean a()
  {
    return b();
  }
  
  @JvmStatic
  public static final boolean a(int paramInt)
  {
    return paramInt >= ApolloConstant.f;
  }
  
  @JvmStatic
  public static final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "fileFullPath");
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return false;
    }
    return b(new File(paramString));
  }
  
  @JvmStatic
  public static final boolean a(@Nullable JSONArray paramJSONArray, boolean paramBoolean, int paramInt, long paramLong)
  {
    if (paramJSONArray == null) {
      return paramBoolean;
    }
    int j = paramJSONArray.length();
    int i = 0;
    while (i < j)
    {
      int k = paramJSONArray.getJSONObject(i).getInt("id");
      long l = paramJSONArray.getJSONObject(i).getLong("updateTs");
      if (k == paramInt)
      {
        if (paramLong == l) {
          break;
        }
        QLog.i("[cmshow]CMResUtil", 1, "compareResVersion version update res.");
        return true;
      }
      i += 1;
    }
    return paramBoolean;
  }
  
  @JvmStatic
  public static final boolean b()
  {
    Scene[] arrayOfScene = Scene.values();
    int j = arrayOfScene.length;
    int i = 0;
    while (i < j)
    {
      Scene localScene = arrayOfScene[i];
      if (CMShowPlatform.a.b(localScene)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  @JvmStatic
  public static final boolean b(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "file");
    String str = paramFile.getAbsolutePath();
    if (!paramFile.exists())
    {
      paramFile = new StringBuilder();
      paramFile.append("ErrorInfo-> ");
      paramFile.append(str);
      paramFile.append(" NOT exist.");
      QLog.d("[cmshow]CMResUtil", 2, paramFile.toString());
      return false;
    }
    if (paramFile.length() == 0L)
    {
      SpriteUtil.a(0, new Object[] { "ErrorInfo-> ", str, ",lenght is 0." });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ErrorInfo-> ");
      localStringBuilder.append(str);
      localStringBuilder.append(", length is 0.");
      QLog.d("[cmshow]CMResUtil", 2, localStringBuilder.toString());
      paramFile.delete();
      return false;
    }
    return true;
  }
  
  @JvmStatic
  public static final boolean c()
  {
    Scene[] arrayOfScene = Scene.values();
    int j = arrayOfScene.length;
    int i = 0;
    while (i < j)
    {
      Scene localScene = arrayOfScene[i];
      if (CMShowPlatform.a.c(localScene) == EngineType.BK) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  @Nullable
  public final String a(@Nullable File paramFile)
  {
    try
    {
      localStringBuilder = new StringBuilder();
      Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
      paramFile = new BufferedReader((Reader)new InputStreamReader((InputStream)new FileInputStream(paramFile)));
      for (;;)
      {
        String str = paramFile.readLine();
        localObjectRef.element = str;
        if (str == null) {
          break;
        }
        localStringBuilder.append((String)localObjectRef.element);
      }
      paramFile.close();
      paramFile = localStringBuilder.toString();
      return paramFile;
    }
    catch (Exception paramFile)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fileToString error, ");
      localStringBuilder.append(paramFile);
      QLog.e("[cmshow]CMResUtil", 1, localStringBuilder.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.util.CMResUtil
 * JD-Core Version:    0.7.0.1
 */