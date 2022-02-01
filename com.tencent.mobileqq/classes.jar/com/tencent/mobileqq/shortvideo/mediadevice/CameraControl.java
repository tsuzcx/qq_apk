package com.tencent.mobileqq.shortvideo.mediadevice;

import android.annotation.TargetApi;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.FaceDetectionListener;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.constants.CameraCompatibleConstants;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.PictureCallback;
import com.tencent.mobileqq.camera.CameraHolder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.mobileqq.shortvideo.common.Observable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.hardware.Camera.Size;>;

@TargetApi(11)
public class CameraControl
  extends Observable
{
  public static String b = "CameraControl";
  public static double c = 0.009999999776482582D;
  static CameraControl f;
  private static boolean t = false;
  private static ArrayList<Float> u = new ArrayList();
  private static boolean v = false;
  private static ArrayList<Float> w = new ArrayList();
  public Camera d;
  CameraControl.CameraInformation e = new CameraControl.CameraInformation(this);
  public int g = -1;
  int h;
  CameraControl.CustomSize i;
  int[] j;
  int k;
  int l;
  CameraControl.CustomSize m;
  boolean n;
  boolean o;
  CameraHolder p = CameraHolder.a();
  private byte[] r;
  private byte[] s;
  
  private CameraControl.CustomSize a(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[@] getHighVersionPreviewSize[wantedPreviewSize]: width=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("  height=");
      ((StringBuilder)localObject2).append(paramInt2);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = new CameraControl.CustomSize();
    int i1 = -1;
    int i2 = i1;
    if (paramList != null)
    {
      i2 = i1;
      if (!paramList.isEmpty())
      {
        paramList = paramList.iterator();
        for (;;)
        {
          i2 = i1;
          if (!paramList.hasNext()) {
            break;
          }
          localObject2 = (Camera.Size)paramList.next();
          if ((localObject2 != null) && (((Camera.Size)localObject2).height == paramInt2) && (((Camera.Size)localObject2).width >= paramInt1) && ((i1 < 0) || (((Camera.Size)localObject2).width <= i1))) {
            i1 = ((Camera.Size)localObject2).width;
          }
        }
      }
    }
    if (i2 > 0)
    {
      ((CameraControl.CustomSize)localObject1).b = paramInt2;
      ((CameraControl.CustomSize)localObject1).a = i2;
      if (((CameraControl.CustomSize)localObject1).a / 4 == ((CameraControl.CustomSize)localObject1).b / 3)
      {
        if (QLog.isColorLevel()) {
          QLog.i(b, 2, "[@] getHighVersionPreviewSize[4:3]...");
        }
        return localObject1;
      }
      if (QLog.isColorLevel()) {
        QLog.i(b, 2, "[@] getHighVersionPreviewSize: RATIO_MUST_EQUAL=false");
      }
      return localObject1;
    }
    return null;
  }
  
  private CameraControl.CustomSize a(List<Camera.Size> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d1 = paramInt4;
    double d2 = paramInt3;
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 /= d2;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[@] getPreviewSize[self-adaption] physicRatio=");
      ((StringBuilder)localObject2).append(d1);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    long l1 = 9223372036854775807L;
    Object localObject1 = new CameraControl.CustomSize();
    Object localObject3;
    double d3;
    long l2;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Camera.Size)((Iterator)localObject2).next();
        if ((localObject3 != null) && (((Camera.Size)localObject3).width >= paramInt1) && (((Camera.Size)localObject3).height >= paramInt2))
        {
          d2 = ((Camera.Size)localObject3).width;
          d3 = ((Camera.Size)localObject3).height;
          Double.isNaN(d2);
          Double.isNaN(d3);
          if (d2 / d3 >= d1)
          {
            l2 = ((Camera.Size)localObject3).width * ((Camera.Size)localObject3).height;
            if (l2 < l1)
            {
              ((CameraControl.CustomSize)localObject1).a = ((Camera.Size)localObject3).width;
              ((CameraControl.CustomSize)localObject1).b = ((Camera.Size)localObject3).height;
              l1 = l2;
            }
            else if ((l2 == l1) && (((Camera.Size)localObject3).width < ((CameraControl.CustomSize)localObject1).a))
            {
              ((CameraControl.CustomSize)localObject1).a = ((Camera.Size)localObject3).width;
              ((CameraControl.CustomSize)localObject1).b = ((Camera.Size)localObject3).height;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(b, 2, "[@] getPreviewSize[self-adaption] have no resolution >= (w*h)");
    }
    l1 = 0L;
    if (((((CameraControl.CustomSize)localObject1).a <= 0) || (((CameraControl.CustomSize)localObject1).b <= 0)) && (paramList != null) && (!paramList.isEmpty()))
    {
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Camera.Size)((Iterator)localObject2).next();
        if (localObject3 != null)
        {
          d2 = ((Camera.Size)localObject3).width;
          d3 = ((Camera.Size)localObject3).height;
          Double.isNaN(d2);
          Double.isNaN(d3);
          if (d2 / d3 >= d1)
          {
            l2 = ((Camera.Size)localObject3).width * ((Camera.Size)localObject3).height;
            if (l2 > l1)
            {
              ((CameraControl.CustomSize)localObject1).a = ((Camera.Size)localObject3).width;
              ((CameraControl.CustomSize)localObject1).b = ((Camera.Size)localObject3).height;
              l1 = l2;
            }
            else if ((l2 == l1) && (((Camera.Size)localObject3).width < ((CameraControl.CustomSize)localObject1).a))
            {
              ((CameraControl.CustomSize)localObject1).a = ((Camera.Size)localObject3).width;
              ((CameraControl.CustomSize)localObject1).b = ((Camera.Size)localObject3).height;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = b;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[@] getPreviewSize[self-adaption] cSize.width=");
      ((StringBuilder)localObject3).append(((CameraControl.CustomSize)localObject1).a);
      ((StringBuilder)localObject3).append("  cSize.height=");
      ((StringBuilder)localObject3).append(((CameraControl.CustomSize)localObject1).b);
      QLog.i((String)localObject2, 2, ((StringBuilder)localObject3).toString());
    }
    if ((((CameraControl.CustomSize)localObject1).a > 0) && (((CameraControl.CustomSize)localObject1).b > 0)) {
      return localObject1;
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramList.get(0) != null))
    {
      ((CameraControl.CustomSize)localObject1).a = ((Camera.Size)paramList.get(0)).width;
      ((CameraControl.CustomSize)localObject1).b = ((Camera.Size)paramList.get(0)).height;
      return localObject1;
    }
    return null;
  }
  
  private CameraControl.CustomSize a(List<Camera.Size> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[@] getHighVersionPreviewSizeV3[wantedPreviewSize]: width=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("  height=");
      ((StringBuilder)localObject2).append(paramInt2);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    float f3 = paramInt1 / paramInt2;
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    Object localObject3;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject3 = (Camera.Size)paramList.next();
        if (localObject3 != null)
        {
          int i1 = Math.max(((Camera.Size)localObject3).width, ((Camera.Size)localObject3).height);
          int i2 = Math.min(((Camera.Size)localObject3).width, ((Camera.Size)localObject3).height);
          if ((((Camera.Size)localObject3).height == paramInt2) && (i1 == paramInt1))
          {
            ((List)localObject1).add(new CameraControl.CustomSize(paramInt1, paramInt2));
            if (!QLog.isColorLevel()) {
              break;
            }
            paramList = b;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("[@] getHighVersionPreviewSizeV3 first: width=");
            ((StringBuilder)localObject3).append(paramInt1);
            ((StringBuilder)localObject3).append("  height=");
            ((StringBuilder)localObject3).append(paramInt2);
            QLog.i(paramList, 2, ((StringBuilder)localObject3).toString());
            break;
          }
          if ((i1 > paramInt5) && (i1 < paramInt3))
          {
            if (i2 > paramInt6)
            {
              if (i2 >= paramInt4) {
                continue;
              }
              ((List)localObject2).add(new CameraControl.CustomSize(i1, i2));
            }
          }
          else {}
        }
      }
    }
    float f1 = 10000.0F;
    float f2 = f1;
    if (((List)localObject1).size() == 0)
    {
      paramList = ((List)localObject2).iterator();
      while (paramList.hasNext())
      {
        localObject3 = (CameraControl.CustomSize)paramList.next();
        if (localObject3 != null)
        {
          paramInt1 = Math.max(((CameraControl.CustomSize)localObject3).a, ((CameraControl.CustomSize)localObject3).b);
          paramInt2 = Math.min(((CameraControl.CustomSize)localObject3).a, ((CameraControl.CustomSize)localObject3).b);
          f2 = f3 - paramInt1 / paramInt2;
          if (Math.abs(f2) < c) {
            ((List)localObject1).add(localObject3);
          }
          if (Math.abs(f2) < f1) {
            f1 = Math.abs(f2);
          }
        }
      }
      f2 = f1;
      if (QLog.isColorLevel())
      {
        paramInt1 = 0;
        for (;;)
        {
          f2 = f1;
          if (paramInt1 >= ((List)localObject1).size()) {
            break;
          }
          paramList = b;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[@] getHighVersionPreviewSizeV2 secend: width=");
          ((StringBuilder)localObject3).append(((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).a);
          ((StringBuilder)localObject3).append(" height=");
          ((StringBuilder)localObject3).append(((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).b);
          ((StringBuilder)localObject3).append(" w/h=");
          ((StringBuilder)localObject3).append(((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).a / ((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).b);
          QLog.i(paramList, 2, ((StringBuilder)localObject3).toString());
          paramInt1 += 1;
        }
      }
    }
    if (((List)localObject1).size() == 0)
    {
      paramList = ((List)localObject2).iterator();
      while (paramList.hasNext())
      {
        localObject2 = (CameraControl.CustomSize)paramList.next();
        if (localObject2 != null)
        {
          paramInt1 = Math.max(((CameraControl.CustomSize)localObject2).a, ((CameraControl.CustomSize)localObject2).b);
          paramInt2 = Math.min(((CameraControl.CustomSize)localObject2).a, ((CameraControl.CustomSize)localObject2).b);
          if (Math.abs(Math.abs(f3 - paramInt1 / paramInt2) - f2) < c) {
            ((List)localObject1).add(localObject2);
          }
        }
      }
      if (QLog.isColorLevel())
      {
        paramInt1 = 0;
        while (paramInt1 < ((List)localObject1).size())
        {
          paramList = b;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[@] getHighVersionPreviewSizeV2 third: width=");
          ((StringBuilder)localObject2).append(((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).a);
          ((StringBuilder)localObject2).append(" height=");
          ((StringBuilder)localObject2).append(((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).b);
          ((StringBuilder)localObject2).append(" w/h=");
          ((StringBuilder)localObject2).append(((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).a / ((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).b);
          QLog.i(paramList, 2, ((StringBuilder)localObject2).toString());
          paramInt1 += 1;
        }
      }
    }
    if (((List)localObject1).size() > 0)
    {
      paramList = (CameraControl.CustomSize)((List)localObject1).get(0);
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (CameraControl.CustomSize)((Iterator)localObject2).next();
        if ((localObject1 != null) && (((CameraControl.CustomSize)localObject1).a * ((CameraControl.CustomSize)localObject1).b > paramList.a * paramList.b)) {
          paramList = (List<Camera.Size>)localObject1;
        }
      }
      return paramList;
    }
    return null;
  }
  
  public static CameraControl a()
  {
    if (f == null) {
      try
      {
        if (f == null) {
          f = new CameraControl();
        }
      }
      finally {}
    }
    return f;
  }
  
  private static void a(ArrayList<Float> paramArrayList)
  {
    Object localObject = CameraAbility.a().j();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Camera.Size localSize = (Camera.Size)((Iterator)localObject).next();
        float f1 = localSize.width / localSize.height;
        if (!paramArrayList.contains(Float.valueOf(f1))) {
          paramArrayList.add(Float.valueOf(f1));
        }
      }
    }
  }
  
  private void a(List<int[]> paramList)
  {
    int i1;
    if ((paramList != null) && (paramList.size() > 0)) {
      i1 = 0;
    }
    while (i1 < paramList.size())
    {
      Object localObject1 = (int[])paramList.get(i1);
      Object localObject2;
      if ((localObject1 != null) && (localObject1.length >= 2))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = b;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("printFpsRange[i=");
          localStringBuilder.append(i1);
          localStringBuilder.append(" fps[low]=");
          localStringBuilder.append(localObject1[0]);
          localStringBuilder.append(" fps[high]=");
          localStringBuilder.append(localObject1[1]);
          localStringBuilder.append("]");
          QLog.i((String)localObject2, 2, localStringBuilder.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject1 = b;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("printFpsRange[i=");
        ((StringBuilder)localObject2).append(i1);
        ((StringBuilder)localObject2).append(" ele=null]");
        QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      i1 += 1;
      continue;
      if (QLog.isColorLevel()) {
        QLog.i(b, 2, "printFpsRange[listFpsRange=null]");
      }
    }
  }
  
  private boolean a(ArrayList<Camera.Size> paramArrayList, int paramInt1, int paramInt2)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() <= 0) {
        return false;
      }
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        Camera.Size localSize = (Camera.Size)paramArrayList.get(i1);
        if ((localSize.width == paramInt1) && (localSize.height == paramInt2)) {
          return true;
        }
        i1 += 1;
      }
    }
    return false;
  }
  
  private int[] a(List<int[]> paramList, int paramInt)
  {
    int[] arrayOfInt2 = b(paramList);
    int[] arrayOfInt1 = arrayOfInt2;
    if (arrayOfInt2 == null) {
      arrayOfInt1 = b(paramList, paramInt);
    }
    return arrayOfInt1;
  }
  
  private boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    double d1 = paramInt4;
    double d2 = paramInt5;
    Double.isNaN(d1);
    Double.isNaN(d2);
    if (d1 / d2 <= 1.0D) {
      return false;
    }
    return paramInt2 * paramInt5 / (paramInt3 * paramInt5 / paramInt4) >= paramInt1;
  }
  
  private int[] b(List<int[]> paramList)
  {
    int[] arrayOfInt1 = new int[2];
    int[] tmp7_5 = arrayOfInt1;
    tmp7_5[0] = 0;
    int[] tmp11_7 = tmp7_5;
    tmp11_7[1] = 0;
    tmp11_7;
    Object localObject1 = new ArrayList();
    Object localObject2 = paramList.iterator();
    label35:
    int[] arrayOfInt2;
    for (int i2 = 0; ((Iterator)localObject2).hasNext(); i2 = arrayOfInt2[1])
    {
      arrayOfInt2 = (int[])((Iterator)localObject2).next();
      if ((arrayOfInt2 == null) || (arrayOfInt2.length < 2) || (arrayOfInt2[1] < i2)) {
        break label35;
      }
    }
    if (i2 <= 0) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject2 = (int[])paramList.next();
      if ((localObject2 != null) && (localObject2.length >= 2) && (localObject2[1] == i2)) {
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    if (((ArrayList)localObject1).size() <= 0) {
      return null;
    }
    paramList = ((ArrayList)localObject1).iterator();
    int i3 = 2147483647;
    int i4 = 0;
    while (paramList.hasNext())
    {
      localObject1 = (int[])paramList.next();
      int i1;
      if (localObject1[0] >= 15000) {
        i1 = localObject1[0] - 15000;
      } else {
        i1 = 15000 - localObject1[0];
      }
      if (i1 < i3)
      {
        i4 = localObject1[0];
        i3 = i1;
      }
    }
    if (i3 != 2147483647)
    {
      arrayOfInt1[0] = i4;
      arrayOfInt1[1] = i2;
    }
    else
    {
      arrayOfInt1[0] = i2;
      arrayOfInt1[1] = i2;
    }
    if (arrayOfInt1[0] > 0)
    {
      if (arrayOfInt1[1] <= 0) {
        return null;
      }
      return arrayOfInt1;
    }
    return null;
  }
  
  private int[] b(List<int[]> paramList, int paramInt)
  {
    int[] arrayOfInt1 = new int[2];
    int[] tmp5_4 = arrayOfInt1;
    tmp5_4[0] = 2147483647;
    int[] tmp11_5 = tmp5_4;
    tmp11_5[1] = 2147483647;
    tmp11_5;
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      int[] arrayOfInt2 = (int[])((Iterator)localObject).next();
      if ((arrayOfInt2 != null) && (arrayOfInt2.length >= 2) && (arrayOfInt2[0] >= paramInt) && (arrayOfInt2[1] < arrayOfInt1[1]))
      {
        arrayOfInt1[0] = arrayOfInt2[0];
        arrayOfInt1[1] = arrayOfInt2[1];
      }
    }
    if ((arrayOfInt1[0] == 2147483647) || (arrayOfInt1[1] == 2147483647))
    {
      arrayOfInt1[1] = 0;
      arrayOfInt1[0] = 0;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (int[])paramList.next();
        if ((localObject != null) && (localObject.length >= 2) && (localObject[0] <= paramInt) && (localObject[1] > arrayOfInt1[1]))
        {
          arrayOfInt1[0] = localObject[0];
          arrayOfInt1[1] = localObject[1];
        }
      }
    }
    if ((arrayOfInt1[0] != 2147483647) && (arrayOfInt1[1] != 2147483647)) {
      return arrayOfInt1;
    }
    return null;
  }
  
  public static String c(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return "unknown";
            }
            return "RM_CAMERA_GET_PARAM";
          }
          return "RM_CAMERA_OPEN_FAILED";
        }
        return "RM_CAMERA_COUNT_ZERO";
      }
      return "RM_CAMERA_USED_AV";
    }
    return "RM_CAMERA_OPEN_SUCCESS";
  }
  
  private boolean e(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = Math.max(paramInt1, paramInt2);
    paramInt1 = Math.min(paramInt1, paramInt2);
    float f1 = i1 / paramInt1;
    paramInt1 = Math.max(paramInt3, paramInt4);
    paramInt2 = Math.min(paramInt3, paramInt4);
    float f2 = paramInt1 / paramInt2;
    boolean bool;
    if (Math.abs(f2 - f1) > c) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      String str = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("needClip ");
      localStringBuilder.append(bool);
      localStringBuilder.append(" screenRatio");
      localStringBuilder.append(f2);
      localStringBuilder.append(" previewRatio");
      localStringBuilder.append(f1);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private int g(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return CameraAbility.f();
      }
      if (CameraAbility.c()) {
        return CameraAbility.f();
      }
    }
    else if (CameraAbility.d())
    {
      return CameraAbility.e();
    }
    return -1;
  }
  
  private boolean h(int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    try
    {
      if ((this.r == null) || (this.r.length != paramInt)) {
        this.r = new byte[paramInt];
      }
      if ((this.s != null) && (this.s.length == paramInt)) {
        break label104;
      }
      this.s = new byte[paramInt];
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      label55:
      label104:
      break label55;
    }
    URLDrawable.clearMemoryCache();
    try
    {
      if ((this.r == null) || (this.r.length != paramInt)) {
        this.r = new byte[paramInt];
      }
      if ((this.s == null) || (this.s.length != paramInt)) {
        this.s = new byte[paramInt];
      }
      return true;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      String str = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("allocateFrame failed , size:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", ");
      localStringBuilder.append(localOutOfMemoryError1.getMessage());
      QLog.e(str, 2, localStringBuilder.toString());
      return false;
    }
  }
  
  private int r()
  {
    int i1 = ImageFormat.getBitsPerPixel(this.h);
    float f1 = i1 * 1.0F / 8.0F;
    int i2 = (int)(this.i.b * this.i.a * f1);
    if (QLog.isColorLevel())
    {
      String str = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startPreview getPreviewBufferSize:bitpixel=");
      localStringBuilder.append(i1);
      localStringBuilder.append(" byteNum=");
      localStringBuilder.append(f1);
      localStringBuilder.append(" bufSize=");
      localStringBuilder.append(i2);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    return i2;
  }
  
  private boolean s()
  {
    return ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProduct(CameraCompatibleConstants.a) ^ true;
  }
  
  public CameraControl.CustomSize a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((!q) && (this.d == null)) {
      throw new AssertionError();
    }
    if ((!q) && (this.i == null)) {
      throw new AssertionError();
    }
    if (l() == null) {
      return null;
    }
    int i1 = Math.min(paramInt1, paramInt2);
    paramInt1 = Math.max(paramInt1, paramInt2);
    float f3 = paramInt1 / i1;
    Object localObject2 = new CameraControl.CustomSize();
    Object localObject3 = CameraAbility.a().j();
    if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
    {
      Object localObject1 = new CameraControl.CustomSize();
      float f1 = 10000.0F;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((List)localObject3).iterator();
      while (localIterator.hasNext())
      {
        Camera.Size localSize = (Camera.Size)localIterator.next();
        if (localSize != null)
        {
          if (QLog.isColorLevel())
          {
            String str = b;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[@] setPictureSize[list]: width=");
            localStringBuilder.append(localSize.width);
            localStringBuilder.append(" height=");
            localStringBuilder.append(localSize.height);
            localStringBuilder.append(" w/h=");
            localStringBuilder.append(localSize.width / localSize.height);
            QLog.i(str, 2, localStringBuilder.toString());
          }
          float f4 = localSize.width / localSize.height - f3;
          if (Math.abs(f4) <= c) {
            localArrayList.add(localSize);
          }
          float f2 = f1;
          if (localSize.width >= paramInt1)
          {
            f2 = f1;
            if (f1 > Math.abs(f4))
            {
              f2 = Math.abs(f4);
              ((CameraControl.CustomSize)localObject1).a = localSize.width;
              ((CameraControl.CustomSize)localObject1).b = localSize.height;
            }
          }
          f1 = f2;
        }
      }
      if ((localArrayList.isEmpty()) && (((CameraControl.CustomSize)localObject1).a >= paramInt1))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = b;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("getPictureSize: width=");
          ((StringBuilder)localObject3).append(((CameraControl.CustomSize)localObject1).a);
          ((StringBuilder)localObject3).append(" height=");
          ((StringBuilder)localObject3).append(((CameraControl.CustomSize)localObject1).b);
          ((StringBuilder)localObject3).append(" w/h=");
          ((StringBuilder)localObject3).append(((CameraControl.CustomSize)localObject1).a / ((CameraControl.CustomSize)localObject1).b);
          QLog.i((String)localObject2, 2, ((StringBuilder)localObject3).toString());
        }
        return localObject1;
      }
      if ((localArrayList.isEmpty()) && (((List)localObject3).size() > 0))
      {
        ((CameraControl.CustomSize)localObject2).a = ((Camera.Size)((List)localObject3).get(0)).width;
        ((CameraControl.CustomSize)localObject2).b = ((Camera.Size)((List)localObject3).get(0)).height;
        return localObject2;
      }
      if (localArrayList.isEmpty()) {
        return null;
      }
      if (paramInt5 == -1)
      {
        localObject3 = localArrayList.iterator();
        for (;;)
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (Camera.Size)((Iterator)localObject3).next();
          if (((CameraControl.CustomSize)localObject2).a < ((Camera.Size)localObject1).width)
          {
            ((CameraControl.CustomSize)localObject2).a = ((Camera.Size)localObject1).width;
            ((CameraControl.CustomSize)localObject2).b = ((Camera.Size)localObject1).height;
          }
        }
      }
      localObject1 = a(paramInt3, paramInt4, paramInt5, localArrayList);
      if (((CameraControl.CustomSize)localObject1).a == 0) {
        return null;
      }
      return localObject1;
    }
    return null;
  }
  
  public CameraControl.CustomSize a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[@] getPreviewSizeV2: dstwidth=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("  dstheight=");
      ((StringBuilder)localObject2).append(paramInt2);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = CameraAbility.a().i();
    boolean bool = QLog.isColorLevel();
    int i2 = 0;
    if ((bool) && (localObject1 != null))
    {
      int i1 = 0;
      while (i1 < ((List)localObject1).size())
      {
        localObject2 = b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] getPreviewSizeGuaranteeOK[list]: width=");
        localStringBuilder.append(((Camera.Size)((List)localObject1).get(i1)).width);
        localStringBuilder.append(" height=");
        localStringBuilder.append(((Camera.Size)((List)localObject1).get(i1)).height);
        localStringBuilder.append(" w/h=");
        localStringBuilder.append(((Camera.Size)((List)localObject1).get(i1)).width / ((Camera.Size)((List)localObject1).get(i1)).height);
        QLog.i((String)localObject2, 2, localStringBuilder.toString());
        i1 += 1;
      }
    }
    Object localObject2 = a((List)localObject1, paramInt1, paramInt2);
    if (localObject2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(b, 2, "[@] getPreviewSizeGuaranteeOK: DEFAULT resolution os OK.");
      }
      if (paramBoolean) {
        NewFlowCameraReporter.a(2, paramInt1, paramInt2, ((CameraControl.CustomSize)localObject2).a, ((CameraControl.CustomSize)localObject2).b);
      }
      return localObject2;
    }
    localObject2 = a((List)localObject1, 960, 720);
    if (localObject2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(b, 2, "[@] getPreviewSizeGuaranteeOK: 640*480 resolution os OK.");
      }
      if (paramBoolean) {
        NewFlowCameraReporter.a(3, paramInt1, paramInt2, ((CameraControl.CustomSize)localObject2).a, ((CameraControl.CustomSize)localObject2).b);
      }
      return localObject2;
    }
    localObject1 = a((List)localObject1, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      if (localObject1 == null) {
        paramInt3 = 0;
      } else {
        paramInt3 = ((CameraControl.CustomSize)localObject1).a;
      }
      if (localObject1 == null) {
        paramInt4 = i2;
      } else {
        paramInt4 = ((CameraControl.CustomSize)localObject1).b;
      }
      NewFlowCameraReporter.a(4, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    return localObject1;
  }
  
  public CameraControl.CustomSize a(int paramInt1, int paramInt2, int paramInt3, List<Camera.Size> paramList)
  {
    paramInt3 = Math.max(paramInt1 * paramInt3, paramInt2 * paramInt3);
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setParamsPictureSize targetWidth ");
      ((StringBuilder)localObject2).append(paramInt3);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = new CameraControl.CustomSize(0, 0);
    paramInt1 = 2147483647;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject2 = (Camera.Size)paramList.next();
      paramInt2 = Math.abs(((Camera.Size)localObject2).width - paramInt3);
      if (paramInt1 > paramInt2)
      {
        ((CameraControl.CustomSize)localObject1).a = ((Camera.Size)localObject2).width;
        ((CameraControl.CustomSize)localObject1).b = ((Camera.Size)localObject2).height;
        paramInt1 = paramInt2;
      }
    }
    return localObject1;
  }
  
  @TargetApi(14)
  public void a(Camera.FaceDetectionListener paramFaceDetectionListener)
  {
    if ((!q) && (this.d == null)) {
      throw new AssertionError();
    }
    try
    {
      this.d.setFaceDetectionListener(paramFaceDetectionListener);
    }
    catch (Exception paramFaceDetectionListener)
    {
      paramFaceDetectionListener.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.i(b, 2, "setFaceDetectionListener");
    }
  }
  
  @TargetApi(17)
  public void a(File paramFile, Rect paramRect, CameraCover.PictureCallback paramPictureCallback, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.d == null)
    {
      if (QLog.isColorLevel())
      {
        paramFile = b;
        paramRect = new StringBuilder();
        paramRect.append("[takePicture]mCamera ");
        paramRect.append(null);
        QLog.i(paramFile, 2, paramRect.toString());
      }
      return;
    }
    NewFlowCameraReporter.a("begin pic taken");
    try
    {
      this.d.enableShutterSound(false);
    }
    catch (Exception localException)
    {
      QLog.i(b, 1, "[takePicture]enableShutterSound error, ", localException);
    }
    try
    {
      long l1 = System.currentTimeMillis();
      this.n = false;
      this.d.takePicture(null, null, null, new CameraControl.1(this, paramInt1, l1, paramFile, paramRect, paramPictureCallback, paramBoolean, paramInt2));
      return;
    }
    catch (RuntimeException paramFile)
    {
      if (QLog.isColorLevel()) {
        QLog.i(b, 2, "", paramFile);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.d != null) && (h(r())))
    {
      this.d.addCallbackBuffer(this.r);
      this.d.addCallbackBuffer(this.s);
    }
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (paramBoolean)
    {
      Camera localCamera = this.d;
      if ((localCamera != null) && (paramArrayOfByte != null)) {
        localCamera.addCallbackBuffer(paramArrayOfByte);
      }
    }
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    if ((!q) && (this.d == null)) {
      throw new AssertionError();
    }
    Camera.Parameters localParameters = l();
    if (localParameters == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(b, 2, "[@] setPreviewFps[failed]getCameraParameters=null");
      }
      return false;
    }
    int[] arrayOfInt = b(paramInt, paramBoolean);
    if ((arrayOfInt != null) && (arrayOfInt.length >= 2)) {
      if (QLog.isColorLevel())
      {
        String str = b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setPreviewFps[ fps[low]=");
        localStringBuilder.append(arrayOfInt[0]);
        localStringBuilder.append(" fps[high]=");
        localStringBuilder.append(arrayOfInt[1]);
        localStringBuilder.append("]");
        QLog.i(str, 2, localStringBuilder.toString());
      }
    }
    try
    {
      localParameters.setPreviewFpsRange(arrayOfInt[0], arrayOfInt[1]);
      this.j = arrayOfInt;
      paramBoolean = a(localParameters);
      return paramBoolean;
    }
    catch (Exception localException) {}
    if (QLog.isColorLevel()) {
      QLog.i(b, 2, "setPreviewFps[getFpsRange=null]");
    }
    return false;
    return false;
  }
  
  public boolean a(SurfaceTexture paramSurfaceTexture)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      if (paramSurfaceTexture == null) {
        return false;
      }
      if (this.n)
      {
        if (QLog.isColorLevel())
        {
          paramSurfaceTexture = b;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("@$[setPreviewTexture] mIsPreviewing=");
          ((StringBuilder)localObject).append(this.n);
          QLog.i(paramSurfaceTexture, 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
      try
      {
        ((Camera)localObject).setPreviewTexture(paramSurfaceTexture);
        return true;
      }
      catch (Exception paramSurfaceTexture)
      {
        paramSurfaceTexture.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i(b, 2, "@$[setPreviewTexture] exp=", paramSurfaceTexture);
        }
      }
    }
    return false;
  }
  
  public boolean a(Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    if ((this.d != null) && (this.n)) {
      if (!s()) {
        return false;
      }
    }
    try
    {
      this.d.cancelAutoFocus();
      this.d.autoFocus(paramAutoFocusCallback);
      return true;
    }
    catch (Exception paramAutoFocusCallback) {}
    return false;
    return false;
  }
  
  public boolean a(Camera.Parameters paramParameters)
  {
    if ((!q) && (this.d == null)) {
      throw new AssertionError();
    }
    if (paramParameters == null) {
      return false;
    }
    try
    {
      this.d.setParameters(paramParameters);
      return true;
    }
    catch (Exception paramParameters)
    {
      QLog.e(b, 2, paramParameters, new Object[0]);
    }
    return false;
  }
  
  public boolean a(Camera.PreviewCallback paramPreviewCallback, boolean paramBoolean)
  {
    Camera localCamera = this.d;
    if (localCamera != null)
    {
      if (paramPreviewCallback == null) {
        return false;
      }
      if (!paramBoolean) {}
    }
    try
    {
      if (h(r()))
      {
        this.d.addCallbackBuffer(this.r);
        this.d.addCallbackBuffer(this.s);
        this.d.setPreviewCallbackWithBuffer(paramPreviewCallback);
      }
      else
      {
        this.d.setPreviewCallback(paramPreviewCallback);
        break label79;
        localCamera.setPreviewCallback(paramPreviewCallback);
      }
      label79:
      return true;
    }
    catch (Exception paramPreviewCallback)
    {
      label81:
      break label81;
    }
    paramPreviewCallback.printStackTrace();
    return false;
  }
  
  public boolean a(SurfaceHolder paramSurfaceHolder)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      if (paramSurfaceHolder == null) {
        return false;
      }
      if (this.n)
      {
        if (QLog.isColorLevel())
        {
          paramSurfaceHolder = b;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("@$[setSurfaceHolder] mIsPreviewing=");
          ((StringBuilder)localObject).append(this.n);
          QLog.i(paramSurfaceHolder, 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
      try
      {
        ((Camera)localObject).setPreviewDisplay(paramSurfaceHolder);
        return true;
      }
      catch (Exception paramSurfaceHolder)
      {
        paramSurfaceHolder.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i(b, 2, "@$[setSurfaceHolder] exp=", paramSurfaceHolder);
        }
      }
    }
    return false;
  }
  
  public boolean a(CameraControl.CustomSize paramCustomSize)
  {
    if ((!q) && (this.d == null)) {
      throw new AssertionError();
    }
    Object localObject = l();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(b, 2, "[@] setParamsPreviewSize[failed]getCameraParameters=null");
      }
      return false;
    }
    try
    {
      ((Camera.Parameters)localObject).setPreviewSize(paramCustomSize.a, paramCustomSize.b);
      this.i = paramCustomSize;
      boolean bool = a((Camera.Parameters)localObject);
      if (QLog.isColorLevel())
      {
        localObject = b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] setParamsPreviewSize, result = ");
        localStringBuilder.append(bool);
        localStringBuilder.append(",size.width = ");
        localStringBuilder.append(paramCustomSize.a);
        localStringBuilder.append(",size.height = ");
        localStringBuilder.append(paramCustomSize.b);
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
      return bool;
    }
    catch (Exception paramCustomSize)
    {
      paramCustomSize.printStackTrace();
    }
    return false;
  }
  
  public boolean a(CameraProxy.ParamCache paramParamCache)
  {
    Camera.Parameters localParameters = l();
    if (localParameters == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(b, 2, "[@] setParamsPreviewFormat[failed]getCameraParameters=null");
      }
      return false;
    }
    localParameters.setPreviewFormat(paramParamCache.b);
    localParameters.setPreviewSize(paramParamCache.e.a, paramParamCache.e.b);
    localParameters.setPreviewFpsRange(paramParamCache.c, paramParamCache.d);
    if (paramParamCache.f) {
      localParameters.setPictureSize(paramParamCache.g.a, paramParamCache.g.b);
    }
    boolean bool = a(localParameters);
    if (bool)
    {
      this.h = paramParamCache.b;
      this.i = paramParamCache.e;
      this.j = new int[] { paramParamCache.c, paramParamCache.d };
      this.m = paramParamCache.g;
    }
    return bool;
  }
  
  public boolean a(String paramString)
  {
    if ((!q) && (this.d == null)) {
      throw new AssertionError();
    }
    boolean bool2 = s();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    try
    {
      this.d.cancelAutoFocus();
    }
    catch (RuntimeException localRuntimeException)
    {
      if (QLog.isColorLevel()) {
        QLog.i(b, 2, "", localRuntimeException);
      }
    }
    Object localObject1 = l();
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = ((Camera.Parameters)localObject1).getFocusMode();
    if (QLog.isColorLevel())
    {
      String str = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[@] setParamsFocusMode getFocusMode=");
      localStringBuilder.append((String)localObject2);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if ((localObject2 != null) && (((String)localObject2).equals(paramString))) {
      return true;
    }
    bool2 = CameraAbility.a().a(paramString);
    if (bool2)
    {
      ((Camera.Parameters)localObject1).setFocusMode(paramString);
      bool1 = a((Camera.Parameters)localObject1);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[@] setParamsFocusMode support=");
      ((StringBuilder)localObject2).append(bool2);
      ((StringBuilder)localObject2).append(" success=");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(" setTo=");
      ((StringBuilder)localObject2).append(paramString);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    return bool1;
  }
  
  public CameraControl.CustomSize[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[@] getPreviewAndPictureSizeV2 wanted size=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(" cliped=");
      ((StringBuilder)localObject2).append(paramInt3);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(paramInt4);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = new CameraControl.CustomSize[2];
    Object localObject2 = a(paramInt1, paramInt2, paramInt3, paramInt4, true);
    if (localObject2 != null)
    {
      localObject1[0] = localObject2;
      Object localObject4;
      if (QLog.isColorLevel())
      {
        localObject3 = b;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("[@] getPreviewAndPictureSizeGuarantee way2 preview=");
        ((StringBuilder)localObject4).append(((CameraControl.CustomSize)localObject2).a);
        ((StringBuilder)localObject4).append(" ");
        ((StringBuilder)localObject4).append(((CameraControl.CustomSize)localObject2).b);
        QLog.i((String)localObject3, 2, ((StringBuilder)localObject4).toString());
      }
      Object localObject3 = a(((CameraControl.CustomSize)localObject2).a, ((CameraControl.CustomSize)localObject2).b, paramInt3, paramInt4, 1);
      localObject1[1] = localObject3;
      if (localObject3 != null)
      {
        if (QLog.isColorLevel())
        {
          localObject4 = b;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[@] getPreviewAndPictureSizeGuarantee way2 picture=");
          localStringBuilder.append(((CameraControl.CustomSize)localObject3).a);
          localStringBuilder.append(" ");
          localStringBuilder.append(((CameraControl.CustomSize)localObject3).b);
          QLog.i((String)localObject4, 2, localStringBuilder.toString());
        }
        NewFlowCameraReporter.a(true, ((CameraControl.CustomSize)localObject2).a, ((CameraControl.CustomSize)localObject2).b, ((CameraControl.CustomSize)localObject3).a, ((CameraControl.CustomSize)localObject3).b);
        return localObject1;
      }
      NewFlowCameraReporter.a(true, ((CameraControl.CustomSize)localObject2).a, ((CameraControl.CustomSize)localObject2).b, -1, -1);
    }
    return localObject1;
  }
  
  public int b(int paramInt)
  {
    if (FlowCameraMqqAction.a()) {
      return 1;
    }
    if (!CameraAbility.b())
    {
      if (QLog.isColorLevel()) {
        QLog.i(b, 2, "[@] openCamera[failed]hasCameras=false");
      }
      return 2;
    }
    String str;
    Object localObject;
    if (this.o)
    {
      if (QLog.isColorLevel())
      {
        str = b;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[openCamera]Camera is opened, Camera object ");
        ((StringBuilder)localObject).append(this.d);
        QLog.i(str, 2, ((StringBuilder)localObject).toString());
      }
      return 5;
    }
    int i2 = 0;
    int i1 = 0;
    for (;;)
    {
      if (i2 < 10) {
        try
        {
          this.g = g(paramInt);
          if (VersionUtils.c())
          {
            if (QLog.isColorLevel())
            {
              str = b;
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("openCamera:currentCount= ");
              ((StringBuilder)localObject).append(i2);
              QLog.d(str, 2, ((StringBuilder)localObject).toString());
            }
            str = b;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("【Real Old openCamera】:");
            ((StringBuilder)localObject).append(this.g);
            AEQLog.b(str, ((StringBuilder)localObject).toString());
            str = b;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("【Real Old openCamera】:currentCount= ");
            ((StringBuilder)localObject).append(i2);
            AEQLog.b(str, ((StringBuilder)localObject).toString());
            this.d = Camera.open(this.g);
          }
          else
          {
            this.d = Camera.open();
          }
          i1 = 0;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          this.d = null;
          i2 += 1;
          if (QLog.isColorLevel())
          {
            localObject = b;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[@] openCamera[failed][RM_CAMERA_OPEN_FAILED]currentCount=");
            localStringBuilder.append(i2);
            QLog.i((String)localObject, 2, localStringBuilder.toString(), localException);
          }
          if (i2 >= 10) {}
        }
      }
      try
      {
        Thread.sleep(300L);
        label349:
        i1 = 3;
        continue;
        if (this.d == null) {
          return i1;
        }
        if (!CameraAbility.a().a(this.d))
        {
          if (QLog.isColorLevel()) {
            QLog.i(b, 2, "[@] openCamera[failed]bindCamera=false");
          }
          return 4;
        }
        this.e = new CameraControl.CameraInformation(this);
        this.o = true;
        return 0;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label349;
      }
    }
  }
  
  public CameraControl.CustomSize b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[@] getPreviewSizeV3: dstwidth=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("  dstheight=");
      ((StringBuilder)localObject2).append(paramInt2);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = CameraAbility.a().i();
    boolean bool = QLog.isColorLevel();
    int i2 = 0;
    if ((bool) && (localObject1 != null))
    {
      int i1 = 0;
      while (i1 < ((List)localObject1).size())
      {
        localObject2 = b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] getPreviewSizeGuaranteeOK[list]: width=");
        localStringBuilder.append(((Camera.Size)((List)localObject1).get(i1)).width);
        localStringBuilder.append(" height=");
        localStringBuilder.append(((Camera.Size)((List)localObject1).get(i1)).height);
        localStringBuilder.append(" w/h=");
        localStringBuilder.append(((Camera.Size)((List)localObject1).get(i1)).width / ((Camera.Size)((List)localObject1).get(i1)).height);
        QLog.i((String)localObject2, 2, localStringBuilder.toString());
        i1 += 1;
      }
    }
    float f4 = paramInt1 * 1.0F / paramInt2;
    float f2 = 1000.0F;
    float f3 = f4 * 1000.0F;
    float f1 = f3;
    if (f3 > 1700.0F) {
      f1 = 1700.0F;
    }
    Object localObject2 = a((List)localObject1, paramInt1, paramInt2, 2600, 1500, (int)f1, 1000);
    if (localObject2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(b, 2, "[@] getPreviewSizeGuaranteeOK: DEFAULT resolution os OK.");
      }
      if (paramBoolean) {
        NewFlowCameraReporter.a(2, paramInt1, paramInt2, ((CameraControl.CustomSize)localObject2).a, ((CameraControl.CustomSize)localObject2).b);
      }
      return localObject2;
    }
    f1 = 700.0F * f4;
    if (f1 > 1000.0F) {
      f1 = f2;
    }
    localObject2 = a((List)localObject1, paramInt1, paramInt2, 2600, 1500, (int)f1, 700);
    if (localObject2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(b, 2, "[@] getPreviewSizeGuaranteeOK: 640*480 resolution os OK.");
      }
      if (paramBoolean) {
        NewFlowCameraReporter.a(3, paramInt1, paramInt2, ((CameraControl.CustomSize)localObject2).a, ((CameraControl.CustomSize)localObject2).b);
      }
      return localObject2;
    }
    localObject1 = a((List)localObject1, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      if (localObject1 == null) {
        paramInt3 = 0;
      } else {
        paramInt3 = ((CameraControl.CustomSize)localObject1).a;
      }
      if (localObject1 == null) {
        paramInt4 = i2;
      } else {
        paramInt4 = ((CameraControl.CustomSize)localObject1).b;
      }
      NewFlowCameraReporter.a(4, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    return localObject1;
  }
  
  public void b()
  {
    this.r = null;
    this.s = null;
    if (QLog.isColorLevel()) {
      QLog.i(b, 2, "releasePreviewFrameBuffer");
    }
  }
  
  public boolean b(CameraControl.CustomSize paramCustomSize)
  {
    Object localObject = l();
    if (localObject == null) {
      return false;
    }
    try
    {
      ((Camera.Parameters)localObject).setPictureSize(paramCustomSize.a, paramCustomSize.b);
      this.m = paramCustomSize;
      boolean bool = a((Camera.Parameters)localObject);
      if (QLog.isColorLevel())
      {
        localObject = b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setRawPictureSize w ");
        localStringBuilder.append(paramCustomSize.a);
        localStringBuilder.append(", h ");
        localStringBuilder.append(paramCustomSize.b);
        localStringBuilder.append(", success=");
        localStringBuilder.append(bool);
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
      return bool;
    }
    catch (Exception paramCustomSize)
    {
      paramCustomSize.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i(b, 2, "setParamsPictureSize", paramCustomSize);
      }
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    if ((!q) && (this.d == null)) {
      throw new AssertionError();
    }
    if (CameraAbility.a().b(paramString))
    {
      Camera.Parameters localParameters = l();
      String str = localParameters.getSceneMode();
      boolean bool1;
      if ((str != null) && (!str.equals(paramString)))
      {
        localParameters.setSceneMode(paramString);
        boolean bool2 = a(localParameters);
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.e(b, 2, new Object[] { "setSceneMode success: ", Boolean.valueOf(bool2) });
          return bool2;
        }
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    return false;
  }
  
  public boolean b(boolean paramBoolean)
  {
    if ((!q) && (this.d == null)) {
      throw new AssertionError();
    }
    if (CameraAbility.a().h())
    {
      Camera.Parameters localParameters = l();
      String str = localParameters.getFlashMode();
      if ((paramBoolean) && (!TextUtils.equals(str, "on"))) {
        localParameters.setFlashMode("on");
      } else if ((!paramBoolean) && (!TextUtils.equals(str, "off"))) {
        localParameters.setFlashMode("off");
      }
      return a(localParameters);
    }
    return false;
  }
  
  public int[] b(int paramInt, boolean paramBoolean)
  {
    int[] arrayOfInt1 = new int[2];
    int[] tmp7_5 = arrayOfInt1;
    tmp7_5[0] = 2147483647;
    int[] tmp13_7 = tmp7_5;
    tmp13_7[1] = 2147483647;
    tmp13_7;
    int i1 = paramInt * 1000;
    List localList = CameraAbility.a().k();
    if (localList == null)
    {
      arrayOfInt1[0] = i1;
      arrayOfInt1[1] = i1;
      return arrayOfInt1;
    }
    a(localList);
    if (!paramBoolean) {
      return a(localList, paramInt);
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      int[] arrayOfInt2 = (int[])localIterator.next();
      if ((arrayOfInt2 != null) && (arrayOfInt2.length >= 2) && (i1 >= arrayOfInt2[0]) && (i1 <= arrayOfInt2[1]))
      {
        arrayOfInt1[0] = i1;
        arrayOfInt1[1] = arrayOfInt2[1];
        return arrayOfInt1;
      }
    }
    return a(localList, paramInt);
  }
  
  public CameraControl.CustomSize[] b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[@] getPreviewAndPictureSizeV3 wanted size=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(" cliped=");
      ((StringBuilder)localObject2).append(paramInt3);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(paramInt4);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = new CameraControl.CustomSize[2];
    Object localObject2 = b(paramInt1, paramInt2, paramInt3, paramInt4, true);
    if (localObject2 != null)
    {
      localObject1[0] = localObject2;
      Object localObject4;
      if (QLog.isColorLevel())
      {
        localObject3 = b;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("[@] getPreviewAndPictureSizeGuarantee way2 preview=");
        ((StringBuilder)localObject4).append(((CameraControl.CustomSize)localObject2).a);
        ((StringBuilder)localObject4).append(" ");
        ((StringBuilder)localObject4).append(((CameraControl.CustomSize)localObject2).b);
        QLog.i((String)localObject3, 2, ((StringBuilder)localObject4).toString());
      }
      Object localObject3 = a(((CameraControl.CustomSize)localObject2).a, ((CameraControl.CustomSize)localObject2).b, paramInt3, paramInt4, 1);
      localObject1[1] = localObject3;
      if (localObject3 != null)
      {
        if (QLog.isColorLevel())
        {
          localObject4 = b;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[@] getPreviewAndPictureSizeGuarantee way2 picture=");
          localStringBuilder.append(((CameraControl.CustomSize)localObject3).a);
          localStringBuilder.append(" ");
          localStringBuilder.append(((CameraControl.CustomSize)localObject3).b);
          QLog.i((String)localObject4, 2, localStringBuilder.toString());
        }
        NewFlowCameraReporter.a(true, ((CameraControl.CustomSize)localObject2).a, ((CameraControl.CustomSize)localObject2).b, ((CameraControl.CustomSize)localObject3).a, ((CameraControl.CustomSize)localObject3).b);
        return localObject1;
      }
      NewFlowCameraReporter.a(true, ((CameraControl.CustomSize)localObject2).a, ((CameraControl.CustomSize)localObject2).b, -1, -1);
    }
    return localObject1;
  }
  
  public CameraControl.CustomSize c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[@] getPreviewSizeGuaranteeOK: dstwidth=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("  dstheight=");
      ((StringBuilder)localObject2).append(paramInt2);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = CameraAbility.a().i();
    boolean bool = QLog.isColorLevel();
    int i2 = 0;
    if ((bool) && (localObject1 != null))
    {
      int i1 = 0;
      while (i1 < ((List)localObject1).size())
      {
        localObject2 = b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] getPreviewSizeGuaranteeOK[list]: width=");
        localStringBuilder.append(((Camera.Size)((List)localObject1).get(i1)).width);
        localStringBuilder.append(" height=");
        localStringBuilder.append(((Camera.Size)((List)localObject1).get(i1)).height);
        localStringBuilder.append(" w/h=");
        localStringBuilder.append(((Camera.Size)((List)localObject1).get(i1)).width / ((Camera.Size)((List)localObject1).get(i1)).height);
        QLog.i((String)localObject2, 2, localStringBuilder.toString());
        i1 += 1;
      }
    }
    Object localObject2 = a((List)localObject1, GloableValue.f, GloableValue.g);
    if (localObject2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(b, 2, "[@] getPreviewSizeGuaranteeOK: DEFAULT resolution os OK.");
      }
      if (paramBoolean) {
        NewFlowCameraReporter.a(2, GloableValue.f, GloableValue.g, ((CameraControl.CustomSize)localObject2).a, ((CameraControl.CustomSize)localObject2).b);
      }
      return localObject2;
    }
    if (QLog.isColorLevel()) {
      QLog.i(b, 2, "[@] getPreviewSizeGuaranteeOK: Degeneration to 640*480...");
    }
    localObject2 = a((List)localObject1, GloableValue.h[1], GloableValue.i[1]);
    if (localObject2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(b, 2, "[@] getPreviewSizeGuaranteeOK: 640*480 resolution os OK.");
      }
      if (paramBoolean) {
        NewFlowCameraReporter.a(3, GloableValue.f, GloableValue.g, ((CameraControl.CustomSize)localObject2).a, ((CameraControl.CustomSize)localObject2).b);
      }
      return localObject2;
    }
    localObject1 = a((List)localObject1, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      if (localObject1 == null) {
        paramInt1 = 0;
      } else {
        paramInt1 = ((CameraControl.CustomSize)localObject1).a;
      }
      if (localObject1 == null) {
        paramInt2 = i2;
      } else {
        paramInt2 = ((CameraControl.CustomSize)localObject1).b;
      }
      NewFlowCameraReporter.a(4, GloableValue.f, GloableValue.g, paramInt1, paramInt2);
    }
    return localObject1;
  }
  
  public boolean c()
  {
    Camera localCamera = this.d;
    if (localCamera == null) {
      return false;
    }
    if (this.n) {
      return true;
    }
    try
    {
      localCamera.startPreview();
      this.n = true;
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public boolean c(boolean paramBoolean)
  {
    if ((!q) && (this.d == null)) {
      throw new AssertionError();
    }
    if (CameraAbility.a().h())
    {
      Camera.Parameters localParameters = l();
      String str;
      if (paramBoolean) {
        str = "torch";
      } else {
        str = "off";
      }
      localParameters.setFlashMode(str);
      return a(localParameters);
    }
    return false;
  }
  
  public CameraControl.CustomSize[] c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[@] getPreviewAndPictureSizeGuarantee wanted size=");
      ((StringBuilder)localObject2).append(GloableValue.f);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(GloableValue.g);
      ((StringBuilder)localObject2).append(" cliped=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(paramInt2);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = new CameraControl.CustomSize[2];
    Object localObject2 = c(paramInt1, paramInt2, paramInt3, paramInt4, true);
    if (localObject2 != null)
    {
      localObject1[0] = localObject2;
      Object localObject4;
      if (QLog.isColorLevel())
      {
        localObject3 = b;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("[@] getPreviewAndPictureSizeGuarantee way2 preview=");
        ((StringBuilder)localObject4).append(((CameraControl.CustomSize)localObject2).a);
        ((StringBuilder)localObject4).append(" ");
        ((StringBuilder)localObject4).append(((CameraControl.CustomSize)localObject2).b);
        QLog.i((String)localObject3, 2, ((StringBuilder)localObject4).toString());
      }
      Object localObject3 = a(((CameraControl.CustomSize)localObject2).a, ((CameraControl.CustomSize)localObject2).b, paramInt3, paramInt4, 1);
      localObject1[1] = localObject3;
      if (localObject3 != null)
      {
        if (QLog.isColorLevel())
        {
          localObject4 = b;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[@] getPreviewAndPictureSizeGuarantee way2 picture=");
          localStringBuilder.append(((CameraControl.CustomSize)localObject3).a);
          localStringBuilder.append(" ");
          localStringBuilder.append(((CameraControl.CustomSize)localObject3).b);
          QLog.i((String)localObject4, 2, localStringBuilder.toString());
        }
        NewFlowCameraReporter.a(true, ((CameraControl.CustomSize)localObject2).a, ((CameraControl.CustomSize)localObject2).b, ((CameraControl.CustomSize)localObject3).a, ((CameraControl.CustomSize)localObject3).b);
        return localObject1;
      }
      NewFlowCameraReporter.a(true, ((CameraControl.CustomSize)localObject2).a, ((CameraControl.CustomSize)localObject2).b, -1, -1);
    }
    return localObject1;
  }
  
  public CameraControl.CustomSize d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    List localList = CameraAbility.a().i();
    if ((localList != null) && (!localList.isEmpty()))
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        paramInt2 = 0;
        while (paramInt2 < localList.size())
        {
          localObject1 = b;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[@] getFullVideoPreviewSize[list]: width=");
          ((StringBuilder)localObject2).append(((Camera.Size)localList.get(paramInt2)).width);
          ((StringBuilder)localObject2).append(" height=");
          ((StringBuilder)localObject2).append(((Camera.Size)localList.get(paramInt2)).height);
          ((StringBuilder)localObject2).append(" w/h=");
          ((StringBuilder)localObject2).append(((Camera.Size)localList.get(paramInt2)).width / ((Camera.Size)localList.get(paramInt2)).height);
          QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          paramInt2 += 1;
        }
      }
      if (FlowCameraConstant.b == 1)
      {
        if (!v)
        {
          a(w);
          v = true;
        }
        localObject1 = w;
      }
      else
      {
        if (!t)
        {
          a(u);
          t = true;
        }
        localObject1 = u;
      }
      double d1 = paramInt4;
      double d2 = paramInt3;
      Double.isNaN(d1);
      Double.isNaN(d2);
      d1 /= d2;
      if (QLog.isColorLevel())
      {
        localObject2 = b;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[@] getFullVideoPreviewSize[self-adaption] physicRatio=");
        ((StringBuilder)localObject3).append(d1);
        QLog.i((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
      ArrayList localArrayList2 = new ArrayList(3);
      ArrayList localArrayList1 = new ArrayList(3);
      Object localObject3 = new CameraControl.CustomSize();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Camera.Size localSize = (Camera.Size)localIterator.next();
        if (localSize != null)
        {
          d2 = localSize.width;
          double d3 = localSize.height;
          Double.isNaN(d2);
          Double.isNaN(d3);
          d2 /= d3;
          localObject2 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            d3 = ((Float)((Iterator)localObject2).next()).floatValue();
            Double.isNaN(d3);
            if (Math.abs(d3 - d2) <= 0.009999999776482582D)
            {
              if (d2 >= d1)
              {
                localArrayList2.add(localSize);
                break;
              }
              localArrayList1.add(localSize);
              break;
            }
          }
        }
      }
      int i2 = GloableValue.f;
      int i3 = GloableValue.g;
      if (QLog.isColorLevel())
      {
        localObject1 = b;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[@] getFullVideoPreviewSize[self-adaption] previewWidth=");
        ((StringBuilder)localObject2).append(i2);
        ((StringBuilder)localObject2).append("previewHeight=");
        ((StringBuilder)localObject2).append(i3);
        QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject1 = localArrayList2.iterator();
      int i1 = -1;
      for (paramInt2 = -1; ((Iterator)localObject1).hasNext(); paramInt2 = ((Camera.Size)localObject2).width)
      {
        label584:
        localObject2 = (Camera.Size)((Iterator)localObject1).next();
        if ((localObject2 == null) || (((Camera.Size)localObject2).height != i3) || (((Camera.Size)localObject2).width < i2) || ((paramInt2 >= 0) && (((Camera.Size)localObject2).width > paramInt2))) {
          break label584;
        }
      }
      if (paramInt2 > 0)
      {
        ((CameraControl.CustomSize)localObject3).b = i3;
        ((CameraControl.CustomSize)localObject3).a = paramInt2;
        if ((((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundCoolPad()) && (a(localArrayList1, i2, i3)))
        {
          ((CameraControl.CustomSize)localObject3).a = i2;
          return localObject3;
        }
        return localObject3;
      }
      localObject1 = localArrayList1.iterator();
      long l2 = 9223372036854775807L;
      long l1 = 9223372036854775807L;
      long l3;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Camera.Size)((Iterator)localObject1).next();
        if ((localObject2 != null) && (b(paramInt1, paramInt3, paramInt4, ((Camera.Size)localObject2).width, ((Camera.Size)localObject2).height)))
        {
          l3 = ((Camera.Size)localObject2).width * ((Camera.Size)localObject2).height;
          if (l3 < l1)
          {
            ((CameraControl.CustomSize)localObject3).a = ((Camera.Size)localObject2).width;
            ((CameraControl.CustomSize)localObject3).b = ((Camera.Size)localObject2).height;
            l1 = l3;
          }
          else if ((l3 == l1) && (((Camera.Size)localObject2).width < ((CameraControl.CustomSize)localObject3).a))
          {
            ((CameraControl.CustomSize)localObject3).a = ((Camera.Size)localObject2).width;
            ((CameraControl.CustomSize)localObject3).b = ((Camera.Size)localObject2).height;
          }
        }
      }
      if (((CameraControl.CustomSize)localObject3).a <= 0)
      {
        if (((CameraControl.CustomSize)localObject3).b > 0) {
          return localObject3;
        }
        paramInt2 = GloableValue.n[1];
        i2 = GloableValue.o[1];
        localObject1 = localArrayList2.iterator();
        for (paramInt1 = i1; ((Iterator)localObject1).hasNext(); paramInt1 = ((Camera.Size)localObject2).width)
        {
          label913:
          localObject2 = (Camera.Size)((Iterator)localObject1).next();
          if ((localObject2 == null) || (((Camera.Size)localObject2).height != i2) || (((Camera.Size)localObject2).width < paramInt2) || ((paramInt1 >= 0) && (((Camera.Size)localObject2).width > paramInt1))) {
            break label913;
          }
        }
        if (paramInt1 > 0)
        {
          ((CameraControl.CustomSize)localObject3).b = i2;
          ((CameraControl.CustomSize)localObject3).a = paramInt1;
          return localObject3;
        }
        if ((((CameraControl.CustomSize)localObject3).a <= 0) || (((CameraControl.CustomSize)localObject3).b <= 0))
        {
          localObject1 = localArrayList2.iterator();
          l1 = 9223372036854775807L;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Camera.Size)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              l3 = ((Camera.Size)localObject2).width * ((Camera.Size)localObject2).height;
              if (l3 < l1)
              {
                ((CameraControl.CustomSize)localObject3).a = ((Camera.Size)localObject2).width;
                ((CameraControl.CustomSize)localObject3).b = ((Camera.Size)localObject2).height;
                l1 = l3;
              }
              else if ((l3 == l1) && (((Camera.Size)localObject2).width < ((CameraControl.CustomSize)localObject3).a))
              {
                ((CameraControl.CustomSize)localObject3).a = ((Camera.Size)localObject2).width;
                ((CameraControl.CustomSize)localObject3).b = ((Camera.Size)localObject2).height;
              }
            }
          }
        }
        if ((((CameraControl.CustomSize)localObject3).a <= 0) || (((CameraControl.CustomSize)localObject3).b <= 0))
        {
          localObject1 = localArrayList1.iterator();
          l1 = l2;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Camera.Size)((Iterator)localObject1).next();
            if ((localObject2 != null) && (b(320, paramInt3, paramInt4, ((Camera.Size)localObject2).width, ((Camera.Size)localObject2).height)))
            {
              l2 = ((Camera.Size)localObject2).width * ((Camera.Size)localObject2).height;
              if (l2 < l1)
              {
                ((CameraControl.CustomSize)localObject3).a = ((Camera.Size)localObject2).width;
                ((CameraControl.CustomSize)localObject3).b = ((Camera.Size)localObject2).height;
                l1 = l2;
              }
              else if ((l2 == l1) && (((Camera.Size)localObject2).width < ((CameraControl.CustomSize)localObject3).a))
              {
                ((CameraControl.CustomSize)localObject3).a = ((Camera.Size)localObject2).width;
                ((CameraControl.CustomSize)localObject3).b = ((Camera.Size)localObject2).height;
              }
            }
          }
        }
        l1 = 0L;
        if ((((CameraControl.CustomSize)localObject3).a <= 0) || (((CameraControl.CustomSize)localObject3).b <= 0))
        {
          localObject1 = localList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Camera.Size)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              l2 = ((Camera.Size)localObject2).width * ((Camera.Size)localObject2).height;
              if (l2 > l1)
              {
                ((CameraControl.CustomSize)localObject3).a = ((Camera.Size)localObject2).width;
                ((CameraControl.CustomSize)localObject3).b = ((Camera.Size)localObject2).height;
                l1 = l2;
              }
              else if ((l2 == l1) && (((Camera.Size)localObject2).width < ((CameraControl.CustomSize)localObject3).a))
              {
                ((CameraControl.CustomSize)localObject3).a = ((Camera.Size)localObject2).width;
                ((CameraControl.CustomSize)localObject3).b = ((Camera.Size)localObject2).height;
              }
            }
          }
        }
        if (QLog.isColorLevel())
        {
          localObject1 = b;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[@] getFullVideoPreviewSize[self-adaption] cSize.width=");
          ((StringBuilder)localObject2).append(((CameraControl.CustomSize)localObject3).a);
          ((StringBuilder)localObject2).append("  cSize.height=");
          ((StringBuilder)localObject2).append(((CameraControl.CustomSize)localObject3).b);
          QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        if ((((CameraControl.CustomSize)localObject3).a > 0) && (((CameraControl.CustomSize)localObject3).b > 0)) {
          return localObject3;
        }
        return null;
      }
      return localObject3;
    }
    return null;
  }
  
  /* Error */
  public boolean d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 370	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:d	Landroid/hardware/Camera;
    //   4: ifnonnull +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: getfield 455	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:n	Z
    //   13: ifne +5 -> 18
    //   16: iconst_1
    //   17: ireturn
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield 455	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:n	Z
    //   23: aload_0
    //   24: invokespecial 508	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:s	()Z
    //   27: istore_1
    //   28: iload_1
    //   29: ifeq +10 -> 39
    //   32: aload_0
    //   33: getfield 370	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:d	Landroid/hardware/Camera;
    //   36: invokevirtual 511	android/hardware/Camera:cancelAutoFocus	()V
    //   39: aload_0
    //   40: getfield 370	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:d	Landroid/hardware/Camera;
    //   43: invokevirtual 794	android/hardware/Camera:stopPreview	()V
    //   46: aload_0
    //   47: getfield 370	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:d	Landroid/hardware/Camera;
    //   50: aconst_null
    //   51: invokevirtual 532	android/hardware/Camera:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   54: aload_0
    //   55: getfield 370	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:d	Landroid/hardware/Camera;
    //   58: aconst_null
    //   59: invokevirtual 539	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   62: iconst_1
    //   63: ireturn
    //   64: astore_2
    //   65: iconst_0
    //   66: ireturn
    //   67: astore_2
    //   68: goto -29 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	CameraControl
    //   27	2	1	bool	boolean
    //   64	1	2	localException	Exception
    //   67	1	2	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   18	28	64	java/lang/Exception
    //   32	39	64	java/lang/Exception
    //   39	62	64	java/lang/Exception
    //   32	39	67	java/lang/RuntimeException
  }
  
  public boolean d(int paramInt)
  {
    if ((!q) && (this.d == null)) {
      throw new AssertionError();
    }
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setParamsPreviewFps[fps_wanted=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    boolean bool2 = a(paramInt, false);
    if (QLog.isColorLevel())
    {
      str = b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setParamsPreviewFps[fps_wanted=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" force=false success=");
      localStringBuilder.append(bool2);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool2 = a(paramInt, true);
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        str = b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setParamsPreviewFps[fps_wanted=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" force=true success=");
        localStringBuilder.append(bool2);
        localStringBuilder.append("]");
        QLog.i(str, 2, localStringBuilder.toString());
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  @TargetApi(14)
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i(b, 2, "release camera");
    }
    if (!this.o) {
      return;
    }
    CameraAbility.a().l();
    if (this.d == null) {
      return;
    }
    q();
    try
    {
      this.d.release();
      this.d = null;
      this.h = -1;
      this.j = null;
      this.i = null;
      this.o = false;
      b();
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean e(int paramInt)
  {
    if ((!q) && (this.d == null)) {
      throw new AssertionError();
    }
    if (CameraAbility.a().g())
    {
      Camera.Parameters localParameters = l();
      if (localParameters == null) {
        return false;
      }
      int i2 = localParameters.getMaxZoom();
      int i1 = paramInt + localParameters.getZoom();
      paramInt = i1;
      if (i1 < 0) {
        paramInt = 0;
      }
      i1 = paramInt;
      if (paramInt > i2) {
        i1 = i2;
      }
      localParameters.setZoom(i1);
      return a(localParameters);
    }
    return false;
  }
  
  public int f()
  {
    return this.h;
  }
  
  public CameraControl.CustomSize f(int paramInt)
  {
    Object localObject2 = CameraAbility.a().i();
    if ((QLog.isColorLevel()) && (localObject2 != null))
    {
      int i1 = 0;
      while (i1 < ((List)localObject2).size())
      {
        localObject1 = b;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[@] getStarPhotoPreviewSize[list]: width=");
        ((StringBuilder)localObject3).append(((Camera.Size)((List)localObject2).get(i1)).width);
        ((StringBuilder)localObject3).append(" height=");
        ((StringBuilder)localObject3).append(((Camera.Size)((List)localObject2).get(i1)).height);
        ((StringBuilder)localObject3).append(" w/h=");
        ((StringBuilder)localObject3).append(((Camera.Size)((List)localObject2).get(i1)).width / ((Camera.Size)((List)localObject2).get(i1)).height);
        QLog.i((String)localObject1, 2, ((StringBuilder)localObject3).toString());
        i1 += 1;
      }
    }
    Object localObject3 = new ArrayList();
    Object localObject1 = new CameraControl.CustomSize();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Camera.Size localSize = (Camera.Size)((Iterator)localObject2).next();
        if ((localSize != null) && (localSize.height >= paramInt)) {
          ((List)localObject3).add(localSize);
        }
      }
    }
    if (((List)localObject3).size() > 0)
    {
      paramInt = 2147483647;
      localObject2 = ((List)localObject3).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Camera.Size)((Iterator)localObject2).next();
        if (((Camera.Size)localObject3).width < paramInt)
        {
          paramInt = ((Camera.Size)localObject3).width;
          ((CameraControl.CustomSize)localObject1).b = ((Camera.Size)localObject3).height;
          ((CameraControl.CustomSize)localObject1).a = ((Camera.Size)localObject3).width;
        }
      }
    }
    if (((CameraControl.CustomSize)localObject1).a > 0) {
      return localObject1;
    }
    return null;
  }
  
  public CameraControl.CustomSize g()
  {
    return this.i;
  }
  
  public CameraControl.CustomSize h()
  {
    return this.m;
  }
  
  public int[] i()
  {
    return this.j;
  }
  
  public boolean j()
  {
    if ((!q) && (this.d == null)) {
      throw new AssertionError();
    }
    Object localObject = Build.MODEL.toUpperCase();
    int i1;
    if ((Build.MANUFACTURER.equalsIgnoreCase("huawei")) && ((((String)localObject).contains("RLI-AN00")) || (((String)localObject).contains("RLI-N29")) || (((String)localObject).contains("TAH-AN00")) || (((String)localObject).contains("TAH-N29")))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = 90;
    if (i1 == 0)
    {
      i1 = i2;
      if (Build.VERSION.SDK_INT < 28) {}
    }
    else
    {
      localObject = new Camera.CameraInfo();
      Camera.getCameraInfo(this.g, (Camera.CameraInfo)localObject);
      int i3 = ((WindowManager)BaseApplicationImpl.getApplication().getSystemService("window")).getDefaultDisplay().getRotation();
      if (i3 != 0)
      {
        i1 = i2;
        if (i3 != 1) {
          if (i3 != 2)
          {
            if (i3 != 3) {
              i1 = i2;
            } else {
              i1 = 270;
            }
          }
          else {
            i1 = 180;
          }
        }
      }
      else
      {
        i1 = 0;
      }
      if (((Camera.CameraInfo)localObject).facing == 1) {
        i1 = (360 - (((Camera.CameraInfo)localObject).orientation + i1) % 360) % 360;
      } else {
        i1 = (((Camera.CameraInfo)localObject).orientation - i1 + 360) % 360;
      }
    }
    for (;;)
    {
      boolean bool3;
      boolean bool4;
      try
      {
        if (this.g == 1)
        {
          bool3 = ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProduct(CameraCompatibleConstants.e);
          bool4 = ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProductFeatureRom(CameraCompatibleConstants.f);
          if (bool3) {
            break label463;
          }
          bool1 = bool3;
          i2 = i1;
          bool2 = bool4;
          if (bool4) {
            break label463;
          }
        }
        else
        {
          bool1 = ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProduct(CameraCompatibleConstants.g);
          i2 = i1;
          if (!bool1) {
            break label480;
          }
          i2 = i1 + 180;
          break label480;
        }
        this.d.setDisplayOrientation(i2);
        this.k = i2;
        if (QLog.isColorLevel())
        {
          localObject = b;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setDisplayOrientation degrees=");
          localStringBuilder.append(i2);
          localStringBuilder.append(" blackPhone=");
          localStringBuilder.append(bool1);
          localStringBuilder.append(" camera=");
          localStringBuilder.append(FlowCameraConstant.b);
          localStringBuilder.append(" rom_black=");
          localStringBuilder.append(bool2);
          QLog.i((String)localObject, 2, localStringBuilder.toString());
        }
        return true;
      }
      catch (Exception localException)
      {
        return false;
      }
      label463:
      i2 = i1 + 180;
      boolean bool1 = bool3;
      boolean bool2 = bool4;
      continue;
      label480:
      bool2 = false;
    }
  }
  
  @TargetApi(14)
  public boolean k()
  {
    if ((!q) && (this.d == null)) {
      throw new AssertionError();
    }
    boolean bool = false;
    int i1;
    try
    {
      i1 = this.d.getParameters().getMaxNumDetectedFaces();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i1 = 0;
    }
    if (QLog.isColorLevel())
    {
      String str = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("supportFaceDetect");
      localStringBuilder.append(i1);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (i1 > 0) {
      bool = true;
    }
    return bool;
  }
  
  public Camera.Parameters l()
  {
    try
    {
      Camera.Parameters localParameters = this.d.getParameters();
      return localParameters;
    }
    catch (Exception localException)
    {
      QLog.e(b, 2, localException, new Object[0]);
    }
    return null;
  }
  
  public boolean m()
  {
    if ((!q) && (this.d == null)) {
      throw new AssertionError();
    }
    Object localObject = l();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(b, 2, "[@] setParamsPreviewFormat[failed]getCameraParameters=null");
      }
      return false;
    }
    boolean bool;
    StringBuilder localStringBuilder;
    if (CameraAbility.a().a(17))
    {
      ((Camera.Parameters)localObject).setPreviewFormat(17);
      this.h = 17;
      bool = a((Camera.Parameters)localObject);
      if (QLog.isColorLevel())
      {
        localObject = b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] setParamsPreviewFormat:success=");
        localStringBuilder.append(bool);
        localStringBuilder.append(", isSupportPreviewFormat=NV21 ok");
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
      return bool;
    }
    if (CameraAbility.a().a(842094169))
    {
      ((Camera.Parameters)localObject).setPreviewFormat(842094169);
      this.h = 842094169;
      bool = a((Camera.Parameters)localObject);
      if (QLog.isColorLevel())
      {
        localObject = b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] setParamsPreviewFormat:success=");
        localStringBuilder.append(bool);
        localStringBuilder.append("isSupportPreviewFormat=YV12 OK");
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
      return bool;
    }
    if (CameraAbility.a().a(20))
    {
      ((Camera.Parameters)localObject).setPreviewFormat(20);
      this.h = 20;
      bool = a((Camera.Parameters)localObject);
      if (QLog.isColorLevel())
      {
        localObject = b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] setParamsPreviewFormat:success=");
        localStringBuilder.append(bool);
        localStringBuilder.append("isSupportPreviewFormat=YUY2 OK");
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
      return bool;
    }
    if (CameraAbility.a().a(4))
    {
      ((Camera.Parameters)localObject).setPreviewFormat(4);
      this.h = 4;
      bool = a((Camera.Parameters)localObject);
      if (QLog.isColorLevel())
      {
        localObject = b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] setParamsPreviewFormat:success=");
        localStringBuilder.append(bool);
        localStringBuilder.append("isSupportPreviewFormat=RGB_565 OK");
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
      return bool;
    }
    if (CameraAbility.a().a(256))
    {
      ((Camera.Parameters)localObject).setPreviewFormat(256);
      this.h = 256;
      bool = a((Camera.Parameters)localObject);
      if (QLog.isColorLevel())
      {
        localObject = b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] setParamsPreviewFormat:success=");
        localStringBuilder.append(bool);
        localStringBuilder.append("isSupportPreviewFormat=JPEG OK");
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
      return bool;
    }
    if (CameraAbility.a().a(16))
    {
      ((Camera.Parameters)localObject).setPreviewFormat(16);
      this.h = 16;
      bool = a((Camera.Parameters)localObject);
      if (QLog.isColorLevel())
      {
        localObject = b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] setParamsPreviewFormat:success=");
        localStringBuilder.append(bool);
        localStringBuilder.append("isSupportPreviewFormat=NV16 OK");
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
      return bool;
    }
    return false;
  }
  
  public boolean n()
  {
    if ((!q) && (this.d == null)) {
      throw new AssertionError();
    }
    if (CameraAbility.a().h())
    {
      Camera.Parameters localParameters = l();
      if (TextUtils.equals(localParameters.getFlashMode(), "torch")) {
        localParameters.setFlashMode("off");
      } else {
        localParameters.setFlashMode("torch");
      }
      return a(localParameters);
    }
    return false;
  }
  
  public int o()
  {
    int i2 = this.k;
    if (FlowCameraConstant.b == 1)
    {
      int i1 = this.k;
      if (i1 == 270) {
        i1 -= 180;
      } else {
        i1 += 180;
      }
      i2 = i1;
      if (QLog.isColorLevel())
      {
        String str = b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getPreviewOrientation:blackPhone= orientation=");
        localStringBuilder.append(i1);
        QLog.i(str, 2, localStringBuilder.toString());
        i2 = i1;
      }
    }
    return i2;
  }
  
  @TargetApi(14)
  public void p()
  {
    if ((!q) && (this.d == null)) {
      throw new AssertionError();
    }
    try
    {
      this.d.startFaceDetection();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.i(b, 2, "startFaceDetection");
    }
  }
  
  @TargetApi(14)
  public void q()
  {
    if ((!q) && (this.d == null)) {
      throw new AssertionError();
    }
    try
    {
      this.d.setFaceDetectionListener(null);
      this.d.stopFaceDetection();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.i(b, 2, "stopFaceDetection");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraControl
 * JD-Core Version:    0.7.0.1
 */