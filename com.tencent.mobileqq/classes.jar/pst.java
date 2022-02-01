import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.net.URLDecoder;

public class pst
  extends QIPCModule
{
  private static volatile pst a;
  
  private pst(String paramString)
  {
    super(paramString);
  }
  
  public static pst a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new pst("ReadInJoyIPCModule");
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
    Object localObject = paramBundle.getString("key_channel_jump_scheme", "");
    QLog.i("ReadInJoyIPCModule", 1, "[jumpToNativeChannel] native channel jump, channelID = " + i + ", changeChannelOrder = " + j + ", channelName = " + str + ", channelType = " + k + ", isPush = " + bool + ", sourceFrom = " + m + ", scheme = " + (String)localObject);
    if (j == 1) {
      pkm.a().b(i, m);
    }
    if (BaseActivity.sTopActivity == null) {}
    for (paramBundle = BaseApplicationImpl.getContext(); paramBundle == null; paramBundle = BaseActivity.sTopActivity)
    {
      QLog.i("ReadInJoyIPCModule", 1, "[jumpToNativeChannel], context is null.");
      return;
    }
    if (prw.a(paramBundle, (String)localObject))
    {
      QLog.i("ReadInJoyIPCModule", 1, "[jumpToNativeChannel], jump to recommend channel, using floating window.");
      return;
    }
    if (twr.a(paramBundle, (String)localObject, i))
    {
      QLog.i("ReadInJoyIPCModule", 1, "[jumpToNativeChannel], jump to mini game channel");
      return;
    }
    if (bool) {}
    for (localObject = "1"; prt.a((String)localObject, i); localObject = "0")
    {
      okj.a(paramBundle, i, str, k, 4);
      return;
    }
    localObject = okj.b(paramBundle, 0, i);
    if (!(paramBundle instanceof BaseActivity)) {
      ((Intent)localObject).setFlags(268435456);
    }
    paramBundle.startActivity((Intent)localObject);
  }
  
  protected void a(Bundle paramBundle, int paramInt)
  {
    ReadInJoyUserInfoModule.a(paramBundle.getLong("uin"), new psv(this, paramInt));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    boolean bool = true;
    if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      QLog.i("ReadInJoyIPCModule", 1, "[onCall], runtime is not QQAppInterface.");
    }
    label237:
    do
    {
      do
      {
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
          if (!"action_viola_fragment_jump".equals(paramString)) {
            break;
          }
        } while (paramBundle == null);
        String str = paramBundle.getString("key_viola_fragment_jump_url", "");
        paramInt = paramBundle.getInt("key_native_channel_id", 0);
        if (prt.a(Uri.parse(str).getQueryParameter("ispush"), paramInt)) {
          try
          {
            if (str.contains("v_url_base64")) {}
            for (paramString = bfvp.c(Uri.parse(str).getQueryParameter("v_url_base64")); BaseActivity.sTopActivity == null; paramString = URLDecoder.decode(Uri.parse(str).getQueryParameter("v_url"), "utf-8"))
            {
              paramBundle = BaseApplicationImpl.getContext();
              tgc.a(paramBundle, null, paramString, null);
              return null;
            }
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              QLog.e("ReadInJoyIPCModule", 1, "call viola page error = " + paramString.getMessage());
              paramString = null;
              continue;
              paramBundle = BaseActivity.sTopActivity;
            }
          }
        }
        paramInt = paramBundle.getInt("key_native_channel_change_order", 0);
        if (BaseActivity.sTopActivity == null)
        {
          paramString = BaseApplicationImpl.getContext();
          if (paramInt != 1) {
            break label237;
          }
        }
        for (;;)
        {
          prt.a(paramString, str, bool);
          return null;
          paramString = BaseActivity.sTopActivity;
          break;
          bool = false;
        }
        if ("action_update_biu_and_comment_switch_action".equals(paramString))
        {
          bool = ooy.a();
          paramString = new Bundle();
          paramString.putBoolean("action_update_biu_and_comment_switch", bool);
          callbackResult(paramInt, EIPCResult.createResult(0, paramString));
          return null;
        }
        if (!"action_update_biu_and_comment_request_action".equals(paramString)) {
          break;
        }
        paramString = (Intent)paramBundle.getParcelable("action_update_biu_and_comment_request");
      } while (paramString == null);
      paramBundle = new ooz();
      UiApiPlugin.a(paramString, paramBundle, paramString.getStringExtra("arg_callback"), new psu(this, paramInt, paramBundle));
      return null;
      if ("action_get_user_info_action".equals(paramString))
      {
        a(paramBundle, paramInt);
        return null;
      }
    } while (!"action_get_app_type_action".equals(paramString));
    paramString = new Bundle();
    paramString.putInt("action_get_app_type", uhv.c());
    callbackResult(paramInt, EIPCResult.createResult(0, paramString));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pst
 * JD-Core Version:    0.7.0.1
 */