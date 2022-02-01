package com.tencent.mobileqq.wink.editor;

import android.support.annotation.DrawableRes;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"ID_PLACEHOLDER", "", "NON_CATEGORY_ID", "THUMB_NON", "TYPE_FILTER", "", "TYPE_FRAME", "TYPE_IMAGE_TEMPLATE", "TYPE_STICKER", "TYPE_TEXT", "TYPE_VIDEO_TEMPLATE", "value", "badgeDisappearTimestamp", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getBadgeDisappearTimestamp", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)I", "setBadgeDisappearTimestamp", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;I)V", "badgeURL", "getBadgeURL", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Ljava/lang/String;", "setBadgeURL", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/lang/String;)V", "categoryId", "getCategoryId", "setCategoryId", "categoryName", "getCategoryName", "setCategoryName", "", "displayDownloadIcon", "getDisplayDownloadIcon", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Z", "setDisplayDownloadIcon", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Z)V", "downloadProgress", "getDownloadProgress", "setDownloadProgress", "hashTag", "getHashTag", "setHashTag", "index", "getIndex", "setIndex", "isApplyLocal", "setApplyLocal", "isPreDownload", "setPreDownload", "isSmallLoading", "setSmallLoading", "name", "getName", "setName", "packagePath", "getPackagePath", "setPackagePath", "redPointTimeStamp", "getRedPointTimeStamp", "setRedPointTimeStamp", "thumbBackground", "getThumbBackground", "setThumbBackground", "thumbText", "getThumbText", "setThumbText", "findFirstItemPositionByCategoryPosition", "categories", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "materials", "categoryItemPosition", "findItemPositionByContentPosition", "contentItemPosition", "newPlaceholderMaterial", "getFloatOrDefault", "", "key", "default", "getFloatOrZero", "getIntOrDefault", "getIntOrZero", "getLongOrDefault", "", "getLongOrZero", "getMapOrNull", "", "getStringOrEmpty", "getThumbLocalRes", "putMap", "", "putNumber", "", "putString", "qq-wink-impl_release"}, k=2, mv={1, 1, 16})
public final class MetaMaterialKt
{
  public static final float a(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$getFloatOrDefault");
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    if (paramMetaMaterial.additionalFields == null) {
      return paramFloat;
    }
    paramMetaMaterial = (String)paramMetaMaterial.additionalFields.get(paramString);
    float f = paramFloat;
    if (paramMetaMaterial != null) {}
    try
    {
      f = Float.parseFloat(paramMetaMaterial);
      return f;
    }
    catch (Exception paramMetaMaterial) {}
    return paramFloat;
  }
  
  public static final int a(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$index");
    return a(paramMetaMaterial, "exIndex", 0);
  }
  
  public static final int a(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$getIntOrDefault");
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    if (paramMetaMaterial.additionalFields == null) {
      return paramInt;
    }
    paramMetaMaterial = (String)paramMetaMaterial.additionalFields.get(paramString);
    int i = paramInt;
    if (paramMetaMaterial != null) {}
    try
    {
      i = Integer.parseInt(paramMetaMaterial);
      return i;
    }
    catch (Exception paramMetaMaterial) {}
    return paramInt;
  }
  
  public static final int a(@Nullable List<MetaCategory> paramList, @Nullable List<MetaMaterial> paramList1, int paramInt)
  {
    if ((paramList != null) && (paramList1 != null))
    {
      if (paramList1.size() < paramInt) {
        return 0;
      }
      paramList1 = d((MetaMaterial)paramList1.get(paramInt));
      int i = ((Collection)paramList).size();
      paramInt = 0;
      while (paramInt < i)
      {
        if (Intrinsics.areEqual(paramList1, ((MetaCategory)paramList.get(paramInt)).id)) {
          return paramInt;
        }
        paramInt += 1;
      }
    }
    return 0;
  }
  
  public static final long a(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$getLongOrDefault");
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    if (paramMetaMaterial.additionalFields == null) {
      return paramLong;
    }
    paramMetaMaterial = (String)paramMetaMaterial.additionalFields.get(paramString);
    long l = paramLong;
    if (paramMetaMaterial != null) {}
    try
    {
      l = Long.parseLong(paramMetaMaterial);
      return l;
    }
    catch (Exception paramMetaMaterial) {}
    return paramLong;
  }
  
