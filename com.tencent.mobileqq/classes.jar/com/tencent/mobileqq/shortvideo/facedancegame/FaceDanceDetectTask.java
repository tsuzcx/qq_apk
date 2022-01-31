package com.tencent.mobileqq.shortvideo.facedancegame;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.os.SystemClock;
import com.tencent.aekit.openrender.internal.Frame;
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
import java.util.TreeSet;

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
    String str = "" + paramString + " ";
    paramString = str;
    if (paramGLLittleBoy != null) {
      paramString = str + "boyinfo id=" + paramGLLittleBoy.getDanceData().id + " needMatched=" + paramGLLittleBoy.needDoMatch() + " isMatched=" + paramGLLittleBoy.isMatched() + " appearTime=" + paramGLLittleBoy.getDanceData().appearTime;
    }
    loginfo(paramString);
  }
  
  public static void logFaceInfo(List<PointF> paramList, float[] paramArrayOfFloat, String paramString)
  {
    paramString = "" + paramString + " ";
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramString = paramString + "expressionFeat [";
      Iterator localIterator = paramList.iterator();
      paramList = paramString;
      if (localIterator.hasNext())
      {
        paramString = (PointF)localIterator.next();
        if (paramString == null) {
          break label448;
        }
        paramList = paramList + "\n";
        paramList = paramList + paramString.x;
        paramList = paramList + ",";
        paramList = paramList + "\n";
        paramList = paramList + paramString.y;
        paramList = paramList + ",";
      }
    }
    label443:
    label448:
    for (;;)
    {
      break;
      paramList = paramList + "\n";
      for (paramList = paramList + "]\n";; paramList = paramString + "expressionFeat is null")
      {
        paramString = paramList;
        if (paramArrayOfFloat == null) {
          break label443;
        }
        paramString = paramList;
        if (paramArrayOfFloat.length <= 0) {
          break label443;
        }
        paramList = paramList + "expressionAngle [";
        int j = paramArrayOfFloat.length;
        int i = 0;
        while (i < j)
        {
          float f = paramArrayOfFloat[i];
          paramList = paramList + "\n";
          paramList = paramList + f;
          paramList = paramList + ",";
          i += 1;
        }
      }
      paramList = paramList + "\n";
      paramString = paramList + "]\n";
      loginfo(paramString);
      return;
    }
  }
  
  public static void logTimeInfo(String paramString, long paramLong1, long paramLong2)
  {
    paramString = "" + paramString;
    double d = (paramLong2 - paramLong1) / 1000000.0D;
    paramString = paramString + " Time cost:" + d;
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
      paramString = "" + "expressionFeat [";
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        PointF localPointF = (PointF)paramList.next();
        if (localPointF == null) {
          break label707;
        }
        paramString = paramString + "\n";
        paramString = paramString + localPointF.x;
        paramString = paramString + ",";
        paramString = paramString + "\n";
        paramString = paramString + localPointF.y;
        paramString = paramString + ",";
      }
    }
    label683:
    label707:
    for (;;)
    {
      break;
      paramString = paramString + "\n";
      int j;
      int i;
      for (paramString = paramString + "]\n";; paramString = "" + "expressionFeat is null")
      {
        localHashMap.put("expressionFeat", paramString);
        if ((paramArrayOfDouble == null) || (paramArrayOfDouble.length <= 0)) {
          break label591;
        }
        paramString = "" + "expressionAngle [";
        j = paramArrayOfDouble.length;
        i = 0;
        while (i < j)
        {
          double d = paramArrayOfDouble[i];
          paramString = paramString + "\n";
          paramString = paramString + d;
          paramString = paramString + ",";
          i += 1;
        }
      }
      paramString = paramString + "\n";
      label591:
      for (paramString = paramString + "]\n";; paramString = "" + "expressionWeight is null")
      {
        localHashMap.put("expressionWeight", paramString);
        if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length <= 0)) {
          break label683;
        }
        paramString = "" + "expressionAngle [";
        j = paramArrayOfFloat.length;
        i = 0;
        while (i < j)
        {
          paramFloat = paramArrayOfFloat[i];
          paramString = paramString + "\n";
          paramString = paramString + paramFloat;
          paramString = paramString + ",";
          i += 1;
        }
      }
      paramString = paramString + "\n";
      for (paramString = paramString + "]\n";; paramString = "" + "expressionAngle is null")
      {
        localHashMap.put("expressionAngle", paramString);
        SdkContext.getInstance().getReporter().reportToBeacon("FaceDanceExpressionInfo", true, 0L, 0L, localHashMap);
        return;
      }
    }
  }
  
  private void startExpressionDetect()
  {
    if (this.mTaskStatus != 2) {}
    FaceDanceDetectTask.FaceDetectTaskResult localFaceDetectTaskResult;
    do
    {
      return;
      localFaceDetectTaskResult = this.mFaceDetectResult;
      localObject1 = this.mGestureDetectResult;
    } while ((localFaceDetectTaskResult == null) || (localObject1 == null));
    this.mTaskStatus = 3;
    if (this.littleBoyReferenceList.size() == 1)
    {
      localObject2 = (GLLittleBoy)((WeakReference)this.littleBoyReferenceList.get(0)).get();
      if ((localObject2 != null) && (((GLLittleBoy)localObject2).isReadyMatch) && (!((GLLittleBoy)localObject2).isMatched()))
      {
        if (localFaceDetectTaskResult.vaild) {
          this.matchedlittleBoyReference = new WeakReference(localObject2);
        }
        loginfo("mFaceDetectResult.vaild =" + localFaceDetectTaskResult.vaild + " and tempboy.isReadyMatch=" + ((GLLittleBoy)localObject2).isReadyMatch);
        notifyTaskEnd();
        return;
      }
    }
    if ((!localFaceDetectTaskResult.vaild) || (!((FaceDanceDetectTask.GestureDetectTaskResult)localObject1).vaild))
    {
      loginfo("mFaceDetectResult.vaild =" + localFaceDetectTaskResult.vaild + " and mGestureDetectResult.vaild=" + ((FaceDanceDetectTask.GestureDetectTaskResult)localObject1).vaild);
      notifyTaskEnd();
      return;
    }
    loginfo("mFaceDetectResult.vaild and mGestureDetectResult.vaild mGestureDetectResult.type=" + ((FaceDanceDetectTask.GestureDetectTaskResult)localObject1).type);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = this.littleBoyReferenceList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (GLLittleBoy)((WeakReference)((Iterator)localObject2).next()).get();
      if ((localObject3 != null) && (((GLLittleBoy)localObject3).needDoMatch()))
      {
        Object localObject4 = ((GLLittleBoy)localObject3).getDanceData();
        localObject4 = ResourceManager.getInstance().getPostureById(((ResourceManager.DancePosture)localObject4).id);
        if ((localObject4 != null) && (((ResourceManager.Posture)localObject4).faceDanceConfig.mGestureType.equals(((FaceDanceDetectTask.GestureDetectTaskResult)localObject1).type)))
        {
          logBoyWithMessage((GLLittleBoy)localObject3, "startExpressionDetect has boy equals");
          localArrayList.add(localObject3);
        }
      }
    }
    loginfo("tempBoyList.size() ==" + localArrayList.size() + " mGestureDetectResult.type=" + ((FaceDanceDetectTask.GestureDetectTaskResult)localObject1).type);
    if (localArrayList.size() == 0)
    {
      notifyTaskEnd();
      notifyTaskEnd();
      return;
    }
    float f1 = 0.0F;
    int i = 0;
    Object localObject1 = null;
    label442:
    long l1;
    if (i < localArrayList.size())
    {
      l1 = SystemClock.elapsedRealtimeNanos();
      localObject2 = (GLLittleBoy)localArrayList.get(i);
      localObject3 = ((GLLittleBoy)localObject2).getDanceData();
      localObject3 = ResourceManager.getInstance().getPostureById(((ResourceManager.DancePosture)localObject3).id);
      if (localObject3 != null) {}
    }
    for (;;)
    {
      i += 1;
      break label442;
      localObject3 = ((ResourceManager.Posture)localObject3).faceDanceConfig;
      float f2 = ActUtil.getExpressionSimilarity(((FaceDanceTemplateConfig)localObject3).mExpressionConfig.expressionFeat, localFaceDetectTaskResult.pointFs, ((FaceDanceTemplateConfig)localObject3).mExpressionConfig.expressionAngle, localFaceDetectTaskResult.angles, ((FaceDanceTemplateConfig)localObject3).mExpressionConfig.expressionWeight);
      logBoyWithMessage((GLLittleBoy)localObject2, "match expression score=" + f2);
      long l2 = SystemClock.elapsedRealtimeNanos();
      logTimeInfo("ActUtil.getExpressionSimilarity No:" + i + " boy", l1, l2);
      if (f2 > 95.0F) {
        reportHighScoreLittelBoy(((FaceDanceTemplateConfig)localObject3).mExpressionConfig.expressionID, f2, localFaceDetectTaskResult.pointFs, localFaceDetectTaskResult.angles, ((FaceDanceTemplateConfig)localObject3).mExpressionConfig.expressionWeight);
      }
      if (!checkIsNeedMatchExpression(((FaceDanceTemplateConfig)localObject3).mExpressionConfig.expressionWeight))
      {
        logBoyWithMessage((GLLittleBoy)localObject2, " not NeedMatchExpression");
        f2 = 100.0F;
      }
      if ((f2 >= ((FaceDanceTemplateConfig)localObject3).threshold) && (f2 > f1))
      {
        f1 = f2;
        localObject1 = localObject2;
        continue;
        if (localObject1 == null) {
          break;
        }
        this.matchedlittleBoyReference = new WeakReference(localObject1);
        logBoyWithMessage((GLLittleBoy)localObject1, "set matchedlittleBoyReference");
        break;
      }
    }
  }
  
  public void DestoryTask() {}
  
  boolean checkIsNeedMatchExpression(double[] paramArrayOfDouble)
  {
    if ((paramArrayOfDouble == null) || (paramArrayOfDouble.length != 7)) {}
    for (;;)
    {
      return false;
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
  
  public void postTask(byte[] paramArrayOfByte, Frame paramFrame, int paramInt1, int paramInt2, TreeSet<GLLittleBoy> paramTreeSet)
  {
    if ((this.mqqFilterRenderManager == null) || (paramArrayOfByte == null) || (paramFrame == null) || (paramTreeSet == null) || (paramTreeSet.size() == 0)) {
      return;
    }
    this.mTaskStatus = 1;
    ResetTask();
    this.mTaskBeginTime = SystemClock.elapsedRealtimeNanos();
    paramTreeSet = paramTreeSet.iterator();
    while (paramTreeSet.hasNext())
    {
      GLLittleBoy localGLLittleBoy = (GLLittleBoy)paramTreeSet.next();
      this.littleBoyReferenceList.add(new WeakReference(localGLLittleBoy));
    }
    this.mTaskStatus = 2;
    this.mqqFilterRenderManager.doAEDetectWithCallBack(paramFrame, paramInt1, paramInt2, this);
    GestureDetectManager.getInstance().doGestureDetectWithCallBack(paramArrayOfByte, paramInt1, paramInt2, this);
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