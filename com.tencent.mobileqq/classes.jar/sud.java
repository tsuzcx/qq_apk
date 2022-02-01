import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/superplayer/SuperPlayerSDKMgr;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerSDKMgr;", "Lcom/tencent/mobileqq/videoplatform/SDKInitListener;", "()V", "listener", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerSDKEventListener;", "initSDK", "", "installPlugin", "isInstalled", "", "onSDKInited", "success", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class sud
  implements SDKInitListener, stu
{
  private static stt a;
  public static final sud a;
  
  static
  {
    jdField_a_of_type_Sud = new sud();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video", 2, "initSuperPlayerSDK() finish");
    }
  }
  
  public void a(@NotNull stt paramstt)
  {
    Intrinsics.checkParameterIsNotNull(paramstt, "listener");
    jdField_a_of_type_Stt = paramstt;
    bapt.a((Context)BaseApplicationImpl.getContext(), (SDKInitListener)this);
  }
  
  public boolean a()
  {
    return bapt.a();
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    stt localstt;
    if (paramBoolean)
    {
      localstt = jdField_a_of_type_Stt;
      if (localstt != null) {
        localstt.a();
      }
    }
    do
    {
      return;
      localstt = jdField_a_of_type_Stt;
    } while (localstt == null);
    localstt.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sud
 * JD-Core Version:    0.7.0.1
 */