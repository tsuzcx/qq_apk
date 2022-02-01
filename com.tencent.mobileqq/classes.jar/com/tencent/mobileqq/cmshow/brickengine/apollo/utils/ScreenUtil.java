package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import mqq.os.MqqHandler;

public class ScreenUtil
{
  public static void a(int paramInt)
  {
    View localView = ApolloRender.getCurrentRenderView();
    if (localView == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new ScreenUtil.1(localView, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.ScreenUtil
 * JD-Core Version:    0.7.0.1
 */