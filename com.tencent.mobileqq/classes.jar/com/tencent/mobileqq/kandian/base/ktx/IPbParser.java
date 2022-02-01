package com.tencent.mobileqq.kandian.base.ktx;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/ktx/IPbParser;", "P", "R", "", "parse", "input", "(Ljava/lang/Object;)Ljava/lang/Object;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IPbParser<P, R>
{
  @Nullable
  public abstract R a(P paramP);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.ktx.IPbParser
 * JD-Core Version:    0.7.0.1
 */