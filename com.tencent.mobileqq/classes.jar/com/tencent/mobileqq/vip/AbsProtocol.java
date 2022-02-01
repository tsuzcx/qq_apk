package com.tencent.mobileqq.vip;

import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.BusinessObserver;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vip/AbsProtocol;", "", "()V", "interceptJce", "Lcom/qq/taf/jce/JceStruct;", "servantName", "", "cmd", "funcName", "req", "onJceCallBack", "", "resp", "observer", "Lcom/tencent/mobileqq/app/BusinessObserver;", "Companion", "JceIntercept", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class AbsProtocol
{
  public static final AbsProtocol.Companion a;
  private static final ArrayList<AbsProtocol.JceIntercept> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVipAbsProtocol$Companion = new AbsProtocol.Companion(null);
  }
  
  @Nullable
  public final JceStruct a(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull JceStruct paramJceStruct)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "servantName");
    Intrinsics.checkParameterIsNotNull(paramString2, "cmd");
    Intrinsics.checkParameterIsNotNull(paramString3, "funcName");
    Intrinsics.checkParameterIsNotNull(paramJceStruct, "req");
    if (!jdField_a_of_type_Boolean) {
      return null;
    }
    Iterator localIterator = ((Iterable)jdField_a_of_type_JavaUtilArrayList).iterator();
    label46:
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      AbsProtocol.JceIntercept localJceIntercept = (AbsProtocol.JceIntercept)localObject;
      if ((Intrinsics.areEqual(localJceIntercept.a(), paramString1)) && (Intrinsics.areEqual(localJceIntercept.b(), paramString2)) && (Intrinsics.areEqual(localJceIntercept.c(), paramString3)))
      {
        i = 1;
        label111:
        if (i == 0) {
          break label147;
        }
      }
    }
    for (paramString1 = localObject;; paramString1 = null)
    {
      paramString1 = (AbsProtocol.JceIntercept)paramString1;
      if (paramString1 == null) {
        break;
      }
      return (JceStruct)paramString1.a().invoke(paramJceStruct);
      i = 0;
      break label111;
      label147:
      break label46;
    }
  }
  
  public final void a(@NotNull JceStruct paramJceStruct, @NotNull BusinessObserver paramBusinessObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramJceStruct, "resp");
    Intrinsics.checkParameterIsNotNull(paramBusinessObserver, "observer");
    paramBusinessObserver.onUpdate(0, true, paramJceStruct);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.AbsProtocol
 * JD-Core Version:    0.7.0.1
 */