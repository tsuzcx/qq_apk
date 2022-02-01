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
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      TencentDocStructMsgGrayTipsConfigBean localTencentDocStructMsgGrayTipsConfigBean = new TencentDocStructMsgGrayTipsConfigBean();
      try
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].a);
        if (paramArrayOfQConfItem.has("flag"))
        {
          localTencentDocStructMsgGrayTipsConfigBean.d = paramArrayOfQConfItem.getInt("flag");
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("handleDocsStructMsgGrayTips flag = ");
            localStringBuilder.append(localTencentDocStructMsgGrayTipsConfigBean.d);
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, localStringBuilder.toString());
          }
        }
        if (paramArrayOfQConfItem.has("showCount"))
        {
          localTencentDocStructMsgGrayTipsConfigBean.c = paramArrayOfQConfItem.getInt("showCount");
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("handleDocsStructMsgGrayTips showCount = ");
            localStringBuilder.append(localTencentDocStructMsgGrayTipsConfigBean.c);
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, localStringBuilder.toString());
          }
        }
        if (paramArrayOfQConfItem.has("groupFlag"))
        {
          localTencentDocStructMsgGrayTipsConfigBean.b = paramArrayOfQConfItem.getInt("groupFlag");
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("handleDocsStructMsgGrayTips groupFlag = ");
            localStringBuilder.append(localTencentDocStructMsgGrayTipsConfigBean.b);
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, localStringBuilder.toString());
          }
        }
        if (paramArrayOfQConfItem.has("groupShowCount"))
        {
          localTencentDocStructMsgGrayTipsConfigBean.a = paramArrayOfQConfItem.getInt("groupShowCount");
          if (QLog.isColorLevel())
          {
            paramArrayOfQConfItem = new StringBuilder();
            paramArrayOfQConfItem.append("handleDocsStructMsgGrayTips groupShowCount = ");
            paramArrayOfQConfItem.append(localTencentDocStructMsgGrayTipsConfigBean.a);
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, paramArrayOfQConfItem.toString());
            return localTencentDocStructMsgGrayTipsConfigBean;
          }
        }
      }
      catch (Exception paramArrayOfQConfItem)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleDocsStructMsgGrayTips e ");
        localStringBuilder.append(paramArrayOfQConfItem.toString());
        QLog.e("TencentDocStructMsgGrayTipsConfigBean", 1, localStringBuilder.toString());
      }
      return localTencentDocStructMsgGrayTipsConfigBean;
    }
    return null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocStructMsgGrayTipsConfigBean
 * JD-Core Version:    0.7.0.1
 */