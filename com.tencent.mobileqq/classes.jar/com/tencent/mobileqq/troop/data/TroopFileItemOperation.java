package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.SpannableString;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.data.DownloadFileConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.UUID;

public class TroopFileItemOperation
{
  public long a;
  public Activity a;
  public QQAppInterface a;
  
  public TroopFileItemOperation(long paramLong, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_Long = paramLong;
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
      return TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long);
    }
    return TroopFileUtils.a(this.jdField_a_of_type_AndroidAppActivity);
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
    TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(paramFileManagerEntity);
  }
  
  public int a(TroopFileInfo paramTroopFileInfo)
  {
    if ("/".equals(paramTroopFileInfo.g)) {
      return 0;
    }
    return 1;
  }
  
  public TroopFileStatusInfo a(TroopFileInfo paramTroopFileInfo)
  {
    TroopFileStatusInfo localTroopFileStatusInfo2 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(paramTroopFileInfo.b);
    TroopFileStatusInfo localTroopFileStatusInfo1 = localTroopFileStatusInfo2;
    if (localTroopFileStatusInfo2 == null)
    {
      localTroopFileStatusInfo1 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID.toString(), paramTroopFileInfo.b, paramTroopFileInfo.jdField_c_of_type_JavaLangString, paramTroopFileInfo.jdField_a_of_type_Long, paramTroopFileInfo.jdField_a_of_type_Int);
      localTroopFileStatusInfo1.jdField_c_of_type_JavaLangString = paramTroopFileInfo.k;
      localTroopFileStatusInfo1.d = paramTroopFileInfo.l;
      localTroopFileStatusInfo1.b = paramTroopFileInfo.j;
    }
    if ((localTroopFileStatusInfo1 != null) && (localTroopFileStatusInfo1.jdField_c_of_type_Long == 0L)) {
      localTroopFileStatusInfo1.jdField_c_of_type_Long = paramTroopFileInfo.jdField_a_of_type_Long;
    }
    return localTroopFileStatusInfo1;
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    if ((i == 1) && (paramFileManagerEntity.fileSize > 3145728L))
    {
      Object localObject = new TroopFileItemOperation.4(this, paramFileManagerEntity);
      paramFileManagerEntity = b(2131697378, new Object[] { TroopFileUtils.a(paramFileManagerEntity.fileName), TroopFileUtils.a(paramFileManagerEntity.fileSize) });
      localObject = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697607), paramFileManagerEntity, 2131690800, 2131719351, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
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
    paramTroopFileInfo = new TroopFileItemOperation.7(this, paramTroopFileInfo);
    DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697268), b(2131697267), 2131690800, 2131694615, paramTroopFileInfo, paramTroopFileInfo).show();
  }
  
  public void a(TroopFileInfo paramTroopFileInfo, String paramString1, String paramString2)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localQQCustomDialog.setTitle(paramString1).setMessage(paramString2);
    paramString1 = (LinearLayout.LayoutParams)localQQCustomDialog.getMessageTextView().getLayoutParams();
    paramString1.gravity = 17;
    localQQCustomDialog.getMessageTextView().setLayoutParams(paramString1);
    localQQCustomDialog.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131694615), new TroopFileItemOperation.14(this, paramTroopFileInfo));
    localQQCustomDialog.show();
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if (a() == 0) {}
    TroopFileTransferManager localTroopFileTransferManager;
    do
    {
      return;
      localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
      Object localObject = HWTroopUtils.a(paramString2);
      localObject = ((IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig((String)localObject);
      if ((!FileManagerUtil.a()) || (paramLong <= ((DownloadFileConfig)localObject).b)) {
        break;
      }
    } while (!FreeWifiHelper.a(this.jdField_a_of_type_AndroidAppActivity, 1, new TroopFileItemOperation.2(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt)));
    paramString1 = new TroopFileItemOperation.3(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt);
    paramString2 = b(2131697379, new Object[] { TroopFileUtils.a(paramString2), TroopFileUtils.a(paramLong) });
    paramString1 = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697607), paramString2, 2131690800, 2131697314, paramString1, paramString1);
    paramString2 = CUOpenCardGuideMng.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramString2);
    if ((paramString2 instanceof SpannableString)) {
      paramString1.setMessageWithoutAutoLink(paramString2);
    }
    paramString1.show();
    return;
    localTroopFileTransferManager.a(paramString1, paramString2, paramLong, paramInt);
  }
  
  public void a(UUID paramUUID)
  {
    if (a() == 0) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    if (FileManagerUtil.a())
    {
      TroopFileItemOperation.1 local1 = new TroopFileItemOperation.1(this, localTroopFileTransferManager, paramUUID);
      paramUUID = localTroopFileTransferManager.a(paramUUID);
      if (paramUUID != null) {}
      for (paramUUID = b(2131697383, new Object[] { TroopFileUtils.a(paramUUID.g), TroopFileUtils.a(paramUUID.jdField_c_of_type_Long) });; paramUUID = b(2131697382))
      {
        DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697607), paramUUID, 2131690800, 2131697700, local1, local1).show();
        return;
      }
    }
    localTroopFileTransferManager.b(paramUUID);
  }
  
  public void b(TroopFileInfo paramTroopFileInfo)
  {
    paramTroopFileInfo = new TroopFileItemOperation.8(this, paramTroopFileInfo);
    DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697264), b(2131697263), 2131690800, 2131694615, paramTroopFileInfo, paramTroopFileInfo).show();
  }
  
  public void b(UUID paramUUID)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    if (i == 1)
    {
      Object localObject2 = localTroopFileTransferManager.a(paramUUID);
      long l;
      Object localObject1;
      if (localObject2 != null)
      {
        l = ((TroopFileStatusInfo)localObject2).jdField_c_of_type_Long;
        localObject1 = b(2131697381, new Object[] { TroopFileUtils.a(((TroopFileStatusInfo)localObject2).g), TroopFileUtils.a(((TroopFileStatusInfo)localObject2).jdField_c_of_type_Long) });
      }
      for (localObject2 = ((TroopFileStatusInfo)localObject2).g; l > ((IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(HWTroopUtils.a((String)localObject2)).b; localObject2 = "")
      {
        paramUUID = new TroopFileItemOperation.6(this, localTroopFileTransferManager, paramUUID);
        paramUUID = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697607), (String)localObject1, 2131690800, 2131697696, paramUUID, paramUUID);
        localObject1 = CUOpenCardGuideMng.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, (String)localObject1);
        if ((localObject1 instanceof SpannableString)) {
          paramUUID.setMessageWithoutAutoLink((CharSequence)localObject1);
        }
        paramUUID.show();
        return;
        localObject1 = b(2131697380);
        l = 0L;
      }
      localTroopFileTransferManager.c(paramUUID);
      return;
    }
    localTroopFileTransferManager.c(paramUUID);
  }
  
  public void c(TroopFileInfo paramTroopFileInfo)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    ThreadManager.post(new TroopFileItemOperation.9(this, localTroopFileTransferManager), 8, new TroopFileItemOperation.10(this, localTroopFileTransferManager, paramTroopFileInfo), false);
  }
  
  public void d(TroopFileInfo paramTroopFileInfo)
  {
    int i = a(false);
    Object localObject = new TroopFileItemOperation.11(this, paramTroopFileInfo);
    if (i == 1) {}
    for (paramTroopFileInfo = b(2131697381, new Object[] { TroopFileUtils.a(paramTroopFileInfo.jdField_c_of_type_JavaLangString), paramTroopFileInfo.a() });; paramTroopFileInfo = b(2131697698, new Object[] { TroopFileUtils.a(paramTroopFileInfo.jdField_c_of_type_JavaLangString) }))
    {
      localObject = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697697), paramTroopFileInfo, 2131690800, 2131697696, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
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
    boolean bool2 = false;
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null);
    String[] arrayOfString = this.jdField_a_of_type_AndroidAppActivity.getResources().getStringArray(2130968671);
    boolean bool1 = bool2;
    if (paramTroopFileInfo.e == 11)
    {
      bool1 = bool2;
      if (FileUtil.b(paramTroopFileInfo.i))
      {
        localActionSheet.addButton(arrayOfString[0], 1);
        bool1 = true;
      }
    }
    if ((TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramTroopFileInfo.b()))) {
      localActionSheet.addButton(arrayOfString[1], 1);
    }
    localActionSheet.setOnButtonClickListener(new TroopFileItemOperation.12(this, bool1, paramTroopFileInfo, localActionSheet));
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.show();
  }
  
  public void f(TroopFileInfo paramTroopFileInfo)
  {
    String str1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131697325);
    String str2 = String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131697311), new Object[] { TroopFileUtils.a(paramTroopFileInfo.jdField_c_of_type_JavaLangString) });
    QQCustomDialog localQQCustomDialog = DialogUtil.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localQQCustomDialog.setTitle(str1).setMessage(str2);
    localQQCustomDialog.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131694615), new TroopFileItemOperation.13(this, paramTroopFileInfo));
    localQQCustomDialog.show();
  }
  
  public void g(TroopFileInfo paramTroopFileInfo)
  {
    if (a() != 0)
    {
      TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(paramTroopFileInfo);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_trans_save", 0, 0, "", this.jdField_a_of_type_Long + "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation
 * JD-Core Version:    0.7.0.1
 */