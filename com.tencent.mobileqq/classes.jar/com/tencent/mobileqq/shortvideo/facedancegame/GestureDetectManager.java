package com.tencent.mobileqq.shortvideo.facedancegame;

import ahnb;
import ahnc;
import android.annotation.SuppressLint;
import com.tencent.av.avgesture.AVGestureWrapper;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.mobileqq.shortvideo.resource.GestureGameResource;
import com.tencent.mobileqq.shortvideo.resource.GestureResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;

@SuppressLint({"NewApi"})
public class GestureDetectManager
{
  private static GestureDetectManager jdField_a_of_type_ComTencentMobileqqShortvideoFacedancegameGestureDetectManager = new GestureDetectManager();
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public static GestureDetectManager a()
  {
    return jdField_a_of_type_ComTencentMobileqqShortvideoFacedancegameGestureDetectManager;
  }
  
  private boolean b()
  {
    bool = true;
    try
    {
      if (!SdkContext.a().a().a().b()) {
        return false;
      }
      String str = SdkContext.a().a().a().c();
      System.load(str + "libAVGesture4Android.so");
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        SLog.a("GestureDetectManager", String.format("System.load Exception[%s]", new Object[] { localThrowable.getClass().getName() }), localThrowable);
        bool = false;
      }
    }
    return bool;
  }
  
  private boolean c()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    try
    {
      String str = SdkContext.a().a().a().a();
      AVGestureWrapper.setFcnModelPath(str);
      AVGestureWrapper.setCnnModelPath(str);
      AVGestureWrapper.setGlobalConfigFile(str);
      AVGestureWrapper.setAVGestureReport(new ahnb(this));
      AVGestureWrapper.setShouldUpload(false);
      SLog.d("GestureDetectManager", String.format("loadSo suc, [%s]", new Object[] { AVGestureWrapper.getVersionInfo() }));
      return false;
    }
    catch (Exception localException)
    {
      SLog.a("GestureDetectManager", String.format("loadSo suc, but setCnnModelPath Exception[%s]", new Object[] { localException.getClass().getName() }), localException);
    }
    return false;
  }
  
  public void a()
  {
    this.b = false;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, IGestureDetectCallBack paramIGestureDetectCallBack)
  {
    paramArrayOfByte = new Thread(new ahnc(this, paramArrayOfByte, paramInt1, paramInt2, paramIGestureDetectCallBack));
    paramArrayOfByte.setPriority(10);
    paramArrayOfByte.start();
  }
  
  public boolean a()
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if ((this.jdField_a_of_type_Boolean) && (this.b)) {
      return bool2;
    }
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_Boolean = b();
        }
        if (!this.b) {
          this.b = c();
        }
        if ((this.jdField_a_of_type_Boolean) && (this.b))
        {
          bool2 = bool1;
          if (!bool1) {
            break;
          }
          GestureMgrRecognize.a().a(2);
          return bool1;
        }
      }
      finally {}
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.facedancegame.GestureDetectManager
 * JD-Core Version:    0.7.0.1
 */