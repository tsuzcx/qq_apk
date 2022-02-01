import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.OnLogListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/tvk/TVKPlayerSDKMgr;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerSDKMgr;", "Lcom/tencent/qqlive/mediaplayer/api/TVK_SDKMgr$OnLogListener;", "Lcom/tencent/qqlive/mediaplayer/api/TVK_SDKMgr$InstallListener;", "()V", "listener", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerSDKEventListener;", "d", "", "s", "", "s1", "e", "i", "initSDK", "", "installPlugin", "isInstalled", "", "onInstallProgress", "p0", "", "onInstalledFailed", "errorCode", "onInstalledSuccessed", "v", "w", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class sao
  implements TVK_SDKMgr.InstallListener, TVK_SDKMgr.OnLogListener, saa
{
  private static rzz a;
  public static final sao a;
  
  static
  {
    jdField_a_of_type_Sao = new sao();
  }
  
  public void a()
  {
    TVK_SDKMgr.setOnLogListener((TVK_SDKMgr.OnLogListener)this);
    TVK_SDKMgr.setDebugEnable(true);
    TVK_SDKMgr.initSdk((Context)BaseApplicationImpl.getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video", 2, "initTVKVideoSDK() finish");
    }
  }
  
  public void a(@NotNull rzz paramrzz)
  {
    Intrinsics.checkParameterIsNotNull(paramrzz, "listener");
    jdField_a_of_type_Rzz = paramrzz;
    TVK_SDKMgr.installPlugin((Context)BaseApplicationImpl.getContext(), (TVK_SDKMgr.InstallListener)this);
  }
  
  public boolean a()
  {
    return TVK_SDKMgr.isInstalled((Context)BaseApplicationImpl.getContext());
  }
  
  public int d(@Nullable String paramString1, @Nullable String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
    return 0;
  }
  
  public int e(@Nullable String paramString1, @Nullable String paramString2)
  {
    QLog.e(paramString1, 1, paramString2);
    return 0;
  }
  
  public int i(@Nullable String paramString1, @Nullable String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
    return 0;
  }
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    rzz localrzz = jdField_a_of_type_Rzz;
    if (localrzz != null) {
      localrzz.a(paramInt);
    }
  }
  
  public void onInstalledSuccessed()
  {
    rzz localrzz = jdField_a_of_type_Rzz;
    if (localrzz != null) {
      localrzz.a();
    }
  }
  
  public int v(@Nullable String paramString1, @Nullable String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
    return 0;
  }
  
  public int w(@Nullable String paramString1, @Nullable String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(paramString1, 2, paramString2);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sao
 * JD-Core Version:    0.7.0.1
 */