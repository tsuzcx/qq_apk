package com.tencent.mobileqq.kandian.repo.webarticle;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJWebResourceUtil$preloadResource$runnable$1
  implements Runnable
{
  public static final 1 a = new 1();
  
  public final void run()
  {
    String str1 = RIJWebResourceUtil.a(RIJWebResourceUtil.a);
    Iterator localIterator = RIJWebResourceUtil.b(RIJWebResourceUtil.a).iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      Intrinsics.checkExpressionValueIsNotNull(str2, "url");
      int i = StringsKt.lastIndexOf$default((CharSequence)str2, '/', 0, false, 6, null);
      int j = str2.length();
      if (str2 != null)
      {
        str2 = str2.substring(i + 1, j);
        Intrinsics.checkExpressionValueIsNotNull(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str1);
        ((StringBuilder)localObject).append('/');
        ((StringBuilder)localObject).append(str2);
        localObject = ((StringBuilder)localObject).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[preloadResource] fileName = ");
        localStringBuilder.append(str2);
        localStringBuilder.append(", filePath = ");
        localStringBuilder.append((String)localObject);
        QLog.i("RIJWebResourceUtil", 1, localStringBuilder.toString());
        RIJWebResourceUtil.a(RIJWebResourceUtil.a, (String)localObject);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.RIJWebResourceUtil.preloadResource.runnable.1
 * JD-Core Version:    0.7.0.1
 */