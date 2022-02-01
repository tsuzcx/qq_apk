package com.tencent.mobileqq.nearby.profilecard;

import android.os.Bundle;
import appoint.define.appoint_define.PublisherInfo;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class NearbyProfileFragment$7
  extends ProtoUtils.TroopProtocolObserver
{
  NearbyProfileFragment$7(NearbyProfileFragment paramNearbyProfileFragment) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      paramBundle = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramBundle.mergeFrom((byte[])paramArrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handle_oidb_0x66b_0|oidb_sso parseFrom byte ");
          ((StringBuilder)localObject).append(paramArrayOfByte.toString());
          QLog.d("NearbyProfileFragment", 2, ((StringBuilder)localObject).toString());
        }
      }
      if (paramBundle.uint32_result.has())
      {
        paramInt = paramBundle.uint32_result.get();
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("handle_oidb_0x66b_0|oidb_sso.OIDBSSOPkg.result ");
          paramArrayOfByte.append(paramInt);
          QLog.d("NearbyProfileFragment", 2, paramArrayOfByte.toString());
        }
      }
      Object localObject = new Oidb_0x66b.RspBody();
      try
      {
        ((Oidb_0x66b.RspBody)localObject).mergeFrom(paramBundle.bytes_bodybuffer.get().toByteArray());
        paramArrayOfByte = new NearbyMyTabCard();
        if (((Oidb_0x66b.RspBody)localObject).rpt_msg_vistor_info.has())
        {
          paramArrayOfByte.visitors.clear();
          paramBundle = ((Oidb_0x66b.RspBody)localObject).rpt_msg_vistor_info.get().iterator();
          while (paramBundle.hasNext())
          {
            localObject = (appoint_define.PublisherInfo)paramBundle.next();
            if (localObject != null)
            {
              localObject = StrangerInfo.convertFrom((appoint_define.PublisherInfo)localObject);
              if (localObject != null) {
                paramArrayOfByte.visitors.add(localObject);
              }
            }
          }
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("handleGetNearbyMyTab visitor info is: ");
            paramBundle.append(paramArrayOfByte.visitors.toString());
            QLog.i("NearbyProfileFragment", 2, paramBundle.toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.i("NearbyProfileFragment", 2, "handleGetNearbyMyTay has no visitor info.");
        }
        paramArrayOfByte = NearbyProfileFragment.b(this.a, paramArrayOfByte.visitors);
        NearbyProfileFragment.a(this.a, paramArrayOfByte);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("handle_oidb_0x66b_0|oidb_sso parseFrom byte ");
          paramBundle.append(paramArrayOfByte.toString());
          QLog.d("NearbyProfileFragment", 2, paramBundle.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment.7
 * JD-Core Version:    0.7.0.1
 */