package com.tencent.ttpic.openapi.util;

import android.graphics.PointF;
import android.util.Log;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.model.StickerItem.TriggerArea;
import com.tencent.ttpic.util.youtu.bodydetector.BodyDetectResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.light.device.LightDeviceUtils;

public class TriggerUtil
{
  public static final int ABSOLUTE_LOCATION = 1;
  public static final int BODY_LOCATION = 5;
  public static final int FACE_LOCATION = 2;
  private static final float HAND_LABEL_FINGER_CONF_VALUE = 0.0F;
  
  private static float calAngle(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    float f1 = paramPointF2.x - paramPointF1.x;
    float f2 = paramPointF2.y - paramPointF1.y;
    float f3 = paramPointF3.x - paramPointF1.x;
    float f4 = paramPointF3.y - paramPointF1.y;
    float f5 = (f1 * f1 + f2 * f2) * (f3 * f3 + f4 * f4);
    if (f5 == 0.0F) {
      return 0.0F;
    }
    double d1 = f1 * f3 + f2 * f4;
    double d2 = Math.sqrt(f5);
    Double.isNaN(d1);
    d1 = (float)(d1 / d2);
    if (d1 >= 1.0D) {
      return 0.0F;
    }
    if (d1 <= -1.0D) {
      return 180.0F;
    }
    f2 = (float)Math.acos(d1) / 3.141593F * 180.0F;
    f1 = f2;
    if (f2 > 180.0D) {
      f1 = 360.0F - f2;
    }
    return f1;
  }
  
