package com.tencent.xaction.api.data;

import androidx.annotation.Keep;
import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.api.base.DecorDrawableState;
import com.tencent.xaction.api.style.Style;
import com.tencent.xaction.impl.XATimeline;
import com.tencent.xaction.trigger.BaseTrigger;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/data/ViewData;", "", "id", "", "st", "Lcom/tencent/xaction/api/style/Style;", "rules", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "tl", "Lcom/tencent/xaction/impl/XATimeline;", "tp", "Lcom/tencent/xaction/api/data/TimeProp;", "anim", "Ljava/util/ArrayList;", "Lcom/tencent/xaction/api/base/BaseAnim;", "Lkotlin/collections/ArrayList;", "tr", "Lcom/tencent/xaction/trigger/BaseTrigger;", "type", "animType", "views", "gt", "comptId", "float", "drawable", "Lcom/tencent/xaction/api/base/DecorDrawableState;", "exts", "(ILcom/tencent/xaction/api/style/Style;Ljava/util/HashMap;Lcom/tencent/xaction/impl/XATimeline;Lcom/tencent/xaction/api/data/TimeProp;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/xaction/api/base/DecorDrawableState;Ljava/util/HashMap;)V", "getAnim", "()Ljava/util/ArrayList;", "setAnim", "(Ljava/util/ArrayList;)V", "getAnimType", "()Ljava/lang/String;", "setAnimType", "(Ljava/lang/String;)V", "getComptId", "()I", "setComptId", "(I)V", "getDrawable", "()Lcom/tencent/xaction/api/base/DecorDrawableState;", "setDrawable", "(Lcom/tencent/xaction/api/base/DecorDrawableState;)V", "getExts", "()Ljava/util/HashMap;", "setExts", "(Ljava/util/HashMap;)V", "getFloat", "setFloat", "getGt", "setGt", "getId", "setId", "getRules", "getSt", "()Lcom/tencent/xaction/api/style/Style;", "getTl", "()Lcom/tencent/xaction/impl/XATimeline;", "setTl", "(Lcom/tencent/xaction/impl/XATimeline;)V", "getTp", "()Lcom/tencent/xaction/api/data/TimeProp;", "setTp", "(Lcom/tencent/xaction/api/data/TimeProp;)V", "getTr", "setTr", "getType", "setType", "getViews", "setViews", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "XActionEngine_release"}, k=1, mv={1, 1, 16})
@Keep
public final class ViewData
{
  @NotNull
  private ArrayList<BaseAnim> anim;
  @NotNull
  private String animType;
  private int comptId;
  @Nullable
  private DecorDrawableState drawable;
  @Nullable
  private HashMap<String, Object> exts;
  @NotNull
  private String jdField_float;
  @Nullable
  private String gt;
  private int id;
  @Nullable
  private final HashMap<String, String> rules;
  @NotNull
  private final Style st;
  @Nullable
  private transient XATimeline tl;
  @NotNull
  private TimeProp tp;
  @NotNull
  private ArrayList<BaseTrigger> tr;
  @NotNull
  private String type;
  @Nullable
  private ArrayList<ViewData> views;
  
  public ViewData()
  {
    this(0, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, 32767, null);
  }
  
  public ViewData(int paramInt1, @NotNull Style paramStyle, @Nullable HashMap<String, String> paramHashMap, @Nullable XATimeline paramXATimeline, @NotNull TimeProp paramTimeProp, @NotNull ArrayList<BaseAnim> paramArrayList, @NotNull ArrayList<BaseTrigger> paramArrayList1, @NotNull String paramString1, @NotNull String paramString2, @Nullable ArrayList<ViewData> paramArrayList2, @Nullable String paramString3, int paramInt2, @NotNull String paramString4, @Nullable DecorDrawableState paramDecorDrawableState, @Nullable HashMap<String, Object> paramHashMap1)
  {
    this.id = paramInt1;
    this.st = paramStyle;
    this.rules = paramHashMap;
    this.tl = paramXATimeline;
    this.tp = paramTimeProp;
    this.anim = paramArrayList;
    this.tr = paramArrayList1;
    this.type = paramString1;
    this.animType = paramString2;
    this.views = paramArrayList2;
    this.gt = paramString3;
    this.comptId = paramInt2;
    this.jdField_float = paramString4;
    this.drawable = paramDecorDrawableState;
    this.exts = paramHashMap1;
  }
  
  public final int component1()
  {
    return this.id;
  }
  
  @Nullable
  public final ArrayList<ViewData> component10()
  {
    return this.views;
  }
  
  @Nullable
  public final String component11()
  {
    return this.gt;
  }
  
  public final int component12()
  {
    return this.comptId;
  }
  
