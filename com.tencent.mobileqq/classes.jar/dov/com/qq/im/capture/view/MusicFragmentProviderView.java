package dov.com.qq.im.capture.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import azib;
import bdin;
import bdoo;
import bhtd;
import blqr;
import blts;
import bltv;
import blua;
import bmae;
import bmaf;
import bmag;
import bmau;
import bmbo;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.io.File;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppActivity;
import mqq.app.BaseActivity;
import xkk;
import xrg;

public class MusicFragmentProviderView
  extends ProviderView
  implements Handler.Callback, View.OnClickListener, bmbo
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 400L;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public bhtd a;
  private blts jdField_a_of_type_Blts = new bmae(this);
  private bltv jdField_a_of_type_Bltv = new bmaf(this);
  private blua jdField_a_of_type_Blua;
  private MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private MusicFragmentProviderView.MusicPlayTask jdField_a_of_type_DovComQqImCaptureViewMusicFragmentProviderView$MusicPlayTask;
  private QimMusicSeekView jdField_a_of_type_DovComQqImCaptureViewQimMusicSeekView;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int = 10000;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  
  public MusicFragmentProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool = true;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd;
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart = 0;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd = this.jdField_c_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicDuration = ((int)ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath()));
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicDuration < this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicDuration;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_DovComQqImCaptureViewQimMusicSeekView.setDurations((b() + 500) / 1000, (Math.max(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicDuration, this.jdField_c_of_type_Int) + 500) / 1000);
    this.jdField_a_of_type_DovComQqImCaptureViewQimMusicSeekView.a(0);
    b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd);
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.e.setEnabled(true);
    bmau localbmau;
    if ((this.jdField_g_of_type_Int == 0) && (!paramBoolean))
    {
      this.jdField_a_of_type_Blua.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_g_of_type_Int);
      if (this.jdField_a_of_type_Bmau != null)
      {
        localbmau = this.jdField_a_of_type_Bmau;
        if (paramBoolean) {
          break label294;
        }
      }
    }
    label294:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localbmau.c(paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("MusicFragmentProviderView", 2, "prepareStartMusic musicName" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName);
      }
      return;
      this.jdField_a_of_type_Blua.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      break;
    }
  }
  
  private int b()
  {
    if (this.jdField_c_of_type_Int < 5000) {
      return 5000;
    }
    if (this.jdField_c_of_type_Int > azib.jdField_c_of_type_Int) {
      return azib.jdField_c_of_type_Int;
    }
    return this.jdField_c_of_type_Int;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    int j = (paramInt2 - paramInt1) / 1000;
    int i;
    if (j < 0) {
      i = 1;
    }
    for (;;)
    {
      String str1 = xkk.a(paramInt1, false);
      String str2 = xkk.a(i * 1000 + paramInt1, false);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder("start = ").append(paramInt1);
        localStringBuilder.append(", end = ").append(paramInt2);
        localStringBuilder.append(", displayStart = ").append(str1);
        localStringBuilder.append(", displayEnd = ").append(str2);
        QLog.d("MusicFragmentProviderView", 2, localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder(str1);
      localStringBuilder.append("-").append(str2);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
      this.jdField_f_of_type_AndroidWidgetTextView.setText(str1);
      this.jdField_g_of_type_AndroidWidgetTextView.setText(str2);
      return;
      i = j;
      if ((paramInt2 - paramInt1) % 1000 > 500) {
        i = j + 1;
      }
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null)
    {
      QLog.i("MusicFragmentProviderView", 1, "startDownload mCurMusicItemInfo is null");
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mSongMid;
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MusicFragmentProviderView", 2, "songMid not exist");
      }
      b(-115);
      return;
    }
    if (!bdin.d(this.jdField_a_of_type_AndroidContentContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MusicFragmentProviderView", 2, "Net not Support");
      }
      b(-104);
      return;
    }
    if (bdin.b(this.jdField_a_of_type_AndroidContentContext)) {
      c(1);
    }
    ((QIMMusicConfigManager)blqr.a(2)).a(str, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo instanceof VsMusicItemInfo, new bmag(this));
  }
  
  protected int a()
  {
    return 2131560752;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bhtd != null)
    {
      Message localMessage = this.jdField_a_of_type_Bhtd.obtainMessage();
      localMessage.what = 5;
      localMessage.arg1 = paramInt;
      this.jdField_a_of_type_Bhtd.sendMessage(localMessage);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = (int)(this.jdField_f_of_type_AndroidWidgetTextView.getPaint().measureText("00:00") / 2.0F);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_f_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.leftMargin = (paramInt1 - i);
    this.jdField_f_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    localLayoutParams = (LinearLayout.LayoutParams)this.jdField_g_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.leftMargin = (paramInt2 - i * 2);
    this.jdField_g_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Blua != null) {
      this.jdField_a_of_type_Blua.d();
    }
    if (this.jdField_a_of_type_Bmau != null) {
      this.jdField_a_of_type_Bmau.c(false);
    }
    b(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560752, this, false);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_DovComQqImCaptureViewQimMusicSeekView = ((QimMusicSeekView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370872));
    this.jdField_a_of_type_DovComQqImCaptureViewQimMusicSeekView.setOnSeekListener(this);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131369777);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365423));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365446));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131370881));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365437));
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131376367);
    this.h = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376880));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376329));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376328));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370908));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363810));
    this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363820));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath().equals(paramString)) && (this.jdField_a_of_type_Bhtd != null))
    {
      paramString = this.jdField_a_of_type_Bhtd.obtainMessage();
      paramString.what = 1;
      paramString.arg1 = paramInt;
      this.jdField_a_of_type_Bhtd.sendMessage(paramString);
    }
  }
  
  public boolean a()
  {
    g();
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getY();
    float f2 = bdoo.b() - this.jdField_f_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("MusicFragmentProviderView", 2, "checkToInterceptTouchArea, touchY=" + f1 + ", minTouchingY=" + f2);
    }
    return f1 < f2;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bhtd != null)
    {
      Message localMessage = this.jdField_a_of_type_Bhtd.obtainMessage();
      localMessage.what = 8;
      localMessage.arg1 = paramInt;
      this.jdField_a_of_type_Bhtd.sendMessage(localMessage);
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null)
    {
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicDuration;
      paramInt1 = (int)(paramInt2 * (paramInt3 / paramInt1));
      paramInt3 = this.jdField_c_of_type_Int;
      if ((paramInt1 >= paramInt2) || (paramInt3 + paramInt1 <= paramInt2)) {
        break label82;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart = (paramInt2 - this.jdField_c_of_type_Int);
    }
    for (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd = paramInt2;; this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd = (paramInt1 + this.jdField_c_of_type_Int))
    {
      b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd);
      return;
      label82:
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart = paramInt1;
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Bhtd != null)
    {
      Message localMessage = this.jdField_a_of_type_Bhtd.obtainMessage();
      localMessage.what = 4;
      localMessage.arg1 = paramInt;
      this.jdField_a_of_type_Bhtd.sendMessage(localMessage);
    }
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramInt1, paramInt2, paramInt3);
    if (this.jdField_a_of_type_Bmau != null) {
      this.jdField_a_of_type_Bmau.c(true);
    }
    if (this.jdField_a_of_type_Blua != null)
    {
      if (this.jdField_g_of_type_Int == 0) {
        this.jdField_a_of_type_Blua.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, true, this.jdField_g_of_type_Int);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Blua.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))
    {
      this.jdField_a_of_type_Blua.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress = -1;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_Blua.e();
      this.jdField_a_of_type_Blua.a(this.jdField_g_of_type_Int);
      if (((QIMMusicConfigManager)blqr.a(2)).a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mItemId) == null)
      {
        xrg.a(new File(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath()));
        if (QLog.isColorLevel()) {
          QLog.d("MusicFragmentProviderView", 2, "delete file=" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName);
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder("cancel musicStart=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart);
        localStringBuilder.append(" musicEnd=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd);
        localStringBuilder.append(" musicDuration").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicDuration);
        localStringBuilder.append(" premusicStart").append(this.jdField_a_of_type_Int);
        localStringBuilder.append(" premusicEnd").append(this.jdField_b_of_type_Int);
        localStringBuilder.append(" musicName").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName);
        QLog.d("MusicFragmentProviderView", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
      i();
    }
    if (this.jdField_a_of_type_Bmau != null) {
      this.jdField_a_of_type_Bmau.d(2);
    }
    if (this.jdField_a_of_type_Bhtd != null)
    {
      this.jdField_a_of_type_Bhtd.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Bhtd = null;
    }
    this.jdField_a_of_type_Blua.b(this.jdField_a_of_type_Bltv);
    this.jdField_a_of_type_Blua = null;
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) && (this.jdField_a_of_type_Boolean))
    {
      if (this.jdField_g_of_type_Int != 0) {
        break label261;
      }
      this.jdField_a_of_type_Blua.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, true, this.jdField_g_of_type_Int);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bmau != null) {
        this.jdField_a_of_type_Bmau.c(true);
      }
      ((QIMMusicConfigManager)blqr.a(2)).a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, true);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder("complete musicStart=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart);
        localStringBuilder.append(" musicEnd=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd);
        localStringBuilder.append(" musicDuration").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicDuration);
        localStringBuilder.append(" premusicStart").append(this.jdField_a_of_type_Int);
        localStringBuilder.append(" premusicEnd").append(this.jdField_b_of_type_Int);
        localStringBuilder.append(" musicName").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName);
        QLog.d("MusicFragmentProviderView", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
      i();
      if (this.jdField_a_of_type_Bmau != null) {
        this.jdField_a_of_type_Bmau.d(2);
      }
      if (this.jdField_a_of_type_Bhtd != null)
      {
        this.jdField_a_of_type_Bhtd.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_Bhtd = null;
      }
      if (this.jdField_a_of_type_Blua != null)
      {
        this.jdField_a_of_type_Blua.b(this.jdField_a_of_type_Bltv);
        this.jdField_a_of_type_Blua = null;
      }
      return;
      label261:
      this.jdField_a_of_type_Blua.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i;
    boolean bool;
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
    case 4: 
      do
      {
        do
        {
          return false;
          this.jdField_a_of_type_DovComQqImCaptureViewQimMusicSeekView.setPlayedPosition(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
          return false;
          i = paramMessage.arg1;
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
          if (i >= 100)
          {
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
            return false;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        } while (!QLog.isColorLevel());
        QLog.d("MusicFragmentProviderView", 2, "MSG_UPDATE_PROGRESS percent=" + i);
        return false;
        i = paramMessage.arg1;
        if (i == 1) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698634));
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      } while (!QLog.isColorLevel());
      QLog.d("MusicFragmentProviderView", 2, "MSG_UPDATE_NET_CHANGE state=" + i);
      return false;
    case 8: 
      i = paramMessage.arg1;
      if (i == 0) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("MusicFragmentProviderView", 2, "MSG_UPDATE_DOWNLOAD_FINISH_STATE finishState=" + i);
        return false;
        if (i == -104)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698635));
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698630));
        }
      }
    case 2: 
      if (QLog.isColorLevel()) {
        QLog.d("MusicFragmentProviderView", 2, "MSG_UPDATE_REPLAY ");
      }
      if ((getContext() instanceof AppActivity))
      {
        paramMessage = (AppActivity)getContext();
        if (QLog.isColorLevel()) {
          QLog.d("MusicFragmentProviderView", 2, "MSG_UPDATE_REPLAY isResume" + paramMessage.isResume());
        }
        if (paramMessage.isResume()) {
          break label879;
        }
        bool = true;
      }
      break;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath())))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MusicFragmentProviderView", 2, "curretInfo ==null or path not exsist");
        return false;
        if (!(getContext() instanceof BaseActivity)) {
          break label879;
        }
        paramMessage = (BaseActivity)getContext();
        if (QLog.isColorLevel()) {
          QLog.d("MusicFragmentProviderView", 2, "MSG_UPDATE_REPLAY isResume" + paramMessage.isResume());
        }
        if (paramMessage.isResume()) {
          break label879;
        }
        bool = true;
        continue;
      }
      a(bool);
      return false;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698636));
      return false;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null) {
        break;
      }
      i = paramMessage.arg1;
      this.jdField_a_of_type_DovComQqImCaptureViewQimMusicSeekView.a(i);
      b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd);
      return false;
      if (paramMessage.obj == null) {
        break;
      }
      paramMessage = (String)paramMessage.obj;
      this.h.setText(paramMessage);
      this.h.setVisibility(0);
      return false;
      String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698630);
      if (paramMessage.arg1 == 1)
      {
        paramMessage = (FlowMusic)paramMessage.obj;
        if (QLog.isColorLevel()) {
          QLog.d("MusicFragmentProviderView", 2, "onGetSingleMusicInfo flowMusic:" + paramMessage.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mUrl = paramMessage.url;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.fileSize = paramMessage.size;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mAlbumUrl = paramMessage.albumUrl;
        if ((paramMessage.playable == 1) && (!TextUtils.isEmpty(paramMessage.url)))
        {
          this.jdField_a_of_type_Blua.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_a_of_type_Blts);
          return false;
        }
        if (paramMessage.playable == 1) {}
      }
      for (paramMessage = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698631);; paramMessage = str)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessage);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MusicFragmentProviderView", 2, "MSG_GET_SINGLE_MUSIC failed");
        return false;
      }
      label879:
      bool = false;
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_DovComQqImCaptureViewMusicFragmentProviderView$MusicPlayTask != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewMusicFragmentProviderView$MusicPlayTask.cancel();
      this.jdField_a_of_type_DovComQqImCaptureViewMusicFragmentProviderView$MusicPlayTask = null;
    }
  }
  
  public void j()
  {
    i();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_DovComQqImCaptureViewMusicFragmentProviderView$MusicPlayTask = new MusicFragmentProviderView.MusicPlayTask(this);
    this.jdField_a_of_type_Long = 400L;
    if (this.jdField_c_of_type_Int > azib.jdField_c_of_type_Int) {
      this.jdField_a_of_type_Long = ((this.jdField_c_of_type_Int * 400.0F / azib.jdField_c_of_type_Int));
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_DovComQqImCaptureViewMusicFragmentProviderView$MusicPlayTask, 0L, this.jdField_a_of_type_Long);
      return;
      if (this.jdField_c_of_type_Int < 5000) {
        this.jdField_a_of_type_Long = ((this.jdField_c_of_type_Int * 400.0F / 5000));
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      g();
      return;
      h();
      return;
      if (!this.jdField_a_of_type_Blua.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo)) {
        n();
      }
    } while (!QLog.isColorLevel());
    QLog.d("MusicFragmentProviderView", 2, "download_try_again");
  }
  
  public void setMusicProviderView(MusicItemInfo paramMusicItemInfo)
  {
    QIMMusicConfigManager localQIMMusicConfigManager = (QIMMusicConfigManager)blqr.a(2);
    this.jdField_a_of_type_Bhtd = new bhtd(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
    localQIMMusicConfigManager.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_Blua = ((blua)blqr.a().c(8));
    if (this.jdField_a_of_type_Bmau != null)
    {
      this.jdField_c_of_type_Int = this.jdField_a_of_type_Bmau.a();
      if (this.jdField_c_of_type_Int < 1000) {
        this.jdField_c_of_type_Int = 1000;
      }
      if (this.jdField_c_of_type_Int != azib.e) {
        break label249;
      }
      this.jdField_a_of_type_Long = ((int)(1.0F * this.jdField_c_of_type_Int / (b() + 1) * 400.0F));
      this.jdField_a_of_type_Blua.e();
      if (!this.jdField_a_of_type_Blua.b(paramMusicItemInfo)) {
        break label291;
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bhtd.sendEmptyMessage(2);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MusicFragmentProviderView", 2, "setMusicProviderView file not exist fileName=" + paramMusicItemInfo.mMusicName + " mid=" + paramMusicItemInfo.mSongMid);
      }
      this.jdField_a_of_type_Blua.a(this.jdField_a_of_type_Bltv);
      return;
      this.jdField_c_of_type_Int = 10000;
      break;
      label249:
      int i = (int)(this.jdField_c_of_type_Int / 6 * 0.4D);
      if (this.jdField_c_of_type_Int < 5000) {}
      for (long l = i;; l = 400L)
      {
        this.jdField_a_of_type_Long = l;
        break;
      }
      label291:
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(1);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695384));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.e.setEnabled(false);
      n();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.view.MusicFragmentProviderView
 * JD-Core Version:    0.7.0.1
 */