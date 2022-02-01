package com.tencent.mobileqq.shortvideo.redbag;

import com.tencent.mobileqq.qipc.QIPCModule;

public class VideoPlayIPCServer
{
  private static volatile VideoPlayIPCServer jdField_a_of_type_ComTencentMobileqqShortvideoRedbagVideoPlayIPCServer;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new VideoPlayIPCServer.1(this, "Module_VideoPlayIPCServer");
  
  public static VideoPlayIPCServer a()
  {
    if (jdField_a_of_type_ComTencentMobileqqShortvideoRedbagVideoPlayIPCServer == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqShortvideoRedbagVideoPlayIPCServer == null) {
          jdField_a_of_type_ComTencentMobileqqShortvideoRedbagVideoPlayIPCServer = new VideoPlayIPCServer();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqShortvideoRedbagVideoPlayIPCServer;
  }
  
  public QIPCModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.VideoPlayIPCServer
 * JD-Core Version:    0.7.0.1
 */