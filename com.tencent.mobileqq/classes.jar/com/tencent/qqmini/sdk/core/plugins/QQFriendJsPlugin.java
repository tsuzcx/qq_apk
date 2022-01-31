package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import behq;
import bekp;
import bekr;
import betc;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import org.json.JSONObject;

public class QQFriendJsPlugin
  extends BaseJsPlugin
{
  public static final String API_ADD_FRIEND = "addFriend";
  public static final String SETTING_ADD_FRIEND = "setting.addFriend";
  private static final String TAG = "QQFriendJsPlugin";
  private ChannelProxy mChannelProxy;
  private MiniAppProxy mMiniAppProxy;
  
  public static void doAddFriend(Context paramContext, String paramString1, String paramString2, QQFriendJsPlugin.IAddFriendCallBack paramIAddFriendCallBack)
  {
    if (paramContext == null)
    {
      betc.d("QQFriendJsPlugin", "doAddFriend context is null ?!!");
      return;
    }
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getUserSetting(paramString1, paramString2, "setting.addFriend", new QQFriendJsPlugin.2(paramString2, paramString1, (MiniAppProxy)ProxyManager.get(MiniAppProxy.class), paramContext, paramIAddFriendCallBack));
  }
  
  public void addFriend(bekr parambekr)
  {
    try
    {
      String str = new JSONObject(parambekr.b).optString("openid", "");
      QQFriendJsPlugin.1 local1 = new QQFriendJsPlugin.1(this, parambekr);
      doAddFriend(this.mMiniAppContext.a(), this.mApkgInfo.d, str, local1);
      return;
    }
    catch (Exception localException)
    {
      parambekr.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.QQFriendJsPlugin
 * JD-Core Version:    0.7.0.1
 */