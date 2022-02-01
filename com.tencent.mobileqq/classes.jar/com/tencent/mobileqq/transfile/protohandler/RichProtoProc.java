package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.transfile.ProtoReqManager;
import java.util.List;

public class RichProtoProc
{
  public static final String ART_FILTER_UP = "art_filter_up";
  public static final String BDH_COMMON_UP = "bdh_common_up";
  public static final String C2C_PIC_DW = "c2c_pic_dw";
  public static final String C2C_PIC_UP = "c2c_pic_up";
  public static final String C2C_PTT_DW = "c2c_ptt_dw";
  public static final String C2C_PTT_UP = "c2c_ptt_up";
  public static final String FRIEND_AVATAR_UP = "friend_avatar_up";
  public static final String GRP_PIC_DW = "grp_pic_dw";
  public static final String GRP_PIC_UP = "grp_pic_up";
  public static final String GRP_PTT_DW = "grp_ptt_dw";
  public static final String GRP_PTT_UP = "grp_ptt_up";
  public static final String MULTI_MSG_DW = "multi_msg_dw";
  public static final String MULTI_MSG_UP = "multi_msg_up";
  public static final String NEARBY_PEOPLE_PIC_UP = "nearby_people_pic_up";
  public static final String PA_LONG_MESSAGE = "pa_long_message";
  public static final String SHARE_PIC_TO_WX = "share_pic_to_wx";
  public static final String SHORT_VIDEO_DW = "short_video_dw";
  public static final String SHORT_VIDEO_FW = "short_video_fw";
  public static final String SHORT_VIDEO_UP = "short_video_up";
  public static final String SNAP_PIC_UP = "snap_pic_up";
  
  public static void cancelRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      paramRichProtoReq.protoReqMgr.cancelReq(paramRichProtoReq.protoReq);
      paramRichProtoReq.callback = null;
      paramRichProtoReq.protoReq = null;
      paramRichProtoReq.protoReqMgr = null;
    }
  }
  
  public static RichProtoProc.RichProtoHandler getHandler(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.protoReqMgr != null) && (paramRichProtoReq.callback != null) && (paramRichProtoReq.reqs.size() != 0))
    {
      if ("c2c_pic_up".equals(paramRichProtoReq.protoKey)) {
        return new C2CPicUpHandler();
      }
      if ("grp_pic_up".equals(paramRichProtoReq.protoKey)) {
        return new GroupPicUpHandler();
      }
      if ("grp_ptt_up".equals(paramRichProtoReq.protoKey)) {
        return new GroupPttUpHandler();
      }
      if ("c2c_pic_dw".equals(paramRichProtoReq.protoKey)) {
        return new C2CPicDownHandler();
      }
      if ("grp_pic_dw".equals(paramRichProtoReq.protoKey)) {
        return new GroupPicDownHandler();
      }
      if ("c2c_ptt_up".equals(paramRichProtoReq.protoKey)) {
        return new C2CPttUpHandler();
      }
      if ("c2c_ptt_dw".equals(paramRichProtoReq.protoKey)) {
        return new C2CPttDownHandler();
      }
      if ("grp_ptt_dw".equals(paramRichProtoReq.protoKey)) {
        return new GroupPttDownHandler();
      }
      if ("short_video_dw".equals(paramRichProtoReq.protoKey)) {
        return new ShortVideoDownHandler();
      }
      if ("short_video_up".equals(paramRichProtoReq.protoKey)) {
        return new ShortVideoUpHandler();
      }
      if ("multi_msg_dw".equals(paramRichProtoReq.protoKey)) {
        return new MultiMsgDownHandler();
      }
      if ("multi_msg_up".equals(paramRichProtoReq.protoKey)) {
        return new MultiMsgUpHandler();
      }
      if (("nearby_people_pic_up".equals(paramRichProtoReq.protoKey)) || ("friend_avatar_up".equals(paramRichProtoReq.protoKey))) {
        return new NearbyPeoplePicUpHandler();
      }
      if ("short_video_fw".equals(paramRichProtoReq.protoKey)) {
        return new ShortVideoForwardHandler();
      }
      if ("bdh_common_up".equals(paramRichProtoReq.protoKey)) {
        return new BDHCommonUpHandler();
      }
      if ("pa_long_message".equals(paramRichProtoReq.protoKey)) {
        return new PALongMessageHandler();
      }
      if ("art_filter_up".equals(paramRichProtoReq.protoKey)) {
        return new ArtFilterUpHandler();
      }
      if ("share_pic_to_wx".equals(paramRichProtoReq.protoKey)) {
        return new SharePicToWXUpHandler();
      }
    }
    return null;
  }
  
  public static void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.callback != null))
    {
      paramRichProtoReq.protoReq = null;
      paramRichProtoReq.callback.onBusiProtoResp(paramRichProtoReq, paramRichProtoResp);
      paramRichProtoReq.callback = null;
      paramRichProtoReq.protoReqMgr = null;
    }
  }
  
  public static void procRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProtoProc.RichProtoHandler localRichProtoHandler = getHandler(paramRichProtoReq);
    if (localRichProtoHandler != null) {
      localRichProtoHandler.sendRichProtoReq(paramRichProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProtoProc
 * JD-Core Version:    0.7.0.1
 */