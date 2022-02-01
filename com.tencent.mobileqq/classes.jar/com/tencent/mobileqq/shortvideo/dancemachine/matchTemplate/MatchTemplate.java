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
  public static final int CHECK_ANGLE = 1;
  public static final int CHECK_DISTANCE = 0;
  public static final String CONFIG_NAME = "pose.cfg";
  public static final int MSG_INDICATOR = 2;
  public static final int MSG_LOG = 1;
  public static final String TAG = "POS_MATCH_TEMPLATE";
  public static MatchTemplate instance;
  public Handler uiHandler;
  
  public static void MLog(String paramString)
  {
    Log.d("POS_MATCH_TEMPLATE", paramString);
  }
  
  private double calDegree(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = calDis(0.0F, 0.0F, paramFloat1, paramFloat2);
    float f2 = calDis(0.0F, 0.0F, paramFloat3, paramFloat4);
    if ((f1 != 0.0F) && (f2 != 0.0F)) {
      return Math.toDegrees(Math.acos((paramFloat1 * paramFloat3 + paramFloat2 * paramFloat4) / (f1 * f2)));
    }
    return (0.0D / 0.0D);
  }
  
  private IVec3f findIVec(List<IVec3f> paramList, int paramInt)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if (((IVec3f)paramList.get(i)).index == paramInt) {
        return (IVec3f)paramList.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  private MatchTemplateConfig.KeyPoint findKeyPoint(List<MatchTemplateConfig.KeyPoint> paramList, int paramInt)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if (((MatchTemplateConfig.KeyPoint)paramList.get(i)).index == paramInt) {
        return (MatchTemplateConfig.KeyPoint)paramList.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public static MatchTemplate getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new MatchTemplate();
        }
      }
      finally {}
    }
    return instance;
  }
  
  private void logLocalPoints(String paramString, List<IVec3f> paramList)
  {
    paramString = new StringBuilder(paramString);
    int i = 0;
    while (i < paramList.size())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((IVec3f)paramList.get(i)).toString());
      localStringBuilder.append("        ");
      paramString.append(localStringBuilder.toString());
      i += 1;
    }
    MLog(paramString.toString());
  }
  
  private boolean match(List<Vec3f> paramList, MatchTemplateConfig paramMatchTemplateConfig, int paramInt)
  {
    if (paramMatchTemplateConfig == null) {
      return false;
    }
    try
    {
      List localList = paramMatchTemplateConfig.keyPoints;
      MatchTemplateConfig.KeyPoint localKeyPoint1 = findKeyPoint(localList, paramMatchTemplateConfig.datumIndex0);
      MatchTemplateConfig.KeyPoint localKeyPoint2 = findKeyPoint(localList, paramMatchTemplateConfig.datumIndex1);
      ArrayList localArrayList = new ArrayList();
      paramInt = 0;
      while (paramInt < localList.size())
      {
        MatchTemplateConfig.KeyPoint localKeyPoint3 = (MatchTemplateConfig.KeyPoint)localList.get(paramInt);
        localArrayList.add(new IVec3f(localKeyPoint3.index, (Vec3f)paramList.get(localKeyPoint3.index)));
        paramInt += 1;
      }
      paramList = convertPoints(localArrayList, paramMatchTemplateConfig.datumIndex0, paramMatchTemplateConfig.datumIndex1, Float.valueOf(calDis(localKeyPoint1.coords[0], localKeyPoint1.coords[1], localKeyPoint2.coords[0], localKeyPoint2.coords[1])));
      if (paramList == null) {
        return false;
      }
      if (paramMatchTemplateConfig.checkMethod == 1) {
        return matchAng(paramList, paramMatchTemplateConfig);
      }
      if (paramMatchTemplateConfig.checkMethod == 0)
      {
        boolean bool = matchDis(paramList, paramMatchTemplateConfig);
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
  
  private boolean matchAng(List<IVec3f> paramList, MatchTemplateConfig paramMatchTemplateConfig)
  {
    if ((paramList != null) && (paramMatchTemplateConfig != null) && (paramMatchTemplateConfig.keyPoints.size() != 0))
    {
      List localList1 = paramMatchTemplateConfig.keyVectors;
      List localList2 = paramMatchTemplateConfig.keyPoints;
      StringBuilder localStringBuilder = new StringBuilder();
      double d1 = 0.0D;
      int j = 0;
      int i = 1;
      for (;;)
      {
        Object localObject = paramList;
        if (j >= localList1.size()) {
          break;
        }
        MatchTemplateConfig.KeyVector localKeyVector = (MatchTemplateConfig.KeyVector)localList1.get(j);
        MatchTemplateConfig.KeyPoint localKeyPoint1 = findKeyPoint(localList2, localKeyVector.vectors[0]);
        MatchTemplateConfig.KeyPoint localKeyPoint2 = findKeyPoint(localList2, localKeyVector.vectors[1]);
        IVec3f localIVec3f = findIVec((List)localObject, localKeyVector.vectors[0]);
        localObject = findIVec((List)localObject, localKeyVector.vectors[1]);
        double d2 = calDegree(localKeyPoint2.coords[0] - localKeyPoint1.coords[0], localKeyPoint2.coords[1] - localKeyPoint1.coords[1], ((IVec3f)localObject).x - localIVec3f.x, ((IVec3f)localObject).y - localIVec3f.y);
        if (Double.isNaN(d2)) {
          i = 0;
        }
        float f = localKeyVector.weight;
        int k = i;
        double d3 = f;
        Double.isNaN(d3);
        d2 *= d3;
        i = k;
        if (localKeyVector.threshold != 0)
        {
          i = k;
          if (d2 > localKeyVector.threshold) {
            i = 0;
          }
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[");
        ((StringBuilder)localObject).append(localKeyVector.vectors[0]);
        ((StringBuilder)localObject).append(" , ");
        ((StringBuilder)localObject).append(localKeyVector.vectors[1]);
        ((StringBuilder)localObject).append(" ] : ");
        ((StringBuilder)localObject).append(d2);
        ((StringBuilder)localObject).append("\n");
        localStringBuilder.append(((StringBuilder)localObject).toString());
        d1 += d2;
        j += 1;
      }
      paramList = new StringBuilder();
      paramList.append("total : ");
      paramList.append(d1);
      localStringBuilder.append(paramList.toString());
      j = i;
      if (paramMatchTemplateConfig.degreeThreshold != 0.0F)
      {
        j = i;
        if (d1 > paramMatchTemplateConfig.degreeThreshold) {
          j = 0;
        }
      }
      paramList = this.uiHandler;
      if (paramList == null) {
        return j == 1;
      }
      paramList.removeMessages(0, null);
      paramList = this.uiHandler.obtainMessage();
      paramList.what = 1;
      paramList.obj = localStringBuilder.toString();
      this.uiHandler.sendMessage(paramList);
      paramList = this.uiHandler.obtainMessage();
      paramList.what = 2;
      paramList.arg1 = j;
      this.uiHandler.sendMessage(paramList);
      return j == 1;
    }
    return false;
  }
  
  private boolean matchDis(List<IVec3f> paramList, MatchTemplateConfig paramMatchTemplateConfig)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (paramList != null)
    {
      bool1 = bool3;
      if (paramMatchTemplateConfig != null)
      {
        if (paramMatchTemplateConfig.keyPoints.size() == 0) {
          return false;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        int j = 0;
        float f1 = 0.0F;
        int k;
        for (int i = 1; j < paramMatchTemplateConfig.keyPoints.size(); i = k)
        {
          Object localObject = (MatchTemplateConfig.KeyPoint)paramMatchTemplateConfig.keyPoints.get(j);
          float f2 = calDis(((IVec3f)paramList.get(j)).x, ((IVec3f)paramList.get(j)).y, ((MatchTemplateConfig.KeyPoint)paramMatchTemplateConfig.keyPoints.get(j)).coords[0], ((MatchTemplateConfig.KeyPoint)paramMatchTemplateConfig.keyPoints.get(j)).coords[1]) * ((MatchTemplateConfig.KeyPoint)localObject).weight;
          k = i;
          if (((MatchTemplateConfig.KeyPoint)localObject).threshold != 0.0F)
          {
            k = i;
            if (f2 > ((MatchTemplateConfig.KeyPoint)localObject).threshold) {
              k = 0;
            }
          }
          f1 += f2;
          if (f2 >= 1.0F)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(((MatchTemplateConfig.KeyPoint)paramMatchTemplateConfig.keyPoints.get(j)).index);
            ((StringBuilder)localObject).append(" : ");
            ((StringBuilder)localObject).append(f2);
            localStringBuilder.append(((StringBuilder)localObject).toString());
            localStringBuilder.append(System.getProperty("line.separator").toString());
          }
          j += 1;
        }
        paramList = new StringBuilder();
        paramList.append("total : ");
        paramList.append(f1);
        localStringBuilder.append(paramList.toString());
        MLog(localStringBuilder.toString());
        j = i;
        if (paramMatchTemplateConfig.distanceThreshold != 0.0F)
        {
          j = i;
          if (f1 > paramMatchTemplateConfig.distanceThreshold) {
            j = 0;
          }
        }
        paramList = this.uiHandler;
        if (paramList == null)
        {
          bool1 = bool2;
          if (j == 1) {
            bool1 = true;
          }
          return bool1;
        }
        paramList.removeMessages(0, null);
        paramList = this.uiHandler.obtainMessage();
        paramList.what = 1;
        paramList.obj = localStringBuilder.toString();
        this.uiHandler.sendMessage(paramList);
        paramList = this.uiHandler.obtainMessage();
        paramList.what = 2;
        paramList.arg1 = j;
        this.uiHandler.sendMessage(paramList);
        bool1 = bool3;
        if (j == 1) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public float calDis(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public List<IVec3f> convertPoints(List<IVec3f> paramList, int paramInt1, int paramInt2, Float paramFloat)
  {
    int j = 0;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i = 0;
    label427:
    label436:
    do
    {
      try
      {
        if (i >= paramList.size()) {
          break label436;
        }
        IVec3f localIVec3f = (IVec3f)paramList.get(i);
        if (localIVec3f.index == paramInt1) {
          localObject2 = localIVec3f;
        }
        if (localIVec3f.index != paramInt2) {
          break label427;
        }
        localObject1 = localIVec3f;
      }
      catch (Exception paramList)
      {
        float f2;
        float f1;
        double d2;
        double d1;
        paramList.printStackTrace();
        return null;
      }
      f2 = calDis(localObject2.x, localObject2.y, ((Vec3f)localObject1).x, ((Vec3f)localObject1).y);
      f1 = f2;
      if (paramFloat != null)
      {
        f1 = f2;
        if (paramFloat.floatValue() > 0.0F) {
          f1 = paramFloat.floatValue();
        }
      }
      f2 = calDis(localObject2.x, localObject2.y, ((Vec3f)localObject1).x, ((Vec3f)localObject1).y);
      if (f2 <= 0.0F) {
        return null;
      }
      f1 /= f2;
      paramFloat = new Matrix();
      paramFloat.setTranslate(-localObject2.x, -localObject2.y);
      d2 = Math.toDegrees(Math.acos((((Vec3f)localObject1).x - localObject2.x) / f2));
      d1 = d2;
      if (((Vec3f)localObject1).y - localObject2.y > 0.0F) {
        d1 = -d2;
      }
      paramFloat.postRotate((float)d1);
      paramFloat.postScale(f1, f1);
      localObject1 = new float[paramList.size() * 2];
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 < paramList.size())
        {
          paramInt2 = paramInt1 * 2;
          localObject1[paramInt2] = ((IVec3f)paramList.get(paramInt1)).x;
          localObject1[(paramInt2 + 1)] = ((IVec3f)paramList.get(paramInt1)).y;
          paramInt1 += 1;
        }
        else
        {
          paramFloat.mapPoints((float[])localObject1);
          paramFloat = new ArrayList();
          paramInt1 = j;
          for (;;)
          {
            if (paramInt1 < paramList.size())
            {
              paramInt2 = paramInt1 * 2;
              f1 = localObject1[paramInt2];
              f2 = localObject1[(paramInt2 + 1)];
              paramFloat.add(new IVec3f(((IVec3f)paramList.get(paramInt1)).index, f1, f2, 0.0F));
              paramInt1 += 1;
            }
            else
            {
              return paramFloat;
            }
          }
        }
      }
      while (localObject2 == null)
      {
        return null;
        i += 1;
        break;
      }
    } while (localObject1 != null);
    return null;
  }
  
  public MatchTemplateConfig generateConfig(List<IVec3f> paramList, int paramInt1, int paramInt2)
  {
    try
    {
      MatchTemplateConfig localMatchTemplateConfig = new MatchTemplateConfig();
      localMatchTemplateConfig.datumIndex0 = paramInt1;
      localMatchTemplateConfig.datumIndex1 = paramInt2;
      localMatchTemplateConfig.distanceThreshold = 100.0F;
      localMatchTemplateConfig.checkMethod = 0;
      try
      {
        List localList = convertPoints(paramList, paramInt1, paramInt2, Float.valueOf(100.0F));
        if ((localList != null) && (localList.size() != 0))
        {
          ArrayList localArrayList = new ArrayList();
          paramInt1 = 0;
          while (paramInt1 < paramList.size())
          {
            IVec3f localIVec3f = (IVec3f)localList.get(paramInt1);
            paramInt2 = localIVec3f.index;
            float f1;
            if (Math.abs(localIVec3f.x) < 0.1D) {
              f1 = 0.0F;
            } else {
              f1 = localIVec3f.x;
            }
            float f2;
            if (Math.abs(localIVec3f.y) < 0.1D) {
              f2 = 0.0F;
            } else {
              f2 = localIVec3f.y;
            }
            localArrayList.add(new MatchTemplateConfig.KeyPoint(paramInt2, 1.0F, 0.0F, new float[] { f1, f2 }));
            paramInt1 += 1;
          }
          localMatchTemplateConfig.keyPoints = localArrayList;
        }
        return localMatchTemplateConfig;
      }
      catch (Exception paramList) {}
      paramList.printStackTrace();
    }
    catch (Exception paramList) {}
    return null;
  }
  
  public boolean multiMatch(List<Vec3f> paramList, List<MatchTemplateConfig> paramList1, int paramInt)
  {
    int i = 0;
    while (i < paramList1.size())
    {
      MatchTemplateConfig localMatchTemplateConfig = (MatchTemplateConfig)paramList1.get(i);
      if ((localMatchTemplateConfig != null) && (match(paramList, localMatchTemplateConfig, paramInt))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.matchTemplate.MatchTemplate
 * JD-Core Version:    0.7.0.1
 */