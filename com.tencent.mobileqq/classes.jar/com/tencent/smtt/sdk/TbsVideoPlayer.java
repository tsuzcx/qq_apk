package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tbs.video.interfaces.IUserStateChangedListener;
import com.tencent.tbs.video.interfaces.IUserStateHolder;

class TbsVideoPlayer
{
  private static TbsVideoPlayer sInstance = null;
  Context mAppContext;
  TbsVideoView mTbsVideoView = null;
  IUserStateHolder mUserStateHolder;
  IUserStateChangedListener mUserStateListener;
  
  private TbsVideoPlayer(Context paramContext)
  {
    this.mAppContext = paramContext.getApplicationContext();
    this.mTbsVideoView = new TbsVideoView(this.mAppContext);
  }
  
  public static TbsVideoPlayer getInstance(Context paramContext)
  {
    try
    {
      if (sInstance == null) {
        sInstance = new TbsVideoPlayer(paramContext);
      }
      paramContext = sInstance;
      return paramContext;
    }
    finally {}
  }
  
  public boolean canUseTbsPlayer()
  {
    this.mTbsVideoView.initPlayer();
    return this.mTbsVideoView.isTbsPlayerReady();
  }
  
  public boolean isSuperVipUser()
  {
    if (this.mUserStateHolder != null) {
      return this.mUserStateHolder.isSuperVipUser();
    }
    return false;
  }
  
  void onActivity(Activity paramActivity, int paramInt)
  {
    this.mTbsVideoView.onActivity(paramActivity, paramInt);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.mUserStateHolder != null) {
      this.mUserStateHolder.onVipActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean play(String paramString, Bundle paramBundle, IUserStateHolder paramIUserStateHolder)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    if (!TextUtils.isEmpty(paramString)) {
      localBundle.putString("videoUrl", paramString);
    }
    if (paramIUserStateHolder != null)
    {
      this.mTbsVideoView.initPlayer();
      if (!this.mTbsVideoView.isTbsPlayerReady()) {
        return false;
      }
      this.mUserStateHolder = paramIUserStateHolder;
      this.mUserStateListener = new IUserStateChangedListener()
      {
        public void onUserStateChanged()
        {
          TbsVideoPlayer.this.mTbsVideoView.onUserStateChanged();
        }
      };
      this.mUserStateHolder.setUserStateChangedListener(this.mUserStateListener);
      localBundle.putInt("callMode", 3);
    }
    for (;;)
    {
      paramBundle = this.mTbsVideoView;
      paramString = this;
      if (paramIUserStateHolder == null) {
        paramString = null;
      }
      paramBundle.play(localBundle, paramString);
      return true;
      localBundle.putInt("callMode", 1);
    }
  }
  
  public void requestOpenSuperVip(Activity paramActivity)
  {
    if (this.mUserStateHolder != null) {
      this.mUserStateHolder.requestOpenSuperVip(paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsVideoPlayer
 * JD-Core Version:    0.7.0.1
 */