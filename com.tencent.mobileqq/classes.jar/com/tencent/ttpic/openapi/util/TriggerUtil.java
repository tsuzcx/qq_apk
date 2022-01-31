package com.tencent.ttpic.openapi.util;

import android.graphics.PointF;
import android.util.Log;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.model.StickerItem.TriggerArea;
import com.tencent.ttpic.util.youtu.bodydetector.BodyDetectResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TriggerUtil
{
  public static final int ABSOLUTE_LOCATION = 1;
  public static final int BODY_LOCATION = 5;
  public static final int FACE_LOCATION = 2;
  
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
  
  public static boolean isGestureTriggered(PTHandAttr paramPTHandAttr, int paramInt)
  {
    return isGestureTriggered(paramPTHandAttr, paramInt, 0, null, null);
  }
  
  public static boolean isGestureTriggered(PTHandAttr paramPTHandAttr, int paramInt1, int paramInt2, ArrayList<StickerItem.TriggerArea> paramArrayList, AIAttr paramAIAttr)
  {
    if (paramPTHandAttr == null) {}
    for (;;)
    {
      return false;
      if ((paramArrayList != null) && (paramArrayList.size() > 0)) {}
      for (int i = 1; ((i == 0) || (isHotAreaTriggered(paramAIAttr, paramInt2, paramArrayList))) && (((200 <= paramInt1) && (paramInt1 <= 212) && (paramPTHandAttr.getHandType() == paramInt1)) || ((paramPTHandAttr.getHandPointList() != null) && (paramPTHandAttr.getHandPointList().size() != 0) && (paramInt1 == 200)) || (paramInt1 == PTFaceAttr.PTExpression.ALWAYS.value)); i = 0) {
        return true;
      }
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
    DeviceUtils.getScreenWidth(AEModule.getContext());
    DeviceUtils.getScreenHeight(AEModule.getContext());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.TriggerUtil
 * JD-Core Version:    0.7.0.1
 */