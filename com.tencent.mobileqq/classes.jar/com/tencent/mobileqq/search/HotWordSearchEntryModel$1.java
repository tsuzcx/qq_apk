package com.tencent.mobileqq.search;

import android.text.TextUtils;
import com.tencent.biz.widgets.HotWordTipsContainer.OnTipClickListener;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
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
    if (paramHotSearchItem != null)
    {
      Object localObject2 = null;
      Object localObject3 = this.a.jdField_a_of_type_JavaUtilList.iterator();
      Object localObject1;
      do
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (HotWordSearchEntryDataModel.HotSearchItem)((Iterator)localObject3).next();
      } while (!TextUtils.equals(paramHotSearchItem.title, ((HotWordSearchEntryDataModel.HotSearchItem)localObject1).title));
      if (localObject1 == null) {
        return;
      }
      localObject2 = ((HotWordSearchEntryDataModel.HotSearchItem)localObject1).jumpUrl;
      paramHotSearchItem = (HotWordSearchEntryDataModel.HotSearchItem)localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        if (this.a.jdField_a_of_type_Int == 10)
        {
          if (((HotWordSearchEntryDataModel.HotSearchItem)localObject1).type == 7) {
            paramHotSearchItem = "kandian_recomword";
          } else {
            paramHotSearchItem = "kandian_hotword";
          }
          paramHotSearchItem = SearchConfigUtils.a(((HotWordSearchEntryDataModel.HotSearchItem)localObject1).recallWord, 5, paramHotSearchItem);
        }
        else
        {
          paramHotSearchItem = SearchConfigUtils.b(this.a.jdField_a_of_type_Int);
          paramHotSearchItem = SearchConfigUtils.a(((HotWordSearchEntryDataModel.HotSearchItem)localObject1).recallWord, 5, paramHotSearchItem);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("open Browser append suffix url = ");
        ((StringBuilder)localObject2).append(paramHotSearchItem);
        QLog.d("Q.uniteSearch.HotWordSearchEntryModel", 2, ((StringBuilder)localObject2).toString());
      }
      HotWordSearchEntryModel.a(this.a, paramHotSearchItem, ((HotWordSearchEntryDataModel.HotSearchItem)localObject1).recallWord);
      SearchUtils.a("hot_list", "clk_hot_list", new String[] { ((HotWordSearchEntryDataModel.HotSearchItem)localObject1).title, String.valueOf(this.a.jdField_a_of_type_Int), String.valueOf(this.a.jdField_a_of_type_JavaUtilList.indexOf(localObject1) + 1) });
      paramHotSearchItem = new JSONObject();
      try
      {
        paramHotSearchItem.put("project", UniteSearchReportController.a());
        paramHotSearchItem.put("event_src", "client");
        paramHotSearchItem.put("experiment_id", UniteSearchReportController.b);
      }
      catch (JSONException localJSONException)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("e = ");
        ((StringBuilder)localObject3).append(localJSONException);
        QLog.e("Q.uniteSearch.HotWordSearchEntryModel", 2, ((StringBuilder)localObject3).toString());
      }
      HotWordSearchEntryModel.a(this.a, (HotWordSearchEntryDataModel.HotSearchItem)localObject1, paramHotSearchItem.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.HotWordSearchEntryModel.1
 * JD-Core Version:    0.7.0.1
 */