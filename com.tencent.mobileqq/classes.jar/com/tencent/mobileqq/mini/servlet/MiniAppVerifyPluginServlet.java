package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StPlugin;
import NS_MINI_INTERFACE.INTERFACE.StVerifyPluginRsp;
import android.content.Intent;
import android.os.Bundle;
import bakc;
import com.tencent.mobileqq.mini.apkg.PluginInfo;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.Packet;
import ynv;

public class MiniAppVerifyPluginServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APP_ID = "key_app_id";
  public static final String KEY_PLUGIN_IDS = "key_plugin_ids";
  public static final String KEY_PLUGIN_PROFILE = "plugin_profile";
  public static final String TAG = "MiniAppVerifyPluginServlet";
  
  public MiniAppVerifyPluginServlet()
  {
    this.observerId = 1038;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    INTERFACE.StVerifyPluginRsp localStVerifyPluginRsp = new INTERFACE.StVerifyPluginRsp();
    localStVerifyPluginRsp.mergeFrom(paramArrayOfByte);
    if (paramBundle.getLong("retCode") == 0L)
    {
      paramArrayOfByte = ynv.a(localStVerifyPluginRsp.pluginList);
      if (paramArrayOfByte != null) {
        paramBundle.putString("plugin_profile", paramArrayOfByte.toString());
      }
      notifyObserver(paramIntent, 1038, true, paramBundle, MiniAppObserver.class);
      return;
    }
    notifyObserver(paramIntent, 1038, false, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getStringExtra("key_app_id");
    Object localObject3 = paramIntent.getParcelableArrayListExtra("key_plugin_ids");
    int i = paramIntent.getIntExtra("key_index", -1);
    Object localObject2 = new ArrayList();
    localObject3 = ((List)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      PluginInfo localPluginInfo = (PluginInfo)((Iterator)localObject3).next();
      if (localPluginInfo != null)
      {
        INTERFACE.StPlugin localStPlugin = new INTERFACE.StPlugin();
        localStPlugin.plugin_id.set(localPluginInfo.getPluginId());
        localStPlugin.inner_version.set(localPluginInfo.getInnerVersion());
        ((List)localObject2).add(localStPlugin);
      }
    }
    localObject2 = new VerifyPluginRequest((String)localObject1, (List)localObject2).encode(paramIntent, i, getTraceId());
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_info.VerifyPlugin");
    paramPacket.putSendData(bakc.a((byte[])localObject1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppVerifyPluginServlet
 * JD-Core Version:    0.7.0.1
 */