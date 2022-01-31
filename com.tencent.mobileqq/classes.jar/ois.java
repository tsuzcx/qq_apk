import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity;
import java.util.ArrayList;
import java.util.Arrays;
import mqq.app.AppRuntime;

public class ois
{
  private static Bundle a(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("edit_video_type", 10013);
    localBundle.putInt("key_ability_flag", 3);
    localBundle.putInt("key_max_duration", bkbq.f(BaseApplicationImpl.getApplication().getRuntime()));
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
      QQToast.a(paramActivity, 0, 2131720131, 0).a();
      return;
    }
    boolean bool = bnsn.b(a());
    if (!axpm.a())
    {
      b(paramActivity);
      return;
    }
    if ((!bool) && (!bdin.g(paramActivity)))
    {
      QQToast.a(paramActivity, 2131719278, 0).a();
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
    localIntent.putExtra("pendingIntentClass", bknx.class.getName());
    localIntent.putExtra("pendingIntentRequest", paramByte);
    localIntent.putExtra("pendingIntentAllWait", true);
    CaptureQmcfSoDownloadActivity.a(paramActivity, bkof.class.getName(), localIntent.getExtras(), paramByte);
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
      QQToast.a(paramContext, 0, 2131720131, 0).a();
      return;
    }
    boolean bool = bnsn.b(a());
    if (!axpm.a())
    {
      b(paramContext);
      return;
    }
    if ((!bool) && (!bdin.g(paramContext)))
    {
      QQToast.a(paramContext, 2131719278, 0).a();
      return;
    }
    a();
    if (bool)
    {
      QIMCameraCaptureActivity.a(paramContext, localBundle);
      return;
    }
    CaptureQmcfSoDownloadActivity.a(paramContext, qps.class.getName(), localBundle, true);
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    if (a().c())
    {
      QQToast.a(paramContext, 0, 2131720131, 0).a();
      return;
    }
    boolean bool = bnsn.b(a());
    if (!axpm.a())
    {
      b(paramContext);
      return;
    }
    if ((!bool) && (!bdin.g(paramContext)))
    {
      QQToast.a(paramContext, 2131719278, 0).a();
      return;
    }
    a();
    if (bool)
    {
      QIMCameraCaptureActivity.a(paramContext, a(paramBundle));
      return;
    }
    CaptureQmcfSoDownloadActivity.a(paramContext, bknx.class.getName(), a(paramBundle), true);
  }
  
  public static void a(sxe paramsxe, Context paramContext, Bundle paramBundle, byte paramByte)
  {
    boolean bool = bnsn.b(paramsxe.mRuntime.a());
    if (!axpm.a())
    {
      b(paramContext);
      return;
    }
    if ((!bool) && (!bdin.g(paramContext)))
    {
      QQToast.a(paramContext, 2131719278, 0).a();
      return;
    }
    paramsxe.m();
    if (bool)
    {
      paramsxe.startActivityForResult(QIMCameraCaptureActivity.a(paramContext, a(paramBundle)), paramByte);
      return;
    }
    paramContext = new Intent(paramContext, CaptureQmcfSoDownloadActivity.class);
    paramContext.putExtras(a(paramBundle));
    paramContext.putExtra("pendingIntentClass", bknx.class.getName());
    paramContext.putExtra("pendingIntentRequest", paramByte);
    paramContext.putExtra("pendingIntentAllWait", true);
    paramsxe.startActivityForResult(paramContext, paramByte);
  }
  
  private static boolean a()
  {
    return azkt.a(a(), BaseApplicationImpl.getContext());
  }
  
  private static void b(Context paramContext)
  {
    bdgm.a(paramContext, 230).setMessage(alud.a(2131713143)).setPositiveButton(2131694953, new oit()).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ois
 * JD-Core Version:    0.7.0.1
 */