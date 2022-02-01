import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.pts.core.PTSComposer;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/pts/network/PTSGeneralRequestModule$Companion;", "", "()V", "CMD_PTS_REQUEST_DATA", "", "KEY_PTS_APP_INSTANCE_ID", "SERVICE_TYPE_DEFAULT", "", "TAG", "requestPtsBusinessData", "", "ptsComposer", "Lcom/tencent/pts/core/PTSComposer;", "businessType", "requestParamsJson", "extendInfoJson", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qhn
{
  public final void a(@Nullable PTSComposer paramPTSComposer, int paramInt, @Nullable String paramString1, @Nullable String paramString2)
  {
    if (paramPTSComposer == null) {
      QLog.i("PTSGeneralRequestModule", 1, "[requestPtsBusinessData] ptsComposer is null, businessType = " + paramInt);
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = ozs.a();
          if (localObject == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
          }
          localObject = (pfg)((QQAppInterface)localObject).getManager(163);
        } while (localObject == null);
        localObject = ((pfg)localObject).a();
      } while (localObject == null);
      localObject = ((pfa)localObject).a();
    } while (localObject == null);
    if (paramString1 != null) {
      if (paramString2 == null) {
        break label121;
      }
    }
    for (;;)
    {
      ((qhm)localObject).a(paramPTSComposer, paramInt, paramString1, paramString2);
      return;
      paramString1 = "";
      break;
      label121:
      paramString2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qhn
 * JD-Core Version:    0.7.0.1
 */