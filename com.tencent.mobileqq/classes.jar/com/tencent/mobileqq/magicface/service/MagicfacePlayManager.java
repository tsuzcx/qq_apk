package com.tencent.mobileqq.magicface.service;

import com.tencent.mobileqq.magicface.model.MagicFaceSuperBigDecoder;
import com.tencent.mobileqq.magicface.model.MagicfaceData;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicPlayListener;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicfaceRenderListener;
import com.tencent.mobileqq.magicface.model.MagicfaceFFMepgDecoder;
import com.tencent.mobileqq.magicface.model.MagicfacePlayRes;
import com.tencent.mobileqq.magicface.model.MagicfaceResLoader;
import com.tencent.mobileqq.magicface.model.MagicfaceXBigDecoder;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;

public class MagicfacePlayManager
{
  private MagicfaceResLoader a;
  private MagicfaceDecoder b;
  private MagicfaceDecoder.MagicfaceRenderListener c;
  private SoundPoolUtil d;
  private MagicfaceData e;
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("func init begins, magicfaceDecoder:");
      localStringBuilder.append(this.b);
      QLog.d("MagicfacePlayManager", 2, localStringBuilder.toString());
    }
    if (this.b == null)
    {
      boolean bool = DeviceInfoUtil.L();
      long l = Math.min(DeviceInfoUtil.B(), DeviceInfoUtil.C());
      if ((bool) && (l >= 720L))
      {
        this.b = new MagicFaceSuperBigDecoder();
        if (QLog.isColorLevel()) {
          QLog.d("MagicfacePlayManager", 2, "func init, use [SuperBigDecoder]");
        }
      }
      else if ("xbig".equalsIgnoreCase(MagicfaceResLoader.a()))
      {
        this.b = new MagicfaceXBigDecoder();
        if (QLog.isColorLevel()) {
          QLog.d("MagicfacePlayManager", 2, "func init, use [XBigDecoder]");
        }
      }
      else
      {
        this.b = new MagicfaceFFMepgDecoder();
        if (QLog.isColorLevel()) {
          QLog.d("MagicfacePlayManager", 2, "func init, use [FFMepgDecoder]");
        }
      }
    }
    this.b.a(this.c);
    if (QLog.isColorLevel()) {
      QLog.d("MagicfacePlayManager", 2, "func init ends.");
    }
  }
  
  public void a(int paramInt)
  {
    MagicfaceDecoder localMagicfaceDecoder = this.b;
    if (localMagicfaceDecoder != null) {
      localMagicfaceDecoder.a(paramInt);
    }
  }
  
  public void a(MagicfaceDecoder.MagicPlayListener paramMagicPlayListener)
  {
    MagicfaceDecoder localMagicfaceDecoder = this.b;
    if (localMagicfaceDecoder != null) {
      localMagicfaceDecoder.a(paramMagicPlayListener);
    }
  }
  
  public void a(MagicfaceDecoder.MagicfaceRenderListener paramMagicfaceRenderListener)
  {
    this.c = paramMagicfaceRenderListener;
  }
  
  public void a(MagicfacePlayRes paramMagicfacePlayRes)
  {
    if ((this.e == null) || (!paramMagicfacePlayRes.c.equalsIgnoreCase(this.e.a)))
    {
      this.e = this.a.a(paramMagicfacePlayRes.c, paramMagicfacePlayRes.d);
      this.e.a = paramMagicfacePlayRes.c;
      this.e.b = paramMagicfacePlayRes.d;
    }
    this.b.a(this.e);
    this.b.d();
  }
  
  public void a(MagicfaceResLoader paramMagicfaceResLoader)
  {
    this.a = paramMagicfaceResLoader;
  }
  
  public void a(SoundPoolUtil paramSoundPoolUtil)
  {
    this.d = paramSoundPoolUtil;
  }
  
  public void a(String paramString)
  {
    SoundPoolUtil localSoundPoolUtil = this.d;
    if (localSoundPoolUtil != null) {
      localSoundPoolUtil.b(this.a.b(paramString));
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    SoundPoolUtil localSoundPoolUtil = this.d;
    if (localSoundPoolUtil != null) {
      localSoundPoolUtil.a(this.a.b(paramString), paramInt, 3);
    }
  }
  
  public void b()
  {
    MagicfaceDecoder localMagicfaceDecoder = this.b;
    if (localMagicfaceDecoder != null) {
      localMagicfaceDecoder.e();
    }
  }
  
  public void c()
  {
    MagicfaceDecoder localMagicfaceDecoder = this.b;
    if (localMagicfaceDecoder != null) {
      localMagicfaceDecoder.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.service.MagicfacePlayManager
 * JD-Core Version:    0.7.0.1
 */