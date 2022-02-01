package com.tencent.mobileqq.profilecard.base.container;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import java.util.ArrayList;
import java.util.List;

public class ProfileFgContainer
  extends AbsProfileContainer<FrameLayout>
{
  public static final String TAG = "ProfileFgContainer";
  
  public ProfileFgContainer(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  protected List<Integer> getChildComponentTypeList()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1004));
    localArrayList.add(Integer.valueOf(1020));
    localArrayList.add(Integer.valueOf(1025));
    localArrayList.add(Integer.valueOf(1031));
    return localArrayList;
  }
  
  protected View getChildComponentViewContainer(int paramInt)
  {
    return (View)this.mViewContainer;
  }
  
  public String getComponentName()
  {
    return "ProfileFgContainer";
  }
  
  public int getComponentType()
  {
    return 105;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileFgContainer
 * JD-Core Version:    0.7.0.1
 */