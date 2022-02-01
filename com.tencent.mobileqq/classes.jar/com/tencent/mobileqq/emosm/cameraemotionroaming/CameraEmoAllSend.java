package com.tencent.mobileqq.emosm.cameraemotionroaming;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.IResultListener;
import com.tencent.mobileqq.app.automator.LinearGroup;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.FavEmoSingleSend;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.CaptureContext;
import java.util.Iterator;
import java.util.List;

public class CameraEmoAllSend
  extends LinearGroup
  implements IResultListener
{
  public static boolean a;
  public static boolean b = false;
  private List<CustomEmotionBase> a;
  private boolean c = false;
  private int d;
  private int f;
  private int g;
  private int h;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public int a()
  {
    Iterator localIterator;
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject = (CustomEmotionBase)localIterator.next();
        if (this.jdField_a_of_type_Int != 8) {
          break label126;
        }
        if (QLog.isColorLevel()) {
          QLog.d("CameraEmoAllSend", 1, new Object[] { "doStep interrupted, index:", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.indexOf(localObject)) });
        }
      }
      if (this.c) {
        a(this.d, this.jdField_a_of_type_JavaUtilList.size(), this.f, this.g, this.h);
      }
      return 7;
      label126:
      Object localObject = a((CustomEmotionBase)localObject);
      if (localObject != null) {
        ((AsyncStep)localObject).run();
      }
    }
  }
  
  public AsyncStep a(CustomEmotionBase paramCustomEmotionBase)
  {
    CameraEmoSingleSend localCameraEmoSingleSend = null;
    if ((paramCustomEmotionBase instanceof CameraEmotionData)) {
      localCameraEmoSingleSend = new CameraEmoSingleSend((CameraEmotionData)paramCustomEmotionBase, false);
    }
    while (!(paramCustomEmotionBase instanceof CustomEmotionData)) {
      return localCameraEmoSingleSend;
    }
    paramCustomEmotionBase = new FavEmoSingleSend((CustomEmotionData)paramCustomEmotionBase, false);
    paramCustomEmotionBase.a = this;
    return paramCustomEmotionBase;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    FavEmoRoamingHandler localFavEmoRoamingHandler = (FavEmoRoamingHandler)((QQAppInterface)CaptureContext.a()).getBusinessHandler(BusinessHandlerFactory.FAVEMO_ROAMING_HANDLER);
    if ((paramInt3 < paramInt2) || ((paramInt4 > 0) && (paramInt5 > 0))) {
      if (paramInt3 == 0) {
        paramInt1 = 5;
      }
    }
    for (;;)
    {
      localFavEmoRoamingHandler.notifyUI(2, false, Integer.valueOf(paramInt1));
      return;
      paramInt1 = 6;
      continue;
      if (paramInt4 > 0)
      {
        if (paramInt4 == paramInt1) {
          paramInt1 = 1;
        } else {
          paramInt1 = 2;
        }
      }
      else if (paramInt5 > 0)
      {
        if (paramInt5 == paramInt1) {
          paramInt1 = 3;
        } else {
          paramInt1 = 4;
        }
      }
      else {
        paramInt1 = 0;
      }
    }
  }
  
  public void a(AsyncStep paramAsyncStep, int paramInt)
  {
    if ((this.c) && ((paramAsyncStep instanceof FavEmoSingleSend)) && (((FavEmoSingleSend)paramAsyncStep).jdField_a_of_type_Boolean)) {
      this.f += 1;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilList = ((List)this.jdField_a_of_type_ArrayOfJavaLangObject[0]);
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      if (!(this.jdField_a_of_type_JavaUtilList.get(0) instanceof CameraEmotionData)) {
        break label82;
      }
      jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmoAllSend", 1, new Object[] { "onCreate, size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      }
      return;
      label82:
      if ((this.jdField_a_of_type_JavaUtilList.get(0) instanceof CustomEmotionData))
      {
        b = false;
        this.c = true;
        this.d = ((Integer)this.jdField_a_of_type_ArrayOfJavaLangObject[1]).intValue();
        this.g = ((Integer)this.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue();
        this.h = ((Integer)this.jdField_a_of_type_ArrayOfJavaLangObject[3]).intValue();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend
 * JD-Core Version:    0.7.0.1
 */