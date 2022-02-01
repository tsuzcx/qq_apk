package com.tencent.mobileqq.search;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.adapter.ContactsSearchResultAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.temporaryban.api.ITemporarilyBannedTroopUtilApi;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.threadpriority.ThreadPriorityManager;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.Map;

class HistorySearchEntryModel$5
  implements AdapterView.OnItemClickListener
{
  HistorySearchEntryModel$5(HistorySearchEntryModel paramHistorySearchEntryModel) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ThreadPriorityManager.a(true);
    if ((paramAdapterView == this.a.d) && (this.a.h != null))
    {
      paramAdapterView = new StringBuilder();
      paramAdapterView.append("");
      paramAdapterView.append(paramInt);
      SearchUtils.a("home_page", "clk_history", new String[] { paramAdapterView.toString() });
      paramAdapterView = (IContactSearchable)this.a.h.getItem(paramInt);
      if ((paramAdapterView instanceof ContactSearchableSearchHistory))
      {
        SearchHistory localSearchHistory = ((ContactSearchableSearchHistory)paramAdapterView).e();
        paramAdapterView = new StringBuilder();
        paramAdapterView.append("on serarch history click, ");
        paramAdapterView.append(localSearchHistory.toString());
        QLog.d("searchUtils", 2, paramAdapterView.toString());
        paramInt = localSearchHistory.type;
        if (paramInt != 0)
        {
          Object localObject2;
          if (paramInt != 1)
          {
            if (paramInt != 1000)
            {
              if (paramInt == 1001) {
                break label987;
              }
              if (paramInt != 1008)
              {
                if (paramInt == 3000) {
                  break label987;
                }
                if (paramInt != 7220)
                {
                  if ((paramInt == 10002) || (paramInt == 10004)) {
                    break label987;
                  }
                  if (paramInt != 10007) {
                    if (paramInt == 10010) {
                      break label987;
                    }
                  }
                }
              }
            }
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                break;
              case 56942: 
                paramAdapterView = new AllInOne(localSearchHistory.uin, 53);
                paramAdapterView.contactName = localSearchHistory.displayName;
                paramAdapterView.lastActivity = 3;
                ProfileUtils.openProfileCard(paramView.getContext(), paramAdapterView);
                break;
              case 56941: 
                paramAdapterView = new AllInOne(localSearchHistory.uin, 34);
                paramAdapterView.contactName = localSearchHistory.displayName;
                paramAdapterView.lastActivity = 3;
                ProfileUtils.openProfileCard(paramView.getContext(), paramAdapterView);
                break;
              case 56940: 
                paramAdapterView = new AllInOne(localSearchHistory.uin, 29);
                paramAdapterView.contactName = localSearchHistory.displayName;
                paramAdapterView.lastActivity = 3;
                ProfileUtils.openProfileCard(paramView.getContext(), paramAdapterView);
                break;
              case 56939: 
                paramAdapterView = new AllInOne(localSearchHistory.uin, 53);
                paramAdapterView.contactName = localSearchHistory.displayName;
                paramAdapterView.lastActivity = 3;
                ProfileUtils.openProfileCard(paramView.getContext(), paramAdapterView);
                break;
              case 56938: 
                localObject1 = new AllInOne(localSearchHistory.uin, 33);
                ((AllInOne)localObject1).contactArray = new ArrayList();
                ((AllInOne)localObject1).contactName = localSearchHistory.displayName;
                if (!TextUtils.isEmpty(localSearchHistory.uin))
                {
                  localObject2 = localSearchHistory.uin.split("\\|");
                  if (localObject2 != null)
                  {
                    paramInt = 0;
                    while (paramInt < localObject2.length)
                    {
                      ArrayList localArrayList = ((AllInOne)localObject1).contactArray;
                      StringBuilder localStringBuilder = new StringBuilder();
                      localStringBuilder.append(HardCodeUtil.a(2131903465));
                      if (localObject2.length > 0) {
                        paramAdapterView = Integer.valueOf(paramInt + 1);
                      } else {
                        paramAdapterView = "";
                      }
                      localStringBuilder.append(paramAdapterView);
                      localArrayList.add(new ProfileContactInfo(localStringBuilder.toString(), localObject2[paramInt], null));
                      paramInt += 1;
                    }
                  }
                }
                ((AllInOne)localObject1).lastActivity = 3;
                ProfileUtils.openProfileCard(paramView.getContext(), (AllInOne)localObject1);
              }
              break;
            case 1004: 
              paramAdapterView = (DiscussionManager)HistorySearchEntryModel.c(this.a).getManager(QQManagerFactory.DISCUSSION_MANAGER);
              if (paramAdapterView != null)
              {
                paramAdapterView = paramAdapterView.b(localSearchHistory.troopUin);
                if (paramAdapterView != null)
                {
                  paramAdapterView = (DiscussionMemberInfo)paramAdapterView.get(localSearchHistory.uin);
                  if (paramAdapterView != null)
                  {
                    RecentUtil.a = true;
                    RecentUtil.a(paramView.getContext(), localSearchHistory.uin, localSearchHistory.troopUin, localSearchHistory.type, paramAdapterView.memberName, false, null, null);
                    break;
                  }
                }
              }
              RecentUtil.a = true;
              RecentUtil.a(paramView.getContext(), localSearchHistory.uin, localSearchHistory.troopUin, localSearchHistory.type, localSearchHistory.displayName, false, null, null);
              break;
              ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).enterGameMsgChatPie(HistorySearchEntryModel.c(this.a), paramView.getContext(), localSearchHistory.uin, 6);
              break;
              ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800671B", "0X800671B", 0, 0, "", "", "", "", false);
              ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchFeedsActivity(paramView.getContext(), 1, 0);
              break;
              if (!TextUtils.equals(localSearchHistory.uin, AppConstants.NEW_KANDIAN_UIN)) {
                break;
              }
              ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800671B", "0X800671B", 0, 0, "", "", "", "", false);
              ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchFeedsActivity(paramView.getContext(), null, -1L, 1);
              break;
              RecentUtil.a = true;
              boolean bool;
              if ((paramView.getContext() instanceof UniteSearchActivity)) {
                bool = SearchUtil.a(localSearchHistory.uin);
              } else {
                bool = false;
              }
              if (!bool) {
                RecentUtil.a(paramView.getContext(), localSearchHistory.uin, localSearchHistory.troopUin, localSearchHistory.type, localSearchHistory.displayName, false, null, null);
              } else {
                RobotUtils.a(paramView.getContext(), null, localSearchHistory.uin);
              }
              break;
            }
          }
          label987:
          RecentUtil.a = true;
          paramAdapterView = localSearchHistory.displayName;
          Object localObject1 = paramAdapterView;
          if (localSearchHistory.type == 1)
          {
            localObject1 = ((TroopManager)HistorySearchEntryModel.c(this.a).getManager(QQManagerFactory.TROOP_MANAGER)).f(localSearchHistory.uin);
            if (localObject1 != null) {
              paramAdapterView = ((TroopInfo)localObject1).getTroopDisplayName();
            }
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("uin", localSearchHistory.uin);
            ((Intent)localObject2).putExtra("uintype", localSearchHistory.type);
            localObject1 = paramAdapterView;
            if (((ITemporarilyBannedTroopUtilApi)QRoute.api(ITemporarilyBannedTroopUtilApi.class)).checkTemporarilyBannedTroop(paramView.getContext(), HistorySearchEntryModel.c(this.a), (Intent)localObject2)) {}
          }
          else
          {
            RecentUtil.a(paramView.getContext(), HistorySearchEntryModel.c(this.a), localSearchHistory.uin, localSearchHistory.type, (String)localObject1, false);
          }
        }
        else
        {
          paramAdapterView = (FriendsManager)HistorySearchEntryModel.c(this.a).getManager(QQManagerFactory.FRIENDS_MANAGER);
          if (paramAdapterView == null) {
            break label1220;
          }
          paramAdapterView = paramAdapterView.m(localSearchHistory.uin);
          if (paramAdapterView != null)
          {
            RecentUtil.a = true;
            RecentUtil.a(paramView.getContext(), HistorySearchEntryModel.c(this.a), localSearchHistory.uin, 0, ContactUtils.a(paramAdapterView), false);
          }
        }
        paramInt = 1;
        break label1222;
        label1220:
        paramInt = 0;
        label1222:
        if (paramInt != 0)
        {
          SearchUtils.a(HistorySearchEntryModel.c(this.a), localSearchHistory.displayName, localSearchHistory.uin, localSearchHistory.troopUin, localSearchHistory.type);
          int i;
          if (localSearchHistory.type == 1) {
            i = 2;
          } else if (localSearchHistory.type == 3000) {
            i = 3;
          } else {
            i = 1;
          }
          if (this.a.g == 2) {
            paramInt = 3;
          } else if (this.a.g == 10) {
            paramInt = 2;
          } else if (this.a.g == 1) {
            paramInt = 1;
          } else {
            paramInt = 0;
          }
          ReportController.b(null, "CliOper", "", "", "Search", "May_find", paramInt, 0, String.valueOf(i), "", "", "");
        }
        if (localSearchHistory.type == 0)
        {
          paramInt = 1;
          break label1411;
        }
        if ((localSearchHistory.type == 1) || (localSearchHistory.type == 3000))
        {
          paramInt = 2;
          break label1411;
        }
      }
      paramInt = 0;
      label1411:
      UniteSearchReportController.a(HistorySearchEntryModel.c(this.a), 0, SearchEntryFragment.b(this.a.a), "0X8009D19", paramInt, 0, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.HistorySearchEntryModel.5
 * JD-Core Version:    0.7.0.1
 */