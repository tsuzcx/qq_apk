package com.tencent.mobileqq.now.focusanchor.focusdata;

import android.text.TextUtils;
import com.tencent.mobileqq.now.focusanchor.focousinterface.FocusLiveStreamListener;
import com.tencent.mobileqq.now.netchannel.websso.ChannelCenter;
import com.tencent.mobileqq.now.netchannel.websso.UserInfoMgr;
import com.tencent.mobileqq.now.nowqqlivefocus.NowQQLiveFocusProto.GetAnchorOnline1Req;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class FocusLiveStreamDataImpl
{
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean;
  private volatile boolean b = false;
  
  public void a(FocusLiveStreamListener paramFocusLiveStreamListener)
  {
    NowQQLiveFocusProto.GetAnchorOnline1Req localGetAnchorOnline1Req = new NowQQLiveFocusProto.GetAnchorOnline1Req();
    String str = UserInfoMgr.a();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    if (this.b) {
      return;
    }
    this.b = true;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Int >= 3)
      {
        paramFocusLiveStreamListener.a(-1, "retry fail");
        return;
      }
    }
    localGetAnchorOnline1Req.uin.set(Long.parseLong(str));
    localGetAnchorOnline1Req.is_uid.set(1);
    localGetAnchorOnline1Req.source.set(1);
    localGetAnchorOnline1Req.need_kroom.set(0);
    ChannelCenter.a().a(28679, 2, localGetAnchorOnline1Req.toByteArray(), new FocusLiveStreamDataImpl.1(this, paramFocusLiveStreamListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.focusanchor.focusdata.FocusLiveStreamDataImpl
 * JD-Core Version:    0.7.0.1
 */