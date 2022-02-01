package com.yolo.esports.room.api;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass.RotateMessageLabel;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/yolo/esports/room/api/OperationData;", "", "type", "", "msgTpl", "", "metaData", "", "Ltrpc/yes/common/YoloRoomOuterClass$RotateMessageLabel;", "msgTime", "dismiss", "", "(ILjava/lang/String;Ljava/util/List;IZ)V", "getDismiss", "()Z", "setDismiss", "(Z)V", "getMetaData", "()Ljava/util/List;", "getMsgTime", "()I", "getMsgTpl", "()Ljava/lang/String;", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class OperationData
{
  private final int a;
  @NotNull
  private final String b;
  @NotNull
  private final List<YoloRoomOuterClass.RotateMessageLabel> c;
  private final int d;
  private boolean e;
  
  public OperationData(int paramInt1, @NotNull String paramString, @NotNull List<YoloRoomOuterClass.RotateMessageLabel> paramList, int paramInt2, boolean paramBoolean)
  {
    this.a = paramInt1;
    this.b = paramString;
    this.c = paramList;
    this.d = paramInt2;
    this.e = paramBoolean;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof OperationData))
      {
        paramObject = (OperationData)paramObject;
        if ((this.a == paramObject.a) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (this.d == paramObject.d) && (this.e == paramObject.e)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OperationData(type=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", msgTpl=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", metaData=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", msgTime=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", dismiss=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.yolo.esports.room.api.OperationData
 * JD-Core Version:    0.7.0.1
 */