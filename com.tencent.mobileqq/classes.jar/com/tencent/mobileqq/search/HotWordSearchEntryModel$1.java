package com.tencent.mobileqq.search;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.widgets.HotWordTipsContainer.OnTipClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SearchWordHistoryManager;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchConfigUtils;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class HotWordSearchEntryModel$1
  implements HotWordTipsContainer.OnTipClickListener
{
  HotWordSearchEntryModel$1(HotWordSearchEntryModel paramHotWordSearchEntryModel) {}
  
  public void a(HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem)
  {
    int j = 21;
    Object localObject;
    HotWordSearchEntryDataModel.HotSearchItem localHotSearchItem;
    if (paramHotSearchItem != null)
    {
      localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localHotSearchItem = (HotWordSearchEntryDataModel.HotSearchItem)((Iterator)localObject).next();
      } while (!TextUtils.equals(paramHotSearchItem.title, localHotSearchItem.title));
    }
    for (;;)
    {
      if (localHotSearchItem == null) {
        return;
      }
      localObject = localHotSearchItem.jumpUrl;
      paramHotSearchItem = (HotWordSearchEntryDataModel.HotSearchItem)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        if (this.a.jdField_a_of_type_Int != 10) {
          break label596;
        }
        paramHotSearchItem = "kandian_hotword";
        if (localHotSearchItem.type == 7) {
          paramHotSearchItem = "kandian_recomword";
        }
        paramHotSearchItem = SearchConfigUtils.a(localHotSearchItem.recallWord, 5, paramHotSearchItem);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.HotWordSearchEntryModel", 2, "open Browser append suffix url = " + paramHotSearchItem);
        }
        HotWordSearchEntryModel.a(this.a, paramHotSearchItem, localHotSearchItem.recallWord);
        SearchUtils.a("hot_list", "clk_hot_list", new String[] { localHotSearchItem.title, String.valueOf(this.a.jdField_a_of_type_Int), String.valueOf(this.a.jdField_a_of_type_JavaUtilList.indexOf(localHotSearchItem) + 1) });
        paramHotSearchItem = new JSONObject();
        try
        {
          paramHotSearchItem.put("project", UniteSearchReportController.a());
          paramHotSearchItem.put("event_src", "client");
          paramHotSearchItem.put("experiment_id", UniteSearchReportController.b);
          localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          localUniteSearchHandler = new UniteSearchHandler((QQAppInterface)localObject);
          if (localHotSearchItem.type == 7)
          {
            localReportModelDC02528 = new ReportModelDC02528().module("recom_list").action("clk_recom_list");
            if (this.a.jdField_a_of_type_Int == 3)
            {
              i = 21;
              UniteSearchReportController.a(null, localReportModelDC02528.ver2(UniteSearchReportController.a(i)).ver4(localHotSearchItem.title).ver7(paramHotSearchItem.toString()).session_id(((QQAppInterface)localObject).getCurrentAccountUin() + this.a.jdField_a_of_type_Long));
              if (this.a.jdField_a_of_type_Int != 3) {
                break label664;
              }
              i = 21;
              localUniteSearchHandler.b((QQAppInterface)localObject, "clk_recom_list", "recom_list", UniteSearchReportController.a(i), localHotSearchItem.sAppend, localHotSearchItem.title, paramHotSearchItem.toString());
              if ((UniteSearchActivity.a != null) && (TextUtils.equals(UniteSearchActivity.a.title, localHotSearchItem.title)))
              {
                paramHotSearchItem = new ReportModelDC02528().module("default_word").action("clk_default_word");
                if (this.a.jdField_a_of_type_Int != 3) {
                  break label835;
                }
                i = 21;
                UniteSearchReportController.a(null, paramHotSearchItem.ver2(UniteSearchReportController.a(i)).ver4(localHotSearchItem.title).ver7(SearchEntryConfigManager.b));
                if (this.a.jdField_a_of_type_Int != 3) {
                  break label846;
                }
                i = j;
                localUniteSearchHandler.b((QQAppInterface)localObject, "clk_default_word", "default_word", UniteSearchReportController.a(i), localHotSearchItem.sAppend, localHotSearchItem.title, SearchEntryConfigManager.b);
              }
              UniteSearchReportController.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, SearchEntryFragment.a(this.a.jdField_a_of_type_Int), "0X8009D28", 0, 0, null, null);
              ((SearchWordHistoryManager)((QQAppInterface)ReadInJoyUtils.a()).getManager(QQManagerFactory.SEARCH_WORD_HISTORY_MANAGER)).a(localHotSearchItem.recallWord);
              return;
              label596:
              paramHotSearchItem = SearchConfigUtils.b(this.a.jdField_a_of_type_Int);
              paramHotSearchItem = SearchConfigUtils.a(localHotSearchItem.recallWord, 5, paramHotSearchItem);
            }
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            UniteSearchHandler localUniteSearchHandler;
            QLog.e("Q.uniteSearch.HotWordSearchEntryModel", 2, "e = " + localJSONException);
            continue;
            int i = this.a.jdField_a_of_type_Int;
            continue;
            label664:
            i = this.a.jdField_a_of_type_Int;
            continue;
            ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("hot_list").action("clk_hot_list");
            if (this.a.jdField_a_of_type_Int == 3)
            {
              i = 21;
              label708:
              UniteSearchReportController.a(null, localReportModelDC02528.ver2(UniteSearchReportController.a(i)).ver4(localHotSearchItem.title).ver7(paramHotSearchItem.toString()).session_id(localJSONException.getCurrentAccountUin() + this.a.jdField_a_of_type_Long));
              if (this.a.jdField_a_of_type_Int != 3) {
                break label824;
              }
            }
            label824:
            for (i = 21;; i = this.a.jdField_a_of_type_Int)
            {
              localUniteSearchHandler.b(localJSONException, "clk_hot_list", "hot_list", UniteSearchReportController.a(i), localHotSearchItem.sAppend, localHotSearchItem.title, paramHotSearchItem.toString());
              break;
              i = this.a.jdField_a_of_type_Int;
              break label708;
            }
            label835:
            i = this.a.jdField_a_of_type_Int;
            continue;
            label846:
            i = this.a.jdField_a_of_type_Int;
          }
        }
      }
      localHotSearchItem = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.HotWordSearchEntryModel.1
 * JD-Core Version:    0.7.0.1
 */