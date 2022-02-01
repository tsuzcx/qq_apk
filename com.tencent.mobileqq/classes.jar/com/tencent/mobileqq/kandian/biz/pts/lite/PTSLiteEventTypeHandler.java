package com.tencent.mobileqq.kandian.biz.pts.lite;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.pts.network.PTSGeneralRequestModule;
import com.tencent.mobileqq.kandian.biz.pts.network.PTSGeneralRequestModule.Companion;
import com.tencent.pts.core.PTSComposer;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/lite/PTSLiteEventTypeHandler;", "", "()V", "TAG", "", "doRequest0xebf", "", "ptsComposer", "Lcom/tencent/pts/core/PTSComposer;", "dataSet", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "handleEventType", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PTSLiteEventTypeHandler
{
  public static final PTSLiteEventTypeHandler a = new PTSLiteEventTypeHandler();
  
  private final void b(PTSComposer paramPTSComposer, HashMap<String, String> paramHashMap)
  {
    Object localObject = (String)paramHashMap.get("businessType");
    if (localObject == null) {
      localObject = "0";
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject, "dataSet[PTSConstantUtil.…SET_BUSINESS_TYPE] ?: \"0\"");
    String str = (String)paramHashMap.get("requestParams");
    paramHashMap = (String)paramHashMap.get("extendInfo");
    int i = 0;
    try
    {
      localObject = Integer.valueOf((String)localObject);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "Integer.valueOf(businessType)");
      int j = ((Integer)localObject).intValue();
      i = j;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[doRequest0xebf] e = ");
      localStringBuilder.append(localNumberFormatException);
      QLog.e("PTSLiteTapEventDispatcher", 1, localStringBuilder.toString());
    }
    PTSGeneralRequestModule.a.a(paramPTSComposer, i, str, paramHashMap);
  }
  
  public final void a(@Nullable PTSComposer paramPTSComposer, @Nullable HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null)
    {
      localObject1 = (String)paramHashMap.get("eventType");
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "dataSet?.get(PTSConstant…ATA_SET_EVENT_TYPE) ?: \"\"");
    Object localObject2 = (CharSequence)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      QLog.i("PTSLiteEventTypeHandler", 1, "[handleEventType], eventTypeString is empty.");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[handleEventType] eventTypeString = ");
    localStringBuilder.append((String)localObject1);
    QLog.i("PTSLiteEventTypeHandler", 1, localStringBuilder.toString());
    Object localObject1 = new Regex("\\|");
    int i = 0;
    localObject1 = ((Collection)((Regex)localObject1).split((CharSequence)localObject2, 0)).toArray(new String[0]);
    if (localObject1 != null)
    {
      localObject2 = (String[])localObject1;
      int j = localObject2.length;
      while (i < j)
      {
        localObject1 = localObject2[i];
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[handleEventType], eventType = ");
        localStringBuilder.append((String)localObject1);
        QLog.i("PTSLiteEventTypeHandler", 1, localStringBuilder.toString());
        if (TextUtils.equals((CharSequence)localObject1, (CharSequence)"0xebfRequest"))
        {
          if (paramHashMap != null) {
            localObject1 = paramHashMap;
          } else {
            localObject1 = new HashMap();
          }
          b(paramPTSComposer, (HashMap)localObject1);
        }
        i += 1;
      }
      return;
    }
    paramPTSComposer = new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    for (;;)
    {
      throw paramPTSComposer;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteEventTypeHandler
 * JD-Core Version:    0.7.0.1
 */