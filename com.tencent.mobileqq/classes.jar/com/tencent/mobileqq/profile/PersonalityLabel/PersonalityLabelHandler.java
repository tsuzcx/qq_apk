package com.tencent.mobileqq.profile.PersonalityLabel;

import android.annotation.TargetApi;
import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForPLNews;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.label.comm.PersonalityTagComm.LabelInfo;
import tencent.im.oidb.cmd0x8f0.cmd0x8f0.ReqBody;
import tencent.im.oidb.cmd0x8f0.cmd0x8f0.RspBody;
import tencent.im.oidb.cmd0x8f1.oidb_0x8f1.ReqBody;
import tencent.im.oidb.cmd0x8f1.oidb_0x8f1.RspBody;
import tencent.im.oidb.cmd0x8f3.oidb_0x8f3.ReqBody;
import tencent.im.oidb.cmd0x909.oidb_0x909.ReqBody;
import tencent.im.oidb.cmd0x90c.oidb_0x90c.ReqBody;
import tencent.im.oidb.cmd0x90c.oidb_0x90c.RspBody;
import tencent.im.oidb.cmd0x91d.cmd0x91d.LabelUpdateInfo;
import tencent.im.oidb.cmd0x91d.cmd0x91d.ReqBody;
import tencent.im.oidb.cmd0x91d.cmd0x91d.RspBody;

