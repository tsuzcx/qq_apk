package com.tencent.mobileqq.emosm.cameraemotionroaming;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.IFavEmoRoamingHandler;
import com.tencent.mobileqq.emosm.control.EmoAsyncStep;
import com.tencent.mobileqq.emosm.control.EmoLinearGroup;
import com.tencent.mobileqq.emosm.control.IEmoResultListener;
import com.tencent.mobileqq.emosm.favroaming.FavEmoSingleSend;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class CameraEmoAllSend
  extends EmoLinearGroup
  implements IEmoResultListener
{
  public static boolean a = false;
  public static boolean b = false;
  private List<CustomEmotionBase> a;
  private boolean c = false;
  private int d;
  private int f;
  private int g;
  private int h;
  
  protected int a()
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (CustomEmotionBase)localIterator.next();
        if (this.jdField_a_of_type_Int == 8)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("CameraEmoAllSend", 1, new Object[] { "doStep interrupted, index:", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.indexOf(localObject)) });
          break;
        }
        localObject = a((CustomEmotionBase)localObject);
        if (localObject != null) {
          ((EmoAsyncStep)localObject).run();
        }
      }
      if (this.c) {
        a(this.d, this.jdField_a_of_type_JavaUtilList.size(), this.f, this.g, this.h);
      }
    }
    return 7;
  }
  
  public EmoAsyncStep a(CustomEmotionBase paramCustomEmotionBase)
  {
    if ((paramCustomEmotionBase instanceof CameraEmotionData)) {
      return new CameraEmoSingleSend((CameraEmotionData)paramCustomEmotionBase, false);
    }
    if ((paramCustomEmotionBase instanceof CustomEmotionData))
    {
      paramCustomEmotionBase = new FavEmoSingleSend((CustomEmotionData)paramCustomEmotionBase, false);
      paramCustomEmotionBase.a = this;
      return paramCustomEmotionBase;
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList = ((List)this.jdField_a_of_type_ArrayOfJavaLangObject[0]);
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      if ((this.jdField_a_of_type_JavaUtilList.get(0) instanceof CameraEmotionData))
      {
        jdField_a_of_type_Boolean = false;
      }
      else if ((this.jdField_a_of_type_JavaUtilList.get(0) instanceof CustomEmotionData))
      {
        b = false;
        this.c = true;
        this.d = ((Integer)this.jdField_a_of_type_ArrayOfJavaLangObject[1]).intValue();
        this.g = ((Integer)this.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue();
        this.h = ((Integer)this.jdField_a_of_type_ArrayOfJavaLangObject[3]).intValue();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraEmoAllSend", 1, new Object[] { "onCreate, size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    IFavEmoRoamingHandler localIFavEmoRoamingHandler = (IFavEmoRoamingHandler)((BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(FavEmoRoamingHandler.a);
    if ((paramInt3 >= paramInt2) && ((paramInt4 <= 0) || (paramInt5 <= 0)))
    {
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
    else if (paramInt3 == 0) {
      paramInt1 = 5;
    } else {
      paramInt1 = 6;
    }
    localIFavEmoRoamingHandler.notifyUI(2, false, Integer.valueOf(paramInt1));
  }
  
  public void a(EmoAsyncStep paramEmoAsyncStep, int paramInt)
  {
    if ((this.c) && ((paramEmoAsyncStep instanceof FavEmoSingleSend)) && (((FavEmoSingleSend)paramEmoAsyncStep).jdField_a_of_type_Boolean)) {
      this.f += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend
 * JD-Core Version:    0.7.0.1
 */