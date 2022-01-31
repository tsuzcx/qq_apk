package com.tencent.mobileqq.shortvideo.mediadevice;

import aigu;
import android.annotation.TargetApi;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.FaceDetectionListener;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.PictureCallback;
import com.tencent.mobileqq.camera.CameraHolder;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.mobileqq.shortvideo.common.Observable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(11)
public class CameraControl
  extends Observable
{
  private static double jdField_a_of_type_Double;
  static CameraControl jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl;
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  public static String b;
  private static ArrayList jdField_b_of_type_JavaUtilArrayList;
  private static boolean d;
  private static boolean e;
  public int a;
  public Camera a;
  public CameraHolder a;
  CameraControl.CameraInformation jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CameraInformation = new CameraControl.CameraInformation(this);
  CameraControl.CustomSize jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize;
  public boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  int[] jdField_a_of_type_ArrayOfInt;
  int jdField_b_of_type_Int;
  CameraControl.CustomSize jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize;
  boolean jdField_b_of_type_Boolean;
  private byte[] jdField_b_of_type_ArrayOfByte;
  int jdField_c_of_type_Int;
  public int d;
  
  static
  {
    if (!CameraControl.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_c_of_type_Boolean = bool;
      jdField_b_of_type_JavaLangString = "CameraControl";
      jdField_a_of_type_Double = 0.009999999776482582D;
      jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      return;
    }
  }
  
  public CameraControl()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqCameraCameraHolder = CameraHolder.a();
  }
  
  private CameraControl.CustomSize a(List paramList, int paramInt1, int paramInt2)
  {
    int j = -1;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getHighVersionPreviewSize[wantedPreviewSize]: width=" + paramInt1 + "  height=" + paramInt2);
    }
    CameraControl.CustomSize localCustomSize = new CameraControl.CustomSize();
    int i = j;
    if (paramList != null)
    {
      i = j;
      if (!paramList.isEmpty())
      {
        paramList = paramList.iterator();
        i = -1;
        if (paramList.hasNext())
        {
          Camera.Size localSize = (Camera.Size)paramList.next();
          if ((localSize == null) || (localSize.height != paramInt2) || (localSize.width < paramInt1) || ((i >= 0) && (localSize.width > i))) {
            break label225;
          }
          i = localSize.width;
        }
      }
    }
    label225:
    for (;;)
    {
      break;
      if (i > 0)
      {
        localCustomSize.jdField_b_of_type_Int = paramInt2;
        localCustomSize.jdField_a_of_type_Int = i;
        if (localCustomSize.jdField_a_of_type_Int / 4 == localCustomSize.jdField_b_of_type_Int / 3)
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getHighVersionPreviewSize[4:3]...");
          }
          return localCustomSize;
        }
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getHighVersionPreviewSize: RATIO_MUST_EQUAL=false");
        }
        return localCustomSize;
      }
      return null;
    }
  }
  
  private CameraControl.CustomSize a(List paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d1 = paramInt4 / paramInt3;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSize[self-adaption] physicRatio=" + d1);
    }
    CameraControl.CustomSize localCustomSize = new CameraControl.CustomSize();
    Iterator localIterator;
    long l1;
    Camera.Size localSize;
    long l2;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localIterator = paramList.iterator();
      l1 = 9223372036854775807L;
      if (localIterator.hasNext())
      {
        localSize = (Camera.Size)localIterator.next();
        if ((localSize != null) && (localSize.width >= paramInt1) && (localSize.height >= paramInt2) && (localSize.width / localSize.height >= d1))
        {
          l2 = localSize.width * localSize.height;
          if (l2 < l1)
          {
            localCustomSize.jdField_a_of_type_Int = localSize.width;
            localCustomSize.jdField_b_of_type_Int = localSize.height;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (localSize.width < localCustomSize.jdField_a_of_type_Int))
          {
            localCustomSize.jdField_a_of_type_Int = localSize.width;
            localCustomSize.jdField_b_of_type_Int = localSize.height;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSize[self-adaption] have no resolution >= (w*h)");
    }
    if (((localCustomSize.jdField_a_of_type_Int <= 0) || (localCustomSize.jdField_b_of_type_Int <= 0)) && (paramList != null) && (!paramList.isEmpty()))
    {
      localIterator = paramList.iterator();
      l1 = 0L;
      if (localIterator.hasNext())
      {
        localSize = (Camera.Size)localIterator.next();
        if ((localSize != null) && (localSize.width / localSize.height >= d1))
        {
          l2 = localSize.width * localSize.height;
          if (l2 > l1)
          {
            localCustomSize.jdField_a_of_type_Int = localSize.width;
            localCustomSize.jdField_b_of_type_Int = localSize.height;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (localSize.width < localCustomSize.jdField_a_of_type_Int))
          {
            localCustomSize.jdField_a_of_type_Int = localSize.width;
            localCustomSize.jdField_b_of_type_Int = localSize.height;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSize[self-adaption] cSize.width=" + localCustomSize.jdField_a_of_type_Int + "  cSize.height=" + localCustomSize.jdField_b_of_type_Int);
    }
    if ((localCustomSize.jdField_a_of_type_Int > 0) && (localCustomSize.jdField_b_of_type_Int > 0)) {
      return localCustomSize;
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramList.get(0) != null))
    {
      localCustomSize.jdField_a_of_type_Int = ((Camera.Size)paramList.get(0)).width;
      localCustomSize.jdField_b_of_type_Int = ((Camera.Size)paramList.get(0)).height;
      return localCustomSize;
    }
    return null;
  }
  
  private CameraControl.CustomSize a(List paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getHighVersionPreviewSizeV2[wantedPreviewSize]: width=" + paramInt1 + "  height=" + paramInt2);
    }
    float f3 = paramInt1 / paramInt2;
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramList = paramList.iterator();
    }
    label236:
    label879:
    label882:
    label885:
    label886:
    for (;;)
    {
      Object localObject3;
      int i;
      int j;
      if (paramList.hasNext())
      {
        localObject3 = (Camera.Size)paramList.next();
        if (localObject3 == null) {
          continue;
        }
        i = Math.max(((Camera.Size)localObject3).width, ((Camera.Size)localObject3).height);
        j = Math.min(((Camera.Size)localObject3).width, ((Camera.Size)localObject3).height);
        if ((((Camera.Size)localObject3).height != paramInt2) || (i != paramInt1)) {
          break label349;
        }
        ((List)localObject1).add(new CameraControl.CustomSize(paramInt1, paramInt2));
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getHighVersionPreviewSizeV2 first: width=" + paramInt1 + "  height=" + paramInt2);
        }
      }
      float f1;
      float f2;
      if (((List)localObject1).size() == 0)
      {
        paramList = ((List)localObject2).iterator();
        f1 = 10000.0F;
        if (paramList.hasNext())
        {
          localObject3 = (CameraControl.CustomSize)paramList.next();
          if (localObject3 == null) {
            break label885;
          }
          paramInt1 = Math.max(((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int);
          paramInt2 = Math.min(((CameraControl.CustomSize)localObject3).jdField_a_of_type_Int, ((CameraControl.CustomSize)localObject3).jdField_b_of_type_Int);
          f2 = paramInt1 / paramInt2;
          if (Math.abs(f3 - f2) < jdField_a_of_type_Double) {
            ((List)localObject1).add(localObject3);
          }
          if (Math.abs(f3 - f2) >= f1) {
            break label885;
          }
          f1 = Math.abs(f3 - f2);
        }
      }
      for (;;)
      {
        break label236;
        if ((i <= paramInt5) || (i >= paramInt3) || (j <= paramInt6) || (j >= paramInt4)) {
          break label886;
        }
        ((List)localObject2).add(new CameraControl.CustomSize(i, j));
        break;
        f2 = f1;
        if (QLog.isColorLevel())
        {
          f2 = f1;
          if (localObject1 != null)
          {
            paramInt1 = 0;
            for (;;)
            {
              f2 = f1;
              if (paramInt1 >= ((List)localObject1).size()) {
                break;
              }
              QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getHighVersionPreviewSizeV2 secend: width=" + ((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).jdField_a_of_type_Int + " height=" + ((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).jdField_b_of_type_Int + " w/h=" + ((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).jdField_a_of_type_Int / ((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).jdField_b_of_type_Int);
              paramInt1 += 1;
            }
            f2 = 10000.0F;
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
          if ((QLog.isColorLevel()) && (localObject1 != null))
          {
            paramInt1 = 0;
            while (paramInt1 < ((List)localObject1).size())
            {
              QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getHighVersionPreviewSizeV2 third: width=" + ((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).jdField_a_of_type_Int + " height=" + ((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).jdField_b_of_type_Int + " w/h=" + ((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).jdField_a_of_type_Int / ((CameraControl.CustomSize)((List)localObject1).get(paramInt1)).jdField_b_of_type_Int);
              paramInt1 += 1;
            }
          }
        }
        if (((List)localObject1).size() > 0)
        {
          paramList = (CameraControl.CustomSize)((List)localObject1).get(0);
          localObject2 = ((List)localObject1).iterator();
          localObject1 = paramList;
          if (!((Iterator)localObject2).hasNext()) {
            break label879;
          }
          localObject1 = (CameraControl.CustomSize)((Iterator)localObject2).next();
          if ((localObject1 == null) || (((CameraControl.CustomSize)localObject1).jdField_a_of_type_Int * ((CameraControl.CustomSize)localObject1).jdField_b_of_type_Int <= paramList.jdField_a_of_type_Int * paramList.jdField_b_of_type_Int)) {
            break label882;
          }
          paramList = (List)localObject1;
        }
        for (;;)
        {
          break;
          localObject1 = null;
          return localObject1;
        }
      }
    }
  }
  
  public static CameraControl a()
  {
    if (jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl == null) {
        jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl = new CameraControl();
      }
      return jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl;
    }
    finally {}
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown";
    case 0: 
      return "RM_CAMERA_OPEN_SUCCESS";
    case 1: 
      return "RM_CAMERA_USED_AV";
    case 2: 
      return "RM_CAMERA_COUNT_ZERO";
    case 3: 
      return "RM_CAMERA_OPEN_FAILED";
    }
    return "RM_CAMERA_GET_PARAM";
  }
  
  private static void a(ArrayList paramArrayList)
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
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "printFpsRange[listFpsRange=null]");
      }
      return;
    }
    int i = 0;
    label31:
    if (i < paramList.size())
    {
      int[] arrayOfInt = (int[])paramList.get(i);
      if ((arrayOfInt == null) || (arrayOfInt.length < 2)) {
        break label128;
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "printFpsRange[i=" + i + " fps[low]=" + arrayOfInt[0] + " fps[high]=" + arrayOfInt[1] + "]");
      }
    }
    for (;;)
    {
      i += 1;
      break label31;
      break;
      label128:
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "printFpsRange[i=" + i + " ele=null]");
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
    boolean bool = false;
    if (Math.abs(f2 - f1) > jdField_a_of_type_Double) {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "needClip " + bool + " screenRatio" + f2 + " previewRatio" + f1);
    }
    return bool;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt4 / paramInt5 <= 1.0D) {}
    while (paramInt2 * paramInt5 / (paramInt5 * paramInt3 / paramInt4) < paramInt1) {
      return false;
    }
    return true;
  }
  
  private boolean a(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {}
    for (;;)
    {
      return false;
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
  }
  
  private int[] a(List paramList)
  {
    int[] arrayOfInt1 = new int[2];
    int[] tmp7_5 = arrayOfInt1;
    tmp7_5[0] = 0;
    int[] tmp11_7 = tmp7_5;
    tmp11_7[1] = 0;
    tmp11_7;
    Object localObject1 = new ArrayList();
    Object localObject2 = paramList.iterator();
    int i = 0;
    if (((Iterator)localObject2).hasNext())
    {
      int[] arrayOfInt2 = (int[])((Iterator)localObject2).next();
      if ((arrayOfInt2 == null) || (arrayOfInt2.length < 2) || (arrayOfInt2[1] < i)) {
        break label316;
      }
      i = arrayOfInt2[1];
    }
    label303:
    label316:
    for (;;)
    {
      break;
      if (i <= 0) {
        return null;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (int[])paramList.next();
        if ((localObject2 != null) && (localObject2.length >= 2) && (localObject2[1] == i)) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      if (((ArrayList)localObject1).size() <= 0) {
        return null;
      }
      paramList = ((ArrayList)localObject1).iterator();
      int k = 0;
      int j = 2147483647;
      int m;
      if (paramList.hasNext())
      {
        localObject1 = (int[])paramList.next();
        if (localObject1[0] >= 15000)
        {
          m = localObject1[0] - 15000;
          label212:
          if (m >= j) {
            break label303;
          }
          j = localObject1[0];
        }
      }
      for (k = m;; k = m)
      {
        m = k;
        k = j;
        j = m;
        break;
        m = 15000 - localObject1[0];
        break label212;
        if (j != 2147483647)
        {
          arrayOfInt1[0] = k;
          arrayOfInt1[1] = i;
        }
        while ((arrayOfInt1[0] <= 0) || (arrayOfInt1[1] <= 0))
        {
          return null;
          arrayOfInt1[0] = i;
          arrayOfInt1[1] = i;
        }
        return arrayOfInt1;
        m = j;
        j = k;
      }
    }
  }
  
  private int[] a(List paramList, int paramInt)
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
    int i = -1;
    switch (paramInt)
    {
    default: 
      paramInt = CameraAbility.b();
    }
    do
    {
      do
      {
        return paramInt;
        paramInt = i;
      } while (!CameraAbility.c());
      return CameraAbility.a();
      paramInt = i;
    } while (!CameraAbility.b());
    return CameraAbility.b();
  }
  
  private int[] b(List paramList, int paramInt)
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
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "startPreview getPreviewBufferSize:bitpixel=" + i + " byteNum=" + f + " bufSize=" + j);
    }
    return j;
  }
  
  private boolean d(int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    try
    {
      if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length != paramInt)) {
        this.jdField_a_of_type_ArrayOfByte = new byte[paramInt];
      }
      if ((this.jdField_b_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_ArrayOfByte.length != paramInt)) {
        this.jdField_b_of_type_ArrayOfByte = new byte[paramInt];
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        URLDrawable.clearMemoryCache();
        try
        {
          if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length == paramInt)) {
            break label81;
          }
          this.jdField_a_of_type_ArrayOfByte = new byte[paramInt];
          label81:
          if ((this.jdField_b_of_type_ArrayOfByte != null) && (this.jdField_b_of_type_ArrayOfByte.length == paramInt)) {
            continue;
          }
          this.jdField_b_of_type_ArrayOfByte = new byte[paramInt];
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          QLog.e(jdField_b_of_type_JavaLangString, 2, "allocateFrame failed , size:" + paramInt + ", " + localOutOfMemoryError2.getMessage());
        }
      }
    }
    return true;
    return false;
  }
  
  private boolean f()
  {
    return !CameraCompatibleList.d(CameraCompatibleList.a);
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    if (FlowCameraMqqAction.a()) {
      i = 1;
    }
    for (;;)
    {
      return i;
      if (!CameraAbility.a())
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] openCamera[failed]hasCameras=false");
        }
        return 2;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[openCamera]Camera is opened, Camera object " + this.jdField_a_of_type_AndroidHardwareCamera);
        }
        return 5;
      }
      int j = 0;
      i = 0;
      label83:
      if (j < 10) {}
      try
      {
        for (;;)
        {
          this.jdField_a_of_type_Int = b(paramInt);
          if (VersionUtils.c()) {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_b_of_type_JavaLangString, 2, "openCamera:currentCount= " + j);
            }
          }
          for (this.jdField_a_of_type_AndroidHardwareCamera = Camera.open(this.jdField_a_of_type_Int);; this.jdField_a_of_type_AndroidHardwareCamera = Camera.open())
          {
            i = 0;
            if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
              break;
            }
            if (CameraAbility.a().a(this.jdField_a_of_type_AndroidHardwareCamera)) {
              break label266;
            }
            if (QLog.isColorLevel()) {
              QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] openCamera[failed]bindCamera=false");
            }
            return 4;
          }
          try
          {
            Thread.sleep(300L);
            i = 3;
            break label83;
            this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CameraInformation = new CameraControl.CameraInformation(this);
            this.jdField_b_of_type_Boolean = true;
            return 0;
          }
          catch (InterruptedException localInterruptedException)
          {
            break label261;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.jdField_a_of_type_AndroidHardwareCamera = null;
        j += 1;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] openCamera[failed][RM_CAMERA_OPEN_FAILED]currentCount=" + j, localException);
        }
        if (j >= 10) {}
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
    int i;
    if ((QLog.isColorLevel()) && (localObject2 != null))
    {
      i = 0;
      while (i < ((List)localObject2).size())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getStarPhotoPreviewSize[list]: width=" + ((Camera.Size)((List)localObject2).get(i)).width + " height=" + ((Camera.Size)((List)localObject2).get(i)).height + " w/h=" + ((Camera.Size)((List)localObject2).get(i)).width / ((Camera.Size)((List)localObject2).get(i)).height);
        i += 1;
      }
    }
    Object localObject1 = new ArrayList();
    CameraControl.CustomSize localCustomSize = new CameraControl.CustomSize();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Camera.Size localSize = (Camera.Size)((Iterator)localObject2).next();
        if ((localSize != null) && (localSize.height >= paramInt)) {
          ((List)localObject1).add(localSize);
        }
      }
    }
    if (((List)localObject1).size() > 0)
    {
      localObject1 = ((List)localObject1).iterator();
      for (paramInt = 2147483647; ((Iterator)localObject1).hasNext(); paramInt = i)
      {
        localObject2 = (Camera.Size)((Iterator)localObject1).next();
        i = paramInt;
        if (((Camera.Size)localObject2).width < paramInt)
        {
          i = ((Camera.Size)localObject2).width;
          localCustomSize.jdField_b_of_type_Int = ((Camera.Size)localObject2).height;
          localCustomSize.jdField_a_of_type_Int = ((Camera.Size)localObject2).width;
        }
      }
    }
    if (localCustomSize.jdField_a_of_type_Int > 0) {
      return localCustomSize;
    }
    return null;
  }
  
  public CameraControl.CustomSize a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject2 = CameraAbility.a().a();
    if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
      return null;
    }
    if (QLog.isColorLevel())
    {
      paramInt2 = 0;
      while (paramInt2 < ((List)localObject2).size())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getFullVideoPreviewSize[list]: width=" + ((Camera.Size)((List)localObject2).get(paramInt2)).width + " height=" + ((Camera.Size)((List)localObject2).get(paramInt2)).height + " w/h=" + ((Camera.Size)((List)localObject2).get(paramInt2)).width / ((Camera.Size)((List)localObject2).get(paramInt2)).height);
        paramInt2 += 1;
      }
    }
    double d1;
    Object localObject4;
    Object localObject3;
    CameraControl.CustomSize localCustomSize;
    Object localObject5;
    label259:
    if (FlowCameraConstant.jdField_a_of_type_Int == 1)
    {
      if (!e)
      {
        a(jdField_b_of_type_JavaUtilArrayList);
        e = true;
      }
      localObject1 = jdField_b_of_type_JavaUtilArrayList;
      d1 = paramInt4 / paramInt3;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getFullVideoPreviewSize[self-adaption] physicRatio=" + d1);
      }
      localObject4 = new ArrayList(3);
      localObject3 = new ArrayList(3);
      localCustomSize = new CameraControl.CustomSize();
      localObject5 = ((List)localObject2).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject5).hasNext()) {
        break label400;
      }
      Camera.Size localSize = (Camera.Size)((Iterator)localObject5).next();
      if (localSize != null)
      {
        double d2 = localSize.width / localSize.height;
        Iterator localIterator = ((ArrayList)localObject1).iterator();
        if (localIterator.hasNext())
        {
          if (Math.abs(((Float)localIterator.next()).floatValue() - d2) > 0.009999999776482582D) {
            break label259;
          }
          if (d2 >= d1)
          {
            ((ArrayList)localObject4).add(localSize);
            continue;
            if (!d)
            {
              a(jdField_a_of_type_JavaUtilArrayList);
              d = true;
            }
            localObject1 = jdField_a_of_type_JavaUtilArrayList;
            break;
          }
          ((ArrayList)localObject3).add(localSize);
        }
      }
    }
    label400:
    int i = GloableValue.jdField_c_of_type_Int;
    int j = GloableValue.d;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getFullVideoPreviewSize[self-adaption] previewWidth=" + i + "previewHeight=" + j);
    }
    Object localObject1 = ((ArrayList)localObject4).iterator();
    paramInt2 = -1;
    if (((Iterator)localObject1).hasNext())
    {
      localObject5 = (Camera.Size)((Iterator)localObject1).next();
      if ((localObject5 == null) || (((Camera.Size)localObject5).height != j) || (((Camera.Size)localObject5).width < i) || ((paramInt2 >= 0) && (((Camera.Size)localObject5).width > paramInt2))) {
        break label1402;
      }
      paramInt2 = ((Camera.Size)localObject5).width;
    }
    label1399:
    label1402:
    for (;;)
    {
      break;
      if (paramInt2 > 0)
      {
        localCustomSize.jdField_b_of_type_Int = j;
        localCustomSize.jdField_a_of_type_Int = paramInt2;
        if ((CameraCompatibleList.a()) && (a((ArrayList)localObject3, i, j))) {
          localCustomSize.jdField_a_of_type_Int = i;
        }
        return localCustomSize;
      }
      localObject1 = ((ArrayList)localObject3).iterator();
      long l1 = 9223372036854775807L;
      long l2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject5 = (Camera.Size)((Iterator)localObject1).next();
        if ((localObject5 != null) && (a(paramInt1, paramInt3, paramInt4, ((Camera.Size)localObject5).width, ((Camera.Size)localObject5).height)))
        {
          l2 = ((Camera.Size)localObject5).width * ((Camera.Size)localObject5).height;
          if (l2 < l1)
          {
            localCustomSize.jdField_a_of_type_Int = ((Camera.Size)localObject5).width;
            localCustomSize.jdField_b_of_type_Int = ((Camera.Size)localObject5).height;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (((Camera.Size)localObject5).width < localCustomSize.jdField_a_of_type_Int))
          {
            localCustomSize.jdField_a_of_type_Int = ((Camera.Size)localObject5).width;
            localCustomSize.jdField_b_of_type_Int = ((Camera.Size)localObject5).height;
          }
        }
      }
      if ((localCustomSize.jdField_a_of_type_Int > 0) || (localCustomSize.jdField_b_of_type_Int > 0)) {
        return localCustomSize;
      }
      paramInt2 = GloableValue.g[1];
      i = GloableValue.h[1];
      localObject1 = ((ArrayList)localObject4).iterator();
      paramInt1 = -1;
      if (((Iterator)localObject1).hasNext())
      {
        localObject5 = (Camera.Size)((Iterator)localObject1).next();
        if ((localObject5 == null) || (((Camera.Size)localObject5).height != i) || (((Camera.Size)localObject5).width < paramInt2) || ((paramInt1 >= 0) && (((Camera.Size)localObject5).width > paramInt1))) {
          break label1399;
        }
        paramInt1 = ((Camera.Size)localObject5).width;
      }
      for (;;)
      {
        break;
        if (paramInt1 > 0)
        {
          localCustomSize.jdField_b_of_type_Int = i;
          localCustomSize.jdField_a_of_type_Int = paramInt1;
          return localCustomSize;
        }
        if ((localCustomSize.jdField_a_of_type_Int <= 0) || (localCustomSize.jdField_b_of_type_Int <= 0))
        {
          localObject1 = ((ArrayList)localObject4).iterator();
          l1 = 9223372036854775807L;
          if (((Iterator)localObject1).hasNext())
          {
            localObject4 = (Camera.Size)((Iterator)localObject1).next();
            if (localObject4 != null)
            {
              l2 = ((Camera.Size)localObject4).width * ((Camera.Size)localObject4).height;
              if (l2 < l1)
              {
                localCustomSize.jdField_a_of_type_Int = ((Camera.Size)localObject4).width;
                localCustomSize.jdField_b_of_type_Int = ((Camera.Size)localObject4).height;
                l1 = l2;
              }
            }
            for (;;)
            {
              break;
              if ((l2 == l1) && (((Camera.Size)localObject4).width < localCustomSize.jdField_a_of_type_Int))
              {
                localCustomSize.jdField_a_of_type_Int = ((Camera.Size)localObject4).width;
                localCustomSize.jdField_b_of_type_Int = ((Camera.Size)localObject4).height;
              }
            }
          }
        }
        if ((localCustomSize.jdField_a_of_type_Int <= 0) || (localCustomSize.jdField_b_of_type_Int <= 0))
        {
          localObject1 = ((ArrayList)localObject3).iterator();
          l1 = 9223372036854775807L;
          if (((Iterator)localObject1).hasNext())
          {
            localObject3 = (Camera.Size)((Iterator)localObject1).next();
            if ((localObject3 != null) && (a(320, paramInt3, paramInt4, ((Camera.Size)localObject3).width, ((Camera.Size)localObject3).height)))
            {
              l2 = ((Camera.Size)localObject3).width * ((Camera.Size)localObject3).height;
              if (l2 < l1)
              {
                localCustomSize.jdField_a_of_type_Int = ((Camera.Size)localObject3).width;
                localCustomSize.jdField_b_of_type_Int = ((Camera.Size)localObject3).height;
                l1 = l2;
              }
            }
            for (;;)
            {
              break;
              if ((l2 == l1) && (((Camera.Size)localObject3).width < localCustomSize.jdField_a_of_type_Int))
              {
                localCustomSize.jdField_a_of_type_Int = ((Camera.Size)localObject3).width;
                localCustomSize.jdField_b_of_type_Int = ((Camera.Size)localObject3).height;
              }
            }
          }
        }
        if ((localCustomSize.jdField_a_of_type_Int <= 0) || (localCustomSize.jdField_b_of_type_Int <= 0))
        {
          localObject1 = ((List)localObject2).iterator();
          l1 = 0L;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Camera.Size)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              l2 = ((Camera.Size)localObject2).width * ((Camera.Size)localObject2).height;
              if (l2 > l1)
              {
                localCustomSize.jdField_a_of_type_Int = ((Camera.Size)localObject2).width;
                localCustomSize.jdField_b_of_type_Int = ((Camera.Size)localObject2).height;
                l1 = l2;
              }
            }
            for (;;)
            {
              break;
              if ((l2 == l1) && (((Camera.Size)localObject2).width < localCustomSize.jdField_a_of_type_Int))
              {
                localCustomSize.jdField_a_of_type_Int = ((Camera.Size)localObject2).width;
                localCustomSize.jdField_b_of_type_Int = ((Camera.Size)localObject2).height;
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getFullVideoPreviewSize[self-adaption] cSize.width=" + localCustomSize.jdField_a_of_type_Int + "  cSize.height=" + localCustomSize.jdField_b_of_type_Int);
        }
        if ((localCustomSize.jdField_a_of_type_Int > 0) && (localCustomSize.jdField_b_of_type_Int > 0)) {
          return localCustomSize;
        }
        return null;
      }
    }
  }
  
  public CameraControl.CustomSize a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize == null)) {
      throw new AssertionError();
    }
    if (a() == null)
    {
      localObject1 = null;
      return localObject1;
    }
    int i = Math.min(paramInt1, paramInt2);
    float f = Math.max(paramInt1, paramInt2) / i;
    CameraControl.CustomSize localCustomSize = new CameraControl.CustomSize();
    Object localObject2 = CameraAbility.a().b();
    if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
      return null;
    }
    Object localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Camera.Size localSize = (Camera.Size)((Iterator)localObject2).next();
      if (localSize != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setPictureSize[list]: width=" + localSize.width + " height=" + localSize.height + " w/h=" + localSize.width / localSize.height);
        }
        if (Math.abs(localSize.width / localSize.height - f) <= jdField_a_of_type_Double) {
          ((List)localObject1).add(localSize);
        }
      }
    }
    if (((List)localObject1).isEmpty()) {
      return null;
    }
    if (paramInt5 == -1)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Camera.Size)((Iterator)localObject1).next();
        if (localCustomSize.jdField_a_of_type_Int < ((Camera.Size)localObject2).width)
        {
          localCustomSize.jdField_a_of_type_Int = ((Camera.Size)localObject2).width;
          localCustomSize.jdField_b_of_type_Int = ((Camera.Size)localObject2).height;
        }
      }
    }
    for (;;)
    {
      localObject1 = localCustomSize;
      if (localCustomSize.jdField_a_of_type_Int != 0) {
        break;
      }
      return null;
      localCustomSize = a(paramInt3, paramInt4, paramInt5, (List)localObject1);
    }
  }
  
  public CameraControl.CustomSize a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeV2: dstwidth=" + paramInt1 + "  dstheight=" + paramInt2);
    }
    Object localObject = CameraAbility.a().a();
    if ((QLog.isColorLevel()) && (localObject != null))
    {
      int i = 0;
      while (i < ((List)localObject).size())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK[list]: width=" + ((Camera.Size)((List)localObject).get(i)).width + " height=" + ((Camera.Size)((List)localObject).get(i)).height + " w/h=" + ((Camera.Size)((List)localObject).get(i)).width / ((Camera.Size)((List)localObject).get(i)).height);
        i += 1;
      }
    }
    CameraControl.CustomSize localCustomSize = a((List)localObject, paramInt1, paramInt2);
    if (localCustomSize != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: DEFAULT resolution os OK.");
      }
      localObject = localCustomSize;
      if (paramBoolean)
      {
        NewFlowCameraReporter.a(2, paramInt1, paramInt2, localCustomSize.jdField_a_of_type_Int, localCustomSize.jdField_b_of_type_Int);
        localObject = localCustomSize;
      }
    }
    do
    {
      do
      {
        return localObject;
        localCustomSize = a((List)localObject, 960, 720);
        if (localCustomSize == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: 640*480 resolution os OK.");
        }
        localObject = localCustomSize;
      } while (!paramBoolean);
      NewFlowCameraReporter.a(3, paramInt1, paramInt2, localCustomSize.jdField_a_of_type_Int, localCustomSize.jdField_b_of_type_Int);
      return localCustomSize;
      localCustomSize = a((List)localObject, paramInt1, paramInt2, paramInt3, paramInt4);
      localObject = localCustomSize;
    } while (!paramBoolean);
    if (localCustomSize == null)
    {
      paramInt3 = 0;
      if (localCustomSize != null) {
        break label379;
      }
    }
    label379:
    for (paramInt4 = j;; paramInt4 = localCustomSize.jdField_b_of_type_Int)
    {
      NewFlowCameraReporter.a(4, paramInt1, paramInt2, paramInt3, paramInt4);
      return localCustomSize;
      paramInt3 = localCustomSize.jdField_a_of_type_Int;
      break;
    }
  }
  
  public CameraControl.CustomSize a(int paramInt1, int paramInt2, int paramInt3, List paramList)
  {
    paramInt3 = Math.max(paramInt1 * paramInt3, paramInt2 * paramInt3);
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "setParamsPictureSize targetWidth " + paramInt3);
    }
    CameraControl.CustomSize localCustomSize = new CameraControl.CustomSize(0, 0);
    paramList = paramList.iterator();
    paramInt1 = 2147483647;
    if (paramList.hasNext())
    {
      Camera.Size localSize = (Camera.Size)paramList.next();
      paramInt2 = Math.abs(localSize.width - paramInt3);
      if (paramInt1 <= paramInt2) {
        break label133;
      }
      localCustomSize.jdField_a_of_type_Int = localSize.width;
      localCustomSize.jdField_b_of_type_Int = localSize.height;
      paramInt1 = paramInt2;
    }
    label133:
    for (;;)
    {
      break;
      return localCustomSize;
    }
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
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "setFaceDetectionListener");
      }
      return;
    }
    catch (Exception paramFaceDetectionListener)
    {
      for (;;)
      {
        paramFaceDetectionListener.printStackTrace();
      }
    }
  }
  
  public void a(File paramFile, Rect paramRect, CameraCover.PictureCallback paramPictureCallback, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[takePicture]mCamera " + null);
      }
    }
    do
    {
      return;
      NewFlowCameraReporter.a("begin pic taken");
      try
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidHardwareCamera.takePicture(null, null, null, new aigu(this, paramInt1, paramFile, paramRect, paramPictureCallback, paramBoolean, paramInt2));
        return;
      }
      catch (RuntimeException paramFile) {}
    } while (!QLog.isColorLevel());
    QLog.i(jdField_b_of_type_JavaLangString, 2, null, paramFile);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidHardwareCamera != null) && (d(c())))
    {
      this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(this.jdField_a_of_type_ArrayOfByte);
      this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(this.jdField_b_of_type_ArrayOfByte);
    }
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidHardwareCamera != null) && (paramArrayOfByte != null)) {
      this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(paramArrayOfByte);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
      return false;
    }
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
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
    for (;;)
    {
      boolean bool3;
      boolean bool4;
      try
      {
        if (this.jdField_a_of_type_Int == 1)
        {
          bool3 = CameraCompatibleList.d(CameraCompatibleList.e);
          bool4 = CameraCompatibleList.b(CameraCompatibleList.f);
          if (bool3) {
            break label183;
          }
          bool1 = bool4;
          bool2 = bool3;
          i = paramInt;
          if (bool4) {
            break label183;
          }
          this.jdField_a_of_type_AndroidHardwareCamera.setDisplayOrientation(i);
          this.jdField_c_of_type_Int = i;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i(jdField_b_of_type_JavaLangString, 2, "setDisplayOrientation degrees=" + i + " blackPhone=" + bool2 + " camera=" + FlowCameraConstant.jdField_a_of_type_Int + " rom_black=" + bool1);
          return true;
        }
        bool2 = CameraCompatibleList.d(CameraCompatibleList.g);
        if (bool2)
        {
          i = paramInt + 180;
          bool1 = false;
          continue;
        }
        bool1 = false;
      }
      catch (Exception localException)
      {
        return false;
      }
      int i = paramInt;
      continue;
      label183:
      i = paramInt + 180;
      boolean bool1 = bool4;
      boolean bool2 = bool3;
    }
    return true;
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    Camera.Parameters localParameters = a();
    if (localParameters == null) {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setPreviewFps[failed]getCameraParameters=null");
      }
    }
    int[] arrayOfInt;
    do
    {
      return false;
      arrayOfInt = a(paramInt, paramBoolean);
      if ((arrayOfInt != null) && (arrayOfInt.length >= 2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_b_of_type_JavaLangString, 2, "setPreviewFps[getFpsRange=null]");
    return false;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "setPreviewFps[ fps[low]=" + arrayOfInt[0] + " fps[high]=" + arrayOfInt[1] + "]");
    }
    try
    {
      localParameters.setPreviewFpsRange(arrayOfInt[0], arrayOfInt[1]);
      this.jdField_a_of_type_ArrayOfInt = arrayOfInt;
      paramBoolean = a(localParameters);
      return paramBoolean;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean a(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_AndroidHardwareCamera == null) || (paramSurfaceTexture == null)) {
      bool = false;
    }
    do
    {
      return bool;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_b_of_type_JavaLangString, 2, "@$[setPreviewTexture] mIsPreviewing=" + this.jdField_a_of_type_Boolean);
    return true;
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewTexture(paramSurfaceTexture);
      return true;
    }
    catch (Exception paramSurfaceTexture)
    {
      paramSurfaceTexture.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "@$[setPreviewTexture] exp=", paramSurfaceTexture);
      }
    }
    return false;
  }
  
  public boolean a(Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    if ((this.jdField_a_of_type_AndroidHardwareCamera == null) || (!this.jdField_a_of_type_Boolean) || (!f())) {
      return false;
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
      this.jdField_a_of_type_AndroidHardwareCamera.autoFocus(paramAutoFocusCallback);
      return true;
    }
    catch (Exception paramAutoFocusCallback) {}
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
  
  public boolean a(Camera.PreviewCallback paramPreviewCallback, SurfaceHolder paramSurfaceHolder)
  {
    if ((this.jdField_a_of_type_AndroidHardwareCamera == null) || (paramPreviewCallback == null) || (paramSurfaceHolder == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] startPreview[failed] mCamera=" + this.jdField_a_of_type_AndroidHardwareCamera + " holder=" + paramSurfaceHolder + " callback=" + paramPreviewCallback);
      }
      return false;
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewDisplay(paramSurfaceHolder);
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(paramPreviewCallback);
      this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    catch (Exception paramPreviewCallback)
    {
      paramPreviewCallback.printStackTrace();
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] startPreview[failed] Exception Occured... ep=" + paramPreviewCallback.getMessage());
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] startPreview[failed] Exception Occured... ep=" + paramPreviewCallback);
      }
    }
    return false;
  }
  
  public boolean a(Camera.PreviewCallback paramPreviewCallback, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidHardwareCamera == null) || (paramPreviewCallback == null)) {
      return false;
    }
    if (paramBoolean) {
      try
      {
        if (d(c()))
        {
          this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(this.jdField_a_of_type_ArrayOfByte);
          this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(this.jdField_b_of_type_ArrayOfByte);
          this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallbackWithBuffer(paramPreviewCallback);
        }
        else
        {
          this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(paramPreviewCallback);
        }
      }
      catch (Exception paramPreviewCallback)
      {
        paramPreviewCallback.printStackTrace();
        return false;
      }
    } else {
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(paramPreviewCallback);
    }
    return true;
  }
  
  public boolean a(SurfaceHolder paramSurfaceHolder)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_AndroidHardwareCamera == null) || (paramSurfaceHolder == null)) {
      bool = false;
    }
    do
    {
      return bool;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_b_of_type_JavaLangString, 2, "@$[setSurfaceHolder] mIsPreviewing=" + this.jdField_a_of_type_Boolean);
    return true;
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewDisplay(paramSurfaceHolder);
      return true;
    }
    catch (Exception paramSurfaceHolder)
    {
      paramSurfaceHolder.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "@$[setSurfaceHolder] exp=", paramSurfaceHolder);
      }
    }
    return false;
  }
  
  public boolean a(CameraControl.CustomSize paramCustomSize)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    Camera.Parameters localParameters = a();
    if (localParameters == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewSize[failed]getCameraParameters=null");
      }
      return false;
    }
    try
    {
      localParameters.setPreviewSize(paramCustomSize.jdField_a_of_type_Int, paramCustomSize.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = paramCustomSize;
      boolean bool = a(localParameters);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewSize, result = " + bool + ",size.width = " + paramCustomSize.jdField_a_of_type_Int + ",size.height = " + paramCustomSize.jdField_b_of_type_Int);
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
    boolean bool1 = false;
    boolean bool2 = false;
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if (!f()) {}
    boolean bool3;
    do
    {
      for (;;)
      {
        return bool2;
        try
        {
          this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
          Camera.Parameters localParameters = a();
          if (localParameters != null)
          {
            String str = localParameters.getFocusMode();
            if (QLog.isColorLevel()) {
              QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsFocusMode getFocusMode=" + str);
            }
            if ((str != null) && (str.equals(paramString))) {
              return true;
            }
          }
        }
        catch (RuntimeException localRuntimeException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i(jdField_b_of_type_JavaLangString, 2, "", localRuntimeException);
            }
          }
          bool3 = CameraAbility.a().a(paramString);
          if (bool3)
          {
            localRuntimeException.setFocusMode(paramString);
            bool1 = a(localRuntimeException);
          }
          bool2 = bool1;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsFocusMode support=" + bool3 + " success=" + bool1 + " setTo=" + paramString);
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
      }
      for (;;)
      {
        return a(localParameters);
        if ((!paramBoolean) && (!TextUtils.equals(str, "off"))) {
          localParameters.setFlashMode("off");
        }
      }
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
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewAndPictureSizeV2 wanted size=" + paramInt1 + " " + paramInt2 + " cliped=" + paramInt3 + " " + paramInt4);
    }
    CameraControl.CustomSize[] arrayOfCustomSize = new CameraControl.CustomSize[2];
    CameraControl.CustomSize localCustomSize1 = a(paramInt1, paramInt2, paramInt3, paramInt4, true);
    if (localCustomSize1 != null)
    {
      arrayOfCustomSize[0] = localCustomSize1;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewAndPictureSizeGuarantee way2 preview=" + localCustomSize1.jdField_a_of_type_Int + " " + localCustomSize1.jdField_b_of_type_Int);
      }
      CameraControl.CustomSize localCustomSize2 = a(localCustomSize1.jdField_a_of_type_Int, localCustomSize1.jdField_b_of_type_Int, paramInt3, paramInt4, 1);
      arrayOfCustomSize[1] = localCustomSize2;
      if (localCustomSize2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewAndPictureSizeGuarantee way2 picture=" + localCustomSize2.jdField_a_of_type_Int + " " + localCustomSize2.jdField_b_of_type_Int);
        }
        NewFlowCameraReporter.a(true, localCustomSize1.jdField_a_of_type_Int, localCustomSize1.jdField_b_of_type_Int, localCustomSize2.jdField_a_of_type_Int, localCustomSize2.jdField_b_of_type_Int);
      }
    }
    else
    {
      return arrayOfCustomSize;
    }
    NewFlowCameraReporter.a(true, localCustomSize1.jdField_a_of_type_Int, localCustomSize1.jdField_b_of_type_Int, -1, -1);
    return arrayOfCustomSize;
  }
  
  public int b()
  {
    int j = this.jdField_c_of_type_Int;
    if (FlowCameraConstant.jdField_a_of_type_Int == 1) {
      if (this.jdField_c_of_type_Int != 270) {
        break label70;
      }
    }
    label70:
    for (int i = this.jdField_c_of_type_Int - 180;; i = this.jdField_c_of_type_Int + 180)
    {
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "getPreviewOrientation:blackPhone= orientation=" + i);
        j = i;
      }
      return j;
    }
  }
  
  public CameraControl.CustomSize b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize;
  }
  
  public CameraControl.CustomSize b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeV2: dstwidth=" + paramInt1 + "  dstheight=" + paramInt2);
    }
    Object localObject = CameraAbility.a().a();
    if ((QLog.isColorLevel()) && (localObject != null))
    {
      int i = 0;
      while (i < ((List)localObject).size())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK[list]: width=" + ((Camera.Size)((List)localObject).get(i)).width + " height=" + ((Camera.Size)((List)localObject).get(i)).height + " w/h=" + ((Camera.Size)((List)localObject).get(i)).width / ((Camera.Size)((List)localObject).get(i)).height);
        i += 1;
      }
    }
    CameraControl.CustomSize localCustomSize = a((List)localObject, paramInt1, paramInt2, 2600, 1500, 1700, 1000);
    if (localCustomSize != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: DEFAULT resolution os OK.");
      }
      localObject = localCustomSize;
      if (paramBoolean)
      {
        NewFlowCameraReporter.a(2, paramInt1, paramInt2, localCustomSize.jdField_a_of_type_Int, localCustomSize.jdField_b_of_type_Int);
        localObject = localCustomSize;
      }
    }
    do
    {
      return localObject;
      localCustomSize = a((List)localObject, paramInt1, paramInt2, 2600, 1500, 1000, 700);
      if (localCustomSize == null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: 640*480 resolution os OK.");
      }
      localObject = localCustomSize;
    } while (!paramBoolean);
    NewFlowCameraReporter.a(3, paramInt1, paramInt2, localCustomSize.jdField_a_of_type_Int, localCustomSize.jdField_b_of_type_Int);
    return localCustomSize;
    localObject = a((List)localObject, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      if (localObject != null) {
        break label382;
      }
      paramInt3 = 0;
      if (localObject != null) {
        break label391;
      }
    }
    label391:
    for (paramInt4 = 0;; paramInt4 = ((CameraControl.CustomSize)localObject).jdField_b_of_type_Int)
    {
      NewFlowCameraReporter.a(4, paramInt1, paramInt2, paramInt3, paramInt4);
      return localObject;
      label382:
      paramInt3 = ((CameraControl.CustomSize)localObject).jdField_a_of_type_Int;
      break;
    }
  }
  
  @TargetApi(14)
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "release camera");
    }
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      CameraAbility.a().a();
    } while (this.jdField_a_of_type_AndroidHardwareCamera == null);
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
    //   1: getfield 337	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   4: ifnonnull +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: getfield 497	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_Boolean	Z
    //   13: ifne +5 -> 18
    //   16: iconst_1
    //   17: ireturn
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield 497	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_Boolean	Z
    //   23: aload_0
    //   24: invokespecial 571	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:f	()Z
    //   27: istore_1
    //   28: iload_1
    //   29: ifeq +10 -> 39
    //   32: aload_0
    //   33: getfield 337	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   36: invokevirtual 574	android/hardware/Camera:cancelAutoFocus	()V
    //   39: aload_0
    //   40: getfield 337	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   43: invokevirtual 723	android/hardware/Camera:stopPreview	()V
    //   46: aload_0
    //   47: getfield 337	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   50: aconst_null
    //   51: invokevirtual 597	android/hardware/Camera:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   54: aload_0
    //   55: getfield 337	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   58: aconst_null
    //   59: invokevirtual 593	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
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
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "setParamsPreviewFps[fps_wanted=" + paramInt + "]");
    }
    boolean bool2 = a(paramInt, false);
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "setParamsPreviewFps[fps_wanted=" + paramInt + " force=false success=" + bool2 + "]");
    }
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool2 = a(paramInt, true);
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "setParamsPreviewFps[fps_wanted=" + paramInt + " force=true success=" + bool2 + "]");
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  public boolean b(CameraControl.CustomSize paramCustomSize)
  {
    Camera.Parameters localParameters = a();
    if (localParameters == null) {}
    do
    {
      return false;
      try
      {
        localParameters.setPictureSize(paramCustomSize.jdField_a_of_type_Int, paramCustomSize.jdField_b_of_type_Int);
        this.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = paramCustomSize;
        boolean bool = a(localParameters);
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "setRawPictureSize w " + paramCustomSize.jdField_a_of_type_Int + ", h " + paramCustomSize.jdField_b_of_type_Int + ", success=" + bool);
        }
        return bool;
      }
      catch (Exception paramCustomSize)
      {
        paramCustomSize.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_b_of_type_JavaLangString, 2, "setParamsPictureSize", paramCustomSize);
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
      if ((str != null) && (!str.equals(paramString)))
      {
        localParameters.setSceneMode(paramString);
        boolean bool = a(localParameters);
        if (QLog.isColorLevel()) {
          QLog.e(jdField_b_of_type_JavaLangString, 2, new Object[] { "setSceneMode success: ", Boolean.valueOf(bool) });
        }
        return bool;
      }
    }
    else
    {
      return false;
    }
    return true;
  }
  
  public boolean b(boolean paramBoolean)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if (CameraAbility.a().e())
    {
      Camera.Parameters localParameters = a();
      if (paramBoolean) {}
      for (String str = "torch";; str = "off")
      {
        localParameters.setFlashMode(str);
        return a(localParameters);
      }
    }
    return false;
  }
  
  public CameraControl.CustomSize[] b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewAndPictureSizeV2 wanted size=" + paramInt1 + " " + paramInt2 + " cliped=" + paramInt3 + " " + paramInt4);
    }
    CameraControl.CustomSize[] arrayOfCustomSize = new CameraControl.CustomSize[2];
    CameraControl.CustomSize localCustomSize1 = b(paramInt1, paramInt2, paramInt3, paramInt4, true);
    if (localCustomSize1 != null)
    {
      arrayOfCustomSize[0] = localCustomSize1;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewAndPictureSizeGuarantee way2 preview=" + localCustomSize1.jdField_a_of_type_Int + " " + localCustomSize1.jdField_b_of_type_Int);
      }
      CameraControl.CustomSize localCustomSize2 = a(localCustomSize1.jdField_a_of_type_Int, localCustomSize1.jdField_b_of_type_Int, paramInt3, paramInt4, 1);
      arrayOfCustomSize[1] = localCustomSize2;
      if (localCustomSize2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewAndPictureSizeGuarantee way2 picture=" + localCustomSize2.jdField_a_of_type_Int + " " + localCustomSize2.jdField_b_of_type_Int);
        }
        NewFlowCameraReporter.a(true, localCustomSize1.jdField_a_of_type_Int, localCustomSize1.jdField_b_of_type_Int, localCustomSize2.jdField_a_of_type_Int, localCustomSize2.jdField_b_of_type_Int);
      }
    }
    else
    {
      return arrayOfCustomSize;
    }
    NewFlowCameraReporter.a(true, localCustomSize1.jdField_a_of_type_Int, localCustomSize1.jdField_b_of_type_Int, -1, -1);
    return arrayOfCustomSize;
  }
  
  public CameraControl.CustomSize c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: dstwidth=" + paramInt1 + "  dstheight=" + paramInt2);
    }
    Object localObject = CameraAbility.a().a();
    if ((QLog.isColorLevel()) && (localObject != null))
    {
      int i = 0;
      while (i < ((List)localObject).size())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK[list]: width=" + ((Camera.Size)((List)localObject).get(i)).width + " height=" + ((Camera.Size)((List)localObject).get(i)).height + " w/h=" + ((Camera.Size)((List)localObject).get(i)).width / ((Camera.Size)((List)localObject).get(i)).height);
        i += 1;
      }
    }
    CameraControl.CustomSize localCustomSize = a((List)localObject, GloableValue.jdField_c_of_type_Int, GloableValue.d);
    if (localCustomSize != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: DEFAULT resolution os OK.");
      }
      localObject = localCustomSize;
      if (paramBoolean)
      {
        NewFlowCameraReporter.a(2, GloableValue.jdField_c_of_type_Int, GloableValue.d, localCustomSize.jdField_a_of_type_Int, localCustomSize.jdField_b_of_type_Int);
        localObject = localCustomSize;
      }
    }
    do
    {
      do
      {
        return localObject;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: Degeneration to 640*480...");
        }
        localCustomSize = a((List)localObject, GloableValue.jdField_a_of_type_ArrayOfInt[1], GloableValue.b[1]);
        if (localCustomSize == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: 640*480 resolution os OK.");
        }
        localObject = localCustomSize;
      } while (!paramBoolean);
      NewFlowCameraReporter.a(3, GloableValue.jdField_c_of_type_Int, GloableValue.d, localCustomSize.jdField_a_of_type_Int, localCustomSize.jdField_b_of_type_Int);
      return localCustomSize;
      localCustomSize = a((List)localObject, paramInt1, paramInt2, paramInt3, paramInt4);
      localObject = localCustomSize;
    } while (!paramBoolean);
    if (localCustomSize == null)
    {
      paramInt1 = 0;
      if (localCustomSize != null) {
        break label413;
      }
    }
    label413:
    for (paramInt2 = j;; paramInt2 = localCustomSize.jdField_b_of_type_Int)
    {
      NewFlowCameraReporter.a(4, GloableValue.jdField_c_of_type_Int, GloableValue.d, paramInt1, paramInt2);
      return localCustomSize;
      paramInt1 = localCustomSize.jdField_a_of_type_Int;
      break;
    }
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
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "startFaceDetection");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  @TargetApi(14)
  public boolean c()
  {
    boolean bool = false;
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    try
    {
      i = this.jdField_a_of_type_AndroidHardwareCamera.getParameters().getMaxNumDetectedFaces();
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "supportFaceDetect" + i);
      }
      if (i > 0) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        int i = 0;
      }
    }
  }
  
  public boolean c(int paramInt)
  {
    int j = 0;
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    Camera.Parameters localParameters;
    int i;
    if (CameraAbility.a().d())
    {
      localParameters = a();
      if (localParameters == null) {
        return false;
      }
      i = localParameters.getMaxZoom();
      paramInt = localParameters.getZoom() + paramInt;
      if (paramInt >= 0) {
        break label90;
      }
      paramInt = j;
    }
    label90:
    for (;;)
    {
      if (paramInt > i) {
        paramInt = i;
      }
      for (;;)
      {
        localParameters.setZoom(paramInt);
        return a(localParameters);
        return false;
      }
    }
  }
  
  public CameraControl.CustomSize[] c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewAndPictureSizeGuarantee wanted size=" + GloableValue.jdField_c_of_type_Int + " " + GloableValue.d + " cliped=" + paramInt1 + " " + paramInt2);
    }
    if (0 != 0)
    {
      paramInt1 = GloableValue.jdField_c_of_type_Int;
      paramInt1 = GloableValue.d;
      throw new NullPointerException();
    }
    CameraControl.CustomSize[] arrayOfCustomSize = new CameraControl.CustomSize[2];
    CameraControl.CustomSize localCustomSize1 = c(paramInt1, paramInt2, paramInt3, paramInt4, true);
    if (localCustomSize1 != null)
    {
      arrayOfCustomSize[0] = localCustomSize1;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewAndPictureSizeGuarantee way2 preview=" + localCustomSize1.jdField_a_of_type_Int + " " + localCustomSize1.jdField_b_of_type_Int);
      }
      CameraControl.CustomSize localCustomSize2 = a(localCustomSize1.jdField_a_of_type_Int, localCustomSize1.jdField_b_of_type_Int, paramInt3, paramInt4, 1);
      arrayOfCustomSize[1] = localCustomSize2;
      if (localCustomSize2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewAndPictureSizeGuarantee way2 picture=" + localCustomSize2.jdField_a_of_type_Int + " " + localCustomSize2.jdField_b_of_type_Int);
        }
        NewFlowCameraReporter.a(true, localCustomSize1.jdField_a_of_type_Int, localCustomSize1.jdField_b_of_type_Int, localCustomSize2.jdField_a_of_type_Int, localCustomSize2.jdField_b_of_type_Int);
        return arrayOfCustomSize;
      }
      NewFlowCameraReporter.a(true, localCustomSize1.jdField_a_of_type_Int, localCustomSize1.jdField_b_of_type_Int, -1, -1);
    }
    return arrayOfCustomSize;
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
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "stopFaceDetection");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public boolean d()
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    Camera.Parameters localParameters = a();
    boolean bool1;
    if (localParameters == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewFormat[failed]getCameraParameters=null");
      }
      bool1 = false;
    }
    boolean bool2;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                if (!CameraAbility.a().a(17)) {
                  break;
                }
                localParameters.setPreviewFormat(17);
                this.jdField_b_of_type_Int = 17;
                bool2 = a(localParameters);
                bool1 = bool2;
              } while (!QLog.isColorLevel());
              QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewFormat:success=" + bool2 + ", isSupportPreviewFormat=NV21 ok");
              return bool2;
              if (!CameraAbility.a().a(842094169)) {
                break;
              }
              localParameters.setPreviewFormat(842094169);
              this.jdField_b_of_type_Int = 842094169;
              bool2 = a(localParameters);
              bool1 = bool2;
            } while (!QLog.isColorLevel());
            QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewFormat:success=" + bool2 + "isSupportPreviewFormat=YV12 OK");
            return bool2;
            if (!CameraAbility.a().a(20)) {
              break;
            }
            localParameters.setPreviewFormat(20);
            this.jdField_b_of_type_Int = 20;
            bool2 = a(localParameters);
            bool1 = bool2;
          } while (!QLog.isColorLevel());
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewFormat:success=" + bool2 + "isSupportPreviewFormat=YUY2 OK");
          return bool2;
          if (!CameraAbility.a().a(4)) {
            break;
          }
          localParameters.setPreviewFormat(4);
          this.jdField_b_of_type_Int = 4;
          bool2 = a(localParameters);
          bool1 = bool2;
        } while (!QLog.isColorLevel());
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewFormat:success=" + bool2 + "isSupportPreviewFormat=RGB_565 OK");
        return bool2;
        if (!CameraAbility.a().a(256)) {
          break;
        }
        localParameters.setPreviewFormat(256);
        this.jdField_b_of_type_Int = 256;
        bool2 = a(localParameters);
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewFormat:success=" + bool2 + "isSupportPreviewFormat=JPEG OK");
      return bool2;
      if (!CameraAbility.a().a(16)) {
        break;
      }
      localParameters.setPreviewFormat(16);
      this.jdField_b_of_type_Int = 16;
      bool2 = a(localParameters);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewFormat:success=" + bool2 + "isSupportPreviewFormat=NV16 OK");
    return bool2;
    return false;
  }
  
  public boolean e()
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if (CameraAbility.a().e())
    {
      Camera.Parameters localParameters = a();
      if (TextUtils.equals(localParameters.getFlashMode(), "torch")) {
        localParameters.setFlashMode("off");
      }
      for (;;)
      {
        return a(localParameters);
        localParameters.setFlashMode("torch");
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraControl
 * JD-Core Version:    0.7.0.1
 */