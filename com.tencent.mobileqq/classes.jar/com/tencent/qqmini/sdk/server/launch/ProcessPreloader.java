package com.tencent.qqmini.sdk.server.launch;

import com.tencent.qqmini.sdk.launcher.MiniProcessorConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/sdk/server/launch/ProcessPreloader;", "", "performPreloadProcess", "", "process", "Lcom/tencent/qqmini/sdk/launcher/MiniProcessorConfig;", "lib_miniserver_internalRelease"}, k=1, mv={1, 1, 16})
public abstract interface ProcessPreloader
{
  public abstract void performPreloadProcess(@NotNull MiniProcessorConfig paramMiniProcessorConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.ProcessPreloader
 * JD-Core Version:    0.7.0.1
 */