package com.tencent.mobileqq.now;

import android.content.Context;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import mqq.app.AppRuntime;

public class NowQQLiveHelper
{
  private static final String a = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/testEnv/";
  
  public static int a()
  {
    Object localObject = a();
    if (!(localObject instanceof QQAppInterface)) {
      return 0;
    }
    localObject = (QQAppInterface)localObject;
    if ((((QQAppInterface)localObject).getMessageFacade() == null) || (((QQAppInterface)localObject).getMessageFacade().a() == null)) {
      return 0;
    }
    return ((QQAppInterface)localObject).getMessageFacade().a().a(NowQQLiveConstant.a, 1008);
  }
  
  public static AppRuntime a()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    return localAppRuntime;
  }
  
  public static boolean a()
  {
    Object localObject = a();
    if (!(localObject instanceof QQAppInterface)) {
      return false;
    }
    localObject = (QQAppInterface)localObject;
    if ((((QQAppInterface)localObject).getMessageFacade() == null) || (((QQAppInterface)localObject).getMessageFacade().a() == null)) {
      return false;
    }
    ((QQAppInterface)localObject).getMessageFacade().a(NowQQLiveConstant.a, 1008, true, true);
    RecentUtil.b((QQAppInterface)localObject, NowQQLiveConstant.a, 1008);
    ServiceAccountFolderManager.a().a((QQAppInterface)localObject, NowQQLiveConstant.a);
    return true;
  }
  
  public static final boolean a(Context paramContext, String paramString, int paramInt)
  {
    NowQQLiveFragment.a(paramContext, paramString, paramInt);
    return true;
  }
  
  public static boolean b()
  {
    return new File(a, "testserver").exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.NowQQLiveHelper
 * JD-Core Version:    0.7.0.1
 */