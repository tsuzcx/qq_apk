package com.tencent.mobileqq.search.business.contact.model;

import android.app.Activity;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.selectmember.SelectMemberUtils;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class ContactSearchModelCreateDiscussion
  extends IContactSearchModel
{
  String a;
  List<IContactSearchModel> b;
  private long c = 0L;
  
  public ContactSearchModelCreateDiscussion(AppInterface paramAppInterface, int paramInt, String paramString, List<IContactSearchModel> paramList)
  {
    super(paramAppInterface, paramInt, 0L);
    this.a = paramString;
    this.b = paramList;
    f(12);
  }
  
  private CharSequence s()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append("邀请:");
    int i = 0;
    while (i < this.b.size())
    {
      if (i != 0) {
        localSpannableStringBuilder.append("、");
      }
      localSpannableStringBuilder.append(((IContactSearchModel)this.b.get(i)).q());
      i += 1;
    }
    return localSpannableStringBuilder;
  }
  
  public CharSequence a()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject = this.b;
    int i;
    if (localObject != null) {
      i = ((List)localObject).size();
    } else {
      i = 0;
    }
    localObject = localSpannableStringBuilder.append("已选择");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(i);
    ((SpannableStringBuilder)localObject).append(localStringBuilder.toString()).append("人");
    return localSpannableStringBuilder;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    long l = System.currentTimeMillis();
    if (l - this.c < 1500L) {
      return;
    }
    Object localObject;
    if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(paramView.getContext()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.a);
      SearchUtils.a("all_result", "clk_discuss", new String[] { ((StringBuilder)localObject).toString() });
    }
    this.c = l;
    Intent localIntent = new Intent();
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1002);
    localIntent.putExtra("param_min", 2);
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("param_entrance", 28);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.b.size())
    {
      IContactSearchModel localIContactSearchModel = (IContactSearchModel)this.b.get(i);
      String str1 = localIContactSearchModel.c();
      String str2 = localIContactSearchModel.q().toString();
      boolean bool = localIContactSearchModel instanceof ContactSearchModelDiscussionMember;
      localObject = "-1";
      if (bool) {}
      for (localObject = ((ContactSearchModelDiscussionMember)localIContactSearchModel).s();; localObject = ((ContactSearchModelNewTroopMember)localIContactSearchModel).a)
      {
        j = 2;
        break label285;
        if (!(localIContactSearchModel instanceof ContactSearchModelNewTroopMember)) {
          break;
        }
      }
      bool = localIContactSearchModel instanceof ContactSearchModelFriend;
      int j = 0;
      label285:
      localArrayList.add(SelectMemberUtils.a(str1, str2, j, (String)localObject));
      i += 1;
    }
    localIntent.putExtra("param_done_button_wording", this.m.getApp().getString(2131916211));
    localIntent.putExtra("param_done_button_highlight_wording", this.m.getApp().getString(2131916212));
    localIntent.putExtra("param_title", HardCodeUtil.a(2131900698));
    localIntent.putExtra("param_selected_records_for_create_discussion", localArrayList);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult((Activity)paramView.getContext(), localIntent, 1300);
    ReportController.b(this.m, "CliOper", "", "", "0X800635F", "0X800635F", 0, 0, "", "", "", "");
    UniteSearchReportController.a(null, 0, this.n, "0X800BDC1", 0, 0, null, null);
  }
  
  public int b()
  {
    return 9889987;
  }
  
  public String c()
  {
    return String.valueOf(9889987);
  }
  
  public CharSequence d()
  {
    return s();
  }
  
  public CharSequence e()
  {
    return "";
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public String g()
  {
    return this.a;
  }
  
  public boolean h()
  {
    return false;
  }
  
  public Object i()
  {
    return Integer.valueOf(9889987);
  }
  
  public int j()
  {
    return 9889987;
  }
  
  public String m()
  {
    return s().toString();
  }
  
  public String n()
  {
    return "";
  }
  
  protected long n_(String paramString)
  {
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelCreateDiscussion
 * JD-Core Version:    0.7.0.1
 */