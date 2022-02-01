package com.tencent.rmonitor.base.meta;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/meta/DumpResult;", "", "()V", "hprofFileSize", "", "success", "", "zipFilePath", "", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class DumpResult
{
  @JvmField
  public long hprofFileSize;
  @JvmField
  public boolean success;
  @JvmField
  @NotNull
  public String zipFilePath = "";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.meta.DumpResult
 * JD-Core Version:    0.7.0.1
 */