package com.tencent.mobileqq.extendfriend.apollo.aio;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.statistics.ReportController;

public class AioApolloHelper
{
  public static void a(QQAppInterface paramQQAppInterface, UniteGrayTipParam paramUniteGrayTipParam)
  {
    if (paramUniteGrayTipParam.b == 459817)
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800B445", "0X800B445", 0, 0, "", "", "", "");
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800B446", "0X800B446", 2, 0, "", "", "", "");
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.apollo.aio.AioApolloHelper
 * JD-Core Version:    0.7.0.1
 */