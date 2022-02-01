package com.tencent.mobileqq.kandian.base.video.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.mobileqq.kandian.base.utils.VideoSessionUtils;
import com.tencent.mobileqq.kandian.base.video.VideoPlayUtils;
import com.tencent.mobileqq.kandian.base.video.player.api.IEventListener;
import com.tencent.mobileqq.kandian.base.video.player.api.IPlayer;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoView;
import com.tencent.mobileqq.kandian.base.video.player.api.MediaPlayListener;
import com.tencent.mobileqq.kandian.base.video.player.config.CodecReuseHelper;
import com.tencent.mobileqq.kandian.base.video.player.config.CodecReuseHelper.OnCodecReuseInfoUpdateCallback;
import com.tencent.mobileqq.kandian.base.video.player.config.ISuperPlayerOptionConfig;
import com.tencent.mobileqq.kandian.base.video.player.config.QuicConfigHelper;
import com.tencent.mobileqq.kandian.base.video.player.config.QuicConfigHelper.Companion;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.IPlayerFactory;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerVideoInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.seamless.SPSeamlessHelper;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPProtocolInfo;
import com.tencent.util.VersionUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VideoPlayerWrapper
  implements PlayState, IEventListener, IVideoPlayerWrapper
{
  private static ISuperPlayerOptionConfig jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerConfigISuperPlayerOptionConfig;
  private static boolean jdField_f_of_type_Boolean = true;
  private static int jdField_g_of_type_Int = 6;
  public int a;
  public long a;
  protected Context a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  @Nullable
  private IPlayer jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
  @Nullable
  private IVideoView jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView;
  private MediaPlayListener jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiMediaPlayListener;
  private CodecReuseHelper.OnCodecReuseInfoUpdateCallback jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerConfigCodecReuseHelper$OnCodecReuseInfoUpdateCallback;
  private CodecReuseHelper jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerConfigCodecReuseHelper;
  private QuicConfigHelper jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerConfigQuicConfigHelper;
  @NotNull
  private IPlayerFactory jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerFactory;
  private Object jdField_a_of_type_JavaLangObject;
  public String a;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  public boolean a;
  public int b;
  public long b;
  private final Object jdField_b_of_type_JavaLangObject;
  private final String jdField_b_of_type_JavaLangString;
  public boolean b;
  private int jdField_c_of_type_Int;
  public long c;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private long jdField_f_of_type_Long;
  private long jdField_g_of_type_Long;
  private boolean jdField_g_of_type_Boolean;
  private long jdField_h_of_type_Long;
  private boolean jdField_h_of_type_Boolean;
  private long jdField_i_of_type_Long;
  private boolean jdField_i_of_type_Boolean;
  private boolean j;
  
  public VideoPlayerWrapper(Context paramContext)
  {
    this(paramContext, "");
  }
  
  public VideoPlayerWrapper(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.readinjoy.video.VideoPlayerWrapper<");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    localStringBuilder.append(">");
    this.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_c_of_type_Int = 101;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_d_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_c_of_type_Long = 0L;
    this.jdField_f_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerConfigCodecReuseHelper = new CodecReuseHelper();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerConfigCodecReuseHelper$OnCodecReuseInfoUpdateCallback = null;
    this.j = false;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerConfigQuicConfigHelper = new QuicConfigHelper();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c(paramString);
    this.jdField_c_of_type_JavaLangString = VideoSessionUtils.a();
  }
  
  private int a(ViewGroup paramViewGroup)
  {
    IVideoView localIVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView;
    if ((localIVideoView != null) && ((localIVideoView.a() instanceof ISPlayerVideoView)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "seamlessAttachVideoView: ");
      }
      SPSeamlessHelper.get().attachVideoView(paramViewGroup, (ISPlayerVideoView)this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView.a(), new ViewGroup.LayoutParams(-1, -1));
      if (!this.jdField_i_of_type_Boolean) {
        return 1;
      }
      if (!r()) {
        return 2;
      }
      c();
    }
    return 0;
  }
  
  private SuperPlayerOption a(boolean paramBoolean)
  {
    SuperPlayerOption localSuperPlayerOption = SuperPlayerOption.obtain(104);
    localSuperPlayerOption.isPrePlay = paramBoolean;
    Object localObject = jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerConfigISuperPlayerOptionConfig;
    if (localObject != null) {
      ((ISuperPlayerOptionConfig)localObject).a(localSuperPlayerOption);
    }
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("commonPlayerOption: ");
      localStringBuilder.append(localSuperPlayerOption);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return localSuperPlayerOption;
  }
  
  public static void a(ISuperPlayerOptionConfig paramISuperPlayerOptionConfig)
  {
    jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerConfigISuperPlayerOptionConfig = paramISuperPlayerOptionConfig;
  }
  
  private void a(PlayerVideoInfo paramPlayerVideoInfo)
  {
    if (paramPlayerVideoInfo != null)
    {
      paramPlayerVideoInfo.c(this.jdField_d_of_type_Boolean);
      paramPlayerVideoInfo.b(this.jdField_e_of_type_Boolean);
      paramPlayerVideoInfo.a(jdField_g_of_type_Int);
    }
  }
  
  private IVideoView b()
  {
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    if (localContext == null)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "createVideoView_Scroll: error, mContext null");
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerFactory.a(localContext, VersionUtils.d());
  }
  
  private void b(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("VideoFeedsPlayManager playerStartByUrl vid = ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("VideoFeedsPlayManager.preplay", 2, ((StringBuilder)localObject).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("#VideoPlayerWrapper# playerStartByUrl, url:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", fileSize:");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(", videoDuration:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("，mState:");
      localStringBuilder.append(VideoPlayUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (!s())
    {
      paramString2 = this.jdField_b_of_type_JavaLangString;
      paramString3 = new StringBuilder();
      paramString3.append("not idle or complete state, should't reopen mediaplayer, vid:");
      paramString3.append(paramString1);
      paramString3.append("，mState:");
      paramString3.append(VideoPlayUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
      paramString3.append(" ,mIsSeamlessPlay:");
      paramString3.append(this.jdField_i_of_type_Boolean);
      QLog.e(paramString2, 1, paramString3.toString());
      return;
    }
    n();
    boolean bool = false;
    if (paramBoolean2)
    {
      localObject = ThirdVideoManager.a().a(paramString2);
      a((String[])localObject);
    }
    else
    {
      localObject = new String[1];
      localObject[0] = paramString2;
      a((String[])localObject);
    }
    paramString1 = new PlayerVideoInfo(paramInt1, paramString1, (String[])localObject);
    paramString1.a(paramBoolean3);
    paramString1.a(paramInt2 * 1000);
    paramString1.d(paramBoolean1);
    paramString1.b(paramString3);
    a(paramString1);
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer != null))
    {
      paramString3 = a(paramBoolean3);
      paramString3.superPlayerDownOption.quicEnableMode = QuicConfigHelper.a.a(this.jdField_a_of_type_AndroidContentContext, paramString2);
      paramString3.superPlayerDownOption.enableQuicPlaintext = QuicConfigHelper.a.a();
      paramString3.superPlayerDownOption.enableQuicConnectionMigration = QuicConfigHelper.a.b();
      paramString3.superPlayerDownOption.quicCongestionType = QuicConfigHelper.a.a();
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerConfigQuicConfigHelper;
      paramBoolean1 = bool;
      if (paramString3.superPlayerDownOption.quicEnableMode > 0) {
        paramBoolean1 = true;
      }
      paramString2.a(paramBoolean1);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer.a(this.jdField_a_of_type_AndroidContentContext, paramString1, paramLong1, paramString3);
    }
    this.jdField_f_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_g_of_type_Long = paramLong1;
    this.jdField_c_of_type_Int = paramInt1;
  }
  
  public static void c(int paramInt)
  {
    jdField_g_of_type_Int = paramInt;
  }
  
  private void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerFactory = PlayerHelper.a.a();
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "VideoPlayerWrapper initPlayer success!");
      }
      boolean bool = TextUtils.isEmpty(paramString) ^ true;
      Object localObject;
      if (bool)
      {
        this.jdField_i_of_type_Boolean = a(paramString);
        if (!this.jdField_i_of_type_Boolean)
        {
          localObject = this.jdField_b_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("SeamlessPlay error for that token(");
          localStringBuilder.append(paramString);
          localStringBuilder.append(") is not validate.");
          QLog.e((String)localObject, 2, localStringBuilder.toString());
        }
      }
      if (!this.jdField_i_of_type_Boolean)
      {
        this.jdField_g_of_type_Boolean = jdField_f_of_type_Boolean;
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerFactory.a(null);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer.a(this);
      c(this.jdField_g_of_type_Boolean);
      d(this.jdField_h_of_type_Boolean);
      if (QLog.isColorLevel())
      {
        paramString = this.jdField_b_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("new VideoPlayerWrapper, needSeamlessPlay:");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(" ,mIsSeamlessPlay:");
        ((StringBuilder)localObject).append(this.jdField_i_of_type_Boolean);
        QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public static void f(boolean paramBoolean)
  {
    jdField_f_of_type_Boolean = paramBoolean;
  }
  
  private void q()
  {
    this.jdField_f_of_type_Int = 0;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
  }
  
  private boolean r()
  {
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localIPlayer == null) {
      return false;
    }
    if (localIPlayer.d())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer.e())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer.c())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(4);
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer.b())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer.f())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
      return true;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(6);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "seamlessAttachVideoView: error state");
    }
    return false;
  }
  
  private boolean s()
  {
    boolean bool2 = this.jdField_i_of_type_Boolean;
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (PlayerHelper.a.a()) {
      return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1);
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1)) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(7, 1)) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(6, 1))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public int a()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if ((localObject != null) && (this.jdField_i_of_type_Boolean)) {
      return a((ViewGroup)localObject);
    }
    localObject = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seamlessAttachVideoView failed for parent is null or not seamlessPlay. mIsSeamlessPlay:");
    localStringBuilder.append(this.jdField_i_of_type_Boolean);
    QLog.e((String)localObject, 2, localStringBuilder.toString());
    return 1;
  }
  
  public long a()
  {
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localIPlayer == null) {
      return 0L;
    }
    return localIPlayer.b();
  }
  
  public long a(boolean paramBoolean)
  {
    long l3 = this.jdField_e_of_type_Long;
    long l1;
    if (paramBoolean) {
      l1 = b();
    } else {
      l1 = a();
    }
    long l4 = this.jdField_g_of_type_Long;
    long l2 = l3;
    if (l1 - l4 > 0L) {
      l2 = l3 + (l1 - l4);
    }
    return l2;
  }
  
  public View a()
  {
    IVideoView localIVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView;
    if (localIVideoView != null) {
      return localIVideoView.a();
    }
    return null;
  }
  
  public IVideoView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public Properties a()
  {
    return new Properties();
  }
  
  public void a()
  {
    IVideoView localIVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView;
    if (localIVideoView != null) {
      localIVideoView.a();
    }
  }
  
  public void a(float paramFloat)
  {
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localIPlayer != null) {
      localIPlayer.a(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    String str = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("test seekTo aaa");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",state:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    ViolaLogUtils.d(str, localStringBuilder.toString());
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 1) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 8))
    {
      long l1 = a();
      long l2 = this.jdField_g_of_type_Long;
      if (l1 - l2 > 0L) {
        this.jdField_e_of_type_Long += l1 - l2;
      }
      this.jdField_g_of_type_Long = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer.a(paramInt, 1);
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if ((localIPlayer != null) && (paramInt1 > 0) && (paramInt2 > 0)) {
      localIPlayer.a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[IPlayer] onDownloadCallback downloadedSizeBytes: ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(", totalSizeBytes=");
      localStringBuilder.append(paramLong2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_c_of_type_Long = Math.max(this.jdField_c_of_type_Long, paramLong1);
    if (this.jdField_a_of_type_Int <= 0)
    {
      paramLong1 = this.jdField_b_of_type_Long;
      if (paramLong1 > 0L)
      {
        paramLong2 = this.jdField_d_of_type_Long;
        if (paramLong2 > 0L) {
          this.jdField_a_of_type_Int = ((int)((float)paramLong1 / 1024.0F * 8.0F / ((float)paramLong2 / 1000.0F)));
        }
      }
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    a(paramViewGroup, false, true);
  }
  
  public void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    a(paramViewGroup, paramBoolean, true);
  }
  
  public void a(ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initVideoView parent:");
      ((StringBuilder)localObject2).append(paramViewGroup);
      ((StringBuilder)localObject2).append(" ,reUseVideoView:");
      ((StringBuilder)localObject2).append(paramBoolean1);
      ((StringBuilder)localObject2).append(" ,autoAttachVideoView:");
      ((StringBuilder)localObject2).append(paramBoolean2);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localObject2 != null) {
      localObject1 = ((IPlayer)localObject2).a();
    }
    int k;
    if ((paramBoolean1) && (this.jdField_i_of_type_Boolean) && (localObject1 != null)) {
      k = 1;
    } else {
      k = 0;
    }
    if (k != 0) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView = ((IVideoView)localObject1);
    } else {
      b();
    }
    if (paramViewGroup != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView;
      if ((localObject1 != null) && (((IVideoView)localObject1).a() != null))
      {
        if (k != 0)
        {
          if (paramBoolean2) {
            a(paramViewGroup);
          }
          a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView);
          return;
        }
        paramViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView.a(), new ViewGroup.LayoutParams(-1, -1));
        a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView);
      }
    }
  }
  
  public void a(@NotNull IPlayer paramIPlayer)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[IPlayer] onVideoPrepared(): stremDumpInfo=");
      localStringBuilder.append(paramIPlayer.a());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiMediaPlayListener;
    if (localObject != null) {
      ((MediaPlayListener)localObject).a(this, this.jdField_a_of_type_JavaLangObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localObject != null) {
      this.jdField_d_of_type_Long = ((IPlayer)localObject).a();
    }
    long l1 = this.jdField_b_of_type_Long;
    if (l1 > 0L)
    {
      long l2 = this.jdField_d_of_type_Long;
      if (l2 > 0L) {
        this.jdField_a_of_type_Int = ((int)((float)l1 / 1024.0F * 8.0F / ((float)l2 / 1000.0F)));
      }
    }
    com.tencent.mobileqq.app.ThreadManager.post(new VideoPlayerWrapper.1(this, paramIPlayer), 5, null, false);
  }
  
  public void a(@NotNull IPlayer paramIPlayer, int paramInt1, int paramInt2)
  {
    paramIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiMediaPlayListener;
    if (paramIPlayer != null) {
      paramIPlayer.a(this, false, paramInt2, paramInt1, null);
    }
  }
  
  public void a(@NotNull IPlayer paramIPlayer, int paramInt1, int paramInt2, int paramInt3, @Nullable Bitmap paramBitmap)
  {
    paramIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiMediaPlayListener;
    if (paramIPlayer != null) {
      paramIPlayer.a(this, true, 0, paramInt1, paramBitmap);
    }
  }
  
  public void a(IVideoView paramIVideoView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "attachVideoView: ");
    }
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localIPlayer == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "attachVideoView: videoplayer null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView = paramIVideoView;
    localIPlayer.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer.a(this.jdField_d_of_type_Int);
  }
  
  public void a(MediaPlayListener paramMediaPlayListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiMediaPlayListener = paramMediaPlayListener;
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(String paramString)
  {
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localIPlayer != null) {
      localIPlayer.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    a(paramString, paramInt, paramLong, false);
  }
  
  public void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("VideoFeedsPlayManager playerStart vid = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("VideoFeedsPlayManager.preplay", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("#VideoPlayerWrapper# playerStart, vid:");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(", playType:");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(", startPosition:");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("，mState:");
      ((StringBuilder)localObject2).append(VideoPlayUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (!s())
    {
      localObject1 = this.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("not idle or complete state, should't reopen mediaplayer, vid:");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("，mState:");
      ((StringBuilder)localObject2).append(VideoPlayUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
      ((StringBuilder)localObject2).append(", mSeamlessPlay:");
      ((StringBuilder)localObject2).append(this.jdField_i_of_type_Boolean);
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return;
    }
    n();
    paramString = new PlayerVideoInfo(paramInt, paramString);
    paramString.a(paramBoolean);
    paramString.a("cache_video");
    a(paramString);
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext;
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
      if (localObject2 != null) {
        ((IPlayer)localObject2).a((Context)localObject1, paramString, paramLong, a(paramBoolean));
      }
    }
    this.jdField_f_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_g_of_type_Long = paramLong;
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    b(paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramInt2, true, true, false, null);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean)
  {
    b(paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramInt2, paramBoolean, true, false, null);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    b(paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3, null);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    b(paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3, paramString3);
  }
  
  public void a(Map<String, String> paramMap)
  {
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localIPlayer != null) {
      localIPlayer.a(paramMap);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void a(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramArrayOfString != null)
    {
      int k = 0;
      while (k < paramArrayOfString.length)
      {
        if (k != 0) {
          localStringBuilder.append(" ,");
        }
        localStringBuilder.append(paramArrayOfString[k]);
        k += 1;
      }
    }
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0;
  }
  
  public boolean a(@NotNull IPlayer paramIPlayer, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "VideoPlayerWrapper onError!");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(6);
    paramIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiMediaPlayListener;
    if (paramIPlayer != null) {
      paramIPlayer.a(this, paramInt2, paramInt3, paramInt1, paramString, null);
    }
    return false;
  }
  
  public boolean a(@NotNull IPlayer paramIPlayer, int paramInt, @Nullable Object paramObject)
  {
    StringBuilder localStringBuilder;
    if (paramInt != 112)
    {
      if (paramInt != 113)
      {
        if (paramInt != 124)
        {
          if (paramInt != 205)
          {
            if (paramInt == 208)
            {
              if ((paramObject instanceof TPPlayerMsg.TPMediaCodecInfo))
              {
                paramIPlayer = (TPPlayerMsg.TPMediaCodecInfo)paramObject;
                this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerConfigCodecReuseHelper.a(paramIPlayer);
              }
              com.tencent.qav.thread.ThreadManager.c(new VideoPlayerWrapper.2(this));
            }
          }
          else if ((paramObject instanceof TPPlayerMsg.TPProtocolInfo)) {
            this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerConfigQuicConfigHelper.a((TPPlayerMsg.TPProtocolInfo)paramObject);
          }
        }
        else
        {
          paramIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiMediaPlayListener;
          if (paramIPlayer != null) {
            paramIPlayer.a(this, "");
          }
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramIPlayer = this.jdField_b_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("VideoPlayerWrapper onInfo, end buffering <== isSeeking = ");
          localStringBuilder.append(this.jdField_c_of_type_Boolean);
          QLog.d(paramIPlayer, 2, localStringBuilder.toString());
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 5) {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
        }
        if (!this.jdField_c_of_type_Boolean)
        {
          this.jdField_e_of_type_Int += 1;
          this.jdField_i_of_type_Long += System.currentTimeMillis() - this.jdField_h_of_type_Long;
        }
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramIPlayer = this.jdField_b_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("VideoPlayerWrapper onInfo, start buffering ==> isSeeking = ");
        localStringBuilder.append(this.jdField_c_of_type_Boolean);
        QLog.d(paramIPlayer, 2, localStringBuilder.toString());
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 5) {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(4);
      }
      this.jdField_h_of_type_Long = System.currentTimeMillis();
    }
    paramIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiMediaPlayListener;
    if (paramIPlayer != null) {
      paramIPlayer.a(this, paramInt, paramObject);
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "attachVideoPlayer: ");
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 2, "attachVideoPlayer failed for token is null.");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerFactory.a(paramString);
    paramString = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (paramString != null)
    {
      this.j = false;
      paramString.a(this);
      return r();
    }
    QLog.e(this.jdField_b_of_type_JavaLangString, 2, "AttachVideoPlayer error for can't obtain player by token.");
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public long b()
  {
    long l = this.jdField_d_of_type_Long;
    if (l != 0L) {
      return l;
    }
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localIPlayer != null) {
      return localIPlayer.a();
    }
    return -1L;
  }
  
  public long b(boolean paramBoolean)
  {
    return this.jdField_f_of_type_Long + a(paramBoolean);
  }
  
  public View b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView == null) {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView == null) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView = b();
        }
      }
      finally {}
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView;
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "createVideoView: null");
      }
      return null;
    }
    localObject2 = ((IVideoView)localObject2).a();
    if ((localObject2 != null) && (((View)localObject2).getParent() != null))
    {
      ViewParent localViewParent = ((View)localObject2).getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView((View)localObject2);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "remove scroll view parents!");
      }
    }
    return localObject2;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    IVideoView localIVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView;
    if (localIVideoView != null) {
      localIVideoView.b();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localObject != null) {
      ((IPlayer)localObject).a(paramInt);
    }
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoPlayerWrapper: setXYaxis value:");
      localStringBuilder.append(paramInt);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  public void b(@NotNull IPlayer paramIPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onCompletion: ");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(7);
    paramIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiMediaPlayListener;
    if (paramIPlayer != null) {
      paramIPlayer.a(this);
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 8) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(8);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localObject != null) {
      com.tencent.mobileqq.app.ThreadManager.executeOnSubThread(new VideoPlayerWrapper.3(this, (IPlayer)localObject));
    }
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView;
      if ((localObject != null) && (((IVideoView)localObject).a() != null))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView.a().getParent();
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView.a());
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiMediaPlayListener = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Long = 0L;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoPlayerWrapper: destory removeView=");
      localStringBuilder.append(paramBoolean);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1;
  }
  
  public int c()
  {
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localIPlayer != null) {
      return localIPlayer.a();
    }
    return -1;
  }
  
  public long c()
  {
    return this.jdField_i_of_type_Long;
  }
  
  public long c(boolean paramBoolean)
  {
    if (paramBoolean) {
      return b();
    }
    return a();
  }
  
  public String c()
  {
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localIPlayer != null) {
      return localIPlayer.b();
    }
    return "";
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiMediaPlayListener.b(this);
  }
  
  public void c(@NotNull IPlayer paramIPlayer)
  {
    if (QLog.isColorLevel())
    {
      paramIPlayer = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoPlayerWrapper: onSeekComplete， isPause=");
      localStringBuilder.append(e());
      QLog.d(paramIPlayer, 2, localStringBuilder.toString());
    }
    paramIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiMediaPlayListener;
    if (paramIPlayer != null) {
      paramIPlayer.c(this);
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localIPlayer != null) {
      localIPlayer.a(paramBoolean);
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2;
  }
  
  public int d()
  {
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localIPlayer != null) {
      return localIPlayer.b();
    }
    return -1;
  }
  
  public long d()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer == null) {
      return;
    }
    if (!k())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoPlayerWrapper: start failed, wrong state:");
      localStringBuilder.append(VideoPlayUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
      localStringBuilder.append(", just return;");
      QLog.e(str, 1, localStringBuilder.toString());
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer.a();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "VideoPlayerWrapper: start");
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      com.tencent.mobileqq.app.ThreadManager.excute(new VideoPlayerWrapper.4(this, paramBoolean), 16, null, false);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 6) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 8)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer.b(paramBoolean);
    }
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2;
  }
  
  public int e()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public long e()
  {
    return this.jdField_g_of_type_Long;
  }
  
  public void e()
  {
    d();
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 5;
  }
  
  public int f()
  {
    int k = this.jdField_c_of_type_Int;
    if ((k != 104) && (k != 102)) {
      return 0;
    }
    return 1;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer != null)
    {
      if (!k())
      {
        String str = this.jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("VideoPlayerWrapper: pause failed, wrong state:");
        localStringBuilder.append(VideoPlayUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
        localStringBuilder.append(", just return;");
        QLog.e(str, 1, localStringBuilder.toString());
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer.b();
    }
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4);
  }
  
  public int g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer != null)
    {
      long l = this.jdField_b_of_type_Long;
      if (l != 0L)
      {
        float f1 = (float)this.jdField_c_of_type_Long / (float)l;
        return Math.round((float)b() * f1 / 1000.0F);
      }
    }
    return 0;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 8)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "VideoPlayerWrapper: stop failed, because has destoryed, just return;");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer.c();
    n();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "VideoPlayerWrapper: stop ");
    }
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4;
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 8)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "VideoPlayerWrapper: release failed, because has destoryed, just return;");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(8);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer.d();
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 7;
  }
  
  public void i()
  {
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localIPlayer != null) {
      localIPlayer.g();
    }
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 8;
  }
  
  public void j()
  {
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localIPlayer != null) {
      localIPlayer.e();
    }
  }
  
  public boolean j()
  {
    int k = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    boolean bool3 = PlayerHelper.a.a();
    boolean bool2 = false;
    boolean bool1 = false;
    if (bool3)
    {
      if (k == 0) {
        bool1 = true;
      }
      return bool1;
    }
    if ((k != 7) && (k != 0))
    {
      bool1 = bool2;
      if (k != 6) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public void k()
  {
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localIPlayer != null) {
      localIPlayer.f();
    }
  }
  
  public boolean k()
  {
    return (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 8) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 6) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 7);
  }
  
  public void l()
  {
    b(this.j ^ true);
  }
  
  public boolean l()
  {
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localIPlayer != null) {
      return localIPlayer.a();
    }
    return this.jdField_g_of_type_Boolean;
  }
  
  public void m()
  {
    this.jdField_f_of_type_Long += a(true);
    this.jdField_e_of_type_Long = 0L;
    this.jdField_g_of_type_Long = 0L;
  }
  
  public boolean m()
  {
    return this.jdField_h_of_type_Boolean;
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "resetVariables: ");
    }
    this.jdField_c_of_type_Int = 101;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_i_of_type_Long = 0L;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -1;
    this.jdField_i_of_type_Boolean = false;
    q();
  }
  
  public boolean n()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "detachVideoPlayer: ");
    }
    this.j = true;
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localIPlayer != null) {
      localIPlayer.a(null);
    }
    this.jdField_d_of_type_JavaLangString = c();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer = null;
  }
  
  public boolean o()
  {
    return a(this.jdField_d_of_type_JavaLangString);
  }
  
  public void p()
  {
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localIPlayer != null) {
      localIPlayer.h();
    }
  }
  
  public boolean p()
  {
    return this.jdField_i_of_type_Boolean;
  }
  
  public boolean q()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper
 * JD-Core Version:    0.7.0.1
 */