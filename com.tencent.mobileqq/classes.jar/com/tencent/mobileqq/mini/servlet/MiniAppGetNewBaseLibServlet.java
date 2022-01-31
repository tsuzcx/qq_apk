package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StBaseLibInfo;
import NS_MINI_INTERFACE.INTERFACE.StGetNewBaseLibRsp;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import bakc;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.Packet;

public class MiniAppGetNewBaseLibServlet
  extends MiniAppAbstractServlet
{
  public static final String TAG = "MiniAppGetNewBaseLibServlet";
  
  public MiniAppGetNewBaseLibServlet()
  {
    this.observerId = 1004;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    INTERFACE.StGetNewBaseLibRsp localStGetNewBaseLibRsp = new INTERFACE.StGetNewBaseLibRsp();
    localStGetNewBaseLibRsp.mergeFrom(paramArrayOfByte);
    int i = localStGetNewBaseLibRsp.interval.get();
    QLog.i("MiniAppGetNewBaseLibServlet", 2, "[MiniEng] GetNewBaseLib interval:" + i);
    long l1 = i * 1000;
    long l2 = System.currentTimeMillis();
    StorageUtil.getPreference().edit().putLong("baselib_min_update_time", l1 + l2).apply();
    paramArrayOfByte = localStGetNewBaseLibRsp.jsOrsoLibs.get().iterator();
    while (paramArrayOfByte.hasNext())
    {
      INTERFACE.StBaseLibInfo localStBaseLibInfo = (INTERFACE.StBaseLibInfo)paramArrayOfByte.next();
      BaseLibInfo localBaseLibInfo = new BaseLibInfo();
      localBaseLibInfo.baseLibUrl = localStBaseLibInfo.downloadUrl.get();
      localBaseLibInfo.baseLibVersion = localStBaseLibInfo.version.get();
      localBaseLibInfo.baseLibKey = null;
      localBaseLibInfo.baseLibDesc = localStBaseLibInfo.extInfo.get();
      if (TextUtils.isEmpty(localBaseLibInfo.baseLibDesc)) {
        localBaseLibInfo.baseLibDesc = "{'file_length':-1}";
      }
      localBaseLibInfo.baseLibType = localStBaseLibInfo.libType.get();
      paramBundle.putParcelable(localBaseLibInfo.getKey(), localBaseLibInfo);
      QLog.i("MiniAppGetNewBaseLibServlet", 1, "[MiniEng] GetNewBaseLib " + localBaseLibInfo);
    }
    paramBundle.putString("version", localStGetNewBaseLibRsp.libInfo.version.get());
    paramBundle.putString("downloadUrl", localStGetNewBaseLibRsp.libInfo.downloadUrl.get());
    notifyObserver(paramIntent, 1004, true, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    long l = paramIntent.getLongExtra("key_uin", 0L);
    Object localObject = paramIntent.getStringExtra("key_version");
    int i = paramIntent.getIntExtra("key_index", -1);
    int j = paramIntent.getIntExtra("key_libtype", 0);
    byte[] arrayOfByte = new GetNewBaseLibRequest(Long.valueOf(l).longValue(), (String)localObject, j).encode(paramIntent, i, getTraceId());
    localObject = arrayOfByte;
    if (arrayOfByte == null) {
      localObject = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_info.GetNewBaseLib");
    paramPacket.putSendData(bakc.a((byte[])localObject));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    QLog.i("MiniAppGetNewBaseLibServlet", 1, "[MiniEng] GetNewBaseLibServlet send request");
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetNewBaseLibServlet
 * JD-Core Version:    0.7.0.1
 */