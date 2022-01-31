package com.tencent.mobileqq.profile.PersonalityLabel;

import agtd;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForMedalNews;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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
  public PersonalityLabelHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static void a(Activity paramActivity, String paramString, QQAppInterface paramQQAppInterface, PersonalityLabel paramPersonalityLabel, ProfileCardInfo paramProfileCardInfo)
  {
    byte[] arrayOfByte = PersonalityLabel.convertToBytes(paramPersonalityLabel);
    paramActivity.runOnUiThread(new agtd(paramString, paramQQAppInterface, paramProfileCardInfo, arrayOfByte));
    paramActivity = (FriendsManager)paramQQAppInterface.getManager(50);
    paramString = paramActivity.a(paramString);
    if (paramString != null)
    {
      paramString.vPersonalityLabelV2 = arrayOfByte;
      paramString.personalityLabel = paramPersonalityLabel;
      paramActivity.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabel,update card");
      }
    }
  }
  
  private void a(String paramString1, String paramString2, long paramLong)
  {
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, 0, new int[] { -2060 });
    MessageRecord localMessageRecord;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (localMessageRecord != null)
        {
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
        }
      }
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, 0, new int[] { -2062 });
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForMedalNews)))
          {
            MessageForMedalNews localMessageForMedalNews = (MessageForMedalNews)localMessageRecord;
            if (localMessageForMedalNews.ts > paramLong) {
              if (QLog.isColorLevel()) {
                QLog.i("PersonalityLabelHandler", 2, "insertPLNewsMsg find newer medalNews:" + localMessageForMedalNews.ts + " " + paramLong);
              }
            }
          }
        }
      }
    }
    do
    {
      return;
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
      break;
      localObject = MessageRecordFactory.a(-2060);
      paramLong = MessageCache.a();
      ((MessageRecord)localObject).init(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString2, paramString2, paramString1, paramLong, -2060, 0, paramLong);
      ((MessageRecord)localObject).isread = true;
    } while (MessageHandlerUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject, false));
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject, ((MessageRecord)localObject).selfuin);
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelHandler", 2, "handleDeleteLabel");
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(3, false, null);
      return;
    }
    oidb_0x8f1.RspBody localRspBody = new oidb_0x8f1.RspBody();
    int i = a(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("key_uin", "");
    long l = paramToServiceMsg.extraData.getLong("label_id", 0L);
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabelPhotos : result = " + i + ", uin = " + paramFromServiceMsg);
    }
    if (i == 0)
    {
      a(3, true, new Object[] { paramFromServiceMsg, Long.valueOf(l), PersonalityLabelInfo.convertFromPb((PersonalityTagComm.LabelInfo)localRspBody.msg_label_info.get()), Integer.valueOf(localRspBody.uint32_complete_flag.get()), localRspBody.bytes_label_cookie.get().toByteArray() });
      return;
    }
    a(3, false, new Object[] { paramFromServiceMsg, Long.valueOf(l), null, null, null });
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelHandler", 2, "handleZan");
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(4, false, null);
      return;
    }
    int i = a(paramFromServiceMsg, paramObject, new oidb_0x90c.RspBody());
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("key_uin", "");
    long l1 = paramToServiceMsg.extraData.getLong("label_id", 0L);
    long l2 = paramToServiceMsg.extraData.getLong("photo_id", 0L);
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder().append("handleDeletePhoto, result==0 ");
      if (i == 0)
      {
        bool = true;
        QLog.i("PersonalityLabelHandler", 2, bool + "," + paramFromServiceMsg + "," + l2 + "," + l1);
      }
    }
    else
    {
      if (i != 0) {
        break label188;
      }
    }
    label188:
    for (boolean bool = true;; bool = false)
    {
      a(4, bool, new Object[] { paramFromServiceMsg, Long.valueOf(l1), Long.valueOf(l2) });
      return;
      bool = false;
      break;
    }
  }
  
  protected Class a()
  {
    return PersonalityLabelObserver.class;
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelHandler", 2, "deleteLabel, labelId = " + paramLong);
    }
    oidb_0x8f3.ReqBody localReqBody = new oidb_0x8f3.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong));
    localReqBody.rpt_uint64_labels.set(localArrayList);
    b(a("OidbSvc.0x8f3", 2291, 0, localReqBody.toByteArray()));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("OidbSvc.0x8f0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("OidbSvc.0x91d".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x909".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x90c".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8f3".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        b();
        return;
      }
    } while (!"OidbSvc.0x8f1".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()));
    d(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelHandler", 2, "getPersonalityLabel:" + paramString);
    }
    Object localObject = new cmd0x8f0.ReqBody();
    ((cmd0x8f0.ReqBody)localObject).uint64_req_uin.set(Long.valueOf(paramString).longValue());
    ((cmd0x8f0.ReqBody)localObject).uint32_req_digest.set(paramInt);
    localObject = a("OidbSvc.0x8f0", 2288, 0, ((cmd0x8f0.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("key_uin", paramString);
    ((ToServiceMsg)localObject).extraData.putInt("flag", paramInt);
    ((ToServiceMsg)localObject).extraData.putBoolean("req_pb_protocol_flag", true);
    a((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelHandler", 2, "getPersonalityLabelNews uin:" + paramString + " ts:" + paramLong);
    }
    Object localObject = new cmd0x91d.ReqBody();
    ((cmd0x91d.ReqBody)localObject).uint64_req_uin.set(Long.valueOf(paramString).longValue());
    ((cmd0x91d.ReqBody)localObject).uint64_last_time.set((int)paramLong);
    localObject = a("OidbSvc.0x91d", 2333, 0, ((cmd0x91d.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("key_uin", paramString);
    ((ToServiceMsg)localObject).extraData.putLong("key_timestamp", paramLong);
    ((ToServiceMsg)localObject).extraData.putBoolean("req_pb_protocol_flag", true);
    a((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelHandler", 2, "getPersonalityLabelPhotos : uin = " + paramString + ", labelId = " + paramLong + ", count = " + paramInt + ", cookie = " + paramArrayOfByte);
    }
    oidb_0x8f1.ReqBody localReqBody = new oidb_0x8f1.ReqBody();
    localReqBody.uint64_req_uin.set(Long.valueOf(paramString).longValue());
    localReqBody.uint64_label_id.set(paramLong);
    localReqBody.uint32_req_num.set(paramInt);
    if (paramArrayOfByte != null) {
      localReqBody.bytes_label_cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    paramArrayOfByte = a("OidbSvc.0x8f1", 2289, 0, localReqBody.toByteArray());
    paramArrayOfByte.extraData.putString("key_uin", paramString);
    paramArrayOfByte.extraData.putLong("label_id", paramLong);
    b(paramArrayOfByte);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelHandler", 2, "deletePhoto, uin = " + paramString + ", labelId = " + paramLong1 + ", photoId = " + paramLong2);
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        Object localObject;
        ArrayList localArrayList;
        localNumberFormatException.printStackTrace();
      }
    }
    localObject = new oidb_0x90c.ReqBody();
    ((oidb_0x90c.ReqBody)localObject).uint64_to.set(l1);
    ((oidb_0x90c.ReqBody)localObject).uint64_labelid.set(paramLong1);
    localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong2));
    ((oidb_0x90c.ReqBody)localObject).rpt_photoids.set(localArrayList);
    localObject = a("OidbSvc.0x90c", 2316, 0, ((oidb_0x90c.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("key_uin", paramString);
    ((ToServiceMsg)localObject).extraData.putLong("label_id", paramLong1);
    ((ToServiceMsg)localObject).extraData.putLong("photo_id", paramLong2);
    b((ToServiceMsg)localObject);
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x8f0");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x91d");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x909");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x90c");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x8f3");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x8f1");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  @TargetApi(12)
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(1, false, null);
      return;
    }
    Object localObject = new cmd0x8f0.RspBody();
    int i = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("key_uin", "");
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder().append("handleGetPersonalityLabel, result==0 ");
      if (i != 0) {
        break label220;
      }
    }
    int j;
    label220:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("PersonalityLabelHandler", 2, bool + "," + paramFromServiceMsg);
      j = paramToServiceMsg.extraData.getInt("flag", 0);
      if (i != 0) {
        break;
      }
      paramToServiceMsg = PersonalityLabel.convertFromPb((cmd0x8f0.RspBody)localObject);
      paramObject = PersonalityLabel.convertToBytes(paramToServiceMsg);
      localObject = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      Card localCard = ((FriendsManager)localObject).a(paramFromServiceMsg);
      if (localCard != null)
      {
        localCard.vPersonalityLabelV2 = paramObject;
        localCard.personalityLabel = paramToServiceMsg;
        ((FriendsManager)localObject).a(localCard);
        if (QLog.isColorLevel()) {
          QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabel,update card");
        }
      }
      a(1, true, new Object[] { paramFromServiceMsg, paramToServiceMsg, paramObject, Integer.valueOf(j) });
      return;
    }
    a(1, false, new Object[] { paramFromServiceMsg, null, null, Integer.valueOf(j) });
  }
  
  public void b(String paramString, long paramLong)
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
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    paramString = new oidb_0x909.ReqBody();
    paramString.uint64_to.set(l1);
    paramString.uint64_labelid.set(paramLong);
    paramString.int32_count.set(1);
    b(a("OidbSvc.0x909", 2313, 0, paramString.toByteArray()));
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    label81:
    label248:
    label254:
    do
    {
      FriendsManager localFriendsManager;
      do
      {
        for (;;)
        {
          return;
          cmd0x91d.RspBody localRspBody = new cmd0x91d.RspBody();
          int i = a(paramFromServiceMsg, paramObject, localRspBody);
          paramObject = paramToServiceMsg.extraData.getString("key_uin", "0");
          long l2 = paramToServiceMsg.extraData.getLong("key_timestamp", 0L);
          boolean bool;
          long l1;
          if (QLog.isColorLevel())
          {
            paramToServiceMsg = new StringBuilder().append("handleGetPersonalityLabelNews, result==0 ");
            if (i == 0)
            {
              bool = true;
              QLog.i("PersonalityLabelHandler", 2, bool + "," + paramObject);
            }
          }
          else
          {
            localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
            paramFromServiceMsg = localFriendsManager.a(paramObject);
            paramToServiceMsg = paramFromServiceMsg;
            if (paramFromServiceMsg == null)
            {
              paramToServiceMsg = new ExtensionInfo();
              paramToServiceMsg.uin = paramObject;
            }
            paramToServiceMsg.lastPullPLNewsTimestamp = (System.currentTimeMillis() / 1000L);
            if (i != 0) {
              break label506;
            }
            if (!localRspBody.uint64_last_time.has()) {
              break label248;
            }
            l1 = localRspBody.uint64_last_time.get();
            if ((l1 > l2) && (localRspBody.msg_update_info.has())) {
              break label257;
            }
            if (l2 < l1) {
              break label254;
            }
            l1 = l2;
          }
          for (;;)
          {
            paramToServiceMsg.latestPLUpdateTimestamp = l1;
            localFriendsManager.a(paramToServiceMsg);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabelNews no update");
            return;
            bool = false;
            break label81;
            l1 = 0L;
            break label183;
          }
          paramToServiceMsg.lastPLNewsTimestamp = l1;
          paramToServiceMsg.latestPLUpdateTimestamp = l1;
          localFriendsManager.a(paramToServiceMsg);
          if (localRspBody.msg_update_info.has())
          {
            paramToServiceMsg = (cmd0x91d.LabelUpdateInfo)localRspBody.msg_update_info.get();
            if ((paramToServiceMsg == null) || (!paramToServiceMsg.msg_label_info.has())) {
              break label490;
            }
            paramFromServiceMsg = paramToServiceMsg.msg_label_info;
            if (paramToServiceMsg.uint32_upload_photos.has()) {
              paramToServiceMsg.uint32_upload_photos.get();
            }
            paramToServiceMsg = PersonalityLabelInfo.convertFromPb(paramFromServiceMsg);
            paramFromServiceMsg = new JSONObject();
          }
          try
          {
            paramFromServiceMsg.put("text", paramToServiceMsg.text);
            paramFromServiceMsg.put("bgColor", paramToServiceMsg.bgColor);
            paramFromServiceMsg.put("ts", l1);
            if (paramToServiceMsg.getSize() > 0) {}
            for (paramToServiceMsg = ((PersonalityLabelPhoto)paramToServiceMsg.personalityLabelPhotos.get(0)).get128SizeUrl() + Constants.d;; paramToServiceMsg = "")
            {
              paramFromServiceMsg.put("cover", paramToServiceMsg);
              if (QLog.isColorLevel()) {
                QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabelNews insert gray msg");
              }
              a(paramFromServiceMsg.toString(), paramObject, l1);
              return;
              paramToServiceMsg = null;
              break;
            }
            if (!QLog.isColorLevel()) {}
          }
          catch (JSONException paramToServiceMsg) {}
        }
        QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabelNews", paramToServiceMsg);
        return;
      } while (!QLog.isColorLevel());
      QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabelNews update, no data");
      return;
      localFriendsManager.a(paramToServiceMsg);
    } while (!QLog.isColorLevel());
    label183:
    label490:
    label506:
    QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabelNews failed");
    label257:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelHandler
 * JD-Core Version:    0.7.0.1
 */