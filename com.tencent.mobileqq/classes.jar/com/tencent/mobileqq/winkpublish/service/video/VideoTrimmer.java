package com.tencent.mobileqq.winkpublish.service.video;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostAVHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostAVHelper._AndroidCodec;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostVideoHelper;
import com.tencent.mobileqq.winkpublish.service.video.util.PublishVideoCommonUtils;
import com.tencent.mobileqq.winkpublish.service.video.util.PublishVideoCommonUtils.VideoSupport;
import com.tencent.mobileqq.winkpublish.service.video.util.PublishVideoUtils;
import com.tencent.mobileqq.winkpublish.util.CheckListUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class VideoTrimmer
{
  private static int A;
  private static int B;
  private static int C;
  private static boolean D = false;
  private static String E = "";
  private static String F = "";
  private static int G;
  private static int H;
  private static boolean I;
  private static boolean J;
  private static boolean K;
  private static int L;
  private static int M;
  private static final String[] a = { "baseline", "main", "high" };
  private static final String[] b = { "2.0", "2.1", "2.2", "3.0", "3.1", "3.2", "4.0", "4.1", "4.2" };
  private static final String[] c = { "ultrafast", "superfast", "veryfast", "faster", "fast", "medium", "slow", "slower", "veryslow" };
  private static final String[] d = { "film", "animation", "grain", "stillimage", "psnr", "ssim", "fastdecode", "zerolatency" };
  private static final int[] e = { 0, 1, 2 };
  private static int f = 1;
  private static int g = 2;
  private static int h = 3;
  private static VideoConverter i;
  private static int j;
  private static boolean k;
  private static int l;
  private static boolean m;
  private static int n;
  private static int o;
  private static int p;
  private static int q;
  private static int r;
  private static String s;
  private static String t;
  private static String u;
  private static String v;
  private static String w;
  private static String x;
  private static int y;
  private static String z;
  
  public static int a()
  {
    if (M == 0) {
      try
      {
        File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new VideoTrimmer.1CpuFilter());
        if (arrayOfFile == null) {
          return 1;
        }
        M = arrayOfFile.length;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("getCpuCores exception occured,e=");
        localStringBuilder2.append(localException.getMessage());
        QLog.w("[upload2]VideoTrimmer", 1, localStringBuilder2.toString());
        M = 1;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("getCpuCores, num=");
      localStringBuilder1.append(M);
      QLog.d("[upload2]VideoTrimmer", 2, localStringBuilder1.toString());
    }
    return M;
  }
  
  private static int a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, boolean paramBoolean, int paramInt, Handler paramHandler, String paramString4)
  {
    long l1 = System.currentTimeMillis();
    paramString1 = a(paramString1, paramString2, paramString3, paramLong1, paramLong2, paramBoolean, paramInt);
    if (paramString1 == null) {
      return -1;
    }
    paramHandler.sendEmptyMessage(1004);
    paramInt = PublishVideoCompressor.a(paramString4, paramString1);
    paramHandler.removeMessages(1004);
    paramLong1 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("trim video time cost:");
      paramString1.append(paramLong1 - l1);
      paramString1.append("ms, ret=");
      paramString1.append(paramInt);
      QLog.d("[upload2]VideoTrimmer", 2, paramString1.toString());
    }
    return paramInt;
  }
  
  public static int a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean1, int paramInt, Handler paramHandler, String paramString5, String paramString6, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramString1 = new StringBuilder();
    paramString1.append("trimVideo: input=");
    paramString1.append(paramString3);
    paramString1.append(" output=");
    paramString1.append(paramString4);
    paramString1.append(" start=");
    paramString1.append(paramLong1);
    paramString1.append(" end=");
    paramString1.append(paramLong2);
    paramString1.append(" totalDuration=");
    paramString1.append(paramLong3);
    paramString1.append(" needOrigin=");
    paramString1.append(paramBoolean1);
    paramString1.append(" retryNum=");
    paramString1.append(paramInt);
    paramString1.append(" tmpVideoPath=");
    paramString1.append(paramString5);
    paramString1.append(" targetKey=");
    paramString1.append(paramString6);
    paramString1.append(" isSyncToWeishi=");
    paramString1.append(paramBoolean2);
    paramString1.append(" isQcircle=");
    paramString1.append(paramBoolean3);
    QLog.i("[upload2]VideoTrimmer", 1, paramString1.toString());
    J = paramBoolean2;
    K = paramBoolean3;
    l();
    long l1 = new File(paramString3).length();
    if (paramLong3 != 0L) {
      l1 = l1 * (paramLong2 - paramLong1) / paramLong3;
    }
    int i1;
    if (m())
    {
      QLog.i("[upload2]VideoTrimmer", 1, "useHwEncode=true");
      i1 = 1;
    }
    else
    {
      i1 = 0;
    }
    if ((!I) && ((i1 == 0) || (paramInt != 0) || (D))) {
      i1 = -1;
    }
    for (;;)
    {
      paramString1 = paramString4;
      break;
      long l2 = Math.abs(paramLong2 - paramLong1 - paramLong3);
      long l3 = l;
      paramLong3 = -1L;
      if (l2 < l3)
      {
        l2 = -1L;
      }
      else
      {
        paramLong3 = paramLong1;
        l2 = paramLong2;
      }
      l3 = System.currentTimeMillis();
      i1 = a(paramString3, paramString5, paramBoolean1, paramLong3, l2);
      if (i1 == 0)
      {
        int i2 = PublishVideoCompressor.a(paramString6, new String[] { "-i", paramString5, "-acodec", "copy", "-vcodec", "copy", "-movflags", "faststart", "-y", paramString4 });
        paramString1 = new StringBuilder();
        paramString1.append("trimVideoByHW, faststart ret2=");
        paramString1.append(i2);
        paramString1 = paramString1.toString();
        String str = "[upload2]VideoTrimmer";
        QLog.i(str, 1, paramString1);
        if (i2 < 0)
        {
          paramString1 = paramString5;
        }
        else
        {
          File localFile = new File(paramString5);
          paramString1 = paramString4;
          if (localFile.exists())
          {
            localFile.delete();
            paramString1 = paramString4;
          }
        }
        paramLong3 = System.currentTimeMillis() - l3;
        l2 = l1 / paramLong3;
        paramString4 = new StringBuilder();
        paramString4.append("trimVideoByHW, time=");
        paramString4.append(paramLong3);
        paramString4.append(" speed=");
        paramString4.append(l2);
        QLog.i(str, 1, paramString4.toString());
        break;
      }
    }
    if ((i1 != 0) && (!I))
    {
      paramString4 = new File(paramString5);
      if (paramString4.exists()) {
        paramString4.delete();
      }
      if (i1 < 0)
      {
        paramLong3 = System.currentTimeMillis();
        paramInt = a(paramString2, paramString3, paramString1, paramLong1, paramLong2, paramBoolean1, paramInt, paramHandler, paramString6);
        i1 = paramInt;
        if (paramInt == 0)
        {
          paramLong1 = System.currentTimeMillis() - paramLong3;
          paramLong2 = l1 / paramLong1;
          paramString1 = new StringBuilder();
          paramString1.append("trimVideoBySoftware, time=");
          paramString1.append(paramLong1);
          paramString1.append(" speed=");
          paramString1.append(paramLong2);
          QLog.i("[upload2]VideoTrimmer", 1, paramString1.toString());
          QCircleHostQzoneHelper.putLong(QCircleHostQzoneHelper.KEY_VIDEO_COMPRESS_SPEED(), paramLong2);
          i1 = paramInt;
        }
      }
    }
    paramString1 = new StringBuilder();
    paramString1.append("trim video ret=");
    paramString1.append(i1);
    QLog.i("[upload2]VideoTrimmer", 1, paramString1.toString());
    return i1;
  }
  
  private static int a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    int i1;
    if (Build.VERSION.SDK_INT >= 18)
    {
      VideoConverterConfig localVideoConverterConfig = QCircleHostVideoHelper.getCompressConfig(paramString1);
      int i2 = QCircleHostAVHelper.checkSupportMediaCodecFeature();
      int i3 = QCircleHostAVHelper._AndroidCodec.SUPPORT_AVC_DEC();
      i1 = 0;
      boolean bool;
      if (((i3 & i2) > 0) && ((i2 & QCircleHostAVHelper._AndroidCodec.SUPPORT_AVC_ENC()) > 0)) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("trimVideoByHW, isHWCodecSupported=");
        localStringBuilder.append(bool);
        QLog.d("[upload2]VideoTrimmer", 2, localStringBuilder.toString());
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("[upload2]VideoTrimmer", 2, "trimVideoByHW, step: Try to compress using MediaCodec");
        }
        paramString2 = new VideoTrimmer.HWCompressProcessor(paramString2, (int)(localVideoConverterConfig.srcBitrate * 1024L), (int)localVideoConverterConfig.srcFrameRate, paramBoolean, paramLong1, paramLong2);
        i = new VideoConverter(new VideoConverterLog());
        i.setCompressMode(1);
        i2 = i.startCompress(MobileQQ.sMobileQQ, paramString1, paramString2, true);
        if ((i2 != 0) && (i2 != -1002))
        {
          if (QLog.isColorLevel()) {
            QLog.d("[upload2]VideoTrimmer", 2, "trimVideoByHW, step: compress failed using MediaCodec");
          }
          return -2;
        }
        if (paramString2.g)
        {
          if (QLog.isColorLevel()) {
            QLog.d("[upload2]VideoTrimmer", 2, "trimVideoByHW, step: compress canceled using MediaCodec");
          }
          return 1;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("[upload2]VideoTrimmer", 2, "trimVideoByHW, step: compress completed using MediaCodec");
          return 0;
        }
      }
      else
      {
        return -3;
      }
    }
    else
    {
      i1 = -1;
    }
    return i1;
  }
  
  private static String a(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong < 0L) {
      l1 = 0L;
    }
    double d1 = l1;
    Double.isNaN(d1);
    return String.valueOf(d1 * 1.0D / 1000.0D);
  }
  
  public static void a(String paramString)
  {
    VideoConverter localVideoConverter = i;
    if (localVideoConverter != null) {
      localVideoConverter.cancelCompress();
    }
    PublishVideoCompressor.a(paramString);
  }
  
  private static String[] a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, boolean paramBoolean, int paramInt)
  {
    String str2 = a(paramLong1);
    String str3 = a(paramLong2 - paramLong1);
    boolean bool;
    try
    {
      bool = QCircleHostVideoHelper.checkAndLoadAVCodec();
      try
      {
        paramString1 = QCircleHostVideoHelper.getRealProperties(paramString2, o, 1);
      }
      catch (Throwable paramString1) {}
      localObject1 = new StringBuilder();
    }
    catch (Throwable paramString1)
    {
      bool = false;
    }
    Object localObject1;
    ((StringBuilder)localObject1).append("generateCommand error:");
    ((StringBuilder)localObject1).append(bool);
    QLog.e("[upload2]VideoTrimmer", 1, ((StringBuilder)localObject1).toString(), paramString1);
    paramString1 = null;
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    Object localObject2 = paramString1.split(",");
    if (localObject2.length >= 4)
    {
      if (!localObject2[0].equals("0")) {
        return null;
      }
      int i2 = Integer.valueOf(localObject2[3]).intValue();
      if ((L != 0) && (a() >= 2)) {
        paramString1 = "2";
      } else {
        paramString1 = "1";
      }
      Object localObject3;
      try
      {
        localObject3 = (ActivityManager)MobileQQ.sMobileQQ.getSystemService("activity");
        localObject1 = new ActivityManager.MemoryInfo();
        ((ActivityManager)localObject3).getMemoryInfo((ActivityManager.MemoryInfo)localObject1);
        i1 = PublishVideoUtils.a(s, paramBoolean);
        try
        {
          if (((ActivityManager.MemoryInfo)localObject1).availMem < i1) {
            if (!paramBoolean)
            {
              s = "ultrafast";
            }
            else
            {
              i3 = PublishVideoUtils.a("ultrafast", true);
              if (((ActivityManager.MemoryInfo)localObject1).availMem > i3) {
                s = "superfast";
              } else {
                s = "ultrafast";
              }
            }
          }
          if (!QLog.isColorLevel()) {
            break label414;
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("availMem=");
          ((StringBuilder)localObject3).append(((ActivityManager.MemoryInfo)localObject1).availMem);
          ((StringBuilder)localObject3).append(", threshold=");
          ((StringBuilder)localObject3).append(((ActivityManager.MemoryInfo)localObject1).threshold);
          ((StringBuilder)localObject3).append(", lowMem=");
          ((StringBuilder)localObject3).append(((ActivityManager.MemoryInfo)localObject1).lowMemory);
          ((StringBuilder)localObject3).append(", minRam=");
          ((StringBuilder)localObject3).append(i1);
          ((StringBuilder)localObject3).append(", preset=");
          ((StringBuilder)localObject3).append(s);
          QLog.d("[upload2]VideoTrimmer", 2, ((StringBuilder)localObject3).toString());
        }
        catch (Exception localException1) {}
        if (paramBoolean) {
          break label398;
        }
      }
      catch (Exception localException2) {}
      s = "ultrafast";
      break label403;
      label398:
      s = "superfast";
      label403:
      QLog.w("[upload2]VideoTrimmer", 1, localException2.getMessage());
      label414:
      int i1 = QzoneConfig.getInstance().getConfig("TrimVideo", "videoRetryDownLow", f);
      int i3 = QzoneConfig.getInstance().getConfig("TrimVideo", "videoRetryDownMedium", g);
      int i4 = QzoneConfig.getInstance().getConfig("TrimVideo", "videoRetryDownHigh", h);
      if (paramInt >= i1) {
        s = "ultrafast";
      }
      String str1;
      if (paramInt >= i3) {
        str1 = "1";
      } else {
        str1 = paramString1;
      }
      if (paramInt >= i4)
      {
        i1 = 10;
        Process.setThreadPriority(10);
      }
      else
      {
        Process.setThreadPriority(0);
        i1 = 0;
      }
      TrimVideoThread.a = i1;
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("retryNum=");
        paramString1.append(paramInt);
        paramString1.append(", preset=");
        paramString1.append(s);
        paramString1.append(", priority=");
        paramString1.append(i1);
        paramString1.append(", threads=");
        paramString1.append(str1);
        QLog.d("[upload2]VideoTrimmer", 2, paramString1.toString());
      }
      i3 = p;
      i4 = H;
      if ((!paramBoolean) && (m))
      {
        i1 = Integer.valueOf(localObject2[1]).intValue();
        paramInt = Integer.valueOf(localObject2[2]).intValue();
        i1 = Math.round(i1 * 1.0F / 16.0F) * 16;
        int i5 = Math.round(paramInt * 1.0F / 16.0F) * 16;
        if (i2 != 0)
        {
          if (i2 == 1) {
            break label725;
          }
          if (i2 != 2)
          {
            if (i2 == 3) {
              break label725;
            }
            paramString1 = "";
            break label782;
          }
        }
        break label755;
        label725:
        paramString1 = String.format("%dx%d", new Object[] { Integer.valueOf(i5), Integer.valueOf(i1) });
        break label782;
        label755:
        paramString1 = String.format("%dx%d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i5) });
        label782:
        if (!K)
        {
          paramInt = Math.max(i1, i5);
          i2 = o;
          if (paramInt < i2)
          {
            double d1 = n;
            Double.isNaN(d1);
            double d2 = i2;
            Double.isNaN(d2);
            d1 = d1 * 1.0D / d2;
            d2 = paramInt;
            Double.isNaN(d2);
            paramInt = (int)(d1 * d2);
          }
          else
          {
            paramInt = n;
          }
        }
        else
        {
          paramInt = n;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("videoMaxBitrate=");
          ((StringBuilder)localObject2).append(n);
          ((StringBuilder)localObject2).append(" videoBitrate=");
          ((StringBuilder)localObject2).append(paramInt);
          ((StringBuilder)localObject2).append(" videoLongestEdge=");
          ((StringBuilder)localObject2).append(o);
          ((StringBuilder)localObject2).append(" outputWidth=");
          ((StringBuilder)localObject2).append(i1);
          ((StringBuilder)localObject2).append(" outputHeight=");
          ((StringBuilder)localObject2).append(i5);
          ((StringBuilder)localObject2).append(" frameRate=");
          ((StringBuilder)localObject2).append(p);
          ((StringBuilder)localObject2).append(" audioMaxSample=");
          ((StringBuilder)localObject2).append(q);
          ((StringBuilder)localObject2).append(" audioMaxBitrate=");
          ((StringBuilder)localObject2).append(r);
          QLog.d("[upload2]VideoTrimmer", 2, ((StringBuilder)localObject2).toString());
        }
        localObject3 = w.split(" ");
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add("-threads");
        ((ArrayList)localObject2).add(str1);
        ((ArrayList)localObject2).add("-ss");
        ((ArrayList)localObject2).add(str2);
        ((ArrayList)localObject2).add("-accurate_seek");
        ((ArrayList)localObject2).add("-i");
        ((ArrayList)localObject2).add(paramString2);
        ((ArrayList)localObject2).add("-t");
        ((ArrayList)localObject2).add(str3);
        ((ArrayList)localObject2).add("-s");
        ((ArrayList)localObject2).add(paramString1);
        ((ArrayList)localObject2).add("-acodec");
        ((ArrayList)localObject2).add("aac");
        ((ArrayList)localObject2).add("-vcodec");
        ((ArrayList)localObject2).add("libx264");
        ((ArrayList)localObject2).add("-movflags");
        ((ArrayList)localObject2).add("faststart");
        ((ArrayList)localObject2).add("-preset");
        ((ArrayList)localObject2).add(s);
        ((ArrayList)localObject2).add("-tune");
        ((ArrayList)localObject2).add(t);
        ((ArrayList)localObject2).add("-profile:v");
        ((ArrayList)localObject2).add(u);
        ((ArrayList)localObject2).add("-level");
        ((ArrayList)localObject2).add(v);
        i1 = 0;
        while (i1 < localObject3.length)
        {
          if (!TextUtils.isEmpty(localObject3[i1])) {
            ((ArrayList)localObject2).add(localObject3[i1]);
          }
          i1 += 1;
        }
        ((ArrayList)localObject2).add("-x264-params");
        paramString1 = new StringBuilder();
        paramString1.append("vbv-maxrate=");
        paramInt /= 1000;
        paramString1.append(paramInt);
        paramString1.append(":vbv-bufsize=");
        paramString1.append(paramInt);
        ((ArrayList)localObject2).add(paramString1.toString());
        ((ArrayList)localObject2).add("-g");
        ((ArrayList)localObject2).add(String.valueOf(i3 * i4));
        ((ArrayList)localObject2).add("-b:a");
        ((ArrayList)localObject2).add(String.valueOf(r));
        ((ArrayList)localObject2).add("-r:v");
        ((ArrayList)localObject2).add(String.valueOf(p));
        ((ArrayList)localObject2).add("-ar");
        ((ArrayList)localObject2).add(String.valueOf(q));
        ((ArrayList)localObject2).add("-y");
        ((ArrayList)localObject2).add(paramString3);
        paramString1 = (String[])((ArrayList)localObject2).toArray(new String[((ArrayList)localObject2).size()]);
      }
      else
      {
        paramString1 = w.split(" ");
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add("-threads");
        ((ArrayList)localObject2).add(str1);
        ((ArrayList)localObject2).add("-ss");
        ((ArrayList)localObject2).add(str2);
        ((ArrayList)localObject2).add("-accurate_seek");
        ((ArrayList)localObject2).add("-i");
        ((ArrayList)localObject2).add(paramString2);
        ((ArrayList)localObject2).add("-t");
        ((ArrayList)localObject2).add(str3);
        ((ArrayList)localObject2).add("-acodec");
        ((ArrayList)localObject2).add("aac");
        ((ArrayList)localObject2).add("-vcodec");
        ((ArrayList)localObject2).add("libx264");
        ((ArrayList)localObject2).add("-movflags");
        ((ArrayList)localObject2).add("faststart");
        ((ArrayList)localObject2).add("-preset");
        ((ArrayList)localObject2).add(s);
        ((ArrayList)localObject2).add("-tune");
        ((ArrayList)localObject2).add(t);
        ((ArrayList)localObject2).add("-profile:v");
        ((ArrayList)localObject2).add(u);
        ((ArrayList)localObject2).add("-level");
        ((ArrayList)localObject2).add(v);
        paramInt = 0;
        while (paramInt < paramString1.length)
        {
          if (!TextUtils.isEmpty(paramString1[paramInt])) {
            ((ArrayList)localObject2).add(paramString1[paramInt]);
          }
          paramInt += 1;
        }
        ((ArrayList)localObject2).add("-y");
        ((ArrayList)localObject2).add(paramString3);
        paramString1 = (String[])((ArrayList)localObject2).toArray(new String[((ArrayList)localObject2).size()]);
      }
      if (QLog.isColorLevel())
      {
        i1 = paramString1.length;
        paramInt = 0;
        while (paramInt < i1)
        {
          paramString2 = paramString1[paramInt];
          paramString3 = new StringBuilder();
          paramString3.append(paramString2);
          paramString3.append("\n");
          QLog.d("[upload2]VideoTrimmer", 2, paramString3.toString());
          paramInt += 1;
        }
      }
      return paramString1;
    }
    return null;
  }
  
  private static void l()
  {
    j = QzoneConfig.getInstance().getConfig("MiniVideo", "videoTrimEnableHw", 1);
    l = QzoneConfig.getInstance().getConfig("MiniVideo", "videoTimeNoTrimThreshold", 1000);
    boolean bool1;
    if (QzoneConfig.getInstance().getConfig("MiniVideo", "ClientCompress", 1) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    m = bool1;
    n = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoMaxBitrate", 700000);
    o = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoLongestEdge", 960);
    p = QzoneConfig.getInstance().getConfig("MiniVideo", "FrameRate", 24);
    q = QzoneConfig.getInstance().getConfig("MiniVideo", "AudioMaxSample", 44100);
    r = QzoneConfig.getInstance().getConfig("MiniVideo", "AudioMaxBitrate", 64000);
    if (QCircleHostQzoneHelper.meetHardwareRestriction(QCircleHostQzoneHelper.HARDWARE_LOWLEVEL(), QCircleHostQzoneHelper.HARDWARE_HIGHLEVEL())) {
      s = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoPreset", "medium");
    } else {
      s = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoPresetForLowCpu", "veryfast");
    }
    t = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoTune", "ssim");
    u = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoProfile", "high");
    v = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoLevel", "3.0");
    H = QzoneConfig.getInstance().getConfig("MiniVideo", "iFrameInterval", 1);
    w = QzoneConfig.getInstance().getConfig("MiniVideo", "OtherConfig", "-refs 2 -subq 3 -me_method hex -sws_flags lanczos -rc-lookahead 30  -weightp 1");
    x = QzoneConfig.getInstance().getConfig("MiniVideo", "HwVideoProfile", "high");
    y = QzoneConfig.getInstance().getConfig("MiniVideo", "HwFrameRate", 30);
    A = QzoneConfig.getInstance().getConfig("MiniVideo", "HwVideoLongestEdge", 960);
    B = QzoneConfig.getInstance().getConfig("MiniVideo", "HwVideoMaxBitrate", 700000);
    F = QzoneConfig.getInstance().getConfig("MiniVideo", "HwCompressBlackList", "TRT-AL00|TRT-AL00A|KNT-AL10|NXT-AL10|HUAWEI NXT-TL00|HUAWEI NXT-DL00|HUAWEI NXT-CL00|OPPO R9s|OPPO R9s Plus|OPPO R11|OPPO R11 Plus|OPPO R11t|OPPO R11t Plus|OPPO R11s|OPPO R11s Plus|OPPO R11st|OPPO R11s Plust|PACM00|PACT00|PAAM00|PAAT00|vivo x9|vivo x9Plus|vivo x20|vivo X20A|vivo X20Plus A|vivo x20Plus|x21a|x21ud|x21uda|vivo y85|vivo y85a|M5 Note");
    G = QzoneConfig.getInstance().getConfig("MiniVideo", "HwCompressWhiteListAndroidVersion", 24);
    z = QzoneConfig.getInstance().getConfig("MiniVideo", "HwVideoLevel", "4.0");
    C = QzoneConfig.getInstance().getConfig("MiniVideo", "HwVideoBitrateMode", 1);
    E = QzoneConfig.getInstance().getConfig("MiniVideo", "ForceHwCompressList", "BKL-AL20|EML-AL00");
    L = QzoneConfig.getInstance().getConfig("MiniVideo", "videoTrimSupportMultiThread", 1);
    String[] arrayOfString3 = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoNewVideoCompressParamAll", "0,1280,2000000|0,1280,2000000|960,700000|960,700000").split("\\|");
    D = true;
    try
    {
      if (arrayOfString3.length != 4) {
        break label732;
      }
      localObject = arrayOfString3[0].split(",");
      arrayOfString1 = arrayOfString3[1].split(",");
      String[] arrayOfString2 = arrayOfString3[2].split(",");
      arrayOfString3 = arrayOfString3[3].split(",");
      if ((arrayOfString2.length == 2) && (arrayOfString3.length == 2))
      {
        o = Integer.valueOf(arrayOfString2[0]).intValue();
        n = Integer.valueOf(arrayOfString2[1]).intValue();
        A = Integer.valueOf(arrayOfString3[0]).intValue();
        B = Integer.valueOf(arrayOfString3[1]).intValue();
      }
      if ((!D) || (localObject.length != 3) || (arrayOfString1.length != 3)) {
        break label732;
      }
      Integer.valueOf(localObject[0]).intValue();
      o = Integer.valueOf(localObject[1]).intValue();
      n = Integer.valueOf(localObject[2]).intValue();
      A = Integer.valueOf(arrayOfString1[1]).intValue();
      B = Integer.valueOf(arrayOfString1[2]).intValue();
    }
    catch (Throwable localThrowable1)
    {
      Object localObject;
      String[] arrayOfString1;
      label694:
      break label694;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isQualityDebugEnable=");
    ((StringBuilder)localObject).append(k);
    QLog.i("[upload2]VideoTrimmer", 1, ((StringBuilder)localObject).toString());
    label732:
    if (K)
    {
      QLog.i("[upload2]VideoTrimmer", 1, "use Qcircle rate...");
      arrayOfString1 = QzoneConfig.getInstance().getConfig("MiniVideo", "QcircleVideoNewVideoCompressParamAll", "1280,3000000|1280,3000000").split("\\|");
    }
    try
    {
      if (arrayOfString1.length != 2) {
        break label894;
      }
      localObject = arrayOfString1[0].split(",");
      arrayOfString1 = arrayOfString1[1].split(",");
      o = Integer.valueOf(localObject[0]).intValue();
      n = Integer.valueOf(localObject[1]).intValue();
      A = Integer.valueOf(arrayOfString1[0]).intValue();
      B = Integer.valueOf(arrayOfString1[1]).intValue();
    }
    catch (Throwable localThrowable2)
    {
      label856:
      boolean bool2;
      int i1;
      int i2;
      int i3;
      int i4;
      int i5;
      int i6;
      int i7;
      int i8;
      int i9;
      break label856;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isQualityDebugEnable=");
    ((StringBuilder)localObject).append(k);
    QLog.i("[upload2]VideoTrimmer", 1, ((StringBuilder)localObject).toString());
    label894:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("loadConfig enableHW=");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(" timeThreshold=");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append(" clientCompress=");
    ((StringBuilder)localObject).append(m);
    ((StringBuilder)localObject).append(" videoMaxBitrate=");
    ((StringBuilder)localObject).append(n);
    ((StringBuilder)localObject).append(" videoLongestEdge=");
    ((StringBuilder)localObject).append(o);
    ((StringBuilder)localObject).append(" frameRate=");
    ((StringBuilder)localObject).append(p);
    ((StringBuilder)localObject).append(" audioMaxSample=");
    ((StringBuilder)localObject).append(q);
    ((StringBuilder)localObject).append(" audioMaxBitrate=");
    ((StringBuilder)localObject).append(r);
    ((StringBuilder)localObject).append(" preset=");
    ((StringBuilder)localObject).append(s);
    ((StringBuilder)localObject).append(" tune=");
    ((StringBuilder)localObject).append(t);
    ((StringBuilder)localObject).append(" profile=");
    ((StringBuilder)localObject).append(u);
    ((StringBuilder)localObject).append(" level=");
    ((StringBuilder)localObject).append(v);
    ((StringBuilder)localObject).append(" mHwVideoLongestEdge:");
    ((StringBuilder)localObject).append(A);
    ((StringBuilder)localObject).append(" mHwVideoMaxBitrate:");
    ((StringBuilder)localObject).append(B);
    QLog.i("[upload2]VideoTrimmer", 1, ((StringBuilder)localObject).toString());
    k = QCircleHostQzoneHelper.getBool("key_video_quality_debug_enable", false);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isQualityDebugEnable=");
      ((StringBuilder)localObject).append(k);
      QLog.i("[upload2]VideoTrimmer", 1, ((StringBuilder)localObject).toString());
    }
    if (k)
    {
      bool1 = QCircleHostQzoneHelper.getBool("key_force_software_encode", false);
      bool2 = QCircleHostQzoneHelper.getBool("key_video_quality_only_change_encode_mode", false);
      I = QCircleHostQzoneHelper.getBool("key_force_software_encode", false);
      i1 = QCircleHostQzoneHelper.getInt("key_video_quality_long_edge", o);
      i2 = QCircleHostQzoneHelper.getInt("key_video_quality_bitrate", n / 1000) * 1000;
      i3 = QCircleHostQzoneHelper.getInt("key_video_quality_frame_rate", p);
      i4 = QCircleHostQzoneHelper.getInt("key_video_quality_i_frame_interval", H);
      i5 = QCircleHostQzoneHelper.getInt("key_video_quality_profile", 0);
      i6 = QCircleHostQzoneHelper.getInt("key_video_quality_level", 0);
      i7 = QCircleHostQzoneHelper.getInt("key_video_quality_preset", 0);
      i8 = QCircleHostQzoneHelper.getInt("key_video_quality_tune", 0);
      i9 = QCircleHostQzoneHelper.getInt("key_video_quality_encode_mode", 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadConfig debug quality, forceSoftwareEncode=");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(" forceHardwareEncode=");
      ((StringBuilder)localObject).append(I);
      ((StringBuilder)localObject).append(" debugLongEdge=");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(" debugBitrate=");
      ((StringBuilder)localObject).append(i2);
      ((StringBuilder)localObject).append(" debugFrameRate=");
      ((StringBuilder)localObject).append(i3);
      ((StringBuilder)localObject).append(" debugIFrameInterval=");
      ((StringBuilder)localObject).append(i4);
      ((StringBuilder)localObject).append(" debugProfile=");
      ((StringBuilder)localObject).append(a[i5]);
      ((StringBuilder)localObject).append(" debugLevel=");
      ((StringBuilder)localObject).append(b[i6]);
      ((StringBuilder)localObject).append(" debugPreset=");
      ((StringBuilder)localObject).append(c[i7]);
      ((StringBuilder)localObject).append(" debugTune=");
      ((StringBuilder)localObject).append(d[i8]);
      QLog.i("[upload2]VideoTrimmer", 1, ((StringBuilder)localObject).toString());
      if (bool1) {
        j = 0;
      }
      if (!bool2)
      {
        o = i1;
        n = i2;
        p = i3;
        H = i4;
        u = a[i5];
        v = b[i6];
        s = c[i7];
        t = d[i8];
      }
      if (i9 == 0)
      {
        s = c[5];
        w = "-refs 3 -subq 3 -me_method hex";
      }
      else if (i9 == 1)
      {
        s = c[8];
        w = "";
      }
    }
    if (J)
    {
      n = QzoneConfig.getInstance().getConfig("MiniVideo", "WeishiVideoMaxBitrate", 3000000);
      o = QzoneConfig.getInstance().getConfig("MiniVideo", "WeishiVideoLongestEdge", 1280);
    }
  }
  
  private static boolean m()
  {
    Object localObject = PublishVideoCommonUtils.a();
    if (!((PublishVideoCommonUtils.VideoSupport)localObject).a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isHwCompressEnable: hardware trim support not available : ");
      localStringBuilder.append(((PublishVideoCommonUtils.VideoSupport)localObject).b());
      QLog.i("[upload2]VideoTrimmer", 1, localStringBuilder.toString());
      return false;
    }
    if (Build.MODEL == null) {
      localObject = "";
    } else {
      localObject = Build.MODEL.trim().toLowerCase();
    }
    if (CheckListUtil.a(E, "\\|", (String)localObject, "[upload2]VideoTrimmer"))
    {
      QLog.i("[upload2]VideoTrimmer", 1, "isHwCompressEnable: in force compress list");
      I = true;
      return true;
    }
    if (j != 1)
    {
      QLog.i("[upload2]VideoTrimmer", 1, "isHwCompressEnable: enableHw != 1");
      return false;
    }
    if (Build.VERSION.SDK_INT < G)
    {
      QLog.i("[upload2]VideoTrimmer", 1, "isHwCompressEnable：sdk too low");
      return false;
    }
    if (CheckListUtil.a(F, "\\|", (String)localObject, "[upload2]VideoTrimmer"))
    {
      QLog.i("[upload2]VideoTrimmer", 1, "isHwCompressEnable: in black list");
      return false;
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("xiaomi"))
    {
      QLog.i("[upload2]VideoTrimmer", 1, "isHwCompressEnable: xiaomi");
      return false;
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("huawei"))
    {
      QLog.i("[upload2]VideoTrimmer", 1, "isHwCompressEnable: huawei");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.service.video.VideoTrimmer
 * JD-Core Version:    0.7.0.1
 */