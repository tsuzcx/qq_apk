package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
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
    FragmentActivity localFragmentActivity = getActivity();
    SystemBarCompact localSystemBarCompact;
    if ((localFragmentActivity != null) && ((localFragmentActivity instanceof PublicFragmentActivity)))
    {
      localSystemBarCompact = ((PublicFragmentActivity)localFragmentActivity).mSystemBarComp;
      if ((localSystemBarCompact != null) && (needImmersive()) && (needStatusTrans()) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        if (!ThemeUtil.isInNightMode(((PublicFragmentActivity)localFragmentActivity).app)) {
          break label115;
        }
        if ((SystemUtil.b()) || (SystemUtil.d())) {
          break label104;
        }
        localSystemBarCompact.setStatusBarColor(0);
      }
    }
    return;
    label104:
    localSystemBarCompact.setStatusBarColor(0);
    localSystemBarCompact.setStatusBarDarkMode(true);
    return;
    label115:
    if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
    {
      localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
      localSystemBarCompact.setStatusBarColor(0);
      return;
    }
    if (!SystemUtil.d())
    {
      localSystemBarCompact.setStatusBarColor(0);
      return;
    }
    localSystemBarCompact.setStatusBarColor(0);
    localSystemBarCompact.setStatusBarDarkMode(true);
  }
  
  public int getContentLayoutId()
  {
    return 2131560944;
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
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131377357);
    Object localObject = getActivity().getIntent();
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
    this.a = ((QQVideoPlayView)QQVideoViewFactory.a(getActivity(), 109L, localVideoPlayParam, null));
    localRelativeLayout.addView(this.a, -1, -1);
    this.a.play();
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileVideoOnlinePlayerFragment
 * JD-Core Version:    0.7.0.1
 */