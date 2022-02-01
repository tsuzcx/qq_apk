package com.tencent.xaction;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.view.View;
import androidx.annotation.Keep;
import com.google.gson.internal.LinkedTreeMap;
import com.tencent.xaction.api.IAnim;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.DecorView;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.api.util.BitmapUtil;
import com.tencent.xaction.api.util.BitmapUtil.Companion;
import com.tencent.xaction.api.util.FilePathUtil;
import com.tencent.xaction.api.util.FilePathUtil.Companion;
import com.tencent.xaction.api.util.FileUtil;
import com.tencent.xaction.api.util.FileUtil.Companion;
import com.tencent.xaction.manager.RuleManager;
import com.tencent.xaction.manager.RuleManager.Companion;
import com.tencent.xaction.openapi.api.IPublicRuleManager;
import com.tencent.xaction.openapi.api.IXAEngine;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGFont;
import org.libpag.PAGImage;
import org.libpag.PAGText;
import org.libpag.PAGView;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/XAPagView;", "Lorg/libpag/PAGView;", "Lcom/tencent/xaction/api/IView;", "Lcom/tencent/xaction/api/IAnim;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "decor", "Lcom/tencent/xaction/api/base/DecorView;", "getDecor", "()Lcom/tencent/xaction/api/base/DecorView;", "setDecor", "(Lcom/tencent/xaction/api/base/DecorView;)V", "doFrame", "", "frameTimeNanos", "", "end", "executeBlock", "data", "Lcom/tencent/xaction/api/data/ViewData;", "engine", "Lcom/tencent/xaction/openapi/api/IXAEngine;", "play", "preStart", "view", "Landroid/view/View;", "replacePagImage", "xaPagView", "pagFile", "Lorg/libpag/PAGFile;", "replacePagText", "setPAGScaleMode", "XAPag_release"}, k=1, mv={1, 1, 16})
@Keep
public final class XAPagView
  extends PAGView
  implements IAnim, IView
{
  private final String TAG = "XAPagView";
  private HashMap _$_findViewCache;
  @NotNull
  private DecorView decor = (DecorView)new XAPagView.decor.1(this, (IView)this);
  
  public XAPagView(@Nullable Context paramContext)
  {
    super(paramContext);
  }
  
  private final void executeBlock(ViewData paramViewData, IXAEngine paramIXAEngine)
  {
    if (paramViewData == null) {
      Intrinsics.throwNpe();
    }
    Object localObject = paramViewData.getExts();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    if (((HashMap)localObject).get("playblock") == null) {
      return;
    }
    paramViewData = paramViewData.getExts();
    if (paramViewData == null) {
      Intrinsics.throwNpe();
    }
    paramViewData = paramViewData.get("playblock");
    if (paramViewData != null)
    {
      paramViewData = ((Iterable)paramViewData).iterator();
      while (paramViewData.hasNext())
      {
        localObject = (String)paramViewData.next();
        RuleManager.Companion localCompanion = RuleManager.Companion;
        localObject = paramIXAEngine.getRuleManager().getRuleValue((String)localObject);
        if (localObject != null) {
          try
          {
            if (!(localObject instanceof Unit)) {
              if (localObject != null) {
                ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(localObject, 1)).invoke(this);
              } else {
                throw new TypeCastException("null cannot be cast to non-null type (kotlin.Any?) -> T?");
              }
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
    paramViewData = new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
    for (;;)
    {
      throw paramViewData;
    }
  }
  
  public void _$_clearFindViewByIdCache()
  {
    HashMap localHashMap = this._$_findViewCache;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void doFrame(long paramLong) {}
  
  public void end()
  {
    super.stop();
  }
  
  @NotNull
  public DecorView getDecor()
  {
    return this.decor;
  }
  
  public void play()
  {
    setProgress(0.0D);
    super.play();
    ViewData localViewData = getDecor().e();
    if (localViewData == null) {
      Intrinsics.throwNpe();
    }
    IXAEngine localIXAEngine = getDecor().d();
    if (localIXAEngine == null) {
      Intrinsics.throwNpe();
    }
    executeBlock(localViewData, localIXAEngine);
  }
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    paramView = getDecor().e();
    if (paramView == null) {
      Intrinsics.throwNpe();
    }
    IXAEngine localIXAEngine = getDecor().d();
    if (localIXAEngine == null) {
      Intrinsics.throwNpe();
    }
    replacePagText(paramView, localIXAEngine, this, (PAGFile)getComposition());
    paramView = getDecor().e();
    if (paramView == null) {
      Intrinsics.throwNpe();
    }
    localIXAEngine = getDecor().d();
    if (localIXAEngine == null) {
      Intrinsics.throwNpe();
    }
    replacePagImage(paramView, localIXAEngine, this, (PAGFile)getComposition());
  }
  
  public final void replacePagImage(@NotNull ViewData paramViewData, @NotNull IXAEngine paramIXAEngine, @NotNull XAPagView paramXAPagView, @Nullable PAGFile paramPAGFile)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "data");
    Intrinsics.checkParameterIsNotNull(paramIXAEngine, "engine");
    Intrinsics.checkParameterIsNotNull(paramXAPagView, "xaPagView");
    Object localObject1 = paramViewData.getExts();
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    if (((HashMap)localObject1).get("image") == null) {
      return;
    }
    paramViewData = paramViewData.getExts();
    if (paramViewData == null) {
      Intrinsics.throwNpe();
    }
    paramViewData = paramViewData.get("image");
    Iterator localIterator;
    if (paramViewData != null) {
      localIterator = ((Iterable)paramViewData).iterator();
    }
    for (;;)
    {
      Object localObject3;
      Object localObject4;
      if (localIterator.hasNext())
      {
        paramViewData = (LinkedTreeMap)localIterator.next();
        localObject3 = paramViewData.get("layer");
        localObject4 = paramViewData.get("value");
        if (!(localObject4 instanceof String)) {}
      }
      else
      {
        label385:
        label388:
        do
        {
          for (;;)
          {
            try
            {
              paramViewData = RuleManager.Companion;
              Object localObject2 = paramIXAEngine.getRuleManager().getRuleValue((String)localObject4);
              localObject1 = null;
              paramViewData = (ViewData)localObject1;
              if (localObject2 != null) {
                try
                {
                  if ((localObject2 instanceof Bitmap))
                  {
                    paramViewData = (ViewData)localObject2;
                    break label385;
                  }
                  if (localObject2 != null)
                  {
                    paramViewData = ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(localObject2, 1)).invoke(paramXAPagView);
                    break label385;
                  }
                  throw new TypeCastException("null cannot be cast to non-null type (kotlin.Any?) -> T?");
                }
                catch (Exception paramViewData)
                {
                  paramViewData.printStackTrace();
                  paramViewData = (ViewData)localObject1;
                }
              }
              localObject1 = (Bitmap)paramViewData;
              paramViewData = (ViewData)localObject1;
              if (localObject1 != null) {
                break label388;
              }
              paramViewData = FileUtil.a;
              localObject2 = getContext();
              Intrinsics.checkExpressionValueIsNotNull(localObject2, "this.context");
              localObject2 = paramViewData.a((Context)localObject2, (String)localObject4, "$PARENT_ROOT", paramIXAEngine);
              paramViewData = (ViewData)localObject1;
              if (localObject2 == null) {
                break label388;
              }
              paramViewData = BitmapUtil.a;
              localObject1 = getResources();
              if (localObject1 == null) {
                Intrinsics.throwNpe();
              }
              paramViewData = paramViewData.a((Resources)localObject1, (String)localObject2, new BitmapFactory.Options(), false, null);
            }
            catch (Exception paramViewData)
            {
              paramViewData.printStackTrace();
            }
            paramViewData = PAGImage.FromBitmap(paramViewData);
            if (paramPAGFile == null) {
              break;
            }
            if (localObject3 != null)
            {
              paramPAGFile.replaceImage((int)((Double)localObject3).doubleValue(), paramViewData);
              break;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Double");
            break;
            return;
            paramViewData = new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.google.gson.internal.LinkedTreeMap<kotlin.String, kotlin.Any>> /* = java.util.ArrayList<com.google.gson.internal.LinkedTreeMap<kotlin.String, kotlin.Any>> */");
            for (;;)
            {
              throw paramViewData;
            }
          }
        } while (paramViewData != null);
      }
    }
  }
  
  public final void replacePagText(@NotNull ViewData paramViewData, @NotNull IXAEngine paramIXAEngine, @NotNull XAPagView paramXAPagView, @Nullable PAGFile paramPAGFile)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "data");
    Intrinsics.checkParameterIsNotNull(paramIXAEngine, "engine");
    Intrinsics.checkParameterIsNotNull(paramXAPagView, "xaPagView");
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
    Object localObject2;
    Object localObject3;
    if (paramViewData != null)
    {
      Iterator localIterator = ((Iterable)paramViewData).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (LinkedTreeMap)localIterator.next();
        localObject2 = ((LinkedTreeMap)localObject1).get("layer");
        paramViewData = ((LinkedTreeMap)localObject1).get("value");
        localObject3 = ((LinkedTreeMap)localObject1).get("font");
      } while (!(paramViewData instanceof String));
    }
    for (;;)
    {
      try
      {
        Object localObject4 = (CharSequence)paramViewData;
        CharSequence localCharSequence = (CharSequence)"$";
        localObject1 = null;
        if (StringsKt.contains$default((CharSequence)localObject4, localCharSequence, false, 2, null))
        {
          localObject4 = RuleManager.Companion;
          paramViewData = paramIXAEngine.getRuleManager().getRuleValue((String)paramViewData);
          if (paramViewData == null) {
            break label440;
          }
          try
          {
            if (!(paramViewData instanceof String)) {
              if (paramViewData != null) {
                paramViewData = ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(paramViewData, 1)).invoke(paramXAPagView);
              } else {
                throw new TypeCastException("null cannot be cast to non-null type (kotlin.Any?) -> T?");
              }
            }
          }
          catch (Exception paramViewData)
          {
            paramViewData.printStackTrace();
          }
          paramViewData = (String)paramViewData;
          if (paramViewData == null) {
            return;
          }
        }
        else
        {
          paramViewData = (String)paramViewData;
        }
        if (paramPAGFile != null) {
          localObject1 = paramPAGFile.getTextData(0);
        }
        if ((localObject3 instanceof String))
        {
          localObject3 = FilePathUtil.a.a((String)localObject3, "$PARENT_ROOT", paramIXAEngine);
          if (new File((String)localObject3).exists())
          {
            localObject3 = PAGFont.RegisterFont((String)localObject3);
            if (localObject1 != null) {
              ((PAGText)localObject1).fontFamily = ((PAGFont)localObject3).fontFamily;
            }
            if (localObject1 != null) {
              ((PAGText)localObject1).fontStyle = ((PAGFont)localObject3).fontStyle;
            }
          }
        }
        if (localObject1 != null) {
          ((PAGText)localObject1).text = paramViewData;
        }
        if (paramPAGFile != null) {
          if (localObject2 != null) {
            paramPAGFile.replaceText((int)((Double)localObject2).doubleValue(), (PAGText)localObject1);
          } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Double");
          }
        }
        paramXAPagView.flush();
      }
      catch (Exception paramViewData)
      {
        paramViewData.printStackTrace();
      }
      break;
      return;
      paramViewData = new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.google.gson.internal.LinkedTreeMap<kotlin.String, kotlin.Any>> /* = java.util.ArrayList<com.google.gson.internal.LinkedTreeMap<kotlin.String, kotlin.Any>> */");
      for (;;)
      {
        throw paramViewData;
      }
      label440:
      paramViewData = null;
    }
  }
  
  public void setDecor(@NotNull DecorView paramDecorView)
  {
    Intrinsics.checkParameterIsNotNull(paramDecorView, "<set-?>");
    this.decor = paramDecorView;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.XAPagView
 * JD-Core Version:    0.7.0.1
 */