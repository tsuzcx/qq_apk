package com.tencent.mobileqq.now;

import aaak;
import aaam;
import afez;
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
import anzj;
import aody;
import ayvd;
import ayve;
import ayvf;
import ayvg;
import ayvw;
import aywm;
import aywp;
import aywr;
import aywx;
import aywz;
import ayxa;
import ayxb;
import ayxc;
import ayxh;
import bhlq;
import bhnv;
import blqj;
import bmlc;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.now.recommend.NoRecommendDataEvent;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.smtt.sdk.CookieManager;
import java.util.ArrayList;
import java.util.List;

public class NowQQLiveFragment
  extends PublicBaseFragment
  implements aaam, aywp, aywz
{
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ayvg jdField_a_of_type_Ayvg;
  private aywx jdField_a_of_type_Aywx;
  private NavBarAIO jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  private AccountDetail a()
  {
    Object localObject = aywr.a();
    if (localObject != null)
    {
      localObject = (aody)((AppInterface)localObject).getManager(56);
      if (localObject != null) {
        return ((aody)localObject).a(ayvd.jdField_a_of_type_JavaLangString);
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
    afez.a(paramContext, localIntent, PublicFragmentActivity.class, NowQQLiveFragment.class);
  }
  
  private void a(View paramView)
  {
    Object localObject = new StaggeredGridLayoutManager(2, 1);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131376407));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    if ((getActivity() != null) && (!getActivity().isFinishing()))
    {
      localObject = new ayxb(getActivity().getResources().getDimensionPixelSize(2131298748));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration((RecyclerView.ItemDecoration)localObject);
    }
    this.jdField_a_of_type_Ayvg = new ayvg(getActivity(), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_Aywx.a());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Ayvg);
    a();
    b(paramView);
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO = ((NavBarAIO)paramView.findViewById(2131371978));
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO == null) {
      return;
    }
    paramView = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getLayoutParams();
    paramView.setMargins(0, ayxh.a(getActivity()), 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setLayoutParams(paramView);
    paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131369042);
    TextView localTextView;
    if (paramView != null)
    {
      if (blqj.a())
      {
        paramView.setBackgroundResource(2130849056);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130850137);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight2Icon(2130841421);
      }
    }
    else
    {
      int i = ayvf.a();
      if (i > 0)
      {
        paramView = (TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131369080);
        paramView.setText(String.valueOf(i));
        paramView.setVisibility(0);
        ayvf.a();
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131369452);
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131378164);
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      localTextView = (TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131378936);
      if (localTextView != null)
      {
        paramView = a();
        if ((paramView == null) || (TextUtils.isEmpty(paramView.name))) {
          break label265;
        }
      }
    }
    label265:
    for (paramView = paramView.name;; paramView = anzj.a(2131694062))
    {
      localTextView.setText(paramView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setOnSelectListener(new ayve(this));
      return;
      paramView.setBackgroundResource(2130849156);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130840416);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight2Icon(2130841420);
      break;
    }
  }
  
  private void c()
  {
    CookieManager.getInstance().setCookie("fastest.now.qq.com", "__client_type=16130");
    CookieManager.getInstance().setCookie("now.qq.com", "__client_type=16130");
    aywm.a().a(this);
  }
  
  private void d()
  {
    aywm.a().b();
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Boolean == ayxh.a()) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Boolean = ayxh.a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.d();
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        ayxh.a(getActivity(), true);
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131369042);
        if (localObject != null) {
          ((View)localObject).setBackgroundResource(2130849056);
        }
        localObject = (TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131378936);
      } while (localObject == null);
      ((TextView)localObject).setTextColor(-1);
      return;
      ayxh.a(getActivity(), false);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131369042);
      if (localObject != null) {
        ((View)localObject).setBackgroundResource(2130849156);
      }
      localObject = (TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131378936);
      if (localObject != null) {
        ((TextView)localObject).setTextColor(-16777216);
      }
    } while (ThemeUtil.isCustomTheme(false));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundColor(-1);
  }
  
  private void f()
  {
    if (bhnv.a()) {
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidAppDialog == null) {
        this.jdField_a_of_type_AndroidAppDialog = bhlq.a(getActivity(), null, getActivity().getString(2131694063), 0, 2131694064, null, null, null);
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
    ayvw.a().a();
    this.jdField_a_of_type_Aywx.a(0, this, false);
  }
  
  public void a(List<ayxa> paramList)
  {
    this.jdField_a_of_type_Ayvg.a(1);
    this.jdField_a_of_type_Ayvg.notifyDataSetChanged();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Ayvg.a(2);
    this.jdField_a_of_type_Ayvg.notifyDataSetChanged();
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
    this.jdField_a_of_type_Aywx = new aywx();
    if (!ayxh.a()) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      f();
      ayxc.a(String.valueOf(paramBundle.getIntExtra("public_account_source", 1)));
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    c();
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559530, paramViewGroup, false);
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
        aaak.a().a(this);
        paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ayvw.a().b();
    URLDrawable.clearMemoryCache();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    aaak.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((getActivity() != null) && (!bhnv.g(getActivity().getApplication())))
    {
      bmlc.a(getActivity(), 2131693976, 1);
      b();
    }
    do
    {
      return;
      if (!aywm.a().a()) {
        break;
      }
    } while ((!(paramSimpleBaseEvent instanceof NoRecommendDataEvent)) || (this.jdField_a_of_type_Aywx == null));
    this.jdField_a_of_type_Aywx.a(0, this, false);
    return;
    aywm.a().a(this);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Ayvg.a();
    this.jdField_a_of_type_Aywx.a(this);
    ayvw.a().a();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.NowQQLiveFragment
 * JD-Core Version:    0.7.0.1
 */