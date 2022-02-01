package com.tencent.mobileqq.cmshow.brickengine;

import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.ReentrantLock;
import org.jetbrains.annotations.NotNull;

public class BKUtils
{
  @NotNull
  public static RectF a(String paramString, ApolloRender paramApolloRender)
  {
    RectF localRectF = new RectF();
    ReentrantLock localReentrantLock = ApolloRender.getLock();
    QLog.d("ApolloLock", 2, "onGetDressRect");
    localReentrantLock.lock();
    if (paramApolloRender != null) {
      try
      {
        paramString = paramApolloRender.getSavaWrapper().getDressRect(paramString);
        if (paramString != null)
        {
          localRectF.left = paramString.left;
          localRectF.bottom = paramString.top;
          paramString.top += paramString.bottom;
          paramString.right += paramString.left;
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("x:");
            paramString.append(localRectF.left);
            paramString.append(",deltaY:");
            paramString.append(localRectF.top);
            paramString.append(",width:");
            paramString.append(localRectF.right);
            paramString.append(",height:");
            paramString.append(localRectF.bottom);
            QLog.d("[cmshow]BKUtils", 2, paramString.toString());
          }
        }
      }
      finally
      {
        localReentrantLock.unlock();
      }
    }
    localReentrantLock.unlock();
    return localRectF;
  }
  
  public static void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if ((paramView.getParent() instanceof ViewGroup)) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.BKUtils
 * JD-Core Version:    0.7.0.1
 */