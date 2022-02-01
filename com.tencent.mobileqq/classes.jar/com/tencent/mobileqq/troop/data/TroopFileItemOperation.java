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
  public Activity a;
  public long b;
  public QQAppInterface c;
  
  public TroopFileItemOperation(long paramLong, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.b = paramLong;
    this.c = paramQQAppInterface;
    this.a = paramActivity;
  }
  
  private int a()
  {
    return a(true);
  }
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return TroopFileUtils.a(this.c, this.a, this.b);
    }
    return TroopFileUtils.a(this.a);
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
    TroopFileTransferManager.a(this.c, this.b).a(paramFileManagerEntity);
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
      paramFileManagerEntity = b(2131895170, new Object[] { TroopFileUtils.a(paramFileManagerEntity.fileName), TroopFileUtils.a(paramFileManagerEntity.fileSize) });
      localObject = DialogUtil.a(this.a, 230, b(2131895386), paramFileManagerEntity, 2131887648, 2131916605, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      paramFileManagerEntity = CUOpenCardGuideMng.a(this.a, this.c, 2, paramFileManagerEntity);
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
    DialogUtil.a(this.a, 230, b(2131895060), b(2131895059), 2131887648, 2131892267, paramTroopFileInfo, paramTroopFileInfo).show();
  }
  
  public void a(TroopFileInfo paramTroopFileInfo, String paramString1, String paramString2)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.b(this.a, 230);
    localQQCustomDialog.setTitle(paramString1).setMessage(paramString2);
    paramString1 = (LinearLayout.LayoutParams)localQQCustomDialog.getMessageTextView().getLayoutParams();
    paramString1.gravity = 17;
    localQQCustomDialog.getMessageTextView().setLayoutParams(paramString1);
    localQQCustomDialog.setPositiveButton(this.a.getResources().getString(2131892267), new TroopFileItemOperation.14(this, paramTroopFileInfo));
    localQQCustomDialog.show();
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if (a() == 0) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.c, this.b);
    Object localObject = HWTroopUtils.a(paramString2);
    localObject = ((IQFileConfigManager)this.c.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig((String)localObject);
    if ((FileManagerUtil.b()) && (paramLong > ((DownloadFileConfig)localObject).b))
    {
      if (FreeWifiHelper.a(this.a, 1, new TroopFileItemOperation.2(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt)))
      {
        paramString1 = new TroopFileItemOperation.3(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt);
        paramString2 = b(2131895171, new Object[] { TroopFileUtils.a(paramString2), TroopFileUtils.a(paramLong) });
        paramString1 = DialogUtil.a(this.a, 230, b(2131895386), paramString2, 2131887648, 2131895106, paramString1, paramString1);
        paramString2 = CUOpenCardGuideMng.a(this.a, this.c, 2, paramString2);
        if ((paramString2 instanceof SpannableString)) {
          paramString1.setMessageWithoutAutoLink(paramString2);
        }
        paramString1.show();
      }
    }
    else {
      localTroopFileTransferManager.a(paramString1, paramString2, paramLong, paramInt);
    }
  }
  
  public void a(UUID paramUUID)
  {
    if (a() == 0) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.c, this.b);
    if (FileManagerUtil.b())
    {
      TroopFileItemOperation.1 local1 = new TroopFileItemOperation.1(this, localTroopFileTransferManager, paramUUID);
      paramUUID = localTroopFileTransferManager.g(paramUUID);
      if (paramUUID != null) {
        paramUUID = b(2131895175, new Object[] { TroopFileUtils.a(paramUUID.t), TroopFileUtils.a(paramUUID.i) });
      } else {
        paramUUID = b(2131895174);
      }
      DialogUtil.a(this.a, 230, b(2131895386), paramUUID, 2131887648, 2131895479, local1, local1).show();
      return;
    }
    localTroopFileTransferManager.c(paramUUID);
  }
  
  public void b(TroopFileInfo paramTroopFileInfo)
  {
    paramTroopFileInfo = new TroopFileItemOperation.8(this, paramTroopFileInfo);
    DialogUtil.a(this.a, 230, b(2131895056), b(2131895055), 2131887648, 2131892267, paramTroopFileInfo, paramTroopFileInfo).show();
  }
  
  public void b(UUID paramUUID)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.c, this.b);
    if (i == 1)
    {
      Object localObject2 = localTroopFileTransferManager.g(paramUUID);
      long l = 0L;
      Object localObject1;
      if (localObject2 != null)
      {
        l = ((TroopFileStatusInfo)localObject2).i;
        localObject1 = b(2131895173, new Object[] { TroopFileUtils.a(((TroopFileStatusInfo)localObject2).t), TroopFileUtils.a(((TroopFileStatusInfo)localObject2).i) });
        localObject2 = ((TroopFileStatusInfo)localObject2).t;
      }
      else
      {
        localObject1 = b(2131895172);
        localObject2 = "";
      }
      if (l > ((IQFileConfigManager)this.c.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(HWTroopUtils.a((String)localObject2)).b)
      {
        paramUUID = new TroopFileItemOperation.6(this, localTroopFileTransferManager, paramUUID);
        paramUUID = DialogUtil.a(this.a, 230, b(2131895386), (String)localObject1, 2131887648, 2131895475, paramUUID, paramUUID);
        localObject1 = CUOpenCardGuideMng.a(this.a, this.c, 2, (String)localObject1);
        if ((localObject1 instanceof SpannableString)) {
          paramUUID.setMessageWithoutAutoLink((CharSequence)localObject1);
        }
        paramUUID.show();
        return;
      }
      localTroopFileTransferManager.d(paramUUID);
      return;
    }
    localTroopFileTransferManager.d(paramUUID);
  }
  
  public void c(TroopFileInfo paramTroopFileInfo)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.c, this.b);
    ThreadManager.post(new TroopFileItemOperation.9(this, localTroopFileTransferManager), 8, new TroopFileItemOperation.10(this, localTroopFileTransferManager, paramTroopFileInfo), false);
  }
  
  public void d(TroopFileInfo paramTroopFileInfo)
  {
    int i = a(false);
    Object localObject = new TroopFileItemOperation.11(this, paramTroopFileInfo);
    if (i == 1) {
      paramTroopFileInfo = b(2131895173, new Object[] { TroopFileUtils.a(paramTroopFileInfo.d), paramTroopFileInfo.a() });
    } else {
      paramTroopFileInfo = b(2131895477, new Object[] { TroopFileUtils.a(paramTroopFileInfo.d) });
    }
    localObject = DialogUtil.a(this.a, 230, b(2131895476), paramTroopFileInfo, 2131887648, 2131895475, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    if (i == 1)
    {
      paramTroopFileInfo = CUOpenCardGuideMng.a(this.a, this.c, 2, paramTroopFileInfo);
      if ((paramTroopFileInfo instanceof SpannableString)) {
        ((QQCustomDialog)localObject).setMessageWithoutAutoLink(paramTroopFileInfo);
      }
    }
    ((QQCustomDialog)localObject).show();
  }
  
  public void e(TroopFileInfo paramTroopFileInfo)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.a, null);
    String[] arrayOfString = this.a.getResources().getStringArray(2130968674);
    int i = paramTroopFileInfo.p;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i == 11)
    {
      bool1 = bool2;
      if (FileUtil.b(paramTroopFileInfo.t))
      {
        localActionSheet.addButton(arrayOfString[0], 1);
        bool1 = true;
      }
    }
    if ((TroopFileUtils.a(this.c, this.b)) || (this.c.getCurrentAccountUin().equals(paramTroopFileInfo.b()))) {
      localActionSheet.addButton(arrayOfString[1], 1);
    }
    localActionSheet.setOnButtonClickListener(new TroopFileItemOperation.12(this, bool1, paramTroopFileInfo, localActionSheet));
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.show();
  }
  
  public TroopFileStatusInfo f(TroopFileInfo paramTroopFileInfo)
  {
    TroopFileStatusInfo localTroopFileStatusInfo2 = TroopFileTransferManager.a(this.c, this.b).a(paramTroopFileInfo.c);
    TroopFileStatusInfo localTroopFileStatusInfo1 = localTroopFileStatusInfo2;
    if (localTroopFileStatusInfo2 == null)
    {
      localTroopFileStatusInfo1 = TroopFileUtils.a(this.c, this.b, paramTroopFileInfo.b.toString(), paramTroopFileInfo.c, paramTroopFileInfo.d, paramTroopFileInfo.e, paramTroopFileInfo.f);
      localTroopFileStatusInfo1.m = paramTroopFileInfo.x;
      localTroopFileStatusInfo1.n = paramTroopFileInfo.y;
      localTroopFileStatusInfo1.l = paramTroopFileInfo.w;
    }
    if ((localTroopFileStatusInfo1 != null) && (localTroopFileStatusInfo1.i == 0L)) {
      localTroopFileStatusInfo1.i = paramTroopFileInfo.e;
    }
    return localTroopFileStatusInfo1;
  }
  
  public int g(TroopFileInfo paramTroopFileInfo)
  {
    return "/".equals(paramTroopFileInfo.o) ^ true;
  }
  
  public void h(TroopFileInfo paramTroopFileInfo)
  {
    String str1 = this.a.getString(2131895117);
    String str2 = String.format(this.a.getString(2131895103), new Object[] { TroopFileUtils.a(paramTroopFileInfo.d) });
    QQCustomDialog localQQCustomDialog = DialogUtil.b(this.a, 230);
    localQQCustomDialog.setTitle(str1).setMessage(str2);
    localQQCustomDialog.setPositiveButton(this.a.getString(2131892267), new TroopFileItemOperation.13(this, paramTroopFileInfo));
    localQQCustomDialog.show();
  }
  
  public void i(TroopFileInfo paramTroopFileInfo)
  {
    if (a() != 0)
    {
      TroopFileManager.a(this.c, this.b).c(paramTroopFileInfo);
      paramTroopFileInfo = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append("");
      ReportController.b(paramTroopFileInfo, "CliOper", "", "", "Grp", "Clk_trans_save", 0, 0, "", localStringBuilder.toString(), "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation
 * JD-Core Version:    0.7.0.1
 */