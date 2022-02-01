package com.tencent.mobileqq.triton.utils;

import androidx.annotation.AnyThread;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/utils/Downloader;", "", "download", "", "url", "", "toPath", "Ljava/io/File;", "listener", "Lcom/tencent/mobileqq/triton/utils/Downloader$Listener;", "Listener", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface Downloader
{
  @AnyThread
  public abstract void download(@NotNull String paramString, @NotNull File paramFile, @NotNull Downloader.Listener paramListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.utils.Downloader
 * JD-Core Version:    0.7.0.1
 */