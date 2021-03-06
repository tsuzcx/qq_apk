package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_PAY.MiniAppMidasPay.StMiniCheckOfferIdRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppCheckOfferIdServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_ERR_MSG = "key_err_msg";
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_EXTENDINFO = "key_extendinfo";
  public static final String KEY_FIRST_REFER = "key_first_refer";
  public static final String KEY_FIRST_VIA = "key_first_via";
  public static final String KEY_MINI_APPID = "key_appid";
  public static final String KEY_OFFER_ID = "key_offer_id";
  public static final String KEY_RESULT = "key_result";
  public static final String TAG = "MiniAppCheckOfferIdServlet";
  
  public MiniAppCheckOfferIdServlet()
  {
    this.observerId = 1021;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    MiniAppMidasPay.StMiniCheckOfferIdRsp localStMiniCheckOfferIdRsp = new MiniAppMidasPay.StMiniCheckOfferIdRsp();
    localStMiniCheckOfferIdRsp.mergeFrom(paramArrayOfByte);
    if (localStMiniCheckOfferIdRsp.result != null)
    {
      if (localStMiniCheckOfferIdRsp.extInfo != null) {
        paramBundle.putByteArray("key_extendinfo", localStMiniCheckOfferIdRsp.extInfo.toByteArray());
      }
      if (localStMiniCheckOfferIdRsp.firstRefer != null) {
        paramBundle.putString("key_first_refer", localStMiniCheckOfferIdRsp.firstRefer.get());
      }
      if (localStMiniCheckOfferIdRsp.firstVia != null) {
        paramBundle.putString("key_first_via", localStMiniCheckOfferIdRsp.firstVia.get());
      }
      paramBundle.putInt("key_result", localStMiniCheckOfferIdRsp.result.get());
      notifyObserver(paramIntent, 1021, true, paramBundle, MiniAppObserver.class);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("onProcessData. result = ");
      paramArrayOfByte.append(localStMiniCheckOfferIdRsp.result);
      QLog.e("MiniAppCheckOfferIdServlet", 2, paramArrayOfByte.toString());
    }
    notifyObserver(paramIntent, 1021, false, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject2 = paramIntent.getStringExtra("key_appid");
    String str = paramIntent.getStringExtra("key_offer_id");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    int i = paramIntent.getIntExtra("key_index", -1);
    if (arrayOfByte != null)
    {
      localObject1 = new COMM.StCommonExt();
      try
      {
        ((COMM.StCommonExt)localObject1).mergeFrom(arrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniAppCheckOfferIdServlet", 2, "onSend. mergeFrom exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    else
    {
      localObject1 = null;
    }
    localObject2 = new CheckOfferIdRequest((COMM.StCommonExt)localObject1, (String)localObject2, str).encode(paramIntent, i, getTraceId());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_pay.MiniCheckOfferId");
    paramPacket.putSendData(WupUtil.a((byte[])localObject1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onSend. intent: ");
      ((StringBuilder)localObject1).append(paramIntent.toString());
      QLog.d("MiniAppCheckOfferIdServlet", 2, ((StringBuilder)localObject1).toString());
    }
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppCheckOfferIdServlet
 * JD-Core Version:    0.7.0.1
 */