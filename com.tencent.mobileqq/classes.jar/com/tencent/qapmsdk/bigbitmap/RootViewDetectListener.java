package com.tencent.qapmsdk.bigbitmap;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qapmsdk.bigbitmap.datainfo.ExceedBitmapInfo;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.common.util.ClassUtil;
import java.lang.ref.WeakReference;
import java.util.List;

class RootViewDetectListener
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private static final Long DETECT_DELAY = Long.valueOf(1000L);
  private static final int MSG_GLOBAL_LAYOUT_CHANGED = 0;
  private static final String TAG = "QAPM_bigbitmap_RootViewDetectListener";
  private String actName;
  private Detector detector;
  private Handler handler = new RootViewDetectListener.1(this, ThreadManager.getMonitorThreadLooper());
  private WeakReference<View> rootViewRef;
  
  RootViewDetectListener(String paramString, View paramView, Detector paramDetector)
  {
    this.actName = paramString;
    this.rootViewRef = new WeakReference(paramView);
    this.detector = paramDetector;
  }
  
  private void detectView(List<ExceedBitmapInfo> paramList, String paramString1, String paramString2, View paramView)
  {
    if ((paramView != null) && (paramView.getVisibility() != 8) && (paramView.getWidth() > 0))
    {
      if (paramView.getHeight() <= 0) {
        return;
      }
      this.detector.detect(paramList, paramString1, paramString2, paramView);
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        if (paramView.getChildCount() > 0)
        {
          int i = 0;
          while (i < paramView.getChildCount())
          {
            View localView = paramView.getChildAt(i);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString2);
            localStringBuilder.append(" -> ");
            localStringBuilder.append(ClassUtil.getClassName(localView, Integer.valueOf(i)));
            detectView(paramList, paramString1, localStringBuilder.toString(), localView);
            i += 1;
          }
        }
      }
    }
  }
  
  public void onGlobalLayout()
  {
    this.handler.removeMessages(0);
    this.handler.sendEmptyMessageDelayed(0, DETECT_DELAY.longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.bigbitmap.RootViewDetectListener
 * JD-Core Version:    0.7.0.1
 */