import android.text.TextUtils;
import com.tencent.pts.core.PTSComposer;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/pts/lite/PTSLiteEventTypeHandler;", "", "()V", "TAG", "", "doRequest0xebf", "", "ptsComposer", "Lcom/tencent/pts/core/PTSComposer;", "dataSet", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "handleEventType", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qmg
{
  public static final qmg a = new qmg();
  
  private final void b(PTSComposer paramPTSComposer, HashMap<String, String> paramHashMap)
  {
    Object localObject = (String)paramHashMap.get("businessType");
    if (localObject != null) {}
    for (;;)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject, "dataSet[PTSConstantUtil.…SET_BUSINESS_TYPE] ?: \"0\"");
      String str = (String)paramHashMap.get("requestParams");
      paramHashMap = (String)paramHashMap.get("extendInfo");
      try
      {
        localObject = Integer.valueOf((String)localObject);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "Integer.valueOf(businessType)");
        i = ((Integer)localObject).intValue();
        qnn.a.a(paramPTSComposer, i, str, paramHashMap);
        return;
        localObject = "0";
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("PTSLiteTapEventDispatcher", 1, "[doRequest0xebf] e = " + localNumberFormatException);
          int i = 0;
        }
      }
    }
  }
  
  public final void a(@Nullable PTSComposer paramPTSComposer, @Nullable HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null)
    {
      localObject = (String)paramHashMap.get("eventType");
      if (localObject == null) {}
    }
    for (;;)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject, "dataSet?.get(PTSConstant…ATA_SET_EVENT_TYPE) ?: \"\"");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      QLog.i("PTSLiteEventTypeHandler", 1, "[handleEventType], eventTypeString is empty.");
      return;
      localObject = "";
    }
    QLog.i("PTSLiteEventTypeHandler", 1, "[handleEventType] eventTypeString = " + (String)localObject);
    Object localObject = (CharSequence)localObject;
    localObject = ((Collection)new Regex("\\|").split((CharSequence)localObject, 0)).toArray(new String[0]);
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    String[] arrayOfString = (String[])localObject;
    int j = arrayOfString.length;
    int i = 0;
    label145:
    if (i < j)
    {
      localObject = arrayOfString[i];
      QLog.i("PTSLiteEventTypeHandler", 1, "[handleEventType], eventType = " + (String)localObject);
      if (TextUtils.equals((CharSequence)localObject, (CharSequence)"0xebfRequest")) {
        if (paramHashMap == null) {
          break label220;
        }
      }
    }
    label220:
    for (localObject = paramHashMap;; localObject = new HashMap())
    {
      b(paramPTSComposer, (HashMap)localObject);
      i += 1;
      break label145;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qmg
 * JD-Core Version:    0.7.0.1
 */