package com.tencent.mobileqq.profilecard.servlet;

import SummaryCard.ReqHead;
import SummaryCard.ReqSummaryCard;
import SummaryCard.RespHead;
import SummaryCard.RespSummaryCard;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.api.impl.ProfileProtocolServiceImpl;
import com.tencent.mobileqq.profilecard.entity.BusinessReqBuffer;
import com.tencent.mobileqq.utils.PkgTools;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.LoginSig;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.comm;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class ProfileCardServlet
  extends MSFServlet
  implements IProfileProtocolConst
{
  public static final int CMD_ID_INVALID = 0;
  public static final int CMD_ID_REQ_SUMMARY_CARD = 1;
  public static final String CMD_REQ_SUMMARY_CARD = "SummaryCard.ReqSummaryCard";
  public static final String PARAM_CMD_ID = "cmdID";
  private static final String TAG = "ProfileCardServlet";
  
  private ArrayList<byte[]> buildReqServicesBuffer(long paramLong1, long paramLong2, String paramString, ArrayList<BusinessReqBuffer> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramLong2 > 0L) && (paramArrayList != null)) {}
    label396:
    for (;;)
    {
      try
      {
        i = Integer.parseInt("5105");
        paramArrayList = paramArrayList.iterator();
        if (paramArrayList.hasNext())
        {
          BusinessReqBuffer localBusinessReqBuffer = (BusinessReqBuffer)paramArrayList.next();
          Object localObject = new SummaryCardBusiEntry.comm();
          ((SummaryCardBusiEntry.comm)localObject).ver.set(1);
          ((SummaryCardBusiEntry.comm)localObject).fromuin.set(paramLong1);
          ((SummaryCardBusiEntry.comm)localObject).touin.set(paramLong2);
          ((SummaryCardBusiEntry.comm)localObject).service.set(localBusinessReqBuffer.getBusinessType());
          ((SummaryCardBusiEntry.comm)localObject).platform.set(2);
          ((SummaryCardBusiEntry.comm)localObject).qqver.set("8.5.5.5105");
          ((SummaryCardBusiEntry.comm)localObject).build.set(i);
          int j = localBusinessReqBuffer.getBusinessType();
          if ((j == 17) || (j == 19) || (j == 18))
          {
            ((SummaryCardBusiEntry.comm)localObject).msg_login_sig.setHasFlag(true);
            ((SummaryCardBusiEntry.comm)localObject).msg_login_sig.uint32_type.set(8);
            ((SummaryCardBusiEntry.comm)localObject).msg_login_sig.uint32_appid.set(16);
            if ((!TextUtils.isEmpty(paramString)) && (!HexUtil.emptybytes.equals(paramString))) {
              ((SummaryCardBusiEntry.comm)localObject).msg_login_sig.bytes_sig.set(ByteStringMicro.copyFromUtf8(paramString));
            }
          }
          localObject = ((SummaryCardBusiEntry.comm)localObject).toByteArray();
          int k = localObject.length;
          j = 0;
          if (localBusinessReqBuffer.getBuffer() != null) {
            j = localBusinessReqBuffer.getBuffer().length;
          }
          byte[] arrayOfByte = new byte[k + 9 + j + 1];
          arrayOfByte[0] = 40;
          PkgTools.DWord2Byte(arrayOfByte, 1, k);
          PkgTools.DWord2Byte(arrayOfByte, 5, j);
          PkgTools.copyData(arrayOfByte, 9, (byte[])localObject, k);
          j = localObject.length + 9;
          if (localBusinessReqBuffer.getBuffer() == null) {
            break label396;
          }
          PkgTools.copyData(arrayOfByte, j, localBusinessReqBuffer.getBuffer(), localBusinessReqBuffer.getBuffer().length);
          j = localBusinessReqBuffer.getBuffer().length + j;
          arrayOfByte[j] = 41;
          localArrayList.add(arrayOfByte);
          continue;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ProfileCardServlet", 1, "buildReqSummaryCard fail.", localException);
        int i = 0;
        continue;
      }
      return localArrayList;
    }
  }
  
  private ReqSummaryCard buildReqSummaryCard(Intent paramIntent)
  {
    long l1 = paramIntent.getLongExtra("selfUin", 0L);
    long l2 = paramIntent.getLongExtra("targetUin", 0L);
    int i = paramIntent.getIntExtra("comeFromType", 0);
    long l3 = paramIntent.getLongExtra("qZoneFeedTimeStamp", 0L);
    byte b1 = paramIntent.getByteExtra("isFriend", (byte)0);
    long l4 = paramIntent.getLongExtra("troopCode", 0L);
    long l5 = paramIntent.getLongExtra("troopUin", 0L);
    Object localObject = paramIntent.getByteArrayExtra("qZoneSeed");
    String str1 = paramIntent.getStringExtra("searchName");
    long l6 = paramIntent.getLongExtra("getControl", 0L);
    int j = paramIntent.getIntExtra("addFriendSource", 0);
    byte[] arrayOfByte1 = paramIntent.getByteArrayExtra("secureSig");
    byte b2 = paramIntent.getByteExtra("reqMedalWall", (byte)0);
    byte b3 = paramIntent.getByteExtra("reqExtendFriend", (byte)0);
    String str2 = paramIntent.getStringExtra("loginSig");
    byte[] arrayOfByte2 = paramIntent.getByteArrayExtra("reqTemplate");
    ArrayList localArrayList1 = paramIntent.getIntegerArrayListExtra("req0x5ebList");
    ArrayList localArrayList2 = paramIntent.getParcelableArrayListExtra("reqServiceList");
    paramIntent = (Intent)localObject;
    if (localObject == null)
    {
      paramIntent = new byte[1];
      paramIntent[0] = 0;
    }
    localObject = arrayOfByte1;
    if (arrayOfByte1 == null)
    {
      localObject = new byte[1];
      localObject[0] = 0;
    }
    return new ReqSummaryCard(l2, i, l3, b1, l4, l5, paramIntent, str1, l6, j, (byte[])localObject, null, arrayOfByte2, null, buildReqServicesBuffer(l1, l2, str2, localArrayList2), 0L, 0L, null, b2, localArrayList1, (byte)1, (byte)0, b3, null, 1L);
  }
  
  private void requestSummaryCard(Intent paramIntent, Packet paramPacket)
  {
    ReqHead localReqHead = new ReqHead();
    localReqHead.iVersion = 2;
    paramIntent = buildReqSummaryCard(paramIntent);
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setServantName("SummaryCardServantObj");
    localUniPacket.setFuncName("ReqSummaryCard");
    localUniPacket.put("ReqHead", localReqHead);
    localUniPacket.put("ReqSummaryCard", paramIntent);
    paramPacket.setSSOCommand("SummaryCard.ReqSummaryCard");
    paramPacket.putSendData(localUniPacket.encode());
    paramPacket.setTimeout(30000L);
  }
  
  private void responseSummaryCard(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = null;
    Bundle localBundle = paramIntent.getExtras();
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
      paramIntent = (RespHead)decodePacket(paramFromServiceMsg, "RespHead", new RespHead());
    }
    for (paramFromServiceMsg = (RespSummaryCard)decodePacket(paramFromServiceMsg, "RespSummaryCard", new RespSummaryCard());; paramFromServiceMsg = localObject)
    {
      ProfileProtocolServiceImpl.getProfileProtocolService(getAppRuntime()).responseProfileCard(localBundle, paramIntent, paramFromServiceMsg);
      return;
      QLog.e("ProfileCardServlet", 1, String.format("responseSummaryCard fail! resultCode=%s", new Object[] { Integer.valueOf(paramFromServiceMsg.getResultCode()) }));
      paramIntent = null;
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramIntent.getIntExtra("cmdID", 0);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardServlet", 2, String.format("onReceive cmdID=%s", new Object[] { Integer.valueOf(i) }));
    }
    switch (i)
    {
    default: 
      QLog.e("ProfileCardServlet", 1, String.format("onReceive invalid command! cmdID=%s", new Object[] { Integer.valueOf(i) }));
      return;
    }
    responseSummaryCard(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("cmdID", 0);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardServlet", 2, String.format("onSend cmdID=%s", new Object[] { Integer.valueOf(i) }));
    }
    switch (i)
    {
    default: 
      QLog.e("ProfileCardServlet", 1, String.format("onSend invalid command! cmdID=%s", new Object[] { Integer.valueOf(i) }));
      return;
    }
    requestSummaryCard(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.servlet.ProfileCardServlet
 * JD-Core Version:    0.7.0.1
 */