package com.tencent.mobileqq.wink.editor.draft;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "Ljava/io/Serializable;", "missionId", "", "editMode", "", "editDatas", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "Lkotlin/collections/ArrayList;", "originMediaInfos", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "templateFilePath", "from", "outMediaInfo", "duration", "", "isFromCapture", "", "selectMusicMid", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/Integer;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;JZLjava/lang/String;)V", "getDuration", "()J", "setDuration", "(J)V", "getEditDatas", "()Ljava/util/ArrayList;", "getEditMode", "()Ljava/lang/Integer;", "setEditMode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFrom", "setFrom", "()Z", "setFromCapture", "(Z)V", "getMissionId", "()Ljava/lang/String;", "getOriginMediaInfos", "getOutMediaInfo", "()Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "setOutMediaInfo", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V", "getSelectMusicMid", "setSelectMusicMid", "(Ljava/lang/String;)V", "getTemplateFilePath", "setTemplateFilePath", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/Integer;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;JZLjava/lang/String;)Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "equals", "other", "", "hashCode", "toString", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class WinkEditDataWrapper
  implements Serializable
{
  public static final WinkEditDataWrapper.Companion Companion = new WinkEditDataWrapper.Companion(null);
  private static final long serialVersionUID = 599093938747237759L;
  private long duration;
  @NotNull
  private final ArrayList<WinkEditData> editDatas;
  @Nullable
  private Integer editMode;
  @Nullable
  private Integer from;
  private boolean isFromCapture;
  @Nullable
  private final String missionId;
  @Nullable
  private final ArrayList<LocalMediaInfo> originMediaInfos;
  @Nullable
  private LocalMediaInfo outMediaInfo;
  @Nullable
  private String selectMusicMid;
  @Nullable
  private String templateFilePath;
  
  public WinkEditDataWrapper(@Nullable String paramString1, @Nullable Integer paramInteger1, @NotNull ArrayList<WinkEditData> paramArrayList, @Nullable ArrayList<LocalMediaInfo> paramArrayList1, @Nullable String paramString2, @Nullable Integer paramInteger2, @Nullable LocalMediaInfo paramLocalMediaInfo, long paramLong, boolean paramBoolean, @Nullable String paramString3)
  {
    this.missionId = paramString1;
    this.editMode = paramInteger1;
    this.editDatas = paramArrayList;
    this.originMediaInfos = paramArrayList1;
    this.templateFilePath = paramString2;
    this.from = paramInteger2;
    this.outMediaInfo = paramLocalMediaInfo;
    this.duration = paramLong;
    this.isFromCapture = paramBoolean;
    this.selectMusicMid = paramString3;
  }
  
  @Nullable
  public final String component1()
  {
    return this.missionId;
  }
  
  @Nullable
  public final String component10()
  {
    return this.selectMusicMid;
  }
  
  @Nullable
  public final Integer component2()
  {
    return this.editMode;
  }
  
  @NotNull
  public final ArrayList<WinkEditData> component3()
  {
    return this.editDatas;
  }
  
  @Nullable
  public final ArrayList<LocalMediaInfo> component4()
  {
    return this.originMediaInfos;
  }
  
  @Nullable
  public final String component5()
  {
    return this.templateFilePath;
  }
  
  @Nullable
  public final Integer component6()
  {
    return this.from;
  }
  
  @Nullable
  public final LocalMediaInfo component7()
  {
    return this.outMediaInfo;
  }
  
  public final long component8()
  {
    return this.duration;
  }
  
  public final boolean component9()
  {
    return this.isFromCapture;
  }
  
  @NotNull
  public final WinkEditDataWrapper copy(@Nullable String paramString1, @Nullable Integer paramInteger1, @NotNull ArrayList<WinkEditData> paramArrayList, @Nullable ArrayList<LocalMediaInfo> paramArrayList1, @Nullable String paramString2, @Nullable Integer paramInteger2, @Nullable LocalMediaInfo paramLocalMediaInfo, long paramLong, boolean paramBoolean, @Nullable String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "editDatas");
    return new WinkEditDataWrapper(paramString1, paramInteger1, paramArrayList, paramArrayList1, paramString2, paramInteger2, paramLocalMediaInfo, paramLong, paramBoolean, paramString3);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof WinkEditDataWrapper))
      {
        paramObject = (WinkEditDataWrapper)paramObject;
        if ((Intrinsics.areEqual(this.missionId, paramObject.missionId)) && (Intrinsics.areEqual(this.editMode, paramObject.editMode)) && (Intrinsics.areEqual(this.editDatas, paramObject.editDatas)) && (Intrinsics.areEqual(this.originMediaInfos, paramObject.originMediaInfos)) && (Intrinsics.areEqual(this.templateFilePath, paramObject.templateFilePath)) && (Intrinsics.areEqual(this.from, paramObject.from)) && (Intrinsics.areEqual(this.outMediaInfo, paramObject.outMediaInfo)) && (this.duration == paramObject.duration) && (this.isFromCapture == paramObject.isFromCapture) && (Intrinsics.areEqual(this.selectMusicMid, paramObject.selectMusicMid))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final long getDuration()
  {
    return this.duration;
  }
  
  @NotNull
  public final ArrayList<WinkEditData> getEditDatas()
  {
    return this.editDatas;
  }
  
  @Nullable
  public final Integer getEditMode()
  {
    return this.editMode;
  }
  
  @Nullable
  public final Integer getFrom()
  {
    return this.from;
  }
  
  @Nullable
  public final String getMissionId()
  {
    return this.missionId;
  }
  
  @Nullable
  public final ArrayList<LocalMediaInfo> getOriginMediaInfos()
  {
    return this.originMediaInfos;
  }
  
  @Nullable
  public final LocalMediaInfo getOutMediaInfo()
  {
    return this.outMediaInfo;
  }
  
  @Nullable
  public final String getSelectMusicMid()
  {
    return this.selectMusicMid;
  }
  
  @Nullable
  public final String getTemplateFilePath()
  {
    return this.templateFilePath;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final boolean isFromCapture()
  {
    return this.isFromCapture;
  }
  
  public final void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public final void setEditMode(@Nullable Integer paramInteger)
  {
    this.editMode = paramInteger;
  }
  
  public final void setFrom(@Nullable Integer paramInteger)
  {
    this.from = paramInteger;
  }
  
  public final void setFromCapture(boolean paramBoolean)
  {
    this.isFromCapture = paramBoolean;
  }
  
  public final void setOutMediaInfo(@Nullable LocalMediaInfo paramLocalMediaInfo)
  {
    this.outMediaInfo = paramLocalMediaInfo;
  }
  
  public final void setSelectMusicMid(@Nullable String paramString)
  {
    this.selectMusicMid = paramString;
  }
  
  public final void setTemplateFilePath(@Nullable String paramString)
  {
    this.templateFilePath = paramString;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WinkEditDataWrapper(missionId=");
    localStringBuilder.append(this.missionId);
    localStringBuilder.append(", editMode=");
    localStringBuilder.append(this.editMode);
    localStringBuilder.append(", editDatas=");
    localStringBuilder.append(this.editDatas);
    localStringBuilder.append(", originMediaInfos=");
    localStringBuilder.append(this.originMediaInfos);
    localStringBuilder.append(", templateFilePath=");
    localStringBuilder.append(this.templateFilePath);
    localStringBuilder.append(", from=");
    localStringBuilder.append(this.from);
    localStringBuilder.append(", outMediaInfo=");
    localStringBuilder.append(this.outMediaInfo);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.duration);
    localStringBuilder.append(", isFromCapture=");
    localStringBuilder.append(this.isFromCapture);
    localStringBuilder.append(", selectMusicMid=");
    localStringBuilder.append(this.selectMusicMid);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper
 * JD-Core Version:    0.7.0.1
 */