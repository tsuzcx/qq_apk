package com.tencent.mobileqq.minigame.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.qphone.base.util.QLog;

public class RedpacketTranslucentBrowserFragment
  extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
{
  public static final String TAG = "WebLog_RedpacketTranslucentBrowserFragment";
  
  public void onInitUIContent(Bundle paramBundle, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    try
    {
      DisplayUtil.setActivityFullScreen(super.getQBaseActivity());
      super.getQBaseActivity().getWindow().addFlags(1024);
      if (Build.VERSION.SDK_INT >= 28)
      {
        View localView = super.getQBaseActivity().getWindow().getDecorView();
        WindowManager.LayoutParams localLayoutParams = super.getQBaseActivity().getWindow().getAttributes();
        localLayoutParams.layoutInDisplayCutoutMode = 1;
        super.getQBaseActivity().getWindow().setAttributes(localLayoutParams);
        int i = localView.getSystemUiVisibility();
        super.getQBaseActivity().getWindow().getDecorView().setSystemUiVisibility(i | 0x400);
      }
    }
    catch (Exception localException)
    {
      QLog.e("WebLog_RedpacketTranslucentBrowserFragment", 1, "set fullscreen error", localException);
    }
    super.onInitUIContent(paramBundle, paramWebViewKernelCallBack);
    try
    {
      boolean bool = super.getQBaseActivity().getIntent().getExtras().getBoolean("isLandScape");
      paramBundle = new StringBuilder();
      paramBundle.append("isLandScape in fragment is");
      paramBundle.append(bool);
      QLog.d("WebLog_RedpacketTranslucentBrowserFragment", 1, paramBundle.toString());
      if (bool)
      {
        QLog.d("WebLog_RedpacketTranslucentBrowserFragment", 1, "使用redpacket自己的fragment，设置背景图片");
        super.getQBaseActivity().getWindow().setBackgroundDrawableResource(2130842040);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      QLog.e("WebLog_RedpacketTranslucentBrowserFragment", 1, "RedpacketTranslucentBrowserFragment error", paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.RedpacketTranslucentBrowserFragment
 * JD-Core Version:    0.7.0.1
 */