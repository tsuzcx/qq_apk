package com.tencent.mobileqq.cmshow.engine.util;

import android.text.TextUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/util/CMGetResPathUtil;", "", "()V", "TAG", "", "addFilePostFix", "", "type", "relPath", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getFilePath", "folder", "fileName", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CMGetResPathUtil
{
  public static final CMGetResPathUtil a = new CMGetResPathUtil();
  
  @JvmStatic
  @Nullable
  public static final String a(@Nullable String paramString1, @Nullable String paramString2)
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
  
  public final void a(@NotNull String paramString, @NotNull StringBuilder paramStringBuilder)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "type");
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "relPath");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.util.CMGetResPathUtil
 * JD-Core Version:    0.7.0.1
 */