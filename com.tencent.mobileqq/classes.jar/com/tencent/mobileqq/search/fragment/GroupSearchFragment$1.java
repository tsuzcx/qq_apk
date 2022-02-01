package com.tencent.mobileqq.search.fragment;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.base.api.SearchEntryConfigManager;
import com.tencent.mobileqq.search.base.api.SearchInfoInterface;
import com.tencent.mobileqq.search.base.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelGuild;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFavorite;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFileEntity;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFunction;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelLocalGuild;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMessage;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMiniProgram;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMostUsed;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMultiChat;
import com.tencent.mobileqq.search.ftsmsg.FTSGroupSearchModelMessage;
import com.tencent.mobileqq.search.model.BaseSearchResultGroupModel;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalTroop;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.model.MiniProgramSearchResultModel;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.ReportUtil;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchUtils.ObjectItemInfo;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class GroupSearchFragment$1
  extends Handler
{
  GroupSearchFragment$1(GroupSearchFragment paramGroupSearchFragment, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    int i = paramMessage.what;
    if (i != 100)
    {
      int j;
      label349:
      int k;
      label437:
      long l;
      switch (i)
      {
      default: 
        return;
      case 14: 
        Object localObject1 = (List)paramMessage.obj;
        int n = paramMessage.arg1;
        boolean bool1;
        if ((n != 4) && (n != 5)) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        paramMessage = new StringBuilder();
        paramMessage.append("handleMessage log for search , GET_LOCAL_CALLBACK_ON_FINISH, onFinish  status = ");
        paramMessage.append(n);
        paramMessage.append(" isFinish");
        paramMessage.append(bool1);
        QLog.i("Q.uniteSearch.GroupSearchFragment", 2, paramMessage.toString());
        paramMessage = (Message)localObject1;
        if (localObject1 == null) {
          paramMessage = new ArrayList();
        }
        if ((paramMessage.size() == 0) && (!bool1)) {
          return;
        }
        if ((System.currentTimeMillis() - this.a.L < 500L) && (!bool1))
        {
          this.a.L = System.currentTimeMillis();
          return;
        }
        this.a.L = System.currentTimeMillis();
        localObject1 = this.a;
        ((GroupSearchFragment)localObject1).r = paramMessage;
        Object localObject3;
        Object localObject4;
        int m;
        if (bool1)
        {
          if ((GroupSearchFragment.i((GroupSearchFragment)localObject1) == 21) && (SearchEntryConfigManager.a() == 0)) {}
          for (;;)
          {
            break;
            i = 0;
            for (;;)
            {
              j = this.a.r.size();
              localObject3 = null;
              if (i >= j) {
                break;
              }
              if ((this.a.r.get(i) instanceof GroupSearchModelFunction))
              {
                localObject2 = (GroupSearchModelFunction)this.a.r.get(i);
                localObject1 = (GroupSearchModeTitle)this.a.r.get(i - 1);
                break label349;
              }
              i += 1;
            }
            localObject1 = null;
            localObject2 = localObject1;
            i = 0;
            while (i < this.a.r.size())
            {
              if ((this.a.r.get(i) instanceof GroupSearchModelMiniProgram))
              {
                localObject3 = (GroupSearchModelMiniProgram)this.a.r.get(i);
                localObject4 = (GroupSearchModeTitle)this.a.r.get(i - 1);
                break label437;
              }
              i += 1;
            }
            localObject4 = null;
            this.a.r.remove(localObject1);
            this.a.r.remove(localObject2);
            this.a.r.remove(localObject3);
            this.a.r.remove(localObject4);
            j = 0;
            i = 0;
            k = -1;
            while (j < paramMessage.size())
            {
              SearchUtil.a(paramMessage.get(j), this.a.q, GroupSearchFragment.i(this.a));
              if ((paramMessage.get(j) instanceof GroupSearchModelMostUsed)) {
                k = j;
              }
              if ((paramMessage.get(j) instanceof GroupSearchModelLocalContact)) {
                i = j + 1;
              }
              if ((paramMessage.get(j) instanceof GroupSearchModelLocalTroop)) {
                i = j + 1;
              }
              if ((paramMessage.get(j) instanceof GroupSearchModelLocalGuild)) {
                i = j + 1;
              }
              j += 1;
            }
            j = i;
            if (!StudyModeManager.h())
            {
              this.a.J.a = this.a.q;
              this.a.J.m_(this.a.q);
              this.a.J.e(GroupSearchFragment.j(this.a));
              this.a.J.d(SearchUtil.a());
              if ((i == 0) && (k >= 0))
              {
                i = k + 1;
                localObject3 = this.a.r;
                j = i + 1;
                ((List)localObject3).add(i, this.a.J);
              }
              else
              {
                this.a.r.add(i, this.a.J);
                j = i + 1;
              }
            }
            SearchUtils.a("all_result", "exp_people_group", new String[] { this.a.q });
            i = 0;
            while (i < this.a.r.size())
            {
              if ((this.a.r.get(i) instanceof GroupSearchModelLocalGuild))
              {
                localObject3 = (GroupSearchModelLocalGuild)this.a.r.get(i);
                localObject4 = ((GroupSearchModelLocalGuild)localObject3).b();
                i = ((GroupSearchModelLocalGuild)localObject3).d();
                localObject3 = ((List)localObject4).iterator();
                m = 0;
                while (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (ISearchResultModel)((Iterator)localObject3).next();
                  if ((localObject4 instanceof ContactSearchModelGuild))
                  {
                    m += 1;
                    if (m > i) {
                      break;
                    }
                    SearchUtils.a("Sgrp", "search_result2", "exp", 0, 0, new String[] { String.valueOf(((ContactSearchModelGuild)localObject4).i()) });
                  }
                }
              }
              i += 1;
            }
            UniteSearchReportController.a(null, 0, GroupSearchFragment.i(this.a), "0X8009D3E", 0, 0, null, null);
            if ((localObject2 != null) && (((GroupSearchModelFunction)localObject2).b() != null) && (((GroupSearchModelFunction)localObject2).b().size() > 0))
            {
              localObject3 = new StringBuilder();
              i = 1;
              while (i < ((GroupSearchModelFunction)localObject2).b().size() - 1)
              {
                ((GroupBaseNetSearchModelItem)((GroupSearchModelFunction)localObject2).b().get(i)).L = (i - 1);
                i += 1;
              }
              m = Math.min(((GroupSearchModelFunction)localObject2).b().size(), ((GroupSearchModelFunction)localObject2).d());
              StringBuilder localStringBuilder;
              if (m > 0)
              {
                i = 0;
                int i1;
                for (;;)
                {
                  i1 = m - 1;
                  if (i >= i1) {
                    break;
                  }
                  localObject4 = (GroupBaseNetSearchModelItem)((GroupSearchModelFunction)localObject2).b().get(i);
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append(((GroupBaseNetSearchModelItem)localObject4).b);
                  localStringBuilder.append("::");
                  ((StringBuilder)localObject3).append(localStringBuilder.toString());
                  i += 1;
                }
                localObject4 = (GroupBaseNetSearchModelItem)((GroupSearchModelFunction)localObject2).b().get(i1);
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(((GroupBaseNetSearchModelItem)localObject4).b);
                localStringBuilder.append("");
                ((StringBuilder)localObject3).append(localStringBuilder.toString());
              }
              if (((GroupBaseNetSearchModelItem)((GroupSearchModelFunction)localObject2).b().get(0)).c.equals(this.a.q))
              {
                if (k < 0)
                {
                  this.a.r.add(0, localObject1);
                  this.a.r.add(1, localObject2);
                }
                else
                {
                  this.a.r.add(k + 1, localObject1);
                  this.a.r.add(k + 2, localObject2);
                }
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("");
                ((StringBuilder)localObject4).append(this.a.q);
                localObject4 = ((StringBuilder)localObject4).toString();
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("");
                localStringBuilder.append(((StringBuilder)localObject3).toString());
                SearchUtils.a("all_result", "exp_function", new String[] { localObject4, localStringBuilder.toString(), "", "1" });
                localObject2 = ((ISearchResultModel)((GroupSearchModelFunction)localObject2).b().get(0)).c();
                UniteSearchReportController.a(null, 0, GroupSearchFragment.i(this.a), "0X8009D34", 0, 0, (String)localObject2, null);
                this.a.r.size();
              }
              else
              {
                this.a.r.add(j, localObject1);
                this.a.r.add(j + 1, localObject2);
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("");
                ((StringBuilder)localObject4).append(this.a.q);
                localObject4 = ((StringBuilder)localObject4).toString();
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("");
                localStringBuilder.append(((StringBuilder)localObject3).toString());
                SearchUtils.a("all_result", "exp_function", new String[] { localObject4, localStringBuilder.toString(), "", "0" });
                localObject2 = ReportUtil.a(((GroupSearchModelFunction)localObject2).b(), ((GroupSearchModelFunction)localObject2).d());
                UniteSearchReportController.a(null, 0, GroupSearchFragment.i(this.a), "0X8009D48", 0, 0, (String)localObject2, null);
              }
              if ((localObject1 != null) && (((GroupSearchModeTitle)localObject1).f())) {
                UniteSearchReportController.a(null, 0, GroupSearchFragment.i(this.a), "0X8009D4A", 0, 0, null, null);
              }
            }
          }
          if (this.a.H == 6)
          {
            localObject1 = this.a;
            ((GroupSearchFragment)localObject1).I = 0;
            if (((GroupSearchFragment)localObject1).H == 0)
            {
              paramMessage = paramMessage.iterator();
              while (paramMessage.hasNext())
              {
                localObject1 = paramMessage.next();
                if (((localObject1 instanceof GroupSearchModelFavorite)) || ((localObject1 instanceof GroupSearchModelFileEntity)) || ((localObject1 instanceof GroupSearchModelLocalContact)) || ((localObject1 instanceof GroupSearchModelMultiChat)) || ((localObject1 instanceof GroupSearchModelLocalTroop)) || ((localObject1 instanceof GroupSearchModelMessage)) || ((localObject1 instanceof FTSGroupSearchModelMessage)) || (((localObject1 instanceof GroupBaseNetSearchModelItem)) && (((GroupBaseNetSearchModelItem)localObject1).j() == 268435456))) {
                  if ((localObject1 instanceof ISearchResultGroupModel))
                  {
                    localObject1 = (ISearchResultGroupModel)localObject1;
                    if ((localObject1 != null) && (((ISearchResultGroupModel)localObject1).b() != null)) {
                      i = ((ISearchResultGroupModel)localObject1).b().size();
                    } else {
                      i = 0;
                    }
                    localObject2 = this.a;
                    ((GroupSearchFragment)localObject2).I += Math.min(i, ((ISearchResultGroupModel)localObject1).d());
                  }
                  else
                  {
                    localObject1 = this.a;
                    ((GroupSearchFragment)localObject1).I += 1;
                  }
                }
              }
            }
            paramMessage = this.a;
            if (n == 4) {
              i = 1;
            } else {
              i = 2;
            }
            paramMessage.b = i;
          }
          boolean bool2;
          if ((this.a.getQBaseActivity() instanceof SearchInfoInterface)) {
            bool2 = ((SearchInfoInterface)this.a.getQBaseActivity()).k();
          } else {
            bool2 = false;
          }
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("onFinish(). matchCount=");
            paramMessage.append(this.a.I);
            paramMessage.append(" forceRequestStatus=");
            paramMessage.append(this.a.H);
            QLog.d("Q.uniteSearch.GroupSearchFragment", 2, paramMessage.toString());
          }
          if (!UniteSearchActivity.a(GroupSearchFragment.j(this.a), GroupSearchFragment.i(this.a)))
          {
            if (this.a.H == 0) {
              this.a.H = 4;
            }
          }
          else if (this.a.H == 0) {
            this.a.H = 4;
          }
          i = 4;
          if (!bool2)
          {
            paramMessage = this.a;
            if (n != 5) {
              i = 3;
            }
            paramMessage.b = i;
            this.a.q();
            i = 12;
          }
          else
          {
            i = 11;
          }
        }
        else
        {
          i = 10;
        }
        l = System.currentTimeMillis();
        if (l - this.a.f >= 50L)
        {
          this.a.Q.removeMessages(i);
          this.a.Q.sendEmptyMessage(i);
        }
        else
        {
          this.a.Q.removeMessages(i);
          this.a.Q.sendEmptyMessageDelayed(i, 50L - (l - this.a.f));
        }
        if (!bool1) {
          break;
        }
        if ((this.a.r != null) && (this.a.r.size() > 0))
        {
          paramMessage = this.a.r.iterator();
          j = 0;
          n = 0;
          for (;;)
          {
            i = n;
            if (!paramMessage.hasNext()) {
              break;
            }
            localObject1 = paramMessage.next();
            if ((!(localObject1 instanceof GroupSearchModelFavorite)) && (!(localObject1 instanceof GroupSearchModelFileEntity)))
            {
              if ((localObject1 instanceof ISearchResultGroupModel))
              {
                localObject2 = (ISearchResultGroupModel)localObject1;
                localObject3 = ((ISearchResultGroupModel)localObject2).b();
                k = j;
                i = n;
                if (localObject3 != null)
                {
                  m = n + Math.min(((List)localObject3).size(), ((ISearchResultGroupModel)localObject2).d());
                  i = j;
                  j = 0;
                  while (j < Math.min(((List)localObject3).size(), ((ISearchResultGroupModel)localObject2).d()))
                  {
                    localObject4 = new SearchUtils.ObjectItemInfo();
                    i += 1;
                    ((SearchUtils.ObjectItemInfo)localObject4).c = i;
                    ((SearchUtils.ObjectItemInfo)localObject4).b = SearchUtil.a((IModel)localObject2);
                    ((SearchUtils.ObjectItemInfo)localObject4).a = ((ISearchResultGroupModel)localObject2).c();
                    SearchUtils.l.put(((List)localObject3).get(j), localObject4);
                    j += 1;
                  }
                  k = i;
                  i = m;
                }
              }
              else
              {
                i = n + 1;
                k = j;
              }
            }
            else
            {
              i = n + 1;
              localObject2 = new SearchUtils.ObjectItemInfo();
              k = j + 1;
              ((SearchUtils.ObjectItemInfo)localObject2).c = k;
              localObject3 = (ISearchResultGroupModel)localObject1;
              ((SearchUtils.ObjectItemInfo)localObject2).b = SearchUtil.a((IModel)localObject3);
              ((SearchUtils.ObjectItemInfo)localObject2).a = ((ISearchResultGroupModel)localObject3).c();
              SearchUtils.l.put(localObject3, localObject2);
            }
            if ((localObject1 instanceof SearchResultModelForEntrance))
            {
              localObject2 = (SearchResultModelForEntrance)localObject1;
              m = k;
              if (((SearchResultModelForEntrance)localObject2).c == -1)
              {
                localObject3 = new SearchUtils.ObjectItemInfo();
                m = k + 1;
                ((SearchUtils.ObjectItemInfo)localObject3).c = m;
                ((SearchUtils.ObjectItemInfo)localObject3).b = SearchUtil.a((IModel)localObject2);
                ((SearchUtils.ObjectItemInfo)localObject3).a = ((SearchResultModelForEntrance)localObject2).a;
                SearchUtils.l.put(localObject2, localObject3);
              }
            }
            else
            {
              m = k;
            }
            if ((localObject1 instanceof ISearchResultGroupModel))
            {
              localObject2 = (ISearchResultGroupModel)localObject1;
              if (((ISearchResultGroupModel)localObject2).b() != null)
              {
                localObject2 = ((ISearchResultGroupModel)localObject2).b().iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (ISearchResultModel)((Iterator)localObject2).next();
                  if ((localObject3 instanceof ISearchResultPositionModel)) {
                    ((ISearchResultPositionModel)localObject3).e(GroupSearchFragment.j(this.a));
                  }
                }
                if ((localObject1 instanceof BaseSearchResultGroupModel)) {
                  ((BaseSearchResultGroupModel)localObject1).b(GroupSearchFragment.j(this.a));
                }
              }
            }
            if ((localObject1 != null) && ((localObject1 instanceof GroupSearchModelFunction)))
            {
              localObject2 = (GroupSearchModelFunction)localObject1;
              if ((((GroupSearchModelFunction)localObject2).b() != null) && (((GroupSearchModelFunction)localObject2).b().size() > 0))
              {
                j = 1;
                break label2760;
              }
            }
            j = 0;
            if (j != 0)
            {
              localObject2 = (ISearchResultModel)((GroupSearchModelFunction)localObject1).b().get(0);
              if ((localObject2 instanceof GroupBaseNetSearchModelItem)) {
                TextUtils.isEmpty(((GroupBaseNetSearchModelItem)localObject2).c);
              }
              if (j != 0) {
                ((GroupBaseNetSearchModelItem)localObject2).c.equals(this.a.q);
              }
            }
            if ((localObject1 != null) && ((localObject1 instanceof GroupSearchModelMiniProgram)))
            {
              localObject2 = (GroupSearchModelMiniProgram)localObject1;
              if ((((GroupSearchModelMiniProgram)localObject2).b() != null) && (((GroupSearchModelMiniProgram)localObject2).b().size() > 0))
              {
                k = 1;
                break label2876;
              }
            }
            k = 0;
            j = m;
            n = i;
            if (k != 0)
            {
              localObject1 = (ISearchResultModel)((GroupSearchModelMiniProgram)localObject1).b().get(0);
              if (((localObject1 instanceof MiniProgramSearchResultModel)) && (!TextUtils.isEmpty(((MiniProgramSearchResultModel)localObject1).m()))) {
                k = 1;
              } else {
                k = 0;
              }
              j = m;
              n = i;
              if (k != 0)
              {
                localObject1 = (MiniProgramSearchResultModel)localObject1;
                j = m;
                n = i;
                if (((MiniProgramSearchResultModel)localObject1).m().equals(this.a.q))
                {
                  UniteSearchReportController.a(GroupSearchFragment.k(this.a), GroupSearchFragment.j(this.a), GroupSearchFragment.i(this.a), "0X8009D32", 0, 0, ((MiniProgramSearchResultModel)localObject1).s(), null);
                  j = m;
                  n = i;
                }
              }
            }
          }
        }
        i = 0;
        paramMessage = new JSONObject();
        try
        {
          paramMessage.put("project", UniteSearchReportController.a());
          paramMessage.put("event_src", "client");
          paramMessage.put("nav_num", i);
        }
        catch (JSONException localJSONException)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("e = ");
          ((StringBuilder)localObject2).append(localJSONException);
          QLog.e("Q.uniteSearch.GroupSearchFragment", 2, ((StringBuilder)localObject2).toString());
        }
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        paramMessage = new ReportModelDC02528().module("all_result").action("exp_items").ver1(this.a.q).ver2(UniteSearchReportController.a(GroupSearchFragment.i(this.a))).ver7(paramMessage.toString());
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localQQAppInterface.getCurrentAccountUin());
        ((StringBuilder)localObject2).append(SearchUtils.j);
        UniteSearchReportController.a(localQQAppInterface, paramMessage.session_id(((StringBuilder)localObject2).toString()));
        SearchUtils.a("all_result", "exp_all_result", new String[] { this.a.q });
        return;
      case 13: 
        paramMessage = (List)paramMessage.obj;
        QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "handleMessage, log for search GET_LOCAL_CALLBACK_ON_UPDATE, onUpdate ");
        if (paramMessage != null)
        {
          if (paramMessage.size() == 0) {
            return;
          }
          if (System.currentTimeMillis() - this.a.L < 500L)
          {
            this.a.L = System.currentTimeMillis();
            return;
          }
          this.a.L = System.currentTimeMillis();
          if (this.a.r != null) {
            this.a.r.clear();
          } else {
            this.a.r = new ArrayList();
          }
          this.a.r.addAll(paramMessage);
          if ((this.a.K != null) && (!this.a.r.contains(this.a.K)))
          {
            this.a.r.add(this.a.K);
            this.a.K.a = this.a.q;
          }
          l = System.currentTimeMillis();
          if (l - this.a.f >= 50L)
          {
            this.a.Q.removeMessages(10);
            this.a.Q.sendEmptyMessage(10);
            return;
          }
          this.a.Q.removeMessages(10);
          this.a.Q.sendEmptyMessageDelayed(10, 50L - (l - this.a.f));
          return;
        }
        return;
      case 12: 
        QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search FINISH_NET_MSG");
        if ((this.a.r != null) && (!this.a.r.isEmpty()))
        {
          GroupSearchFragment.g(this.a);
          GroupSearchFragment.h(this.a).setVisibility(0);
          GroupSearchFragment.b(this.a, false);
        }
        this.a.c(false);
        paramMessage = this.a;
        GroupSearchFragment.a(paramMessage, paramMessage.r);
        if (this.a.r == null) {
          i = 0;
        } else {
          i = this.a.r.size();
        }
        k = i;
        if (i <= 2)
        {
          k = i;
          if (this.a.r != null)
          {
            j = 0;
            for (;;)
            {
              k = i;
              if (j >= this.a.r.size()) {
                break;
              }
              k = i;
              if ((this.a.r.get(j) instanceof SearchResultModelForEntrance)) {
                k = i - 1;
              }
              j += 1;
              i = k;
            }
          }
        }
        if (k > 0) {
          break;
        }
        paramMessage = new StringBuilder();
        paramMessage.append("");
        paramMessage.append(this.a.q);
        SearchUtils.a("all_result", "noresult_local", new String[] { paramMessage.toString() });
        return;
      case 11: 
        QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search FINISH_LOCAL_MSG");
        if ((this.a.r != null) && (!this.a.r.isEmpty()))
        {
          GroupSearchFragment.e(this.a);
          GroupSearchFragment.f(this.a).setVisibility(8);
          GroupSearchFragment.a(this.a, false);
        }
        this.a.c(false);
        paramMessage = this.a;
        GroupSearchFragment.a(paramMessage, paramMessage.r);
        return;
      case 10: 
        label2760:
        QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search GET_LOCAL_MSG");
        label2876:
        this.a.f = System.currentTimeMillis();
        paramMessage = this.a;
        GroupSearchFragment.a(paramMessage, paramMessage.r);
        if ((this.a.r == null) || (this.a.r.isEmpty())) {
          break;
        }
        GroupSearchFragment.c(this.a);
        GroupSearchFragment.d(this.a).setVisibility(0);
        return;
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("log for search START_SEARCH keyword = ");
        paramMessage.append(this.a.q);
        QLog.i("Q.uniteSearch.GroupSearchFragment", 2, paramMessage.toString());
      }
      if (!TextUtils.isEmpty(this.a.q))
      {
        GroupSearchFragment.a(this.a).setVisibility(8);
        GroupSearchFragment.b(this.a);
        paramMessage = this.a;
        paramMessage.a(paramMessage.q);
        if (QLog.isColorLevel()) {
          QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "GroupSearchFragment onViewCreated  startSearch");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.GroupSearchFragment.1
 * JD-Core Version:    0.7.0.1
 */