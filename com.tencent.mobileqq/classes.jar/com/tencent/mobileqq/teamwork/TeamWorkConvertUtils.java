package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.TencentDocsPushBean;
import com.tencent.mobileqq.config.business.TencentDocsPushItemBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocUrl2DocConfigProcessor;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class TeamWorkConvertUtils
{
  public static QQProgressDialog a(AppInterface paramAppInterface, Context paramContext, String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    ITeamWorkFileImportHandler localITeamWorkFileImportHandler = (ITeamWorkFileImportHandler)paramAppInterface.getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
    if ((paramContext != null) && (localITeamWorkFileImportHandler != null) && (paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1))
    {
      paramTeamWorkFileImportInfo.g = 6;
      return a(paramAppInterface, paramTeamWorkFileImportInfo, paramContext, paramString);
    }
    return null;
  }
  
  public static QQProgressDialog a(AppInterface paramAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, Context paramContext, String paramString)
  {
    paramAppInterface = (ITeamWorkFileImportHandler)paramAppInterface.getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
    if ((paramAppInterface != null) && (paramTeamWorkFileImportInfo != null))
    {
      if (!a(paramTeamWorkFileImportInfo)) {
        return null;
      }
      paramTeamWorkFileImportInfo.jdField_e_of_type_Boolean = true;
      paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean = true;
      if ((!paramAppInterface.isFileImporting(paramTeamWorkFileImportInfo)) && (TextUtils.isEmpty(paramAppInterface.getUrlFromConvertedMap(paramTeamWorkFileImportInfo))) && (paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean))
      {
        paramAppInterface.addFileImportJob(paramTeamWorkFileImportInfo);
        a(paramContext, paramTeamWorkFileImportInfo, null);
        return null;
      }
      if ((paramAppInterface.isFileImporting(paramTeamWorkFileImportInfo)) && (paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean))
      {
        a(paramContext, paramTeamWorkFileImportInfo, null);
        return null;
      }
      if ((!TextUtils.isEmpty(paramAppInterface.getUrlFromConvertedMap(paramTeamWorkFileImportInfo))) && (paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean))
      {
        paramString = new Bundle();
        paramString.putString("url", paramAppInterface.getUrlFromConvertedMap(paramTeamWorkFileImportInfo));
        paramString.putBoolean("temp_preview_from_qq", true);
        paramString.putParcelable("key_team_work_file_import_info", paramTeamWorkFileImportInfo);
        if (paramTeamWorkFileImportInfo.d()) {
          paramString.putString("tdsourcetag", "s_qq_file_preview");
        } else {
          paramString.putString("tdsourcetag", "s_qq_file_edit");
        }
        ((ITeamWorkDocEditBrowserProxy)QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openTeamWorkDocEditBrowserActivity(paramContext, paramString, false);
      }
    }
    return null;
  }
  
  public static QQProgressDialog a(AppInterface paramAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    ITeamWorkFileImportHandler localITeamWorkFileImportHandler = (ITeamWorkFileImportHandler)paramAppInterface.getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
    if ((localITeamWorkFileImportHandler != null) && (paramTeamWorkFileImportInfo != null))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      paramTeamWorkFileImportInfo.jdField_e_of_type_Boolean = true;
      if (paramString2.equals(paramContext.getString(2131719542))) {
        paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean = true;
      } else {
        paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean = false;
      }
      localITeamWorkFileImportHandler.updateFileImporting(paramTeamWorkFileImportInfo, paramBoolean);
      if ((!localITeamWorkFileImportHandler.isFileImporting(paramTeamWorkFileImportInfo)) && (TextUtils.isEmpty(localITeamWorkFileImportHandler.getUrlFromConvertedMap(paramTeamWorkFileImportInfo))) && (paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean))
      {
        localITeamWorkFileImportHandler.addFileImportJob(paramTeamWorkFileImportInfo);
        a(paramContext, paramTeamWorkFileImportInfo, null);
        return null;
      }
      if ((localITeamWorkFileImportHandler.isFileImporting(paramTeamWorkFileImportInfo)) && (paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean))
      {
        a(paramContext, paramTeamWorkFileImportInfo, null);
        return null;
      }
      if ((!TextUtils.isEmpty(localITeamWorkFileImportHandler.getUrlFromConvertedMap(paramTeamWorkFileImportInfo))) && (paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean))
      {
        paramAppInterface = new Bundle();
        paramAppInterface.putString("url", localITeamWorkFileImportHandler.getUrlFromConvertedMap(paramTeamWorkFileImportInfo));
        paramAppInterface.putBoolean("temp_preview_from_qq", true);
        paramAppInterface.putParcelable("key_team_work_file_import_info", paramTeamWorkFileImportInfo);
        if (paramTeamWorkFileImportInfo.d()) {
          paramAppInterface.putString("tdsourcetag", "s_qq_file_preview");
        } else {
          paramAppInterface.putString("tdsourcetag", "s_qq_file_edit");
        }
        ((ITeamWorkDocEditBrowserProxy)QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openTeamWorkDocEditBrowserActivity(paramContext, paramAppInterface, false);
        return null;
      }
      if (!paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean) {
        a(paramAppInterface, paramTeamWorkFileImportInfo, paramContext, paramString1, paramString2, paramBoolean);
      }
    }
    return null;
  }
  
  public static String a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1) {
      return paramTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString;
    }
    return paramTeamWorkFileImportInfo.o;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {}
    for (String str = "0X800A750";; str = "0X800A751")
    {
      break;
      if (paramInt1 != 1) {
        return;
      }
    }
    ReportController.b(null, "dc00898", "", "", str, str, paramInt2, 0, "", "", "", "");
  }
  
  public static void a(Context paramContext, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    paramString = ((ITeamWorkDocEditBrowserProxy)QRoute.api(ITeamWorkDocEditBrowserProxy.class)).getClassIntent(paramContext);
    paramString.putExtra("key_team_work_file_import_info", paramTeamWorkFileImportInfo);
    paramString.putExtra("temp_preview_from_qq", true);
    paramString.putExtra("temp_preview_show_loading", true);
    int j = 0;
    int i = 0;
    if (paramTeamWorkFileImportInfo != null)
    {
      if (paramTeamWorkFileImportInfo.jdField_d_of_type_Int == 1)
      {
        paramString.putExtra("tdsourcetag", "s_qq_aio_edit");
      }
      else
      {
        if (paramTeamWorkFileImportInfo.jdField_d_of_type_Int == 5) {
          paramString.putExtra("tdsourcetag", "s_QQ_file_share_edit");
        }
        for (;;)
        {
          i = 1;
          break;
          if (paramTeamWorkFileImportInfo.d())
          {
            paramString.putExtra("tdsourcetag", "s_qq_file_preview");
            break;
          }
          paramString.putExtra("tdsourcetag", "s_qq_file_edit");
        }
      }
      Map localMap = ITeamWorkUtils.ENTRANCE_TO_AD_TAG_MAP;
      j = i;
      if (localMap != null)
      {
        j = i;
        if (localMap.containsKey(Integer.valueOf(paramTeamWorkFileImportInfo.jdField_d_of_type_Int)))
        {
          paramString.putExtra("tdsourcetag", (String)localMap.get(Integer.valueOf(paramTeamWorkFileImportInfo.jdField_d_of_type_Int)));
          j = i;
        }
      }
    }
    ((ITeamWorkDocEditBrowserProxy)QRoute.api(ITeamWorkDocEditBrowserProxy.class)).getOpenTeamWorkIntent(paramString, null, paramContext);
    boolean bool = paramContext instanceof Activity;
    if (bool) {
      i = 536870912;
    } else {
      i = 268435456;
    }
    paramString.addFlags(i);
    if ((bool) && (j != 0) && (b(paramString.getStringExtra("tdsourcetag"))))
    {
      ((Activity)paramContext).startActivityForResult(paramString, 14002);
      return;
    }
    paramContext.startActivity(paramString);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, TeamWorkConvertUtils.TencentDocGetProgressDialogCallback paramTencentDocGetProgressDialogCallback)
  {
    if (paramContext == null)
    {
      QLog.w(paramString, 1, "no context to show dialog");
      return;
    }
    if (!b(paramTeamWorkFileImportInfo))
    {
      a(paramAppInterface, paramTeamWorkFileImportInfo);
      c(paramTeamWorkFileImportInfo);
      paramAppInterface = a(paramAppInterface, paramTeamWorkFileImportInfo, paramContext, paramString, paramContext.getString(2131719542), true);
      if (paramTencentDocGetProgressDialogCallback != null) {
        paramTencentDocGetProgressDialogCallback.a(paramAppInterface);
      }
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).actionSheetHelperCreateDialog(paramContext, null);
    String str1;
    String str2;
    String str3;
    if (paramTeamWorkFileImportInfo.d())
    {
      str1 = paramContext.getString(2131691873);
      str2 = paramContext.getString(2131691869);
      str3 = paramContext.getString(2131691871);
    }
    else
    {
      str1 = paramContext.getString(2131691872);
      str2 = paramContext.getString(2131691867);
      str3 = paramContext.getString(2131691870);
    }
    localActionSheet.setMainTitle(2131691874);
    localActionSheet.setSecondaryTitle(str1);
    localActionSheet.addButton(str2, 5);
    localActionSheet.addButton(str3, 5);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new TeamWorkConvertUtils.1(paramTeamWorkFileImportInfo, localActionSheet, paramAppInterface, paramContext, paramString, paramTencentDocGetProgressDialogCallback));
    localActionSheet.show();
    if (paramTeamWorkFileImportInfo.d()) {
      TenDocLogReportHelper.a(paramAppInterface, "0X8009ED0");
    }
  }
  
  private static void a(AppInterface paramAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramAppInterface != null)
    {
      if (paramTeamWorkFileImportInfo == null) {
        return;
      }
      paramAppInterface = (ITeamWorkFileImportHandler)paramAppInterface.getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
      if (paramAppInterface == null) {
        return;
      }
      if ((paramAppInterface.isFileImporting(paramTeamWorkFileImportInfo)) && ((paramTeamWorkFileImportInfo.g == 1) || (paramTeamWorkFileImportInfo.g == 2))) {
        paramAppInterface.removeFileImporting(paramTeamWorkFileImportInfo);
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    ITeamWorkFileImportHandler localITeamWorkFileImportHandler = (ITeamWorkFileImportHandler)paramAppInterface.getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
    if ((localITeamWorkFileImportHandler != null) && (paramTeamWorkFileImportInfo != null))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      String str1 = String.format(paramContext.getString(2131719573), new Object[] { paramString2 });
      int j = TencentDocConvertConfigProcessor.a().a();
      int i = TencentDocConvertConfigProcessor.a().b();
      if (!PackageUtil.b(paramAppInterface.getApp(), "com.tencent.tim", "775E696D09856872FDD8AB4F3F06B1E0"))
      {
        str1 = String.format(paramContext.getString(2131719573), new Object[] { paramString2 });
        paramString2 = str1;
        if (QLog.isColorLevel())
        {
          QLog.d(paramString1, 2, "jumpTimLogin tim not install ");
          paramString2 = str1;
        }
      }
      for (;;)
      {
        i = 0;
        break label278;
        String str2 = PackageUtil.a(paramAppInterface.getApp(), "com.tencent.tim");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("jumpTimLogin tim timVersion=");
          localStringBuilder.append(str2);
          QLog.d(paramString1, 2, localStringBuilder.toString());
        }
        try
        {
          int k = Integer.parseInt(str2.replace(".", ""));
          if (k == 0)
          {
            paramString2 = String.format(paramContext.getString(2131719573), new Object[] { paramString2 });
          }
          else
          {
            if (k >= i) {
              break label271;
            }
            paramString2 = paramContext.getString(2131719630);
          }
        }
        catch (Exception paramString2)
        {
          QLog.w(paramString1, 1, paramString2.toString());
          label271:
          i = 1;
          paramString2 = str1;
        }
      }
      label278:
      if (i != 0)
      {
        paramContext = new Bundle();
        if (!paramBoolean)
        {
          if (j == -1) {
            QLog.i(paramString1, 1, "tim entry not defined");
          }
          paramContext.putBoolean("isOpenTeamWork", false);
          paramContext.putInt("timEntry", j);
        }
        else
        {
          paramContext.putBoolean("isOpenTeamWork", true);
        }
        paramContext.putString("teamworkUrl", localITeamWorkFileImportHandler.getUrlFromConvertedMap(paramTeamWorkFileImportInfo));
        paramContext.putInt("peerType", paramTeamWorkFileImportInfo.jdField_a_of_type_Int);
        paramContext.putString("peerUin", paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString);
        paramContext.putInt("busId", paramTeamWorkFileImportInfo.jdField_b_of_type_Int);
        paramContext.putLong("uniSeq", paramTeamWorkFileImportInfo.jdField_a_of_type_Long);
        ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).jumpTimLogin(paramContext, paramAppInterface);
        return;
      }
      paramAppInterface = DialogUtil.a(paramContext, 0);
      paramAppInterface.setMessage(paramString2);
      paramAppInterface.setPositiveButton(paramContext.getString(2131691827), new TeamWorkConvertUtils.2(paramContext, paramString1));
      paramAppInterface.setNegativeButton(paramContext.getString(2131693250), new TeamWorkConvertUtils.3(paramAppInterface));
      try
      {
        if (!paramAppInterface.isShowing())
        {
          paramAppInterface.show();
          return;
        }
      }
      catch (Exception paramAppInterface)
      {
        paramTeamWorkFileImportInfo = new StringBuilder();
        paramTeamWorkFileImportInfo.append("mDialog.show() exception");
        paramTeamWorkFileImportInfo.append(paramAppInterface.toString());
        QLog.e(paramString1, 1, paramTeamWorkFileImportInfo.toString());
      }
    }
  }
  
  public static void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo != null)
    {
      if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 1) {
        return;
      }
      Object localObject = null;
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
      if ((localAppRuntime instanceof AppInterface)) {
        localObject = (AppInterface)localAppRuntime;
      }
      if (localObject == null) {
        return;
      }
      localObject = (ITeamWorkFileImportHandler)((AppInterface)localObject).getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
      if (localObject == null) {
        return;
      }
      paramTeamWorkFileImportInfo.g = 7;
      ((ITeamWorkFileImportHandler)localObject).addFileImportJob(paramTeamWorkFileImportInfo);
    }
  }
  
  public static void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return;
    }
    QLog.d(paramString, 2, "try pre import");
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    ITeamWorkFileImportHandler localITeamWorkFileImportHandler = (ITeamWorkFileImportHandler)localAppInterface.getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
    if ((!localITeamWorkFileImportHandler.isFileImporting(paramTeamWorkFileImportInfo)) && (TextUtils.isEmpty(localITeamWorkFileImportHandler.getUrlFromConvertedMap(paramTeamWorkFileImportInfo))))
    {
      QLog.i(paramString, 1, " parseFileImportTendoc: no cache");
      paramTeamWorkFileImportInfo.g = 1;
      localITeamWorkFileImportHandler.addFileImportJob(paramTeamWorkFileImportInfo);
      return;
    }
    if (paramTeamWorkFileImportInfo.d())
    {
      QLog.i(paramString, 1, " parseFileImportTendoc: has cache, but online preview, drop it");
      localITeamWorkFileImportHandler.removeFileImporting(paramTeamWorkFileImportInfo);
      localITeamWorkFileImportHandler.removeFromConvertedMap(paramTeamWorkFileImportInfo);
      paramTeamWorkFileImportInfo.g = 1;
      localITeamWorkFileImportHandler.addFileImportJob(paramTeamWorkFileImportInfo);
      return;
    }
    QLog.i(paramString, 1, " parseFileImportTendoc: has cache");
    paramTeamWorkFileImportInfo.g = 2;
    paramTeamWorkFileImportInfo.h = 1;
    if (paramTeamWorkFileImportInfo.d()) {
      TenDocLogReportHelper.a(localAppInterface, "0X8009ECF");
    }
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity, Context paramContext, AppInterface paramAppInterface, int paramInt)
  {
    if (paramFileManagerEntity == null) {
      return false;
    }
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    localTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString = paramFileManagerEntity.getFilePath();
    localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = paramFileManagerEntity.fileName;
    localTeamWorkFileImportInfo.jdField_e_of_type_Int = paramFileManagerEntity.nFileType;
    localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = true;
    localTeamWorkFileImportInfo.jdField_d_of_type_Int = paramInt;
    localTeamWorkFileImportInfo.jdField_d_of_type_Long = paramFileManagerEntity.fileSize;
    if (paramInt == 6)
    {
      localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = false;
      localTeamWorkFileImportInfo.jdField_c_of_type_Boolean = true;
    }
    localTeamWorkFileImportInfo.jdField_a_of_type_Int = paramFileManagerEntity.peerType;
    localTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = paramFileManagerEntity.peerUin;
    localTeamWorkFileImportInfo.jdField_e_of_type_JavaLangString = String.valueOf(paramFileManagerEntity.TroopUin);
    localTeamWorkFileImportInfo.jdField_b_of_type_Int = paramFileManagerEntity.busId;
    localTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString = paramFileManagerEntity.strTroopFilePath;
    localTeamWorkFileImportInfo.jdField_a_of_type_Long = paramFileManagerEntity.uniseq;
    if (paramFileManagerEntity.status != 16) {
      localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
    }
    return a(localTeamWorkFileImportInfo, paramContext, paramAppInterface, paramInt);
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity, Context paramContext, AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    if (paramFileManagerEntity == null) {
      return false;
    }
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    localTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString = paramFileManagerEntity.getFilePath();
    localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = paramFileManagerEntity.fileName;
    localTeamWorkFileImportInfo.jdField_e_of_type_Int = paramFileManagerEntity.nFileType;
    localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = true;
    localTeamWorkFileImportInfo.jdField_d_of_type_Int = paramInt1;
    localTeamWorkFileImportInfo.jdField_d_of_type_Long = paramFileManagerEntity.fileSize;
    localTeamWorkFileImportInfo.jdField_c_of_type_Int = paramInt2;
    if (paramInt1 == 6)
    {
      localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = false;
      localTeamWorkFileImportInfo.jdField_c_of_type_Boolean = true;
    }
    localTeamWorkFileImportInfo.jdField_a_of_type_Int = paramFileManagerEntity.peerType;
    localTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = paramFileManagerEntity.peerUin;
    localTeamWorkFileImportInfo.jdField_e_of_type_JavaLangString = String.valueOf(paramFileManagerEntity.TroopUin);
    localTeamWorkFileImportInfo.jdField_b_of_type_Int = paramFileManagerEntity.busId;
    localTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString = paramFileManagerEntity.strTroopFilePath;
    localTeamWorkFileImportInfo.jdField_a_of_type_Long = paramFileManagerEntity.uniseq;
    if (paramFileManagerEntity.status != 16) {
      localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
    }
    return a(localTeamWorkFileImportInfo, paramContext, paramAppInterface, paramInt1);
  }
  
  public static boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    return (paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.g == 6) || (paramTeamWorkFileImportInfo.g == 7)) && (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1);
  }
  
  public static boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, Context paramContext, AppInterface paramAppInterface, int paramInt)
  {
    if (!NetworkUtil.isNetSupport(MobileQQ.getContext()))
    {
      QQToast.a(paramContext, HardCodeUtil.a(2131714581), 1).b(MobileQQ.getContext().getResources().getDimensionPixelSize(2131299168));
      return false;
    }
    if (paramInt == 9) {
      paramTeamWorkFileImportInfo.jdField_d_of_type_Int = paramInt;
    }
    ITeamWorkFileImportHandler localITeamWorkFileImportHandler = (ITeamWorkFileImportHandler)paramAppInterface.getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
    paramAppInterface = null;
    if (!TextUtils.isEmpty(localITeamWorkFileImportHandler.getUrlFromConvertedMap(paramTeamWorkFileImportInfo))) {
      paramAppInterface = localITeamWorkFileImportHandler.getUrlFromConvertedMap(paramTeamWorkFileImportInfo);
    }
    if (!localITeamWorkFileImportHandler.isFileImporting(paramTeamWorkFileImportInfo)) {
      localITeamWorkFileImportHandler.addFileImportJob(paramTeamWorkFileImportInfo);
    }
    if (!paramTeamWorkFileImportInfo.a()) {
      a(paramContext, paramTeamWorkFileImportInfo, paramAppInterface);
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (TencentDocUrl2DocConfigProcessor.a(Uri.parse(paramString).getHost()));
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = str;
    localTeamWorkFileImportInfo.f = paramString1;
    localTeamWorkFileImportInfo.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
    localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
    localTeamWorkFileImportInfo.jdField_d_of_type_Int = 12;
    paramString1 = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((paramString1 instanceof AppInterface))
    {
      a(localTeamWorkFileImportInfo, MobileQQ.getContext(), (AppInterface)paramString1, localTeamWorkFileImportInfo.jdField_d_of_type_Int);
      return true;
    }
    paramString1 = new Bundle();
    paramString1.putParcelable("key_team_work_file_import_info", localTeamWorkFileImportInfo);
    ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).sendServiceIpcReq(paramString1);
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString4)) && (!TextUtils.isEmpty(paramString5));
  }
  
  public static boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    Object localObject = paramJSONObject.optJSONArray("urls");
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((JSONArray)localObject).optString(0);
    }
    return a((String)localObject, paramJSONObject.optString("filename"), paramJSONObject.optString("cookie"), paramJSONObject.optString("filetype"), paramJSONObject.optString("fileid"));
  }
  
  public static void b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localObject instanceof AppInterface)) {
      localObject = (AppInterface)localObject;
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return;
    }
    localObject = (ITeamWorkFileImportHandler)((AppInterface)localObject).getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
    if (localObject == null) {
      return;
    }
    paramTeamWorkFileImportInfo.g = 1;
    ((ITeamWorkFileImportHandler)localObject).addFileImportJob(paramTeamWorkFileImportInfo);
  }
  
  private static boolean b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    boolean bool = false;
    if (paramTeamWorkFileImportInfo == null) {
      return false;
    }
    if (paramTeamWorkFileImportInfo.d()) {
      return false;
    }
    if ((paramTeamWorkFileImportInfo.h == 2) || (paramTeamWorkFileImportInfo.h == 1)) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = (String)ITeamWorkUtils.MINIAPP_CONFIG_TYPE_MAP.get(paramString);
    if (paramString == null) {
      return false;
    }
    TencentDocsPushBean localTencentDocsPushBean = (TencentDocsPushBean)QConfigManager.a().a(418);
    if (localTencentDocsPushBean == null) {
      return false;
    }
    paramString = (TencentDocsPushItemBean)localTencentDocsPushBean.a().get(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.a();
  }
  
  private static void c(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return;
    }
    if (paramTeamWorkFileImportInfo.g != 0)
    {
      if (paramTeamWorkFileImportInfo.g == 4) {
        return;
      }
      paramTeamWorkFileImportInfo.g = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkConvertUtils
 * JD-Core Version:    0.7.0.1
 */