package com.tencent.mobileqq.guild.config;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/config/QQGuildShareConfigProcessor$ConfigBeanDTO;", "Ljava/io/Serializable;", "time", "", "kaNavigateUrl", "", "kaShouldNavigate", "", "(JLjava/lang/String;Z)V", "getKaNavigateUrl", "()Ljava/lang/String;", "getKaShouldNavigate", "()Z", "getTime", "()J", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
final class QQGuildShareConfigProcessor$ConfigBeanDTO
  implements Serializable
{
  @SerializedName("kaNavigateUrl")
  @NotNull
  private final String kaNavigateUrl;
  @SerializedName("kaShouldNavigate")
  private final boolean kaShouldNavigate;
  @SerializedName("time")
  private final long time;
  
  public QQGuildShareConfigProcessor$ConfigBeanDTO()
  {
    this(0L, null, false, 7, null);
  }
  
  public QQGuildShareConfigProcessor$ConfigBeanDTO(long paramLong, @NotNull String paramString, boolean paramBoolean)
  {
    this.time = paramLong;
    this.kaNavigateUrl = paramString;
    this.kaShouldNavigate = paramBoolean;
  }
  
  public final long component1()
  {
    return this.time;
  }
  
  @NotNull
  public final String component2()
  {
    return this.kaNavigateUrl;
  }
  
  public final boolean component3()
  {
    return this.kaShouldNavigate;
  }
  
  @NotNull
  public final ConfigBeanDTO copy(long paramLong, @NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "kaNavigateUrl");
    return new ConfigBeanDTO(paramLong, paramString, paramBoolean);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ConfigBeanDTO))
      {
        paramObject = (ConfigBeanDTO)paramObject;
        if ((this.time == paramObject.time) && (Intrinsics.areEqual(this.kaNavigateUrl, paramObject.kaNavigateUrl)) && (this.kaShouldNavigate == paramObject.kaShouldNavigate)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String getKaNavigateUrl()
  {
    return this.kaNavigateUrl;
  }
  
  public final boolean getKaShouldNavigate()
  {
    return this.kaShouldNavigate;
  }
  
  public final long getTime()
  {
    return this.time;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ConfigBeanDTO(time=");
    localStringBuilder.append(this.time);
    localStringBuilder.append(", kaNavigateUrl=");
    localStringBuilder.append(this.kaNavigateUrl);
    localStringBuilder.append(", kaShouldNavigate=");
    localStringBuilder.append(this.kaShouldNavigate);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.config.QQGuildShareConfigProcessor.ConfigBeanDTO
 * JD-Core Version:    0.7.0.1
 */