import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/superplayer/SuperPlayerSDKMgr;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerSDKMgr;", "Lcom/tencent/mobileqq/videoplatform/SDKInitListener;", "()V", "listener", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerSDKEventListener;", "initSDK", "", "installPlugin", "isInstalled", "", "onSDKInited", "success", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class shn
  implements SDKInitListener, she
{
  private static shd a;
  public static final shn a;
  
  static
  {
    jdField_a_of_type_Shn = new shn();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video", 2, "initSuperPlayerSDK() finish");
    }
  }
  
  public void a(@NotNull shd paramshd)
  {
    Intrinsics.checkParameterIsNotNull(paramshd, "listener");
    jdField_a_of_type_Shd = paramshd;
    azjl.a((Context)BaseApplicationImpl.getContext(), (SDKInitListener)this);
  }
  
  public boolean a()
  {
    return azjl.a();
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    shd localshd;
    if (paramBoolean)
    {
      localshd = jdField_a_of_type_Shd;
      if (localshd != null) {
        localshd.a();
      }
    }
    do
    {
      return;
      localshd = jdField_a_of_type_Shd;
    } while (localshd == null);
    localshd.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     shn
 * JD-Core Version:    0.7.0.1
 */