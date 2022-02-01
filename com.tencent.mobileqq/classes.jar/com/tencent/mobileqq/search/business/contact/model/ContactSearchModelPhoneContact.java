package com.tencent.mobileqq.search.business.contact.model;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.util.LruCache;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.ChnSpelling;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class ContactSearchModelPhoneContact
  extends IContactSearchModel
{
  private static LruCache<String, String> d = new LruCache(3);
  public PhoneContact a;
  public ChnToSpell.ChnSpelling b;
  public ChnToSpell.ChnSpelling c;
  private long e;
  private String f;
  private long g = IContactSearchable.M;
  
  public ContactSearchModelPhoneContact(AppInterface paramAppInterface, int paramInt, PhoneContact paramPhoneContact)
  {
    super(paramAppInterface, paramInt, 0L);
    this.a = paramPhoneContact;
    if (TextUtils.isEmpty(paramPhoneContact.uin)) {
      this.g = IContactSearchable.U;
    }
    if (!TextUtils.isEmpty(paramPhoneContact.name))
    {
      this.b = ChnToSpell.a(paramPhoneContact.name, 1);
      this.c = ChnToSpell.a(paramPhoneContact.name, 2);
    }
    f(6);
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    return ((IAddFriendServiceApi)this.m.getRuntimeService(IAddFriendServiceApi.class, "")).hasSendAddFriendReq(paramString, paramBoolean, false);
  }
  
  public CharSequence a()
  {
    if (SearchUtils.b(this.n)) {
      return HardCodeUtil.a(2131900689);
    }
    if ((this.n != 17) && (this.n != 19)) {
      return HardCodeUtil.a(2131900728);
    }
    if ((!TextUtils.isEmpty(this.a.uin)) && (!this.a.uin.equalsIgnoreCase("0"))) {
      return HardCodeUtil.a(2131900711);
    }
    if (a(this.a.unifiedCode, true)) {
      return HardCodeUtil.a(2131900735);
    }
    return null;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    int i;
    int j;
    Object localObject1;
    if ((paramView.getId() == 2131444718) && (this.n == 17))
    {
      if (!((IPhoneContactService)this.m.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload())
      {
        ReportController.b(this.m, "dc00898", "", "", "0X80077CD", "0X80077CD", 3, 0, "", "", "", "");
        ReportController.b(this.m, "dc00898", "", "", "0X80077CD", "0X80077CD", 0, 0, "", "", "", "");
        i = 3075;
        j = 1;
      }
      else
      {
        ReportController.b(this.m, "dc00898", "", "", "0X80077D3", "0X80077D3", 3, 0, "", "", "", "");
        ReportController.b(this.m, "dc00898", "", "", "0X80077D3", "0X80077D3", 0, 0, "", "", "", "");
        i = 3006;
        j = 13;
      }
      localObject1 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(paramView.getContext(), 2, this.a.unifiedCode, null, i, j, this.a.name, null, null, HardCodeUtil.a(2131900731), null);
      ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(paramView.getContext(), (Intent)localObject1);
    }
    else
    {
      j = this.n;
      i = 56940;
      Object localObject2;
      if (j == 17)
      {
        PhoneContact localPhoneContact = this.a;
        localObject1 = (IPhoneContactService)this.m.getRuntimeService(IPhoneContactService.class, "");
        if ((!TextUtils.isEmpty(localPhoneContact.uin)) && (!"0".equals(localPhoneContact.uin)))
        {
          localObject2 = localPhoneContact.unifiedCode;
          localObject1 = new AllInOne((String)localObject2, 53);
          i = 56939;
        }
        else if ("0".equals(localPhoneContact.uin))
        {
          localObject2 = this.a.unifiedCode;
          if (((IPhoneContactService)localObject1).isBindedIgnoreUpload())
          {
            localObject1 = new AllInOne((String)localObject2, 53);
            i = 56941;
          }
          else
          {
            localObject1 = new AllInOne((String)localObject2, 29);
          }
        }
        else
        {
          localObject2 = this.a.mobileNo;
          localObject1 = new AllInOne((String)localObject2, 53);
          i = 56942;
        }
        ((AllInOne)localObject1).contactName = localPhoneContact.name;
        ((AllInOne)localObject1).nickname = localPhoneContact.name;
        ((AllInOne)localObject1).profileEntryType = 103;
        ProfileUtils.openProfileCard(paramView.getContext(), (AllInOne)localObject1);
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.m, this.f);
        SearchUtils.a(this.m, d().toString(), (String)localObject2, "", i);
      }
      else if (SearchUtils.b(this.n))
      {
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
        localObject1 = this.a.uin;
        if (!((IPhoneContactService)this.m.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload())
        {
          if ("0".equals(this.a.uin))
          {
            localObject1 = this.a.unifiedCode;
            localObject2 = new AllInOne((String)localObject1, 29);
            ((AllInOne)localObject2).contactArray = new ArrayList();
            ((AllInOne)localObject2).contactName = this.a.name;
            ((AllInOne)localObject2).nickname = this.a.nickName;
            ((AllInOne)localObject2).chatAbility = this.a.ability;
            ((AllInOne)localObject2).lastActivity = 3;
            ((AllInOne)localObject2).profileEntryType = 103;
            ProfileUtils.openProfileCard(paramView.getContext(), (AllInOne)localObject2);
            ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.m, this.f);
            SearchUtils.a(this.m, d().toString(), (String)localObject1, "", 56940);
            return;
          }
          if (TextUtils.isEmpty(this.a.uin))
          {
            localObject1 = this.a.mobileNo;
            localObject2 = new AllInOne((String)localObject1, 53);
            ((AllInOne)localObject2).contactArray = new ArrayList();
            ((AllInOne)localObject2).contactName = this.a.name;
            ((AllInOne)localObject2).nickname = this.a.nickName;
            ((AllInOne)localObject2).chatAbility = this.a.ability;
            ((AllInOne)localObject2).lastActivity = 3;
            ((AllInOne)localObject2).profileEntryType = 103;
            ProfileUtils.openProfileCard(paramView.getContext(), (AllInOne)localObject2);
            ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.m, this.f);
            SearchUtils.a(this.m, d().toString(), (String)localObject1, "", 56942);
          }
        }
        else
        {
          if (TextUtils.isEmpty(this.a.uin))
          {
            localObject1 = this.a.mobileNo;
            localObject2 = new AllInOne((String)localObject1, 53);
            ((AllInOne)localObject2).contactArray = new ArrayList();
            ((AllInOne)localObject2).contactName = this.a.name;
            ((AllInOne)localObject2).nickname = this.a.nickName;
            ((AllInOne)localObject2).chatAbility = this.a.ability;
            ((AllInOne)localObject2).lastActivity = 3;
            ((AllInOne)localObject2).profileEntryType = 103;
            ProfileUtils.openProfileCard(paramView.getContext(), (AllInOne)localObject2);
            ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.m, this.f);
            SearchUtils.a(this.m, d().toString(), (String)localObject1, "", 56942);
            return;
          }
          if ("0".equals(this.a.uin))
          {
            localObject1 = this.a.unifiedCode;
            i = 1006;
            break label1031;
          }
        }
        i = 0;
        label1031:
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).enterChatWin(paramView.getContext(), this.m, (String)localObject1, i, this.a.name, false);
        SearchUtils.a(this.f, 20, 1, paramView);
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.m, this.f);
        SearchUtils.a(this.m, d().toString(), (String)localObject1, "", i);
        SearchUtils.a(this.f, 20, paramView, false);
        SearchUtils.a(this, paramView);
        if (SearchConfigManager.needSeparate) {
          SearchUtils.a("search", "contact", "contacts", 0, 0, new String[] { SearchUtils.a(this.n) });
        }
      }
      else
      {
        SearchUtils.a(paramView, this);
      }
    }
    if ((SearchUtils.b(this.n)) && ((i() instanceof String)) && (!this.r)) {
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
  
  public int b()
  {
    if ((!TextUtils.isEmpty(this.a.uin)) && (!this.a.uin.equals("0"))) {
      return 1;
    }
    return 11;
  }
  
  public String c()
  {
    String str2 = this.a.uin;
    if (TextUtils.isEmpty(str2)) {
      return this.a.mobileNo;
    }
    String str1 = str2;
    if (str2.equals("0")) {
      str1 = this.a.unifiedCode;
    }
    return str1;
  }
  
  public CharSequence e()
  {
    if (this.n == 17)
    {
      String str = n();
      if (!TextUtils.isEmpty(str))
      {
        if ((!str.equals(this.u)) || (!TextUtils.equals(this.t, g())))
        {
          this.u = str;
          this.t = g();
          SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(HardCodeUtil.a(2131900695));
          localSpannableStringBuilder.append(SearchUtils.b(str, g(), 10));
          this.s = localSpannableStringBuilder;
        }
        return this.s;
      }
      this.u = null;
      return null;
    }
    return super.e();
  }
  
  public CharSequence f()
  {
    if ((this.n == 17) && (this.a.samFriend > 0)) {
      return String.format(this.m.getApplication().getResources().getString(2131888039), new Object[] { Integer.valueOf(this.a.samFriend) });
    }
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
    String str = this.a.uin;
    if (TextUtils.isEmpty(str))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mn:");
      ((StringBuilder)localObject).append(this.a.mobileNo);
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = str;
    if (str.equals("0")) {
      localObject = this.a.unifiedCode;
    }
    return localObject;
  }
  
  public int j()
  {
    if (TextUtils.isEmpty(this.a.uin)) {
      return 56938;
    }
    if (this.a.uin.equals("0")) {
      return 1006;
    }
    return 0;
  }
  
  public String m()
  {
    return this.a.name;
  }
  
  public String n()
  {
    if (this.n == 17) {
      return null;
    }
    return this.a.mobileNo;
  }
  
  protected long n_(String paramString)
  {
    this.f = paramString;
    this.e = -9223372036854775808L;
    long l = SearchUtils.a(paramString, this.a.name, this.b, this.c, IContactSearchable.q);
    if (l > this.e) {
      this.e = l;
    }
    String str2 = (String)d.get(paramString);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = paramString.replaceAll("-", "");
      d.put(paramString, str1);
    }
    l = SearchUtils.a(str1, this.a.mobileNo, IContactSearchable.t, true);
    if (l > this.e) {
      this.e = l;
    }
    l = SearchUtils.a(paramString, this.a.nickName, IContactSearchable.p, false);
    if (l > this.e) {
      this.e = l;
    }
    l = this.e;
    if (l != -9223372036854775808L) {
      this.e = (l + this.g);
    }
    return this.e;
  }
  
  public int o()
  {
    return 4;
  }
  
  public String s()
  {
    return this.a.unifiedCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelPhoneContact
 * JD-Core Version:    0.7.0.1
 */