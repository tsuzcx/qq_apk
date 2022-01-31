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
import java.util.TreeSet;

@SuppressLint({"NewApi"})
public class FaceDanceDetectTask
  implements IFaceDetectCallBack, IGestureDetectCallBack
{
  private static FaceDanceDetectTask jdField_a_of_type_ComTencentMobileqqShortvideoFacedancegameFaceDanceDetectTask = new FaceDanceDetectTask();
  private volatile int jdField_a_of_type_Int = 0;
  private volatile long jdField_a_of_type_Long = -1L;
  private volatile FaceDanceDetectTask.FaceDetectTaskResult jdField_a_of_type_ComTencentMobileqqShortvideoFacedancegameFaceDanceDetectTask$FaceDetectTaskResult = null;
  private volatile FaceDanceDetectTask.GestureDetectTaskResult jdField_a_of_type_ComTencentMobileqqShortvideoFacedancegameFaceDanceDetectTask$GestureDetectTaskResult = null;
  QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
  volatile WeakReference jdField_a_of_type_JavaLangRefWeakReference = null;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static FaceDanceDetectTask a()
  {
    return jdField_a_of_type_ComTencentMobileqqShortvideoFacedancegameFaceDanceDetectTask;
  }
  
  public static void a(GLLittleBoy paramGLLittleBoy, String paramString)
  {
    String str = "" + paramString + " ";
    paramString = str;
    if (paramGLLittleBoy != null) {
      paramString = str + "boyinfo id=" + paramGLLittleBoy.a().jdField_a_of_type_JavaLangString + " needMatched=" + paramGLLittleBoy.b() + " isMatched=" + paramGLLittleBoy.c() + " appearTime=" + paramGLLittleBoy.a().jdField_a_of_type_Double;
    }
    a(paramString);
  }
  
  public static void a(String paramString)
  {
    if (SLog.a()) {
      SLog.d("FaceDanceDetectTask", paramString);
    }
  }
  
  static void a(String paramString, float paramFloat, List paramList, float[] paramArrayOfFloat, double[] paramArrayOfDouble)
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
        SdkContext.a().a().a("FaceDanceExpressionInfo", true, 0L, 0L, localHashMap);
        return;
      }
    }
  }
  
  public static void a(String paramString, long paramLong1, long paramLong2)
  {
    paramString = "" + paramString;
    double d = (paramLong2 - paramLong1) / 1000000.0D;
    paramString = paramString + " Time cost:" + d;
    if (SLog.a()) {
      SLog.d("FaceDanceDetectTaskTime", paramString);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFacedancegameFaceDanceDetectTask$GestureDetectTaskResult = null;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFacedancegameFaceDanceDetectTask$FaceDetectTaskResult = null;
  }
  
  private void e()
  {
    b();
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Int != 2) {}
    FaceDanceDetectTask.FaceDetectTaskResult localFaceDetectTaskResult;
    do
    {
      return;
      localFaceDetectTaskResult = this.jdField_a_of_type_ComTencentMobileqqShortvideoFacedancegameFaceDanceDetectTask$FaceDetectTaskResult;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFacedancegameFaceDanceDetectTask$GestureDetectTaskResult;
    } while ((localFaceDetectTaskResult == null) || (localObject1 == null));
    this.jdField_a_of_type_Int = 3;
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      localObject2 = (GLLittleBoy)((WeakReference)this.jdField_a_of_type_JavaUtilList.get(0)).get();
      if ((localObject2 != null) && (((GLLittleBoy)localObject2).g) && (!((GLLittleBoy)localObject2).c()))
      {
        if (localFaceDetectTaskResult.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject2);
        }
        a("mFaceDetectResult.vaild =" + localFaceDetectTaskResult.jdField_a_of_type_Boolean + " and tempboy.isReadyMatch=" + ((GLLittleBoy)localObject2).g);
        b();
        return;
      }
    }
    if ((!localFaceDetectTaskResult.jdField_a_of_type_Boolean) || (!((FaceDanceDetectTask.GestureDetectTaskResult)localObject1).jdField_a_of_type_Boolean))
    {
      a("mFaceDetectResult.vaild =" + localFaceDetectTaskResult.jdField_a_of_type_Boolean + " and mGestureDetectResult.vaild=" + ((FaceDanceDetectTask.GestureDetectTaskResult)localObject1).jdField_a_of_type_Boolean);
      b();
      return;
    }
    a("mFaceDetectResult.vaild and mGestureDetectResult.vaild mGestureDetectResult.type=" + ((FaceDanceDetectTask.GestureDetectTaskResult)localObject1).jdField_a_of_type_JavaLangString);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (GLLittleBoy)((WeakReference)((Iterator)localObject2).next()).get();
      if ((localObject3 != null) && (((GLLittleBoy)localObject3).b()))
      {
        Object localObject4 = ((GLLittleBoy)localObject3).a();
        localObject4 = ResourceManager.a().a(((ResourceManager.DancePosture)localObject4).jdField_a_of_type_JavaLangString);
        if ((localObject4 != null) && (((ResourceManager.Posture)localObject4).a.b.equals(((FaceDanceDetectTask.GestureDetectTaskResult)localObject1).jdField_a_of_type_JavaLangString)))
        {
          a((GLLittleBoy)localObject3, "startExpressionDetect has boy equals");
          localArrayList.add(localObject3);
        }
      }
    }
    a("tempBoyList.size() ==" + localArrayList.size() + " mGestureDetectResult.type=" + ((FaceDanceDetectTask.GestureDetectTaskResult)localObject1).jdField_a_of_type_JavaLangString);
    if (localArrayList.size() == 0)
    {
      b();
      b();
      return;
    }
    float f1 = 0.0F;
    int i = 0;
    Object localObject1 = null;
    label437:
    long l1;
    if (i < localArrayList.size())
    {
      l1 = SystemClock.elapsedRealtimeNanos();
      localObject2 = (GLLittleBoy)localArrayList.get(i);
      localObject3 = ((GLLittleBoy)localObject2).a();
      localObject3 = ResourceManager.a().a(((ResourceManager.DancePosture)localObject3).jdField_a_of_type_JavaLangString);
      if (localObject3 != null) {}
    }
    for (;;)
    {
      i += 1;
      break label437;
      localObject3 = ((ResourceManager.Posture)localObject3).a;
      float f2 = ActUtil.a(((FaceDanceTemplateConfig)localObject3).jdField_a_of_type_ComTencentMobileqqShortvideoFacedancegameExpressionTemplateConfig.jdField_a_of_type_JavaUtilList, localFaceDetectTaskResult.jdField_a_of_type_JavaUtilList, ((FaceDanceTemplateConfig)localObject3).jdField_a_of_type_ComTencentMobileqqShortvideoFacedancegameExpressionTemplateConfig.jdField_a_of_type_ArrayOfFloat, localFaceDetectTaskResult.jdField_a_of_type_ArrayOfFloat, ((FaceDanceTemplateConfig)localObject3).jdField_a_of_type_ComTencentMobileqqShortvideoFacedancegameExpressionTemplateConfig.jdField_a_of_type_ArrayOfDouble);
      a((GLLittleBoy)localObject2, "match expression score=" + f2);
      long l2 = SystemClock.elapsedRealtimeNanos();
      a("ActUtil.getExpressionSimilarity No:" + i + " boy", l1, l2);
      if (f2 > 95.0F) {
        a(((FaceDanceTemplateConfig)localObject3).jdField_a_of_type_ComTencentMobileqqShortvideoFacedancegameExpressionTemplateConfig.jdField_a_of_type_JavaLangString, f2, localFaceDetectTaskResult.jdField_a_of_type_JavaUtilList, localFaceDetectTaskResult.jdField_a_of_type_ArrayOfFloat, ((FaceDanceTemplateConfig)localObject3).jdField_a_of_type_ComTencentMobileqqShortvideoFacedancegameExpressionTemplateConfig.jdField_a_of_type_ArrayOfDouble);
      }
      if (!a(((FaceDanceTemplateConfig)localObject3).jdField_a_of_type_ComTencentMobileqqShortvideoFacedancegameExpressionTemplateConfig.jdField_a_of_type_ArrayOfDouble))
      {
        a((GLLittleBoy)localObject2, " not NeedMatchExpression");
        f2 = 100.0F;
      }
      if ((f2 >= ((FaceDanceTemplateConfig)localObject3).jdField_a_of_type_Float) && (f2 > f1))
      {
        f1 = f2;
        localObject1 = localObject2;
        continue;
        if (localObject1 == null) {
          break;
        }
        this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject1);
        a((GLLittleBoy)localObject1, "set matchedlittleBoyReference");
        break;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      GLLittleBoy localGLLittleBoy = (GLLittleBoy)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localGLLittleBoy != null)
      {
        if (localGLLittleBoy.b()) {
          localGLLittleBoy.b(true);
        }
        a(localGLLittleBoy, "updateDetectResult");
      }
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
  
  public void a(FaceDanceDetectTask.FaceDetectTaskResult paramFaceDetectTaskResult)
  {
    if (paramFaceDetectTaskResult == null)
    {
      e();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFacedancegameFaceDanceDetectTask$FaceDetectTaskResult = paramFaceDetectTaskResult;
    f();
  }
  
  public void a(FaceDanceDetectTask.GestureDetectTaskResult paramGestureDetectTaskResult)
  {
    if (paramGestureDetectTaskResult == null)
    {
      e();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFacedancegameFaceDanceDetectTask$GestureDetectTaskResult = paramGestureDetectTaskResult;
    f();
  }
  
  public void a(QQFilterRenderManager paramQQFilterRenderManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = paramQQFilterRenderManager;
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, TreeSet paramTreeSet)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == null) || (paramArrayOfByte1 == null) || (paramArrayOfByte2 == null) || (paramTreeSet == null) || (paramTreeSet.size() == 0)) {
      return;
    }
    this.jdField_a_of_type_Int = 1;
    d();
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
    paramTreeSet = paramTreeSet.iterator();
    while (paramTreeSet.hasNext())
    {
      GLLittleBoy localGLLittleBoy = (GLLittleBoy)paramTreeSet.next();
      this.jdField_a_of_type_JavaUtilList.add(new WeakReference(localGLLittleBoy));
    }
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(paramArrayOfByte2, paramInt1, paramInt2, this);
    GestureDetectManager.a().a(paramArrayOfByte1, paramInt1, paramInt2, this);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int != 0;
  }
  
  boolean a(double[] paramArrayOfDouble)
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
  
  public void b()
  {
    d();
    long l = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Long = -1L;
    if (l > 0L) {
      a("FaceDanceDetectTask End", l, SystemClock.elapsedRealtimeNanos());
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.facedancegame.FaceDanceDetectTask
 * JD-Core Version:    0.7.0.1
 */