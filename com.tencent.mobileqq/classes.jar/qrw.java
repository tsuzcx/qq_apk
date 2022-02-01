import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadService;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/service/RIJAidlClient;", "", "()V", "TAG", "", "<set-?>", "Lcom/tencent/biz/pubaccount/readinjoy/service/IRIJAidlInterface;", "rijAidlInterface", "getRijAidlInterface", "()Lcom/tencent/biz/pubaccount/readinjoy/service/IRIJAidlInterface;", "rijServiceConnection", "Lcom/tencent/biz/pubaccount/readinjoy/service/RIJAidlClient$RIJServiceConnection;", "bindService", "", "context", "Landroid/content/Context;", "getInstance", "unbindService", "RIJServiceConnection", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qrw
{
  @Nullable
  private static qrt jdField_a_of_type_Qrt;
  public static final qrw a;
  private static final qrx jdField_a_of_type_Qrx = new qrx();
  
  static
  {
    jdField_a_of_type_Qrw = new qrw();
  }
  
  @JvmStatic
  @NotNull
  public static final qrw a()
  {
    return jdField_a_of_type_Qrw;
  }
  
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    try
    {
      paramContext.bindService(new Intent(paramContext, KandianVideoUploadService.class), (ServiceConnection)jdField_a_of_type_Qrx, 1);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("RIJAidlClient", 1, QLog.getStackTraceString((Throwable)paramContext));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qrw
 * JD-Core Version:    0.7.0.1
 */