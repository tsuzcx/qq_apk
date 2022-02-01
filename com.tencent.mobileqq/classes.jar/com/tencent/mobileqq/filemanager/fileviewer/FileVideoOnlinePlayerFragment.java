package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.QQVideoPlayView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;

public class FileVideoOnlinePlayerFragment
  extends IphoneTitleBarFragment
{
  private QQVideoPlayView a = null;
  
  void a()
  {
    if (getTitleBarView() != null)
    {
      getTitleBarView().setBackgroundResource(0);
      getTitleBarView().setBackgroundColor(-16777216);
    }
    BaseActivity localBaseActivity = getBaseActivity();
    if ((localBaseActivity != null) && ((localBaseActivity instanceof PublicFragmentActivity)))
    {
      PublicFragmentActivity localPublicFragmentActivity = (PublicFragmentActivity)localBaseActivity;
      SystemBarCompact localSystemBarCompact = localPublicFragmentActivity.mSystemBarComp;
      if ((localSystemBarCompact != null) && (needImmersive()) && (needStatusTrans()) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        if (ThemeUtil.isInNightMode(localPublicFragmentActivity.app))
        {
          if ((!SystemUtil.d()) && (!SystemUtil.g()))
          {
            localSystemBarCompact.setStatusBarColor(0);
            return;
          }
          localSystemBarCompact.setStatusBarColor(0);
          localSystemBarCompact.setStatusBarDarkMode(true);
          return;
        }
        if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.d()) && (!SystemUtil.g()))
        {
          localBaseActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
          localSystemBarCompact.setStatusBarColor(0);
          return;
        }
        if (!SystemUtil.g())
        {
          localSystemBarCompact.setStatusBarColor(0);
          return;
        }
        localSystemBarCompact.setStatusBarColor(0);
        localSystemBarCompact.setStatusBarDarkMode(true);
      }
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131627077;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().addFlags(1024);
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onDestroy()
  {
    this.a.releasePlayer(false);
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    a();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131445139);
    Object localObject = getBaseActivity().getIntent();
    String str1 = ((Intent)localObject).getStringExtra("fileid");
    String str2 = ((Intent)localObject).getStringExtra("url");
    localObject = ((Intent)localObject).getStringExtra("cookie");
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    localVideoPlayParam.mVideoFormat = 104;
    localVideoPlayParam.mUrls = new String[] { str2 };
    localVideoPlayParam.mCookies = new ArrayList();
    localVideoPlayParam.mCookies.add(localObject);
    localVideoPlayParam.mFileID = str1;
    localVideoPlayParam.mIsLocal = false;
    localVideoPlayParam.mIsLoop = false;
    localVideoPlayParam.mSceneId = 109;
    this.a = ((QQVideoPlayView)QQVideoViewFactory.createQQVideoPlayView(getBaseActivity(), 109L, localVideoPlayParam, null));
    localRelativeLayout.addView(this.a, -1, -1);
    this.a.play();
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileVideoOnlinePlayerFragment
 * JD-Core Version:    0.7.0.1
 */