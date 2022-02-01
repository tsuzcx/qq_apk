package com.tencent.mobileqq.guild.profilecard.baseprofile.framework.controller;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profilecard.baseprofile.framework.component.AbsGuildProfileComponent;
import com.tencent.mobileqq.guild.profilecard.baseprofile.framework.component.IComponentLifecycle;

public abstract class IGuildComponentController
  implements IComponentLifecycle<GuildProfileData>, IComponentAction
{
  public abstract void addComponent(AbsGuildProfileComponent paramAbsGuildProfileComponent);
  
  public abstract AbsGuildProfileComponent createComponent(int paramInt, GuildProfileData paramGuildProfileData);
  
  public abstract AbsGuildProfileComponent getComponent(int paramInt);
  
  public abstract ViewGroup getContentViewContainer();
  
  public abstract IGuildComponentController.IDelegateCallback getDelegate();
  
  public abstract void init(Fragment paramFragment, GuildProfileData paramGuildProfileData, IGuildComponentController.IDelegateCallback paramIDelegateCallback);
  
  public abstract void removeComponent(AbsGuildProfileComponent paramAbsGuildProfileComponent);
  
  public abstract void setContentViewContainer(ViewGroup paramViewGroup);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.baseprofile.framework.controller.IGuildComponentController
 * JD-Core Version:    0.7.0.1
 */