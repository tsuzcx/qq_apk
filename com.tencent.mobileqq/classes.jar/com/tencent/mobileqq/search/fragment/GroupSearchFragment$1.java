package com.tencent.mobileqq.search.fragment;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.search.GroupSearchModelFileEntity;
import com.tencent.mobileqq.search.SearchEntryConfigManager;
import com.tencent.mobileqq.search.SearchInfoInterface;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.SearchUtil.ObjectItemInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.ftsmsg.FTSGroupSearchModelMessage;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.GroupSearchModelFunction;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalTroop;
import com.tencent.mobileqq.search.model.GroupSearchModelMessage;
import com.tencent.mobileqq.search.model.GroupSearchModelMiniProgram;
import com.tencent.mobileqq.search.model.GroupSearchModelMostUsed;
import com.tencent.mobileqq.search.model.GroupSearchModelMultiChat;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.model.MiniProgramSearchResultModel;
import com.tencent.mobileqq.search.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.globalsearch.GroupSearchModelFavorite;
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
    switch (paramMessage.what)
    {
    }
    label1170:
    label2335:
    label3617:
    label3621:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search START_SEARCH keyword = " + this.a.jdField_c_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.a.jdField_c_of_type_JavaLangString))
      {
        this.a.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.a.b();
        this.a.a(this.a.jdField_c_of_type_JavaLangString);
        if (QLog.isColorLevel())
        {
          QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "GroupSearchFragment onViewCreated  startSearch");
          return;
          QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search GET_LOCAL_MSG");
          this.a.jdField_a_of_type_Long = System.currentTimeMillis();
          this.a.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(this.a.jdField_c_of_type_JavaUtilList);
          if ((this.a.jdField_c_of_type_JavaUtilList != null) && (!this.a.jdField_c_of_type_JavaUtilList.isEmpty()))
          {
            this.a.c();
            this.a.jdField_c_of_type_AndroidViewView.setVisibility(0);
            return;
            QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search FINISH_LOCAL_MSG");
            if ((this.a.jdField_c_of_type_JavaUtilList != null) && (!this.a.jdField_c_of_type_JavaUtilList.isEmpty()))
            {
              this.a.c();
              this.a.jdField_c_of_type_AndroidViewView.setVisibility(8);
              this.a.g_(false);
            }
            this.a.c(false);
            this.a.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(this.a.jdField_c_of_type_JavaUtilList);
            return;
            QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search FINISH_NET_MSG");
            if ((this.a.jdField_c_of_type_JavaUtilList != null) && (!this.a.jdField_c_of_type_JavaUtilList.isEmpty()))
            {
              this.a.c();
              this.a.jdField_c_of_type_AndroidViewView.setVisibility(0);
              this.a.g_(false);
            }
            this.a.c(false);
            this.a.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(this.a.jdField_c_of_type_JavaUtilList);
            if (this.a.jdField_c_of_type_JavaUtilList == null) {}
            int k;
            int j;
            for (int i = 0;; i = this.a.jdField_c_of_type_JavaUtilList.size())
            {
              k = i;
              if (i > 2) {
                break;
              }
              k = i;
              if (this.a.jdField_c_of_type_JavaUtilList == null) {
                break;
              }
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
            if (k <= 0)
            {
              SearchUtils.a("all_result", "noresult_local", new String[] { "" + this.a.jdField_c_of_type_JavaLangString });
              return;
              paramMessage = (List)paramMessage.obj;
              QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "handleMessage, log for search GET_LOCAL_CALLBACK_ON_UPDATE, onUpdate ");
              if ((paramMessage != null) && (paramMessage.size() != 0))
              {
                if (System.currentTimeMillis() - this.a.jdField_b_of_type_Long < 500L)
                {
                  this.a.jdField_b_of_type_Long = System.currentTimeMillis();
                  return;
                }
                this.a.jdField_b_of_type_Long = System.currentTimeMillis();
                if (this.a.jdField_c_of_type_JavaUtilList != null) {
                  this.a.jdField_c_of_type_JavaUtilList.clear();
                }
                long l;
                for (;;)
                {
                  this.a.jdField_c_of_type_JavaUtilList.addAll(paramMessage);
                  if ((this.a.jdField_b_of_type_ComTencentMobileqqSearchModelSearchResultModelForEntrance != null) && (!this.a.jdField_c_of_type_JavaUtilList.contains(this.a.jdField_b_of_type_ComTencentMobileqqSearchModelSearchResultModelForEntrance)))
                  {
                    this.a.jdField_c_of_type_JavaUtilList.add(this.a.jdField_b_of_type_ComTencentMobileqqSearchModelSearchResultModelForEntrance);
                    this.a.jdField_b_of_type_ComTencentMobileqqSearchModelSearchResultModelForEntrance.jdField_a_of_type_JavaLangString = this.a.jdField_c_of_type_JavaLangString;
                  }
                  l = System.currentTimeMillis();
                  if (l - this.a.jdField_a_of_type_Long < 50L) {
                    break;
                  }
                  this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(10);
                  this.a.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(10);
                  return;
                  this.a.jdField_c_of_type_JavaUtilList = new ArrayList();
                }
                this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(10);
                this.a.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10, 50L - (l - this.a.jdField_a_of_type_Long));
                return;
                Object localObject1 = (List)paramMessage.obj;
                int m = paramMessage.arg1;
                boolean bool1;
                if ((m == 4) || (m == 5))
                {
                  bool1 = true;
                  label876:
                  QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "handleMessage log for search , GET_LOCAL_CALLBACK_ON_FINISH, onFinish  status = " + m + " isFinish" + bool1);
                  if (localObject1 != null) {
                    break label3617;
                  }
                }
                label1095:
                label1901:
                label2556:
                Object localObject2;
                for (paramMessage = new ArrayList();; paramMessage = localObject2)
                {
                  if ((paramMessage.size() == 0) && (!bool1)) {
                    break label3621;
                  }
                  if ((System.currentTimeMillis() - this.a.jdField_b_of_type_Long < 500L) && (!bool1))
                  {
                    this.a.jdField_b_of_type_Long = System.currentTimeMillis();
                    return;
                    bool1 = false;
                    break label876;
                  }
                  this.a.jdField_b_of_type_Long = System.currentTimeMillis();
                  this.a.jdField_c_of_type_JavaUtilList = paramMessage;
                  Object localObject3;
                  Object localObject4;
                  Object localObject5;
                  if (bool1)
                  {
                    if ((GroupSearchFragment.a(this.a) != 21) || (SearchEntryConfigManager.a() != 0))
                    {
                      i = 0;
                      if (i >= this.a.jdField_c_of_type_JavaUtilList.size()) {
                        break label3602;
                      }
                      if ((this.a.jdField_c_of_type_JavaUtilList.get(i) instanceof GroupSearchModelFunction))
                      {
                        localObject3 = (GroupSearchModelFunction)this.a.jdField_c_of_type_JavaUtilList.get(i);
                        localObject1 = (GroupSearchModeTitle)this.a.jdField_c_of_type_JavaUtilList.get(i - 1);
                        i = 0;
                      }
                    }
                    for (;;)
                    {
                      if (i < this.a.jdField_c_of_type_JavaUtilList.size())
                      {
                        if ((this.a.jdField_c_of_type_JavaUtilList.get(i) instanceof GroupSearchModelMiniProgram))
                        {
                          localObject4 = (GroupSearchModelMiniProgram)this.a.jdField_c_of_type_JavaUtilList.get(i);
                          localObject5 = (GroupSearchModeTitle)this.a.jdField_c_of_type_JavaUtilList.get(i - 1);
                          this.a.jdField_c_of_type_JavaUtilList.remove(localObject1);
                          this.a.jdField_c_of_type_JavaUtilList.remove(localObject3);
                          this.a.jdField_c_of_type_JavaUtilList.remove(localObject4);
                          this.a.jdField_c_of_type_JavaUtilList.remove(localObject5);
                          i = 0;
                          k = 0;
                          j = -1;
                          while (k < paramMessage.size())
                          {
                            UniteSearchReportController.a(paramMessage.get(k), this.a.jdField_c_of_type_JavaLangString, GroupSearchFragment.a(this.a));
                            if (!(paramMessage.get(k) instanceof GroupSearchModelMostUsed)) {
                              break label3590;
                            }
                            j = k;
                            if ((paramMessage.get(k) instanceof GroupSearchModelLocalContact)) {
                              i = k + 1;
                            }
                            if ((paramMessage.get(k) instanceof GroupSearchModelLocalTroop)) {
                              i = k + 1;
                            }
                            k += 1;
                          }
                          i += 1;
                          break;
                        }
                        i += 1;
                        continue;
                        if (!StudyModeManager.a())
                        {
                          this.a.jdField_a_of_type_ComTencentMobileqqSearchModelSearchResultModelForEntrance.jdField_a_of_type_JavaLangString = this.a.jdField_c_of_type_JavaLangString;
                          if ((i == 0) && (j >= 0))
                          {
                            i = j + 1;
                            this.a.jdField_c_of_type_JavaUtilList.add(i, this.a.jdField_a_of_type_ComTencentMobileqqSearchModelSearchResultModelForEntrance);
                            i += 1;
                          }
                          for (;;)
                          {
                            SearchUtils.a("all_result", "exp_people_group", new String[] { this.a.jdField_c_of_type_JavaLangString });
                            UniteSearchReportController.a(null, 0, GroupSearchFragment.a(this.a), "0X8009D3E", 0, 0, null, null);
                            if ((localObject3 == null) || (((GroupSearchModelFunction)localObject3).a() == null) || (((GroupSearchModelFunction)localObject3).a().size() <= 0)) {
                              break label1933;
                            }
                            localObject4 = new StringBuilder();
                            k = 1;
                            while (k < ((GroupSearchModelFunction)localObject3).a().size() - 1)
                            {
                              ((GroupBaseNetSearchModelItem)((GroupSearchModelFunction)localObject3).a().get(k)).j = (k - 1);
                              k += 1;
                            }
                            this.a.jdField_c_of_type_JavaUtilList.add(i, this.a.jdField_a_of_type_ComTencentMobileqqSearchModelSearchResultModelForEntrance);
                            i += 1;
                          }
                          int n = Math.min(((GroupSearchModelFunction)localObject3).a().size(), ((GroupSearchModelFunction)localObject3).a());
                          if (n > 0)
                          {
                            k = 0;
                            while (k < n - 1)
                            {
                              localObject5 = (GroupBaseNetSearchModelItem)((GroupSearchModelFunction)localObject3).a().get(k);
                              ((StringBuilder)localObject4).append(((GroupBaseNetSearchModelItem)localObject5).b + "::");
                              k += 1;
                            }
                            localObject5 = (GroupBaseNetSearchModelItem)((GroupSearchModelFunction)localObject3).a().get(n - 1);
                            ((StringBuilder)localObject4).append(((GroupBaseNetSearchModelItem)localObject5).b + "");
                          }
                          if (((GroupBaseNetSearchModelItem)((GroupSearchModelFunction)localObject3).a().get(0)).jdField_c_of_type_JavaLangString.equals(this.a.jdField_c_of_type_JavaLangString)) {
                            if (j < 0)
                            {
                              this.a.jdField_c_of_type_JavaUtilList.add(0, localObject1);
                              this.a.jdField_c_of_type_JavaUtilList.add(1, localObject3);
                              SearchUtils.a("all_result", "exp_function", new String[] { "" + this.a.jdField_c_of_type_JavaLangString, "" + ((StringBuilder)localObject4).toString(), "", "1" });
                              localObject3 = ((ISearchResultModel)((GroupSearchModelFunction)localObject3).a().get(0)).b();
                              UniteSearchReportController.a(null, 0, GroupSearchFragment.a(this.a), "0X8009D34", 0, 0, (String)localObject3, null);
                              if (this.a.jdField_c_of_type_JavaUtilList.size() >= 2) {}
                              if ((localObject1 != null) && (((GroupSearchModeTitle)localObject1).a())) {
                                UniteSearchReportController.a(null, 0, GroupSearchFragment.a(this.a), "0X8009D4A", 0, 0, null, null);
                              }
                              if (this.a.jdField_c_of_type_Int != 6) {
                                break label2353;
                              }
                              this.a.e = 0;
                              if (this.a.jdField_c_of_type_Int != 0) {
                                break label2335;
                              }
                              paramMessage = paramMessage.iterator();
                            }
                          }
                          for (;;)
                          {
                            label1970:
                            if (!paramMessage.hasNext()) {
                              break label2335;
                            }
                            localObject1 = paramMessage.next();
                            if (((localObject1 instanceof GroupSearchModelFavorite)) || ((localObject1 instanceof GroupSearchModelFileEntity)) || ((localObject1 instanceof GroupSearchModelLocalContact)) || ((localObject1 instanceof GroupSearchModelMultiChat)) || ((localObject1 instanceof GroupSearchModelLocalTroop)) || ((localObject1 instanceof GroupSearchModelMessage)) || ((localObject1 instanceof FTSGroupSearchModelMessage)) || (((localObject1 instanceof GroupBaseNetSearchModelItem)) && (((GroupBaseNetSearchModelItem)localObject1).d() == 268435456)))
                            {
                              if ((localObject1 instanceof ISearchResultGroupModel))
                              {
                                localObject1 = (ISearchResultGroupModel)localObject1;
                                if ((localObject1 == null) || (((ISearchResultGroupModel)localObject1).a() == null)) {}
                                for (i = 0;; i = ((ISearchResultGroupModel)localObject1).a().size())
                                {
                                  localObject3 = this.a;
                                  j = ((GroupSearchFragment)localObject3).e;
                                  ((GroupSearchFragment)localObject3).e = (Math.min(i, ((ISearchResultGroupModel)localObject1).a()) + j);
                                  break label1970;
                                  this.a.jdField_c_of_type_JavaUtilList.add(j + 1, localObject1);
                                  this.a.jdField_c_of_type_JavaUtilList.add(j + 2, localObject3);
                                  break;
                                  this.a.jdField_c_of_type_JavaUtilList.add(i, localObject1);
                                  this.a.jdField_c_of_type_JavaUtilList.add(i + 1, localObject3);
                                  SearchUtils.a("all_result", "exp_function", new String[] { "" + this.a.jdField_c_of_type_JavaLangString, "" + ((StringBuilder)localObject4).toString(), "", "0" });
                                  UniteSearchReportController.a(null, 0, GroupSearchFragment.a(this.a), "0X8009D48", 0, 0, null, null);
                                  break label1901;
                                }
                              }
                              localObject1 = this.a;
                              ((GroupSearchFragment)localObject1).e += 1;
                            }
                          }
                          paramMessage = this.a;
                          if (m == 4)
                          {
                            i = 1;
                            label2348:
                            paramMessage.jdField_a_of_type_Int = i;
                            label2353:
                            boolean bool2 = false;
                            if ((this.a.getActivity() instanceof SearchInfoInterface)) {
                              bool2 = ((SearchInfoInterface)this.a.getActivity()).a();
                            }
                            if (QLog.isColorLevel()) {
                              QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "onFinish(). matchCount=" + this.a.e + " forceRequestStatus=" + this.a.jdField_c_of_type_Int);
                            }
                            if (UniteSearchActivity.a(GroupSearchFragment.b(this.a), GroupSearchFragment.a(this.a))) {
                              break label2894;
                            }
                            if (this.a.jdField_c_of_type_Int == 0) {
                              this.a.jdField_c_of_type_Int = 4;
                            }
                            label2478:
                            if (bool2) {
                              break label2920;
                            }
                            paramMessage = this.a;
                            if (m != 5) {
                              break label2915;
                            }
                            i = 4;
                            label2496:
                            paramMessage.jdField_a_of_type_Int = i;
                            this.a.g();
                            i = 12;
                          }
                        }
                      }
                    }
                  }
                  for (;;)
                  {
                    label2511:
                    l = System.currentTimeMillis();
                    if (l - this.a.jdField_a_of_type_Long >= 50L)
                    {
                      this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(i);
                      this.a.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(i);
                      if (!bool1) {
                        break label2964;
                      }
                      j = 0;
                      i = j;
                      if (this.a.jdField_c_of_type_JavaUtilList == null) {
                        break label3402;
                      }
                      i = j;
                      if (this.a.jdField_c_of_type_JavaUtilList.size() <= 0) {
                        break label3402;
                      }
                      paramMessage = this.a.jdField_c_of_type_JavaUtilList.iterator();
                      i = 0;
                      j = 0;
                      if (!paramMessage.hasNext()) {
                        break label3400;
                      }
                      localObject1 = paramMessage.next();
                      if ((!(localObject1 instanceof GroupSearchModelFavorite)) && (!(localObject1 instanceof GroupSearchModelFileEntity))) {
                        break label2966;
                      }
                      j += 1;
                      localObject3 = new SearchUtil.ObjectItemInfo();
                      k = i + 1;
                      ((SearchUtil.ObjectItemInfo)localObject3).jdField_a_of_type_Int = k;
                      ((SearchUtil.ObjectItemInfo)localObject3).jdField_a_of_type_Long = SearchUtil.a((ISearchResultGroupModel)localObject1);
                      ((SearchUtil.ObjectItemInfo)localObject3).jdField_a_of_type_JavaLangString = ((ISearchResultGroupModel)localObject1).b();
                      SearchUtil.b.put((ISearchResultGroupModel)localObject1, localObject3);
                      i = j;
                      j = k;
                    }
                    for (;;)
                    {
                      k = j;
                      if ((localObject1 instanceof SearchResultModelForEntrance))
                      {
                        k = j;
                        if (((SearchResultModelForEntrance)localObject1).jdField_a_of_type_Int == -1)
                        {
                          localObject3 = new SearchUtil.ObjectItemInfo();
                          k = j + 1;
                          ((SearchUtil.ObjectItemInfo)localObject3).jdField_a_of_type_Int = k;
                          ((SearchUtil.ObjectItemInfo)localObject3).jdField_a_of_type_Long = SearchUtil.a((SearchResultModelForEntrance)localObject1);
                          ((SearchUtil.ObjectItemInfo)localObject3).jdField_a_of_type_JavaLangString = ((SearchResultModelForEntrance)localObject1).jdField_a_of_type_JavaLangString;
                          SearchUtil.b.put((SearchResultModelForEntrance)localObject1, localObject3);
                        }
                      }
                      if ((!(localObject1 instanceof ISearchResultGroupModel)) || (((ISearchResultGroupModel)localObject1).a() == null)) {
                        break label3151;
                      }
                      localObject3 = ((ISearchResultGroupModel)localObject1).a().iterator();
                      while (((Iterator)localObject3).hasNext())
                      {
                        localObject4 = (ISearchResultModel)((Iterator)localObject3).next();
                        if ((localObject4 instanceof ISearchResultPositionModel)) {
                          ((ISearchResultPositionModel)localObject4).b(GroupSearchFragment.b(this.a));
                        }
                      }
                      i = 2;
                      break label2348;
                      label2894:
                      if (this.a.jdField_c_of_type_Int != 0) {
                        break label2478;
                      }
                      this.a.jdField_c_of_type_Int = 4;
                      break label2478;
                      label2915:
                      i = 3;
                      break label2496;
                      label2920:
                      i = 11;
                      break label2511;
                      this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(i);
                      this.a.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(i, 50L - (l - this.a.jdField_a_of_type_Long));
                      break label2556;
                      break;
                      if ((localObject1 instanceof ISearchResultGroupModel))
                      {
                        localObject3 = (ISearchResultGroupModel)localObject1;
                        localObject4 = ((ISearchResultGroupModel)localObject3).a();
                        k = i;
                        m = j;
                        if (localObject4 != null)
                        {
                          m = Math.min(((List)localObject4).size(), ((ISearchResultGroupModel)localObject3).a());
                          k = 0;
                          while (k < Math.min(((List)localObject4).size(), ((ISearchResultGroupModel)localObject3).a()))
                          {
                            localObject5 = new SearchUtil.ObjectItemInfo();
                            i += 1;
                            ((SearchUtil.ObjectItemInfo)localObject5).jdField_a_of_type_Int = i;
                            ((SearchUtil.ObjectItemInfo)localObject5).jdField_a_of_type_Long = SearchUtil.a((ISearchResultGroupModel)localObject1);
                            ((SearchUtil.ObjectItemInfo)localObject5).jdField_a_of_type_JavaLangString = ((ISearchResultGroupModel)localObject1).b();
                            SearchUtil.b.put(((List)localObject4).get(k), localObject5);
                            k += 1;
                          }
                          m = j + m;
                          k = i;
                        }
                        i = m;
                        j = k;
                      }
                      else
                      {
                        k = j + 1;
                        j = i;
                        i = k;
                      }
                    }
                    label3151:
                    if ((localObject1 != null) && ((localObject1 instanceof GroupSearchModelFunction)) && (((GroupSearchModelFunction)localObject1).a() != null) && (((GroupSearchModelFunction)localObject1).a().size() > 0))
                    {
                      j = 1;
                      label3193:
                      if (j != 0)
                      {
                        localObject3 = (ISearchResultModel)((GroupSearchModelFunction)localObject1).a().get(0);
                        if ((((localObject3 instanceof GroupBaseNetSearchModelItem)) && (!TextUtils.isEmpty(((GroupBaseNetSearchModelItem)localObject3).jdField_c_of_type_JavaLangString))) && ((j == 0) || (!((GroupBaseNetSearchModelItem)localObject3).jdField_c_of_type_JavaLangString.equals(this.a.jdField_c_of_type_JavaLangString)))) {}
                      }
                      if ((localObject1 == null) || (!(localObject1 instanceof GroupSearchModelMiniProgram)) || (((GroupSearchModelMiniProgram)localObject1).a() == null) || (((GroupSearchModelMiniProgram)localObject1).a().size() <= 0)) {
                        break label3390;
                      }
                      j = 1;
                      label3305:
                      if (j != 0)
                      {
                        localObject1 = (ISearchResultModel)((GroupSearchModelMiniProgram)localObject1).a().get(0);
                        if ((!(localObject1 instanceof MiniProgramSearchResultModel)) || (TextUtils.isEmpty(((MiniProgramSearchResultModel)localObject1).c()))) {
                          break label3395;
                        }
                      }
                    }
                    label3390:
                    label3395:
                    for (j = 1;; j = 0)
                    {
                      if ((j != 0) && (((MiniProgramSearchResultModel)localObject1).c().equals(this.a.jdField_c_of_type_JavaLangString))) {}
                      j = i;
                      i = k;
                      break;
                      j = 0;
                      break label3193;
                      j = 0;
                      break label3305;
                    }
                    label3400:
                    i = j;
                    label3402:
                    paramMessage = new JSONObject();
                    try
                    {
                      paramMessage.put("project", UniteSearchReportController.a());
                      paramMessage.put("event_src", "client");
                      paramMessage.put("nav_num", i);
                      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
                      UniteSearchReportController.a((QQAppInterface)localObject1, new ReportModelDC02528().module("all_result").action("exp_items").ver1(this.a.jdField_c_of_type_JavaLangString).ver2(UniteSearchReportController.a(GroupSearchFragment.a(this.a))).ver7(paramMessage.toString()).session_id(((QQAppInterface)localObject1).getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
                      SearchUtils.a("all_result", "exp_all_result", new String[] { this.a.jdField_c_of_type_JavaLangString });
                      return;
                    }
                    catch (JSONException localJSONException)
                    {
                      for (;;)
                      {
                        QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "e = " + localJSONException);
                      }
                    }
                    break label1410;
                    break label1290;
                    localObject5 = null;
                    localObject4 = null;
                    break label1170;
                    localObject3 = null;
                    localObject2 = null;
                    break label1095;
                    i = 10;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.GroupSearchFragment.1
 * JD-Core Version:    0.7.0.1
 */