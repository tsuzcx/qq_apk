package com.tencent.rmonitor.bigbitmap;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.rmonitor.base.plugin.listener.IBaseListener;
import com.tencent.rmonitor.base.plugin.listener.ListenerManager;
import com.tencent.rmonitor.base.plugin.listener.MonitorListenerMng;
import com.tencent.rmonitor.bigbitmap.datainfo.ExceedBitmapInfo;
import com.tencent.rmonitor.bigbitmap.listener.BitmapExceedListener;
import com.tencent.rmonitor.bigbitmap.listener.IBitmapExceedListener;
import com.tencent.rmonitor.common.thread.ThreadManager;
import com.tencent.rmonitor.common.util.ClassUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RootViewDetectListener
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private static final Long a = Long.valueOf(1000L);
  private final String b;
  private final WeakReference<View> c;
  private final BigBitmapDetector d;
  private final BitmapExceedListener e = new BitmapExceedListener();
  private final Handler f = new RootViewDetectListener.1(this, ThreadManager.e());
  
  public RootViewDetectListener(String paramString, View paramView, BigBitmapDetector paramBigBitmapDetector)
  {
    this.b = paramString;
    this.c = new WeakReference(paramView);
    this.d = paramBigBitmapDetector;
  }
  
  private void a(List<ExceedBitmapInfo> paramList)
  {
    this.e.a(paramList);
    Iterator localIterator = ListenerManager.h.a().iterator();
    while (localIterator.hasNext())
    {
      IBaseListener localIBaseListener = (IBaseListener)localIterator.next();
      if ((localIBaseListener instanceof IBitmapExceedListener)) {
        ((IBitmapExceedListener)localIBaseListener).a(paramList);
      }
    }
  }
  
  private void a(List<ExceedBitmapInfo> paramList, String paramString1, String paramString2, View paramView)
  {
    if ((paramView != null) && (paramView.getVisibility() != 8) && (paramView.getWidth() > 0))
    {
      if (paramView.getHeight() <= 0) {
        return;
      }
      this.d.a(paramList, paramString1, paramString2, paramView);
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        if (paramView.getChildCount() > 0)
        {
          int i = 0;
          while (i < paramView.getChildCount())
          {
            View localView = paramView.getChildAt(i);
            if (localView != null)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramString2);
              localStringBuilder.append(" -> ");
              localStringBuilder.append(ClassUtil.a(localView, Integer.valueOf(i)));
              a(paramList, paramString1, localStringBuilder.toString(), localView);
            }
            i += 1;
          }
        }
      }
    }
  }
  
  public void onGlobalLayout()
  {
    this.f.removeMessages(0);
    this.f.sendEmptyMessageDelayed(0, a.longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.bigbitmap.RootViewDetectListener
 * JD-Core Version:    0.7.0.1
 */