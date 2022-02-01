package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import java.util.HashMap;
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
  @ConfigInject(configPath="Foundation/Transfile/src/main/resources/Inject_InitProtoHandlerConfig.yml", version=1)
  public static HashMap<String, Class<? extends RichProtoProc.RichProtoHandler>> handlerMaps = new HashMap();
  
  static
  {
    handlerMaps.put("share_pic_to_wx", SharePicToWXUpHandler.class);
    handlerMaps.put("pa_long_message", PALongMessageHandler.class);
    handlerMaps.put("bdh_common_up", BDHCommonUpHandler.class);
    handlerMaps.put("short_video_fw", ShortVideoForwardHandler.class);
    handlerMaps.put("friend_avatar_up", NearbyPeoplePicUpHandler.class);
    handlerMaps.put("nearby_people_pic_up", NearbyPeoplePicUpHandler.class);
    handlerMaps.put("multi_msg_up", MultiMsgUpHandler.class);
    handlerMaps.put("multi_msg_dw", MultiMsgDownHandler.class);
    handlerMaps.put("short_video_up", ShortVideoUpHandler.class);
    handlerMaps.put("short_video_dw", ShortVideoDownHandler.class);
    handlerMaps.put("grp_ptt_dw", GroupPttDownHandler.class);
    handlerMaps.put("c2c_ptt_dw", C2CPttDownHandler.class);
    handlerMaps.put("c2c_ptt_up", C2CPttUpHandler.class);
    handlerMaps.put("grp_pic_dw", GroupPicDownHandler.class);
    handlerMaps.put("c2c_pic_dw", C2CPicDownHandler.class);
    handlerMaps.put("grp_ptt_up", GroupPttUpHandler.class);
    handlerMaps.put("grp_pic_up", GroupPicUpHandler.class);
    handlerMaps.put("c2c_pic_up", C2CPicUpHandler.class);
  }
  
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
      paramRichProtoReq = paramRichProtoReq.protoKey;
      paramRichProtoReq = (Class)handlerMaps.get(paramRichProtoReq);
      if (paramRichProtoReq == null) {}
    }
    try
    {
      paramRichProtoReq = (RichProtoProc.RichProtoHandler)paramRichProtoReq.newInstance();
      return paramRichProtoReq;
    }
    catch (IllegalAccessException paramRichProtoReq)
    {
      paramRichProtoReq.printStackTrace();
      return null;
    }
    catch (InstantiationException paramRichProtoReq)
    {
      for (;;)
      {
        paramRichProtoReq.printStackTrace();
      }
    }
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