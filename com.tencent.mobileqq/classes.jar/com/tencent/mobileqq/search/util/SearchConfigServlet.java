package com.tencent.mobileqq.search.util;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.search.base.api.SearchEntryConfigManager;
import com.tencent.qphone.base.util.QLog;

public class SearchConfigServlet
{
  public static void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    SearchEntryConfigManager.b = paramQQAppInterface.getCurrentAccountUin();
    int i = paramConfig.version.get();
    int j = SearchEntryConfigManager.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleSearchNetEntryConfig, version: ");
    localStringBuilder.append(i);
    localStringBuilder.append(" localVersion: ");
    localStringBuilder.append(j);
    QLog.i("search_manager_configSearchConfigServlet", 1, localStringBuilder.toString());
    if (i == j) {
      return;
    }
    SearchEntryConfigManager.a(paramQQAppInterface.getApp(), i, paramQQAppInterface.getCurrentAccountUin());
    SearchEntryConfigManager.a(paramQQAppInterface.getApp(), paramConfig, paramQQAppInterface.getCurrentUin());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ConfigurationService.ConfigSeq paramConfigSeq)
  {
    int i = SearchEntryConfigManager.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    paramConfigSeq.version.set(i);
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("onGetSearchEntryConfig v=");
    paramQQAppInterface.append(i);
    QLog.i("search_manager_configSearchConfigServlet", 1, paramQQAppInterface.toString());
  }
  
  public static void a(ConfigurationService.ConfigSeq paramConfigSeq)
  {
    int i = SearchConfigUtils.b();
    paramConfigSeq.version.set(i);
    paramConfigSeq = new StringBuilder();
    paramConfigSeq.append("onGetSearchUrlSearchConfig v=");
    paramConfigSeq.append(i);
    QLog.i("search_manager_configSearchConfigServlet", 1, paramConfigSeq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.SearchConfigServlet
 * JD-Core Version:    0.7.0.1
 */