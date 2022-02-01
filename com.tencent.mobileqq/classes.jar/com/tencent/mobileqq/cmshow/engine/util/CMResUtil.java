package com.tencent.mobileqq.cmshow.engine.util;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/util/CMResUtil;", "", "()V", "ACTION_BASE_URL", "", "ACTION_RES_NONE_PREFIX", "ACTION_RES_PREFIX", "AUDIO_BASE_URL", "BASE_JS_PREFIX", "DRAWER_URL", "DRESS_BASE_URL", "DRESS_RES_PREFIX", "EXTENSION_RES_PREFIX", "INVALID_ASSETS_MAYBE", "", "POSTFIX_ANDROID", "POSTFIX_AUDIO", "POSTFIX_ZIP", "ROLE_BASE_URL", "ROLE_RES_PREFIX", "SLAVE_RES_PREFIX", "TAG", "anySceneRunOnCrossEngine", "", "check2DActionRes", "personNum", "", "dirPath", "check2DRoleRes", "id", "dirFile", "Ljava/io/File;", "check3DActionRes", "check3DFaceRes", "faceData", "check3DRoleRes", "checkAssetsRes", "jsonObject", "Lorg/json/JSONObject;", "baseFile", "checkBK3DActionRes", "checkBKDressRes", "checkCE3DActionRes", "checkCE3DInfoJsonRes", "resType", "checkCEDressRes", "checkDressRes", "checkMaterialRes", "checkResVersion", "checkRoleRes", "checkRoomRes", "fileToString", "file", "getActionBaseUrl", "getApolloDrawerUrl", "actionId", "getApolloFileDir", "dirType", "getApolloTabUrl", "actionPackage", "Lcom/tencent/mobileqq/apollo/model/ApolloActionPackage;", "getCEMakeupProperty", "path", "getCEMaterialFiles", "getCEMeshFile", "getDressBaseUrl", "getRealResUrl", "getRoleBaseUrl", "is3DActionPathRscDone", "actionPath", "is3DRes", "isActionDone", "data", "Lcom/tencent/mobileqq/apollo/model/ApolloActionData;", "isActionPanelFrameResDone", "isActionPathRscDone", "isActionResDone", "rscType", "isCEEngine", "isConfigJsonExists", "isFileExistAndLenNot0", "fileFullPath", "isRandomSubActionDone", "isPear", "subActionId", "isDivisionPlatform", "isResourceDone", "rscId", "isSpecialActionResDone", "isWhiteFaceActionRscDone", "subType", "isGroup", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CMResUtil
{
  public static final CMResUtil a;
  private static final List<String> a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqCmshowEngineUtilCMResUtil = new CMResUtil();
    jdField_a_of_type_JavaUtilList = CollectionsKt.listOf(".DS_Store");
  }
  
  @JvmStatic
  @NotNull
  public static final String a(int paramInt1, int paramInt2)
  {
    if (c(paramInt2)) {
      localObject = "/android.zip";
    } else {
      localObject = "/d.zip";
    }
    StringBuilder localStringBuilder;
    if (paramInt1 == 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_ComTencentMobileqqCmshowEngineUtilCMResUtil.e(paramInt2));
      localStringBuilder.append(paramInt2);
      localStringBuilder.append((String)localObject);
      return localStringBuilder.toString();
    }
    if (paramInt1 == 2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_ComTencentMobileqqCmshowEngineUtilCMResUtil.d(paramInt2));
      localStringBuilder.append(paramInt2);
      localStringBuilder.append((String)localObject);
      return localStringBuilder.toString();
    }
    if (paramInt1 == 3)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(jdField_a_of_type_ComTencentMobileqqCmshowEngineUtilCMResUtil.a(paramInt2));
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("/d.zip");
      return ((StringBuilder)localObject).toString();
    }
    if (paramInt1 == 4)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_common_data/apollo_audio_");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(".amr");
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getRealResUrl recognize Type->");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" id->");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.d("[cmshow]CMResUtil", 2, ((StringBuilder)localObject).toString());
    return "";
  }
  
  @JvmStatic
  @Nullable
  public static final String a(@Nullable ApolloActionPackage paramApolloActionPackage)
  {
    return null;
  }
  
  private final String a(File paramFile)
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
  
  @JvmStatic
  public static final boolean a()
  {
    return (b()) || (CmShowWnsUtils.w());
  }
  
  @JvmStatic
  public static final boolean a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[checkDressRes], dressId:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("[cmshow]CMResUtil", 2, ((StringBuilder)localObject).toString());
    localObject = new File(CMGetResPathUtil.b(paramInt));
    StringBuilder localStringBuilder;
    if (paramInt < 21)
    {
      localObject = ApolloConstant.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("/def/basic/dress/");
      localStringBuilder.append(paramInt);
      localObject = new File((String)localObject, localStringBuilder.toString());
    }
    if (!((File)localObject).exists())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dir NOT exist.");
      localStringBuilder.append(((File)localObject).getPath());
      QLog.d("[cmshow]CMResUtil", 2, localStringBuilder.toString());
      return false;
    }
    if (a()) {
      return jdField_a_of_type_ComTencentMobileqqCmshowEngineUtilCMResUtil.b(paramInt, (File)localObject);
    }
    return jdField_a_of_type_ComTencentMobileqqCmshowEngineUtilCMResUtil.a(paramInt, (File)localObject);
  }
  
  @JvmStatic
  public static final boolean a(int paramInt1, int paramInt2)
  {
    Object localObject1 = new File(CMGetResPathUtil.c(paramInt1));
    Object localObject2;
    if (!((File)localObject1).exists())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isActionResDone dir NOT exist.");
      ((StringBuilder)localObject2).append(((File)localObject1).getPath());
      QLog.w("[cmshow]CMResUtil", 1, ((StringBuilder)localObject2).toString());
      return false;
    }
    StringBuilder localStringBuilder;
    boolean bool;
    if (c(paramInt1))
    {
      localObject2 = jdField_a_of_type_ComTencentMobileqqCmshowEngineUtilCMResUtil;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((File)localObject1).getAbsolutePath());
      localStringBuilder.append(File.separator);
      bool = ((CMResUtil)localObject2).b(paramInt2, localStringBuilder.toString());
    }
    else
    {
      localObject2 = jdField_a_of_type_ComTencentMobileqqCmshowEngineUtilCMResUtil;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((File)localObject1).getAbsolutePath());
      localStringBuilder.append(File.separator);
      bool = ((CMResUtil)localObject2).a(paramInt2, localStringBuilder.toString());
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("isActionResDone, actionId:");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(", personNum:");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(", result:");
    ((StringBuilder)localObject1).append(bool);
    QLog.i("[cmshow]CMResUtil", 1, ((StringBuilder)localObject1).toString());
    return bool;
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
      QLog.d("[cmshow]CMResUtil", 2, ((StringBuilder)localObject2).toString());
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
    if (c(paramInt1))
    {
      localObject2 = jdField_a_of_type_ComTencentMobileqqCmshowEngineUtilCMResUtil;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "subDirName");
      bool = ((CMResUtil)localObject2).b(paramInt3, (String)localObject1);
    }
    else
    {
      localObject2 = jdField_a_of_type_ComTencentMobileqqCmshowEngineUtilCMResUtil;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "subDirName");
      bool = ((CMResUtil)localObject2).a(paramInt3, (String)localObject1);
    }
    QLog.d("[cmshow]CMResUtil", 2, new Object[] { "isWhiteFaceActionRscDone, actionId:", Integer.valueOf(paramInt1), ",subType:", Integer.valueOf(paramInt2), ",personNum:", Integer.valueOf(paramInt3), ",isGroup:", Boolean.valueOf(paramBoolean), "check result:", Boolean.valueOf(bool) });
    return bool;
  }
  
  private final boolean a(int paramInt, File paramFile)
  {
    boolean bool2 = c(paramInt);
    boolean bool1 = true;
    StringBuilder localStringBuilder;
    if (bool2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFile.getAbsolutePath());
      localStringBuilder.append("/");
      localStringBuilder.append("dress.bin");
      if (d(localStringBuilder.toString())) {
        return bool1;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFile.getAbsolutePath());
      localStringBuilder.append("/");
      localStringBuilder.append("face.json");
      if (d(localStringBuilder.toString())) {
        return true;
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFile.getAbsolutePath());
      localStringBuilder.append("/");
      localStringBuilder.append("dress.json");
      if (d(localStringBuilder.toString()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramFile.getAbsolutePath());
        localStringBuilder.append("/");
        localStringBuilder.append("dress.atlas");
        if (d(localStringBuilder.toString()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramFile.getAbsolutePath());
          localStringBuilder.append("/");
          localStringBuilder.append("dress.png");
          if (d(localStringBuilder.toString())) {
            return true;
          }
        }
      }
    }
    bool1 = false;
    return bool1;
  }
  
  private final boolean a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("action/action.json");
    boolean bool1 = d(localStringBuilder.toString());
    boolean bool3 = false;
    if (bool1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("action/action.atlas");
      if (d(localStringBuilder.toString()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("action/action.png");
        if (d(localStringBuilder.toString()))
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
        if (d(localStringBuilder.toString()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("action_peer/action.atlas");
          bool2 = bool3;
          if (d(localStringBuilder.toString()))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString);
            localStringBuilder.append("action_peer/action.png");
            bool2 = bool3;
            if (d(localStringBuilder.toString())) {
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
      QLog.e("[cmshow]CMResUtil", 1, localStringBuilder.toString());
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((File)localObject).getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("action.json");
    paramBoolean1 = paramBoolean2;
    if (d(localStringBuilder.toString()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((File)localObject).getAbsolutePath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("action.atlas");
      paramBoolean1 = paramBoolean2;
      if (d(localStringBuilder.toString()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(((File)localObject).getAbsolutePath());
        localStringBuilder.append(File.separator);
        localStringBuilder.append("action.png");
        paramBoolean1 = paramBoolean2;
        if (d(localStringBuilder.toString())) {
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
    boolean bool = FileUtil.b(CMGetResPathUtil.a(paramApolloActionData, 0));
    if (!a(paramApolloActionData.actionId, paramApolloActionData.personNum)) {
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
      QLog.d("[cmshow]CMResUtil", 2, localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  private final boolean a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("action/");
    localStringBuilder.append("action.bin");
    boolean bool3 = d(localStringBuilder.toString());
    if (paramInt != 0)
    {
      boolean bool2 = false;
      if (paramInt != 1) {
        return false;
      }
      boolean bool1 = bool2;
      if (bool3)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("action_peer/");
        localStringBuilder.append("action.bin");
        bool1 = bool2;
        if (d(localStringBuilder.toString())) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return bool3;
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
          l = CmShowWnsUtils.c();
        }
      }
      else {
        l = CmShowWnsUtils.d();
      }
    }
    else {
      l = CmShowWnsUtils.b();
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
        if (!d(localStringBuilder.toString()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("file not exist or length 0 ");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(paramJSONObject);
          QLog.e("[cmshow]CMResUtil", 1, ((StringBuilder)localObject).toString());
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  @JvmStatic
  @Nullable
  public static final String b(int paramInt)
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
  private static final boolean b()
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
  public static final boolean b(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[checkRoleRes], roleId:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("[cmshow]CMResUtil", 2, ((StringBuilder)localObject).toString());
    StringBuilder localStringBuilder;
    if (paramInt == 0)
    {
      if (a())
      {
        localObject = new File(ApolloConstant.jdField_a_of_type_JavaLangString, "/def/role/0/3D/android/skeleton");
      }
      else
      {
        localObject = ApolloConstant.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("/def/basic/skeleton/");
        localStringBuilder.append(paramInt);
        localObject = new File((String)localObject, localStringBuilder.toString());
      }
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
      QLog.d("[cmshow]CMResUtil", 2, localStringBuilder.toString());
      return false;
    }
    if (((paramInt == 0) && (a())) || (c(paramInt))) {
      return jdField_a_of_type_ComTencentMobileqqCmshowEngineUtilCMResUtil.d(paramInt, (File)localObject);
    }
    return jdField_a_of_type_ComTencentMobileqqCmshowEngineUtilCMResUtil.c(paramInt, (File)localObject);
  }
  
  @JvmStatic
  public static final boolean b(int paramInt1, int paramInt2)
  {
    Object localObject = new File(CMGetResPathUtil.a(paramInt1));
    if (!((File)localObject).exists())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isActionPanelFrameResDone, dir NOT exist.");
      localStringBuilder.append(((File)localObject).getPath());
      QLog.e("[cmshow]CMResUtil", 1, localStringBuilder.toString());
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((File)localObject).getAbsolutePath());
    localStringBuilder.append("/");
    localObject = localStringBuilder.toString();
    if (c(paramInt1)) {
      return jdField_a_of_type_ComTencentMobileqqCmshowEngineUtilCMResUtil.b(paramInt2, (String)localObject);
    }
    return jdField_a_of_type_ComTencentMobileqqCmshowEngineUtilCMResUtil.a(paramInt2, (String)localObject);
  }
  
  private final boolean b(int paramInt, File paramFile)
  {
    boolean bool3 = c(paramInt);
    boolean bool1 = false;
    boolean bool2 = false;
    if (!bool3)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFile.getAbsolutePath());
      localStringBuilder.append("/");
      localStringBuilder.append("dress.json");
      bool1 = bool2;
      if (d(localStringBuilder.toString()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramFile.getAbsolutePath());
        localStringBuilder.append("/");
        localStringBuilder.append("dress.atlas");
        bool1 = bool2;
        if (d(localStringBuilder.toString()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramFile.getAbsolutePath());
          localStringBuilder.append("/");
          localStringBuilder.append("dress.png");
          bool1 = bool2;
          if (d(localStringBuilder.toString())) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile.getAbsolutePath());
    localStringBuilder.append(File.separator);
    if (!c(localStringBuilder.toString(), 2))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFile.getAbsolutePath());
      localStringBuilder.append("/");
      localStringBuilder.append("face.json");
      if (!d(localStringBuilder.toString())) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  private final boolean b(int paramInt, String paramString)
  {
    if (a()) {
      return b(paramString, paramInt);
    }
    return a(paramString, paramInt);
  }
  
  @JvmStatic
  public static final boolean b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "actionPath");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[isSpecialActionResDone], actionPath:");
    localStringBuilder.append(paramString);
    QLog.d("[cmshow]CMResUtil", 2, localStringBuilder.toString());
    paramString = new File(paramString);
    boolean bool1 = paramString.exists();
    boolean bool2 = false;
    if (!bool1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dir NOT exist.");
      localStringBuilder.append(paramString.getPath());
      QLog.d("[cmshow]CMResUtil", 2, localStringBuilder.toString());
      return false;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.getAbsolutePath());
    localStringBuilder.append("/");
    localStringBuilder.append("action/action.json");
    bool1 = bool2;
    if (d(localStringBuilder.toString()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.getAbsolutePath());
      localStringBuilder.append("/");
      localStringBuilder.append("action/action.atlas");
      bool1 = bool2;
      if (d(localStringBuilder.toString()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString.getAbsolutePath());
        localStringBuilder.append("/");
        localStringBuilder.append("action/action.png");
        bool1 = bool2;
        if (d(localStringBuilder.toString())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private final boolean b(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("action/");
    boolean bool3 = c(localStringBuilder.toString(), 3);
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
        if (c(paramString, 3)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return bool3;
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
        if (jdField_a_of_type_JavaUtilList.contains(paramJSONObject))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkAssetsRes skip check assets ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(paramJSONObject);
          QLog.w("[cmshow]CMResUtil", 1, localStringBuilder.toString());
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append(paramJSONObject);
          if (!d(localStringBuilder.toString()))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("file not exist or length 0 ");
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(paramJSONObject);
            QLog.e("[cmshow]CMResUtil", 1, ((StringBuilder)localObject).toString());
            return false;
          }
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  @JvmStatic
  @Nullable
  public static final String c(int paramInt)
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
    return ApolloConstant.jdField_a_of_type_JavaLangString;
  }
  
  @JvmStatic
  public static final boolean c(int paramInt)
  {
    return paramInt >= ApolloConstant.jdField_a_of_type_Int;
  }
  
  @JvmStatic
  public static final boolean c(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2) {
        return false;
      }
      return a(paramInt2);
    }
    return b(paramInt2);
  }
  
  private final boolean c(int paramInt, File paramFile)
  {
    boolean bool1 = e(paramInt, paramFile);
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile.getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("role.json");
    bool1 = bool2;
    if (d(localStringBuilder.toString()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFile.getAbsolutePath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("role.atlas");
      bool1 = bool2;
      if (d(localStringBuilder.toString()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramFile.getAbsolutePath());
        localStringBuilder.append(File.separator);
        localStringBuilder.append("role.png");
        bool1 = bool2;
        if (d(localStringBuilder.toString())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  @JvmStatic
  public static final boolean c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "actionPath");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[is3DActionPathRscDone], actionPath:");
    localStringBuilder.append(paramString);
    QLog.d("[cmshow]CMResUtil", 2, localStringBuilder.toString());
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dir NOT exist.");
      localStringBuilder.append(paramString.getPath());
      QLog.d("[cmshow]CMResUtil", 2, localStringBuilder.toString());
      return false;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.getAbsolutePath());
    localStringBuilder.append("/action/");
    localStringBuilder.append("action.bin");
    return d(localStringBuilder.toString());
  }
  
  private final boolean c(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("info.json");
    localObject = ((StringBuilder)localObject).toString();
    if (!d((String)localObject))
    {
      paramString = new StringBuilder();
      paramString.append("file not exist or length 0 ");
      paramString.append((String)localObject);
      QLog.e("[cmshow]CMResUtil", 1, paramString.toString());
      return false;
    }
    String str = a(new File((String)localObject));
    if (str != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkCE3DInfoJsonRes, infoPath:");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(", content: ");
        localStringBuilder.append(str);
        QLog.i("[cmshow]CMResUtil", 4, localStringBuilder.toString());
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
        QLog.e("[cmshow]CMResUtil", 1, ((StringBuilder)localObject).toString());
      }
    }
    return false;
  }
  
  private final String d(int paramInt)
  {
    if ((c(paramInt)) && (a()))
    {
      String str = CmShowWnsUtils.c();
      Intrinsics.checkExpressionValueIsNotNull(str, "CmShowWnsUtils.getCrossEngineDressUrl()");
      return str;
    }
    return "https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_item_";
  }
  
  @JvmStatic
  public static final boolean d(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt2 > ApolloConstant.jdField_a_of_type_Int) {
      i = 1;
    } else {
      i = 0;
    }
    String str;
    if (paramInt1 != 5) {
      str = "";
    } else {
      str = CMGetResPathUtil.d(paramInt2);
    }
    if (i != 0) {
      return c(str);
    }
    return b(str);
  }
  
  private final boolean d(int paramInt, File paramFile)
  {
    if (a())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFile.getAbsolutePath());
      localStringBuilder.append(File.separator);
      return c(localStringBuilder.toString(), 1);
    }
    if (!e(paramInt, paramFile)) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile.getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("skeleton.bin");
    return d(localStringBuilder.toString());
  }
  
  @JvmStatic
  public static final boolean d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "fileFullPath");
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return false;
    }
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ErrorInfo-> ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" NOT exist.");
      QLog.d("[cmshow]CMResUtil", 2, ((StringBuilder)localObject).toString());
      return false;
    }
    if (((File)localObject).length() == 0L)
    {
      SpriteUtil.a(0, new Object[] { "ErrorInfo-> ", paramString, ",lenght is 0." });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ErrorInfo-> ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", length is 0.");
      QLog.d("[cmshow]CMResUtil", 2, localStringBuilder.toString());
      ((File)localObject).delete();
      return false;
    }
    return true;
  }
  
  private final String e(int paramInt)
  {
    if (((paramInt == 0) || (c(paramInt))) && (a()))
    {
      String str = CmShowWnsUtils.a();
      Intrinsics.checkExpressionValueIsNotNull(str, "CmShowWnsUtils.getCrossEngineRoleUrl()");
      return str;
    }
    return "https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_role_";
  }
  
  private final boolean e(int paramInt, File paramFile)
  {
    paramFile = new File(paramFile, "config.json");
    if ((paramInt != 0) && (!paramFile.exists()))
    {
      SpriteUtil.a(0, new Object[] { "ROLE_FILE_CONFIG_NAME NOT exist.", paramFile.getPath() });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ROLE_FILE_CONFIG_NAME NOT exist.");
      localStringBuilder.append(paramFile.getPath());
      QLog.d("[cmshow]CMResUtil", 2, localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  @NotNull
  public final String a(int paramInt)
  {
    if ((c(paramInt)) && (a()))
    {
      String str = CmShowWnsUtils.b();
      Intrinsics.checkExpressionValueIsNotNull(str, "CmShowWnsUtils.getCrossEngineActionUrl()");
      return str;
    }
    return "https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.util.CMResUtil
 * JD-Core Version:    0.7.0.1
 */