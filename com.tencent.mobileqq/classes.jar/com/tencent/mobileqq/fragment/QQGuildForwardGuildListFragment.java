package com.tencent.mobileqq.fragment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.adapter.QQGuildForwardSelectionGuildListAdapter;
import com.tencent.mobileqq.adapter.QQGuildForwardSelectionGuildListAdapter.IForwardGuildListAdapterCallback;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.ResultRecord.DefaultComparator;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar.ISelectedAndSearchBarCallback;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.PinnedHeaderExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class QQGuildForwardGuildListFragment
  extends QPublicBaseFragment
  implements View.OnClickListener
{
  private static final int v = BaseApplication.getContext().getResources().getDimensionPixelSize(2131299920);
  private TextView a;
  private TextView b;
  private ImageView c;
  private TextView d;
  private final Map<String, ResultRecord> e = new LinkedHashMap();
  private View f;
  private View g;
  private PinnedHeaderExpandableListView h;
  private SelectedAndSearchBar i;
  private IFaceDecoder j;
  private IQQGuildService k;
  private Dialog l;
  private boolean m;
  private boolean n;
  private ForwardBaseOption o;
  private String p;
  private QQGuildForwardSelectionGuildListAdapter q;
  private QBaseActivity r;
  private QQAppInterface s;
  private final SelectedAndSearchBar.ISelectedAndSearchBarCallback t = new QQGuildForwardGuildListFragment.1(this);
  private final QQGuildForwardSelectionGuildListAdapter.IForwardGuildListAdapterCallback u = new QQGuildForwardGuildListFragment.2(this);
  
  private void a()
  {
    this.i.setVisibility(0);
    if ((this.j == null) || (this.k == null)) {
      b();
    }
    this.b.setVisibility(0);
    this.b.setText("");
    Object localObject = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = BaseAIOUtils.b(29.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).rightMargin = BaseAIOUtils.b(10.0F, getResources());
    if (Build.VERSION.SDK_INT <= 18) {
      ((RelativeLayout.LayoutParams)localObject).width = BaseAIOUtils.b(75.0F, getResources());
    }
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.d.setPadding(BaseAIOUtils.b(7.0F, getResources()), 0, BaseAIOUtils.b(7.0F, getResources()), 0);
    this.d.setBackgroundResource(2130846654);
    this.d.setTextSize(1, 14.0F);
    this.d.setVisibility(0);
    this.d.setOnClickListener(this);
    c();
    if (AppSetting.e)
    {
      localObject = this.d;
      ((TextView)localObject).setContentDescription(((TextView)localObject).getText());
    }
  }
  
  private void a(View paramView)
  {
    c(paramView);
    this.h = ((PinnedHeaderExpandableListView)paramView.findViewById(2131433791));
    this.h.setIsDrawIndicator(false);
    b(paramView);
    if (this.m)
    {
      a();
      return;
    }
    d();
  }
  
  private void a(ResultRecord paramResultRecord)
  {
    if (paramResultRecord == null) {
      return;
    }
    String str = c(paramResultRecord.uin, paramResultRecord.getUinType());
    ResultRecord localResultRecord = (ResultRecord)this.e.get(str);
    if (localResultRecord != null)
    {
      localResultRecord.lastChooseTime = SystemClock.elapsedRealtime();
      paramResultRecord = new ArrayList(this.e.values());
      this.i.a(paramResultRecord, false);
      return;
    }
    if (this.e.size() == 9)
    {
      g();
      return;
    }
    ResultRecord.copyResultRecord(paramResultRecord).lastChooseTime = SystemClock.elapsedRealtime();
    this.e.put(str, ResultRecord.copyResultRecord(paramResultRecord));
    c();
    paramResultRecord = new ArrayList(this.e.values());
    this.i.a(paramResultRecord, true);
  }
  
  public static void a(String paramString, int paramInt)
  {
    QQToast.makeText(BaseApplication.getContext(), paramInt, paramString, 1).show(v);
  }
  
  private void b()
  {
    if (this.j == null) {
      this.j = ((IQQAvatarService)this.s.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.s);
    }
    if (this.k == null) {
      this.k = ((IQQGuildService)this.s.getRuntimeService(IQQGuildService.class, ""));
    }
    this.i.a(null, this.j, this.t, this.k);
  }
  
  private void b(View paramView)
  {
    this.i = ((SelectedAndSearchBar)paramView.findViewById(2131445550));
    paramView = (ImageView)this.i.findViewById(2131445432);
    EditText localEditText = (EditText)this.i.findViewById(2131445437);
    paramView.setOnClickListener(this);
    localEditText.setOnClickListener(this);
    localEditText.setFocusable(false);
    localEditText.setCursorVisible(false);
    this.i.setVisibility(8);
  }
  
  private void b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = c(paramString, paramInt);
    this.e.remove(paramString);
    c();
    paramString = new ArrayList(this.e.values());
    this.i.a(paramString, true);
  }
  
  private String c(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private void c()
  {
    if (this.e.isEmpty())
    {
      this.d.setText(HardCodeUtil.a(2131902757));
      this.d.setClickable(false);
      this.d.setTextColor(855836698);
    }
    else
    {
      this.d.setText(String.format(HardCodeUtil.a(2131902751), new Object[] { Integer.valueOf(this.e.size()) }));
      this.d.setClickable(true);
      this.d.setTextColor(getResources().getColor(2131168001));
    }
    if (AppSetting.e)
    {
      TextView localTextView = this.d;
      localTextView.setContentDescription(localTextView.getText());
    }
  }
  
  @TargetApi(14)
  private void c(View paramView)
  {
    Object localObject = (LinearLayout)paramView.findViewById(2131445137);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      ((LinearLayout)localObject).setFitsSystemWindows(true);
      ((LinearLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(this.r), 0, 0);
    }
    localObject = (TextView)paramView.findViewById(2131436227);
    ((TextView)localObject).setText("选择频道");
    this.b = ((TextView)paramView.findViewById(2131436180));
    this.b.setVisibility(0);
    this.b.setOnClickListener(this);
    this.b.setText("");
    this.a = ((TextView)paramView.findViewById(2131436182));
    this.a.setVisibility(8);
    this.d = ((TextView)paramView.findViewById(2131436211));
    this.d.setVisibility(0);
    this.d.setText(HardCodeUtil.a(2131902775));
    this.d.setOnClickListener(this);
    this.d.setMaxWidth(BaseAIOUtils.b(260.0F, getResources()));
    this.c = ((ImageView)paramView.findViewById(2131436194));
    this.c.setVisibility(8);
    if (this.n)
    {
      this.d.setVisibility(8);
      this.b.setText(2131887625);
    }
    if (AppSetting.e)
    {
      ((TextView)localObject).setContentDescription("选择频道");
      this.b.setContentDescription(HardCodeUtil.a(2131887440));
      this.d.setContentDescription(HardCodeUtil.a(2131902757));
    }
  }
  
  private void d()
  {
    this.f = LayoutInflater.from(this.r).inflate(2131629215, this.h, false);
    this.f.findViewById(2131429816).setVisibility(8);
    EditText localEditText = (EditText)this.f.findViewById(2131432634);
    localEditText.setFocusable(false);
    localEditText.setOnClickListener(this);
    localEditText.setCursorVisible(false);
    this.h.addHeaderView(this.f);
    this.g = new View(this.r);
    this.g.setLayoutParams(new AbsListView.LayoutParams(-1, BaseAIOUtils.b(12.0F, getResources())));
    this.h.addHeaderView(this.g);
  }
  
  private void e()
  {
    this.q = new QQGuildForwardSelectionGuildListAdapter(this.r, this.s, this.h, this.u, this.m, this.p);
    this.h.setAdapter(this.q);
    this.q.a();
    if (this.m) {
      f();
    }
  }
  
  private void f()
  {
    Object localObject = this.r.getIntent().getParcelableArrayListExtra("selected_target_list");
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a((ResultRecord)((Iterator)localObject).next());
      }
    }
  }
  
  private void g()
  {
    if (this.l == null) {
      this.l = DialogUtil.a(this.r, getString(2131896914), 0, 2131892366, null, new -..Lambda.QQGuildForwardGuildListFragment.SJvtmrAjTlYhvwZ3zIxrHRGLCVY(this));
    }
    if (!this.r.isFinishing()) {
      this.l.show();
    }
  }
  
  private void h()
  {
    this.m = false;
    this.e.clear();
    Object localObject = new ArrayList(this.e.values());
    this.i.a((List)localObject, true);
    this.a.setText("");
    this.a.setVisibility(8);
    this.b.setVisibility(0);
    this.d.setText(HardCodeUtil.a(2131902775));
    this.d.setBackgroundResource(2130853306);
    this.d.setTextColor(getResources().getColor(2131167990));
    localObject = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = BaseAIOUtils.b(36.0F, getResources());
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.d.setTextSize(1, 17.0F);
    this.d.setClickable(true);
    this.c.setVisibility(8);
    if (AppSetting.e)
    {
      localObject = this.d;
      ((TextView)localObject).setContentDescription(((TextView)localObject).getText());
    }
    this.i.setVisibility(8);
    this.h.addHeaderView(this.f);
    this.h.addHeaderView(this.g);
    this.h.postDelayed(new -..Lambda.QQGuildForwardGuildListFragment.cZ5NBa0kTCXuaosIjM5xOlCJEuk(this), 1L);
  }
  
  private void i()
  {
    this.m = true;
    this.f.setVisibility(0);
    this.h.removeHeaderView(this.f);
    this.h.removeHeaderView(this.g);
    a();
    this.b.setVisibility(8);
    this.a.setVisibility(0);
    this.a.setText(HardCodeUtil.a(2131887648));
    this.a.setOnClickListener(this);
    if (AppSetting.e)
    {
      TextView localTextView = this.a;
      localTextView.setContentDescription(localTextView.getText());
    }
    this.h.postDelayed(new -..Lambda.QQGuildForwardGuildListFragment.So6OsWRcQPLUX63Z9sgZabTWfRk(this), 1L);
  }
  
  private void j()
  {
    if (this.o == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ForwardGuildListActivity", 2, "forwardOption is null, return.");
      }
      return;
    }
    if (this.e.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ForwardGuildListActivity", 2, "forward2MultiTargets map is empty !");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList(this.e.values());
    Collections.sort(localArrayList, new ResultRecord.DefaultComparator());
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("forward_multi_target", localArrayList);
    this.o.a(ForwardAbility.ForwardAbilityType.b.intValue(), localBundle);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(2130771996, 2130771997);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131436211: 
      if (this.m) {
        j();
      } else {
        i();
      }
      break;
    case 2131436182: 
      h();
      break;
    case 2131436180: 
      if (this.m)
      {
        Intent localIntent = new Intent();
        localIntent.putParcelableArrayListExtra("selected_target_list", new ArrayList(this.e.values()));
        localIntent.putExtra("is_multi_selection", this.m);
        this.r.setResult(0, localIntent);
      }
      this.r.finish();
      break;
    case 2131432634: 
    case 2131445432: 
    case 2131445437: 
      a("暂时不可搜索频道列表", 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @TargetApi(14)
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131624868, paramViewGroup, false);
    this.r = getQBaseActivity();
    if ((this.r.getAppRuntime() instanceof QQAppInterface)) {
      this.s = ((QQAppInterface)this.r.getAppRuntime());
    }
    paramViewGroup = this.r.getIntent();
    if (paramViewGroup == null)
    {
      this.r.finish();
      paramLayoutInflater = null;
    }
    else
    {
      this.m = paramViewGroup.getBooleanExtra("is_multi_selection", false);
      this.p = paramViewGroup.getStringExtra("open_single_guild_id");
      this.n = paramViewGroup.getBooleanExtra("only_single_selection", false);
      if (paramViewGroup.getBooleanExtra("call_by_forward", false)) {
        this.o = ForwardOptionBuilder.a(paramViewGroup, this.s, this.r);
      }
      this.r.getWindow().setBackgroundDrawable(null);
      a(paramLayoutInflater);
      e();
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.q;
    if (localObject != null)
    {
      ((QQGuildForwardSelectionGuildListAdapter)localObject).c();
      this.h.setAdapter((PinnedHeaderExpandableListView.ExpandableListAdapter)null);
    }
    localObject = this.j;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    getQBaseActivity().overridePendingTransition(2130771994, 2130771995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQGuildForwardGuildListFragment
 * JD-Core Version:    0.7.0.1
 */