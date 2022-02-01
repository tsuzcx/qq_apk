package com.tencent.mobileqq.config.business.tendoc;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TencentDocStructMsgGrayTipsConfigBean
{
  private int a = 0;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  
  public static TencentDocStructMsgGrayTipsConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0)) {
      paramArrayOfQConfItem = null;
    }
    TencentDocStructMsgGrayTipsConfigBean localTencentDocStructMsgGrayTipsConfigBean;
    for (;;)
    {
      return paramArrayOfQConfItem;
      localTencentDocStructMsgGrayTipsConfigBean = new TencentDocStructMsgGrayTipsConfigBean();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfQConfItem[0].a);
        if (localJSONObject.has("flag"))
        {
          localTencentDocStructMsgGrayTipsConfigBean.d = localJSONObject.getInt("flag");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips flag = " + localTencentDocStructMsgGrayTipsConfigBean.d);
          }
        }
        if (localJSONObject.has("showCount"))
        {
          localTencentDocStructMsgGrayTipsConfigBean.c = localJSONObject.getInt("showCount");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips showCount = " + localTencentDocStructMsgGrayTipsConfigBean.c);
          }
        }
        if (localJSONObject.has("groupFlag"))
        {
          localTencentDocStructMsgGrayTipsConfigBean.b = localJSONObject.getInt("groupFlag");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips groupFlag = " + localTencentDocStructMsgGrayTipsConfigBean.b);
          }
        }
        paramArrayOfQConfItem = localTencentDocStructMsgGrayTipsConfigBean;
        if (localJSONObject.has("groupShowCount"))
        {
          localTencentDocStructMsgGrayTipsConfigBean.a = localJSONObject.getInt("groupShowCount");
          paramArrayOfQConfItem = localTencentDocStructMsgGrayTipsConfigBean;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips groupShowCount = " + localTencentDocStructMsgGrayTipsConfigBean.a);
            return localTencentDocStructMsgGrayTipsConfigBean;
          }
        }
      }
      catch (Exception paramArrayOfQConfItem)
      {
        QLog.e("TencentDocStructMsgGrayTipsConfigBean", 1, "handleDocsStructMsgGrayTips e " + paramArrayOfQConfItem.toString());
      }
    }
    return localTencentDocStructMsgGrayTipsConfigBean;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocStructMsgGrayTipsConfigBean
 * JD-Core Version:    0.7.0.1
 */