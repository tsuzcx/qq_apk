package com.tencent.mobileqq.now;

import aevv;
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
import anni;
import anrs;
import ayck;
import aycl;
import aycm;
import aycn;
import aydd;
import aydt;
import aydw;
import aydy;
import ayee;
import ayeg;
import ayeh;
import ayei;
import ayej;
import ayeo;
import bglp;
import bgnt;
import bkpg;
import bljz;
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
import zwp;
import zwr;

public class NowQQLiveFragment
  extends PublicBaseFragment
  implements aydw, ayeg, zwr
{
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private aycn jdField_a_of_type_Aycn;
  private ayee jdField_a_of_type_Ayee;
  private NavBarAIO jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  private AccountDetail a()
  {
    Object localObject = aydy.a();
    if (localObject != null)
    {
      localObject = (anrs)((AppInterface)localObject).getManager(56);
      if (localObject != null) {
        return ((anrs)localObject).a(ayck.jdField_a_of_type_JavaLangString);
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
    aevv.a(paramContext, localIntent, PublicFragmentActivity.class, NowQQLiveFragment.class);
  }
  
  private void a(View paramView)
  {
    Object localObject = new StaggeredGridLayoutManager(2, 1);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131376267));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    if ((getActivity() != null) && (!getActivity().isFinishing()))
    {
      localObject = new ayei(getActivity().getResources().getDimensionPixelSize(2131298735));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration((RecyclerView.ItemDecoration)localObject);
    }
    this.jdField_a_of_type_Aycn = new aycn(getActivity(), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_Ayee.a());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Aycn);
    a();
    b(paramView);
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO = ((NavBarAIO)paramView.findViewById(2131371865));
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO == null) {
      return;
    }
    paramView = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getLayoutParams();
    paramView.setMargins(0, ayeo.a(getActivity()), 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setLayoutParams(paramView);
    paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131368947);
    TextView localTextView;
    if (paramView != null)
    {
      if (bkpg.a())
      {
        paramView.setBackgroundResource(2130849037);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130850125);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight2Icon(2130841411);
      }
    }
    else
    {
      int i = aycm.a();
      if (i > 0)
      {
        paramView = (TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131368986);
        paramView.setText(String.valueOf(i));
        paramView.setVisibility(0);
        aycm.a();
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131369362);
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131378009);
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      localTextView = (TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131378776);
      if (localTextView != null)
      {
        paramView = a();
        if ((paramView == null) || (TextUtils.isEmpty(paramView.name))) {
          break label265;
        }
      }
    }
    label265:
    for (paramView = paramView.name;; paramView = anni.a(2131694045))
    {
      localTextView.setText(paramView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setOnSelectListener(new aycl(this));
      return;
      paramView.setBackgroundResource(2130849137);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130840406);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight2Icon(2130841410);
      break;
    }
  }
  
  private void c()
  {
    CookieManager.getInstance().setCookie("fastest.now.qq.com", "__client_type=16130");
    CookieManager.getInstance().setCookie("now.qq.com", "__client_type=16130");
    aydt.a().a(this);
  }
  
  private void d()
  {
    aydt.a().b();
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Boolean == ayeo.a()) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Boolean = ayeo.a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.d();
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        ayeo.a(getActivity(), true);
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131368947);
        if (localObject != null) {
          ((View)localObject).setBackgroundResource(2130849037);
        }
        localObject = (TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131378776);
      } while (localObject == null);
      ((TextView)localObject).setTextColor(-1);
      return;
      ayeo.a(getActivity(), false);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131368947);
      if (localObject != null) {
        ((View)localObject).setBackgroundResource(2130849137);
      }
      localObject = (TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131378776);
      if (localObject != null) {
        ((TextView)localObject).setTextColor(-16777216);
      }
    } while (ThemeUtil.isCustomTheme(false));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundColor(-1);
  }
  
  private void f()
  {
    if (bgnt.a()) {
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidAppDialog == null) {
        this.jdField_a_of_type_AndroidAppDialog = bglp.a(getActivity(), null, getActivity().getString(2131694046), 0, 2131694047, null, null, null);
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
    aydd.a().a();
    this.jdField_a_of_type_Ayee.a(0, this, false);
  }
  
  public void a(List<ayeh> paramList)
  {
    this.jdField_a_of_type_Aycn.a(1);
    this.jdField_a_of_type_Aycn.notifyDataSetChanged();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Aycn.a(2);
    this.jdField_a_of_type_Aycn.notifyDataSetChanged();
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
    this.jdField_a_of_type_Ayee = new ayee();
    if (!ayeo.a()) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      f();
      ayej.a(String.valueOf(paramBundle.getIntExtra("public_account_source", 1)));
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    c();
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559525, paramViewGroup, false);
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
        zwp.a().a(this);
        paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    aydd.a().b();
    URLDrawable.clearMemoryCache();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    zwp.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((getActivity() != null) && (!bgnt.g(getActivity().getApplication())))
    {
      bljz.a(getActivity(), 2131693959, 1);
      b();
    }
    do
    {
      return;
      if (!aydt.a().a()) {
        break;
      }
    } while ((!(paramSimpleBaseEvent instanceof NoRecommendDataEvent)) || (this.jdField_a_of_type_Ayee == null));
    this.jdField_a_of_type_Ayee.a(0, this, false);
    return;
    aydt.a().a(this);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Aycn.a();
    this.jdField_a_of_type_Ayee.a(this);
    aydd.a().a();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.NowQQLiveFragment
 * JD-Core Version:    0.7.0.1
 */