import android.app.Application;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/superplayer/SuperPlayerSDKMgr;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerSDKMgr;", "Lcom/tencent/mobileqq/videoplatform/SDKInitListener;", "()V", "listener", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerSDKEventListener;", "initSDK", "", "installPlugin", "isInstalled", "", "onSDKInited", "success", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class saj
  implements SDKInitListener, saa
{
  private static rzz a;
  public static final saj a;
  
  static
  {
    jdField_a_of_type_Saj = new saj();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video", 2, "initSuperPlayerSDK() finish");
    }
  }
  
  public void a(@NotNull rzz paramrzz)
  {
    Intrinsics.checkParameterIsNotNull(paramrzz, "listener");
    jdField_a_of_type_Rzz = paramrzz;
    bapg.a((Application)BaseApplicationImpl.getContext(), (SDKInitListener)this);
  }
  
  public boolean a()
  {
    return bapg.a();
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    rzz localrzz;
    if (paramBoolean)
    {
      localrzz = jdField_a_of_type_Rzz;
      if (localrzz != null) {
        localrzz.a();
      }
    }
    do
    {
      return;
      localrzz = jdField_a_of_type_Rzz;
    } while (localrzz == null);
    localrzz.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     saj
 * JD-Core Version:    0.7.0.1
 */