package com.tencent.xaction.express;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/express/IFunc;", "", "compute", "fieldType", "Ljava/lang/Class;", "param", "", "index", "", "XActionCore_release"}, k=1, mv={1, 1, 16})
public abstract interface IFunc
{
  @Nullable
  public abstract Object a(@NotNull Class<?> paramClass, @NotNull String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.express.IFunc
 * JD-Core Version:    0.7.0.1
 */