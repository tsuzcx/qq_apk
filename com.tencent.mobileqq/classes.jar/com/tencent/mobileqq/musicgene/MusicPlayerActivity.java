package com.tencent.mobileqq.musicgene;

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
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class MusicPlayerActivity
  extends BaseActivity
{
  private static final HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static final HashMap<String, String> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private static final HashMap<String, MusicPlayerActivity.SimpleSongInfo> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  private final ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new MusicPlayerActivity.2(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new MusicPlayerActivity.1(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Lyric jdField_a_of_type_ComTencentMobileqqLyricDataLyric;
  private LyricViewController jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController;
  LyricViewDetail jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail;
  private final IQQPlayerCallback.Stub jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerCallback$Stub = new MusicPlayerActivity.3(this);
  private IQQPlayerService jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService = null;
  private AlbumDecodeHandler.OnDecodeCompleteCallback jdField_a_of_type_ComTencentMobileqqMusicgeneAlbumDecodeHandler$OnDecodeCompleteCallback = new MusicPlayerActivity.4(this);
  private final MusicPlayerActivity.LoadAlbumImageHandler jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$LoadAlbumImageHandler = new MusicPlayerActivity.LoadAlbumImageHandler(this);
  private final MusicPlayerActivity.MusicPlayerObserver jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$MusicPlayerObserver = new MusicPlayerActivity.MusicPlayerObserver(this);
  private MusicPlayerHandler jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerHandler = null;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Lyric jdField_b_of_type_ComTencentMobileqqLyricDataLyric;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private ImageView d;
  
  private static Point a(Activity paramActivity)
  {
    Point localPoint = new Point();
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
      if (Build.VERSION.SDK_INT >= 13)
      {
        paramActivity.getSize(localPoint);
        return localPoint;
      }
      localPoint.x = paramActivity.getWidth();
      localPoint.y = paramActivity.getHeight();
    }
    return localPoint;
  }
  
  private String a(IQQPlayerService paramIQQPlayerService, SongInfo paramSongInfo, long paramLong)
  {
    if (paramSongInfo != null)
    {
      if (paramLong == paramSongInfo.a) {
        paramSongInfo.b = 4;
      }
      int i = paramSongInfo.b;
      if (i != 4)
      {
        if (i == 6)
        {
          paramSongInfo = getString(2131694369);
          break label63;
        }
      }
      else
      {
        paramSongInfo = getString(2131694577);
        break label63;
      }
    }
    paramSongInfo = "";
    label63:
    Object localObject = paramSongInfo;
    if (TextUtils.isEmpty(paramSongInfo))
    {
      localObject = paramSongInfo;
      if (paramIQQPlayerService != null) {
        localObject = null;
      }
    }
    try
    {
      paramIQQPlayerService = paramIQQPlayerService.a();
      localObject = paramSongInfo;
      if (paramIQQPlayerService != null) {
        localObject = paramIQQPlayerService.getString("KEY_SOURCE_NAME");
      }
      return localObject;
    }
    catch (RemoteException paramIQQPlayerService)
    {
      for (;;)
      {
        paramIQQPlayerService = (IQQPlayerService)localObject;
      }
    }
  }
  
  private String a(SongInfo paramSongInfo)
  {
    if (paramSongInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramSongInfo.c);
      localStringBuilder.append("_____");
      localStringBuilder.append(String.valueOf(paramSongInfo.a));
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private void a()
  {
    IQQPlayerService localIQQPlayerService = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
    if (localIQQPlayerService == null)
    {
      QLog.e("MusicPlayerActivity", 1, new Object[] { "updateLyricPosition() exception", "mService is null!" });
      return;
    }
    label416:
    for (;;)
    {
      try
      {
        Object localObject2 = localIQQPlayerService.a();
        Object localObject1 = "";
        long l3 = 0L;
        if (localObject2 != null)
        {
          localObject2 = a((SongInfo)localObject2);
          if (jdField_a_of_type_JavaUtilHashMap.containsKey(localObject2))
          {
            long l2 = ((Long)jdField_a_of_type_JavaUtilHashMap.get(localObject2)).longValue();
            l1 = l2;
            if (jdField_b_of_type_JavaUtilHashMap.containsKey(localObject2))
            {
              localObject1 = (String)jdField_b_of_type_JavaUtilHashMap.get(localObject2);
              l1 = l2;
            }
            l2 = -1L;
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.getTag();
            if ((localObject2 instanceof Long)) {
              l2 = ((Long)localObject2).longValue();
            }
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(4);
              this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.b();
              return;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.a().b() == null) || (l2 != l1))
            {
              a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail);
              this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setTag(Long.valueOf(l1));
            }
            int i = localIQQPlayerService.a();
            this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(0);
            l1 = localIQQPlayerService.g();
            if (l1 >= 0L) {
              break label416;
            }
            l1 = l3;
            int j = (int)l1;
            if (localIQQPlayerService.a())
            {
              boolean bool = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.a();
              if (!bool) {
                this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.a();
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("LyricTest updateLyricPosition() try to seek! playPosition:");
              ((StringBuilder)localObject1).append(l1);
              ((StringBuilder)localObject1).append(" seekPosition:");
              ((StringBuilder)localObject1).append(j);
              ((StringBuilder)localObject1).append(" isPlaying:");
              ((StringBuilder)localObject1).append(bool);
              QLog.i("MusicPlayerActivity", 1, ((StringBuilder)localObject1).toString());
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
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("MusicPlayerActivity", 1, localException, new Object[0]);
        return;
      }
      long l1 = 0L;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = getResources().getDrawable(paramInt1);
    if (localDrawable != null) {
      localDrawable.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
    }
  }
  
  private void a(MusicPlayerActivity.SimpleSongInfo paramSimpleSongInfo, String paramString)
  {
    MusicPlayerActivity.ShareInfo localShareInfo = new MusicPlayerActivity.ShareInfo(paramSimpleSongInfo.jdField_a_of_type_JavaLangString, paramSimpleSongInfo.b, paramSimpleSongInfo.e, paramSimpleSongInfo.d, paramSimpleSongInfo.c, "https://qzonestyle.gtimg.cn/ac/qzone/applogo/16/308/100497308_16.gif");
    Message localMessage = Message.obtain(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$LoadAlbumImageHandler, 51);
    localMessage.arg1 = 1;
    localMessage.obj = localShareInfo;
    localMessage.sendToTarget();
    Message.obtain(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$LoadAlbumImageHandler, 53).sendToTarget();
    a(paramSimpleSongInfo.jdField_a_of_type_JavaLangString, paramSimpleSongInfo.b, paramSimpleSongInfo.e, paramString, paramSimpleSongInfo.jdField_a_of_type_Boolean, true);
  }
  
  private void a(String paramString, LyricViewDetail paramLyricViewDetail)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric = LyricParseHelper.a(paramString, true);
    if (this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric == null) {
      this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric = LyricParseHelper.a(paramString, false);
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric == null) && (this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric == null)) {
      return;
    }
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
    localBundle.putString("struct_url", this.app.getCurrentUin());
    localBundle.putBoolean("from_web", true);
    QZoneShareManager.jumpToQzoneShare(this.app, this, localBundle, null, 0);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$LoadAlbumImageHandler, 52);
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
    Object localObject = paramString1;
    if (paramString1 != null)
    {
      localObject = paramString1;
      if (paramString1.length() > 45)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1.substring(0, 45));
        ((StringBuilder)localObject).append("…");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (paramString2.length() > 60)
      {
        paramString1 = new StringBuilder();
        paramString1.append(paramString2.substring(0, 60));
        paramString1.append("…");
        paramString1 = paramString1.toString();
      }
    }
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("title", (String)localObject);
    localIntent.putExtra("desc", paramString1);
    localIntent.putExtra("detail_url", paramString3);
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("req_share_id", 1101244924L);
    localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
    localIntent.putExtra("image_url_remote", paramString4);
    localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131696401, new Object[] { localObject }));
    localIntent.putExtra("audio_url", paramString5);
    localIntent.putExtra("req_type", 2);
    localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
    if (this.app != null)
    {
      localIntent.putExtra("struct_share_key_source_name", getString(2131690092));
      Share.a(this.app, this, this.app.getAccount(), 1101244924L, 3000L, new MusicPlayerActivity.5(this, localIntent));
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    boolean bool = super.doOnCreate(paramBundle);
    try
    {
      setContentView(2131559474);
      bindService(new Intent(this, QQPlayerService.class), this.jdField_a_of_type_AndroidContentServiceConnection, 33);
      paramBundle = findViewById(2131371644);
      View localView = findViewById(2131371633);
      int i = a(this).x;
      paramBundle.getLayoutParams().height = i;
      localView.getLayoutParams().height = i;
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371643));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371637));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371639));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371641));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371636));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerHandler = ((MusicPlayerHandler)this.app.getBusinessHandler(BusinessHandlerFactory.MUSIC_PLAYER_HANDLER));
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail = ((LyricViewDetail)findViewById(2131371640));
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController = new LyricViewController(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail);
      findViewById(2131371634).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.d = ((ImageView)findViewById(2131371642));
      this.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$MusicPlayerObserver);
      ReportController.b(this.app, "CliOper", "", "", "0X8006826", "0X8006826", 0, 0, "", "", "", "");
      return bool;
    }
    catch (OutOfMemoryError paramBundle)
    {
      label310:
      break label310;
    }
    finish();
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
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onDestroy()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.b();
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerActivity", 1, localException, new Object[0]);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicPlayerActivity
 * JD-Core Version:    0.7.0.1
 */