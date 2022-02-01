package com.tencent.mobileqq.search.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.View;
import com.tencent.biz.lebasearch.Utils;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil.PublicAccountConfigFolder;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.confess.ConfessMsgListFragment;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.api.ISearchUtilFetcher;
import com.tencent.mobileqq.search.base.api.SearchInfoInterface;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelDiscussion;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelGlobalTroop;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelGuild;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelNewTroop;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelTroop;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.model.SearchMatchResult;
import com.tencent.mobileqq.search.mostused.MostUsedSearchResultManager;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.subaccount.api.ISubAccountAssistantForward;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class SearchUtilFetcherImpl
  implements ISearchUtilFetcher
{
  public Drawable getFaceBitmap(IFaceDecoder paramIFaceDecoder, String paramString, int paramInt)
  {
    int i;
    if (paramInt == 103) {
      i = 1;
    } else {
      i = paramInt;
    }
    Bitmap localBitmap = paramIFaceDecoder.getBitmapFromCache(i, paramString);
    if (localBitmap != null)
    {
      if (paramInt == 103) {
        return SearchUtils.a(localBitmap);
      }
      return new BitmapDrawable(localBitmap);
    }
    if (!paramIFaceDecoder.isPausing()) {
      paramIFaceDecoder.requestDecodeFace(paramString, i, true, (byte)1);
    }
    if (paramInt == 1) {
      return ImageUtil.j();
    }
    if (paramInt == 101) {
      return ImageUtil.h();
    }
    if (paramInt == 4) {
      return ImageUtil.f();
    }
    if (paramInt == 11) {
      return new BitmapDrawable(ImageUtil.c());
    }
    if (paramInt == 102) {
      return BaseApplicationImpl.sApplication.getResources().getDrawable(2130845599);
    }
    if (paramInt == 106) {
      return BaseApplicationImpl.sApplication.getResources().getDrawable(2130848921);
    }
    if (paramInt == 105)
    {
      paramIFaceDecoder = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getFolder((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), BaseApplication.getContext(), 1);
      if ((paramIFaceDecoder != null) && (paramIFaceDecoder.c() != null)) {
        return paramIFaceDecoder.c();
      }
      return ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getDefaultDrawable(BaseApplicationImpl.sApplication, 1);
    }
    if (String.valueOf(9999L).equals(paramString)) {
      return BaseApplicationImpl.sApplication.getResources().getDrawable(2130841177);
    }
    if (String.valueOf(9994L).equals(paramString)) {
      return BaseApplicationImpl.sApplication.getResources().getDrawable(2130841185);
    }
    if (String.valueOf(9992L).equals(paramString)) {
      return BaseApplicationImpl.sApplication.getResources().getDrawable(2130841183);
    }
    if (AppConstants.SERVICE_ACCOUNT_FOLDER_UIN.equals(paramString)) {
      return ServiceAccountFolderManager.f();
    }
    if (String.valueOf(9980L).equals(paramString)) {
      return BaseApplicationImpl.sApplication.getResources().getDrawable(2130841184);
    }
    if (String.valueOf(9973L).equals(paramString)) {
      return BaseApplicationImpl.sApplication.getResources().getDrawable(2130846157);
    }
    if (paramInt == 9889987) {
      return BaseApplicationImpl.sApplication.getResources().getDrawable(2130843590);
    }
    if (paramInt == 108)
    {
      paramIFaceDecoder = BaseApplicationImpl.sApplication.getRuntime();
      if (paramIFaceDecoder != null) {
        return ((BlessManager)paramIFaceDecoder.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).A();
      }
    }
    else
    {
      if (String.valueOf(AppConstants.RECOMMEND_CONTACT_UIN).equals(paramString)) {
        return BaseApplicationImpl.sApplication.getResources().getDrawable(2130841172);
      }
      if (paramInt == 110)
      {
        paramIFaceDecoder = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getFolder((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), BaseApplicationImpl.sApplication, 2);
        if ((paramIFaceDecoder != null) && (paramIFaceDecoder.c() != null)) {
          return paramIFaceDecoder.c().getConstantState().newDrawable();
        }
        return ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getDefaultDrawable(BaseApplicationImpl.sApplication, 2).getConstantState().newDrawable();
      }
      if (paramInt == 111)
      {
        paramIFaceDecoder = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getFolder((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), BaseApplicationImpl.sApplication, 3);
        if ((paramIFaceDecoder != null) && (paramIFaceDecoder.c() != null)) {
          return paramIFaceDecoder.c().getConstantState().newDrawable();
        }
        return ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getDefaultDrawable(BaseApplicationImpl.sApplication, 3).getConstantState().newDrawable();
      }
      if (paramInt == 117) {
        return ((IQQGuildService)BaseApplicationImpl.sApplication.getRuntime().getRuntimeService(IQQGuildService.class, "")).getAvatarDrawable(paramString);
      }
      if (paramInt == 119)
      {
        paramIFaceDecoder = BaseApplicationImpl.sApplication.getRuntime();
        if ((paramIFaceDecoder instanceof AppInterface)) {
          return ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getGameMsgAvatarDrawable((AppInterface)paramIFaceDecoder, paramString);
        }
      }
    }
    return ImageUtil.j();
  }
  
  public CharSequence getHighLightApproximateMatchedMessageForMainTitle(AppInterface paramAppInterface, String paramString1, String paramString2, SearchMatchResult paramSearchMatchResult)
  {
    return SearchUtils.a(paramAppInterface, paramString1, paramString2, 6, paramSearchMatchResult);
  }
  
  public CharSequence getHighLightMatchedMessage(String paramString1, String paramString2)
  {
    return SearchUtils.b(paramString1, paramString2, 6);
  }
  
  public CharSequence getHighLightMatchedMessageForMainTitle(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    return SearchUtils.a(paramAppInterface, paramString1, paramString2, 6);
  }
  
  public CharSequence getMessageWithParenthese(CharSequence paramCharSequence)
  {
    return SearchUtils.a(paramCharSequence);
  }
  
  public void handleFeatureJump(Context paramContext, int paramInt1, int paramInt2)
  {
    Object localObject = new HashMap();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((paramInt1 != 2) && (paramInt1 != 18)) {
      if (paramInt1 != 59) {
        if ((paramInt1 == 4) || (paramInt1 == 5) || (paramInt1 == 6) || (paramInt1 == 14) || (paramInt1 == 15) || (paramInt1 == 27) || (paramInt1 == 28)) {
          break label380;
        }
      }
    }
    switch (paramInt1)
    {
    default: 
      switch (paramInt1)
      {
      default: 
        switch (paramInt1)
        {
        default: 
          switch (paramInt1)
          {
          default: 
          case 44: 
            localObject = new Intent(paramContext, ActivateFriendActivity.class);
            ((Intent)localObject).putExtra("af_key_from", 5);
            paramContext.startActivity((Intent)localObject);
            if ((paramInt2 == 2) || (paramInt2 == 1))
            {
              ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8006477", "0X8006477", paramInt2, 0, "", "", "", "");
              return;
            }
            break;
          case 43: 
            SubscribeLaucher.a(paramContext, 9005, null);
            if (QLog.isColorLevel())
            {
              QLog.d("ContactSearchModelTool", 2, "enterServiceAccountFolderActivityFromSearch");
              return;
            }
            break;
          case 42: 
            MsgBoxListActivity.startMsgBoxListActivity(paramContext, 1001, String.valueOf(9999L));
            return;
          case 41: 
            ((INewFriendApi)QRoute.api(INewFriendApi.class)).startActivity(paramContext, null, 0);
            return;
          case 40: 
            ((ISubAccountAssistantForward)QRoute.api(ISubAccountAssistantForward.class)).forwardTo(localQQAppInterface, paramContext, String.valueOf(9992L));
            localQQAppInterface.getMessageFacade().a(String.valueOf(9992L), 7000);
            return;
          }
          break;
        }
      case 30: 
        Utils.gotoFaceToFaceSend(paramContext, (HashMap)localObject);
        return;
        ConfessMsgListFragment.a(paramContext, 2);
        return;
      }
      break;
    case 8: 
    case 9: 
    case 10: 
      label380:
      ((HashMap)localObject).put("newtask", Boolean.valueOf(false));
      ((HashMap)localObject).put("fid", Integer.valueOf(paramInt1));
      Utils.gotoFunctionActivity(paramContext, (HashMap)localObject);
    }
  }
  
  public boolean isEntityGroup(long paramLong)
  {
    if (paramLong <= 0L) {
      return false;
    }
    return (paramLong != 1073745984L) && (paramLong != 2049L) && (paramLong != 1004L) && (paramLong != 64L) && (paramLong != 4097L);
  }
  
  public boolean isGuildModel(ISearchResultModel paramISearchResultModel)
  {
    return (paramISearchResultModel instanceof ContactSearchModelGuild);
  }
  
  public boolean isTroopModel(ISearchResultModel paramISearchResultModel)
  {
    return ((paramISearchResultModel instanceof ContactSearchModelDiscussion)) || ((paramISearchResultModel instanceof ContactSearchModelGlobalTroop)) || ((paramISearchResultModel instanceof ContactSearchModelNewTroop)) || ((paramISearchResultModel instanceof ContactSearchModelTroop));
  }
  
  public boolean isUniteSearchActivity(Context paramContext)
  {
    return ((Activity)paramContext instanceof UniteSearchActivity);
  }
  
  public boolean isValidGroupMask(long paramLong)
  {
    long[] arrayOfLong = UniteSearchHandler.c;
    int j = arrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfLong[i] == paramLong) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void report(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext instanceof SearchInfoInterface))
    {
      paramContext = (SearchInfoInterface)paramContext;
      String str = paramContext.h();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramContext.j());
      report(paramString1, paramString2, new String[] { str, localStringBuilder.toString(), "", SearchUtils.a("dynamic_tab_search.1", paramContext.j()) });
      return;
    }
    report(paramString1, paramString2, new String[0]);
  }
  
  public void report(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    new ReportTask(null).a("dc00899").b("Grp_all_search").c(paramString1).d(paramString2).a(paramInt1).b(paramInt2).a(paramVarArgs).a();
  }
  
  public void report(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    new ReportTask(null).a("dc00899").b(paramString1).c(paramString2).d(paramString3).a(paramInt1).b(paramInt2).a(paramVarArgs).a();
  }
  
  public void report(String paramString1, String paramString2, String... paramVarArgs)
  {
    report(paramString1, paramString2, 0, 0, paramVarArgs);
  }
  
  public void reportContactResultItemClick(ISearchResultPositionModel paramISearchResultPositionModel, View paramView)
  {
    if ((paramISearchResultPositionModel instanceof IContactSearchModel)) {
      SearchUtil.a((IContactSearchModel)paramISearchResultPositionModel, paramView);
    }
  }
  
  public void reportJumpToAIOorProfile(String paramString, int paramInt, View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("moduleType:40 -3 searchKey:");
        paramString.append("");
        QLog.d("searchUtils", 2, paramString.toString());
      }
      ReportController.b(null, "CliOper", "", "", "0X8005E12", "0X8005E12", 40, 0, "3", "", "", "");
      return;
    }
    if (isUniteSearchActivity(paramView.getContext()))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("moduleType:");
        paramString.append(paramInt);
        paramString.append(" -1 searchKey:");
        paramString.append("");
        QLog.d("searchUtils", 2, paramString.toString());
      }
      ReportController.b(null, "CliOper", "", "", "0X8005E12", "0X8005E12", paramInt, 0, "1", "", "", "");
      if (UniteSearchActivity.m)
      {
        if (UniteSearchActivity.o == -1)
        {
          paramString = new StringBuilder();
          paramString.append("");
          paramString.append(UniteSearchActivity.d);
          ReportController.b(null, "CliOper", "", "", "0X8007E2E", "0X8007E2E", 2, 0, "", paramString.toString(), UniteSearchActivity.c, "");
          return;
        }
        paramString = new StringBuilder();
        paramString.append("");
        paramString.append(UniteSearchActivity.d);
        ReportController.b(null, "CliOper", "", "", "0X8007E2E", "0X8007E2E", 1, 0, "", paramString.toString(), UniteSearchActivity.c, "");
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("moduleType:");
        paramString.append(paramInt);
        paramString.append(" -2 searchKey:");
        paramString.append("");
        QLog.d("searchUtils", 2, paramString.toString());
      }
      ReportController.b(null, "CliOper", "", "", "0X8005E12", "0X8005E12", paramInt, 0, "2", "", "", "");
    }
  }
  
  public void saveSearchHistory(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ThreadManager.postImmediately(new SearchUtilFetcherImpl.1(this, paramString1, paramInt, paramString2, paramString3, paramAppInterface), null, false);
  }
  
  public void selectContactResult(View paramView, ISearchResultPositionModel paramISearchResultPositionModel)
  {
    if ((paramISearchResultPositionModel instanceof IContactSearchModel)) {
      SearchUtil.a(paramView, (IContactSearchModel)paramISearchResultPositionModel);
    }
  }
  
  public void updateItemUsed(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ((MostUsedSearchResultManager)paramAppInterface.getManager(QQManagerFactory.MOST_USE_SEARCH_MANAGER)).a(paramString1, paramString2, paramString3, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.api.impl.SearchUtilFetcherImpl
 * JD-Core Version:    0.7.0.1
 */