package com.tencent.timi.game.gift.impl.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/gift/impl/event/GiftPanelControlEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "show", "", "triggerReason", "", "chosenUid", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "roomId", "", "subSceneId", "", "(ZILtrpc/yes/common/CommonOuterClass$QQUserId;Ljava/lang/Long;Ljava/lang/String;)V", "getChosenUid", "()Ltrpc/yes/common/CommonOuterClass$QQUserId;", "getRoomId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getShow", "()Z", "setShow", "(Z)V", "getSubSceneId", "()Ljava/lang/String;", "getTriggerReason", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "(ZILtrpc/yes/common/CommonOuterClass$QQUserId;Ljava/lang/Long;Ljava/lang/String;)Lcom/tencent/timi/game/gift/impl/event/GiftPanelControlEvent;", "equals", "other", "", "hashCode", "toString", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GiftPanelControlEvent
  extends SimpleBaseEvent
{
  @Nullable
  private final CommonOuterClass.QQUserId chosenUid;
  @Nullable
  private final Long roomId;
  private boolean show;
  @NotNull
  private final String subSceneId;
  private final int triggerReason;
  
  public GiftPanelControlEvent(boolean paramBoolean, int paramInt, @Nullable CommonOuterClass.QQUserId paramQQUserId, @Nullable Long paramLong, @NotNull String paramString)
  {
    this.show = paramBoolean;
    this.triggerReason = paramInt;
    this.chosenUid = paramQQUserId;
    this.roomId = paramLong;
    this.subSceneId = paramString;
  }
  
  public final boolean component1()
  {
    return this.show;
  }
  
  public final int component2()
  {
    return this.triggerReason;
  }
  
  @Nullable
  public final CommonOuterClass.QQUserId component3()
  {
    return this.chosenUid;
  }
  
  @Nullable
  public final Long component4()
  {
    return this.roomId;
  }
  
  @NotNull
  public final String component5()
  {
    return this.subSceneId;
  }
  
  @NotNull
  public final GiftPanelControlEvent copy(boolean paramBoolean, int paramInt, @Nullable CommonOuterClass.QQUserId paramQQUserId, @Nullable Long paramLong, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "subSceneId");
    return new GiftPanelControlEvent(paramBoolean, paramInt, paramQQUserId, paramLong, paramString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof GiftPanelControlEvent))
      {
        paramObject = (GiftPanelControlEvent)paramObject;
        if ((this.show == paramObject.show) && (this.triggerReason == paramObject.triggerReason) && (Intrinsics.areEqual(this.chosenUid, paramObject.chosenUid)) && (Intrinsics.areEqual(this.roomId, paramObject.roomId)) && (Intrinsics.areEqual(this.subSceneId, paramObject.subSceneId))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @Nullable
  public final CommonOuterClass.QQUserId getChosenUid()
  {
    return this.chosenUid;
  }
  
  @Nullable
  public final Long getRoomId()
  {
    return this.roomId;
  }
  
  public final boolean getShow()
  {
    return this.show;
  }
  
  @NotNull
  public final String getSubSceneId()
  {
    return this.subSceneId;
  }
  
  public final int getTriggerReason()
  {
    return this.triggerReason;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void setShow(boolean paramBoolean)
  {
    this.show = paramBoolean;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GiftPanelControlEvent(show=");
    localStringBuilder.append(this.show);
    localStringBuilder.append(", triggerReason=");
    localStringBuilder.append(this.triggerReason);
    localStringBuilder.append(", chosenUid=");
    localStringBuilder.append(this.chosenUid);
    localStringBuilder.append(", roomId=");
    localStringBuilder.append(this.roomId);
    localStringBuilder.append(", subSceneId=");
    localStringBuilder.append(this.subSceneId);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.event.GiftPanelControlEvent
 * JD-Core Version:    0.7.0.1
 */