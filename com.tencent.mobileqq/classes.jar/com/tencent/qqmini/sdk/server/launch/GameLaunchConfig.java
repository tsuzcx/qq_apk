package com.tencent.qqmini.sdk.server.launch;

import android.support.annotation.VisibleForTesting;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/sdk/server/launch/GameLaunchConfig;", "", "enableProcessReuse", "", "multiInstanceCount", "", "(ZI)V", "enableMultiInstance", "getEnableMultiInstance", "()Z", "getEnableProcessReuse", "getMultiInstanceCount", "()I", "setMultiInstanceCount", "(I)V", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "lib_miniserver_internalRelease"}, k=1, mv={1, 1, 16})
public final class GameLaunchConfig
{
  public static final GameLaunchConfig.Companion Companion = new GameLaunchConfig.Companion(null);
  private final boolean enableProcessReuse;
  private int multiInstanceCount;
  
  @VisibleForTesting
  public GameLaunchConfig(boolean paramBoolean, int paramInt)
  {
    this.enableProcessReuse = paramBoolean;
    this.multiInstanceCount = paramInt;
  }
  
  @JvmStatic
  @NotNull
  public static final GameLaunchConfig fromWnsConfig()
  {
    return Companion.fromWnsConfig();
  }
  
  public final boolean component1()
  {
    return this.enableProcessReuse;
  }
  
  public final int component2()
  {
    return this.multiInstanceCount;
  }
  
  @NotNull
  public final GameLaunchConfig copy(boolean paramBoolean, int paramInt)
  {
    return new GameLaunchConfig(paramBoolean, paramInt);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof GameLaunchConfig))
      {
        paramObject = (GameLaunchConfig)paramObject;
        if ((this.enableProcessReuse == paramObject.enableProcessReuse) && (this.multiInstanceCount == paramObject.multiInstanceCount)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final boolean getEnableMultiInstance()
  {
    return this.multiInstanceCount > 1;
  }
  
  public final boolean getEnableProcessReuse()
  {
    return this.enableProcessReuse;
  }
  
  public final int getMultiInstanceCount()
  {
    return this.multiInstanceCount;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void setMultiInstanceCount(int paramInt)
  {
    this.multiInstanceCount = paramInt;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GameLaunchConfig(enableProcessReuse=");
    localStringBuilder.append(this.enableProcessReuse);
    localStringBuilder.append(", multiInstanceCount=");
    localStringBuilder.append(this.multiInstanceCount);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.GameLaunchConfig
 * JD-Core Version:    0.7.0.1
 */