  @NotNull
  public static final MetaMaterial a()
  {
    MetaMaterial localMetaMaterial = new MetaMaterial();
    localMetaMaterial.id = "ID_PLACEHOLDER";
    return localMetaMaterial;
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$index");
    a(paramMetaMaterial, "exIndex", (Number)Integer.valueOf(paramInt));
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$name");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    a(paramMetaMaterial, "name", paramString);
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString, @NotNull Number paramNumber)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$putNumber");
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    Intrinsics.checkParameterIsNotNull(paramNumber, "value");
    if (paramMetaMaterial.additionalFields == null) {
      paramMetaMaterial.additionalFields = ((Map)new HashMap());
    }
    try
    {
      paramMetaMaterial = paramMetaMaterial.additionalFields;
      Intrinsics.checkExpressionValueIsNotNull(paramMetaMaterial, "this.additionalFields");
      paramMetaMaterial.put(paramString, paramNumber.toString());
      return;
    }
    catch (Exception paramMetaMaterial) {}
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$putString");
    Intrinsics.checkParameterIsNotNull(paramString1, "key");
    if (paramMetaMaterial.additionalFields == null) {
      paramMetaMaterial.additionalFields = ((Map)new HashMap());
    }
    paramMetaMaterial = paramMetaMaterial.additionalFields;
    Intrinsics.checkExpressionValueIsNotNull(paramMetaMaterial, "this.additionalFields");
    paramMetaMaterial.put(paramString1, paramString2);
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, @Nullable String paramString, @Nullable Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$putMap");
    if (paramMetaMaterial.additionalFields == null) {
      paramMetaMaterial.additionalFields = ((Map)new HashMap());
    }
    try
    {
      Gson localGson = new Gson();
      paramMetaMaterial = paramMetaMaterial.additionalFields;
      Intrinsics.checkExpressionValueIsNotNull(paramMetaMaterial, "this.additionalFields");
      paramMetaMaterial.put(paramString, localGson.toJson(paramMap, new MetaMaterialKt.putMap.1().getType()));
      return;
    }
    catch (JsonSyntaxException paramMetaMaterial) {}
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static final int b(@Nullable List<MetaCategory> paramList, @Nullable List<MetaMaterial> paramList1, int paramInt)
  {
    if ((paramList != null) && (paramList1 != null))
    {
      if (paramList.size() < paramInt) {
        return 0;
      }
      paramList = (MetaCategory)paramList.get(paramInt);
      int i = ((Collection)paramList1).size();
      paramInt = 0;
      while (paramInt < i)
      {
        if (Intrinsics.areEqual(paramList.id, d((MetaMaterial)paramList1.get(paramInt)))) {
          return paramInt;
        }
        paramInt += 1;
      }
    }
    return 0;
  }
  
  @NotNull
  public static final String b(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$name");
    return f(paramMetaMaterial, "name");
  }
  
  public static final void b(@NotNull MetaMaterial paramMetaMaterial, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$downloadProgress");
    a(paramMetaMaterial, "downloadProgress", (Number)Integer.valueOf(Math.min(paramInt, 100)));
  }
  
  public static final void b(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$categoryId");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    a(paramMetaMaterial, "categoryId", paramString);
  }
  
  public static final void b(@NotNull MetaMaterial paramMetaMaterial, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static final void c(@NotNull MetaMaterial paramMetaMaterial, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$thumbBackground");
    a(paramMetaMaterial, "exThumbBackground", (Number)Integer.valueOf(paramInt));
  }
  
  public static final void c(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$categoryName");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    a(paramMetaMaterial, "categoryName", paramString);
  }
  
  public static final boolean c(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$displayDownloadIcon");
    return g(paramMetaMaterial, "displayDownloadIcon") == 1;
  }
  
  @NotNull
  public static final String d(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$categoryId");
    return f(paramMetaMaterial, "categoryId");
  }
  
  public static final void d(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$packagePath");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    a(paramMetaMaterial, "packagePath", paramString);
  }
  
  @NotNull
  public static final String e(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$categoryName");
    return f(paramMetaMaterial, "categoryName");
  }
  
  public static final void e(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$thumbText");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    a(paramMetaMaterial, "thumbText", paramString);
  }
  
  @NotNull
  public static final String f(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$getStringOrEmpty");
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    if (paramMetaMaterial.additionalFields == null) {
      return "";
    }
    paramMetaMaterial = (String)paramMetaMaterial.additionalFields.get(paramString);
    if (paramMetaMaterial != null) {
      return paramMetaMaterial;
    }
    return "";
  }
  
  public static final boolean f(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$isApplyLocal");
    return a(paramMetaMaterial, "isApplyLocal", 1) == 1;
  }
  
  public static final int g(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$getIntOrZero");
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    return a(paramMetaMaterial, paramString, 0);
  }
  
  public static final boolean g(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$isSmallLoading");
    return a(paramMetaMaterial, "isSmallLoading", 1) == 1;
  }
  
  public static final int h(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$downloadProgress");
    return a(paramMetaMaterial, "downloadProgress", -1);
  }
  
  @NotNull
  public static final String i(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$thumbText");
    return f(paramMetaMaterial, "thumbText");
  }
  
  public static final int j(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$thumbBackground");
    return a(paramMetaMaterial, "exThumbBackground", -1);
  }
  
  @DrawableRes
  public static final int k(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$getThumbLocalRes");
    if (Intrinsics.areEqual("thumbNon", paramMetaMaterial.thumbUrl)) {
      return 2130848888;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.MetaMaterialKt
 * JD-Core Version:    0.7.0.1
 */