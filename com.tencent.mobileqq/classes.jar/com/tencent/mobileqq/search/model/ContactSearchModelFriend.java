package com.tencent.mobileqq.search.model;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.search.util.SearchMatchResult;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.ChnSpelling;
import com.tencent.mobileqq.utils.ChnToSpell.ChnSpellingAll;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
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
  
  public ContactSearchModelFriend(QQAppInterface paramQQAppInterface, int paramInt, Friends paramFriends, String paramString, long paramLong)
  {
    super(paramQQAppInterface, paramInt, paramLong);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = paramFriends;
    if (paramQQAppInterface.getProxyManager().a().c(paramFriends.uin)) {
      this.jdField_b_of_type_Long = IContactSearchable.z;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramFriends.remark))
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpellingAll = ChnToSpell.a(paramFriends.remark);
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpellingAll != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpelling = this.jdField_a_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpellingAll.a();
          this.jdField_b_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpelling = this.jdField_a_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpellingAll.b();
        }
      }
      if (!TextUtils.isEmpty(paramFriends.name))
      {
        this.jdField_b_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpellingAll = ChnToSpell.a(paramFriends.name);
        if (this.jdField_b_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpellingAll != null)
        {
          this.jdField_c_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpelling = this.jdField_b_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpellingAll.a();
          this.jdField_d_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpelling = this.jdField_b_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpellingAll.b();
        }
      }
      return;
      if (paramFriends.gathtertype == 1) {
        this.jdField_b_of_type_Long = IContactSearchable.F;
      } else if (QidianManager.b(paramFriends.cSpecialFlag)) {
        this.jdField_b_of_type_Long = IContactSearchable.W;
      } else if (((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramFriends.uin) != null) {
        this.jdField_b_of_type_Long = IContactSearchable.D;
      }
    }
  }
  
  private void a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_b_of_type_JavaLangString = "";
      return;
    case 0: 
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
      return;
    case 2: 
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
      this.jdField_c_of_type_JavaLangString = SearchUtils.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin });
      return;
    case 1: 
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
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.strMasterUin)) {}
    for (l = SearchUtils.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataFriends.strMasterUin, IContactSearchable.o, false);; l = SearchUtils.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, IContactSearchable.o, false))
    {
      if (l > this.jdField_a_of_type_Long)
      {
        this.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_Int = 0;
      }
      if (this.jdField_a_of_type_Long != -9223372036854775808L)
      {
        this.jdField_a_of_type_Long += this.jdField_b_of_type_Long;
        a();
      }
      return this.jdField_a_of_type_Long;
    }
  }
  
  public Pair<CharSequence, CharSequence> a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return null;
    case 0: 
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) {
        return new Pair(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, SearchUtils.c(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, this.jdField_d_of_type_JavaLangString, 6, false));
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name)) {
        return new Pair(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, SearchUtils.c(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, this.jdField_d_of_type_JavaLangString, 6, false));
      }
      return new Pair(SearchUtils.b(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, this.jdField_d_of_type_JavaLangString, 6, false), null);
    case 2: 
      return new Pair(SearchUtils.b(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, this.jdField_d_of_type_JavaLangString, 6, true), null);
    case 1: 
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) {
        return new Pair(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, SearchUtils.c(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, this.jdField_d_of_type_JavaLangString, 6, true));
      }
      return new Pair(SearchUtils.b(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, this.jdField_d_of_type_JavaLangString, 6, true), null);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) {
      return new Pair(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, SearchUtils.c(this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias, this.jdField_d_of_type_JavaLangString, 6, true));
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name)) {
      return new Pair(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, SearchUtils.c(this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias, this.jdField_d_of_type_JavaLangString, 6, true));
    }
    return new Pair(SearchUtils.b(this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias, this.jdField_d_of_type_JavaLangString, 6, true), null);
  }
  
  public SearchMatchResult a(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    Object localObject1 = ChnToSpell.a(paramString);
    SearchMatchResult localSearchMatchResult = SearchUtils.a(paramString, (ChnToSpell.ChnSpellingAll)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, this.jdField_a_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpellingAll, IContactSearchable.g);
    localObject1 = SearchUtils.a(paramString, (ChnToSpell.ChnSpellingAll)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, this.jdField_b_of_type_ComTencentMobileqqUtilsChnToSpell$ChnSpellingAll, IContactSearchable.g);
    if ((localSearchMatchResult != null) && (localSearchMatchResult.a)) {
      if ((localObject1 != null) && (((SearchMatchResult)localObject1).a) && (((SearchMatchResult)localObject1).c > localSearchMatchResult.c))
      {
        this.jdField_a_of_type_Int = 1;
        localObject2 = localObject1;
        if (localObject1 == null) {
          this.jdField_a_of_type_Int = 2;
        }
      }
    }
    for (Object localObject2 = localSearchMatchResult;; localObject2 = null)
    {
      if ((localObject2 != null) && (((SearchMatchResult)localObject2).a))
      {
        this.jdField_b_of_type_Boolean = true;
        this.a = ((SearchMatchResult)localObject2);
        a();
        return localObject2;
      }
      return super.a(paramString);
      localObject1 = null;
      break;
    }
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
  }
  
  public String a()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    Object localObject;
    if (SearchUtils.a(this.jdField_b_of_type_Int))
    {
      RecentUtil.a = true;
      RecentUtil.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 0, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends), false);
      SearchUtils.a(this.jdField_d_of_type_JavaLangString, 20, 1, paramView);
      SearchHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString);
      String str = a().toString();
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
      SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, "", 0);
      SearchUtils.a(this.jdField_d_of_type_JavaLangString, 20, paramView, false);
      SearchUtils.a(this, paramView);
      if (SearchConfigManager.needSeparate) {
        SearchUtils.a("search", "contact", "contacts", 0, 0, new String[] { SearchUtils.a(this.jdField_b_of_type_Int) });
      }
      if (((a() instanceof String)) && (!this.jdField_b_of_type_Boolean)) {
        SearchUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.i, (String)a(), e());
      }
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        if ((this.i != null) && (!TextUtils.isEmpty(this.i))) {
          UniteSearchReportController.a(null, 0, this.jdField_b_of_type_Int, "0X8009D31", 1, 0, null, null);
        }
      }
      else {
        return;
      }
      UniteSearchReportController.a(null, 0, this.jdField_b_of_type_Int, "0X8009D37", 0, 0, null, null);
      return;
    }
    if (11 == this.jdField_b_of_type_Int)
    {
      localObject = (BaseActivity)paramView.getContext();
      if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin) != null)
      {
        QQToast.a((Context)localObject, ((BaseActivity)localObject).getString(2131699211), 0).b(((BaseActivity)localObject).getTitleBarHeight());
        return;
      }
    }
    SearchUtils.a(paramView, this);
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_Int == 21) || (this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 2);
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
  }
  
  public int c()
  {
    return 1;
  }
  
  public CharSequence c()
  {
    if (SearchUtils.a(this.jdField_b_of_type_Int)) {
      return HardCodeUtil.a(2131702580) + this.jdField_a_of_type_JavaLangString;
    }
    return this.jdField_a_of_type_JavaLangString;
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
    Object localObject = a();
    CharSequence localCharSequence = b();
    switch (this.jdField_a_of_type_Int)
    {
    }
    do
    {
      localObject = super.e();
      SpannableStringBuilder localSpannableStringBuilder;
      do
      {
        return localObject;
        localSpannableStringBuilder = new SpannableStringBuilder();
        if (localObject != null) {
          localSpannableStringBuilder.append((CharSequence)localObject);
        }
        localObject = localSpannableStringBuilder;
      } while (localCharSequence == null);
      localSpannableStringBuilder.append(localCharSequence);
      return localSpannableStringBuilder;
      return localObject;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) {
        return localObject;
      }
    } while ((localCharSequence == null) || (localCharSequence.length() <= 2));
    return localCharSequence.subSequence(1, localCharSequence.length() - 1);
  }
  
  public int f()
  {
    return this.jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.ContactSearchModelFriend
 * JD-Core Version:    0.7.0.1
 */