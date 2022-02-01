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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/data/ViewData;", "", "id", "", "singleTag", "", "tag", "st", "Lcom/tencent/xaction/api/style/Style;", "rules", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "tl", "Lcom/tencent/xaction/impl/XATimeline;", "tp", "Lcom/tencent/xaction/api/data/TimeProp;", "linkDelay", "anim", "Ljava/util/ArrayList;", "Lcom/tencent/xaction/api/base/BaseAnim;", "Lkotlin/collections/ArrayList;", "tr", "Lcom/tencent/xaction/trigger/BaseTrigger;", "type", "views", "gt", "comptId", "float", "drawable", "Lcom/tencent/xaction/api/base/DecorDrawableState;", "exts", "rwd", "", "(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/xaction/api/style/Style;Ljava/util/HashMap;Lcom/tencent/xaction/impl/XATimeline;Lcom/tencent/xaction/api/data/TimeProp;ILjava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/xaction/api/base/DecorDrawableState;Ljava/util/HashMap;Z)V", "getAnim", "()Ljava/util/ArrayList;", "setAnim", "(Ljava/util/ArrayList;)V", "getComptId", "()I", "setComptId", "(I)V", "getDrawable", "()Lcom/tencent/xaction/api/base/DecorDrawableState;", "setDrawable", "(Lcom/tencent/xaction/api/base/DecorDrawableState;)V", "getExts", "()Ljava/util/HashMap;", "setExts", "(Ljava/util/HashMap;)V", "getFloat", "()Ljava/lang/String;", "setFloat", "(Ljava/lang/String;)V", "getGt", "setGt", "getId", "setId", "getLinkDelay", "setLinkDelay", "getRules", "getRwd", "()Z", "setRwd", "(Z)V", "getSingleTag", "getSt", "()Lcom/tencent/xaction/api/style/Style;", "getTag", "getTl", "()Lcom/tencent/xaction/impl/XATimeline;", "setTl", "(Lcom/tencent/xaction/impl/XATimeline;)V", "getTp", "()Lcom/tencent/xaction/api/data/TimeProp;", "setTp", "(Lcom/tencent/xaction/api/data/TimeProp;)V", "getTr", "setTr", "getType", "setType", "getViews", "setViews", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class ViewData
{
  @NotNull
  private ArrayList<BaseAnim> anim;
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
  private int linkDelay;
  @Nullable
  private final HashMap<String, String> rules;
  private boolean rwd;
  @Nullable
  private final String singleTag;
  @NotNull
  private final Style st;
  @Nullable
  private final String tag;
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
    this(0, null, null, null, null, null, null, 0, null, null, null, null, null, 0, null, null, null, false, 262143, null);
  }
  
  public ViewData(int paramInt1, @Nullable String paramString1, @Nullable String paramString2, @NotNull Style paramStyle, @Nullable HashMap<String, String> paramHashMap, @Nullable XATimeline paramXATimeline, @NotNull TimeProp paramTimeProp, int paramInt2, @NotNull ArrayList<BaseAnim> paramArrayList, @NotNull ArrayList<BaseTrigger> paramArrayList1, @NotNull String paramString3, @Nullable ArrayList<ViewData> paramArrayList2, @Nullable String paramString4, int paramInt3, @NotNull String paramString5, @Nullable DecorDrawableState paramDecorDrawableState, @Nullable HashMap<String, Object> paramHashMap1, boolean paramBoolean)
  {
    this.id = paramInt1;
    this.singleTag = paramString1;
    this.tag = paramString2;
    this.st = paramStyle;
    this.rules = paramHashMap;
    this.tl = paramXATimeline;
    this.tp = paramTimeProp;
    this.linkDelay = paramInt2;
    this.anim = paramArrayList;
    this.tr = paramArrayList1;
    this.type = paramString3;
    this.views = paramArrayList2;
    this.gt = paramString4;
    this.comptId = paramInt3;
    this.jdField_float = paramString5;
    this.drawable = paramDecorDrawableState;
    this.exts = paramHashMap1;
    this.rwd = paramBoolean;
  }
  
  public final int component1()
  {
    return this.id;
  }
  
  @NotNull
  public final ArrayList<BaseTrigger> component10()
  {
    return this.tr;
  }
  
  @NotNull
  public final String component11()
  {
    return this.type;
  }
  
  @Nullable
  public final ArrayList<ViewData> component12()
  {
    return this.views;
  }
  
  @Nullable
  public final String component13()
  {
    return this.gt;
  }
  
  public final int component14()
  {
    return this.comptId;
  }
  
  @NotNull
  public final String component15()
  {
    return this.jdField_float;
  }
  
  @Nullable
  public final DecorDrawableState component16()
  {
    return this.drawable;
  }
  
  @Nullable
  public final HashMap<String, Object> component17()
  {
    return this.exts;
  }
  
  public final boolean component18()
  {
    return this.rwd;
  }
  
  @Nullable
  public final String component2()
  {
    return this.singleTag;
  }
  
  @Nullable
  public final String component3()
  {
    return this.tag;
  }
  
  @NotNull
  public final Style component4()
  {
    return this.st;
  }
  
  @Nullable
  public final HashMap<String, String> component5()
  {
    return this.rules;
  }
  
  @Nullable
  public final XATimeline component6()
  {
    return this.tl;
  }
  
  @NotNull
  public final TimeProp component7()
  {
    return this.tp;
  }
  
  public final int component8()
  {
    return this.linkDelay;
  }
  
  @NotNull
  public final ArrayList<BaseAnim> component9()
  {
    return this.anim;
  }
  
  @NotNull
  public final ViewData copy(int paramInt1, @Nullable String paramString1, @Nullable String paramString2, @NotNull Style paramStyle, @Nullable HashMap<String, String> paramHashMap, @Nullable XATimeline paramXATimeline, @NotNull TimeProp paramTimeProp, int paramInt2, @NotNull ArrayList<BaseAnim> paramArrayList, @NotNull ArrayList<BaseTrigger> paramArrayList1, @NotNull String paramString3, @Nullable ArrayList<ViewData> paramArrayList2, @Nullable String paramString4, int paramInt3, @NotNull String paramString5, @Nullable DecorDrawableState paramDecorDrawableState, @Nullable HashMap<String, Object> paramHashMap1, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramStyle, "st");
    Intrinsics.checkParameterIsNotNull(paramTimeProp, "tp");
    Intrinsics.checkParameterIsNotNull(paramArrayList, "anim");
    Intrinsics.checkParameterIsNotNull(paramArrayList1, "tr");
    Intrinsics.checkParameterIsNotNull(paramString3, "type");
    Intrinsics.checkParameterIsNotNull(paramString5, "jdField_float");
    return new ViewData(paramInt1, paramString1, paramString2, paramStyle, paramHashMap, paramXATimeline, paramTimeProp, paramInt2, paramArrayList, paramArrayList1, paramString3, paramArrayList2, paramString4, paramInt3, paramString5, paramDecorDrawableState, paramHashMap1, paramBoolean);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ViewData))
      {
        paramObject = (ViewData)paramObject;
        if ((this.id == paramObject.id) && (Intrinsics.areEqual(this.singleTag, paramObject.singleTag)) && (Intrinsics.areEqual(this.tag, paramObject.tag)) && (Intrinsics.areEqual(this.st, paramObject.st)) && (Intrinsics.areEqual(this.rules, paramObject.rules)) && (Intrinsics.areEqual(this.tl, paramObject.tl)) && (Intrinsics.areEqual(this.tp, paramObject.tp)) && (this.linkDelay == paramObject.linkDelay) && (Intrinsics.areEqual(this.anim, paramObject.anim)) && (Intrinsics.areEqual(this.tr, paramObject.tr)) && (Intrinsics.areEqual(this.type, paramObject.type)) && (Intrinsics.areEqual(this.views, paramObject.views)) && (Intrinsics.areEqual(this.gt, paramObject.gt)) && (this.comptId == paramObject.comptId) && (Intrinsics.areEqual(this.jdField_float, paramObject.jdField_float)) && (Intrinsics.areEqual(this.drawable, paramObject.drawable)) && (Intrinsics.areEqual(this.exts, paramObject.exts)) && (this.rwd == paramObject.rwd)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final ArrayList<BaseAnim> getAnim()
  {
    return this.anim;
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
  
  public final int getLinkDelay()
  {
    return this.linkDelay;
  }
  
  @Nullable
  public final HashMap<String, String> getRules()
  {
    return this.rules;
  }
  
  public final boolean getRwd()
  {
    return this.rwd;
  }
  
  @Nullable
  public final String getSingleTag()
  {
    return this.singleTag;
  }
  
  @NotNull
  public final Style getSt()
  {
    return this.st;
  }
  
  @Nullable
  public final String getTag()
  {
    return this.tag;
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void setAnim(@NotNull ArrayList<BaseAnim> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "<set-?>");
    this.anim = paramArrayList;
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
  
  public final void setLinkDelay(int paramInt)
  {
    this.linkDelay = paramInt;
  }
  
  public final void setRwd(boolean paramBoolean)
  {
    this.rwd = paramBoolean;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ViewData(id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", singleTag=");
    localStringBuilder.append(this.singleTag);
    localStringBuilder.append(", tag=");
    localStringBuilder.append(this.tag);
    localStringBuilder.append(", st=");
    localStringBuilder.append(this.st);
    localStringBuilder.append(", rules=");
    localStringBuilder.append(this.rules);
    localStringBuilder.append(", tl=");
    localStringBuilder.append(this.tl);
    localStringBuilder.append(", tp=");
    localStringBuilder.append(this.tp);
    localStringBuilder.append(", linkDelay=");
    localStringBuilder.append(this.linkDelay);
    localStringBuilder.append(", anim=");
    localStringBuilder.append(this.anim);
    localStringBuilder.append(", tr=");
    localStringBuilder.append(this.tr);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", views=");
    localStringBuilder.append(this.views);
    localStringBuilder.append(", gt=");
    localStringBuilder.append(this.gt);
    localStringBuilder.append(", comptId=");
    localStringBuilder.append(this.comptId);
    localStringBuilder.append(", float=");
    localStringBuilder.append(this.jdField_float);
    localStringBuilder.append(", drawable=");
    localStringBuilder.append(this.drawable);
    localStringBuilder.append(", exts=");
    localStringBuilder.append(this.exts);
    localStringBuilder.append(", rwd=");
    localStringBuilder.append(this.rwd);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.api.data.ViewData
 * JD-Core Version:    0.7.0.1
 */