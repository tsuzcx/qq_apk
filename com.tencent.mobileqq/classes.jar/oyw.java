import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.net.URLDecoder;

public class oyw
  extends QIPCModule
{
  private static volatile oyw a;
  
  private oyw(String paramString)
  {
    super(paramString);
  }
  
  public static oyw a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new oyw("ReadInJoyIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  private void a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("key_native_channel_id", 0);
    int j = paramBundle.getInt("key_native_channel_change_order", 0);
    String str = paramBundle.getString("key_native_channel_name", "");
    int k = paramBundle.getInt("key_native_channel_type", 0);
    boolean bool = paramBundle.getBoolean("key_native_channel_is_push", false);
    int m = paramBundle.getInt("key_channel_source_from", -1);
    paramBundle = paramBundle.getString("key_channel_jump_scheme", "");
    QLog.i("ReadInJoyIPCModule", 1, "[jumpToNativeChannel] native channel jump, channelID = " + i + ", changeChannelOrder = " + j + ", channelName = " + str + ", channelType = " + k + ", isPush = " + bool + ", sourceFrom = " + m + ", scheme = " + paramBundle);
    if (j == 1) {
      osj.a().b(i, m);
    }
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (oxz.a(localBaseActivity, paramBundle))
    {
      QLog.i("ReadInJoyIPCModule", 1, "[jumpToNativeChannel], jump to recommend channel, using floating window.");
      return;
    }
    if (bool) {}
    for (paramBundle = "1"; oxw.a(paramBundle, i); paramBundle = "0")
    {
      nut.a(localBaseActivity, i, str, k, 4);
      return;
    }
    paramBundle = nut.b(localBaseActivity, 0, i);
    if (!(localBaseActivity instanceof BaseActivity)) {
      paramBundle.setFlags(268435456);
    }
    localBaseActivity.startActivity(paramBundle);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    boolean bool = true;
    if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      QLog.i("ReadInJoyIPCModule", 1, "[onCall], runtime is not QQAppInterface.");
    }
    do
    {
      do
      {
        return null;
        if (!"action_native_channel_jump".equals(paramString)) {
          break;
        }
      } while (paramBundle == null);
      a(paramBundle);
      return null;
    } while ((!"action_viola_fragment_jump".equals(paramString)) || (paramBundle == null));
    String str = paramBundle.getString("key_viola_fragment_jump_url", "");
    paramInt = paramBundle.getInt("key_native_channel_id", 0);
    if (oxw.a(Uri.parse(str).getQueryParameter("ispush"), paramInt)) {
      try
      {
        if (str.contains("v_url_base64")) {}
        for (paramString = bbds.a(Uri.parse(str).getQueryParameter("v_url_base64"));; paramString = URLDecoder.decode(Uri.parse(str).getQueryParameter("v_url"), "utf-8"))
        {
          rwa.a(BaseActivity.sTopActivity, null, paramString, null);
          return null;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          QLog.e("ReadInJoyIPCModule", 1, "call viola page error = " + paramString.getMessage());
          paramString = null;
        }
      }
    }
    paramInt = paramBundle.getInt("key_native_channel_change_order", 0);
    if (BaseActivity.sTopActivity == null)
    {
      paramString = BaseApplicationImpl.getContext();
      if (paramInt != 1) {
        break label222;
      }
    }
    for (;;)
    {
      oxw.a(paramString, str, bool);
      return null;
      paramString = BaseActivity.sTopActivity;
      break;
      label222:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyw
 * JD-Core Version:    0.7.0.1
 */