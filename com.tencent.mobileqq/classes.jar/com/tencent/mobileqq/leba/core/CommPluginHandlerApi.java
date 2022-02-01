package com.tencent.mobileqq.leba.core;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppSetting;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class CommPluginHandlerApi
{
  public static final String a = CommPluginHandler.class.getName();
  
  public static void a(AppRuntime paramAppRuntime)
  {
    ((CommPluginHandler)((AppInterface)paramAppRuntime).getBusinessHandler(a)).b();
  }
  
  public static void a(AppRuntime paramAppRuntime, ArrayList<BusinessInfoCheckUpdate.AppSetting> paramArrayList)
  {
    ((CommPluginHandler)((AppInterface)paramAppRuntime).getBusinessHandler(a)).a(paramArrayList);
  }
  
  public static void a(AppRuntime paramAppRuntime, List<Integer> paramList, long paramLong, int paramInt)
  {
    ((CommPluginHandler)((AppInterface)paramAppRuntime).getBusinessHandler(a)).a(paramList, paramLong, paramInt);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    ((CommPluginHandler)((AppInterface)paramAppRuntime).getBusinessHandler(a)).a(paramBoolean);
  }
  
  public static void b(AppRuntime paramAppRuntime)
  {
    ((CommPluginHandler)((AppInterface)paramAppRuntime).getBusinessHandler(a)).c();
  }
  
  public static void c(AppRuntime paramAppRuntime)
  {
    ((CommPluginHandler)((AppInterface)paramAppRuntime).getBusinessHandler(a)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.CommPluginHandlerApi
 * JD-Core Version:    0.7.0.1
 */