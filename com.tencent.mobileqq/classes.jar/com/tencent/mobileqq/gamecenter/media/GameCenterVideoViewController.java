package com.tencent.mobileqq.gamecenter.media;

import aceh;
import afur;
import ampj;
import android.annotation.SuppressLint;
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
import ausy;
import ausz;
import auta;
import autb;
import auuc;
import auud;
import azwq;
import bgnt;
import bmxq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.gamecenter.view.VideoLoadingImage;
import com.tencent.qphone.base.util.BaseApplication;
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
import pgk;

public class GameCenterVideoViewController
  extends FrameLayout
  implements Handler.Callback, View.OnClickListener, SeekBar.OnSeekBarChangeListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener
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
  private auta jdField_a_of_type_Auta;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private FeedsItemData jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData;
  private VideoLoadingImage jdField_a_of_type_ComTencentMobileqqGamecenterViewVideoLoadingImage;
  private ISuperPlayer jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
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
    q();
  }
  
  public GameCenterVideoViewController(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    q();
  }
  
  public GameCenterVideoViewController(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    q();
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
  
  private void a(int paramInt)
  {
    if (this.jdField_c_of_type_Int == 2)
    {
      if ((paramInt != 5) && (paramInt != 7) && (paramInt != 0)) {
        break label28;
      }
      autb.b(5);
    }
    label28:
    while (paramInt != 3) {
      return;
    }
    autb.b(6);
  }
  
  private void p()
  {
    if (!azwq.a()) {
      azwq.a(BaseApplication.getContext(), new ausz(this));
    }
  }
  
  private void q()
  {
    p();
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)LayoutInflater.from(getContext()).inflate(2131559210, this));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131380597));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131370539));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372005));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewVideoLoadingImage = ((VideoLoadingImage)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131361802));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372958));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365744));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131368650));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131380843));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367268));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372061));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365125));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void r()
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs());
    this.jdField_a_of_type_AndroidWidgetTextView.setText(pgk.a((int)this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs() / 1000));
  }
  
  public long a()
  {
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 4, "---> getCurrentPostion");
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs();
  }
  
  public View a()
  {
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 4, "[createVideoPlayer]");
    if (!azwq.a())
    {
      com.tencent.TMG.utils.QLog.w("GameCenterVideoViewController", 1, "sdk NOT installed.");
      return null;
    }
    ISPlayerVideoView localISPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 106, localISPlayerVideoView);
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null)
    {
      com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[createVideoView] create media player fail.");
      return null;
    }
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCompletionListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoPreparedListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnErrorListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnSeekCompleteListener(this);
    return (View)localISPlayerVideoView;
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
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs();
  }
  
  public void b()
  {
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 4, "enterFullScreen");
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(8);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(8, 300L);
    this.jdField_a_of_type_Auta.a(true, this.jdField_b_of_type_Int);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isOutputMute();
    }
    return false;
  }
  
  public void c()
  {
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 4, "exitFullScreen");
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(9);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(9, 300L);
    this.jdField_a_of_type_Auta.a(false, this.jdField_b_of_type_Int);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 5)
    {
      e();
      if ((this.jdField_c_of_type_Int == 2) && (jdField_a_of_type_Int == 0))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(14);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(14, auuc.jdField_b_of_type_Int - this.jdField_a_of_type_Long);
      }
      return;
    }
    if (!bgnt.g(getContext()))
    {
      ThreadManagerV2.getUIHandlerV2().post(new GameCenterVideoViewController.4(this));
      com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 2, "commentReport network error, stop request.");
      setCurrentStatus(0);
      a();
      return;
    }
    SuperPlayerVideoInfo localSuperPlayerVideoInfo;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.videoUrl)) {
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type == 1)
      {
        localSuperPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForTVideo(5590303, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.videoVid);
        this.jdField_a_of_type_AndroidViewView = a();
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView, -1, -1);
        }
        if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null) {
          break label271;
        }
        setCurrentStatus(1);
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.openMediaPlayer(getContext(), localSuperPlayerVideoInfo, 0L);
      }
    }
    for (;;)
    {
      setMute(this.jdField_c_of_type_Boolean);
      return;
      localSuperPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForTVideo(5590303, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.videoVid);
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type == 1)
      {
        localSuperPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForUrl(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.videoUrl, 201, "");
        break;
      }
      localSuperPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForUrl(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.videoUrl, 101, "");
      break;
      label271:
      com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[play] mVideoPlayer is null");
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.start();
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
    if ((bgnt.g(getContext())) && (bgnt.h(getContext())))
    {
      this.d = true;
      arrayOfInt = new int[2];
      getLocationOnScreen(arrayOfInt);
      i = getHeight();
      localDisplayMetrics = getResources().getDisplayMetrics();
      if ((arrayOfInt[1] > afur.a(50.0F, getResources())) && (arrayOfInt[1] + i < (i + localDisplayMetrics.heightPixels) / 2 + afur.a(50.0F, getResources())) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(13);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(13);
        setMute(auud.jdField_a_of_type_Boolean);
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
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.pause();
      setCurrentStatus(5);
      a();
    }
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
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
            paramMessage.mLoadingDrawable = getResources().getDrawable(2130843177);
            paramMessage.mFailedDrawable = getResources().getDrawable(2130843177);
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
            paramMessage.mLoadingDrawable = getResources().getDrawable(2130843178);
            paramMessage.mFailedDrawable = getResources().getDrawable(2130843178);
            paramMessage = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_video_play@2x.png", paramMessage);
            this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqGamecenterViewVideoLoadingImage.setVisibility(8);
            this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramMessage);
            this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
            try
            {
              this.jdField_b_of_type_ComTencentImageURLImageView.setImageURL(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.coverImgUrl);
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
              this.jdField_a_of_type_AndroidWidgetTextView.setText(pgk.a(0));
              paramMessage = pgk.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.videoDuration);
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
            paramMessage.mLoadingDrawable = getResources().getDrawable(2130843177);
            paramMessage.mFailedDrawable = getResources().getDrawable(2130843177);
            paramMessage = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_video_play@2x.png", paramMessage);
            this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqGamecenterViewVideoLoadingImage.setVisibility(8);
            this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramMessage);
            return false;
          }
          paramMessage = URLDrawable.URLDrawableOptions.obtain();
          paramMessage.mLoadingDrawable = getResources().getDrawable(2130843178);
          paramMessage.mFailedDrawable = getResources().getDrawable(2130843178);
          paramMessage = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_video_play@2x.png", paramMessage);
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqGamecenterViewVideoLoadingImage.setVisibility(8);
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramMessage);
          return false;
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 1000L);
          r();
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
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setXYaxis(2);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841754);
        this.jdField_a_of_type_Boolean = true;
        return false;
      } while (!this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this);
      this.jdField_b_of_type_AndroidViewViewGroup.addView(this, this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
      a(getContext()).getWindow().clearFlags(1024);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setXYaxis(0);
      a(getContext()).setRequestedOrientation(1);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841755);
      this.jdField_a_of_type_Boolean = false;
      return false;
    case 10: 
      if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isOutputMute())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843011);
        return false;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843012);
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
          aceh.a(paramMessage, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
          paramMessage.put(Integer.valueOf(2), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
          paramMessage.put(Integer.valueOf(6), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.feedId);
          paramMessage.put(Integer.valueOf(4), "20");
          paramMessage.put(Integer.valueOf(43), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.algorithmId);
          paramMessage.put(Integer.valueOf(44), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type + "");
          aceh.a(ampj.a(), "769", "205020", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.gameInfo.gameAppId, "76902", "1", "160", paramMessage);
        }
        ausy.a().a(this);
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewVideoLoadingImage.setVisibility(0);
        d();
        return false;
      }
      com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[handleMessage] autoplay mCurrentStatus:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      return false;
    }
    bmxq.a().a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.gameInfo.gameAppId);
    return false;
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0))
    {
      if ((this.d) && (this.jdField_b_of_type_Boolean))
      {
        HashMap localHashMap = new HashMap();
        aceh.a(localHashMap, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
        localHashMap.put(Integer.valueOf(2), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
        localHashMap.put(Integer.valueOf(6), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.feedId);
        localHashMap.put(Integer.valueOf(4), "-1");
        localHashMap.put(Integer.valueOf(42), a() + "");
        localHashMap.put(Integer.valueOf(43), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.algorithmId);
        localHashMap.put(Integer.valueOf(44), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type + "");
        aceh.a(ampj.a(), "769", "205026", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.gameInfo.gameAppId, "76902", "1", "160", localHashMap);
      }
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
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
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 1, "[hideControlPanel] hide");
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 2);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 2000L);
  }
  
  public void l()
  {
    setCurrentStatus(0);
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.release();
      com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[release] release video ok:" + this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.toString());
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
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      HashMap localHashMap;
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0)
      {
        if ((this.jdField_b_of_type_Boolean) && (!this.d))
        {
          localHashMap = new HashMap();
          aceh.a(localHashMap, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
          localHashMap.put(Integer.valueOf(2), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
          localHashMap.put(Integer.valueOf(6), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.feedId);
          localHashMap.put(Integer.valueOf(4), "20");
          localHashMap.put(Integer.valueOf(43), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.algorithmId);
          localHashMap.put(Integer.valueOf(44), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type + "");
          aceh.a(ampj.a(), "769", "205023", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.gameInfo.gameAppId, "76902", "1", "160", localHashMap);
        }
        ausy.a().a(this);
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewVideoLoadingImage.setVisibility(0);
        d();
      }
      else if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3)
      {
        if (this.jdField_b_of_type_Boolean)
        {
          localHashMap = new HashMap();
          aceh.a(localHashMap, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
          localHashMap.put(Integer.valueOf(2), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
          localHashMap.put(Integer.valueOf(6), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.feedId);
          localHashMap.put(Integer.valueOf(4), "20");
          localHashMap.put(Integer.valueOf(42), a() + "");
          localHashMap.put(Integer.valueOf(43), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.algorithmId);
          localHashMap.put(Integer.valueOf(44), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type + "");
          aceh.a(ampj.a(), "769", "205034", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.gameInfo.gameAppId, "76902", "1", "160", localHashMap);
        }
        h();
      }
      else if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 5)
      {
        if (this.jdField_b_of_type_Boolean)
        {
          localHashMap = new HashMap();
          aceh.a(localHashMap, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
          localHashMap.put(Integer.valueOf(2), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
          localHashMap.put(Integer.valueOf(6), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.feedId);
          localHashMap.put(Integer.valueOf(4), "20");
          localHashMap.put(Integer.valueOf(42), a() + "");
          localHashMap.put(Integer.valueOf(43), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.algorithmId);
          localHashMap.put(Integer.valueOf(44), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type + "");
          aceh.a(ampj.a(), "769", "205034", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.gameInfo.gameAppId, "76902", "1", "160", localHashMap);
        }
        if ((this.jdField_c_of_type_Int == 2) && (jdField_a_of_type_Int == 0))
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(14);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(14, auuc.jdField_b_of_type_Int - this.jdField_a_of_type_Long);
        }
        e();
        continue;
        if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
        {
          if (!this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isOutputMute()) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            auud.jdField_a_of_type_Boolean = bool1;
            bool1 = bool2;
            if (!this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isOutputMute()) {
              bool1 = true;
            }
            setMute(bool1);
            break;
          }
          if (this.jdField_a_of_type_Boolean) {
            c();
          } else {
            b();
          }
        }
      }
    }
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 4, "onCompletion");
    setCurrentStatus(7);
    i();
    l();
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 4, "SuperPlayer onError:i i1 i2 " + paramString);
    l();
    ThreadManagerV2.getUIHandlerV2().post(new GameCenterVideoViewController.2(this));
    com.tencent.qphone.base.util.QLog.e("GameCenterVideoViewController", 1, "[onError] " + paramInt1 + ", " + paramInt2 + ", " + paramInt3);
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 4, "SuperPlayer onInfo:i i1 i2 " + paramObject);
    return false;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 4, "onSeekComplete");
    e();
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    int i = paramSeekBar.getProgress();
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 2, "onStopTrackingTouch(): progress=" + i);
    }
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.seekTo(i);
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 4, "SuperPlayer onVideoPrepared");
    ThreadManagerV2.getUIHandlerV2().post(new GameCenterVideoViewController.3(this));
  }
  
  public void setCurrentStatus(int paramInt)
  {
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("GameCenterVideoViewController", 2, "[setCurrentStatus] status:" + paramInt + ", obj:" + this);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
    a(paramInt);
    if (this.jdField_a_of_type_Auta != null) {
      this.jdField_a_of_type_Auta.a(paramInt, this.jdField_b_of_type_Int);
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
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOutputMute(paramBoolean);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10, 300L);
      if (this.jdField_a_of_type_Auta != null) {
        this.jdField_a_of_type_Auta.b(paramBoolean, this.jdField_b_of_type_Int);
      }
    }
  }
  
  public void setVideoId(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setVideoStatusChangerListener(auta paramauta)
  {
    this.jdField_a_of_type_Auta = paramauta;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController
 * JD-Core Version:    0.7.0.1
 */