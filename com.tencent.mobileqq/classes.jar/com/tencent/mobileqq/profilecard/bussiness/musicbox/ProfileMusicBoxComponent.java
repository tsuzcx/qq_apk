package com.tencent.mobileqq.profilecard.bussiness.musicbox;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.profile.musicbox.ProfileMusicBox;
import com.tencent.mobileqq.profile.musicbox.ProfileMusicBoxController;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;

public class ProfileMusicBoxComponent
  extends AbsQQProfileContentComponent
{
  private static final String TAG = "ProfileMusicBoxComponent";
  
  public ProfileMusicBoxComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  public String getComponentName()
  {
    return "ProfileMusicBoxComponent";
  }
  
  public int getComponentType()
  {
    return 1017;
  }
  
  public String getProfileContentKey()
  {
    return "map_key_music_box";
  }
  
  public boolean makeOrRefreshMusicBox(Card paramCard)
  {
    if (ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).isDiy()) {
      return true;
    }
    ProfileMusicBox localProfileMusicBox = new ProfileMusicBox(false);
    paramCard = localProfileMusicBox.a(this.mActivity, paramCard.uin);
    paramCard.setTag(2131628450, localProfileMusicBox);
    if (paramCard.getTag(2131628450) != null) {
      ((ProfileMusicBox)paramCard.getTag(2131628450)).b((ProfileCardInfo)this.mData);
    }
    this.mViewContainer = paramCard;
    updateItemTheme(paramCard, (TextView)paramCard.findViewById(2131447238), null, (ImageView)paramCard.findViewById(2131435403));
    return true;
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool2 = super.onDataUpdate(paramProfileCardInfo);
    if (ProfileMusicBox.a((ProfileCardInfo)this.mData)) {
      return bool2 | makeOrRefreshMusicBox(((ProfileCardInfo)this.mData).card);
    }
    boolean bool1;
    if (this.mViewContainer != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mViewContainer = null;
    return bool2 | bool1;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ProfileMusicBoxController localProfileMusicBoxController = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).l();
    if (localProfileMusicBoxController != null) {
      localProfileMusicBoxController.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.musicbox.ProfileMusicBoxComponent
 * JD-Core Version:    0.7.0.1
 */