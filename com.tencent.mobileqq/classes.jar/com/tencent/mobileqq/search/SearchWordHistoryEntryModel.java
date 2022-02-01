package com.tencent.mobileqq.search;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.adapter.SearchWordHistoryAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SearchWordHistoryManager;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.MeasureListView;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class SearchWordHistoryEntryModel
  extends BaseSearchEntryModel<View>
{
  protected View d;
  protected MeasureListView e;
  protected TextView f;
  protected RelativeLayout g;
  protected ImageView h;
  protected int i;
  protected SearchWordHistoryAdapter j;
  private TextView k = null;
  private TextView l = null;
  private TextView m = null;
  private TextView n = null;
  private Context o;
  private QQAppInterface p;
  
  public SearchWordHistoryEntryModel(int paramInt)
  {
    super(paramInt);
    this.i = paramInt;
  }
  
  private void d()
  {
    SearchWordHistoryAdapter localSearchWordHistoryAdapter = this.j;
    if (localSearchWordHistoryAdapter != null) {
      localSearchWordHistoryAdapter.a();
    }
  }
  
  public View a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.p = paramQQAppInterface;
    this.o = paramContext;
    this.d = LayoutInflater.from(this.o).inflate(2131625841, null);
    paramViewGroup = this.d;
    int i1 = 0;
    paramViewGroup.setVisibility(0);
    this.e = ((MeasureListView)this.d.findViewById(2131435061));
    this.e.setDivider(null);
    this.f = ((TextView)this.d.findViewById(2131445430));
    this.g = ((RelativeLayout)this.d.findViewById(2131431717));
    this.h = ((ImageView)this.d.findViewById(2131431718));
    paramViewGroup = new AbsListView.LayoutParams(-1, DisplayUtil.a(this.o, 7.0F));
    this.k = new TextView(this.o);
    this.k.setLayoutParams(paramViewGroup);
    paramViewGroup = (LinearLayout)LayoutInflater.from(this.o).inflate(2131629223, null);
    this.l = ((TextView)paramViewGroup.findViewById(2131429708));
    this.m = ((TextView)paramViewGroup.findViewById(2131429709));
    this.n = ((TextView)paramViewGroup.findViewById(2131429710));
    this.e.addHeaderView(this.k);
    this.e.addFooterView(paramViewGroup);
    boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    this.k.setBackgroundResource(2130852377);
    if (bool) {
      this.h.setImageResource(2130843361);
    }
    this.j = new SearchWordHistoryAdapter(this.o, this.p, this.d, this.i);
    this.e.setOnTouchListener(new SearchWordHistoryEntryModel.1(this));
    this.g.setOnClickListener(new SearchWordHistoryEntryModel.2(this, paramContext, paramQQAppInterface));
    paramViewGroup = ((SearchWordHistoryManager)this.p.getManager(QQManagerFactory.SEARCH_WORD_HISTORY_MANAGER)).b();
    if (!paramViewGroup.isEmpty())
    {
      paramContext = new StringBuilder("");
      while (i1 < paramViewGroup.size())
      {
        if (i1 != paramViewGroup.size() - 1)
        {
          paramContext.append((String)paramViewGroup.get(i1));
          paramContext.append("::");
        }
        else
        {
          paramContext.append((String)paramViewGroup.get(i1));
        }
        i1 += 1;
      }
      paramViewGroup = new ReportModelDC02528().module("search_his").action("exp_search_his").ver2(UniteSearchReportController.a(this.i)).ver4(paramContext.toString());
      paramBundle = new StringBuilder();
      paramBundle.append("{experiment_id:");
      paramBundle.append(UniteSearchReportController.b);
      paramBundle.append("}");
      UniteSearchReportController.a(null, paramViewGroup.ver7(paramBundle.toString()));
      paramViewGroup = new UniteSearchHandler(paramQQAppInterface);
      paramBundle = UniteSearchReportController.a(this.i);
      paramContext = paramContext.toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{experiment_id:");
      localStringBuilder.append(UniteSearchReportController.b);
      localStringBuilder.append("}");
      paramViewGroup.b(paramQQAppInterface, "exp_search_his", "search_his", paramBundle, "", paramContext, localStringBuilder.toString());
    }
    return this.d;
  }
  
  public void a()
  {
    super.a();
    this.e.setAdapter(this.j);
    d();
  }
  
  public void b()
  {
    super.b();
    if (this.j != null) {
      this.j = null;
    }
  }
  
  public void c()
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchWordHistoryEntryModel
 * JD-Core Version:    0.7.0.1
 */