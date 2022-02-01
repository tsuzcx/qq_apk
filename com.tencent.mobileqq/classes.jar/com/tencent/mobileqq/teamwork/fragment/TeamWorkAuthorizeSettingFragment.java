package com.tencent.mobileqq.teamwork.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkAuthorizeUinListAdapter;
import com.tencent.mobileqq.teamwork.TeamWorkAuthorizeUinListAdapter.Holder;
import com.tencent.mobileqq.teamwork.TeamWorkAuthorizeUinListAdapter.ItemData;
import com.tencent.mobileqq.teamwork.TeamWorkObserver;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TeamWorkAuthorizeSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  String a;
  int b;
  TextView c;
  TextView d;
  TextView e;
  XListView f;
  TextView g;
  List<TeamWorkAuthorizeUinListAdapter.ItemData> h;
  Map<Integer, List<TeamWorkAuthorizeUinListAdapter.ItemData>> i;
  TeamWorkAuthorizeUinListAdapter j;
  int k = -1;
  boolean l = false;
  FriendListObserver m = new TeamWorkAuthorizeSettingFragment.1(this);
  TeamWorkObserver n = new TeamWorkAuthorizeSettingFragment.2(this);
  private ITeamWorkHandler o;
  private QQAppInterface p;
  
  private void a()
  {
    this.vg.changeBg(true);
    this.c = ((TextView)this.mContentView.findViewById(2131432034));
    this.d = ((TextView)this.mContentView.findViewById(2131433634));
    this.e = ((TextView)this.mContentView.findViewById(2131434220));
    this.f = ((XListView)this.mContentView.findViewById(2131449288));
    this.g = ((TextView)this.mContentView.findViewById(2131432356));
    setLeftViewName(2131887440);
    setRightButton(2131892267, this);
    setTitle(getBaseActivity().getResources().getString(2131917070));
  }
  
  private void a(int paramInt)
  {
    if ((paramInt <= 3) && (paramInt >= 0))
    {
      this.g.setText(2131917063);
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("no process PUBFLAG:");
              ((StringBuilder)localObject).append(paramInt);
              QLog.w("TeamWorkAuthorizeSettingFragment", 1, ((StringBuilder)localObject).toString());
              return;
            }
            this.d.setText(2131917067);
            this.e.setText(2131917066);
          }
          else
          {
            this.d.setText(2131917067);
            this.e.setText(2131917065);
            this.g.setText(2131917064);
          }
        }
        else {
          this.d.setText(2131917068);
        }
      }
      else {
        this.d.setText(2131917069);
      }
      int i1 = this.k;
      if (i1 != paramInt)
      {
        this.l = true;
        if ((i1 == 2) || (i1 == 1))
        {
          localObject = new ArrayList();
          ((List)localObject).addAll(this.h);
          this.i.put(Integer.valueOf(this.k), localObject);
        }
        this.h.clear();
      }
      this.k = paramInt;
      if (this.i.containsKey(Integer.valueOf(paramInt))) {
        this.h.addAll((Collection)this.i.get(Integer.valueOf(paramInt)));
      }
      localObject = this.j;
      if (localObject != null) {
        ((TeamWorkAuthorizeUinListAdapter)localObject).a(this.k);
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pubFlag error:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.e("TeamWorkAuthorizeSettingFragment", 1, ((StringBuilder)localObject).toString());
  }
  
  private void a(TeamWorkAuthorizeUinListAdapter.Holder paramHolder)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(getBaseActivity(), null);
    SparseArray localSparseArray = new SparseArray();
    int i2 = this.k;
    int i1 = 2;
    if (i2 != 2)
    {
      localActionSheet.addButton(getString(2131917065), 5);
      localSparseArray.put(0, Integer.valueOf(2131917065));
      localActionSheet.addButton(getString(2131917066), 5);
      localSparseArray.put(1, Integer.valueOf(2131917066));
    }
    else
    {
      i1 = 0;
    }
    localActionSheet.addButton(getString(2131887718), 3);
    localSparseArray.put(i1, Integer.valueOf(2131887718));
    localActionSheet.setOnButtonClickListener(new TeamWorkAuthorizeSettingFragment.5(this, paramHolder, localSparseArray, localActionSheet));
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.show();
  }
  
  private void a(boolean paramBoolean)
  {
    ViewGroup localViewGroup1 = (ViewGroup)this.mContentView.findViewById(2131433635);
    ViewGroup localViewGroup2 = (ViewGroup)this.mContentView.findViewById(2131434221);
    ViewGroup localViewGroup3 = (ViewGroup)this.mContentView.findViewById(2131427763);
    int i3 = 0;
    int i1 = 0;
    while (i1 < localViewGroup1.getChildCount())
    {
      localViewGroup1.getChildAt(i1).setEnabled(paramBoolean);
      i1 += 1;
    }
    i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= localViewGroup2.getChildCount()) {
        break;
      }
      localViewGroup2.getChildAt(i1).setEnabled(paramBoolean);
      i1 += 1;
    }
    while (i2 < localViewGroup3.getChildCount())
    {
      localViewGroup3.getChildAt(i2).setEnabled(paramBoolean);
      i2 += 1;
    }
    localViewGroup1.setEnabled(paramBoolean);
    localViewGroup2.setEnabled(paramBoolean);
    localViewGroup3.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      a(this.k);
      b();
      localViewGroup1.setOnClickListener(this);
      localViewGroup2.setOnClickListener(this);
      localViewGroup3.setOnClickListener(this);
      return;
    }
    localViewGroup1.setOnClickListener(null);
    localViewGroup2.setOnClickListener(null);
    localViewGroup3.setOnClickListener(null);
  }
  
  private void b()
  {
    View localView1 = this.mContentView.findViewById(2131431547);
    View localView2 = this.mContentView.findViewById(2131434221);
    int i1 = this.k;
    if (i1 == 2)
    {
      localView2.setVisibility(0);
      localView1.setVisibility(0);
      return;
    }
    if (i1 == 3)
    {
      localView2.setVisibility(0);
      localView1.setVisibility(8);
      return;
    }
    if (i1 == 1)
    {
      localView2.setVisibility(8);
      localView1.setVisibility(0);
      return;
    }
    localView1.setVisibility(8);
    localView2.setVisibility(8);
  }
  
  private void c()
  {
    Intent localIntent = getBaseActivity().getIntent();
    String str = localIntent.getStringExtra("team_work_name");
    if (TextUtils.isEmpty(str)) {
      this.c.setVisibility(8);
    }
    TextView localTextView = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("对\"");
    localStringBuilder.append(str);
    localStringBuilder.append("\"进行设置");
    localTextView.setText(localStringBuilder.toString());
    this.a = localIntent.getStringExtra("team_work_pad_url");
    this.b = localIntent.getIntExtra("team_work_pad_list_type", -1);
    this.k = localIntent.getIntExtra("team_work_public_tag", -1);
    this.i = new HashMap();
    this.h = new ArrayList();
    this.j = new TeamWorkAuthorizeUinListAdapter(this.p, getBaseActivity(), this, this.h);
    this.f.setAdapter(this.j);
  }
  
  private void d()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < this.h.size())
    {
      localArrayList.add(String.valueOf(((TeamWorkAuthorizeUinListAdapter.ItemData)this.h.get(i1)).b));
      i1 += 1;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("param_uins_selected_default", localArrayList);
    localIntent.putExtra("param_type", 9504);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_entrance", 31);
    localIntent.putExtra("param_min", 0);
    localIntent.putExtra("param_max", 2000);
    localIntent.putExtra("param_enable_all_select", true);
    localIntent.putExtra("param_overload_tips_include_default_count", true);
    localIntent.putExtra("param_donot_need_contacts", true);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(getActivity(), localIntent, 1001);
  }
  
  private void e()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(getBaseActivity(), null);
    SparseArray localSparseArray = new SparseArray();
    localActionSheet.addButton(getString(2131917067), 5);
    localSparseArray.put(0, Integer.valueOf(2131917067));
    localActionSheet.addButton(getString(2131917068), 5);
    localSparseArray.put(1, Integer.valueOf(2131917068));
    localActionSheet.addButton(getString(2131917069), 5);
    localSparseArray.put(2, Integer.valueOf(2131917069));
    localActionSheet.setOnButtonClickListener(new TeamWorkAuthorizeSettingFragment.3(this, localSparseArray, localActionSheet));
    localActionSheet.setMainTitle(HardCodeUtil.a(2131912081));
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.show();
  }
  
  private void f()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(getBaseActivity(), null);
    SparseArray localSparseArray = new SparseArray();
    localActionSheet.addButton(getString(2131917065), 5);
    localSparseArray.put(0, Integer.valueOf(2131917065));
    localActionSheet.addButton(getString(2131917066), 5);
    localSparseArray.put(1, Integer.valueOf(2131917066));
    localActionSheet.setOnButtonClickListener(new TeamWorkAuthorizeSettingFragment.4(this, localSparseArray, localActionSheet));
    localActionSheet.setMainTitle(HardCodeUtil.a(2131912126));
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.show();
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    startTitleProgress();
    this.p = getBaseActivity().app;
    this.p.addObserver(this.n);
    a();
    c();
    this.o = ((ITeamWorkHandler)this.p.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER));
    this.o.getPadRightsInfo(this.b, this.a);
    ReportController.b(this.p, "dc00898", "", "", "0x8007CF5", "0x8007CF5", 0, 0, "", "", "", "");
    a(false);
    this.p.addObserver(this.m);
  }
  
  protected int getContentLayoutId()
  {
    return 2131629373;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1001) && (-1 == paramInt2))
    {
      paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)paramIntent.next();
          TimDocSSOMsg.UinRightInfo localUinRightInfo = new TimDocSSOMsg.UinRightInfo();
          localUinRightInfo.uint64_uin.set(Long.parseLong(localResultRecord.uin));
          localUinRightInfo.uint32_right.set(2);
          localUinRightInfo.uint32_uin_type.set(0);
          TeamWorkAuthorizeUinListAdapter.ItemData localItemData = new TeamWorkAuthorizeUinListAdapter.ItemData();
          localItemData.b = localResultRecord.uin;
          localItemData.e = localResultRecord.name;
          localItemData.d = localResultRecord.groupUin;
          localItemData.c = localResultRecord.type;
          localItemData.a = localUinRightInfo;
          this.j.a(localItemData);
          this.l = true;
        }
      }
      this.j.notifyDataSetChanged();
    }
  }
  
  public boolean onBackEvent()
  {
    ReportController.b(this.p, "dc00898", "", "", "0x8007D01", "0x8007D01", 0, 0, "", "", "", "");
    if (this.l)
    {
      DialogUtil.a(getBaseActivity(), 230, getString(2131917059), "", 2131917058, 2131917060, new TeamWorkAuthorizeSettingFragment.6(this), new TeamWorkAuthorizeSettingFragment.7(this)).show();
      return false;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131446931: 
      a((TeamWorkAuthorizeUinListAdapter.Holder)paramView.getTag());
      if (this.k == 1) {
        ReportController.b(this.p, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
      }
      break;
    case 2131436211: 
      ReportController.b(this.p, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext())
      {
        TeamWorkAuthorizeUinListAdapter.ItemData localItemData = (TeamWorkAuthorizeUinListAdapter.ItemData)localIterator.next();
        if (this.k == 2) {
          localItemData.a.uint32_right.set(2);
        }
        localArrayList.add(localItemData.a);
      }
      this.o.setPadRightsInfo(this.k, this.a, this.b, localArrayList);
      a(false);
      getRightTextView().setEnabled(false);
      startTitleProgress();
      break;
    case 2131434221: 
      f();
      ReportController.b(this.p, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
      break;
    case 2131433635: 
      e();
      ReportController.b(this.p, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
      break;
    case 2131427763: 
      d();
      ReportController.b(this.p, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroyView()
  {
    QQAppInterface localQQAppInterface = this.p;
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.n);
    }
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment
 * JD-Core Version:    0.7.0.1
 */