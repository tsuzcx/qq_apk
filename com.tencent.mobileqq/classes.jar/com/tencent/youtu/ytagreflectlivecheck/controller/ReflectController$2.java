package com.tencent.youtu.ytagreflectlivecheck.controller;

import android.graphics.ColorMatrixColorFilter;
import com.tencent.youtu.ytagreflectlivecheck.jni.JNIUtils;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.ProcessResult;
import com.tencent.youtu.ytagreflectlivecheck.worker.TimerWorker;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import java.util.Timer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ReflectController$2
  extends TimerWorker
{
  ReflectController$2(ReflectController paramReflectController, long paramLong1, long paramLong2, int paramInt, JSONArray paramJSONArray)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    try
    {
      YTLogger.i("YoutuLightLiveCheck", "finish timer.");
      ReflectController.access$702(this.this$0, 0);
      ReflectController.access$1302(this.this$0, System.currentTimeMillis());
      ReflectController.access$1200(this.this$0, ReflectController.DEFAULT_MATRIX_COLOR_FILTER);
      YTLogger.i("mCountDownTimer", "setColorMatrixColorFilter:" + (System.currentTimeMillis() - ReflectController.access$1300(this.this$0)));
      ReflectController.access$1400(this.this$0, 1);
      YTLogger.i("mCountDownTimer", "changeState:" + (System.currentTimeMillis() - ReflectController.access$1300(this.this$0)));
      new Timer().schedule(new ReflectController.2.1(this), 400L);
      ReflectController.access$1500(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      YTException.report(localException);
      ReflectController.access$1800(this.this$0).onFailed(ReflectController.access$1600(), "Finish check failed. ", "Check error report to get more information.", ReflectController.access$1700(this.this$0));
    }
  }
  
  public void onTick(long paramLong)
  {
    ReflectController.access$102(this.this$0, System.currentTimeMillis());
    YTLogger.i("mCountDownTimer", "unit:" + this.val$unit + " | real unit:" + (ReflectController.access$100(this.this$0) - ReflectController.access$200(this.this$0)));
    ReflectController.access$202(this.this$0, ReflectController.access$100(this.this$0));
    for (;;)
    {
      float f1;
      float f2;
      float f3;
      float f4;
      try
      {
        YTLogger.d("YoutuLightLiveCheck", "startTimer.onTick. mFrame: " + ReflectController.access$300(this.this$0));
        if (ReflectController.access$300(this.this$0) == ReflectController.access$400(this.this$0))
        {
          YTLogger.i("YoutuLightLiveCheck", "change color begin. mFrame: " + ReflectController.access$300(this.this$0));
          YTAGReflectLiveCheckJNIInterface.getInstance().FRSetBegin(JNIUtils.getTimeval());
          JSONObject localJSONObject = this.val$jsonArray.getJSONObject(ReflectController.access$300(this.this$0));
          f1 = (float)localJSONObject.getDouble("R");
          f2 = (float)localJSONObject.getDouble("G");
          f3 = (float)localJSONObject.getDouble("B");
          f4 = (float)localJSONObject.getDouble("A");
          ReflectController.access$702(this.this$0, 0);
          if ((f1 != ReflectController.access$800(this.this$0)) || (f2 != ReflectController.access$900(this.this$0)) || (f3 != ReflectController.access$1000(this.this$0)) || (f4 != ReflectController.access$1100(this.this$0))) {
            break label419;
          }
          YTLogger.i("YoutuLightLiveCheck", "[ReflectController.onTick] rgba: keep bef");
          ReflectController.access$308(this.this$0);
          return;
        }
        if (ReflectController.access$300(this.this$0) == ReflectController.access$500(this.this$0))
        {
          YTLogger.i("YoutuLightLiveCheck", "change color end. mFrame: " + ReflectController.access$300(this.this$0));
          YTAGReflectLiveCheckJNIInterface.getInstance().FRSetEnd(JNIUtils.getTimeval());
          continue;
        }
        if (ReflectController.access$300(this.this$0) != ReflectController.access$600(this.this$0)) {
          continue;
        }
      }
      catch (JSONException localJSONException)
      {
        YTException.report(localJSONException);
        return;
      }
      YTLogger.i("YoutuLightLiveCheck", "change color point. mFrame: " + ReflectController.access$300(this.this$0));
      YTAGReflectLiveCheckJNIInterface.getInstance().FRSetChangePointTime(JNIUtils.getTimeval());
      continue;
      label419:
      YTLogger.i("YoutuLightLiveCheck", "[ReflectController.onTick] rgba: " + f1 + " " + f2 + " " + f3 + " " + f4);
      ReflectController.access$1200(this.this$0, new ColorMatrixColorFilter(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f1, 0.0F, 0.0F, 0.0F, 0.0F, f2, 0.0F, 0.0F, 0.0F, 0.0F, f3, 0.0F, 0.0F, 0.0F, f4, 0.0F }));
      ReflectController.access$802(this.this$0, f1);
      ReflectController.access$902(this.this$0, f2);
      ReflectController.access$1002(this.this$0, f3);
      ReflectController.access$1102(this.this$0, f4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.controller.ReflectController.2
 * JD-Core Version:    0.7.0.1
 */