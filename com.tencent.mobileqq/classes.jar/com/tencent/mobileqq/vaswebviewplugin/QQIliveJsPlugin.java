package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import cooperation.ilive.host.IliveEnterGroupHost;
import eipc.EIPCClient;

public class QQIliveJsPlugin
  extends VasWebviewJsPluginV2
{
  private static final String ACTION_NOTIFY_FOLLOW_CHANGE = "action_follow_change";
  public static final String BUSINESS_NAME = "vaslive";
  private static final String KEY_FOLLOW_STATE = "key_follow_state";
  private static final String TAG = "QQIliveJsPlugin";
  
  public QQIliveJsPlugin()
  {
    super("vaslive");
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback|p_uin|type", method="followAnchor")
  public void followAnchor(String paramString1, String paramString2, Object paramObject)
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("anchorUin", paramString2);
      localBundle.putInt("followType", ((Integer)paramObject).intValue());
      QIPCClientHelper.getInstance().getClient().callServer("VasLiveIPCModule", "followAccount", localBundle, new QQIliveJsPlugin.1(this, paramObject, paramString1));
      return;
    }
    catch (Exception paramString2)
    {
      super.callJsOnError(paramString1, paramString2.getMessage());
    }
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback|uin", method="openGroupAioOrProfile")
  public void openGroupAioOrProfile(String paramString1, String paramString2)
  {
    try
    {
      IliveEnterGroupHost.joinGroup(false, paramString2, "");
      super.callJs(paramString1);
      return;
    }
    catch (Exception paramString2)
    {
      super.callJsOnError(paramString1, paramString2.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQIliveJsPlugin
 * JD-Core Version:    0.7.0.1
 */