package com.tencent.open.agent;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anzj;
import bdll;
import bhlq;
import bhnv;
import bhpc;
import bjbs;
import bjkq;
import bjkr;
import bjks;
import bjkt;
import bjku;
import bjkv;
import bjkw;
import bjps;
import bjyz;
import bjza;
import blnt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.model.AppInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class AuthorityControlFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bjbs jdField_a_of_type_Bjbs;
  private bjps jdField_a_of_type_Bjps;
  private bjyz jdField_a_of_type_Bjyz;
  private bjza jdField_a_of_type_Bjza;
  private blnt jdField_a_of_type_Blnt;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  @NonNull
  private ArrayList<AppInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    b();
    c();
    d();
    if (!bhnv.d(BaseApplicationImpl.sApplication))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131691989, 0).a();
      e();
      return;
    }
    this.jdField_a_of_type_Bjyz = ((bjyz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(151));
    this.jdField_a_of_type_Bjyz.a();
    try
    {
      this.jdField_a_of_type_Bjbs.show();
      label90:
      this.jdField_a_of_type_AndroidContentResColorStateList = this.rightViewText.getTextColors();
      this.jdField_a_of_type_AndroidViewView$OnTouchListener = new bjkq(this);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DC3", "0X8009DC3", 0, 0, "", "", "", "");
      return;
    }
    catch (Throwable localThrowable)
    {
      break label90;
    }
  }
  
  public static void a(Activity paramActivity)
  {
    PublicFragmentActivity.a(paramActivity, AuthorityControlFragment.class);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().postDelayed(new AuthorityControlFragment.5(this), 800L);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(1);
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_Blnt = new bjkr(this);
  }
  
  private void c()
  {
    setTitle(getString(2131690175));
    this.jdField_a_of_type_Bjps = new bjps(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)a(2131370064));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559652, null, false));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_Blnt);
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558703, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localView);
    this.jdField_a_of_type_AndroidViewView = a(2131366016);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363057));
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bjps);
    this.jdField_a_of_type_Bjbs = new bjbs(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
    this.jdField_a_of_type_Bjbs.a(anzj.a(2131699722));
    this.jdField_a_of_type_Bjbs.c(false);
    this.jdField_a_of_type_Bjbs.setOnCancelListener(new bjks(this));
  }
  
  private void d()
  {
    this.jdField_a_of_type_Bjza = new bjkt(this);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.rightViewText.setVisibility(8);
    setLeftButton("", null);
    this.mLeftBackIcon.setVisibility(0);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Bjps.b();
    setTextWithTalk(this.rightViewText, 2131690178);
    this.rightViewText.setTextColor(getResources().getColorStateList(2131165333));
    this.rightViewText.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.rightViewText.setEnabled(false);
    setLeftButton(2131690580, new bjku(this));
    Object localObject = this.leftViewNotBack.getLayoutParams();
    if ((localObject instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localObject;
      ((RelativeLayout.LayoutParams)localObject).setMargins(18, ((RelativeLayout.LayoutParams)localObject).topMargin, ((RelativeLayout.LayoutParams)localObject).rightMargin, ((RelativeLayout.LayoutParams)localObject).bottomMargin);
      this.leftViewNotBack.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.leftView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131717436);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(null);
    a(true);
  }
  
  private void g()
  {
    Object localObject1 = this.jdField_a_of_type_Bjps.a();
    if (((List)localObject1).size() == 0) {
      return;
    }
    Object localObject2 = new bjkv(this, (List)localObject1);
    bjkw localbjkw = new bjkw(this);
    if (((List)localObject1).size() == 1) {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131717435);
    }
    for (;;)
    {
      int i = this.jdField_a_of_type_Bjps.a().size();
      String str = String.format(anzj.a(2131699714), new Object[] { Integer.valueOf(i) });
      localObject1 = bhlq.a(this.jdField_a_of_type_AndroidContentContext, 230, str, (String)localObject1, 2131690580, 2131694098, (DialogInterface.OnClickListener)localObject2, localbjkw);
      try
      {
        ((bhpc)localObject1).show();
        label124:
        localObject1 = new StringBuilder();
        localObject2 = this.jdField_a_of_type_Bjps.a().iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            ((StringBuilder)localObject1).append(String.valueOf(((AppInfo)((Iterator)localObject2).next()).a()));
            ((StringBuilder)localObject1).append(" ");
            continue;
            localObject1 = anzj.a(2131699711);
            break;
          }
        }
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DC6", "0X8009DC6", 0, 0, "", "", ((StringBuilder)localObject1).toString(), "");
        return;
      }
      catch (Throwable localThrowable)
      {
        break label124;
      }
    }
  }
  
  protected final <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  public int getContentLayoutId()
  {
    return 2131558444;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 996) && (paramInt2 == -1))
    {
      paramIntent = new AuthorityControlFragment.9(this, (AppInfo)paramIntent.getParcelableExtra("KEY_DELETED_INFO"));
      this.jdField_a_of_type_Bjps.b(paramIntent);
      this.jdField_a_of_type_Bjps.a();
      if (this.jdField_a_of_type_Bjps.getCount() == 0) {
        e();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.rightViewText.getId() == paramView.getId())
    {
      if (!this.jdField_a_of_type_Bjps.a()) {
        break label36;
      }
      g();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label36:
      f();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Bjps != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() == this.jdField_a_of_type_Bjps.getCount())) {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DC7", "0X8009DC7", 0, 0, "", "", "", "");
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bjza);
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bjza);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlFragment
 * JD-Core Version:    0.7.0.1
 */