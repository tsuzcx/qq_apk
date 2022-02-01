package com.tencent.mobileqq.troop.viewmodel;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/troop/viewmodel/PictureShowActionEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "callbackId", "", "type", "", "isLiked", "", "(Ljava/lang/String;IZ)V", "getCallbackId", "()Ljava/lang/String;", "()Z", "getType", "()I", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PictureShowActionEvent
  extends SimpleBaseEvent
{
  @NotNull
  private final String callbackId;
  private final boolean isLiked;
  private final int type;
  
  public PictureShowActionEvent(@NotNull String paramString, int paramInt, boolean paramBoolean)
  {
    this.callbackId = paramString;
    this.type = paramInt;
    this.isLiked = paramBoolean;
  }
  
  @NotNull
  public final String component1()
  {
    return this.callbackId;
  }
  
  public final int component2()
  {
    return this.type;
  }
  
  public final boolean component3()
  {
    return this.isLiked;
  }
  
  @NotNull
  public final PictureShowActionEvent copy(@NotNull String paramString, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "callbackId");
    return new PictureShowActionEvent(paramString, paramInt, paramBoolean);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof PictureShowActionEvent))
      {
        paramObject = (PictureShowActionEvent)paramObject;
        if ((Intrinsics.areEqual(this.callbackId, paramObject.callbackId)) && (this.type == paramObject.type) && (this.isLiked == paramObject.isLiked)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String getCallbackId()
  {
    return this.callbackId;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final boolean isLiked()
  {
    return this.isLiked;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PictureShowActionEvent(callbackId=");
    localStringBuilder.append(this.callbackId);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", isLiked=");
    localStringBuilder.append(this.isLiked);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.viewmodel.PictureShowActionEvent
 * JD-Core Version:    0.7.0.1
 */