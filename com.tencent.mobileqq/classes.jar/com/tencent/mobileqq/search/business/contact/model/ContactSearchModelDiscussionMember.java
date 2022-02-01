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
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private DiscussionMemberInfo jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public ContactSearchModelDiscussionMember(AppInterface paramAppInterface, int paramInt, DiscussionMemberInfo paramDiscussionMemberInfo)
  {
    super(paramAppInterface, paramInt, 0L);
    this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo = paramDiscussionMemberInfo;
  }
  
  private void a()
  {
    int i = this.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          this.jdField_a_of_type_JavaLangString = "";
          return;
        }
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName))
        {
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName;
          return;
        }
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark))
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark;
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName;
        return;
      }
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark))
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName))
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
      return;
    }
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
    this.jdField_b_of_type_JavaLangString = null;
  }
  
  public int a()
  {
    return 1;
  }
  
  protected long a(String paramString)
  {
    DiscussionInfo localDiscussionInfo = (DiscussionInfo)((IDiscussionService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IDiscussionService.class, "")).findDiscussionInfoByID(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.discussionUin);
    if ((localDiscussionInfo != null) && (!localDiscussionInfo.isDiscussHrMeeting()) && (!localDiscussionInfo.isHidden()))
    {
      this.c = paramString;
      this.jdField_a_of_type_Long = -9223372036854775808L;
      long l = SearchUtils.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark, IContactSearchable.k);
      if (l > this.jdField_a_of_type_Long)
      {
        this.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_Int = 2;
      }
      l = SearchUtils.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName, IContactSearchable.l);
      if (l > this.jdField_a_of_type_Long)
      {
        this.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_Int = 1;
      }
      l = SearchUtils.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin, IContactSearchable.o, false);
      if (l > this.jdField_a_of_type_Long)
      {
        this.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_Int = 0;
      }
      l = this.jdField_a_of_type_Long;
      if (l != -9223372036854775808L)
      {
        this.jdField_a_of_type_Long = (l + IContactSearchable.H);
        a();
      }
      return this.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_Long = -9223372036854775808L;
    return this.jdField_a_of_type_Long;
  }
  
  public Pair<CharSequence, CharSequence> a()
  {
    int i = this.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return null;
        }
        return new Pair(SearchUtils.b(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark, this.c, 6, true), null);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark)) {
        return new Pair(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark, SearchUtils.c(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName, this.c, 6, true));
      }
      return new Pair(SearchUtils.b(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName, this.c, 6, true), null);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark)) {
      return new Pair(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark, SearchUtils.c(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin, this.c, 6, false));
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName)) {
      return new Pair(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName, SearchUtils.c(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin, this.c, 6, false));
    }
    return new Pair(SearchUtils.b(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin, this.c, 6, false), null);
  }
  
  public CharSequence a()
  {
    if (SearchUtils.a(this.jdField_b_of_type_Int)) {
      return HardCodeUtil.a(2131702734);
    }
    return HardCodeUtil.a(2131702694);
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (SearchUtils.a(this.jdField_b_of_type_Int))
    {
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).enterTroopTmpChatWin(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.discussionUin, 1004, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName, false, null, null);
      SearchUtils.a(this.c, 20, 1, paramView);
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.c);
      SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, b().toString(), this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.discussionUin, 1004);
      SearchUtils.a(this.c, 20, paramView, false);
      SearchUtils.a(this, paramView);
      if (SearchConfigManager.needSeparate) {
        SearchUtils.a("search", "contact", "contacts", 0, 0, new String[] { SearchUtils.a(this.jdField_b_of_type_Int) });
      }
      if (((a() instanceof String)) && (!this.jdField_b_of_type_Boolean)) {
        SearchUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.c, this.i, (String)a(), e());
      }
      if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(paramView.getContext()))
      {
        if ((this.i != null) && (!TextUtils.isEmpty(this.i)))
        {
          UniteSearchReportController.a(null, 0, this.jdField_b_of_type_Int, "0X8009D31", 1, 0, null, null);
          return;
        }
        UniteSearchReportController.a(null, 0, this.jdField_b_of_type_Int, "0X8009D37", 0, 0, null, null);
      }
    }
    else
    {
      SearchUtils.a(paramView, this);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public int d()
  {
    return 1004;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public int e()
  {
    return 1;
  }
  
  public CharSequence e()
  {
    CharSequence localCharSequence1 = b();
    CharSequence localCharSequence2 = c();
    int i = this.jdField_a_of_type_Int;
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
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark)) {
          return localCharSequence1;
        }
        if ((localCharSequence2 != null) && (localCharSequence2.length() > 2)) {
          return localCharSequence2.subSequence(1, localCharSequence2.length() - 1);
        }
      }
      return super.e();
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
  
  public String e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.discussionUin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelDiscussionMember
 * JD-Core Version:    0.7.0.1
 */