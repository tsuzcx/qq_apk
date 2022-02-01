package com.tencent.mobileqq.vas.api;

import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.BusinessObserver;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/api/AbsProtocol;", "", "()V", "interceptJce", "Lcom/qq/taf/jce/JceStruct;", "servantName", "", "cmd", "funcName", "req", "onJceCallBack", "", "resp", "observer", "Lcom/tencent/mobileqq/app/BusinessObserver;", "Companion", "JceIntercept", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public abstract class AbsProtocol
{
  public static final AbsProtocol.Companion Companion = new AbsProtocol.Companion(null);
  private static boolean a;
  private static final ArrayList<AbsProtocol.JceIntercept> b = new ArrayList();
  
  @Nullable
  public final JceStruct interceptJce(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull JceStruct paramJceStruct)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "servantName");
    Intrinsics.checkParameterIsNotNull(paramString2, "cmd");
    Intrinsics.checkParameterIsNotNull(paramString3, "funcName");
    Intrinsics.checkParameterIsNotNull(paramJceStruct, "req");
    if (!a) {
      return null;
    }
    Iterator localIterator = ((Iterable)b).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      AbsProtocol.JceIntercept localJceIntercept = (AbsProtocol.JceIntercept)localObject;
      int i;
      if ((Intrinsics.areEqual(localJceIntercept.a(), paramString1)) && (Intrinsics.areEqual(localJceIntercept.b(), paramString2)) && (Intrinsics.areEqual(localJceIntercept.c(), paramString3))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        paramString1 = localObject;
        break label130;
      }
    }
    paramString1 = null;
    label130:
    paramString1 = (AbsProtocol.JceIntercept)paramString1;
    if (paramString1 != null) {
      return (JceStruct)paramString1.d().invoke(paramJceStruct);
    }
    return null;
  }
  
  public final void onJceCallBack(@NotNull JceStruct paramJceStruct, @NotNull BusinessObserver paramBusinessObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramJceStruct, "resp");
    Intrinsics.checkParameterIsNotNull(paramBusinessObserver, "observer");
    paramBusinessObserver.onUpdate(0, true, paramJceStruct);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.AbsProtocol
 * JD-Core Version:    0.7.0.1
 */