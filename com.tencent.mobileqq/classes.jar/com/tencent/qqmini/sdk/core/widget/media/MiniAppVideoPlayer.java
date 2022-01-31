package com.tencent.qqmini.sdk.core.widget.media;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import bdcy;
import bdew;
import bdgx;
import bdhe;
import bdhg;
import bdii;
import bdjo;
import bdjr;
import bdjs;
import bdju;
import bdjv;
import bdjw;
import bdjx;
import bdjy;
import bdjz;
import bdka;
import bdkb;
import bdkc;
import bdki;
import bdnw;
import bdyn;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnCaptureImageListener;
import com.tencent.qqmini.sdk.core.widget.media.danmu.BarrageView;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniAppVideoPlayer
  extends FrameLayout
  implements MediaPlayer.OnPreparedListener, Handler.Callback, View.OnClickListener
{
  private static final String jdField_h_of_type_JavaLangString = bdhg.a("QZoneSetting", "MiniProgramVideoContentType", "application/octet-stream; charset=utf-8");
  public boolean A;
  public boolean B;
  boolean C = false;
  boolean D = false;
  private boolean E;
  private boolean F;
  private boolean G;
  private boolean H;
  private boolean I;
  private boolean J;
  private float jdField_a_of_type_Float = 1.0F;
  public int a;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Window jdField_a_of_type_AndroidViewWindow;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public bdcy a;
  public bdii a;
  public bdkc a;
  private VideoPlayerProxy jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy;
  private VideoGestureLayout jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureLayout;
  private VideoGestureRelativeLayout jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureRelativeLayout;
  private BarrageView jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaDanmuBarrageView;
  public String a;
  public WeakReference<Activity> a;
  public List<bdki> a;
  public boolean a;
  public int b;
  long jdField_b_of_type_Long = -1L;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  public boolean b;
  public int c;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public String c;
  public boolean c;
  public int d;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  public String d;
  public boolean d;
  public int e;
  private View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  public String e;
  public boolean e;
  public int f;
  private View jdField_f_of_type_AndroidViewView;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  public String f;
  public boolean f;
  public int g;
  private ImageView g;
  public String g;
  public boolean g;
  public int h;
  private ImageView jdField_h_of_type_AndroidWidgetImageView;
  public boolean h;
  private int i;
  public boolean i;
  private int j;
  public boolean j;
  private int k;
  public boolean k;
  private int l;
  public boolean l;
  private int m;
  public boolean m;
  private int n;
  public boolean n;
  private int o;
  public boolean o;
  private int p;
  public boolean p;
  private int q;
  public boolean q;
  private int r;
  public boolean r;
  private int s;
  public boolean s;
  public boolean t = true;
  public boolean u = true;
  public boolean v = true;
  public boolean w = true;
  public boolean x;
  public boolean y = true;
  public boolean z = true;
  
  public MiniAppVideoPlayer(Context paramContext)
  {
    this(paramContext, null);
    b(paramContext);
  }
  
  public MiniAppVideoPlayer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_i_of_type_Int = 8;
    this.jdField_j_of_type_Int = 8;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_j_of_type_Boolean = true;
    this.jdField_e_of_type_JavaLangString = "contain";
    this.jdField_q_of_type_Boolean = true;
    this.jdField_d_of_type_Int = -1;
    this.jdField_g_of_type_Int = 300;
    this.jdField_h_of_type_Int = 150;
    b(paramContext);
  }
  
  private int a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localActivity != null) {
        return Settings.System.getInt(localActivity.getContentResolver(), "screen_brightness", 255);
      }
    }
    return 255;
  }
  
  public static int a(MediaExtractor paramMediaExtractor)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        int i1 = 0;
        while (i1 < paramMediaExtractor.getTrackCount())
        {
          bdnw.a("VideoJsPlugin", "format for track " + i1 + " is " + paramMediaExtractor.getTrackFormat(i1).getString("mime"));
          if (paramMediaExtractor.getTrackFormat(i1).getString("mime").startsWith("video/"))
          {
            paramMediaExtractor.selectTrack(i1);
            return i1;
          }
          i1 += 1;
        }
      }
      return -1;
    }
    catch (Exception paramMediaExtractor) {}
  }
  
  private List<bdki> a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return this.jdField_a_of_type_JavaUtilList;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new LinkedList();
    }
    for (;;)
    {
      int i2 = paramJSONArray.length();
      if (i2 > 0)
      {
        int i1 = 0;
        label38:
        if (i1 < i2) {
          try
          {
            this.jdField_a_of_type_JavaUtilList.add(bdki.a(paramJSONArray.getJSONObject(i1)));
            i1 += 1;
            break label38;
            this.jdField_a_of_type_JavaUtilList.clear();
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaDanmuBarrageView != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaDanmuBarrageView.setBarrages(this.jdField_a_of_type_JavaUtilList);
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  private void a(Activity paramActivity)
  {
    int i1 = paramActivity.getWindow().getDecorView().getSystemUiVisibility();
    if (Build.VERSION.SDK_INT >= 21)
    {
      i1 = 5894;
      if (Build.VERSION.SDK_INT < 19) {
        break label64;
      }
      i1 |= 0x800;
    }
    for (;;)
    {
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(i1);
      return;
      if (Build.VERSION.SDK_INT < 16) {
        break;
      }
      i1 = 1798;
      break;
      label64:
      i1 |= 0x1;
    }
  }
  
  public static void a(Context paramContext) {}
  
  private void a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("videoPlayerId", this.jdField_a_of_type_Long);
      localJSONObject.put("state", paramString);
      if ("timeUpdate".equals(paramString))
      {
        localJSONObject.put("position", this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.getCurrentPostion() / 1000.0D);
        localJSONObject.put("duration", this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.getDuration() / 1000.0D);
      }
      this.jdField_a_of_type_Bdcy.a("onVideoStateChange", localJSONObject.toString(), this.jdField_a_of_type_Int);
      return;
    }
    catch (Throwable paramString)
    {
      bdnw.d("MiniAppVideoPlayer", "callbackVideoStateChange error.", paramString);
    }
  }
  
  private static String b(long paramLong)
  {
    long l2 = paramLong / 1000L;
    long l1 = l2;
    if (paramLong % 1000L != 0L) {
      l1 = l2 + 1L;
    }
    int i1 = (int)(l1 % 60L);
    paramLong = l1 / 60L;
    return c(paramLong) + ":" + c(i1);
  }
  
  private void b(long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2002;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void b(Context paramContext)
  {
    if (this.G) {
      return;
    }
    this.G = true;
    setTag("MiniAppVideoPlayer");
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131493736, null);
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureRelativeLayout = ((VideoGestureRelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131303390));
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureRelativeLayout.setContentDescription("video_container");
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131313225));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131313168));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131306059));
    this.jdField_h_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131313220);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131313222));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131313223));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131313215));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131313216));
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131313212);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131313218));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131313211));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131313185);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131313214));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131313221));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131313213));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131313224));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131313217));
    this.jdField_a_of_type_AndroidViewViewGroup = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131313078));
    paramContext = this.jdField_d_of_type_AndroidWidgetImageView;
    if (this.jdField_h_of_type_Boolean) {}
    for (int i1 = 0;; i1 = 4)
    {
      paramContext.setVisibility(i1);
      if (Build.VERSION.SDK_INT > 15) {
        this.jdField_a_of_type_AndroidWidgetSeekBar.getThumb().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_Bdkc = new bdkc(this);
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureLayout = new VideoGestureLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureLayout.setContentDescription("VideoGestureLayout");
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureRelativeLayout.setVideoGestureListener(new bdjv(this));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new bdjw(this));
      addView(this.jdField_a_of_type_AndroidViewView);
      return;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840770);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840770);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840772);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840772);
  }
  
  private static String c(long paramLong)
  {
    if (paramLong == 0L) {
      return "00";
    }
    if (paramLong < 10L) {
      return "0" + paramLong;
    }
    return Long.toString(paramLong);
  }
  
  private void c(Context paramContext)
  {
    i1 = 0;
    if (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy == null)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy = ((VideoPlayerProxy)ProxyManager.get(VideoPlayerProxy.class));
      if (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy != null) {
        break label30;
      }
    }
    label30:
    do
    {
      return;
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.createVideoView(this.jdField_a_of_type_AndroidContentContext);
    } while (this.jdField_e_of_type_AndroidViewView == null);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_f_of_type_AndroidViewView = this.jdField_e_of_type_AndroidViewView;
    this.jdField_f_of_type_AndroidViewView.setLayoutParams(paramContext);
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.setXYaxis(0);
    if (!this.jdField_k_of_type_Boolean)
    {
      if (bdhe.a(this.jdField_b_of_type_JavaLangString)) {
        break label491;
      }
      j();
    }
    for (;;)
    {
      try
      {
        if (this.jdField_i_of_type_Boolean)
        {
          paramContext = new Properties();
          if (this.jdField_g_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaDanmuBarrageView = new BarrageView(this.jdField_a_of_type_AndroidContentContext, null);
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
            addView(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaDanmuBarrageView, localLayoutParams);
            this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaDanmuBarrageView.setBarrages(this.jdField_a_of_type_JavaUtilList);
          }
          if (this.jdField_p_of_type_Boolean) {
            paramContext.put("mHaveCacheDownload", "true");
          }
        }
      }
      catch (Exception paramContext)
      {
        label491:
        paramContext.printStackTrace();
        continue;
        this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
        continue;
        boolean bool = false;
        continue;
        i1 = 1;
        continue;
      }
      this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.setOnControllerClickListener(new bdjy(this));
      this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.setOnVideoPreparedListener(new bdjz(this));
      this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.setOnCompletionListener(new bdka(this));
      this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.setLoopback(this.jdField_n_of_type_Boolean);
      this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.setOnErrorListener(new bdkb(this));
      this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.setOnInfoListener(new bdjr(this));
      this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.setOnSeekCompleteListener(new bdjs(this));
      if (!this.u) {
        continue;
      }
      this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureRelativeLayout.removeAllViews();
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureRelativeLayout.addView(this.jdField_f_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureRelativeLayout.setBackgroundColor(-16777216);
      paramContext = new FrameLayout.LayoutParams(bdyn.a(this.jdField_a_of_type_AndroidContentContext, 100.0F), bdyn.a(this.jdField_a_of_type_AndroidContentContext, 100.0F));
      paramContext.gravity = 17;
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureRelativeLayout.addView(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureLayout, paramContext);
      if ((this.jdField_c_of_type_Long > 0L) && (b()))
      {
        bdnw.a("MiniAppVideoPlayer", "play current pos is: " + this.jdField_c_of_type_Long);
        a(this.jdField_c_of_type_Long);
        if (this.I) {
          continue;
        }
        bool = true;
        b(bool);
        this.H = this.I;
      }
      paramContext = this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy;
      if (!this.jdField_e_of_type_JavaLangString.equals("contain")) {
        continue;
      }
      paramContext.setXYaxis(i1);
      return;
      if (!bdhe.a(this.jdField_d_of_type_JavaLangString)) {
        bdjo.a(this.jdField_d_of_type_JavaLangString, new bdjx(this));
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    MiniAppVideoPlayer.16 local16 = new MiniAppVideoPlayer.16(this);
    if (!paramBoolean) {
      local16.run();
    }
    while ((!this.J) && (this.jdField_s_of_type_Int == 0)) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(local16, 20L);
  }
  
  private void h()
  {
    if (!this.x) {
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    while (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy == null) {
      return;
    }
    ImageView localImageView = this.jdField_f_of_type_AndroidWidgetImageView;
    if (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.getOutputMute()) {}
    for (int i1 = 2130840823;; i1 = 2130840801)
    {
      localImageView.setImageResource(i1);
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
  }
  
  private void i()
  {
    if ((this.jdField_b_of_type_JavaLangString != null) && (!this.jdField_b_of_type_JavaLangString.equals(this.jdField_c_of_type_JavaLangString))) {
      j();
    }
    this.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
  }
  
  private void j()
  {
    Drawable localDrawable = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getDrawable(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_JavaLangString, 0, 0, null);
    if ((localDrawable != null) && (this.jdField_g_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      this.jdField_g_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }
  }
  
  private void k()
  {
    ImageView localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
    if (this.jdField_c_of_type_Boolean) {}
    for (int i1 = 2130840774;; i1 = 2130840775)
    {
      localImageView.setImageResource(i1);
      return;
    }
  }
  
  private void l()
  {
    ImageView localImageView = this.jdField_d_of_type_AndroidWidgetImageView;
    if (this.jdField_d_of_type_Boolean) {}
    for (int i1 = 2130840769;; i1 = 2130840768)
    {
      localImageView.setImageResource(i1);
      return;
    }
  }
  
  private void m()
  {
    n();
    Message localMessage = Message.obtain();
    localMessage.what = 2003;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 5000L);
  }
  
  private void n()
  {
    int i1 = 0;
    if (this.jdField_i_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      View localView = this.jdField_d_of_type_AndroidViewView;
      if (this.jdField_j_of_type_Boolean) {
        localView.setVisibility(i1);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2003);
      return;
      i1 = 8;
      break;
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    }
  }
  
  private void o()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2003;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 500L);
  }
  
  private void p()
  {
    bdnw.a("MiniAppVideoPlayer", "start");
    u();
    if ((this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy != null) && (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.getCurrentPostion() > 0L)) {
      this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.start();
    }
    for (;;)
    {
      this.I = false;
      return;
      e();
    }
  }
  
  private void q()
  {
    bdnw.a("MiniAppVideoPlayer", "pause");
    if (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
    } while (!this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.isPlaying());
    v();
    this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.pause();
    this.I = true;
    if (!this.jdField_a_of_type_Bdcy.getClass().getName().equals("com.tencent.qqmini.sdk.runtime.core.service.AppBrandService"))
    {
      a("pause");
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("videoId", this.jdField_a_of_type_Long);
      localJSONObject.put("data", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Bdcy.a("onVideoPause", localJSONObject.toString(), this.jdField_a_of_type_Int);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(b(this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.getCurrentPostion()));
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy == null) {
      return;
    }
    long l2 = this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.getDuration();
    long l1 = l2;
    if (l2 == 0L) {
      l1 = 1L;
    }
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.getCurrentPostion() * this.jdField_a_of_type_AndroidWidgetSeekBar.getMax() / l1));
  }
  
  private void t()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      getHandler().postDelayed(new MiniAppVideoPlayer.17(this), 1000L);
    }
  }
  
  private void u()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getWindow().addFlags(128);
      ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getWindow().clearFlags(1);
      bdnw.a("MiniAppVideoPlayer", "avoidLockScreen");
    }
  }
  
  private void v()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getWindow().clearFlags(128);
      ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getWindow().addFlags(1);
      bdnw.a("MiniAppVideoPlayer", "cancelAvoidLockScreen");
    }
  }
  
  private void w()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("videoId", this.jdField_a_of_type_Long);
      localJSONObject.put("fullScreen", this.jdField_c_of_type_Boolean);
      this.jdField_a_of_type_Bdcy.a("onVideoFullScreenChange", localJSONObject.toString(), this.jdField_a_of_type_Int);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy == null) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.getCurrentPostion();
  }
  
  public void a()
  {
    bdew.c().post(new MiniAppVideoPlayer.4(this));
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy == null) {}
    do
    {
      return;
      Log.i("MiniAppVideoPlayer", "play: " + paramLong + " /" + this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.getDuration(), new Throwable());
    } while (bdhe.a(this.jdField_d_of_type_JavaLangString));
    this.J = true;
    c(false);
    u();
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.stop();
    if (this.jdField_g_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.startPlayDanmu();
    }
    this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.openMediaPlayerByUrl(getContext(), this.jdField_d_of_type_JavaLangString, paramLong);
    this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
    if (!this.jdField_a_of_type_Bdcy.getClass().getName().equals("com.tencent.qqmini.sdk.runtime.core.service.AppBrandService"))
    {
      a("play");
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Bdcy.a("onVideoPlay", localJSONObject.toString(), this.jdField_a_of_type_Int);
      bdnw.a("MiniAppVideoPlayer", "evaluateSubcribeJS onVideoPlay = " + localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void a(VideoPlayerProxy.OnCaptureImageListener paramOnCaptureImageListener)
  {
    int i1 = 0;
    if (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy == null)
    {
      bdnw.d("MiniAppVideoPlayer", "captureImage video player is null");
      if (paramOnCaptureImageListener != null) {
        paramOnCaptureImageListener.onCaptureImageFailed(null);
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          if (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.isPlaying()) {
            break label128;
          }
          if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
            break label117;
          }
          if (paramOnCaptureImageListener != null)
          {
            paramOnCaptureImageListener.onCaptureImageSucceed(this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy, this.jdField_a_of_type_AndroidGraphicsBitmap);
            return;
          }
        }
        catch (Exception localException1)
        {
          bdnw.d("MiniAppVideoPlayer", "captureImage video player fail!,e" + localException1);
        }
      }
    } while (paramOnCaptureImageListener == null);
    paramOnCaptureImageListener.onCaptureImageFailed(null);
    return;
    label117:
    paramOnCaptureImageListener.onCaptureImageFailed(this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy);
    return;
    label128:
    int i2;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      i2 = this.jdField_a_of_type_AndroidViewView.getWidth();
      i1 = this.jdField_a_of_type_AndroidViewView.getHeight();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.setOnCaptureImageListener(new bdju(this, paramOnCaptureImageListener));
      try
      {
        this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.captureImageInTime(i2, i1);
        return;
      }
      catch (Exception localException2)
      {
        bdnw.d("MiniAppVideoPlayer", "captureImage ", localException2);
        return;
      }
      i2 = 0;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy != null) && (this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaDanmuBarrageView != null)) {
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaDanmuBarrageView.a(new bdki(paramString, paramInt, 0L));
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    int i2 = 0;
    bdnw.b("MiniAppVideoPlayer", "initSetting: " + paramJSONObject.toString());
    this.jdField_e_of_type_Boolean = paramJSONObject.optBoolean("needEvent", this.jdField_e_of_type_Boolean);
    this.jdField_f_of_type_Boolean = paramJSONObject.optBoolean("hide", this.jdField_f_of_type_Boolean);
    this.jdField_g_of_type_Boolean = paramJSONObject.optBoolean("enableDanmu", this.jdField_g_of_type_Boolean);
    if (!this.F)
    {
      this.jdField_h_of_type_Boolean = paramJSONObject.optBoolean("showDanmuBtn", this.jdField_h_of_type_Boolean);
      this.jdField_n_of_type_Boolean = paramJSONObject.optBoolean("loop", this.jdField_n_of_type_Boolean);
      bdnw.b("MiniAppVideoPlayer", "initSetting: set dan mu btn " + this.jdField_g_of_type_Boolean);
      this.F = true;
      this.B = paramJSONObject.optBoolean("enablePlayGesture", this.B);
      this.jdField_d_of_type_Int = paramJSONObject.optInt("direction", this.jdField_d_of_type_Int);
      this.jdField_i_of_type_Boolean = paramJSONObject.optBoolean("showBasicControls", this.jdField_i_of_type_Boolean);
      this.jdField_j_of_type_Boolean = paramJSONObject.optBoolean("controls", this.jdField_j_of_type_Boolean);
      this.jdField_g_of_type_JavaLangString = paramJSONObject.optString("playBtnPosition", this.jdField_g_of_type_JavaLangString);
      this.jdField_q_of_type_Boolean = paramJSONObject.optBoolean("showProgress", this.jdField_q_of_type_Boolean);
      this.x = paramJSONObject.optBoolean("showMuteBtn", this.x);
      this.jdField_f_of_type_JavaLangString = paramJSONObject.optString("title", this.jdField_f_of_type_JavaLangString);
      this.y = paramJSONObject.optBoolean("autoPauseIfNavigate", this.y);
      this.z = paramJSONObject.optBoolean("autoPauseIfOpenNative", this.z);
    }
    if (paramJSONObject.has("muted")) {}
    try
    {
      this.A = paramJSONObject.getBoolean("muted");
      this.u = paramJSONObject.optBoolean("showCenterPlayBtn", this.u);
      Object localObject = paramJSONObject.optString("objectFit", this.jdField_e_of_type_JavaLangString);
      if (!this.jdField_e_of_type_JavaLangString.equals(localObject))
      {
        if ("contain".equals(localObject))
        {
          if (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy != null) {
            this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.setXYaxis(0);
          }
          this.jdField_e_of_type_JavaLangString = ((String)localObject);
        }
      }
      else
      {
        this.jdField_k_of_type_Boolean = paramJSONObject.optBoolean("autoplay", this.jdField_k_of_type_Boolean);
        this.jdField_a_of_type_JavaUtilList = a((JSONArray)paramJSONObject.opt("danmuList"));
        this.jdField_l_of_type_Boolean = paramJSONObject.optBoolean("isLive", this.jdField_l_of_type_Boolean);
        this.jdField_m_of_type_Boolean = paramJSONObject.optBoolean("isMuted", this.jdField_m_of_type_Boolean);
        this.jdField_o_of_type_Boolean = paramJSONObject.optBoolean("pageGesture", this.jdField_o_of_type_Boolean);
        this.jdField_b_of_type_Int = paramJSONObject.optInt("initialTime", this.jdField_b_of_type_Int);
        this.jdField_c_of_type_Int = paramJSONObject.optInt("parentId", this.jdField_c_of_type_Int);
        this.jdField_p_of_type_Boolean = paramJSONObject.optBoolean("customCache", this.jdField_p_of_type_Boolean);
        this.jdField_q_of_type_Boolean = paramJSONObject.optBoolean("showProgress", this.jdField_q_of_type_Boolean);
        this.jdField_r_of_type_Boolean = paramJSONObject.optBoolean("showControlProgress", this.jdField_r_of_type_Boolean);
        this.jdField_s_of_type_Boolean = paramJSONObject.optBoolean("showLiveBtn", this.jdField_s_of_type_Boolean);
        this.t = paramJSONObject.optBoolean("showPlayBtn", this.t);
        this.v = paramJSONObject.optBoolean("showFullScreenBtn", this.v);
        this.w = paramJSONObject.optBoolean("enableProgressGesture", this.w);
        localObject = paramJSONObject.optJSONObject("position");
        if (localObject == null) {
          break label1005;
        }
        this.jdField_e_of_type_Int = ((JSONObject)localObject).optInt("left", this.jdField_e_of_type_Int);
        this.jdField_f_of_type_Int = ((JSONObject)localObject).optInt("top", this.jdField_f_of_type_Int);
        this.jdField_g_of_type_Int = ((JSONObject)localObject).optInt("width", this.jdField_g_of_type_Int);
        this.jdField_h_of_type_Int = ((JSONObject)localObject).optInt("height", this.jdField_h_of_type_Int);
        if (bdhe.a(this.jdField_b_of_type_JavaLangString)) {
          this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("poster", this.jdField_b_of_type_JavaLangString);
        }
        if (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy != null)
        {
          this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.getCurrentPostion();
          if (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.getOutputMute() != this.A)
          {
            Log.i("MiniAppVideoPlayer", "initSetting: set mute " + this.A);
            this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.setOutputMute(this.A);
          }
        }
        if (this.jdField_d_of_type_AndroidWidgetImageView != null)
        {
          paramJSONObject = this.jdField_d_of_type_AndroidWidgetImageView;
          if (!this.jdField_h_of_type_Boolean) {
            break label1068;
          }
          i1 = 0;
          paramJSONObject.setVisibility(i1);
        }
        if (!"center".equals(this.jdField_g_of_type_JavaLangString)) {
          break label1079;
        }
        paramJSONObject = this.jdField_b_of_type_AndroidWidgetImageView;
        if (!this.u) {
          break label1073;
        }
        i1 = i2;
        paramJSONObject.setVisibility(i1);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
          this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
        }
        h();
        if (this.jdField_a_of_type_Bdii != null) {
          break label1099;
        }
        paramJSONObject = new RelativeLayout.LayoutParams(bdyn.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_g_of_type_Int), bdyn.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_h_of_type_Int));
        paramJSONObject.leftMargin = bdyn.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_e_of_type_Int);
        paramJSONObject.topMargin = bdyn.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_f_of_type_Int);
        ((CoverVideoView)getParent()).setLayoutParams(paramJSONObject);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        int i1;
        bdnw.c("MiniAppVideoPlayer", "initSetting: ", localJSONException);
        continue;
        if ("fill".equals(localJSONException))
        {
          if (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy != null) {
            this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.setXYaxis(1);
          }
          this.jdField_e_of_type_JavaLangString = localJSONException;
          continue;
          label1005:
          this.jdField_e_of_type_Int = paramJSONObject.optInt("x", this.jdField_e_of_type_Int);
          this.jdField_f_of_type_Int = paramJSONObject.optInt("y", this.jdField_f_of_type_Int);
          this.jdField_g_of_type_Int = paramJSONObject.optInt("width", this.jdField_g_of_type_Int);
          this.jdField_h_of_type_Int = paramJSONObject.optInt("height", this.jdField_h_of_type_Int);
          continue;
          label1068:
          i1 = 4;
          continue;
          label1073:
          i1 = 8;
          continue;
          label1079:
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      label1099:
      paramJSONObject = new FrameLayout.LayoutParams(bdyn.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_g_of_type_Int), bdyn.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_h_of_type_Int));
      paramJSONObject.leftMargin = bdyn.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_e_of_type_Int);
      paramJSONObject.topMargin = bdyn.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_f_of_type_Int);
      ((CoverVideoView)getParent()).setLayoutParams(paramJSONObject);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_c_of_type_Boolean)) {
      g();
    }
    if (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.stop();
    }
    bdew.c().post(new MiniAppVideoPlayer.12(this));
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy == null) {
      return false;
    }
    if (paramInt < 0)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.seekTo(0);
      return true;
    }
    if (paramInt > this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.getDuration())
    {
      this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.seekTo((int)this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.getDuration());
      return true;
    }
    this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.seekTo(paramInt);
    return true;
  }
  
  public void b()
  {
    bdnw.a("MiniAppVideoPlayer", "operate");
    if (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.isPlaying())
    {
      this.jdField_b_of_type_Boolean = true;
      q();
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    p();
    if (!this.jdField_a_of_type_Bdcy.getClass().getName().equals("com.tencent.qqmini.sdk.runtime.core.service.AppBrandService")) {
      a("play");
    }
    for (;;)
    {
      b(200L);
      return;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("videoId", this.jdField_a_of_type_Long);
        localJSONObject.put("data", this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Bdcy.a("onVideoPlay", localJSONObject.toString(), this.jdField_a_of_type_Int);
        bdnw.a("MiniAppVideoPlayer", "operate start evaluateSubcribeJS onVideoPlay = " + localJSONObject.toString());
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    bdnw.a("MiniAppVideoPlayer", "initLivePlayerSettings isFullScreen: " + this.jdField_c_of_type_Boolean);
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    a(this.jdField_a_of_type_AndroidContentContext);
    a(paramJSONObject);
    c(this.jdField_a_of_type_AndroidContentContext);
    i();
  }
  
  public boolean b()
  {
    return ((ConnectivityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("connectivity")).getNetworkInfo(1).isConnected();
  }
  
  public void c()
  {
    a(true);
  }
  
  public void c(JSONObject paramJSONObject)
  {
    bdnw.a("MiniAppVideoPlayer", "updateLivePlayerSetting isFullScreen: " + this.jdField_c_of_type_Boolean);
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    a(paramJSONObject);
    i();
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy != null) && (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.isPlaying());
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaDanmuBarrageView != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaDanmuBarrageView.a();
    }
    if (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.release();
    }
    bdew.c().post(new MiniAppVideoPlayer.13(this));
    bdgx.a().a();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2002);
  }
  
  public void e()
  {
    a(a());
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new MiniAppVideoPlayer.14(this));
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new MiniAppVideoPlayer.15(this));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
      return bool;
    case 2002: 
      long l1 = System.currentTimeMillis();
      if ((this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy != null) && (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.isPlaying()))
      {
        r();
        if (this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaDanmuBarrageView != null) {
          this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaDanmuBarrageView.a(this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.getCurrentPostion());
        }
        if (!this.E) {
          s();
        }
        if (this.jdField_a_of_type_Bdcy.getClass().getName().equals("com.tencent.qqmini.sdk.runtime.core.service.AppBrandService")) {
          break label137;
        }
        a("timeUpdate");
      }
      while (!this.I)
      {
        b(l1 + 200L - System.currentTimeMillis());
        return true;
        try
        {
          label137:
          paramMessage = new JSONObject();
          paramMessage.put("data", this.jdField_a_of_type_JavaLangString);
          paramMessage.put("position", this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.getCurrentPostion() / 1000.0D);
          paramMessage.put("duration", this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.getDuration() / 1000.0D);
          paramMessage.put("videoId", this.jdField_a_of_type_Long);
          this.jdField_a_of_type_Bdcy.a("onVideoTimeUpdate", paramMessage.toString(), this.jdField_a_of_type_Int);
          bdnw.a("MiniAppVideoPlayer", "evaluateSubcribeJS onVideoTimeUpdate = " + paramMessage.toString());
        }
        catch (JSONException paramMessage)
        {
          paramMessage.printStackTrace();
        }
      }
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    return true;
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy == null) {}
    do
    {
      do
      {
        return;
        if (paramView.getId() != 2131306059) {
          break;
        }
      } while (this.jdField_h_of_type_AndroidWidgetImageView.getVisibility() != 0);
      a(a());
      return;
      if ((paramView.getId() == this.jdField_a_of_type_AndroidWidgetImageView.getId()) || (paramView.getId() == this.jdField_b_of_type_AndroidWidgetImageView.getId()))
      {
        b();
        if (this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.isPlaying()) {
          m();
        }
        for (;;)
        {
          b(this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.isPlaying());
          return;
          n();
        }
      }
      if ((paramView.getId() == this.jdField_c_of_type_AndroidWidgetImageView.getId()) || (paramView.getId() == this.jdField_e_of_type_AndroidWidgetImageView.getId()))
      {
        m();
        if (this.jdField_c_of_type_Boolean) {
          g();
        }
        for (;;)
        {
          k();
          return;
          f();
        }
      }
      if (paramView.getId() == this.jdField_d_of_type_AndroidWidgetImageView.getId())
      {
        m();
        if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaDanmuBarrageView.setVisibility(4);
          this.jdField_d_of_type_Boolean = false;
        }
        for (;;)
        {
          l();
          return;
          if (this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaDanmuBarrageView != null)
          {
            this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaDanmuBarrageView.setVisibility(0);
            this.jdField_d_of_type_Boolean = true;
          }
        }
      }
    } while (paramView.getId() != this.jdField_f_of_type_AndroidWidgetImageView.getId());
    paramView = this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy;
    if (!this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy.getOutputMute()) {}
    for (;;)
    {
      paramView.setOutputMute(bool);
      h();
      return;
      bool = false;
    }
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.start();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_c_of_type_Boolean) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAtyRef(WeakReference<Activity> paramWeakReference)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    if (paramWeakReference != null)
    {
      paramWeakReference = (Activity)paramWeakReference.get();
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)paramWeakReference.getSystemService("audio"));
      if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
        this.jdField_q_of_type_Int = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamMaxVolume(3);
      }
      this.jdField_a_of_type_AndroidViewWindow = paramWeakReference.getWindow();
      if (this.jdField_a_of_type_AndroidViewWindow != null)
      {
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = this.jdField_a_of_type_AndroidViewWindow.getAttributes();
        if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams != null) {
          this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.screenBrightness;
        }
      }
    }
  }
  
  /* Error */
  public void setVideoPath(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc_w 437
    //   6: new 193	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 1345
    //   16: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_1
    //   20: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 1170	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   29: pop
    //   30: aload_0
    //   31: iconst_0
    //   32: invokevirtual 1261	com/tencent/qqmini/sdk/core/widget/media/MiniAppVideoPlayer:a	(Z)V
    //   35: aload_0
    //   36: getfield 127	com/tencent/qqmini/sdk/core/widget/media/MiniAppVideoPlayer:u	Z
    //   39: ifeq +212 -> 251
    //   42: aload_0
    //   43: getfield 522	com/tencent/qqmini/sdk/core/widget/media/MiniAppVideoPlayer:jdField_h_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   46: iconst_0
    //   47: invokevirtual 564	android/widget/ImageView:setVisibility	(I)V
    //   50: aload_0
    //   51: getfield 259	com/tencent/qqmini/sdk/core/widget/media/MiniAppVideoPlayer:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   54: bipush 8
    //   56: invokevirtual 658	android/view/View:setVisibility	(I)V
    //   59: aload_0
    //   60: getfield 109	com/tencent/qqmini/sdk/core/widget/media/MiniAppVideoPlayer:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   63: sipush 2002
    //   66: invokevirtual 858	android/os/Handler:removeMessages	(I)V
    //   69: aload_1
    //   70: ldc_w 1347
    //   73: invokevirtual 235	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   76: ifeq +187 -> 263
    //   79: aload_0
    //   80: invokestatic 1352	bdeu:a	()Lbdeu;
    //   83: aload_1
    //   84: invokevirtual 1354	bdeu:a	(Ljava/lang/String;)Ljava/lang/String;
    //   87: putfield 765	com/tencent/qqmini/sdk/core/widget/media/MiniAppVideoPlayer:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   90: aload_0
    //   91: getfield 143	com/tencent/qqmini/sdk/core/widget/media/MiniAppVideoPlayer:C	Z
    //   94: ifne +10 -> 104
    //   97: aload_0
    //   98: getfield 663	com/tencent/qqmini/sdk/core/widget/media/MiniAppVideoPlayer:jdField_k_of_type_Boolean	Z
    //   101: ifeq +22 -> 123
    //   104: aload_0
    //   105: getfield 109	com/tencent/qqmini/sdk/core/widget/media/MiniAppVideoPlayer:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   108: new 1356	com/tencent/qqmini/sdk/core/widget/media/MiniAppVideoPlayer$1
    //   111: dup
    //   112: aload_0
    //   113: invokespecial 1357	com/tencent/qqmini/sdk/core/widget/media/MiniAppVideoPlayer$1:<init>	(Lcom/tencent/qqmini/sdk/core/widget/media/MiniAppVideoPlayer;)V
    //   116: ldc2_w 1358
    //   119: invokevirtual 792	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   122: pop
    //   123: aload_0
    //   124: iconst_1
    //   125: putfield 143	com/tencent/qqmini/sdk/core/widget/media/MiniAppVideoPlayer:C	Z
    //   128: aload_0
    //   129: iconst_0
    //   130: putfield 810	com/tencent/qqmini/sdk/core/widget/media/MiniAppVideoPlayer:jdField_l_of_type_Int	I
    //   133: getstatic 184	android/os/Build$VERSION:SDK_INT	I
    //   136: bipush 15
    //   138: if_icmple +112 -> 250
    //   141: new 1361	java/io/FileInputStream
    //   144: dup
    //   145: aload_0
    //   146: getfield 765	com/tencent/qqmini/sdk/core/widget/media/MiniAppVideoPlayer:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   149: invokespecial 1363	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   152: astore_3
    //   153: new 186	android/media/MediaExtractor
    //   156: dup
    //   157: invokespecial 1364	android/media/MediaExtractor:<init>	()V
    //   160: astore 5
    //   162: aload 5
    //   164: aload_3
    //   165: invokevirtual 1368	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   168: invokevirtual 1372	android/media/MediaExtractor:setDataSource	(Ljava/io/FileDescriptor;)V
    //   171: aload 5
    //   173: invokestatic 1374	com/tencent/qqmini/sdk/core/widget/media/MiniAppVideoPlayer:a	(Landroid/media/MediaExtractor;)I
    //   176: istore_2
    //   177: iload_2
    //   178: iconst_m1
    //   179: if_icmple +53 -> 232
    //   182: aload 5
    //   184: iload_2
    //   185: invokevirtual 210	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   188: astore_1
    //   189: aload_1
    //   190: ldc_w 1376
    //   193: invokevirtual 1379	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   196: ifeq +14 -> 210
    //   199: aload_0
    //   200: aload_1
    //   201: ldc_w 1376
    //   204: invokevirtual 1383	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   207: putfield 810	com/tencent/qqmini/sdk/core/widget/media/MiniAppVideoPlayer:jdField_l_of_type_Int	I
    //   210: aload_0
    //   211: aload_1
    //   212: ldc_w 1161
    //   215: invokevirtual 1383	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   218: putfield 802	com/tencent/qqmini/sdk/core/widget/media/MiniAppVideoPlayer:jdField_m_of_type_Int	I
    //   221: aload_0
    //   222: aload_1
    //   223: ldc_w 1163
    //   226: invokevirtual 1383	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   229: putfield 806	com/tencent/qqmini/sdk/core/widget/media/MiniAppVideoPlayer:jdField_n_of_type_Int	I
    //   232: aload_3
    //   233: ifnull +7 -> 240
    //   236: aload_3
    //   237: invokevirtual 1386	java/io/FileInputStream:close	()V
    //   240: aload 5
    //   242: ifnull +8 -> 250
    //   245: aload 5
    //   247: invokevirtual 1387	android/media/MediaExtractor:release	()V
    //   250: return
    //   251: aload_0
    //   252: getfield 522	com/tencent/qqmini/sdk/core/widget/media/MiniAppVideoPlayer:jdField_h_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   255: bipush 8
    //   257: invokevirtual 564	android/widget/ImageView:setVisibility	(I)V
    //   260: goto -210 -> 50
    //   263: aload_1
    //   264: ldc_w 1389
    //   267: invokevirtual 235	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   270: ifne +13 -> 283
    //   273: aload_1
    //   274: ldc_w 1391
    //   277: invokevirtual 235	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   280: ifeq -190 -> 90
    //   283: aload_0
    //   284: aload_1
    //   285: putfield 765	com/tencent/qqmini/sdk/core/widget/media/MiniAppVideoPlayer:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   288: goto -198 -> 90
    //   291: astore 4
    //   293: aconst_null
    //   294: astore_3
    //   295: aload 6
    //   297: astore_1
    //   298: ldc_w 437
    //   301: ldc_w 1345
    //   304: aload 4
    //   306: invokestatic 1393	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   309: pop
    //   310: aload_3
    //   311: ifnull +7 -> 318
    //   314: aload_3
    //   315: invokevirtual 1386	java/io/FileInputStream:close	()V
    //   318: aload_1
    //   319: ifnull -69 -> 250
    //   322: aload_1
    //   323: invokevirtual 1387	android/media/MediaExtractor:release	()V
    //   326: return
    //   327: astore_1
    //   328: aconst_null
    //   329: astore 4
    //   331: aconst_null
    //   332: astore_3
    //   333: aload 4
    //   335: ifnull +8 -> 343
    //   338: aload 4
    //   340: invokevirtual 1386	java/io/FileInputStream:close	()V
    //   343: aload_3
    //   344: ifnull +7 -> 351
    //   347: aload_3
    //   348: invokevirtual 1387	android/media/MediaExtractor:release	()V
    //   351: aload_1
    //   352: athrow
    //   353: astore_1
    //   354: goto -114 -> 240
    //   357: astore_3
    //   358: goto -40 -> 318
    //   361: astore 4
    //   363: goto -20 -> 343
    //   366: astore_1
    //   367: aconst_null
    //   368: astore 5
    //   370: aload_3
    //   371: astore 4
    //   373: aload 5
    //   375: astore_3
    //   376: goto -43 -> 333
    //   379: astore_1
    //   380: aload_3
    //   381: astore 4
    //   383: aload 5
    //   385: astore_3
    //   386: goto -53 -> 333
    //   389: astore 4
    //   391: aload_1
    //   392: astore 5
    //   394: aload 4
    //   396: astore_1
    //   397: aload_3
    //   398: astore 4
    //   400: aload 5
    //   402: astore_3
    //   403: goto -70 -> 333
    //   406: astore 4
    //   408: aload 6
    //   410: astore_1
    //   411: goto -113 -> 298
    //   414: astore 4
    //   416: aload 5
    //   418: astore_1
    //   419: goto -121 -> 298
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	this	MiniAppVideoPlayer
    //   0	422	1	paramString	String
    //   176	9	2	i1	int
    //   152	196	3	localFileInputStream	java.io.FileInputStream
    //   357	14	3	localIOException1	java.io.IOException
    //   375	28	3	localObject1	Object
    //   291	14	4	localThrowable1	Throwable
    //   329	10	4	localObject2	Object
    //   361	1	4	localIOException2	java.io.IOException
    //   371	11	4	localObject3	Object
    //   389	6	4	localObject4	Object
    //   398	1	4	localObject5	Object
    //   406	1	4	localThrowable2	Throwable
    //   414	1	4	localThrowable3	Throwable
    //   160	257	5	localObject6	Object
    //   1	408	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   141	153	291	java/lang/Throwable
    //   141	153	327	finally
    //   236	240	353	java/io/IOException
    //   314	318	357	java/io/IOException
    //   338	343	361	java/io/IOException
    //   153	162	366	finally
    //   162	177	379	finally
    //   182	210	379	finally
    //   210	232	379	finally
    //   298	310	389	finally
    //   153	162	406	java/lang/Throwable
    //   162	177	414	java/lang/Throwable
    //   182	210	414	java/lang/Throwable
    //   210	232	414	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer
 * JD-Core Version:    0.7.0.1
 */