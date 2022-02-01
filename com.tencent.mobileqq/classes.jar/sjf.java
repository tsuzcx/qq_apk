import android.app.Application;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/superplayer/SuperPlayerSDKMgr;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerSDKMgr;", "Lcom/tencent/mobileqq/videoplatform/SDKInitListener;", "()V", "listener", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerSDKEventListener;", "initSDK", "", "installPlugin", "isInstalled", "", "onSDKInited", "success", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class sjf
  implements SDKInitListener, siw
{
  private static siv a;
  public static final sjf a;
  
  static
  {
    jdField_a_of_type_Sjf = new sjf();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video", 2, "initSuperPlayerSDK() finish");
    }
  }
  
  public void a(@NotNull siv paramsiv)
  {
    Intrinsics.checkParameterIsNotNull(paramsiv, "listener");
    jdField_a_of_type_Siv = paramsiv;
    azwq.a((Application)BaseApplicationImpl.getContext(), (SDKInitListener)this);
  }
  
  public boolean a()
  {
    return azwq.a();
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    siv localsiv;
    if (paramBoolean)
    {
      localsiv = jdField_a_of_type_Siv;
      if (localsiv != null) {
        localsiv.a();
      }
    }
    do
    {
      return;
      localsiv = jdField_a_of_type_Siv;
    } while (localsiv == null);
    localsiv.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sjf
 * JD-Core Version:    0.7.0.1
 */