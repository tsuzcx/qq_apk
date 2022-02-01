package com.tencent.mobileqq.musicgene;

import Override;
import abgu;
import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import awwm;
import awwu;
import awxf;
import axqq;
import axqs;
import axrh;
import axrr;
import axru;
import axrv;
import axrw;
import axrx;
import axry;
import axrz;
import axsa;
import axsb;
import axsc;
import bdll;
import bmud;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.lyric.widget.LyricViewDetail;
import com.tencent.mobileqq.lyric.widget.LyricViewInternal;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class MusicPlayerActivity
  extends BaseActivity
{
  private static final HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static final HashMap<String, String> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private static final HashMap<String, axsb> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  private final ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new axru(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new axrr(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private awwm jdField_a_of_type_Awwm;
  private awxf jdField_a_of_type_Awxf;
  private final axqq jdField_a_of_type_Axqq = new axrv(this);
  private axqs jdField_a_of_type_Axqs;
  private axrh jdField_a_of_type_Axrh = new axrw(this);
  private final axry jdField_a_of_type_Axry = new axry(this);
  private final axrz jdField_a_of_type_Axrz = new axrz(this);
  private axsc jdField_a_of_type_Axsc;
  public LyricViewDetail a;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private awwm jdField_b_of_type_Awwm;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private ImageView d;
  
  private static Point a(Activity paramActivity)
  {
    Point localPoint = new Point();
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
      if (Build.VERSION.SDK_INT >= 13) {
        paramActivity.getSize(localPoint);
      }
    }
    else
    {
      return localPoint;
    }
    localPoint.x = paramActivity.getWidth();
    localPoint.y = paramActivity.getHeight();
    return localPoint;
  }
  
  private String a(axqs paramaxqs, SongInfo paramSongInfo, long paramLong)
  {
    String str2 = "";
    String str1 = str2;
    if (paramSongInfo != null)
    {
      if (paramLong == paramSongInfo.a) {
        paramSongInfo.b = 4;
      }
      str1 = str2;
      switch (paramSongInfo.b)
      {
      default: 
        str1 = str2;
      }
    }
    for (;;)
    {
      paramSongInfo = str1;
      if (TextUtils.isEmpty(str1))
      {
        paramSongInfo = str1;
        if (paramaxqs != null) {
          paramSongInfo = null;
        }
      }
      try
      {
        paramaxqs = paramaxqs.a();
        paramSongInfo = str1;
        if (paramaxqs != null) {
          paramSongInfo = paramaxqs.getString("KEY_SOURCE_NAME");
        }
        return paramSongInfo;
        str1 = getString(2131694092);
        continue;
        str1 = getString(2131693910);
      }
      catch (RemoteException paramaxqs)
      {
        for (;;)
        {
          paramaxqs = paramSongInfo;
        }
      }
    }
  }
  
  private String a(SongInfo paramSongInfo)
  {
    String str = "";
    if (paramSongInfo != null) {
      str = paramSongInfo.c + "_____" + String.valueOf(paramSongInfo.a);
    }
    return str;
  }
  
  private void a()
  {
    axqs localaxqs = this.jdField_a_of_type_Axqs;
    if (localaxqs == null)
    {
      QLog.e("MusicPlayerActivity", 1, new Object[] { "updateLyricPosition() exception", "mService is null!" });
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject1 = localaxqs.a();
        if (localObject1 == null) {
          break label383;
        }
        localObject1 = a((SongInfo)localObject1);
        if (!jdField_a_of_type_JavaUtilHashMap.containsKey(localObject1)) {
          break label383;
        }
        l1 = ((Long)jdField_a_of_type_JavaUtilHashMap.get(localObject1)).longValue();
        if (!jdField_b_of_type_JavaUtilHashMap.containsKey(localObject1)) {
          break label376;
        }
        localObject1 = (String)jdField_b_of_type_JavaUtilHashMap.get(localObject1);
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.getTag();
        if (!(localObject2 instanceof Long)) {
          break label368;
        }
        l2 = ((Long)localObject2).longValue();
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(4);
          this.jdField_a_of_type_Awxf.b();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("MusicPlayerActivity", 1, localException, new Object[0]);
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.a().b() == null) || (l2 != l1))
      {
        a(localException, this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail);
        this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setTag(Long.valueOf(l1));
      }
      int i = localaxqs.a();
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(0);
      long l2 = localaxqs.g();
      long l1 = l2;
      if (l2 < 0L) {
        l1 = 0L;
      }
      int j = (int)l1;
      if (localaxqs.a())
      {
        boolean bool = this.jdField_a_of_type_Awxf.a();
        if (!bool) {
          this.jdField_a_of_type_Awxf.a();
        }
        QLog.i("MusicPlayerActivity", 1, "LyricTest updateLyricPosition() try to seek! playPosition:" + l1 + " seekPosition:" + j + " isPlaying:" + bool);
        this.jdField_a_of_type_Awxf.a(j);
        return;
      }
      if (3 == i)
      {
        this.jdField_a_of_type_Awxf.a(j);
        this.jdField_a_of_type_Awxf.c();
        return;
      }
      this.jdField_a_of_type_Awxf.b();
      return;
      label368:
      l2 = -1L;
      continue;
      label376:
      String str = "";
      continue;
      label383:
      l1 = 0L;
      str = "";
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = getResources().getDrawable(paramInt1);
    if (localDrawable != null) {
      localDrawable.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
    }
  }
  
  private void a(axsb paramaxsb, String paramString)
  {
    axsa localaxsa = new axsa(paramaxsb.jdField_a_of_type_JavaLangString, paramaxsb.b, paramaxsb.e, paramaxsb.d, paramaxsb.c, "https://qzonestyle.gtimg.cn/ac/qzone/applogo/16/308/100497308_16.gif");
    Message localMessage = Message.obtain(this.jdField_a_of_type_Axry, 51);
    localMessage.arg1 = 1;
    localMessage.obj = localaxsa;
    localMessage.sendToTarget();
    Message.obtain(this.jdField_a_of_type_Axry, 53).sendToTarget();
    a(paramaxsb.jdField_a_of_type_JavaLangString, paramaxsb.b, paramaxsb.e, paramString, paramaxsb.jdField_a_of_type_Boolean, true);
  }
  
  private void a(String paramString, LyricViewDetail paramLyricViewDetail)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.jdField_b_of_type_Awwm = awwu.a(paramString, true);
      if (this.jdField_b_of_type_Awwm == null) {
        this.jdField_a_of_type_Awwm = awwu.a(paramString, false);
      }
    } while ((this.jdField_b_of_type_Awwm == null) && (this.jdField_a_of_type_Awwm == null));
    this.jdField_a_of_type_Awxf.b();
    paramLyricViewDetail.a().setHighlightCurrentLine(true);
    paramLyricViewDetail.a().setHighlightLineNumber(2);
    this.jdField_a_of_type_Awxf.a(paramLyricViewDetail);
    this.jdField_a_of_type_Awxf.a(this.jdField_b_of_type_Awwm, this.jdField_a_of_type_Awwm, null);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("title", paramString1);
    localBundle.putString("desc", paramString2);
    localBundle.putString("detail_url", paramString3);
    localBundle.putString("from", "qq");
    localBundle.putString("audio_url", paramString5);
    localBundle.putInt("req_type", 2);
    paramString1 = new ArrayList(1);
    paramString1.add(paramString4);
    localBundle.putStringArrayList("image_url", paramString1);
    localBundle.putLong("req_share_id", 0L);
    localBundle.putString("strurt_msgid", "0");
    localBundle.putString("struct_url", this.app.c());
    localBundle.putBoolean("from_web", true);
    bmud.a(this.app, this, localBundle, null, 0);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Axry, 52);
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_SONG_NAME", paramString1);
    localBundle.putString("KEY_SINGER_NAME", paramString2);
    localBundle.putString("KEY_IMG_URL", paramString3);
    localBundle.putString("KEY_SOURCE_NAME", paramString4);
    localBundle.putBoolean("KEY_IS_FAVOURITE", paramBoolean1);
    localBundle.putBoolean("KEY_MATCH_SONG", paramBoolean2);
    localMessage.setData(localBundle);
    localMessage.sendToTarget();
  }
  
  private void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, ForwardRecentActivity.class);
    localIntent.putExtra("key_flag_from_plugin", true);
    String str = paramString1;
    if (paramString1 != null)
    {
      str = paramString1;
      if (paramString1.length() > 45) {
        str = paramString1.substring(0, 45) + "…";
      }
    }
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (paramString2.length() > 60) {
        paramString1 = paramString2.substring(0, 60) + "…";
      }
    }
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("title", str);
    localIntent.putExtra("desc", paramString1);
    localIntent.putExtra("detail_url", paramString3);
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("req_share_id", 1101244924L);
    localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
    localIntent.putExtra("image_url_remote", paramString4);
    localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131695740, new Object[] { str }));
    localIntent.putExtra("audio_url", paramString5);
    localIntent.putExtra("req_type", 2);
    localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
    if (this.app != null)
    {
      localIntent.putExtra("struct_share_key_source_name", getString(2131690062));
      abgu.a(this.app, this, this.app.getAccount(), 1101244924L, 3000L, new axrx(this, localIntent));
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    boolean bool = super.doOnCreate(paramBundle);
    try
    {
      setContentView(2131559490);
      bindService(new Intent(this, QQPlayerService.class), this.jdField_a_of_type_AndroidContentServiceConnection, 33);
      paramBundle = findViewById(2131371577);
      View localView = findViewById(2131371566);
      int i = a(this).x;
      paramBundle.getLayoutParams().height = i;
      localView.getLayoutParams().height = i;
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371576));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371570));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371572));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371574));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371569));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_Axsc = ((axsc)this.app.a(92));
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail = ((LyricViewDetail)findViewById(2131371573));
      this.jdField_a_of_type_Awxf = new awxf(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail);
      findViewById(2131371567).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.d = ((ImageView)findViewById(2131371575));
      this.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      addObserver(this.jdField_a_of_type_Axrz);
      bdll.b(this.app, "CliOper", "", "", "0X8006826", "0X8006826", 0, 0, "", "", "", "");
      return bool;
    }
    catch (OutOfMemoryError paramBundle)
    {
      finish();
    }
    return false;
  }
  
  public void doOnDestroy()
  {
    axqs localaxqs = this.jdField_a_of_type_Axqs;
    if (localaxqs != null) {}
    try
    {
      localaxqs.b(this.jdField_a_of_type_Axqq);
      label19:
      unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
      removeObserver(this.jdField_a_of_type_Axrz);
      super.doOnDestroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      break label19;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDestroy()
  {
    try
    {
      if (this.jdField_a_of_type_Awxf != null) {
        this.jdField_a_of_type_Awxf.b();
      }
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MusicPlayerActivity", 1, localException, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicPlayerActivity
 * JD-Core Version:    0.7.0.1
 */