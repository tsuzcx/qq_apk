package com.tencent.mobileqq.gamecenter.media;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.gamecenter.view.VideoLoadingImage;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDisplayUtils;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.data.GamePubAccountConstant;
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
  private static final String FILE_PROTOCOL_HEADER = "file://";
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
  public static int sPlayCount;
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
  private boolean mIsLandscapeWhenFullScreen = true;
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
    if (this.mSrc == 2) {
      if ((paramInt != 5) && (paramInt != 7) && (paramInt != 0))
      {
        if (paramInt == 3) {
          ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).dispatchVideoEvent(6);
        }
      }
      else {
        ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).dispatchVideoEvent(5);
      }
    }
  }
  
  private void initSdkReady()
  {
    boolean bool1 = QQVideoPlaySDKManager.isSDKReady();
    boolean bool2 = QQVideoPlaySDKManager.isSoLoadSucess();
    if ((!bool1) || (!bool2)) {
      QQVideoPlaySDKManager.initSDKAsync(BaseApplication.getContext(), null);
    }
    if (com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initSdkReady,isSdkReady:");
      localStringBuilder.append(bool1);
      localStringBuilder.append(",isSoLoadSuc:");
      localStringBuilder.append(bool2);
      com.tencent.qphone.base.util.QLog.i("GameCenterVideoViewController", 2, localStringBuilder.toString());
    }
  }
  
  private void initView()
  {
    initSdkReady();
    this.mRootView = ((FrameLayout)LayoutInflater.from(getContext()).inflate(2131624922, this));
    this.mVideoContainer = ((FrameLayout)this.mRootView.findViewById(2131449510));
    this.mControlPanel = ((RelativeLayout)this.mRootView.findViewById(2131437986));
    this.mOperateButton = ((URLImageView)this.mRootView.findViewById(2131439638));
    this.mLoadingButton = ((VideoLoadingImage)this.mRootView.findViewById(2131427344));
    this.mProgressTime = ((TextView)this.mRootView.findViewById(2131440766));
    this.mVideoDuration = ((TextView)this.mRootView.findViewById(2131432269));
    this.mVideoSeek = ((SeekBar)this.mRootView.findViewById(2131435807));
    this.mAudioBtn = ((ImageView)this.mRootView.findViewById(2131449774));
    this.mFullScreenBtn = ((ImageView)this.mRootView.findViewById(2131433912));
    this.mCoverContainer = this.mRootView.findViewById(2131431467);
    this.mCoverDuration = ((TextView)this.mRootView.findViewById(2131432267));
    this.mCoverImage = ((URLImageView)this.mRootView.findViewById(2131431470));
    this.mRootView.setOnClickListener(this);
    this.mOperateButton.setOnClickListener(this);
    this.mVideoSeek.setOnSeekBarChangeListener(this);
    this.mAudioBtn.setOnClickListener(this);
    this.mFullScreenBtn.setOnClickListener(this);
    this.mDanmakuLayout = ((DanmakuLayout)this.mRootView.findViewById(2131431573));
    this.mDanmakuLayout.setTimeSupplier(new GameCenterVideoViewController.1(this), 150L);
    this.mDanmakuSwitch = ((CheckBox)this.mRootView.findViewById(2131431572));
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
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getResources().getDrawable(2130844327);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = getResources().getDrawable(2130844327);
        localObject = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_video_play@2x.png", (URLDrawable.URLDrawableOptions)localObject);
        this.mOperateButton.setImageDrawable((Drawable)localObject);
        return;
      }
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getResources().getDrawable(2130844326);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = getResources().getDrawable(2130844326);
      localObject = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_video_stop@2x.png", (URLDrawable.URLDrawableOptions)localObject);
      this.mOperateButton.setImageDrawable((Drawable)localObject);
      return;
    }
    if (paramBoolean)
    {
      this.mOperateButton.setImageResource(2130845700);
      return;
    }
    this.mOperateButton.setImageResource(2130845699);
  }
  
  private void updateVideoProgress(int paramInt)
  {
    this.mVideoSeek.setProgress(paramInt);
    this.mProgressTime.setText(((IReadInJoyDisplayUtils)QRoute.api(IReadInJoyDisplayUtils.class)).getDisplayDuration(paramInt / 1000));
    postUpdateProgress(1000 - paramInt % 1000);
  }
  
  public void autoPlay()
  {
    this.mUiHandler.removeMessages(13);
    this.mUiHandler.sendEmptyMessage(13);
  }
  
  public void checkAndPlay()
  {
    if ((NetworkUtil.isNetworkAvailable(getContext())) && (NetworkUtil.isWifiConnected(getContext())))
    {
      this.mIsAutoPlay = true;
      int[] arrayOfInt = new int[2];
      getLocationOnScreen(arrayOfInt);
      int i = getHeight();
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      if ((arrayOfInt[1] > AIOUtils.b(50.0F, getResources())) && (arrayOfInt[1] + i < (i + localDisplayMetrics.heightPixels) / 2 + AIOUtils.b(50.0F, getResources())) && (this.mCurrentStatus.get() == 0))
      {
        this.mUiHandler.removeMessages(13);
        this.mUiHandler.sendEmptyMessage(13);
        setMute(GamePubAccountConstant.a);
      }
    }
    else if (com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 1, "[checkAndPlay] network err or not wifi,auto play failed.");
    }
  }
  
  public View createVideoView()
  {
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 4, "[createVideoPlayer]");
    if (!QQVideoPlaySDKManager.isSDKReady())
    {
      com.tencent.TMG.utils.QLog.w("GameCenterVideoViewController", 1, "sdk NOT installed.");
      return null;
    }
    ISPlayerVideoView localISPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(BaseApplicationImpl.getContext());
    this.mVideoPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 106, localISPlayerVideoView);
    ISuperPlayer localISuperPlayer = this.mVideoPlayer;
    if (localISuperPlayer == null)
    {
      com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[createVideoView] create media player fail.");
      return null;
    }
    localISuperPlayer.setOnCompletionListener(this);
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
    ISuperPlayer localISuperPlayer = this.mVideoPlayer;
    if (localISuperPlayer == null) {
      return 0L;
    }
    return localISuperPlayer.getCurrentPositionMs();
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
    ISuperPlayer localISuperPlayer = this.mVideoPlayer;
    if (localISuperPlayer == null) {
      return 0L;
    }
    return localISuperPlayer.getDurationMs();
  }
  
  public boolean getOutputMute()
  {
    ISuperPlayer localISuperPlayer = this.mVideoPlayer;
    if (localISuperPlayer != null) {
      return localISuperPlayer.isOutputMute();
    }
    return false;
  }
  
  public int getVideoId()
  {
    return this.mVideoId;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    int i = 8;
    if (j != 1)
    {
      if (j != 2)
      {
        Object localObject;
        if (j != 4)
        {
          if (j != 5)
          {
            switch (j)
            {
            default: 
              return false;
            case 17: 
              paramMessage = this.mDanmakuSwitch;
              if (this.mDanmakuSwitchStyle > 0) {
                i = 0;
              }
              paramMessage.setVisibility(i);
              i = this.mDanmakuSwitchStyle;
              if (i == 1) {
                this.mDanmakuSwitch.setChecked(false);
              } else if (i == 2) {
                this.mDanmakuSwitch.setChecked(true);
              }
              checkView(this.mDanmakuSwitch);
              return false;
            case 16: 
              this.mOperateButton.setVisibility(((Integer)paramMessage.obj).intValue());
              return false;
            case 15: 
              setProgressVisibility(((Integer)paramMessage.obj).intValue());
              return false;
            case 14: 
              ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).getFloadWindowInfo(this.mData.gameInfo.gameAppId);
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
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append(this.mData.type);
                  ((StringBuilder)localObject).append("");
                  paramMessage.put(Integer.valueOf(44), ((StringBuilder)localObject).toString());
                  GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "205020", this.mData.gameInfo.gameAppId, "76902", "1", "160", paramMessage);
                }
                GameCenterVideoManager.a().a(this);
                this.mOperateButton.setVisibility(8);
                this.mLoadingButton.setVisibility(0);
                play();
                return false;
              }
              paramMessage = new StringBuilder();
              paramMessage.append("[handleMessage] autoplay mCurrentStatus:");
              paramMessage.append(this.mCurrentStatus.get());
              com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, paramMessage.toString());
              return false;
            case 12: 
              this.mFullScreenBtn.setVisibility(0);
              checkView(this.mFullScreenBtn);
              return false;
            case 11: 
              this.mAudioBtn.setVisibility(0);
              checkView(this.mAudioBtn);
              return false;
            case 10: 
              if (this.mVideoPlayer.isOutputMute())
              {
                this.mAudioBtn.setImageResource(2130840535);
                return false;
              }
              this.mAudioBtn.setImageResource(2130840536);
              return false;
            case 9: 
              if (!this.mIsFullScreen) {
                break;
              }
              if (scanForActivity(getContext()) == null) {
                return false;
              }
              this.mFullScreenContainer.removeView(this);
              this.mParentView.addView(this, this.mOldlp);
              scanForActivity(getContext()).getWindow().clearFlags(1024);
              this.mVideoPlayer.setXYaxis(0);
              if ((this.mIsLandscapeWhenFullScreen) && (getResources().getConfiguration().orientation != 1)) {
                scanForActivity(getContext()).setRequestedOrientation(1);
              }
              this.mFullScreenBtn.setImageResource(2130840530);
              this.mIsFullScreen = false;
              return false;
            case 8: 
              if (this.mIsFullScreen) {
                break;
              }
              if (scanForActivity(getContext()) == null) {
                return false;
              }
              if (this.mParentView == null)
              {
                this.mParentView = ((ViewGroup)getParent());
                this.mFullScreenContainer = ((ViewGroup)scanForActivity(getContext()).findViewById(16908290));
              }
              scanForActivity(getContext()).getWindow().setFlags(1024, 1024);
              this.mOldlp = getLayoutParams();
              this.mParentView.removeView(this);
              if (this.mIsLandscapeWhenFullScreen) {
                scanForActivity(getContext()).setRequestedOrientation(0);
              }
              paramMessage = new FrameLayout.LayoutParams(-1, -1);
              this.mFullScreenContainer.addView(this, paramMessage);
              this.mVideoPlayer.setXYaxis(0);
              this.mFullScreenBtn.setImageResource(2130840531);
              this.mIsFullScreen = true;
              GameCenterVideoManager.a().a(this);
              return false;
            }
          }
          else
          {
            updateVideoProgress((int)this.mVideoPlayer.getCurrentPositionMs());
            return false;
          }
        }
        else
        {
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
            if (!TextUtils.isEmpty(this.mData.coverImgUrl)) {
              try
              {
                paramMessage = ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).getOfflineResPath(this.mData.coverImgUrl);
                if (TextUtils.isEmpty(paramMessage))
                {
                  this.mCoverImage.setImageURL(this.mData.coverImgUrl);
                }
                else
                {
                  localObject = this.mCoverImage;
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append("file://");
                  localStringBuilder.append(paramMessage);
                  ((URLImageView)localObject).setImageURL(localStringBuilder.toString());
                }
              }
              catch (Exception paramMessage)
              {
                com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, paramMessage, new Object[0]);
              }
            }
            this.mControlPanel.setVisibility(8);
            this.mProgressTime.setText(((IReadInJoyDisplayUtils)QRoute.api(IReadInJoyDisplayUtils.class)).getDisplayDuration(0));
            paramMessage = ((IReadInJoyDisplayUtils)QRoute.api(IReadInJoyDisplayUtils.class)).getDisplayDuration(this.mData.videoDuration);
            this.mVideoDuration.setText(paramMessage);
            if (this.mData.videoDuration == 0)
            {
              this.mCoverDuration.setText("");
              return false;
            }
            this.mCoverDuration.setText(paramMessage);
            return false;
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
        }
      }
      else if (this.mCurrentStatus.get() != 5)
      {
        this.mControlPanel.setVisibility(8);
        if (this.mCurrentStatus.get() != 0)
        {
          this.mOperateButton.setVisibility(8);
          this.mLoadingButton.setVisibility(8);
          return false;
        }
      }
    }
    else
    {
      if (this.mCurrentStatus.get() != 0)
      {
        paramMessage = this.mControlPanel;
        if ((this.mEnableFullScreen) || (this.mEnableAudio) || (this.mEnableProgress) || (this.mPlayBtnVisibility == 0)) {
          i = 0;
        }
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
      }
      this.mOperateButton.setVisibility(this.mPlayBtnVisibility);
      hideControlPanel();
    }
    return false;
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
    int i = paramView.getId();
    if (i != 2131433912)
    {
      Object localObject;
      if (i != 2131439638)
      {
        if (i != 2131449774)
        {
          if (this.mControlPanel.getVisibility() != 0) {
            showControlPanel();
          }
        }
        else
        {
          localObject = this.mVideoPlayer;
          if (localObject != null)
          {
            GamePubAccountConstant.a = ((ISuperPlayer)localObject).isOutputMute() ^ true;
            setMute(this.mVideoPlayer.isOutputMute() ^ true);
          }
        }
      }
      else
      {
        StringBuilder localStringBuilder;
        if (this.mCurrentStatus.get() == 0)
        {
          if ((this.mNeedReport) && (!this.mIsAutoPlay))
          {
            localObject = new HashMap();
            GameCenterUtils.a((Map)localObject, this.mData.msgId);
            ((Map)localObject).put(Integer.valueOf(2), this.mData.msgId);
            ((Map)localObject).put(Integer.valueOf(6), this.mData.feedId);
            ((Map)localObject).put(Integer.valueOf(4), "20");
            ((Map)localObject).put(Integer.valueOf(43), this.mData.algorithmId);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.mData.type);
            localStringBuilder.append("");
            ((Map)localObject).put(Integer.valueOf(44), localStringBuilder.toString());
            GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "205023", this.mData.gameInfo.gameAppId, "76902", "1", "160", (Map)localObject);
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
            localObject = new HashMap();
            GameCenterUtils.a((Map)localObject, this.mData.msgId);
            ((Map)localObject).put(Integer.valueOf(2), this.mData.msgId);
            ((Map)localObject).put(Integer.valueOf(6), this.mData.feedId);
            ((Map)localObject).put(Integer.valueOf(4), "20");
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(getCurrentPostion());
            localStringBuilder.append("");
            ((Map)localObject).put(Integer.valueOf(42), localStringBuilder.toString());
            ((Map)localObject).put(Integer.valueOf(43), this.mData.algorithmId);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.mData.type);
            localStringBuilder.append("");
            ((Map)localObject).put(Integer.valueOf(44), localStringBuilder.toString());
            GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "205034", this.mData.gameInfo.gameAppId, "76902", "1", "160", (Map)localObject);
          }
          pause();
        }
        else if (this.mCurrentStatus.get() == 5)
        {
          if (this.mNeedReport)
          {
            localObject = new HashMap();
            GameCenterUtils.a((Map)localObject, this.mData.msgId);
            ((Map)localObject).put(Integer.valueOf(2), this.mData.msgId);
            ((Map)localObject).put(Integer.valueOf(6), this.mData.feedId);
            ((Map)localObject).put(Integer.valueOf(4), "20");
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(getCurrentPostion());
            localStringBuilder.append("");
            ((Map)localObject).put(Integer.valueOf(42), localStringBuilder.toString());
            ((Map)localObject).put(Integer.valueOf(43), this.mData.algorithmId);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.mData.type);
            localStringBuilder.append("");
            ((Map)localObject).put(Integer.valueOf(44), localStringBuilder.toString());
            GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "205034", this.mData.gameInfo.gameAppId, "76902", "1", "160", (Map)localObject);
          }
          if ((this.mSrc == 2) && (sPlayCount == 0))
          {
            this.mUiHandler.removeMessages(14);
            this.mUiHandler.sendEmptyMessageDelayed(14, 30000L - this.mPlayTime);
          }
          start();
        }
      }
    }
    else if (this.mIsFullScreen)
    {
      exitFullScreen();
    }
    else
    {
      enterFullScreen();
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
    paramISuperPlayer = new StringBuilder();
    paramISuperPlayer.append("SuperPlayer onError:i");
    paramISuperPlayer.append(paramInt1);
    paramISuperPlayer.append(" i1");
    paramISuperPlayer.append(paramInt2);
    paramISuperPlayer.append(" i2");
    paramISuperPlayer.append(paramInt3);
    paramISuperPlayer.append(" s");
    paramISuperPlayer.append(paramString);
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 4, paramISuperPlayer.toString());
    release();
    this.mUiHandler.post(new GameCenterVideoViewController.3(this));
    paramISuperPlayer = new StringBuilder();
    paramISuperPlayer.append("[onError] ");
    paramISuperPlayer.append(paramInt1);
    paramISuperPlayer.append(", ");
    paramISuperPlayer.append(paramInt2);
    paramISuperPlayer.append(", ");
    paramISuperPlayer.append(paramInt3);
    com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, paramISuperPlayer.toString());
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    paramISuperPlayer = new StringBuilder();
    paramISuperPlayer.append("SuperPlayer onInfo:i i1 i2 ");
    paramISuperPlayer.append(paramObject);
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 4, paramISuperPlayer.toString());
    return false;
  }
  
  protected void onPlayerCreated(ISuperPlayer paramISuperPlayer) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    paramSeekBar = this.mOnProgressChangeListener;
    if (paramSeekBar != null) {
      paramSeekBar.a(paramInt, this.mVideoId);
    }
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 4, new Object[] { "onSeekComplete: ", Long.valueOf(getCurrentPostion()) });
    start();
    paramISuperPlayer = this.mOnSeekListener;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.a((int)getCurrentPostion(), this.mVideoId);
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.mUiHandler.removeMessages(2);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    int i = paramSeekBar.getProgress();
    if (com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStopTrackingTouch(): progress=");
      localStringBuilder.append(i);
      com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 2, localStringBuilder.toString());
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
      ISuperPlayer localISuperPlayer = this.mVideoPlayer;
      if (localISuperPlayer != null)
      {
        localISuperPlayer.pause();
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
        this.mUiHandler.sendEmptyMessageDelayed(14, 30000L - this.mPlayTime);
      }
      return;
    }
    if (this.mCurrentStatus.get() == 3) {
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(getContext()))
    {
      this.mUiHandler.post(new GameCenterVideoViewController.5(this));
      com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 2, "commentReport network error, stop request.");
      setCurrentStatus(0);
      updateControlPanle();
      return;
    }
    Object localObject;
    if (TextUtils.isEmpty(this.mData.videoUrl))
    {
      if (this.mData.type == 1) {
        localObject = SuperPlayerFactory.createVideoInfoForTVideo(5590303, this.mData.videoVid);
      } else {
        localObject = SuperPlayerFactory.createVideoInfoForTVideo(5590303, this.mData.videoVid);
      }
    }
    else if (this.mData.type == 1)
    {
      localObject = SuperPlayerFactory.createVideoInfoForUrl(this.mData.videoUrl, 201, "");
    }
    else
    {
      localObject = ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).getOfflineResPath(this.mData.videoUrl);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        localObject = SuperPlayerFactory.createVideoInfoForUrl(this.mData.videoUrl, 104, "");
      } else {
        localObject = SuperPlayerFactory.createVideoInfoForUrl(this.mData.videoUrl, 104, "", (String)localObject);
      }
    }
    try
    {
      if ((this.mVideoView != null) && (this.mVideoContainer == this.mVideoView.getParent()))
      {
        this.mVideoContainer.removeView(this.mVideoView);
        this.mVideoView = null;
      }
      label305:
      this.mVideoView = createVideoView();
      View localView = this.mVideoView;
      if (localView != null)
      {
        this.mVideoContainer.addView(localView, -1, -1);
        checkView(this.mVideoView);
      }
      if (this.mVideoPlayer != null)
      {
        setCurrentStatus(1);
        this.mVideoPlayer.openMediaPlayer(getContext(), (SuperPlayerVideoInfo)localObject, 0L);
      }
      else
      {
        com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[play] mVideoPlayer is null");
      }
      setMute(this.mIsMute);
      return;
    }
    catch (Exception localException)
    {
      break label305;
    }
  }
  
  public void release()
  {
    setCurrentStatus(0);
    Object localObject = this.mVideoPlayer;
    if (localObject != null)
    {
      ((ISuperPlayer)localObject).stop();
      this.mVideoPlayer.release();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[release] release video ok:");
      ((StringBuilder)localObject).append(this.mVideoPlayer.toString());
      com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, ((StringBuilder)localObject).toString());
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
    ISuperPlayer localISuperPlayer = this.mVideoPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.seekTo(paramInt, 3);
    }
  }
  
  public void setCurrentStatus(int paramInt)
  {
    if (com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[setCurrentStatus] status:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", obj:");
      ((StringBuilder)localObject).append(this);
      com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 2, ((StringBuilder)localObject).toString());
    }
    this.mLastStatus.set(this.mCurrentStatus.get());
    this.mCurrentStatus.set(paramInt);
    handleVideoEvent(paramInt);
    Object localObject = this.mStatusListener;
    if (localObject != null) {
      ((GameCenterVideoViewController.VideoStatusChangeListener)localObject).onVideoStatusChanged(paramInt, this.mVideoId);
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
    if (this.mVideoDurationValue > 0)
    {
      paramFeedsItemData = this.mData;
      if ((paramFeedsItemData != null) && (paramFeedsItemData.videoDuration == 0)) {
        this.mData.videoDuration = this.mVideoDurationValue;
      }
    }
    this.mSrc = paramInt;
    updateControlPanle();
  }
  
  public void setIsLandscapeWhenFullScreen(boolean paramBoolean)
  {
    this.mIsLandscapeWhenFullScreen = paramBoolean;
  }
  
  public void setLoadingIconStyle(int paramInt)
  {
    this.mLoadingButton.setStyle(paramInt);
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.mIsMute = paramBoolean;
    Object localObject = this.mVideoPlayer;
    if (localObject != null)
    {
      ((ISuperPlayer)localObject).setOutputMute(paramBoolean);
      this.mUiHandler.removeMessages(10);
      this.mUiHandler.sendEmptyMessageDelayed(10, 300L);
      localObject = this.mStatusListener;
      if (localObject != null) {
        ((GameCenterVideoViewController.VideoStatusChangeListener)localObject).onAudioMute(paramBoolean, this.mVideoId);
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
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    this.mPlayBtnVisibility = i;
    Message.obtain(this.mUiHandler, 16, Integer.valueOf(this.mPlayBtnVisibility)).sendToTarget();
  }
  
  public void setProgressEnabled(boolean paramBoolean)
  {
    this.mEnableProgress = paramBoolean;
    Handler localHandler = this.mUiHandler;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 4;
    }
    Message.obtain(localHandler, 15, Integer.valueOf(i)).sendToTarget();
  }
  
  public void setUIStyle(int paramInt)
  {
    this.mUIStyle = paramInt;
    this.mLoadingButton.setStyle(this.mUIStyle);
  }
  
  public void setVideoDuration(int paramInt)
  {
    this.mVideoDurationValue = paramInt;
    FeedsItemData localFeedsItemData = this.mData;
    if (localFeedsItemData != null) {
      localFeedsItemData.videoDuration = paramInt;
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
    ISuperPlayer localISuperPlayer = this.mVideoPlayer;
    if (localISuperPlayer != null)
    {
      localISuperPlayer.start();
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(getCurrentPostion());
        localStringBuilder.append("");
        localHashMap.put(Integer.valueOf(42), localStringBuilder.toString());
        localHashMap.put(Integer.valueOf(43), this.mData.algorithmId);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.mData.type);
        localStringBuilder.append("");
        localHashMap.put(Integer.valueOf(44), localStringBuilder.toString());
        GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "205026", this.mData.gameInfo.gameAppId, "76902", "1", "160", localHashMap);
      }
      this.mVideoPlayer.stop();
      setCurrentStatus(0);
      updateControlPanle();
    }
  }
  
  public void updateControlPanle()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[updateControlPanle] ");
    localStringBuilder.append(this.mCurrentStatus.get());
    com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, localStringBuilder.toString());
    this.mUiHandler.removeMessages(4);
    this.mUiHandler.sendEmptyMessage(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController
 * JD-Core Version:    0.7.0.1
 */