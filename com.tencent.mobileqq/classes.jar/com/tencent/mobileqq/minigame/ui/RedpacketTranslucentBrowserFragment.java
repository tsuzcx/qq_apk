package com.tencent.mobileqq.minigame.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;

public class RedpacketTranslucentBrowserFragment
  extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
{
  public static final String TAG = "WebLog_RedpacketTranslucentBrowserFragment";
  
  public int doCreateLoopStep_InitUIContent(Bundle paramBundle)
  {
    int i;
    try
    {
      DisplayUtil.setActivityFullScreen(super.getActivity());
      super.getActivity().getWindow().addFlags(1024);
      if (Build.VERSION.SDK_INT >= 28)
      {
        View localView = super.getActivity().getWindow().getDecorView();
        WindowManager.LayoutParams localLayoutParams = super.getActivity().getWindow().getAttributes();
        localLayoutParams.layoutInDisplayCutoutMode = 1;
        super.getActivity().getWindow().setAttributes(localLayoutParams);
        i = localView.getSystemUiVisibility();
        super.getActivity().getWindow().getDecorView().setSystemUiVisibility(i | 0x400);
      }
      i = super.doCreateLoopStep_InitUIContent(paramBundle);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          boolean bool = super.getActivity().getIntent().getExtras().getBoolean("isLandScape");
          QLog.d("WebLog_RedpacketTranslucentBrowserFragment", 1, "isLandScape in fragment is" + bool);
          if (bool)
          {
            QLog.d("WebLog_RedpacketTranslucentBrowserFragment", 1, "使用redpacket自己的fragment，设置背景图片");
            super.getActivity().getWindow().setBackgroundDrawableResource(2130841368);
          }
          return i;
        }
        catch (Exception paramBundle)
        {
          QLog.e("WebLog_RedpacketTranslucentBrowserFragment", 1, "RedpacketTranslucentBrowserFragment error", paramBundle);
        }
        localException = localException;
        QLog.e("WebLog_RedpacketTranslucentBrowserFragment", 1, "set fullscreen error", localException);
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.RedpacketTranslucentBrowserFragment
 * JD-Core Version:    0.7.0.1
 */