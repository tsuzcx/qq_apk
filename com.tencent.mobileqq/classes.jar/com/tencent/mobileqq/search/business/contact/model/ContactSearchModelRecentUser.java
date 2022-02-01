package com.tencent.mobileqq.search.business.contact.model;

import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import java.util.Map;

public class ContactSearchModelRecentUser
  extends IContactSearchModel
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 1000, 1004, 1005, 1006, 1001, 10002, 10004, 10010 };
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private RecentUser jdField_a_of_type_ComTencentMobileqqDataRecentUser;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String l;
  private String m;
  
  public ContactSearchModelRecentUser(AppInterface paramAppInterface, int paramInt, RecentUser paramRecentUser, long paramLong)
  {
    super(paramAppInterface, paramInt, paramLong);
    this.jdField_a_of_type_ComTencentMobileqqDataRecentUser = paramRecentUser;
    b();
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
            if (i != 4) {
              return;
            }
            this.l = this.g;
            this.m = this.f;
            return;
          }
          this.l = this.d;
          this.m = SearchUtils.a(new String[] { this.e, this.f });
          return;
        }
        this.l = this.c;
        this.m = SearchUtils.a(new String[] { this.e, this.f });
        return;
      }
      this.l = SearchUtils.a(new String[] { this.c, this.d });
      if (!TextUtils.isEmpty(this.l))
      {
        this.m = this.e;
        return;
      }
      this.l = this.e;
      this.m = this.f;
      return;
    }
    this.l = SearchUtils.a(new String[] { this.c, this.d, this.e });
    this.m = this.f;
  }
  
  private void b()
  {
    this.f = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin;
    this.e = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.displayName;
    int i = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType();
    Object localObject1;
    Object localObject2;
    if (i != 1000)
    {
      if (i != 1001)
      {
        if (i != 10002)
        {
          if (i != 10004)
          {
            if (i != 10010) {
              switch (i)
              {
              default: 
                localObject1 = HardCodeUtil.a(2131702717);
                break;
              case 1006: 
                this.g = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.displayName;
                this.e = null;
                localObject1 = ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getUinByPhoneNum(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
                localObject2 = ((IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, "")).queryContactByCodeNumber(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
                if (localObject2 != null) {
                  this.g = ((PhoneContact)localObject2).name;
                } else if (localObject1 != null) {
                  this.g = ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getBuddyName(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject1, true);
                }
                localObject1 = HardCodeUtil.a(2131702743);
                break;
              case 1005: 
                localObject1 = "wap临时会话";
                break;
              case 1004: 
                localObject1 = (Map)((IDiscussionService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberInfoMapByUin(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin);
                if (localObject1 != null)
                {
                  localObject1 = (DiscussionMemberInfo)((Map)localObject1).get(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
                  if (localObject1 != null)
                  {
                    localObject2 = ((DiscussionMemberInfo)localObject1).memberName;
                    if (!TextUtils.isEmpty(((DiscussionMemberInfo)localObject1).inteRemark)) {
                      this.d = ((DiscussionMemberInfo)localObject1).inteRemark;
                    }
                    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                      this.e = ((String)localObject2);
                    }
                  }
                }
                localObject2 = HardCodeUtil.a(2131702725);
                String str = this.e;
                localObject1 = localObject2;
                if (str == null) {
                  break;
                }
                localObject1 = localObject2;
                if (!str.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
                  break;
                }
                this.e = ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getBuddyName(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
                localObject1 = localObject2;
                break;
              }
            } else {
              localObject1 = HardCodeUtil.a(2131694304);
            }
          }
          else {
            localObject1 = "QQ电影票临时会话";
          }
        }
        else {
          localObject1 = HardCodeUtil.a(2131702707);
        }
      }
      else {
        localObject1 = HardCodeUtil.a(2131702737);
      }
    }
    else
    {
      localObject1 = SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin);
      localObject1 = SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
      if (localObject1 != null)
      {
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopnick)) {
          this.c = ((TroopMemberInfo)localObject1).troopnick;
        }
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).autoremark)) {
          this.d = ((TroopMemberInfo)localObject1).autoremark;
        }
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).friendnick)) {
          this.e = ((TroopMemberInfo)localObject1).friendnick;
        }
      }
      localObject1 = HardCodeUtil.a(2131702701);
    }
    if (SearchUtils.a(this.jdField_b_of_type_Int))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131702740));
      ((StringBuilder)localObject2).append((String)localObject1);
      this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
    }
    else
    {
      this.jdField_a_of_type_JavaLangString = ((String)localObject1);
    }
    if ((TextUtils.isEmpty(this.e)) || (this.e.equals(this.f))) {
      this.e = ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getBuddyName(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.f, true);
    }
  }
  
  public int a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType();
    if (i != 1000)
    {
      if ((i != 1001) && (i != 10002) && (i != 10004)) {}
      switch (i)
      {
      default: 
        return 1;
      case 1006: 
        return 11;
        return 32;
      }
    }
    return 1;
  }
  
  protected long a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    long l1 = SearchUtils.b(paramString, this.c, IContactSearchable.g);
    if (l1 > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_Int = 2;
    }
    l1 = SearchUtils.b(paramString, this.d, IContactSearchable.k);
    if (l1 > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_Int = 3;
    }
    l1 = SearchUtils.b(paramString, this.e, IContactSearchable.l);
    if (l1 > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_Int = 1;
    }
    l1 = SearchUtils.b(paramString, this.g, IContactSearchable.m);
    if (l1 > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_Int = 4;
    }
    l1 = SearchUtils.a(paramString, this.f, IContactSearchable.o, false);
    if (l1 > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_Int = 0;
    }
    l1 = this.jdField_a_of_type_Long;
    if (l1 != -9223372036854775808L)
    {
      this.jdField_a_of_type_Long = (l1 + IContactSearchable.z);
      a();
    }
    return this.jdField_a_of_type_Long;
  }
  
  public CharSequence a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (SearchUtils.a(this.jdField_b_of_type_Int))
    {
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
      if (!((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isRobotUin(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
      {
        int i = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType();
        if ((i != 0) && (i != 10002) && (i != 10004)) {
          if (i != 1000)
          {
            if (i == 1001) {}
          }
          else {
            switch (i)
            {
            default: 
              break;
            case 1004: 
              ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
              ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).enterTroopTmpChatWin(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType(), this.l, false, null, null);
              break;
            }
          }
        }
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).enterChatWin(paramView.getContext(), this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType(), this.l, false);
      }
      else
      {
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).openRobotProfileCard(paramView.getContext(), null, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
      }
      SearchUtils.a(this.jdField_b_of_type_JavaLangString, 20, 1, paramView);
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_JavaLangString);
      AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      String str2 = b().toString();
      String str3 = this.f;
      String str1;
      if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin == null) {
        str1 = "";
      } else {
        str1 = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin;
      }
      SearchUtils.a(localAppInterface, str2, str3, str1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType());
      SearchUtils.a(this.jdField_b_of_type_JavaLangString, 20, paramView, false);
      SearchUtils.a(this, paramView);
      if (SearchConfigManager.needSeparate) {
        SearchUtils.a("search", "contact", "contacts", 0, 0, new String[] { SearchUtils.a(this.jdField_b_of_type_Int) });
      }
      if ((a() instanceof String)) {
        SearchUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_JavaLangString, this.i, (String)a(), e());
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
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String c()
  {
    return this.l;
  }
  
  public int d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType();
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return this.m;
  }
  
  public int e()
  {
    return 1;
  }
  
  public String e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelRecentUser
 * JD-Core Version:    0.7.0.1
 */