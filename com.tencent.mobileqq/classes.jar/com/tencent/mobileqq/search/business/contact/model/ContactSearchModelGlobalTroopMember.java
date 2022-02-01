package com.tencent.mobileqq.search.business.contact.model;

import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;

public class ContactSearchModelGlobalTroopMember
  extends IContactSearchModel
{
  protected int a;
  protected long a;
  protected TroopInfo a;
  public String a;
  protected long b;
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  
  public ContactSearchModelGlobalTroopMember(AppInterface paramAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramAppInterface, paramInt, 0L);
    this.jdField_b_of_type_Long = IContactSearchable.V;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = SearchUtils.a(paramAppInterface, this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop()) {
      this.jdField_b_of_type_Long = IContactSearchable.G;
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
          this.e = "";
          this.f = null;
          return;
        }
        this.e = this.c;
        if (!TextUtils.isEmpty(this.d))
        {
          this.f = this.d;
          return;
        }
        this.f = this.jdField_b_of_type_JavaLangString;
        return;
      }
      if (!TextUtils.isEmpty(this.c))
      {
        this.e = this.c;
        this.f = this.d;
        return;
      }
      this.e = this.d;
      this.f = this.jdField_b_of_type_JavaLangString;
      return;
    }
    if (!TextUtils.isEmpty(this.c))
    {
      this.e = this.c;
      this.f = this.jdField_b_of_type_JavaLangString;
      return;
    }
    if (!TextUtils.isEmpty(this.d))
    {
      this.e = this.d;
      this.f = this.jdField_b_of_type_JavaLangString;
      return;
    }
    this.e = this.jdField_b_of_type_JavaLangString;
    this.f = null;
  }
  
  public int a()
  {
    return 1;
  }
  
  protected long a(String paramString)
  {
    this.g = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop() ^ true;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop()) {
      l = IContactSearchable.i;
    } else {
      l = IContactSearchable.q;
    }
    long l = SearchUtils.a(paramString, this.c, l, false, false, bool);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 2;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop()) {
      l = IContactSearchable.h;
    } else {
      l = IContactSearchable.l;
    }
    l = SearchUtils.a(paramString, this.d, l, false, false, bool);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 1;
    }
    l = SearchUtils.a(paramString, this.jdField_b_of_type_JavaLangString, IContactSearchable.o, false, true, true);
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
  
  public CharSequence a()
  {
    String str = ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getTroopName(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, true);
    if (str != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131702695));
      localStringBuilder.append(str);
      return localStringBuilder.toString();
    }
    return HardCodeUtil.a(2131702687);
  }
  
  public Object a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (SearchUtils.a(this.jdField_b_of_type_Int))
    {
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
      String str2 = SearchUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString);
      Object localObject = SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_JavaLangString);
      if (!((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isRobotUin(this.jdField_b_of_type_JavaLangString))
      {
        if ((localObject != null) && (((Friends)localObject).isFriend()))
        {
          ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).enterChatWin(paramView.getContext(), this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_JavaLangString, 0, SearchUtils.a((Friends)localObject), false);
          SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, SearchUtils.a((Friends)localObject), this.jdField_b_of_type_JavaLangString, "", 0);
        }
        else
        {
          ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).enterTroopTmpChatWin(paramView.getContext(), this.jdField_b_of_type_JavaLangString, str2, 1000, b().toString(), false, null, null);
          String str1 = b().toString();
          localObject = str1;
          if (TextUtils.isEmpty(str1))
          {
            if (QLog.isColorLevel()) {
              QLog.d(h, 2, "saveSearchHistory title is null");
            }
            str1 = c();
            localObject = str1;
            if (TextUtils.isEmpty(str1))
            {
              if (QLog.isColorLevel()) {
                QLog.d(h, 2, "saveSearchHistory titlestr is null");
              }
              localObject = d();
            }
          }
          SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject, this.jdField_b_of_type_JavaLangString, str2, 1000);
        }
      }
      else
      {
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).openRobotProfileCard(paramView.getContext(), null, this.jdField_b_of_type_JavaLangString);
        SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, b().toString(), this.jdField_b_of_type_JavaLangString, str2, 1000);
      }
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.g);
      SearchUtils.a(this.g, 20, 1, paramView);
      SearchUtils.a(this.g, 20, paramView, false);
      SearchUtils.a(this, paramView);
      if (SearchConfigManager.needSeparate) {
        SearchUtils.a("search", "contact", "contacts", 0, 0, new String[] { SearchUtils.a(this.jdField_b_of_type_Int) });
      }
      if (((a() instanceof String)) && (!this.jdField_b_of_type_Boolean)) {
        SearchUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.g, this.i, (String)a(), e());
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
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return this.g;
  }
  
  public String c()
  {
    return this.e;
  }
  
  public int d()
  {
    return 1000;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return this.f;
  }
  
  public int e()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelGlobalTroopMember
 * JD-Core Version:    0.7.0.1
 */