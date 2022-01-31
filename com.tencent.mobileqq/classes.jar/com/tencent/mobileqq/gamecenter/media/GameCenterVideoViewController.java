package com.tencent.mobileqq.gamecenter.media;

import aact;
import aekt;
import akro;
import akvt;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
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
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import asii;
import asij;
import asjb;
import asjc;
import bdee;
import bhou;
import bkeu;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.gamecenter.view.VideoLoadingImage;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import orc;
import tar;

public class GameCenterVideoViewController
  extends FrameLayout
  implements Handler.Callback, View.OnClickListener, SeekBar.OnSeekBarChangeListener, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnSeekCompleteListener, TVK_IMediaPlayer.OnVideoPreparedListener
{
  public static int a;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private asij jdField_a_of_type_Asij;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private FeedsItemData jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData;
  private VideoLoadingImage jdField_a_of_type_ComTencentMobileqqGamecenterViewVideoLoadingImage;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private TVK_PlayerVideoInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo;
  private TVK_UserInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public GameCenterVideoViewController(@NonNull Context paramContext)
  {
    super(paramContext);
    p();
  }
  
  public GameCenterVideoViewController(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    p();
  }
  
  public GameCenterVideoViewController(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    p();
  }
  
  public static Activity a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    if ((paramContext instanceof Activity)) {
      return (Activity)paramContext;
    }
    if ((paramContext instanceof ContextWrapper)) {
      return a(((ContextWrapper)paramContext).getBaseContext());
    }
    return null;
  }
  
  private void p()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)LayoutInflater.from(getContext()).inflate(2131559138, this));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131379593));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131370078));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131371416));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewVideoLoadingImage = ((VideoLoadingImage)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131361802));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372344));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365506));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131368331));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131379827));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131366990));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131371471));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131364889));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void q()
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
    this.jdField_a_of_type_AndroidWidgetTextView.setText(orc.a((int)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion() / 1000));
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
  }
  
  public View a()
  {
    com.tencent.qphone.base.util.QLog.i("GameCenterVideoViewController", 1, "[createVideoPlayer]");
    if (!TVK_SDKMgr.isInstalled(getContext()))
    {
      com.tencent.TMG.utils.QLog.w("GameCenterVideoViewController", 1, "sdk NOT installed.");
      return null;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null)
    {
      com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "videoProxyFactory is null.");
      return null;
    }
    if (bhou.d()) {}
    for (IVideoViewBase localIVideoViewBase = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(getContext());; localIVideoViewBase = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView(getContext()))
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(getContext(), localIVideoViewBase);
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 2, "[createVideoView] create video ok:" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.toString());
      }
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
        break;
      }
      com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[createVideoView] create media player fail.");
      return null;
    }
    TVK_SDKMgr.setDebugEnable(false);
    TVK_SDKMgr.setOnLogListener(new akvt());
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo = new TVK_UserInfo("", "");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "bus_type_game_center");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnSeekCompleteListener(this);
    return (View)localIVideoViewBase;
  }
  
  public void a()
  {
    com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[updateControlPanle] " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(8);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
    this.jdField_a_of_type_Asij.a(true, this.jdField_b_of_type_Int);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getOutputMute();
    }
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(9);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
    this.jdField_a_of_type_Asij.a(false, this.jdField_b_of_type_Int);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 5)
    {
      e();
      if ((this.jdField_c_of_type_Int == 2) && (jdField_a_of_type_Int == 0))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(14);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(14, asjb.jdField_b_of_type_Int - this.jdField_a_of_type_Long);
      }
      return;
    }
    if (!bdee.g(getContext()))
    {
      ThreadManagerV2.getUIHandlerV2().post(new GameCenterVideoViewController.2(this));
      com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 2, "commentReport network error, stop request.");
      setCurrentStatus(0);
      a();
      return;
    }
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.videoUrl)) {
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type == 1)
      {
        localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(1, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.videoVid, "");
        localTVK_PlayerVideoInfo.setPlayType(1);
        this.jdField_a_of_type_AndroidViewView = a();
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView, -1, -1);
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("shouq_bus_type", "bus_type_apollo");
        localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
          break label408;
        }
        setCurrentStatus(1);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.videoUrl)) {
          break label382;
        }
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayer(getContext(), this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo, localTVK_PlayerVideoInfo, tar.a(), 0L, 0L);
      }
    }
    for (;;)
    {
      setMute(this.jdField_c_of_type_Boolean);
      return;
      localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.videoVid, "");
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.videoUrl.contains("https:")) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.videoUrl = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.videoUrl.replace("https:", "http:");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type == 1)
      {
        localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(1, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.videoUrl, "");
        localTVK_PlayerVideoInfo.setPlayType(1);
        break;
      }
      localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.videoUrl, "");
      break;
      label382:
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(getContext(), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.videoUrl, 0L, 0L, localTVK_PlayerVideoInfo);
      continue;
      label408:
      com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[play] mVideoPlayer is null");
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      setCurrentStatus(3);
      a();
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type == 2) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
      }
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(13);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(13);
  }
  
  public void g()
  {
    if ((bdee.g(getContext())) && (bdee.h(getContext())))
    {
      this.d = true;
      arrayOfInt = new int[2];
      getLocationOnScreen(arrayOfInt);
      i = getHeight();
      localDisplayMetrics = getResources().getDisplayMetrics();
      if ((arrayOfInt[1] > aekt.a(50.0F, getResources())) && (arrayOfInt[1] + i < (i + localDisplayMetrics.heightPixels) / 2 + aekt.a(50.0F, getResources())) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(13);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(13);
        setMute(asjc.jdField_a_of_type_Boolean);
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
  
  public void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    if ((this.jdField_c_of_type_Int == 2) && (jdField_a_of_type_Int == 0)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(14);
    }
    this.jdField_a_of_type_Long += System.currentTimeMillis() - this.jdField_b_of_type_Long;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
      setCurrentStatus(5);
      a();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 3: 
    case 6: 
    default: 
    case 1: 
    case 2: 
    case 4: 
    case 5: 
    case 7: 
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
              if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0)
              {
                this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
                if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type == 1)
                {
                  this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
                  this.jdField_a_of_type_AndroidWidgetSeekBar.setVisibility(4);
                  this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
                }
                if (this.f) {
                  this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
                }
                if (this.e) {
                  this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
                }
              }
              this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
              k();
              return false;
            } while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 5);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          } while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0);
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqGamecenterViewVideoLoadingImage.setVisibility(8);
          return false;
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3)
          {
            paramMessage = URLDrawable.URLDrawableOptions.obtain();
            paramMessage.mLoadingDrawable = getResources().getDrawable(2130842822);
            paramMessage.mFailedDrawable = getResources().getDrawable(2130842822);
            paramMessage = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_video_stop@2x.png");
            this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqGamecenterViewVideoLoadingImage.setVisibility(8);
            this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramMessage);
            j();
            this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
            return false;
          }
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0)
          {
            paramMessage = URLDrawable.URLDrawableOptions.obtain();
            paramMessage.mLoadingDrawable = getResources().getDrawable(2130842823);
            paramMessage.mFailedDrawable = getResources().getDrawable(2130842823);
            paramMessage = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_video_play@2x.png", paramMessage);
            this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqGamecenterViewVideoLoadingImage.setVisibility(8);
            this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramMessage);
            this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
            try
            {
              this.jdField_b_of_type_ComTencentImageURLImageView.setImageURL(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.coverImgUrl);
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
              this.jdField_a_of_type_AndroidWidgetTextView.setText(orc.a(0));
              paramMessage = orc.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.videoDuration);
              this.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessage);
              return false;
            }
            catch (Exception paramMessage)
            {
              for (;;)
              {
                com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, paramMessage, new Object[0]);
              }
            }
          }
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 5)
          {
            paramMessage = URLDrawable.URLDrawableOptions.obtain();
            paramMessage.mLoadingDrawable = getResources().getDrawable(2130842822);
            paramMessage.mFailedDrawable = getResources().getDrawable(2130842822);
            paramMessage = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_video_play@2x.png", paramMessage);
            this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqGamecenterViewVideoLoadingImage.setVisibility(8);
            this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramMessage);
            return false;
          }
          paramMessage = URLDrawable.URLDrawableOptions.obtain();
          paramMessage.mLoadingDrawable = getResources().getDrawable(2130842823);
          paramMessage.mFailedDrawable = getResources().getDrawable(2130842823);
          paramMessage = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_video_play@2x.png", paramMessage);
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqGamecenterViewVideoLoadingImage.setVisibility(8);
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramMessage);
          return false;
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 1000L);
          q();
          return false;
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          return false;
        } while (this.jdField_a_of_type_Boolean);
        if (this.jdField_b_of_type_AndroidViewViewGroup == null)
        {
          this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)getParent());
          this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(getContext()).findViewById(16908290));
        }
        a(getContext()).getWindow().setFlags(1024, 1024);
        this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = getLayoutParams();
        this.jdField_b_of_type_AndroidViewViewGroup.removeView(this);
        a(getContext()).setRequestedOrientation(0);
        paramMessage = new FrameLayout.LayoutParams(-1, -1);
        this.jdField_a_of_type_AndroidViewViewGroup.addView(this, paramMessage);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(2);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841444);
        this.jdField_a_of_type_Boolean = true;
        return false;
      } while (!this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this);
      this.jdField_b_of_type_AndroidViewViewGroup.addView(this, this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
      a(getContext()).getWindow().clearFlags(1024);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(0);
      a(getContext()).setRequestedOrientation(1);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841445);
      this.jdField_a_of_type_Boolean = false;
      return false;
    case 10: 
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getOutputMute())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842660);
        return false;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842661);
      return false;
    case 12: 
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return false;
    case 11: 
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return false;
    case 13: 
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0)
      {
        if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData != null))
        {
          paramMessage = new HashMap();
          aact.a(paramMessage, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
          paramMessage.put(Integer.valueOf(2), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
          paramMessage.put(Integer.valueOf(6), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.feedId);
          paramMessage.put(Integer.valueOf(4), "20");
          paramMessage.put(Integer.valueOf(43), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.algorithmId);
          paramMessage.put(Integer.valueOf(44), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type + "");
          aact.a(akro.a(), "769", "205020", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.gameInfo.gameAppId, "76902", "1", "160", paramMessage);
        }
        asii.a().a(this);
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewVideoLoadingImage.setVisibility(0);
        d();
        return false;
      }
      com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[handleMessage] autoplay mCurrentStatus:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      return false;
    }
    bkeu.a().a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.gameInfo.gameAppId);
    return false;
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0))
    {
      if ((this.d) && (this.jdField_b_of_type_Boolean))
      {
        HashMap localHashMap = new HashMap();
        aact.a(localHashMap, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
        localHashMap.put(Integer.valueOf(2), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
        localHashMap.put(Integer.valueOf(6), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.feedId);
        localHashMap.put(Integer.valueOf(4), "-1");
        localHashMap.put(Integer.valueOf(42), a() + "");
        localHashMap.put(Integer.valueOf(43), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.algorithmId);
        localHashMap.put(Integer.valueOf(44), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type + "");
        aact.a(akro.a(), "769", "205026", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.gameInfo.gameAppId, "76902", "1", "160", localHashMap);
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      setCurrentStatus(0);
      a();
    }
  }
  
  public void j()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void k()
  {
    com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[hideControlPanel] hide");
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 2);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 2000L);
  }
  
  public void l()
  {
    setCurrentStatus(0);
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[release] release video ok:" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.toString());
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    a();
  }
  
  public void m()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void n()
  {
    this.e = true;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(12);
  }
  
  public void o()
  {
    this.f = true;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11);
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = false;
    switch (paramView.getId())
    {
    default: 
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
        j();
      }
    case 2131371416: 
    case 2131379827: 
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0)
          {
            if ((this.jdField_b_of_type_Boolean) && (!this.d))
            {
              paramView = new HashMap();
              aact.a(paramView, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
              paramView.put(Integer.valueOf(2), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
              paramView.put(Integer.valueOf(6), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.feedId);
              paramView.put(Integer.valueOf(4), "20");
              paramView.put(Integer.valueOf(43), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.algorithmId);
              paramView.put(Integer.valueOf(44), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type + "");
              aact.a(akro.a(), "769", "205023", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.gameInfo.gameAppId, "76902", "1", "160", paramView);
            }
            asii.a().a(this);
            this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqGamecenterViewVideoLoadingImage.setVisibility(0);
            d();
            return;
          }
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3)
          {
            if (this.jdField_b_of_type_Boolean)
            {
              paramView = new HashMap();
              aact.a(paramView, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
              paramView.put(Integer.valueOf(2), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
              paramView.put(Integer.valueOf(6), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.feedId);
              paramView.put(Integer.valueOf(4), "20");
              paramView.put(Integer.valueOf(42), a() + "");
              paramView.put(Integer.valueOf(43), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.algorithmId);
              paramView.put(Integer.valueOf(44), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type + "");
              aact.a(akro.a(), "769", "205034", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.gameInfo.gameAppId, "76902", "1", "160", paramView);
            }
            h();
            return;
          }
        } while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 5);
        if (this.jdField_b_of_type_Boolean)
        {
          paramView = new HashMap();
          aact.a(paramView, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
          paramView.put(Integer.valueOf(2), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
          paramView.put(Integer.valueOf(6), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.feedId);
          paramView.put(Integer.valueOf(4), "20");
          paramView.put(Integer.valueOf(42), a() + "");
          paramView.put(Integer.valueOf(43), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.algorithmId);
          paramView.put(Integer.valueOf(44), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type + "");
          aact.a(akro.a(), "769", "205034", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.gameInfo.gameAppId, "76902", "1", "160", paramView);
        }
        if ((this.jdField_c_of_type_Int == 2) && (jdField_a_of_type_Int == 0))
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(14);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(14, asjb.jdField_b_of_type_Int - this.jdField_a_of_type_Long);
        }
        e();
        return;
      } while (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null);
      if (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getOutputMute()) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        asjc.jdField_a_of_type_Boolean = bool1;
        bool1 = bool2;
        if (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getOutputMute()) {
          bool1 = true;
        }
        setMute(bool1);
        return;
      }
    }
    if (this.jdField_a_of_type_Boolean)
    {
      c();
      return;
    }
    b();
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    setCurrentStatus(7);
    i();
    l();
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    l();
    ThreadManagerV2.getUIHandlerV2().post(new GameCenterVideoViewController.1(this));
    com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[onError] " + paramInt1 + ", " + paramInt2 + ", " + paramInt3);
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    return false;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    e();
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    int i = paramSeekBar.getProgress();
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 2, "onStopTrackingTouch(): progress=" + i);
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo(i);
    }
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[onVideoPrepared] status:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ",sPlayCount = " + jdField_a_of_type_Int + ",ConfigCount=" + asjb.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 5) {
      return;
    }
    setCurrentStatus(2);
    e();
    if (this.jdField_c_of_type_Int == 2)
    {
      int i = jdField_a_of_type_Int + 1;
      jdField_a_of_type_Int = i;
      if ((i >= asjb.jdField_a_of_type_Int) && (asjb.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.gameInfo.gameAppId)))
      {
        jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(14, asjb.jdField_b_of_type_Int - this.jdField_a_of_type_Long);
      }
    }
    long l = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax((int)l);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(orc.a((int)l / 1000));
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type == 2) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    }
    k();
  }
  
  public void setBgTransparent()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(0);
  }
  
  public void setCurrentStatus(int paramInt)
  {
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 2, "[setCurrentStatus] status:" + paramInt + ", obj:" + this);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
    if (this.jdField_a_of_type_Asij != null) {
      this.jdField_a_of_type_Asij.a(paramInt, this.jdField_b_of_type_Int);
    }
  }
  
  public void setData(FeedsItemData paramFeedsItemData, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData = paramFeedsItemData;
    this.jdField_c_of_type_Int = paramInt;
    a();
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(paramBoolean);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(10);
      if (this.jdField_a_of_type_Asij != null) {
        this.jdField_a_of_type_Asij.b(paramBoolean, this.jdField_b_of_type_Int);
      }
    }
  }
  
  public void setVideoId(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setVideoStatusChangerListener(asij paramasij)
  {
    this.jdField_a_of_type_Asij = paramasij;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController
 * JD-Core Version:    0.7.0.1
 */