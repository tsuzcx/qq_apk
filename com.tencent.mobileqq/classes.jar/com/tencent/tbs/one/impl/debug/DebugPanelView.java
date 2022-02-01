package com.tencent.tbs.one.impl.debug;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.tbs.one.impl.common.CommonUtils;

public class DebugPanelView
  extends FrameLayout
{
  private static final String FAILURE_DESCRIPTION = "加载调试组件失败，请稍后重试";
  private static final String PROGRESS_DESCRIPTION_FORMAT = "已加载 %d";
  private static final String SUCCESS_DESCRIPTION = "加载调试组件成功";
  private final String mCategory;
  private TextView mProgressView;
  private Handler mUIHandler = new Handler(Looper.getMainLooper());
  
  public DebugPanelView(@NonNull Context paramContext, String paramString)
  {
    super(paramContext);
    this.mCategory = paramString;
    this.mProgressView = new TextView(paramContext);
    paramString = new FrameLayout.LayoutParams(-2, -2);
    paramString.gravity = 17;
    addView(this.mProgressView, paramString);
    CommonUtils.loadDebugPlugin(paramContext, new DebugPanelView.1(this));
  }
  
  private void removeProgressView()
  {
    removeView(this.mProgressView);
  }
  
  private void runOnUIThread(Runnable paramRunnable)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramRunnable.run();
      return;
    }
    this.mUIHandler.post(paramRunnable);
  }
  
  private void showToast(String paramString)
  {
    Toast.makeText(getContext(), paramString, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.debug.DebugPanelView
 * JD-Core Version:    0.7.0.1
 */