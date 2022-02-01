package com.tencent.mobileqq.shortvideo.redbag;

import com.tencent.mobileqq.qipc.QIPCModule;

public class VideoPlayIPCServer
{
  private static volatile VideoPlayIPCServer a;
  private QIPCModule b = new VideoPlayIPCServer.1(this, "Module_VideoPlayIPCServer");
  
  public static VideoPlayIPCServer a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new VideoPlayIPCServer();
        }
      }
      finally {}
    }
    return a;
  }
  
  public QIPCModule b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.VideoPlayIPCServer
 * JD-Core Version:    0.7.0.1
 */