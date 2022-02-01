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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/reward/aidl/RIJAidlClient;", "", "()V", "TAG", "", "<set-?>", "Lcom/tencent/biz/pubaccount/readinjoy/reward/aidl/IRIJAidlInterface;", "rijAidlInterface", "getRijAidlInterface", "()Lcom/tencent/biz/pubaccount/readinjoy/reward/aidl/IRIJAidlInterface;", "rijServiceConnection", "Lcom/tencent/biz/pubaccount/readinjoy/reward/aidl/RIJAidlClient$RIJServiceConnection;", "bindService", "", "context", "Landroid/content/Context;", "getInstance", "unbindService", "RIJServiceConnection", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rlc
{
  @Nullable
  private static rkt jdField_a_of_type_Rkt;
  public static final rlc a;
  private static final rld jdField_a_of_type_Rld = new rld();
  
  static
  {
    jdField_a_of_type_Rlc = new rlc();
  }
  
  @JvmStatic
  @NotNull
  public static final rlc a()
  {
    return jdField_a_of_type_Rlc;
  }
  
  @Nullable
  public final rkt a()
  {
    return jdField_a_of_type_Rkt;
  }
  
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    try
    {
      paramContext.bindService(new Intent(paramContext, KandianVideoUploadService.class), (ServiceConnection)jdField_a_of_type_Rld, 1);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("RIJAidlClient", 1, QLog.getStackTraceString((Throwable)paramContext));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rlc
 * JD-Core Version:    0.7.0.1
 */