package com.tencent.mobileqq.profilecard.vas.component.baseinfo;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.profilecard.vas.view.ProfileBaseInfoView;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/vas/component/baseinfo/ProfileBaseInfoComponent;", "Lcom/tencent/mobileqq/profilecard/base/component/AbsProfileContentComponent;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "cardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "(Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;)V", "TAG", "", "childComponentArray", "", "checkValidComponent", "", "component", "destroyChildComponent", "", "getChildComponentTypeList", "", "", "getComponentName", "getComponentType", "getProfileContentKey", "initChildComponent", "onChildComponentDataUpdate", "onCreate", "activity", "Lcom/tencent/mobileqq/app/QBaseActivity;", "savedInstanceState", "Landroid/os/Bundle;", "onDataUpdate", "data", "onDestroy", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ProfileBaseInfoComponent
  extends AbsProfileContentComponent
{
  private final String TAG = "ProfileBaseInfoComponent";
  private final int[] childComponentArray = { 1032, 1023, 1033, 1011, 1013, 1021, 1019 };
  
  public ProfileBaseInfoComponent(@Nullable IComponentCenter paramIComponentCenter, @Nullable ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private final boolean checkValidComponent(AbsProfileContentComponent paramAbsProfileContentComponent, ProfileCardInfo paramProfileCardInfo)
  {
    if (!paramProfileCardInfo.isTroopMemberCard) {
      return true;
    }
    IRuntimeService localIRuntimeService = this.mApp.getRuntimeService(ITroopInfoService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localIRuntimeService, "mApp.getRuntimeService(I…va, ProcessConstant.MAIN)");
    if (!((ITroopInfoService)localIRuntimeService).isQidianPrivateTroop(paramProfileCardInfo.troopUin)) {
      return true;
    }
    paramAbsProfileContentComponent = paramAbsProfileContentComponent.getProfileContentKey();
    paramProfileCardInfo = IProfileContentKey.KEY_MAP_QIDIAN_PRIVATE_TROOP;
    int j = paramProfileCardInfo.length;
    int i = 0;
    while (i < j)
    {
      localIRuntimeService = paramProfileCardInfo[i];
      if (TextUtils.equals((CharSequence)paramAbsProfileContentComponent, (CharSequence)localIRuntimeService)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private final void destroyChildComponent()
  {
    Iterator localIterator = getChildComponentTypeList().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Number)localIterator.next()).intValue();
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
        QLog.e(this.TAG, 1, "destroyChildComponent fail.", (Throwable)localException);
      }
    }
  }
  
  private final List<Integer> getChildComponentTypeList()
  {
    List localList = (List)new ArrayList();
    int[] arrayOfInt = this.childComponentArray;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localList.add(Integer.valueOf(arrayOfInt[i]));
      i += 1;
    }
    return localList;
  }
  
  private final void initChildComponent()
  {
    Iterator localIterator = getChildComponentTypeList().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Number)localIterator.next()).intValue();
      try
      {
        AbsProfileComponent localAbsProfileComponent2 = ProfileUtils.create(i, this.mComponentCenter, (ProfileCardInfo)this.mData, this.mDelegate);
        Intrinsics.checkExpressionValueIsNotNull(localAbsProfileComponent2, "ProfileUtils.create(comp…Center, mData, mDelegate)");
        localAbsProfileComponent2.attachToComponentCenter();
        AbsProfileComponent localAbsProfileComponent1 = localAbsProfileComponent2;
        if (!(localAbsProfileComponent2 instanceof IComponent)) {
          localAbsProfileComponent1 = null;
        }
        addComponent((IComponent)localAbsProfileComponent1);
      }
      catch (Exception localException)
      {
        QLog.e(this.TAG, 1, "initChildComponent fail.", (Throwable)localException);
      }
    }
  }
  
  private final boolean onChildComponentDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.TAG;
      localObject2 = StringCompanionObject.INSTANCE;
      localObject2 = new Object[1];
      localObject2[0] = this;
      localObject2 = String.format("onDateUpdate this=%s", Arrays.copyOf((Object[])localObject2, localObject2.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "java.lang.String.format(format, *args)");
      QLog.d((String)localObject1, 2, (String)localObject2);
    }
    if (!(this.mViewContainer instanceof ProfileBaseInfoView)) {
      return false;
    }
    this.mData = paramProfileCardInfo;
    int j = this.mChildComponent.size();
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2)
    {
      localObject1 = this.mChildComponent.valueAt(i);
      bool2 = localObject1 instanceof AbsProfileContentComponent;
      localObject2 = null;
      if (!bool2) {
        localObject1 = null;
      }
      localObject1 = (AbsProfileContentComponent)localObject1;
      bool2 = bool1;
      if (localObject1 != null)
      {
        Object localObject3 = this.mData;
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "mData");
        if (!checkValidComponent((AbsProfileContentComponent)localObject1, (ProfileCardInfo)localObject3))
        {
          bool2 = bool1;
        }
        else
        {
          try
          {
            bool2 = ((AbsProfileContentComponent)localObject1).onDataUpdate(paramProfileCardInfo);
          }
          catch (Exception localException)
          {
            QLog.e(this.TAG, 1, "onDataUpdate fail.", (Throwable)localException);
            bool2 = true;
          }
          String str = ((AbsProfileContentComponent)localObject1).getProfileContentKey();
          View localView = (View)((AbsProfileContentComponent)localObject1).getContainerView();
          localObject1 = localObject2;
          if (localView != null) {
            localObject1 = localView.getParent();
          }
          if (QLog.isColorLevel())
          {
            localObject2 = this.TAG;
            Object localObject4 = StringCompanionObject.INSTANCE;
            localObject4 = new Object[4];
            localObject4[0] = Boolean.valueOf(bool2);
            localObject4[1] = str;
            localObject4[2] = localView;
            localObject4[3] = localObject1;
            localObject1 = String.format("onDataUpdate update=%s key=%s view=%s viewParent=%s", Arrays.copyOf((Object[])localObject4, localObject4.length));
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
            QLog.d((String)localObject2, 2, (String)localObject1);
          }
          if (bool2)
          {
            localObject1 = this.mViewContainer;
            if (localObject1 != null)
            {
              localObject1 = ((ProfileBaseInfoView)localObject1).getMoreInfoMap();
              if (localView == null)
              {
                ((HashMap)localObject1).remove(str);
              }
              else
              {
                Intrinsics.checkExpressionValueIsNotNull(localObject1, "moreInfoMap");
                ((Map)localObject1).put(str, localView);
              }
            }
            else
            {
              throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.profilecard.vas.view.ProfileBaseInfoView");
            }
          }
          bool2 |= bool1;
        }
      }
      i += 1;
    }
    if (bool1)
    {
      paramProfileCardInfo = this.mViewContainer;
      if (paramProfileCardInfo != null)
      {
        ((ProfileBaseInfoView)paramProfileCardInfo).rebuildProfileContent((ProfileCardInfo)this.mData);
        return bool1;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.profilecard.vas.view.ProfileBaseInfoView");
    }
    return bool1;
  }
  
  @NotNull
  public String getComponentName()
  {
    return this.TAG;
  }
  
  public int getComponentType()
  {
    return 1035;
  }
  
  @NotNull
  public String getProfileContentKey()
  {
    return "map_key_base_info";
  }
  
  public void onCreate(@Nullable QBaseActivity paramQBaseActivity, @Nullable Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    paramQBaseActivity = new ProfileBaseInfoView((Context)paramQBaseActivity);
    paramQBaseActivity.setOrientation(1);
    setContainerView(paramQBaseActivity);
    initChildComponent();
  }
  
  public boolean onDataUpdate(@NotNull ProfileCardInfo paramProfileCardInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramProfileCardInfo, "data");
    Object localObject2;
    if (ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).isDiy())
    {
      localObject1 = (View)getContainerView();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "containerView");
      localObject2 = (ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ViewGroup.MarginLayoutParams(-1, -1);
      }
      ((ViewGroup.MarginLayoutParams)localObject1).setMargins(ViewUtils.dip2px(11.0F), ViewUtils.dip2px(11.0F), ViewUtils.dip2px(11.0F), ViewUtils.dip2px(11.0F));
      localObject2 = (View)getContainerView();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "containerView");
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    else
    {
      localObject1 = (View)getContainerView();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "containerView");
      localObject2 = (ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ViewGroup.MarginLayoutParams(-1, -1);
      }
      ((ViewGroup.MarginLayoutParams)localObject1).setMargins(0, 0, 0, 0);
      localObject2 = (View)getContainerView();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "containerView");
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    Object localObject1 = ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter);
    if (((IDiyMoreInfoManager)localObject1).isDiy()) {
      ((IDiyMoreInfoManager)localObject1).updateBaseInfoForDeepDiy((View)getContainerView());
    }
    return onChildComponentDataUpdate(paramProfileCardInfo);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    destroyChildComponent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.baseinfo.ProfileBaseInfoComponent
 * JD-Core Version:    0.7.0.1
 */