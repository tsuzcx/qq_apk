package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.Context;
import android.os.Bundle;
import com.tencent.jungle.videohub.proto.GroupRoomManageProto.GetGameStatusByGroupCodeRsp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.groupvideo.cschannel.IODCsChannel.CsChannelObserver;
import com.tencent.mobileqq.nearby.report.IODReportTask;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;

final class GroupVideoChatAppInfo$1
  implements IODCsChannel.CsChannelObserver
{
  GroupVideoChatAppInfo$1(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, HashMap paramHashMap) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramBundle = new GroupRoomManageProto.GetGameStatusByGroupCodeRsp();
      try
      {
        paramArrayOfByte = (GroupRoomManageProto.GetGameStatusByGroupCodeRsp)paramBundle.mergeFrom(paramArrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = paramBundle;
      }
      boolean bool = QLog.isColorLevel();
      int i = 1;
      if (bool)
      {
        paramBundle = new StringBuilder();
        paramBundle.append(" room_id=");
        paramBundle.append(paramArrayOfByte.room_id.get());
        paramBundle.append(" app_type=");
        paramBundle.append(paramArrayOfByte.app_type.get());
        paramBundle.append(" game_id=");
        paramBundle.append(paramArrayOfByte.game_id.get());
        paramBundle.append(" is_group_member=");
        paramBundle.append(paramArrayOfByte.is_group_member.get());
        QLog.d("GroupVideoChatAppInfo", 2, new Object[] { "MSF.C.NetConnTag", paramBundle.toString() });
      }
      if ((paramArrayOfByte.app_type.get() > 0) && (paramArrayOfByte.is_group_member.get() == 0)) {
        bool = false;
      } else {
        bool = true;
      }
      if ("Panel".equals(this.jdField_a_of_type_JavaUtilHashMap.get("from"))) {
        paramInt = 1;
      } else if ("tipBar".equals(this.jdField_a_of_type_JavaUtilHashMap.get("from"))) {
        paramInt = 2;
      } else if ("itemBuilder".equals(this.jdField_a_of_type_JavaUtilHashMap.get("from"))) {
        paramInt = 3;
      } else {
        paramInt = 0;
      }
      paramBundle = ((IODReportTask)QRoute.api(IODReportTask.class)).setModule("QQ_chatroom_surface").setAction("click_entrance").obj1(paramInt).obj2(String.valueOf(bool));
      if (paramArrayOfByte.app_type.get() == 2) {
        paramInt = i;
      } else {
        paramInt = 0;
      }
      paramBundle.obj3(paramInt).report();
      if (!bool)
      {
        GroupVideoChatAppInfo.access$100(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
        return;
      }
      if (paramArrayOfByte.app_type.get() == 2)
      {
        GroupVideoChatAppInfo.access$200(this.jdField_a_of_type_Int, Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), paramArrayOfByte.room_id.get(), paramArrayOfByte.game_id.get());
        return;
      }
      GroupVideoChatAppInfo.access$000(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilHashMap);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("login: errorCode=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" bundle=");
    if (paramBundle == null) {
      paramBundle = "null";
    } else {
      paramBundle = paramBundle.toString();
    }
    localStringBuilder.append(paramBundle);
    localStringBuilder.append(" data=");
    localStringBuilder.append(Arrays.toString(paramArrayOfByte));
    QLog.i("GroupVideoChatAppInfo", 2, localStringBuilder.toString());
    GroupVideoChatAppInfo.access$000(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.GroupVideoChatAppInfo.1
 * JD-Core Version:    0.7.0.1
 */