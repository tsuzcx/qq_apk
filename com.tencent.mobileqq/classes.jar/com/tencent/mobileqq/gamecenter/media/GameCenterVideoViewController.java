package com.tencent.mobileqq.gamecenter.media;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.gamecenter.util.QQGameConfigUtil;
import com.tencent.mobileqq.gamecenter.util.QQGameConstant;
import com.tencent.mobileqq.gamecenter.view.VideoLoadingImage;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class GameCenterVideoViewController
  extends FrameLayout
  implements Handler.Callback, View.OnClickListener, SeekBar.OnSeekBarChangeListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener
{
  public static final int MSG_TYPE_AUTO_PLAY = 13;
  public static final int MSG_TYPE_ENTER_FULLSCREEN = 8;
  public static final int MSG_TYPE_EXIT_FULLSCREEN = 9;
  public static final int MSG_TYPE_HIDE_CONTROL_PANLE = 2;
  public static final int MSG_TYPE_INITAL_VIDEO = 6;
  public static final int MSG_TYPE_SHOW_CONTROL_PANLE = 1;
  public static final int MSG_TYPE_SHOW_DANMAKU_SWITCH = 17;
  public static final int MSG_TYPE_SHOW_FLOAT_WINDOW = 14;
  public static final int MSG_TYPE_SHOW_FULLSCREEN = 12;
  public static final int MSG_TYPE_SHOW_OUT_LAYER_INFO = 7;
  public static final int MSG_TYPE_SHOW_PLAY = 16;
  public static final int MSG_TYPE_SHOW_PROGRESS = 15;
  public static final int MSG_TYPE_SHOW_VOLUME = 11;
  public static final int MSG_TYPE_UPDATE_PANEL = 4;
  public static final int MSG_TYPE_UPDATE_SEEKBAR = 3;
  public static final int MSG_TYPE_UPDATE_VIDEO_PROGRESS = 5;
  public static final int MSG_TYPE_UPDATE_VOLUME = 10;
  public static final int SRC_GAME_CENTER = 1;
  public static final int SRC_PUB_ACCOUT = 2;
  public static final String TAG = "GameCenterVideoViewController";
  public static int sPlayCount = 0;
  private ImageView mAudioBtn;
  private RelativeLayout mControlPanel;
  private View mCoverContainer;
  private TextView mCoverDuration;
  private URLImageView mCoverImage;
  private AtomicInteger mCurrentStatus = new AtomicInteger(0);
  private DanmakuLayout mDanmakuLayout;
  private CheckBox mDanmakuSwitch;
  private int mDanmakuSwitchStyle;
  private FeedsItemData mData;
  private boolean mEnableAudio = false;
  private boolean mEnableFullScreen = false;
  private boolean mEnableProgress = true;
  private TVK_IProxyFactory mFactory;
  private ImageView mFullScreenBtn;
  private ViewGroup mFullScreenContainer;
  private boolean mIsAutoPlay = false;
  private boolean mIsFullScreen = false;
  private boolean mIsMute = false;
  private long mLastPlayTimestamp = 0L;
  private AtomicInteger mLastStatus = new AtomicInteger(0);
  private VideoLoadingImage mLoadingButton;
  private boolean mNeedReport = false;
  private ViewGroup.LayoutParams mOldlp;
  private GameCenterVideoViewController.OnDanmakuChangeListener mOnDanmakuChangeListener;
  private GameCenterVideoViewController.OnProgressChangeListener mOnProgressChangeListener;
  private GameCenterVideoViewController.OnSeekListener mOnSeekListener;
  private URLImageView mOperateButton;
  private ViewGroup mParentView;
  private int mPlayBtnVisibility = 0;
  private long mPlayTime = 0L;
  private TVK_PlayerVideoInfo mPlayerInfo;
  private TextView mProgressTime;
  private FrameLayout mRootView;
  private int mSrc;
  private GameCenterVideoViewController.VideoStatusChangeListener mStatusListener;
  private int mUIStyle = 1;
  private Handler mUiHandler = new Handler(Looper.getMainLooper(), this);
  private TVK_UserInfo mUserInfo;
  private FrameLayout mVideoContainer;
  private TextView mVideoDuration;
  private int mVideoDurationValue;
  private int mVideoId = 0;
  private ISuperPlayer mVideoPlayer;
  private SeekBar mVideoSeek;
  private View mVideoView;
  private int mXYaxis;
  
  public GameCenterVideoViewController(@NonNull Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public GameCenterVideoViewController(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public GameCenterVideoViewController(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void checkView(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null) && (paramView.getVisibility() == 0) && ((paramView.getWidth() == 0) || (paramView.getHeight() == 0) || (paramView.getWidth() > getWidth()) || (paramView.getHeight() > getHeight()))) {
      onViewChanged((View)paramView.getParent());
    }
  }
  
  private void handleVideoEvent(int paramInt)
  {
    if (this.mSrc == 2)
    {
      if ((paramInt != 5) && (paramInt != 7) && (paramInt != 0)) {
        break label28;
      }
      GameVideoManager.b(5);
    }
    label28:
    while (paramInt != 3) {
      return;
    }
    GameVideoManager.b(6);
  }
  
  private void initSdkReady()
  {
    if (!QQVideoPlaySDKManager.a()) {
      QQVideoPlaySDKManager.a(BaseApplication.getContext(), null);
    }
  }
  
  private void initView()
  {
    initSdkReady();
    this.mRootView = ((FrameLayout)LayoutInflater.from(getContext()).inflate(2131559294, this));
    this.mVideoContainer = ((FrameLayout)this.mRootView.findViewById(2131381298));
    this.mControlPanel = ((RelativeLayout)this.mRootView.findViewById(2131371075));
    this.mOperateButton = ((URLImageView)this.mRootView.findViewById(2131372581));
    this.mLoadingButton = ((VideoLoadingImage)this.mRootView.findViewById(2131361803));
    this.mProgressTime = ((TextView)this.mRootView.findViewById(2131373577));
    this.mVideoDuration = ((TextView)this.mRootView.findViewById(2131366081));
    this.mVideoSeek = ((SeekBar)this.mRootView.findViewById(2131369140));
    this.mAudioBtn = ((ImageView)this.mRootView.findViewById(2131381568));
    this.mFullScreenBtn = ((ImageView)this.mRootView.findViewById(2131367657));
    this.mCoverContainer = this.mRootView.findViewById(2131365426);
    this.mCoverDuration = ((TextView)this.mRootView.findViewById(2131366079));
    this.mCoverImage = ((URLImageView)this.mRootView.findViewById(2131365428));
    this.mRootView.setOnClickListener(this);
    this.mOperateButton.setOnClickListener(this);
    this.mVideoSeek.setOnSeekBarChangeListener(this);
    this.mAudioBtn.setOnClickListener(this);
    this.mFullScreenBtn.setOnClickListener(this);
    this.mDanmakuLayout = ((DanmakuLayout)this.mRootView.findViewById(2131365529));
    this.mDanmakuLayout.setTimeSupplier(new GameCenterVideoViewController.1(this), 150L);
    this.mDanmakuSwitch = ((CheckBox)this.mRootView.findViewById(2131365528));
    this.mDanmakuSwitch.setOnCheckedChangeListener(new GameCenterVideoViewController.2(this));
  }
  
  private void postUpdateProgress(long paramLong)
  {
    if ((this.mData.type == 2) || (this.mData.videoDuration > 0))
    {
      this.mUiHandler.removeMessages(5);
      if (getParent() != null) {
        this.mUiHandler.sendEmptyMessageDelayed(5, paramLong);
      }
    }
  }
  
  private void setProgressVisibility(int paramInt)
  {
    this.mProgressTime.setVisibility(paramInt);
    this.mVideoSeek.setVisibility(paramInt);
    this.mVideoDuration.setVisibility(paramInt);
  }
  
  private void updateOperateButton(boolean paramBoolean)
  {
    if (this.mUIStyle == 0)
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      if (paramBoolean)
      {
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getResources().getDrawable(2130843459);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = getResources().getDrawable(2130843459);
        localObject = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_video_play@2x.png", (URLDrawable.URLDrawableOptions)localObject);
        this.mOperateButton.setImageDrawable((Drawable)localObject);
        return;
      }
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getResources().getDrawable(2130843458);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = getResources().getDrawable(2130843458);
      localObject = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_video_stop@2x.png", (URLDrawable.URLDrawableOptions)localObject);
      this.mOperateButton.setImageDrawable((Drawable)localObject);
      return;
    }
    if (paramBoolean)
    {
      this.mOperateButton.setImageResource(2130844477);
      return;
    }
    this.mOperateButton.setImageResource(2130844476);
  }
  
  private void updateVideoProgress(int paramInt)
  {
    this.mVideoSeek.setProgress(paramInt);
    this.mProgressTime.setText(ReadInJoyDisplayUtils.a(paramInt / 1000));
    postUpdateProgress(1000 - paramInt % 1000);
  }
  
  public void autoPlay()
  {
    this.mUiHandler.removeMessages(13);
    this.mUiHandler.sendEmptyMessage(13);
  }
  
  public void checkAndPlay()
  {
    if ((NetworkUtil.g(getContext())) && (NetworkUtil.h(getContext())))
    {
      this.mIsAutoPlay = true;
      arrayOfInt = new int[2];
      getLocationOnScreen(arrayOfInt);
      i = getHeight();
      localDisplayMetrics = getResources().getDisplayMetrics();
      if ((arrayOfInt[1] > AIOUtils.a(50.0F, getResources())) && (arrayOfInt[1] + i < (i + localDisplayMetrics.heightPixels) / 2 + AIOUtils.a(50.0F, getResources())) && (this.mCurrentStatus.get() == 0))
      {
        this.mUiHandler.removeMessages(13);
        this.mUiHandler.sendEmptyMessage(13);
        setMute(QQGameConstant.a);
      }
    }
    while (!com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      int[] arrayOfInt;
      int i;
      DisplayMetrics localDisplayMetrics;
      return;
    }
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 1, "[checkAndPlay] network err or not wifi,auto play failed.");
  }
  
  public View createVideoView()
  {
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 4, "[createVideoPlayer]");
    if (!QQVideoPlaySDKManager.a())
    {
      com.tencent.TMG.utils.QLog.w("GameCenterVideoViewController", 1, "sdk NOT installed.");
      return null;
    }
    ISPlayerVideoView localISPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(BaseApplicationImpl.getContext());
    this.mVideoPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 106, localISPlayerVideoView);
    if (this.mVideoPlayer == null)
    {
      com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[createVideoView] create media player fail.");
      return null;
    }
    this.mVideoPlayer.setOnCompletionListener(this);
    this.mVideoPlayer.setOnVideoPreparedListener(this);
    this.mVideoPlayer.setOnErrorListener(this);
    this.mVideoPlayer.setOnSeekCompleteListener(this);
    onPlayerCreated(this.mVideoPlayer);
    return (View)localISPlayerVideoView;
  }
  
  public void enableFullScreenSwitch()
  {
    this.mEnableFullScreen = true;
    this.mUiHandler.sendEmptyMessage(12);
  }
  
  public void enableReport()
  {
    this.mNeedReport = true;
  }
  
  public void enableVolumeSwitch()
  {
    this.mEnableAudio = true;
    this.mUiHandler.sendEmptyMessage(11);
  }
  
  public void enterFullScreen()
  {
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 4, "enterFullScreen");
    this.mUiHandler.removeMessages(8);
    this.mUiHandler.sendEmptyMessageDelayed(8, 300L);
    this.mStatusListener.onSrceenModeChanged(true, this.mVideoId);
  }
  
  public void exitFullScreen()
  {
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 4, "exitFullScreen");
    this.mUiHandler.removeMessages(9);
    this.mUiHandler.sendEmptyMessageDelayed(9, 300L);
    this.mStatusListener.onSrceenModeChanged(false, this.mVideoId);
  }
  
  public long getCurrentPostion()
  {
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 4, "---> getCurrentPostion");
    if (this.mVideoPlayer == null) {
      return 0L;
    }
    return this.mVideoPlayer.getCurrentPositionMs();
  }
  
  public int getCurrentStatus()
  {
    return this.mCurrentStatus.get();
  }
  
  public DanmakuLayout getDanmakuLayout()
  {
    return this.mDanmakuLayout;
  }
  
  public long getDuration()
  {
    if (this.mVideoPlayer == null) {
      return 0L;
    }
    return this.mVideoPlayer.getDurationMs();
  }
  
  public boolean getOutputMute()
  {
    if (this.mVideoPlayer != null) {
      return this.mVideoPlayer.isOutputMute();
    }
    return false;
  }
  
  public int getVideoId()
  {
    return this.mVideoId;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 8;
    switch (paramMessage.what)
    {
    case 3: 
    case 6: 
    case 7: 
    default: 
    case 1: 
    case 2: 
    case 4: 
    case 5: 
    case 8: 
    case 9: 
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              if (this.mCurrentStatus.get() != 0)
              {
                paramMessage = this.mControlPanel;
                if ((!this.mEnableFullScreen) && (!this.mEnableAudio) && (!this.mEnableProgress) && (this.mPlayBtnVisibility != 0)) {
                  break label237;
                }
              }
              for (i = 0;; i = 8)
              {
                paramMessage.setVisibility(i);
                checkView(this.mControlPanel);
                if ((this.mData.type == 1) && (this.mData.videoDuration == 0)) {
                  setProgressVisibility(4);
                }
                if (this.mEnableAudio)
                {
                  this.mAudioBtn.setVisibility(0);
                  checkView(this.mAudioBtn);
                }
                if (this.mEnableFullScreen)
                {
                  this.mFullScreenBtn.setVisibility(0);
                  checkView(this.mFullScreenBtn);
                }
                this.mOperateButton.setVisibility(this.mPlayBtnVisibility);
                hideControlPanel();
                return false;
              }
            } while (this.mCurrentStatus.get() == 5);
            this.mControlPanel.setVisibility(8);
          } while (this.mCurrentStatus.get() == 0);
          this.mOperateButton.setVisibility(8);
          this.mLoadingButton.setVisibility(8);
          return false;
          if (this.mCurrentStatus.get() == 3)
          {
            this.mOperateButton.setVisibility(this.mPlayBtnVisibility);
            this.mLoadingButton.setVisibility(8);
            updateOperateButton(false);
            showControlPanel();
            this.mCoverContainer.setVisibility(8);
            return false;
          }
          if (this.mCurrentStatus.get() == 0)
          {
            this.mOperateButton.setVisibility(this.mPlayBtnVisibility);
            this.mLoadingButton.setVisibility(8);
            updateOperateButton(true);
            this.mCoverContainer.setVisibility(0);
            if (!TextUtils.isEmpty(this.mData.coverImgUrl)) {}
            try
            {
              this.mCoverImage.setImageURL(this.mData.coverImgUrl);
              this.mControlPanel.setVisibility(8);
              this.mProgressTime.setText(ReadInJoyDisplayUtils.a(0));
              paramMessage = ReadInJoyDisplayUtils.a(this.mData.videoDuration);
              this.mVideoDuration.setText(paramMessage);
              if (this.mData.videoDuration == 0)
              {
                this.mCoverDuration.setText("");
                return false;
              }
            }
            catch (Exception paramMessage)
            {
              for (;;)
              {
                com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, paramMessage, new Object[0]);
              }
              this.mCoverDuration.setText(paramMessage);
              return false;
            }
          }
          if (this.mCurrentStatus.get() == 5)
          {
            this.mOperateButton.setVisibility(this.mPlayBtnVisibility);
            this.mLoadingButton.setVisibility(8);
            updateOperateButton(true);
            return false;
          }
          this.mOperateButton.setVisibility(this.mPlayBtnVisibility);
          this.mLoadingButton.setVisibility(8);
          updateOperateButton(false);
          return false;
          updateVideoProgress((int)this.mVideoPlayer.getCurrentPositionMs());
          return false;
        } while ((this.mIsFullScreen) || (scanForActivity(getContext()) == null));
        if (this.mParentView == null)
        {
          this.mParentView = ((ViewGroup)getParent());
          this.mFullScreenContainer = ((ViewGroup)scanForActivity(getContext()).findViewById(16908290));
        }
        scanForActivity(getContext()).getWindow().setFlags(1024, 1024);
        this.mOldlp = getLayoutParams();
        this.mParentView.removeView(this);
        scanForActivity(getContext()).setRequestedOrientation(0);
        paramMessage = new FrameLayout.LayoutParams(-1, -1);
        this.mFullScreenContainer.addView(this, paramMessage);
        this.mVideoPlayer.setXYaxis(2);
        this.mFullScreenBtn.setImageResource(2130840350);
        this.mIsFullScreen = true;
        GameCenterVideoManager.a().a(this);
        return false;
      } while ((!this.mIsFullScreen) || (scanForActivity(getContext()) == null));
      this.mFullScreenContainer.removeView(this);
      this.mParentView.addView(this, this.mOldlp);
      scanForActivity(getContext()).getWindow().clearFlags(1024);
      this.mVideoPlayer.setXYaxis(0);
      scanForActivity(getContext()).setRequestedOrientation(1);
      this.mFullScreenBtn.setImageResource(2130840349);
      this.mIsFullScreen = false;
      return false;
    case 10: 
      if (this.mVideoPlayer.isOutputMute())
      {
        this.mAudioBtn.setImageResource(2130840354);
        return false;
      }
      this.mAudioBtn.setImageResource(2130840355);
      return false;
    case 12: 
      this.mFullScreenBtn.setVisibility(0);
      checkView(this.mFullScreenBtn);
      return false;
    case 11: 
      this.mAudioBtn.setVisibility(0);
      checkView(this.mAudioBtn);
      return false;
    case 15: 
      setProgressVisibility(((Integer)paramMessage.obj).intValue());
      return false;
    case 16: 
      this.mOperateButton.setVisibility(((Integer)paramMessage.obj).intValue());
      return false;
    case 13: 
      if (this.mCurrentStatus.get() == 0)
      {
        if ((this.mNeedReport) && (this.mData != null))
        {
          paramMessage = new HashMap();
          GameCenterUtils.a(paramMessage, this.mData.msgId);
          paramMessage.put(Integer.valueOf(2), this.mData.msgId);
          paramMessage.put(Integer.valueOf(6), this.mData.feedId);
          paramMessage.put(Integer.valueOf(4), "20");
          paramMessage.put(Integer.valueOf(43), this.mData.algorithmId);
          paramMessage.put(Integer.valueOf(44), this.mData.type + "");
          GameCenterUtils.a(CmGameUtil.a(), "769", "205020", this.mData.gameInfo.gameAppId, "76902", "1", "160", paramMessage);
        }
        GameCenterVideoManager.a().a(this);
        this.mOperateButton.setVisibility(8);
        this.mLoadingButton.setVisibility(0);
        play();
        return false;
      }
      com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[handleMessage] autoplay mCurrentStatus:" + this.mCurrentStatus.get());
      return false;
    case 14: 
      label237:
      ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).getFloadWindowInfo(this.mData.gameInfo.gameAppId);
      return false;
    }
    paramMessage = this.mDanmakuSwitch;
    if (this.mDanmakuSwitchStyle > 0) {
      i = 0;
    }
    paramMessage.setVisibility(i);
    if (this.mDanmakuSwitchStyle == 1) {
      this.mDanmakuSwitch.setChecked(false);
    }
    for (;;)
    {
      checkView(this.mDanmakuSwitch);
      return false;
      if (this.mDanmakuSwitchStyle == 2) {
        this.mDanmakuSwitch.setChecked(true);
      }
    }
  }
  
  public void hideControlPanel()
  {
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 1, "[hideControlPanel] hide");
    this.mUiHandler.removeMessages(2);
    Message localMessage = Message.obtain(this.mUiHandler, 2);
    this.mUiHandler.sendMessageDelayed(localMessage, 2000L);
  }
  
  public boolean isFullScreenMode()
  {
    return this.mIsFullScreen;
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = false;
    switch (paramView.getId())
    {
    default: 
      if (this.mControlPanel.getVisibility() != 0) {
        showControlPanel();
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      HashMap localHashMap;
      if (this.mCurrentStatus.get() == 0)
      {
        if ((this.mNeedReport) && (!this.mIsAutoPlay))
        {
          localHashMap = new HashMap();
          GameCenterUtils.a(localHashMap, this.mData.msgId);
          localHashMap.put(Integer.valueOf(2), this.mData.msgId);
          localHashMap.put(Integer.valueOf(6), this.mData.feedId);
          localHashMap.put(Integer.valueOf(4), "20");
          localHashMap.put(Integer.valueOf(43), this.mData.algorithmId);
          localHashMap.put(Integer.valueOf(44), this.mData.type + "");
          GameCenterUtils.a(CmGameUtil.a(), "769", "205023", this.mData.gameInfo.gameAppId, "76902", "1", "160", localHashMap);
        }
        GameCenterVideoManager.a().a(this);
        this.mOperateButton.setVisibility(8);
        this.mLoadingButton.setVisibility(0);
        play();
      }
      else if (this.mCurrentStatus.get() == 3)
      {
        if (this.mNeedReport)
        {
          localHashMap = new HashMap();
          GameCenterUtils.a(localHashMap, this.mData.msgId);
          localHashMap.put(Integer.valueOf(2), this.mData.msgId);
          localHashMap.put(Integer.valueOf(6), this.mData.feedId);
          localHashMap.put(Integer.valueOf(4), "20");
          localHashMap.put(Integer.valueOf(42), getCurrentPostion() + "");
          localHashMap.put(Integer.valueOf(43), this.mData.algorithmId);
          localHashMap.put(Integer.valueOf(44), this.mData.type + "");
          GameCenterUtils.a(CmGameUtil.a(), "769", "205034", this.mData.gameInfo.gameAppId, "76902", "1", "160", localHashMap);
        }
        pause();
      }
      else if (this.mCurrentStatus.get() == 5)
      {
        if (this.mNeedReport)
        {
          localHashMap = new HashMap();
          GameCenterUtils.a(localHashMap, this.mData.msgId);
          localHashMap.put(Integer.valueOf(2), this.mData.msgId);
          localHashMap.put(Integer.valueOf(6), this.mData.feedId);
          localHashMap.put(Integer.valueOf(4), "20");
          localHashMap.put(Integer.valueOf(42), getCurrentPostion() + "");
          localHashMap.put(Integer.valueOf(43), this.mData.algorithmId);
          localHashMap.put(Integer.valueOf(44), this.mData.type + "");
          GameCenterUtils.a(CmGameUtil.a(), "769", "205034", this.mData.gameInfo.gameAppId, "76902", "1", "160", localHashMap);
        }
        if ((this.mSrc == 2) && (sPlayCount == 0))
        {
          this.mUiHandler.removeMessages(14);
          this.mUiHandler.sendEmptyMessageDelayed(14, QQGameConfigUtil.b - this.mPlayTime);
        }
        start();
        continue;
        if (this.mVideoPlayer != null)
        {
          if (!this.mVideoPlayer.isOutputMute()) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            QQGameConstant.a = bool1;
            bool1 = bool2;
            if (!this.mVideoPlayer.isOutputMute()) {
              bool1 = true;
            }
            setMute(bool1);
            break;
          }
          if (this.mIsFullScreen) {
            exitFullScreen();
          } else {
            enterFullScreen();
          }
        }
      }
    }
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 4, "onCompletion");
    setCurrentStatus(7);
    stop();
    release();
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 4, "SuperPlayer onError:i" + paramInt1 + " i1" + paramInt2 + " i2" + paramInt3 + " s" + paramString);
    release();
    this.mUiHandler.post(new GameCenterVideoViewController.3(this));
    com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[onError] " + paramInt1 + ", " + paramInt2 + ", " + paramInt3);
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 4, "SuperPlayer onInfo:i i1 i2 " + paramObject);
    return false;
  }
  
  protected void onPlayerCreated(ISuperPlayer paramISuperPlayer) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (this.mOnProgressChangeListener != null) {
      this.mOnProgressChangeListener.a(paramInt, this.mVideoId);
    }
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 4, new Object[] { "onSeekComplete: ", Long.valueOf(getCurrentPostion()) });
    start();
    if (this.mOnSeekListener != null) {
      this.mOnSeekListener.a((int)getCurrentPostion(), this.mVideoId);
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.mUiHandler.removeMessages(2);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    int i = paramSeekBar.getProgress();
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 2, "onStopTrackingTouch(): progress=" + i);
    }
    seekTo(i);
    hideControlPanel();
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 4, "SuperPlayer onVideoPrepared");
    this.mUiHandler.post(new GameCenterVideoViewController.4(this));
  }
  
  protected void onViewChanged(View paramView) {}
  
  public void pause()
  {
    if (this.mCurrentStatus.get() == 3)
    {
      this.mUiHandler.removeMessages(5);
      if ((this.mSrc == 2) && (sPlayCount == 0)) {
        this.mUiHandler.removeMessages(14);
      }
      this.mPlayTime += System.currentTimeMillis() - this.mLastPlayTimestamp;
      if (this.mVideoPlayer != null)
      {
        this.mVideoPlayer.pause();
        setCurrentStatus(5);
        updateControlPanle();
      }
    }
  }
  
  public void play()
  {
    if (this.mCurrentStatus.get() == 5)
    {
      start();
      if ((this.mSrc == 2) && (sPlayCount == 0))
      {
        this.mUiHandler.removeMessages(14);
        this.mUiHandler.sendEmptyMessageDelayed(14, QQGameConfigUtil.b - this.mPlayTime);
      }
    }
    while (this.mCurrentStatus.get() == 3) {
      return;
    }
    if (!NetworkUtil.g(getContext()))
    {
      this.mUiHandler.post(new GameCenterVideoViewController.5(this));
      com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 2, "commentReport network error, stop request.");
      setCurrentStatus(0);
      updateControlPanle();
      return;
    }
    SuperPlayerVideoInfo localSuperPlayerVideoInfo;
    if (TextUtils.isEmpty(this.mData.videoUrl)) {
      if (this.mData.type == 1) {
        localSuperPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForTVideo(5590303, this.mData.videoVid);
      }
    }
    try
    {
      if ((this.mVideoView != null) && (this.mVideoContainer == this.mVideoView.getParent()))
      {
        this.mVideoContainer.removeView(this.mVideoView);
        this.mVideoView = null;
      }
      label189:
      this.mVideoView = createVideoView();
      if (this.mVideoView != null)
      {
        this.mVideoContainer.addView(this.mVideoView, -1, -1);
        checkView(this.mVideoView);
      }
      if (this.mVideoPlayer != null)
      {
        setCurrentStatus(1);
        this.mVideoPlayer.openMediaPlayer(getContext(), localSuperPlayerVideoInfo, 0L);
      }
      for (;;)
      {
        setMute(this.mIsMute);
        return;
        localSuperPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForTVideo(5590303, this.mData.videoVid);
        break;
        if (this.mData.type == 1)
        {
          localSuperPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForUrl(this.mData.videoUrl, 201, "");
          break;
        }
        localSuperPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForUrl(this.mData.videoUrl, 101, "");
        break;
        com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[play] mVideoPlayer is null");
      }
    }
    catch (Exception localException)
    {
      break label189;
    }
  }
  
  public void release()
  {
    setCurrentStatus(0);
    if (this.mVideoPlayer != null)
    {
      this.mVideoPlayer.stop();
      this.mVideoPlayer.release();
      com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[release] release video ok:" + this.mVideoPlayer.toString());
    }
    this.mUiHandler.removeCallbacksAndMessages(null);
    updateControlPanle();
  }
  
  protected Activity scanForActivity(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    if ((paramContext instanceof Activity)) {
      return (Activity)paramContext;
    }
    if ((paramContext instanceof ContextWrapper)) {
      return scanForActivity(((ContextWrapper)paramContext).getBaseContext());
    }
    return null;
  }
  
  public void seekTo(int paramInt)
  {
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.seekTo(paramInt, 3);
    }
  }
  
  public void setCurrentStatus(int paramInt)
  {
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 2, "[setCurrentStatus] status:" + paramInt + ", obj:" + this);
    }
    this.mLastStatus.set(this.mCurrentStatus.get());
    this.mCurrentStatus.set(paramInt);
    handleVideoEvent(paramInt);
    if (this.mStatusListener != null) {
      this.mStatusListener.onVideoStatusChanged(paramInt, this.mVideoId);
    }
  }
  
  public void setDanmakuSwitch(int paramInt)
  {
    this.mDanmakuSwitchStyle = paramInt;
    this.mUiHandler.sendEmptyMessage(17);
  }
  
  public void setData(FeedsItemData paramFeedsItemData, int paramInt)
  {
    this.mData = paramFeedsItemData;
    if ((this.mVideoDurationValue > 0) && (this.mData != null) && (this.mData.videoDuration == 0)) {
      this.mData.videoDuration = this.mVideoDurationValue;
    }
    this.mSrc = paramInt;
    updateControlPanle();
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.mIsMute = paramBoolean;
    if (this.mVideoPlayer != null)
    {
      this.mVideoPlayer.setOutputMute(paramBoolean);
      this.mUiHandler.removeMessages(10);
      this.mUiHandler.sendEmptyMessageDelayed(10, 300L);
      if (this.mStatusListener != null) {
        this.mStatusListener.onAudioMute(paramBoolean, this.mVideoId);
      }
    }
  }
  
  public void setOnDanmakuChangeListener(GameCenterVideoViewController.OnDanmakuChangeListener paramOnDanmakuChangeListener)
  {
    this.mOnDanmakuChangeListener = paramOnDanmakuChangeListener;
  }
  
  public void setOnProgressChangeListener(GameCenterVideoViewController.OnProgressChangeListener paramOnProgressChangeListener)
  {
    this.mOnProgressChangeListener = paramOnProgressChangeListener;
  }
  
  public void setOnSeekListener(GameCenterVideoViewController.OnSeekListener paramOnSeekListener)
  {
    this.mOnSeekListener = paramOnSeekListener;
  }
  
  public void setPlayEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.mPlayBtnVisibility = i;
      Message.obtain(this.mUiHandler, 16, Integer.valueOf(this.mPlayBtnVisibility)).sendToTarget();
      return;
    }
  }
  
  public void setProgressEnabled(boolean paramBoolean)
  {
    this.mEnableProgress = paramBoolean;
    Handler localHandler = this.mUiHandler;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      Message.obtain(localHandler, 15, Integer.valueOf(i)).sendToTarget();
      return;
    }
  }
  
  public void setUIStyle(int paramInt)
  {
    this.mUIStyle = paramInt;
    this.mLoadingButton.setStyle(this.mUIStyle);
  }
  
  public void setVideoDuration(int paramInt)
  {
    this.mVideoDurationValue = paramInt;
    if (this.mData != null) {
      this.mData.videoDuration = paramInt;
    }
  }
  
  public void setVideoId(int paramInt)
  {
    this.mVideoId = paramInt;
  }
  
  public void setVideoStatusChangerListener(GameCenterVideoViewController.VideoStatusChangeListener paramVideoStatusChangeListener)
  {
    this.mStatusListener = paramVideoStatusChangeListener;
  }
  
  public void showControlPanel()
  {
    this.mUiHandler.removeMessages(1);
    Message localMessage = Message.obtain(this.mUiHandler, 1);
    this.mUiHandler.sendMessage(localMessage);
  }
  
  public void start()
  {
    if (this.mVideoPlayer != null)
    {
      this.mVideoPlayer.start();
      setCurrentStatus(3);
      updateControlPanle();
      this.mLastPlayTimestamp = System.currentTimeMillis();
      postUpdateProgress(0L);
    }
  }
  
  public void stop()
  {
    if ((this.mVideoPlayer != null) && (this.mCurrentStatus.get() != 0))
    {
      if ((this.mIsAutoPlay) && (this.mNeedReport))
      {
        HashMap localHashMap = new HashMap();
        GameCenterUtils.a(localHashMap, this.mData.msgId);
        localHashMap.put(Integer.valueOf(2), this.mData.msgId);
        localHashMap.put(Integer.valueOf(6), this.mData.feedId);
        localHashMap.put(Integer.valueOf(4), "-1");
        localHashMap.put(Integer.valueOf(42), getCurrentPostion() + "");
        localHashMap.put(Integer.valueOf(43), this.mData.algorithmId);
        localHashMap.put(Integer.valueOf(44), this.mData.type + "");
        GameCenterUtils.a(CmGameUtil.a(), "769", "205026", this.mData.gameInfo.gameAppId, "76902", "1", "160", localHashMap);
      }
      this.mVideoPlayer.stop();
      setCurrentStatus(0);
      updateControlPanle();
    }
  }
  
  public void updateControlPanle()
  {
    com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[updateControlPanle] " + this.mCurrentStatus.get());
    this.mUiHandler.removeMessages(4);
    this.mUiHandler.sendEmptyMessage(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController
 * JD-Core Version:    0.7.0.1
 */