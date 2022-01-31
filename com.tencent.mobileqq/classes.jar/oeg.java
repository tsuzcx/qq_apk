import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity;
import java.util.ArrayList;
import java.util.Arrays;
import mqq.app.AppRuntime;

public class oeg
{
  private static Bundle a(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("edit_video_type", 10013);
    localBundle.putInt("key_ability_flag", 3);
    localBundle.putInt("key_max_duration", bhvy.f(BaseApplicationImpl.getApplication().getRuntime()));
    return localBundle;
  }
  
  private static QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    throw new AndroidRuntimeException("mobile qq main process only");
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, byte paramByte)
  {
    if (paramActivity == null) {
      return;
    }
    if (a().c())
    {
      bcql.a(paramActivity, 0, 2131719587, 0).a();
      return;
    }
    boolean bool = blcr.b(a());
    if (!avte.a())
    {
      b(paramActivity);
      return;
    }
    if ((!bool) && (!bbfj.g(paramActivity)))
    {
      bcql.a(paramActivity, 2131718792, 0).a();
      return;
    }
    a();
    if (bool)
    {
      QIMCameraCaptureActivity.a(paramActivity, a(paramBundle), paramByte);
      return;
    }
    Intent localIntent = new Intent(paramActivity, CaptureQmcfSoDownloadActivity.class);
    localIntent.putExtras(a(paramBundle));
    localIntent.putExtra("pendingIntentClass", bihu.class.getName());
    localIntent.putExtra("pendingIntentRequest", paramByte);
    localIntent.putExtra("pendingIntentAllWait", true);
    CaptureQmcfSoDownloadActivity.a(paramActivity, biid.class.getName(), localIntent.getExtras(), paramByte);
  }
  
  public static void a(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("edit_video_type", 10017);
    localBundle.putInt("entrance_type", 106);
    localBundle.putIntegerArrayList("support_intent_mode", new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(0) })));
    localBundle.putInt("capture_intent_mode", 0);
    localBundle.putBoolean("enable_local_video", false);
    if (a().c())
    {
      bcql.a(paramContext, 0, 2131719587, 0).a();
      return;
    }
    boolean bool = blcr.b(a());
    if (!avte.a())
    {
      b(paramContext);
      return;
    }
    if ((!bool) && (!bbfj.g(paramContext)))
    {
      bcql.a(paramContext, 2131718792, 0).a();
      return;
    }
    a();
    if (bool)
    {
      QIMCameraCaptureActivity.a(paramContext, localBundle);
      return;
    }
    CaptureQmcfSoDownloadActivity.a(paramContext, qfm.class.getName(), localBundle, true);
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    if (a().c())
    {
      bcql.a(paramContext, 0, 2131719587, 0).a();
      return;
    }
    boolean bool = blcr.b(a());
    if (!avte.a())
    {
      b(paramContext);
      return;
    }
    if ((!bool) && (!bbfj.g(paramContext)))
    {
      bcql.a(paramContext, 2131718792, 0).a();
      return;
    }
    a();
    if (bool)
    {
      QIMCameraCaptureActivity.a(paramContext, a(paramBundle));
      return;
    }
    CaptureQmcfSoDownloadActivity.a(paramContext, bihu.class.getName(), a(paramBundle), true);
  }
  
  public static void a(sfk paramsfk, Context paramContext, Bundle paramBundle, byte paramByte)
  {
    boolean bool = blcr.b(paramsfk.mRuntime.a());
    if (!avte.a())
    {
      b(paramContext);
      return;
    }
    if ((!bool) && (!bbfj.g(paramContext)))
    {
      bcql.a(paramContext, 2131718792, 0).a();
      return;
    }
    paramsfk.m();
    if (bool)
    {
      paramsfk.startActivityForResult(QIMCameraCaptureActivity.a(paramContext, a(paramBundle)), paramByte);
      return;
    }
    paramContext = new Intent(paramContext, CaptureQmcfSoDownloadActivity.class);
    paramContext.putExtras(a(paramBundle));
    paramContext.putExtra("pendingIntentClass", bihu.class.getName());
    paramContext.putExtra("pendingIntentRequest", paramByte);
    paramContext.putExtra("pendingIntentAllWait", true);
    paramsfk.startActivityForResult(paramContext, paramByte);
  }
  
  private static boolean a()
  {
    return axle.a(a(), BaseApplicationImpl.getContext());
  }
  
  private static void b(Context paramContext)
  {
    bbdj.a(paramContext, 230).setMessage(ajya.a(2131712759)).setPositiveButton(2131694794, new oeh()).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     oeg
 * JD-Core Version:    0.7.0.1
 */