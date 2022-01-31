package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StExtConfigInfo;
import NS_MINI_INTERFACE.INTERFACE.StGetExtConfigDetailRsp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bdku;
import com.tencent.mobileqq.mini.apkg.ExtConfigInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.Packet;
import org.json.JSONObject;

public class MiniAppGetExtConfigDetailServlet
  extends MiniAppAbstractServlet
{
  public static final String CONFIG_KEY_API_SCOPE = "apiscopeconfig";
  public static final String KEY_COMMON_EXT = "key_common_ext";
  public static final String KEY_EXT_CONFIG_DETAIL_RESULT = "key_ext_config_detail_result";
  public static final String KEY_EXT_CONFIG_INFO = "key_ext_config_info";
  private static final String TAG = "MiniAppGetExtConfigDetailServlet";
  
  public MiniAppGetExtConfigDetailServlet()
  {
    this.observerId = 1040;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    Object localObject = new INTERFACE.StGetExtConfigDetailRsp();
    ((INTERFACE.StGetExtConfigDetailRsp)localObject).mergeFrom(paramArrayOfByte);
    localObject = ((INTERFACE.StGetExtConfigDetailRsp)localObject).configs.get();
    paramArrayOfByte = new JSONObject();
    if (localObject != null) {
      try
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ExtConfigInfo localExtConfigInfo = ExtConfigInfo.from((INTERFACE.StExtConfigInfo)((Iterator)localObject).next());
          if ((localExtConfigInfo != null) && (!TextUtils.isEmpty(localExtConfigInfo.configKey))) {
            paramArrayOfByte.put(localExtConfigInfo.configKey, localExtConfigInfo.toJson());
          }
        }
        paramBundle.putString("key_ext_config_detail_result", paramArrayOfByte.toString());
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MiniAppGetExtConfigDetailServlet", 1, "onProcessData exception!", localThrowable);
      }
    }
    notifyObserver(paramIntent, 1040, true, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject3 = paramIntent.getByteArrayExtra("key_common_ext");
    Object localObject2 = paramIntent.getParcelableArrayListExtra("key_ext_config_info");
    int i = paramIntent.getIntExtra("key_index", -1);
    if (localObject3 != null) {}
    for (Object localObject1 = new COMM.StCommonExt();; localObject1 = null) {
      try
      {
        ((COMM.StCommonExt)localObject1).mergeFrom((byte[])localObject3);
        localObject3 = new ArrayList();
        if (localObject2 != null)
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((List)localObject3).add(((ExtConfigInfo)((Iterator)localObject2).next()).toProto());
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("MiniAppGetExtConfigDetailServlet", 1, "onSend. StCommonExt mergeFrom exception!", localThrowable);
        }
        localObject2 = new GetExtConfigDetailRequest((COMM.StCommonExt)localObject1, localThrowable).encode(paramIntent, i, getTraceId());
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new byte[4];
        }
        paramPacket.setSSOCommand("LightAppSvc.mini_app_info.GetExtConfigDetail");
        paramPacket.putSendData(bdku.a((byte[])localObject1));
        paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
        super.onSend(paramIntent, paramPacket);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetExtConfigDetailServlet
 * JD-Core Version:    0.7.0.1
 */