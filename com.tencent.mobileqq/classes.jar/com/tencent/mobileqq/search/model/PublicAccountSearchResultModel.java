package com.tencent.mobileqq.search.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountSearchRecommendManager;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.ecshopassit.utils.JumpUtil;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.gamecenter.util.QQGameConfigUtil;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.now.NowQQLiveConstant;
import com.tencent.mobileqq.now.NowQQLiveHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.HighlightModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.contentbox.QZoneMsgActivity;
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
  
  protected long a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    long l2 = SearchUtils.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name, 1073741824L);
    long l1 = l2;
    if (l2 != -9223372036854775808L) {
      l1 = (l2 & 0x0) >> 20 | 0xFFFFFFFF & l2 | (0x0 & l2) >> 26;
    }
    if (l1 > this.jdField_a_of_type_Long) {
      this.jdField_a_of_type_Long = l1;
    }
    for (int i = 1;; i = 0)
    {
      if (this.jdField_a_of_type_Long != -9223372036854775808L)
      {
        if (this.b != IContactSearchable.O) {
          break label232;
        }
        this.jdField_a_of_type_Long |= 0x100000;
        if (!this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isOffLine)
        {
          this.jdField_a_of_type_Long |= 0x0;
          if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.clickCount >= 3) {
            if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.clickCount >= 128) {
              break label247;
            }
          }
        }
      }
      label232:
      label247:
      for (this.jdField_a_of_type_Long |= (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.clickCount & 0x7F) << 32;; this.jdField_a_of_type_Long |= 0x0)
      {
        if (i != 0) {
          this.jdField_a_of_type_Long |= 0x0;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.certifiedGrade == 1L) {
          this.jdField_a_of_type_Long |= 0x80000000;
        }
        return this.jdField_a_of_type_Long;
        this.jdField_a_of_type_Long |= 0x80000;
        break;
      }
    }
  }
  
  public PublicAccountInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo;
  }
  
  public Object a()
  {
    return Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.uin);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    Object localObject2 = paramView.getContext();
    if (localObject2 == null) {}
    String str;
    label143:
    do
    {
      return;
      if ((localObject2 instanceof UniteSearchActivity))
      {
        SearchUtils.a("all_result", "clk_public_uin", new String[] { "" + this.jdField_a_of_type_JavaLangString });
        UniteSearchReportController.a(null, 0, this.c, "0X8009D51", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin(), null);
      }
      str = this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin();
      PAStartupTracker.a(null, "pubAcc_aio_open", str);
      localObject1 = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if (!AppConstants.WEISHI_UIN.equals(str)) {
        break;
      }
      ((IWSManager)QRoute.api(IWSManager.class)).enterWSPublicAccount((Context)localObject2, "from_search_result", true);
      SearchUtils.a(this.jdField_a_of_type_JavaLangString, 50, 0, paramView, str, this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isOffLine, this.c);
      SearchHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      SearchUtils.a(this.jdField_a_of_type_JavaLangString, 50, paramView, false);
    } while ((!(localObject2 instanceof BaseActivity)) || (this.jdField_a_of_type_Int <= 0));
    Object localObject1 = null;
    paramView = null;
    if ((localObject2 instanceof UniteSearchActivity))
    {
      localObject1 = "0X8005D1C";
      paramView = "0X8006570";
      label224:
      if (localObject1 == null) {
        break label911;
      }
      localObject2 = ((BaseActivity)localObject2).app;
      if (this.c != 12) {
        break label913;
      }
      ReportController.b((AppRuntime)localObject2, "CliOper", "", "", paramView, paramView, 0, 1, 0, this.jdField_a_of_type_Int + "", "", str, this.jdField_a_of_type_JavaLangString);
      label294:
      paramView = PublicAccountSearchRecommendManager.a();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name;
      if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.extendType == 2) {
        break label977;
      }
    }
    label911:
    label913:
    label977:
    for (boolean bool = true;; bool = false)
    {
      paramView.a((QQAppInterface)localObject2, str, (String)localObject1, bool);
      return;
      if (AppConstants.TIM_TEAM_UIN.equals(str))
      {
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).enterTimTeam((Context)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        break label143;
      }
      if ((TextUtils.equals("2290230341", str)) && (QZoneMsgActivity.open((Context)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        break label143;
      }
      if (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(str))
      {
        KandianSubscribeManager.a((Context)localObject2, 3, 2);
        break label143;
      }
      if (AppConstants.KANDIAN_DAILY_UIN.equals(str))
      {
        KandianDailyManager.a((Context)localObject2);
        break label143;
      }
      if (("2747277822".equals(str)) && (QQGameConfigUtil.b()))
      {
        QQGameHelper.a((Context)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a("2747277822", 1008, false);
        break label143;
      }
      if (((IMiniAppService)QRoute.api(IMiniAppService.class)).shouldOpenWebFragment(str))
      {
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniGamePublicAccount((Context)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN, 1008, false);
        break label143;
      }
      if (NowQQLiveConstant.jdField_a_of_type_JavaLangString.equals(str))
      {
        NowQQLiveHelper.a((Context)localObject2, str, 3);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(NowQQLiveConstant.jdField_a_of_type_JavaLangString, 1008, false);
        break label143;
      }
      if (TextUtils.equals("3046055438", str))
      {
        JumpUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Context)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a("3046055438", 1008, false);
        break label143;
      }
      if (((localObject1 != null) && (((PublicAccountDataManager)localObject1).a(Long.valueOf(str)))) || ((localObject1 == null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isFollowUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str))))
      {
        Intent localIntent = new Intent(paramView.getContext(), ChatActivity.class);
        int i = 1008;
        if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.extendType == 2)
        {
          localIntent.putExtra("chat_subType", 1);
          i = 0;
        }
        if (TextUtils.isEmpty(str))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.w("PublicAccountSearchResultModel", 2, "uin is null");
          return;
        }
        localIntent.putExtra("uin", str);
        localIntent.putExtra("uintype", i);
        localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name);
        localIntent.putExtra("selfSet_leftViewText", ((Context)localObject2).getString(2131690778));
        RecentUtil.a = true;
        RecentUtil.a(localIntent);
        ((Context)localObject2).startActivity(localIntent);
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.clickCount += 1;
        if (localObject1 == null) {
          break label143;
        }
        ((PublicAccountDataManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
        break label143;
      }
      if (TextUtils.isEmpty(str))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("PublicAccountSearchResultModel", 2, "uin is null");
        return;
      }
      localObject1 = new ActivityURIRequest((Context)localObject2, "/pubaccount/detail");
      ((ActivityURIRequest)localObject1).extra().putString("uin", str);
      ((ActivityURIRequest)localObject1).extra().putInt("source", 4);
      QRoute.startUri((URIRequest)localObject1, null);
      break label143;
      if (!(localObject2 instanceof PublicAcntSearchActivity)) {
        break label224;
      }
      localObject1 = "0X8005D1E";
      paramView = "0X8006588";
      break label224;
      break;
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate((AppInterface)localObject2, "P_CliOper", "Pb_account_lifeservice", str, (String)localObject1, (String)localObject1, 0, 0, this.jdField_a_of_type_Int + "", "", this.jdField_a_of_type_JavaLangString, "", false);
      break label294;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin();
  }
  
  public int c()
  {
    return 1;
  }
  
  public CharSequence c()
  {
    SpannableString localSpannableString = new HighlightModel(new ArrayList(), a()).a(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.summary));
    Object localObject = localSpannableString;
    if (localSpannableString == null) {
      localObject = "";
    }
    return localObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.PublicAccountSearchResultModel
 * JD-Core Version:    0.7.0.1
 */