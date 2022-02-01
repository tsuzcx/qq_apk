package com.tencent.mobileqq.profile.musicbox;

import VIP.GetMusicListReq;
import VIP.GetMusicListRsp;
import VIP.GetQzoneMusicInfoReq;
import VIP.GetQzoneMusicInfoRsp;
import VIP.MusicInfo;
import VIP.MusicListInfo;
import VIP.SingerInfo;
import VIP.SourceInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.lyrics.FloatIconLayout;
import com.tencent.mobileqq.listentogether.lyrics.FloatParams;
import com.tencent.mobileqq.listentogether.lyrics.FloatTextLayout;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController;
import com.tencent.mobileqq.music.QQPlayerCallback;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ListenTogetherTheme.FloatViewSkin;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.config.business.qvip.QVipProfileMusicBoxConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipProfileMusicBoxProcessor;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileMusicBoxController
  extends LyricsController
  implements BusinessObserver, QQPlayerCallback
{
  public static int F = 3;
  private long G;
  private SongInfo[] H;
  private SongInfo I = new SongInfo();
  private ProfileMusicBoxController.PlayChange J;
  private boolean K;
  private long L;
  private boolean M = false;
  
  public ProfileMusicBoxController(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.d.f = true;
    paramQQAppInterface.removeObserver(this.v);
  }
  
  public static boolean b(long paramLong)
  {
    SongInfo localSongInfo = QQPlayerService.g();
    if ((localSongInfo != null) && (QQPlayerService.g().m == 10) && (localSongInfo.c == paramLong)) {
      return QQPlayerService.b();
    }
    return false;
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(F, paramString);
    FloatViewSkin.a().a(this.i, paramString, F);
    if ((this.a != null) && (this.a.getAccount().equalsIgnoreCase(paramString)))
    {
      this.M = true;
      return;
    }
    this.M = false;
  }
  
  public void a(long paramLong)
  {
    VasUtil.a().getJceRequset().build("VIP.ProfileMusicBoxServer.ProfileMusicBoxObj", "ProfileMusicBox.getMusicList").request("getMusicList", new GetMusicListReq(paramLong, "", 100L, new SourceInfo(3, "8.8.17"), 0), new GetMusicListRsp(), this, false);
  }
  
  public void a(long paramLong, SongInfo paramSongInfo)
  {
    this.G = paramLong;
    this.I = paramSongInfo;
    this.K = b(paramLong);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramSongInfo.i);
    a(paramLong, localArrayList);
  }
  
  public void a(long paramLong, ArrayList<String> paramArrayList)
  {
    VasUtil.a().getJceRequset().build("VIP.ProfileMusicBoxServer.ProfileMusicBoxObj", "ProfileMusicBox.getQzoneMusicInfo").request("getQzoneMusicInfo", new GetQzoneMusicInfoReq(paramLong, paramArrayList, new SourceInfo(3, "8.8.17")), new GetQzoneMusicInfoRsp(), new ProfileMusicBoxController.3(this), false);
  }
  
  public void a(Context paramContext, SongInfo paramSongInfo)
  {
    if (QQPlayerService.c() == 3)
    {
      QQPlayerService.a(paramContext, false);
      d(true);
      return;
    }
    new Intent(paramContext, QQBrowserActivity.class).putExtra("url", URLUtil.a(QVipProfileMusicBoxProcessor.a().b, "uin", String.valueOf(this.G)));
    QQPlayerService.b(this);
    QQPlayerService.b(103);
    QQPlayerService.a(paramContext, getToken(), new SongInfo[] { paramSongInfo }, 0, false);
    a(this.G);
    a(String.valueOf(this.G));
    a(paramSongInfo);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("playMusic mid:");
      paramContext.append(paramSongInfo.i);
      paramContext.append(" url:");
      paramContext.append(paramSongInfo.d);
      QLog.d("ProfileMusicBoxController", 2, paramContext.toString());
    }
  }
  
  public void a(SongInfo paramSongInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPlayMusicChange song.id:");
      localStringBuilder.append(paramSongInfo.g);
      QLog.i("ProfileMusicBoxController", 2, localStringBuilder.toString());
    }
    this.d.g = paramSongInfo.g;
    if (g()) {
      this.i.a(this.d);
    }
  }
  
  public void a(ProfileMusicBoxController.PlayChange paramPlayChange)
  {
    this.J = paramPlayChange;
  }
  
  public void a(String paramString)
  {
    if ((this.a != null) && (this.a.getAccount().equalsIgnoreCase(paramString))) {
      this.M = true;
    } else {
      this.M = false;
    }
    if (o())
    {
      QQPlayerService.a(BaseApplicationImpl.getContext(), false);
      d(true);
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = ListenTogetherManager.a(this.a).k();
    if (localObject != null)
    {
      this.d.a = ((LyricsController)localObject).l().a;
      this.d.b = ((LyricsController)localObject).l().b;
      this.d.e = ((LyricsController)localObject).l().e;
      if (((LyricsController)localObject).g()) {
        ((LyricsController)localObject).b(((LyricsController)localObject).l().m, ((LyricsController)localObject).l().n);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileMusicBoxController", 2, "showLyrics");
    }
    if ((TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.d.n)))
    {
      super.a(F, this.d.n);
      return;
    }
    localObject = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(F);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    ((Set)localObject).add(localStringBuilder.toString());
    if (!g())
    {
      super.a(F, paramString);
      if (this.j != null) {
        this.j.c();
      }
    }
    FloatViewSkin.a().a(this.i, paramString, F);
  }
  
  public void c()
  {
    ProfileMusicBox.c(this.i.getContext(), this.d.n);
    String str;
    if (this.M) {
      str = "";
    } else {
      str = String.valueOf(this.G);
    }
    int i;
    if (this.M) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b(null, "dc00898", "", str, "qq_vip", "0X800A7DF", i, 0, "", "", "", "");
  }
  
  public void d()
  {
    QQPlayerService.e(BaseApplicationImpl.getContext());
    t();
    String str;
    if (this.M) {
      str = "";
    } else {
      str = String.valueOf(this.G);
    }
    int i;
    if (this.M) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b(null, "dc00898", "", str, "qq_vip", "0X800A7E0", i, 0, "", "", "", "");
  }
  
  public void d(boolean paramBoolean)
  {
    ThreadManagerV2.getUIHandlerV2().post(new ProfileMusicBoxController.1(this, paramBoolean));
  }
  
  public void e()
  {
    QQPlayerService.c(this);
    this.J = null;
    super.e();
    FloatViewSkin.a().d();
  }
  
  protected void f() {}
  
  public String getToken()
  {
    return QQPlayerService.a(4, "QQMusicWrap");
  }
  
  public boolean o()
  {
    return (QQPlayerService.c() == 3) && (QQPlayerService.g() != null) && (QQPlayerService.g().m == 10) && (g());
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo)
  {
    this.I = paramSongInfo;
    if (paramSongInfo.m == 10)
    {
      Object localObject = this.J;
      if (localObject != null) {
        ((ProfileMusicBoxController.PlayChange)localObject).a(paramSongInfo, this.K);
      }
      u();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onPlaySongChanged newSong:");
        ((StringBuilder)localObject).append(paramSongInfo.e);
        QLog.d("ProfileMusicBoxController", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void onPlayStateChanged(int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 7)
          {
            if (paramInt == 8)
            {
              localObject1 = QQPlayerService.g();
              if ((localObject1 != null) && (TextUtils.isEmpty(((SongInfo)localObject1).d)) && (((SongInfo)localObject1).m == 10))
              {
                this.K = false;
                localObject2 = new ArrayList();
                ((ArrayList)localObject2).add(((SongInfo)localObject1).i);
                a(this.G, (ArrayList)localObject2);
              }
            }
          }
          else
          {
            this.K = false;
            localObject1 = QQPlayerService.g();
            if ((localObject1 != null) && (((SongInfo)localObject1).m == 10))
            {
              localObject2 = new ArrayList();
              ((ArrayList)localObject2).add(((SongInfo)localObject1).i);
              a(this.G, (ArrayList)localObject2);
            }
          }
        }
        else
        {
          t();
          this.K = false;
        }
      }
      else
      {
        localObject1 = this.J;
        if (localObject1 != null) {
          ((ProfileMusicBoxController.PlayChange)localObject1).a(2);
        }
        d(false);
        this.K = false;
        long l = this.G;
        if (this.M) {
          localObject1 = "0X800A7D9";
        } else {
          localObject1 = "0X800A7DE";
        }
        int i;
        if (FloatViewSkin.a().b()) {
          i = 1;
        } else {
          i = 2;
        }
        ReportController.b(null, "dc00898", "", String.valueOf(l), "qq_vip", (String)localObject1, i, 0, String.valueOf((System.currentTimeMillis() - this.L) / 1000L), "", "", "");
      }
    }
    else
    {
      localObject1 = QQPlayerService.g();
      if (((SongInfo)localObject1).m == 10)
      {
        localObject2 = this.J;
        if (localObject2 != null) {
          ((ProfileMusicBoxController.PlayChange)localObject2).a((SongInfo)localObject1, true);
        }
        a((SongInfo)localObject1);
        if (!g()) {
          a(String.valueOf(this.G));
        }
        if (this.i != null) {
          this.i.setPlayState(true);
        }
        this.K = true;
        this.L = System.currentTimeMillis();
      }
      else
      {
        p();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onPlayStateChanged playState:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("ProfileMusicBoxController", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof GetMusicListRsp)))
    {
      paramObject = (GetMusicListRsp)paramObject;
      ArrayList localArrayList = new ArrayList();
      this.H = new SongInfo[paramObject.stMusicList.vMusicList.size()];
      paramInt = 0;
      while (paramInt < paramObject.stMusicList.vMusicList.size())
      {
        this.H[paramInt] = new SongInfo();
        this.H[paramInt].i = ((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).sSongId;
        this.H[paramInt].f = ((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).sAlbumName;
        this.H[paramInt].g = ((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).sPic;
        this.H[paramInt].e = ((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).sSongName;
        this.H[paramInt].p = ((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).iDuration;
        Object localObject = this.H;
        localObject[paramInt].m = 10;
        localObject[paramInt].c = this.G;
        if (localObject[paramInt].i.equals(this.I.i)) {
          this.H[paramInt].d = this.I.d;
        }
        localObject = new StringBuilder();
        int i = 0;
        while (i < ((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).vSingerList.size())
        {
          if (i != 0) {
            ((StringBuilder)localObject).append("/");
          }
          ((StringBuilder)localObject).append(((SingerInfo)((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).vSingerList.get(i)).sSingerName);
          i += 1;
        }
        this.H[paramInt].j = ((StringBuilder)localObject).toString();
        localArrayList.add(((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).sSongId);
        paramInt += 1;
      }
      QQPlayerService.a(this.H);
      u();
    }
  }
  
  public void p()
  {
    super.b(F, this.d.n);
    this.d.m = 0;
    b(F, this.d.n, true);
    if (this.a != null)
    {
      LyricsController localLyricsController = ListenTogetherManager.a(this.a).k();
      if (localLyricsController != null)
      {
        localLyricsController.l().a = this.d.a;
        localLyricsController.l().b = this.d.b;
        localLyricsController.l().e = this.d.e;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileMusicBoxController", 2, "hideLyrics");
      }
    }
  }
  
  public void q()
  {
    QQPlayerService.c(BaseApplicationImpl.getContext());
    d(false);
  }
  
  public boolean r()
  {
    return this.K;
  }
  
  public void s()
  {
    QQPlayerService.e(BaseApplicationImpl.getContext());
    t();
  }
  
  public void t()
  {
    ThreadManagerV2.getUIHandlerV2().post(new ProfileMusicBoxController.2(this));
    LyricsController localLyricsController = ListenTogetherManager.a(this.a).k();
    if ((localLyricsController != null) && (!ListenTogetherManager.a(this.a).i()))
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("type", "musicboxResume");
        localJSONObject.put("uin", localLyricsController.l().n);
        localJSONObject.put("uinType", localLyricsController.l().m);
        ListenTogetherManager.a(this.a).a(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileMusicBoxController", 2, "resetState");
    }
  }
  
  public void u()
  {
    SongInfo localSongInfo = QQPlayerService.q();
    Object localObject = QQPlayerService.g();
    if ((localSongInfo != null) && (localObject != null) && (localSongInfo.m == 10) && (!TextUtils.isEmpty(localSongInfo.i)) && (!localSongInfo.i.equals(((SongInfo)localObject).i)))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(localSongInfo.i);
      a(this.G, (ArrayList)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.musicbox.ProfileMusicBoxController
 * JD-Core Version:    0.7.0.1
 */