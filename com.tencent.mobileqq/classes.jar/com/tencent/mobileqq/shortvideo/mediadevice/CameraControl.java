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
  public static double a;
  static CameraControl jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl;
  private static ArrayList<Float> jdField_a_of_type_JavaUtilArrayList;
  public static String b;
  private static ArrayList<Float> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private static boolean jdField_d_of_type_Boolean;
  private static boolean e;
  public int a;
  public Camera a;
  CameraHolder jdField_a_of_type_ComTencentMobileqqCameraCameraHolder = CameraHolder.a();
  CameraControl.CameraInformation jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CameraInformation = new CameraControl.CameraInformation(this);
  CameraControl.CustomSize jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize;
  boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  int[] jdField_a_of_type_ArrayOfInt;
  int jdField_b_of_type_Int;
  CameraControl.CustomSize jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize;
  boolean jdField_b_of_type_Boolean;
  private byte[] jdField_b_of_type_ArrayOfByte;
  int jdField_c_of_type_Int;
  int jdField_d_of_type_Int;
  
  static
  {
    jdField_b_of_type_JavaLangString = "CameraControl";
    jdField_a_of_type_Double = 0.009999999776482582D;
    d = false;
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    e = false;
  }
  
  public CameraControl()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  private CameraControl.CustomSize a(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[@] getHighVersionPreviewSize[wantedPreviewSize]: width=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("  height=");
      ((StringBuilder)localObject2).append(paramInt2);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = new CameraControl.CustomSize();
    int i = -1;
    int j = i;
    if (paramList != null)
    {
      j = i;
      if (!paramList.isEmpty())
      {
        paramList = paramList.iterator();
        for (;;)
        {
          j = i;
          if (!paramList.hasNext()) {
            break;
          }
          localObject2 = (Camera.Size)paramList.next();
          if ((localObject2 != null) && (((Camera.Size)localObject2).height == paramInt2) && (((Camera.Size)localObject2).width >= paramInt1) && ((i < 0) || (((Camera.Size)localObject2).width <= i))) {
            i = ((Camera.Size)localObject2).width;
          }
        }
      }
    }
    if (j > 0)
    {
      ((CameraControl.CustomSize)localObject1).jdField_b_of_type_Int = paramInt2;
      ((CameraControl.CustomSize)localObject1).jdField_a_of_type_Int = j;
      if (((CameraControl.CustomSize)localObject1).jdField_a_of_type_Int / 4 == ((CameraControl.CustomSize)localObject1).jdField_b_of_type_Int / 3)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getHighVersionPreviewSize[4:3]...");
        }
        return localObject1;
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getHighVersionPreviewSize: RATIO_MUST_EQUAL=false");
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
      localObject1 = jdField_b_of_type_JavaLangString;
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
              ((CameraControl.CustomSize)localObject1).jdField_a_of_type_Int = ((Camera.Size)localObject3).width;
              ((CameraControl.CustomSize)localObject1).jdField_b_of_type_Int = ((Camera.Size)localObject3).height;
              l1 = l2;
            }
            else if ((l2 == l1) && (((Camera.Size)localObject3).width < ((CameraControl.CustomSize)localObject1).jdField_a_of_type_Int))
            {
              ((CameraControl.CustomSize)localObject1).jdField_a_of_type_Int = ((Camera.Size)localObject3).width;
              ((CameraControl.CustomSize)localObject1).jdField_b_of_type_Int = ((Camera.Size)localObject3).height;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSize[self-adaption] have no resolution >= (w*h)");
    }
    l1 = 0L;
    if (((((CameraControl.CustomSize)localObject1).jdField_a_of_type_Int <= 0) || (((CameraControl.CustomSize)localObject1).jdField_b_of_type_Int <= 0)) && (paramList != null) && (!paramList.isEmpty()))
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
              ((CameraControl.CustomSize)localObject1).jdField_a_of_type_Int = ((Camera.Size)localObject3).width;
              ((CameraControl.CustomSize)localObject1).jdField_b_of_type_Int = ((Camera.Size)localObject3).height;
              l1 = l2;
            }
            else if ((l2 == l1) && (((Camera.Size)localObject3).width < ((CameraControl.CustomSize)localObject1).jdField_a_of_type_Int))
            {
              ((CameraControl.CustomSize)localObject1).jdField_a_of_type_Int = ((Camera.Size)localObject3).width;
              ((CameraControl.CustomSize)localObject1).jdField_b_of_type_Int = ((Camera.Size)localObject3).height;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_b_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[@] getPreviewSize[self-adaption] cSize.width=");
      ((StringBuilder)localObject3).append(((CameraControl.CustomSize)localObject1).jdField_a_of_type_Int);
      ((StringBuilder)localObject3).append("  cSize.height=");
      ((StringBuilder)localObject3).append(((CameraControl.CustomSize)localObject1).jdField_b_of_type_Int);
      QLog.i((String)localObject2, 2, ((StringBuilder)localObject3).toString());
    }
    if ((((CameraControl.CustomSize)localObject1).jdField_a_of_type_Int > 0) && (((CameraControl.CustomSize)localObject1).jdField_b_of_type_Int > 0)) {
      return localObject1;
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramList.get(0) != null))
    {
      ((CameraControl.CustomSize)localObject1).jdField_a_of_type_Int = ((Camera.Size)paramList.get(0)).width;
      ((CameraControl.CustomSize)localObject1).jdField_b_of_type_Int = ((Camera.Size)paramList.get(0)).height;
      return localObject1;
    }
    return null;
  }
  
  private CameraControl.CustomSize a(List<Camera.Size> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_b_of_type_JavaLangString;
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
          int i = Math.max(((Camera.Size)localObject3).width, ((Camera.Size)localObject3).height);
          int j = Math.min(((Camera.Size)localObject3).width, ((Camera.Size)localObject3).height);
          if ((((Camera.Size)localObject3).height == paramInt2) && (i == paramInt1))
          {
            ((List)localObject1).add(new CameraControl.CustomSize(paramInt1, paramInt2));
            if (!QLog.isColorLevel()) {
              break;
            }
            paramList = jdField_b_of_type_JavaLangString;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("[@] getHighVersionPreviewSizeV3 first: width=");
            ((StringBuilder)localObject3).append(paramInt1);
            ((StringBuilder)localObject3).append("  height=");
            ((StringBuilder)localObject3).append(paramInt2);
            QLog.i(paramList, 2, ((StringBuilder)localObject3).toString());
            break;
          }
          if ((i > paramInt5) && (i < paramInt3))
          {
            if (j > paramInt6)
            {
              if (j >= paramInt4) {
                continue;
              }
              ((List)localObject2).add(new CameraControl.CustomSize(i, j));
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
          paramInt1 = Math.max(((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int);
          paramInt2 = Math.min(((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int);
          f2 = f3 - paramInt1 / paramInt2;
          if (Math.abs(f2) < jdField_a_of_type_Double) {
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
          paramList = jdField_b_of_type_JavaLangString;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[@] getHighVersionPreviewSizeV2 secend: width=");
          ((StringBuilder)localObject3).append(((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).jdField_a_of_type_Int);
          ((StringBuilder)localObject3).append(" height=");
          ((StringBuilder)localObject3).append(((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).jdField_b_of_type_Int);
          ((StringBuilder)localObject3).append(" w/h=");
          ((StringBuilder)localObject3).append(((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).jdField_a_of_type_Int / ((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).jdField_b_of_type_Int);
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
          paramInt1 = Math.max(((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int);
          paramInt2 = Math.min(((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int);
          if (Math.abs(Math.abs(f3 - paramInt1 / paramInt2) - f2) < jdField_a_of_type_Double) {
            ((List)localObject1).add(localObject2);
          }
        }
      }
      if (QLog.isColorLevel())
      {
        paramInt1 = 0;
        while (paramInt1 < ((List)localObject1).size())
        {
          paramList = jdField_b_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[@] getHighVersionPreviewSizeV2 third: width=");
          ((StringBuilder)localObject2).append(((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).jdField_a_of_type_Int);
          ((StringBuilder)localObject2).append(" height=");
          ((StringBuilder)localObject2).append(((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).jdField_b_of_type_Int);
          ((StringBuilder)localObject2).append(" w/h=");
          ((StringBuilder)localObject2).append(((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).jdField_a_of_type_Int / ((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).jdField_b_of_type_Int);
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
        if ((localObject1 != null) && (((CameraControl.CustomSize)localObject1).jdField_a_of_type_Int * ((CameraControl.CustomSize)localObject1).jdField_b_of_type_Int > paramList.jdField_a_of_type_Int * paramList.jdField_b_of_type_Int)) {
          paramList = (List<Camera.Size>)localObject1;
        }
      }
      return paramList;
    }
    return null;
  }
  
  public static CameraControl a()
  {
    if (jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl == null) {
          jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl = new CameraControl();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl;
  }
  
  public static String a(int paramInt)
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
  
  private static void a(ArrayList<Float> paramArrayList)
  {
    Object localObject = CameraAbility.a().b();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Camera.Size localSize = (Camera.Size)((Iterator)localObject).next();
        float f = localSize.width / localSize.height;
        if (!paramArrayList.contains(Float.valueOf(f))) {
          paramArrayList.add(Float.valueOf(f));
        }
      }
    }
  }
  
  private void a(List<int[]> paramList)
  {
    int i;
    if ((paramList != null) && (paramList.size() > 0)) {
      i = 0;
    }
    while (i < paramList.size())
    {
      Object localObject1 = (int[])paramList.get(i);
      Object localObject2;
      if ((localObject1 != null) && (localObject1.length >= 2))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = jdField_b_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("printFpsRange[i=");
          localStringBuilder.append(i);
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
        localObject1 = jdField_b_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("printFpsRange[i=");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" ele=null]");
        QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      i += 1;
      continue;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "printFpsRange[listFpsRange=null]");
      }
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = Math.max(paramInt1, paramInt2);
    paramInt1 = Math.min(paramInt1, paramInt2);
    float f1 = i / paramInt1;
    paramInt1 = Math.max(paramInt3, paramInt4);
    paramInt2 = Math.min(paramInt3, paramInt4);
    float f2 = paramInt1 / paramInt2;
    boolean bool;
    if (Math.abs(f2 - f1) > jdField_a_of_type_Double) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      String str = jdField_b_of_type_JavaLangString;
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
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
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
  
  private boolean a(ArrayList<Camera.Size> paramArrayList, int paramInt1, int paramInt2)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() <= 0) {
        return false;
      }
      int i = 0;
      while (i < paramArrayList.size())
      {
        Camera.Size localSize = (Camera.Size)paramArrayList.get(i);
        if ((localSize.width == paramInt1) && (localSize.height == paramInt2)) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private int[] a(List<int[]> paramList)
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
    for (int j = 0; ((Iterator)localObject2).hasNext(); j = arrayOfInt2[1])
    {
      arrayOfInt2 = (int[])((Iterator)localObject2).next();
      if ((arrayOfInt2 == null) || (arrayOfInt2.length < 2) || (arrayOfInt2[1] < j)) {
        break label35;
      }
    }
    if (j <= 0) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject2 = (int[])paramList.next();
      if ((localObject2 != null) && (localObject2.length >= 2) && (localObject2[1] == j)) {
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    if (((ArrayList)localObject1).size() <= 0) {
      return null;
    }
    paramList = ((ArrayList)localObject1).iterator();
    int k = 2147483647;
    int m = 0;
    while (paramList.hasNext())
    {
      localObject1 = (int[])paramList.next();
      int i;
      if (localObject1[0] >= 15000) {
        i = localObject1[0] - 15000;
      } else {
        i = 15000 - localObject1[0];
      }
      if (i < k)
      {
        m = localObject1[0];
        k = i;
      }
    }
    if (k != 2147483647)
    {
      arrayOfInt1[0] = m;
      arrayOfInt1[1] = j;
    }
    else
    {
      arrayOfInt1[0] = j;
      arrayOfInt1[1] = j;
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
  
  private int[] a(List<int[]> paramList, int paramInt)
  {
    int[] arrayOfInt2 = a(paramList);
    int[] arrayOfInt1 = arrayOfInt2;
    if (arrayOfInt2 == null) {
      arrayOfInt1 = b(paramList, paramInt);
    }
    return arrayOfInt1;
  }
  
  private int b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return CameraAbility.b();
      }
      if (CameraAbility.b()) {
        return CameraAbility.b();
      }
    }
    else if (CameraAbility.c())
    {
      return CameraAbility.a();
    }
    return -1;
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
  
  private int c()
  {
    int i = ImageFormat.getBitsPerPixel(this.jdField_b_of_type_Int);
    float f = i * 1.0F / 8.0F;
    int j = (int)(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_b_of_type_Int * this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_a_of_type_Int * f);
    if (QLog.isColorLevel())
    {
      String str = jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startPreview getPreviewBufferSize:bitpixel=");
      localStringBuilder.append(i);
      localStringBuilder.append(" byteNum=");
      localStringBuilder.append(f);
      localStringBuilder.append(" bufSize=");
      localStringBuilder.append(j);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    return j;
  }
  
  private boolean c(int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    try
    {
      if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length != paramInt)) {
        this.jdField_a_of_type_ArrayOfByte = new byte[paramInt];
      }
      if ((this.jdField_b_of_type_ArrayOfByte != null) && (this.jdField_b_of_type_ArrayOfByte.length == paramInt)) {
        break label104;
      }
      this.jdField_b_of_type_ArrayOfByte = new byte[paramInt];
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
      if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length != paramInt)) {
        this.jdField_a_of_type_ArrayOfByte = new byte[paramInt];
      }
      if ((this.jdField_b_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_ArrayOfByte.length != paramInt)) {
        this.jdField_b_of_type_ArrayOfByte = new byte[paramInt];
      }
      return true;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      String str = jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("allocateFrame failed , size:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", ");
      localStringBuilder.append(localOutOfMemoryError1.getMessage());
      QLog.e(str, 2, localStringBuilder.toString());
      return false;
    }
  }
  
  private boolean g()
  {
    return ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProduct(CameraCompatibleConstants.a) ^ true;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    if (FlowCameraMqqAction.a()) {
      return 1;
    }
    if (!CameraAbility.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] openCamera[failed]hasCameras=false");
      }
      return 2;
    }
    String str;
    Object localObject;
    if (this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        str = jdField_b_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[openCamera]Camera is opened, Camera object ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidHardwareCamera);
        QLog.i(str, 2, ((StringBuilder)localObject).toString());
      }
      return 5;
    }
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (j < 10) {
        try
        {
          this.jdField_a_of_type_Int = b(paramInt);
          if (VersionUtils.c())
          {
            if (QLog.isColorLevel())
            {
              str = jdField_b_of_type_JavaLangString;
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("openCamera:currentCount= ");
              ((StringBuilder)localObject).append(j);
              QLog.d(str, 2, ((StringBuilder)localObject).toString());
            }
            str = jdField_b_of_type_JavaLangString;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("【Real Old openCamera】:");
            ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
            AEQLog.b(str, ((StringBuilder)localObject).toString());
            str = jdField_b_of_type_JavaLangString;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("【Real Old openCamera】:currentCount= ");
            ((StringBuilder)localObject).append(j);
            AEQLog.b(str, ((StringBuilder)localObject).toString());
            this.jdField_a_of_type_AndroidHardwareCamera = Camera.open(this.jdField_a_of_type_Int);
          }
          else
          {
            this.jdField_a_of_type_AndroidHardwareCamera = Camera.open();
          }
          i = 0;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          this.jdField_a_of_type_AndroidHardwareCamera = null;
          j += 1;
          if (QLog.isColorLevel())
          {
            localObject = jdField_b_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[@] openCamera[failed][RM_CAMERA_OPEN_FAILED]currentCount=");
            localStringBuilder.append(j);
            QLog.i((String)localObject, 2, localStringBuilder.toString(), localException);
          }
          if (j >= 10) {}
        }
      }
      try
      {
        Thread.sleep(300L);
        label349:
        i = 3;
        continue;
        if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
          return i;
        }
        if (!CameraAbility.a().a(this.jdField_a_of_type_AndroidHardwareCamera))
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] openCamera[failed]bindCamera=false");
          }
          return 4;
        }
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CameraInformation = new CameraControl.CameraInformation(this);
        this.jdField_b_of_type_Boolean = true;
        return 0;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label349;
      }
    }
  }
  
  public Camera.Parameters a()
  {
    try
    {
      Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
      return localParameters;
    }
    catch (Exception localException)
    {
      QLog.e(jdField_b_of_type_JavaLangString, 2, localException, new Object[0]);
    }
    return null;
  }
  
  public CameraControl.CustomSize a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize;
  }
  
  public CameraControl.CustomSize a(int paramInt)
  {
    Object localObject2 = CameraAbility.a().a();
    if ((QLog.isColorLevel()) && (localObject2 != null))
    {
      int i = 0;
      while (i < ((List)localObject2).size())
      {
        localObject1 = jdField_b_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[@] getStarPhotoPreviewSize[list]: width=");
        ((StringBuilder)localObject3).append(((Camera.Size)((List)localObject2).get(i)).width);
        ((StringBuilder)localObject3).append(" height=");
        ((StringBuilder)localObject3).append(((Camera.Size)((List)localObject2).get(i)).height);
        ((StringBuilder)localObject3).append(" w/h=");
        ((StringBuilder)localObject3).append(((Camera.Size)((List)localObject2).get(i)).width / ((Camera.Size)((List)localObject2).get(i)).height);
        QLog.i((String)localObject1, 2, ((StringBuilder)localObject3).toString());
        i += 1;
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
          ((CameraControl.CustomSize)localObject1).jdField_b_of_type_Int = ((Camera.Size)localObject3).height;
          ((CameraControl.CustomSize)localObject1).jdField_a_of_type_Int = ((Camera.Size)localObject3).width;
        }
      }
    }
    if (((CameraControl.CustomSize)localObject1).jdField_a_of_type_Int > 0) {
      return localObject1;
    }
    return null;
  }
  
  public CameraControl.CustomSize a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    List localList = CameraAbility.a().a();
    if ((localList != null) && (!localList.isEmpty()))
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        paramInt2 = 0;
        while (paramInt2 < localList.size())
        {
          localObject1 = jdField_b_of_type_JavaLangString;
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
      if (FlowCameraConstant.jdField_a_of_type_Int == 1)
      {
        if (!e)
        {
          a(jdField_b_of_type_JavaUtilArrayList);
          e = true;
        }
        localObject1 = jdField_b_of_type_JavaUtilArrayList;
      }
      else
      {
        if (!d)
        {
          a(jdField_a_of_type_JavaUtilArrayList);
          d = true;
        }
        localObject1 = jdField_a_of_type_JavaUtilArrayList;
      }
      double d1 = paramInt4;
      double d2 = paramInt3;
      Double.isNaN(d1);
      Double.isNaN(d2);
      d1 /= d2;
      if (QLog.isColorLevel())
      {
        localObject2 = jdField_b_of_type_JavaLangString;
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
      int j = GloableValue.jdField_c_of_type_Int;
      int k = GloableValue.d;
      if (QLog.isColorLevel())
      {
        localObject1 = jdField_b_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[@] getFullVideoPreviewSize[self-adaption] previewWidth=");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append("previewHeight=");
        ((StringBuilder)localObject2).append(k);
        QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject1 = localArrayList2.iterator();
      int i = -1;
      for (paramInt2 = -1; ((Iterator)localObject1).hasNext(); paramInt2 = ((Camera.Size)localObject2).width)
      {
        label584:
        localObject2 = (Camera.Size)((Iterator)localObject1).next();
        if ((localObject2 == null) || (((Camera.Size)localObject2).height != k) || (((Camera.Size)localObject2).width < j) || ((paramInt2 >= 0) && (((Camera.Size)localObject2).width > paramInt2))) {
          break label584;
        }
      }
      if (paramInt2 > 0)
      {
        ((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int = k;
        ((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int = paramInt2;
        if ((((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundCoolPad()) && (a(localArrayList1, j, k)))
        {
          ((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int = j;
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
        if ((localObject2 != null) && (a(paramInt1, paramInt3, paramInt4, ((Camera.Size)localObject2).width, ((Camera.Size)localObject2).height)))
        {
          l3 = ((Camera.Size)localObject2).width * ((Camera.Size)localObject2).height;
          if (l3 < l1)
          {
            ((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int = ((Camera.Size)localObject2).width;
            ((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int = ((Camera.Size)localObject2).height;
            l1 = l3;
          }
          else if ((l3 == l1) && (((Camera.Size)localObject2).width < ((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int))
          {
            ((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int = ((Camera.Size)localObject2).width;
            ((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int = ((Camera.Size)localObject2).height;
          }
        }
      }
      if (((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int <= 0)
      {
        if (((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int > 0) {
          return localObject3;
        }
        paramInt2 = GloableValue.g[1];
        j = GloableValue.h[1];
        localObject1 = localArrayList2.iterator();
        for (paramInt1 = i; ((Iterator)localObject1).hasNext(); paramInt1 = ((Camera.Size)localObject2).width)
        {
          label913:
          localObject2 = (Camera.Size)((Iterator)localObject1).next();
          if ((localObject2 == null) || (((Camera.Size)localObject2).height != j) || (((Camera.Size)localObject2).width < paramInt2) || ((paramInt1 >= 0) && (((Camera.Size)localObject2).width > paramInt1))) {
            break label913;
          }
        }
        if (paramInt1 > 0)
        {
          ((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int = j;
          ((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int = paramInt1;
          return localObject3;
        }
        if ((((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int <= 0) || (((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int <= 0))
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
                ((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int = ((Camera.Size)localObject2).width;
                ((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int = ((Camera.Size)localObject2).height;
                l1 = l3;
              }
              else if ((l3 == l1) && (((Camera.Size)localObject2).width < ((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int))
              {
                ((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int = ((Camera.Size)localObject2).width;
                ((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int = ((Camera.Size)localObject2).height;
              }
            }
          }
        }
        if ((((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int <= 0) || (((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int <= 0))
        {
          localObject1 = localArrayList1.iterator();
          l1 = l2;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Camera.Size)((Iterator)localObject1).next();
            if ((localObject2 != null) && (a(320, paramInt3, paramInt4, ((Camera.Size)localObject2).width, ((Camera.Size)localObject2).height)))
            {
              l2 = ((Camera.Size)localObject2).width * ((Camera.Size)localObject2).height;
              if (l2 < l1)
              {
                ((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int = ((Camera.Size)localObject2).width;
                ((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int = ((Camera.Size)localObject2).height;
                l1 = l2;
              }
              else if ((l2 == l1) && (((Camera.Size)localObject2).width < ((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int))
              {
                ((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int = ((Camera.Size)localObject2).width;
                ((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int = ((Camera.Size)localObject2).height;
              }
            }
          }
        }
        l1 = 0L;
        if ((((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int <= 0) || (((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int <= 0))
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
                ((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int = ((Camera.Size)localObject2).width;
                ((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int = ((Camera.Size)localObject2).height;
                l1 = l2;
              }
              else if ((l2 == l1) && (((Camera.Size)localObject2).width < ((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int))
              {
                ((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int = ((Camera.Size)localObject2).width;
                ((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int = ((Camera.Size)localObject2).height;
              }
            }
          }
        }
        if (QLog.isColorLevel())
        {
          localObject1 = jdField_b_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[@] getFullVideoPreviewSize[self-adaption] cSize.width=");
          ((StringBuilder)localObject2).append(((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int);
          ((StringBuilder)localObject2).append("  cSize.height=");
          ((StringBuilder)localObject2).append(((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int);
          QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        if ((((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int > 0) && (((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int > 0)) {
          return localObject3;
        }
        return null;
      }
      return localObject3;
    }
    return null;
  }
  
  public CameraControl.CustomSize a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize == null)) {
      throw new AssertionError();
    }
    if (a() == null) {
      return null;
    }
    int i = Math.min(paramInt1, paramInt2);
    paramInt1 = Math.max(paramInt1, paramInt2);
    float f3 = paramInt1 / i;
    Object localObject2 = new CameraControl.CustomSize();
    Object localObject3 = CameraAbility.a().b();
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
            String str = jdField_b_of_type_JavaLangString;
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
          if (Math.abs(f4) <= jdField_a_of_type_Double) {
            localArrayList.add(localSize);
          }
          float f2 = f1;
          if (localSize.width >= paramInt1)
          {
            f2 = f1;
            if (f1 > Math.abs(f4))
            {
              f2 = Math.abs(f4);
              ((CameraControl.CustomSize)localObject1).jdField_a_of_type_Int = localSize.width;
              ((CameraControl.CustomSize)localObject1).jdField_b_of_type_Int = localSize.height;
            }
          }
          f1 = f2;
        }
      }
      if ((localArrayList.isEmpty()) && (((CameraControl.CustomSize)localObject1).jdField_a_of_type_Int >= paramInt1))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = jdField_b_of_type_JavaLangString;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("getPictureSize: width=");
          ((StringBuilder)localObject3).append(((CameraControl.CustomSize)localObject1).jdField_a_of_type_Int);
          ((StringBuilder)localObject3).append(" height=");
          ((StringBuilder)localObject3).append(((CameraControl.CustomSize)localObject1).jdField_b_of_type_Int);
          ((StringBuilder)localObject3).append(" w/h=");
          ((StringBuilder)localObject3).append(((CameraControl.CustomSize)localObject1).jdField_a_of_type_Int / ((CameraControl.CustomSize)localObject1).jdField_b_of_type_Int);
          QLog.i((String)localObject2, 2, ((StringBuilder)localObject3).toString());
        }
        return localObject1;
      }
      if ((localArrayList.isEmpty()) && (((List)localObject3).size() > 0))
      {
        ((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int = ((Camera.Size)((List)localObject3).get(0)).width;
        ((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int = ((Camera.Size)((List)localObject3).get(0)).height;
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
          if (((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int < ((Camera.Size)localObject1).width)
          {
            ((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int = ((Camera.Size)localObject1).width;
            ((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int = ((Camera.Size)localObject1).height;
          }
        }
      }
      localObject1 = a(paramInt3, paramInt4, paramInt5, localArrayList);
      if (((CameraControl.CustomSize)localObject1).jdField_a_of_type_Int == 0) {
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
      localObject1 = jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[@] getPreviewSizeV2: dstwidth=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("  dstheight=");
      ((StringBuilder)localObject2).append(paramInt2);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = CameraAbility.a().a();
    boolean bool = QLog.isColorLevel();
    int j = 0;
    if ((bool) && (localObject1 != null))
    {
      int i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] getPreviewSizeGuaranteeOK[list]: width=");
        localStringBuilder.append(((Camera.Size)((List)localObject1).get(i)).width);
        localStringBuilder.append(" height=");
        localStringBuilder.append(((Camera.Size)((List)localObject1).get(i)).height);
        localStringBuilder.append(" w/h=");
        localStringBuilder.append(((Camera.Size)((List)localObject1).get(i)).width / ((Camera.Size)((List)localObject1).get(i)).height);
        QLog.i((String)localObject2, 2, localStringBuilder.toString());
        i += 1;
      }
    }
    Object localObject2 = a((List)localObject1, paramInt1, paramInt2);
    if (localObject2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: DEFAULT resolution os OK.");
      }
      if (paramBoolean) {
        NewFlowCameraReporter.a(2, paramInt1, paramInt2, ((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int);
      }
      return localObject2;
    }
    localObject2 = a((List)localObject1, 960, 720);
    if (localObject2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: 640*480 resolution os OK.");
      }
      if (paramBoolean) {
        NewFlowCameraReporter.a(3, paramInt1, paramInt2, ((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int);
      }
      return localObject2;
    }
    localObject1 = a((List)localObject1, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      if (localObject1 == null) {
        paramInt3 = 0;
      } else {
        paramInt3 = ((CameraControl.CustomSize)localObject1).jdField_a_of_type_Int;
      }
      if (localObject1 == null) {
        paramInt4 = j;
      } else {
        paramInt4 = ((CameraControl.CustomSize)localObject1).jdField_b_of_type_Int;
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
      localObject1 = jdField_b_of_type_JavaLangString;
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
        ((CameraControl.CustomSize)localObject1).jdField_a_of_type_Int = ((Camera.Size)localObject2).width;
        ((CameraControl.CustomSize)localObject1).jdField_b_of_type_Int = ((Camera.Size)localObject2).height;
        paramInt1 = paramInt2;
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_ArrayOfByte = null;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "releasePreviewFrameBuffer");
    }
  }
  
  @TargetApi(14)
  public void a(Camera.FaceDetectionListener paramFaceDetectionListener)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setFaceDetectionListener(paramFaceDetectionListener);
    }
    catch (Exception paramFaceDetectionListener)
    {
      paramFaceDetectionListener.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "setFaceDetectionListener");
    }
  }
  
  @TargetApi(17)
  public void a(File paramFile, Rect paramRect, CameraCover.PictureCallback paramPictureCallback, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera == null)
    {
      if (QLog.isColorLevel())
      {
        paramFile = jdField_b_of_type_JavaLangString;
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
      this.jdField_a_of_type_AndroidHardwareCamera.enableShutterSound(false);
    }
    catch (Exception localException)
    {
      QLog.i(jdField_b_of_type_JavaLangString, 1, "[takePicture]enableShutterSound error, ", localException);
    }
    try
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidHardwareCamera.takePicture(null, null, null, new CameraControl.1(this, paramInt1, l, paramFile, paramRect, paramPictureCallback, paramBoolean, paramInt2));
      return;
    }
    catch (RuntimeException paramFile)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "", paramFile);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidHardwareCamera != null) && (c(c())))
    {
      this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(this.jdField_a_of_type_ArrayOfByte);
      this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(this.jdField_b_of_type_ArrayOfByte);
    }
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (paramBoolean)
    {
      Camera localCamera = this.jdField_a_of_type_AndroidHardwareCamera;
      if ((localCamera != null) && (paramArrayOfByte != null)) {
        localCamera.addCallbackBuffer(paramArrayOfByte);
      }
    }
  }
  
  public boolean a()
  {
    Camera localCamera = this.jdField_a_of_type_AndroidHardwareCamera;
    if (localCamera == null) {
      return false;
    }
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    try
    {
      localCamera.startPreview();
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = jdField_b_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setParamsPreviewFps[fps_wanted=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    boolean bool2 = a(paramInt, false);
    if (QLog.isColorLevel())
    {
      str = jdField_b_of_type_JavaLangString;
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
        str = jdField_b_of_type_JavaLangString;
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
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    Camera.Parameters localParameters = a();
    if (localParameters == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setPreviewFps[failed]getCameraParameters=null");
      }
      return false;
    }
    int[] arrayOfInt = a(paramInt, paramBoolean);
    if ((arrayOfInt != null) && (arrayOfInt.length >= 2)) {
      if (QLog.isColorLevel())
      {
        String str = jdField_b_of_type_JavaLangString;
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
      this.jdField_a_of_type_ArrayOfInt = arrayOfInt;
      paramBoolean = a(localParameters);
      return paramBoolean;
    }
    catch (Exception localException) {}
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "setPreviewFps[getFpsRange=null]");
    }
    return false;
    return false;
  }
  
  public boolean a(SurfaceTexture paramSurfaceTexture)
  {
    Object localObject = this.jdField_a_of_type_AndroidHardwareCamera;
    if (localObject != null)
    {
      if (paramSurfaceTexture == null) {
        return false;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel())
        {
          paramSurfaceTexture = jdField_b_of_type_JavaLangString;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("@$[setPreviewTexture] mIsPreviewing=");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
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
          QLog.i(jdField_b_of_type_JavaLangString, 2, "@$[setPreviewTexture] exp=", paramSurfaceTexture);
        }
      }
    }
    return false;
  }
  
  public boolean a(Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    if ((this.jdField_a_of_type_AndroidHardwareCamera != null) && (this.jdField_a_of_type_Boolean)) {
      if (!g()) {
        return false;
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
      this.jdField_a_of_type_AndroidHardwareCamera.autoFocus(paramAutoFocusCallback);
      return true;
    }
    catch (Exception paramAutoFocusCallback) {}
    return false;
    return false;
  }
  
  public boolean a(Camera.Parameters paramParameters)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if (paramParameters == null) {
      return false;
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setParameters(paramParameters);
      return true;
    }
    catch (Exception paramParameters)
    {
      QLog.e(jdField_b_of_type_JavaLangString, 2, paramParameters, new Object[0]);
    }
    return false;
  }
  
  public boolean a(Camera.PreviewCallback paramPreviewCallback, boolean paramBoolean)
  {
    Camera localCamera = this.jdField_a_of_type_AndroidHardwareCamera;
    if (localCamera != null)
    {
      if (paramPreviewCallback == null) {
        return false;
      }
      if (!paramBoolean) {}
    }
    try
    {
      if (c(c()))
      {
        this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(this.jdField_a_of_type_ArrayOfByte);
        this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(this.jdField_b_of_type_ArrayOfByte);
        this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallbackWithBuffer(paramPreviewCallback);
      }
      else
      {
        this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(paramPreviewCallback);
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
    Object localObject = this.jdField_a_of_type_AndroidHardwareCamera;
    if (localObject != null)
    {
      if (paramSurfaceHolder == null) {
        return false;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel())
        {
          paramSurfaceHolder = jdField_b_of_type_JavaLangString;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("@$[setSurfaceHolder] mIsPreviewing=");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
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
          QLog.i(jdField_b_of_type_JavaLangString, 2, "@$[setSurfaceHolder] exp=", paramSurfaceHolder);
        }
      }
    }
    return false;
  }
  
  public boolean a(CameraControl.CustomSize paramCustomSize)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewSize[failed]getCameraParameters=null");
      }
      return false;
    }
    try
    {
      ((Camera.Parameters)localObject).setPreviewSize(paramCustomSize.jdField_a_of_type_Int, paramCustomSize.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = paramCustomSize;
      boolean bool = a((Camera.Parameters)localObject);
      if (QLog.isColorLevel())
      {
        localObject = jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] setParamsPreviewSize, result = ");
        localStringBuilder.append(bool);
        localStringBuilder.append(",size.width = ");
        localStringBuilder.append(paramCustomSize.jdField_a_of_type_Int);
        localStringBuilder.append(",size.height = ");
        localStringBuilder.append(paramCustomSize.jdField_b_of_type_Int);
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
    Camera.Parameters localParameters = a();
    if (localParameters == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewFormat[failed]getCameraParameters=null");
      }
      return false;
    }
    localParameters.setPreviewFormat(paramParamCache.jdField_a_of_type_Int);
    localParameters.setPreviewSize(paramParamCache.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_a_of_type_Int, paramParamCache.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_b_of_type_Int);
    localParameters.setPreviewFpsRange(paramParamCache.jdField_b_of_type_Int, paramParamCache.jdField_c_of_type_Int);
    if (paramParamCache.jdField_a_of_type_Boolean) {
      localParameters.setPictureSize(paramParamCache.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_a_of_type_Int, paramParamCache.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_b_of_type_Int);
    }
    boolean bool = a(localParameters);
    if (bool)
    {
      this.jdField_b_of_type_Int = paramParamCache.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = paramParamCache.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize;
      this.jdField_a_of_type_ArrayOfInt = new int[] { paramParamCache.jdField_b_of_type_Int, paramParamCache.jdField_c_of_type_Int };
      this.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = paramParamCache.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize;
    }
    return bool;
  }
  
  public boolean a(String paramString)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    boolean bool2 = g();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
    }
    catch (RuntimeException localRuntimeException)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "", localRuntimeException);
      }
    }
    Object localObject1 = a();
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = ((Camera.Parameters)localObject1).getFocusMode();
    if (QLog.isColorLevel())
    {
      String str = jdField_b_of_type_JavaLangString;
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
      localObject1 = jdField_b_of_type_JavaLangString;
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
  
  public boolean a(boolean paramBoolean)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if (CameraAbility.a().e())
    {
      Camera.Parameters localParameters = a();
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
  
  public int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public int[] a(int paramInt, boolean paramBoolean)
  {
    int[] arrayOfInt1 = new int[2];
    int[] tmp7_5 = arrayOfInt1;
    tmp7_5[0] = 2147483647;
    int[] tmp13_7 = tmp7_5;
    tmp13_7[1] = 2147483647;
    tmp13_7;
    int i = paramInt * 1000;
    List localList = CameraAbility.a().c();
    if (localList == null)
    {
      arrayOfInt1[0] = i;
      arrayOfInt1[1] = i;
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
      if ((arrayOfInt2 != null) && (arrayOfInt2.length >= 2) && (i >= arrayOfInt2[0]) && (i <= arrayOfInt2[1]))
      {
        arrayOfInt1[0] = i;
        arrayOfInt1[1] = arrayOfInt2[1];
        return arrayOfInt1;
      }
    }
    return a(localList, paramInt);
  }
  
  public CameraControl.CustomSize[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_b_of_type_JavaLangString;
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
        localObject3 = jdField_b_of_type_JavaLangString;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("[@] getPreviewAndPictureSizeGuarantee way2 preview=");
        ((StringBuilder)localObject4).append(((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int);
        ((StringBuilder)localObject4).append(" ");
        ((StringBuilder)localObject4).append(((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int);
        QLog.i((String)localObject3, 2, ((StringBuilder)localObject4).toString());
      }
      Object localObject3 = a(((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int, paramInt3, paramInt4, 1);
      localObject1[1] = localObject3;
      if (localObject3 != null)
      {
        if (QLog.isColorLevel())
        {
          localObject4 = jdField_b_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[@] getPreviewAndPictureSizeGuarantee way2 picture=");
          localStringBuilder.append(((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int);
          localStringBuilder.append(" ");
          localStringBuilder.append(((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int);
          QLog.i((String)localObject4, 2, localStringBuilder.toString());
        }
        NewFlowCameraReporter.a(true, ((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int, ((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int);
        return localObject1;
      }
      NewFlowCameraReporter.a(true, ((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int, -1, -1);
    }
    return localObject1;
  }
  
  public int b()
  {
    int j = this.jdField_c_of_type_Int;
    if (FlowCameraConstant.jdField_a_of_type_Int == 1)
    {
      int i = this.jdField_c_of_type_Int;
      if (i == 270) {
        i -= 180;
      } else {
        i += 180;
      }
      j = i;
      if (QLog.isColorLevel())
      {
        String str = jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getPreviewOrientation:blackPhone= orientation=");
        localStringBuilder.append(i);
        QLog.i(str, 2, localStringBuilder.toString());
        j = i;
      }
    }
    return j;
  }
  
  public CameraControl.CustomSize b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize;
  }
  
  public CameraControl.CustomSize b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[@] getPreviewSizeV3: dstwidth=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("  dstheight=");
      ((StringBuilder)localObject2).append(paramInt2);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = CameraAbility.a().a();
    boolean bool = QLog.isColorLevel();
    int j = 0;
    if ((bool) && (localObject1 != null))
    {
      int i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] getPreviewSizeGuaranteeOK[list]: width=");
        localStringBuilder.append(((Camera.Size)((List)localObject1).get(i)).width);
        localStringBuilder.append(" height=");
        localStringBuilder.append(((Camera.Size)((List)localObject1).get(i)).height);
        localStringBuilder.append(" w/h=");
        localStringBuilder.append(((Camera.Size)((List)localObject1).get(i)).width / ((Camera.Size)((List)localObject1).get(i)).height);
        QLog.i((String)localObject2, 2, localStringBuilder.toString());
        i += 1;
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
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: DEFAULT resolution os OK.");
      }
      if (paramBoolean) {
        NewFlowCameraReporter.a(2, paramInt1, paramInt2, ((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int);
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
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: 640*480 resolution os OK.");
      }
      if (paramBoolean) {
        NewFlowCameraReporter.a(3, paramInt1, paramInt2, ((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int);
      }
      return localObject2;
    }
    localObject1 = a((List)localObject1, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      if (localObject1 == null) {
        paramInt3 = 0;
      } else {
        paramInt3 = ((CameraControl.CustomSize)localObject1).jdField_a_of_type_Int;
      }
      if (localObject1 == null) {
        paramInt4 = j;
      } else {
        paramInt4 = ((CameraControl.CustomSize)localObject1).jdField_b_of_type_Int;
      }
      NewFlowCameraReporter.a(4, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    return localObject1;
  }
  
  @TargetApi(14)
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "release camera");
    }
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    CameraAbility.a().a();
    if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
      return;
    }
    d();
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.release();
      this.jdField_a_of_type_AndroidHardwareCamera = null;
      this.jdField_b_of_type_Int = -1;
      this.jdField_a_of_type_ArrayOfInt = null;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = null;
      this.jdField_b_of_type_Boolean = false;
      a();
      return;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 366	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   4: ifnonnull +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: getfield 548	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_Boolean	Z
    //   13: ifne +5 -> 18
    //   16: iconst_1
    //   17: ireturn
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield 548	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_Boolean	Z
    //   23: aload_0
    //   24: invokespecial 612	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:g	()Z
    //   27: istore_1
    //   28: iload_1
    //   29: ifeq +10 -> 39
    //   32: aload_0
    //   33: getfield 366	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   36: invokevirtual 615	android/hardware/Camera:cancelAutoFocus	()V
    //   39: aload_0
    //   40: getfield 366	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   43: invokevirtual 757	android/hardware/Camera:stopPreview	()V
    //   46: aload_0
    //   47: getfield 366	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   50: aconst_null
    //   51: invokevirtual 631	android/hardware/Camera:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   54: aload_0
    //   55: getfield 366	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   58: aconst_null
    //   59: invokevirtual 638	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
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
  
  public boolean b(int paramInt)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if (CameraAbility.a().d())
    {
      Camera.Parameters localParameters = a();
      if (localParameters == null) {
        return false;
      }
      int j = localParameters.getMaxZoom();
      int i = paramInt + localParameters.getZoom();
      paramInt = i;
      if (i < 0) {
        paramInt = 0;
      }
      i = paramInt;
      if (paramInt > j) {
        i = j;
      }
      localParameters.setZoom(i);
      return a(localParameters);
    }
    return false;
  }
  
  public boolean b(CameraControl.CustomSize paramCustomSize)
  {
    Object localObject = a();
    if (localObject == null) {
      return false;
    }
    try
    {
      ((Camera.Parameters)localObject).setPictureSize(paramCustomSize.jdField_a_of_type_Int, paramCustomSize.jdField_b_of_type_Int);
      this.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = paramCustomSize;
      boolean bool = a((Camera.Parameters)localObject);
      if (QLog.isColorLevel())
      {
        localObject = jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setRawPictureSize w ");
        localStringBuilder.append(paramCustomSize.jdField_a_of_type_Int);
        localStringBuilder.append(", h ");
        localStringBuilder.append(paramCustomSize.jdField_b_of_type_Int);
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
        QLog.i(jdField_b_of_type_JavaLangString, 2, "setParamsPictureSize", paramCustomSize);
      }
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if (CameraAbility.a().b(paramString))
    {
      Camera.Parameters localParameters = a();
      String str = localParameters.getSceneMode();
      boolean bool1;
      if ((str != null) && (!str.equals(paramString)))
      {
        localParameters.setSceneMode(paramString);
        boolean bool2 = a(localParameters);
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.e(jdField_b_of_type_JavaLangString, 2, new Object[] { "setSceneMode success: ", Boolean.valueOf(bool2) });
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
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if (CameraAbility.a().e())
    {
      Camera.Parameters localParameters = a();
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
  
  public CameraControl.CustomSize[] b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_b_of_type_JavaLangString;
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
        localObject3 = jdField_b_of_type_JavaLangString;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("[@] getPreviewAndPictureSizeGuarantee way2 preview=");
        ((StringBuilder)localObject4).append(((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int);
        ((StringBuilder)localObject4).append(" ");
        ((StringBuilder)localObject4).append(((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int);
        QLog.i((String)localObject3, 2, ((StringBuilder)localObject4).toString());
      }
      Object localObject3 = a(((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int, paramInt3, paramInt4, 1);
      localObject1[1] = localObject3;
      if (localObject3 != null)
      {
        if (QLog.isColorLevel())
        {
          localObject4 = jdField_b_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[@] getPreviewAndPictureSizeGuarantee way2 picture=");
          localStringBuilder.append(((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int);
          localStringBuilder.append(" ");
          localStringBuilder.append(((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int);
          QLog.i((String)localObject4, 2, localStringBuilder.toString());
        }
        NewFlowCameraReporter.a(true, ((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int, ((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int);
        return localObject1;
      }
      NewFlowCameraReporter.a(true, ((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int, -1, -1);
    }
    return localObject1;
  }
  
  public CameraControl.CustomSize c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[@] getPreviewSizeGuaranteeOK: dstwidth=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("  dstheight=");
      ((StringBuilder)localObject2).append(paramInt2);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = CameraAbility.a().a();
    boolean bool = QLog.isColorLevel();
    int j = 0;
    if ((bool) && (localObject1 != null))
    {
      int i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] getPreviewSizeGuaranteeOK[list]: width=");
        localStringBuilder.append(((Camera.Size)((List)localObject1).get(i)).width);
        localStringBuilder.append(" height=");
        localStringBuilder.append(((Camera.Size)((List)localObject1).get(i)).height);
        localStringBuilder.append(" w/h=");
        localStringBuilder.append(((Camera.Size)((List)localObject1).get(i)).width / ((Camera.Size)((List)localObject1).get(i)).height);
        QLog.i((String)localObject2, 2, localStringBuilder.toString());
        i += 1;
      }
    }
    Object localObject2 = a((List)localObject1, GloableValue.jdField_c_of_type_Int, GloableValue.d);
    if (localObject2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: DEFAULT resolution os OK.");
      }
      if (paramBoolean) {
        NewFlowCameraReporter.a(2, GloableValue.jdField_c_of_type_Int, GloableValue.d, ((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int);
      }
      return localObject2;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: Degeneration to 640*480...");
    }
    localObject2 = a((List)localObject1, GloableValue.jdField_a_of_type_ArrayOfInt[1], GloableValue.b[1]);
    if (localObject2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: 640*480 resolution os OK.");
      }
      if (paramBoolean) {
        NewFlowCameraReporter.a(3, GloableValue.jdField_c_of_type_Int, GloableValue.d, ((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int);
      }
      return localObject2;
    }
    localObject1 = a((List)localObject1, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      if (localObject1 == null) {
        paramInt1 = 0;
      } else {
        paramInt1 = ((CameraControl.CustomSize)localObject1).jdField_a_of_type_Int;
      }
      if (localObject1 == null) {
        paramInt2 = j;
      } else {
        paramInt2 = ((CameraControl.CustomSize)localObject1).jdField_b_of_type_Int;
      }
      NewFlowCameraReporter.a(4, GloableValue.jdField_c_of_type_Int, GloableValue.d, paramInt1, paramInt2);
    }
    return localObject1;
  }
  
  @TargetApi(14)
  public void c()
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.startFaceDetection();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "startFaceDetection");
    }
  }
  
  public boolean c()
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    Object localObject = Build.MODEL.toUpperCase();
    int i;
    if ((Build.MANUFACTURER.equalsIgnoreCase("huawei")) && ((((String)localObject).contains("RLI-AN00")) || (((String)localObject).contains("RLI-N29")) || (((String)localObject).contains("TAH-AN00")) || (((String)localObject).contains("TAH-N29")))) {
      i = 1;
    } else {
      i = 0;
    }
    int j = 90;
    if (i == 0)
    {
      i = j;
      if (Build.VERSION.SDK_INT < 28) {}
    }
    else
    {
      localObject = new Camera.CameraInfo();
      Camera.getCameraInfo(this.jdField_a_of_type_Int, (Camera.CameraInfo)localObject);
      int k = ((WindowManager)BaseApplicationImpl.getApplication().getSystemService("window")).getDefaultDisplay().getRotation();
      if (k != 0)
      {
        i = j;
        if (k != 1) {
          if (k != 2)
          {
            if (k != 3) {
              i = j;
            } else {
              i = 270;
            }
          }
          else {
            i = 180;
          }
        }
      }
      else
      {
        i = 0;
      }
      if (((Camera.CameraInfo)localObject).facing == 1) {
        i = (360 - (((Camera.CameraInfo)localObject).orientation + i) % 360) % 360;
      } else {
        i = (((Camera.CameraInfo)localObject).orientation - i + 360) % 360;
      }
    }
    for (;;)
    {
      boolean bool3;
      boolean bool4;
      try
      {
        if (this.jdField_a_of_type_Int == 1)
        {
          bool3 = ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProduct(CameraCompatibleConstants.e);
          bool4 = ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProductFeatureRom(CameraCompatibleConstants.f);
          if (bool3) {
            break label463;
          }
          bool1 = bool3;
          j = i;
          bool2 = bool4;
          if (bool4) {
            break label463;
          }
        }
        else
        {
          bool1 = ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProduct(CameraCompatibleConstants.g);
          j = i;
          if (!bool1) {
            break label480;
          }
          j = i + 180;
          break label480;
        }
        this.jdField_a_of_type_AndroidHardwareCamera.setDisplayOrientation(j);
        this.jdField_c_of_type_Int = j;
        if (QLog.isColorLevel())
        {
          localObject = jdField_b_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setDisplayOrientation degrees=");
          localStringBuilder.append(j);
          localStringBuilder.append(" blackPhone=");
          localStringBuilder.append(bool1);
          localStringBuilder.append(" camera=");
          localStringBuilder.append(FlowCameraConstant.jdField_a_of_type_Int);
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
      j = i + 180;
      boolean bool1 = bool3;
      boolean bool2 = bool4;
      continue;
      label480:
      bool2 = false;
    }
  }
  
  public CameraControl.CustomSize[] c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[@] getPreviewAndPictureSizeGuarantee wanted size=");
      ((StringBuilder)localObject2).append(GloableValue.jdField_c_of_type_Int);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(GloableValue.d);
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
        localObject3 = jdField_b_of_type_JavaLangString;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("[@] getPreviewAndPictureSizeGuarantee way2 preview=");
        ((StringBuilder)localObject4).append(((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int);
        ((StringBuilder)localObject4).append(" ");
        ((StringBuilder)localObject4).append(((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int);
        QLog.i((String)localObject3, 2, ((StringBuilder)localObject4).toString());
      }
      Object localObject3 = a(((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int, paramInt3, paramInt4, 1);
      localObject1[1] = localObject3;
      if (localObject3 != null)
      {
        if (QLog.isColorLevel())
        {
          localObject4 = jdField_b_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[@] getPreviewAndPictureSizeGuarantee way2 picture=");
          localStringBuilder.append(((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int);
          localStringBuilder.append(" ");
          localStringBuilder.append(((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int);
          QLog.i((String)localObject4, 2, localStringBuilder.toString());
        }
        NewFlowCameraReporter.a(true, ((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int, ((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int);
        return localObject1;
      }
      NewFlowCameraReporter.a(true, ((CameraControl.CustomSize)localObject2).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject2).jdField_b_of_type_Int, -1, -1);
    }
    return localObject1;
  }
  
  @TargetApi(14)
  public void d()
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setFaceDetectionListener(null);
      this.jdField_a_of_type_AndroidHardwareCamera.stopFaceDetection();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "stopFaceDetection");
    }
  }
  
  @TargetApi(14)
  public boolean d()
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    boolean bool = false;
    int i;
    try
    {
      i = this.jdField_a_of_type_AndroidHardwareCamera.getParameters().getMaxNumDetectedFaces();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      String str = jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("supportFaceDetect");
      localStringBuilder.append(i);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (i > 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean e()
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewFormat[failed]getCameraParameters=null");
      }
      return false;
    }
    boolean bool;
    StringBuilder localStringBuilder;
    if (CameraAbility.a().a(17))
    {
      ((Camera.Parameters)localObject).setPreviewFormat(17);
      this.jdField_b_of_type_Int = 17;
      bool = a((Camera.Parameters)localObject);
      if (QLog.isColorLevel())
      {
        localObject = jdField_b_of_type_JavaLangString;
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
      this.jdField_b_of_type_Int = 842094169;
      bool = a((Camera.Parameters)localObject);
      if (QLog.isColorLevel())
      {
        localObject = jdField_b_of_type_JavaLangString;
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
      this.jdField_b_of_type_Int = 20;
      bool = a((Camera.Parameters)localObject);
      if (QLog.isColorLevel())
      {
        localObject = jdField_b_of_type_JavaLangString;
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
      this.jdField_b_of_type_Int = 4;
      bool = a((Camera.Parameters)localObject);
      if (QLog.isColorLevel())
      {
        localObject = jdField_b_of_type_JavaLangString;
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
      this.jdField_b_of_type_Int = 256;
      bool = a((Camera.Parameters)localObject);
      if (QLog.isColorLevel())
      {
        localObject = jdField_b_of_type_JavaLangString;
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
      this.jdField_b_of_type_Int = 16;
      bool = a((Camera.Parameters)localObject);
      if (QLog.isColorLevel())
      {
        localObject = jdField_b_of_type_JavaLangString;
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
  
  public boolean f()
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if (CameraAbility.a().e())
    {
      Camera.Parameters localParameters = a();
      if (TextUtils.equals(localParameters.getFlashMode(), "torch")) {
        localParameters.setFlashMode("off");
      } else {
        localParameters.setFlashMode("torch");
      }
      return a(localParameters);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraControl
 * JD-Core Version:    0.7.0.1
 */