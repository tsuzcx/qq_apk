package com.tencent.mobileqq.profilecard.base.container;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import java.util.ArrayList;
import java.util.List;

public class ProfileBgContainer
  extends AbsProfileContainer<FrameLayout>
{
  public static final String TAG = "ProfileBgContainer";
  private long mCurStyleId;
  
  public ProfileBgContainer(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private boolean checkReloadChildComponent(ProfileCardInfo paramProfileCardInfo)
  {
    return (paramProfileCardInfo != null) && (this.mCurStyleId != paramProfileCardInfo.curUseStyleId);
  }
  
  protected void destroyChildComponent()
  {
    super.destroyChildComponent();
    this.mCurStyleId = 0L;
  }
  
  protected List<Integer> getChildComponentTypeList()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1003));
    return localArrayList;
  }
  
  protected View getChildComponentViewContainer(int paramInt)
  {
    return (View)this.mViewContainer;
  }
  
  public String getComponentName()
  {
    return "ProfileBgContainer";
  }
  
  public int getComponentType()
  {
    return 104;
  }
  
  protected void initChildComponent()
  {
    super.initChildComponent();
    this.mCurStyleId = ((ProfileCardInfo)this.mData).curUseStyleId;
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    int i;
    if (checkReloadChildComponent(paramProfileCardInfo))
    {
      destroyChildComponent();
      initChildComponent();
      i = 1;
    }
    else
    {
      i = 0;
    }
    return super.onDataUpdate(paramProfileCardInfo) | i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileBgContainer
 * JD-Core Version:    0.7.0.1
 */