package com.tencent.qqmini.miniapp.proxy;

import com.tencent.qqmini.miniapp.util.VideoCompressProxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VideoCompressProxyDefault
  extends VideoCompressProxy
{
  public static final String TAG = "VideoCompress";
  private static final ExecutorService executor = ;
  
  public void execute()
  {
    executor.execute(new VideoCompressProxyDefault.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.proxy.VideoCompressProxyDefault
 * JD-Core Version:    0.7.0.1
 */