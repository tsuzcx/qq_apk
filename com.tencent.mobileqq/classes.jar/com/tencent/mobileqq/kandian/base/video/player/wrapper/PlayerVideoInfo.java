package com.tencent.mobileqq.kandian.base.video.player.wrapper;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/PlayerVideoInfo;", "", "playType", "", "vid", "", "(ILjava/lang/String;)V", "urls", "", "(ILjava/lang/String;[Ljava/lang/String;)V", "pid", "isPreload", "", "duration", "", "playMode", "keepLastframe", "coverFrame", "hwCodec", "hwBackupUrls", "preloadDuration", "(ILjava/lang/String;[Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/String;ZZZLjava/lang/String;I)V", "getCoverFrame", "()Z", "setCoverFrame", "(Z)V", "getDuration", "()J", "setDuration", "(J)V", "getHwBackupUrls", "()Ljava/lang/String;", "setHwBackupUrls", "(Ljava/lang/String;)V", "getHwCodec", "setHwCodec", "setPreload", "getKeepLastframe", "setKeepLastframe", "getPid", "getPlayMode", "setPlayMode", "getPlayType", "()I", "getPreloadDuration", "setPreloadDuration", "(I)V", "getUrls", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getVid", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;[Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/String;ZZZLjava/lang/String;I)Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/PlayerVideoInfo;", "equals", "other", "hashCode", "toString", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class PlayerVideoInfo
{
  private final int a;
  @Nullable
  private final String b;
  @Nullable
  private final String[] c;
  @Nullable
  private final String d;
  private boolean e;
  private long f;
  @Nullable
  private String g;
  private boolean h;
  private boolean i;
  private boolean j;
  @Nullable
  private String k;
  private int l;
  
  public PlayerVideoInfo(int paramInt, @Nullable String paramString)
  {
    this(paramInt, paramString, null);
  }
  
  public PlayerVideoInfo(int paramInt, @Nullable String paramString, @Nullable String[] paramArrayOfString)
  {
    this(paramInt, paramString, paramArrayOfString, null, false, 0L, null, false, false, false, null, 0, 4080, null);
  }
  
  public PlayerVideoInfo(int paramInt1, @Nullable String paramString1, @Nullable String[] paramArrayOfString, @Nullable String paramString2, boolean paramBoolean1, long paramLong, @Nullable String paramString3, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, @Nullable String paramString4, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramArrayOfString;
    this.d = paramString2;
    this.e = paramBoolean1;
    this.f = paramLong;
    this.g = paramString3;
    this.h = paramBoolean2;
    this.i = paramBoolean3;
    this.j = paramBoolean4;
    this.k = paramString4;
    this.l = paramInt2;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final void a(int paramInt)
  {
    this.l = paramInt;
  }
  
  public final void a(long paramLong)
  {
    this.f = paramLong;
  }
  
  public final void a(@Nullable String paramString)
  {
    this.g = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  @Nullable
  public final String b()
  {
    return this.b;
  }
  
  public final void b(@Nullable String paramString)
  {
    this.k = paramString;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public final void c(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  @Nullable
  public final String[] c()
  {
    return this.c;
  }
  
  @Nullable
  public final String d()
  {
    return this.d;
  }
  
  public final void d(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public final long e()
  {
    return this.f;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof PlayerVideoInfo))
      {
        paramObject = (PlayerVideoInfo)paramObject;
        if ((this.a == paramObject.a) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d)) && (this.e == paramObject.e) && (this.f == paramObject.f) && (Intrinsics.areEqual(this.g, paramObject.g)) && (this.h == paramObject.h) && (this.i == paramObject.i) && (this.j == paramObject.j) && (Intrinsics.areEqual(this.k, paramObject.k)) && (this.l == paramObject.l)) {}
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
    localStringBuilder.append("PlayerVideoInfo(playType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", vid=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", urls=");
    localStringBuilder.append(Arrays.toString(this.c));
    localStringBuilder.append(", pid=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", isPreload=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", playMode=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", keepLastframe=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", coverFrame=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", hwCodec=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", hwBackupUrls=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", preloadDuration=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerVideoInfo
 * JD-Core Version:    0.7.0.1
 */