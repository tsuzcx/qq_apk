import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadService;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/service/RIJAidlClient;", "", "()V", "<set-?>", "Lcom/tencent/biz/pubaccount/readinjoy/service/IRIJAidlInterface;", "rijAidlInterface", "getRijAidlInterface", "()Lcom/tencent/biz/pubaccount/readinjoy/service/IRIJAidlInterface;", "rijServiceConnection", "Lcom/tencent/biz/pubaccount/readinjoy/service/RIJAidlClient$RIJServiceConnection;", "bindService", "", "context", "Landroid/content/Context;", "getInstance", "unbindService", "RIJServiceConnection", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qhu
{
  @Nullable
  private static qhr jdField_a_of_type_Qhr;
  public static final qhu a;
  private static final qhv jdField_a_of_type_Qhv = new qhv();
  
  static
  {
    jdField_a_of_type_Qhu = new qhu();
  }
  
  @JvmStatic
  @NotNull
  public static final qhu a()
  {
    return jdField_a_of_type_Qhu;
  }
  
  @Nullable
  public final qhr a()
  {
    return jdField_a_of_type_Qhr;
  }
  
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext.bindService(new Intent(paramContext, KandianVideoUploadService.class), (ServiceConnection)jdField_a_of_type_Qhv, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qhu
 * JD-Core Version:    0.7.0.1
 */