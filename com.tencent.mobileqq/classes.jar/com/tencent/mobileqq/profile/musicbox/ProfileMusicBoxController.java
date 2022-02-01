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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ListenTogetherTheme.FloatViewSkin;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.config.business.qvip.QVipProfileMusicBoxConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipProfileMusicBoxProcessor;
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
  public static int j = 3;
  private long jdField_a_of_type_Long;
  private SongInfo jdField_a_of_type_ComTencentMobileqqMusicSongInfo = new SongInfo();
  private ProfileMusicBoxController.PlayChange jdField_a_of_type_ComTencentMobileqqProfileMusicboxProfileMusicBoxController$PlayChange;
  private SongInfo[] jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo;
  private long b;
  private boolean h;
  private boolean i = false;
  
  public ProfileMusicBoxController(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_Boolean = true;
    paramQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherObserver);
  }
  
  public static boolean a(long paramLong)
  {
    SongInfo localSongInfo = QQPlayerService.b();
    if ((localSongInfo != null) && (QQPlayerService.b().jdField_b_of_type_Int == 10) && (localSongInfo.jdField_b_of_type_Long == paramLong)) {
      return QQPlayerService.a();
    }
    return false;
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(j, paramString);
    FloatViewSkin.a().a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout, paramString, j);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equalsIgnoreCase(paramString)))
    {
      this.i = true;
      return;
    }
    this.i = false;
  }
  
  public void a(long paramLong)
  {
    ((IJce)QRoute.api(IJce.class)).build("VIP.ProfileMusicBoxServer.ProfileMusicBoxObj", "ProfileMusicBox.getMusicList").request("getMusicList", new GetMusicListReq(paramLong, "", 100L, new SourceInfo(3, "8.7.0"), 0), new GetMusicListRsp(), this, false);
  }
  
  public void a(long paramLong, SongInfo paramSongInfo)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo = paramSongInfo;
    this.h = a(paramLong);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramSongInfo.g);
    a(paramLong, localArrayList);
  }
  
  public void a(long paramLong, ArrayList<String> paramArrayList)
  {
    ((IJce)QRoute.api(IJce.class)).build("VIP.ProfileMusicBoxServer.ProfileMusicBoxObj", "ProfileMusicBox.getQzoneMusicInfo").request("getQzoneMusicInfo", new GetQzoneMusicInfoReq(paramLong, paramArrayList, new SourceInfo(3, "8.7.0")), new GetQzoneMusicInfoRsp(), new ProfileMusicBoxController.3(this), false);
  }
  
  public void a(Context paramContext, SongInfo paramSongInfo)
  {
    if (QQPlayerService.a() == 3)
    {
      QQPlayerService.a(paramContext, false);
      d(true);
      return;
    }
    new Intent(paramContext, QQBrowserActivity.class).putExtra("url", URLUtil.a(QVipProfileMusicBoxProcessor.a().jdField_b_of_type_JavaLangString, "uin", String.valueOf(this.jdField_a_of_type_Long)));
    QQPlayerService.b(this);
    QQPlayerService.a(103);
    QQPlayerService.a(paramContext, getToken(), new SongInfo[] { paramSongInfo }, 0, false);
    a(this.jdField_a_of_type_Long);
    a(String.valueOf(this.jdField_a_of_type_Long));
    a(paramSongInfo);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("playMusic mid:");
      paramContext.append(paramSongInfo.g);
      paramContext.append(" url:");
      paramContext.append(paramSongInfo.jdField_b_of_type_JavaLangString);
      QLog.d("ProfileMusicBoxController", 2, paramContext.toString());
    }
  }
  
  public void a(SongInfo paramSongInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPlayMusicChange song.id:");
      localStringBuilder.append(paramSongInfo.e);
      QLog.i("ProfileMusicBoxController", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_a_of_type_JavaLangString = paramSongInfo.e;
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams);
    }
  }
  
  public void a(ProfileMusicBoxController.PlayChange paramPlayChange)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileMusicboxProfileMusicBoxController$PlayChange = paramPlayChange;
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equalsIgnoreCase(paramString))) {
      this.i = true;
    } else {
      this.i = false;
    }
    if (b())
    {
      QQPlayerService.a(BaseApplicationImpl.getContext(), false);
      d(true);
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_a_of_type_Int = ((LyricsController)localObject).a().jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_Int = ((LyricsController)localObject).a().jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_a_of_type_Boolean = ((LyricsController)localObject).a().jdField_a_of_type_Boolean;
      if (((LyricsController)localObject).a()) {
        ((LyricsController)localObject).b(((LyricsController)localObject).a().e, ((LyricsController)localObject).a().jdField_b_of_type_JavaLangString);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileMusicBoxController", 2, "showLyrics");
    }
    if ((TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_JavaLangString)))
    {
      super.a(j, this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_JavaLangString);
      return;
    }
    localObject = this.jdField_a_of_type_JavaUtilSet;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(j);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    ((Set)localObject).add(localStringBuilder.toString());
    if (!a())
    {
      super.a(j, paramString);
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.b();
      }
    }
    FloatViewSkin.a().a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout, paramString, j);
  }
  
  public boolean b()
  {
    return (QQPlayerService.a() == 3) && (QQPlayerService.b() != null) && (QQPlayerService.b().jdField_b_of_type_Int == 10) && (a());
  }
  
  public void c()
  {
    ProfileMusicBox.b(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.getContext(), this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_JavaLangString);
    String str;
    if (this.i) {
      str = "";
    } else {
      str = String.valueOf(this.jdField_a_of_type_Long);
    }
    int k;
    if (this.i) {
      k = 1;
    } else {
      k = 2;
    }
    ReportController.b(null, "dc00898", "", str, "qq_vip", "0X800A7DF", k, 0, "", "", "", "");
  }
  
  public boolean c()
  {
    return this.h;
  }
  
  public void d()
  {
    QQPlayerService.c(BaseApplicationImpl.getContext());
    p();
    String str;
    if (this.i) {
      str = "";
    } else {
      str = String.valueOf(this.jdField_a_of_type_Long);
    }
    int k;
    if (this.i) {
      k = 1;
    } else {
      k = 2;
    }
    ReportController.b(null, "dc00898", "", str, "qq_vip", "0X800A7E0", k, 0, "", "", "", "");
  }
  
  public void d(boolean paramBoolean)
  {
    ThreadManagerV2.getUIHandlerV2().post(new ProfileMusicBoxController.1(this, paramBoolean));
  }
  
  public void e()
  {
    QQPlayerService.c(this);
    this.jdField_a_of_type_ComTencentMobileqqProfileMusicboxProfileMusicBoxController$PlayChange = null;
    super.e();
    FloatViewSkin.a().b();
  }
  
  protected void f() {}
  
  public String getToken()
  {
    return QQPlayerService.a(4, "QQMusicWrap");
  }
  
  public void m()
  {
    super.b(j, this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.e = 0;
    b(j, this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_JavaLangString, true);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      LyricsController localLyricsController = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      if (localLyricsController != null)
      {
        localLyricsController.a().jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_a_of_type_Int;
        localLyricsController.a().jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_Int;
        localLyricsController.a().jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_a_of_type_Boolean;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileMusicBoxController", 2, "hideLyrics");
      }
    }
  }
  
  public void n()
  {
    QQPlayerService.a(BaseApplicationImpl.getContext());
    d(false);
  }
  
  public void o()
  {
    QQPlayerService.c(BaseApplicationImpl.getContext());
    p();
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo = paramSongInfo;
    if (paramSongInfo.jdField_b_of_type_Int == 10)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfileMusicboxProfileMusicBoxController$PlayChange;
      if (localObject != null) {
        ((ProfileMusicBoxController.PlayChange)localObject).a(paramSongInfo, this.h);
      }
      q();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onPlaySongChanged newSong:");
        ((StringBuilder)localObject).append(paramSongInfo.c);
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
              localObject1 = QQPlayerService.b();
              if ((localObject1 != null) && (TextUtils.isEmpty(((SongInfo)localObject1).jdField_b_of_type_JavaLangString)) && (((SongInfo)localObject1).jdField_b_of_type_Int == 10))
              {
                this.h = false;
                localObject2 = new ArrayList();
                ((ArrayList)localObject2).add(((SongInfo)localObject1).g);
                a(this.jdField_a_of_type_Long, (ArrayList)localObject2);
              }
            }
          }
          else
          {
            this.h = false;
            localObject1 = QQPlayerService.b();
            if ((localObject1 != null) && (((SongInfo)localObject1).jdField_b_of_type_Int == 10))
            {
              localObject2 = new ArrayList();
              ((ArrayList)localObject2).add(((SongInfo)localObject1).g);
              a(this.jdField_a_of_type_Long, (ArrayList)localObject2);
            }
          }
        }
        else
        {
          p();
          this.h = false;
        }
      }
      else
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileMusicboxProfileMusicBoxController$PlayChange;
        if (localObject1 != null) {
          ((ProfileMusicBoxController.PlayChange)localObject1).a(2);
        }
        d(false);
        this.h = false;
        long l = this.jdField_a_of_type_Long;
        if (this.i) {
          localObject1 = "0X800A7D9";
        } else {
          localObject1 = "0X800A7DE";
        }
        int k;
        if (FloatViewSkin.a().a()) {
          k = 1;
        } else {
          k = 2;
        }
        ReportController.b(null, "dc00898", "", String.valueOf(l), "qq_vip", (String)localObject1, k, 0, String.valueOf((System.currentTimeMillis() - this.jdField_b_of_type_Long) / 1000L), "", "", "");
      }
    }
    else
    {
      localObject1 = QQPlayerService.b();
      if (((SongInfo)localObject1).jdField_b_of_type_Int == 10)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileMusicboxProfileMusicBoxController$PlayChange;
        if (localObject2 != null) {
          ((ProfileMusicBoxController.PlayChange)localObject2).a((SongInfo)localObject1, true);
        }
        a((SongInfo)localObject1);
        if (!a()) {
          a(String.valueOf(this.jdField_a_of_type_Long));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null) {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.setPlayState(true);
        }
        this.h = true;
        this.jdField_b_of_type_Long = System.currentTimeMillis();
      }
      else
      {
        m();
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
      this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo = new SongInfo[paramObject.stMusicList.vMusicList.size()];
      paramInt = 0;
      while (paramInt < paramObject.stMusicList.vMusicList.size())
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[paramInt] = new SongInfo();
        this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[paramInt].g = ((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).sSongId;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[paramInt].jdField_d_of_type_JavaLangString = ((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).sAlbumName;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[paramInt].e = ((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).sPic;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[paramInt].c = ((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).sSongName;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[paramInt].jdField_d_of_type_Long = ((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).iDuration;
        Object localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo;
        localObject[paramInt].jdField_b_of_type_Int = 10;
        localObject[paramInt].jdField_b_of_type_Long = this.jdField_a_of_type_Long;
        if (localObject[paramInt].g.equals(this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo.g)) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[paramInt].jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_b_of_type_JavaLangString;
        }
        localObject = new StringBuilder();
        int k = 0;
        while (k < ((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).vSingerList.size())
        {
          if (k != 0) {
            ((StringBuilder)localObject).append("/");
          }
          ((StringBuilder)localObject).append(((SingerInfo)((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).vSingerList.get(k)).sSingerName);
          k += 1;
        }
        this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[paramInt].h = ((StringBuilder)localObject).toString();
        localArrayList.add(((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).sSongId);
        paramInt += 1;
      }
      QQPlayerService.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo);
      q();
    }
  }
  
  public void p()
  {
    ThreadManagerV2.getUIHandlerV2().post(new ProfileMusicBoxController.2(this));
    LyricsController localLyricsController = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    if ((localLyricsController != null) && (!ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()))
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("type", "musicboxResume");
        localJSONObject.put("uin", localLyricsController.a().jdField_b_of_type_JavaLangString);
        localJSONObject.put("uinType", localLyricsController.a().e);
        ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localJSONObject);
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
  
  public void q()
  {
    SongInfo localSongInfo = QQPlayerService.d();
    Object localObject = QQPlayerService.b();
    if ((localSongInfo != null) && (localObject != null) && (localSongInfo.jdField_b_of_type_Int == 10) && (!TextUtils.isEmpty(localSongInfo.g)) && (!localSongInfo.g.equals(((SongInfo)localObject).g)))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(localSongInfo.g);
      a(this.jdField_a_of_type_Long, (ArrayList)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.musicbox.ProfileMusicBoxController
 * JD-Core Version:    0.7.0.1
 */