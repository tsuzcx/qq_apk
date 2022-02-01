package com.tencent.qapmsdk.common.json;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/json/JsonTransform;", "", "toJSON", "", "common_release"}, k=1, mv={1, 1, 15})
public abstract interface JsonTransform
{
  @NotNull
  public abstract String toJSON();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.json.JsonTransform
 * JD-Core Version:    0.7.0.1
 */