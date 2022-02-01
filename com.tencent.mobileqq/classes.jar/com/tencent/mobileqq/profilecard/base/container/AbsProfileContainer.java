package com.tencent.mobileqq.profilecard.base.container;

import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public abstract class AbsProfileContainer<VIEW>
  extends AbsProfileComponent<VIEW>
{
  private static final String TAG = "AbsProfileContainer";
  
  public AbsProfileContainer(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  protected void destroyChildComponent()
  {
    Object localObject = getChildComponentTypeList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        int i = ((Integer)((Iterator)localObject).next()).intValue();
        try
        {
          IComponent localIComponent = getComponent(i);
          if (localIComponent != null)
          {
            removeComponent(localIComponent);
            localIComponent.detachFromComponentCenter();
          }
        }
        catch (Exception localException)
        {
          QLog.e("AbsProfileContainer", 1, "destroyChildComponent fail.", localException);
        }
      }
    }
  }
  
  protected List<Integer> getChildComponentTypeList()
  {
    return null;
  }
  
  protected View getChildComponentViewContainer(int paramInt)
  {
    return null;
  }
  
  protected void initChildComponent()
  {
    Object localObject = getChildComponentTypeList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        int i = ((Integer)((Iterator)localObject).next()).intValue();
        try
        {
          View localView = getChildComponentViewContainer(i);
          AbsProfileComponent localAbsProfileComponent = ProfileUtils.create(i, this.mComponentCenter, (ProfileCardInfo)this.mData, this.mDelegate);
          localAbsProfileComponent.setContainerView(localView);
          localAbsProfileComponent.attachToComponentCenter();
          addComponent(localAbsProfileComponent);
        }
        catch (Exception localException)
        {
          QLog.e("AbsProfileContainer", 1, "initChildComponent fail.", localException);
        }
      }
    }
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    initChildComponent();
  }
  
  public void onDestroy()
  {
    destroyChildComponent();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.AbsProfileContainer
 * JD-Core Version:    0.7.0.1
 */