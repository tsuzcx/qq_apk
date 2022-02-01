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
    if ((this.faceAttr != null) && (this.faceAttr.getFaceStatusList() != null) && (this.faceAttr.getFaceStatusList().size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.faceAttr.getFaceStatusList().iterator();
      while (localIterator.hasNext())
      {
        FaceStatus localFaceStatus = (FaceStatus)localIterator.next();
        if (localFaceStatus != null) {
          localArrayList.add(Integer.valueOf(localFaceStatus.age));
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public PTFaceAttr getFaceAttr()
  {
    return this.faceAttr;
  }
  
  public int getFaceCount()
  {
    if (this.faceAttr != null) {
      return this.faceAttr.getFaceCount();
    }
    return 0;
  }
  
  public boolean getFaceExpression(PTFaceAttr.PTExpression paramPTExpression)
  {
    if ((this.faceAttr != null) && (this.faceAttr.getFaceExpression() != null)) {
      return ((Boolean)this.faceAttr.getFaceExpression().get(paramPTExpression)).booleanValue();
    }
    return false;
  }
  
  public List<Boolean> getFaceExpressions(PTFaceAttr.PTExpression paramPTExpression)
  {
    if (this.faceAttr != null)
    {
      Object localObject = this.faceAttr.getExpressions();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        ArrayList localArrayList = new ArrayList();
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          Set localSet = (Set)((Iterator)localObject).next();
          if ((localSet != null) && (localSet.contains(Integer.valueOf(paramPTExpression.value)))) {}
          for (boolean bool = true;; bool = false)
          {
            localArrayList.add(Boolean.valueOf(bool));
            break;
          }
        }
        return localArrayList;
      }
    }
    return null;
  }
  
  public List<List<PointF>> getFacePoints()
  {
    if (this.faceAttr != null) {
      return this.faceAttr.getAllFacePoints();
    }
    return null;
  }
  
  public List<Integer> getGenders()
  {
    if ((this.genderAttr != null) && (this.genderAttr.getGenderInfos() != null) && (this.genderAttr.getGenderInfos().size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.genderAttr.getGenderInfos().iterator();
      while (localIterator.hasNext())
      {
        PTGenderAttr.GenderInfo localGenderInfo = (PTGenderAttr.GenderInfo)localIterator.next();
        if (localGenderInfo != null) {
          localArrayList.add(Integer.valueOf(localGenderInfo.curGender));
        }
      }
      return localArrayList;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ai.PTFaceAttrPro
 * JD-Core Version:    0.7.0.1
 */