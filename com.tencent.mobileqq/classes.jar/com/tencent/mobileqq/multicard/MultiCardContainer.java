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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.multicard.manager.TroopMemberRecommendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.SimpleSlidingIndicator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MultiCardContainer
  implements View.OnClickListener, MultiCardManager.GetGroupIntimateInfoListListener, MultiCardManager.GetGroupMemberNickListener, MultiCardManager.GetGroupRecommendUinListsListener
{
  private int a;
  public QQAppInterface b;
  public BaseActivity c;
  public Context d;
  MultiCardManager e;
  MultiCardFragment f;
  MultiCardRecommendFragment g;
  public boolean h;
  private View i;
  private View j;
  private TextView k;
  private TextView l;
  private RelativeLayout m;
  private SimpleSlidingIndicator n;
  private long o;
  private Long p;
  
  public MultiCardContainer(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MultiCardContainer, groopuin :");
      localStringBuilder.append(paramString);
      QLog.d("MultiCardContainer", 2, localStringBuilder.toString());
    }
    this.b = paramQQAppInterface;
    this.c = paramBaseActivity;
    this.d = paramContext;
    try
    {
      this.o = Long.valueOf(paramString).longValue();
    }
    catch (Exception localException)
    {
      label76:
      int i2;
      int i1;
      break label76;
    }
    this.o = 0L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MultiCardContainer troopuinerror:");
    localStringBuilder.append(paramString);
    QLog.d("MultiCardContainer", 2, localStringBuilder.toString());
    this.i = LayoutInflater.from(paramContext).inflate(2131629596, null);
    this.m = ((RelativeLayout)this.i.findViewById(2131445159));
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
      this.m.setBackgroundDrawable(paramBaseActivity.getResources().getDrawable(2130841294));
    }
    this.j = this.i.findViewById(2131447587);
    this.k = ((TextView)this.i.findViewById(2131429218));
    this.l = ((TextView)this.i.findViewById(2131448606));
    this.k.setOnClickListener(this);
    this.n = ((SimpleSlidingIndicator)this.i.findViewById(2131446094));
    a(paramQQAppInterface, paramContext, String.valueOf(this.o));
    this.k.setOnTouchListener(new MultiCardContainer.1(this));
    if (AppSetting.e) {
      this.k.setContentDescription(HardCodeUtil.a(2131901576));
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBaseActivity = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
      i2 = ImmersiveUtils.getStatusBarHeight(paramContext);
      i1 = i2;
      if (h()) {
        i1 = i2 - AIOUtils.b(10.0F, this.j.getResources());
      }
      paramBaseActivity.setMargins(0, i1, 0, 0);
      this.j.setLayoutParams(paramBaseActivity);
    }
    this.e = ((MultiCardManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_MULTI_CARD_MANAGER));
  }
  
  private void a(int paramInt)
  {
    if (this.g != null)
    {
      if (this.f == null) {
        return;
      }
      FragmentTransaction localFragmentTransaction = this.c.getSupportFragmentManager().beginTransaction();
      this.a = paramInt;
      Object localObject;
      StringBuilder localStringBuilder;
      if (paramInt != 0)
      {
        if (paramInt != 1) {
          return;
        }
        if (!this.g.isAdded())
        {
          localObject = this.c.getSupportFragmentManager();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.a);
          localStringBuilder.append("");
          if (((FragmentManager)localObject).findFragmentByTag(localStringBuilder.toString()) == null)
          {
            localFragmentTransaction = localFragmentTransaction.hide(this.f);
            localObject = this.g;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.a);
            localStringBuilder.append("");
            localFragmentTransaction.add(2131433242, (Fragment)localObject, localStringBuilder.toString()).commit();
            break label180;
          }
        }
        localFragmentTransaction.hide(this.f).show(this.g).commit();
        label180:
        TroopRecommendReport.a(this.b);
        return;
      }
      if (!this.f.isAdded())
      {
        localObject = this.c.getSupportFragmentManager();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.a);
        localStringBuilder.append("");
        if (((FragmentManager)localObject).findFragmentByTag(localStringBuilder.toString()) == null)
        {
          localFragmentTransaction = localFragmentTransaction.hide(this.g);
          localObject = this.f;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.a);
          localStringBuilder.append("");
          localFragmentTransaction.add(2131433242, (Fragment)localObject, localStringBuilder.toString()).commit();
          return;
        }
      }
      localFragmentTransaction.hide(this.g).show(this.f).commit();
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    this.h = TroopMemberRecommendManager.a(paramQQAppInterface).a(paramString);
    if (!this.h)
    {
      this.n.setVisibility(8);
      return;
    }
    this.n.setTabData(new String[] { paramContext.getResources().getString(2131917573), paramContext.getResources().getString(2131917574) }, new int[] { 0, 1 });
    this.n.setOnTabListener(new MultiCardContainer.2(this));
  }
  
  private void b(boolean paramBoolean)
  {
    View localView = this.i;
    if (localView != null)
    {
      localView = localView.findViewById(2131448421);
      if (localView != null)
      {
        int i1;
        if (paramBoolean) {
          i1 = 0;
        } else {
          i1 = 8;
        }
        localView.setVisibility(i1);
      }
    }
  }
  
  private boolean h()
  {
    return (Build.VERSION.SDK_INT == 28) && ("samsung".equals(Build.MANUFACTURER)) && ("SM-G9750".equals(Build.MODEL));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardContainer", 2, "initCardFragment");
    }
    if (this.f != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiCardContainer", 2, "initCardFragment, mainfragment is not null");
      }
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A212", "0X800A212", 0, 0, "", "", "", "");
    this.f = new MultiCardFragment();
    this.f.a(this.b, String.valueOf(this.o), this);
    this.g = new MultiCardRecommendFragment();
    this.g.a(this.b, String.valueOf(this.o));
    try
    {
      Object localObject1;
      if (this.a == 0) {
        localObject1 = this.f;
      } else {
        localObject1 = this.g;
      }
      if (!((PublicBaseFragment)localObject1).isAdded())
      {
        localObject3 = this.c.getSupportFragmentManager();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.a);
        localStringBuilder.append("");
        if (((FragmentManager)localObject3).findFragmentByTag(localStringBuilder.toString()) == null)
        {
          localObject3 = this.c.getSupportFragmentManager().beginTransaction();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.a);
          localStringBuilder.append("");
          ((FragmentTransaction)localObject3).add(2131433242, (Fragment)localObject1, localStringBuilder.toString());
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
    Object localObject2 = this.e;
    if (localObject2 != null) {
      ((MultiCardManager)localObject2).a(this.d, this.o, this);
    }
    int i1 = PreferenceManager.getDefaultSharedPreferences(this.d).getInt(TroopDNANavBar.a(this.b), 0);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" guideCount = ");
      ((StringBuilder)localObject2).append(i1);
      QLog.d("MultiCardContainer", 2, ((StringBuilder)localObject2).toString());
    }
    if (i1 < 3) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      this.a = 1;
    }
    this.n.setCurrentPosition(this.a, false);
    if (this.a == 1) {
      TroopRecommendReport.a(this.b);
    }
  }
  
  public void a(long paramLong, ArrayList<Long> paramArrayList)
  {
    if (this.o != paramLong) {
      return;
    }
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      b(false);
      MultiCardFragment localMultiCardFragment = this.f;
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
    if (this.o == paramLong)
    {
      if (paramHashMap == null) {
        return;
      }
      MultiCardFragment localMultiCardFragment = this.f;
      if (localMultiCardFragment != null) {
        localMultiCardFragment.a(null, null, paramHashMap);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (!this.h)
    {
      paramString = this.l;
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
    Object localObject1 = this.e;
    if (localObject1 != null)
    {
      if (paramBoolean1) {
        ((MultiCardManager)localObject1).a(this.d, this.o, paramArrayList, this);
      }
      if (paramBoolean2) {
        this.e.a(this.d, this.o, paramArrayList, this);
      }
    }
  }
  
  public void a(HashMap<Long, IntimateInfo> paramHashMap)
  {
    MultiCardFragment localMultiCardFragment = this.f;
    if (localMultiCardFragment != null) {
      localMultiCardFragment.a(null, paramHashMap, null);
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public View b()
  {
    return this.i;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardContainer", 2, "initData");
    }
    MultiCardManager localMultiCardManager = this.e;
    if (localMultiCardManager != null) {
      localMultiCardManager.a(this.o);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardContainer", 2, "unInitCardFragment");
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      try
      {
        localObject = ((BaseActivity)localObject).getSupportFragmentManager().beginTransaction();
        if (this.f != null) {
          ((FragmentTransaction)localObject).remove(this.f);
        }
        if (this.g != null) {
          ((FragmentTransaction)localObject).remove(this.g);
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
      this.f = null;
      this.g = null;
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardContainer", 2, "onDestroy");
    }
    this.n.d();
    this.n.setOnTabListener(null);
    d();
    this.f = null;
    this.g = null;
    MultiCardManager localMultiCardManager = this.e;
    if (localMultiCardManager != null)
    {
      localMultiCardManager.b(this.o);
      this.e = null;
    }
    this.i = null;
    this.j = null;
    this.k = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.o = 0L;
  }
  
  public boolean f()
  {
    MultiCardFragment localMultiCardFragment = this.f;
    if ((localMultiCardFragment != null) && (!localMultiCardFragment.onBackEvent())) {
      a(true);
    }
    return false;
  }
  
  public void g()
  {
    a(false);
  }
  
  public void onClick(View paramView)
  {
    long l1 = SystemClock.elapsedRealtime();
    Long localLong = this.p;
    if ((localLong == null) || (l1 - localLong.longValue() >= 500L))
    {
      this.p = Long.valueOf(l1);
      if (paramView.getId() == 2131429218) {
        a(true);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardContainer
 * JD-Core Version:    0.7.0.1
 */