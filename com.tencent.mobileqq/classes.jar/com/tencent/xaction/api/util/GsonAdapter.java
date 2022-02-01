package com.tencent.xaction.api.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.xaction.anim.Elevation;
import com.tencent.xaction.anim.Layer;
import com.tencent.xaction.anim.Layout;
import com.tencent.xaction.anim.Opacity;
import com.tencent.xaction.anim.ResAnim;
import com.tencent.xaction.anim.Rotate;
import com.tencent.xaction.anim.Scale;
import com.tencent.xaction.anim.Translation;
import com.tencent.xaction.anim.Vibrate;
import com.tencent.xaction.anim.Visibility;
import com.tencent.xaction.api.IAnim;
import com.tencent.xaction.api.ITrigger;
import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.api.base.DecorDrawableState;
import com.tencent.xaction.drawable.DrawableAnim;
import com.tencent.xaction.trigger.AnimTrigger;
import com.tencent.xaction.trigger.BannerTrigger;
import com.tencent.xaction.trigger.BaseTrigger;
import com.tencent.xaction.trigger.CardFlipTrigger;
import com.tencent.xaction.trigger.ClickTrigger;
import com.tencent.xaction.trigger.GestureTrigger;
import com.tencent.xaction.trigger.MoveTrigger;
import com.tencent.xaction.trigger.ShakeTrigger;
import com.tencent.xaction.trigger.TextTrigger;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/util/GsonAdapter;", "", "()V", "ANIM_TYPE", "Ljava/util/HashMap;", "", "Ljava/lang/Class;", "Lcom/tencent/xaction/api/IAnim;", "getANIM_TYPE", "()Ljava/util/HashMap;", "DRAWABLE_TYPE", "getDRAWABLE_TYPE", "TRIGGER_TYPE", "Lcom/tencent/xaction/api/ITrigger;", "getTRIGGER_TYPE", "buildGson", "Lcom/google/gson/Gson;", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class GsonAdapter
{
  public static final GsonAdapter a = new GsonAdapter();
  @NotNull
  private static final HashMap<String, Class<? extends IAnim>> b = new HashMap();
  @NotNull
  private static final HashMap<String, Class<? extends ITrigger>> c = new HashMap();
  @NotNull
  private static final HashMap<String, String> d = new HashMap();
  
  static
  {
    ((Map)b).put("scale", Scale.class);
    ((Map)b).put("translation", Translation.class);
    ((Map)b).put("vibrate", Vibrate.class);
    ((Map)b).put("rotate", Rotate.class);
    ((Map)b).put("opacity", Opacity.class);
    ((Map)b).put("elevation", Elevation.class);
    ((Map)b).put("visibility", Visibility.class);
    ((Map)b).put("layout", Layout.class);
    ((Map)b).put("drawable", DrawableAnim.class);
    ((Map)b).put("res", ResAnim.class);
    ((Map)b).put("layer", Layer.class);
    ((Map)c).put("click", ClickTrigger.class);
    ((Map)c).put("move", MoveTrigger.class);
    ((Map)c).put("flip", CardFlipTrigger.class);
    ((Map)c).put("gesture", GestureTrigger.class);
    ((Map)c).put("banner", BannerTrigger.class);
    ((Map)c).put("anim", AnimTrigger.class);
    ((Map)c).put("shake", ShakeTrigger.class);
    ((Map)c).put("text", TextTrigger.class);
    ((Map)d).put("pngs", "com.tencent.xaction.drawable.pngs.PngsDecorDrawable$PngsDecorDrawableState");
    ((Map)d).put("gldrawable", "com.tencent.xaction.gldrawable.GLDrawableDecor$GLDrawableDecorState");
    ((Map)d).put("partical", "com.tencent.xaction.drawable.partical.ParticalDecorDrawable$ParticalDecorDrawableState");
    ((Map)d).put("gesdraw", "com.tencent.xaction.apng.GiftDiyDecorDrawable$GiftDiyDecorDrawableState");
    ((Map)d).put("apng", "com.tencent.xaction.apng.ApngDecorDrawable$ApngDecorDrawableState");
    ((Map)d).put("shoot", "com.tencent.xaction.XAPhysicalDecorDrawable$XAPhysicalDecorDrawableState");
  }
  
  @JvmStatic
  @NotNull
  public static final Gson d()
  {
    Gson localGson = new GsonBuilder().registerTypeAdapter((Type)BaseAnim.class, new BaseAnimAdapter()).registerTypeAdapter((Type)BaseTrigger.class, new BaseTriggerAdapter()).registerTypeAdapter((Type)DecorDrawableState.class, new BaseDrawableAdapter()).create();
    Intrinsics.checkExpressionValueIsNotNull(localGson, "GsonBuilder()\n          …()\n            ).create()");
    return localGson;
  }
  
  @NotNull
  public final HashMap<String, Class<? extends IAnim>> a()
  {
    return b;
  }
  
  @NotNull
  public final HashMap<String, Class<? extends ITrigger>> b()
  {
    return c;
  }
  
  @NotNull
  public final HashMap<String, String> c()
  {
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.api.util.GsonAdapter
 * JD-Core Version:    0.7.0.1
 */