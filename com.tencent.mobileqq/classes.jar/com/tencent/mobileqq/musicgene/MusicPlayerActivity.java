package com.tencent.mobileqq.musicgene;

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
import asbc;
import asbk;
import asbv;
import asvl;
import asvn;
import aswc;
import aswm;
import aswp;
import aswq;
import aswr;
import asws;
import aswt;
import aswu;
import aswv;
import asww;
import aswx;
import axqy;
import bgzl;
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
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;
import xmq;

public class MusicPlayerActivity
  extends BaseActivity
{
  private static final HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static final HashMap<String, String> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private static final HashMap<String, asww> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  private final ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new aswp(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aswm(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private asbc jdField_a_of_type_Asbc;
  private asbv jdField_a_of_type_Asbv;
  private final asvl jdField_a_of_type_Asvl = new aswq(this);
  private asvn jdField_a_of_type_Asvn;
  private aswc jdField_a_of_type_Aswc = new aswr(this);
  private final aswt jdField_a_of_type_Aswt = new aswt(this);
  private final aswu jdField_a_of_type_Aswu = new aswu(this);
  private aswx jdField_a_of_type_Aswx;
  public LyricViewDetail a;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private asbc jdField_b_of_type_Asbc;
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
  
  private String a(asvn paramasvn, SongInfo paramSongInfo, long paramLong)
  {
    String str2 = "";
    String str1 = str2;
    if (paramSongInfo != null)
    {
      if (paramLong == paramSongInfo.a) {
        paramSongInfo.jdField_b_of_type_Int = 4;
      }
      str1 = str2;
      switch (paramSongInfo.jdField_b_of_type_Int)
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
        if (paramasvn != null) {
          paramSongInfo = null;
        }
      }
      try
      {
        paramasvn = paramasvn.a();
        paramSongInfo = str1;
        if (paramasvn != null) {
          paramSongInfo = paramasvn.getString("KEY_SOURCE_NAME");
        }
        return paramSongInfo;
        str1 = getString(2131694788);
        continue;
        str1 = getString(2131694482);
      }
      catch (RemoteException paramasvn)
      {
        for (;;)
        {
          paramasvn = paramSongInfo;
        }
      }
    }
  }
  
  private String a(SongInfo paramSongInfo)
  {
    String str = "";
    if (paramSongInfo != null) {
      str = paramSongInfo.jdField_b_of_type_JavaLangString + "_____" + String.valueOf(paramSongInfo.a);
    }
    return str;
  }
  
  private void a()
  {
    asvn localasvn = this.jdField_a_of_type_Asvn;
    if (localasvn == null)
    {
      QLog.e("MusicPlayerActivity", 1, new Object[] { "updateLyricPosition() exception", "mService is null!" });
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject1 = localasvn.a();
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
          this.jdField_a_of_type_Asbv.b();
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
      int i = localasvn.a();
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(0);
      long l2 = localasvn.g();
      long l1 = l2;
      if (l2 < 0L) {
        l1 = 0L;
      }
      int j = (int)l1;
      if (localasvn.a())
      {
        boolean bool = this.jdField_a_of_type_Asbv.a();
        if (!bool) {
          this.jdField_a_of_type_Asbv.a();
        }
        QLog.i("MusicPlayerActivity", 1, "LyricTest updateLyricPosition() try to seek! playPosition:" + l1 + " seekPosition:" + j + " isPlaying:" + bool);
        this.jdField_a_of_type_Asbv.a(j);
        return;
      }
      if (3 == i)
      {
        this.jdField_a_of_type_Asbv.a(j);
        this.jdField_a_of_type_Asbv.c();
        return;
      }
      this.jdField_a_of_type_Asbv.b();
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
  
  private void a(asww paramasww, String paramString)
  {
    aswv localaswv = new aswv(paramasww.jdField_a_of_type_JavaLangString, paramasww.jdField_b_of_type_JavaLangString, paramasww.e, paramasww.d, paramasww.c, "http://qzonestyle.gtimg.cn/ac/qzone/applogo/16/308/100497308_16.gif");
    Message localMessage = Message.obtain(this.jdField_a_of_type_Aswt, 51);
    localMessage.arg1 = 1;
    localMessage.obj = localaswv;
    localMessage.sendToTarget();
    Message.obtain(this.jdField_a_of_type_Aswt, 53).sendToTarget();
    a(paramasww.jdField_a_of_type_JavaLangString, paramasww.jdField_b_of_type_JavaLangString, paramasww.e, paramString, paramasww.jdField_a_of_type_Boolean, true);
  }
  
  private void a(String paramString, LyricViewDetail paramLyricViewDetail)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.jdField_b_of_type_Asbc = asbk.a(paramString, true);
      if (this.jdField_b_of_type_Asbc == null) {
        this.jdField_a_of_type_Asbc = asbk.a(paramString, false);
      }
    } while ((this.jdField_b_of_type_Asbc == null) && (this.jdField_a_of_type_Asbc == null));
    this.jdField_a_of_type_Asbv.b();
    paramLyricViewDetail.a().setHighlightCurrentLine(true);
    paramLyricViewDetail.a().setHighlightLineNumber(2);
    this.jdField_a_of_type_Asbv.a(paramLyricViewDetail);
    this.jdField_a_of_type_Asbv.a(this.jdField_b_of_type_Asbc, this.jdField_a_of_type_Asbc, null);
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
    bgzl.a(this.app, this, localBundle, null, 0);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_Aswt, 52);
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
    localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131696698, new Object[] { str }));
    localIntent.putExtra("audio_url", paramString5);
    localIntent.putExtra("req_type", 2);
    localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
    if (this.app != null)
    {
      localIntent.putExtra("struct_share_key_source_name", getString(2131690145));
      xmq.a(this.app, this, this.app.getAccount(), 1101244924L, 3000L, new asws(this, localIntent));
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    boolean bool = super.doOnCreate(paramBundle);
    try
    {
      setContentView(2131559319);
      bindService(new Intent(this, QQPlayerService.class), this.jdField_a_of_type_AndroidContentServiceConnection, 33);
      paramBundle = findViewById(2131370580);
      View localView = findViewById(2131370569);
      int i = a(this).x;
      paramBundle.getLayoutParams().height = i;
      localView.getLayoutParams().height = i;
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370579));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370573));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370575));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370577));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370572));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_Aswx = ((aswx)this.app.a(92));
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail = ((LyricViewDetail)findViewById(2131370576));
      this.jdField_a_of_type_Asbv = new asbv(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail);
      findViewById(2131370570).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.d = ((ImageView)findViewById(2131370578));
      this.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      addObserver(this.jdField_a_of_type_Aswu);
      axqy.b(this.app, "CliOper", "", "", "0X8006826", "0X8006826", 0, 0, "", "", "", "");
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
    asvn localasvn = this.jdField_a_of_type_Asvn;
    if (localasvn != null) {}
    try
    {
      localasvn.b(this.jdField_a_of_type_Asvl);
      label19:
      unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
      removeObserver(this.jdField_a_of_type_Aswu);
      super.doOnDestroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      break label19;
    }
  }
  
  public void onDestroy()
  {
    try
    {
      if (this.jdField_a_of_type_Asbv != null) {
        this.jdField_a_of_type_Asbv.b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicPlayerActivity
 * JD-Core Version:    0.7.0.1
 */