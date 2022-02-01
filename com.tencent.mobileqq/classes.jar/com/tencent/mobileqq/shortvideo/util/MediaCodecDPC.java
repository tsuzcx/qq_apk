package com.tencent.mobileqq.shortvideo.util;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.qphone.base.util.QLog;

public class MediaCodecDPC
{
  public static MediaCodecDPC a;
  public float a;
  public int a;
  public int b = 1;
  public int c = 1;
  public int d = 1;
  public int e = 1;
  public int f = -1;
  public int g = 1;
  public int h = 6000;
  public int i = 1;
  public int j = 0;
  public int k = 3;
  public int l = 0;
  public int m = 0;
  public int n = 1;
  public int o = 0;
  public int p = 1;
  public int q = 1;
  public int r = 1;
  public int s = 1;
  public int t = 1;
  public int u = -1;
  public int v = -1;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqShortvideoUtilMediaCodecDPC = null;
  }
  
  public MediaCodecDPC()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public static float a()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    if (localMediaCodecDPC != null) {
      return localMediaCodecDPC.jdField_a_of_type_Float;
    }
    return 1.0F;
  }
  
  public static int a()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    if (localMediaCodecDPC != null) {
      return localMediaCodecDPC.f;
    }
    return -1;
  }
  
  public static MediaCodecDPC a()
  {
    if (jdField_a_of_type_ComTencentMobileqqShortvideoUtilMediaCodecDPC == null) {
      jdField_a_of_type_ComTencentMobileqqShortvideoUtilMediaCodecDPC = b();
    }
    return jdField_a_of_type_ComTencentMobileqqShortvideoUtilMediaCodecDPC;
  }
  
  public static boolean a()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC != null) && (localMediaCodecDPC.jdField_a_of_type_Int == 1);
  }
  
  public static int b()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    if (localMediaCodecDPC != null) {
      return localMediaCodecDPC.h;
    }
    return 6000;
  }
  
  public static MediaCodecDPC b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaCodecDPC", 2, "loadMediaCodecDPC!");
    }
    MediaCodecDPC localMediaCodecDPC = new MediaCodecDPC();
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.SVideoCfg.name());
    if (QLog.isColorLevel()) {
      QLog.i("MediaCodecDPC", 2, "loadMediaCodecDPC dpcValue: " + (String)localObject);
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return localMediaCodecDPC;
    }
    for (;;)
    {
      try
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject == null) {
          return localMediaCodecDPC;
        }
        if (localObject.length >= 1) {
          localMediaCodecDPC.jdField_a_of_type_Int = Integer.valueOf(localObject[0]).intValue();
        }
        if (localObject.length >= 2) {
          localMediaCodecDPC.b = Integer.valueOf(localObject[1]).intValue();
        }
        if (localObject.length >= 4)
        {
          f1 = Float.valueOf(localObject[2]).floatValue();
          localMediaCodecDPC.c = Integer.valueOf(localObject[3]).intValue();
          if ((f1 > 1.0D) || (f1 <= 0.0F)) {
            continue;
          }
          localMediaCodecDPC.jdField_a_of_type_Float = f1;
        }
        if (localObject.length >= 5) {
          localMediaCodecDPC.d = Integer.valueOf(localObject[4]).intValue();
        }
        if (localObject.length >= 6) {
          localMediaCodecDPC.e = Integer.valueOf(localObject[5]).intValue();
        }
        if (localObject.length >= 7) {
          localMediaCodecDPC.f = Integer.valueOf(localObject[6]).intValue();
        }
        if (localObject.length >= 8) {
          localMediaCodecDPC.g = Integer.valueOf(localObject[7]).intValue();
        }
        if (localObject.length >= 9) {
          localMediaCodecDPC.h = Integer.valueOf(localObject[8]).intValue();
        }
        if (localObject.length >= 10) {
          localMediaCodecDPC.i = Integer.valueOf(localObject[9]).intValue();
        }
        if (localObject.length >= 12)
        {
          localMediaCodecDPC.j = Integer.valueOf(localObject[10]).intValue();
          localMediaCodecDPC.k = Integer.valueOf(localObject[11]).intValue();
        }
        if (localObject.length >= 13) {
          localMediaCodecDPC.l = Integer.valueOf(localObject[12]).intValue();
        }
        if (localObject.length >= 14) {
          localMediaCodecDPC.m = Integer.valueOf(localObject[13]).intValue();
        }
        if (localObject.length >= 15) {
          localMediaCodecDPC.n = Integer.valueOf(localObject[14]).intValue();
        }
        if (localObject.length >= 16) {
          localMediaCodecDPC.o = Integer.valueOf(localObject[15]).intValue();
        }
        if (localObject.length >= 17) {
          localMediaCodecDPC.p = Integer.valueOf(localObject[16]).intValue();
        }
        if (localObject.length >= 18) {
          localMediaCodecDPC.q = Integer.valueOf(localObject[17]).intValue();
        }
        if (localObject.length >= 19) {
          localMediaCodecDPC.r = Integer.valueOf(localObject[18]).intValue();
        }
        if (localObject.length >= 21)
        {
          localMediaCodecDPC.s = Integer.valueOf(localObject[19]).intValue();
          localMediaCodecDPC.t = Integer.valueOf(localObject[20]).intValue();
        }
        if (localObject.length >= 23)
        {
          localMediaCodecDPC.u = Integer.valueOf(localObject[21]).intValue();
          localMediaCodecDPC.v = Integer.valueOf(localObject[22]).intValue();
        }
      }
      catch (Exception localException)
      {
        float f1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MediaCodecDPC", 2, "loadMediaCodecDPC exception:", localException);
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MediaCodecDPC", 2, "MediaCodecDPC:" + localMediaCodecDPC.toString());
      }
      return localMediaCodecDPC;
      QLog.e("MediaCodecDPC", 1, new Object[] { "MediaCodecDPC:  beautyRate: ", Float.valueOf(f1) });
    }
  }
  
  public static boolean b()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC != null) && (localMediaCodecDPC.b == 1);
  }
  
  public static int c()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    if (localMediaCodecDPC != null) {
      return localMediaCodecDPC.u;
    }
    return -1;
  }
  
  public static boolean c()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC != null) && (localMediaCodecDPC.c == 1);
  }
  
  public static int d()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    if (localMediaCodecDPC != null) {
      return localMediaCodecDPC.v;
    }
    return -1;
  }
  
  public static boolean d()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC != null) && (localMediaCodecDPC.d == 1);
  }
  
  public static boolean e()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC != null) && (localMediaCodecDPC.e == 1);
  }
  
  public static boolean f()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC != null) && (localMediaCodecDPC.g == 1);
  }
  
  public static boolean g()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC != null) && (localMediaCodecDPC.i == 1);
  }
  
  public static boolean h()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC != null) && (localMediaCodecDPC.l == 1);
  }
  
  public static boolean i()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC != null) && (localMediaCodecDPC.m == 1);
  }
  
  public static boolean j()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC != null) && (localMediaCodecDPC.n == 1);
  }
  
  public static boolean k()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC != null) && (localMediaCodecDPC.p == 1);
  }
  
  public static boolean l()
  {
    if (!CameraCompatibleList.f()) {}
    MediaCodecDPC localMediaCodecDPC;
    do
    {
      return false;
      localMediaCodecDPC = a();
    } while ((localMediaCodecDPC != null) && (localMediaCodecDPC.r == 0));
    return true;
  }
  
  public static boolean m()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC != null) && (localMediaCodecDPC.q == 1);
  }
  
  public static boolean n()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC == null) || (localMediaCodecDPC.s == 1);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mediaCodecSwitch: ").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" beautySwitch: ").append(this.b);
    localStringBuilder.append(" beautyRate: ").append(this.jdField_a_of_type_Float);
    localStringBuilder.append(" svafSwitch: ").append(this.c);
    localStringBuilder.append(" gestureDPCSwitch: ").append(this.d);
    localStringBuilder.append(" deNoiseDPCSwitch: ").append(this.e);
    localStringBuilder.append(" qmcfDPCFrameType: ").append(this.f);
    localStringBuilder.append(" cqBitrateModeSwitch: ").append(this.g);
    localStringBuilder.append(" cqMaxBitrate: ").append(this.h);
    localStringBuilder.append(" faceDanceDPCSwitch: ").append(this.i);
    localStringBuilder.append(" portraitDPCSwitch: ").append(this.l);
    localStringBuilder.append(" danceRankingSwitch: ").append(this.m);
    localStringBuilder.append(" arParticleDPCSwitch: ").append(this.n);
    localStringBuilder.append(" rijiCameraDPCSwitch: ").append(this.o);
    localStringBuilder.append(" segmentMediaCodecEncodeSwitch: ").append(this.p);
    localStringBuilder.append(" transitionSwitch: ").append(this.q);
    localStringBuilder.append(" rijiCamera720PSwitch: ").append(this.r);
    localStringBuilder.append(" followCaptureSwitch: ").append(this.s);
    localStringBuilder.append(" followCaptureGopSize: ").append(this.t);
    localStringBuilder.append(" mLimittedSdkVersion: ").append(this.u);
    localStringBuilder.append(" camera2Switch: ").append(this.v);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.MediaCodecDPC
 * JD-Core Version:    0.7.0.1
 */