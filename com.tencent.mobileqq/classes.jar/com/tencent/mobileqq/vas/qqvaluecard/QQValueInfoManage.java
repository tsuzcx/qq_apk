package com.tencent.mobileqq.vas.qqvaluecard;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.qqvaluecard.bean.QQValueInfoItem;
import com.tencent.mobileqq.vas.qqvaluecard.view.QQValuePagView;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.updatesystem.business.QQValueViewBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class QQValueInfoManage
{
  private static final QQValueInfoManage jdField_a_of_type_ComTencentMobileqqVasQqvaluecardQQValueInfoManage = new QQValueInfoManage();
  private static final Map<String, QQValueInfoItem> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static final Map<String, QQValuePagView> b = new HashMap();
  
  public static QQValueInfoManage a()
  {
    return jdField_a_of_type_ComTencentMobileqqVasQqvaluecardQQValueInfoManage;
  }
  
  public QQValueInfoItem a(@NonNull String paramString)
  {
    if (paramString == null) {
      return null;
    }
    QQValueInfoItem localQQValueInfoItem = (QQValueInfoItem)jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localQQValueInfoItem != null) {
      return localQQValueInfoItem;
    }
    localQQValueInfoItem = QQValueInfoItem.a(paramString);
    if (localQQValueInfoItem != null) {
      jdField_a_of_type_JavaUtilMap.put(paramString, localQQValueInfoItem);
    }
    return localQQValueInfoItem;
  }
  
  public String a(String paramString)
  {
    paramString = a().a(paramString);
    if ((paramString != null) && (!TextUtils.isEmpty(paramString.a))) {
      return paramString.a;
    }
    return "";
  }
  
  public void a(String paramString)
  {
    b.remove(paramString);
  }
  
  public void a(String paramString, QQValuePagView paramQQValuePagView)
  {
    b.put(paramString, paramQQValuePagView);
  }
  
  public void a(@NonNull String paramString, Object paramObject)
  {
    paramObject = QQValueInfoItem.a(paramObject);
    if (paramObject == null) {
      return;
    }
    if (!paramObject.a(a(paramString)))
    {
      jdField_a_of_type_JavaUtilMap.put(paramString, paramObject);
      paramObject.a(paramString);
    }
  }
  
  public void b(String paramString)
  {
    Iterator localIterator = b.values().iterator();
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
  
  public void c(String paramString)
  {
    QQValueViewBusiness localQQValueViewBusiness = (QQValueViewBusiness)QQVasUpdateBusiness.a(QQValueViewBusiness.class);
    if (localQQValueViewBusiness != null)
    {
      localQQValueViewBusiness.addUpdateListener(new QQValueInfoManage.1(this, paramString));
      paramString = a(paramString);
      if (!TextUtils.isEmpty(paramString)) {
        localQQValueViewBusiness.startDownload(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qqvaluecard.QQValueInfoManage
 * JD-Core Version:    0.7.0.1
 */