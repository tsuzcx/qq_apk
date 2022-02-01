package com.tencent.open.agent;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.authority.AuthorityControlAdapter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.manager.OpenAgentHandler;
import com.tencent.open.manager.OpenAgentObserver;
import com.tencent.open.model.AppInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class AuthorityControlFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  View.OnTouchListener a;
  private XListView b;
  private AuthorityControlAdapter c;
  private Context d;
  private View e;
  private QQAppInterface f;
  private OpenAgentObserver g;
  private OpenAgentHandler h;
  private TextView i;
  private ColorStateList j;
  @NonNull
  private ArrayList<AppInfo> k = new ArrayList();
  private PullRefreshHeader l;
  private OverScrollViewListener m;
  private QQProgressDialog n;
  
  private void a()
  {
    this.f = getBaseActivity().app;
    this.d = getBaseActivity();
    c();
    d();
    e();
    b();
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.sApplication))
    {
      QQToast.makeText(this.d, 2131889169, 0).show();
      f();
      return;
    }
    this.h = ((OpenAgentHandler)this.f.getBusinessHandler(BusinessHandlerFactory.OPEN_AGENT_HANDLER));
    this.h.a();
    try
    {
      this.n.show();
      label94:
      this.j = this.rightViewText.getTextColors();
      this.a = new AuthorityControlFragment.1(this);
      ReportController.b(this.f, "dc00898", "", "", "0X8009DC3", "0X8009DC3", 0, 0, "", "", "", "");
      AuthorityUtil.a(this.f, "0X800B92E", null);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label94;
    }
  }
  
  public static void a(Activity paramActivity)
  {
    PublicFragmentActivity.a(paramActivity, AuthorityControlFragment.class);
  }
  
  private void a(List<AppInfo> paramList)
  {
    AuthorityControlAdapter localAuthorityControlAdapter = this.c;
    if (localAuthorityControlAdapter == null) {
      return;
    }
    localAuthorityControlAdapter.b(paramList);
    this.c.c();
    if (this.c.getCount() == 0) {
      f();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.l.a(0);
    } else {
      this.l.a(1);
    }
    ThreadManager.getUIHandler().postDelayed(new AuthorityControlFragment.6(this), 800L);
  }
  
  private void b()
  {
    AuthorityControlFragment.2 local2 = new AuthorityControlFragment.2(this);
    this.f.setHandler(AuthorityControlFragment.class, local2);
  }
  
  private void c()
  {
    this.m = new AuthorityControlFragment.3(this);
  }
  
  private void d()
  {
    setTitle(getString(2131887123));
    this.c = new AuthorityControlAdapter(this, this.f);
    this.b = ((XListView)a(2131437331));
    this.l = ((PullRefreshHeader)LayoutInflater.from(this.d).inflate(2131625671, null, false));
    this.b.setOverScrollHeader(this.l);
    this.b.setOverScrollListener(this.m);
    Object localObject = LayoutInflater.from(this.d).inflate(2131624264, this.b, false);
    this.b.addHeaderView((View)localObject);
    this.e = a(2131432495);
    this.i = ((TextView)((View)localObject).findViewById(2131428911));
    this.b.setAdapter(this.c);
    localObject = this.d;
    this.n = new QQProgressDialog((Context)localObject, ((Context)localObject).getResources().getDimensionPixelSize(2131299920));
    this.n.a(HardCodeUtil.a(2131899050));
    this.n.c(false);
    this.n.setOnCancelListener(new AuthorityControlFragment.4(this));
  }
  
  private void e()
  {
    this.g = new AuthorityControlFragment.5(this);
  }
  
  private void f()
  {
    this.b.setVisibility(8);
    this.i.setVisibility(8);
    this.e.setVisibility(0);
    this.rightViewText.setVisibility(8);
    setLeftButton("", null);
    this.mLeftBackIcon.setVisibility(0);
  }
  
  private void g()
  {
    this.c.d();
    setTextWithTalk(this.rightViewText, 2131887126);
    this.rightViewText.setTextColor(getResources().getColorStateList(2131165544));
    this.rightViewText.setOnTouchListener(this.a);
    this.rightViewText.setEnabled(false);
    setLeftButton(2131887648, new AuthorityControlFragment.7(this));
    Object localObject = this.leftViewNotBack.getLayoutParams();
    if ((localObject instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localObject;
      ((RelativeLayout.LayoutParams)localObject).setMargins(18, ((RelativeLayout.LayoutParams)localObject).topMargin, ((RelativeLayout.LayoutParams)localObject).rightMargin, ((RelativeLayout.LayoutParams)localObject).bottomMargin);
      this.leftViewNotBack.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.leftView.setVisibility(8);
    this.i.setText(2131915675);
    this.b.setOverScrollHeader(null);
    a(true);
    AuthorityUtil.a(this.f, "0X800B932", null);
  }
  
  private void h()
  {
    Object localObject1 = this.c.b();
    if (((List)localObject1).size() == 0)
    {
      AuthorityUtil.a(this.f, "0X800B933", null);
      return;
    }
    Object localObject2 = new AuthorityControlFragment.8(this, (List)localObject1);
    Object localObject3 = new AuthorityControlFragment.9(this);
    if (((List)localObject1).size() == 1) {
      localObject1 = this.d.getResources().getString(2131915674);
    } else {
      localObject1 = HardCodeUtil.a(2131899039);
    }
    int i1 = this.c.b().size();
    Object localObject4 = String.format(HardCodeUtil.a(2131899042), new Object[] { Integer.valueOf(i1) });
    localObject1 = DialogUtil.a(this.d, 230, (String)localObject4, (String)localObject1, 2131887648, 2131892267, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject3);
    try
    {
      ((QQCustomDialog)localObject1).show();
      label145:
      localObject1 = new StringBuilder();
      localObject2 = new StringBuilder();
      localObject3 = this.c.b().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (AppInfo)((Iterator)localObject3).next();
        ((StringBuilder)localObject1).append(String.valueOf(((AppInfo)localObject4).a()));
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject2).append(((AppInfo)localObject4).c());
        ((StringBuilder)localObject2).append(" ");
      }
      ReportController.b(this.f, "dc00898", "", "", "0X8009DC6", "0X8009DC6", 0, 0, "", "", ((StringBuilder)localObject1).toString(), "");
      AuthorityUtil.a(this.f, "0X800B933", new String[] { "", "", ((StringBuilder)localObject2).toString(), "" });
      return;
    }
    catch (Throwable localThrowable)
    {
      break label145;
    }
  }
  
  protected final <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  protected int getContentLayoutId()
  {
    return 2131624015;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 996) && (paramInt2 == -1)) {
      a(new AuthorityControlFragment.10(this, (AppInfo)paramIntent.getParcelableExtra("KEY_DELETED_INFO")));
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.rightViewText.getId() == paramView.getId()) {
      if (this.c.a()) {
        h();
      } else {
        g();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.f.removeHandler(AuthorityControlFragment.class);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ArrayList localArrayList = this.k;
    if ((localArrayList != null) && (this.c != null) && (localArrayList.size() == this.c.getCount())) {
      ReportController.b(this.f, "dc00898", "", "", "0X8009DC7", "0X8009DC7", 0, 0, "", "", "", "");
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.f.addObserver(this.g);
  }
  
  public void onStop()
  {
    super.onStop();
    this.f.removeObserver(this.g);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlFragment
 * JD-Core Version:    0.7.0.1
 */