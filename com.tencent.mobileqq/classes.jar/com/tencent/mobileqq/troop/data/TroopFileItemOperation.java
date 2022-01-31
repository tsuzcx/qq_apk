package com.tencent.mobileqq.troop.data;

import ajeg;
import ajeh;
import ajei;
import ajej;
import ajek;
import ajel;
import ajem;
import ajen;
import ajeo;
import ajep;
import ajeq;
import ajer;
import ajes;
import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.DownloadFileConfig;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.UUID;

public class TroopFileItemOperation
{
  public Activity a;
  public QQAppInterface a;
  public long b;
  
  public TroopFileItemOperation(long paramLong, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private int a()
  {
    return a(true);
  }
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_Long);
    }
    return TroopFileUtils.a(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, long paramLong1, TroopFileStatusInfo paramTroopFileStatusInfo, String paramString, long paramLong2, int paramInt)
  {
    FileInfo localFileInfo = new FileInfo();
    if (!FileUtil.a(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) {
      TroopFileTransferManager.a(paramQQAppInterface, paramLong1).b();
    }
    switch (paramTroopFileStatusInfo.jdField_b_of_type_Int)
    {
    default: 
      if (TextUtils.isEmpty(paramTroopFileStatusInfo.g)) {
        break;
      }
    }
    for (String str = paramTroopFileStatusInfo.g;; str = "")
    {
      TroopFileManager.a(paramQQAppInterface, paramLong1).a(paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
      localFileInfo.d(str);
      localFileInfo.e(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString);
      localFileInfo.a(paramTroopFileStatusInfo.jdField_b_of_type_Long);
      Object localObject = new TroopFileStatusInfo();
      ((TroopFileStatusInfo)localObject).g = str;
      ((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaLangString = paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString;
      ((TroopFileStatusInfo)localObject).jdField_b_of_type_Long = paramTroopFileStatusInfo.jdField_b_of_type_Long;
      ((TroopFileStatusInfo)localObject).jdField_c_of_type_Long = paramTroopFileStatusInfo.jdField_c_of_type_Long;
      ((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaUtilUUID = paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID;
      ((TroopFileStatusInfo)localObject).jdField_a_of_type_Long = paramLong1;
      ((TroopFileStatusInfo)localObject).jdField_e_of_type_Int = paramTroopFileStatusInfo.jdField_e_of_type_Int;
      ((TroopFileStatusInfo)localObject).jdField_e_of_type_JavaLangString = paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString;
      ((TroopFileStatusInfo)localObject).f = paramTroopFileStatusInfo.f;
      ((TroopFileStatusInfo)localObject).jdField_b_of_type_JavaLangString = paramTroopFileStatusInfo.jdField_b_of_type_JavaLangString;
      ((TroopFileStatusInfo)localObject).jdField_c_of_type_JavaLangString = paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString;
      ((TroopFileStatusInfo)localObject).d = paramTroopFileStatusInfo.d;
      ((TroopFileStatusInfo)localObject).jdField_b_of_type_Int = paramTroopFileStatusInfo.jdField_b_of_type_Int;
      FileManagerEntity localFileManagerEntity = FileManagerUtil.a((TroopFileStatusInfo)localObject);
      localFileManagerEntity.selfUin = paramString;
      localFileManagerEntity.lastTime = paramLong2;
      localFileManagerEntity.bSend = paramQQAppInterface.getAccount().equals(localFileManagerEntity.selfUin);
      localObject = new ForwardFileInfo();
      ((ForwardFileInfo)localObject).b(localFileManagerEntity.nSessionId);
      ((ForwardFileInfo)localObject).d(4);
      ((ForwardFileInfo)localObject).b(10006);
      ((ForwardFileInfo)localObject).a(localFileInfo.c());
      ((ForwardFileInfo)localObject).d(localFileInfo.d());
      ((ForwardFileInfo)localObject).d(localFileInfo.a());
      ((ForwardFileInfo)localObject).a(paramLong1);
      if ((paramActivity instanceof BasePluginActivity)) {}
      for (paramString = ((BasePluginActivity)paramActivity).getOutActivity();; paramString = paramActivity)
      {
        paramString = new Intent(paramString, TroopFileDetailBrowserActivity.class);
        if (paramInt == 1)
        {
          paramTroopFileStatusInfo = TroopFileManager.a(paramQQAppInterface, paramLong1).a(paramTroopFileStatusInfo.i);
          if (paramTroopFileStatusInfo != null) {
            paramString.putExtra("leftViewText", paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString);
          }
        }
        paramString.putExtra("fileinfo", (Parcelable)localObject);
        paramString.putExtra("removemementity", true);
        paramString.putExtra("forward_from_troop_file", true);
        paramString.putExtra("not_forward", true);
        paramString.putExtra("last_time", paramLong2);
        paramString.putExtra("from_type_troop", paramInt);
        if ((paramActivity instanceof BasePluginActivity)) {
          ((BasePluginActivity)paramActivity).startActivityForResult(paramString, 102);
        }
        for (;;)
        {
          if ((str != null) && (str.endsWith(".mp4")))
          {
            paramString = "3";
            paramTroopFileStatusInfo = paramString;
            if (paramActivity != null)
            {
              paramTroopFileStatusInfo = paramString;
              if ((paramActivity instanceof SplashActivity)) {
                paramTroopFileStatusInfo = "1";
              }
            }
            ShortVideoUtils.a(paramQQAppInterface.getCurrentAccountUin(), String.valueOf(paramLong1), String.valueOf(0), 1, "3", paramTroopFileStatusInfo);
          }
          return;
          paramQQAppInterface = "";
          paramInt = paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString.lastIndexOf("/") + 1;
          if (paramInt < paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString.length()) {
            paramQQAppInterface = paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString.substring(paramInt, paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString.length() - 1);
          }
          TroopFileError.a(paramActivity, b(2131429794, new Object[] { TroopFileUtils.a(paramQQAppInterface) }));
          return;
          paramActivity.startActivityForResult(paramString, 102);
        }
      }
    }
  }
  
  private static String b(int paramInt)
  {
    return BaseApplicationImpl.getContext().getResources().getString(paramInt);
  }
  
  private static String b(int paramInt, Object... paramVarArgs)
  {
    return String.format(b(paramInt), paramVarArgs);
  }
  
  private void b(FileManagerEntity paramFileManagerEntity)
  {
    TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.TroopUin, paramFileManagerEntity.zipFilePath, paramFileManagerEntity.busId, new ajen(this, paramFileManagerEntity));
  }
  
  public TroopFileInfo a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    paramView = paramView.getTag();
    if ((paramView == null) || (!(paramView instanceof TroopFileInfo))) {
      return null;
    }
    return (TroopFileInfo)paramView;
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    if ((i == 1) && (paramFileManagerEntity.fileSize > 3145728L))
    {
      Object localObject = new ajem(this, paramFileManagerEntity);
      paramFileManagerEntity = b(2131429776, new Object[] { TroopFileUtils.a(paramFileManagerEntity.fileName), TroopFileUtils.a(paramFileManagerEntity.fileSize) });
      localObject = DialogUtil.b(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131429769), paramFileManagerEntity, 2131433015, 2131433013, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      paramFileManagerEntity = CUOpenCardGuideMng.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramFileManagerEntity);
      if ((paramFileManagerEntity instanceof SpannableString)) {
        ((QQCustomDialog)localObject).setMessageWithoutAutoLink(paramFileManagerEntity);
      }
      ((QQCustomDialog)localObject).show();
      return;
    }
    b(paramFileManagerEntity);
  }
  
  public void a(TroopFileInfo paramTroopFileInfo)
  {
    paramTroopFileInfo = new ajep(this, paramTroopFileInfo);
    DialogUtil.b(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131429770), b(2131429782), 2131433015, 2131433016, paramTroopFileInfo, paramTroopFileInfo).show();
  }
  
  public void a(TroopFileInfo paramTroopFileInfo, String paramString1, String paramString2)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localQQCustomDialog.setTitle(paramString1).setMessage(paramString2);
    paramString1 = (LinearLayout.LayoutParams)localQQCustomDialog.getMessageTextView().getLayoutParams();
    paramString1.gravity = 17;
    localQQCustomDialog.getMessageTextView().setLayoutParams(paramString1);
    localQQCustomDialog.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131433016), new ajek(this, paramTroopFileInfo));
    localQQCustomDialog.show();
  }
  
  public void a(TroopFileStatusInfo paramTroopFileStatusInfo, String paramString, long paramLong, int paramInt)
  {
    a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long, paramTroopFileStatusInfo, paramString, paramLong, paramInt);
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    Object localObject = HWTroopUtils.a(paramString2);
    localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a((String)localObject);
    if ((i == 1) && (paramLong > ((TroopManager.DownloadFileConfig)localObject).jdField_b_of_type_Int))
    {
      paramString1 = new ajel(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt);
      paramString2 = b(2131429779, new Object[] { TroopFileUtils.a(paramString2), TroopFileUtils.a(paramLong) });
      paramString1 = DialogUtil.b(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131429769), paramString2, 2131433015, 2131429731, paramString1, paramString1);
      paramString2 = CUOpenCardGuideMng.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramString2);
      if ((paramString2 instanceof SpannableString)) {
        paramString1.setMessageWithoutAutoLink(paramString2);
      }
      paramString1.show();
      return;
    }
    localTroopFileTransferManager.a(paramString1, paramString2, paramLong, paramInt);
  }
  
  public void a(UUID paramUUID)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    if (i == 1)
    {
      ajeg localajeg = new ajeg(this, localTroopFileTransferManager, paramUUID);
      paramUUID = localTroopFileTransferManager.a(paramUUID);
      if (paramUUID != null) {}
      for (paramUUID = b(2131429777, new Object[] { TroopFileUtils.a(paramUUID.g), TroopFileUtils.a(paramUUID.jdField_b_of_type_Long) });; paramUUID = b(2131429778))
      {
        DialogUtil.b(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131429769), paramUUID, 2131433015, 2131429734, localajeg, localajeg).show();
        return;
      }
    }
    localTroopFileTransferManager.b(paramUUID);
  }
  
  public void b(TroopFileInfo paramTroopFileInfo)
  {
    paramTroopFileInfo = new ajeq(this, paramTroopFileInfo);
    DialogUtil.b(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131429771), b(2131429783), 2131433015, 2131433016, paramTroopFileInfo, paramTroopFileInfo).show();
  }
  
  public void b(UUID paramUUID)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    if (i == 1)
    {
      Object localObject = localTroopFileTransferManager.a(paramUUID);
      long l = 3145729L;
      if (localObject != null) {
        l = ((TroopFileStatusInfo)localObject).jdField_b_of_type_Long;
      }
      for (localObject = b(2131429780, new Object[] { TroopFileUtils.a(((TroopFileStatusInfo)localObject).g), TroopFileUtils.a(((TroopFileStatusInfo)localObject).jdField_b_of_type_Long) }); l > 3145728L; localObject = b(2131429781))
      {
        paramUUID = new ajeo(this, localTroopFileTransferManager, paramUUID);
        paramUUID = DialogUtil.b(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131429769), (String)localObject, 2131433015, 2131429735, paramUUID, paramUUID);
        localObject = CUOpenCardGuideMng.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, (String)localObject);
        if ((localObject instanceof SpannableString)) {
          paramUUID.setMessageWithoutAutoLink((CharSequence)localObject);
        }
        paramUUID.show();
        return;
      }
      localTroopFileTransferManager.e(paramUUID);
      return;
    }
    localTroopFileTransferManager.e(paramUUID);
  }
  
  public void c(TroopFileInfo paramTroopFileInfo)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    ThreadManager.post(new ajer(this, localTroopFileTransferManager), 8, new ajes(this, localTroopFileTransferManager, paramTroopFileInfo), false);
  }
  
  public void d(TroopFileInfo paramTroopFileInfo)
  {
    int i = a(false);
    Object localObject = new ajeh(this, paramTroopFileInfo);
    if (i == 1) {}
    for (paramTroopFileInfo = b(2131429780, new Object[] { TroopFileUtils.a(paramTroopFileInfo.jdField_c_of_type_JavaLangString), paramTroopFileInfo.a() });; paramTroopFileInfo = b(2131429785, new Object[] { TroopFileUtils.a(paramTroopFileInfo.jdField_c_of_type_JavaLangString) }))
    {
      localObject = DialogUtil.b(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131429773), paramTroopFileInfo, 2131433015, 2131429735, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      if (i == 1)
      {
        paramTroopFileInfo = CUOpenCardGuideMng.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramTroopFileInfo);
        if ((paramTroopFileInfo instanceof SpannableString)) {
          ((QQCustomDialog)localObject).setMessageWithoutAutoLink(paramTroopFileInfo);
        }
      }
      ((QQCustomDialog)localObject).show();
      return;
    }
  }
  
  public void e(TroopFileInfo paramTroopFileInfo)
  {
    boolean bool = false;
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null);
    String[] arrayOfString = this.jdField_a_of_type_AndroidAppActivity.getResources().getStringArray(2131296347);
    if (paramTroopFileInfo.jdField_e_of_type_Int == 11)
    {
      localActionSheet.a(arrayOfString[0], 1);
      bool = true;
    }
    if ((TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramTroopFileInfo.b()))) {
      localActionSheet.a(arrayOfString[1], 1);
    }
    localActionSheet.a(new ajei(this, bool, paramTroopFileInfo, localActionSheet));
    localActionSheet.c(2131433015);
    localActionSheet.show();
  }
  
  public void f(TroopFileInfo paramTroopFileInfo)
  {
    TroopFileStatusInfo localTroopFileStatusInfo2 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long).a(paramTroopFileInfo.jdField_b_of_type_JavaLangString);
    TroopFileStatusInfo localTroopFileStatusInfo1 = localTroopFileStatusInfo2;
    if (localTroopFileStatusInfo2 == null)
    {
      localTroopFileStatusInfo1 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long, paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID.toString(), paramTroopFileInfo.jdField_b_of_type_JavaLangString, paramTroopFileInfo.jdField_c_of_type_JavaLangString, paramTroopFileInfo.jdField_a_of_type_Long, paramTroopFileInfo.jdField_a_of_type_Int);
      localTroopFileStatusInfo1.jdField_c_of_type_JavaLangString = paramTroopFileInfo.j;
      localTroopFileStatusInfo1.d = paramTroopFileInfo.k;
      localTroopFileStatusInfo1.jdField_b_of_type_JavaLangString = paramTroopFileInfo.i;
    }
    if ((localTroopFileStatusInfo1 != null) && (localTroopFileStatusInfo1.jdField_b_of_type_Long == 0L)) {
      localTroopFileStatusInfo1.jdField_b_of_type_Long = paramTroopFileInfo.jdField_a_of_type_Long;
    }
    if ("/".equals(paramTroopFileInfo.f)) {}
    for (int i = 0;; i = 1)
    {
      a(localTroopFileStatusInfo1, String.valueOf(paramTroopFileInfo.jdField_b_of_type_Long), paramTroopFileInfo.jdField_c_of_type_Int, i);
      return;
    }
  }
  
  public void g(TroopFileInfo paramTroopFileInfo)
  {
    String str1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131429790);
    String str2 = String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131429805), new Object[] { TroopFileUtils.a(paramTroopFileInfo.jdField_c_of_type_JavaLangString) });
    QQCustomDialog localQQCustomDialog = DialogUtil.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localQQCustomDialog.setTitle(str1).setMessage(str2);
    localQQCustomDialog.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131433016), new ajej(this, paramTroopFileInfo));
    localQQCustomDialog.show();
  }
  
  public void h(TroopFileInfo paramTroopFileInfo)
  {
    if (a() != 0)
    {
      TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long).a(paramTroopFileInfo);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_trans_save", 0, 0, "", this.jdField_b_of_type_Long + "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation
 * JD-Core Version:    0.7.0.1
 */