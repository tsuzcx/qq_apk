package com.tencent.mobileqq.splashad;

import android.content.Context;
import android.graphics.BitmapFactory.Options;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anzj;
import bany;
import bdhj;
import bdhk;
import bdhl;
import bdhm;
import bhgm;
import com.tencent.common.app.BaseApplicationImpl;
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
  public ImageView a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public bany a;
  private bdhm jdField_a_of_type_Bdhm;
  public TVK_IMediaPlayer a;
  public boolean a;
  View b;
  public boolean b;
  View c;
  public boolean c;
  
  public SplashADView(bany parambany, Context paramContext)
  {
    this(parambany, paramContext, null);
  }
  
  public SplashADView(bany parambany, Context paramContext, AttributeSet paramAttributeSet)
  {
    this(parambany, paramContext, paramAttributeSet, 0);
  }
  
  public SplashADView(bany parambany, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Bany = parambany;
    this.jdField_a_of_type_Boolean = a(paramContext);
    this.jdField_b_of_type_Boolean = true;
    QLog.i("QSplash@QbossSplashUtil", 1, "@SplashADView start");
  }
  
  public static SplashADView a(bany parambany, Context paramContext)
  {
    try
    {
      if ((jdField_a_of_type_ComTencentMobileqqSplashadSplashADView == null) && (parambany != null) && (paramContext != null)) {
        jdField_a_of_type_ComTencentMobileqqSplashadSplashADView = new SplashADView(parambany, paramContext);
      }
      parambany = jdField_a_of_type_ComTencentMobileqqSplashadSplashADView;
      return parambany;
    }
    finally {}
  }
  
  private boolean a(Context paramContext)
  {
    QLog.i("QSplash@QbossSplashUtil", 1, "madentry =" + this.jdField_a_of_type_Bany.toString());
    LayoutInflater.from(paramContext).inflate(2131562930, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369481));
    if ((this.jdField_a_of_type_Bany.jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_Bany.jdField_b_of_type_Int == 0)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131713119));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371593));
    if ((this.jdField_a_of_type_Bany.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Bany.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidViewView = findViewById(2131381382);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131377916));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131365174);
    switch (this.jdField_a_of_type_Bany.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      return false;
      paramContext = new ImageView(paramContext);
      paramContext.setTag("image");
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = 1;
      localOptions.inMutable = true;
      try
      {
        QLog.i("QSplash@QbossSplashUtil", 1, "respath =" + this.jdField_a_of_type_Bany.jdField_a_of_type_JavaLangString);
        paramContext.setImageBitmap(bhgm.a(this.jdField_a_of_type_Bany.jdField_a_of_type_JavaLangString, localOptions));
        paramContext.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramContext, new RelativeLayout.LayoutParams(-1, -1));
        return true;
      }
      catch (OutOfMemoryError paramContext)
      {
        QLog.e("SplashAD", 1, paramContext.toString());
        return false;
      }
      bdhj.b(paramContext);
      if (TVK_SDKMgr.isInstalled(paramContext)) {
        return a(paramContext, this.jdField_a_of_type_Bany);
      }
      QLog.i("SplashAD", 1, "TVK_SDK not Installed");
    }
  }
  
  private boolean a(Context paramContext, bany parambany)
  {
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (localTVK_IProxyFactory != null) {
      try
      {
        this.jdField_c_of_type_AndroidViewView = ((View)localTVK_IProxyFactory.createVideoView_Scroll(BaseApplicationImpl.getContext()));
        if (this.jdField_c_of_type_AndroidViewView != null)
        {
          this.jdField_c_of_type_AndroidViewView.setBackgroundColor(-1);
          paramContext = new RelativeLayout.LayoutParams(-1, -1);
          paramContext.addRule(13, -1);
          this.jdField_c_of_type_AndroidViewView.setLayoutParams(paramContext);
          this.jdField_c_of_type_AndroidViewView.setTag("video");
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = localTVK_IProxyFactory.createMediaPlayer(BaseApplicationImpl.getContext(), (IVideoViewBase)this.jdField_c_of_type_AndroidViewView);
          if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
            return false;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("QSplash@QbossSplashUtil", 1, " mVideoView init erro", localThrowable);
          this.jdField_c_of_type_AndroidViewView = ((View)localTVK_IProxyFactory.createVideoView_Scroll(paramContext));
        }
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new bdhk(this));
        QLog.i("QSplash@QbossSplashUtil", 1, "initVideo addView");
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidViewView);
        if (parambany.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bdhl(this));
        }
        return true;
      }
    }
    return false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      QLog.i("QSplash@QbossSplashUtil", 1, "startVideo");
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      this.jdField_a_of_type_Int = 2;
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(false);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(2);
      String str = this.jdField_a_of_type_Bany.jdField_c_of_type_JavaLangString;
      QLog.i("QSplash@QbossSplashUtil", 1, "videopath =" + this.jdField_a_of_type_Bany.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_Int = 1;
      TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
      HashMap localHashMap = new HashMap();
      localHashMap.put("shouq_bus_type", "bus_type_spashad");
      localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
      QLog.i("QSplash@QbossSplashUtil", 1, "openMediaPlayerByUrl ");
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(getContext(), str, 0L, 0L, localTVK_PlayerVideoInfo);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(true);
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_Int == 2)) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
  }
  
  public void e()
  {
    try
    {
      boolean bool = this.jdField_c_of_type_Boolean;
      if (bool) {}
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("SplashAD", 2, "release splash res");
        }
        this.jdField_c_of_type_Boolean = true;
        jdField_a_of_type_ComTencentMobileqqSplashadSplashADView = null;
        this.jdField_a_of_type_Int = 0;
        switch (this.jdField_a_of_type_Bany.jdField_a_of_type_Int)
        {
        case 0: 
        case 2: 
          if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
          {
            this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
            this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
            this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
            if (QLog.isColorLevel()) {
              QLog.i("SplashAD", 2, "release splash resvideo");
            }
          }
          break;
        }
      }
    }
    finally {}
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnCompletionListener(TVK_IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(paramOnCompletionListener);
    }
  }
  
  public void setOnErrorListener(TVK_IMediaPlayer.OnErrorListener paramOnErrorListener)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(paramOnErrorListener);
    }
  }
  
  public void setPresenter(bdhm parambdhm)
  {
    this.jdField_a_of_type_Bdhm = parambdhm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.splashad.SplashADView
 * JD-Core Version:    0.7.0.1
 */