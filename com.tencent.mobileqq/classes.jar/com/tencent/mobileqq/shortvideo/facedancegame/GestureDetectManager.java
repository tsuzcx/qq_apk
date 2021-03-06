package com.tencent.mobileqq.shortvideo.facedancegame;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.util.Log;
import com.tencent.av.avgesture.AVGestureWrapper;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.mobileqq.shortvideo.resource.GestureGameResource;
import com.tencent.mobileqq.shortvideo.resource.GestureResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.openapi.util.RetrieveDataManager;
import com.tencent.ttpic.openapi.util.RetrieveDataManager.DATA_TYPE;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@SuppressLint({"NewApi"})
public class GestureDetectManager
{
  public static final String GestureSoName = "libAVGesture4Android.so";
  private static final String TAG = "GestureDetectManager";
  private static GestureDetectManager instance = new GestureDetectManager();
  boolean bModelLoaded = false;
  boolean bSoLoaded = false;
  
  public static boolean copyFileFromAssets(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new FileInputStream(new File(Environment.getExternalStorageDirectory(), paramString1));
      paramString2 = new File(paramString2);
      paramString2.createNewFile();
      paramString2 = new FileOutputStream(paramString2);
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = paramString1.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        paramString2.write(arrayOfByte, 0, i);
      }
      paramString2.close();
      paramString1.close();
      return true;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
      paramString2 = new StringBuilder();
      paramString2.append("[copyFileFromAssets] IOException ");
      paramString2.append(paramString1.toString());
      Log.e("MainActivity", paramString2.toString());
    }
    return false;
  }
  
  public static GestureDetectManager getInstance()
  {
    return instance;
  }
  
  private boolean innerLoadModel()
  {
    if (!this.bSoLoaded) {
      return false;
    }
    try
    {
      String str = SdkContext.getInstance().getResources().geteGestureGameResource().getGameModelPath();
      AVGestureWrapper.setFilePath(str, str, "");
      AVGestureWrapper.setGlobalConfigFile(str);
      AVGestureWrapper.setAVGestureReport(new GestureDetectManager.1(this));
      AVGestureWrapper.setShouldUpload(false);
      SLog.d("GestureDetectManager", String.format("loadSo suc, [%s]", new Object[] { AVGestureWrapper.getVersionInfo() }));
      return false;
    }
    catch (Exception localException)
    {
      SLog.e("GestureDetectManager", String.format("loadSo suc, but setCnnModelPath Exception[%s]", new Object[] { localException.getClass().getName() }), localException);
    }
    return false;
  }
  
  private boolean innerLoadSo()
  {
    try
    {
      if (!SdkContext.getInstance().getResources().getGestureResource().isGestureEnable()) {
        return false;
      }
      String str = SdkContext.getInstance().getResources().getGestureResource().getSoPathDir();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("libAVGesture4Android.so");
      System.load(localStringBuilder.toString());
      return true;
    }
    catch (Throwable localThrowable)
    {
      SLog.e("GestureDetectManager", String.format("System.load Exception[%s]", new Object[] { localThrowable.getClass().getName() }), localThrowable);
    }
    return false;
  }
  
  public boolean LoadSDK()
  {
    boolean bool2 = this.bSoLoaded;
    boolean bool1 = true;
    if ((bool2) && (this.bModelLoaded)) {
      return true;
    }
    try
    {
      if (!this.bSoLoaded) {
        this.bSoLoaded = innerLoadSo();
      }
      if (!this.bModelLoaded) {
        this.bModelLoaded = innerLoadModel();
      }
      if ((!this.bSoLoaded) || (!this.bModelLoaded)) {
        bool1 = false;
      }
      if (bool1) {
        GestureMgrRecognize.getInstance().setModelLoadStatus(2);
      }
      return bool1;
    }
    finally {}
  }
  
  public void ResetModel()
  {
    this.bModelLoaded = false;
  }
  
  public void doGestureDetectWithCallBack(int paramInt1, int paramInt2, int paramInt3, IGestureDetectCallBack paramIGestureDetectCallBack)
  {
    if (!SdkContext.getInstance().getResources().geteGestureGameResource().isGestureGameEnable()) {
      return;
    }
    doGestureDetectWithCallBack(RetrieveDataManager.getInstance().retrieveData(RetrieveDataManager.DATA_TYPE.RGBA.value, paramInt1, paramInt2, paramInt3), paramInt2, paramInt3, paramIGestureDetectCallBack);
  }
  
  public void doGestureDetectWithCallBack(byte[] paramArrayOfByte, int paramInt1, int paramInt2, IGestureDetectCallBack paramIGestureDetectCallBack)
  {
    paramArrayOfByte = new Thread(new GestureDetectManager.2(this, paramArrayOfByte, paramInt1, paramInt2, paramIGestureDetectCallBack));
    paramArrayOfByte.setPriority(10);
    paramArrayOfByte.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.facedancegame.GestureDetectManager
 * JD-Core Version:    0.7.0.1
 */