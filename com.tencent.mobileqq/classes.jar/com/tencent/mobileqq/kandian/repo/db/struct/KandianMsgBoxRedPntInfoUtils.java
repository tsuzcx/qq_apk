package com.tencent.mobileqq.kandian.repo.db.struct;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.MsgBody;
import tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.MsgContent;
import tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.MsgFolderInfo;
import tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.MsgGetRsp;

public class KandianMsgBoxRedPntInfoUtils
{
  public static KandianMsgBoxRedPntInfo a()
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.a();
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = (KandianMsgBoxRedPntInfo)RIJSPUtils.a(localAppRuntime, "kandian_msg_box_sp_key_new", true);
    Object localObject = localKandianMsgBoxRedPntInfo;
    if (localKandianMsgBoxRedPntInfo == null)
    {
      KandianOx210MsgInfo localKandianOx210MsgInfo1 = KandianOx210MsgInfo.d();
      KandianOx210MsgInfo localKandianOx210MsgInfo2 = KandianOx210MsgInfo.a();
      if (localKandianOx210MsgInfo1 == null)
      {
        localObject = localKandianMsgBoxRedPntInfo;
        if (localKandianOx210MsgInfo2 == null) {}
      }
      else
      {
        localObject = new KandianMsgBoxRedPntInfoImpl();
        ((KandianMsgBoxRedPntInfo)localObject).mSeq = -1L;
        ((KandianMsgBoxRedPntInfo)localObject).mNeedShowInFolder = false;
        if (localKandianOx210MsgInfo2 != null)
        {
          ((KandianMsgBoxRedPntInfo)localObject).mMsgCnt += localKandianOx210MsgInfo2.a;
          ((KandianMsgBoxRedPntInfo)localObject).mUin = localKandianOx210MsgInfo2.e;
          ((KandianMsgBoxRedPntInfo)localObject).mMsgTime = System.currentTimeMillis();
          ((KandianMsgBoxRedPntInfo)localObject).mMsgType = 1;
          localKandianOx210MsgInfo2.a(localAppRuntime);
        }
        if (localKandianOx210MsgInfo1 != null)
        {
          ((KandianMsgBoxRedPntInfo)localObject).mMsgCnt += localKandianOx210MsgInfo1.a;
          ((KandianMsgBoxRedPntInfo)localObject).mMsgType = 2;
          localKandianOx210MsgInfo1.d((QQAppInterface)localAppRuntime);
        }
        ((KandianMsgBoxRedPntInfo)localObject).asyncWriteToSP();
      }
    }
    return localObject;
  }
  
  public static KandianMsgBoxRedPntInfo a(String paramString)
  {
    try
    {
      KandianMsgBoxRedPntInfoImpl localKandianMsgBoxRedPntInfoImpl = new KandianMsgBoxRedPntInfoImpl();
      paramString = new JSONObject(paramString);
      localKandianMsgBoxRedPntInfoImpl.mSeq = paramString.getLong("_red_ext_seq");
      localKandianMsgBoxRedPntInfoImpl.mUin = paramString.getLong("_red_ext_from_uin");
      localKandianMsgBoxRedPntInfoImpl.mMsgType = paramString.getInt("_red_ext_msg_type");
      localKandianMsgBoxRedPntInfoImpl.mMsgTime = paramString.getLong("_red_ext_msg_time");
      localKandianMsgBoxRedPntInfoImpl.mIconUrl = paramString.getString("_red_ext_pic_url");
      localKandianMsgBoxRedPntInfoImpl.mJumpUrl = paramString.getString("_red_ext_jump_url");
      localKandianMsgBoxRedPntInfoImpl.mNeedShowInFolder = false;
      localKandianMsgBoxRedPntInfoImpl.mRedType = paramString.getInt("_red_ext_red_type");
      localKandianMsgBoxRedPntInfoImpl.mOrangeWord = paramString.getString("_red_ext_orange_word");
      localKandianMsgBoxRedPntInfoImpl.mSummary = paramString.getString("_red_ext_summary");
      if ((!TextUtils.isEmpty(localKandianMsgBoxRedPntInfoImpl.mSummary)) && (!TextUtils.isEmpty(localKandianMsgBoxRedPntInfoImpl.mOrangeWord))) {
        localKandianMsgBoxRedPntInfoImpl.mNeedShowInFolder = true;
      }
      localKandianMsgBoxRedPntInfoImpl.mMsgCnt = paramString.getInt("_red_ext_unread");
      return localKandianMsgBoxRedPntInfoImpl;
    }
    catch (JSONException paramString)
    {
      label149:
      break label149;
    }
    return null;
  }
  
  public static KandianMsgBoxRedPntInfo a(oidb_cmd0xbe4.MsgGetRsp paramMsgGetRsp)
  {
    if (paramMsgGetRsp == null) {
      return null;
    }
    KandianMsgBoxRedPntInfoImpl localKandianMsgBoxRedPntInfoImpl = new KandianMsgBoxRedPntInfoImpl();
    localKandianMsgBoxRedPntInfoImpl.mMsgCnt = ((int)paramMsgGetRsp.uint64_unread.get());
    oidb_cmd0xbe4.MsgBody localMsgBody = (oidb_cmd0xbe4.MsgBody)paramMsgGetRsp.msg_body.get();
    if (localMsgBody == null) {
      return null;
    }
    localKandianMsgBoxRedPntInfoImpl.mSeq = localMsgBody.uint64_seq.get();
    localKandianMsgBoxRedPntInfoImpl.mMsgType = localMsgBody.uint32_msg_type.get();
    localKandianMsgBoxRedPntInfoImpl.mMsgTime = localMsgBody.uint64_msg_time.get();
    if (localMsgBody.bytes_pic_url.has()) {
      localKandianMsgBoxRedPntInfoImpl.mIconUrl = localMsgBody.bytes_pic_url.get().toStringUtf8();
    }
    if (localMsgBody.str_summary.has()) {
      localKandianMsgBoxRedPntInfoImpl.mMsgText = localMsgBody.str_summary.get();
    }
    if (localMsgBody.bytes_jump_url.has()) {
      localKandianMsgBoxRedPntInfoImpl.mJumpUrl = localMsgBody.bytes_jump_url.get().toStringUtf8();
    }
    if (localMsgBody.str_msgid.has()) {
      localKandianMsgBoxRedPntInfoImpl.mMsgId = localMsgBody.str_msgid.get();
    }
    localKandianMsgBoxRedPntInfoImpl.mUin = localMsgBody.uint64_from_uin.get();
    boolean bool;
    if (localMsgBody.msg_folder_info.has())
    {
      paramMsgGetRsp = (oidb_cmd0xbe4.MsgFolderInfo)localMsgBody.msg_folder_info.get();
      if (paramMsgGetRsp.uint32_show_folder.get() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      localKandianMsgBoxRedPntInfoImpl.mNeedShowInFolder = bool;
      if (paramMsgGetRsp.bytes_summary.has()) {
        localKandianMsgBoxRedPntInfoImpl.mSummary = paramMsgGetRsp.bytes_summary.get().toStringUtf8();
      } else {
        localKandianMsgBoxRedPntInfoImpl.mNeedShowInFolder = false;
      }
      if (paramMsgGetRsp.bytes_orange_word.has()) {
        localKandianMsgBoxRedPntInfoImpl.mOrangeWord = paramMsgGetRsp.bytes_orange_word.get().toStringUtf8();
      } else {
        localKandianMsgBoxRedPntInfoImpl.mNeedShowInFolder = false;
      }
    }
    if (localMsgBody.msg_content.has())
    {
      localKandianMsgBoxRedPntInfoImpl.dataType = 1;
      oidb_cmd0xbe4.MsgContent localMsgContent = (oidb_cmd0xbe4.MsgContent)localMsgBody.msg_content.get();
      bool = localMsgContent.str_desc.has();
      String str = "";
      if (bool) {
        paramMsgGetRsp = localMsgContent.str_desc.get();
      } else {
        paramMsgGetRsp = "";
      }
      localKandianMsgBoxRedPntInfoImpl.mCardSummary = paramMsgGetRsp;
      if (localMsgContent.str_feeds_pic.has()) {
        paramMsgGetRsp = localMsgContent.str_feeds_pic.get();
      } else {
        paramMsgGetRsp = "";
      }
      localKandianMsgBoxRedPntInfoImpl.mArticlePicUrl = paramMsgGetRsp;
      localKandianMsgBoxRedPntInfoImpl.sysMsgFrom = localMsgContent.uint32_sys_from.get();
      if (localMsgContent.string_sys_activityid.has()) {
        paramMsgGetRsp = localMsgContent.string_sys_activityid.get();
      } else {
        paramMsgGetRsp = "";
      }
      localKandianMsgBoxRedPntInfoImpl.sysMsgID = paramMsgGetRsp;
      paramMsgGetRsp = str;
      if (localMsgContent.string_feeds_id.has()) {
        paramMsgGetRsp = localMsgContent.string_feeds_id.get();
      }
      localKandianMsgBoxRedPntInfoImpl.feedsID = paramMsgGetRsp;
      localKandianMsgBoxRedPntInfoImpl.feedsType = localMsgContent.uint32_feed_type.get();
      localKandianMsgBoxRedPntInfoImpl.messageType = localMsgContent.uint32_type.get();
    }
    if (localMsgBody.bytes_ext_data.has()) {
      localKandianMsgBoxRedPntInfoImpl.mExtraData = localMsgBody.bytes_ext_data.get().toStringUtf8();
    }
    return localKandianMsgBoxRedPntInfoImpl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.KandianMsgBoxRedPntInfoUtils
 * JD-Core Version:    0.7.0.1
 */