package com.tencent.mobileqq.multicard;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.navigate.TroopDNANavBar;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.multicard.manager.TroopMemberRecommendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MultiCardContainer
  implements View.OnClickListener, MultiCardManager.GetGroupIntimateInfoListListener, MultiCardManager.GetGroupMemberNickListener, MultiCardManager.GetGroupRecommendUinListsListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public Context a;
  private View jdField_a_of_type_AndroidViewView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SimpleSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
  public BaseActivity a;
  public QQAppInterface a;
  MultiCardFragment jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment;
  MultiCardManager jdField_a_of_type_ComTencentMobileqqMulticardMultiCardManager;
  MultiCardRecommendFragment jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment;
  private Long jdField_a_of_type_JavaLangLong;
  public boolean a;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public MultiCardContainer(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MultiCardContainer, groopuin :");
      localStringBuilder.append(paramString);
      QLog.d("MultiCardContainer", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    try
    {
      this.jdField_a_of_type_Long = Long.valueOf(paramString).longValue();
    }
    catch (Exception localException)
    {
      label76:
      int j;
      int i;
      break label76;
    }
    this.jdField_a_of_type_Long = 0L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MultiCardContainer troopuinerror:");
    localStringBuilder.append(paramString);
    QLog.d("MultiCardContainer", 2, localStringBuilder.toString());
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131562988, null);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376828));
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(paramBaseActivity.getResources().getDrawable(2130840528));
    }
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131378886);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363340));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379784));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator = ((SimpleSlidingIndicator)this.jdField_a_of_type_AndroidViewView.findViewById(2131377670));
    a(paramQQAppInterface, paramContext, String.valueOf(this.jdField_a_of_type_Long));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new MultiCardContainer.1(this));
    if (AppSetting.d) {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131707032));
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBaseActivity = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      j = ImmersiveUtils.getStatusBarHeight(paramContext);
      i = j;
      if (b()) {
        i = j - AIOUtils.b(10.0F, this.jdField_b_of_type_AndroidViewView.getResources());
      }
      paramBaseActivity.setMargins(0, i, 0, 0);
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramBaseActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardManager = ((MultiCardManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_MULTI_CARD_MANAGER));
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment == null) {
        return;
      }
      FragmentTransaction localFragmentTransaction = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSupportFragmentManager().beginTransaction();
      this.jdField_a_of_type_Int = paramInt;
      Object localObject;
      StringBuilder localStringBuilder;
      if (paramInt != 0)
      {
        if (paramInt != 1) {
          return;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.isAdded())
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSupportFragmentManager();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_a_of_type_Int);
          localStringBuilder.append("");
          if (((FragmentManager)localObject).findFragmentByTag(localStringBuilder.toString()) == null)
          {
            localFragmentTransaction = localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment);
            localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.jdField_a_of_type_Int);
            localStringBuilder.append("");
            localFragmentTransaction.add(2131366905, (Fragment)localObject, localStringBuilder.toString()).commit();
            break label180;
          }
        }
        localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment).show(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment).commit();
        label180:
        TroopRecommendReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment.isAdded())
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSupportFragmentManager();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append("");
        if (((FragmentManager)localObject).findFragmentByTag(localStringBuilder.toString()) == null)
        {
          localFragmentTransaction = localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment);
          localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_a_of_type_Int);
          localStringBuilder.append("");
          localFragmentTransaction.add(2131366905, (Fragment)localObject, localStringBuilder.toString()).commit();
          return;
        }
      }
      localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment).show(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment).commit();
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    this.jdField_a_of_type_Boolean = TroopMemberRecommendManager.a(paramQQAppInterface).a(paramString);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setTabData(new String[] { paramContext.getResources().getString(2131719968), paramContext.getResources().getString(2131719969) }, new int[] { 0, 1 });
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setOnTabListener(new MultiCardContainer.2(this));
  }
  
  private void b(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      localView = localView.findViewById(2131379649);
      if (localView != null)
      {
        int i;
        if (paramBoolean) {
          i = 0;
        } else {
          i = 8;
        }
        localView.setVisibility(i);
      }
    }
  }
  
  private boolean b()
  {
    return (Build.VERSION.SDK_INT == 28) && ("samsung".equals(Build.MANUFACTURER)) && ("SM-G9750".equals(Build.MODEL));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardContainer", 2, "initCardFragment");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiCardContainer", 2, "initCardFragment, mainfragment is not null");
      }
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A212", "0X800A212", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment = new MultiCardFragment();
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_Long), this);
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment = new MultiCardRecommendFragment();
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_Long));
    try
    {
      Object localObject1;
      if (this.jdField_a_of_type_Int == 0) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment;
      } else {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment;
      }
      if (!((PublicBaseFragment)localObject1).isAdded())
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSupportFragmentManager();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append("");
        if (((FragmentManager)localObject3).findFragmentByTag(localStringBuilder.toString()) == null)
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSupportFragmentManager().beginTransaction();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_a_of_type_Int);
          localStringBuilder.append("");
          ((FragmentTransaction)localObject3).add(2131366905, (Fragment)localObject1, localStringBuilder.toString());
          ((FragmentTransaction)localObject3).commitAllowingStateLoss();
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("initCardFragment exception:");
      ((StringBuilder)localObject3).append(localException.toString());
      QLog.e("MultiCardContainer", 2, ((StringBuilder)localObject3).toString());
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardManager;
    if (localObject2 != null) {
      ((MultiCardManager)localObject2).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Long, this);
    }
    int i = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).getInt(TroopDNANavBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 0);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" guideCount = ");
      ((StringBuilder)localObject2).append(i);
      QLog.d("MultiCardContainer", 2, ((StringBuilder)localObject2).toString());
    }
    if (i < 3) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      this.jdField_a_of_type_Int = 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(this.jdField_a_of_type_Int, false);
    if (this.jdField_a_of_type_Int == 1) {
      TroopRecommendReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void a(long paramLong, ArrayList<Long> paramArrayList)
  {
    if (this.jdField_a_of_type_Long != paramLong) {
      return;
    }
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      b(false);
      MultiCardFragment localMultiCardFragment = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment;
      if (localMultiCardFragment != null) {
        localMultiCardFragment.a(paramArrayList, null, null);
      }
      return;
    }
    b(true);
    a(null);
  }
  
  public void a(long paramLong, HashMap<Long, String> paramHashMap)
  {
    if (this.jdField_a_of_type_Long == paramLong)
    {
      if (paramHashMap == null) {
        return;
      }
      MultiCardFragment localMultiCardFragment = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment;
      if (localMultiCardFragment != null) {
        localMultiCardFragment.a(null, null, paramHashMap);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      paramString = this.jdField_b_of_type_AndroidWidgetTextView;
      if (paramString != null) {
        paramString.setText(null);
      }
    }
  }
  
  public void a(ArrayList<Long> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramArrayList == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onPreLoadData : ");
      ((StringBuilder)localObject1).append(paramArrayList.size());
      ((StringBuilder)localObject1).append("  ");
      Object localObject2 = paramArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ((StringBuilder)localObject1).append((Long)((Iterator)localObject2).next());
        ((StringBuilder)localObject1).append(" ");
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onPreLoadData : ");
      ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
      QLog.d("MultiCardContainer", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardManager;
    if (localObject1 != null)
    {
      if (paramBoolean1) {
        ((MultiCardManager)localObject1).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Long, paramArrayList, this);
      }
      if (paramBoolean2) {
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardManager.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Long, paramArrayList, this);
      }
    }
  }
  
  public void a(HashMap<Long, IntimateInfo> paramHashMap)
  {
    MultiCardFragment localMultiCardFragment = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment;
    if (localMultiCardFragment != null) {
      localMultiCardFragment.a(null, paramHashMap, null);
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    MultiCardFragment localMultiCardFragment = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment;
    if ((localMultiCardFragment != null) && (!localMultiCardFragment.onBackEvent())) {
      a(true);
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardContainer", 2, "initData");
    }
    MultiCardManager localMultiCardManager = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardManager;
    if (localMultiCardManager != null) {
      localMultiCardManager.a(this.jdField_a_of_type_Long);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardContainer", 2, "unInitCardFragment");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if (localObject != null)
    {
      try
      {
        localObject = ((BaseActivity)localObject).getSupportFragmentManager().beginTransaction();
        if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment != null) {
          ((FragmentTransaction)localObject).remove(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment != null) {
          ((FragmentTransaction)localObject).remove(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment);
        }
        ((FragmentTransaction)localObject).commitAllowingStateLoss();
        if (QLog.isColorLevel()) {
          QLog.d("MultiCardContainer", 2, "unInitCardFragment succ");
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("unInitCardFragment excption:");
          localStringBuilder.append(localException);
          QLog.d("MultiCardContainer", 2, localStringBuilder.toString());
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment = null;
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment = null;
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardContainer", 2, "onDestroy");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.c();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setOnTabListener(null);
    c();
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment = null;
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment = null;
    MultiCardManager localMultiCardManager = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardManager;
    if (localMultiCardManager != null)
    {
      localMultiCardManager.b(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardManager = null;
    }
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void e()
  {
    a(false);
  }
  
  public void onClick(View paramView)
  {
    long l = SystemClock.elapsedRealtime();
    Long localLong = this.jdField_a_of_type_JavaLangLong;
    if ((localLong == null) || (l - localLong.longValue() >= 500L))
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(l);
      if (paramView.getId() == 2131363340) {
        a(true);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardContainer
 * JD-Core Version:    0.7.0.1
 */