public class PersonalityLabelHandler
  extends BusinessHandler
{
  private QQAppInterface a;
  
  public PersonalityLabelHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelHandler", 2, "handleDeleteLabel");
    }
  }
  
  private void a(String paramString1, String paramString2, long paramLong)
  {
    BeancurdManager localBeancurdManager = (BeancurdManager)this.a.getManager(QQManagerFactory.BEANCURD_MANAGER);
    Object localObject = localBeancurdManager.b(paramString2, 0, 3);
    if (localObject != null)
    {
      if (((BeancurdMsg)localObject).originTime < paramLong) {}
    }
    else {
      do
      {
        i = 0;
        break;
        localObject = this.a.getMessageFacade().a(paramString2, 0, new int[] { -2060 });
      } while ((localObject != null) && (((List)localObject).size() > 0) && (((MessageForPLNews)((List)localObject).get(((List)localObject).size() - 1)).ts >= paramLong));
    }
    int i = 1;
    if (i != 0) {
      try
      {
        localObject = new BeancurdMsg();
        ((BeancurdMsg)localObject).frienduin = paramString2;
        ((BeancurdMsg)localObject).busiid = 3;
        ((BeancurdMsg)localObject).isNeedDelHistory = true;
        ((BeancurdMsg)localObject).ispush = false;
        ((BeancurdMsg)localObject).originTime = paramLong;
        ((BeancurdMsg)localObject).startTime = MessageCache.c();
        ((BeancurdMsg)localObject).validTime = 2592000L;
        ((BeancurdMsg)localObject).buffer = paramString1;
        localBeancurdManager.a((BeancurdMsg)localObject);
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("handleAIOQQStoryFeedMessage: parse data to MessageRecord has error. Message: ");
          paramString2.append(paramString1.getMessage());
          QLog.i("PersonalityLabelHandler", 2, paramString2.toString());
        }
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      oidb_0x8f1.RspBody localRspBody = new oidb_0x8f1.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("key_uin", "");
      long l = paramToServiceMsg.extraData.getLong("label_id", 0L);
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleGetPersonalityLabelPhotos : result = ");
        paramToServiceMsg.append(i);
        paramToServiceMsg.append(", uin = ");
        paramToServiceMsg.append(paramFromServiceMsg);
        QLog.i("PersonalityLabelHandler", 2, paramToServiceMsg.toString());
      }
      if (i == 0)
      {
        notifyUI(3, true, new Object[] { paramFromServiceMsg, Long.valueOf(l), PersonalityLabelInfo.convertFromPb((PersonalityTagComm.LabelInfo)localRspBody.msg_label_info.get()), Integer.valueOf(localRspBody.uint32_complete_flag.get()), localRspBody.bytes_label_cookie.get().toByteArray() });
        return;
      }
      notifyUI(3, false, new Object[] { paramFromServiceMsg, Long.valueOf(l), null, null, null });
      return;
    }
    notifyUI(3, false, null);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelHandler", 2, "handleZan");
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_0x90c.RspBody());
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("key_uin", "");
      long l1 = paramToServiceMsg.extraData.getLong("label_id", 0L);
      long l2 = paramToServiceMsg.extraData.getLong("photo_id", 0L);
      boolean bool;
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleDeletePhoto, result==0 ");
        if (i == 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramToServiceMsg.append(bool);
        paramToServiceMsg.append(",");
        paramToServiceMsg.append(paramFromServiceMsg);
        paramToServiceMsg.append(",");
        paramToServiceMsg.append(l2);
        paramToServiceMsg.append(",");
        paramToServiceMsg.append(l1);
        QLog.i("PersonalityLabelHandler", 2, paramToServiceMsg.toString());
      }
      if (i == 0) {
        bool = true;
      } else {
        bool = false;
      }
      notifyUI(4, bool, new Object[] { paramFromServiceMsg, Long.valueOf(l1), Long.valueOf(l2) });
      return;
    }
    notifyUI(4, false, null);
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteLabel, labelId = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.i("PersonalityLabelHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_0x8f3.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong));
    ((oidb_0x8f3.ReqBody)localObject).rpt_uint64_labels.set(localArrayList);
    sendPbReq(makeOIDBPkg("OidbSvc.0x8f3", 2291, 0, ((oidb_0x8f3.ReqBody)localObject).toByteArray()));
  }
  
  @TargetApi(12)
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      cmd0x8f0.RspBody localRspBody = new cmd0x8f0.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("key_uin", "");
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("handleGetPersonalityLabel, result==0 ");
        boolean bool;
        if (i == 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramObject.append(bool);
        paramObject.append(",");
        paramObject.append(paramFromServiceMsg);
        QLog.i("PersonalityLabelHandler", 2, paramObject.toString());
      }
      int j = paramToServiceMsg.extraData.getInt("flag", 0);
      if (i == 0)
      {
        paramToServiceMsg = ProfilePersonalityLabelInfo.convertFromPb(localRspBody);
        notifyUI(1, true, new Object[] { paramFromServiceMsg, paramToServiceMsg, ProfilePersonalityLabelInfo.convertToBytes(paramToServiceMsg), Integer.valueOf(j) });
        return;
      }
      notifyUI(1, false, new Object[] { paramFromServiceMsg, null, null, Integer.valueOf(j) });
      return;
    }
    notifyUI(1, false, null);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getPersonalityLabel:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("PersonalityLabelHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new cmd0x8f0.ReqBody();
    ((cmd0x8f0.ReqBody)localObject).uint64_req_uin.set(Long.valueOf(paramString).longValue());
    ((cmd0x8f0.ReqBody)localObject).uint32_req_digest.set(paramInt);
    localObject = makeOIDBPkg("OidbSvc.0x8f0", 2288, 0, ((cmd0x8f0.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("key_uin", paramString);
    ((ToServiceMsg)localObject).extraData.putInt("flag", paramInt);
    ((ToServiceMsg)localObject).extraData.putBoolean("req_pb_protocol_flag", true);
    send((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelHandler", 2, "zan");
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    paramString = new oidb_0x909.ReqBody();
    paramString.uint64_to.set(l1);
    paramString.uint64_labelid.set(paramLong);
    paramString.int32_count.set(1);
    sendPbReq(makeOIDBPkg("OidbSvc.0x909", 2313, 0, paramString.toByteArray()));
  }
  
  public void a(String paramString, long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getPersonalityLabelPhotos : uin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", labelId = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", count = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", cookie = ");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      QLog.i("PersonalityLabelHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_0x8f1.ReqBody();
    ((oidb_0x8f1.ReqBody)localObject).uint64_req_uin.set(Long.valueOf(paramString).longValue());
    ((oidb_0x8f1.ReqBody)localObject).uint64_label_id.set(paramLong);
    ((oidb_0x8f1.ReqBody)localObject).uint32_req_num.set(paramInt);
    if (paramArrayOfByte != null) {
      ((oidb_0x8f1.ReqBody)localObject).bytes_label_cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    paramArrayOfByte = makeOIDBPkg("OidbSvc.0x8f1", 2289, 0, ((oidb_0x8f1.ReqBody)localObject).toByteArray());
    paramArrayOfByte.extraData.putString("key_uin", paramString);
    paramArrayOfByte.extraData.putLong("label_id", paramLong);
    sendPbReq(paramArrayOfByte);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getPersonalityLabelNews uin:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" ts:");
      ((StringBuilder)localObject).append(paramLong1);
      QLog.i("PersonalityLabelHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new cmd0x91d.ReqBody();
    ((cmd0x91d.ReqBody)localObject).uint64_req_uin.set(Long.valueOf(paramString).longValue());
    ((cmd0x91d.ReqBody)localObject).uint64_last_time.set((int)paramLong1);
    localObject = makeOIDBPkg("OidbSvc.0x91d", 2333, 0, ((cmd0x91d.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("key_uin", paramString);
    ((ToServiceMsg)localObject).extraData.putLong("key_timestamp", paramLong1);
    ((ToServiceMsg)localObject).extraData.putLong("latestPLUpdateTimestamp", paramLong2);
    ((ToServiceMsg)localObject).extraData.putBoolean("req_pb_protocol_flag", true);
    send((ToServiceMsg)localObject);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject;
    int i;
    long l3;
    long l1;
    FriendsManager localFriendsManager;
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      localObject = new cmd0x91d.RspBody();
      i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      paramObject = paramToServiceMsg.extraData.getString("key_uin", "0");
      l3 = paramToServiceMsg.extraData.getLong("key_timestamp", 0L);
      l1 = paramToServiceMsg.extraData.getLong("latestPLUpdateTimestamp", 0L);
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleGetPersonalityLabelNews, result==0 ");
        boolean bool;
        if (i == 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramToServiceMsg.append(bool);
        paramToServiceMsg.append(",");
        paramToServiceMsg.append(paramObject);
        QLog.i("PersonalityLabelHandler", 2, paramToServiceMsg.toString());
      }
      localFriendsManager = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
      paramFromServiceMsg = localFriendsManager.x(paramObject);
      paramToServiceMsg = paramFromServiceMsg;
      if (paramFromServiceMsg == null)
      {
        paramToServiceMsg = new ExtensionInfo();
        paramToServiceMsg.uin = paramObject;
      }
      paramToServiceMsg.lastPullPLNewsTimestamp = (System.currentTimeMillis() / 1000L);
      if (i == 0)
      {
        if (((cmd0x91d.RspBody)localObject).uint64_last_time.has()) {
          l1 = ((cmd0x91d.RspBody)localObject).uint64_last_time.get();
        } else {
          l1 = 0L;
        }
        if ((l1 > l3) && (((cmd0x91d.RspBody)localObject).msg_update_info.has()))
        {
          paramToServiceMsg.lastPLNewsTimestamp = l1;
          paramToServiceMsg.latestPLUpdateTimestamp = l1;
          localFriendsManager.a(paramToServiceMsg);
          if (((cmd0x91d.RspBody)localObject).msg_update_info.has()) {
            paramToServiceMsg = (cmd0x91d.LabelUpdateInfo)((cmd0x91d.RspBody)localObject).msg_update_info.get();
          } else {
            paramToServiceMsg = null;
          }
          if ((paramToServiceMsg != null) && (paramToServiceMsg.msg_label_info.has()))
          {
            paramFromServiceMsg = paramToServiceMsg.msg_label_info;
            if (paramToServiceMsg.uint32_upload_photos.has()) {
              paramToServiceMsg.uint32_upload_photos.get();
            }
            paramToServiceMsg = PersonalityLabelInfo.convertFromPb(paramFromServiceMsg);
            paramFromServiceMsg = new JSONObject();
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg.put("text", paramToServiceMsg.text);
        paramFromServiceMsg.put("bgColor", paramToServiceMsg.bgColor);
        paramFromServiceMsg.put("ts", l1);
        if (paramToServiceMsg.getSize() <= 0) {
          break label626;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(((PersonalityLabelPhoto)paramToServiceMsg.personalityLabelPhotos.get(0)).get128SizeUrl());
        ((StringBuilder)localObject).append(Constants.d);
        paramToServiceMsg = ((StringBuilder)localObject).toString();
        paramFromServiceMsg.put("cover", paramToServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabelNews insert gray msg");
        }
        a(paramFromServiceMsg.toString(), paramObject, l1);
        return;
      }
      catch (JSONException paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabelNews", paramToServiceMsg);
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabelNews update, no data");
        return;
        long l2 = l1;
        if (l3 >= l1) {
          l2 = l3;
        }
        paramToServiceMsg.latestPLUpdateTimestamp = l2;
        localFriendsManager.a(paramToServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabelNews no update");
        }
        return;
        if (i == 1206)
        {
          paramToServiceMsg.lastPLNewsTimestamp = l1;
          paramToServiceMsg.latestPLUpdateTimestamp = l1;
          localFriendsManager.a(paramToServiceMsg);
          if (QLog.isColorLevel())
          {
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("handleGetPersonalityLabelNews 1206 ");
            paramToServiceMsg.append(l1);
            QLog.i("PersonalityLabelHandler", 2, paramToServiceMsg.toString());
          }
        }
        else
        {
          localFriendsManager.a(paramToServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabelNews failed");
          }
        }
      }
      return;
      label626:
      paramToServiceMsg = "";
    }
  }
  
  public void b(String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deletePhoto, uin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", labelId = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(", photoId = ");
      localStringBuilder.append(paramLong2);
      QLog.i("PersonalityLabelHandler", 2, localStringBuilder.toString());
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
    }
    Object localObject = new oidb_0x90c.ReqBody();
    ((oidb_0x90c.ReqBody)localObject).uint64_to.set(l1);
    ((oidb_0x90c.ReqBody)localObject).uint64_labelid.set(paramLong1);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong2));
    ((oidb_0x90c.ReqBody)localObject).rpt_photoids.set(localArrayList);
    localObject = makeOIDBPkg("OidbSvc.0x90c", 2316, 0, ((oidb_0x90c.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("key_uin", paramString);
    ((ToServiceMsg)localObject).extraData.putLong("label_id", paramLong1);
    ((ToServiceMsg)localObject).extraData.putLong("photo_id", paramLong2);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x8f0");
      this.allowCmdSet.add("OidbSvc.0x91d");
      this.allowCmdSet.add("OidbSvc.0x909");
      this.allowCmdSet.add("OidbSvc.0x90c");
      this.allowCmdSet.add("OidbSvc.0x8f3");
      this.allowCmdSet.add("OidbSvc.0x8f1");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return PersonalityLabelObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("OidbSvc.0x8f0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x91d".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x909".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x90c".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x8f3".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      a();
      return;
    }
    if ("OidbSvc.0x8f1".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelHandler
 * JD-Core Version:    0.7.0.1
 */