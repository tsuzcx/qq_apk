package com.tencent.mobileqq.profilecard.bussiness.musicbox;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.musicbox.ProfileMusicBox;
import com.tencent.mobileqq.profile.musicbox.ProfileMusicBoxController;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.vas.misc.DiyMoreInfoViewHelper;

public class ProfileMusicBoxComponent
  extends AbsProfileContentComponent
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
    if (ProfileCardTemplate.a(((ProfileCardInfo)this.mData).a.lCurrentStyleId)) {
      return true;
    }
    Object localObject;
    boolean bool;
    if (0 == 0)
    {
      localObject = this.mDiyHelper.getDiyView("map_key_music_box");
      if (localObject != null) {
        bool = true;
      }
    }
    for (;;)
    {
      if (localObject == null)
      {
        localObject = new ProfileMusicBox(false);
        paramCard = ((ProfileMusicBox)localObject).a(this.mActivity, paramCard.uin);
        paramCard.setTag(2131562187, localObject);
        bool = true;
      }
      for (;;)
      {
        if (paramCard.getTag(2131562187) != null) {
          ((ProfileMusicBox)paramCard.getTag(2131562187)).a((ProfileCardInfo)this.mData);
        }
        this.mViewContainer = paramCard;
        updateItemTheme((TextView)paramCard.findViewById(2131379248), null, (ImageView)paramCard.findViewById(2131368771));
        return bool;
        paramCard = (Card)localObject;
      }
      bool = false;
      continue;
      localObject = null;
      bool = false;
    }
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool2 = super.onDataUpdate(paramProfileCardInfo);
    if (ProfileMusicBox.a((ProfileCardInfo)this.mData)) {
      return makeOrRefreshMusicBox(((ProfileCardInfo)this.mData).a) | bool2;
    }
    if (this.mViewContainer != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.mViewContainer = null;
      return bool1 | bool2;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ProfileMusicBoxController localProfileMusicBoxController = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
    if (localProfileMusicBoxController != null) {
      localProfileMusicBoxController.a(null);
    }
    this.mDiyHelper.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.musicbox.ProfileMusicBoxComponent
 * JD-Core Version:    0.7.0.1
 */