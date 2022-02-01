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
  private static final HashMap<String, Long> k = new HashMap();
  private static final HashMap<String, String> l = new HashMap();
  private static final HashMap<String, MusicPlayerActivity.SimpleSongInfo> m = new HashMap();
  LyricViewDetail a;
  private IQQPlayerService b = null;
  private TextView c;
  private TextView d;
  private ImageView e;
  private ImageView f;
  private ImageView g;
  private ImageView h;
  private MusicPlayerHandler i = null;
  private final MusicPlayerActivity.MusicPlayerObserver j = new MusicPlayerActivity.MusicPlayerObserver(this);
  private View.OnClickListener n = new MusicPlayerActivity.1(this);
  private final ServiceConnection o = new MusicPlayerActivity.2(this);
  private final IQQPlayerCallback.Stub p = new MusicPlayerActivity.3(this);
  private AlbumDecodeHandler.OnDecodeCompleteCallback q = new MusicPlayerActivity.4(this);
  private final MusicPlayerActivity.LoadAlbumImageHandler r = new MusicPlayerActivity.LoadAlbumImageHandler(this);
  private LyricViewController s;
  private Lyric t;
  private Lyric u;
  
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
        paramSongInfo.m = 4;
      }
      int i1 = paramSongInfo.m;
      if (i1 != 4)
      {
        if (i1 == 6)
        {
          paramSongInfo = getString(2131892046);
          break label63;
        }
      }
      else
      {
        paramSongInfo = getString(2131892261);
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
      paramIQQPlayerService = paramIQQPlayerService.q();
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
      localStringBuilder.append(paramSongInfo.e);
      localStringBuilder.append("_____");
      localStringBuilder.append(String.valueOf(paramSongInfo.a));
      return localStringBuilder.toString();
    }
    return "";
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
    MusicPlayerActivity.ShareInfo localShareInfo = new MusicPlayerActivity.ShareInfo(paramSimpleSongInfo.b, paramSimpleSongInfo.c, paramSimpleSongInfo.f, paramSimpleSongInfo.e, paramSimpleSongInfo.d, "https://qzonestyle.gtimg.cn/ac/qzone/applogo/16/308/100497308_16.gif");
    Message localMessage = Message.obtain(this.r, 51);
    localMessage.arg1 = 1;
    localMessage.obj = localShareInfo;
    localMessage.sendToTarget();
    Message.obtain(this.r, 53).sendToTarget();
    a(paramSimpleSongInfo.b, paramSimpleSongInfo.c, paramSimpleSongInfo.f, paramString, paramSimpleSongInfo.g, true);
  }
  
  private void a(String paramString, LyricViewDetail paramLyricViewDetail)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.u = LyricParseHelper.a(paramString, true);
    if (this.u == null) {
      this.t = LyricParseHelper.a(paramString, false);
    }
    if ((this.u == null) && (this.t == null)) {
      return;
    }
    this.s.b();
    paramLyricViewDetail.getLyricViewInternal().setHighlightCurrentLine(true);
    paramLyricViewDetail.getLyricViewInternal().setHighlightLineNumber(2);
    this.s.a(paramLyricViewDetail);
    this.s.a(this.u, this.t, null);
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
    Message localMessage = Message.obtain(this.r, 52);
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
    localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131894173, new Object[] { localObject }));
    localIntent.putExtra("audio_url", paramString5);
    localIntent.putExtra("req_type", 2);
    localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
    if (this.app != null)
    {
      localIntent.putExtra("struct_share_key_source_name", getString(2131886912));
      Share.a(this.app, this, this.app.getAccount(), 1101244924L, 3000L, new MusicPlayerActivity.5(this, localIntent));
    }
  }
  
  private void d()
  {
    IQQPlayerService localIQQPlayerService = this.b;
    if (localIQQPlayerService == null)
    {
      QLog.e("MusicPlayerActivity", 1, new Object[] { "updateLyricPosition() exception", "mService is null!" });
      return;
    }
    label421:
    for (;;)
    {
      try
      {
        Object localObject2 = localIQQPlayerService.k();
        Object localObject1 = "";
        long l3 = 0L;
        if (localObject2 != null)
        {
          localObject2 = a((SongInfo)localObject2);
          if (k.containsKey(localObject2))
          {
            long l2 = ((Long)k.get(localObject2)).longValue();
            l1 = l2;
            if (l.containsKey(localObject2))
            {
              localObject1 = (String)l.get(localObject2);
              l1 = l2;
            }
            l2 = -1L;
            localObject2 = this.a.getTag();
            if ((localObject2 instanceof Long)) {
              l2 = ((Long)localObject2).longValue();
            }
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              this.a.setVisibility(4);
              this.s.b();
              return;
            }
            if ((this.a.getLyricViewInternal().getLyric() == null) || (l2 != l1))
            {
              a((String)localObject1, this.a);
              this.a.setTag(Long.valueOf(l1));
            }
            int i1 = localIQQPlayerService.g();
            this.a.setVisibility(0);
            l1 = localIQQPlayerService.s();
            if (l1 >= 0L) {
              break label421;
            }
            l1 = l3;
            int i2 = (int)l1;
            if (localIQQPlayerService.f())
            {
              boolean bool = this.s.d();
              if (!bool) {
                this.s.a();
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("LyricTest updateLyricPosition() try to seek! playPosition:");
              ((StringBuilder)localObject1).append(l1);
              ((StringBuilder)localObject1).append(" seekPosition:");
              ((StringBuilder)localObject1).append(i2);
              ((StringBuilder)localObject1).append(" isPlaying:");
              ((StringBuilder)localObject1).append(bool);
              QLog.i("MusicPlayerActivity", 1, ((StringBuilder)localObject1).toString());
              this.s.a(i2);
              return;
            }
            if (3 == i1)
            {
              this.s.a(i2);
              this.s.c();
              return;
            }
            this.s.b();
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
      setContentView(2131625493);
      bindService(new Intent(this, QQPlayerService.class), this.o, 33);
      paramBundle = findViewById(2131439064);
      View localView = findViewById(2131439053);
      int i1 = a(this).x;
      paramBundle.getLayoutParams().height = i1;
      localView.getLayoutParams().height = i1;
      this.c = ((TextView)findViewById(2131439063));
      this.d = ((TextView)findViewById(2131439057));
      this.f = ((ImageView)findViewById(2131439059));
      this.e = ((ImageView)findViewById(2131439061));
      this.g = ((ImageView)findViewById(2131439056));
      this.e.setOnClickListener(this.n);
      this.i = ((MusicPlayerHandler)this.app.getBusinessHandler(BusinessHandlerFactory.MUSIC_PLAYER_HANDLER));
      this.a = ((LyricViewDetail)findViewById(2131439060));
      this.s = new LyricViewController(this.a);
      findViewById(2131439054).setOnClickListener(this.n);
      this.f.setOnClickListener(this.n);
      this.h = ((ImageView)findViewById(2131439062));
      this.h.setOnClickListener(this.n);
      this.g.setOnClickListener(this.n);
      addObserver(this.j);
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
    IQQPlayerService localIQQPlayerService = this.b;
    if (localIQQPlayerService != null) {}
    try
    {
      localIQQPlayerService.b(this.p);
      label19:
      unbindService(this.o);
      removeObserver(this.j);
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
      if (this.s != null) {
        this.s.b();
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerActivity", 1, localException, new Object[0]);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicPlayerActivity
 * JD-Core Version:    0.7.0.1
 */