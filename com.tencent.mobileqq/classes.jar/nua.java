import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailVideoManager.5;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class nua
{
  static boolean jdField_a_of_type_Boolean;
  static boolean b;
  int jdField_a_of_type_Int;
  public Activity a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new nuf(this);
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView = null;
  TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
  TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = null;
  TVK_PlayerVideoInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo = null;
  TVK_UserInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo = null;
  public nug a;
  public boolean c = true;
  
  public nua(Activity paramActivity, nug paramnug)
  {
    this.jdField_a_of_type_AndroidContentContext = paramActivity.getApplicationContext();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Nug = paramnug;
    a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    paramActivity = new IntentFilter();
    paramActivity.addAction("android.intent.action.SCREEN_OFF");
    paramActivity.addAction("tencent.av.v2q.StartVideoChat");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramActivity);
  }
  
  private View a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null) {
        return null;
      }
    }
    return (View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private static boolean a(Context paramContext)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailVideoManager", 2, "isSDKloaded context= null");
      }
      return false;
    }
    if (!b)
    {
      TVK_SDKMgr.initSdk(paramContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      TVK_SDKMgr.setDebugEnable(true);
      b = true;
    }
    if (TVK_SDKMgr.isInstalled(paramContext)) {
      jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      return jdField_a_of_type_Boolean;
      jdField_a_of_type_Boolean = false;
      c();
    }
  }
  
  private static void c()
  {
    ThreadManager.post(new AccountDetailVideoManager.5(), 2, null, false);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
    {
      this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailVideoManager", 2, "pausePlayVideo , mCurrentPosition = " + this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
  }
  
  void a(FrameLayout paramFrameLayout)
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = a();
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1);
        localObject = new FrameLayout.LayoutParams(-1, -1);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramFrameLayout.addView(this.jdField_a_of_type_AndroidViewView, new ViewGroup.LayoutParams(-1, -1));
      }
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.c) && (this.jdField_a_of_type_AndroidViewView.getParent() != null))
    {
      localObject = this.jdField_a_of_type_AndroidViewView.getParent();
      if ((localObject instanceof ViewGroup))
      {
        ((ViewGroup)localObject).removeView(this.jdField_a_of_type_AndroidViewView);
        paramFrameLayout.addView(this.jdField_a_of_type_AndroidViewView, new ViewGroup.LayoutParams(-1, -1));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailVideoManager", 2, "onCreateVideoSdkView needRemoveAndAdd = " + this.c);
    }
  }
  
  void a(obq paramobq)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(this.jdField_a_of_type_AndroidContentContext, (IVideoViewBase)this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new nub(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(new nuc(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new nud(this));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo = new TVK_UserInfo("", "");
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (paramobq.a != null)
        {
          localObject1 = localObject2;
          if (paramobq.a.size() != 0) {
            localObject1 = ((obr)paramobq.a.get(0)).j;
          }
        }
        if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
        {
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, (String)localObject1, "");
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(true);
          paramobq = new HashMap();
          paramobq.put("shouq_bus_type", "bus_type_account_detail");
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setReportInfoMap(paramobq);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayer(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo, "", 0L, 0L);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(2);
        }
      }
      return;
    }
  }
  
  public void a(obq paramobq, FrameLayout paramFrameLayout)
  {
    if (jdField_a_of_type_Boolean)
    {
      a(paramFrameLayout);
      a(paramobq);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPauseing()) {
        break label86;
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo(this.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailVideoManager", 2, "restartPlayVideo , mCurrentPosition = " + this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      this.jdField_a_of_type_Nug.f();
    }
    label86:
    while (!paramBoolean) {
      return;
    }
    this.jdField_a_of_type_Nug.g();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailVideoManager", 2, "releaseMediaPlayer");
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nua
 * JD-Core Version:    0.7.0.1
 */