package com.tencent.ttpic.openapi.ai;

import android.graphics.PointF;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.openapi.PTEmotionAttr;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.PTGenderAttr;
import com.tencent.ttpic.openapi.PTGenderAttr.GenderInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PTFaceAttrPro
{
  private PTEmotionAttr emotionAttr;
  private PTFaceAttr faceAttr;
  private PTGenderAttr genderAttr;
  
  public List<Integer> getAges()
  {
    Object localObject = this.faceAttr;
    if ((localObject != null) && (((PTFaceAttr)localObject).getFaceStatusList() != null) && (this.faceAttr.getFaceStatusList().size() > 0))
    {
      localObject = new ArrayList();
      Iterator localIterator = this.faceAttr.getFaceStatusList().iterator();
      while (localIterator.hasNext())
      {
        FaceStatus localFaceStatus = (FaceStatus)localIterator.next();
        if (localFaceStatus != null) {
          ((List)localObject).add(Integer.valueOf(localFaceStatus.age));
        }
      }
      return localObject;
    }
    return null;
  }
  
  public PTFaceAttr getFaceAttr()
  {
    return this.faceAttr;
  }
  
  public int getFaceCount()
  {
    PTFaceAttr localPTFaceAttr = this.faceAttr;
    if (localPTFaceAttr != null) {
      return localPTFaceAttr.getFaceCount();
    }
    return 0;
  }
  
  public boolean getFaceExpression(PTFaceAttr.PTExpression paramPTExpression)
  {
    PTFaceAttr localPTFaceAttr = this.faceAttr;
    if ((localPTFaceAttr != null) && (localPTFaceAttr.getFaceExpression() != null)) {
      return ((Boolean)this.faceAttr.getFaceExpression().get(paramPTExpression)).booleanValue();
    }
    return false;
  }
  
  public List<Boolean> getFaceExpressions(PTFaceAttr.PTExpression paramPTExpression)
  {
    Object localObject1 = this.faceAttr;
    if (localObject1 != null)
    {
      Object localObject2 = ((PTFaceAttr)localObject1).getExpressions();
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Set localSet = (Set)((Iterator)localObject2).next();
          boolean bool;
          if ((localSet != null) && (localSet.contains(Integer.valueOf(paramPTExpression.value)))) {
            bool = true;
          } else {
            bool = false;
          }
          ((List)localObject1).add(Boolean.valueOf(bool));
        }
        return localObject1;
      }
    }
    return null;
  }
  
  public List<List<PointF>> getFacePoints()
  {
    PTFaceAttr localPTFaceAttr = this.faceAttr;
    if (localPTFaceAttr != null) {
      return localPTFaceAttr.getAllFacePoints();
    }
    return null;
  }
  
  public List<Integer> getGenders()
  {
    Object localObject = this.genderAttr;
    if ((localObject != null) && (((PTGenderAttr)localObject).getGenderInfos() != null) && (this.genderAttr.getGenderInfos().size() > 0))
    {
      localObject = new ArrayList();
      Iterator localIterator = this.genderAttr.getGenderInfos().iterator();
      while (localIterator.hasNext())
      {
        PTGenderAttr.GenderInfo localGenderInfo = (PTGenderAttr.GenderInfo)localIterator.next();
        if (localGenderInfo != null) {
          ((List)localObject).add(Integer.valueOf(localGenderInfo.curGender));
        }
      }
      return localObject;
    }
    return null;
  }
  
  public void setEmotionAttr(PTEmotionAttr paramPTEmotionAttr)
  {
    this.emotionAttr = paramPTEmotionAttr;
  }
  
  public void setFaceAttr(PTFaceAttr paramPTFaceAttr)
  {
    this.faceAttr = paramPTFaceAttr;
  }
  
  public void setGenderAttr(PTGenderAttr paramPTGenderAttr)
  {
    this.genderAttr = paramPTGenderAttr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ai.PTFaceAttrPro
 * JD-Core Version:    0.7.0.1
 */