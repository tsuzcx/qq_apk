package com.tencent.mobileqq.guild.profilecard.baseprofile.framework.component;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profilecard.baseprofile.framework.controller.IGuildComponentController;
import com.tencent.qphone.base.util.QLog;

public abstract class AbsGuildProfileComponent
  implements IGuildProfileComponent<View, GuildProfileData>
{
  protected static final boolean LOG_ENABLE = false;
  private static final String TAG = "AbsGuildProfileComponent";
  protected AppInterface mApp;
  protected IGuildComponentController mComponentController;
  protected GuildProfileData mData;
  protected Fragment mFragment;
  protected ViewGroup mViewContainer;
  
  public AbsGuildProfileComponent(IGuildComponentController paramIGuildComponentController, GuildProfileData paramGuildProfileData)
  {
    this.mComponentController = paramIGuildComponentController;
    this.mData = paramGuildProfileData;
  }
  
  public void attachToComponentController()
  {
    IGuildComponentController localIGuildComponentController = this.mComponentController;
    if (localIGuildComponentController != null) {
      localIGuildComponentController.addComponent(this);
    }
  }
  
  public void detachFromComponentController()
  {
    IGuildComponentController localIGuildComponentController = this.mComponentController;
    if (localIGuildComponentController != null) {
      localIGuildComponentController.removeComponent(this);
    }
  }
  
  public IGuildComponentController getComponentController()
  {
    return this.mComponentController;
  }
  
  public View getContainerView()
  {
    return this.mViewContainer;
  }
  
  public void onCreate(Fragment paramFragment, AppInterface paramAppInterface, Bundle paramBundle)
  {
    this.mFragment = paramFragment;
    this.mApp = paramAppInterface;
    if (this.mFragment == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("AbsGuildProfileComponent", 1, "mFragment is null!");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AbsGuildProfileComponent", 1, String.format("getComponentType: %d, %s", new Object[] { Integer.valueOf(getComponentType()), this.mViewContainer }));
    }
    this.mViewContainer = ((ViewGroup)this.mFragment.getActivity().getLayoutInflater().inflate(getContentLayoutId(), null));
  }
  
  public void onDestroy() {}
  
  public void onInitData(GuildProfileData paramGuildProfileData) {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public String toString()
  {
    return String.format("Component@%s{componentType=%s componentName=%s}", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getComponentType()), getComponentName() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
 * JD-Core Version:    0.7.0.1
 */