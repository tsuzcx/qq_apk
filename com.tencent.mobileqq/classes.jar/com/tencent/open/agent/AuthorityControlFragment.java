package com.tencent.open.agent;

import ajjy;
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
import awqx;
import babr;
import badq;
import bafb;
import bbms;
import bbmy;
import bbun;
import bbuo;
import bbup;
import bbuq;
import bbur;
import bbus;
import bbut;
import bbzq;
import bcix;
import bciy;
import belq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.open.model.AppInfo;
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
  private bbms jdField_a_of_type_Bbms;
  private bbzq jdField_a_of_type_Bbzq;
  private bcix jdField_a_of_type_Bcix;
  private bciy jdField_a_of_type_Bciy;
  private belq jdField_a_of_type_Belq;
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
    if (!badq.d(BaseApplicationImpl.sApplication))
    {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131626719, 0).a();
      e();
      return;
    }
    this.jdField_a_of_type_Bcix = ((bcix)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(151));
    this.jdField_a_of_type_Bcix.a();
    try
    {
      this.jdField_a_of_type_Bbms.show();
      label90:
      this.jdField_a_of_type_AndroidContentResColorStateList = this.rightViewText.getTextColors();
      this.jdField_a_of_type_AndroidViewView$OnTouchListener = new bbun(this);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DC3", "0X8009DC3", 0, 0, "", "", "", "");
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
    this.jdField_a_of_type_Belq = new bbuo(this);
  }
  
  private void c()
  {
    setTitle(getString(2131624721));
    this.jdField_a_of_type_Bbzq = new bbzq(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)a(2131303649));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493891, null, false));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_Belq);
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493085, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localView);
    this.jdField_a_of_type_AndroidViewView = a(2131300047);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297349));
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bbzq);
    this.jdField_a_of_type_Bbms = new bbms(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
    this.jdField_a_of_type_Bbms.a(ajjy.a(2131635014));
    this.jdField_a_of_type_Bbms.c(false);
    this.jdField_a_of_type_Bbms.setOnCancelListener(new bbup(this));
  }
  
  private void d()
  {
    this.jdField_a_of_type_Bciy = new bbuq(this);
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
    this.jdField_a_of_type_Bbzq.b();
    setTextWithTalk(this.rightViewText, 2131624724);
    this.rightViewText.setTextColor(getResources().getColorStateList(2131099734));
    this.rightViewText.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.rightViewText.setEnabled(false);
    setLeftButton(2131625035, new bbur(this));
    Object localObject = this.leftViewNotBack.getLayoutParams();
    if ((localObject instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localObject;
      ((RelativeLayout.LayoutParams)localObject).setMargins(18, ((RelativeLayout.LayoutParams)localObject).topMargin, ((RelativeLayout.LayoutParams)localObject).rightMargin, ((RelativeLayout.LayoutParams)localObject).bottomMargin);
      this.leftViewNotBack.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.leftView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131652878);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(null);
    a(true);
  }
  
  private void g()
  {
    Object localObject1 = this.jdField_a_of_type_Bbzq.a();
    if (((List)localObject1).size() == 0) {
      return;
    }
    Object localObject2 = new bbus(this, (List)localObject1);
    bbut localbbut = new bbut(this);
    if (((List)localObject1).size() == 1) {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131652877);
    }
    for (;;)
    {
      int i = this.jdField_a_of_type_Bbzq.a().size();
      String str = String.format(ajjy.a(2131635006), new Object[] { Integer.valueOf(i) });
      localObject1 = babr.a(this.jdField_a_of_type_AndroidContentContext, 230, str, (String)localObject1, 2131625035, 2131629116, (DialogInterface.OnClickListener)localObject2, localbbut);
      try
      {
        ((bafb)localObject1).show();
        label124:
        localObject1 = new StringBuilder();
        localObject2 = this.jdField_a_of_type_Bbzq.a().iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            ((StringBuilder)localObject1).append(String.valueOf(((AppInfo)((Iterator)localObject2).next()).a()));
            ((StringBuilder)localObject1).append(" ");
            continue;
            localObject1 = ajjy.a(2131635003);
            break;
          }
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DC6", "0X8009DC6", 0, 0, "", "", ((StringBuilder)localObject1).toString(), "");
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
    return 2131492902;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 996) && (paramInt2 == -1))
    {
      paramIntent = new AuthorityControlFragment.9(this, (AppInfo)paramIntent.getParcelableExtra("KEY_DELETED_INFO"));
      this.jdField_a_of_type_Bbzq.b(paramIntent);
      this.jdField_a_of_type_Bbzq.a();
      if (this.jdField_a_of_type_Bbzq.getCount() == 0) {
        e();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.rightViewText.getId() == paramView.getId())
    {
      if (this.jdField_a_of_type_Bbzq.a()) {
        g();
      }
    }
    else {
      return;
    }
    f();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Bbzq != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() == this.jdField_a_of_type_Bbzq.getCount())) {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DC7", "0X8009DC7", 0, 0, "", "", "", "");
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bciy);
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bciy);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlFragment
 * JD-Core Version:    0.7.0.1
 */