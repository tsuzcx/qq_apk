package com.tencent.ttpic.util.youtu;

import android.graphics.PointF;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.model.VideoMaterial.EXPRESSION_TYPE;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class ExpressionDetectorObject
{
  private static final int FACE_QUEUE_MAX_SIZE = 30;
  private static final String TAG = "ExpressionDetectorObject";
  private boolean[] isLeftEyeClosed = new boolean[30];
  private boolean isLeftOccluded = false;
  private boolean[] isRightEyeClosed = new boolean[30];
  private boolean isRightOccluded = false;
  private boolean[] islipsOccluded = new boolean[30];
  private List<LinkedList<FaceInfo>> mFaceQueueList = new ArrayList();
  private List<LinkedList<Float>> mNodePitchQueueList = new ArrayList();
  private List<LinkedList<FaceInfo>> mShookQueueList = new ArrayList();
  
  private double calDistanceSquare(PointF paramPointF1, PointF paramPointF2)
  {
    return Math.pow(paramPointF1.x - paramPointF2.x, 2.0D) + Math.pow(paramPointF1.y - paramPointF2.y, 2.0D);
  }
  
  private double calcDistanceOfFeaturePoints(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return Math.sqrt(Math.pow(paramFloat1 - paramFloat3, 2.0D) + Math.pow(paramFloat2 - paramFloat4, 2.0D));
  }
  
  private <T> void checkList(List<LinkedList<T>> paramList, int paramInt, T paramT)
  {
    if (paramInt == paramList.size()) {
      paramList.add(new LinkedList());
    }
    paramList = (LinkedList)paramList.get(paramInt);
    if (paramList.size() > 30) {
      paramList.removeLast();
    }
    paramList.addFirst(paramT);
  }
  
  private void clearFaceQueue(int paramInt)
  {
    if (paramInt < this.mFaceQueueList.size()) {
      while (((LinkedList)this.mFaceQueueList.get(paramInt)).size() > 1) {
        ((LinkedList)this.mFaceQueueList.get(paramInt)).removeLast();
      }
    }
  }
  
  private <T> void clearQueue(List<LinkedList<T>> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      LinkedList localLinkedList = (LinkedList)paramList.next();
      while (localLinkedList.size() > 1) {
        localLinkedList.removeLast();
      }
    }
  }
  
  private boolean isExpressionDistanceChangeDetected(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if (isExpressionDistanceChangeDetected(i, paramInt1, paramInt2)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean isExpressionDistanceChangeDetected(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 >= 0)
    {
      bool1 = bool2;
      if (paramInt1 < this.mFaceQueueList.size())
      {
        if (((LinkedList)this.mFaceQueueList.get(paramInt1)).isEmpty()) {
          return false;
        }
        Object localObject = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt1)).getFirst();
        double d = calDistanceSquare((PointF)((FaceInfo)localObject).points.get(paramInt2), (PointF)((FaceInfo)localObject).points.get(paramInt3));
        localObject = ((LinkedList)this.mFaceQueueList.get(paramInt1)).iterator();
        FaceInfo localFaceInfo;
        do
        {
          bool1 = bool2;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localFaceInfo = (FaceInfo)((Iterator)localObject).next();
        } while (d / calDistanceSquare((PointF)localFaceInfo.points.get(paramInt2), (PointF)localFaceInfo.points.get(paramInt3)) >= 0.5D);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean isExpressionDoubleEyesOcculudedDetected()
  {
    return (this.isLeftOccluded) && (this.isRightOccluded);
  }
  
  private boolean isExpressionJumpEyebrowDetected()
  {
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if (isExpressionJumpEyebrowDetected(i)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean isExpressionJumpEyebrowDetected(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramInt < this.mFaceQueueList.size())
      {
        if (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty()) {
          return false;
        }
        Object localObject = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst();
        double d1 = AlgoUtils.getDistance((PointF)((FaceInfo)localObject).points.get(26), (PointF)((FaceInfo)localObject).points.get(64)) / AlgoUtils.getDistance((PointF)((FaceInfo)localObject).points.get(24), (PointF)((FaceInfo)localObject).points.get(64));
        localObject = ((LinkedList)this.mFaceQueueList.get(paramInt)).listIterator();
        ((ListIterator)localObject).next();
        double d2;
        double d3;
        do
        {
          FaceInfo localFaceInfo;
          do
          {
            bool1 = bool2;
            if (!((ListIterator)localObject).hasNext()) {
              break;
            }
            localFaceInfo = (FaceInfo)((ListIterator)localObject).next();
          } while ((localFaceInfo == null) || (localFaceInfo.points == null) || (localFaceInfo.points.size() < 90));
          d2 = AlgoUtils.getDistance((PointF)localFaceInfo.points.get(26), (PointF)localFaceInfo.points.get(64));
          d3 = AlgoUtils.getDistance((PointF)localFaceInfo.points.get(24), (PointF)localFaceInfo.points.get(64));
          Double.isNaN(d1);
          Double.isNaN(d2);
          Double.isNaN(d3);
        } while (1.04D * d1 > d2 / d3);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean isExpressionJumpEyebrowDetectedForAtLeastOneFace()
  {
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if (isExpressionJumpEyebrowDetected(i)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean isExpressionKissDetected()
  {
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if (isExpressionKissDetected(i)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean isExpressionKissDetected(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramInt < this.mFaceQueueList.size())
      {
        if (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty()) {
          return false;
        }
        FaceInfo localFaceInfo = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst();
        float f1;
        if ((localFaceInfo != null) && (localFaceInfo.expressionWeights != null)) {
          f1 = localFaceInfo.expressionWeights[31];
        } else {
          f1 = 0.0F;
        }
        Float[] arrayOfFloat = new Float[25];
        arrayOfFloat[0] = localFaceInfo.pointsVis[3];
        arrayOfFloat[1] = localFaceInfo.pointsVis[4];
        arrayOfFloat[2] = localFaceInfo.pointsVis[5];
        arrayOfFloat[3] = localFaceInfo.pointsVis[6];
        arrayOfFloat[4] = localFaceInfo.pointsVis[7];
        arrayOfFloat[5] = localFaceInfo.pointsVis[8];
        arrayOfFloat[6] = localFaceInfo.pointsVis[9];
        arrayOfFloat[7] = localFaceInfo.pointsVis[10];
        arrayOfFloat[8] = localFaceInfo.pointsVis[11];
        arrayOfFloat[9] = localFaceInfo.pointsVis[12];
        arrayOfFloat[10] = localFaceInfo.pointsVis[13];
        arrayOfFloat[11] = localFaceInfo.pointsVis[14];
        arrayOfFloat[12] = localFaceInfo.pointsVis[15];
        arrayOfFloat[13] = localFaceInfo.pointsVis[65];
        arrayOfFloat[14] = localFaceInfo.pointsVis[66];
        arrayOfFloat[15] = localFaceInfo.pointsVis[67];
        arrayOfFloat[16] = localFaceInfo.pointsVis[68];
        arrayOfFloat[17] = localFaceInfo.pointsVis[69];
        arrayOfFloat[18] = localFaceInfo.pointsVis[70];
        arrayOfFloat[19] = localFaceInfo.pointsVis[71];
        arrayOfFloat[20] = localFaceInfo.pointsVis[75];
        arrayOfFloat[21] = localFaceInfo.pointsVis[76];
        arrayOfFloat[22] = localFaceInfo.pointsVis[77];
        arrayOfFloat[23] = localFaceInfo.pointsVis[78];
        arrayOfFloat[24] = localFaceInfo.pointsVis[79];
        int i = arrayOfFloat.length;
        paramInt = 0;
        float f2 = 0.0F;
        while (paramInt < i)
        {
          f2 += arrayOfFloat[paramInt].floatValue();
          paramInt += 1;
        }
        f2 /= arrayOfFloat.length;
        if (f2 == 0.0F) {
          return false;
        }
        if (f1 <= 0.36F / f2)
        {
          bool1 = bool2;
          if (f1 <= 0.54F) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean isExpressionLeftEyeOccludedDetected()
  {
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if (isExpressionLeftEyeOccludedDetected(i))
      {
        this.isLeftOccluded = true;
        return true;
      }
      i += 1;
    }
    this.isLeftOccluded = false;
    return false;
  }
  
  private boolean isExpressionLeftEyeOccludedDetected(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mFaceQueueList.size()))
    {
      if (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty()) {
        return false;
      }
      Object localObject = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst();
      float f = 0.0F;
      int i = 35;
      while (i < 44)
      {
        f += localObject.pointsVis[i].floatValue();
        i += 1;
      }
      localObject = this.isLeftEyeClosed;
      if ((localObject != null) && (localObject.length > paramInt))
      {
        if (f / 9.0F < 0.5D)
        {
          localObject[paramInt] = 1;
          return true;
        }
        if (localObject[paramInt] != 0)
        {
          localObject[paramInt] = 0;
          return true;
        }
      }
      return false;
    }
    return false;
  }
  
  private boolean isExpressionLeftEyeWinkDetected()
  {
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if (isExpressionDistanceChangeDetected(i, 37, 41)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean isExpressionMouthOccludedDetected()
  {
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if (isExpressionMouthOccludedDetected(i)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean isExpressionMouthOccludedDetected(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.mFaceQueueList.size()))
    {
      if (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty()) {
        return false;
      }
      Object localObject = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst();
      float f = 0.0F;
      int i = 65;
      while (i < 72)
      {
        f += localObject.pointsVis[i].floatValue();
        i += 1;
      }
      i = 75;
      while (i < 80)
      {
        f += localObject.pointsVis[i].floatValue();
        i += 1;
      }
      if (f / 12.0F < 0.5D)
      {
        localObject = this.islipsOccluded;
        if (paramInt < localObject.length)
        {
          localObject[paramInt] = 1;
          return true;
        }
      }
      else
      {
        localObject = this.islipsOccluded;
        if ((paramInt < localObject.length) && (localObject[paramInt] != 0))
        {
          localObject[paramInt] = 0;
          return true;
        }
      }
      return false;
    }
    return false;
  }
  
  private boolean isExpressionNodDetected()
  {
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if (isExpressionNodDetectedOptim(i)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean isExpressionNodDetected(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramInt < this.mFaceQueueList.size())
      {
        if (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty()) {
          return false;
        }
        float f1 = 100.0F;
        double d = ((FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst()).angles[0] * 180.0F;
        Double.isNaN(d);
        float f3 = (float)(d / 3.141592653589793D);
        Iterator localIterator = ((LinkedList)this.mFaceQueueList.get(paramInt)).iterator();
        float f2;
        do
        {
          bool1 = bool2;
          if (!localIterator.hasNext()) {
            break;
          }
          d = ((FaceInfo)localIterator.next()).angles[0] * 180.0F;
          Double.isNaN(d);
          f2 = Math.min(f1, (float)(d / 3.141592653589793D));
          f1 = f2;
        } while (f3 - f2 <= 7.0F);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean isExpressionNodDetectedOptim(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramInt < this.mNodePitchQueueList.size())
      {
        if (((LinkedList)this.mNodePitchQueueList.get(paramInt)).isEmpty()) {
          return false;
        }
        LinkedList localLinkedList = (LinkedList)this.mNodePitchQueueList.get(paramInt);
        double d = ((Float)localLinkedList.getFirst()).floatValue() * 180.0F;
        Double.isNaN(d);
        float f3 = (float)(d / 3.141592653589793D);
        paramInt = 1;
        float f6 = 100.0F;
        float f2 = 0.0F;
        float f5;
        for (float f1 = 0.0F; paramInt < localLinkedList.size(); f1 = f5)
        {
          d = ((Float)localLinkedList.get(paramInt)).floatValue() * 180.0F;
          Double.isNaN(d);
          float f7 = (float)(d / 3.141592653589793D);
          f6 = Math.min(f6, f7);
          float f4;
          if (f7 > f3)
          {
            if (f2 > 8.0F) {
              break;
            }
            f4 = f2 + (f7 - f3);
            f5 = f1;
          }
          else
          {
            f4 = f2;
            f5 = f1;
            if (f7 < f3)
            {
              if (f2 > 0.001F) {
                break;
              }
              f5 = f1 + (f3 - f7);
              f4 = f2;
            }
          }
          paramInt += 1;
          f3 = f7;
          f2 = f4;
        }
        bool1 = bool2;
        if (f2 > 3.0F)
        {
          bool1 = bool2;
          if (f1 > 2.0F)
          {
            bool1 = bool2;
            if (f2 + f1 > 20.0F)
            {
              clearQueue(this.mNodePitchQueueList);
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean isExpressionOpenMouthDetected()
  {
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if (isExpressionOpenMouthDetected(i)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean isExpressionOpenMouthDetected(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramInt < this.mFaceQueueList.size())
      {
        if (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty()) {
          return false;
        }
        FaceInfo localFaceInfo = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst();
        double d1 = AlgoUtils.getDistance((PointF)localFaceInfo.points.get(65), (PointF)localFaceInfo.points.get(66));
        double d2 = AlgoUtils.getDistance((PointF)localFaceInfo.points.get(73), (PointF)localFaceInfo.points.get(81));
        Double.isNaN(d1);
        bool1 = bool2;
        if (d2 > d1 * 0.2D) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean isExpressionOpenMouthDetectedForAtLeastOneFace()
  {
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if (isExpressionOpenMouthDetected(i)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean isExpressionRightEyeOccludedDetected()
  {
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if (isExpressionRightEyeOccludedDetected(i))
      {
        this.isRightOccluded = true;
        return true;
      }
      i += 1;
    }
    this.isRightOccluded = false;
    return false;
  }
  
  private boolean isExpressionRightEyeOccludedDetected(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mFaceQueueList.size()))
    {
      if (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty()) {
        return false;
      }
      Object localObject = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst();
      float f = 0.0F;
      int i = 45;
      while (i < 54)
      {
        f += localObject.pointsVis[i].floatValue();
        i += 1;
      }
      localObject = this.isRightEyeClosed;
      if ((localObject != null) && (localObject.length > paramInt))
      {
        if (f / 9.0F < 0.5D)
        {
          localObject[paramInt] = 1;
          return true;
        }
        if (localObject[paramInt] != 0)
        {
          localObject[paramInt] = 0;
          return true;
        }
      }
      return false;
    }
    return false;
  }
  
  private boolean isExpressionRightEyeWinkDetected()
  {
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if (isExpressionDistanceChangeDetected(i, 47, 51)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean isExpressionShakeHeadDetected()
  {
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if (isExpressionShakeHeadDetected(i)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean isExpressionShakeHeadDetected(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramInt < this.mFaceQueueList.size())
      {
        if (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty()) {
          return false;
        }
        float f2 = 100.0F;
        float f1 = -100.0F;
        Iterator localIterator = ((LinkedList)this.mFaceQueueList.get(paramInt)).iterator();
        float f4;
        float f3;
        do
        {
          bool1 = bool2;
          if (!localIterator.hasNext()) {
            break;
          }
          double d = ((FaceInfo)localIterator.next()).angles[1] * 180.0F;
          Double.isNaN(d);
          f4 = (float)(d / 3.141592653589793D);
          f3 = Math.min(f2, f4);
          f4 = Math.max(f1, f4);
          f2 = f3;
          f1 = f4;
        } while (f4 - f3 <= 7.0F);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean isExpressionShookHeadDetected()
  {
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if (isExpressionShookHeadDetected(i)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean isExpressionShookHeadDetected(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramInt < this.mFaceQueueList.size())
      {
        if (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty()) {
          return false;
        }
        Object localObject = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst();
        bool1 = bool2;
        if (((LinkedList)this.mFaceQueueList.get(paramInt)).size() > 1)
        {
          bool1 = bool2;
          if (AlgoUtils.getDistance((PointF)((FaceInfo)localObject).points.get(2), (PointF)((FaceInfo)localObject).points.get(64)) * 0.7F > AlgoUtils.getDistance((PointF)((FaceInfo)localObject).points.get(64), (PointF)((FaceInfo)localObject).points.get(16)))
          {
            localObject = ((LinkedList)this.mFaceQueueList.get(paramInt)).listIterator();
            ((ListIterator)localObject).next();
            FaceInfo localFaceInfo;
            do
            {
              bool1 = bool2;
              if (!((ListIterator)localObject).hasNext()) {
                break;
              }
              localFaceInfo = (FaceInfo)((ListIterator)localObject).next();
            } while (AlgoUtils.getDistance((PointF)localFaceInfo.points.get(64), (PointF)localFaceInfo.points.get(16)) * 0.7F <= AlgoUtils.getDistance((PointF)localFaceInfo.points.get(2), (PointF)localFaceInfo.points.get(64)));
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean isFaceDetected()
  {
    return this.mFaceQueueList.isEmpty() ^ true;
  }
  
  public static boolean needSaveDetectedExpression(int paramInt)
  {
    return (paramInt == VideoMaterial.EXPRESSION_TYPE.JUMP_EYE_BROW.value) || (paramInt == VideoMaterial.EXPRESSION_TYPE.WINK.value) || (paramInt == VideoMaterial.EXPRESSION_TYPE.SHOOK_HEAD.value) || (paramInt == VideoMaterial.EXPRESSION_TYPE.RIGHT_EYE_WINK.value) || (paramInt == VideoMaterial.EXPRESSION_TYPE.LEFT_EYE_WINK.value) || (paramInt == VideoMaterial.EXPRESSION_TYPE.NOD.value) || (paramInt == VideoMaterial.EXPRESSION_TYPE.SHAKE_HEAD.value);
  }
  
  private float pointPairToBearingDegrees(PointF paramPointF1, PointF paramPointF2)
  {
    paramPointF1 = new PointF(paramPointF2.x - paramPointF1.x, paramPointF2.y - paramPointF1.y);
    double d = (float)Math.atan2(paramPointF1.y, paramPointF1.x);
    Double.isNaN(d);
    float f = (float)(d * 57.295779513082323D);
    if (f > 0.0F) {
      return f;
    }
    return f + 360.0F;
  }
  
  private PointF pointSub(PointF paramPointF1, PointF paramPointF2)
  {
    return new PointF(paramPointF1.x - paramPointF2.x, paramPointF1.y - paramPointF2.y);
  }
  
  private void updateExpressionDoubleEyesOcculudedDetected(List<Set<Integer>> paramList)
  {
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      Set localSet = (Set)paramList.get(i);
      if ((localSet != null) && (localSet.contains(Integer.valueOf(PTFaceAttr.PTExpression.RIGHT_EYE_OCCLUDED.value))) && (localSet.contains(Integer.valueOf(PTFaceAttr.PTExpression.LEFT_EYE_OCCLUDED.value)))) {
        localSet.add(Integer.valueOf(PTFaceAttr.PTExpression.DOUBLE_EYE_OCCLUDED.value));
      }
      i += 1;
    }
  }
  
  private void updateExpressionKissDetected(List<Set<Integer>> paramList)
  {
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if ((isExpressionKissDetected(i)) && (paramList.get(i) != null)) {
        ((Set)paramList.get(i)).add(Integer.valueOf(PTFaceAttr.PTExpression.KISS.value));
      }
      i += 1;
    }
  }
  
  private void updateExpressionLeftEyeOccludedDetected(List<Set<Integer>> paramList)
  {
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if ((isExpressionLeftEyeOccludedDetected(i)) && (paramList.get(i) != null)) {
        ((Set)paramList.get(i)).add(Integer.valueOf(PTFaceAttr.PTExpression.LEFT_EYE_OCCLUDED.value));
      }
      i += 1;
    }
  }
  
  private void updateExpressionMouthOccludedDetected(List<Set<Integer>> paramList)
  {
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if ((isExpressionMouthOccludedDetected(i)) && (paramList.get(i) != null)) {
        ((Set)paramList.get(i)).add(Integer.valueOf(PTFaceAttr.PTExpression.MOUTH_OCCLUDED.value));
      }
      i += 1;
    }
  }
  
  private void updateExpressionOpenMouthDetected(List<Set<Integer>> paramList)
  {
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if ((isExpressionOpenMouthDetected(i)) && (paramList.get(i) != null)) {
        ((Set)paramList.get(i)).add(Integer.valueOf(PTFaceAttr.PTExpression.MOUTH_OPEN.value));
      }
      i += 1;
    }
  }
  
  private void updateExpressionRightEyeOccludedDetected(List<Set<Integer>> paramList)
  {
    int i = 0;
    while (i < this.mFaceQueueList.size())
    {
      if ((isExpressionRightEyeOccludedDetected(i)) && (paramList.get(i) != null)) {
        ((Set)paramList.get(i)).add(Integer.valueOf(PTFaceAttr.PTExpression.RIGHT_EYE_OCCLUDED.value));
      }
      i += 1;
    }
  }
  
  public void addFaces(List<FaceInfo> paramList)
  {
    if (paramList == null)
    {
      this.mFaceQueueList.clear();
      this.mNodePitchQueueList.clear();
      return;
    }
    if (paramList.size() != this.mFaceQueueList.size()) {
      this.mFaceQueueList.clear();
    }
    if (paramList.size() != this.mNodePitchQueueList.size()) {
      this.mNodePitchQueueList.clear();
    }
    int i = 0;
    while (i < paramList.size())
    {
      FaceInfo localFaceInfo = (FaceInfo)paramList.get(i);
      checkList(this.mFaceQueueList, i, localFaceInfo);
      if ((localFaceInfo != null) && (localFaceInfo.angles != null) && (localFaceInfo.angles.length > 1)) {
        checkList(this.mNodePitchQueueList, i, Float.valueOf(localFaceInfo.angles[0]));
      }
      i += 1;
    }
    addShookFaces(paramList);
  }
  
  public void addShookFaces(List<FaceInfo> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if (i == this.mShookQueueList.size()) {
        this.mShookQueueList.add(new LinkedList());
      }
      LinkedList localLinkedList = (LinkedList)this.mShookQueueList.get(i);
      if (localLinkedList.size() > 40) {
        localLinkedList.removeLast();
      }
      localLinkedList.addFirst(paramList.get(i));
      i += 1;
    }
  }
  
  public void clearFaceQueue()
  {
    clearQueue(this.mFaceQueueList);
  }
  
  public void detectAllFaceExpression(List<Set<Integer>> paramList, int paramInt)
  {
    if (paramInt != 3)
    {
      if (paramInt != 7)
      {
        switch (paramInt)
        {
        default: 
          return;
        case 18: 
          updateExpressionDoubleEyesOcculudedDetected(paramList);
          return;
        case 17: 
          updateExpressionRightEyeOccludedDetected(paramList);
          return;
        case 16: 
          updateExpressionLeftEyeOccludedDetected(paramList);
          return;
        }
        updateExpressionMouthOccludedDetected(paramList);
        return;
      }
      updateExpressionKissDetected(paramList);
      return;
    }
    updateExpressionOpenMouthDetected(paramList);
  }
  
  public boolean detectExpression(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 103)
    {
      if (paramInt != 104)
      {
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              return false;
            case 110: 
              return (isFaceDetected()) && (!isExpressionNodDetected());
            case 109: 
              return (isFaceDetected()) && (!isExpressionRightEyeWinkDetected());
            case 108: 
              return (isFaceDetected()) && (!isExpressionRightEyeWinkDetected());
            case 107: 
              return (isFaceDetected()) && (!isExpressionKissDetected());
            }
            return (isFaceDetected()) && (!isExpressionShookHeadDetected());
          case 18: 
            return isExpressionDoubleEyesOcculudedDetected();
          case 17: 
            return isExpressionRightEyeOccludedDetected();
          case 16: 
            return isExpressionLeftEyeOccludedDetected();
          }
          return isExpressionMouthOccludedDetected();
        case 10: 
          return isExpressionNodDetected();
        case 9: 
          return isExpressionRightEyeWinkDetected();
        case 8: 
          return isExpressionLeftEyeWinkDetected();
        case 7: 
          return isExpressionKissDetected();
        case 6: 
          return isExpressionShakeHeadDetected();
        case 5: 
          if (!isExpressionRightEyeWinkDetected())
          {
            if (isExpressionLeftEyeWinkDetected()) {
              return true;
            }
            bool = false;
          }
          return bool;
        case 4: 
          return isExpressionJumpEyebrowDetected();
        case 3: 
          return isExpressionOpenMouthDetected();
        case 2: 
          return isFaceDetected();
        }
        return true;
      }
      return (isFaceDetected()) && (!isExpressionJumpEyebrowDetected());
    }
    return (isFaceDetected()) && (!isExpressionOpenMouthDetected());
  }
  
  public List<LinkedList<FaceInfo>> getShookFaceInfos()
  {
    return this.mShookQueueList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.ExpressionDetectorObject
 * JD-Core Version:    0.7.0.1
 */