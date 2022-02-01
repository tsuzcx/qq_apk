package com.tencent.mobileqq.search.business.contact.model;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.troop.api.IDiscussionService;

public class ContactSearchModelDiscussionMember
  extends IContactSearchModel
{
  private DiscussionMemberInfo a;
  private long b;
  private int c;
  private String d;
  private String e;
  private String f;
  
  public ContactSearchModelDiscussionMember(AppInterface paramAppInterface, int paramInt, DiscussionMemberInfo paramDiscussionMemberInfo)
  {
    super(paramAppInterface, paramInt, 0L);
    this.a = paramDiscussionMemberInfo;
    f(6);
  }
  
  private void t()
  {
    int i = this.c;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          this.d = "";
          return;
        }
        this.d = this.a.inteRemark;
        if (!TextUtils.isEmpty(this.a.memberName))
        {
          this.e = this.a.memberName;
          return;
        }
        this.e = this.a.memberUin;
        return;
      }
      if (!TextUtils.isEmpty(this.a.inteRemark))
      {
        this.d = this.a.inteRemark;
        this.e = this.a.memberName;
        return;
      }
      this.d = this.a.memberName;
      this.e = this.a.memberUin;
      return;
    }
    if (!TextUtils.isEmpty(this.a.inteRemark))
    {
      this.d = this.a.inteRemark;
      this.e = this.a.memberUin;
      return;
    }
    if (!TextUtils.isEmpty(this.a.memberName))
    {
      this.d = this.a.memberName;
      this.e = this.a.memberUin;
      return;
    }
    this.d = this.a.memberUin;
    this.e = null;
  }
  
  public CharSequence a()
  {
    if (SearchUtils.b(this.n)) {
      return HardCodeUtil.a(2131900724);
    }
    return HardCodeUtil.a(2131900684);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (SearchUtils.b(this.n))
    {
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).enterTroopTmpChatWin(paramView.getContext(), this.a.memberUin, this.a.discussionUin, 1004, this.a.memberName, false, null, null);
      SearchUtils.a(this.f, 20, 1, paramView);
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.m, this.f);
      SearchUtils.a(this.m, d().toString(), this.a.memberUin, this.a.discussionUin, 1004);
      SearchUtils.a(this.f, 20, paramView, false);
      SearchUtils.a(this, paramView);
      if (SearchConfigManager.needSeparate) {
        SearchUtils.a("search", "contact", "contacts", 0, 0, new String[] { SearchUtils.a(this.n) });
      }
      if (((i() instanceof String)) && (!this.r)) {
        SearchUtils.b(this.m, this.f, this.p, (String)i(), o());
      }
      if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(paramView.getContext()))
      {
        if ((this.p != null) && (!TextUtils.isEmpty(this.p)))
        {
          UniteSearchReportController.a(null, 0, this.n, "0X8009D31", 1, 0, null, null);
          return;
        }
        UniteSearchReportController.a(null, 0, this.n, "0X8009D37", 0, 0, null, null);
      }
    }
    else
    {
      SearchUtils.a(paramView, this);
    }
  }
  
  public int b()
  {
    return 1;
  }
  
  public String c()
  {
    return this.a.memberUin;
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public String g()
  {
    return this.f;
  }
  
  public boolean h()
  {
    return false;
  }
  
  public Object i()
  {
    return this.a.memberUin;
  }
  
  public int j()
  {
    return 1004;
  }
  
  public String m()
  {
    return this.d;
  }
  
  public String n()
  {
    return this.e;
  }
  
  protected long n_(String paramString)
  {
    DiscussionInfo localDiscussionInfo = (DiscussionInfo)((IDiscussionService)this.m.getRuntimeService(IDiscussionService.class, "")).findDiscussionInfoByID(this.a.discussionUin);
    if ((localDiscussionInfo != null) && (!localDiscussionInfo.isDiscussHrMeeting()) && (!localDiscussionInfo.isHidden()))
    {
      this.f = paramString;
      this.b = -9223372036854775808L;
      long l = SearchUtils.b(paramString, this.a.inteRemark, IContactSearchable.o);
      if (l > this.b)
      {
        this.b = l;
        this.c = 2;
      }
      l = SearchUtils.b(paramString, this.a.memberName, IContactSearchable.p);
      if (l > this.b)
      {
        this.b = l;
        this.c = 1;
      }
      l = SearchUtils.a(paramString, this.a.memberUin, IContactSearchable.s, false);
      if (l > this.b)
      {
        this.b = l;
        this.c = 0;
      }
      l = this.b;
      if (l != -9223372036854775808L)
      {
        this.b = (l + IContactSearchable.L);
        t();
      }
      return this.b;
    }
    this.b = -9223372036854775808L;
    return this.b;
  }
  
  public int o()
  {
    return 1;
  }
  
  public CharSequence q()
  {
    CharSequence localCharSequence1 = d();
    CharSequence localCharSequence2 = e();
    int i = this.c;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          return localCharSequence1;
        }
      }
      else
      {
        if (TextUtils.isEmpty(this.a.inteRemark)) {
          return localCharSequence1;
        }
        if ((localCharSequence2 != null) && (localCharSequence2.length() > 2)) {
          return localCharSequence2.subSequence(1, localCharSequence2.length() - 1);
        }
      }
      return super.q();
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (localCharSequence1 != null) {
      localSpannableStringBuilder.append(localCharSequence1);
    }
    if (localCharSequence2 != null) {
      localSpannableStringBuilder.append(localCharSequence2);
    }
    return localSpannableStringBuilder;
  }
  
  public Pair<CharSequence, CharSequence> r()
  {
    int i = this.c;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return null;
        }
        return new Pair(SearchUtils.b(this.a.inteRemark, this.f, 6, true), null);
      }
      if (!TextUtils.isEmpty(this.a.inteRemark)) {
        return new Pair(this.a.inteRemark, SearchUtils.c(this.a.memberName, this.f, 6, true));
      }
      return new Pair(SearchUtils.b(this.a.memberName, this.f, 6, true), null);
    }
    if (!TextUtils.isEmpty(this.a.inteRemark)) {
      return new Pair(this.a.inteRemark, SearchUtils.c(this.a.memberUin, this.f, 6, false));
    }
    if (!TextUtils.isEmpty(this.a.memberName)) {
      return new Pair(this.a.memberName, SearchUtils.c(this.a.memberUin, this.f, 6, false));
    }
    return new Pair(SearchUtils.b(this.a.memberUin, this.f, 6, false), null);
  }
  
  public String s()
  {
    return this.a.discussionUin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelDiscussionMember
 * JD-Core Version:    0.7.0.1
 */