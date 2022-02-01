package com.tencent.mobileqq.search.business.contact.model;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.api.ISearchUtilFetcher;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.search.model.SearchMatchResult;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.ChnSpelling;
import com.tencent.mobileqq.utils.ChnToSpell.ChnSpellingAll;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ContactSearchModelFriend
  extends IContactSearchModel
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Friends jdField_a_of_type_ComTencentMobileqqDataFriends;
  public ChnToSpell.ChnSpelling a;
  public ChnToSpell.ChnSpellingAll a;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long = IContactSearchable.E;
  public ChnToSpell.ChnSpelling b;
  public ChnToSpell.ChnSpellingAll b;
  private String jdField_b_of_type_JavaLangString;
  public ChnToSpell.ChnSpelling c;
  private String c;
  public ChnToSpell.ChnSpelling d;
  private String d;
  
  public ContactSearchModelFriend(AppInterface paramAppInterface, int paramInt, Friends paramFriends, String paramString, long paramLong)
  {
    super(paramAppInterface, paramInt, paramLong);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = paramFriends;
    if (((IRecentUserProxyService)paramAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().c(paramFriends.uin)) {
      this.jdField_b_of_type_Long = IContactSearchable.z;
    } else if (paramFriends.gathtertype == 1) {
      this.jdField_b_of_type_Long = IContactSearchable.F;
    } else if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isQidianMaster(paramFriends.cSpecialFlag)) {
      this.jdField_b_of_type_Long = IContactSearchable.W;
    } else if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isSpecialCareInfo(paramFriends.uin)) {
      this.jdField_b_of_type_Long = IContactSearchable.D;
    }
    if (!TextUtils.isEmpty(paramFriends.remark))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpellingAll = ChnToSpell.a(paramFriends.remark);
      paramAppInterface = this.jdField_a_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpellingAll;
      if (paramAppInterface != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpelling = paramAppInterface.a();
        this.jdField_b_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpelling = this.jdField_a_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpellingAll.b();
      }
    }
    if (!TextUtils.isEmpty(paramFriends.name))
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpellingAll = ChnToSpell.a(paramFriends.name);
      paramAppInterface = this.jdField_b_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpellingAll;
      if (paramAppInterface != null)
      {
        this.jdField_c_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpelling = paramAppInterface.a();
        this.jdField_d_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpelling = this.jdField_b_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpellingAll.b();
      }
    }
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
          if (i != 3)
          {
            this.jdField_b_of_type_JavaLangString = "";
            return;
          }
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark))
          {
            this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
            this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias;
            return;
          }
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name))
          {
            this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name;
            this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias;
            return;
          }
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias;
          this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
          return;
        }
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
        this.jdField_c_of_type_JavaLangString = SearchUtils.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin });
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark))
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
        this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name;
        return;
      }
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name;
      this.jdField_c_of_type_JavaLangString = SearchUtils.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin });
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark))
    {
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name))
    {
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name;
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
      return;
    }
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
    this.jdField_c_of_type_JavaLangString = null;
  }
  
  public int a()
  {
    return 1;
  }
  
  protected long a(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    long l = SearchUtils.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, this.jdField_a_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpelling, this.jdField_b_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpelling, IContactSearchable.g);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 2;
    }
    l = SearchUtils.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, this.jdField_c_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpelling, this.jdField_d_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpelling, IContactSearchable.l);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 1;
    }
    l = SearchUtils.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias, IContactSearchable.n, false);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 3;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.strMasterUin)) {
      l = SearchUtils.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataFriends.strMasterUin, IContactSearchable.o, false);
    } else {
      l = SearchUtils.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, IContactSearchable.o, false);
    }
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 0;
    }
    l = this.jdField_a_of_type_Long;
    if (l != -9223372036854775808L)
    {
      this.jdField_a_of_type_Long = (l + this.jdField_b_of_type_Long);
      a();
    }
    return this.jdField_a_of_type_Long;
  }
  
  public Pair<CharSequence, CharSequence> a()
  {
    int i = this.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return null;
          }
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) {
            return new Pair(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, SearchUtils.c(this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias, this.jdField_d_of_type_JavaLangString, 6, true));
          }
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name)) {
            return new Pair(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, SearchUtils.c(this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias, this.jdField_d_of_type_JavaLangString, 6, true));
          }
          return new Pair(SearchUtils.b(this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias, this.jdField_d_of_type_JavaLangString, 6, true), null);
        }
        return new Pair(SearchUtils.b(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, this.jdField_d_of_type_JavaLangString, 6, true), null);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) {
        return new Pair(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, SearchUtils.c(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, this.jdField_d_of_type_JavaLangString, 6, true));
      }
      return new Pair(SearchUtils.b(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, this.jdField_d_of_type_JavaLangString, 6, true), null);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) {
      return new Pair(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, SearchUtils.c(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, this.jdField_d_of_type_JavaLangString, 6, false));
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name)) {
      return new Pair(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, SearchUtils.c(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, this.jdField_d_of_type_JavaLangString, 6, false));
    }
    return new Pair(SearchUtils.b(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, this.jdField_d_of_type_JavaLangString, 6, false), null);
  }
  
  public SearchMatchResult a(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    Object localObject1 = ChnToSpell.a(paramString);
    SearchMatchResult localSearchMatchResult = SearchUtils.a(paramString, (ChnToSpell.ChnSpellingAll)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, this.jdField_a_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpellingAll, IContactSearchable.g);
    localObject1 = SearchUtils.a(paramString, (ChnToSpell.ChnSpellingAll)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, this.jdField_b_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpellingAll, IContactSearchable.g);
    Object localObject2;
    if ((localSearchMatchResult != null) && (localSearchMatchResult.a))
    {
      if ((localObject1 != null) && (((SearchMatchResult)localObject1).a) && (((SearchMatchResult)localObject1).c > localSearchMatchResult.c)) {
        this.jdField_a_of_type_Int = 1;
      } else {
        localObject1 = null;
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        this.jdField_a_of_type_Int = 2;
        localObject2 = localSearchMatchResult;
      }
    }
    else
    {
      localObject2 = null;
    }
    if ((localObject2 != null) && (((SearchMatchResult)localObject2).a))
    {
      this.jdField_b_of_type_Boolean = true;
      this.a = ((SearchMatchResult)localObject2);
      a();
      return localObject2;
    }
    return super.a(paramString);
  }
  
  public CharSequence a()
  {
    if (SearchUtils.a(this.jdField_b_of_type_Int))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131702712));
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      return localStringBuilder.toString();
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    Object localObject;
    if (SearchUtils.a(this.jdField_b_of_type_Int))
    {
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).setContactSearchRecentAndHistroy(paramView.getContext(), this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, this.jdField_a_of_type_ComTencentMobileqqDataFriends, this.jdField_d_of_type_JavaLangString, paramView);
      String str = b().toString();
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d(h, 2, "saveSearchHistory title is null");
        }
        str = c();
        localObject = str;
        if (TextUtils.isEmpty(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d(h, 2, "saveSearchHistory titlestr is null");
          }
          localObject = d();
        }
      }
      SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, "", 0);
      SearchUtils.a(this.jdField_d_of_type_JavaLangString, 20, paramView, false);
      ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).reportContactResultItemClick(this, paramView);
      if (SearchConfigManager.needSeparate) {
        SearchUtils.a("search", "contact", "contacts", 0, 0, new String[] { SearchUtils.a(this.jdField_b_of_type_Int) });
      }
      if (((a() instanceof String)) && (!this.jdField_b_of_type_Boolean)) {
        SearchUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_d_of_type_JavaLangString, this.i, (String)a(), e());
      }
      if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(paramView.getContext()))
      {
        if ((this.i != null) && (!TextUtils.isEmpty(this.i)))
        {
          UniteSearchReportController.a(null, 0, this.jdField_b_of_type_Int, "0X8009D31", ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getMostUseConstantsReportContact(), 0, null, null);
          return;
        }
        UniteSearchReportController.a(null, 0, this.jdField_b_of_type_Int, "0X8009D37", 0, 0, null, null);
      }
    }
    else
    {
      if (11 == this.jdField_b_of_type_Int)
      {
        localObject = (QBaseActivity)paramView.getContext();
        if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isSpecialCareInfo(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
        {
          QQToast.a((Context)localObject, ((QBaseActivity)localObject).getString(2131699315), 0).b(((QBaseActivity)localObject).getTitleBarHeight());
          return;
        }
      }
      ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).selectContactResult(paramView, this);
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_b_of_type_Int != 21) && (this.jdField_b_of_type_Int != 1)) {
      return this.jdField_b_of_type_Int == 2;
    }
    return true;
  }
  
  public String b()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public String c()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public int d()
  {
    return 0;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return this.jdField_c_of_type_JavaLangString;
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
        if (i != 2) {
          if (i == 3) {
            break label89;
          }
        } else {
          return localCharSequence1;
        }
      }
      else
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) {
          return localCharSequence1;
        }
        if ((localCharSequence2 != null) && (localCharSequence2.length() > 2)) {
          return localCharSequence2.subSequence(1, localCharSequence2.length() - 1);
        }
      }
      return super.e();
    }
    label89:
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (localCharSequence1 != null) {
      localSpannableStringBuilder.append(localCharSequence1);
    }
    if (localCharSequence2 != null) {
      localSpannableStringBuilder.append(localCharSequence2);
    }
    return localSpannableStringBuilder;
  }
  
  public int f()
  {
    return this.jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelFriend
 * JD-Core Version:    0.7.0.1
 */