package com.tencent.mobileqq.shortvideo.dancemachine.matchTemplate;

import android.graphics.Matrix;
import android.os.Handler;
import android.util.Log;
import com.tencent.mobileqq.shortvideo.dancemachine.MatchTemplateConfig;
import com.tencent.mobileqq.shortvideo.dancemachine.MatchTemplateConfig.KeyPoint;
import com.tencent.mobileqq.shortvideo.dancemachine.MatchTemplateConfig.KeyVector;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.Vec3f;
import java.util.ArrayList;
import java.util.List;

public class MatchTemplate
{
  public static MatchTemplate a;
  public Handler a;
  
  private double a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = a(0.0F, 0.0F, paramFloat1, paramFloat2);
    float f2 = a(0.0F, 0.0F, paramFloat3, paramFloat4);
    if ((f1 == 0.0F) || (f2 == 0.0F)) {
      return (0.0D / 0.0D);
    }
    return Math.toDegrees(Math.acos((paramFloat1 * paramFloat3 + paramFloat2 * paramFloat4) / (f1 * f2)));
  }
  
  private MatchTemplateConfig.KeyPoint a(List paramList, int paramInt)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if (((MatchTemplateConfig.KeyPoint)paramList.get(i)).jdField_a_of_type_Int == paramInt) {
        return (MatchTemplateConfig.KeyPoint)paramList.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  private IVec3f a(List paramList, int paramInt)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if (((IVec3f)paramList.get(i)).jdField_a_of_type_Int == paramInt) {
        return (IVec3f)paramList.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public static MatchTemplate a()
  {
    if (jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineMatchTemplateMatchTemplate == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineMatchTemplateMatchTemplate == null) {
        jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineMatchTemplateMatchTemplate = new MatchTemplate();
      }
      return jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineMatchTemplateMatchTemplate;
    }
    finally {}
  }
  
  public static void a(String paramString)
  {
    Log.d("POS_MATCH_TEMPLATE", paramString);
  }
  
  private boolean a(List paramList, MatchTemplateConfig paramMatchTemplateConfig)
  {
    boolean bool = true;
    if ((paramList == null) || (paramMatchTemplateConfig == null) || (paramMatchTemplateConfig.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      bool = false;
      return bool;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    int i = 1;
    float f1 = 0.0F;
    float f2;
    if (j < paramMatchTemplateConfig.jdField_a_of_type_JavaUtilList.size())
    {
      MatchTemplateConfig.KeyPoint localKeyPoint = (MatchTemplateConfig.KeyPoint)paramMatchTemplateConfig.jdField_a_of_type_JavaUtilList.get(j);
      f2 = a(((IVec3f)paramList.get(j)).jdField_a_of_type_Float, ((IVec3f)paramList.get(j)).jdField_b_of_type_Float, ((MatchTemplateConfig.KeyPoint)paramMatchTemplateConfig.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_ArrayOfFloat[0], ((MatchTemplateConfig.KeyPoint)paramMatchTemplateConfig.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_ArrayOfFloat[1]);
      f2 = localKeyPoint.jdField_a_of_type_Float * f2;
      if ((localKeyPoint.jdField_b_of_type_Float == 0.0F) || (f2 <= localKeyPoint.jdField_b_of_type_Float)) {
        break label419;
      }
      i = 0;
    }
    label419:
    for (;;)
    {
      if (f2 < 1.0F) {}
      for (;;)
      {
        j += 1;
        f1 += f2;
        break;
        localStringBuilder.append(((MatchTemplateConfig.KeyPoint)paramMatchTemplateConfig.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_Int + " : " + f2);
        localStringBuilder.append(System.getProperty("line.separator").toString());
      }
      localStringBuilder.append("total : " + f1);
      a(localStringBuilder.toString());
      j = i;
      if (paramMatchTemplateConfig.jdField_a_of_type_Float != 0.0F)
      {
        j = i;
        if (f1 > paramMatchTemplateConfig.jdField_a_of_type_Float) {
          j = 0;
        }
      }
      if (this.jdField_a_of_type_AndroidOsHandler == null)
      {
        if (j == 1) {
          break;
        }
        return false;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0, null);
      paramList = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      paramList.what = 1;
      paramList.obj = localStringBuilder.toString();
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramList);
      paramList = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      paramList.what = 2;
      paramList.arg1 = j;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramList);
      if (j == 1) {
        break;
      }
      return false;
    }
  }
  
  private boolean a(List paramList, MatchTemplateConfig paramMatchTemplateConfig, int paramInt)
  {
    if (paramMatchTemplateConfig == null) {
      return false;
    }
    try
    {
      List localList = paramMatchTemplateConfig.jdField_a_of_type_JavaUtilList;
      MatchTemplateConfig.KeyPoint localKeyPoint1 = a(localList, paramMatchTemplateConfig.jdField_b_of_type_Int);
      MatchTemplateConfig.KeyPoint localKeyPoint2 = a(localList, paramMatchTemplateConfig.c);
      ArrayList localArrayList = new ArrayList();
      paramInt = 0;
      while (paramInt < localList.size())
      {
        MatchTemplateConfig.KeyPoint localKeyPoint3 = (MatchTemplateConfig.KeyPoint)localList.get(paramInt);
        localArrayList.add(new IVec3f(localKeyPoint3.jdField_a_of_type_Int, (Vec3f)paramList.get(localKeyPoint3.jdField_a_of_type_Int)));
        paramInt += 1;
      }
      paramList = a(localArrayList, paramMatchTemplateConfig.jdField_b_of_type_Int, paramMatchTemplateConfig.c, Float.valueOf(a(localKeyPoint1.jdField_a_of_type_ArrayOfFloat[0], localKeyPoint1.jdField_a_of_type_ArrayOfFloat[1], localKeyPoint2.jdField_a_of_type_ArrayOfFloat[0], localKeyPoint2.jdField_a_of_type_ArrayOfFloat[1])));
      if (paramList == null) {
        return false;
      }
      if (paramMatchTemplateConfig.jdField_a_of_type_Int == 1) {
        return b(paramList, paramMatchTemplateConfig);
      }
      if (paramMatchTemplateConfig.jdField_a_of_type_Int == 0)
      {
        boolean bool = a(paramList, paramMatchTemplateConfig);
        return bool;
      }
      return false;
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
    }
    return false;
  }
  
  private boolean b(List paramList, MatchTemplateConfig paramMatchTemplateConfig)
  {
    if ((paramList == null) || (paramMatchTemplateConfig == null) || (paramMatchTemplateConfig.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return false;
    }
    List localList1 = paramMatchTemplateConfig.jdField_b_of_type_JavaUtilList;
    List localList2 = paramMatchTemplateConfig.jdField_a_of_type_JavaUtilList;
    StringBuilder localStringBuilder = new StringBuilder();
    double d1 = 0.0D;
    int i = 1;
    int k = 0;
    while (k < localList1.size())
    {
      MatchTemplateConfig.KeyVector localKeyVector = (MatchTemplateConfig.KeyVector)localList1.get(k);
      MatchTemplateConfig.KeyPoint localKeyPoint1 = a(localList2, localKeyVector.jdField_a_of_type_ArrayOfInt[0]);
      MatchTemplateConfig.KeyPoint localKeyPoint2 = a(localList2, localKeyVector.jdField_a_of_type_ArrayOfInt[1]);
      IVec3f localIVec3f1 = a(paramList, localKeyVector.jdField_a_of_type_ArrayOfInt[0]);
      IVec3f localIVec3f2 = a(paramList, localKeyVector.jdField_a_of_type_ArrayOfInt[1]);
      double d2 = a(localKeyPoint2.jdField_a_of_type_ArrayOfFloat[0] - localKeyPoint1.jdField_a_of_type_ArrayOfFloat[0], localKeyPoint2.jdField_a_of_type_ArrayOfFloat[1] - localKeyPoint1.jdField_a_of_type_ArrayOfFloat[1], localIVec3f2.jdField_a_of_type_Float - localIVec3f1.jdField_a_of_type_Float, localIVec3f2.jdField_b_of_type_Float - localIVec3f1.jdField_b_of_type_Float);
      j = i;
      if (Double.isNaN(d2)) {
        j = 0;
      }
      d2 *= localKeyVector.jdField_a_of_type_Float;
      i = j;
      if (localKeyVector.jdField_a_of_type_Int != 0)
      {
        i = j;
        if (d2 > localKeyVector.jdField_a_of_type_Int) {
          i = 0;
        }
      }
      localStringBuilder.append("[" + localKeyVector.jdField_a_of_type_ArrayOfInt[0] + " , " + localKeyVector.jdField_a_of_type_ArrayOfInt[1] + " ] : " + d2 + "\n");
      d1 += d2;
      k += 1;
    }
    localStringBuilder.append("total : " + d1);
    int j = i;
    if (paramMatchTemplateConfig.jdField_b_of_type_Float != 0.0F)
    {
      j = i;
      if (d1 > paramMatchTemplateConfig.jdField_b_of_type_Float) {
        j = 0;
      }
    }
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return j == 1;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0, null);
    paramList = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    paramList.what = 1;
    paramList.obj = localStringBuilder.toString();
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramList);
    paramList = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    paramList.what = 2;
    paramList.arg1 = j;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramList);
    return j == 1;
  }
  
  public float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public List a(List paramList, int paramInt1, int paramInt2, Float paramFloat)
  {
    int j = 0;
    int i = 0;
    Object localObject1 = null;
    Object localObject2 = null;
    label423:
    label426:
    label429:
    do
    {
      for (;;)
      {
        try
        {
          if (i >= paramList.size()) {
            break;
          }
          IVec3f localIVec3f = (IVec3f)paramList.get(i);
          if (localIVec3f.jdField_a_of_type_Int != paramInt1) {
            break label426;
          }
          localObject2 = localIVec3f;
          if (localIVec3f.jdField_a_of_type_Int != paramInt2) {
            break label423;
          }
          localObject1 = localIVec3f;
        }
        catch (Exception paramList)
        {
          float f2;
          float f1;
          double d;
          paramList.printStackTrace();
          return null;
        }
        f2 = a(localObject2.jdField_a_of_type_Float, localObject2.jdField_b_of_type_Float, ((Vec3f)localObject1).jdField_a_of_type_Float, ((Vec3f)localObject1).jdField_b_of_type_Float);
        f1 = f2;
        if (paramFloat != null)
        {
          f1 = f2;
          if (paramFloat.floatValue() > 0.0F) {
            f1 = paramFloat.floatValue();
          }
        }
        f2 = a(localObject2.jdField_a_of_type_Float, localObject2.jdField_b_of_type_Float, ((Vec3f)localObject1).jdField_a_of_type_Float, ((Vec3f)localObject1).jdField_b_of_type_Float);
        if (f2 <= 0.0F) {
          return null;
        }
        f1 /= f2;
        paramFloat = new Matrix();
        paramFloat.setTranslate(-localObject2.jdField_a_of_type_Float, -localObject2.jdField_b_of_type_Float);
        d = Math.toDegrees(Math.acos((((Vec3f)localObject1).jdField_a_of_type_Float - localObject2.jdField_a_of_type_Float) / f2));
        if (((Vec3f)localObject1).jdField_b_of_type_Float - localObject2.jdField_b_of_type_Float > 0.0F)
        {
          d = -d;
          paramFloat.postRotate((float)d);
          paramFloat.postScale(f1, f1);
          localObject1 = new float[paramList.size() * 2];
          paramInt1 = 0;
          if (paramInt1 < paramList.size())
          {
            localObject1[(paramInt1 * 2)] = ((IVec3f)paramList.get(paramInt1)).jdField_a_of_type_Float;
            localObject1[(paramInt1 * 2 + 1)] = ((IVec3f)paramList.get(paramInt1)).jdField_b_of_type_Float;
            paramInt1 += 1;
            continue;
          }
          paramFloat.mapPoints((float[])localObject1);
          paramFloat = new ArrayList();
          paramInt1 = j;
          if (paramInt1 < paramList.size())
          {
            f1 = localObject1[(paramInt1 * 2)];
            f2 = localObject1[(paramInt1 * 2 + 1)];
            paramFloat.add(new IVec3f(((IVec3f)paramList.get(paramInt1)).jdField_a_of_type_Int, f1, f2, 0.0F));
            paramInt1 += 1;
            continue;
          }
          return paramFloat;
        }
        continue;
        break label429;
        continue;
        i += 1;
      }
    } while ((localObject2 != null) && (localObject1 != null));
    return null;
  }
  
  public boolean a(List paramList1, List paramList2, int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramList2.size())
      {
        MatchTemplateConfig localMatchTemplateConfig = (MatchTemplateConfig)paramList2.get(i);
        if ((localMatchTemplateConfig != null) && (a(paramList1, localMatchTemplateConfig, paramInt))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.matchTemplate.MatchTemplate
 * JD-Core Version:    0.7.0.1
 */