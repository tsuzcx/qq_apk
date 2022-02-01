package com.tencent.mobileqq.kandian.base.view.api.impl;

import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class KanDianOptUtils$reportTabInfo$1
  implements Runnable
{
  KanDianOptUtils$reportTabInfo$1(QQTabHost paramQQTabHost) {}
  
  public final void run()
  {
    try
    {
      Object localObject = this.a.getClass().getSuperclass();
      if (localObject != null)
      {
        localObject = ((Class)localObject).getDeclaredField("mTabSpecs");
        Intrinsics.checkExpressionValueIsNotNull(localObject, "mTabSpecsField");
        ((Field)localObject).setAccessible(true);
        localObject = ((Field)localObject).get(this.a);
        if (localObject != null)
        {
          localObject = (List)localObject;
          KanDianOptUtils.access$reportTabInfoImp(KanDianOptUtils.INSTANCE, (List)localObject);
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<android.widget.TabHost.TabSpec>");
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[reportTabInfo] e = ");
      localStringBuilder.append(localException);
      QLog.e("KanDianOptUtils", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.api.impl.KanDianOptUtils.reportTabInfo.1
 * JD-Core Version:    0.7.0.1
 */