  @NotNull
  public final String component13()
  {
    return this.jdField_float;
  }
  
  @Nullable
  public final DecorDrawableState component14()
  {
    return this.drawable;
  }
  
  @Nullable
  public final HashMap<String, Object> component15()
  {
    return this.exts;
  }
  
  @NotNull
  public final Style component2()
  {
    return this.st;
  }
  
  @Nullable
  public final HashMap<String, String> component3()
  {
    return this.rules;
  }
  
  @Nullable
  public final XATimeline component4()
  {
    return this.tl;
  }
  
  @NotNull
  public final TimeProp component5()
  {
    return this.tp;
  }
  
  @NotNull
  public final ArrayList<BaseAnim> component6()
  {
    return this.anim;
  }
  
  @NotNull
  public final ArrayList<BaseTrigger> component7()
  {
    return this.tr;
  }
  
  @NotNull
  public final String component8()
  {
    return this.type;
  }
  
  @NotNull
  public final String component9()
  {
    return this.animType;
  }
  
  @NotNull
  public final ViewData copy(int paramInt1, @NotNull Style paramStyle, @Nullable HashMap<String, String> paramHashMap, @Nullable XATimeline paramXATimeline, @NotNull TimeProp paramTimeProp, @NotNull ArrayList<BaseAnim> paramArrayList, @NotNull ArrayList<BaseTrigger> paramArrayList1, @NotNull String paramString1, @NotNull String paramString2, @Nullable ArrayList<ViewData> paramArrayList2, @Nullable String paramString3, int paramInt2, @NotNull String paramString4, @Nullable DecorDrawableState paramDecorDrawableState, @Nullable HashMap<String, Object> paramHashMap1)
  {
    Intrinsics.checkParameterIsNotNull(paramStyle, "st");
    Intrinsics.checkParameterIsNotNull(paramTimeProp, "tp");
    Intrinsics.checkParameterIsNotNull(paramArrayList, "anim");
    Intrinsics.checkParameterIsNotNull(paramArrayList1, "tr");
    Intrinsics.checkParameterIsNotNull(paramString1, "type");
    Intrinsics.checkParameterIsNotNull(paramString2, "animType");
    Intrinsics.checkParameterIsNotNull(paramString4, "jdField_float");
    return new ViewData(paramInt1, paramStyle, paramHashMap, paramXATimeline, paramTimeProp, paramArrayList, paramArrayList1, paramString1, paramString2, paramArrayList2, paramString3, paramInt2, paramString4, paramDecorDrawableState, paramHashMap1);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof ViewData))
      {
        paramObject = (ViewData)paramObject;
        if ((this.id != paramObject.id) || (!Intrinsics.areEqual(this.st, paramObject.st)) || (!Intrinsics.areEqual(this.rules, paramObject.rules)) || (!Intrinsics.areEqual(this.tl, paramObject.tl)) || (!Intrinsics.areEqual(this.tp, paramObject.tp)) || (!Intrinsics.areEqual(this.anim, paramObject.anim)) || (!Intrinsics.areEqual(this.tr, paramObject.tr)) || (!Intrinsics.areEqual(this.type, paramObject.type)) || (!Intrinsics.areEqual(this.animType, paramObject.animType)) || (!Intrinsics.areEqual(this.views, paramObject.views)) || (!Intrinsics.areEqual(this.gt, paramObject.gt)) || (this.comptId != paramObject.comptId) || (!Intrinsics.areEqual(this.jdField_float, paramObject.jdField_float)) || (!Intrinsics.areEqual(this.drawable, paramObject.drawable)) || (!Intrinsics.areEqual(this.exts, paramObject.exts))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  @NotNull
  public final ArrayList<BaseAnim> getAnim()
  {
    return this.anim;
  }
  
  @NotNull
  public final String getAnimType()
  {
    return this.animType;
  }
  
  public final int getComptId()
  {
    return this.comptId;
  }
  
  @Nullable
  public final DecorDrawableState getDrawable()
  {
    return this.drawable;
  }
  
  @Nullable
  public final HashMap<String, Object> getExts()
  {
    return this.exts;
  }
  
  @NotNull
  public final String getFloat()
  {
    return this.jdField_float;
  }
  
  @Nullable
  public final String getGt()
  {
    return this.gt;
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  @Nullable
  public final HashMap<String, String> getRules()
  {
    return this.rules;
  }
  
  @NotNull
  public final Style getSt()
  {
    return this.st;
  }
  
  @Nullable
  public final XATimeline getTl()
  {
    return this.tl;
  }
  
  @NotNull
  public final TimeProp getTp()
  {
    return this.tp;
  }
  
  @NotNull
  public final ArrayList<BaseTrigger> getTr()
  {
    return this.tr;
  }
  
  @NotNull
  public final String getType()
  {
    return this.type;
  }
  
  @Nullable
  public final ArrayList<ViewData> getViews()
  {
    return this.views;
  }
  
  public int hashCode()
  {
    int i8 = 0;
    int i9 = this.id;
    Object localObject = this.st;
    int i;
    int j;
    label43:
    int k;
    label60:
    int m;
    label78:
    int n;
    label96:
    int i1;
    label114:
    int i2;
    label132:
    int i3;
    label150:
    int i4;
    label168:
    int i5;
    label186:
    int i10;
    int i6;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.rules;
      if (localObject == null) {
        break label335;
      }
      j = localObject.hashCode();
      localObject = this.tl;
      if (localObject == null) {
        break label340;
      }
      k = localObject.hashCode();
      localObject = this.tp;
      if (localObject == null) {
        break label345;
      }
      m = localObject.hashCode();
      localObject = this.anim;
      if (localObject == null) {
        break label351;
      }
      n = localObject.hashCode();
      localObject = this.tr;
      if (localObject == null) {
        break label357;
      }
      i1 = localObject.hashCode();
      localObject = this.type;
      if (localObject == null) {
        break label363;
      }
      i2 = localObject.hashCode();
      localObject = this.animType;
      if (localObject == null) {
        break label369;
      }
      i3 = localObject.hashCode();
      localObject = this.views;
      if (localObject == null) {
        break label375;
      }
      i4 = localObject.hashCode();
      localObject = this.gt;
      if (localObject == null) {
        break label381;
      }
      i5 = localObject.hashCode();
      i10 = this.comptId;
      localObject = this.jdField_float;
      if (localObject == null) {
        break label387;
      }
      i6 = localObject.hashCode();
      label210:
      localObject = this.drawable;
      if (localObject == null) {
        break label393;
      }
    }
    label387:
    label393:
    for (int i7 = localObject.hashCode();; i7 = 0)
    {
      localObject = this.exts;
      if (localObject != null) {
        i8 = localObject.hashCode();
      }
      return (i7 + (i6 + ((i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + i9 * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i10) * 31) * 31) * 31 + i8;
      i = 0;
      break;
      label335:
      j = 0;
      break label43;
      label340:
      k = 0;
      break label60;
      label345:
      m = 0;
      break label78;
      label351:
      n = 0;
      break label96;
      label357:
      i1 = 0;
      break label114;
      label363:
      i2 = 0;
      break label132;
      label369:
      i3 = 0;
      break label150;
      label375:
      i4 = 0;
      break label168;
      label381:
      i5 = 0;
      break label186;
      i6 = 0;
      break label210;
    }
  }
  
  public final void setAnim(@NotNull ArrayList<BaseAnim> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "<set-?>");
    this.anim = paramArrayList;
  }
  
  public final void setAnimType(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.animType = paramString;
  }
  
  public final void setComptId(int paramInt)
  {
    this.comptId = paramInt;
  }
  
  public final void setDrawable(@Nullable DecorDrawableState paramDecorDrawableState)
  {
    this.drawable = paramDecorDrawableState;
  }
  
  public final void setExts(@Nullable HashMap<String, Object> paramHashMap)
  {
    this.exts = paramHashMap;
  }
  
  public final void setFloat(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_float = paramString;
  }
  
  public final void setGt(@Nullable String paramString)
  {
    this.gt = paramString;
  }
  
  public final void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public final void setTl(@Nullable XATimeline paramXATimeline)
  {
    this.tl = paramXATimeline;
  }
  
  public final void setTp(@NotNull TimeProp paramTimeProp)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeProp, "<set-?>");
    this.tp = paramTimeProp;
  }
  
  public final void setTr(@NotNull ArrayList<BaseTrigger> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "<set-?>");
    this.tr = paramArrayList;
  }
  
  public final void setType(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.type = paramString;
  }
  
  public final void setViews(@Nullable ArrayList<ViewData> paramArrayList)
  {
    this.views = paramArrayList;
  }
  
  @NotNull
  public String toString()
  {
    return "ViewData(id=" + this.id + ", st=" + this.st + ", rules=" + this.rules + ", tl=" + this.tl + ", tp=" + this.tp + ", anim=" + this.anim + ", tr=" + this.tr + ", type=" + this.type + ", animType=" + this.animType + ", views=" + this.views + ", gt=" + this.gt + ", comptId=" + this.comptId + ", float=" + this.jdField_float + ", drawable=" + this.drawable + ", exts=" + this.exts + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.data.ViewData
 * JD-Core Version:    0.7.0.1
 */