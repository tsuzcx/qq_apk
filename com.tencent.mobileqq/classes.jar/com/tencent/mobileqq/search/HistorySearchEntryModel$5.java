package com.tencent.mobileqq.search;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.threadpriority.ThreadPriorityManager;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView<*>;
import java.util.ArrayList;
import java.util.Map;

class HistorySearchEntryModel$5
  implements AdapterView.OnItemClickListener
{
  HistorySearchEntryModel$5(HistorySearchEntryModel paramHistorySearchEntryModel) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ThreadPriorityManager.a(true);
    SearchHistory localSearchHistory;
    label278:
    int i;
    if ((paramAdapterView == this.a.jdField_a_of_type_ComTencentWidgetXListView) && (this.a.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter != null))
    {
      SearchUtils.a("home_page", "clk_history", new String[] { "" + paramInt });
      paramAdapterView = (IContactSearchable)this.a.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.getItem(paramInt);
      if (!(paramAdapterView instanceof ContactSearchableSearchHistory)) {
        break label1331;
      }
      localSearchHistory = ((ContactSearchableSearchHistory)paramAdapterView).a();
      QLog.d("searchUtils", 2, "on serarch history click, " + localSearchHistory.toString());
      switch (localSearchHistory.type)
      {
      default: 
        paramInt = 1;
        if (paramInt != 0)
        {
          SearchUtils.a(HistorySearchEntryModel.a(this.a), localSearchHistory.displayName, localSearchHistory.uin, localSearchHistory.troopUin, localSearchHistory.type);
          if (localSearchHistory.type != 1) {
            break label1256;
          }
          i = 2;
        }
        break;
      }
    }
    for (;;)
    {
      label324:
      paramInt = 0;
      if (this.a.b == 2)
      {
        paramInt = 3;
        label339:
        ReportController.b(null, "CliOper", "", "", "Search", "May_find", paramInt, 0, String.valueOf(i), "", "", "");
        if (localSearchHistory.type != 0) {
          break label1306;
        }
        paramInt = 1;
      }
      for (;;)
      {
        UniteSearchReportController.a(HistorySearchEntryModel.a(this.a), 0, SearchEntryFragment.a(this.a.jdField_a_of_type_Int), "0X8009D19", paramInt, 0, null, null);
        return;
        paramAdapterView = new ProfileActivity.AllInOne(localSearchHistory.uin, 29);
        paramAdapterView.k = localSearchHistory.displayName;
        paramAdapterView.g = 3;
        ProfileActivity.b(paramView.getContext(), paramAdapterView);
        paramInt = 1;
        break label278;
        paramAdapterView = new ProfileActivity.AllInOne(localSearchHistory.uin, 34);
        paramAdapterView.k = localSearchHistory.displayName;
        paramAdapterView.g = 3;
        ProfileActivity.b(paramView.getContext(), paramAdapterView);
        paramInt = 1;
        break label278;
        paramAdapterView = new ProfileActivity.AllInOne(localSearchHistory.uin, 53);
        paramAdapterView.k = localSearchHistory.displayName;
        paramAdapterView.g = 3;
        ProfileActivity.b(paramView.getContext(), paramAdapterView);
        paramInt = 1;
        break label278;
        paramAdapterView = new ProfileActivity.AllInOne(localSearchHistory.uin, 53);
        paramAdapterView.k = localSearchHistory.displayName;
        paramAdapterView.g = 3;
        ProfileActivity.b(paramView.getContext(), paramAdapterView);
        paramInt = 1;
        break label278;
        Object localObject1 = new ProfileActivity.AllInOne(localSearchHistory.uin, 33);
        ((ProfileActivity.AllInOne)localObject1).a = new ArrayList();
        ((ProfileActivity.AllInOne)localObject1).k = localSearchHistory.displayName;
        Object localObject2;
        if (!TextUtils.isEmpty(localSearchHistory.uin))
        {
          localObject2 = localSearchHistory.uin.split("\\|");
          if (localObject2 != null)
          {
            paramInt = 0;
            if (paramInt < localObject2.length)
            {
              ArrayList localArrayList = ((ProfileActivity.AllInOne)localObject1).a;
              StringBuilder localStringBuilder = new StringBuilder().append(HardCodeUtil.a(2131705506));
              if (localObject2.length > 0) {}
              for (paramAdapterView = Integer.valueOf(paramInt + 1);; paramAdapterView = "")
              {
                localArrayList.add(new ProfileActivity.CardContactInfo(paramAdapterView, localObject2[paramInt], null));
                paramInt += 1;
                break;
              }
            }
          }
        }
        ((ProfileActivity.AllInOne)localObject1).g = 3;
        ProfileActivity.b(paramView.getContext(), (ProfileActivity.AllInOne)localObject1);
        paramInt = 1;
        break label278;
        paramAdapterView = (FriendsManager)HistorySearchEntryModel.a(this.a).getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (paramAdapterView != null)
        {
          paramAdapterView = paramAdapterView.e(localSearchHistory.uin);
          if (paramAdapterView != null)
          {
            RecentUtil.a = true;
            RecentUtil.a(paramView.getContext(), HistorySearchEntryModel.a(this.a), localSearchHistory.uin, 0, ContactUtils.a(paramAdapterView), false);
          }
          paramInt = 1;
          break label278;
        }
        paramInt = 0;
        break label278;
        paramAdapterView = (DiscussionManager)HistorySearchEntryModel.a(this.a).getManager(QQManagerFactory.DISCUSSION_MANAGER);
        if (paramAdapterView != null)
        {
          paramAdapterView = paramAdapterView.a(localSearchHistory.troopUin);
          if (paramAdapterView != null)
          {
            paramAdapterView = (DiscussionMemberInfo)paramAdapterView.get(localSearchHistory.uin);
            if (paramAdapterView != null)
            {
              RecentUtil.a = true;
              RecentUtil.a(paramView.getContext(), localSearchHistory.uin, localSearchHistory.troopUin, localSearchHistory.type, paramAdapterView.memberName, false, null, null);
              paramInt = 1;
              break label278;
            }
          }
        }
        RecentUtil.a = true;
        RecentUtil.a(paramView.getContext(), localSearchHistory.uin, localSearchHistory.troopUin, localSearchHistory.type, localSearchHistory.displayName, false, null, null);
        paramInt = 1;
        break label278;
        RecentUtil.a = true;
        boolean bool = false;
        if ((paramView.getContext() instanceof UniteSearchActivity)) {
          bool = SearchUtil.a(localSearchHistory.uin);
        }
        if (!bool)
        {
          RecentUtil.a(paramView.getContext(), localSearchHistory.uin, localSearchHistory.troopUin, localSearchHistory.type, localSearchHistory.displayName, false, null, null);
          paramInt = 1;
          break label278;
        }
        RobotUtils.a(paramView.getContext(), null, localSearchHistory.uin);
        paramInt = 1;
        break label278;
        RecentUtil.a = true;
        localObject1 = localSearchHistory.displayName;
        paramAdapterView = (AdapterView<?>)localObject1;
        if (localSearchHistory.type == 1)
        {
          localObject2 = ((TroopManager)HistorySearchEntryModel.a(this.a).getManager(QQManagerFactory.TROOP_MANAGER)).b(localSearchHistory.uin);
          paramAdapterView = (AdapterView<?>)localObject1;
          if (localObject2 != null) {
            paramAdapterView = ((TroopInfo)localObject2).getTroopDisplayName();
          }
        }
        RecentUtil.a(paramView.getContext(), HistorySearchEntryModel.a(this.a), localSearchHistory.uin, localSearchHistory.type, paramAdapterView, false);
        paramInt = 1;
        break label278;
        if (!TextUtils.equals(localSearchHistory.uin, AppConstants.NEW_KANDIAN_UIN)) {
          break;
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800671B", "0X800671B", 0, 0, "", "", "", "", false);
        ReadInJoyActivityHelper.a(paramView.getContext(), null, -1L, 1);
        paramInt = 1;
        break label278;
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800671B", "0X800671B", 0, 0, "", "", "", "", false);
        ReadInJoyActivityHelper.a(HistorySearchEntryModel.a(this.a), paramView.getContext(), 1, 0);
        break;
        label1256:
        if (localSearchHistory.type != 3000) {
          break label1336;
        }
        i = 3;
        break label324;
        if (this.a.b == 10)
        {
          paramInt = 2;
          break label339;
        }
        if (this.a.b != 1) {
          break label339;
        }
        paramInt = 1;
        break label339;
        label1306:
        if ((localSearchHistory.type == 1) || (localSearchHistory.type == 3000)) {
          paramInt = 2;
        } else {
          label1331:
          paramInt = 0;
        }
      }
      label1336:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.HistorySearchEntryModel.5
 * JD-Core Version:    0.7.0.1
 */