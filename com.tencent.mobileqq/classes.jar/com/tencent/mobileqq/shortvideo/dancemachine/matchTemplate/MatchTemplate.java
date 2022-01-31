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
    if ((f1 == 0.0F) || (f2 == 0.0F)) {
      return (0.0D / 0.0D);
    }
    return Math.toDegrees(Math.acos((paramFloat1 * paramFloat3 + paramFloat2 * paramFloat4) / (f1 * f2)));
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
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new MatchTemplate();
      }
      return instance;
    }
    finally {}
  }
  
  private void logLocalPoints(String paramString, List<IVec3f> paramList)
  {
    paramString = new StringBuilder(paramString);
    int i = 0;
    while (i < paramList.size())
    {
      paramString.append(((IVec3f)paramList.get(i)).toString() + "        ");
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
    if ((paramList == null) || (paramMatchTemplateConfig == null) || (paramMatchTemplateConfig.keyPoints.size() == 0)) {
      return false;
    }
    List localList1 = paramMatchTemplateConfig.keyVectors;
    List localList2 = paramMatchTemplateConfig.keyPoints;
    StringBuilder localStringBuilder = new StringBuilder();
    double d1 = 0.0D;
    int i = 1;
    int k = 0;
    while (k < localList1.size())
    {
      MatchTemplateConfig.KeyVector localKeyVector = (MatchTemplateConfig.KeyVector)localList1.get(k);
      MatchTemplateConfig.KeyPoint localKeyPoint1 = findKeyPoint(localList2, localKeyVector.vectors[0]);
      MatchTemplateConfig.KeyPoint localKeyPoint2 = findKeyPoint(localList2, localKeyVector.vectors[1]);
      IVec3f localIVec3f1 = findIVec(paramList, localKeyVector.vectors[0]);
      IVec3f localIVec3f2 = findIVec(paramList, localKeyVector.vectors[1]);
      double d2 = calDegree(localKeyPoint2.coords[0] - localKeyPoint1.coords[0], localKeyPoint2.coords[1] - localKeyPoint1.coords[1], localIVec3f2.x - localIVec3f1.x, localIVec3f2.y - localIVec3f1.y);
      j = i;
      if (Double.isNaN(d2)) {
        j = 0;
      }
      d2 *= localKeyVector.weight;
      i = j;
      if (localKeyVector.threshold != 0)
      {
        i = j;
        if (d2 > localKeyVector.threshold) {
          i = 0;
        }
      }
      localStringBuilder.append("[" + localKeyVector.vectors[0] + " , " + localKeyVector.vectors[1] + " ] : " + d2 + "\n");
      d1 += d2;
      k += 1;
    }
    localStringBuilder.append("total : " + d1);
    int j = i;
    if (paramMatchTemplateConfig.degreeThreshold != 0.0F)
    {
      j = i;
      if (d1 > paramMatchTemplateConfig.degreeThreshold) {
        j = 0;
      }
    }
    if (this.uiHandler == null) {
      return j == 1;
    }
    this.uiHandler.removeMessages(0, null);
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
  
  private boolean matchDis(List<IVec3f> paramList, MatchTemplateConfig paramMatchTemplateConfig)
  {
    boolean bool = true;
    if ((paramList == null) || (paramMatchTemplateConfig == null) || (paramMatchTemplateConfig.keyPoints.size() == 0))
    {
      bool = false;
      return bool;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    int i = 1;
    float f1 = 0.0F;
    float f2;
    if (j < paramMatchTemplateConfig.keyPoints.size())
    {
      MatchTemplateConfig.KeyPoint localKeyPoint = (MatchTemplateConfig.KeyPoint)paramMatchTemplateConfig.keyPoints.get(j);
      f2 = calDis(((IVec3f)paramList.get(j)).x, ((IVec3f)paramList.get(j)).y, ((MatchTemplateConfig.KeyPoint)paramMatchTemplateConfig.keyPoints.get(j)).coords[0], ((MatchTemplateConfig.KeyPoint)paramMatchTemplateConfig.keyPoints.get(j)).coords[1]);
      f2 = localKeyPoint.weight * f2;
      if ((localKeyPoint.threshold == 0.0F) || (f2 <= localKeyPoint.threshold)) {
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
        localStringBuilder.append(((MatchTemplateConfig.KeyPoint)paramMatchTemplateConfig.keyPoints.get(j)).index + " : " + f2);
        localStringBuilder.append(System.getProperty("line.separator").toString());
      }
      localStringBuilder.append("total : " + f1);
      MLog(localStringBuilder.toString());
      j = i;
      if (paramMatchTemplateConfig.distanceThreshold != 0.0F)
      {
        j = i;
        if (f1 > paramMatchTemplateConfig.distanceThreshold) {
          j = 0;
        }
      }
      if (this.uiHandler == null)
      {
        if (j == 1) {
          break;
        }
        return false;
      }
      this.uiHandler.removeMessages(0, null);
      paramList = this.uiHandler.obtainMessage();
      paramList.what = 1;
      paramList.obj = localStringBuilder.toString();
      this.uiHandler.sendMessage(paramList);
      paramList = this.uiHandler.obtainMessage();
      paramList.what = 2;
      paramList.arg1 = j;
      this.uiHandler.sendMessage(paramList);
      if (j == 1) {
        break;
      }
      return false;
    }
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
          if (localIVec3f.index != paramInt1) {
            break label426;
          }
          localObject2 = localIVec3f;
          if (localIVec3f.index != paramInt2) {
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
        d = Math.toDegrees(Math.acos((((Vec3f)localObject1).x - localObject2.x) / f2));
        if (((Vec3f)localObject1).y - localObject2.y > 0.0F)
        {
          d = -d;
          paramFloat.postRotate((float)d);
          paramFloat.postScale(f1, f1);
          localObject1 = new float[paramList.size() * 2];
          paramInt1 = 0;
          if (paramInt1 < paramList.size())
          {
            localObject1[(paramInt1 * 2)] = ((IVec3f)paramList.get(paramInt1)).x;
            localObject1[(paramInt1 * 2 + 1)] = ((IVec3f)paramList.get(paramInt1)).y;
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
            paramFloat.add(new IVec3f(((IVec3f)paramList.get(paramInt1)).index, f1, f2, 0.0F));
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
  
  public MatchTemplateConfig generateConfig(List<IVec3f> paramList, int paramInt1, int paramInt2)
  {
    try
    {
      MatchTemplateConfig localMatchTemplateConfig = new MatchTemplateConfig();
      localMatchTemplateConfig.datumIndex0 = paramInt1;
      localMatchTemplateConfig.datumIndex1 = paramInt2;
      localMatchTemplateConfig.distanceThreshold = 100.0F;
      localMatchTemplateConfig.checkMethod = 0;
      List localList = convertPoints(paramList, paramInt1, paramInt2, Float.valueOf(100.0F));
      if ((localList != null) && (localList.size() != 0))
      {
        ArrayList localArrayList = new ArrayList();
        paramInt1 = 0;
        if (paramInt1 < paramList.size())
        {
          IVec3f localIVec3f = (IVec3f)localList.get(paramInt1);
          paramInt2 = localIVec3f.index;
          float f1;
          if (Math.abs(localIVec3f.x) < 0.1D)
          {
            f1 = 0.0F;
            label124:
            if (Math.abs(localIVec3f.y) >= 0.1D) {
              break label191;
            }
          }
          label191:
          for (float f2 = 0.0F;; f2 = localIVec3f.y)
          {
            localArrayList.add(new MatchTemplateConfig.KeyPoint(paramInt2, 1.0F, 0.0F, new float[] { f1, f2 }));
            paramInt1 += 1;
            break;
            f1 = localIVec3f.x;
            break label124;
          }
        }
        localMatchTemplateConfig.keyPoints = localArrayList;
      }
      return localMatchTemplateConfig;
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
    }
    return null;
  }
  
  public boolean multiMatch(List<Vec3f> paramList, List<MatchTemplateConfig> paramList1, int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramList1.size())
      {
        MatchTemplateConfig localMatchTemplateConfig = (MatchTemplateConfig)paramList1.get(i);
        if ((localMatchTemplateConfig != null) && (match(paramList, localMatchTemplateConfig, paramInt))) {
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