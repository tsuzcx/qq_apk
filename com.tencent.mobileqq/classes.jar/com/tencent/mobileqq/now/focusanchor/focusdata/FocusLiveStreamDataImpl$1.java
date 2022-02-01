package com.tencent.mobileqq.now.focusanchor.focusdata;

import com.tencent.mobileqq.now.focusanchor.focousinterface.FocusLiveStreamListener;
import com.tencent.mobileqq.now.netchannel.websso.IChannelListener;
import com.tencent.mobileqq.now.nowqqlivefocus.NowQQLiveFocusProto.AnchorInfo;
import com.tencent.mobileqq.now.nowqqlivefocus.NowQQLiveFocusProto.GetAnchorOnline1Rsp;
import com.tencent.mobileqq.now.nowqqlivefocus.NowQQLiveFocusProto.RetInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class FocusLiveStreamDataImpl$1
  implements IChannelListener
{
  FocusLiveStreamDataImpl$1(FocusLiveStreamDataImpl paramFocusLiveStreamDataImpl, FocusLiveStreamListener paramFocusLiveStreamListener) {}
  
  public void a(int paramInt, String paramString)
  {
    FocusLiveStreamDataImpl.a(this.jdField_a_of_type_ComTencentMobileqqNowFocusanchorFocusdataFocusLiveStreamDataImpl, false);
    FocusLiveStreamDataImpl.b(this.jdField_a_of_type_ComTencentMobileqqNowFocusanchorFocusdataFocusLiveStreamDataImpl, true);
    this.jdField_a_of_type_ComTencentMobileqqNowFocusanchorFocusdataFocusLiveStreamDataImpl.a(this.jdField_a_of_type_ComTencentMobileqqNowFocusanchorFocousinterfaceFocusLiveStreamListener);
    if (QLog.isColorLevel()) {
      QLog.d("FocusLiveStreamDataImpl", 2, "Focus cmd:28679 sub cmd:2 errCode:" + paramInt + " msg:" + paramString);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    try
    {
      FocusLiveStreamDataImpl.a(this.jdField_a_of_type_ComTencentMobileqqNowFocusanchorFocusdataFocusLiveStreamDataImpl, false);
      FocusLiveStreamDataImpl.b(this.jdField_a_of_type_ComTencentMobileqqNowFocusanchorFocusdataFocusLiveStreamDataImpl, false);
      Object localObject1 = new NowQQLiveFocusProto.GetAnchorOnline1Rsp();
      ((NowQQLiveFocusProto.GetAnchorOnline1Rsp)localObject1).mergeFrom(paramArrayOfByte);
      Object localObject2 = ((NowQQLiveFocusProto.GetAnchorOnline1Rsp)localObject1).anchor_info.get();
      if (QLog.isColorLevel()) {
        QLog.d("FocusLiveStreamDataImpl", 2, "Focus cmd:28679 sub cmd:2 anchorInfoList:" + ((List)localObject2).size() + " rsp code:" + ((NowQQLiveFocusProto.GetAnchorOnline1Rsp)localObject1).ret_info.err_code + " msg:" + ((NowQQLiveFocusProto.GetAnchorOnline1Rsp)localObject1).ret_info.err_msg);
      }
      paramArrayOfByte = new ArrayList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (NowQQLiveFocusProto.AnchorInfo)((Iterator)localObject1).next();
        NowQQLiveAnchorInfo localNowQQLiveAnchorInfo = new NowQQLiveAnchorInfo();
        localNowQQLiveAnchorInfo.a(((NowQQLiveFocusProto.AnchorInfo)localObject2).uin.get());
        localNowQQLiveAnchorInfo.d(((NowQQLiveFocusProto.AnchorInfo)localObject2).anchor_logo_url.get());
        localNowQQLiveAnchorInfo.e(((NowQQLiveFocusProto.AnchorInfo)localObject2).audience_sum.get());
        localNowQQLiveAnchorInfo.b(((NowQQLiveFocusProto.AnchorInfo)localObject2).jump_url.get());
        localNowQQLiveAnchorInfo.c(((NowQQLiveFocusProto.AnchorInfo)localObject2).nick_name.get());
        localNowQQLiveAnchorInfo.c(((NowQQLiveFocusProto.AnchorInfo)localObject2).room_id.get());
        localNowQQLiveAnchorInfo.e(((NowQQLiveFocusProto.AnchorInfo)localObject2).room_name.get());
        localNowQQLiveAnchorInfo.d(((NowQQLiveFocusProto.AnchorInfo)localObject2).start_time.get());
        localNowQQLiveAnchorInfo.b(((NowQQLiveFocusProto.AnchorInfo)localObject2).user_type.get());
        localNowQQLiveAnchorInfo.a(((NowQQLiveFocusProto.AnchorInfo)localObject2).type.get());
        localNowQQLiveAnchorInfo.a(((NowQQLiveFocusProto.AnchorInfo)localObject2).cover_url.get());
        paramArrayOfByte.add(localNowQQLiveAnchorInfo);
        if (QLog.isColorLevel()) {
          QLog.d("FocusLiveStreamDataImpl", 2, "Focus cmd:28679 sub cmd:2 nick_name:" + localNowQQLiveAnchorInfo.b() + " jump_url:" + localNowQQLiveAnchorInfo.a() + " anchor_logo_url: " + localNowQQLiveAnchorInfo.c() + " anchorInfo.jump_url.get():" + ((NowQQLiveFocusProto.AnchorInfo)localObject2).jump_url.get());
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqNowFocusanchorFocousinterfaceFocusLiveStreamListener.a(paramArrayOfByte);
    }
    catch (Exception paramArrayOfByte)
    {
      FocusLiveStreamDataImpl.a(this.jdField_a_of_type_ComTencentMobileqqNowFocusanchorFocusdataFocusLiveStreamDataImpl, false);
      FocusLiveStreamDataImpl.b(this.jdField_a_of_type_ComTencentMobileqqNowFocusanchorFocusdataFocusLiveStreamDataImpl, true);
      this.jdField_a_of_type_ComTencentMobileqqNowFocusanchorFocusdataFocusLiveStreamDataImpl.a(this.jdField_a_of_type_ComTencentMobileqqNowFocusanchorFocousinterfaceFocusLiveStreamListener);
      if (QLog.isColorLevel()) {
        QLog.d("FocusLiveStreamDataImpl", 2, "Focus cmd:28679 sub cmd:2 Exception:" + paramArrayOfByte.getMessage());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.focusanchor.focusdata.FocusLiveStreamDataImpl.1
 * JD-Core Version:    0.7.0.1
 */