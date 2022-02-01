package com.tencent.mobileqq.qqexpand.config.banner;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ExpandBannerConfBean
{
  private ArrayList<ExpandBannerConfBean.BannerItem> a = new ArrayList(3);
  
  public static ExpandBannerConfBean a(QConfItem paramQConfItem)
  {
    ExpandBannerConfBean localExpandBannerConfBean = new ExpandBannerConfBean();
    Object localObject;
    if (paramQConfItem != null) {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parse taskid->");
        ((StringBuilder)localObject).append(paramQConfItem.a);
        ((StringBuilder)localObject).append(" content->");
        ((StringBuilder)localObject).append(paramQConfItem.b);
        QLog.d("ExtendFriendBannerConfBean", 2, ((StringBuilder)localObject).toString());
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramQConfItem = new JSONObject(paramQConfItem.b).optJSONArray("appList");
        if (paramQConfItem != null)
        {
          localObject = new ArrayList(2);
          i = 0;
          int j = paramQConfItem.length();
          if (i < j)
          {
            JSONObject localJSONObject = paramQConfItem.optJSONObject(i);
            if (localJSONObject == null) {
              break label336;
            }
            ExpandBannerConfBean.BannerItem localBannerItem = new ExpandBannerConfBean.BannerItem();
            localBannerItem.id = localJSONObject.optLong("appID");
            localBannerItem.type = localJSONObject.optString("type");
            localBannerItem.bgBeginColor = localJSONObject.optString("bgBeginColor");
            localBannerItem.bgEndColor = localJSONObject.optString("bgEndColor");
            localBannerItem.bgHorizontalColor = localJSONObject.optString("bgHorizontalColor");
            localBannerItem.title = localJSONObject.optString("title");
            localBannerItem.subTitle = localJSONObject.optString("subTitle");
            localBannerItem.bgEndColor = localJSONObject.optString("bgEndColor");
            localBannerItem.iconUrl = localJSONObject.optString("icon");
            localBannerItem.schemeOrUrl = localJSONObject.optString("schemeOrUrl");
            localBannerItem.extra = localJSONObject.optJSONObject("extra");
            ((ArrayList)localObject).add(localBannerItem);
            break label336;
          }
          localExpandBannerConfBean.a((ArrayList)localObject);
          return localExpandBannerConfBean;
        }
      }
      catch (Exception paramQConfItem)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("parse error->");
          ((StringBuilder)localObject).append(paramQConfItem.toString());
          QLog.d("ExtendFriendBannerConfBean", 2, ((StringBuilder)localObject).toString());
        }
      }
      return localExpandBannerConfBean;
      label336:
      i += 1;
    }
  }
  
  private void a(ArrayList<ExpandBannerConfBean.BannerItem> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public ArrayList<ExpandBannerConfBean.BannerItem> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.config.banner.ExpandBannerConfBean
 * JD-Core Version:    0.7.0.1
 */