  private static boolean hasOverlay(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramPointF1 != null)
    {
      bool1 = bool2;
      if (paramPointF2 != null)
      {
        bool1 = bool2;
        if (paramPointF3 != null)
        {
          if (paramPointF4 == null) {
            return false;
          }
          int i;
          if (Math.max(paramPointF1.x, paramPointF3.x) <= Math.min(paramPointF2.x, paramPointF4.x)) {
            i = 1;
          } else {
            i = 0;
          }
          int j;
          if (Math.max(paramPointF1.y, paramPointF3.y) <= Math.min(paramPointF2.y, paramPointF4.y)) {
            j = 1;
          } else {
            j = 0;
          }
          bool1 = bool2;
          if (i != 0)
          {
            bool1 = bool2;
            if (j != 0) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private static boolean isAllFingerTriggered(List<PointF> paramList, float paramFloat)
  {
    int i = 1;
    while (i <= 5)
    {
      if (isSingleFingerTriggered(i, paramList, paramFloat)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static boolean isFinger4Point(float paramFloat, int paramInt, PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4)
  {
    if (paramFloat >= 0.0F)
    {
      float f1 = calAngle(paramPointF1, paramPointF2, paramPointF3);
      float f4 = calAngle(paramPointF1, paramPointF3, paramPointF4);
      float f3 = calAngle(paramPointF2, paramPointF3, paramPointF4);
      float f2 = calAngle(paramPointF1, paramPointF2, paramPointF4);
      if (0.0F >= f1) {
        f1 = 0.0F;
      }
      paramFloat = f1;
      if (f1 < f4) {
        paramFloat = f4;
      }
      f1 = paramFloat;
      if (paramFloat < f3) {
        f1 = f3;
      }
      paramFloat = f1;
      if (f1 < f2) {
        paramFloat = f2;
      }
      if ((paramInt == 2) && (paramFloat > 10.0F)) {
        return true;
      }
      return paramFloat > 20.0F;
    }
    return false;
  }
  
  private static boolean isFingerTriggerd(int paramInt, PTHandAttr paramPTHandAttr)
  {
    if ((paramPTHandAttr != null) && (paramPTHandAttr.getHandPointList() != null))
    {
      if (paramPTHandAttr.getHandPointList().size() == 0) {
        return false;
      }
      if (!isHandBoxValid(paramPTHandAttr)) {
        return false;
      }
      if (!isHandBoxLeftOutOfRange(paramPTHandAttr))
      {
        if (isHandBoxRightOutOfRange(paramPTHandAttr)) {
          return false;
        }
        if (paramInt == 0) {
          return isAllFingerTriggered(paramPTHandAttr.getHandPointList(), paramPTHandAttr.getConfidence());
        }
        if ((paramInt > 0) && (paramInt <= 5)) {
          return isSingleFingerTriggered(paramInt, paramPTHandAttr.getHandPointList(), paramPTHandAttr.getConfidence());
        }
      }
    }
    return false;
  }
  
  public static boolean isGestureTriggered(PTHandAttr paramPTHandAttr, int paramInt)
  {
    return isGestureTriggered(paramPTHandAttr, paramInt, 0, 0, null, null);
  }
  
  public static boolean isGestureTriggered(PTHandAttr paramPTHandAttr, int paramInt1, int paramInt2, int paramInt3, ArrayList<StickerItem.TriggerArea> paramArrayList, AIAttr paramAIAttr)
  {
    if (paramPTHandAttr == null) {
      return false;
    }
    int i;
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (!isHotAreaTriggered(paramAIAttr, paramInt2, paramArrayList))) {
      return false;
    }
    if (paramInt1 == 220) {
      return isFingerTriggerd(paramInt3, paramPTHandAttr);
    }
    return ((200 <= paramInt1) && (paramInt1 <= 214) && (paramPTHandAttr.getHandType() == paramInt1)) || ((paramPTHandAttr.getHandPointList() != null) && (paramPTHandAttr.getHandPointList().size() != 0) && (paramInt1 == 200)) || (paramInt1 == PTFaceAttr.PTExpression.ALWAYS.value);
  }
  
  private static boolean isHandBoxLeftOutOfRange(PTHandAttr paramPTHandAttr)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramPTHandAttr != null)
    {
      bool1 = bool2;
      if (paramPTHandAttr.getHandPointList() != null)
      {
        if (paramPTHandAttr.getHandPointList().size() < 30) {
          return false;
        }
        float f3 = ((PointF)paramPTHandAttr.getHandPointList().get(1)).x;
        int i = 9;
        float f2;
        for (float f1 = 10000.0F; i < 30; f1 = f2)
        {
          f2 = f1;
          if (((PointF)paramPTHandAttr.getHandPointList().get(i)).x < f1) {
            f2 = ((PointF)paramPTHandAttr.getHandPointList().get(i)).x;
          }
          i += 1;
        }
        bool1 = bool2;
        if (f1 - f3 < 5.0F) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static boolean isHandBoxRightOutOfRange(PTHandAttr paramPTHandAttr)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramPTHandAttr != null)
    {
      bool1 = bool2;
      if (paramPTHandAttr.getHandPointList() != null)
      {
        if (paramPTHandAttr.getHandPointList().size() < 30) {
          return false;
        }
        float f3 = ((PointF)paramPTHandAttr.getHandPointList().get(8)).x;
        int i = 9;
        float f2;
        for (float f1 = 0.0F; i < 30; f1 = f2)
        {
          f2 = f1;
          if (((PointF)paramPTHandAttr.getHandPointList().get(i)).x > f1) {
            f2 = ((PointF)paramPTHandAttr.getHandPointList().get(i)).x;
          }
          i += 1;
        }
        bool1 = bool2;
        if (f3 - f1 < 5.0F) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static boolean isHandBoxValid(PTHandAttr paramPTHandAttr)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramPTHandAttr != null)
    {
      bool1 = bool2;
      if (paramPTHandAttr.getHandPointList() != null)
      {
        if (paramPTHandAttr.getHandPointList().size() < 30) {
          return false;
        }
        float f1 = ((PointF)paramPTHandAttr.getHandPointList().get(8)).x - ((PointF)paramPTHandAttr.getHandPointList().get(1)).x;
        float f2 = ((PointF)paramPTHandAttr.getHandPointList().get(8)).y - ((PointF)paramPTHandAttr.getHandPointList().get(1)).y;
        bool1 = bool2;
        if (f1 > 0.01F)
        {
          if (f2 <= 0.01F) {
            return false;
          }
          bool1 = bool2;
          if (f1 / f2 >= 0.5F)
          {
            bool1 = bool2;
            if (f2 / f1 >= 0.5F) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private static boolean isHotAreaTriggered(AIAttr paramAIAttr, int paramInt, ArrayList<StickerItem.TriggerArea> paramArrayList)
  {
    if (paramArrayList == null) {
      return false;
    }
    if (AEModule.getContext() == null) {
      return false;
    }
    LightDeviceUtils.getScreenWidth(AEModule.getContext());
    LightDeviceUtils.getScreenHeight(AEModule.getContext());
    Object localObject1;
    PTFaceAttr localPTFaceAttr;
    List localList;
    if (paramAIAttr != null)
    {
      localObject1 = (PTHandAttr)paramAIAttr.getAvailableData(AEDetectorType.HAND.value);
      localPTFaceAttr = (PTFaceAttr)paramAIAttr.getAvailableData(AEDetectorType.FACE.value);
      localList = (List)paramAIAttr.getAvailableData(AEDetectorType.BODY.value);
      paramAIAttr = (AIAttr)localObject1;
    }
    else
    {
      localList = null;
      paramAIAttr = null;
      localPTFaceAttr = null;
    }
    if (paramAIAttr == null) {
      return false;
    }
    int i = paramAIAttr.getDetectWidth();
    int j = paramAIAttr.getDetectHeight();
    if (i != 0)
    {
      if (j == 0) {
        return false;
      }
      paramAIAttr = paramAIAttr.getHandPointList();
      if ((paramAIAttr != null) && (paramInt >= 0) && (paramInt < paramAIAttr.size())) {
        paramAIAttr = (PointF)paramAIAttr.get(paramInt);
      } else {
        paramAIAttr = null;
      }
      if (paramAIAttr == null) {
        return false;
      }
      if (paramArrayList != null)
      {
        float f2 = paramAIAttr.x;
        float f1 = i;
        f2 /= f1;
        float f3 = paramAIAttr.y;
        float f4 = j;
        localObject1 = new PointF(f2, f3 / f4);
        PointF localPointF1 = new PointF(paramAIAttr.x / f1, paramAIAttr.y / f4);
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          paramArrayList = (StickerItem.TriggerArea)localIterator.next();
          if (paramArrayList != null)
          {
            if (paramArrayList.type == 1)
            {
              if ((paramArrayList.rect == null) || (paramArrayList.rect.length < 4)) {
                continue;
              }
              f1 = paramArrayList.rect[0];
              f2 = paramArrayList.rect[1];
              f3 = paramArrayList.rect[2];
              f4 = paramArrayList.rect[3];
              paramAIAttr = new PointF(f1, f2);
              paramArrayList = new PointF(f3 + f1, f4 + f2);
            }
            else
            {
              PointF localPointF2;
              if (paramArrayList.type == 2)
              {
                if ((localPTFaceAttr == null) || (localPTFaceAttr.getFaceDetWidth() == 0) || (localPTFaceAttr.getFaceDetHeight() == 0) || (paramArrayList.rect == null) || (paramArrayList.anchorPoint == null) || (paramArrayList.anchorPoint.length < 1) || (paramArrayList.rect.length < 4)) {
                  continue;
                }
                paramAIAttr = localPTFaceAttr.getAllFacePoints();
                if ((paramAIAttr == null) || (paramAIAttr.size() <= 0)) {
                  continue;
                }
                localObject2 = (List)paramAIAttr.get(0);
                if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
                  continue;
                }
                f4 = ((PointF)((List)localObject2).get(0)).x;
                f3 = ((PointF)((List)localObject2).get(0)).x;
                f1 = ((PointF)((List)localObject2).get(0)).y;
                f2 = ((PointF)((List)localObject2).get(0)).y;
                paramAIAttr = ((List)localObject2).iterator();
                while (paramAIAttr.hasNext())
                {
                  localPointF2 = (PointF)paramAIAttr.next();
                  f4 = Math.min(f4, localPointF2.x);
                  f3 = Math.max(f3, localPointF2.x);
                  f1 = Math.min(f1, localPointF2.y);
                  f2 = Math.max(f2, localPointF2.y);
                }
                f3 -= f4;
                f1 = f2 - f1;
                if (localObject2 != null)
                {
                  if (paramArrayList.anchorPoint.length == 1)
                  {
                    paramInt = paramArrayList.anchorPoint[0];
                    if ((paramInt >= 0) && (paramInt < ((List)localObject2).size())) {
                      paramAIAttr = (PointF)((List)localObject2).get(paramInt);
                    } else {
                      paramAIAttr = null;
                    }
                    break label835;
                  }
                  if (paramArrayList.anchorPoint.length == 2)
                  {
                    paramInt = paramArrayList.anchorPoint[0];
                    i = paramArrayList.anchorPoint[1];
                    if ((paramInt >= 0) && (paramInt < ((List)localObject2).size()) && (i >= 0) && (i < ((List)localObject2).size()))
                    {
                      paramAIAttr = new PointF();
                      paramAIAttr.x = ((((PointF)((List)localObject2).get(paramInt)).x + ((PointF)((List)localObject2).get(i)).x) / 2.0F);
                      paramAIAttr.y = ((((PointF)((List)localObject2).get(paramInt)).y + ((PointF)((List)localObject2).get(i)).y) / 2.0F);
                      break label835;
                    }
                  }
                }
                paramAIAttr = null;
                label835:
                if (paramAIAttr == null) {
                  continue;
                }
                i = localPTFaceAttr.getFaceDetRotation();
                if ((i != 90) && (i != 270)) {
                  paramInt = localPTFaceAttr.getFaceDetWidth();
                } else {
                  paramInt = localPTFaceAttr.getFaceDetHeight();
                }
                if ((i != 90) && (i != 270)) {
                  i = localPTFaceAttr.getFaceDetHeight();
                } else {
                  i = localPTFaceAttr.getFaceDetWidth();
                }
                f4 = paramAIAttr.x;
                f2 = paramInt;
                paramAIAttr.x = (f4 / f2);
                float f5 = paramAIAttr.y;
                f4 = i;
                paramAIAttr.y = (f5 / f4);
                f5 = paramAIAttr.x + paramArrayList.rect[0] * f3 / f2;
                float f6 = paramAIAttr.y + paramArrayList.rect[1] * f1 / f4;
                f2 = paramArrayList.rect[2] * f3 / f2;
                f1 = paramArrayList.rect[3] * f1 / f4;
                paramAIAttr = new PointF(f5, f6);
                paramArrayList = new PointF(f2 + f5, f1 + f6);
              }
              else if (paramArrayList.type == 5)
              {
                if ((localList == null) || (localList.size() <= 0) || (paramArrayList.rect == null) || (paramArrayList.anchorPoint == null)) {
                  continue;
                }
                localObject2 = (BodyDetectResult)localList.get(0);
                if ((localObject2 == null) || (((BodyDetectResult)localObject2).bodyPoints == null) || (((BodyDetectResult)localObject2).bodyPoints.size() <= 0) || (((BodyDetectResult)localObject2).detectWidth == 0) || (((BodyDetectResult)localObject2).detectHeight == 0)) {
                  continue;
                }
                f4 = ((PointF)((BodyDetectResult)localObject2).bodyPoints.get(0)).x;
                f3 = ((PointF)((BodyDetectResult)localObject2).bodyPoints.get(0)).x;
                f2 = ((PointF)((BodyDetectResult)localObject2).bodyPoints.get(0)).y;
                f1 = ((PointF)((BodyDetectResult)localObject2).bodyPoints.get(0)).y;
                paramAIAttr = ((BodyDetectResult)localObject2).bodyPoints.iterator();
                while (paramAIAttr.hasNext())
                {
                  localPointF2 = (PointF)paramAIAttr.next();
                  f4 = Math.min(f4, localPointF2.x);
                  f3 = Math.max(f3, localPointF2.x);
                  f2 = Math.min(f2, localPointF2.y);
                  f1 = Math.max(f1, localPointF2.y);
                }
                f3 -= f4;
                f4 = f1 - f2;
                if (((BodyDetectResult)localObject2).bodyPoints != null)
                {
                  if (paramArrayList.anchorPoint.length == 1)
                  {
                    paramInt = paramArrayList.anchorPoint[0];
                    if ((paramInt >= 0) && (paramInt < ((BodyDetectResult)localObject2).bodyPoints.size())) {
                      paramAIAttr = (PointF)((BodyDetectResult)localObject2).bodyPoints.get(paramInt);
                    } else {
                      paramAIAttr = null;
                    }
                    break label1550;
                  }
                  if (paramArrayList.anchorPoint.length == 2)
                  {
                    paramInt = paramArrayList.anchorPoint[0];
                    i = paramArrayList.anchorPoint[1];
                    if ((paramInt >= 0) && (paramInt < ((BodyDetectResult)localObject2).bodyPoints.size()) && (i >= 0) && (i < ((BodyDetectResult)localObject2).bodyPoints.size()))
                    {
                      paramAIAttr = new PointF();
                      paramAIAttr.x = ((((PointF)((BodyDetectResult)localObject2).bodyPoints.get(paramInt)).x + ((PointF)((BodyDetectResult)localObject2).bodyPoints.get(i)).x) / 2.0F);
                      paramAIAttr.y = ((((PointF)((BodyDetectResult)localObject2).bodyPoints.get(paramInt)).y + ((PointF)((BodyDetectResult)localObject2).bodyPoints.get(i)).y) / 2.0F);
                      break label1550;
                    }
                  }
                }
                paramAIAttr = null;
                label1550:
                if (paramAIAttr == null) {
                  continue;
                }
                paramAIAttr.x /= ((BodyDetectResult)localObject2).detectWidth;
                paramAIAttr.y /= ((BodyDetectResult)localObject2).detectHeight;
                f1 = paramAIAttr.x + paramArrayList.rect[0] * f3 / ((BodyDetectResult)localObject2).detectWidth;
                f2 = paramAIAttr.y + paramArrayList.rect[1] * f4 / ((BodyDetectResult)localObject2).detectHeight;
                f3 = paramArrayList.rect[2] * f3 / ((BodyDetectResult)localObject2).detectWidth;
                f4 = paramArrayList.rect[3] * f4 / ((BodyDetectResult)localObject2).detectWidth;
                paramAIAttr = new PointF(f1, f2);
                paramArrayList = new PointF(f3 + f1, f4 + f2);
              }
              else
              {
                paramAIAttr = null;
                paramArrayList = null;
              }
            }
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handPointLt::");
            ((StringBuilder)localObject2).append(localObject1);
            Log.e("ykk", ((StringBuilder)localObject2).toString());
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handPointRB::");
            ((StringBuilder)localObject2).append(localPointF1);
            Log.e("ykk", ((StringBuilder)localObject2).toString());
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("triggerHotAreaLT::");
            ((StringBuilder)localObject2).append(paramAIAttr);
            Log.e("ykk", ((StringBuilder)localObject2).toString());
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("triggerHotAreaRB::");
            ((StringBuilder)localObject2).append(paramArrayList);
            Log.e("ykk", ((StringBuilder)localObject2).toString());
            if (hasOverlay((PointF)localObject1, localPointF1, paramAIAttr, paramArrayList))
            {
              Log.e("ykk", "hasOverlay");
              return true;
            }
          }
        }
      }
    }
    return false;
  }
  
  private static boolean isSingleFingerTriggered(int paramInt, List<PointF> paramList, float paramFloat)
  {
    if (paramList == null) {
      return false;
    }
    if (paramList.size() < 30) {
      return false;
    }
    if (paramInt >= 1)
    {
      if (paramInt > 5) {
        return false;
      }
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return false;
              }
              return isFinger4Point(paramFloat, paramInt, (PointF)paramList.get(26), (PointF)paramList.get(27), (PointF)paramList.get(28), (PointF)paramList.get(29));
            }
            return isFinger4Point(paramFloat, paramInt, (PointF)paramList.get(22), (PointF)paramList.get(23), (PointF)paramList.get(24), (PointF)paramList.get(25));
          }
          return isFinger4Point(paramFloat, paramInt, (PointF)paramList.get(18), (PointF)paramList.get(19), (PointF)paramList.get(20), (PointF)paramList.get(21));
        }
        return isFinger4Point(paramFloat, paramInt, (PointF)paramList.get(14), (PointF)paramList.get(15), (PointF)paramList.get(16), (PointF)paramList.get(17));
      }
      return isFinger4Point(paramFloat, paramInt, (PointF)paramList.get(10), (PointF)paramList.get(11), (PointF)paramList.get(12), (PointF)paramList.get(13));
    }
    return false;
  }
  
  public static boolean isTouchAreaTriggered(ArrayList<StickerItem.TriggerArea> paramArrayList, PointF paramPointF)
  {
    if (paramArrayList == null) {
      return false;
    }
    if (paramArrayList.size() < 1) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      float[] arrayOfFloat = ((StickerItem.TriggerArea)paramArrayList.next()).rect;
      if ((arrayOfFloat != null) && (arrayOfFloat.length >= 4) && (arrayOfFloat[0] <= paramPointF.x) && (paramPointF.x <= arrayOfFloat[0] + arrayOfFloat[2]) && (arrayOfFloat[1] <= paramPointF.y) && (paramPointF.y <= arrayOfFloat[1] + arrayOfFloat[3])) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.TriggerUtil
 * JD-Core Version:    0.7.0.1
 */