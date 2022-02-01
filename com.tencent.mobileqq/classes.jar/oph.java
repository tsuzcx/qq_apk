import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity;
import java.util.ArrayList;
import java.util.Arrays;
import mqq.app.AppRuntime;

public class oph
{
  private static Bundle a(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("edit_video_type", 10013);
    localBundle.putInt("entrance_type", 106);
    localBundle.putInt("extra.busi_type", 12);
    localBundle.putInt("edit_video_way", 10);
    localBundle.putBoolean("PeakConstants.ARG_ALBUM", false);
    localBundle.putInt("key_camera_photo_edit_type", 1);
    localBundle.putInt("key_camera_video_edit_type", 5);
    localBundle.putInt("ability_flag", 3);
    localBundle.putInt("key_max_duration", bkwm.f(BaseApplicationImpl.getApplication().getRuntime()));
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
    if (a().isVideoChatting())
    {
      QQToast.a(paramActivity, 0, 2131718468, 0).a();
      return;
    }
    boolean bool = body.b(a());
    if (!babd.a())
    {
      b(paramActivity);
      return;
    }
    if ((!bool) && (!NetworkUtil.isNetworkAvailable(paramActivity)))
    {
      QQToast.a(paramActivity, 2131717741, 0).a();
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
    localIntent.putExtra("pendingIntentClass", bljy.class.getName());
    localIntent.putExtra("pendingIntentRequest", paramByte);
    localIntent.putExtra("pendingIntentAllWait", true);
    CaptureQmcfSoDownloadActivity.a(paramActivity, blii.class.getName(), localIntent.getExtras(), paramByte);
  }
  
  public static void a(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("edit_video_type", 10017);
    localBundle.putInt("entrance_type", 106);
    localBundle.putInt("extra.busi_type", 8);
    localBundle.putInt("edit_video_way", 10);
    localBundle.putInt("ability_flag", 2);
    localBundle.putBoolean("PeakConstants.ARG_ALBUM", false);
    localBundle.putInt("key_camera_photo_edit_type", 1);
    localBundle.putInt("key_camera_video_edit_type", 5);
    localBundle.putIntegerArrayList("support_intent_mode", new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(0) })));
    localBundle.putInt("capture_intent_mode", 0);
    if (a().isVideoChatting())
    {
      QQToast.a(paramContext, 0, 2131718468, 0).a();
      return;
    }
    boolean bool = body.b(a());
    if (!babd.a())
    {
      b(paramContext);
      return;
    }
    if ((!bool) && (!NetworkUtil.isNetworkAvailable(paramContext)))
    {
      QQToast.a(paramContext, 2131717741, 0).a();
      return;
    }
    a();
    if (bool)
    {
      QIMCameraCaptureActivity.a(paramContext, localBundle);
      return;
    }
    CaptureQmcfSoDownloadActivity.a(paramContext, bljy.class.getName(), localBundle, true);
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    if (a().isVideoChatting())
    {
      QQToast.a(paramContext, 0, 2131718468, 0).a();
      return;
    }
    boolean bool = body.b(a());
    if (!babd.a())
    {
      b(paramContext);
      return;
    }
    if ((!bool) && (!NetworkUtil.isNetworkAvailable(paramContext)))
    {
      QQToast.a(paramContext, 2131717741, 0).a();
      return;
    }
    a();
    if (bool)
    {
      QIMCameraCaptureActivity.a(paramContext, a(paramBundle));
      return;
    }
    CaptureQmcfSoDownloadActivity.a(paramContext, bljy.class.getName(), a(paramBundle), true);
  }
  
  public static void a(ufd paramufd, Context paramContext, Bundle paramBundle, byte paramByte)
  {
    boolean bool = body.b(paramufd.mRuntime.a());
    if (!babd.a())
    {
      b(paramContext);
      return;
    }
    if ((!bool) && (!NetworkUtil.isNetworkAvailable(paramContext)))
    {
      QQToast.a(paramContext, 2131717741, 0).a();
      return;
    }
    paramufd.m();
    if (bool)
    {
      paramufd.startActivityForResult(QIMCameraCaptureActivity.a(paramContext, a(paramBundle)), paramByte);
      return;
    }
    paramContext = new Intent(paramContext, CaptureQmcfSoDownloadActivity.class);
    paramContext.putExtras(a(paramBundle));
    paramContext.putExtra("pendingIntentClass", bljy.class.getName());
    paramContext.putExtra("pendingIntentRequest", paramByte);
    paramContext.putExtra("pendingIntentAllWait", true);
    paramufd.startActivityForResult(paramContext, paramByte);
  }
  
  private static boolean a()
  {
    return bbxj.a(a(), BaseApplicationImpl.getContext());
  }
  
  private static void b(Context paramContext)
  {
    bfur.a(paramContext, 230).setMessage(amtj.a(2131711863)).setPositiveButton(2131694201, new opi()).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oph
 * JD-Core Version:    0.7.0.1
 */