package com.tencent.mobileqq.search.business.contact.model;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.bless.api.IBlessApi;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class ContactSearchModelTool
  extends IContactSearchModel
{
  private long a = IContactSearchable.P;
  private String b;
  private int c;
  private String d;
  private String e;
  private String f;
  private String g;
  private long h;
  
  public ContactSearchModelTool(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    super(paramAppInterface, paramInt1, paramLong);
    this.b = paramString;
    this.c = paramInt2;
    s();
  }
  
  static String a(AppInterface paramAppInterface)
  {
    if (TextUtils.isEmpty(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderName())) {
      return ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountTitle();
    }
    return ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderName();
  }
  
  private Friends e(String paramString)
  {
    if (!Friends.isValidUin(paramString)) {
      return null;
    }
    return ((IFriendDataService)this.m.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString, true, true);
  }
  
  private void s()
  {
    switch (this.c)
    {
    default: 
      break;
    case 10002: 
      this.e = MobileQQ.sMobileQQ.getResources().getString(2131890676);
      break;
    case 9003: 
      this.e = MobileQQ.sMobileQQ.getResources().getString(2131887598);
      break;
    case 9002: 
      this.e = MobileQQ.sMobileQQ.getResources().getString(2131886175);
      break;
    case 9000: 
      this.e = MobileQQ.sMobileQQ.getResources().getString(2131888047);
      break;
    case 7230: 
      this.e = a(this.m);
      break;
    case 7220: 
      this.e = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getMergerKandianName(this.m, MobileQQ.sMobileQQ.getApplicationContext());
      break;
    case 7210: 
      this.e = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.m, MobileQQ.sMobileQQ.getApplicationContext());
      break;
    case 7120: 
      this.e = MobileQQ.sMobileQQ.getResources().getString(2131888820);
      break;
    case 7000: 
      this.e = MobileQQ.sMobileQQ.getResources().getString(2131916834);
      if (!AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(this.b))
      {
        Object localObject1 = e(this.b);
        if ((localObject1 != null) && (((Friends)localObject1).name != null)) {
          localObject2 = ((Friends)localObject1).name;
        } else {
          localObject2 = this.b;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).equals(this.b)) {}
        }
        else
        {
          String str = ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getBuddyNickName(this.m, this.b, true);
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(str)) {
            localObject1 = str;
          }
        }
        Object localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = this.b;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.e);
        ((StringBuilder)localObject1).append("(");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(")");
        this.e = ((StringBuilder)localObject1).toString();
      }
      break;
    case 6000: 
      this.e = MobileQQ.sMobileQQ.getResources().getString(2131891354);
      break;
    case 5000: 
      this.e = MobileQQ.sMobileQQ.getResources().getString(2131917386);
      break;
    case 4000: 
      this.e = MobileQQ.sMobileQQ.getResources().getString(2131892123);
      break;
    case 1008: 
      if (TextUtils.equals(this.b, AppConstants.NEW_KANDIAN_UIN)) {
        this.e = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getXinKandianName(this.m, MobileQQ.sMobileQQ.getApplicationContext());
      }
      break;
    case 1001: 
      this.e = MobileQQ.sMobileQQ.getResources().getString(2131890674);
    }
    if (!TextUtils.isEmpty(this.e))
    {
      this.f = ChnToSpell.b(this.e, 1).toLowerCase();
      this.g = ChnToSpell.b(this.e, 2).toLowerCase();
    }
  }
  
  public CharSequence a()
  {
    int i = this.c;
    if (i != 7220)
    {
      if (i != 9002) {
        return null;
      }
      return SearchUtils.b(MobileQQ.sMobileQQ.getResources().getString(2131886429), this.d, 255);
    }
    return SearchUtils.b(String.format(MobileQQ.sMobileQQ.getResources().getString(2131897916), new Object[] { ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.m, this.m.getApplication().getApplicationContext()), ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getMergerKandianName(this.m, this.m.getApplication().getApplicationContext()), ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getMergerKandianName(this.m, this.m.getApplication().getApplicationContext()) }), this.d, 255);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (SearchUtils.b(this.n))
    {
      switch (this.c)
      {
      default: 
        break;
      case 9003: 
        ((IBlessApi)QRoute.api(IBlessApi.class)).openWebBlessActivity(this.m, paramView.getContext());
        break;
      case 9002: 
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).startActivateFriendsForModelTroop(paramView.getContext());
        if ((this.n == 2) || (this.n == 1)) {
          ReportController.b(this.m, "CliOper", "", "", "0X8006477", "0X8006477", this.n, 0, "", "", "", "");
        }
        break;
      case 9000: 
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).startTroopNotificationForModelTroop(this.m, paramView.getContext());
        break;
      case 7230: 
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).startServiceAccountFolderForModelTroop(paramView.getContext());
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchModelTool", 2, "enterServiceAccountFolderActivityFromSearch");
        }
        break;
      case 7220: 
        ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchFeedsActivity(paramView.getContext(), 1, 0);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800671A", "0X800671A", 0, 0, "", "", "", "", false);
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).updateDeleteOldKandian(this.m, true);
        SearchUtils.a(this.m, d().toString(), this.b, "", this.c);
        break;
      case 7210: 
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).startTroopBarAssistForModelTroop(this.m, paramView.getContext());
        break;
      case 7120: 
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).startECShopAssistForModelTroop(this.m, paramView.getContext());
        ReportController.b(this.m, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Clk_Searchshopfolder", 0, 0, "", "", "", "");
        break;
      case 7000: 
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).startSubAccountAssistantForModelTroop(this.m, paramView.getContext(), this.b, this.c);
        break;
      case 6000: 
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).startDataLinePCForModelTroop(paramView.getContext());
        break;
      case 5000: 
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).startTroopAssistantForModelTroop(paramView.getContext());
        break;
      case 4000: 
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).startRecommendContactForModelTroop(paramView.getContext());
        break;
      case 1008: 
        if (TextUtils.equals(this.b, AppConstants.NEW_KANDIAN_UIN))
        {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800671A", "0X800671A", 0, 0, "", "", "", "", false);
          ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchFeedsActivity(paramView.getContext(), null, -1L, 1);
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).updateDeleteOldKandian(this.m, true);
          SearchUtils.a(this.m, d().toString(), this.b, "", this.c);
        }
        break;
      case 1001: 
      case 10002: 
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).startMsgBoxListActForModelTroop(paramView.getContext());
      }
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.m, this.d);
      long l1 = 0L;
      try
      {
        long l2 = Long.parseLong(this.b);
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
      SearchUtils.a(this.d, 20, (int)l1, paramView);
      return;
    }
    SearchUtils.a(paramView, this);
  }
  
  public int b()
  {
    return ((Integer)((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getFaceTypeAndResId(this.m, this.c, this.b).first).intValue();
  }
  
  public String c()
  {
    return this.b;
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public String g()
  {
    return this.d;
  }
  
  public boolean h()
  {
    return false;
  }
  
  public Object i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tool:");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
  
  public int j()
  {
    return this.c;
  }
  
  public String m()
  {
    return this.e;
  }
  
  public String n()
  {
    return null;
  }
  
  protected long n_(String paramString)
  {
    this.d = paramString;
    this.h = -9223372036854775808L;
    long l = SearchUtils.b(paramString, this.e, IContactSearchable.p);
    if (l > this.h) {
      this.h = l;
    }
    int i = this.c;
    if ((i == 7220) || ((i == 1008) && (TextUtils.equals(this.b, AppConstants.NEW_KANDIAN_UIN))))
    {
      l = SearchUtils.b(paramString, HardCodeUtil.a(2131891080), IContactSearchable.p);
      if (l > this.h) {
        this.h = l;
      }
    }
    if ((((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInReadinjoyFolderMergerStyle()) && (this.c == 7220))
    {
      l = SearchUtils.b(paramString, String.format(MobileQQ.sMobileQQ.getResources().getString(2131897916), new Object[] { ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.m, this.m.getApplication().getApplicationContext()), ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getMergerKandianName(this.m, this.m.getApplication().getApplicationContext()), ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getMergerKandianName(this.m, this.m.getApplication().getApplicationContext()) }), IContactSearchable.t);
      if (l > this.h) {
        this.h = l;
      }
    }
    if (this.c == 9002)
    {
      l = SearchUtils.b(paramString, MobileQQ.sMobileQQ.getResources().getString(2131886429), IContactSearchable.t);
      if (l > this.h) {
        this.h = l;
      }
    }
    l = this.h;
    if (l != -9223372036854775808L)
    {
      this.h = (l + IContactSearchable.R);
      if ((AppConstants.EC_SHOP_ASSISTANT_UIN.equals(c())) && ((HardCodeUtil.a(2131900713).equals(paramString)) || (HardCodeUtil.a(2131900720).equals(paramString)) || (HardCodeUtil.a(2131900694).equals(paramString)))) {
        this.h = (IContactSearchable.B + 1L);
      }
    }
    return this.h;
  }
  
  public int o()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelTool
 * JD-Core Version:    0.7.0.1
 */