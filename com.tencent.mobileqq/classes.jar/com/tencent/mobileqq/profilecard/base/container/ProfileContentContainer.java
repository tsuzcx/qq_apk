package com.tencent.mobileqq.profilecard.base.container;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProfileContentContainer
  extends AbsProfileContainer<ProfileContentView>
{
  public static final String TAG = "ProfileContentContainer";
  
  public ProfileContentContainer(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private boolean checkValidComponent(AbsProfileContentComponent paramAbsProfileContentComponent, ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool3 = paramProfileCardInfo.isTroopMemberCard;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (((ITroopInfoService)this.mApp.getRuntimeService(ITroopInfoService.class, "")).isQidianPrivateTroop(paramProfileCardInfo.troopUin))
      {
        paramAbsProfileContentComponent = paramAbsProfileContentComponent.getProfileContentKey();
        paramProfileCardInfo = IProfileContentKey.KEY_MAP_QIDIAN_PRIVATE_TROOP;
        int j = paramProfileCardInfo.length;
        int i = 0;
        while (i < j)
        {
          if (TextUtils.equals(paramAbsProfileContentComponent, paramProfileCardInfo[i])) {
            return true;
          }
          i += 1;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  protected List<Integer> getChildComponentTypeList()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1005));
    localArrayList.add(Integer.valueOf(1006));
    localArrayList.add(Integer.valueOf(1007));
    localArrayList.add(Integer.valueOf(1008));
    localArrayList.add(Integer.valueOf(1009));
    localArrayList.add(Integer.valueOf(1035));
    localArrayList.add(Integer.valueOf(1011));
    localArrayList.add(Integer.valueOf(1010));
    localArrayList.add(Integer.valueOf(1012));
    localArrayList.add(Integer.valueOf(1013));
    localArrayList.add(Integer.valueOf(1014));
    localArrayList.add(Integer.valueOf(1015));
    localArrayList.add(Integer.valueOf(1016));
    localArrayList.add(Integer.valueOf(1017));
    localArrayList.add(Integer.valueOf(1018));
    localArrayList.add(Integer.valueOf(1019));
    localArrayList.add(Integer.valueOf(1021));
    localArrayList.add(Integer.valueOf(1023));
    localArrayList.add(Integer.valueOf(1026));
    localArrayList.add(Integer.valueOf(1027));
    localArrayList.add(Integer.valueOf(1028));
    localArrayList.add(Integer.valueOf(1029));
    localArrayList.add(Integer.valueOf(1030));
    localArrayList.add(Integer.valueOf(1032));
    localArrayList.add(Integer.valueOf(1033));
    return localArrayList;
  }
  
  public String getComponentName()
  {
    return "ProfileContentContainer";
  }
  
  public int getComponentType()
  {
    return 103;
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileContentContainer", 2, String.format("onDateUpdate this=%s", new Object[] { this }));
    }
    this.mData = paramProfileCardInfo;
    int j = this.mChildComponent.size();
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2)
    {
      Object localObject = (AbsProfileContentComponent)this.mChildComponent.valueAt(i);
      bool2 = bool1;
      if (localObject != null) {
        if (!checkValidComponent((AbsProfileContentComponent)localObject, (ProfileCardInfo)this.mData))
        {
          bool2 = bool1;
        }
        else
        {
          try
          {
            bool2 = ((AbsProfileContentComponent)localObject).onDataUpdate(paramProfileCardInfo);
          }
          catch (Exception localException)
          {
            QLog.e("ProfileContentContainer", 1, "onDataUpdate fail.", localException);
            bool2 = false;
          }
          String str = ((AbsProfileContentComponent)localObject).getProfileContentKey();
          View localView = (View)((AbsProfileContentComponent)localObject).getContainerView();
          if (localView != null) {
            localObject = localView.getParent();
          } else {
            localObject = null;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ProfileContentContainer", 2, String.format("onDataUpdate update=%s key=%s view=%s viewParent=%s", new Object[] { Boolean.valueOf(bool2), str, localView, localObject }));
          }
          if (bool2)
          {
            localObject = ((ProfileContentView)this.mViewContainer).getMoreInfoMap();
            if (localView == null) {
              ((HashMap)localObject).remove(str);
            } else {
              ((HashMap)localObject).put(str, localView);
            }
          }
          bool2 = bool1 | bool2;
        }
      }
      i += 1;
    }
    if (bool1) {
      ((ProfileContentView)this.mViewContainer).rebuildProfileContent((ProfileCardInfo)this.mData);
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileContentContainer
 * JD-Core Version:    0.7.0.1
 */