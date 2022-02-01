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
      StringBuilder localStringBuilder = null;
      Object localObject2 = this.a.n.iterator();
      Object localObject1;
      do
      {
        localObject1 = localStringBuilder;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (HotWordSearchEntryDataModel.HotSearchItem)((Iterator)localObject2).next();
      } while (!TextUtils.equals(paramHotSearchItem.title, ((HotWordSearchEntryDataModel.HotSearchItem)localObject1).title));
      if (localObject1 == null) {
        return;
      }
      paramHotSearchItem = ((HotWordSearchEntryDataModel.HotSearchItem)localObject1).jumpUrl;
      if (TextUtils.isEmpty(paramHotSearchItem))
      {
        SearchUtils.a("后台没有配置链接，终端拼接跳转");
        if (this.a.a == 10)
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
          paramHotSearchItem = SearchConfigUtils.d(this.a.a);
          paramHotSearchItem = SearchConfigUtils.a(((HotWordSearchEntryDataModel.HotSearchItem)localObject1).recallWord, 5, paramHotSearchItem);
        }
      }
      else
      {
        SearchUtils.a("后台配置了链接，使用后台链接跳转");
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("open Browser append suffix url = ");
        localStringBuilder.append(paramHotSearchItem);
        QLog.d("Q.uniteSearch.HotWordSearchEntryModel", 2, localStringBuilder.toString());
      }
      HotWordSearchEntryModel.a(this.a, paramHotSearchItem, ((HotWordSearchEntryDataModel.HotSearchItem)localObject1).recallWord);
      SearchUtils.a("hot_list", "clk_hot_list", new String[] { ((HotWordSearchEntryDataModel.HotSearchItem)localObject1).title, String.valueOf(this.a.a), String.valueOf(this.a.n.indexOf(localObject1) + 1) });
      paramHotSearchItem = new JSONObject();
      try
      {
        paramHotSearchItem.put("project", UniteSearchReportController.a());
        paramHotSearchItem.put("event_src", "client");
        paramHotSearchItem.put("experiment_id", UniteSearchReportController.b);
      }
      catch (JSONException localJSONException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("e = ");
        ((StringBuilder)localObject2).append(localJSONException);
        QLog.e("Q.uniteSearch.HotWordSearchEntryModel", 2, ((StringBuilder)localObject2).toString());
      }
      HotWordSearchEntryModel.a(this.a, (HotWordSearchEntryDataModel.HotSearchItem)localObject1, paramHotSearchItem.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.HotWordSearchEntryModel.1
 * JD-Core Version:    0.7.0.1
 */