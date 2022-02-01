package com.tencent.mobileqq.config.business.qflutter;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfigProcessor$OptionList;", "", "options", "", "", "(Ljava/util/List;)V", "getOptions", "()Ljava/util/List;", "match", "", "option", "Lcom/tencent/mobileqq/config/business/qflutter/PreloadEngineOption;", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QFlutterResConfigProcessor$OptionList
{
  @NotNull
  private final List<String> a;
  
  public QFlutterResConfigProcessor$OptionList(@NotNull List<String> paramList)
  {
    this.a = paramList;
  }
  
  public final boolean a(@NotNull PreloadEngineOption paramPreloadEngineOption)
  {
    Intrinsics.checkParameterIsNotNull(paramPreloadEngineOption, "option");
    return this.a.contains(paramPreloadEngineOption.getDesc());
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OptionList(options=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qflutter.QFlutterResConfigProcessor.OptionList
 * JD-Core Version:    0.7.0.1
 */