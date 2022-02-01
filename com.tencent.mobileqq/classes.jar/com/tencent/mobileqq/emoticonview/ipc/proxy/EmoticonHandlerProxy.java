package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class EmoticonHandlerProxy
  extends AbsHandlerProxy<EmoticonHandler>
{
  public static final String ACTION_EMOTICONHANDLER_FETCHEMOTICONRECOMMEND = "emoticonhandler_fetchemoticonrecommend";
  public static final String ACTION_EMOTICONHANDLER_FETCHIPSITEINFOEX = "emoticonhandler_fetchipsiteinfoex";
  public static final String ACTION_EMOTICONHANDLER_GETRECOMMENDEMOTICONINFO = "emoticonhandler_recommendEmoticonInfo";
  public static final String ACTION_EMOTICONHANDLER_GETSMALLYELLOWEMOITONREQUEST = "emoticonhandler_smallyellowemoitonrequest";
  public static final String ACTION_EMOTICONHANDLER_REPORTADDEMOTICONPKG = "emoticonhandler_reportaddemoticonpkg";
  public static final String ACTION_EMOTICONHANDLER_REPORTEMOTICONORDER = "emoticonhandler_reportemoticonorder";
  public static final String ACTION_EMOTICONHANDLER_SAVEKANDIANRECOMMENDEMOTICON = "emoticonhandler_savekandianrecommendemoticon";
  private static final String BUSINESS_TYPE = "businessType";
  private static final String EPID = "epId";
  private static final String IGNORE_RICHINFO = "ignoreRichInfo";
  private static final String PARAM_BUSINESSTYPE = "param_businesstype";
  private static final String PARAM_LOCALLIST = "param_list_locallist";
  private static final String PARAM_SHOULDREVERSE = "param_shouldreverse";
  private static final String PARSEINT = "parseInt";
  public static final String TAG = "EmoticonHandlerProxy";
  
  public EmoticonHandlerProxy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface, BusinessHandlerFactory.HANDLER_EMOSM);
  }
  
  public static EIPCResult checkMatch(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle, int paramInt)
  {
    if ("emoticonhandler_recommendEmoticonInfo".equals(paramString)) {
      return onGetRecommendEmoticonInfo((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emoticonhandler_smallyellowemoitonrequest".equals(paramString)) {
      return onGetCommonUsedSmallYellowEmoitonRequest((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emoticonhandler_reportaddemoticonpkg".equals(paramString)) {
      return onReportAddEmoticonPkg((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emoticonhandler_fetchemoticonrecommend".equals(paramString)) {
      return onFetchEmoticonRecommend((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emoticonhandler_fetchipsiteinfoex".equals(paramString)) {
      return onFetchEmoticonIPSiteInformationEx((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emoticonhandler_savekandianrecommendemoticon".equals(paramString)) {
      return onSaveKandianRecommendEmoticon((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emoticonhandler_reportemoticonorder".equals(paramString)) {
      return onReportEmoticonOrder((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    return null;
  }
  
  public static EIPCResult onFetchEmoticonIPSiteInformationEx(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((EmoticonHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).a(paramBundle.getString("epId"), paramBundle.getBoolean("ignoreRichInfo"));
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onFetchEmoticonRecommend(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((EmoticonHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).b(paramBundle.getInt("parseInt"));
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onGetCommonUsedSmallYellowEmoitonRequest(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((EmoticonHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).b();
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onGetRecommendEmoticonInfo(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((EmoticonHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).a();
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onReportAddEmoticonPkg(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((EmoticonHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).a(paramBundle.getString("epId"), paramBundle.getInt("businessType"));
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onReportEmoticonOrder(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((EmoticonHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).a(paramBundle.getStringArrayList("param_list_locallist"), paramBundle.getBoolean("param_shouldreverse"), paramBundle.getInt("param_businesstype"));
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onSaveKandianRecommendEmoticon(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((EmoticonHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).c();
    return EIPCResult.createSuccessResult(null);
  }
  
  public void fetchEmoticonIPSiteInformationEx(String paramString, boolean paramBoolean)
  {
    if (this.businessHandler != null) {
      ((EmoticonHandler)this.businessHandler).a(paramString, paramBoolean);
    }
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putString("epId", paramString);
      localBundle.putBoolean("ignoreRichInfo", paramBoolean);
      paramString = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emoticonhandler_fetchipsiteinfoex", localBundle);
      if ((paramString == null) || (!paramString.isSuccess())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonHandlerProxy", 4, "fetchEmoticonIPSiteInformationEx suc.");
    return;
    QLog.e("EmoticonHandlerProxy", 4, "fetchEmoticonIPSiteInformationEx fail.");
  }
  
  public void fetchEmoticonRecommend(int paramInt)
  {
    if (this.businessHandler != null) {
      ((EmoticonHandler)this.businessHandler).b(paramInt);
    }
    do
    {
      return;
      Object localObject = new Bundle();
      ((Bundle)localObject).putInt("parseInt", paramInt);
      localObject = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emoticonhandler_fetchemoticonrecommend", (Bundle)localObject);
      if ((localObject == null) || (!((EIPCResult)localObject).isSuccess())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonHandlerProxy", 4, "fetchEmoticonRecommend suc.");
    return;
    QLog.e("EmoticonHandlerProxy", 4, "fetchEmoticonRecommend fail.");
  }
  
  public void getCommonUsedSmallYellowEmoitonRequest()
  {
    if (this.businessHandler != null) {
      ((EmoticonHandler)this.businessHandler).b();
    }
    do
    {
      return;
      EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emoticonhandler_smallyellowemoitonrequest", null);
      if ((localEIPCResult == null) || (!localEIPCResult.isSuccess())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonHandlerProxy", 4, "getCommonUsedSmallYellowEmoitonRequest suc.");
    return;
    QLog.e("EmoticonHandlerProxy", 4, "getCommonUsedSmallYellowEmoitonRequest fail.");
  }
  
  public void getRecommendEmoticonInfo()
  {
    if (this.businessHandler != null) {
      ((EmoticonHandler)this.businessHandler).a();
    }
    do
    {
      return;
      EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emoticonhandler_recommendEmoticonInfo", null);
      if ((localEIPCResult == null) || (!localEIPCResult.isSuccess())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonHandlerProxy", 4, "getRecommendEmoticonInfo suc.");
    return;
    QLog.e("EmoticonHandlerProxy", 4, "getRecommendEmoticonInfo fail.");
  }
  
  public void reportAddEmoticonPkg(String paramString, int paramInt)
  {
    if (this.businessHandler != null) {
      ((EmoticonHandler)this.businessHandler).a(paramString, paramInt);
    }
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putString("epId", paramString);
      localBundle.putInt("businessType", paramInt);
      paramString = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emoticonhandler_reportaddemoticonpkg", localBundle);
      if ((paramString == null) || (!paramString.isSuccess())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonHandlerProxy", 4, "reportAddEmoticonPkg suc.");
    return;
    QLog.e("EmoticonHandlerProxy", 4, "reportAddEmoticonPkg fail.");
  }
  
  public void reportEmoticonOrder(List<String> paramList, boolean paramBoolean, int paramInt)
  {
    if (this.businessHandler != null) {
      ((EmoticonHandler)this.businessHandler).a(paramList, paramBoolean, paramInt);
    }
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putStringArrayList("param_list_locallist", new ArrayList(paramList));
      localBundle.putBoolean("param_shouldreverse", paramBoolean);
      localBundle.putInt("param_businesstype", paramInt);
      paramList = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emoticonhandler_reportemoticonorder", localBundle);
      if ((paramList == null) || (!paramList.isSuccess())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonHandlerProxy", 4, "reportEmoticonOrder suc.");
    return;
    QLog.e("EmoticonHandlerProxy", 4, "reportEmoticonOrder fail.");
  }
  
  public void saveKandianRecommendEmoticon()
  {
    if (this.businessHandler != null) {
      ((EmoticonHandler)this.businessHandler).c();
    }
    do
    {
      return;
      EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emoticonhandler_savekandianrecommendemoticon", null);
      if ((localEIPCResult == null) || (!localEIPCResult.isSuccess())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonHandlerProxy", 4, "saveKandianRecommendEmoticon suc.");
    return;
    QLog.e("EmoticonHandlerProxy", 4, "saveKandianRecommendEmoticon fail.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonHandlerProxy
 * JD-Core Version:    0.7.0.1
 */