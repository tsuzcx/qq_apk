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
  public final int a;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("CameraPointsExtract_thread");
  private CameraPointsExtract.OnReceiveResultListener jdField_a_of_type_ComTencentTarJniCameraPointsExtract$OnReceiveResultListener;
  private TARMarkerNative jdField_a_of_type_ComTencentTarJniTARMarkerNative = new TARMarkerNative();
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte;
  public final int b;
  private long jdField_b_of_type_Long = 500L;
  private ArrayList<Integer> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = -1L;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = false;
  private int e;
  private int f = 150;
  
  public CameraPointsExtract()
  {
    this.jdField_a_of_type_Int = 101;
    this.jdField_b_of_type_Int = 102;
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
  }
  
  private boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (paramArrayOfByte.length == paramInt1 * paramInt2 * 3 / 2);
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    int i = 0;
    int j = 0;
    int k;
    while (i < paramInt1)
    {
      k = paramInt2 - 1;
      while (k >= 0)
      {
        paramArrayOfByte2[j] = paramArrayOfByte1[(k * paramInt1 + i)];
        j += 1;
        k -= 1;
      }
      i += 1;
    }
    int m = paramInt1 * paramInt2;
    i = m * 3 / 2 - 1;
    j = paramInt1 - 1;
    while (j > 0)
    {
      k = 0;
      while (k < paramInt2 / 2)
      {
        int n = k * paramInt1 + m;
        paramArrayOfByte2[i] = paramArrayOfByte1[(n + j)];
        i -= 1;
        paramArrayOfByte2[i] = paramArrayOfByte1[(n + (j - 1))];
        i -= 1;
        k += 1;
      }
      j -= 2;
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
      long l = System.currentTimeMillis();
      if (this.jdField_d_of_type_Boolean)
      {
        ((IImgProcessApi)QRoute.api(IImgProcessApi.class)).YUVrotate(this.jdField_b_of_type_ArrayOfByte, paramArrayOfByte, paramInt1, paramInt2);
        paramArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
      }
      else
      {
        paramArrayOfByte = a(paramArrayOfByte, paramInt1, paramInt2, this.jdField_b_of_type_ArrayOfByte);
      }
      TARMarkerNative localTARMarkerNative = this.jdField_a_of_type_ComTencentTarJniTARMarkerNative;
      boolean bool;
      if (this.jdField_c_of_type_Int == 842094169) {
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
      paramArrayOfByte.append(System.currentTimeMillis() - l);
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
      paramArrayOfByte = this.jdField_a_of_type_ComTencentTarJniCameraPointsExtract$OnReceiveResultListener;
      if ((paramArrayOfByte != null) && (this.jdField_b_of_type_Boolean)) {
        paramArrayOfByte.a(arrayOfInt1, paramArrayList1, this.e, this.jdField_d_of_type_Int);
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
    if ((paramMessage.what == 101) && (this.jdField_b_of_type_Boolean)) {
      a(this.jdField_d_of_type_Int, this.e, this.jdField_a_of_type_ArrayOfByte, 1, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaUtilArrayList);
    } else if (paramMessage.what == 102) {
      this.jdField_a_of_type_Boolean = ARShell.loadARFeatureNativeLibrary();
    }
    return true;
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      if (System.currentTimeMillis() < this.jdField_c_of_type_Long + this.jdField_b_of_type_Long) {
        return;
      }
      paramCamera = this.jdField_a_of_type_AndroidOsHandler;
      if ((paramCamera != null) && (!paramCamera.hasMessages(101)))
      {
        long l = System.currentTimeMillis();
        if (l - this.jdField_a_of_type_Long < this.f) {
          return;
        }
        if (a(paramArrayOfByte, this.jdField_d_of_type_Int, this.e))
        {
          paramCamera = this.jdField_a_of_type_ArrayOfByte;
          if ((paramCamera == null) || ((paramCamera != null) && (paramCamera.length != paramArrayOfByte.length)))
          {
            this.jdField_a_of_type_ArrayOfByte = new byte[paramArrayOfByte.length];
            this.jdField_b_of_type_ArrayOfByte = new byte[paramArrayOfByte.length];
          }
          System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte.length);
          this.jdField_a_of_type_Long = l;
        }
        else
        {
          this.jdField_d_of_type_Int = 0;
          this.e = 0;
          this.jdField_a_of_type_Long = 0L;
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(101);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tar.jni.CameraPointsExtract
 * JD-Core Version:    0.7.0.1
 */