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
public final class qyw
{
  @Nullable
  private static qyn jdField_a_of_type_Qyn;
  public static final qyw a;
  private static final qyx jdField_a_of_type_Qyx = new qyx();
  
  static
  {
    jdField_a_of_type_Qyw = new qyw();
  }
  
  @JvmStatic
  @NotNull
  public static final qyw a()
  {
    return jdField_a_of_type_Qyw;
  }
  
  @Nullable
  public final qyn a()
  {
    return jdField_a_of_type_Qyn;
  }
  
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    try
    {
      paramContext.bindService(new Intent(paramContext, KandianVideoUploadService.class), (ServiceConnection)jdField_a_of_type_Qyx, 1);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("RIJAidlClient", 1, QLog.getStackTraceString((Throwable)paramContext));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qyw
 * JD-Core Version:    0.7.0.1
 */