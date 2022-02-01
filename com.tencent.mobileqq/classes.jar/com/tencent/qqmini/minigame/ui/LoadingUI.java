package com.tencent.qqmini.minigame.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqmini.minigame.R.color;
import com.tencent.qqmini.minigame.R.drawable;
import com.tencent.qqmini.minigame.R.id;
import com.tencent.qqmini.minigame.R.layout;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.URLUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.widget.SquareImageView;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import java.util.ArrayList;

public class LoadingUI
  extends RelativeLayout
{
  public static final String TAG = "LoadingUI";
  int iconSize = DisplayUtil.dip2px(getContext(), 100.0F);
  private boolean isForeground = false;
  private LinearLayout mBottonLayout;
  private LinearLayout mCenterLayout;
  private ImageView mCloseView;
  private LinearLayout mDeveloperDescLayout;
  private TextView mDeveloperDescView;
  private LinearLayout mGameCopyRightLayout;
  private TextView mGameCopyrightInfo;
  private ImageView mGameFakeFirstFrame;
  private RelativeLayout mGameFakeFirstFrameDownLoadRect;
  private TextView mGameFakeFrameGameName;
  private ProgressBar mGameFakeFrameProgres;
  private TextView mGameFakeFrameProgressText;
  private SquareImageView mGameFakeGameLogo;
  private TextView mGameInstruction;
  private TextView mGameVersionDesc;
  private TextView mJumpBtn;
  private SquareImageView mLogoView;
  private MiniAppInfo mMiniAppInfo;
  private ImageView mMoreView;
  private TextView mNameView;
  private String mProgressStr = "0%";
  private TextView mProgressTxt;
  private LinearLayout mSplashLayout;
  private boolean mSplashLoadComplete = false;
  private ProgressBar mSplashProgressBar;
  private TextView mSplashProgressTxt;
  private ImageView mStartView;
  private View mStatusBar;
  
  public LoadingUI(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LoadingUI(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LoadingUI(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initUIComponents();
  }
  
  private void checkShowFakeFirstFrame()
  {
    Object localObject2 = getFakeFristFrameUrlByAppid(GameWnsUtils.getFakeFristFrameUrl(), this.mMiniAppInfo.appId);
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) || (URLUtil.isValidUrl((String)localObject2))) {}
    for (;;)
    {
      try
      {
        MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
        Drawable localDrawable = getContext().getResources().getDrawable(R.color.transparent);
        localObject2 = localMiniAppProxy.getDrawable(getContext(), (String)localObject2, getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, localDrawable);
        if (localObject2 == null)
        {
          this.mGameFakeFirstFrame.setImageDrawable(localDrawable);
          localMiniAppProxy.setDrawableCallback(localDrawable, new LoadingUI.1(this));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      Object localObject1 = localObject2;
    }
  }
  
  private String getFakeFristFrameUrlByAppid(String paramString1, String paramString2)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        if (TextUtils.isEmpty(paramString2)) {
          return null;
        }
        paramString1 = paramString1.split(";");
        if ((paramString1 != null) && (paramString1.length > 0))
        {
          int i = 0;
          while (i < paramString1.length)
          {
            String[] arrayOfString = paramString1[i].split("\\|\\|");
            if ((arrayOfString != null) && (arrayOfString.length == 2) && (paramString2.equals(arrayOfString[0])))
            {
              paramString1 = arrayOfString[1];
              return paramString1;
            }
            i += 1;
          }
        }
      }
      return null;
    }
    catch (Throwable paramString1) {}
    return null;
  }
  
  private void initUIComponents()
  {
    try
    {
      inflate(getContext(), R.layout.mini_sdk_game_loading_layout, this);
      this.mStatusBar = findViewById(R.id.status_bar);
      this.mGameInstruction = ((TextView)findViewById(R.id.game_instruction));
      this.mGameVersionDesc = ((TextView)findViewById(R.id.game_version_desc));
      this.mGameCopyrightInfo = ((TextView)findViewById(R.id.game_copyright_info));
      this.mGameCopyRightLayout = ((LinearLayout)findViewById(R.id.game_copyright));
      this.mJumpBtn = ((TextView)findViewById(R.id.jump_btn));
      this.mMoreView = ((ImageView)findViewById(R.id.btn_more_menu));
      this.mCloseView = ((ImageView)findViewById(R.id.btn_close));
      this.mNameView = ((TextView)findViewById(R.id.game_name));
      this.mDeveloperDescView = ((TextView)findViewById(R.id.developer_desc));
      this.mDeveloperDescLayout = ((LinearLayout)findViewById(R.id.developer_desc_layout));
      this.mLogoView = ((SquareImageView)findViewById(R.id.logo_mask));
      this.mLogoView.setRoundRect(this.iconSize);
      this.mBottonLayout = ((LinearLayout)findViewById(R.id.bottom_layout));
      this.mGameFakeFirstFrameDownLoadRect = ((RelativeLayout)findViewById(R.id.minigame_fakecover_rect));
      this.mGameFakeFirstFrame = ((ImageView)findViewById(R.id.game_fake_firstframe));
      this.mGameFakeFrameProgres = ((ProgressBar)findViewById(R.id.minigame_fakecover_progressbar));
      this.mGameFakeFrameProgressText = ((TextView)findViewById(R.id.minigame_fakecover_progresstext));
      this.mGameFakeFrameGameName = ((TextView)findViewById(R.id.minigame_fakecover_gamename));
      this.mGameFakeGameLogo = ((SquareImageView)findViewById(R.id.minigame_fakecover_gamelogo));
      this.mGameFakeGameLogo.setRoundRect(10);
      this.mProgressTxt = ((TextView)findViewById(R.id.txt_download_progress));
      this.mSplashProgressTxt = ((TextView)findViewById(R.id.splash_txt_download_progress));
      this.mSplashProgressBar = ((ProgressBar)findViewById(R.id.splash_launch_progress));
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("LoadingUI", "void initUIComponents", localException);
    }
  }
  
  private boolean isInterLoadingMode()
  {
    return true;
  }
  
  private void onResume()
  {
    this.isForeground = true;
    this.mProgressTxt.setText(this.mProgressStr);
    this.mSplashProgressTxt.setText(this.mProgressStr);
    Object localObject1 = this.mMiniAppInfo;
    if (localObject1 != null)
    {
      this.mNameView.setText(((MiniAppInfo)localObject1).name);
      this.mGameFakeFrameGameName.setText(this.mMiniAppInfo.name);
      showGameCopyRight();
      showDeveloperDesc();
      showGameVersionDesc();
      if (!TextUtils.isEmpty(this.mMiniAppInfo.iconUrl))
      {
        Object localObject2 = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
        localObject1 = getContext().getResources().getDrawable(R.drawable.mini_sdk_default_icon);
        Context localContext = getContext();
        String str = this.mMiniAppInfo.iconUrl;
        int i = this.iconSize;
        localObject2 = ((MiniAppProxy)localObject2).getDrawable(localContext, str, i, i, (Drawable)localObject1);
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
        this.mLogoView.setImageDrawable((Drawable)localObject1);
        this.mGameFakeGameLogo.setImageDrawable((Drawable)localObject1);
      }
      checkShowFakeFirstFrame();
    }
  }
  
  private void onStop()
  {
    this.isForeground = false;
    setVisibility(8);
  }
  
  private void showDeveloperDesc()
  {
    if (TextUtils.isEmpty(this.mMiniAppInfo.developerDesc))
    {
      this.mDeveloperDescLayout.setVisibility(8);
      return;
    }
    this.mDeveloperDescLayout.setVisibility(0);
    TextView localTextView = this.mDeveloperDescView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("由");
    localStringBuilder.append(this.mMiniAppInfo.developerDesc);
    localStringBuilder.append("提供");
    localTextView.setText(localStringBuilder.toString());
  }
  
  private void showGameCopyRight()
  {
    if (TextUtils.isEmpty(this.mMiniAppInfo.gameCopyrightInfo))
    {
      this.mGameCopyRightLayout.setVisibility(8);
      this.mDeveloperDescLayout.setVisibility(0);
      return;
    }
    this.mGameCopyRightLayout.setVisibility(0);
    this.mDeveloperDescLayout.setVisibility(0);
    this.mGameCopyrightInfo.setText(this.mMiniAppInfo.gameCopyrightInfo);
  }
  
  private void showGameVersionDesc()
  {
    if ((this.mMiniAppInfo.qualifications != null) && (this.mMiniAppInfo.qualifications.size() > 0))
    {
      this.mDeveloperDescLayout.setVisibility(8);
      Object localObject = this.mGameVersionDesc;
      int i = 0;
      ((TextView)localObject).setVisibility(0);
      localObject = new StringBuilder();
      while (i < this.mMiniAppInfo.qualifications.size())
      {
        if ((i > 0) && (!TextUtils.isEmpty((CharSequence)this.mMiniAppInfo.qualifications.get(i - 1)))) {
          ((StringBuilder)localObject).append("\n");
        }
        if (!TextUtils.isEmpty((CharSequence)this.mMiniAppInfo.qualifications.get(i))) {
          ((StringBuilder)localObject).append((String)this.mMiniAppInfo.qualifications.get(i));
        }
        i += 1;
      }
      this.mGameVersionDesc.setText(((StringBuilder)localObject).toString());
      return;
    }
    this.mGameVersionDesc.setVisibility(4);
  }
  
  private void showStartView()
  {
    this.mSplashProgressBar.setVisibility(8);
    this.mSplashProgressTxt.setVisibility(8);
    this.mStartView.setVisibility(0);
  }
  
  public void hide()
  {
    onStop();
  }
  
  public LoadingUI initUIData(MiniAppInfo paramMiniAppInfo)
  {
    this.mMiniAppInfo = paramMiniAppInfo;
    return this;
  }
  
  public boolean isForeground()
  {
    return this.isForeground;
  }
  
  public void setProgressInt(float paramFloat)
  {
    Object localObject = this.mGameFakeFrameProgres;
    int i = (int)(paramFloat * 100.0F);
    ((ProgressBar)localObject).setProgress(i);
    localObject = this.mGameFakeFrameProgressText;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("%");
    ((TextView)localObject).setText(localStringBuilder.toString());
  }
  
  public void setProgressTxt(String paramString)
  {
    this.mProgressTxt.setText(paramString);
    this.mProgressStr = paramString;
  }
  
  public void show(ViewGroup paramViewGroup)
  {
    if (getVisibility() != 0) {
      setVisibility(0);
    }
    if (getParent() != null) {
      ((ViewGroup)getParent()).removeView(this);
    }
    paramViewGroup.addView(this);
    onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.LoadingUI
 * JD-Core Version:    0.7.0.1
 */