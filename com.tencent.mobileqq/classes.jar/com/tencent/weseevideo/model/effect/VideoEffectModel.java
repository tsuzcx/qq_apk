package com.tencent.weseevideo.model.effect;

import android.text.TextUtils;
import com.tencent.tavcut.bean.TextItem;
import com.tencent.weseevideo.model.utils.FileUtils;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/model/effect/VideoEffectModel;", "Ljava/io/Serializable;", "effectType", "", "filePath", "", "stickerId", "startTime", "", "duration", "isUserEdit", "", "source", "effectId", "effectName", "effectBgColor", "createTime", "", "landscapePath", "animationMode", "verticalPath", "categoryId", "timeLineIndex", "effectSubType", "startOffset", "endOffset", "isRelative", "isLoadName", "pagTextItems", "", "Lcom/tencent/tavcut/bean/TextItem;", "(ILjava/lang/String;Ljava/lang/String;FFZILjava/lang/String;Ljava/lang/String;IJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;IIJJZZLjava/util/List;)V", "getAnimationMode", "()I", "setAnimationMode", "(I)V", "getCategoryId", "()Ljava/lang/String;", "setCategoryId", "(Ljava/lang/String;)V", "getCreateTime", "()J", "setCreateTime", "(J)V", "getDuration", "()F", "setDuration", "(F)V", "getEffectBgColor", "setEffectBgColor", "getEffectId", "setEffectId", "getEffectName", "setEffectName", "getEffectSubType", "setEffectSubType", "getEffectType", "setEffectType", "getEndOffset", "setEndOffset", "endTime", "getEndTime", "getFilePath", "setFilePath", "()Z", "setLoadName", "(Z)V", "setRelative", "setUserEdit", "getLandscapePath", "setLandscapePath", "getPagTextItems", "()Ljava/util/List;", "setPagTextItems", "(Ljava/util/List;)V", "getSource", "setSource", "getStartOffset", "setStartOffset", "getStartTime", "setStartTime", "getStickerId", "setStickerId", "getTimeLineIndex", "setTimeLineIndex", "getVerticalPath", "setVerticalPath", "clone", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "isVertical", "hashCode", "toString", "Companion", "EffectType", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class VideoEffectModel
  implements Serializable
{
  public static final VideoEffectModel.Companion Companion = new VideoEffectModel.Companion(null);
  private static final String LANDSCAPE_SUFFIX = "_landscape";
  private static final String PAG_SUFFIX = ".pag";
  public static final int STATUS_UN_POSITION = -1;
  public static final int TYPE_BEGIN = 1;
  public static final int TYPE_DEFAULT = 0;
  public static final int TYPE_END = 2;
  private int animationMode;
  @Nullable
  private String categoryId;
  private long createTime;
  private float duration;
  private int effectBgColor;
  @Nullable
  private String effectId;
  @Nullable
  private String effectName;
  private int effectSubType;
  private int effectType;
  private long endOffset;
  @Nullable
  private String filePath;
  private boolean isLoadName;
  private boolean isRelative;
  private boolean isUserEdit;
  @Nullable
  private String landscapePath;
  @Nullable
  private List<TextItem> pagTextItems;
  private int source;
  private long startOffset;
  private float startTime;
  @Nullable
  private String stickerId;
  private int timeLineIndex;
  @Nullable
  private String verticalPath;
  
  public VideoEffectModel()
  {
    this(0, null, null, 0.0F, 0.0F, false, 0, null, null, 0, 0L, null, 0, null, null, 0, 0, 0L, 0L, false, false, null, 4194303, null);
  }
  
  public VideoEffectModel(int paramInt1, @Nullable String paramString1, @Nullable String paramString2, float paramFloat1, float paramFloat2, boolean paramBoolean1, int paramInt2, @Nullable String paramString3, @Nullable String paramString4, int paramInt3, long paramLong1, @Nullable String paramString5, int paramInt4, @Nullable String paramString6, @Nullable String paramString7, int paramInt5, int paramInt6, long paramLong2, long paramLong3, boolean paramBoolean2, boolean paramBoolean3, @Nullable List<TextItem> paramList)
  {
    this.effectType = paramInt1;
    this.filePath = paramString1;
    this.stickerId = paramString2;
    this.startTime = paramFloat1;
    this.duration = paramFloat2;
    this.isUserEdit = paramBoolean1;
    this.source = paramInt2;
    this.effectId = paramString3;
    this.effectName = paramString4;
    this.effectBgColor = paramInt3;
    this.createTime = paramLong1;
    this.landscapePath = paramString5;
    this.animationMode = paramInt4;
    this.verticalPath = paramString6;
    this.categoryId = paramString7;
    this.timeLineIndex = paramInt5;
    this.effectSubType = paramInt6;
    this.startOffset = paramLong2;
    this.endOffset = paramLong3;
    this.isRelative = paramBoolean2;
    this.isLoadName = paramBoolean3;
    this.pagTextItems = paramList;
  }
  
  @NotNull
  public final VideoEffectModel clone()
  {
    return copy$default(this, 0, null, null, 0.0F, 0.0F, false, 0, null, null, 0, 0L, null, 0, null, null, 0, 0, 0L, 0L, false, false, null, 4194303, null);
  }
  
  public final int component1()
  {
    return this.effectType;
  }
  
  public final int component10()
  {
    return this.effectBgColor;
  }
  
  public final long component11()
  {
    return this.createTime;
  }
  
  @Nullable
  public final String component12()
  {
    return this.landscapePath;
  }
  
  public final int component13()
  {
    return this.animationMode;
  }
  
  @Nullable
  public final String component14()
  {
    return this.verticalPath;
  }
  
  @Nullable
  public final String component15()
  {
    return this.categoryId;
  }
  
  public final int component16()
  {
    return this.timeLineIndex;
  }
  
  public final int component17()
  {
    return this.effectSubType;
  }
  
  public final long component18()
  {
    return this.startOffset;
  }
  
  public final long component19()
  {
    return this.endOffset;
  }
  
  @Nullable
  public final String component2()
  {
    return this.filePath;
  }
  
  public final boolean component20()
  {
    return this.isRelative;
  }
  
  public final boolean component21()
  {
    return this.isLoadName;
  }
  
  @Nullable
  public final List<TextItem> component22()
  {
    return this.pagTextItems;
  }
  
  @Nullable
  public final String component3()
  {
    return this.stickerId;
  }
  
  public final float component4()
  {
    return this.startTime;
  }
  
  public final float component5()
  {
    return this.duration;
  }
  
  public final boolean component6()
  {
    return this.isUserEdit;
  }
  
  public final int component7()
  {
    return this.source;
  }
  
  @Nullable
  public final String component8()
  {
    return this.effectId;
  }
  
  @Nullable
  public final String component9()
  {
    return this.effectName;
  }
  
  @NotNull
  public final VideoEffectModel copy(int paramInt1, @Nullable String paramString1, @Nullable String paramString2, float paramFloat1, float paramFloat2, boolean paramBoolean1, int paramInt2, @Nullable String paramString3, @Nullable String paramString4, int paramInt3, long paramLong1, @Nullable String paramString5, int paramInt4, @Nullable String paramString6, @Nullable String paramString7, int paramInt5, int paramInt6, long paramLong2, long paramLong3, boolean paramBoolean2, boolean paramBoolean3, @Nullable List<TextItem> paramList)
  {
    return new VideoEffectModel(paramInt1, paramString1, paramString2, paramFloat1, paramFloat2, paramBoolean1, paramInt2, paramString3, paramString4, paramInt3, paramLong1, paramString5, paramInt4, paramString6, paramString7, paramInt5, paramInt6, paramLong2, paramLong3, paramBoolean2, paramBoolean3, paramList);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof VideoEffectModel))
      {
        paramObject = (VideoEffectModel)paramObject;
        if ((this.effectType != paramObject.effectType) || (!Intrinsics.areEqual(this.filePath, paramObject.filePath)) || (!Intrinsics.areEqual(this.stickerId, paramObject.stickerId)) || (Float.compare(this.startTime, paramObject.startTime) != 0) || (Float.compare(this.duration, paramObject.duration) != 0) || (this.isUserEdit != paramObject.isUserEdit) || (this.source != paramObject.source) || (!Intrinsics.areEqual(this.effectId, paramObject.effectId)) || (!Intrinsics.areEqual(this.effectName, paramObject.effectName)) || (this.effectBgColor != paramObject.effectBgColor) || (this.createTime != paramObject.createTime) || (!Intrinsics.areEqual(this.landscapePath, paramObject.landscapePath)) || (this.animationMode != paramObject.animationMode) || (!Intrinsics.areEqual(this.verticalPath, paramObject.verticalPath)) || (!Intrinsics.areEqual(this.categoryId, paramObject.categoryId)) || (this.timeLineIndex != paramObject.timeLineIndex) || (this.effectSubType != paramObject.effectSubType) || (this.startOffset != paramObject.startOffset) || (this.endOffset != paramObject.endOffset) || (this.isRelative != paramObject.isRelative) || (this.isLoadName != paramObject.isLoadName) || (!Intrinsics.areEqual(this.pagTextItems, paramObject.pagTextItems))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int getAnimationMode()
  {
    return this.animationMode;
  }
  
  @Nullable
  public final String getCategoryId()
  {
    return this.categoryId;
  }
  
  public final long getCreateTime()
  {
    return this.createTime;
  }
  
  public final float getDuration()
  {
    return this.duration;
  }
  
  public final int getEffectBgColor()
  {
    return this.effectBgColor;
  }
  
  @Nullable
  public final String getEffectId()
  {
    return this.effectId;
  }
  
  @Nullable
  public final String getEffectName()
  {
    return this.effectName;
  }
  
  public final int getEffectSubType()
  {
    return this.effectSubType;
  }
  
  public final int getEffectType()
  {
    return this.effectType;
  }
  
  public final long getEndOffset()
  {
    return this.endOffset;
  }
  
  public final float getEndTime()
  {
    return this.startTime + this.duration;
  }
  
  @Nullable
  public final String getFilePath()
  {
    return this.filePath;
  }
  
  @Nullable
  public final String getFilePath(boolean paramBoolean)
  {
    if ((TextUtils.isEmpty((CharSequence)this.verticalPath)) && (TextUtils.isEmpty((CharSequence)this.landscapePath)))
    {
      this.verticalPath = this.filePath;
      this.landscapePath = this.filePath;
      if (!TextUtils.isEmpty((CharSequence)this.verticalPath))
      {
        Object localObject = this.verticalPath;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        if (StringsKt.endsWith$default((String)localObject, ".pag", false, 2, null))
        {
          localObject = new StringBuilder();
          String str1 = this.verticalPath;
          if (str1 == null) {
            Intrinsics.throwNpe();
          }
          String str2 = this.verticalPath;
          if (str2 == null) {
            Intrinsics.throwNpe();
          }
          int i = str2.length();
          int j = ".pag".length();
          if (str1 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
          }
          str1 = str1.substring(0, i - j);
          Intrinsics.checkExpressionValueIsNotNull(str1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          this.landscapePath = (str1 + "_landscape" + ".pag");
          if (!FileUtils.exists(this.landscapePath)) {
            this.landscapePath = this.verticalPath;
          }
        }
      }
    }
    if (paramBoolean) {
      return this.verticalPath;
    }
    return this.landscapePath;
  }
  
  @Nullable
  public final String getLandscapePath()
  {
    return this.landscapePath;
  }
  
  @Nullable
  public final List<TextItem> getPagTextItems()
  {
    return this.pagTextItems;
  }
  
  public final int getSource()
  {
    return this.source;
  }
  
  public final long getStartOffset()
  {
    return this.startOffset;
  }
  
  public final float getStartTime()
  {
    return this.startTime;
  }
  
  @Nullable
  public final String getStickerId()
  {
    return this.stickerId;
  }
  
  public final int getTimeLineIndex()
  {
    return this.timeLineIndex;
  }
  
  @Nullable
  public final String getVerticalPath()
  {
    return this.verticalPath;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final boolean isLoadName()
  {
    return this.isLoadName;
  }
  
  public final boolean isRelative()
  {
    return this.isRelative;
  }
  
  public final boolean isUserEdit()
  {
    return this.isUserEdit;
  }
  
  public final void setAnimationMode(int paramInt)
  {
    this.animationMode = paramInt;
  }
  
  public final void setCategoryId(@Nullable String paramString)
  {
    this.categoryId = paramString;
  }
  
  public final void setCreateTime(long paramLong)
  {
    this.createTime = paramLong;
  }
  
  public final void setDuration(float paramFloat)
  {
    this.duration = paramFloat;
  }
  
  public final void setEffectBgColor(int paramInt)
  {
    this.effectBgColor = paramInt;
  }
  
  public final void setEffectId(@Nullable String paramString)
  {
    this.effectId = paramString;
  }
  
  public final void setEffectName(@Nullable String paramString)
  {
    this.effectName = paramString;
  }
  
  public final void setEffectSubType(int paramInt)
  {
    this.effectSubType = paramInt;
  }
  
  public final void setEffectType(int paramInt)
  {
    this.effectType = paramInt;
  }
  
  public final void setEndOffset(long paramLong)
  {
    this.endOffset = paramLong;
  }
  
  public final void setFilePath(@Nullable String paramString)
  {
    this.filePath = paramString;
  }
  
  public final void setLandscapePath(@Nullable String paramString)
  {
    this.landscapePath = paramString;
  }
  
  public final void setLoadName(boolean paramBoolean)
  {
    this.isLoadName = paramBoolean;
  }
  
  public final void setPagTextItems(@Nullable List<TextItem> paramList)
  {
    this.pagTextItems = paramList;
  }
  
  public final void setRelative(boolean paramBoolean)
  {
    this.isRelative = paramBoolean;
  }
  
  public final void setSource(int paramInt)
  {
    this.source = paramInt;
  }
  
  public final void setStartOffset(long paramLong)
  {
    this.startOffset = paramLong;
  }
  
  public final void setStartTime(float paramFloat)
  {
    this.startTime = paramFloat;
  }
  
  public final void setStickerId(@Nullable String paramString)
  {
    this.stickerId = paramString;
  }
  
  public final void setTimeLineIndex(int paramInt)
  {
    this.timeLineIndex = paramInt;
  }
  
  public final void setUserEdit(boolean paramBoolean)
  {
    this.isUserEdit = paramBoolean;
  }
  
  public final void setVerticalPath(@Nullable String paramString)
  {
    this.verticalPath = paramString;
  }
  
  @NotNull
  public String toString()
  {
    return "VideoEffectModel(effectType=" + this.effectType + ", filePath=" + this.filePath + ", stickerId=" + this.stickerId + ", startTime=" + this.startTime + ", duration=" + this.duration + ", isUserEdit=" + this.isUserEdit + ", source=" + this.source + ", effectId=" + this.effectId + ", effectName=" + this.effectName + ", effectBgColor=" + this.effectBgColor + ", createTime=" + this.createTime + ", landscapePath=" + this.landscapePath + ", animationMode=" + this.animationMode + ", verticalPath=" + this.verticalPath + ", categoryId=" + this.categoryId + ", timeLineIndex=" + this.timeLineIndex + ", effectSubType=" + this.effectSubType + ", startOffset=" + this.startOffset + ", endOffset=" + this.endOffset + ", isRelative=" + this.isRelative + ", isLoadName=" + this.isLoadName + ", pagTextItems=" + this.pagTextItems + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.effect.VideoEffectModel
 * JD-Core Version:    0.7.0.1
 */