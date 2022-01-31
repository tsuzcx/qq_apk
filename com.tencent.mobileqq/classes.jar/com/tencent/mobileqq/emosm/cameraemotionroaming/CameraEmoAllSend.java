package com.tencent.mobileqq.emosm.cameraemotionroaming;

import ajwa;
import aklb;
import bizu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.LinearGroup;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.FavEmoSingleSend;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class CameraEmoAllSend
  extends LinearGroup
  implements aklb
{
  public static boolean a;
  public static boolean b;
  private List<CustomEmotionBase> a;
  private boolean c;
  private int d;
  private int f;
  private int g;
  private int h;
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ajwa localajwa = (ajwa)((QQAppInterface)bizu.a()).a(72);
    if ((paramInt3 < paramInt2) || ((paramInt4 > 0) && (paramInt5 > 0))) {
      if (paramInt3 == 0) {
        paramInt1 = 5;
      }
    }
    for (;;)
    {
      localajwa.notifyUI(2, false, Integer.valueOf(paramInt1));
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
  
  public int a()
  {
    Iterator localIterator;
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    for (;;)
    {
      Object localObject;
      if (localIterator.hasNext())
      {
        localObject = (CustomEmotionBase)localIterator.next();
        if (this.jdField_a_of_type_Int != 8) {
          break label125;
        }
        if (QLog.isColorLevel()) {
          QLog.d("CameraEmoAllSend", 1, new Object[] { "doStep interrupted, index:", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.indexOf(localObject)) });
        }
      }
      if (this.c) {
        a(this.d, this.jdField_a_of_type_JavaUtilList.size(), this.f, this.g, this.h);
      }
      return 7;
      label125:
      if ((localObject instanceof CameraEmotionData))
      {
        new CameraEmoSingleSend((CameraEmotionData)localObject, false).run();
      }
      else if ((localObject instanceof CustomEmotionData))
      {
        localObject = new FavEmoSingleSend((CustomEmotionData)localObject, false);
        ((AsyncStep)localObject).a = this;
        ((AsyncStep)localObject).run();
      }
    }
  }
  
  public void a()
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
  
  public void a(AsyncStep paramAsyncStep, int paramInt)
  {
    if ((this.c) && ((paramAsyncStep instanceof FavEmoSingleSend)) && (((FavEmoSingleSend)paramAsyncStep).jdField_a_of_type_Boolean)) {
      this.f += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend
 * JD-Core Version:    0.7.0.1
 */