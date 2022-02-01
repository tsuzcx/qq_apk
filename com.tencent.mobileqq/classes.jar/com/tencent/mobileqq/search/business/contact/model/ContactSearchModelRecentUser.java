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
  private static final int[] a = { 1000, 1004, 1005, 1006, 1001, 10002, 10004, 10010 };
  private RecentUser b;
  private long c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String w;
  private int x = 1;
  
  public ContactSearchModelRecentUser(AppInterface paramAppInterface, int paramInt, RecentUser paramRecentUser, long paramLong)
  {
    super(paramAppInterface, paramInt, paramLong);
    this.b = paramRecentUser;
    w();
  }
  
  private void t()
  {
    int m = this.x;
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3)
          {
            if (m != 4) {
              return;
            }
            this.k = this.j;
            this.w = this.i;
            return;
          }
          this.k = this.g;
          this.w = SearchUtils.a(new String[] { this.h, this.i });
          return;
        }
        this.k = this.f;
        this.w = SearchUtils.a(new String[] { this.h, this.i });
        return;
      }
      this.k = SearchUtils.a(new String[] { this.f, this.g });
      if (!TextUtils.isEmpty(this.k))
      {
        this.w = this.h;
        return;
      }
      this.k = this.h;
      this.w = this.i;
      return;
    }
    this.k = SearchUtils.a(new String[] { this.f, this.g, this.h });
    this.w = this.i;
  }
  
  private void w()
  {
    this.i = this.b.uin;
    this.h = this.b.displayName;
    int m = this.b.getType();
    Object localObject1;
    Object localObject2;
    if (m != 1000)
    {
      if (m != 1001)
      {
        if (m != 10002)
        {
          if (m != 10004)
          {
            if (m != 10010) {
              switch (m)
              {
              default: 
                localObject1 = HardCodeUtil.a(2131900707);
                break;
              case 1006: 
                this.j = this.b.displayName;
                this.h = null;
                localObject1 = ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getUinByPhoneNum(this.m, this.b.uin);
                localObject2 = ((IPhoneContactService)this.m.getRuntimeService(IPhoneContactService.class, "")).queryContactByCodeNumber(this.b.uin);
                if (localObject2 != null) {
                  this.j = ((PhoneContact)localObject2).name;
                } else if (localObject1 != null) {
                  this.j = ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getBuddyName(this.m, (String)localObject1, true);
                }
                localObject1 = HardCodeUtil.a(2131900733);
                break;
              case 1005: 
                localObject1 = "wap临时会话";
                break;
              case 1004: 
                localObject1 = (Map)((IDiscussionService)this.m.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberInfoMapByUin(this.b.troopUin);
                if (localObject1 != null)
                {
                  localObject1 = (DiscussionMemberInfo)((Map)localObject1).get(this.b.uin);
                  if (localObject1 != null)
                  {
                    localObject2 = ((DiscussionMemberInfo)localObject1).memberName;
                    if (!TextUtils.isEmpty(((DiscussionMemberInfo)localObject1).inteRemark)) {
                      this.g = ((DiscussionMemberInfo)localObject1).inteRemark;
                    }
                    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                      this.h = ((String)localObject2);
                    }
                  }
                }
                localObject2 = HardCodeUtil.a(2131900715);
                String str = this.h;
                localObject1 = localObject2;
                if (str == null) {
                  break;
                }
                localObject1 = localObject2;
                if (!str.equals(this.b.uin)) {
                  break;
                }
                this.h = ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getBuddyName(this.m, this.b.uin, true);
                localObject1 = localObject2;
                break;
              }
            } else {
              localObject1 = HardCodeUtil.a(2131891942);
            }
          }
          else {
            localObject1 = "QQ电影票临时会话";
          }
        }
        else {
          localObject1 = HardCodeUtil.a(2131900697);
        }
      }
      else {
        localObject1 = HardCodeUtil.a(2131900727);
      }
    }
    else
    {
      localObject1 = SearchUtils.e(this.m, this.b.troopUin);
      localObject1 = SearchUtils.b(this.m, (String)localObject1, this.b.uin);
      if (localObject1 != null)
      {
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopnick)) {
          this.f = ((TroopMemberInfo)localObject1).troopnick;
        }
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).autoremark)) {
          this.g = ((TroopMemberInfo)localObject1).autoremark;
        }
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).friendnick)) {
          this.h = ((TroopMemberInfo)localObject1).friendnick;
        }
      }
      localObject1 = HardCodeUtil.a(2131900691);
    }
    if (SearchUtils.b(this.n))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131900730));
      ((StringBuilder)localObject2).append((String)localObject1);
      this.d = ((StringBuilder)localObject2).toString();
    }
    else
    {
      this.d = ((String)localObject1);
    }
    if ((TextUtils.isEmpty(this.h)) || (this.h.equals(this.i))) {
      this.h = ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getBuddyName(this.m, this.i, true);
    }
  }
  
  public CharSequence a()
  {
    return this.d;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (SearchUtils.b(this.n))
    {
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
      if (!((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isRobotUin(this.b.uin))
      {
        int m = this.b.getType();
        if ((m != 0) && (m != 10002) && (m != 10004)) {
          if (m != 1000)
          {
            if (m == 1001) {}
          }
          else {
            switch (m)
            {
            default: 
              break;
            case 1004: 
              ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
              ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).enterTroopTmpChatWin(paramView.getContext(), this.b.uin, this.b.troopUin, this.b.getType(), this.k, false, null, null);
              break;
            }
          }
        }
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).enterChatWin(paramView.getContext(), this.m, this.b.uin, this.b.getType(), this.k, false);
      }
      else
      {
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).openRobotProfileCard(paramView.getContext(), null, this.b.uin);
      }
      SearchUtils.a(this.e, 20, 1, paramView);
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.m, this.e);
      AppInterface localAppInterface = this.m;
      String str2 = d().toString();
      String str3 = this.i;
      String str1;
      if (this.b.troopUin == null) {
        str1 = "";
      } else {
        str1 = this.b.troopUin;
      }
      SearchUtils.a(localAppInterface, str2, str3, str1, this.b.getType());
      SearchUtils.a(this.e, 20, paramView, false);
      SearchUtils.a(this, paramView);
      if (SearchConfigManager.needSeparate) {
        SearchUtils.a("search", "contact", "contacts", 0, 0, new String[] { SearchUtils.a(this.n) });
      }
      if ((i() instanceof String)) {
        SearchUtils.b(this.m, this.e, this.p, (String)i(), o());
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
    int m = this.b.getType();
    if (m != 1000)
    {
      if ((m != 1001) && (m != 10002) && (m != 10004)) {}
      switch (m)
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
  
  public String c()
  {
    return this.b.uin;
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public String g()
  {
    return this.e;
  }
  
  public boolean h()
  {
    return false;
  }
  
  public Object i()
  {
    return this.b.uin;
  }
  
  public int j()
  {
    return this.b.getType();
  }
  
  public String m()
  {
    return this.k;
  }
  
  public String n()
  {
    return this.w;
  }
  
  protected long n_(String paramString)
  {
    this.e = paramString;
    this.c = -9223372036854775808L;
    long l = SearchUtils.b(paramString, this.f, IContactSearchable.k);
    if (l > this.c)
    {
      this.c = l;
      this.x = 2;
    }
    l = SearchUtils.b(paramString, this.g, IContactSearchable.o);
    if (l > this.c)
    {
      this.c = l;
      this.x = 3;
    }
    l = SearchUtils.b(paramString, this.h, IContactSearchable.p);
    if (l > this.c)
    {
      this.c = l;
      this.x = 1;
    }
    l = SearchUtils.b(paramString, this.j, IContactSearchable.q);
    if (l > this.c)
    {
      this.c = l;
      this.x = 4;
    }
    l = SearchUtils.a(paramString, this.i, IContactSearchable.s, false);
    if (l > this.c)
    {
      this.c = l;
      this.x = 0;
    }
    l = this.c;
    if (l != -9223372036854775808L)
    {
      this.c = (l + IContactSearchable.D);
      t();
    }
    return this.c;
  }
  
  public int o()
  {
    return 1;
  }
  
  public String s()
  {
    return this.b.troopUin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelRecentUser
 * JD-Core Version:    0.7.0.1
 */