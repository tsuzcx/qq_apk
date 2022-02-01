package com.tencent.mobileqq.vas.qqvaluecard;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.qqvaluecard.bean.QQValueInfoItem;
import com.tencent.mobileqq.vas.qqvaluecard.view.QQValuePagView;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.updatesystem.business.QQValueViewBusiness;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class QQValueInfoManage
{
  private static final QQValueInfoManage a = new QQValueInfoManage();
  private static final Map<String, QQValueInfoItem> b = new HashMap();
  private static final Map<String, QQValuePagView> c = new HashMap();
  
  public static QQValueInfoManage a()
  {
    return a;
  }
  
  public void a(String paramString)
  {
    c.remove(paramString);
  }
  
  public void a(String paramString, QQValuePagView paramQQValuePagView)
  {
    c.put(paramString, paramQQValuePagView);
  }
  
  public void a(@NonNull String paramString, Object paramObject)
  {
    paramObject = QQValueInfoItem.a(paramObject);
    if (paramObject == null) {
      return;
    }
    if (!paramObject.a(c(paramString)))
    {
      b.put(paramString, paramObject);
      paramObject.a(paramString);
    }
  }
  
  public void b(String paramString)
  {
    Iterator localIterator = c.values().iterator();
    while (localIterator.hasNext())
    {
      QQValuePagView localQQValuePagView = (QQValuePagView)localIterator.next();
      if (localQQValuePagView.isFocused()) {
        localQQValuePagView.a(paramString, ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null));
      }
    }
  }
  
  public void b(String paramString, Object paramObject)
  {
    a().a(paramString, paramObject);
    b(paramString);
  }
  
  public QQValueInfoItem c(@NonNull String paramString)
  {
    if (paramString == null) {
      return null;
    }
    QQValueInfoItem localQQValueInfoItem = (QQValueInfoItem)b.get(paramString);
    if (localQQValueInfoItem != null) {
      return localQQValueInfoItem;
    }
    localQQValueInfoItem = QQValueInfoItem.b(paramString);
    if (localQQValueInfoItem != null) {
      b.put(paramString, localQQValueInfoItem);
    }
    return localQQValueInfoItem;
  }
  
  public String d(String paramString)
  {
    paramString = a().c(paramString);
    if ((paramString != null) && (!TextUtils.isEmpty(paramString.d))) {
      return paramString.d;
    }
    return "";
  }
  
  public void e(String paramString)
  {
    QQValueViewBusiness localQQValueViewBusiness = (QQValueViewBusiness)QQVasUpdateBusinessUtil.a(QQValueViewBusiness.class);
    if (localQQValueViewBusiness != null)
    {
      localQQValueViewBusiness.addUpdateListener(new QQValueInfoManage.1(this, paramString));
      paramString = d(paramString);
      if (!TextUtils.isEmpty(paramString)) {
        localQQValueViewBusiness.startDownload(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qqvaluecard.QQValueInfoManage
 * JD-Core Version:    0.7.0.1
 */