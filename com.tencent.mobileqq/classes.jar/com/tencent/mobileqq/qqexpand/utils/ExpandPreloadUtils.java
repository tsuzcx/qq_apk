package com.tencent.mobileqq.qqexpand.utils;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.qflutter.ExpandModuleKey;
import com.tencent.mobileqq.config.business.qflutter.PreloadEngineOption;
import com.tencent.mobileqq.config.business.qflutter.QFlutterResConfigProcessor;
import com.tencent.mobileqq.config.business.qflutter.QFlutterResConfigProcessor.OptionList;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.qqexpand.manager.ExpandManager;
import com.tencent.qphone.base.util.QLog;

public class ExpandPreloadUtils
{
  private static boolean a(QQAppInterface paramQQAppInterface)
  {
    return MatchChatMsgUtil.b(paramQQAppInterface) > 0;
  }
  
  public static boolean a(ExpandModuleKey paramExpandModuleKey)
  {
    paramExpandModuleKey = QFlutterResConfigProcessor.a(paramExpandModuleKey);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("shouldPreload: ");
    ((StringBuilder)localObject).append(paramExpandModuleKey);
    QLog.d("ExpandPreloadUtils", 1, ((StringBuilder)localObject).toString());
    if (paramExpandModuleKey.a(PreloadEngineOption.ALWAYS_PRELOAD)) {
      return true;
    }
    localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
    if (!(localObject instanceof QQAppInterface)) {
      return false;
    }
    localObject = (QQAppInterface)localObject;
    if ((paramExpandModuleKey.a(PreloadEngineOption.RED_POINT_PRELOAD)) && (a((QQAppInterface)localObject))) {
      return true;
    }
    return (paramExpandModuleKey.a(PreloadEngineOption.ACTIVE_USER_PRELOAD)) && (b((QQAppInterface)localObject));
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface)
  {
    return ((ExpandManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).ad();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.ExpandPreloadUtils
 * JD-Core Version:    0.7.0.1
 */