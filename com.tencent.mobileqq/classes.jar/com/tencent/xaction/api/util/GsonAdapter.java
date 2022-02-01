package com.tencent.xaction.api.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.xaction.anim.Elevation;
import com.tencent.xaction.anim.Layout;
import com.tencent.xaction.anim.Opacity;
import com.tencent.xaction.anim.ResAnim;
import com.tencent.xaction.anim.Rotate;
import com.tencent.xaction.anim.Scale;
import com.tencent.xaction.anim.Translation;
import com.tencent.xaction.anim.Visibility;
import com.tencent.xaction.api.IAnim;
import com.tencent.xaction.api.ITrigger;
import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.api.base.DecorDrawableState;
import com.tencent.xaction.drawable.DrawableAnim;
import com.tencent.xaction.trigger.BannerTrigger;
import com.tencent.xaction.trigger.BaseTrigger;
import com.tencent.xaction.trigger.CardFlipTrigger;
import com.tencent.xaction.trigger.ClickTrigger;
import com.tencent.xaction.trigger.GestureTrigger;
import com.tencent.xaction.trigger.MoveTrigger;
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
  public static final GsonAdapter a;
  @NotNull
  private static final HashMap<String, Class<? extends IAnim>> a;
  @NotNull
  private static final HashMap<String, Class<? extends ITrigger>> b;
  @NotNull
  private static final HashMap<String, String> c;
  
  static
  {
    jdField_a_of_type_ComTencentXactionApiUtilGsonAdapter = new GsonAdapter();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    b = new HashMap();
    c = new HashMap();
    ((Map)jdField_a_of_type_JavaUtilHashMap).put("scale", Scale.class);
    ((Map)jdField_a_of_type_JavaUtilHashMap).put("translation", Translation.class);
    ((Map)jdField_a_of_type_JavaUtilHashMap).put("rotate", Rotate.class);
    ((Map)jdField_a_of_type_JavaUtilHashMap).put("opacity", Opacity.class);
    ((Map)jdField_a_of_type_JavaUtilHashMap).put("elevation", Elevation.class);
    ((Map)jdField_a_of_type_JavaUtilHashMap).put("visibility", Visibility.class);
    ((Map)jdField_a_of_type_JavaUtilHashMap).put("layout", Layout.class);
    ((Map)jdField_a_of_type_JavaUtilHashMap).put("drawable", DrawableAnim.class);
    ((Map)jdField_a_of_type_JavaUtilHashMap).put("res", ResAnim.class);
    ((Map)b).put("click", ClickTrigger.class);
    ((Map)b).put("move", MoveTrigger.class);
    ((Map)b).put("flip", CardFlipTrigger.class);
    ((Map)b).put("gesture", GestureTrigger.class);
    ((Map)b).put("banner", BannerTrigger.class);
    ((Map)b).put("text", TextTrigger.class);
    ((Map)c).put("pngs", "com.tencent.xaction.drawable.pngs.PngsDecorDrawable$PngsDecorDrawableState");
    ((Map)c).put("gldrawable", "com.tencent.xaction.gldrawable.GLDrawableDecor$GLDrawableDecorState");
    ((Map)c).put("partical", "com.tencent.xaction.drawable.partical.ParticalDecorDrawable$ParticalDecorDrawableState");
  }
  
  @JvmStatic
  @NotNull
  public static final Gson a()
  {
    Gson localGson = new GsonBuilder().registerTypeAdapter((Type)BaseAnim.class, new BaseAnimAdapter()).registerTypeAdapter((Type)BaseTrigger.class, new BaseTriggerAdapter()).registerTypeAdapter((Type)DecorDrawableState.class, new BaseDrawableAdapter()).create();
    Intrinsics.checkExpressionValueIsNotNull(localGson, "GsonBuilder()\n          …()\n            ).create()");
    return localGson;
  }
  
  @NotNull
  public final HashMap<String, Class<? extends IAnim>> a()
  {
    return jdField_a_of_type_JavaUtilHashMap;
  }
  
  @NotNull
  public final HashMap<String, Class<? extends ITrigger>> b()
  {
    return b;
  }
  
  @NotNull
  public final HashMap<String, String> c()
  {
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.api.util.GsonAdapter
 * JD-Core Version:    0.7.0.1
 */