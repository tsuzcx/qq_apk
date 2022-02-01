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
    if ((paramContext != null) && (localITeamWorkFileImportHandler != null) && (paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.a == 1))
    {
      paramTeamWorkFileImportInfo.B = 6;
      return a(paramAppInterface, paramTeamWorkFileImportInfo, paramContext, paramString);
    }
    return null;
  }
  
  public static QQProgressDialog a(AppInterface paramAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, Context paramContext, String paramString)
  {
    paramAppInterface = (ITeamWorkFileImportHandler)paramAppInterface.getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
    if ((paramAppInterface != null) && (paramTeamWorkFileImportInfo != null))
    {
      if (!d(paramTeamWorkFileImportInfo)) {
        return null;
      }
      paramTeamWorkFileImportInfo.r = true;
      paramTeamWorkFileImportInfo.q = true;
      if ((!paramAppInterface.isFileImporting(paramTeamWorkFileImportInfo)) && (TextUtils.isEmpty(paramAppInterface.getUrlFromConvertedMap(paramTeamWorkFileImportInfo))) && (paramTeamWorkFileImportInfo.q))
      {
        paramAppInterface.addFileImportJob(paramTeamWorkFileImportInfo);
        a(paramContext, paramTeamWorkFileImportInfo, null);
        return null;
      }
      if ((paramAppInterface.isFileImporting(paramTeamWorkFileImportInfo)) && (paramTeamWorkFileImportInfo.q))
      {
        a(paramContext, paramTeamWorkFileImportInfo, null);
        return null;
      }
      if ((!TextUtils.isEmpty(paramAppInterface.getUrlFromConvertedMap(paramTeamWorkFileImportInfo))) && (paramTeamWorkFileImportInfo.q))
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
      paramTeamWorkFileImportInfo.r = true;
      if (paramString2.equals(paramContext.getString(2131917105))) {
        paramTeamWorkFileImportInfo.q = true;
      } else {
        paramTeamWorkFileImportInfo.q = false;
      }
      localITeamWorkFileImportHandler.updateFileImporting(paramTeamWorkFileImportInfo, paramBoolean);
      if ((!localITeamWorkFileImportHandler.isFileImporting(paramTeamWorkFileImportInfo)) && (TextUtils.isEmpty(localITeamWorkFileImportHandler.getUrlFromConvertedMap(paramTeamWorkFileImportInfo))) && (paramTeamWorkFileImportInfo.q))
      {
        localITeamWorkFileImportHandler.addFileImportJob(paramTeamWorkFileImportInfo);
        a(paramContext, paramTeamWorkFileImportInfo, null);
        return null;
      }
      if ((localITeamWorkFileImportHandler.isFileImporting(paramTeamWorkFileImportInfo)) && (paramTeamWorkFileImportInfo.q))
      {
        a(paramContext, paramTeamWorkFileImportInfo, null);
        return null;
      }
      if ((!TextUtils.isEmpty(localITeamWorkFileImportHandler.getUrlFromConvertedMap(paramTeamWorkFileImportInfo))) && (paramTeamWorkFileImportInfo.q))
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
      if (!paramTeamWorkFileImportInfo.q) {
        b(paramAppInterface, paramTeamWorkFileImportInfo, paramContext, paramString1, paramString2, paramBoolean);
      }
    }
    return null;
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
      if (paramTeamWorkFileImportInfo.n == 1)
      {
        paramString.putExtra("tdsourcetag", "s_qq_aio_edit");
      }
      else
      {
        if (paramTeamWorkFileImportInfo.n == 5) {
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
        if (localMap.containsKey(Integer.valueOf(paramTeamWorkFileImportInfo.n)))
        {
          paramString.putExtra("tdsourcetag", (String)localMap.get(Integer.valueOf(paramTeamWorkFileImportInfo.n)));
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
    if (!e(paramTeamWorkFileImportInfo))
    {
      a(paramAppInterface, paramTeamWorkFileImportInfo);
      f(paramTeamWorkFileImportInfo);
      paramAppInterface = a(paramAppInterface, paramTeamWorkFileImportInfo, paramContext, paramString, paramContext.getString(2131917105), true);
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
      str1 = paramContext.getString(2131888838);
      str2 = paramContext.getString(2131888834);
      str3 = paramContext.getString(2131888836);
    }
    else
    {
      str1 = paramContext.getString(2131888837);
      str2 = paramContext.getString(2131888832);
      str3 = paramContext.getString(2131888835);
    }
    localActionSheet.setMainTitle(2131888839);
    localActionSheet.setSecondaryTitle(str1);
    localActionSheet.addButton(str2, 5);
    localActionSheet.addButton(str3, 5);
    localActionSheet.addCancelButton(2131887648);
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
      if ((paramAppInterface.isFileImporting(paramTeamWorkFileImportInfo)) && ((paramTeamWorkFileImportInfo.B == 1) || (paramTeamWorkFileImportInfo.B == 2))) {
        paramAppInterface.removeFileImporting(paramTeamWorkFileImportInfo);
      }
    }
  }
  
  public static void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo != null)
    {
      if (paramTeamWorkFileImportInfo.a != 1) {
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
      paramTeamWorkFileImportInfo.B = 7;
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
      paramTeamWorkFileImportInfo.B = 1;
      localITeamWorkFileImportHandler.addFileImportJob(paramTeamWorkFileImportInfo);
      return;
    }
    if (paramTeamWorkFileImportInfo.d())
    {
      QLog.i(paramString, 1, " parseFileImportTendoc: has cache, but online preview, drop it");
      localITeamWorkFileImportHandler.removeFileImporting(paramTeamWorkFileImportInfo);
      localITeamWorkFileImportHandler.removeFromConvertedMap(paramTeamWorkFileImportInfo);
      paramTeamWorkFileImportInfo.B = 1;
      localITeamWorkFileImportHandler.addFileImportJob(paramTeamWorkFileImportInfo);
      return;
    }
    QLog.i(paramString, 1, " parseFileImportTendoc: has cache");
    paramTeamWorkFileImportInfo.B = 2;
    paramTeamWorkFileImportInfo.C = 1;
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
    localTeamWorkFileImportInfo.d = paramFileManagerEntity.getFilePath();
    localTeamWorkFileImportInfo.c = paramFileManagerEntity.fileName;
    localTeamWorkFileImportInfo.u = paramFileManagerEntity.nFileType;
    localTeamWorkFileImportInfo.o = true;
    localTeamWorkFileImportInfo.n = paramInt;
    localTeamWorkFileImportInfo.K = paramFileManagerEntity.fileSize;
    if (paramInt == 6)
    {
      localTeamWorkFileImportInfo.o = false;
      localTeamWorkFileImportInfo.p = true;
    }
    localTeamWorkFileImportInfo.a = paramFileManagerEntity.peerType;
    localTeamWorkFileImportInfo.b = paramFileManagerEntity.peerUin;
    localTeamWorkFileImportInfo.j = String.valueOf(paramFileManagerEntity.TroopUin);
    localTeamWorkFileImportInfo.h = paramFileManagerEntity.busId;
    localTeamWorkFileImportInfo.g = paramFileManagerEntity.strTroopFilePath;
    localTeamWorkFileImportInfo.e = paramFileManagerEntity.uniseq;
    if (paramFileManagerEntity.status != 16) {
      localTeamWorkFileImportInfo.m = true;
    }
    return a(localTeamWorkFileImportInfo, paramContext, paramAppInterface, paramInt);
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity, Context paramContext, AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    if (paramFileManagerEntity == null) {
      return false;
    }
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    localTeamWorkFileImportInfo.d = paramFileManagerEntity.getFilePath();
    localTeamWorkFileImportInfo.c = paramFileManagerEntity.fileName;
    localTeamWorkFileImportInfo.u = paramFileManagerEntity.nFileType;
    localTeamWorkFileImportInfo.o = true;
    localTeamWorkFileImportInfo.n = paramInt1;
    localTeamWorkFileImportInfo.K = paramFileManagerEntity.fileSize;
    localTeamWorkFileImportInfo.i = paramInt2;
    if (paramInt1 == 6)
    {
      localTeamWorkFileImportInfo.o = false;
      localTeamWorkFileImportInfo.p = true;
    }
    localTeamWorkFileImportInfo.a = paramFileManagerEntity.peerType;
    localTeamWorkFileImportInfo.b = paramFileManagerEntity.peerUin;
    localTeamWorkFileImportInfo.j = String.valueOf(paramFileManagerEntity.TroopUin);
    localTeamWorkFileImportInfo.h = paramFileManagerEntity.busId;
    localTeamWorkFileImportInfo.g = paramFileManagerEntity.strTroopFilePath;
    localTeamWorkFileImportInfo.e = paramFileManagerEntity.uniseq;
    if (paramFileManagerEntity.status != 16) {
      localTeamWorkFileImportInfo.m = true;
    }
    return a(localTeamWorkFileImportInfo, paramContext, paramAppInterface, paramInt1);
  }
  
  public static boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, Context paramContext, AppInterface paramAppInterface, int paramInt)
  {
    if (!NetworkUtil.isNetSupport(MobileQQ.getContext()))
    {
      QQToast.makeText(paramContext, HardCodeUtil.a(2131912090), 1).show(MobileQQ.getContext().getResources().getDimensionPixelSize(2131299920));
      return false;
    }
    if (paramInt == 9) {
      paramTeamWorkFileImportInfo.n = paramInt;
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
    localTeamWorkFileImportInfo.c = str;
    localTeamWorkFileImportInfo.k = paramString1;
    localTeamWorkFileImportInfo.l = SystemClock.elapsedRealtime();
    localTeamWorkFileImportInfo.m = true;
    localTeamWorkFileImportInfo.n = 12;
    paramString1 = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((paramString1 instanceof AppInterface))
    {
      a(localTeamWorkFileImportInfo, MobileQQ.getContext(), (AppInterface)paramString1, localTeamWorkFileImportInfo.n);
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
  
  public static void b(AppInterface paramAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    ITeamWorkFileImportHandler localITeamWorkFileImportHandler = (ITeamWorkFileImportHandler)paramAppInterface.getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
    if ((localITeamWorkFileImportHandler != null) && (paramTeamWorkFileImportInfo != null))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      String str1 = String.format(paramContext.getString(2131917136), new Object[] { paramString2 });
      int j = TencentDocConvertConfigProcessor.a().e();
      int i = TencentDocConvertConfigProcessor.a().h();
      if (!PackageUtil.b(paramAppInterface.getApp(), "com.tencent.tim", "775E696D09856872FDD8AB4F3F06B1E0"))
      {
        str1 = String.format(paramContext.getString(2131917136), new Object[] { paramString2 });
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
        String str2 = PackageUtil.b(paramAppInterface.getApp(), "com.tencent.tim");
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
            paramString2 = String.format(paramContext.getString(2131917136), new Object[] { paramString2 });
          }
          else
          {
            if (k >= i) {
              break label271;
            }
            paramString2 = paramContext.getString(2131917227);
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
        paramContext.putInt("peerType", paramTeamWorkFileImportInfo.a);
        paramContext.putString("peerUin", paramTeamWorkFileImportInfo.b);
        paramContext.putInt("busId", paramTeamWorkFileImportInfo.h);
        paramContext.putLong("uniSeq", paramTeamWorkFileImportInfo.e);
        ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).jumpTimLogin(paramContext, paramAppInterface);
        return;
      }
      paramAppInterface = DialogUtil.a(paramContext, 0);
      paramAppInterface.setMessage(paramString2);
      paramAppInterface.setPositiveButton(paramContext.getString(2131888790), new TeamWorkConvertUtils.2(paramContext, paramString1));
      paramAppInterface.setNegativeButton(paramContext.getString(2131890798), new TeamWorkConvertUtils.3(paramAppInterface));
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
    paramTeamWorkFileImportInfo.B = 1;
    ((ITeamWorkFileImportHandler)localObject).addFileImportJob(paramTeamWorkFileImportInfo);
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
    TencentDocsPushBean localTencentDocsPushBean = (TencentDocsPushBean)QConfigManager.b().b(418);
    if (localTencentDocsPushBean == null) {
      return false;
    }
    paramString = (TencentDocsPushItemBean)localTencentDocsPushBean.a().get(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.a();
  }
  
  public static String c(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo.a == 1) {
      return paramTeamWorkFileImportInfo.g;
    }
    return paramTeamWorkFileImportInfo.H;
  }
  
  public static boolean d(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    return (paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.B == 6) || (paramTeamWorkFileImportInfo.B == 7)) && (paramTeamWorkFileImportInfo.a == 1);
  }
  
  private static boolean e(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    boolean bool = false;
    if (paramTeamWorkFileImportInfo == null) {
      return false;
    }
    if (paramTeamWorkFileImportInfo.d()) {
      return false;
    }
    if ((paramTeamWorkFileImportInfo.C == 2) || (paramTeamWorkFileImportInfo.C == 1)) {
      bool = true;
    }
    return bool;
  }
  
  private static void f(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return;
    }
    if (paramTeamWorkFileImportInfo.B != 0)
    {
      if (paramTeamWorkFileImportInfo.B == 4) {
        return;
      }
      paramTeamWorkFileImportInfo.B = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkConvertUtils
 * JD-Core Version:    0.7.0.1
 */