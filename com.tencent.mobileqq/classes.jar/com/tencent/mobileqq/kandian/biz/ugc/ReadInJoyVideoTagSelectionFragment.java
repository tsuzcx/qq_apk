package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyFlowLayout;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.handler.TagInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ReadInJoyVideoTagSelectionFragment
  extends QIphoneTitleBarFragment
  implements View.OnClickListener
{
  private ReadInJoyVideoTagSelectionFragment.SelectedTagsAdapter a;
  private ReadInJoyVideoTagSelectionFragment.TagsAdapter b;
  private TextView c;
  private View d;
  private View e;
  private View f;
  private QQToast g;
  private QQToast w;
  private DataSetObserver x = new ReadInJoyVideoTagSelectionFragment.1(this);
  private DataSetObserver y = new ReadInJoyVideoTagSelectionFragment.2(this);
  private ReadInJoyObserver z = new ReadInJoyVideoTagSelectionFragment.3(this);
  
  private void b()
  {
    this.f.setVisibility(0);
  }
  
  private void c()
  {
    this.f = this.t.findViewById(2131446823);
    this.f.setOnClickListener(this);
    this.c = ((TextView)this.t.findViewById(2131447279));
    this.d = this.t.findViewById(2131431362);
    this.e = this.t.findViewById(2131431355);
    ReadInJoyFlowLayout localReadInJoyFlowLayout = (ReadInJoyFlowLayout)this.t.findViewById(2131433478);
    this.a = new ReadInJoyVideoTagSelectionFragment.SelectedTagsAdapter(getQBaseActivity(), 2131626355);
    this.a.registerDataSetObserver(this.x);
    localReadInJoyFlowLayout.setAdapter(this.a);
    localReadInJoyFlowLayout.setOnItemClickListener(new ReadInJoyVideoTagSelectionFragment.4(this));
    localReadInJoyFlowLayout = (ReadInJoyFlowLayout)this.t.findViewById(2131433479);
    this.b = new ReadInJoyVideoTagSelectionFragment.TagsAdapter(getQBaseActivity(), 2131626355);
    this.b.registerDataSetObserver(this.y);
    localReadInJoyFlowLayout.setAdapter(this.b);
    this.b.notifyDataSetChanged();
    localReadInJoyFlowLayout.setOnItemClickListener(new ReadInJoyVideoTagSelectionFragment.5(this));
    this.g = QQToast.makeText(getQBaseActivity(), 2131915533, 0);
    this.w = QQToast.makeText(getQBaseActivity(), 2131915532, 0);
    d();
  }
  
  private void d()
  {
    Object localObject2 = getQBaseActivity().getIntent();
    if (localObject2 != null)
    {
      localObject1 = ((Intent)localObject2).getStringExtra("EXTRA_TOPIC_ID");
      if (localObject1 == null) {}
    }
    try
    {
      localObject1 = Long.valueOf((String)localObject1);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label31:
      ArrayList localArrayList;
      break label31;
    }
    QLog.d("ReadInJoyVideoTagSelectionFragment", 2, "handleIntent: fail to get topicId");
    Object localObject1 = null;
    localArrayList = ((Intent)localObject2).getParcelableArrayListExtra("EXTRA_SELECTED_TAG_LIST");
    localObject2 = localObject1;
    if (localArrayList != null)
    {
      this.a.addAll(localArrayList);
      localObject2 = localObject1;
      break label69;
      localObject2 = null;
    }
    label69:
    this.a.notifyDataSetChanged();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.z);
    if (localObject2 != null)
    {
      ReadInJoyLogicEngine.a().c(((Long)localObject2).longValue());
      return;
    }
    ReadInJoyLogicEngine.a().f(null);
  }
  
  private void e()
  {
    this.p.changeBg(true);
    c(2131888010, this);
    this.k.setTextColor(-16265040);
    this.k.setBackgroundResource(0);
    a(getString(2131915512));
    this.h.setText(2131887440);
    Utils.a(this);
  }
  
  private void f()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("EXTRA_SELECTION_REACH_MAXIMUM_NUMBER", this.a.a());
    QPublicFragmentActivity.Launcher.a(getQBaseActivity(), localIntent, QPublicTransFragmentActivity.class, ReadInJoyVideoSearchTagFragment.class, 1000);
  }
  
  private void g()
  {
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    int j = this.a.getCount();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(this.a.getItem(i));
      i += 1;
    }
    localIntent.putParcelableArrayListExtra("EXTRA_SELECTED_TAG_LIST", localArrayList);
    getQBaseActivity().setResult(-1, localIntent);
    getQBaseActivity().finish();
    PublicAccountReportUtils.a(null, "", "0X80092F2", "0X80092F2", 0, 0, Integer.valueOf(localArrayList.size()).toString(), "", "", RIJTransMergeKanDianReport.e(), false);
  }
  
  protected int a()
  {
    return 2131626354;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    c();
    RIJDtReportHelper.a.a(getQBaseActivity());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1000) && (paramInt2 == -1))
    {
      paramIntent = (TagInfo)paramIntent.getParcelableExtra("SEARCH_TAG_RESULT");
      if ((paramIntent != null) && (!this.a.a(paramIntent)) && (!this.g.isShowing())) {
        this.g.show();
      }
    }
  }
  
  public boolean onBackEvent()
  {
    g();
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131436211)
    {
      if (i != 2131446823) {
        return;
      }
      this.f.setVisibility(8);
      f();
      return;
    }
    g();
  }
  
  public void onPause()
  {
    super.onPause();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.z);
  }
  
  public void onResume()
  {
    super.onResume();
    e();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyVideoTagSelectionFragment
 * JD-Core Version:    0.7.0.1
 */