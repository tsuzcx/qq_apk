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

public class ovj
{
  private static Bundle a(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("edit_video_type", 10013);
    localBundle.putInt("key_ability_flag", 3);
    localBundle.putInt("key_max_duration", bmqa.f(BaseApplicationImpl.getApplication().getRuntime()));
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
    if (a().d())
    {
      QQToast.a(paramActivity, 0, 2131718094, 0).a();
      return;
    }
    boolean bool = bqjb.b(a());
    if (!bann.a())
    {
      b(paramActivity);
      return;
    }
    if ((!bool) && (!bgnt.g(paramActivity)))
    {
      QQToast.a(paramActivity, 2131717374, 0).a();
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
    localIntent.putExtra("pendingIntentClass", bnck.class.getName());
    localIntent.putExtra("pendingIntentRequest", paramByte);
    localIntent.putExtra("pendingIntentAllWait", true);
    CaptureQmcfSoDownloadActivity.a(paramActivity, bncs.class.getName(), localIntent.getExtras(), paramByte);
  }
  
  public static void a(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("edit_video_type", 10017);
    localBundle.putInt("entrance_type", 106);
    localBundle.putIntegerArrayList("support_intent_mode", new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(0) })));
    localBundle.putInt("capture_intent_mode", 0);
    localBundle.putBoolean("enable_local_video", false);
    if (a().d())
    {
      QQToast.a(paramContext, 0, 2131718094, 0).a();
      return;
    }
    boolean bool = bqjb.b(a());
    if (!bann.a())
    {
      b(paramContext);
      return;
    }
    if ((!bool) && (!bgnt.g(paramContext)))
    {
      QQToast.a(paramContext, 2131717374, 0).a();
      return;
    }
    a();
    if (bool)
    {
      QIMCameraCaptureActivity.a(paramContext, localBundle);
      return;
    }
    CaptureQmcfSoDownloadActivity.a(paramContext, rkp.class.getName(), localBundle, true);
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    if (a().d())
    {
      QQToast.a(paramContext, 0, 2131718094, 0).a();
      return;
    }
    boolean bool = bqjb.b(a());
    if (!bann.a())
    {
      b(paramContext);
      return;
    }
    if ((!bool) && (!bgnt.g(paramContext)))
    {
      QQToast.a(paramContext, 2131717374, 0).a();
      return;
    }
    a();
    if (bool)
    {
      QIMCameraCaptureActivity.a(paramContext, a(paramBundle));
      return;
    }
    CaptureQmcfSoDownloadActivity.a(paramContext, bnck.class.getName(), a(paramBundle), true);
  }
  
  public static void a(tym paramtym, Context paramContext, Bundle paramBundle, byte paramByte)
  {
    boolean bool = bqjb.b(paramtym.mRuntime.a());
    if (!bann.a())
    {
      b(paramContext);
      return;
    }
    if ((!bool) && (!bgnt.g(paramContext)))
    {
      QQToast.a(paramContext, 2131717374, 0).a();
      return;
    }
    paramtym.m();
    if (bool)
    {
      paramtym.startActivityForResult(QIMCameraCaptureActivity.a(paramContext, a(paramBundle)), paramByte);
      return;
    }
    paramContext = new Intent(paramContext, CaptureQmcfSoDownloadActivity.class);
    paramContext.putExtras(a(paramBundle));
    paramContext.putExtra("pendingIntentClass", bnck.class.getName());
    paramContext.putExtra("pendingIntentRequest", paramByte);
    paramContext.putExtra("pendingIntentAllWait", true);
    paramtym.startActivityForResult(paramContext, paramByte);
  }
  
  private static boolean a()
  {
    return bcls.a(a(), BaseApplicationImpl.getContext());
  }
  
  private static void b(Context paramContext)
  {
    bglp.a(paramContext, 230).setMessage(anni.a(2131711522)).setPositiveButton(2131694081, new ovk()).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ovj
 * JD-Core Version:    0.7.0.1
 */