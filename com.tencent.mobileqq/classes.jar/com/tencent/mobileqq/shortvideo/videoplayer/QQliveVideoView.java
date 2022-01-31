package com.tencent.mobileqq.shortvideo.videoplayer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import awnc;
import awnd;
import awng;
import awnh;
import awrc;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase.IVideoViewCallBack;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class QQliveVideoView
  extends FrameLayout
  implements awng, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnSeekCompleteListener, TVK_IMediaPlayer.OnVideoPreparedListener, IVideoViewBase.IVideoViewCallBack
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public Context a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private awnh jdField_a_of_type_Awnh;
  private QQliveVideoView.ProgressChecker jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerQQliveVideoView$ProgressChecker;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private String jdField_a_of_type_JavaLangString;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private String f;
  
  public QQliveVideoView(Context paramContext, long paramLong)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_d_of_type_Boolean = false;
    g();
  }
  
  private void a(String paramString) {}
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +33 -> 38
    //   8: aload_0
    //   9: invokevirtual 124	com/tencent/mobileqq/shortvideo/videoplayer/QQliveVideoView:a	()Ljava/lang/String;
    //   12: iconst_2
    //   13: new 126	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   20: ldc 130
    //   22: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: getfield 80	com/tencent/mobileqq/shortvideo/videoplayer/QQliveVideoView:jdField_a_of_type_Int	I
    //   29: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aload_0
    //   39: getfield 145	com/tencent/mobileqq/shortvideo/videoplayer/QQliveVideoView:jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory	Lcom/tencent/qqlive/mediaplayer/api/TVK_IProxyFactory;
    //   42: ifnonnull +37 -> 79
    //   45: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   48: ifeq +13 -> 61
    //   51: aload_0
    //   52: invokevirtual 124	com/tencent/mobileqq/shortvideo/videoplayer/QQliveVideoView:a	()Ljava/lang/String;
    //   55: iconst_2
    //   56: ldc 147
    //   58: invokestatic 149	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: aload_0
    //   62: getfield 89	com/tencent/mobileqq/shortvideo/videoplayer/QQliveVideoView:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   65: ifnull +11 -> 76
    //   68: aload_0
    //   69: getfield 89	com/tencent/mobileqq/shortvideo/videoplayer/QQliveVideoView:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   72: iconst_0
    //   73: invokevirtual 154	android/widget/ImageView:setVisibility	(I)V
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: aload_0
    //   80: iconst_2
    //   81: aconst_null
    //   82: invokevirtual 157	com/tencent/mobileqq/shortvideo/videoplayer/QQliveVideoView:a	(ILjava/lang/Object;)V
    //   85: aload_0
    //   86: aload_0
    //   87: getfield 145	com/tencent/mobileqq/shortvideo/videoplayer/QQliveVideoView:jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory	Lcom/tencent/qqlive/mediaplayer/api/TVK_IProxyFactory;
    //   90: aload_0
    //   91: getfield 68	com/tencent/mobileqq/shortvideo/videoplayer/QQliveVideoView:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   94: invokevirtual 163	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   97: aload_0
    //   98: getfield 165	com/tencent/mobileqq/shortvideo/videoplayer/QQliveVideoView:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   101: checkcast 167	com/tencent/qqlive/mediaplayer/view/IVideoViewBase
    //   104: invokeinterface 173 3 0
    //   109: putfield 98	com/tencent/mobileqq/shortvideo/videoplayer/QQliveVideoView:jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   112: aload_0
    //   113: getfield 98	com/tencent/mobileqq/shortvideo/videoplayer/QQliveVideoView:jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   116: iconst_2
    //   117: invokeinterface 178 2 0
    //   122: aload_0
    //   123: getfield 98	com/tencent/mobileqq/shortvideo/videoplayer/QQliveVideoView:jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   126: aload_0
    //   127: invokeinterface 182 2 0
    //   132: aload_0
    //   133: getfield 98	com/tencent/mobileqq/shortvideo/videoplayer/QQliveVideoView:jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   136: aload_0
    //   137: invokeinterface 186 2 0
    //   142: aload_0
    //   143: getfield 98	com/tencent/mobileqq/shortvideo/videoplayer/QQliveVideoView:jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   146: aload_0
    //   147: invokeinterface 190 2 0
    //   152: aload_0
    //   153: getfield 98	com/tencent/mobileqq/shortvideo/videoplayer/QQliveVideoView:jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   156: aload_0
    //   157: invokeinterface 194 2 0
    //   162: aload_0
    //   163: getfield 98	com/tencent/mobileqq/shortvideo/videoplayer/QQliveVideoView:jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   166: aload_0
    //   167: invokeinterface 198 2 0
    //   172: aload_0
    //   173: getfield 98	com/tencent/mobileqq/shortvideo/videoplayer/QQliveVideoView:jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   176: aload_0
    //   177: invokeinterface 202 2 0
    //   182: goto -106 -> 76
    //   185: astore_1
    //   186: aload_0
    //   187: monitorexit
    //   188: aload_1
    //   189: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	QQliveVideoView
    //   185	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	185	finally
    //   38	61	185	finally
    //   61	76	185	finally
    //   79	182	185	finally
  }
  
  private void e()
  {
    int i = 0;
    for (;;)
    {
      Object localObject;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d(a(), 2, "openPlayer ");
        }
        TVK_PlayerVideoInfo localTVK_PlayerVideoInfo1;
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          a(2, null);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(this.jdField_a_of_type_Boolean);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(this.jdField_c_of_type_Boolean);
          localTVK_PlayerVideoInfo1 = new TVK_PlayerVideoInfo();
          localTVK_PlayerVideoInfo1.setConfigMap("keep_last_frame", "true");
          if (this.jdField_b_of_type_Boolean)
          {
            localTVK_PlayerVideoInfo1.setPlayType(4);
            if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
              localTVK_PlayerVideoInfo1.setConfigMap("cache_servers_type", this.jdField_e_of_type_JavaLangString);
            }
            if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
              localTVK_PlayerVideoInfo1.setConfigMap("file_dir", this.jdField_b_of_type_JavaLangString);
            }
            if (this.jdField_b_of_type_Long > 0L) {
              localTVK_PlayerVideoInfo1.setConfigMap("duration", String.valueOf(this.jdField_b_of_type_Long));
            }
            if (!TextUtils.isEmpty(this.f)) {
              localTVK_PlayerVideoInfo1.setVid(this.f);
            }
            localObject = new HashMap();
            if (this.jdField_d_of_type_JavaLangString != null) {
              ((Map)localObject).put("shouq_bus_type", this.jdField_d_of_type_JavaLangString);
            }
            localTVK_PlayerVideoInfo1.setReportInfoMap((Map)localObject);
            if (!this.jdField_b_of_type_Boolean) {
              break label291;
            }
            this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 0L, localTVK_PlayerVideoInfo1);
            this.jdField_a_of_type_Int = 0;
            QLog.d(a(), 2, "openPlayer, openMediaPlayerByUrl, videoPath = " + this.jdField_a_of_type_JavaLangString);
          }
        }
        else
        {
          return;
        }
        localTVK_PlayerVideoInfo1.setPlayType(2);
        continue;
        if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
          continue;
        }
      }
      finally {}
      label291:
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_Int, 0L, localTVK_PlayerVideoInfo2, null);
      this.jdField_a_of_type_Int = 0;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
        int j = localObject.length;
        while (i < j)
        {
          localStringBuilder.append(localObject[i]).append(" ; ");
          i += 1;
        }
        QLog.d(a(), 2, "openPlayer, openMediaPlayerByUrl, urls = " + localStringBuilder.toString());
      }
    }
  }
  
  private void f()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      h();
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 1) {
        a(2, null);
      }
      this.jdField_a_of_type_Int = 0;
      d();
      e();
      return;
    }
    finally {}
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d(a(), 2, "initView");
    }
    awnd.a().a(this.jdField_a_of_type_AndroidContentContext, this);
    h();
    i();
  }
  
  private void h()
  {
    try
    {
      if (findViewById(2131307461) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(a(), 2, "addTVKVideoView, videoView is exist");
        }
        removeView(findViewById(2131307461));
      }
      if (TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()))
      {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null)
        {
          this.jdField_a_of_type_AndroidViewView = ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(this.jdField_a_of_type_AndroidContentContext));
          ((IVideoViewBase)this.jdField_a_of_type_AndroidViewView).addViewCallBack(this);
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidViewView == null) {
          this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
        }
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_AndroidViewView.setId(2131307461);
        addView(this.jdField_a_of_type_AndroidViewView, 0);
        return;
        if (QLog.isColorLevel()) {
          QLog.d(a(), 2, "TVK_SDKMgr.isInstalled = false");
        }
        a(1, null);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(a(), 1, "addTVKVideoView error。", localThrowable);
    }
  }
  
  private void i()
  {
    try
    {
      if (findViewById(2131307459) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(a(), 2, "addCoverImageView, imageView is exist");
        }
        removeView(findViewById(2131307459));
      }
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetImageView.setId(2131307459);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      addView(this.jdField_a_of_type_AndroidWidgetImageView, 1);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(a(), 1, "addCoverImageView error。", localThrowable);
    }
  }
  
  private void j() {}
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      a(3, null);
      l();
    }
  }
  
  private void l()
  {
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_AndroidOsHandler != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerQQliveVideoView$ProgressChecker == null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerQQliveVideoView$ProgressChecker = new QQliveVideoView.ProgressChecker(this);
      }
      if (QLog.isColorLevel()) {
        QLog.d(a(), 2, "startCheckPlayProgress");
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerQQliveVideoView$ProgressChecker);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerQQliveVideoView$ProgressChecker, 500L);
    }
  }
  
  private void m()
  {
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerQQliveVideoView$ProgressChecker != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(a(), 2, "stopCheckPlayProgress");
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerQQliveVideoView$ProgressChecker);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerQQliveVideoView$ProgressChecker = null;
    }
  }
  
  public void OnDownloadCallback(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a(), 2, "OnDownloadCallback, str = " + paramString);
    }
    if (this.jdField_a_of_type_Awnh != null) {
      this.jdField_a_of_type_Awnh.a(this.jdField_a_of_type_Long, paramString);
    }
  }
  
  public long a()
  {
    l2 = -1L;
    l1 = l2;
    try
    {
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
      {
        l1 = l2;
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) {
          l1 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(a(), 2, "getCurPlayingPos() curPosi = " + l1);
    }
    return l1;
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  protected String a()
  {
    return "QQliveVideoView[" + b() + "][state:" + awnc.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) + "]";
  }
  
  public void a()
  {
    a("pause");
    if (QLog.isColorLevel()) {
      QLog.d(a(), 2, "pause");
    }
    try
    {
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2)) {
        a(5, null);
      }
      ThreadManagerV2.executeOnFileThread(new QQliveVideoView.2(this));
      return;
    }
    finally {}
  }
  
  protected void a(int paramInt, Object paramObject)
  {
    if (paramInt != this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d(a(), 2, "changeStateAndNotify() , newState = " + awnc.a(paramInt));
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
      ThreadManager.getUIHandler().post(new QQliveVideoView.3(this, paramInt, paramObject));
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    a("showCover");
    if (QLog.isColorLevel()) {
      QLog.d(a(), 2, "showCover");
    }
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    a(false);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    a("playVideoLocal");
    if ((paramString == null) || (paramString.length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e(a(), 2, "playVideoLocal, videoPath is null ");
      }
      return;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      bool1 = bool2;
      if (paramString.equals(this.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (paramBoolean == this.jdField_a_of_type_Boolean)
        {
          bool1 = bool2;
          if (this.jdField_b_of_type_Boolean) {
            bool1 = true;
          }
        }
      }
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(a(), 2, "playVideoLocal, videoPath = " + paramString + ", isLoop = " + paramBoolean + " , isSameVideo = " + bool1);
    }
    if (bool1)
    {
      b();
      return;
    }
    f();
  }
  
  public void a(boolean paramBoolean)
  {
    a("releasePlayer");
    if (QLog.isColorLevel()) {
      QLog.d(a(), 2, "releasePlayer");
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 8)
      {
        if (QLog.isColorLevel()) {
          QLog.d(a(), 2, "has released, do nothing.");
        }
        return;
      }
      a(8, null);
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.removeAllListener();
      }
      m();
      this.jdField_a_of_type_Awnh = null;
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      ThreadManagerV2.executeOnFileThread(new QQliveVideoView.1(this, paramBoolean));
      if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof IVideoViewBase)))
      {
        ((IVideoViewBase)this.jdField_a_of_type_AndroidViewView).removeViewCallBack(this);
        return;
      }
    }
    finally {}
  }
  
  public void a(String[] paramArrayOfString, boolean paramBoolean)
  {
    boolean bool2 = false;
    a("playVideoOnline");
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e(a(), 2, "playVideoOnline, urls is null ");
      }
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Boolean = false;
    boolean bool1 = bool2;
    if (paramBoolean == this.jdField_a_of_type_Boolean)
    {
      bool1 = bool2;
      if (!this.jdField_b_of_type_Boolean)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ArrayOfJavaLangString.length == paramArrayOfString.length)
          {
            int i = 0;
            for (bool1 = false; i < paramArrayOfString.length; bool1 = true)
            {
              if ((this.jdField_a_of_type_ArrayOfJavaLangString[i] == null) || (paramArrayOfString[i] == null) || (!this.jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramArrayOfString[i])))
              {
                bool1 = bool2;
                if (this.jdField_a_of_type_ArrayOfJavaLangString[i] != paramArrayOfString[i]) {
                  break;
                }
              }
              i += 1;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(a(), 2, "playVideoOnline, urls.length = " + paramArrayOfString.length + ", isLoop = " + paramBoolean + ", isSameVideo = " + bool1);
    }
    if (bool1)
    {
      b();
      return;
    }
    f();
  }
  
  protected long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void b()
  {
    a("resume");
    if (QLog.isColorLevel()) {
      QLog.d(a(), 2, "resume, mIsPlayVideo = " + this.jdField_d_of_type_Boolean);
    }
    if (!this.jdField_d_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a(), 2, "resume , mIsPlayVideo is false , do nothing.");
      }
      return;
    }
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2))
        {
          if (QLog.isColorLevel()) {
            QLog.d(a(), 2, "resume, do nothing.");
          }
          if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (QLog.isColorLevel())) {
            QLog.d(a(), 2, "resume, mMediaPlayer.isPlaying() = " + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying());
          }
          return;
        }
      }
      finally {}
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(a(), 2, "resume, mMediaPlayer != null ");
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 5)
        {
          if (QLog.isColorLevel()) {
            QLog.d(a(), 2, "resume, mMediaPlayer.isPauseing() =  " + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPauseing());
          }
          if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          }
          k();
          if (QLog.isColorLevel()) {
            QLog.d(a(), 2, "resume, startPlayer() ");
          }
        }
        else
        {
          e();
        }
      }
      else
      {
        d();
        e();
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(a(), 2, "onSDKInstalled ");
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {
      ThreadManager.getUIHandler().post(new QQliveVideoView.6(this));
    }
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a(), 2, "onCompletion, mIsLoop = " + this.jdField_a_of_type_Boolean);
    }
    a(7, null);
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramTVK_IMediaPlayer = "model = " + paramInt1 + " , what = " + paramInt2 + " ,extra = " + paramInt3 + " ,detailInfo = " + paramString + " ,Info = " + paramObject;
    QLog.d(a(), 1, "onError, " + paramTVK_IMediaPlayer);
    if (!QLog.isColorLevel()) {}
    for (;;)
    {
      a(6, null);
      a(false);
      return false;
      awrc.a("QQliveVideoView_onError", paramTVK_IMediaPlayer);
    }
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(a(), 2, "[TVK_IMediaPlayer] onInfo(): PLAYER_INFO_START_BUFFERING");
      }
      a(4, null);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d(a(), 2, "[TVK_IMediaPlayer] onInfo(): PLAYER_INFO_ENDOF_BUFFERING");
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4) {
        a(3, null);
      }
    }
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a(), 2, "onSeekComplete");
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a(), 2, "onSeekComplete, startPlayer()");
      }
      k();
      ThreadManager.getUIHandler().postDelayed(new QQliveVideoView.5(this), 0L);
    }
  }
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a(), 2, "onSurfaceChanged");
    }
  }
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a(), 2, "onSurfaceCreated");
    }
  }
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a(), 2, "onSurfaceDestory");
    }
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      paramTVK_IMediaPlayer = a();
      localStringBuilder = new StringBuilder().append("onVideoPrepared, mMediaPlayer == null ? ");
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
        break label113;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      QLog.d(paramTVK_IMediaPlayer, 2, bool);
      label113:
      try
      {
        if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2))
        {
          if (QLog.isColorLevel()) {
            QLog.d(a(), 2, "onVideoPrepared, startPlayer.");
          }
          k();
        }
        ThreadManager.getUIHandler().postDelayed(new QQliveVideoView.4(this), 300L);
        return;
      }
      finally {}
    }
  }
  
  public void setCoverDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
    }
  }
  
  public void setCoverPath(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void setLogID(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    j();
  }
  
  public void setMaxPlayTimeMs(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
    this.jdField_e_of_type_Boolean = true;
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setPlayBusiType(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public void setSavePath(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void setServerType(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public void setVid(String paramString)
  {
    this.f = paramString;
  }
  
  public void setVideoFileTimeMs(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void setVideoPlayerCallback(awnh paramawnh)
  {
    this.jdField_a_of_type_Awnh = paramawnh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.videoplayer.QQliveVideoView
 * JD-Core Version:    0.7.0.1
 */