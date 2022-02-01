package com.tencent.mobileqq.shortvideo.facedancegame;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.os.SystemClock;
import com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoy;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.DancePosture;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.Posture;
import com.tencent.mobileqq.shortvideo.facedancegame.utils.ActUtil;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.sveffects.Reporter;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"NewApi"})
public class FaceDanceDetectTask
  implements IFaceDetectCallBack, IGestureDetectCallBack
{
  private static final String TAG = "FaceDanceDetectTask";
  static final int TASKSTATUS_EXPRESSIONDETECT = 3;
  static final int TASKSTATUS_FACEDETECT = 2;
  static final int TASKSTATUS_INITING = 1;
  static final int TASKSTATUS_READY = 0;
  private static final String TIMETAG = "FaceDanceDetectTaskTime";
  private static FaceDanceDetectTask instance = new FaceDanceDetectTask();
  private List<WeakReference<GLLittleBoy>> littleBoyReferenceList = new ArrayList();
  private volatile FaceDanceDetectTask.FaceDetectTaskResult mFaceDetectResult = null;
  private volatile FaceDanceDetectTask.GestureDetectTaskResult mGestureDetectResult = null;
  private volatile long mTaskBeginTime = -1L;
  private volatile int mTaskStatus = 0;
  volatile WeakReference<GLLittleBoy> matchedlittleBoyReference = null;
  QQFilterRenderManager mqqFilterRenderManager = null;
  
  private void ResetTask()
  {
    this.littleBoyReferenceList.clear();
    this.mGestureDetectResult = null;
    this.mFaceDetectResult = null;
  }
  
  private void firstDetectFaild()
  {
    notifyTaskEnd();
  }
  
  public static FaceDanceDetectTask getInstance()
  {
    return instance;
  }
  
  public static void logBoyWithMessage(GLLittleBoy paramGLLittleBoy, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" ");
    localObject = ((StringBuilder)localObject).toString();
    paramString = (String)localObject;
    if (paramGLLittleBoy != null)
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append("boyinfo id=");
      paramString.append(paramGLLittleBoy.getDanceData().id);
      paramString.append(" needMatched=");
      paramString.append(paramGLLittleBoy.needDoMatch());
      paramString.append(" isMatched=");
      paramString.append(paramGLLittleBoy.isMatched());
      paramString.append(" appearTime=");
      paramString.append(paramGLLittleBoy.getDanceData().appearTime);
      paramString = paramString.toString();
    }
    loginfo(paramString);
  }
  
  public static void logFaceInfo(List<PointF> paramList, float[] paramArrayOfFloat, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" ");
    paramString = ((StringBuilder)localObject).toString();
    if ((paramList != null) && (paramList.size() > 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("expressionFeat [");
      paramString = ((StringBuilder)localObject).toString();
      localObject = paramList.iterator();
      paramList = paramString;
      while (((Iterator)localObject).hasNext())
      {
        paramString = (PointF)((Iterator)localObject).next();
        if (paramString != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramList);
          localStringBuilder.append("\n");
          paramList = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramList);
          localStringBuilder.append(paramString.x);
          paramList = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramList);
          localStringBuilder.append(",");
          paramList = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramList);
          localStringBuilder.append("\n");
          paramList = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramList);
          localStringBuilder.append(paramString.y);
          paramList = localStringBuilder.toString();
          paramString = new StringBuilder();
          paramString.append(paramList);
          paramString.append(",");
          paramList = paramString.toString();
        }
      }
      paramString = new StringBuilder();
      paramString.append(paramList);
      paramString.append("\n");
      paramList = paramString.toString();
      paramString = new StringBuilder();
      paramString.append(paramList);
      paramString.append("]\n");
      paramList = paramString.toString();
    }
    else
    {
      paramList = new StringBuilder();
      paramList.append(paramString);
      paramList.append("expressionFeat is null");
      paramList = paramList.toString();
    }
    paramString = paramList;
    if (paramArrayOfFloat != null)
    {
      paramString = paramList;
      if (paramArrayOfFloat.length > 0)
      {
        paramString = new StringBuilder();
        paramString.append(paramList);
        paramString.append("expressionAngle [");
        paramList = paramString.toString();
        int j = paramArrayOfFloat.length;
        int i = 0;
        while (i < j)
        {
          float f = paramArrayOfFloat[i];
          paramString = new StringBuilder();
          paramString.append(paramList);
          paramString.append("\n");
          paramList = paramString.toString();
          paramString = new StringBuilder();
          paramString.append(paramList);
          paramString.append(f);
          paramList = paramString.toString();
          paramString = new StringBuilder();
          paramString.append(paramList);
          paramString.append(",");
          paramList = paramString.toString();
          i += 1;
        }
        paramArrayOfFloat = new StringBuilder();
        paramArrayOfFloat.append(paramList);
        paramArrayOfFloat.append("\n");
        paramList = paramArrayOfFloat.toString();
        paramArrayOfFloat = new StringBuilder();
        paramArrayOfFloat.append(paramList);
        paramArrayOfFloat.append("]\n");
        paramString = paramArrayOfFloat.toString();
      }
    }
    loginfo(paramString);
  }
  
  public static void logTimeInfo(String paramString, long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    double d = paramLong2 - paramLong1;
    Double.isNaN(d);
    d /= 1000000.0D;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" Time cost:");
    localStringBuilder.append(d);
    paramString = localStringBuilder.toString();
    if (SLog.isEnable()) {
      SLog.d("FaceDanceDetectTaskTime", paramString);
    }
  }
  
  public static void loginfo(String paramString)
  {
    if (SLog.isEnable()) {
      SLog.d("FaceDanceDetectTask", paramString);
    }
  }
  
  static void reportHighScoreLittelBoy(String paramString, float paramFloat, List<PointF> paramList, float[] paramArrayOfFloat, double[] paramArrayOfDouble)
  {
    HashMap localHashMap = new HashMap();
    if (paramString != null) {
      localHashMap.put("boyType", paramString);
    }
    localHashMap.put("score", String.valueOf(paramFloat));
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append("expressionFeat [");
      paramString = paramString.toString();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (PointF)paramList.next();
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("\n");
          paramString = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append(((PointF)localObject).x);
          paramString = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append(",");
          paramString = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("\n");
          paramString = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append(((PointF)localObject).y);
          paramString = localStringBuilder.toString();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(",");
          paramString = ((StringBuilder)localObject).toString();
        }
      }
      paramList = new StringBuilder();
      paramList.append(paramString);
      paramList.append("\n");
      paramString = paramList.toString();
      paramList = new StringBuilder();
      paramList.append(paramString);
      paramList.append("]\n");
      paramString = paramList.toString();
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append("expressionFeat is null");
      paramString = paramString.toString();
    }
    localHashMap.put("expressionFeat", paramString);
    int j = 0;
    int k;
    int i;
    if ((paramArrayOfDouble != null) && (paramArrayOfDouble.length > 0))
    {
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append("expressionAngle [");
      paramString = paramString.toString();
      k = paramArrayOfDouble.length;
      i = 0;
      while (i < k)
      {
        double d = paramArrayOfDouble[i];
        paramList = new StringBuilder();
        paramList.append(paramString);
        paramList.append("\n");
        paramString = paramList.toString();
        paramList = new StringBuilder();
        paramList.append(paramString);
        paramList.append(d);
        paramString = paramList.toString();
        paramList = new StringBuilder();
        paramList.append(paramString);
        paramList.append(",");
        paramString = paramList.toString();
        i += 1;
      }
      paramList = new StringBuilder();
      paramList.append(paramString);
      paramList.append("\n");
      paramString = paramList.toString();
      paramList = new StringBuilder();
      paramList.append(paramString);
      paramList.append("]\n");
      paramString = paramList.toString();
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append("expressionWeight is null");
      paramString = paramString.toString();
    }
    localHashMap.put("expressionWeight", paramString);
    if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length > 0))
    {
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append("expressionAngle [");
      paramString = paramString.toString();
      k = paramArrayOfFloat.length;
      i = j;
      while (i < k)
      {
        paramFloat = paramArrayOfFloat[i];
        paramList = new StringBuilder();
        paramList.append(paramString);
        paramList.append("\n");
        paramString = paramList.toString();
        paramList = new StringBuilder();
        paramList.append(paramString);
        paramList.append(paramFloat);
        paramString = paramList.toString();
        paramList = new StringBuilder();
        paramList.append(paramString);
        paramList.append(",");
        paramString = paramList.toString();
        i += 1;
      }
      paramList = new StringBuilder();
      paramList.append(paramString);
      paramList.append("\n");
      paramString = paramList.toString();
      paramList = new StringBuilder();
      paramList.append(paramString);
      paramList.append("]\n");
      paramString = paramList.toString();
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append("expressionAngle is null");
      paramString = paramString.toString();
    }
    localHashMap.put("expressionAngle", paramString);
    SdkContext.getInstance().getReporter().reportToBeacon("FaceDanceExpressionInfo", true, 0L, 0L, localHashMap);
  }
  
  private void startExpressionDetect()
  {
    if (this.mTaskStatus != 2) {
      return;
    }
    FaceDanceDetectTask.FaceDetectTaskResult localFaceDetectTaskResult = this.mFaceDetectResult;
    Object localObject1 = this.mGestureDetectResult;
    if ((localFaceDetectTaskResult != null) && (localObject1 != null))
    {
      this.mTaskStatus = 3;
      int j = this.littleBoyReferenceList.size();
      int i = 0;
      if (j == 1)
      {
        localObject2 = (GLLittleBoy)((WeakReference)this.littleBoyReferenceList.get(0)).get();
        if ((localObject2 != null) && (((GLLittleBoy)localObject2).isReadyMatch) && (!((GLLittleBoy)localObject2).isMatched()))
        {
          if (localFaceDetectTaskResult.vaild) {
            this.matchedlittleBoyReference = new WeakReference(localObject2);
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("mFaceDetectResult.vaild =");
          ((StringBuilder)localObject1).append(localFaceDetectTaskResult.vaild);
          ((StringBuilder)localObject1).append(" and tempboy.isReadyMatch=");
          ((StringBuilder)localObject1).append(((GLLittleBoy)localObject2).isReadyMatch);
          loginfo(((StringBuilder)localObject1).toString());
          notifyTaskEnd();
          return;
        }
      }
      if ((localFaceDetectTaskResult.vaild) && (((FaceDanceDetectTask.GestureDetectTaskResult)localObject1).vaild))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("mFaceDetectResult.vaild and mGestureDetectResult.vaild mGestureDetectResult.type=");
        ((StringBuilder)localObject2).append(((FaceDanceDetectTask.GestureDetectTaskResult)localObject1).type);
        loginfo(((StringBuilder)localObject2).toString());
        ArrayList localArrayList = new ArrayList();
        localObject2 = this.littleBoyReferenceList.iterator();
        GLLittleBoy localGLLittleBoy;
        Object localObject3;
        while (((Iterator)localObject2).hasNext())
        {
          localGLLittleBoy = (GLLittleBoy)((WeakReference)((Iterator)localObject2).next()).get();
          if ((localGLLittleBoy != null) && (localGLLittleBoy.needDoMatch()))
          {
            localObject3 = localGLLittleBoy.getDanceData();
            localObject3 = ResourceManager.getInstance().getPostureById(((ResourceManager.DancePosture)localObject3).id);
            if ((localObject3 != null) && (((ResourceManager.Posture)localObject3).faceDanceConfig.mGestureType.equals(((FaceDanceDetectTask.GestureDetectTaskResult)localObject1).type)))
            {
              logBoyWithMessage(localGLLittleBoy, "startExpressionDetect has boy equals");
              localArrayList.add(localGLLittleBoy);
            }
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("tempBoyList.size() ==");
        ((StringBuilder)localObject2).append(localArrayList.size());
        ((StringBuilder)localObject2).append(" mGestureDetectResult.type=");
        ((StringBuilder)localObject2).append(((FaceDanceDetectTask.GestureDetectTaskResult)localObject1).type);
        loginfo(((StringBuilder)localObject2).toString());
        if (localArrayList.size() == 0)
        {
          notifyTaskEnd();
        }
        else
        {
          float f2 = 0.0F;
          for (localObject1 = null; i < localArrayList.size(); localObject1 = localObject2)
          {
            long l1 = SystemClock.elapsedRealtimeNanos();
            localGLLittleBoy = (GLLittleBoy)localArrayList.get(i);
            localObject2 = localGLLittleBoy.getDanceData();
            localObject2 = ResourceManager.getInstance().getPostureById(((ResourceManager.DancePosture)localObject2).id);
            float f3;
            if (localObject2 == null)
            {
              f3 = f2;
              localObject2 = localObject1;
            }
            else
            {
              localObject3 = ((ResourceManager.Posture)localObject2).faceDanceConfig;
              float f1 = ActUtil.getExpressionSimilarity(((FaceDanceTemplateConfig)localObject3).mExpressionConfig.expressionFeat, localFaceDetectTaskResult.pointFs, ((FaceDanceTemplateConfig)localObject3).mExpressionConfig.expressionAngle, localFaceDetectTaskResult.angles, ((FaceDanceTemplateConfig)localObject3).mExpressionConfig.expressionWeight);
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("match expression score=");
              ((StringBuilder)localObject2).append(f1);
              logBoyWithMessage(localGLLittleBoy, ((StringBuilder)localObject2).toString());
              long l2 = SystemClock.elapsedRealtimeNanos();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("ActUtil.getExpressionSimilarity No:");
              ((StringBuilder)localObject2).append(i);
              ((StringBuilder)localObject2).append(" boy");
              logTimeInfo(((StringBuilder)localObject2).toString(), l1, l2);
              if (f1 > 95.0F) {
                reportHighScoreLittelBoy(((FaceDanceTemplateConfig)localObject3).mExpressionConfig.expressionID, f1, localFaceDetectTaskResult.pointFs, localFaceDetectTaskResult.angles, ((FaceDanceTemplateConfig)localObject3).mExpressionConfig.expressionWeight);
              }
              if (!checkIsNeedMatchExpression(((FaceDanceTemplateConfig)localObject3).mExpressionConfig.expressionWeight))
              {
                logBoyWithMessage(localGLLittleBoy, " not NeedMatchExpression");
                f1 = 100.0F;
              }
              f3 = f2;
              localObject2 = localObject1;
              if (f1 >= ((FaceDanceTemplateConfig)localObject3).threshold)
              {
                f3 = f2;
                localObject2 = localObject1;
                if (f1 > f2)
                {
                  localObject2 = localGLLittleBoy;
                  f3 = f1;
                }
              }
            }
            i += 1;
            f2 = f3;
          }
          if (localObject1 != null)
          {
            this.matchedlittleBoyReference = new WeakReference(localObject1);
            logBoyWithMessage((GLLittleBoy)localObject1, "set matchedlittleBoyReference");
          }
        }
        notifyTaskEnd();
        return;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mFaceDetectResult.vaild =");
      ((StringBuilder)localObject2).append(localFaceDetectTaskResult.vaild);
      ((StringBuilder)localObject2).append(" and mGestureDetectResult.vaild=");
      ((StringBuilder)localObject2).append(((FaceDanceDetectTask.GestureDetectTaskResult)localObject1).vaild);
      loginfo(((StringBuilder)localObject2).toString());
      notifyTaskEnd();
    }
  }
  
  public void DestoryTask() {}
  
  boolean checkIsNeedMatchExpression(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble != null)
    {
      if (paramArrayOfDouble.length != 7) {
        return false;
      }
      int j = paramArrayOfDouble.length;
      int i = 0;
      while (i < j)
      {
        if (Math.abs(paramArrayOfDouble[i] - 0.0D) > 0.0001D) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public boolean checkIsRunning()
  {
    return this.mTaskStatus != 0;
  }
  
  public void faceDetectEnd(FaceDanceDetectTask.FaceDetectTaskResult paramFaceDetectTaskResult)
  {
    if (paramFaceDetectTaskResult == null)
    {
      firstDetectFaild();
      return;
    }
    this.mFaceDetectResult = paramFaceDetectTaskResult;
    startExpressionDetect();
  }
  
  public void gestureDetectEnd(FaceDanceDetectTask.GestureDetectTaskResult paramGestureDetectTaskResult)
  {
    if (paramGestureDetectTaskResult == null)
    {
      firstDetectFaild();
      return;
    }
    this.mGestureDetectResult = paramGestureDetectTaskResult;
    startExpressionDetect();
  }
  
  public void notifyTaskEnd()
  {
    ResetTask();
    long l = this.mTaskBeginTime;
    this.mTaskBeginTime = -1L;
    if (l > 0L) {
      logTimeInfo("FaceDanceDetectTask End", l, SystemClock.elapsedRealtimeNanos());
    }
    this.mTaskStatus = 0;
  }
  
  public void setQQFilterRenderManager(QQFilterRenderManager paramQQFilterRenderManager)
  {
    this.mqqFilterRenderManager = paramQQFilterRenderManager;
  }
  
  public void updateDetectResult()
  {
    if (this.matchedlittleBoyReference != null)
    {
      GLLittleBoy localGLLittleBoy = (GLLittleBoy)this.matchedlittleBoyReference.get();
      if (localGLLittleBoy != null)
      {
        if (localGLLittleBoy.needDoMatch()) {
          localGLLittleBoy.setMatch(true);
        }
        logBoyWithMessage(localGLLittleBoy, "updateDetectResult");
      }
      this.matchedlittleBoyReference = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.facedancegame.FaceDanceDetectTask
 * JD-Core Version:    0.7.0.1
 */