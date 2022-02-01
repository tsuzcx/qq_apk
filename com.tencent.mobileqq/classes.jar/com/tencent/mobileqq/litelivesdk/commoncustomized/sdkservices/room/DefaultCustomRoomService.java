package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.room;

import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;

public class DefaultCustomRoomService
  extends AbstractCustomRoomService
{
  protected String a()
  {
    return "https://ilive.qq.com/cgi-bin/core/room_video/get_video_streaming";
  }
  
  protected String b()
  {
    return "https://test.ilive.qq.com/cgi-bin/core/room_video/get_video_streaming";
  }
  
  protected String c()
  {
    return "https://kd.ilive.qq.com/cgi-bin/info_flow/short_video/get_video_info";
  }
  
  protected String d()
  {
    return "https://test.kd.ilive.qq.com/cgi-bin/info_flow/short_video/get_video_info";
  }
  
  protected String e()
  {
    return "https://kd.ilive.qq.com/cgi-bin/info_flow/room/get_offset_streaming";
  }
  
  protected String f()
  {
    return "https://test.kd.ilive.qq.com/cgi-bin/info_flow/room/get_offset_streaming";
  }
  
  protected String g()
  {
    return "https://kd.ilive.qq.com/" + BusinessManager.a.a().d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.room.DefaultCustomRoomService
 * JD-Core Version:    0.7.0.1
 */