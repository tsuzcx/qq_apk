package com.tencent.xaction;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.google.gson.internal.LinkedTreeMap;
import com.tencent.xaction.api.IAnim;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.DecorView;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.api.util.FilePathUtil;
import com.tencent.xaction.api.util.FilePathUtil.Companion;
import com.tencent.xaction.openapi.api.IPublicRuleManager;
import com.tencent.xaction.openapi.api.IXAEngine;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGFont;
import org.libpag.PAGImage;
import org.libpag.PAGText;
import org.libpag.PAGView;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/XAPagView;", "Lorg/libpag/PAGView;", "Lcom/tencent/xaction/api/IView;", "Lcom/tencent/xaction/api/IAnim;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "decor", "Lcom/tencent/xaction/api/base/DecorView;", "getDecor", "()Lcom/tencent/xaction/api/base/DecorView;", "setDecor", "(Lcom/tencent/xaction/api/base/DecorView;)V", "doFrame", "", "frameTimeNanos", "", "end", "executeBlock", "data", "Lcom/tencent/xaction/api/data/ViewData;", "engine", "Lcom/tencent/xaction/openapi/api/IXAEngine;", "play", "preStart", "view", "Landroid/view/View;", "replacePagImage", "xaPagView", "pagFile", "Lorg/libpag/PAGFile;", "replacePagText", "setPAGScaleMode", "XAPag_release"}, k=1, mv={1, 1, 16})
public final class XAPagView
  extends PAGView
  implements IAnim, IView
{
  @NotNull
  private DecorView jdField_a_of_type_ComTencentXactionApiBaseDecorView = (DecorView)new XAPagView.decor.1(this, (IView)this);
  private final String jdField_a_of_type_JavaLangString = "XAPagView";
  
  public XAPagView(@Nullable Context paramContext)
  {
    super(paramContext);
  }
  
  private final void a(ViewData paramViewData, IXAEngine paramIXAEngine)
  {
    if (paramViewData == null) {
      Intrinsics.throwNpe();
    }
    Object localObject = paramViewData.getExts();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    if (((HashMap)localObject).get("block") == null) {
      return;
    }
    paramViewData = paramViewData.getExts();
    if (paramViewData == null) {
      Intrinsics.throwNpe();
    }
    paramViewData = paramViewData.get("block");
    if (paramViewData != null)
    {
      paramViewData = ((Iterable)paramViewData).iterator();
      while (paramViewData.hasNext())
      {
        localObject = (String)paramViewData.next();
        localObject = paramIXAEngine.getRuleManager().getRuleValue((String)localObject);
        if (localObject != null) {
          try
          {
            ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(localObject, 1)).invoke(this);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
      return;
    }
    paramViewData = new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
    for (;;)
    {
      throw paramViewData;
    }
  }
  
  @NotNull
  public DecorView a()
  {
    return this.jdField_a_of_type_ComTencentXactionApiBaseDecorView;
  }
  
  public final void a(@NotNull ViewData paramViewData, @NotNull IXAEngine paramIXAEngine, @NotNull XAPagView paramXAPagView, @NotNull PAGFile paramPAGFile)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "data");
    Intrinsics.checkParameterIsNotNull(paramIXAEngine, "engine");
    Intrinsics.checkParameterIsNotNull(paramXAPagView, "xaPagView");
    Intrinsics.checkParameterIsNotNull(paramPAGFile, "pagFile");
    paramPAGFile = paramViewData.getExts();
    if (paramPAGFile == null) {
      Intrinsics.throwNpe();
    }
    if (paramPAGFile.get("image") == null) {
      return;
    }
    paramViewData = paramViewData.getExts();
    if (paramViewData == null) {
      Intrinsics.throwNpe();
    }
    paramViewData = paramViewData.get("image");
    if (paramViewData != null)
    {
      paramViewData = ((Iterable)paramViewData).iterator();
      while (paramViewData.hasNext())
      {
        Object localObject = (LinkedTreeMap)paramViewData.next();
        paramPAGFile = ((LinkedTreeMap)localObject).get("layer");
        localObject = ((LinkedTreeMap)localObject).get("value");
        if ((localObject instanceof String)) {
          try
          {
            localObject = paramIXAEngine.getRuleManager().getRuleValue((String)localObject);
            if (localObject != null)
            {
              if (localObject != null)
              {
                localObject = (Bitmap)((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(localObject, 1)).invoke(paramXAPagView);
                if (localObject == null) {
                  return;
                }
                localObject = PAGImage.FromBitmap((Bitmap)localObject);
                if (paramPAGFile != null) {
                  paramXAPagView.replaceImage((int)((Double)paramPAGFile).doubleValue(), (PAGImage)localObject);
                } else {
                  throw new TypeCastException("null cannot be cast to non-null type kotlin.Double");
                }
              }
              else
              {
                throw new TypeCastException("null cannot be cast to non-null type (org.libpag.PAGView) -> android.graphics.Bitmap?");
              }
            }
            else {
              return;
            }
          }
          catch (Exception paramPAGFile)
          {
            paramPAGFile.printStackTrace();
          }
        }
      }
      return;
    }
    paramViewData = new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.google.gson.internal.LinkedTreeMap<kotlin.String, kotlin.Any>> /* = java.util.ArrayList<com.google.gson.internal.LinkedTreeMap<kotlin.String, kotlin.Any>> */");
    for (;;)
    {
      throw paramViewData;
    }
  }
  
  public final void b(@NotNull ViewData paramViewData, @NotNull IXAEngine paramIXAEngine, @NotNull XAPagView paramXAPagView, @NotNull PAGFile paramPAGFile)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "data");
    Intrinsics.checkParameterIsNotNull(paramIXAEngine, "engine");
    Intrinsics.checkParameterIsNotNull(paramXAPagView, "xaPagView");
    Intrinsics.checkParameterIsNotNull(paramPAGFile, "pagFile");
    Object localObject1 = paramViewData.getExts();
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    if (((HashMap)localObject1).get("text") == null) {
      return;
    }
    paramViewData = paramViewData.getExts();
    if (paramViewData == null) {
      Intrinsics.throwNpe();
    }
    paramViewData = paramViewData.get("text");
    if (paramViewData != null)
    {
      paramViewData = ((Iterable)paramViewData).iterator();
      while (paramViewData.hasNext())
      {
        Object localObject2 = (LinkedTreeMap)paramViewData.next();
        localObject1 = ((LinkedTreeMap)localObject2).get("layer");
        Object localObject3 = ((LinkedTreeMap)localObject2).get("value");
        localObject2 = ((LinkedTreeMap)localObject2).get("font");
        if ((localObject3 instanceof String)) {
          try
          {
            localObject3 = paramIXAEngine.getRuleManager().getRuleValue((String)localObject3);
            if (localObject3 != null)
            {
              if (localObject3 != null)
              {
                localObject3 = (String)((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(localObject3, 1)).invoke(paramXAPagView);
                if (localObject3 == null) {
                  return;
                }
                PAGText localPAGText = paramPAGFile.getTextData(0);
                if ((localObject2 instanceof String))
                {
                  localObject2 = FilePathUtil.a.a((String)localObject2, "$PARENT_ROOT", paramIXAEngine);
                  if (new File((String)localObject2).exists())
                  {
                    localObject2 = PAGFont.RegisterFont((String)localObject2);
                    if (localPAGText != null) {
                      localPAGText.fontFamily = ((PAGFont)localObject2).fontFamily;
                    }
                    if (localPAGText != null) {
                      localPAGText.fontStyle = ((PAGFont)localObject2).fontStyle;
                    }
                  }
                }
                if (localPAGText != null) {
                  localPAGText.text = ((String)localObject3);
                }
                if (localObject1 != null)
                {
                  paramXAPagView.setTextData((int)((Double)localObject1).doubleValue(), localPAGText);
                  paramXAPagView.flush();
                }
                else
                {
                  throw new TypeCastException("null cannot be cast to non-null type kotlin.Double");
                }
              }
              else
              {
                throw new TypeCastException("null cannot be cast to non-null type (org.libpag.PAGView) -> kotlin.String?");
              }
            }
            else {
              return;
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
      return;
    }
    paramViewData = new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.google.gson.internal.LinkedTreeMap<kotlin.String, kotlin.Any>> /* = java.util.ArrayList<com.google.gson.internal.LinkedTreeMap<kotlin.String, kotlin.Any>> */");
    for (;;)
    {
      throw paramViewData;
    }
  }
  
  public void doFrame(long paramLong) {}
  
  public void end()
  {
    super.stop();
  }
  
  public void play()
  {
    setProgress(0.0D);
    super.play();
    ViewData localViewData = a().a();
    if (localViewData == null) {
      Intrinsics.throwNpe();
    }
    IXAEngine localIXAEngine = a().a();
    if (localIXAEngine == null) {
      Intrinsics.throwNpe();
    }
    a(localViewData, localIXAEngine);
  }
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    paramView = a().a();
    if (paramView == null) {
      Intrinsics.throwNpe();
    }
    IXAEngine localIXAEngine = a().a();
    if (localIXAEngine == null) {
      Intrinsics.throwNpe();
    }
    PAGFile localPAGFile = getFile();
    Intrinsics.checkExpressionValueIsNotNull(localPAGFile, "this.file");
    b(paramView, localIXAEngine, this, localPAGFile);
    paramView = a().a();
    if (paramView == null) {
      Intrinsics.throwNpe();
    }
    localIXAEngine = a().a();
    if (localIXAEngine == null) {
      Intrinsics.throwNpe();
    }
    localPAGFile = getFile();
    Intrinsics.checkExpressionValueIsNotNull(localPAGFile, "this.file");
    a(paramView, localIXAEngine, this, localPAGFile);
  }
  
  public void setDecor(@NotNull DecorView paramDecorView)
  {
    Intrinsics.checkParameterIsNotNull(paramDecorView, "<set-?>");
    this.jdField_a_of_type_ComTencentXactionApiBaseDecorView = paramDecorView;
  }
  
  public final void setPAGScaleMode(@NotNull ViewData paramViewData, @NotNull XAPagView paramXAPagView)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "data");
    Intrinsics.checkParameterIsNotNull(paramXAPagView, "xaPagView");
    HashMap localHashMap = paramViewData.getExts();
    if (localHashMap == null) {
      Intrinsics.throwNpe();
    }
    if (localHashMap.get("scaleMode") == null) {
      return;
    }
    paramViewData = paramViewData.getExts();
    if (paramViewData == null) {
      Intrinsics.throwNpe();
    }
    paramViewData = paramViewData.get("scaleMode");
    if (paramViewData != null)
    {
      paramXAPagView.setScaleMode((int)((Double)paramViewData).doubleValue());
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Double");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.XAPagView
 * JD-Core Version:    0.7.0.1
 */