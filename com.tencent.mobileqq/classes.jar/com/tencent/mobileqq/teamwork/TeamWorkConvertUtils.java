package com.tencent.mobileqq.teamwork;

import aime;
import aimf;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.managers.TimJumpLoginManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class TeamWorkConvertUtils
{
  public static QQProgressDialog a(QQAppInterface paramQQAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    TeamWorkFileImportHandler localTeamWorkFileImportHandler = (TeamWorkFileImportHandler)paramQQAppInterface.a(120);
    if ((localTeamWorkFileImportHandler == null) || (paramTeamWorkFileImportInfo == null) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return null;
      paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean = true;
      if (paramString2.equals(paramContext.getString(2131439137))) {}
      for (paramTeamWorkFileImportInfo.jdField_c_of_type_Boolean = true;; paramTeamWorkFileImportInfo.jdField_c_of_type_Boolean = false)
      {
        localTeamWorkFileImportHandler.a(paramTeamWorkFileImportInfo, paramBoolean);
        if ((localTeamWorkFileImportHandler.a(paramTeamWorkFileImportInfo)) || (!TextUtils.isEmpty(localTeamWorkFileImportHandler.a(paramTeamWorkFileImportInfo))) || (!paramTeamWorkFileImportInfo.jdField_c_of_type_Boolean)) {
          break;
        }
        localTeamWorkFileImportHandler.a(paramTeamWorkFileImportInfo);
        a(paramContext, paramTeamWorkFileImportInfo, null);
        return null;
      }
      if ((localTeamWorkFileImportHandler.a(paramTeamWorkFileImportInfo)) && (paramTeamWorkFileImportInfo.jdField_c_of_type_Boolean))
      {
        a(paramContext, paramTeamWorkFileImportInfo, null);
        return null;
      }
      if ((!TextUtils.isEmpty(localTeamWorkFileImportHandler.a(paramTeamWorkFileImportInfo))) && (paramTeamWorkFileImportInfo.jdField_c_of_type_Boolean))
      {
        paramQQAppInterface = new Bundle();
        paramQQAppInterface.putString("url", localTeamWorkFileImportHandler.a(paramTeamWorkFileImportInfo));
        paramQQAppInterface.putBoolean("temp_preview_from_qq", true);
        paramQQAppInterface.putParcelable("key_team_work_file_import_info", paramTeamWorkFileImportInfo);
        TeamWorkDocEditBrowserActivity.a(paramContext, paramQQAppInterface, false);
        return null;
      }
    } while (paramTeamWorkFileImportInfo.jdField_c_of_type_Boolean);
    a(paramQQAppInterface, paramTeamWorkFileImportInfo, paramContext, paramString1, paramString2, paramBoolean);
    return null;
  }
  
  public static void a(Context paramContext, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    paramString = new Intent(paramContext, TeamWorkDocEditBrowserActivity.class);
    paramString.putExtra("key_team_work_file_import_info", paramTeamWorkFileImportInfo);
    paramString.putExtra("temp_preview_from_qq", true);
    paramString.putExtra("temp_preview_show_loading", true);
    TeamWorkDocEditBrowserActivity.a(paramString, null, paramContext);
    paramString.addFlags(603979776);
    paramContext.startActivity(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    TeamWorkFileImportHandler localTeamWorkFileImportHandler = (TeamWorkFileImportHandler)paramQQAppInterface.a(120);
    if ((localTeamWorkFileImportHandler == null) || (paramTeamWorkFileImportInfo == null) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return;
      String str = String.format(paramContext.getString(2131439141), new Object[] { paramString2 });
      Object localObject = paramQQAppInterface.getApp().getSharedPreferences("tim_convert_teamwork_pre_" + paramQQAppInterface.c(), 0);
      int k = ((SharedPreferences)localObject).getInt("tim_convert_teamwork_tim_open_file_entry", -1);
      int m = ((SharedPreferences)localObject).getInt("tim_convert_teamwork_tim_version", -1);
      int j = 1;
      int i;
      if (!PackageUtil.b(paramQQAppInterface.getApp(), "com.tencent.tim", "775E696D09856872FDD8AB4F3F06B1E0"))
      {
        paramString2 = String.format(paramContext.getString(2131439141), new Object[] { paramString2 });
        if (QLog.isColorLevel()) {
          QLog.d(paramString1, 2, "jumpTimLogin tim not install ");
        }
        i = 0;
        if (i == 0) {
          break label420;
        }
        paramContext = new Bundle();
        if (paramBoolean) {
          break label410;
        }
        if (k == -1) {
          QLog.i(paramString1, 1, "tim entry not defined");
        }
        paramContext.putBoolean("isOpenTeamWork", false);
        paramContext.putInt("timEntry", k);
      }
      for (;;)
      {
        for (;;)
        {
          paramContext.putString("teamworkUrl", localTeamWorkFileImportHandler.a(paramTeamWorkFileImportInfo));
          paramContext.putInt("peerType", paramTeamWorkFileImportInfo.jdField_a_of_type_Int);
          paramContext.putString("peerUin", paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString);
          paramContext.putInt("busId", paramTeamWorkFileImportInfo.jdField_b_of_type_Int);
          paramContext.putLong("uniSeq", paramTeamWorkFileImportInfo.jdField_a_of_type_Long);
          ((TimJumpLoginManager)paramQQAppInterface.getManager(241)).a(paramContext);
          return;
          localObject = PackageUtil.a(paramQQAppInterface.getApp(), "com.tencent.tim");
          if (QLog.isColorLevel()) {
            QLog.d(paramString1, 2, "jumpTimLogin tim timVersion=" + (String)localObject);
          }
          try
          {
            int n = Integer.parseInt(((String)localObject).replace(".", ""));
            if (n == 0)
            {
              paramString2 = String.format(paramContext.getString(2131439141), new Object[] { paramString2 });
              i = 0;
              break;
            }
            i = j;
            paramString2 = str;
            if (n >= m) {
              break;
            }
            paramString2 = paramContext.getString(2131439133);
            i = 0;
          }
          catch (Exception paramString2)
          {
            QLog.w(paramString1, 1, paramString2.toString());
            i = j;
            paramString2 = str;
          }
        }
        break;
        label410:
        paramContext.putBoolean("isOpenTeamWork", true);
      }
      label420:
      paramTeamWorkFileImportInfo = DialogUtil.a(paramContext, 0);
      paramTeamWorkFileImportInfo.setMessage(paramString2);
      paramTeamWorkFileImportInfo.setPositiveButton(paramContext.getString(2131434609), new aime(paramQQAppInterface, paramContext, paramString1));
      paramTeamWorkFileImportInfo.setNegativeButton(paramContext.getString(2131435886), new aimf(paramTeamWorkFileImportInfo));
      try
      {
        if (!paramTeamWorkFileImportInfo.isShowing())
        {
          paramTeamWorkFileImportInfo.show();
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e(paramString1, 1, "mDialog.show() exception" + paramQQAppInterface.toString());
      }
    }
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramFileManagerEntity == null) {
      return false;
    }
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    localTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString = paramFileManagerEntity.strFilePath;
    localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = paramFileManagerEntity.fileName;
    localTeamWorkFileImportInfo.jdField_d_of_type_Int = paramFileManagerEntity.nFileType;
    localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = true;
    localTeamWorkFileImportInfo.jdField_c_of_type_Int = paramInt;
    localTeamWorkFileImportInfo.jdField_c_of_type_Long = paramFileManagerEntity.fileSize;
    localTeamWorkFileImportInfo.jdField_a_of_type_Int = paramFileManagerEntity.peerType;
    localTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = paramFileManagerEntity.peerUin;
    localTeamWorkFileImportInfo.e = String.valueOf(paramFileManagerEntity.TroopUin);
    localTeamWorkFileImportInfo.jdField_b_of_type_Int = paramFileManagerEntity.busId;
    localTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString = paramFileManagerEntity.strTroopFilePath;
    localTeamWorkFileImportInfo.jdField_a_of_type_Long = paramFileManagerEntity.uniseq;
    if (paramFileManagerEntity.status != 16) {
      localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
    }
    return a(localTeamWorkFileImportInfo, paramContext, paramQQAppInterface, paramInt);
  }
  
  public static boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramInt = paramQQAppInterface.getApp().getSharedPreferences("tim_convert_teamwork_pre_" + paramQQAppInterface.c(), 0).getInt("tim_convert_teamwork_file_size", 20971520);
    if (!NetworkUtil.d(BaseApplicationImpl.getContext())) {
      QQToast.a(paramContext, "当前网络不可用，请检查你的网络设置。", 1).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131558448));
    }
    while ((!TeamWorkUtils.a(paramTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString, paramTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString)) || (paramTeamWorkFileImportInfo.jdField_c_of_type_Long > paramInt)) {
      return false;
    }
    TeamWorkFileImportHandler localTeamWorkFileImportHandler = (TeamWorkFileImportHandler)paramQQAppInterface.a(120);
    paramQQAppInterface = null;
    if (!TextUtils.isEmpty(localTeamWorkFileImportHandler.a(paramTeamWorkFileImportInfo))) {
      paramQQAppInterface = localTeamWorkFileImportHandler.a(paramTeamWorkFileImportInfo);
    }
    if (!localTeamWorkFileImportHandler.a(paramTeamWorkFileImportInfo)) {
      localTeamWorkFileImportHandler.a(paramTeamWorkFileImportInfo);
    }
    a(paramContext, paramTeamWorkFileImportInfo, paramQQAppInterface);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkConvertUtils
 * JD-Core Version:    0.7.0.1
 */