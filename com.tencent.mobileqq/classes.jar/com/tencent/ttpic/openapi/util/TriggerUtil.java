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
    float f1 = 0.0F;
    float f2 = paramPointF2.x - paramPointF1.x;
    float f3 = paramPointF2.y - paramPointF1.y;
    float f4 = paramPointF3.x - paramPointF1.x;
    float f5 = paramPointF3.y - paramPointF1.y;
    float f6 = (f2 * f2 + f3 * f3) * (f4 * f4 + f5 * f5);
    if (f6 == 0.0F) {}
    do
    {
      do
      {
        return f1;
        f2 = (float)((f2 * f4 + f3 * f5) / Math.sqrt(f6));
      } while (f2 >= 1.0D);
      if (f2 <= -1.0D) {
        return 180.0F;
      }
      f2 = (float)Math.acos(f2) / 3.141593F * 180.0F;
      f1 = f2;
    } while (f2 <= 180.0D);
    return 360.0F - f2;
  }
  
  private static boolean hasOverlay(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4)
  {
    boolean bool = true;
    if ((paramPointF1 == null) || (paramPointF2 == null) || (paramPointF3 == null) || (paramPointF4 == null)) {
      bool = false;
    }
    label101:
    label105:
    for (;;)
    {
      return bool;
      int i;
      if (Math.max(paramPointF1.x, paramPointF3.x) <= Math.min(paramPointF2.x, paramPointF4.x))
      {
        i = 1;
        if (Math.max(paramPointF1.y, paramPointF3.y) > Math.min(paramPointF2.y, paramPointF4.y)) {
          break label101;
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((i != 0) && (j != 0)) {
          break label105;
        }
        return false;
        i = 0;
        break;
      }
    }
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
    float f3;
    float f2;
    float f1;
    if (paramFloat >= 0.0F)
    {
      paramFloat = calAngle(paramPointF1, paramPointF2, paramPointF3);
      f3 = calAngle(paramPointF1, paramPointF3, paramPointF4);
      f2 = calAngle(paramPointF2, paramPointF3, paramPointF4);
      f1 = calAngle(paramPointF1, paramPointF2, paramPointF4);
      if (0.0F >= paramFloat) {
        break label113;
      }
    }
    for (;;)
    {
      if (paramFloat < f3) {
        paramFloat = f3;
      }
      for (;;)
      {
        if (paramFloat < f2) {
          paramFloat = f2;
        }
        for (;;)
        {
          if (paramFloat < f1) {
            paramFloat = f1;
          }
          for (;;)
          {
            if ((paramInt == 2) && (paramFloat > 10.0F)) {}
            while (paramFloat > 20.0F) {
              return true;
            }
            return false;
            return false;
          }
        }
      }
      label113:
      paramFloat = 0.0F;
    }
  }
  
  private static boolean isFingerTriggerd(int paramInt, PTHandAttr paramPTHandAttr)
  {
    if ((paramPTHandAttr == null) || (paramPTHandAttr.getHandPointList() == null) || (paramPTHandAttr.getHandPointList().size() == 0)) {}
    do
    {
      do
      {
        return false;
      } while ((!isHandBoxValid(paramPTHandAttr)) || (isHandBoxLeftOutOfRange(paramPTHandAttr)) || (isHandBoxRightOutOfRange(paramPTHandAttr)));
      if (paramInt == 0) {
        return isAllFingerTriggered(paramPTHandAttr.getHandPointList(), paramPTHandAttr.getConfidence());
      }
    } while ((paramInt <= 0) || (paramInt > 5));
    return isSingleFingerTriggered(paramInt, paramPTHandAttr.getHandPointList(), paramPTHandAttr.getConfidence());
  }
  
  public static boolean isGestureTriggered(PTHandAttr paramPTHandAttr, int paramInt)
  {
    return isGestureTriggered(paramPTHandAttr, paramInt, 0, 0, null, null);
  }
  
  public static boolean isGestureTriggered(PTHandAttr paramPTHandAttr, int paramInt1, int paramInt2, int paramInt3, ArrayList<StickerItem.TriggerArea> paramArrayList, AIAttr paramAIAttr)
  {
    if (paramPTHandAttr == null) {}
    label57:
    do
    {
      for (;;)
      {
        return false;
        if ((paramArrayList != null) && (paramArrayList.size() > 0)) {}
        for (int i = 1; (i == 0) || (isHotAreaTriggered(paramAIAttr, paramInt2, paramArrayList)); i = 0)
        {
          if (paramInt1 != 220) {
            break label57;
          }
          return isFingerTriggerd(paramInt3, paramPTHandAttr);
        }
      }
    } while (((200 > paramInt1) || (paramInt1 > 214) || (paramPTHandAttr.getHandType() != paramInt1)) && ((paramPTHandAttr.getHandPointList() == null) || (paramPTHandAttr.getHandPointList().size() == 0) || (paramInt1 != 200)) && (paramInt1 != PTFaceAttr.PTExpression.ALWAYS.value));
    return true;
  }
  
  private static boolean isHandBoxLeftOutOfRange(PTHandAttr paramPTHandAttr)
  {
    if ((paramPTHandAttr == null) || (paramPTHandAttr.getHandPointList() == null) || (paramPTHandAttr.getHandPointList().size() < 30)) {
      return false;
    }
    float f2 = ((PointF)paramPTHandAttr.getHandPointList().get(1)).x;
    float f1 = 10000.0F;
    int i = 9;
    if (i < 30)
    {
      if (((PointF)paramPTHandAttr.getHandPointList().get(i)).x >= f1) {
        break label114;
      }
      f1 = ((PointF)paramPTHandAttr.getHandPointList().get(i)).x;
    }
    label114:
    for (;;)
    {
      i += 1;
      break;
      return f1 - f2 < 5.0F;
    }
  }
  
  private static boolean isHandBoxRightOutOfRange(PTHandAttr paramPTHandAttr)
  {
    if ((paramPTHandAttr == null) || (paramPTHandAttr.getHandPointList() == null) || (paramPTHandAttr.getHandPointList().size() < 30)) {
      return false;
    }
    float f2 = ((PointF)paramPTHandAttr.getHandPointList().get(8)).x;
    float f1 = 0.0F;
    int i = 9;
    if (i < 30)
    {
      if (((PointF)paramPTHandAttr.getHandPointList().get(i)).x <= f1) {
        break label114;
      }
      f1 = ((PointF)paramPTHandAttr.getHandPointList().get(i)).x;
    }
    label114:
    for (;;)
    {
      i += 1;
      break;
      return f2 - f1 < 5.0F;
    }
  }
  
  private static boolean isHandBoxValid(PTHandAttr paramPTHandAttr)
  {
    if ((paramPTHandAttr == null) || (paramPTHandAttr.getHandPointList() == null) || (paramPTHandAttr.getHandPointList().size() < 30)) {}
    float f1;
    float f2;
    do
    {
      return false;
      f1 = ((PointF)paramPTHandAttr.getHandPointList().get(8)).x - ((PointF)paramPTHandAttr.getHandPointList().get(1)).x;
      f2 = ((PointF)paramPTHandAttr.getHandPointList().get(8)).y - ((PointF)paramPTHandAttr.getHandPointList().get(1)).y;
    } while ((f1 <= 0.01F) || (f2 <= 0.01F));
    if ((f1 / f2 >= 0.5F) && (f2 / f1 >= 0.5F)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
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
    Object localObject1 = null;
    Object localObject2;
    PTFaceAttr localPTFaceAttr;
    if (paramAIAttr != null)
    {
      localObject2 = (PTHandAttr)paramAIAttr.getAvailableData(AEDetectorType.HAND.value);
      localPTFaceAttr = (PTFaceAttr)paramAIAttr.getAvailableData(AEDetectorType.FACE.value);
      localObject1 = (List)paramAIAttr.getAvailableData(AEDetectorType.BODY.value);
      paramAIAttr = (AIAttr)localObject2;
    }
    for (;;)
    {
      if (paramAIAttr == null) {
        return false;
      }
      int i = paramAIAttr.getDetectWidth();
      int j = paramAIAttr.getDetectHeight();
      if ((i == 0) || (j == 0)) {
        return false;
      }
      Object localObject3 = paramAIAttr.getHandPointList();
      localObject2 = null;
      paramAIAttr = (AIAttr)localObject2;
      if (localObject3 != null)
      {
        paramAIAttr = (AIAttr)localObject2;
        if (paramInt >= 0)
        {
          paramAIAttr = (AIAttr)localObject2;
          if (paramInt < ((List)localObject3).size()) {
            paramAIAttr = (PointF)((List)localObject3).get(paramInt);
          }
        }
      }
      if (paramAIAttr == null) {
        return false;
      }
      Iterator localIterator;
      if (paramArrayList != null)
      {
        localObject2 = new PointF(paramAIAttr.x / i, paramAIAttr.y / j);
        localObject3 = new PointF(paramAIAttr.x / i, paramAIAttr.y / j);
        localIterator = paramArrayList.iterator();
      }
      label1802:
      label1807:
      label1810:
      for (;;)
      {
        StickerItem.TriggerArea localTriggerArea;
        float f1;
        float f2;
        float f3;
        float f4;
        label346:
        float f6;
        float f5;
        Object localObject4;
        if (localIterator.hasNext())
        {
          localTriggerArea = (StickerItem.TriggerArea)localIterator.next();
          if (localTriggerArea == null) {
            continue;
          }
          if (localTriggerArea.type == 1)
          {
            if ((localTriggerArea.rect == null) || (localTriggerArea.rect.length < 4)) {
              continue;
            }
            f1 = localTriggerArea.rect[0];
            f2 = localTriggerArea.rect[1];
            f3 = localTriggerArea.rect[2];
            f4 = localTriggerArea.rect[3];
            paramArrayList = new PointF(f1, f2);
            paramAIAttr = new PointF(f1 + f3, f2 + f4);
            Log.e("ykk", "handPointLt::" + localObject2);
            Log.e("ykk", "handPointRB::" + localObject3);
            Log.e("ykk", "triggerHotAreaLT::" + paramArrayList);
            Log.e("ykk", "triggerHotAreaRB::" + paramAIAttr);
            if (!hasOverlay((PointF)localObject2, (PointF)localObject3, paramArrayList, paramAIAttr)) {
              continue;
            }
            Log.e("ykk", "hasOverlay");
            return true;
          }
          if (localTriggerArea.type == 2)
          {
            if ((localPTFaceAttr == null) || (localPTFaceAttr.getFaceDetWidth() == 0) || (localPTFaceAttr.getFaceDetHeight() == 0) || (localTriggerArea.rect == null) || (localTriggerArea.anchorPoint == null) || (localTriggerArea.anchorPoint.length < 1) || (localTriggerArea.rect.length < 4)) {
              continue;
            }
            paramAIAttr = localPTFaceAttr.getAllFacePoints();
            if ((paramAIAttr == null) || (paramAIAttr.size() <= 0)) {
              continue;
            }
            paramArrayList = (List)paramAIAttr.get(0);
            if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
              continue;
            }
            f1 = ((PointF)paramArrayList.get(0)).x;
            f2 = ((PointF)paramArrayList.get(0)).x;
            f3 = ((PointF)paramArrayList.get(0)).y;
            f4 = ((PointF)paramArrayList.get(0)).y;
            paramAIAttr = paramArrayList.iterator();
            f6 = f1;
            f5 = f2;
            f2 = f3;
            for (f1 = f4; paramAIAttr.hasNext(); f1 = Math.max(f1, ((PointF)localObject4).y))
            {
              localObject4 = (PointF)paramAIAttr.next();
              f6 = Math.min(f6, ((PointF)localObject4).x);
              f5 = Math.max(f5, ((PointF)localObject4).x);
              f2 = Math.min(f2, ((PointF)localObject4).y);
            }
            f3 = f5 - f6;
            f1 -= f2;
            if (paramArrayList == null) {
              break label1802;
            }
            if (localTriggerArea.anchorPoint.length == 1)
            {
              paramInt = localTriggerArea.anchorPoint[0];
              if ((paramInt < 0) || (paramInt >= paramArrayList.size())) {
                break label1807;
              }
              paramAIAttr = (PointF)paramArrayList.get(paramInt);
            }
          }
        }
        for (;;)
        {
          label787:
          if (paramAIAttr == null) {
            break label1810;
          }
          i = localPTFaceAttr.getFaceDetRotation();
          if ((i == 90) || (i == 270))
          {
            paramInt = localPTFaceAttr.getFaceDetHeight();
            label819:
            if ((i != 90) && (i != 270)) {
              break label1118;
            }
          }
          label1118:
          for (i = localPTFaceAttr.getFaceDetWidth();; i = localPTFaceAttr.getFaceDetHeight())
          {
            paramAIAttr.x /= paramInt;
            paramAIAttr.y /= i;
            f2 = paramAIAttr.x + localTriggerArea.rect[0] * f3 / paramInt;
            f4 = paramAIAttr.y + localTriggerArea.rect[1] * f1 / i;
            f3 = f3 * localTriggerArea.rect[2] / paramInt;
            f1 = localTriggerArea.rect[3] * f1 / i;
            paramArrayList = new PointF(f2, f4);
            paramAIAttr = new PointF(f3 + f2, f4 + f1);
            break;
            if (localTriggerArea.anchorPoint.length != 2) {
              break label1802;
            }
            paramInt = localTriggerArea.anchorPoint[0];
            i = localTriggerArea.anchorPoint[1];
            if ((paramInt < 0) || (paramInt >= paramArrayList.size()) || (i < 0) || (i >= paramArrayList.size())) {
              break label1802;
            }
            paramAIAttr = new PointF();
            f2 = ((PointF)paramArrayList.get(paramInt)).x;
            paramAIAttr.x = ((((PointF)paramArrayList.get(i)).x + f2) / 2.0F);
            f2 = ((PointF)paramArrayList.get(paramInt)).y;
            paramAIAttr.y = ((((PointF)paramArrayList.get(i)).y + f2) / 2.0F);
            break label787;
            paramInt = localPTFaceAttr.getFaceDetWidth();
            break label819;
          }
          if (localTriggerArea.type == 5)
          {
            if ((localObject1 == null) || (((List)localObject1).size() <= 0) || (localTriggerArea.rect == null) || (localTriggerArea.anchorPoint == null)) {
              break;
            }
            localObject4 = (BodyDetectResult)((List)localObject1).get(0);
            if ((localObject4 == null) || (((BodyDetectResult)localObject4).bodyPoints == null) || (((BodyDetectResult)localObject4).bodyPoints.size() <= 0) || (((BodyDetectResult)localObject4).detectWidth == 0) || (((BodyDetectResult)localObject4).detectHeight == 0)) {
              break;
            }
            f1 = ((PointF)((BodyDetectResult)localObject4).bodyPoints.get(0)).x;
            f2 = ((PointF)((BodyDetectResult)localObject4).bodyPoints.get(0)).x;
            f3 = ((PointF)((BodyDetectResult)localObject4).bodyPoints.get(0)).y;
            f4 = ((PointF)((BodyDetectResult)localObject4).bodyPoints.get(0)).y;
            paramAIAttr = ((BodyDetectResult)localObject4).bodyPoints.iterator();
            f6 = f1;
            f5 = f2;
            f2 = f3;
            for (f1 = f4; paramAIAttr.hasNext(); f1 = Math.max(f1, paramArrayList.y))
            {
              paramArrayList = (PointF)paramAIAttr.next();
              f6 = Math.min(f6, paramArrayList.x);
              f5 = Math.max(f5, paramArrayList.x);
              f2 = Math.min(f2, paramArrayList.y);
            }
            f3 = f5 - f6;
            f1 -= f2;
            paramArrayList = null;
            paramAIAttr = paramArrayList;
            if (((BodyDetectResult)localObject4).bodyPoints != null)
            {
              if (localTriggerArea.anchorPoint.length != 1) {
                break label1615;
              }
              paramInt = localTriggerArea.anchorPoint[0];
              paramAIAttr = paramArrayList;
              if (paramInt >= 0)
              {
                paramAIAttr = paramArrayList;
                if (paramInt < ((BodyDetectResult)localObject4).bodyPoints.size()) {
                  paramAIAttr = (PointF)((BodyDetectResult)localObject4).bodyPoints.get(paramInt);
                }
              }
            }
            for (;;)
            {
              if (paramAIAttr == null) {
                break label1791;
              }
              paramAIAttr.x /= ((BodyDetectResult)localObject4).detectWidth;
              paramAIAttr.y /= ((BodyDetectResult)localObject4).detectHeight;
              f2 = paramAIAttr.x + localTriggerArea.rect[0] * f3 / ((BodyDetectResult)localObject4).detectWidth;
              f4 = paramAIAttr.y + localTriggerArea.rect[1] * f1 / ((BodyDetectResult)localObject4).detectHeight;
              f3 = f3 * localTriggerArea.rect[2] / ((BodyDetectResult)localObject4).detectWidth;
              f1 = localTriggerArea.rect[3] * f1 / ((BodyDetectResult)localObject4).detectWidth;
              paramArrayList = new PointF(f2, f4);
              paramAIAttr = new PointF(f3 + f2, f4 + f1);
              break;
              label1615:
              paramAIAttr = paramArrayList;
              if (localTriggerArea.anchorPoint.length == 2)
              {
                paramInt = localTriggerArea.anchorPoint[0];
                i = localTriggerArea.anchorPoint[1];
                paramAIAttr = paramArrayList;
                if (paramInt >= 0)
                {
                  paramAIAttr = paramArrayList;
                  if (paramInt < ((BodyDetectResult)localObject4).bodyPoints.size())
                  {
                    paramAIAttr = paramArrayList;
                    if (i >= 0)
                    {
                      paramAIAttr = paramArrayList;
                      if (i < ((BodyDetectResult)localObject4).bodyPoints.size())
                      {
                        paramAIAttr = new PointF();
                        f2 = ((PointF)((BodyDetectResult)localObject4).bodyPoints.get(paramInt)).x;
                        paramAIAttr.x = ((((PointF)((BodyDetectResult)localObject4).bodyPoints.get(i)).x + f2) / 2.0F);
                        f2 = ((PointF)((BodyDetectResult)localObject4).bodyPoints.get(paramInt)).y;
                        paramAIAttr.y = ((((PointF)((BodyDetectResult)localObject4).bodyPoints.get(i)).y + f2) / 2.0F);
                      }
                    }
                  }
                }
              }
            }
            label1791:
            break;
            return false;
          }
          paramAIAttr = null;
          paramArrayList = null;
          break label346;
          paramAIAttr = null;
          continue;
          paramAIAttr = null;
        }
      }
      localObject2 = null;
      localPTFaceAttr = null;
      paramAIAttr = (AIAttr)localObject1;
      localObject1 = localObject2;
    }
  }
  
  private static boolean isSingleFingerTriggered(int paramInt, List<PointF> paramList, float paramFloat)
  {
    if (paramList == null) {}
    while ((paramList.size() < 30) || (paramInt < 1) || (paramInt > 5)) {
      return false;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      return isFinger4Point(paramFloat, paramInt, (PointF)paramList.get(10), (PointF)paramList.get(11), (PointF)paramList.get(12), (PointF)paramList.get(13));
    case 2: 
      return isFinger4Point(paramFloat, paramInt, (PointF)paramList.get(14), (PointF)paramList.get(15), (PointF)paramList.get(16), (PointF)paramList.get(17));
    case 3: 
      return isFinger4Point(paramFloat, paramInt, (PointF)paramList.get(18), (PointF)paramList.get(19), (PointF)paramList.get(20), (PointF)paramList.get(21));
    case 4: 
      return isFinger4Point(paramFloat, paramInt, (PointF)paramList.get(22), (PointF)paramList.get(23), (PointF)paramList.get(24), (PointF)paramList.get(25));
    }
    return isFinger4Point(paramFloat, paramInt, (PointF)paramList.get(26), (PointF)paramList.get(27), (PointF)paramList.get(28), (PointF)paramList.get(29));
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
      if ((arrayOfFloat != null) && (arrayOfFloat.length >= 4) && (arrayOfFloat[0] <= paramPointF.x) && (paramPointF.x <= arrayOfFloat[0] + arrayOfFloat[2]) && (arrayOfFloat[1] <= paramPointF.y))
      {
        float f1 = paramPointF.y;
        float f2 = arrayOfFloat[1];
        if (f1 <= arrayOfFloat[3] + f2) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.TriggerUtil
 * JD-Core Version:    0.7.0.1
 */