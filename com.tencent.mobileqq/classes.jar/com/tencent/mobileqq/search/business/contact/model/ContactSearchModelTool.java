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
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = IContactSearchable.L;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  public ContactSearchModelTool(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    super(paramAppInterface, paramInt1, paramLong);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt2;
    a();
  }
  
  private Friends a(String paramString)
  {
    if (!Friends.isValidUin(paramString)) {
      return null;
    }
    return ((IFriendDataService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString, true, true);
  }
  
  static String a(AppInterface paramAppInterface)
  {
    if (TextUtils.isEmpty(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderName())) {
      return ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountTitle();
    }
    return ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderName();
  }
  
  private void a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      break;
    case 10002: 
      this.c = MobileQQ.sMobileQQ.getResources().getString(2131693137);
      break;
    case 9003: 
      this.c = MobileQQ.sMobileQQ.getResources().getString(2131690683);
      break;
    case 9002: 
      this.c = MobileQQ.sMobileQQ.getResources().getString(2131689565);
      break;
    case 9000: 
      this.c = MobileQQ.sMobileQQ.getResources().getString(2131691101);
      break;
    case 7230: 
      this.c = a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      break;
    case 7220: 
      this.c = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getMergerKandianName(this.jdField_a_of_type_ComTencentCommonAppAppInterface, MobileQQ.sMobileQQ.getApplicationContext());
      break;
    case 7210: 
      this.c = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.jdField_a_of_type_ComTencentCommonAppAppInterface, MobileQQ.sMobileQQ.getApplicationContext());
      break;
    case 7120: 
      this.c = MobileQQ.sMobileQQ.getResources().getString(2131691855);
      break;
    case 7000: 
      this.c = MobileQQ.sMobileQQ.getResources().getString(2131719282);
      if (!AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(this.jdField_a_of_type_JavaLangString))
      {
        Object localObject1 = a(this.jdField_a_of_type_JavaLangString);
        if ((localObject1 != null) && (((Friends)localObject1).name != null)) {
          localObject2 = ((Friends)localObject1).name;
        } else {
          localObject2 = this.jdField_a_of_type_JavaLangString;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).equals(this.jdField_a_of_type_JavaLangString)) {}
        }
        else
        {
          String str = ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getBuddyNickName(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, true);
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(str)) {
            localObject1 = str;
          }
        }
        Object localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = this.jdField_a_of_type_JavaLangString;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.c);
        ((StringBuilder)localObject1).append("(");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(")");
        this.c = ((StringBuilder)localObject1).toString();
      }
      break;
    case 6000: 
      this.c = MobileQQ.sMobileQQ.getResources().getString(2131693779);
      break;
    case 5000: 
      this.c = MobileQQ.sMobileQQ.getResources().getString(2131719782);
      break;
    case 4000: 
      this.c = MobileQQ.sMobileQQ.getResources().getString(2131694443);
      break;
    case 1008: 
      if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, AppConstants.NEW_KANDIAN_UIN)) {
        this.c = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getXinKandianName(this.jdField_a_of_type_ComTencentCommonAppAppInterface, MobileQQ.sMobileQQ.getApplicationContext());
      }
      break;
    case 1001: 
      this.c = MobileQQ.sMobileQQ.getResources().getString(2131693135);
    }
    if (!TextUtils.isEmpty(this.c))
    {
      this.d = ChnToSpell.a(this.c, 1).toLowerCase();
      this.e = ChnToSpell.a(this.c, 2).toLowerCase();
    }
  }
  
  public int a()
  {
    return ((Integer)((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getFaceTypeAndResId(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString).first).intValue();
  }
  
  protected long a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Long = -9223372036854775808L;
    long l = SearchUtils.b(paramString, this.c, IContactSearchable.l);
    if (l > this.jdField_b_of_type_Long) {
      this.jdField_b_of_type_Long = l;
    }
    int i = this.jdField_a_of_type_Int;
    if ((i == 7220) || ((i == 1008) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, AppConstants.NEW_KANDIAN_UIN))))
    {
      l = SearchUtils.b(paramString, HardCodeUtil.a(2131693524), IContactSearchable.l);
      if (l > this.jdField_b_of_type_Long) {
        this.jdField_b_of_type_Long = l;
      }
    }
    if ((((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInReadinjoyFolderMergerStyle()) && (this.jdField_a_of_type_Int == 7220))
    {
      l = SearchUtils.b(paramString, String.format(MobileQQ.sMobileQQ.getResources().getString(2131699863), new Object[] { ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getApplicationContext()), ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getMergerKandianName(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getApplicationContext()), ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getMergerKandianName(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getApplicationContext()) }), IContactSearchable.p);
      if (l > this.jdField_b_of_type_Long) {
        this.jdField_b_of_type_Long = l;
      }
    }
    if (this.jdField_a_of_type_Int == 9002)
    {
      l = SearchUtils.b(paramString, MobileQQ.sMobileQQ.getResources().getString(2131689788), IContactSearchable.p);
      if (l > this.jdField_b_of_type_Long) {
        this.jdField_b_of_type_Long = l;
      }
    }
    l = this.jdField_b_of_type_Long;
    if (l != -9223372036854775808L)
    {
      this.jdField_b_of_type_Long = (l + IContactSearchable.N);
      if ((AppConstants.EC_SHOP_ASSISTANT_UIN.equals(a())) && ((HardCodeUtil.a(2131702723).equals(paramString)) || (HardCodeUtil.a(2131702730).equals(paramString)) || (HardCodeUtil.a(2131702704).equals(paramString)))) {
        this.jdField_b_of_type_Long = (IContactSearchable.x + 1L);
      }
    }
    return this.jdField_b_of_type_Long;
  }
  
  public CharSequence a()
  {
    int i = this.jdField_a_of_type_Int;
    if (i != 7220)
    {
      if (i != 9002) {
        return null;
      }
      return SearchUtils.a(MobileQQ.sMobileQQ.getResources().getString(2131689788), this.jdField_b_of_type_JavaLangString, 255);
    }
    return SearchUtils.a(String.format(MobileQQ.sMobileQQ.getResources().getString(2131699863), new Object[] { ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getApplicationContext()), ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getMergerKandianName(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getApplicationContext()), ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getMergerKandianName(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getApplicationContext()) }), this.jdField_b_of_type_JavaLangString, 255);
  }
  
  public Object a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tool:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (SearchUtils.a(this.jdField_b_of_type_Int))
    {
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        break;
      case 9003: 
        ((IBlessApi)QRoute.api(IBlessApi.class)).openWebBlessActivity(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramView.getContext());
        break;
      case 9002: 
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).startActivateFriendsForModelTroop(paramView.getContext());
        if ((this.jdField_b_of_type_Int == 2) || (this.jdField_b_of_type_Int == 1)) {
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8006477", "0X8006477", this.jdField_b_of_type_Int, 0, "", "", "", "");
        }
        break;
      case 9000: 
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).startTroopNotificationForModelTroop(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramView.getContext());
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
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).updateDeleteOldKandian(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true);
        SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, b().toString(), this.jdField_a_of_type_JavaLangString, "", this.jdField_a_of_type_Int);
        break;
      case 7210: 
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).startTroopBarAssistForModelTroop(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramView.getContext());
        break;
      case 7120: 
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).startECShopAssistForModelTroop(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramView.getContext());
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Clk_Searchshopfolder", 0, 0, "", "", "", "");
        break;
      case 7000: 
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).startSubAccountAssistantForModelTroop(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramView.getContext(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
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
        if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, AppConstants.NEW_KANDIAN_UIN))
        {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800671A", "0X800671A", 0, 0, "", "", "", "", false);
          ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchFeedsActivity(paramView.getContext(), null, -1L, 1);
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).updateDeleteOldKandian(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true);
          SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, b().toString(), this.jdField_a_of_type_JavaLangString, "", this.jdField_a_of_type_Int);
        }
        break;
      case 1001: 
      case 10002: 
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).startMsgBoxListActForModelTroop(paramView.getContext());
      }
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_JavaLangString);
      long l1 = 0L;
      try
      {
        long l2 = Long.parseLong(this.jdField_a_of_type_JavaLangString);
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
      SearchUtils.a(this.jdField_b_of_type_JavaLangString, 20, (int)l1, paramView);
      return;
    }
    SearchUtils.a(paramView, this);
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
    return this.c;
  }
  
  public int d()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return null;
  }
  
  public int e()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelTool
 * JD-Core Version:    0.7.0.1
 */