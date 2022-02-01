package com.tencent.mobileqq.now;

import adxr;
import amtj;
import amxz;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.SimpleItemAnimator;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import axil;
import axim;
import axin;
import axio;
import axje;
import axju;
import axjx;
import axjz;
import axkf;
import axkh;
import axki;
import axkj;
import axkk;
import axkp;
import bfur;
import bjuk;
import bkpj;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.now.recommend.NoRecommendDataEvent;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.smtt.sdk.CookieManager;
import java.util.ArrayList;
import java.util.List;

public class NowQQLiveFragment
  extends PublicBaseFragment
  implements axjx, axkh, SimpleEventReceiver
{
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private axio jdField_a_of_type_Axio;
  private axkf jdField_a_of_type_Axkf;
  private NavBarAIO jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  private AccountDetail a()
  {
    Object localObject = axjz.a();
    if (localObject != null)
    {
      localObject = (amxz)((AppInterface)localObject).getManager(56);
      if (localObject != null) {
        return ((amxz)localObject).a(axil.jdField_a_of_type_JavaLangString);
      }
    }
    return null;
  }
  
  public static final void a(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, PublicFragmentActivity.class);
    localIntent.putExtra("public_account_uin", paramString);
    localIntent.putExtra("public_account_source", paramInt);
    localIntent.addFlags(67108864);
    adxr.a(paramContext, localIntent, PublicFragmentActivity.class, NowQQLiveFragment.class);
  }
  
  private void a(View paramView)
  {
    Object localObject = new StaggeredGridLayoutManager(2, 1);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131376174));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    if ((getActivity() != null) && (!getActivity().isFinishing()))
    {
      localObject = new axkj(getActivity().getResources().getDimensionPixelSize(2131298813));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration((RecyclerView.ItemDecoration)localObject);
    }
    this.jdField_a_of_type_Axio = new axio(getActivity(), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_Axkf.a());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Axio);
    a();
    b(paramView);
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO = ((NavBarAIO)paramView.findViewById(2131371943));
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO == null) {
      return;
    }
    paramView = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getLayoutParams();
    paramView.setMargins(0, axkp.a(getActivity()), 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setLayoutParams(paramView);
    paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131369068);
    TextView localTextView;
    if (paramView != null)
    {
      if (bjuk.a())
      {
        paramView.setBackgroundResource(2130848967);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130850054);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight2Icon(2130841457);
      }
    }
    else
    {
      int i = axin.a();
      if (i > 0)
      {
        paramView = (TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131369106);
        paramView.setText(String.valueOf(i));
        paramView.setVisibility(0);
        axin.a();
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131369436);
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131377934);
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      localTextView = (TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131378707);
      if (localTextView != null)
      {
        paramView = a();
        if ((paramView == null) || (TextUtils.isEmpty(paramView.name))) {
          break label265;
        }
      }
    }
    label265:
    for (paramView = paramView.name;; paramView = amtj.a(2131694164))
    {
      localTextView.setText(paramView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setOnSelectListener(new axim(this));
      return;
      paramView.setBackgroundResource(2130849067);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130840454);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight2Icon(2130841456);
      break;
    }
  }
  
  private void c()
  {
    CookieManager.getInstance().setCookie("fastest.now.qq.com", "__client_type=16130");
    CookieManager.getInstance().setCookie("now.qq.com", "__client_type=16130");
    axju.a().a(this);
  }
  
  private void d()
  {
    axju.a().b();
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Boolean == axkp.a()) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Boolean = axkp.a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.d();
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        axkp.a(getActivity(), true);
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131369068);
        if (localObject != null) {
          ((View)localObject).setBackgroundResource(2130848967);
        }
        localObject = (TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131378707);
      } while (localObject == null);
      ((TextView)localObject).setTextColor(-1);
      return;
      axkp.a(getActivity(), false);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131369068);
      if (localObject != null) {
        ((View)localObject).setBackgroundResource(2130849067);
      }
      localObject = (TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131378707);
      if (localObject != null) {
        ((TextView)localObject).setTextColor(-16777216);
      }
    } while (ThemeUtil.isCustomTheme(false));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundColor(-1);
  }
  
  private void f()
  {
    if (NetworkUtil.isNetworkAvailable()) {
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidAppDialog == null) {
        this.jdField_a_of_type_AndroidAppDialog = bfur.a(getActivity(), null, getActivity().getString(2131694165), 0, 2131694166, null, null, null);
      }
    } while (this.jdField_a_of_type_AndroidAppDialog.isShowing());
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator().setAddDuration(0L);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator().setChangeDuration(0L);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator().setMoveDuration(0L);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator().setRemoveDuration(0L);
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator() instanceof SimpleItemAnimator)) {
      ((SimpleItemAnimator)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    axje.a().a();
    this.jdField_a_of_type_Axkf.a(0, this, false);
  }
  
  public void a(List<axki> paramList)
  {
    this.jdField_a_of_type_Axio.a(1);
    this.jdField_a_of_type_Axio.notifyDataSetChanged();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Axio.a(2);
    this.jdField_a_of_type_Axio.notifyDataSetChanged();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(NoRecommendDataEvent.class);
    return localArrayList;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setSoftInputMode(17);
    paramActivity.overridePendingTransition(2130771982, 2130771984);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getActivity().getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("public_account_uin");
    this.jdField_a_of_type_Axkf = new axkf();
    if (!axkp.a()) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      f();
      axkk.a(String.valueOf(paramBundle.getIntExtra("public_account_source", 1)));
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    c();
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559532, paramViewGroup, false);
    a(this.jdField_a_of_type_AndroidViewView);
    if (getActivity() == null)
    {
      QLog.e("NowQQLiveFragment", 1, "activity is null");
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      if (getArguments() == null)
      {
        QLog.e("NowQQLiveFragment", 1, "argsBundle is null");
        paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
      }
      else
      {
        SimpleEventBus.getInstance().registerReceiver(this);
        paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    axje.a().b();
    URLDrawable.clearMemoryCache();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((getActivity() != null) && (!NetworkUtil.isNetworkAvailable(getActivity().getApplication())))
    {
      bkpj.a(getActivity(), 2131694075, 1);
      b();
    }
    do
    {
      return;
      if (!axju.a().a()) {
        break;
      }
    } while ((!(paramSimpleBaseEvent instanceof NoRecommendDataEvent)) || (this.jdField_a_of_type_Axkf == null));
    this.jdField_a_of_type_Axkf.a(0, this, false);
    return;
    axju.a().a(this);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Axio.a();
    this.jdField_a_of_type_Axkf.a(this);
    axje.a().a();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.NowQQLiveFragment
 * JD-Core Version:    0.7.0.1
 */