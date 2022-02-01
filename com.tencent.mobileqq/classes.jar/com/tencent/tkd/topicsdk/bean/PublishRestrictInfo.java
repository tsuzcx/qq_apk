package com.tencent.tkd.topicsdk.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/PublishRestrictInfo;", "", "isPictureOriginalAuthor", "", "isVideoOriginalAuthor", "hasCharacterLimit", "characterUpperLimit", "", "characterLowerLimit", "allowShowTweetTopic", "allowShowInvitedManuscript", "allowShowSubmitManuscript", "allowPublishEmoji", "isForbidden", "dialogInfo", "Lcom/tencent/tkd/topicsdk/bean/DialogInfo;", "(ZZZIIZZZZZLcom/tencent/tkd/topicsdk/bean/DialogInfo;)V", "getAllowPublishEmoji", "()Z", "getAllowShowInvitedManuscript", "getAllowShowSubmitManuscript", "getAllowShowTweetTopic", "getCharacterLowerLimit", "()I", "getCharacterUpperLimit", "getDialogInfo", "()Lcom/tencent/tkd/topicsdk/bean/DialogInfo;", "getHasCharacterLimit", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishRestrictInfo
{
  private final boolean a;
  private final boolean b;
  private final boolean c;
  private final int d;
  private final int e;
  private final boolean f;
  private final boolean g;
  private final boolean h;
  private final boolean i;
  private final boolean j;
  @Nullable
  private final DialogInfo k;
  
  public final boolean a()
  {
    return this.b;
  }
  
  public final boolean b()
  {
    return this.c;
  }
  
  public final int c()
  {
    return this.d;
  }
  
  public final int d()
  {
    return this.e;
  }
  
  public final boolean e()
  {
    return this.f;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof PublishRestrictInfo))
      {
        paramObject = (PublishRestrictInfo)paramObject;
        if ((this.a == paramObject.a) && (this.b == paramObject.b) && (this.c == paramObject.c) && (this.d == paramObject.d) && (this.e == paramObject.e) && (this.f == paramObject.f) && (this.g == paramObject.g) && (this.h == paramObject.h) && (this.i == paramObject.i) && (this.j == paramObject.j) && (Intrinsics.areEqual(this.k, paramObject.k))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final boolean f()
  {
    return this.g;
  }
  
  public final boolean g()
  {
    return this.i;
  }
  
  public final boolean h()
  {
    return this.j;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @Nullable
  public final DialogInfo i()
  {
    return this.k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PublishRestrictInfo(isPictureOriginalAuthor=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", isVideoOriginalAuthor=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", hasCharacterLimit=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", characterUpperLimit=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", characterLowerLimit=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", allowShowTweetTopic=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", allowShowInvitedManuscript=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", allowShowSubmitManuscript=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", allowPublishEmoji=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", isForbidden=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", dialogInfo=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.PublishRestrictInfo
 * JD-Core Version:    0.7.0.1
 */