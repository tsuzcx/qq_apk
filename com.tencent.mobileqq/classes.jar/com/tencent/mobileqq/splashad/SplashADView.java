package com.tencent.mobileqq.splashad;

import android.content.Context;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vassplash.model.SplashUIdata;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.util.HashMap;
import java.util.Map;

public class SplashADView
  extends RelativeLayout
{
  private static SplashADView jdField_a_of_type_ComTencentMobileqqSplashadSplashADView;
  private int jdField_a_of_type_Int = 0;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private SplashADView.SplashADViewPresenter jdField_a_of_type_ComTencentMobileqqSplashadSplashADView$SplashADViewPresenter;
  public SplashUIdata a;
  public TVK_IMediaPlayer a;
  public boolean a;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  View c;
  public boolean c;
  
  public SplashADView(SplashUIdata paramSplashUIdata, Context paramContext)
  {
    this(paramSplashUIdata, paramContext, null);
  }
  
  public SplashADView(SplashUIdata paramSplashUIdata, Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramSplashUIdata, paramContext, paramAttributeSet, 0);
  }
  
  public SplashADView(SplashUIdata paramSplashUIdata, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashUIdata = paramSplashUIdata;
    this.jdField_a_of_type_Boolean = a(paramContext);
    this.jdField_b_of_type_Boolean = true;
    QLog.i("QSplash@VasSplashUtil", 1, "@SplashADView start");
  }
  
  private int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -16777216;
    }
    Object localObject = paramString;
    if (!paramString.startsWith("#"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    try
    {
      int i = Color.parseColor((String)localObject);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("  getValidTextColor error color = ");
      localStringBuilder.append((String)localObject);
      QLog.e("QSplash@VasSplashUtil", 1, localStringBuilder.toString(), paramString);
    }
    return -16777216;
  }
  
  private Drawable a(String paramString)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    GradientDrawable localGradientDrawable = a(paramString);
    localStateListDrawable.addState(new int[] { -16842919 }, localGradientDrawable);
    paramString = b(paramString);
    localStateListDrawable.addState(new int[] { 16842919 }, paramString);
    return localStateListDrawable;
  }
  
  private GradientDrawable a()
  {
    return b("#26000000");
  }
  
  private GradientDrawable a(String paramString)
  {
    return b(paramString);
  }
  
  public static SplashADView a(SplashUIdata paramSplashUIdata, Context paramContext)
  {
    try
    {
      if ((jdField_a_of_type_ComTencentMobileqqSplashadSplashADView == null) && (paramSplashUIdata != null) && (paramContext != null)) {
        jdField_a_of_type_ComTencentMobileqqSplashadSplashADView = new SplashADView(paramSplashUIdata, paramContext);
      }
      paramSplashUIdata = jdField_a_of_type_ComTencentMobileqqSplashadSplashADView;
      return paramSplashUIdata;
    }
    finally {}
  }
  
  private boolean a(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mAdEntry =");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashUIdata.toString());
    QLog.i("QSplash@VasSplashUtil", 1, ((StringBuilder)localObject).toString());
    LayoutInflater.from(paramContext).inflate(2131562849, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369593));
    f();
    if ((this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashUIdata.jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashUIdata.jdField_b_of_type_Int == 0)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714123));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371659));
    if ((this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashUIdata.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashUIdata.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidViewView = findViewById(2131381123);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131377789));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131365297);
    int i = this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashUIdata.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 2) {
        return false;
      }
      SplashADUtil.b(paramContext);
      if (TVK_SDKMgr.isInstalled(paramContext)) {
        return a(paramContext, this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashUIdata);
      }
      QLog.i("SplashAD", 1, "TVK_SDK not Installed");
      return false;
    }
    paramContext = new ImageView(paramContext);
    paramContext.setTag("image");
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inSampleSize = 1;
    ((BitmapFactory.Options)localObject).inMutable = true;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("respath =");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashUIdata.jdField_a_of_type_JavaLangString);
      QLog.i("QSplash@VasSplashUtil", 1, localStringBuilder.toString());
      paramContext.setImageBitmap(BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashUIdata.jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject));
      paramContext.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramContext, new RelativeLayout.LayoutParams(-1, -1));
      return true;
    }
    catch (OutOfMemoryError paramContext)
    {
      QLog.e("SplashAD", 1, paramContext.toString());
    }
    return false;
  }
  
  private boolean a(Context paramContext, SplashUIdata paramSplashUIdata)
  {
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (localTVK_IProxyFactory != null)
    {
      try
      {
        this.jdField_c_of_type_AndroidViewView = ((View)localTVK_IProxyFactory.createVideoView_Scroll(BaseApplicationImpl.getContext()));
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QSplash@VasSplashUtil", 1, " mVideoView init error", localThrowable);
        this.jdField_c_of_type_AndroidViewView = ((View)localTVK_IProxyFactory.createVideoView_Scroll(paramContext));
      }
      paramContext = this.jdField_c_of_type_AndroidViewView;
      if (paramContext != null)
      {
        paramContext.setBackgroundColor(-1);
        paramContext = new RelativeLayout.LayoutParams(-1, -1);
        paramContext.addRule(13, -1);
        this.jdField_c_of_type_AndroidViewView.setLayoutParams(paramContext);
        this.jdField_c_of_type_AndroidViewView.setTag("video");
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = localTVK_IProxyFactory.createMediaPlayer(BaseApplicationImpl.getContext(), (IVideoViewBase)this.jdField_c_of_type_AndroidViewView);
        paramContext = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
        if (paramContext == null) {
          return false;
        }
        paramContext.setOnVideoPreparedListener(new SplashADView.1(this));
        QLog.i("QSplash@VasSplashUtil", 1, "initVideo addView");
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidViewView);
        if (paramSplashUIdata.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new SplashADView.2(this));
        }
        return true;
      }
    }
    return false;
  }
  
  private Drawable b(String paramString)
  {
    return new LayerDrawable(new Drawable[] { a(paramString), a() });
  }
  
  private GradientDrawable b(String paramString)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(ViewUtils.b(6.0F));
    localGradientDrawable.setColor(a(paramString));
    return localGradientDrawable;
  }
  
  private void f()
  {
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377787));
    SplashUIdata localSplashUIdata = this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashUIdata;
    if ((localSplashUIdata != null) && (!TextUtils.isEmpty(localSplashUIdata.e)))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashUIdata.e);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a(this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashUIdata.f));
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(a(this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashUIdata.g));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      QLog.i("QSplash@VasSplashUtil", 1, "startVideo");
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      this.jdField_a_of_type_Int = 2;
    }
  }
  
  public void b()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if ((localObject1 != null) && (!((TVK_IMediaPlayer)localObject1).isPlaying()))
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(false);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(2);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashUIdata.jdField_c_of_type_JavaLangString;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("videopath =");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashUIdata.jdField_c_of_type_JavaLangString);
      QLog.i("QSplash@VasSplashUtil", 1, ((StringBuilder)localObject2).toString());
      this.jdField_a_of_type_Int = 1;
      localObject2 = new TVK_PlayerVideoInfo();
      if (Build.VERSION.SDK_INT >= 21) {
        ((TVK_PlayerVideoInfo)localObject2).setConfigMap("keep_last_frame", "true");
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("shouq_bus_type", "bus_type_spashad");
      ((TVK_PlayerVideoInfo)localObject2).setReportInfoMap(localHashMap);
      QLog.i("QSplash@VasSplashUtil", 1, "openMediaPlayerByUrl ");
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(getContext(), (String)localObject1, 0L, 0L, (TVK_PlayerVideoInfo)localObject2);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(true);
    }
  }
  
  public void c()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if ((localTVK_IMediaPlayer != null) && (this.jdField_a_of_type_Int == 2)) {
      localTVK_IMediaPlayer.start();
    }
  }
  
  public void d()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.pause();
    }
  }
  
  public void e()
  {
    try
    {
      boolean bool = this.jdField_c_of_type_Boolean;
      if (bool) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("SplashAD", 2, "release splash res");
      }
      this.jdField_c_of_type_Boolean = true;
      jdField_a_of_type_ComTencentMobileqqSplashadSplashADView = null;
      this.jdField_a_of_type_Int = 0;
      int i = this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashUIdata.jdField_a_of_type_Int;
      if ((i != 0) && (i == 2) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null))
      {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        if (QLog.isColorLevel()) {
          QLog.i("SplashAD", 2, "release splash resvideo");
        }
      }
      return;
    }
    finally {}
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnCompletionListener(TVK_IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.setOnCompletionListener(paramOnCompletionListener);
    }
  }
  
  public void setOnErrorListener(TVK_IMediaPlayer.OnErrorListener paramOnErrorListener)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.setOnErrorListener(paramOnErrorListener);
    }
  }
  
  public void setPresenter(SplashADView.SplashADViewPresenter paramSplashADViewPresenter)
  {
    this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView$SplashADViewPresenter = paramSplashADViewPresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.splashad.SplashADView
 * JD-Core Version:    0.7.0.1
 */