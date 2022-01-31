package com.tencent.mobileqq.prediction;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class PredictionReporter
{
  private static HashMap a = new HashMap();
  
  public static void a(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("business_type", String.valueOf(paramInt1));
    localHashMap.put("prediction_step", String.valueOf(paramInt2));
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actPredictionData", true, 0L, 0L, localHashMap, "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo.getBitValue(1) == 1) {}
    long l;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPredictionEvaluator", 2, "msgViewedInAIO, size=" + a.size());
      }
      l = System.currentTimeMillis();
    } while ((a.containsKey(Long.valueOf(paramMessageForShortVideo.uniseq))) || (a.size() >= 24));
    paramQQAppInterface = new PredictionReporter.EvaluatorInfo(paramQQAppInterface, paramMessageForShortVideo, l, 0L);
    a.put(Long.valueOf(paramMessageForShortVideo.uniseq), paramQQAppInterface);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo.getBitValue(1) == 1) {}
    long l;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPredictionEvaluator", 2, "msgClicked, size=" + a.size());
        }
        l = System.currentTimeMillis();
      } while (!a.containsKey(Long.valueOf(paramMessageForShortVideo.uniseq)));
      paramQQAppInterface = (PredictionReporter.EvaluatorInfo)a.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
    } while (paramQQAppInterface == null);
    paramQQAppInterface.a(l);
    paramQQAppInterface.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.prediction.PredictionReporter
 * JD-Core Version:    0.7.0.1
 */