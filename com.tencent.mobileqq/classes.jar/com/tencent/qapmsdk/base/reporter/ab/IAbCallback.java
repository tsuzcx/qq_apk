package com.tencent.qapmsdk.base.reporter.ab;

import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/ab/IAbCallback;", "", "addType", "", "qpmPlugin", "", "relationPerfTypes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "qapmbase_release"}, k=1, mv={1, 1, 15})
public abstract interface IAbCallback
{
  public abstract void addType(int paramInt, @NotNull ArrayList<Integer> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.ab.IAbCallback
 * JD-Core Version:    0.7.0.1
 */