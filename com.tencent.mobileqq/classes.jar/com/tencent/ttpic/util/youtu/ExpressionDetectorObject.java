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
  private static final String TAG = ExpressionDetectorObject.class.getSimpleName();
  private boolean[] isLeftEyeClosed = new boolean[30];
  private boolean isLeftOccluded = false;
  private boolean[] isRightEyeClosed = new boolean[30];
  private boolean isRightOccluded = false;
  private boolean[] islipsOccluded = new boolean[30];
  private List<LinkedList<FaceInfo>> mFaceQueueList = new ArrayList();
  private List<LinkedList<FaceInfo>> mShookQueueList = new ArrayList();
  
  private double calDistanceSquare(PointF paramPointF1, PointF paramPointF2)
  {
    return Math.pow(paramPointF1.x - paramPointF2.x, 2.0D) + Math.pow(paramPointF1.y - paramPointF2.y, 2.0D);
  }
  
  private double calcDistanceOfFeaturePoints(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return Math.sqrt(Math.pow(paramFloat1 - paramFloat3, 2.0D) + Math.pow(paramFloat2 - paramFloat4, 2.0D));
  }
  
  private void clearFaceQueue(int paramInt)
  {
    if (paramInt < this.mFaceQueueList.size()) {
      while (((LinkedList)this.mFaceQueueList.get(paramInt)).size() > 1) {
        ((LinkedList)this.mFaceQueueList.get(paramInt)).removeLast();
      }
    }
  }
  
  private boolean isExpressionDistanceChangeDetected(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mFaceQueueList.size())
      {
        if (isExpressionDistanceChangeDetected(i, paramInt1, paramInt2)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean isExpressionDistanceChangeDetected(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.mFaceQueueList.size()) || (((LinkedList)this.mFaceQueueList.get(paramInt1)).isEmpty())) {
      return false;
    }
    Object localObject = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt1)).getFirst();
    double d = calDistanceSquare((PointF)((FaceInfo)localObject).points.get(paramInt2), (PointF)((FaceInfo)localObject).points.get(paramInt3));
    localObject = ((LinkedList)this.mFaceQueueList.get(paramInt1)).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FaceInfo localFaceInfo = (FaceInfo)((Iterator)localObject).next();
      if (d / calDistanceSquare((PointF)localFaceInfo.points.get(paramInt2), (PointF)localFaceInfo.points.get(paramInt3)) < 0.5D) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isExpressionDoubleEyesOcculudedDetected()
  {
    return (this.isLeftOccluded) && (this.isRightOccluded);
  }
  
  private boolean isExpressionJumpEyebrowDetected()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mFaceQueueList.size())
      {
        if (isExpressionJumpEyebrowDetected(i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean isExpressionJumpEyebrowDetected(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mFaceQueueList.size()) || (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty())) {
      return false;
    }
    Object localObject = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst();
    double d = AlgoUtils.getDistance((PointF)((FaceInfo)localObject).points.get(26), (PointF)((FaceInfo)localObject).points.get(64)) / AlgoUtils.getDistance((PointF)((FaceInfo)localObject).points.get(24), (PointF)((FaceInfo)localObject).points.get(64));
    localObject = ((LinkedList)this.mFaceQueueList.get(paramInt)).listIterator();
    ((ListIterator)localObject).next();
    while (((ListIterator)localObject).hasNext())
    {
      FaceInfo localFaceInfo = (FaceInfo)((ListIterator)localObject).next();
      if ((localFaceInfo != null) && (localFaceInfo.points != null) && (localFaceInfo.points.size() >= 90) && (1.04D * d <= AlgoUtils.getDistance((PointF)localFaceInfo.points.get(26), (PointF)localFaceInfo.points.get(64)) / AlgoUtils.getDistance((PointF)localFaceInfo.points.get(24), (PointF)localFaceInfo.points.get(64)))) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isExpressionJumpEyebrowDetectedForAtLeastOneFace()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mFaceQueueList.size())
      {
        if (isExpressionJumpEyebrowDetected(i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean isExpressionKissDetected()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mFaceQueueList.size())
      {
        if (isExpressionKissDetected(i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean isExpressionKissDetected(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mFaceQueueList.size()) || (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty())) {
      return false;
    }
    FaceInfo localFaceInfo = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst();
    if ((localFaceInfo != null) && (localFaceInfo.expressionWeights != null)) {}
    for (float f1 = localFaceInfo.expressionWeights[31];; f1 = 0.0F)
    {
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
        break;
      }
      if ((f1 > 0.36F / f2) || (f1 > 1.5F * 0.36F)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
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
    if ((paramInt < 0) || (paramInt >= this.mFaceQueueList.size()) || (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty())) {
      return false;
    }
    FaceInfo localFaceInfo = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst();
    float f = 0.0F;
    int i = 35;
    while (i < 44)
    {
      f += localFaceInfo.pointsVis[i].floatValue();
      i += 1;
    }
    if (f / 9.0F < 0.5D)
    {
      this.isLeftEyeClosed[paramInt] = true;
      return true;
    }
    if (this.isLeftEyeClosed[paramInt] != 0)
    {
      this.isLeftEyeClosed[paramInt] = false;
      return true;
    }
    return false;
  }
  
  private boolean isExpressionLeftEyeWinkDetected()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mFaceQueueList.size())
      {
        if (isExpressionDistanceChangeDetected(i, 37, 41)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean isExpressionMouthOccludedDetected()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mFaceQueueList.size())
      {
        if (isExpressionMouthOccludedDetected(i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean isExpressionMouthOccludedDetected(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.mFaceQueueList.size()) || (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty())) {
      return false;
    }
    FaceInfo localFaceInfo = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst();
    float f = 0.0F;
    int i = 65;
    while (i < 72)
    {
      f += localFaceInfo.pointsVis[i].floatValue();
      i += 1;
    }
    i = 75;
    while (i < 80)
    {
      f += localFaceInfo.pointsVis[i].floatValue();
      i += 1;
    }
    if (f / 12.0F < 0.5D)
    {
      if (paramInt < this.islipsOccluded.length)
      {
        this.islipsOccluded[paramInt] = true;
        return true;
      }
    }
    else if ((paramInt < this.islipsOccluded.length) && (this.islipsOccluded[paramInt] != 0))
    {
      this.islipsOccluded[paramInt] = false;
      return true;
    }
    return false;
  }
  
  private boolean isExpressionNodDetected()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mFaceQueueList.size())
      {
        if (isExpressionNodDetected(i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean isExpressionNodDetected(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mFaceQueueList.size()) || (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty())) {
      return false;
    }
    float f1 = 100.0F;
    float f2 = (float)(((FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst()).angles[0] * 180.0F / 3.141592653589793D);
    Iterator localIterator = ((LinkedList)this.mFaceQueueList.get(paramInt)).iterator();
    while (localIterator.hasNext())
    {
      f1 = Math.min(f1, (float)(((FaceInfo)localIterator.next()).angles[0] * 180.0F / 3.141592653589793D));
      if (f2 - f1 > 7.0F) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isExpressionOpenMouthDetected()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mFaceQueueList.size())
      {
        if (isExpressionOpenMouthDetected(i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean isExpressionOpenMouthDetected(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mFaceQueueList.size()) || (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty())) {
      return false;
    }
    FaceInfo localFaceInfo = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst();
    double d = AlgoUtils.getDistance((PointF)localFaceInfo.points.get(65), (PointF)localFaceInfo.points.get(66));
    return AlgoUtils.getDistance((PointF)localFaceInfo.points.get(73), (PointF)localFaceInfo.points.get(81)) > d * 0.2D;
  }
  
  private boolean isExpressionOpenMouthDetectedForAtLeastOneFace()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mFaceQueueList.size())
      {
        if (isExpressionOpenMouthDetected(i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
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
    if ((paramInt < 0) || (paramInt >= this.mFaceQueueList.size()) || (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty())) {
      return false;
    }
    FaceInfo localFaceInfo = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst();
    float f = 0.0F;
    int i = 45;
    while (i < 54)
    {
      f += localFaceInfo.pointsVis[i].floatValue();
      i += 1;
    }
    if (f / 9.0F < 0.5D)
    {
      this.isRightEyeClosed[paramInt] = true;
      return true;
    }
    if (this.isRightEyeClosed[paramInt] != 0)
    {
      this.isRightEyeClosed[paramInt] = false;
      return true;
    }
    return false;
  }
  
  private boolean isExpressionRightEyeWinkDetected()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mFaceQueueList.size())
      {
        if (isExpressionDistanceChangeDetected(i, 47, 51)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean isExpressionShakeHeadDetected()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mFaceQueueList.size())
      {
        if (isExpressionShakeHeadDetected(i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean isExpressionShakeHeadDetected(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mFaceQueueList.size()) || (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty())) {
      return false;
    }
    float f2 = 100.0F;
    float f1 = -100.0F;
    Iterator localIterator = ((LinkedList)this.mFaceQueueList.get(paramInt)).iterator();
    while (localIterator.hasNext())
    {
      float f3 = (float)(((FaceInfo)localIterator.next()).angles[1] * 180.0F / 3.141592653589793D);
      f2 = Math.min(f2, f3);
      f1 = Math.max(f1, f3);
      if (f1 - f2 > 7.0F) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isExpressionShookHeadDetected()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mFaceQueueList.size())
      {
        if (isExpressionShookHeadDetected(i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean isExpressionShookHeadDetected(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mFaceQueueList.size()) || (((LinkedList)this.mFaceQueueList.get(paramInt)).isEmpty())) {
      return false;
    }
    Object localObject = (FaceInfo)((LinkedList)this.mFaceQueueList.get(paramInt)).getFirst();
    if ((((LinkedList)this.mFaceQueueList.get(paramInt)).size() > 1) && (AlgoUtils.getDistance((PointF)((FaceInfo)localObject).points.get(2), (PointF)((FaceInfo)localObject).points.get(64)) * 0.7F > AlgoUtils.getDistance((PointF)((FaceInfo)localObject).points.get(64), (PointF)((FaceInfo)localObject).points.get(16))))
    {
      localObject = ((LinkedList)this.mFaceQueueList.get(paramInt)).listIterator();
      ((ListIterator)localObject).next();
      while (((ListIterator)localObject).hasNext())
      {
        FaceInfo localFaceInfo = (FaceInfo)((ListIterator)localObject).next();
        if (AlgoUtils.getDistance((PointF)localFaceInfo.points.get(64), (PointF)localFaceInfo.points.get(16)) * 0.7F > AlgoUtils.getDistance((PointF)localFaceInfo.points.get(2), (PointF)localFaceInfo.points.get(64))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean isFaceDetected()
  {
    return !this.mFaceQueueList.isEmpty();
  }
  
  public static boolean needSaveDetectedExpression(int paramInt)
  {
    return (paramInt == VideoMaterial.EXPRESSION_TYPE.JUMP_EYE_BROW.value) || (paramInt == VideoMaterial.EXPRESSION_TYPE.WINK.value) || (paramInt == VideoMaterial.EXPRESSION_TYPE.SHOOK_HEAD.value) || (paramInt == VideoMaterial.EXPRESSION_TYPE.RIGHT_EYE_WINK.value) || (paramInt == VideoMaterial.EXPRESSION_TYPE.LEFT_EYE_WINK.value) || (paramInt == VideoMaterial.EXPRESSION_TYPE.NOD.value) || (paramInt == VideoMaterial.EXPRESSION_TYPE.SHAKE_HEAD.value);
  }
  
  private float pointPairToBearingDegrees(PointF paramPointF1, PointF paramPointF2)
  {
    paramPointF1 = new PointF(paramPointF2.x - paramPointF1.x, paramPointF2.y - paramPointF1.y);
    float f = (float)((float)Math.atan2(paramPointF1.y, paramPointF1.x) * 57.295779513082323D);
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
      return;
    }
    if (paramList.size() != this.mFaceQueueList.size()) {
      this.mFaceQueueList.clear();
    }
    int i = 0;
    while (i < paramList.size())
    {
      if (i == this.mFaceQueueList.size()) {
        this.mFaceQueueList.add(new LinkedList());
      }
      LinkedList localLinkedList = (LinkedList)this.mFaceQueueList.get(i);
      if (localLinkedList.size() > 30) {
        localLinkedList.removeLast();
      }
      localLinkedList.addFirst(paramList.get(i));
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
    Iterator localIterator = this.mFaceQueueList.iterator();
    while (localIterator.hasNext())
    {
      LinkedList localLinkedList = (LinkedList)localIterator.next();
      while (localLinkedList.size() > 1) {
        localLinkedList.removeLast();
      }
    }
  }
  
  public void detectAllFaceExpression(List<Set<Integer>> paramList, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      updateExpressionOpenMouthDetected(paramList);
      return;
    case 7: 
      updateExpressionKissDetected(paramList);
      return;
    case 15: 
      updateExpressionMouthOccludedDetected(paramList);
      return;
    case 16: 
      updateExpressionLeftEyeOccludedDetected(paramList);
      return;
    case 17: 
      updateExpressionRightEyeOccludedDetected(paramList);
      return;
    }
    updateExpressionDoubleEyesOcculudedDetected(paramList);
  }
  
  public boolean detectExpression(int paramInt)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool2;
    switch (paramInt)
    {
    default: 
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return bool1;
                  return isFaceDetected();
                  return isExpressionOpenMouthDetected();
                  return isExpressionJumpEyebrowDetected();
                  if (!isExpressionRightEyeWinkDetected())
                  {
                    bool1 = bool3;
                    if (!isExpressionLeftEyeWinkDetected()) {}
                  }
                  else
                  {
                    bool1 = true;
                  }
                  return bool1;
                  return isExpressionShakeHeadDetected();
                  return isExpressionKissDetected();
                  return isExpressionLeftEyeWinkDetected();
                  return isExpressionRightEyeWinkDetected();
                  return isExpressionNodDetected();
                  return isExpressionMouthOccludedDetected();
                  return isExpressionLeftEyeOccludedDetected();
                  return isExpressionRightEyeOccludedDetected();
                  return isExpressionDoubleEyesOcculudedDetected();
                  if (!isFaceDetected()) {
                    break;
                  }
                  bool1 = bool2;
                } while (!isExpressionOpenMouthDetected());
                return false;
                if (!isFaceDetected()) {
                  break;
                }
                bool1 = bool2;
              } while (!isExpressionJumpEyebrowDetected());
              return false;
              if (!isFaceDetected()) {
                break;
              }
              bool1 = bool2;
            } while (!isExpressionShookHeadDetected());
            return false;
            if (!isFaceDetected()) {
              break;
            }
            bool1 = bool2;
          } while (!isExpressionKissDetected());
          return false;
          if (!isFaceDetected()) {
            break;
          }
          bool1 = bool2;
        } while (!isExpressionRightEyeWinkDetected());
        return false;
        if (!isFaceDetected()) {
          break;
        }
        bool1 = bool2;
      } while (!isExpressionRightEyeWinkDetected());
      return false;
      if (!isFaceDetected()) {
        break;
      }
      bool1 = bool2;
    } while (!isExpressionNodDetected());
    return false;
  }
  
  public List<LinkedList<FaceInfo>> getShookFaceInfos()
  {
    return this.mShookQueueList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.ExpressionDetectorObject
 * JD-Core Version:    0.7.0.1
 */