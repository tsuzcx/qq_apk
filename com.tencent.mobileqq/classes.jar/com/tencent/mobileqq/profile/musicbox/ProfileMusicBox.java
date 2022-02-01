package com.tencent.mobileqq.profile.musicbox;

import QQService.EVIPSPEC;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileNameUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.config.business.qvip.QVipProfileMusicBoxConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipProfileMusicBoxProcessor;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.pb.profilecard.VaProfileGate.CommTaskInfo;
import com.tencent.pb.profilecard.VipMusicBox.GetProfileMusicBoxInfoRsp;
import com.tencent.pb.profilecard.VipMusicBox.ProfileMusicInfo;
import com.tencent.pb.profilecard.VipMusicBox.ProfileSingerInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.URLUtil;
import com.tencent.widget.AlphaClickableImageView;
import mqq.app.AppRuntime;

public class ProfileMusicBox
  implements View.OnClickListener, ProfileMusicBoxController.PlayChange
{
  private String a = "";
  private AlphaClickableImageView b;
  private View c;
  private SongInfo d = new SongInfo();
  private int e;
  private ProfileMusicBoxController f;
  private boolean g;
  private String h = "";
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l = true;
  
  public ProfileMusicBox(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public static void a(VaProfileGate.CommTaskInfo paramCommTaskInfo, Card paramCard)
  {
    VipMusicBox.GetProfileMusicBoxInfoRsp localGetProfileMusicBoxInfoRsp = new VipMusicBox.GetProfileMusicBoxInfoRsp();
    for (;;)
    {
      try
      {
        localGetProfileMusicBoxInfoRsp.mergeFrom(paramCommTaskInfo.bytes_task_data.get().toByteArray());
        paramCard.coverUrl = localGetProfileMusicBoxInfoRsp.music.pic.get();
        paramCommTaskInfo = new StringBuilder();
        m = 0;
        if (m < localGetProfileMusicBoxInfoRsp.music.singer_list.size())
        {
          if (m != 0) {
            paramCommTaskInfo.append("/");
          }
          paramCommTaskInfo.append(((VipMusicBox.ProfileSingerInfo)localGetProfileMusicBoxInfoRsp.music.singer_list.get(m)).singer_name.get());
          m += 1;
          continue;
        }
        paramCard.singer = paramCommTaskInfo.toString();
        paramCard.songId = localGetProfileMusicBoxInfoRsp.music.song_id.get();
        paramCard.songName = localGetProfileMusicBoxInfoRsp.music.song_name.get();
        paramCard.songDuration = localGetProfileMusicBoxInfoRsp.music.duration.get();
        if (QLog.isColorLevel())
        {
          paramCommTaskInfo = new StringBuilder();
          paramCommTaskInfo.append("card songId :");
          paramCommTaskInfo.append(paramCard.songId);
          paramCommTaskInfo.append(" ");
          paramCommTaskInfo.append(paramCard.songName);
          QLog.e("ProfileMusicBox", 2, paramCommTaskInfo.toString());
        }
        paramCommTaskInfo = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (paramCommTaskInfo != null)
        {
          if (paramCommTaskInfo.getAccount().equalsIgnoreCase(paramCard.uin))
          {
            if (!a()) {
              break label336;
            }
            if (!TextUtils.isEmpty(paramCard.songId)) {
              break label331;
            }
            m = 2;
            ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A7D6", m, 0, "", "", "", "");
            return;
          }
          paramCommTaskInfo = paramCard.uin;
          if (!a()) {
            break label341;
          }
          m = 1;
          ReportController.b(null, "dc00898", "", paramCommTaskInfo, "qq_vip", "0X800A7DC", m, 0, "", "", "", "");
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramCommTaskInfo)
      {
        paramCommTaskInfo.printStackTrace();
      }
      return;
      label331:
      int m = 1;
      continue;
      label336:
      m = 3;
      continue;
      label341:
      m = 2;
    }
  }
  
  public static boolean a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    return (VasUtil.b(localAppRuntime).getVipStatus().isSVip()) || (VasUtil.b(localAppRuntime).getVipStatus().isBigClub());
  }
  
  public static boolean a(ProfileCardInfo paramProfileCardInfo)
  {
    Card localCard = paramProfileCardInfo.card;
    boolean bool1 = false;
    if (localCard == null) {
      return false;
    }
    if (paramProfileCardInfo.allInOne.pa == 0)
    {
      int m;
      if (paramProfileCardInfo.card.switchMusicBox == 0) {
        m = 1;
      } else {
        m = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800A7DB", "qq_vip", m, 0, "", "", "", "");
      if (paramProfileCardInfo.card.switchMusicBox == 0) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = paramProfileCardInfo.card.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
    boolean bool2 = paramProfileCardInfo.card.isVipOpen(EVIPSPEC.E_SP_BIGCLUB);
    return (paramProfileCardInfo.card.switchMusicBox == 0) && (!TextUtils.isEmpty(paramProfileCardInfo.card.songId)) && ((bool1) || (bool2));
  }
  
  public static void c(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    paramString = URLUtil.a(QVipProfileMusicBoxProcessor.a().b, "uin", paramString);
    localIntent.setFlags(268435456);
    localIntent.putExtra("url", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public View a(Context paramContext, String paramString)
  {
    this.a = paramString;
    this.c = LayoutInflater.from(paramContext).inflate(2131628450, null);
    this.c.setOnClickListener(this);
    if (this.j)
    {
      this.c.findViewById(2131435715).setOnClickListener(this);
      this.c.findViewById(2131446333).setOnClickListener(this);
      this.b = ((AlphaClickableImageView)this.c.findViewById(2131446333));
      this.c.findViewById(2131446162).setVisibility(8);
    }
    else
    {
      this.c.findViewById(2131446162).setOnClickListener(this);
      this.c.findViewById(2131435715).setVisibility(8);
    }
    a(2);
    this.e = AIOUtils.b(35.0F, paramContext.getResources());
    if (this.f == null) {
      this.f = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).l();
    }
    this.f.a(this);
    return this.c;
  }
  
  @SuppressLint({"NewApi"})
  public void a(int paramInt)
  {
    if (this.j)
    {
      if (paramInt == 1)
      {
        this.b.setImageResource(2130846231);
        this.b.setContentDescription("暂停音乐");
        return;
      }
      this.b.setImageResource(2130846232);
      this.b.setContentDescription("播放音乐");
      return;
    }
    TextView localTextView = (TextView)this.c.findViewById(2131446162);
    localTextView.setCompoundDrawablePadding(ViewUtils.dpToPx(4.0F));
    if (paramInt == 1)
    {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(2130852417, 0, 0, 0);
      return;
    }
    localTextView.setCompoundDrawablesWithIntrinsicBounds(2130852418, 0, 0, 0);
  }
  
  public void a(SongInfo paramSongInfo, boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int m = 2;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update :");
      ((StringBuilder)localObject).append(paramSongInfo.e);
      QLog.e("ProfileMusicBox", 2, ((StringBuilder)localObject).toString());
    }
    if (paramSongInfo.c != Long.parseLong(this.a)) {
      return;
    }
    this.d = paramSongInfo;
    this.g = paramBoolean;
    if (this.j)
    {
      ((TextView)this.c.findViewById(2131446161)).setText(paramSongInfo.e);
      ((TextView)this.c.findViewById(2131446160)).setText(paramSongInfo.j);
      a(paramSongInfo.g);
      return;
    }
    Object localObject = (TextView)this.c.findViewById(2131446162);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramSongInfo.e);
    localStringBuilder.append("-");
    localStringBuilder.append(paramSongInfo.j);
    ((TextView)localObject).setText(localStringBuilder.toString());
    if (this.g) {
      m = 1;
    }
    a(m);
  }
  
  public void a(String paramString)
  {
    if (this.h.equals(paramString)) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = this.c.getContext().getResources().getDrawable(2130846230);
    localURLDrawableOptions.mFailedDrawable = this.c.getContext().getResources().getDrawable(2130846230);
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    int m = 1;
    paramString.setTag(new int[] { this.e / 2 });
    paramString.setDecodeHandler(URLDrawableDecodeHandler.z);
    paramString.startDownload();
    this.c.findViewById(2131446333).setBackgroundDrawable(paramString);
    if (!this.g) {
      m = 2;
    }
    a(m);
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
    if (!this.j)
    {
      TextView localTextView = (TextView)this.c.findViewById(2131446162);
      if (paramBoolean)
      {
        localTextView.setVisibility(8);
        return;
      }
      localTextView.setVisibility(0);
      return;
    }
    if (paramBoolean)
    {
      this.c.findViewById(2131432523).setVisibility(0);
      this.c.findViewById(2131446333).setVisibility(8);
      this.c.findViewById(2131439040).setVisibility(8);
      return;
    }
    this.c.findViewById(2131432523).setVisibility(8);
    this.c.findViewById(2131446333).setVisibility(0);
    this.c.findViewById(2131439040).setVisibility(0);
  }
  
  public void b()
  {
    if ((this.k) && (!this.j)) {
      this.c.findViewById(2131446162).setVisibility(8);
    }
  }
  
  public void b(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", URLUtil.a(QVipProfileMusicBoxProcessor.a().a, "uin", paramString));
    paramContext.startActivity(localIntent);
    int m;
    if (a())
    {
      if (this.k) {
        m = 2;
      } else {
        m = 1;
      }
    }
    else {
      m = 3;
    }
    ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A7D7", m, 0, "", "", "", "");
  }
  
  public void b(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject1 = paramProfileCardInfo.card;
    boolean bool1 = ((Card)localObject1).isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
    boolean bool2 = ((Card)localObject1).isVipOpen(EVIPSPEC.E_SP_BIGCLUB);
    if ((!bool1) && (!bool2)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    this.i = bool1;
    Object localObject2;
    if (TextUtils.isEmpty(((Card)localObject1).songId))
    {
      a(true);
    }
    else
    {
      a(false);
      localObject2 = QQPlayerService.g();
      if ((localObject2 != null) && (((SongInfo)localObject2).c == Long.parseLong(this.a)))
      {
        this.d = ((SongInfo)localObject2);
        a(QQPlayerService.c());
      }
      else
      {
        this.d.e = ((Card)localObject1).songName;
        this.d.g = ((Card)localObject1).coverUrl;
        this.d.j = ((Card)localObject1).singer;
        this.d.i = ((Card)localObject1).songId;
        localObject1 = this.d;
        ((SongInfo)localObject1).m = 10;
        ((SongInfo)localObject1).c = Long.parseLong(this.a);
      }
      a(this.d, ProfileMusicBoxController.b(Long.parseLong(this.a)));
    }
    localObject1 = (TextView)this.c.findViewById(2131447238);
    if (paramProfileCardInfo.allInOne.pa != 0)
    {
      this.l = false;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(ProfileNameUtils.getCurCardName(paramProfileCardInfo));
      ((StringBuilder)localObject2).append(((TextView)localObject1).getContext().getResources().getString(2131892871));
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    }
  }
  
  public void onClick(View paramView)
  {
    b();
    if (this.k) {
      b(paramView.getContext(), this.a);
    } else {
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131446162: 
      case 2131446333: 
        if (this.l)
        {
          ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A7D8", 0, 0, "", "", "", "");
        }
        else
        {
          String str = this.a;
          int m;
          if (a()) {
            m = 1;
          } else {
            m = 2;
          }
          ReportController.b(null, "dc00898", "", str, "qq_vip", "0X800A7DD", m, 0, "", "", "", "");
        }
        if ((!this.i) && (this.l))
        {
          b(paramView.getContext(), this.a);
        }
        else if (ProfileMusicBoxController.b(Long.parseLong(this.a)))
        {
          this.f.q();
          a(2);
        }
        else
        {
          this.f.a(Long.parseLong(this.a), this.d);
        }
        break;
      case 2131435715: 
        c(paramView.getContext(), this.a);
        break;
      case 2131431160: 
      case 2131440714: 
        if (this.l) {
          b(paramView.getContext(), this.a);
        } else {
          c(paramView.getContext(), this.a);
        }
        break;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.musicbox.ProfileMusicBox
 * JD-Core Version:    0.7.0.1
 */