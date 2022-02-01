package com.tencent.mobileqq.search.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.ecshop.api.IEcshopUtilApi;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.daily.api.IKandianDailyManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IKandianSubscribeManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.now.NowQQLiveConstant;
import com.tencent.mobileqq.now.NowQQLiveHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.HighlightModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.contentbox.IQzoneMsgApi;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class PublicAccountSearchResultModel
  extends IContactSearchModel
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public final PublicAccountInfo a;
  private String jdField_a_of_type_JavaLangString;
  private long b;
  private int c = -1;
  
  public PublicAccountSearchResultModel(QQAppInterface paramQQAppInterface, PublicAccountInfo paramPublicAccountInfo, int paramInt)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = paramPublicAccountInfo;
    if (paramQQAppInterface.getProxyManager().a().a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin()))
    {
      this.b = IContactSearchable.O;
      return;
    }
    this.b = IContactSearchable.P;
  }
  
  public int a()
  {
    return 1;
  }
  
  protected long a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    long l2 = SearchUtils.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name, 1073741824L);
    long l1 = l2;
    if (l2 != -9223372036854775808L) {
      l1 = (l2 & 0x0) >> 20 | 0xFFFFFFFF & l2 | (0x0 & l2) >> 26;
    }
    int i;
    if (l1 > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l1;
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (this.jdField_a_of_type_Long != -9223372036854775808L)
    {
      if (this.b == IContactSearchable.O) {
        this.jdField_a_of_type_Long |= 0x100000;
      } else {
        this.jdField_a_of_type_Long |= 0x80000;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isOffLine)
      {
        this.jdField_a_of_type_Long |= 0x0;
        if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.clickCount >= 3) {
          if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.clickCount < 128) {
            this.jdField_a_of_type_Long |= (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.clickCount & 0x7F) << 32;
          } else {
            this.jdField_a_of_type_Long |= 0x0;
          }
        }
      }
      if (i != 0) {
        this.jdField_a_of_type_Long |= 0x0;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.certifiedGrade == 1L) {
        this.jdField_a_of_type_Long |= 0x80000000;
      }
    }
    return this.jdField_a_of_type_Long;
  }
  
  public PublicAccountInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo;
  }
  
  public CharSequence a()
  {
    SpannableString localSpannableString = new HighlightModel(new ArrayList(), b()).a(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.summary));
    Object localObject = localSpannableString;
    if (localSpannableString == null) {
      localObject = "";
    }
    return localObject;
  }
  
  public Object a()
  {
    return Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.uin);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    Object localObject3 = paramView.getContext();
    if (localObject3 == null) {
      return;
    }
    boolean bool2 = localObject3 instanceof UniteSearchActivity;
    boolean bool1 = false;
    if (bool2)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      SearchUtils.a("all_result", "clk_public_uin", new String[] { ((StringBuilder)localObject1).toString() });
      UniteSearchReportController.a(null, 0, this.c, "0X8009D51", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin(), null);
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin();
    PAStartupTracker.a(null, "pubAcc_aio_open", str);
    Object localObject1 = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    Object localObject2;
    if (AppConstants.WEISHI_UIN.equals(str)) {
      ((IWSManager)QRoute.api(IWSManager.class)).enterWSPublicAccount((Context)localObject3, "from_search_result", true);
    } else if (AppConstants.TIM_TEAM_UIN.equals(str)) {
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).enterTimTeam((Context)localObject3, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    } else if ((!TextUtils.equals("2290230341", str)) || (!((IQzoneMsgApi)QRoute.api(IQzoneMsgApi.class)).openContentBox((Context)localObject3))) {
      if (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(str))
      {
        ((IKandianSubscribeManager)((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getRuntimeService(IKandianSubscribeManager.class)).lanuchKandianSubscribeActivity((Context)localObject3, 3, 2);
      }
      else if (AppConstants.KANDIAN_DAILY_UIN.equals(str))
      {
        ((IKandianDailyManager)QRoute.api(IKandianDailyManager.class)).launchKandianDaily((Context)localObject3);
      }
      else if (("2747277822".equals(str)) && (((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).checkGamePubAccountConfig()))
      {
        ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).startQQGamePubAccount((Context)localObject3, 3);
        ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getConversationFacade().a("2747277822", 1008, false);
      }
      else if (((IMiniAppService)QRoute.api(IMiniAppService.class)).shouldOpenWebFragment(str))
      {
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniGamePublicAccount((Context)localObject3);
        ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getConversationFacade().a(AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN, 1008, false);
      }
      else if (NowQQLiveConstant.jdField_a_of_type_JavaLangString.equals(str))
      {
        NowQQLiveHelper.a((Context)localObject3, str, 3);
        ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getConversationFacade().a(NowQQLiveConstant.jdField_a_of_type_JavaLangString, 1008, false);
      }
      else if (TextUtils.equals("3046055438", str))
      {
        ((IEcshopUtilApi)QRoute.api(IEcshopUtilApi.class)).jump((Context)localObject3);
        ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getConversationFacade().a("3046055438", 1008, false);
        localObject2 = new Intent(paramView.getContext(), ChatActivity.class);
        int i;
        if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.extendType == 2)
        {
          ((Intent)localObject2).putExtra("chat_subType", 1);
          i = 0;
        }
        else
        {
          i = 1008;
        }
        if (TextUtils.isEmpty(str))
        {
          if (QLog.isColorLevel()) {
            QLog.w("PublicAccountSearchResultModel", 2, "uin is null");
          }
          return;
        }
        ((Intent)localObject2).putExtra("uin", str);
        ((Intent)localObject2).putExtra("uintype", i);
        ((Intent)localObject2).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name);
        ((Intent)localObject2).putExtra("selfSet_leftViewText", ((Context)localObject3).getString(2131690706));
        RecentUtil.a = true;
        RecentUtil.a((Intent)localObject2);
        ((Context)localObject3).startActivity((Intent)localObject2);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo;
        ((PublicAccountInfo)localObject2).clickCount += 1;
        if (localObject1 != null) {
          ((IPublicAccountDataManager)localObject1).savePublicAccountInfo(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
        }
      }
      else
      {
        if (TextUtils.isEmpty(str))
        {
          if (QLog.isColorLevel()) {
            QLog.w("PublicAccountSearchResultModel", 2, "uin is null");
          }
          return;
        }
        localObject1 = new ActivityURIRequest((Context)localObject3, "/pubaccount/detail");
        ((ActivityURIRequest)localObject1).extra().putString("uin", str);
        ((ActivityURIRequest)localObject1).extra().putInt("source", 4);
        QRoute.startUri((URIRequest)localObject1, null);
      }
    }
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 50, 0, paramView, str, this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isOffLine, this.c);
    SearchHistoryManager.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString);
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 50, paramView, false);
    if (((localObject3 instanceof BaseActivity)) && (this.jdField_a_of_type_Int > 0))
    {
      if (bool2) {
        localObject1 = "0X8005D1C";
      }
      for (paramView = "0X8006570";; paramView = "0X8006588")
      {
        localObject2 = localObject1;
        localObject1 = paramView;
        paramView = (View)localObject2;
        break label876;
        if (!(localObject3 instanceof PublicAcntSearchActivity)) {
          break;
        }
        localObject1 = "0X8005D1E";
      }
      localObject1 = null;
      paramView = (View)localObject1;
      label876:
      if (paramView == null) {
        return;
      }
      localObject2 = ((BaseActivity)localObject3).app;
      if (this.c == 12)
      {
        paramView = new StringBuilder();
        paramView.append(this.jdField_a_of_type_Int);
        paramView.append("");
        ReportController.b((AppRuntime)localObject2, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 1, 0, paramView.toString(), "", str, this.jdField_a_of_type_JavaLangString);
      }
      else
      {
        localObject1 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject3).append("");
        ((IPublicAccountReportUtils)localObject1).publicAccountReportClickEventForMigrate((AppInterface)localObject2, "P_CliOper", "Pb_account_lifeservice", str, paramView, paramView, 0, 0, ((StringBuilder)localObject3).toString(), "", this.jdField_a_of_type_JavaLangString, "", false);
      }
      paramView = (IPublicAccountSearchRecommendManager)QRoute.api(IPublicAccountSearchRecommendManager.class);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name;
      if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.extendType != 2) {
        bool1 = true;
      }
      paramView.updatePublicAccountSearchHistoryItem((AppInterface)localObject2, str, (String)localObject1, bool1);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name;
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
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.PublicAccountSearchResultModel
 * JD-Core Version:    0.7.0.1
 */