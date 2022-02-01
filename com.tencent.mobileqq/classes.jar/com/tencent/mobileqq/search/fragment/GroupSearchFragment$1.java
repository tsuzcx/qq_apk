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
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.api.SearchEntryConfigManager;
import com.tencent.mobileqq.search.base.api.SearchInfoInterface;
import com.tencent.mobileqq.search.base.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFavorite;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFileEntity;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFunction;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMessage;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMiniProgram;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMostUsed;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMultiChat;
import com.tencent.mobileqq.search.ftsmsg.FTSGroupSearchModelMessage;
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
        int m = paramMessage.arg1;
        boolean bool1;
        if ((m != 4) && (m != 5)) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        paramMessage = new StringBuilder();
        paramMessage.append("handleMessage log for search , GET_LOCAL_CALLBACK_ON_FINISH, onFinish  status = ");
        paramMessage.append(m);
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
        if ((System.currentTimeMillis() - this.a.jdField_b_of_type_Long < 500L) && (!bool1))
        {
          this.a.jdField_b_of_type_Long = System.currentTimeMillis();
          return;
        }
        this.a.jdField_b_of_type_Long = System.currentTimeMillis();
        localObject1 = this.a;
        ((GroupSearchFragment)localObject1).jdField_c_of_type_JavaUtilList = paramMessage;
        Object localObject3;
        Object localObject4;
        int n;
        if (bool1)
        {
          if ((GroupSearchFragment.a((GroupSearchFragment)localObject1) == 21) && (SearchEntryConfigManager.a() == 0)) {}
          for (;;)
          {
            break;
            i = 0;
            for (;;)
            {
              j = this.a.jdField_c_of_type_JavaUtilList.size();
              localObject3 = null;
              if (i >= j) {
                break;
              }
              if ((this.a.jdField_c_of_type_JavaUtilList.get(i) instanceof GroupSearchModelFunction))
              {
                localObject2 = (GroupSearchModelFunction)this.a.jdField_c_of_type_JavaUtilList.get(i);
                localObject1 = (GroupSearchModeTitle)this.a.jdField_c_of_type_JavaUtilList.get(i - 1);
                break label349;
              }
              i += 1;
            }
            localObject1 = null;
            localObject2 = localObject1;
            i = 0;
            while (i < this.a.jdField_c_of_type_JavaUtilList.size())
            {
              if ((this.a.jdField_c_of_type_JavaUtilList.get(i) instanceof GroupSearchModelMiniProgram))
              {
                localObject3 = (GroupSearchModelMiniProgram)this.a.jdField_c_of_type_JavaUtilList.get(i);
                localObject4 = (GroupSearchModeTitle)this.a.jdField_c_of_type_JavaUtilList.get(i - 1);
                break label437;
              }
              i += 1;
            }
            localObject4 = null;
            this.a.jdField_c_of_type_JavaUtilList.remove(localObject1);
            this.a.jdField_c_of_type_JavaUtilList.remove(localObject2);
            this.a.jdField_c_of_type_JavaUtilList.remove(localObject3);
            this.a.jdField_c_of_type_JavaUtilList.remove(localObject4);
            j = 0;
            i = 0;
            k = -1;
            while (j < paramMessage.size())
            {
              SearchUtil.a(paramMessage.get(j), this.a.jdField_c_of_type_JavaLangString, GroupSearchFragment.a(this.a));
              if ((paramMessage.get(j) instanceof GroupSearchModelMostUsed)) {
                k = j;
              }
              if ((paramMessage.get(j) instanceof GroupSearchModelLocalContact)) {
                i = j + 1;
              }
              if ((paramMessage.get(j) instanceof GroupSearchModelLocalTroop)) {
                i = j + 1;
              }
              j += 1;
            }
            j = i;
            if (!StudyModeManager.a())
            {
              this.a.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchResultModelForEntrance.jdField_a_of_type_JavaLangString = this.a.jdField_c_of_type_JavaLangString;
              if ((i == 0) && (k >= 0))
              {
                i = k + 1;
                localObject3 = this.a.jdField_c_of_type_JavaUtilList;
                j = i + 1;
                ((List)localObject3).add(i, this.a.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchResultModelForEntrance);
              }
              else
              {
                this.a.jdField_c_of_type_JavaUtilList.add(i, this.a.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchResultModelForEntrance);
                j = i + 1;
              }
            }
            SearchUtils.a("all_result", "exp_people_group", new String[] { this.a.jdField_c_of_type_JavaLangString });
            UniteSearchReportController.a(null, 0, GroupSearchFragment.a(this.a), "0X8009D3E", 0, 0, null, null);
            if ((localObject2 != null) && (((GroupSearchModelFunction)localObject2).a() != null) && (((GroupSearchModelFunction)localObject2).a().size() > 0))
            {
              localObject3 = new StringBuilder();
              i = 1;
              while (i < ((GroupSearchModelFunction)localObject2).a().size() - 1)
              {
                ((GroupBaseNetSearchModelItem)((GroupSearchModelFunction)localObject2).a().get(i)).j = (i - 1);
                i += 1;
              }
              n = Math.min(((GroupSearchModelFunction)localObject2).a().size(), ((GroupSearchModelFunction)localObject2).a());
              StringBuilder localStringBuilder;
              if (n > 0)
              {
                i = 0;
                int i1;
                for (;;)
                {
                  i1 = n - 1;
                  if (i >= i1) {
                    break;
                  }
                  localObject4 = (GroupBaseNetSearchModelItem)((GroupSearchModelFunction)localObject2).a().get(i);
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append(((GroupBaseNetSearchModelItem)localObject4).b);
                  localStringBuilder.append("::");
                  ((StringBuilder)localObject3).append(localStringBuilder.toString());
                  i += 1;
                }
                localObject4 = (GroupBaseNetSearchModelItem)((GroupSearchModelFunction)localObject2).a().get(i1);
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(((GroupBaseNetSearchModelItem)localObject4).b);
                localStringBuilder.append("");
                ((StringBuilder)localObject3).append(localStringBuilder.toString());
              }
              if (((GroupBaseNetSearchModelItem)((GroupSearchModelFunction)localObject2).a().get(0)).jdField_c_of_type_JavaLangString.equals(this.a.jdField_c_of_type_JavaLangString))
              {
                if (k < 0)
                {
                  this.a.jdField_c_of_type_JavaUtilList.add(0, localObject1);
                  this.a.jdField_c_of_type_JavaUtilList.add(1, localObject2);
                }
                else
                {
                  this.a.jdField_c_of_type_JavaUtilList.add(k + 1, localObject1);
                  this.a.jdField_c_of_type_JavaUtilList.add(k + 2, localObject2);
                }
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("");
                ((StringBuilder)localObject4).append(this.a.jdField_c_of_type_JavaLangString);
                localObject4 = ((StringBuilder)localObject4).toString();
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("");
                localStringBuilder.append(((StringBuilder)localObject3).toString());
                SearchUtils.a("all_result", "exp_function", new String[] { localObject4, localStringBuilder.toString(), "", "1" });
                localObject2 = ((ISearchResultModel)((GroupSearchModelFunction)localObject2).a().get(0)).a();
                UniteSearchReportController.a(null, 0, GroupSearchFragment.a(this.a), "0X8009D34", 0, 0, (String)localObject2, null);
                this.a.jdField_c_of_type_JavaUtilList.size();
              }
              else
              {
                this.a.jdField_c_of_type_JavaUtilList.add(j, localObject1);
                this.a.jdField_c_of_type_JavaUtilList.add(j + 1, localObject2);
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("");
                ((StringBuilder)localObject4).append(this.a.jdField_c_of_type_JavaLangString);
                localObject4 = ((StringBuilder)localObject4).toString();
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("");
                localStringBuilder.append(((StringBuilder)localObject3).toString());
                SearchUtils.a("all_result", "exp_function", new String[] { localObject4, localStringBuilder.toString(), "", "0" });
                localObject2 = ReportUtil.a(((GroupSearchModelFunction)localObject2).a(), ((GroupSearchModelFunction)localObject2).a());
                UniteSearchReportController.a(null, 0, GroupSearchFragment.a(this.a), "0X8009D48", 0, 0, (String)localObject2, null);
              }
              if ((localObject1 != null) && (((GroupSearchModeTitle)localObject1).a())) {
                UniteSearchReportController.a(null, 0, GroupSearchFragment.a(this.a), "0X8009D4A", 0, 0, null, null);
              }
            }
          }
          if (this.a.jdField_c_of_type_Int == 6)
          {
            localObject1 = this.a;
            ((GroupSearchFragment)localObject1).e = 0;
            if (((GroupSearchFragment)localObject1).jdField_c_of_type_Int == 0)
            {
              paramMessage = paramMessage.iterator();
              while (paramMessage.hasNext())
              {
                localObject1 = paramMessage.next();
                if (((localObject1 instanceof GroupSearchModelFavorite)) || ((localObject1 instanceof GroupSearchModelFileEntity)) || ((localObject1 instanceof GroupSearchModelLocalContact)) || ((localObject1 instanceof GroupSearchModelMultiChat)) || ((localObject1 instanceof GroupSearchModelLocalTroop)) || ((localObject1 instanceof GroupSearchModelMessage)) || ((localObject1 instanceof FTSGroupSearchModelMessage)) || (((localObject1 instanceof GroupBaseNetSearchModelItem)) && (((GroupBaseNetSearchModelItem)localObject1).d() == 268435456))) {
                  if ((localObject1 instanceof ISearchResultGroupModel))
                  {
                    localObject1 = (ISearchResultGroupModel)localObject1;
                    if ((localObject1 != null) && (((ISearchResultGroupModel)localObject1).a() != null)) {
                      i = ((ISearchResultGroupModel)localObject1).a().size();
                    } else {
                      i = 0;
                    }
                    localObject2 = this.a;
                    ((GroupSearchFragment)localObject2).e += Math.min(i, ((ISearchResultGroupModel)localObject1).a());
                  }
                  else
                  {
                    localObject1 = this.a;
                    ((GroupSearchFragment)localObject1).e += 1;
                  }
                }
              }
            }
            paramMessage = this.a;
            if (m == 4) {
              i = 1;
            } else {
              i = 2;
            }
            paramMessage.jdField_a_of_type_Int = i;
          }
          boolean bool2;
          if ((this.a.getQBaseActivity() instanceof SearchInfoInterface)) {
            bool2 = ((SearchInfoInterface)this.a.getQBaseActivity()).a();
          } else {
            bool2 = false;
          }
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("onFinish(). matchCount=");
            paramMessage.append(this.a.e);
            paramMessage.append(" forceRequestStatus=");
            paramMessage.append(this.a.jdField_c_of_type_Int);
            QLog.d("Q.uniteSearch.GroupSearchFragment", 2, paramMessage.toString());
          }
          if (!UniteSearchActivity.a(GroupSearchFragment.b(this.a), GroupSearchFragment.a(this.a)))
          {
            if (this.a.jdField_c_of_type_Int == 0) {
              this.a.jdField_c_of_type_Int = 4;
            }
          }
          else if (this.a.jdField_c_of_type_Int == 0) {
            this.a.jdField_c_of_type_Int = 4;
          }
          i = 4;
          if (!bool2)
          {
            paramMessage = this.a;
            if (m != 5) {
              i = 3;
            }
            paramMessage.jdField_a_of_type_Int = i;
            this.a.i();
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
        if (l - this.a.jdField_a_of_type_Long >= 50L)
        {
          this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(i);
          this.a.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(i);
        }
        else
        {
          this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(i);
          this.a.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(i, 50L - (l - this.a.jdField_a_of_type_Long));
        }
        if (!bool1) {
          break;
        }
        if ((this.a.jdField_c_of_type_JavaUtilList != null) && (this.a.jdField_c_of_type_JavaUtilList.size() > 0))
        {
          paramMessage = this.a.jdField_c_of_type_JavaUtilList.iterator();
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
                localObject3 = ((ISearchResultGroupModel)localObject2).a();
                k = j;
                i = n;
                if (localObject3 != null)
                {
                  m = n + Math.min(((List)localObject3).size(), ((ISearchResultGroupModel)localObject2).a());
                  i = j;
                  j = 0;
                  while (j < Math.min(((List)localObject3).size(), ((ISearchResultGroupModel)localObject2).a()))
                  {
                    localObject4 = new SearchUtils.ObjectItemInfo();
                    i += 1;
                    ((SearchUtils.ObjectItemInfo)localObject4).jdField_a_of_type_Int = i;
                    ((SearchUtils.ObjectItemInfo)localObject4).jdField_a_of_type_Long = SearchUtil.a((IModel)localObject2);
                    ((SearchUtils.ObjectItemInfo)localObject4).jdField_a_of_type_JavaLangString = ((ISearchResultGroupModel)localObject2).b();
                    SearchUtils.b.put(((List)localObject3).get(j), localObject4);
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
              ((SearchUtils.ObjectItemInfo)localObject2).jdField_a_of_type_Int = k;
              localObject3 = (ISearchResultGroupModel)localObject1;
              ((SearchUtils.ObjectItemInfo)localObject2).jdField_a_of_type_Long = SearchUtil.a((IModel)localObject3);
              ((SearchUtils.ObjectItemInfo)localObject2).jdField_a_of_type_JavaLangString = ((ISearchResultGroupModel)localObject3).b();
              SearchUtils.b.put(localObject3, localObject2);
            }
            if ((localObject1 instanceof SearchResultModelForEntrance))
            {
              localObject2 = (SearchResultModelForEntrance)localObject1;
              m = k;
              if (((SearchResultModelForEntrance)localObject2).jdField_a_of_type_Int == -1)
              {
                localObject3 = new SearchUtils.ObjectItemInfo();
                m = k + 1;
                ((SearchUtils.ObjectItemInfo)localObject3).jdField_a_of_type_Int = m;
                ((SearchUtils.ObjectItemInfo)localObject3).jdField_a_of_type_Long = SearchUtil.a((IModel)localObject2);
                ((SearchUtils.ObjectItemInfo)localObject3).jdField_a_of_type_JavaLangString = ((SearchResultModelForEntrance)localObject2).jdField_a_of_type_JavaLangString;
                SearchUtils.b.put(localObject2, localObject3);
              }
            }
            else
            {
              m = k;
            }
            if ((localObject1 instanceof ISearchResultGroupModel))
            {
              localObject2 = (ISearchResultGroupModel)localObject1;
              if (((ISearchResultGroupModel)localObject2).a() != null)
              {
                localObject2 = ((ISearchResultGroupModel)localObject2).a().iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (ISearchResultModel)((Iterator)localObject2).next();
                  if ((localObject3 instanceof ISearchResultPositionModel)) {
                    ((ISearchResultPositionModel)localObject3).c(GroupSearchFragment.b(this.a));
                  }
                }
              }
            }
            if ((localObject1 != null) && ((localObject1 instanceof GroupSearchModelFunction)))
            {
              localObject2 = (GroupSearchModelFunction)localObject1;
              if ((((GroupSearchModelFunction)localObject2).a() != null) && (((GroupSearchModelFunction)localObject2).a().size() > 0))
              {
                j = 1;
                break label2525;
              }
            }
            j = 0;
            if (j != 0)
            {
              localObject2 = (ISearchResultModel)((GroupSearchModelFunction)localObject1).a().get(0);
              if ((localObject2 instanceof GroupBaseNetSearchModelItem)) {
                TextUtils.isEmpty(((GroupBaseNetSearchModelItem)localObject2).jdField_c_of_type_JavaLangString);
              }
              if (j != 0) {
                ((GroupBaseNetSearchModelItem)localObject2).jdField_c_of_type_JavaLangString.equals(this.a.jdField_c_of_type_JavaLangString);
              }
            }
            if ((localObject1 != null) && ((localObject1 instanceof GroupSearchModelMiniProgram)))
            {
              localObject2 = (GroupSearchModelMiniProgram)localObject1;
              if ((((GroupSearchModelMiniProgram)localObject2).a() != null) && (((GroupSearchModelMiniProgram)localObject2).a().size() > 0))
              {
                k = 1;
                break label2641;
              }
            }
            k = 0;
            j = m;
            n = i;
            if (k != 0)
            {
              localObject1 = (ISearchResultModel)((GroupSearchModelMiniProgram)localObject1).a().get(0);
              if (((localObject1 instanceof MiniProgramSearchResultModel)) && (!TextUtils.isEmpty(((MiniProgramSearchResultModel)localObject1).c()))) {
                k = 1;
              } else {
                k = 0;
              }
              j = m;
              n = i;
              if (k != 0)
              {
                ((MiniProgramSearchResultModel)localObject1).c().equals(this.a.jdField_c_of_type_JavaLangString);
                j = m;
                n = i;
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
        paramMessage = new ReportModelDC02528().module("all_result").action("exp_items").ver1(this.a.jdField_c_of_type_JavaLangString).ver2(UniteSearchReportController.a(GroupSearchFragment.a(this.a))).ver7(paramMessage.toString());
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localQQAppInterface.getCurrentAccountUin());
        ((StringBuilder)localObject2).append(SearchUtils.d);
        UniteSearchReportController.a(localQQAppInterface, paramMessage.session_id(((StringBuilder)localObject2).toString()));
        SearchUtils.a("all_result", "exp_all_result", new String[] { this.a.jdField_c_of_type_JavaLangString });
        return;
      case 13: 
        paramMessage = (List)paramMessage.obj;
        QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "handleMessage, log for search GET_LOCAL_CALLBACK_ON_UPDATE, onUpdate ");
        if (paramMessage != null)
        {
          if (paramMessage.size() == 0) {
            return;
          }
          if (System.currentTimeMillis() - this.a.jdField_b_of_type_Long < 500L)
          {
            this.a.jdField_b_of_type_Long = System.currentTimeMillis();
            return;
          }
          this.a.jdField_b_of_type_Long = System.currentTimeMillis();
          if (this.a.jdField_c_of_type_JavaUtilList != null) {
            this.a.jdField_c_of_type_JavaUtilList.clear();
          } else {
            this.a.jdField_c_of_type_JavaUtilList = new ArrayList();
          }
          this.a.jdField_c_of_type_JavaUtilList.addAll(paramMessage);
          if ((this.a.jdField_b_of_type_ComTencentMobileqqSearchBaseModelSearchResultModelForEntrance != null) && (!this.a.jdField_c_of_type_JavaUtilList.contains(this.a.jdField_b_of_type_ComTencentMobileqqSearchBaseModelSearchResultModelForEntrance)))
          {
            this.a.jdField_c_of_type_JavaUtilList.add(this.a.jdField_b_of_type_ComTencentMobileqqSearchBaseModelSearchResultModelForEntrance);
            this.a.jdField_b_of_type_ComTencentMobileqqSearchBaseModelSearchResultModelForEntrance.jdField_a_of_type_JavaLangString = this.a.jdField_c_of_type_JavaLangString;
          }
          l = System.currentTimeMillis();
          if (l - this.a.jdField_a_of_type_Long >= 50L)
          {
            this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(10);
            this.a.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(10);
            return;
          }
          this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(10);
          this.a.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10, 50L - (l - this.a.jdField_a_of_type_Long));
          return;
        }
        return;
      case 12: 
        QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search FINISH_NET_MSG");
        if ((this.a.jdField_c_of_type_JavaUtilList != null) && (!this.a.jdField_c_of_type_JavaUtilList.isEmpty()))
        {
          GroupSearchFragment.d(this.a);
          GroupSearchFragment.d(this.a).setVisibility(0);
          GroupSearchFragment.b(this.a, false);
        }
        this.a.c(false);
        GroupSearchFragment.c(this.a).a(this.a.jdField_c_of_type_JavaUtilList);
        if (this.a.jdField_c_of_type_JavaUtilList == null) {
          i = 0;
        } else {
          i = this.a.jdField_c_of_type_JavaUtilList.size();
        }
        k = i;
        if (i <= 2)
        {
          k = i;
          if (this.a.jdField_c_of_type_JavaUtilList != null)
          {
            j = 0;
            for (;;)
            {
              k = i;
              if (j >= this.a.jdField_c_of_type_JavaUtilList.size()) {
                break;
              }
              k = i;
              if ((this.a.jdField_c_of_type_JavaUtilList.get(j) instanceof SearchResultModelForEntrance)) {
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
        paramMessage.append(this.a.jdField_c_of_type_JavaLangString);
        SearchUtils.a("all_result", "noresult_local", new String[] { paramMessage.toString() });
        return;
      case 11: 
        QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search FINISH_LOCAL_MSG");
        if ((this.a.jdField_c_of_type_JavaUtilList != null) && (!this.a.jdField_c_of_type_JavaUtilList.isEmpty()))
        {
          GroupSearchFragment.c(this.a);
          GroupSearchFragment.c(this.a).setVisibility(8);
          GroupSearchFragment.a(this.a, false);
        }
        this.a.c(false);
        GroupSearchFragment.b(this.a).a(this.a.jdField_c_of_type_JavaUtilList);
        return;
      case 10: 
        label2525:
        QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search GET_LOCAL_MSG");
        label2641:
        this.a.jdField_a_of_type_Long = System.currentTimeMillis();
        GroupSearchFragment.a(this.a).a(this.a.jdField_c_of_type_JavaUtilList);
        if ((this.a.jdField_c_of_type_JavaUtilList == null) || (this.a.jdField_c_of_type_JavaUtilList.isEmpty())) {
          break;
        }
        GroupSearchFragment.b(this.a);
        GroupSearchFragment.b(this.a).setVisibility(0);
        return;
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("log for search START_SEARCH keyword = ");
        paramMessage.append(this.a.jdField_c_of_type_JavaLangString);
        QLog.i("Q.uniteSearch.GroupSearchFragment", 2, paramMessage.toString());
      }
      if (!TextUtils.isEmpty(this.a.jdField_c_of_type_JavaLangString))
      {
        GroupSearchFragment.a(this.a).setVisibility(8);
        GroupSearchFragment.a(this.a);
        paramMessage = this.a;
        paramMessage.a(paramMessage.jdField_c_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "GroupSearchFragment onViewCreated  startSearch");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.GroupSearchFragment.1
 * JD-Core Version:    0.7.0.1
 */