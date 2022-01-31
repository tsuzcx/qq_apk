package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.transfile.ProtoReqManager;
import java.util.List;

public class RichProtoProc
{
  public static RichProtoProc.RichProtoHandler a(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback != null) && (paramRichProtoReq.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      if ("c2c_pic_up".equals(paramRichProtoReq.jdField_a_of_type_JavaLangString)) {
        return new C2CPicUpHandler();
      }
      if ("grp_pic_up".equals(paramRichProtoReq.jdField_a_of_type_JavaLangString)) {
        return new GroupPicUpHandler();
      }
      if ("grp_ptt_up".equals(paramRichProtoReq.jdField_a_of_type_JavaLangString)) {
        return new GroupPttUpHandler();
      }
      if ("c2c_pic_dw".equals(paramRichProtoReq.jdField_a_of_type_JavaLangString)) {
        return new C2CPicDownHandler();
      }
      if ("grp_pic_dw".equals(paramRichProtoReq.jdField_a_of_type_JavaLangString)) {
        return new GroupPicDownHandler();
      }
      if ("c2c_ptt_up".equals(paramRichProtoReq.jdField_a_of_type_JavaLangString)) {
        return new C2CPttUpHandler();
      }
      if ("c2c_ptt_dw".equals(paramRichProtoReq.jdField_a_of_type_JavaLangString)) {
        return new C2CPttDownHandler();
      }
      if ("grp_ptt_dw".equals(paramRichProtoReq.jdField_a_of_type_JavaLangString)) {
        return new GroupPttDownHandler();
      }
      if ("short_video_dw".equals(paramRichProtoReq.jdField_a_of_type_JavaLangString)) {
        return new ShortVideoDownHandler();
      }
      if ("short_video_up".equals(paramRichProtoReq.jdField_a_of_type_JavaLangString)) {
        return new ShortVideoUpHandler();
      }
      if ("multi_msg_dw".equals(paramRichProtoReq.jdField_a_of_type_JavaLangString)) {
        return new MultiMsgDownHandler();
      }
      if ("multi_msg_up".equals(paramRichProtoReq.jdField_a_of_type_JavaLangString)) {
        return new MultiMsgUpHandler();
      }
      if (("nearby_people_pic_up".equals(paramRichProtoReq.jdField_a_of_type_JavaLangString)) || ("friend_avatar_up".equals(paramRichProtoReq.jdField_a_of_type_JavaLangString))) {
        return new NearbyPeoplePicUpHandler();
      }
      if ("short_video_fw".equals(paramRichProtoReq.jdField_a_of_type_JavaLangString)) {
        return new ShortVideoForwardHandler();
      }
      if ("bdh_common_up".equals(paramRichProtoReq.jdField_a_of_type_JavaLangString)) {
        return new BDHCommonUpHandler();
      }
      if ("pa_long_message".equals(paramRichProtoReq.jdField_a_of_type_JavaLangString)) {
        return new PALongMessageHandler();
      }
      if ("art_filter_up".equals(paramRichProtoReq.jdField_a_of_type_JavaLangString)) {
        return new ArtFilterUpHandler();
      }
    }
    return null;
  }
  
  public static void a(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProtoProc.RichProtoHandler localRichProtoHandler = a(paramRichProtoReq);
    if (localRichProtoHandler != null) {
      localRichProtoHandler.a(paramRichProtoReq);
    }
  }
  
  public static void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback != null))
    {
      paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoReq = null;
      paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback.a(paramRichProtoReq, paramRichProtoResp);
      paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = null;
      paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = null;
    }
  }
  
  public static void b(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.b(paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoReq);
      paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = null;
      paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoReq = null;
      paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProtoProc
 * JD-Core Version:    0.7.0.1
 */