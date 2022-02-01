package com.tencent.mobileqq.nearby.profilecard;

import android.os.Bundle;
import appoint.define.appoint_define.PublisherInfo;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.sso.accretion.flower_info.SFlowerInfoRsp;

class NearbyProfileDisplayTribePanel$32
  extends ProtoUtils.TroopProtocolObserver
{
  NearbyProfileDisplayTribePanel$32(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      paramBundle = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramArrayOfByte = (oidb_sso.OIDBSSOPkg)paramBundle.mergeFrom((byte[])paramArrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        paramArrayOfByte = paramBundle;
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("handle_oidb_0x66b_0|oidb_sso parseFrom byte ");
          paramArrayOfByte.append(localInvalidProtocolBufferMicroException1.toString());
          QLog.d("NearbyProfileDisplayTribePanel", 2, paramArrayOfByte.toString());
          paramArrayOfByte = paramBundle;
        }
      }
      paramBundle = new Oidb_0x66b.RspBody();
      if (paramArrayOfByte != null) {
        try
        {
          paramInt = paramArrayOfByte.uint32_result.get();
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("handle_oidb_0x66b_0|oidb_sso.OIDBSSOPkg.result ");
            ((StringBuilder)localObject1).append(paramInt);
            QLog.d("NearbyProfileDisplayTribePanel", 2, ((StringBuilder)localObject1).toString());
          }
          paramBundle.mergeFrom(paramArrayOfByte.bytes_bodybuffer.get().toByteArray());
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("handle_oidb_0x66b_0|oidb_sso parseFrom byte ");
            paramBundle.append(paramArrayOfByte.toString());
            QLog.d("NearbyProfileDisplayTribePanel", 2, paramBundle.toString());
          }
          return;
        }
      }
      Object localObject1 = new oidb_0x5eb.RspBody();
      paramArrayOfByte = new NearbyMyTabCard();
      byte[] arrayOfByte;
      if (paramBundle.bytes_rspbody_5eb.has())
      {
        arrayOfByte = paramBundle.bytes_rspbody_5eb.get().toByteArray();
        try
        {
          ((oidb_0x5eb.RspBody)localObject1).mergeFrom(arrayOfByte);
          if ((((oidb_0x5eb.RspBody)localObject1).rpt_msg_uin_data.has()) && (((oidb_0x5eb.RspBody)localObject1).rpt_msg_uin_data.size() > 0))
          {
            localObject1 = (oidb_0x5eb.UdcUinData)((oidb_0x5eb.RspBody)localObject1).rpt_msg_uin_data.get().get(0);
            paramArrayOfByte.uin = Long.valueOf(((oidb_0x5eb.UdcUinData)localObject1).uint64_uin.get());
            paramArrayOfByte.nickName = ((oidb_0x5eb.UdcUinData)localObject1).bytes_stranger_nick.get().toStringUtf8();
            paramArrayOfByte.carrier = ((oidb_0x5eb.UdcUinData)localObject1).uint32_profession.get();
            paramArrayOfByte.gender = ((oidb_0x5eb.UdcUinData)localObject1).uint32_gender.get();
            paramArrayOfByte.age = ((oidb_0x5eb.UdcUinData)localObject1).uint32_age.get();
            paramArrayOfByte.godFlag = ((oidb_0x5eb.UdcUinData)localObject1).uint32_god_flag.get();
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NewNearbyMyTab", 2, "fail to decode 5eb_rspBody", localInvalidProtocolBufferMicroException2);
          }
        }
      }
      Object localObject2;
      if (paramBundle.bytes_rspbody_gift.has())
      {
        arrayOfByte = paramBundle.bytes_rspbody_gift.get().toByteArray();
        localObject2 = new flower_info.SFlowerInfoRsp();
        try
        {
          ((flower_info.SFlowerInfoRsp)localObject2).mergeFrom(arrayOfByte);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException3)
        {
          paramArrayOfByte.giftNum = 0;
          if (QLog.isColorLevel()) {
            QLog.e("NewNearbyMyTab", 2, "fail to decode SFlowerInfoRsp", localInvalidProtocolBufferMicroException3);
          }
        }
        paramArrayOfByte.giftNum = ((flower_info.SFlowerInfoRsp)localObject2).num.get();
        this.a.jdField_a_of_type_JavaUtilList = ((flower_info.SFlowerInfoRsp)localObject2).rpt_flower_url.get();
        this.a.jdField_a_of_type_JavaLangString = ((flower_info.SFlowerInfoRsp)localObject2).flower_msg_tips.get();
        this.a.d = ((flower_info.SFlowerInfoRsp)localObject2).flower_flag.get();
      }
      if (paramBundle.rpt_msg_vistor_info.has())
      {
        paramArrayOfByte.visitors.clear();
        paramBundle = paramBundle.rpt_msg_vistor_info.get().iterator();
        while (paramBundle.hasNext())
        {
          localObject2 = (appoint_define.PublisherInfo)paramBundle.next();
          if (localObject2 != null)
          {
            localObject2 = StrangerInfo.convertFrom((appoint_define.PublisherInfo)localObject2);
            if (localObject2 != null) {
              paramArrayOfByte.visitors.add(localObject2);
            }
          }
        }
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("handleGetNearbyMyTab visitor info is: ");
          paramBundle.append(paramArrayOfByte.visitors.toString());
          QLog.i("NearbyProfileDisplayTribePanel", 2, paramBundle.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.i("NearbyProfileDisplayTribePanel", 2, "handleGetNearbyMyTay has no visitor info.");
      }
      paramArrayOfByte = NearbyProfileDisplayTribePanel.a(this.a, paramArrayOfByte.visitors);
      NearbyProfileDisplayTribePanel.a(this.a, paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.32
 * JD-Core Version:    0.7.0.1
 */