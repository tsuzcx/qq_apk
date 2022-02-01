package com.tencent.rmonitor.base.reporter.ab;

import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/reporter/ab/IAbCallback;", "", "addType", "", "qpmPlugin", "", "relationPerfTypes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public abstract interface IAbCallback
{
  public abstract void a(int paramInt, @NotNull ArrayList<Integer> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.ab.IAbCallback
 * JD-Core Version:    0.7.0.1
 */