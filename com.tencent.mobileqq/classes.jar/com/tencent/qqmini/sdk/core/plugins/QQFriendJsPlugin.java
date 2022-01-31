package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import bgho;
import bgjw;
import bgkd;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.log.QMLog;
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
      QMLog.e("QQFriendJsPlugin", "doAddFriend context is null ?!!");
      return;
    }
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    localChannelProxy.getUserSetting(paramString1, paramString2, "setting.addFriend", new QQFriendJsPlugin.2(paramString2, paramString1, localChannelProxy, paramContext, paramIAddFriendCallBack));
  }
  
  public void addFriend(bgkd parambgkd)
  {
    try
    {
      String str = new JSONObject(parambgkd.b).optString("openid", "");
      QQFriendJsPlugin.1 local1 = new QQFriendJsPlugin.1(this, parambgkd);
      doAddFriend(this.mMiniAppContext.a(), this.mApkgInfo.appId, str, local1);
      return;
    }
    catch (Exception localException)
    {
      parambgkd.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.QQFriendJsPlugin
 * JD-Core Version:    0.7.0.1
 */