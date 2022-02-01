package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoRsp;
import android.content.Intent;
import android.os.Bundle;
import bhuf;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import mqq.app.Packet;

public class MiniAppGetShareInfoServlet
  extends MiniAppAbstractServlet
{
  private static final String CMD_STRING = "LightAppSvc.mini_app_share.AdaptShareInfo";
  public static final String JSON_DATA = "jsonData";
  public static final String MINI_APP_NEED_ONLY_PREVIEW = "miniAppNeedOnlyPreview";
  public static final String NEED_SHARE_CALLBACK = "needShareCallBack";
  private static final String TAG = "MiniAppGetShareInfoServ";
  
  public MiniAppGetShareInfoServlet()
  {
    this.observerId = 1012;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    MiniProgramShare.StAdaptShareInfoRsp localStAdaptShareInfoRsp = new MiniProgramShare.StAdaptShareInfoRsp();
    localStAdaptShareInfoRsp.mergeFrom(paramArrayOfByte);
    if ((localStAdaptShareInfoRsp.extInfo != null) && (localStAdaptShareInfoRsp.extInfo.mapInfo != null))
    {
      int i = 0;
      while (i < localStAdaptShareInfoRsp.extInfo.mapInfo.size())
      {
        paramArrayOfByte = (COMM.Entry)localStAdaptShareInfoRsp.extInfo.mapInfo.get(i);
        if (("needShareCallBack".equals(paramArrayOfByte.key.get())) && ("true".equals(paramArrayOfByte.value.get()))) {
          paramBundle.putBoolean("needShareCallBack", true);
        }
        i += 1;
      }
    }
    paramBundle.putString("jsonData", localStAdaptShareInfoRsp.jsonData.get());
    notifyObserver(paramIntent, 1012, true, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject = paramIntent.getByteArrayExtra("key_data");
    int i = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte = new GetShareInfoRequest((byte[])localObject).encode(paramIntent, i, getTraceId());
    localObject = arrayOfByte;
    if (arrayOfByte == null) {
      localObject = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_share.AdaptShareInfo");
    paramPacket.putSendData(bhuf.a((byte[])localObject));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetShareInfoServlet
 * JD-Core Version:    0.7.0.1
 */