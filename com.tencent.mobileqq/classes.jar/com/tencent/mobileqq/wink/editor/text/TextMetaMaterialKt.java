package com.tencent.mobileqq.wink.editor.text;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.MetaMaterialKt;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGText;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"CATEGORY_KEYBOARD", "", "CATEGORY_TEXT_DECOR", "CATEGORY_TEXT_PATTERN", "CATEGORY_TEXT_STYLE", "TAG", "TEXT_DECOR_NON_ID", "TEXT_DEFAULT_DEFAULT_ID", "TEXT_PATTERN_NON_ID", "TYPE_BLUR", "TYPE_COLOR_TEXT", "TYPE_FIXED_TEXT", "TYPE_PLAIN_TEXT", "value", "actionType", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getActionType", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Ljava/lang/String;", "setActionType", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/lang/String;)V", "", "angle", "getAngle", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)F", "setAngle", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;F)V", "", "backgroundColor", "getBackgroundColor", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)I", "setBackgroundColor", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;I)V", "blurTextPath", "getBlurTextPath", "setBlurTextPath", "blurTexturePath", "getBlurTexturePath", "setBlurTexturePath", "centerX", "getCenterX", "setCenterX", "centerY", "getCenterY", "setCenterY", "configJsonPath", "getConfigJsonPath", "setConfigJsonPath", "configType", "getConfigType", "setConfigType", "content", "getContent", "setContent", "fontFamily", "getFontFamily", "setFontFamily", "fontId", "getFontId", "setFontId", "fontPath", "getFontPath", "setFontPath", "fontStyle", "getFontStyle", "setFontStyle", "", "isFirstLine", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Z", "setFirstLine", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Z)V", "isInteractive", "setInteractive", "isTextReady", "setTextReady", "isTextSticker", "setTextSticker", "maxScale", "getMaxScale", "setMaxScale", "minScale", "getMinScale", "setMinScale", "pagFilePath", "getPagFilePath", "setPagFilePath", "", "playEndDuration", "getPlayEndDuration", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)J", "setPlayEndDuration", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;J)V", "scale", "getScale", "setScale", "textColor", "getTextColor", "setTextColor", "textJustification", "getTextJustification", "setTextJustification", "type", "getType", "setType", "initTextMaterials", "", "categoryId", "materials", "newDefaultTextMaterial", "newNonTextMaterial", "materialId", "init", "", "updateTextByPagConfig", "config", "Lcom/tencent/mobileqq/wink/editor/text/WinkPagStickerConfig;", "qq-wink-impl_release"}, k=2, mv={1, 1, 16})
public final class TextMetaMaterialKt
{
  @NotNull
  public static final MetaMaterial a()
  {
    MetaMaterial localMetaMaterial = new MetaMaterial();
    localMetaMaterial.id = "TEXT_DEFAULT_DEFAULT_ID";
    Object localObject = RFApplication.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RFApplication.getApplication()");
    localObject = ((Context)localObject).getResources().getString(2131886344);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RFApplication.getApplica…e_editor_text_thumb_text)");
    MetaMaterialKt.e(localMetaMaterial, (String)localObject);
    b(localMetaMaterial, true);
    a(localMetaMaterial, "plain_text");
    a(localMetaMaterial, -1);
    k(localMetaMaterial, "CATEGORY_TEXT_STYLE");
    return localMetaMaterial;
  }
  
  @NotNull
  public static final MetaMaterial a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "materialId");
    MetaMaterial localMetaMaterial = new MetaMaterial();
    localMetaMaterial.id = paramString;
    paramString = RFApplication.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "RFApplication.getApplication()");
    paramString = paramString.getResources().getString(2131886344);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "RFApplication.getApplica…e_editor_text_thumb_text)");
    MetaMaterialKt.e(localMetaMaterial, paramString);
    localMetaMaterial.thumbUrl = "thumbNon";
    b(localMetaMaterial, true);
    return localMetaMaterial;
  }
  
  @NotNull
  public static final List<MetaMaterial> a(@NotNull String paramString, @NotNull List<MetaMaterial> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "categoryId");
    Intrinsics.checkParameterIsNotNull(paramList, "materials");
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      k((MetaMaterial)localIterator.next(), paramString);
    }
    return paramList;
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$scale");
    MetaMaterialKt.a(paramMetaMaterial, "scale", (Number)Float.valueOf(paramFloat));
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$textColor");
    MetaMaterialKt.a(paramMetaMaterial, "textColor", (Number)Integer.valueOf(paramInt));
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, @Nullable WinkPagStickerConfig paramWinkPagStickerConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$updateTextByPagConfig");
    if (!b(paramMetaMaterial))
    {
      Object localObject;
      if (paramWinkPagStickerConfig != null)
      {
        localObject = paramWinkPagStickerConfig.frameConfig;
        if (localObject != null)
        {
          b(paramMetaMaterial, ((WinkPagStickerConfig.FrameConfig)localObject).angle);
          e(paramMetaMaterial, ((WinkPagStickerConfig.FrameConfig)localObject).minScale);
          f(paramMetaMaterial, ((WinkPagStickerConfig.FrameConfig)localObject).maxScale);
        }
      }
      d(paramMetaMaterial, WinkEditorResourceManager.c().a(f(paramMetaMaterial), 0));
      try
      {
        if (new File(n(paramMetaMaterial)).exists())
        {
          localObject = PAGFile.Load(n(paramMetaMaterial));
        }
        else
        {
          localObject = WinkEditorResourceManager.c();
          Intrinsics.checkExpressionValueIsNotNull(localObject, "WinkEditorResourceManager.getInstance()");
          localObject = PAGFile.Load(((WinkEditorResourceManager)localObject).w());
        }
        if (((PAGFile)localObject).numTexts() > 0)
        {
          String str2 = ((PAGFile)localObject).getTextData(0).text;
          Intrinsics.checkExpressionValueIsNotNull(str2, "pagFile.getTextData(0).text");
          g(paramMetaMaterial, str2);
          a(paramMetaMaterial, ((PAGFile)localObject).getTextData(0).fillColor);
          str2 = ((PAGFile)localObject).getTextData(0).fontFamily;
          Intrinsics.checkExpressionValueIsNotNull(str2, "pagFile.getTextData(0).fontFamily");
          e(paramMetaMaterial, str2);
          localObject = ((PAGFile)localObject).getTextData(0).fontStyle;
          Intrinsics.checkExpressionValueIsNotNull(localObject, "pagFile.getTextData(0).fontStyle");
          f(paramMetaMaterial, (String)localObject);
        }
      }
      catch (Exception localException)
      {
        AEQLog.a("TextMetaMaterial", "updateTextByPagConfig", (Throwable)localException);
      }
      if (paramWinkPagStickerConfig != null)
      {
        str1 = paramWinkPagStickerConfig.type;
        if (str1 != null) {}
      }
      else
      {
        str1 = "fixed_text";
      }
      a(paramMetaMaterial, str1);
      String str1 = d(paramMetaMaterial);
      int i = str1.hashCode();
      if (i != 3027047)
      {
        if (i != 1021751938)
        {
          if ((i == 1289680009) && (str1.equals("color_text")) && (paramWinkPagStickerConfig != null))
          {
            paramWinkPagStickerConfig = paramWinkPagStickerConfig.styleConfig;
            if (paramWinkPagStickerConfig != null) {
              b(paramMetaMaterial, Color.parseColor(paramWinkPagStickerConfig.defaultColor));
            }
          }
        }
        else if ((str1.equals("plain_text")) && (paramWinkPagStickerConfig != null))
        {
          paramWinkPagStickerConfig = paramWinkPagStickerConfig.styleConfig;
          if (paramWinkPagStickerConfig != null) {
            a(paramMetaMaterial, Color.parseColor(paramWinkPagStickerConfig.defaultColor));
          }
        }
      }
      else if (str1.equals("blur"))
      {
        i(paramMetaMaterial, WinkEditorResourceManager.c().h(paramMetaMaterial));
        j(paramMetaMaterial, WinkEditorResourceManager.c().i(paramMetaMaterial));
      }
      b(paramMetaMaterial, true);
    }
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$type");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    MetaMaterialKt.a(paramMetaMaterial, "type", paramString);
  }
  
  public static final void a(@NotNull MetaMaterial paramMetaMaterial, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static final boolean a(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$isTextSticker");
    return MetaMaterialKt.g(paramMetaMaterial, "isTextSticker") == 1;
  }
  
  public static final void b(@NotNull MetaMaterial paramMetaMaterial, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$angle");
    MetaMaterialKt.a(paramMetaMaterial, "angle", (Number)Float.valueOf(paramFloat));
  }
  
  public static final void b(@NotNull MetaMaterial paramMetaMaterial, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$backgroundColor");
    MetaMaterialKt.a(paramMetaMaterial, "backgroundColor", (Number)Integer.valueOf(paramInt));
  }
  
  public static final void b(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$configJsonPath");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    MetaMaterialKt.a(paramMetaMaterial, "configJsonPath", paramString);
  }
  
  public static final void b(@NotNull MetaMaterial paramMetaMaterial, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static final boolean b(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$isTextReady");
    return MetaMaterialKt.g(paramMetaMaterial, "isTextReady") == 1;
  }
  
  public static final void c(@NotNull MetaMaterial paramMetaMaterial, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$centerX");
    MetaMaterialKt.a(paramMetaMaterial, "centerX", (Number)Float.valueOf(paramFloat));
  }
  
  public static final void c(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$fontId");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    MetaMaterialKt.a(paramMetaMaterial, "fontID", paramString);
  }
  
  public static final void c(@NotNull MetaMaterial paramMetaMaterial, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static final boolean c(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$isFirstLine");
    return MetaMaterialKt.g(paramMetaMaterial, "exIsFirstLine") == 1;
  }
  
  @NotNull
  public static final String d(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$type");
    return MetaMaterialKt.f(paramMetaMaterial, "type");
  }
  
  public static final void d(@NotNull MetaMaterial paramMetaMaterial, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$centerY");
    MetaMaterialKt.a(paramMetaMaterial, "centerY", (Number)Float.valueOf(paramFloat));
  }
  
  public static final void d(@NotNull MetaMaterial paramMetaMaterial, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$fontPath");
    MetaMaterialKt.a(paramMetaMaterial, "fontPath", paramString);
  }
  
  @NotNull
  public static final String e(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$configJsonPath");
    return MetaMaterialKt.f(paramMetaMaterial, "configJsonPath");
  }
  
  public static final void e(@NotNull MetaMaterial paramMetaMaterial, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$minScale");
    MetaMaterialKt.a(paramMetaMaterial, "minScale", (Number)Float.valueOf(paramFloat));
  }
  
  public static final void e(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$fontFamily");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    MetaMaterialKt.a(paramMetaMaterial, "fontFamily", paramString);
  }
  
  @NotNull
  public static final String f(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$fontId");
    return MetaMaterialKt.f(paramMetaMaterial, "fontID");
  }
  
  public static final void f(@NotNull MetaMaterial paramMetaMaterial, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$maxScale");
    MetaMaterialKt.a(paramMetaMaterial, "maxScale", (Number)Float.valueOf(paramFloat));
  }
  
  public static final void f(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$fontStyle");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    MetaMaterialKt.a(paramMetaMaterial, "fontStyle", paramString);
  }
  
  @Nullable
  public static final String g(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$fontPath");
    return MetaMaterialKt.f(paramMetaMaterial, "fontPath");
  }
  
  public static final void g(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$content");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    MetaMaterialKt.a(paramMetaMaterial, "content", paramString);
  }
  
  @NotNull
  public static final String h(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$fontFamily");
    return MetaMaterialKt.f(paramMetaMaterial, "fontFamily");
  }
  
  public static final void h(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$pagFilePath");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    MetaMaterialKt.a(paramMetaMaterial, "pagFilePath", paramString);
  }
  
  @NotNull
  public static final String i(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$fontStyle");
    return MetaMaterialKt.f(paramMetaMaterial, "fontStyle");
  }
  
  public static final void i(@NotNull MetaMaterial paramMetaMaterial, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$blurTextPath");
    MetaMaterialKt.a(paramMetaMaterial, "blurTextPath", paramString);
  }
  
  public static final int j(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$textJustification");
    return MetaMaterialKt.a(paramMetaMaterial, "textJustification", 1);
  }
  
  public static final void j(@NotNull MetaMaterial paramMetaMaterial, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$blurTexturePath");
    MetaMaterialKt.a(paramMetaMaterial, "blurTexturePath", paramString);
  }
  
  @NotNull
  public static final String k(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$content");
    return MetaMaterialKt.f(paramMetaMaterial, "content");
  }
  
  public static final void k(@NotNull MetaMaterial paramMetaMaterial, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$init");
    Intrinsics.checkParameterIsNotNull(paramString, "categoryId");
    MetaMaterialKt.b(paramMetaMaterial, paramString);
    int i = paramString.hashCode();
    if (i != -921884268)
    {
      if (i != -907563552)
      {
        if ((i == 793913343) && (paramString.equals("CATEGORY_TEXT_PATTERN")))
        {
          a(paramMetaMaterial, true);
          paramString = WinkEditorResourceManager.c().e(paramMetaMaterial);
          Intrinsics.checkExpressionValueIsNotNull(paramString, "WinkEditorResourceManage…tTextConfigJsonPath(this)");
          b(paramMetaMaterial, paramString);
          paramString = WinkEditorResourceManager.c().f(paramMetaMaterial);
          Intrinsics.checkExpressionValueIsNotNull(paramString, "WinkEditorResourceManage…tTextPagContentPath(this)");
          h(paramMetaMaterial, paramString);
          paramString = RFApplication.getApplication();
          Intrinsics.checkExpressionValueIsNotNull(paramString, "RFApplication.getApplication()");
          paramString = paramString.getResources().getString(2131886339);
          Intrinsics.checkExpressionValueIsNotNull(paramString, "RFApplication.getApplica…tor_text_default_content)");
          g(paramMetaMaterial, paramString);
          a(paramMetaMaterial, 0.8F);
        }
      }
      else if (paramString.equals("CATEGORY_TEXT_STYLE"))
      {
        a(paramMetaMaterial, true);
        paramString = WinkEditorResourceManager.c();
        Intrinsics.checkExpressionValueIsNotNull(paramString, "WinkEditorResourceManager.getInstance()");
        paramString = paramString.y();
        Intrinsics.checkExpressionValueIsNotNull(paramString, "WinkEditorResourceManage…textDefaultConfigJsonPath");
        b(paramMetaMaterial, paramString);
        paramString = WinkEditorResourceManager.c();
        Intrinsics.checkExpressionValueIsNotNull(paramString, "WinkEditorResourceManager.getInstance()");
        paramString = paramString.w();
        Intrinsics.checkExpressionValueIsNotNull(paramString, "WinkEditorResourceManage…ance().textDefaultPagPath");
        h(paramMetaMaterial, paramString);
        paramString = paramMetaMaterial.id;
        Intrinsics.checkExpressionValueIsNotNull(paramString, "id");
        c(paramMetaMaterial, paramString);
        paramString = RFApplication.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(paramString, "RFApplication.getApplication()");
        paramString = paramString.getResources().getString(2131886339);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "RFApplication.getApplica…tor_text_default_content)");
        g(paramMetaMaterial, paramString);
        a(paramMetaMaterial, 0.8F);
      }
    }
    else if (paramString.equals("CATEGORY_TEXT_DECOR"))
    {
      a(paramMetaMaterial, true);
      paramString = WinkEditorResourceManager.c().e(paramMetaMaterial);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "WinkEditorResourceManage…tTextConfigJsonPath(this)");
      b(paramMetaMaterial, paramString);
      paramString = WinkEditorResourceManager.c().f(paramMetaMaterial);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "WinkEditorResourceManage…tTextPagContentPath(this)");
      h(paramMetaMaterial, paramString);
      a(paramMetaMaterial, 0.5F);
      return;
    }
    MetaMaterialKt.c(paramMetaMaterial, 0);
    paramString = WinkEditorResourceManager.c().f(paramMetaMaterial);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "WinkEditorResourceManage…tTextPagContentPath(this)");
    h(paramMetaMaterial, paramString);
    a(paramMetaMaterial, 0.4F);
  }
  
  public static final int l(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$textColor");
    return MetaMaterialKt.g(paramMetaMaterial, "textColor");
  }
  
  public static final int m(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$backgroundColor");
    return MetaMaterialKt.g(paramMetaMaterial, "backgroundColor");
  }
  
  @NotNull
  public static final String n(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$pagFilePath");
    return MetaMaterialKt.f(paramMetaMaterial, "pagFilePath");
  }
  
  public static final float o(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$scale");
    return MetaMaterialKt.a(paramMetaMaterial, "scale", 0.4F);
  }
  
  public static final float p(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$angle");
    return MetaMaterialKt.a(paramMetaMaterial, "angle", 0.0F);
  }
  
  public static final float q(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$centerX");
    return MetaMaterialKt.a(paramMetaMaterial, "centerX", 0.0F);
  }
  
  public static final float r(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$centerY");
    return MetaMaterialKt.a(paramMetaMaterial, "centerY", 0.0F);
  }
  
  public static final float s(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$minScale");
    return MetaMaterialKt.a(paramMetaMaterial, "minScale", 0.2F);
  }
  
  public static final float t(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$maxScale");
    return MetaMaterialKt.a(paramMetaMaterial, "maxScale", 10.0F);
  }
  
  public static final long u(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$playEndDuration");
    return MetaMaterialKt.a(paramMetaMaterial, "playEndDuration", -1L);
  }
  
  @NotNull
  public static final String v(@NotNull MetaMaterial paramMetaMaterial)
  {
    Intrinsics.checkParameterIsNotNull(paramMetaMaterial, "$this$actionType");
    return MetaMaterialKt.f(paramMetaMaterial, "actionType");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.text.TextMetaMaterialKt
 * JD-Core Version:    0.7.0.1
 */