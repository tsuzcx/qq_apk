package com.tencent.tar.jni;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.tencent.mobileqq.ar.model.CameraProxy.OnCameraPreviewCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IImgProcessApi;
import com.youtu.arsdk.ARShell;
import java.util.ArrayList;

public class CameraPointsExtract
  implements Camera.PreviewCallback, Handler.Callback, CameraProxy.OnCameraPreviewCallback
{
  public final int a = 101;
  public final int b = 102;
  private HandlerThread c = new HandlerThread("CameraPointsExtract_thread");
  private Handler d;
  private TARMarkerNative e = new TARMarkerNative();
  private int f;
  private int g;
  private int h;
  private byte[] i;
  private byte[] j;
  private long k;
  private int l = 150;
  private ArrayList<Integer> m = new ArrayList();
  private ArrayList<Integer> n = new ArrayList();
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  private long s = 500L;
  private long t = -1L;
  private CameraPointsExtract.OnReceiveResultListener u;
  
  public CameraPointsExtract()
  {
    this.c.start();
    this.d = new Handler(this.c.getLooper(), this);
  }
  
  private boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (paramArrayOfByte.length == paramInt1 * paramInt2 * 3 / 2);
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    int i1 = 0;
    int i2 = 0;
    int i3;
    while (i1 < paramInt1)
    {
      i3 = paramInt2 - 1;
      while (i3 >= 0)
      {
        paramArrayOfByte2[i2] = paramArrayOfByte1[(i3 * paramInt1 + i1)];
        i2 += 1;
        i3 -= 1;
      }
      i1 += 1;
    }
    int i4 = paramInt1 * paramInt2;
    i1 = i4 * 3 / 2 - 1;
    i2 = paramInt1 - 1;
    while (i2 > 0)
    {
      i3 = 0;
      while (i3 < paramInt2 / 2)
      {
        int i5 = i3 * paramInt1 + i4;
        paramArrayOfByte2[i1] = paramArrayOfByte1[(i5 + i2)];
        i1 -= 1;
        paramArrayOfByte2[i1] = paramArrayOfByte1[(i5 + (i2 - 1))];
        i1 -= 1;
        i3 += 1;
      }
      i2 -= 2;
    }
    return paramArrayOfByte2;
  }
  
  public int a(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3, ArrayList<Integer> paramArrayList1, ArrayList<Integer> paramArrayList2)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 1))
    {
      int[] arrayOfInt2 = new int['È'];
      int[] arrayOfInt1 = new int[3];
      int[] tmp27_25 = arrayOfInt1;
      tmp27_25[0] = -1;
      int[] tmp31_27 = tmp27_25;
      tmp31_27[1] = 0;
      int[] tmp35_31 = tmp31_27;
      tmp35_31[2] = 0;
      tmp35_31;
      long l1 = System.currentTimeMillis();
      if (this.r)
      {
        ((IImgProcessApi)QRoute.api(IImgProcessApi.class)).YUVrotate(this.j, paramArrayOfByte, paramInt1, paramInt2);
        paramArrayOfByte = this.j;
      }
      else
      {
        paramArrayOfByte = a(paramArrayOfByte, paramInt1, paramInt2, this.j);
      }
      TARMarkerNative localTARMarkerNative = this.e;
      boolean bool;
      if (this.f == 842094169) {
        bool = true;
      } else {
        bool = false;
      }
      paramInt3 = localTARMarkerNative.a(paramInt2, paramInt1, paramArrayOfByte, bool, arrayOfInt2, arrayOfInt1);
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("width:");
      paramArrayOfByte.append(paramInt1);
      paramArrayOfByte.append(" height:");
      paramArrayOfByte.append(paramInt2);
      paramArrayOfByte.append(" ret=");
      paramArrayOfByte.append(paramInt3);
      paramArrayOfByte.append(" out[0]=");
      paramArrayOfByte.append(arrayOfInt1[0]);
      paramArrayOfByte.append(" out[1]=");
      paramArrayOfByte.append(arrayOfInt1[1]);
      paramArrayOfByte.append(" out[2]=");
      paramArrayOfByte.append(arrayOfInt1[2]);
      paramArrayOfByte.append(" use time:");
      paramArrayOfByte.append(System.currentTimeMillis() - l1);
      Log.d("CameraPointsExtract", paramArrayOfByte.toString());
      paramArrayList1.clear();
      if (arrayOfInt1[1] > 0)
      {
        paramInt2 = arrayOfInt1[1];
        paramInt1 = 0;
        while (paramInt1 < paramInt2 * 2)
        {
          paramArrayList1.add(Integer.valueOf(arrayOfInt2[paramInt1]));
          paramInt1 += 1;
        }
      }
      paramArrayList2.clear();
      paramArrayList2.add(Integer.valueOf(arrayOfInt1[2]));
      paramArrayOfByte = this.u;
      if ((paramArrayOfByte != null) && (this.p)) {
        paramArrayOfByte.a(arrayOfInt1, paramArrayList1, this.h, this.g);
      }
      return arrayOfInt1[0];
    }
    return -1;
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    onPreviewFrame(paramArrayOfByte, null);
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 101) && (this.p)) {
      a(this.g, this.h, this.i, 1, this.m, this.n);
    } else if (paramMessage.what == 102) {
      this.o = ARShell.loadARFeatureNativeLibrary();
    }
    return true;
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if ((this.p) && (this.o))
    {
      if (System.currentTimeMillis() < this.t + this.s) {
        return;
      }
      paramCamera = this.d;
      if ((paramCamera != null) && (!paramCamera.hasMessages(101)))
      {
        long l1 = System.currentTimeMillis();
        if (l1 - this.k < this.l) {
          return;
        }
        if (a(paramArrayOfByte, this.g, this.h))
        {
          paramCamera = this.i;
          if ((paramCamera == null) || ((paramCamera != null) && (paramCamera.length != paramArrayOfByte.length)))
          {
            this.i = new byte[paramArrayOfByte.length];
            this.j = new byte[paramArrayOfByte.length];
          }
          System.arraycopy(paramArrayOfByte, 0, this.i, 0, paramArrayOfByte.length);
          this.k = l1;
        }
        else
        {
          this.g = 0;
          this.h = 0;
          this.k = 0L;
        }
        this.d.removeMessages(101);
        this.d.sendEmptyMessage(101);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tar.jni.CameraPointsExtract
 * JD-Core Version:    0.7.0.1
 */