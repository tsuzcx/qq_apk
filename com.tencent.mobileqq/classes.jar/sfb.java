import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.2;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.3;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.4;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.seamless.SPSeamlessHelper;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo;
import com.tencent.tmediacodec.util.LogUtils;
import com.tencent.util.VersionUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class sfb
  implements sio
{
  public int a;
  public long a;
  protected Context a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Object jdField_a_of_type_JavaLangObject;
  public String a;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private rui jdField_a_of_type_Rui = new rui();
  private rum jdField_a_of_type_Rum;
  private sfc jdField_a_of_type_Sfc;
  @Nullable
  private sip jdField_a_of_type_Sip;
  @NotNull
  private sir jdField_a_of_type_Sir;
  @Nullable
  private six jdField_a_of_type_Six;
  public boolean a;
  public int b;
  public long b;
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  private final String jdField_b_of_type_JavaLangString = "Q.readinjoy.video.VideoPlayerWrapper<" + Integer.toHexString(hashCode()) + ">";
  public boolean b;
  private int jdField_c_of_type_Int = 101;
  public long c;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 0;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private long jdField_f_of_type_Long;
  private boolean jdField_f_of_type_Boolean;
  private long jdField_g_of_type_Long;
  private boolean jdField_g_of_type_Boolean;
  private long jdField_h_of_type_Long;
  private boolean jdField_h_of_type_Boolean;
  private boolean i;
  
  public sfb(Context paramContext)
  {
    this(paramContext, "");
  }
  
  public sfb(Context paramContext, String paramString)
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c(paramString);
    this.jdField_c_of_type_JavaLangString = och.b();
  }
  
  private int a(ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Six != null) && ((this.jdField_a_of_type_Six.a() instanceof ISPlayerVideoView)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "seamlessAttachVideoView: ");
      }
      SPSeamlessHelper.get().attachVideoView(paramViewGroup, (ISPlayerVideoView)this.jdField_a_of_type_Six.a(), new ViewGroup.LayoutParams(-1, -1));
      if (!this.jdField_h_of_type_Boolean) {
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
    LogUtils.setLogEnable(QLog.isColorLevel());
    SuperPlayerOption localSuperPlayerOption = SuperPlayerOption.obtain();
    localSuperPlayerOption.isPrePlay = paramBoolean;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(357);
    localSuperPlayerOption.bufferPacketMinTotalDurationMs = localAladdinConfig.getIntegerFromString("bufferPacketMinTotalDurationMs", 0);
    localSuperPlayerOption.preloadPacketDurationMs = localAladdinConfig.getIntegerFromString("preloadPacketDurationMs", 0);
    localSuperPlayerOption.minBufferingPacketDurationMs = localAladdinConfig.getIntegerFromString("minBufferingPacketDurationMs", 0);
    localSuperPlayerOption.enableCodecReuse = rui.a.c();
    localSuperPlayerOption.enableVideoFrameCheck = rui.a.d();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "commonPlayerOption: " + localSuperPlayerOption);
    }
    return localSuperPlayerOption;
  }
  
  private void a(sja paramsja)
  {
    if (paramsja != null)
    {
      paramsja.c(this.jdField_d_of_type_Boolean);
      paramsja.b(this.jdField_e_of_type_Boolean);
      paramsja.a(bmqa.e());
    }
  }
  
  private six b()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "createVideoView_Scroll: error, mContext null");
      return null;
    }
    return this.jdField_a_of_type_Sir.a(this.jdField_a_of_type_AndroidContentContext, VersionUtils.isIceScreamSandwich());
  }
  
  private void b(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playerStartByUrl vid = " + paramString1);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#VideoPlayerWrapper# playerStartByUrl, url:" + paramString2 + ", fileSize:" + paramLong2 + ", videoDuration:" + paramInt2 + "，mState:" + sfa.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    }
    if (!s())
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "not idle or complete state, should't reopen mediaplayer, vid:" + paramString1 + "，mState:" + sfa.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) + " ,mIsSeamlessPlay:" + this.jdField_h_of_type_Boolean);
      return;
    }
    if (paramBoolean2)
    {
      paramString2 = slm.a(paramString2);
      a(paramString2);
    }
    for (;;)
    {
      paramString1 = new sja(paramInt1, paramString1, paramString2);
      paramString1.a(paramBoolean3);
      paramString1.a(paramInt2);
      paramString1.d(paramBoolean1);
      paramString1.b(paramString3);
      a(paramString1);
      if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_Sip != null)) {
        this.jdField_a_of_type_Sip.a(this.jdField_a_of_type_AndroidContentContext, paramString1, paramLong1, a(paramBoolean3));
      }
      this.jdField_e_of_type_Long = 0L;
      this.jdField_d_of_type_Long = 0L;
      this.jdField_f_of_type_Long = paramLong1;
      this.jdField_c_of_type_Int = paramInt1;
      return;
      String[] arrayOfString = new String[1];
      arrayOfString[0] = paramString2;
      a(arrayOfString);
      paramString2 = arrayOfString;
    }
  }
  
  private void c(String paramString)
  {
    this.jdField_a_of_type_Sir = siy.a.a();
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "VideoPlayerWrapper initPlayer success!");
      }
      if (TextUtils.isEmpty(paramString)) {
        break label202;
      }
    }
    label202:
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        this.jdField_h_of_type_Boolean = a(paramString);
        if (!this.jdField_h_of_type_Boolean) {
          QLog.e(this.jdField_b_of_type_JavaLangString, 2, "SeamlessPlay error for that token(" + paramString + ") is not validate.");
        }
      }
      if (!this.jdField_h_of_type_Boolean)
      {
        this.jdField_f_of_type_Boolean = sgc.a().a();
        this.jdField_a_of_type_Sip = this.jdField_a_of_type_Sir.a(null);
      }
      this.jdField_a_of_type_Sip.a(this);
      c(this.jdField_f_of_type_Boolean);
      d(this.jdField_g_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "new VideoPlayerWrapper, needSeamlessPlay:" + bool + " ,mIsSeamlessPlay:" + this.jdField_h_of_type_Boolean);
      }
      return;
    }
  }
  
  private void p()
  {
    this.jdField_f_of_type_Int = 0;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
  }
  
  private boolean r()
  {
    if (this.jdField_a_of_type_Sip == null) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_Sip.d()) {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      }
      for (;;)
      {
        return true;
        if (this.jdField_a_of_type_Sip.e())
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
        }
        else if (this.jdField_a_of_type_Sip.c())
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(4);
        }
        else if (this.jdField_a_of_type_Sip.b())
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
        }
        else
        {
          if (!this.jdField_a_of_type_Sip.f()) {
            break;
          }
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(6);
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "seamlessAttachVideoView: error state");
    return false;
  }
  
  private boolean s()
  {
    if (this.jdField_h_of_type_Boolean) {}
    do
    {
      return false;
      if (siy.a.a()) {
        return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1);
      }
    } while ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1)) && (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(7, 1)) && (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(6, 1)));
    return true;
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (!this.jdField_h_of_type_Boolean))
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 2, "seamlessAttachVideoView failed for parent is null or not seamlessPlay. mIsSeamlessPlay:" + this.jdField_h_of_type_Boolean);
      return 1;
    }
    return a(this.jdField_a_of_type_AndroidViewViewGroup);
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Sip == null) {
      return 0L;
    }
    return this.jdField_a_of_type_Sip.b();
  }
  
  public long a(boolean paramBoolean)
  {
    long l2 = this.jdField_e_of_type_Long;
    if (paramBoolean) {}
    for (long l1 = b(); l1 - this.jdField_f_of_type_Long > 0L; l1 = a()) {
      return l1 - this.jdField_f_of_type_Long + l2;
    }
    return l2;
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_Six != null) {
      return this.jdField_a_of_type_Six.a();
    }
    return null;
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
  
  public six a()
  {
    return this.jdField_a_of_type_Six;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Six != null) {
      this.jdField_a_of_type_Six.a();
    }
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_Sip != null) {
      this.jdField_a_of_type_Sip.a(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    ViolaLogUtils.d(this.jdField_b_of_type_JavaLangString, "test seekTo aaa" + paramInt + ",state:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    if ((this.jdField_a_of_type_Sip != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 1) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 8))
    {
      long l1 = a();
      if (l1 - this.jdField_f_of_type_Long > 0L)
      {
        long l2 = this.jdField_e_of_type_Long;
        this.jdField_e_of_type_Long = (l1 - this.jdField_f_of_type_Long + l2);
      }
      this.jdField_f_of_type_Long = paramInt;
      this.jdField_a_of_type_Sip.a(paramInt, 1);
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Sip != null) && (paramInt1 > 0) && (paramInt2 > 0)) {
      this.jdField_a_of_type_Sip.a(paramInt1, paramInt2, bmqa.e());
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    a(paramViewGroup, false, true);
  }
  
  public void a(ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "initVideoView parent:" + paramViewGroup + " ,reUseVideoView:" + paramBoolean1 + " ,autoAttachVideoView:" + paramBoolean2);
    }
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    if (this.jdField_a_of_type_Sip != null) {}
    for (six localsix = this.jdField_a_of_type_Sip.a();; localsix = null)
    {
      int j;
      if ((paramBoolean1) && (this.jdField_h_of_type_Boolean) && (localsix != null))
      {
        j = 1;
        if (j == 0) {
          break label152;
        }
        this.jdField_a_of_type_Six = localsix;
      }
      for (;;)
      {
        if ((paramViewGroup != null) && (this.jdField_a_of_type_Six != null) && (this.jdField_a_of_type_Six.a() != null))
        {
          if (j != 0)
          {
            if (paramBoolean2) {
              a(paramViewGroup);
            }
            return;
            j = 0;
            break;
            label152:
            b();
            continue;
          }
          paramViewGroup.addView(this.jdField_a_of_type_Six.a(), new ViewGroup.LayoutParams(-1, -1));
        }
      }
      a(this.jdField_a_of_type_Six);
      return;
    }
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(@Nullable String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "[IPlayer] OnDownloadCallback(): s:" + paramString);
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        j = localJSONObject.getInt("playID");
        long l = localJSONObject.getLong("fileSize");
        if (this.jdField_f_of_type_Int != j) {
          p();
        }
        this.jdField_f_of_type_Int = j;
        if (l > 0L) {
          this.jdField_b_of_type_Long = l;
        }
        j = localJSONObject.getInt("callBackType");
        if ((j != 1) || (this.jdField_a_of_type_Sfc == null)) {
          break label175;
        }
        this.jdField_a_of_type_Sfc.a(this, paramString);
      }
      catch (JSONException paramString)
      {
        JSONObject localJSONObject;
        paramString.printStackTrace();
        return;
      }
      if (this.jdField_a_of_type_Sfc != null) {
        this.jdField_a_of_type_Sfc.d(this);
      }
      int j = localJSONObject.getInt("offset");
      if (j > 0) {
        this.jdField_c_of_type_Long = Math.max(this.jdField_c_of_type_Long, j);
      }
      return;
      label175:
      if (j != 7) {
        if (j != 50) {}
      }
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    a(paramString, paramInt, paramLong, false);
  }
  
  public void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playerStart vid = " + paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#VideoPlayerWrapper# playerStart, vid:" + paramString + ", playType:" + paramInt + ", startPosition:" + paramLong + "，mState:" + sfa.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    }
    if (!s())
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "not idle or complete state, should't reopen mediaplayer, vid:" + paramString + "，mState:" + sfa.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) + ", mSeamlessPlay:" + this.jdField_h_of_type_Boolean);
      return;
    }
    paramString = new sja(paramInt, paramString);
    paramString.a(paramBoolean);
    paramString.a("cache_video");
    a(paramString);
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_Sip != null)) {
      this.jdField_a_of_type_Sip.a(this.jdField_a_of_type_AndroidContentContext, paramString, paramLong, a(paramBoolean));
    }
    this.jdField_e_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_f_of_type_Long = paramLong;
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
  
  public void a(sfc paramsfc)
  {
    this.jdField_a_of_type_Sfc = paramsfc;
  }
  
  public void a(@NotNull sip paramsip)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "[IPlayer] onVideoPrepared(): stremDumpInfo=" + paramsip.a());
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    if (this.jdField_a_of_type_Sfc != null) {
      this.jdField_a_of_type_Sfc.a(this, this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_Sip != null) {
      this.jdField_d_of_type_Long = this.jdField_a_of_type_Sip.a();
    }
    if ((this.jdField_b_of_type_Long > 0L) && (this.jdField_d_of_type_Long > 0L)) {
      this.jdField_a_of_type_Int = ((int)(this.jdField_b_of_type_Long / 1024L * 8L / (this.jdField_d_of_type_Long / 1000L)));
    }
    ThreadManager.post(new VideoPlayerWrapper.1(this, paramsip), 5, null, false);
  }
  
  public void a(@NotNull sip paramsip, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Sfc != null) {
      this.jdField_a_of_type_Sfc.a(this, false, paramInt2, paramInt1, null);
    }
  }
  
  public void a(@NotNull sip paramsip, int paramInt1, int paramInt2, int paramInt3, @Nullable Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Sfc != null) {
      this.jdField_a_of_type_Sfc.a(this, true, 0, paramInt1, paramBitmap);
    }
  }
  
  public void a(six paramsix)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "attachVideoView: ");
    }
    if (this.jdField_a_of_type_Sip == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "attachVideoView: videoplayer null");
      }
      return;
    }
    this.jdField_a_of_type_Six = paramsix;
    this.jdField_a_of_type_Sip.a(this.jdField_a_of_type_Six);
    this.jdField_a_of_type_Sip.a(this.jdField_d_of_type_Int);
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
      int j = 0;
      while (j < paramArrayOfString.length)
      {
        if (j != 0) {
          localStringBuilder.append(" ,");
        }
        localStringBuilder.append(paramArrayOfString[j]);
        j += 1;
      }
    }
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0;
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
    this.jdField_a_of_type_Sip = this.jdField_a_of_type_Sir.a(paramString);
    if (this.jdField_a_of_type_Sip != null)
    {
      this.i = false;
      this.jdField_a_of_type_Sip.a(this);
      return r();
    }
    QLog.e(this.jdField_b_of_type_JavaLangString, 2, "AttachVideoPlayer error for can't obtain player by token.");
    return false;
  }
  
  public boolean a(@NotNull sip paramsip, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "VideoPlayerWrapper onError!");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(6);
    if (this.jdField_a_of_type_Sfc != null) {
      this.jdField_a_of_type_Sfc.a(this, paramInt2, paramInt3, paramInt1, paramString, null);
    }
    return false;
  }
  
  public boolean a(@NotNull sip paramsip, int paramInt, @Nullable Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Sfc != null) {
        this.jdField_a_of_type_Sfc.a(this, paramInt, paramObject);
      }
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "VideoPlayerWrapper onInfo, start buffering ==> isSeeking = " + this.jdField_c_of_type_Boolean);
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 5) {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(4);
      }
      this.jdField_g_of_type_Long = System.currentTimeMillis();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "VideoPlayerWrapper onInfo, end buffering <== isSeeking = " + this.jdField_c_of_type_Boolean);
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 5) {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
      }
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_e_of_type_Int += 1;
        this.jdField_h_of_type_Long += System.currentTimeMillis() - this.jdField_g_of_type_Long;
        continue;
        if ((paramObject instanceof TPPlayerMsg.TPMediaCodecInfo))
        {
          paramsip = (TPPlayerMsg.TPMediaCodecInfo)paramObject;
          this.jdField_a_of_type_Rui.a(paramsip);
        }
        bjda.c(new VideoPlayerWrapper.2(this));
        continue;
        if (this.jdField_a_of_type_Sfc != null) {
          this.jdField_a_of_type_Sfc.a(this, "");
        }
      }
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public long b()
  {
    if (this.jdField_d_of_type_Long != 0L) {
      return this.jdField_d_of_type_Long;
    }
    if (this.jdField_a_of_type_Sip != null) {
      return this.jdField_a_of_type_Sip.a();
    }
    return -1L;
  }
  
  public long b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return b();
    }
    return a();
  }
  
  public View b()
  {
    if (this.jdField_a_of_type_Six == null) {}
    try
    {
      if (this.jdField_a_of_type_Six == null) {
        this.jdField_a_of_type_Six = b();
      }
      if (this.jdField_a_of_type_Six == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "createVideoView: null");
        }
        return null;
      }
    }
    finally {}
    View localView = this.jdField_a_of_type_Six.a();
    if ((localView != null) && (localView.getParent() != null))
    {
      ViewParent localViewParent = localView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(localView);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "remove scroll view parents!");
      }
    }
    return localView;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Six != null) {
      this.jdField_a_of_type_Six.b();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Sip != null) {
      this.jdField_a_of_type_Sip.a(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "VideoPlayerWrapper: setXYaxis value:" + paramInt);
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void b(@NotNull sip paramsip)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onCompletion: ");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(7);
    if (this.jdField_a_of_type_Sfc != null) {
      this.jdField_a_of_type_Sfc.a(this);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 8) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(8);
      if (this.jdField_a_of_type_Sip != null) {
        ThreadManager.executeOnSubThread(new VideoPlayerWrapper.3(this, this.jdField_a_of_type_Sip));
      }
      if ((paramBoolean) && (this.jdField_a_of_type_Six != null) && (this.jdField_a_of_type_Six.a() != null))
      {
        ViewParent localViewParent = this.jdField_a_of_type_Six.a().getParent();
        if ((localViewParent instanceof ViewGroup)) {
          ((ViewGroup)localViewParent).removeView(this.jdField_a_of_type_Six.a());
        }
      }
      this.jdField_a_of_type_Sfc = null;
      this.jdField_a_of_type_Six = null;
      this.jdField_a_of_type_AndroidContentContext = null;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_c_of_type_Long = 0L;
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "VideoPlayerWrapper: destory removeView=" + paramBoolean);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Sip != null) {
      return this.jdField_a_of_type_Sip.a();
    }
    return -1;
  }
  
  public long c()
  {
    return this.jdField_h_of_type_Long;
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_Sip != null) {
      return this.jdField_a_of_type_Sip.b();
    }
    return "";
  }
  
  public void c()
  {
    this.jdField_a_of_type_Sfc.b(this);
  }
  
  public void c(@NotNull sip paramsip)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "VideoPlayerWrapper: onSeekComplete， isPause=" + e());
    }
    if (this.jdField_a_of_type_Sfc != null) {
      this.jdField_a_of_type_Sfc.c(this);
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Sip != null) {
      this.jdField_a_of_type_Sip.a(paramBoolean);
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Sip != null) {
      return this.jdField_a_of_type_Sip.b();
    }
    return -1;
  }
  
  public long d()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Sip == null) {}
    do
    {
      return;
      if (!k())
      {
        QLog.e(this.jdField_b_of_type_JavaLangString, 1, "VideoPlayerWrapper: start failed, wrong state:" + sfa.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) + ", just return;");
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
      this.jdField_a_of_type_Sip.a();
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "VideoPlayerWrapper: start");
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      ThreadManager.excute(new VideoPlayerWrapper.4(this, paramBoolean), 16, null, false);
    }
    while ((this.jdField_a_of_type_Sip == null) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 6) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 8)) {
      return;
    }
    this.jdField_a_of_type_Sip.b(paramBoolean);
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
    return this.jdField_f_of_type_Long;
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
    if ((this.jdField_c_of_type_Int == 104) || (this.jdField_c_of_type_Int == 102)) {
      return 1;
    }
    return 0;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Sip != null)
    {
      if (!k()) {
        QLog.e(this.jdField_b_of_type_JavaLangString, 1, "VideoPlayerWrapper: pause failed, wrong state:" + sfa.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) + ", just return;");
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
    this.jdField_a_of_type_Sip.b();
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4);
  }
  
  public int g()
  {
    if ((this.jdField_a_of_type_Sip != null) && (this.jdField_b_of_type_Long != 0L)) {
      return Math.round((float)this.jdField_c_of_type_Long / (float)this.jdField_b_of_type_Long * (float)b() / 1000.0F);
    }
    return 0;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Sip == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 8)
      {
        QLog.e(this.jdField_b_of_type_JavaLangString, 1, "VideoPlayerWrapper: stop failed, because has destoryed, just return;");
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      this.jdField_a_of_type_Sip.c();
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "VideoPlayerWrapper: stop ");
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4;
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Sip == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 8)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "VideoPlayerWrapper: release failed, because has destoryed, just return;");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(8);
    this.jdField_a_of_type_Sip.d();
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 7;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Sip != null) {
      this.jdField_a_of_type_Sip.g();
    }
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 8;
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Sip != null) {
      this.jdField_a_of_type_Sip.e();
    }
  }
  
  public boolean j()
  {
    boolean bool = false;
    int j = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (siy.a.a()) {
      return j == 0;
    }
    if ((j == 7) || (j == 0) || (j == 6)) {
      bool = true;
    }
    return bool;
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Sip != null) {
      this.jdField_a_of_type_Sip.f();
    }
  }
  
  public boolean k()
  {
    return (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 8) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 6) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 7);
  }
  
  public void l()
  {
    if (!this.i) {}
    for (boolean bool = true;; bool = false)
    {
      b(bool);
      return;
    }
  }
  
  public boolean l()
  {
    if (this.jdField_a_of_type_Sip != null) {
      return this.jdField_a_of_type_Sip.a();
    }
    return this.jdField_f_of_type_Boolean;
  }
  
  public void m()
  {
    this.jdField_e_of_type_Long = 0L;
    this.jdField_f_of_type_Long = 0L;
  }
  
  public boolean m()
  {
    return this.jdField_g_of_type_Boolean;
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
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -1;
    this.jdField_h_of_type_Boolean = false;
    p();
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
    this.i = true;
    if (this.jdField_a_of_type_Sip != null) {
      this.jdField_a_of_type_Sip.a(null);
    }
    this.jdField_d_of_type_JavaLangString = c();
    this.jdField_a_of_type_Sip = null;
  }
  
  public boolean o()
  {
    return a(this.jdField_d_of_type_JavaLangString);
  }
  
  public boolean p()
  {
    return this.jdField_h_of_type_Boolean;
  }
  
  public boolean q()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sfb
 * JD-Core Version:    0.7.0.1
 */