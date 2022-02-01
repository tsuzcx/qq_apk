package com.tencent.mobileqq.cmshow.brickengine.resource.util;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/brickengine/resource/util/BKResUtil;", "", "()V", "ACTION_BASE_URL", "", "AUDIO_BASE_URL", "DRAWER_URL", "DRESS_BASE_URL", "ROLE_BASE_URL", "TAG", "check2DActionRes", "", "personNum", "", "dirPath", "check2DRoleRes", "id", "dirFile", "Ljava/io/File;", "check3DActionRes", "check3DFaceRes", "faceData", "check3DRoleRes", "checkDressRes", "checkRoleRes", "getActionBaseUrl", "getApolloDrawerUrl", "actionId", "getApolloFileDir", "dirType", "getDressBaseUrl", "getRealResUrl", "resType", "getRoleBaseUrl", "is3DActionPathRscDone", "actionPath", "isActionDone", "data", "Lcom/tencent/mobileqq/apollo/model/ApolloActionData;", "isActionPanelFrameResDone", "isActionPathRscDone", "isActionResDone", "isConfigJsonExists", "isRandomSubActionDone", "isPear", "subActionId", "isDivisionPlatform", "isResourceDone", "rscType", "rscId", "isSpecialActionResDone", "isWhiteFaceActionRscDone", "subType", "isGroup", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class BKResUtil
{
  public static final BKResUtil a = new BKResUtil();
  
  @JvmStatic
  @NotNull
  public static final String a(int paramInt1, int paramInt2)
  {
    if (CMResUtil.a(paramInt2)) {
      localObject = "/android.zip";
    } else {
      localObject = "/d.zip";
    }
    StringBuilder localStringBuilder;
    if (paramInt1 == 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a.g(paramInt2));
      localStringBuilder.append(paramInt2);
      localStringBuilder.append((String)localObject);
      return localStringBuilder.toString();
    }
    if (paramInt1 == 2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a.f(paramInt2));
      localStringBuilder.append(paramInt2);
      localStringBuilder.append((String)localObject);
      return localStringBuilder.toString();
    }
    if (paramInt1 == 3)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(a.a(paramInt2));
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
    QLog.d("[cmshow]BKResUtil", 2, ((StringBuilder)localObject).toString());
    return "";
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
      QLog.d("[cmshow]BKResUtil", 2, ((StringBuilder)localObject2).toString());
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
      bool = ((BKResUtil)localObject2).b(paramInt3, (String)localObject1);
    }
    else
    {
      localObject2 = a;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "subDirName");
      bool = ((BKResUtil)localObject2).a(paramInt3, (String)localObject1);
    }
    QLog.d("[cmshow]BKResUtil", 2, new Object[] { "isWhiteFaceActionRscDone, actionId:", Integer.valueOf(paramInt1), ",subType:", Integer.valueOf(paramInt2), ",personNum:", Integer.valueOf(paramInt3), ",isGroup:", Boolean.valueOf(paramBoolean), "check result:", Boolean.valueOf(bool) });
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
          break label117;
        }
      }
    }
    bool1 = false;
    label117:
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
      QLog.e("[cmshow]BKResUtil", 1, localStringBuilder.toString());
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
    boolean bool = FileUtil.d(BKGetResPathUtil.a(paramApolloActionData, 0));
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
      QLog.d("[cmshow]BKResUtil", 2, localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  @JvmStatic
  public static final boolean b(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[checkDressRes], dressId:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("[cmshow]BKResUtil", 2, ((StringBuilder)localObject).toString());
    localObject = new File(BKGetResPathUtil.b(paramInt));
    StringBuilder localStringBuilder;
    if (paramInt < 21)
    {
      localObject = ApolloConstant.a;
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
      QLog.d("[cmshow]BKResUtil", 2, localStringBuilder.toString());
      return false;
    }
    boolean bool2 = CMResUtil.a(paramInt);
    boolean bool1 = true;
    if (bool2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((File)localObject).getAbsolutePath());
      localStringBuilder.append("/");
      localStringBuilder.append("dress.bin");
      if (CMResUtil.a(localStringBuilder.toString())) {
        return bool1;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((File)localObject).getAbsolutePath());
      localStringBuilder.append("/");
      localStringBuilder.append("face.json");
      if (CMResUtil.a(localStringBuilder.toString())) {
        return true;
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((File)localObject).getAbsolutePath());
      localStringBuilder.append("/");
      localStringBuilder.append("dress.json");
      if (CMResUtil.a(localStringBuilder.toString()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(((File)localObject).getAbsolutePath());
        localStringBuilder.append("/");
        localStringBuilder.append("dress.atlas");
        if (CMResUtil.a(localStringBuilder.toString()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(((File)localObject).getAbsolutePath());
          localStringBuilder.append("/");
          localStringBuilder.append("dress.png");
          if (CMResUtil.a(localStringBuilder.toString())) {
            return true;
          }
        }
      }
    }
    bool1 = false;
    return bool1;
  }
  
  @JvmStatic
  public static final boolean b(int paramInt1, int paramInt2)
  {
    Object localObject1 = new File(BKGetResPathUtil.c(paramInt1));
    Object localObject2;
    if (!((File)localObject1).exists())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isActionResDone dir NOT exist.");
      ((StringBuilder)localObject2).append(((File)localObject1).getPath());
      QLog.w("[cmshow]BKResUtil", 1, ((StringBuilder)localObject2).toString());
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
      bool = ((BKResUtil)localObject2).b(paramInt2, localStringBuilder.toString());
    }
    else
    {
      localObject2 = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((File)localObject1).getAbsolutePath());
      localStringBuilder.append(File.separator);
      bool = ((BKResUtil)localObject2).a(paramInt2, localStringBuilder.toString());
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("isActionResDone, actionId:");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(", personNum:");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(", result:");
    ((StringBuilder)localObject1).append(bool);
    QLog.i("[cmshow]BKResUtil", 1, ((StringBuilder)localObject1).toString());
    return bool;
  }
  
  private final boolean b(int paramInt, File paramFile)
  {
    if (!c(paramInt, paramFile)) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile.getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("skeleton.bin");
    return CMResUtil.a(localStringBuilder.toString());
  }
  
  private final boolean b(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("action/");
    localStringBuilder.append("action.bin");
    boolean bool3 = CMResUtil.a(localStringBuilder.toString());
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
        if (CMResUtil.a(localStringBuilder.toString())) {
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
    QLog.d("[cmshow]BKResUtil", 2, localStringBuilder.toString());
    paramString = new File(paramString);
    boolean bool1 = paramString.exists();
    boolean bool2 = false;
    if (!bool1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dir NOT exist.");
      localStringBuilder.append(paramString.getPath());
      QLog.d("[cmshow]BKResUtil", 2, localStringBuilder.toString());
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
  
  @JvmStatic
  public static final boolean c(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[checkRoleRes], roleId:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("[cmshow]BKResUtil", 2, ((StringBuilder)localObject).toString());
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
      QLog.d("[cmshow]BKResUtil", 2, localStringBuilder.toString());
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
    Object localObject = new File(BKGetResPathUtil.a(paramInt1));
    if (!((File)localObject).exists())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isActionPanelFrameResDone, dir NOT exist.");
      localStringBuilder.append(((File)localObject).getPath());
      QLog.e("[cmshow]BKResUtil", 1, localStringBuilder.toString());
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
      QLog.d("[cmshow]BKResUtil", 2, localStringBuilder.toString());
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
    QLog.d("[cmshow]BKResUtil", 2, localStringBuilder.toString());
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dir NOT exist.");
      localStringBuilder.append(paramString.getPath());
      QLog.d("[cmshow]BKResUtil", 2, localStringBuilder.toString());
      return false;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.getAbsolutePath());
    localStringBuilder.append("/action/");
    localStringBuilder.append("action.bin");
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
      str = BKGetResPathUtil.d(paramInt2);
    }
    if (i != 0) {
      return c(str);
    }
    return b(str);
  }
  
  private final String f(int paramInt)
  {
    return "https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_item_";
  }
  
  private final String g(int paramInt)
  {
    return "https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_role_";
  }
  
  @NotNull
  public final String a(int paramInt)
  {
    return "https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.resource.util.BKResUtil
 * JD-Core Version:    0.7.0.1
 */