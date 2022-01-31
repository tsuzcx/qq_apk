package com.tencent.mobileqq.musicgene;

import aeko;
import aekt;
import aeku;
import aekv;
import aekw;
import aeky;
import aekz;
import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.util.LyricParseHelper;
import com.tencent.mobileqq.lyric.widget.LyricViewController;
import com.tencent.mobileqq.lyric.widget.LyricViewDetail;
import com.tencent.mobileqq.lyric.widget.LyricViewInternal;
import com.tencent.mobileqq.music.IQQPlayerCallback.Stub;
import com.tencent.mobileqq.music.IQQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class MusicPlayerActivity
  extends BaseActivity
{
  private static final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static final HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private static final HashMap jdField_c_of_type_JavaUtilHashMap = new HashMap();
  private static final HashMap jdField_d_of_type_JavaUtilHashMap = new HashMap();
  private final aekw jdField_a_of_type_Aekw = new aekw(this);
  private final ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new aekt(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aeko(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Lyric jdField_a_of_type_ComTencentMobileqqLyricDataLyric;
  private LyricViewController jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController;
  public LyricViewDetail a;
  private final IQQPlayerCallback.Stub jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerCallback$Stub = new aeku(this);
  private IQQPlayerService jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
  private final MusicPlayerActivity.MusicPlayerObserver jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$MusicPlayerObserver = new MusicPlayerActivity.MusicPlayerObserver(this);
  private MusicPlayerHandler jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerHandler;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Lyric jdField_b_of_type_ComTencentMobileqqLyricDataLyric;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  
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
  
  private String a(IQQPlayerService paramIQQPlayerService, SongInfo paramSongInfo, long paramLong)
  {
    String str2 = "";
    String str1 = str2;
    if (paramSongInfo != null)
    {
      if (paramLong == paramSongInfo.jdField_a_of_type_Long) {
        paramSongInfo.jdField_a_of_type_Int = 4;
      }
      str1 = str2;
      switch (paramSongInfo.jdField_a_of_type_Int)
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
        if (paramIQQPlayerService != null) {
          paramSongInfo = null;
        }
      }
      try
      {
        paramIQQPlayerService = paramIQQPlayerService.a();
        paramSongInfo = str1;
        if (paramIQQPlayerService != null) {
          paramSongInfo = paramIQQPlayerService.getString("KEY_SOURCE_NAME");
        }
        return paramSongInfo;
        str1 = getString(2131435107);
        continue;
        str1 = getString(2131438483);
      }
      catch (RemoteException paramIQQPlayerService)
      {
        for (;;)
        {
          paramIQQPlayerService = paramSongInfo;
        }
      }
    }
  }
  
  private String a(SongInfo paramSongInfo)
  {
    String str = "";
    if (paramSongInfo != null) {
      str = paramSongInfo.b + "_____" + String.valueOf(paramSongInfo.jdField_a_of_type_Long);
    }
    return str;
  }
  
  private void a()
  {
    IQQPlayerService localIQQPlayerService = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
    if (localIQQPlayerService == null)
    {
      QLog.e("MusicPlayerActivity", 1, new Object[] { "updateLyricPosition() exception", "mService is null!" });
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject1 = localIQQPlayerService.a();
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
          this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.b();
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
      int i = localIQQPlayerService.a();
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(0);
      long l2 = localIQQPlayerService.g();
      long l1 = l2;
      if (l2 < 0L) {
        l1 = 0L;
      }
      int j = (int)l1;
      if (localIQQPlayerService.a())
      {
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.a();
        if (!bool) {
          this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.a();
        }
        QLog.i("MusicPlayerActivity", 1, "LyricTest updateLyricPosition() try to seek! playPosition:" + l1 + " seekPosition:" + j + " isPlaying:" + bool);
        this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.a(j);
        return;
      }
      if (3 == i)
      {
        this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.a(j);
        this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.c();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.b();
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
  
  private void a(aekz paramaekz, String paramString)
  {
    aeky localaeky = new aeky(paramaekz.jdField_a_of_type_JavaLangString, paramaekz.b, paramaekz.e, paramaekz.d, paramaekz.c, "http://qzonestyle.gtimg.cn/ac/qzone/applogo/16/308/100497308_16.gif");
    Message localMessage = Message.obtain(this.jdField_a_of_type_Aekw, 51);
    localMessage.arg1 = 1;
    localMessage.obj = localaeky;
    localMessage.sendToTarget();
    Message.obtain(this.jdField_a_of_type_Aekw, 53).sendToTarget();
    a(paramaekz.jdField_a_of_type_JavaLangString, paramaekz.b, paramaekz.e, paramString, paramaekz.jdField_a_of_type_Boolean, true);
  }
  
  private void a(String paramString, LyricViewDetail paramLyricViewDetail)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric = LyricParseHelper.a(paramString, true);
      if (this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric == null) {
        this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric = LyricParseHelper.a(paramString, false);
      }
    } while ((this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric == null) && (this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric == null));
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.b();
    paramLyricViewDetail.a().setHighlightCurrentLine(true);
    paramLyricViewDetail.a().setHighlightLineNumber(2);
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.a(paramLyricViewDetail);
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.a(this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric, this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric, null);
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
    QZoneShareManager.a(this.app, this, localBundle, null, 0);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Aekw, 52);
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
    localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131430117, new Object[] { str }));
    localIntent.putExtra("audio_url", paramString5);
    localIntent.putExtra("req_type", 2);
    localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getProcessName());
    if (this.app != null)
    {
      localIntent.putExtra("struct_share_key_source_name", getString(2131433004));
      Share.a(this.app, this, this.app.getAccount(), 1101244924L, 3000L, new aekv(this, localIntent));
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    boolean bool = super.doOnCreate(paramBundle);
    try
    {
      setContentView(2130969107);
      bindService(new Intent(this, QQPlayerService.class), this.jdField_a_of_type_AndroidContentServiceConnection, 33);
      paramBundle = findViewById(2131365184);
      View localView = findViewById(2131365183);
      int i = a(this).x;
      paramBundle.getLayoutParams().height = i;
      localView.getLayoutParams().height = i;
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365189));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365194));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365192));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365191));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365193));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerHandler = ((MusicPlayerHandler)this.app.a(92));
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail = ((LyricViewDetail)findViewById(2131365190));
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController = new LyricViewController(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail);
      findViewById(2131365186).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365187));
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$MusicPlayerObserver);
      ReportController.b(this.app, "CliOper", "", "", "0X8006826", "0X8006826", 0, 0, "", "", "", "");
      return bool;
    }
    catch (OutOfMemoryError paramBundle)
    {
      finish();
    }
    return false;
  }
  
  protected void doOnDestroy()
  {
    IQQPlayerService localIQQPlayerService = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
    if (localIQQPlayerService != null) {}
    try
    {
      localIQQPlayerService.b(this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerCallback$Stub);
      label19:
      unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$MusicPlayerObserver);
      super.doOnDestroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      break label19;
    }
  }
  
  protected void onDestroy()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicPlayerActivity
 * JD-Core Version:    0.7.0.1
 */