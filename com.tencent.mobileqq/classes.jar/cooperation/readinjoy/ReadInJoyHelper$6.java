package cooperation.readinjoy;

import android.text.TextUtils;
import bkbq;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nvm;
import org.json.JSONArray;
import org.json.JSONObject;
import ors;

public final class ReadInJoyHelper$6
  implements Runnable
{
  public ReadInJoyHelper$6(BaseArticleInfo paramBaseArticleInfo) {}
  
  public void run()
  {
    boolean bool = ors.x(this.a);
    ArrayList localArrayList;
    try
    {
      Object localObject1 = bkbq.a("daily_cba_report_key");
      localArrayList = new ArrayList();
      if ((localObject1 != null) && (!TextUtils.isEmpty(localObject1.toString()))) {
        localObject1 = new JSONArray(localObject1.toString());
      } else {
        while (i < ((JSONArray)localObject1).length())
        {
          localArrayList.add(((JSONArray)localObject1).optJSONObject(i));
          i += 1;
          continue;
          localObject1 = new JSONArray();
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("ReadInJoyLog", 1, "saveDailyClickCards error,msg=" + localException.toString());
      return;
    }
    Object localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("click_time", System.currentTimeMillis());
    ((JSONObject)localObject2).put("rowkey", this.a.innerUniqueID);
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      ((JSONObject)localObject2).put("isVideo", i);
      ((JSONObject)localObject2).put("algoid", this.a.mAlgorithmID);
      localArrayList.add(localObject2);
      Collections.sort(localArrayList, new nvm("click_time"));
      int j = Aladdin.getConfig(227).getIntegerFromString("request_article_nums", 10);
      localObject2 = new JSONArray();
      i = 0;
      for (;;)
      {
        if ((i >= localArrayList.size()) || (i >= j))
        {
          bkbq.a("daily_cba_report_key", ((JSONArray)localObject2).toString());
          return;
        }
        ((JSONArray)localObject2).put(localArrayList.get(i));
        i += 1;
      }
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.readinjoy.ReadInJoyHelper.6
 * JD-Core Version:    0.7.0.1
 */