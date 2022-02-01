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
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private SongInfo jdField_a_of_type_ComTencentMobileqqMusicSongInfo = new SongInfo();
  private ProfileMusicBoxController jdField_a_of_type_ComTencentMobileqqProfileMusicboxProfileMusicBoxController;
  private AlphaClickableImageView jdField_a_of_type_ComTencentWidgetAlphaClickableImageView;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  private boolean d = false;
  private boolean e = true;
  
  public ProfileMusicBox(boolean paramBoolean)
  {
    this.c = paramBoolean;
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
        i = 0;
        if (i < localGetProfileMusicBoxInfoRsp.music.singer_list.size())
        {
          if (i != 0) {
            paramCommTaskInfo.append("/");
          }
          paramCommTaskInfo.append(((VipMusicBox.ProfileSingerInfo)localGetProfileMusicBoxInfoRsp.music.singer_list.get(i)).singer_name.get());
          i += 1;
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
            i = 2;
            ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A7D6", i, 0, "", "", "", "");
            return;
          }
          paramCommTaskInfo = paramCard.uin;
          if (!a()) {
            break label341;
          }
          i = 1;
          ReportController.b(null, "dc00898", "", paramCommTaskInfo, "qq_vip", "0X800A7DC", i, 0, "", "", "", "");
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramCommTaskInfo)
      {
        paramCommTaskInfo.printStackTrace();
      }
      return;
      label331:
      int i = 1;
      continue;
      label336:
      i = 3;
      continue;
      label341:
      i = 2;
    }
  }
  
  public static boolean a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    return (VasUtil.a(localAppRuntime).getVipStatus().isSVip()) || (VasUtil.a(localAppRuntime).getVipStatus().isBigClub());
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
      int i;
      if (paramProfileCardInfo.card.switchMusicBox == 0) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800A7DB", "qq_vip", i, 0, "", "", "", "");
      if (paramProfileCardInfo.card.switchMusicBox == 0) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = paramProfileCardInfo.card.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
    boolean bool2 = paramProfileCardInfo.card.isVipOpen(EVIPSPEC.E_SP_BIGCLUB);
    return (paramProfileCardInfo.card.switchMusicBox == 0) && (!TextUtils.isEmpty(paramProfileCardInfo.card.songId)) && ((bool1) || (bool2));
  }
  
  public static void b(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    paramString = URLUtil.a(QVipProfileMusicBoxProcessor.a().jdField_b_of_type_JavaLangString, "uin", paramString);
    localIntent.setFlags(268435456);
    localIntent.putExtra("url", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public View a(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131562024, null);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    if (this.c)
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131368794).setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131377856).setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView = ((AlphaClickableImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377856));
      this.jdField_a_of_type_AndroidViewView.findViewById(2131377706).setVisibility(8);
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131377706).setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131368794).setVisibility(8);
    }
    a(2);
    this.jdField_a_of_type_Int = AIOUtils.b(35.0F, paramContext.getResources());
    if (this.jdField_a_of_type_ComTencentMobileqqProfileMusicboxProfileMusicBoxController == null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileMusicboxProfileMusicBoxController = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileMusicboxProfileMusicBoxController.a(this);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if ((this.d) && (!this.c)) {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131377706).setVisibility(8);
    }
  }
  
  @SuppressLint({"NewApi"})
  public void a(int paramInt)
  {
    if (this.c)
    {
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setImageResource(2130844797);
        this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setContentDescription("暂停音乐");
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setImageResource(2130844798);
      this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setContentDescription("播放音乐");
      return;
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377706);
    localTextView.setCompoundDrawablePadding(ViewUtils.b(4.0F));
    if (paramInt == 1)
    {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(2130850619, 0, 0, 0);
      return;
    }
    localTextView.setCompoundDrawablesWithIntrinsicBounds(2130850620, 0, 0, 0);
  }
  
  public void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", URLUtil.a(QVipProfileMusicBoxProcessor.a().jdField_a_of_type_JavaLangString, "uin", paramString));
    paramContext.startActivity(localIntent);
    int i;
    if (a())
    {
      if (this.d) {
        i = 2;
      } else {
        i = 1;
      }
    }
    else {
      i = 3;
    }
    ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A7D7", i, 0, "", "", "", "");
  }
  
  public void a(SongInfo paramSongInfo, boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update :");
      ((StringBuilder)localObject).append(paramSongInfo.c);
      QLog.e("ProfileMusicBox", 2, ((StringBuilder)localObject).toString());
    }
    if (paramSongInfo.jdField_b_of_type_Long != Long.parseLong(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo = paramSongInfo;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.c)
    {
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377705)).setText(paramSongInfo.c);
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377704)).setText(paramSongInfo.h);
      a(paramSongInfo.e);
      return;
    }
    Object localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377706);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramSongInfo.c);
    localStringBuilder.append("-");
    localStringBuilder.append(paramSongInfo.h);
    ((TextView)localObject).setText(localStringBuilder.toString());
    if (this.jdField_a_of_type_Boolean) {
      i = 1;
    }
    a(i);
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject1 = paramProfileCardInfo.card;
    boolean bool1 = ((Card)localObject1).isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
    boolean bool2 = ((Card)localObject1).isVipOpen(EVIPSPEC.E_SP_BIGCLUB);
    if ((!bool1) && (!bool2)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    this.jdField_b_of_type_Boolean = bool1;
    Object localObject2;
    if (TextUtils.isEmpty(((Card)localObject1).songId))
    {
      a(true);
    }
    else
    {
      a(false);
      localObject2 = QQPlayerService.b();
      if ((localObject2 != null) && (((SongInfo)localObject2).jdField_b_of_type_Long == Long.parseLong(this.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo = ((SongInfo)localObject2);
        a(QQPlayerService.a());
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo.c = ((Card)localObject1).songName;
        this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo.e = ((Card)localObject1).coverUrl;
        this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo.h = ((Card)localObject1).singer;
        this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo.g = ((Card)localObject1).songId;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
        ((SongInfo)localObject1).jdField_b_of_type_Int = 10;
        ((SongInfo)localObject1).jdField_b_of_type_Long = Long.parseLong(this.jdField_a_of_type_JavaLangString);
      }
      a(this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo, ProfileMusicBoxController.a(Long.parseLong(this.jdField_a_of_type_JavaLangString)));
    }
    localObject1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378609);
    if (paramProfileCardInfo.allInOne.pa != 0)
    {
      this.e = false;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(ProfileNameUtils.getCurCardName(paramProfileCardInfo));
      ((StringBuilder)localObject2).append(((TextView)localObject1).getContext().getResources().getString(2131695143));
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_JavaLangString.equals(paramString)) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130844796);
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130844796);
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    int i = 1;
    paramString.setTag(new int[] { this.jdField_a_of_type_Int / 2 });
    paramString.setDecodeHandler(URLDrawableDecodeHandler.y);
    paramString.startDownload();
    this.jdField_a_of_type_AndroidViewView.findViewById(2131377856).setBackgroundDrawable(paramString);
    if (!this.jdField_a_of_type_Boolean) {
      i = 2;
    }
    a(i);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if (!this.c)
    {
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377706);
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
      this.jdField_a_of_type_AndroidViewView.findViewById(2131366232).setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131377856).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131371621).setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.findViewById(2131366232).setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131377856).setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131371621).setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    a();
    if (this.d) {
      a(paramView.getContext(), this.jdField_a_of_type_JavaLangString);
    } else {
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131377706: 
      case 2131377856: 
        if (this.e)
        {
          ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A7D8", 0, 0, "", "", "", "");
        }
        else
        {
          String str = this.jdField_a_of_type_JavaLangString;
          int i;
          if (a()) {
            i = 1;
          } else {
            i = 2;
          }
          ReportController.b(null, "dc00898", "", str, "qq_vip", "0X800A7DD", i, 0, "", "", "", "");
        }
        if ((!this.jdField_b_of_type_Boolean) && (this.e))
        {
          a(paramView.getContext(), this.jdField_a_of_type_JavaLangString);
        }
        else if (ProfileMusicBoxController.a(Long.parseLong(this.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_ComTencentMobileqqProfileMusicboxProfileMusicBoxController.n();
          a(2);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqProfileMusicboxProfileMusicBoxController.a(Long.parseLong(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo);
        }
        break;
      case 2131368794: 
        b(paramView.getContext(), this.jdField_a_of_type_JavaLangString);
        break;
      case 2131365027: 
      case 2131373111: 
        if (this.e) {
          a(paramView.getContext(), this.jdField_a_of_type_JavaLangString);
        } else {
          b(paramView.getContext(), this.jdField_a_of_type_JavaLangString);
        }
        break;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.musicbox.ProfileMusicBox
 * JD-Core Version:    0.7.0.1
 */