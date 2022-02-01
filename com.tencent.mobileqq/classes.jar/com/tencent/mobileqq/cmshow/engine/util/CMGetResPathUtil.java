package com.tencent.mobileqq.cmshow.engine.util;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/util/CMGetResPathUtil;", "", "()V", "TAG", "", "addFilePostFix", "", "type", "relPath", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getActionPath", "id", "", "getApolloDrawerPath", "actionId", "getApolloPanelFramePath", "getApolloResPath", "action", "Lcom/tencent/mobileqq/apollo/model/ApolloActionData;", "opType", "getApolloTabResPath", "actionPackage", "Lcom/tencent/mobileqq/apollo/model/ApolloActionPackage;", "getDressPath", "getFaceJsonFilePath", "dir", "getFaceJsonFilePathByUrl", "url", "getFilePath", "folder", "fileName", "getRealResDir", "resType", "getResAbsolutePath", "name", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CMGetResPathUtil
{
  public static final CMGetResPathUtil a = new CMGetResPathUtil();
  
  @JvmStatic
  @NotNull
  public static final String a(int paramInt)
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
    ((StringBuffer)localObject).append(paramInt);
    ((StringBuffer)localObject).append("/panelAction");
    localObject = ((StringBuffer)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "sb.toString()");
    return localObject;
  }
  
  @JvmStatic
  @NotNull
  public static final String a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      if (paramInt2 == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(ApolloConstant.a);
        ((StringBuilder)localObject).append("/def/role/0/");
        return ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(File.separator);
      return ((StringBuilder)localObject).toString();
    }
    if (paramInt1 == 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(File.separator);
      return ((StringBuilder)localObject).toString();
    }
    if (paramInt1 == 3)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(File.separator);
      return ((StringBuilder)localObject).toString();
    }
    if (paramInt1 == 4)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/audio/");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(File.separator);
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/unknow/");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(File.separator);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getRealResFile unknow Type->");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" id->");
    localStringBuilder.append(paramInt2);
    QLog.d("[cmshow][CMGetResPathUtil]", 2, localStringBuilder.toString());
    return localObject;
  }
  
  @JvmStatic
  @Nullable
  public static final String a(@Nullable ApolloActionData paramApolloActionData, int paramInt)
  {
    if (paramApolloActionData == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(100);
    switch (paramInt)
    {
    default: 
      break;
    case 10: 
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/frame/");
      localStringBuilder.append(paramApolloActionData.actionId);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(ApolloUtilImpl.getCurrentUin());
      localStringBuilder.append("_frame.png");
      break;
    case 9: 
      localStringBuilder.append("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_drawerAction_");
      localStringBuilder.append(paramApolloActionData.actionId);
      localStringBuilder.append("/d.zip");
      break;
    case 8: 
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/ai/action/");
      localStringBuilder.append(paramApolloActionData.actionId);
      break;
    case 7: 
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
      localStringBuilder.append(paramApolloActionData.actionId);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("config.json");
      break;
    case 6: 
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
      localStringBuilder.append(paramApolloActionData.actionId);
      localStringBuilder.append(File.separator);
      break;
    case 5: 
      localStringBuilder.append(CMResUtil.a.a(paramApolloActionData.actionId));
      localStringBuilder.append(paramApolloActionData.actionId);
      localStringBuilder.append("/d.zip");
      break;
    case 4: 
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
      localStringBuilder.append(paramApolloActionData.actionId);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("actionRes.zip");
      break;
    case 3: 
      localStringBuilder.append("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_");
      localStringBuilder.append(paramApolloActionData.actionId);
      localStringBuilder.append("/preview.gif");
      break;
    case 2: 
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
      localStringBuilder.append(paramApolloActionData.actionId);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("panelGif.gif");
      break;
    case 1: 
      localStringBuilder.append(CMResUtil.a.a(paramApolloActionData.actionId));
      localStringBuilder.append(paramApolloActionData.actionId);
      localStringBuilder.append("/preview.png");
      break;
    case 0: 
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
      localStringBuilder.append(paramApolloActionData.actionId);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("panelView.png");
    }
    return localStringBuilder.toString();
  }
  
  @JvmStatic
  @Nullable
  public static final String a(@Nullable ApolloActionPackage paramApolloActionPackage)
  {
    if (paramApolloActionPackage == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/packages/");
    localStringBuilder.append(paramApolloActionPackage.packageId);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("tab.png");
    return localStringBuilder.toString();
  }
  
  @JvmStatic
  @Nullable
  public static final String a(@Nullable String paramString)
  {
    return b(paramString, "face.json");
  }
  
  @JvmStatic
  @NotNull
  public static final String a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Object localObject = paramString1;
    Intrinsics.checkParameterIsNotNull(localObject, "name");
    Intrinsics.checkParameterIsNotNull(paramString2, "type");
    paramString1 = (CharSequence)localObject;
    if (TextUtils.isEmpty(paramString1)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (StringsKt.startsWith$default((String)localObject, "BaseJs:", false, 2, null))
    {
      paramString1 = ((String)localObject).substring(9);
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.String).substring(startIndex)");
      localStringBuilder.append(ApolloConstant.N);
    }
    else if ((!StringsKt.startsWith$default((String)localObject, "ActionRes:", false, 2, null)) && (!StringsKt.startsWith$default((String)localObject, "Action:", false, 2, null)))
    {
      if (StringsKt.startsWith$default((String)localObject, "Role:", false, 2, null))
      {
        paramString1 = ((String)localObject).substring(7);
        Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.String).substring(startIndex)");
        localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo");
        localStringBuilder.append("/role/");
      }
      else if (StringsKt.startsWith$default((String)localObject, "Dress:", false, 2, null))
      {
        paramString1 = ((String)localObject).substring(8);
        Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.String).substring(startIndex)");
        localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo");
        if (StringsKt.startsWith$default(paramString1, "role/", false, 2, null))
        {
          if (paramString1 != null)
          {
            paramString1 = paramString1.substring(5);
            Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.String).substring(startIndex)");
            localStringBuilder.append("/role/");
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
          }
        }
        else {
          localStringBuilder.append("/dress/");
        }
      }
      else if (StringsKt.startsWith$default((String)localObject, "Extension:", false, 2, null))
      {
        paramString1 = ((String)localObject).substring(12);
        Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.String).substring(startIndex)");
        localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo");
        localStringBuilder.append("/extension/");
      }
      else if (StringsKt.startsWith$default((String)localObject, "SlaveAction", false, 2, null))
      {
        paramString1 = ((String)localObject).substring(13);
        Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.String).substring(startIndex)");
        new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo", "slave");
        localStringBuilder.append(ApolloConstant.a);
        localStringBuilder.append("/def/role/0/script/slave/");
      }
      else if ((!StringsKt.contains$default(paramString1, (CharSequence)"game", false, 2, null)) && (!StringsKt.contains$default(paramString1, (CharSequence)"def", false, 2, null)))
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("getRscPath err name:");
          paramString1.append((String)localObject);
          paramString1.append(",type:");
          paramString1.append(paramString2);
          QLog.e("[cmshow][CMGetResPathUtil]", 2, paramString1.toString());
        }
        if (StringsKt.startsWith$default((String)localObject, "role", false, 2, null))
        {
          paramString1 = ((String)localObject).substring(5);
          Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.String).substring(startIndex)");
          localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo");
          localStringBuilder.append("/role/");
        }
        else if (StringsKt.startsWith$default((String)localObject, "action", false, 2, null))
        {
          paramString1 = ((String)localObject).substring(7);
          Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.String).substring(startIndex)");
          localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo");
          localStringBuilder.append("/action/");
        }
        else
        {
          paramString1 = (String)localObject;
          if (StringsKt.startsWith$default((String)localObject, "dress", false, 2, null))
          {
            paramString1 = ((String)localObject).substring(6);
            Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.String).substring(startIndex)");
            localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo");
            localStringBuilder.append("/dress/");
          }
        }
      }
      else
      {
        localStringBuilder.append(ApolloConstant.a);
        String str = localStringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(str, "sb.toString()");
        paramString1 = (String)localObject;
        if (!StringsKt.endsWith$default(str, "/", false, 2, null))
        {
          localStringBuilder.append("/");
          paramString1 = (String)localObject;
        }
      }
    }
    else
    {
      int i = 7;
      if (StringsKt.startsWith$default((String)localObject, "ActionRes:", false, 2, null)) {
        i = 10;
      }
      paramString1 = ((String)localObject).substring(i + 2);
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.String).substring(startIndex)");
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo");
      if (StringsKt.startsWith$default(paramString1, "role/", false, 2, null))
      {
        if (paramString1 != null)
        {
          paramString1 = paramString1.substring(5);
          Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.String).substring(startIndex)");
          localStringBuilder.append("/role/");
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
      }
      else if (StringsKt.startsWith$default(paramString1, "drawer_action/", false, 2, null))
      {
        if (paramString1 != null)
        {
          paramString1 = paramString1.substring(14);
          Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.String).substring(startIndex)");
          localStringBuilder.append("/drawer_action/");
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
      }
      else {
        localStringBuilder.append("/action/");
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    a.a(paramString2, (StringBuilder)localObject);
    localStringBuilder.append(((StringBuilder)localObject).toString());
    paramString1 = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "sb.toString()");
    return paramString1;
  }
  
  private final void a(String paramString, StringBuilder paramStringBuilder)
  {
    if (Intrinsics.areEqual("json", paramString))
    {
      paramStringBuilder.append(".json");
      return;
    }
    if (Intrinsics.areEqual("atlas", paramString))
    {
      paramStringBuilder.append(".atlas");
      return;
    }
    if (Intrinsics.areEqual("lua", paramString))
    {
      paramStringBuilder.append(".lua");
      return;
    }
    if (Intrinsics.areEqual("png", paramString))
    {
      paramStringBuilder.append(".png");
      return;
    }
    if (Intrinsics.areEqual("jpg", paramString))
    {
      paramStringBuilder.append(".jpg");
      return;
    }
    if (Intrinsics.areEqual(".js", paramString))
    {
      paramStringBuilder.append(".js");
      return;
    }
    if (Intrinsics.areEqual("shp", paramString))
    {
      paramStringBuilder.append(".shp");
      return;
    }
    if (Intrinsics.areEqual("bin", paramString))
    {
      paramStringBuilder.append(".bin");
      return;
    }
    if (Intrinsics.areEqual("nda", paramString)) {
      paramStringBuilder.append(".nda");
    }
  }
  
  @JvmStatic
  @NotNull
  public static final String b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  @JvmStatic
  @Nullable
  public static final String b(@Nullable String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return null;
    }
    Object localObject = (String)null;
    try
    {
      paramString = MD5Utils.toMD5(paramString);
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getFaceJsonFilePathByUr]l error! ");
      localStringBuilder.append(paramString);
      QLog.e("[cmshow][CMGetResPathUtil]", 1, localStringBuilder.toString());
      paramString = (String)localObject;
    }
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return null;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress//face/");
    ((StringBuilder)localObject).append(paramString);
    return b(((StringBuilder)localObject).toString(), "face.json");
  }
  
  @JvmStatic
  @Nullable
  public static final String b(@Nullable String paramString1, @Nullable String paramString2)
  {
    if ((!TextUtils.isEmpty((CharSequence)paramString1)) && (!TextUtils.isEmpty((CharSequence)paramString2)))
    {
      paramString1 = new StringBuilder(paramString1);
      paramString1.append(File.separator);
      paramString1.append(paramString2);
      return paramString1.toString();
    }
    return null;
  }
  
  @JvmStatic
  @NotNull
  public static final String c(int paramInt)
  {
    if (paramInt < 21)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(ApolloConstant.a);
      localStringBuilder.append("/def/basic/action/");
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  @JvmStatic
  @NotNull
  public static final String d(int paramInt)
  {
    Object localObject = new StringBuilder(50);
    ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/drawer_action/");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "sb.toString()");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.util.CMGetResPathUtil
 * JD-Core Version:    0.7.0.1
 */