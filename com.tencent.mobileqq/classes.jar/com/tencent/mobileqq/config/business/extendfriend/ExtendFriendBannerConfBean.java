package com.tencent.mobileqq.config.business.extendfriend;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ExtendFriendBannerConfBean
{
  private ArrayList<ExtendFriendBannerConfBean.BannerItem> a = new ArrayList(3);
  
  public static ExtendFriendBannerConfBean a(QConfItem paramQConfItem)
  {
    ExtendFriendBannerConfBean localExtendFriendBannerConfBean = new ExtendFriendBannerConfBean();
    if (paramQConfItem != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBannerConfBean", 2, "parse taskid->" + paramQConfItem.jdField_a_of_type_Int + " content->" + paramQConfItem.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramQConfItem = new JSONObject(paramQConfItem.jdField_a_of_type_JavaLangString).optJSONArray("appList");
        if (paramQConfItem != null)
        {
          ArrayList localArrayList = new ArrayList(2);
          i = 0;
          int j = paramQConfItem.length();
          if (i < j)
          {
            JSONObject localJSONObject = paramQConfItem.optJSONObject(i);
            if (localJSONObject == null) {
              break label310;
            }
            ExtendFriendBannerConfBean.BannerItem localBannerItem = new ExtendFriendBannerConfBean.BannerItem();
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
            localArrayList.add(localBannerItem);
            break label310;
          }
          localExtendFriendBannerConfBean.a(localArrayList);
        }
      }
      catch (Exception paramQConfItem)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ExtendFriendBannerConfBean", 2, "parse error->" + paramQConfItem.toString());
        return localExtendFriendBannerConfBean;
      }
      return localExtendFriendBannerConfBean;
      label310:
      i += 1;
    }
  }
  
  private void a(ArrayList<ExtendFriendBannerConfBean.BannerItem> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public ArrayList<ExtendFriendBannerConfBean.BannerItem> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.extendfriend.ExtendFriendBannerConfBean
 * JD-Core Version:    0.7.0.1
 */