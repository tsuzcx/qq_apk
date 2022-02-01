package com.tencent.mobileqq.cmshow.crossengine.resource.util;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/resource/util/CEResUtil;", "", "()V", "ACTION_BASE_URL", "", "AUDIO_BASE_URL", "DRAWER_URL", "DRESS_BASE_URL", "INVALID_ASSETS_MAYBE", "", "ROLE_BASE_URL", "TAG", "actionVersionConfig", "Lorg/json/JSONObject;", "dressVersionConfig", "roleVersionConfig", "check2DActionRes", "", "personNum", "", "dirPath", "check2DRoleRes", "id", "dirFile", "Ljava/io/File;", "check3DActionRes", "check3DFaceRes", "faceData", "check3DRole0Res", "check3DRoleRes", "checkAssetsRes", "jsonObject", "baseFile", "checkCE3DInfoJsonRes", "resType", "checkDressRes", "checkMaterialRes", "checkResVersion", "checkRoleRes", "getActionBaseUrl", "getApolloDrawerUrl", "actionId", "getApolloFileDir", "dirType", "getCEMakeupProperty", "path", "getCEMaterialFiles", "getCEMeshFile", "getDressBaseUrl", "getRealResUrl", "getRoleBaseUrl", "is3DActionPathRscDone", "actionPath", "isActionDone", "data", "Lcom/tencent/mobileqq/apollo/model/ApolloActionData;", "isActionPanelFrameResDone", "isActionPathRscDone", "isActionResDone", "isConfigJsonExists", "isRandomSubActionDone", "isPear", "subActionId", "isDivisionPlatform", "isResourceDone", "rscType", "rscId", "isSpecialActionResDone", "isWhiteFaceActionRscDone", "subType", "isGroup", "recordResVersion", "", "useDebugBetaRes", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CEResUtil
{
  public static final CEResUtil a = new CEResUtil();
  private static final List<String> b = CollectionsKt.listOf(".DS_Store");
  private static JSONObject c;
  private static JSONObject d;
  private static JSONObject e;
  
  @JvmStatic
  @NotNull
  public static final String a(int paramInt1, int paramInt2)
  {
    Object localObject1 = "/android.zip";
    Object localObject2 = null;
    JSONObject localJSONObject = null;
    Object localObject3 = null;
    if (paramInt1 == 1)
    {
      localJSONObject = c;
      localObject2 = localObject3;
      if (localJSONObject != null) {
        localObject2 = localJSONObject.optString(String.valueOf(paramInt2));
      }
      if (!CMResUtil.a(paramInt2)) {
        localObject1 = "/d.zip";
      }
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(a.g(paramInt2));
        ((StringBuilder)localObject2).append(paramInt2);
        ((StringBuilder)localObject2).append((String)localObject1);
        return ((StringBuilder)localObject2).toString();
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(a.g(paramInt2));
      ((StringBuilder)localObject3).append(paramInt2);
      ((StringBuilder)localObject3).append('_');
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append((String)localObject1);
      return ((StringBuilder)localObject3).toString();
    }
    if (paramInt1 == 2)
    {
      if (!CMResUtil.a(paramInt2)) {
        localObject1 = "/d.zip";
      }
      localObject3 = d;
      if (localObject3 != null) {
        localObject2 = ((JSONObject)localObject3).optString(String.valueOf(paramInt2));
      }
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(a.f(paramInt2));
        ((StringBuilder)localObject2).append(paramInt2);
        ((StringBuilder)localObject2).append((String)localObject1);
        return ((StringBuilder)localObject2).toString();
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(a.f(paramInt2));
      ((StringBuilder)localObject3).append(paramInt2);
      ((StringBuilder)localObject3).append('_');
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append((String)localObject1);
      return ((StringBuilder)localObject3).toString();
    }
    if (paramInt1 == 3)
    {
      localObject2 = e;
      localObject1 = localJSONObject;
      if (localObject2 != null) {
        localObject1 = ((JSONObject)localObject2).optString(String.valueOf(paramInt2));
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(a.a(paramInt2));
        ((StringBuilder)localObject1).append(paramInt2);
        ((StringBuilder)localObject1).append("/d.zip");
        return ((StringBuilder)localObject1).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(a.a(paramInt2));
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append('_');
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("/d.zip");
      return ((StringBuilder)localObject2).toString();
    }
    if (paramInt1 == 4)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_common_data/apollo_audio_");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(".amr");
      return ((StringBuilder)localObject1).toString();
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getRealResUrl recognize Type->");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(" id->");
    ((StringBuilder)localObject1).append(paramInt2);
    QLog.d("[cmshow]CEResUtil", 2, ((StringBuilder)localObject1).toString());
    return "";
  }
  
  @JvmStatic
  public static final boolean a()
  {
    File localFile = new File(ApolloConstant.a, "/def/role/0/3D/android/skeleton");
    if (!localFile.exists())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("check3DRole0Res dir NOT exist.");
      localStringBuilder.append(localFile.getPath());
      QLog.e("[cmshow]CEResUtil", 1, localStringBuilder.toString());
      return false;
    }
    return a.b(0, localFile);
  }
  
  @JvmStatic
  public static final boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append("/action");
    localObject1 = new File(((StringBuilder)localObject1).toString());
    if (!((File)localObject1).exists())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isWhiteFaceActionRscDone dir NOT exist.");
      ((StringBuilder)localObject2).append(((File)localObject1).getPath());
      QLog.d("[cmshow]CEResUtil", 2, ((StringBuilder)localObject2).toString());
      return false;
    }
    localObject1 = ((File)localObject1).getAbsolutePath();
    Object localObject2 = localObject1;
    if (paramBoolean)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("/group");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    if (paramInt2 == 1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("/main/");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else if (paramInt2 == 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("/pre/");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = localObject2;
      if (paramInt2 == 2)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("/post/");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    boolean bool;
    if (CMResUtil.a(paramInt1))
    {
      localObject2 = a;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "subDirName");
      bool = ((CEResUtil)localObject2).b(paramInt3, (String)localObject1);
    }
    else
    {
      localObject2 = a;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "subDirName");
      bool = ((CEResUtil)localObject2).a(paramInt3, (String)localObject1);
    }
    QLog.d("[cmshow]CEResUtil", 2, new Object[] { "isWhiteFaceActionRscDone, actionId:", Integer.valueOf(paramInt1), ",subType:", Integer.valueOf(paramInt2), ",personNum:", Integer.valueOf(paramInt3), ",isGroup:", Boolean.valueOf(paramBoolean), "check result:", Boolean.valueOf(bool) });
    return bool;
  }
  
  private final boolean a(int paramInt, File paramFile)
  {
    boolean bool1 = c(paramInt, paramFile);
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile.getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("role.json");
    bool1 = bool2;
    if (CMResUtil.a(localStringBuilder.toString()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFile.getAbsolutePath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("role.atlas");
      bool1 = bool2;
      if (CMResUtil.a(localStringBuilder.toString()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramFile.getAbsolutePath());
        localStringBuilder.append(File.separator);
        localStringBuilder.append("role.png");
        bool1 = bool2;
        if (CMResUtil.a(localStringBuilder.toString())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private final boolean a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("action/action.json");
    boolean bool1 = CMResUtil.a(localStringBuilder.toString());
    boolean bool3 = false;
    if (bool1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("action/action.atlas");
      if (CMResUtil.a(localStringBuilder.toString()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("action/action.png");
        if (CMResUtil.a(localStringBuilder.toString()))
        {
          bool1 = true;
          break label120;
        }
      }
    }
    bool1 = false;
    label120:
    boolean bool2;
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return false;
      }
      bool2 = bool3;
      if (bool1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("action_peer/action.json");
        bool2 = bool3;
        if (CMResUtil.a(localStringBuilder.toString()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("action_peer/action.atlas");
          bool2 = bool3;
          if (CMResUtil.a(localStringBuilder.toString()))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString);
            localStringBuilder.append("action_peer/action.png");
            bool2 = bool3;
            if (CMResUtil.a(localStringBuilder.toString())) {
              return true;
            }
          }
        }
      }
    }
    else
    {
      bool2 = bool1;
    }
    return bool2;
  }
  
  @JvmStatic
  public static final boolean a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
    ((StringBuilder)localObject).append(paramInt1);
    localObject = new StringBuilder(((StringBuilder)localObject).toString());
    ((StringBuilder)localObject).append(File.separator);
    if (paramBoolean1) {
      ((StringBuilder)localObject).append("action_peer");
    } else {
      ((StringBuilder)localObject).append("action");
    }
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("action");
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramInt2);
    if (paramBoolean2)
    {
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("android");
    }
    localObject = new File(((StringBuilder)localObject).toString());
    paramBoolean1 = ((File)localObject).exists();
    paramBoolean2 = false;
    if (!paramBoolean1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dir NOT exist.");
      localStringBuilder.append(((File)localObject).getPath());
      QLog.e("[cmshow]CEResUtil", 1, localStringBuilder.toString());
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((File)localObject).getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("action.json");
    paramBoolean1 = paramBoolean2;
    if (CMResUtil.a(localStringBuilder.toString()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((File)localObject).getAbsolutePath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("action.atlas");
      paramBoolean1 = paramBoolean2;
      if (CMResUtil.a(localStringBuilder.toString()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(((File)localObject).getAbsolutePath());
        localStringBuilder.append(File.separator);
        localStringBuilder.append("action.png");
        paramBoolean1 = paramBoolean2;
        if (CMResUtil.a(localStringBuilder.toString())) {
          paramBoolean1 = true;
        }
      }
    }
    return paramBoolean1;
  }
  
  @JvmStatic
  public static final boolean a(@Nullable ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData == null) {
      return false;
    }
    boolean bool = FileUtil.d(CEGetResPathUtil.a(paramApolloActionData, 0));
    if (!b(paramApolloActionData.actionId, paramApolloActionData.personNum)) {
      return false;
    }
    return bool;
  }
  
  @JvmStatic
  public static final boolean a(@Nullable String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return true;
    }
    paramString = MD5Utils.toMD5(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress//face/");
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(".zip");
    paramString = new File(localStringBuilder.toString());
    if (!paramString.exists())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ErrorInfo-> ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" NOT exist.");
      QLog.d("[cmshow]CEResUtil", 2, localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  private final boolean a(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("info.json");
    localObject = ((StringBuilder)localObject).toString();
    if (!CMResUtil.a((String)localObject))
    {
      paramString = new StringBuilder();
      paramString.append("file not exist or length 0 ");
      paramString.append((String)localObject);
      QLog.e("[cmshow]CEResUtil", 1, paramString.toString());
      return false;
    }
    String str = CMResUtil.a.a(new File((String)localObject));
    if (str != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkCE3DInfoJsonRes, infoPath:");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(", content: ");
        localStringBuilder.append(str);
        QLog.i("[cmshow]CEResUtil", 4, localStringBuilder.toString());
      }
      try
      {
        localObject = new JSONObject(str);
        if (!b((JSONObject)localObject, paramString)) {
          return false;
        }
        if (!a((JSONObject)localObject, paramString)) {
          return false;
        }
        boolean bool = a((JSONObject)localObject, paramInt);
        return bool;
      }
      catch (Exception paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkCE3DInfoJsonRes error, ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("[cmshow]CEResUtil", 1, ((StringBuilder)localObject).toString());
      }
    }
    return false;
  }
  
  private final boolean a(JSONObject paramJSONObject, int paramInt)
  {
    long l;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          l = 0L;
        } else {
          l = CmShowWnsUtils.N();
        }
      }
      else {
        l = CmShowWnsUtils.O();
      }
    }
    else {
      l = CmShowWnsUtils.M();
    }
    return paramJSONObject.optLong("assets_version", 0L) >= l;
  }
  
  private final boolean a(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = paramJSONObject.optJSONArray("material");
    if ((localObject != null) && (((JSONArray)localObject).length() > 0))
    {
      int j = ((JSONArray)localObject).length();
      int i = 0;
      while (i < j)
      {
        paramJSONObject = ((JSONArray)localObject).getString(i);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(paramJSONObject);
        if (!CMResUtil.a(localStringBuilder.toString()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("file not exist or length 0 ");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(paramJSONObject);
          QLog.e("[cmshow]CEResUtil", 1, ((StringBuilder)localObject).toString());
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  @JvmStatic
  public static final void b()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(ApolloConstant.k);
    ((StringBuilder)localObject1).append("/Contents/info.json");
    localObject1 = ((StringBuilder)localObject1).toString();
    if (!CMResUtil.a((String)localObject1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("recordResVersion file not exist or length 0 ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.e("[cmshow]CEResUtil", 1, ((StringBuilder)localObject2).toString());
      return;
    }
    Object localObject2 = CMResUtil.a.a(new File((String)localObject1));
    if (localObject2 != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("recordResVersion, infoPath:");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(", content: ");
        localStringBuilder.append((String)localObject2);
        QLog.i("[cmshow]CEResUtil", 4, localStringBuilder.toString());
      }
      try
      {
        localObject1 = new JSONObject((String)localObject2);
        c = ((JSONObject)localObject1).optJSONObject("roleVersionMap");
        d = ((JSONObject)localObject1).optJSONObject("dressVersionMap");
        e = ((JSONObject)localObject1).optJSONObject("actionVersionMap");
        return;
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("recordResVersion error, ");
        ((StringBuilder)localObject2).append(localException);
        QLog.e("[cmshow]CEResUtil", 1, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  @JvmStatic
  public static final boolean b(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[checkDressRes], dressId:");
    ((StringBuilder)localObject1).append(paramInt);
    QLog.d("[cmshow]CEResUtil", 2, ((StringBuilder)localObject1).toString());
    localObject1 = new File(CEGetResPathUtil.b(paramInt));
    if (paramInt < 21)
    {
      localObject1 = ApolloConstant.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("/def/basic/dress/");
      ((StringBuilder)localObject2).append(paramInt);
      localObject1 = new File((String)localObject1, ((StringBuilder)localObject2).toString());
    }
    if (!((File)localObject1).exists())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("dir NOT exist.");
      ((StringBuilder)localObject2).append(((File)localObject1).getPath());
      QLog.d("[cmshow]CEResUtil", 2, ((StringBuilder)localObject2).toString());
      return false;
    }
    boolean bool2 = CMResUtil.a(paramInt);
    boolean bool1 = true;
    if (!bool2)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
      ((StringBuilder)localObject2).append("/");
      ((StringBuilder)localObject2).append("dress.json");
      if (CMResUtil.a(((StringBuilder)localObject2).toString()))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
        ((StringBuilder)localObject2).append("/");
        ((StringBuilder)localObject2).append("dress.atlas");
        if (CMResUtil.a(((StringBuilder)localObject2).toString()))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
          ((StringBuilder)localObject2).append("/");
          ((StringBuilder)localObject2).append("dress.png");
          if (CMResUtil.a(((StringBuilder)localObject2).toString())) {
            return true;
          }
        }
      }
      return false;
    }
    Object localObject2 = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((File)localObject1).getAbsolutePath());
    localStringBuilder.append(File.separator);
    if (!((CEResUtil)localObject2).a(localStringBuilder.toString(), 2))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
      ((StringBuilder)localObject2).append("/");
      ((StringBuilder)localObject2).append("face.json");
      if (CMResUtil.a(((StringBuilder)localObject2).toString())) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  @JvmStatic
  public static final boolean b(int paramInt1, int paramInt2)
  {
    Object localObject1 = new File(CEGetResPathUtil.c(paramInt1));
    Object localObject2;
    if (!((File)localObject1).exists())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isActionResDone dir NOT exist.");
      ((StringBuilder)localObject2).append(((File)localObject1).getPath());
      QLog.w("[cmshow]CEResUtil", 1, ((StringBuilder)localObject2).toString());
      return false;
    }
    StringBuilder localStringBuilder;
    boolean bool;
    if (CMResUtil.a(paramInt1))
    {
      localObject2 = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((File)localObject1).getAbsolutePath());
      localStringBuilder.append(File.separator);
      bool = ((CEResUtil)localObject2).b(paramInt2, localStringBuilder.toString());
    }
    else
    {
      localObject2 = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((File)localObject1).getAbsolutePath());
      localStringBuilder.append(File.separator);
      bool = ((CEResUtil)localObject2).a(paramInt2, localStringBuilder.toString());
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("isActionResDone, actionId:");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(", personNum:");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(", result:");
    ((StringBuilder)localObject1).append(bool);
    QLog.i("[cmshow]CEResUtil", 1, ((StringBuilder)localObject1).toString());
    return bool;
  }
  
  private final boolean b(int paramInt, File paramFile)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile.getAbsolutePath());
    localStringBuilder.append(File.separator);
    return a(localStringBuilder.toString(), 1);
  }
  
  private final boolean b(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("action/");
    boolean bool3 = a(localStringBuilder.toString(), 3);
    if (paramInt != 0)
    {
      boolean bool2 = false;
      if (paramInt != 1) {
        return false;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("action_peer/");
      paramString = localStringBuilder.toString();
      boolean bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (a(paramString, 3)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return bool3;
  }
  
  @JvmStatic
  public static final boolean b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "actionPath");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[isSpecialActionResDone], actionPath:");
    localStringBuilder.append(paramString);
    QLog.d("[cmshow]CEResUtil", 2, localStringBuilder.toString());
    paramString = new File(paramString);
    boolean bool1 = paramString.exists();
    boolean bool2 = false;
    if (!bool1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dir NOT exist.");
      localStringBuilder.append(paramString.getPath());
      QLog.d("[cmshow]CEResUtil", 2, localStringBuilder.toString());
      return false;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.getAbsolutePath());
    localStringBuilder.append("/");
    localStringBuilder.append("action/action.json");
    bool1 = bool2;
    if (CMResUtil.a(localStringBuilder.toString()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.getAbsolutePath());
      localStringBuilder.append("/");
      localStringBuilder.append("action/action.atlas");
      bool1 = bool2;
      if (CMResUtil.a(localStringBuilder.toString()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString.getAbsolutePath());
        localStringBuilder.append("/");
        localStringBuilder.append("action/action.png");
        bool1 = bool2;
        if (CMResUtil.a(localStringBuilder.toString())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private final boolean b(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = paramJSONObject.optJSONArray("assets");
    if (localObject != null)
    {
      int j = ((JSONArray)localObject).length();
      int i = 0;
      while (i < j)
      {
        paramJSONObject = ((JSONArray)localObject).getString(i);
        StringBuilder localStringBuilder;
        if (b.contains(paramJSONObject))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkAssetsRes skip check assets ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(paramJSONObject);
          QLog.w("[cmshow]CEResUtil", 1, localStringBuilder.toString());
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append(paramJSONObject);
          if (!CMResUtil.a(localStringBuilder.toString()))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("file not exist or length 0 ");
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(paramJSONObject);
            QLog.e("[cmshow]CEResUtil", 1, ((StringBuilder)localObject).toString());
            return false;
          }
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  private final boolean c()
  {
    return false;
  }
  
  @JvmStatic
  public static final boolean c(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[checkRoleRes], roleId:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("[cmshow]CEResUtil", 2, ((StringBuilder)localObject).toString());
    StringBuilder localStringBuilder;
    if (paramInt == 0)
    {
      localObject = ApolloConstant.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("/def/basic/skeleton/");
      localStringBuilder.append(paramInt);
      localObject = new File((String)localObject, localStringBuilder.toString());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/");
      ((StringBuilder)localObject).append(paramInt);
      localObject = new File(((StringBuilder)localObject).toString());
    }
    if (!((File)localObject).exists())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dir NOT exist.");
      localStringBuilder.append(((File)localObject).getPath());
      QLog.d("[cmshow]CEResUtil", 2, localStringBuilder.toString());
      return false;
    }
    if (CMResUtil.a(paramInt)) {
      return a.b(paramInt, (File)localObject);
    }
    return a.a(paramInt, (File)localObject);
  }
  
  @JvmStatic
  public static final boolean c(int paramInt1, int paramInt2)
  {
    Object localObject = new File(CEGetResPathUtil.a(paramInt1));
    if (!((File)localObject).exists())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isActionPanelFrameResDone, dir NOT exist.");
      localStringBuilder.append(((File)localObject).getPath());
      QLog.e("[cmshow]CEResUtil", 1, localStringBuilder.toString());
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((File)localObject).getAbsolutePath());
    localStringBuilder.append("/");
    localObject = localStringBuilder.toString();
    if (CMResUtil.a(paramInt1)) {
      return a.b(paramInt2, (String)localObject);
    }
    return a.a(paramInt2, (String)localObject);
  }
  
  private final boolean c(int paramInt, File paramFile)
  {
    paramFile = new File(paramFile, "config.json");
    if ((paramInt != 0) && (!paramFile.exists()))
    {
      SpriteUtil.a(0, new Object[] { "ROLE_FILE_CONFIG_NAME NOT exist.", paramFile.getPath() });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ROLE_FILE_CONFIG_NAME NOT exist.");
      localStringBuilder.append(paramFile.getPath());
      QLog.d("[cmshow]CEResUtil", 2, localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  @JvmStatic
  public static final boolean c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "actionPath");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[is3DActionPathRscDone], actionPath:");
    localStringBuilder.append(paramString);
    QLog.d("[cmshow]CEResUtil", 2, localStringBuilder.toString());
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dir NOT exist.");
      localStringBuilder.append(paramString.getPath());
      QLog.d("[cmshow]CEResUtil", 2, localStringBuilder.toString());
      return false;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.getAbsolutePath());
    localStringBuilder.append("/action/");
    localStringBuilder.append("action__ANIM.nda");
    return CMResUtil.a(localStringBuilder.toString());
  }
  
  @JvmStatic
  @Nullable
  public static final String d(int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_drawerAction_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("/d.zip");
    return localStringBuilder.toString();
  }
  
  @JvmStatic
  public static final boolean d(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2) {
        return false;
      }
      return b(paramInt2);
    }
    return c(paramInt2);
  }
  
  @JvmStatic
  @Nullable
  public static final String e(int paramInt)
  {
    Object localObject = (String)null;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo";
      }
      localObject = new StringBuilder();
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localBaseApplicationImpl, "BaseApplicationImpl.getApplication()");
      ((StringBuilder)localObject).append(localBaseApplicationImpl.getFilesDir().toString());
      ((StringBuilder)localObject).append("");
      return ((StringBuilder)localObject).toString();
    }
    return ApolloConstant.a;
  }
  
  @JvmStatic
  public static final boolean e(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt2 > ApolloConstant.f) {
      i = 1;
    } else {
      i = 0;
    }
    String str;
    if (paramInt1 != 5) {
      str = "";
    } else {
      str = CEGetResPathUtil.d(paramInt2);
    }
    if (i != 0) {
      return c(str);
    }
    return b(str);
  }
  
  private final String f(int paramInt)
  {
    if (CMResUtil.a(paramInt))
    {
      if (c()) {
        return "https://qqshowar.gtimg.cn/cedata_only_beta/vipApollo_item_";
      }
      String str = CmShowWnsUtils.L();
      Intrinsics.checkExpressionValueIsNotNull(str, "CmShowWnsUtils.getCrossEngineDressUrl()");
      return str;
    }
    return "https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_item_";
  }
  
  private final String g(int paramInt)
  {
    if ((paramInt != 0) && (!CMResUtil.a(paramInt))) {
      return "https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_role_";
    }
    if (c()) {
      return "https://qqshowar.gtimg.cn/cedata_only_beta/vipApollo_role_";
    }
    String str = CmShowWnsUtils.J();
    Intrinsics.checkExpressionValueIsNotNull(str, "CmShowWnsUtils.getCrossEngineRoleUrl()");
    return str;
  }
  
  @NotNull
  public final String a(int paramInt)
  {
    if (CMResUtil.a(paramInt))
    {
      if (c()) {
        return "https://qqshowar.gtimg.cn/cedata_only_beta/vipApollo_action_";
      }
      String str = CmShowWnsUtils.K();
      Intrinsics.checkExpressionValueIsNotNull(str, "CmShowWnsUtils.getCrossEngineActionUrl()");
      return str;
    }
    return "https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.resource.util.CEResUtil
 * JD-Core Version:    0.7.0.1
 */