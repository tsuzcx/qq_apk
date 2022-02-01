package com.tencent.mobileqq.winkpublish.task.compress;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AppSetting;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneThreadHelper;
import com.tencent.mobileqq.winkpublish.common.config.LocalConfig;
import com.tencent.mobileqq.winkpublish.model.ShuoshuoVideoInfo;
import com.tencent.mobileqq.winkpublish.service.video.RemoteVideoServiceHandler;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class VideoCompressEngine
{
  private static VideoCompressEngine e;
  public VideoCompressTask a;
  int b = QCircleConfigHelper.a("MiniVideo", "videoTaskRetryForDisconnect", Integer.valueOf(3)).intValue();
  int c = QCircleConfigHelper.a("MiniVideo", "videoTaskRetryForConnectFailed", Integer.valueOf(2)).intValue();
  public int d = QCircleConfigHelper.a("MiniVideo", "videoTaskRetryForBuildFailed", Integer.valueOf(0)).intValue();
  private boolean f = true;
  private LinkedHashMap<String, VideoCompressTask> g = new LinkedHashMap();
  
  public VideoCompressEngine()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("retry4Dis=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", retry4Conn=");
      localStringBuilder.append(this.c);
      localStringBuilder.append(", retry4build=");
      localStringBuilder.append(this.d);
      QLog.d("[upload2_VideoCompressEngine]", 2, localStringBuilder.toString());
    }
  }
  
  public static VideoCompressEngine a()
  {
    if (e == null) {
      try
      {
        if (e == null) {
          e = new VideoCompressEngine();
        }
      }
      finally {}
    }
    return e;
  }
  
  public VideoCompressTask a(String paramString)
  {
    VideoCompressTask localVideoCompressTask = (VideoCompressTask)this.g.get(paramString);
    paramString = localVideoCompressTask;
    if (localVideoCompressTask == null) {
      paramString = null;
    }
    return paramString;
  }
  
  public void a(String paramString, Intent paramIntent)
  {
    try
    {
      paramString = a(paramString);
      if (paramString == null) {
        return;
      }
      if (paramIntent == null) {
        return;
      }
      boolean bool1 = false;
      paramString.c = false;
      QCircleHostQzoneThreadHelper.removeRealTimeThreadTask(paramString.i);
      QCircleHostQzoneThreadHelper.removeRealTimeThreadTask(paramString.h);
      boolean bool2 = paramIntent.getBooleanExtra("video_handle_result", false);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("VideoCompressTask video receiver handle result:");
      ((StringBuilder)localObject1).append(bool2);
      QLog.i("[upload2_VideoCompressEngine]", 1, ((StringBuilder)localObject1).toString());
      Object localObject2;
      if (bool2)
      {
        localObject1 = paramIntent.getStringExtra("video_dest_path");
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramString.ae = "video path is empty!";
          paramString.f.a(paramString, 100082);
          return;
        }
        localObject2 = new File((String)localObject1);
        if ((((File)localObject2).exists()) && (((File)localObject2).length() != 0L))
        {
          paramString.a.b = ((String)localObject1);
          if (!paramString.e)
          {
            paramString.l();
            paramString.a.n = false;
            paramString.a.w = true;
            if ((QCircleHostConstants._AppSetting.isDebugVersion()) && (LocalConfig.a("key_video_quality_debug_enable", false))) {
              paramString.a.w = false;
            }
            paramString.a.g = ((File)localObject2).length();
            localObject1 = paramString.a;
            if (!paramString.a.q) {
              bool1 = true;
            }
            ((ShuoshuoVideoInfo)localObject1).r = bool1;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("VideoCompressTask video receiver handle destpath:");
            ((StringBuilder)localObject1).append(paramString.a.b);
            QLog.i("[upload2_VideoCompressEngine]", 1, ((StringBuilder)localObject1).toString());
          }
          b(paramString);
          RemoteVideoServiceHandler.a().b(paramString.getCacheKey());
          paramString.f.a(paramString, paramIntent);
          this.a = null;
        }
        else
        {
          paramString.ae = "video file is not valid";
          paramString.f.a(paramString, 100083);
        }
      }
      else
      {
        int i = paramIntent.getIntExtra("video_error_code", 0);
        localObject1 = paramIntent.getStringExtra("video_error_file_name");
        paramIntent = paramIntent.getStringExtra("video_error_msg");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleVideoComplete compress error errCode:");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(", errMsg:");
        ((StringBuilder)localObject2).append(paramIntent);
        ((StringBuilder)localObject2).append(", failedFile:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.w("[upload2_VideoCompressEngine]", 1, ((StringBuilder)localObject2).toString());
        paramString.ae = paramIntent;
        paramString.d += 1;
        QCircleHostQzoneThreadHelper.postNormalThread(new VideoCompressEngine.1(this, (String)localObject1, i, paramString));
      }
      return;
    }
    finally {}
  }
  
  public boolean a(VideoCompressTask paramVideoCompressTask)
  {
    if (paramVideoCompressTask != null) {
      try
      {
        if (!TextUtils.isEmpty(paramVideoCompressTask.getCacheKey()))
        {
          this.g.put(paramVideoCompressTask.getCacheKey(), paramVideoCompressTask);
          return true;
        }
      }
      finally {}
    }
    return false;
  }
  
  public VideoCompressTask b()
  {
    try
    {
      int i = this.g.size();
      if (i == 0) {
        return null;
      }
      if (this.a == null)
      {
        localVideoCompressTask = (VideoCompressTask)((Map.Entry)this.g.entrySet().iterator().next()).getValue();
        return localVideoCompressTask;
      }
      VideoCompressTask localVideoCompressTask = this.a;
      return localVideoCompressTask;
    }
    finally {}
  }
  
  public void b(VideoCompressTask paramVideoCompressTask)
  {
    try
    {
      this.g.remove(paramVideoCompressTask.getCacheKey());
      if ((this.a != null) && (this.a.getCacheKey().equals(paramVideoCompressTask.getCacheKey()))) {
        this.a = null;
      }
      return;
    }
    finally
    {
      paramVideoCompressTask = finally;
      throw paramVideoCompressTask;
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      paramString = a(paramString);
      if (paramString == null)
      {
        QLog.i("[upload2_VideoCompressEngine]", 1, "handleCompressStart, getTaskByCacheKey null");
        return;
      }
      this.a = paramString;
      paramString.k();
      return;
    }
    finally {}
  }
  
  public void c(VideoCompressTask paramVideoCompressTask)
  {
    if (paramVideoCompressTask == null) {
      return;
    }
    try
    {
      if (!this.g.containsKey(paramVideoCompressTask.getCacheKey())) {
        a(paramVideoCompressTask);
      }
      paramVideoCompressTask.c();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.task.compress.VideoCompressEngine
 * JD-Core Version:    0.7.0.1
 */