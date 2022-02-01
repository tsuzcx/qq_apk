package com.tencent.mobileqq.filemanager.multioperate;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class TroopFileMultiOperate
  implements IQFileMultiOperate<TroopFileInfo>
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public TroopFileMultiOperate(QQAppInterface paramQQAppInterface, Activity paramActivity, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void a(List<TroopFileInfo> paramList)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopFileInfo localTroopFileInfo = (TroopFileInfo)paramList.next();
      TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, localTroopFileInfo.jdField_a_of_type_JavaUtilUUID.toString(), localTroopFileInfo.jdField_b_of_type_JavaLangString, localTroopFileInfo.jdField_c_of_type_JavaLangString, localTroopFileInfo.jdField_a_of_type_Long, localTroopFileInfo.jdField_a_of_type_Int);
      if ((localTroopFileStatusInfo != null) && (localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID != null) && ((localTroopFileStatusInfo.jdField_b_of_type_Int == 10) || (localTroopFileStatusInfo.jdField_b_of_type_Int == 9))) {
        localTroopFileTransferManager.c(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
      } else {
        localTroopFileTransferManager.a(localTroopFileInfo.jdField_b_of_type_JavaLangString, localTroopFileInfo.jdField_c_of_type_JavaLangString, localTroopFileInfo.jdField_a_of_type_Long, localTroopFileInfo.jdField_a_of_type_Int);
      }
    }
  }
  
  private void a(List<TroopFileInfo> paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    if (paramList == null)
    {
      QLog.w("TroopFileMultiOperate", 1, "fileList == null");
      return;
    }
    int i = 0;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramQFileMultiOperateCallback = (TroopFileInfo)paramList.next();
      Object localObject = new TroopFileStatusInfo();
      ((TroopFileStatusInfo)localObject).g = paramQFileMultiOperateCallback.jdField_c_of_type_JavaLangString;
      ((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaLangString = paramQFileMultiOperateCallback.i;
      ((TroopFileStatusInfo)localObject).jdField_c_of_type_Long = paramQFileMultiOperateCallback.jdField_a_of_type_Long;
      ((TroopFileStatusInfo)localObject).jdField_d_of_type_Long = paramQFileMultiOperateCallback.jdField_d_of_type_Long;
      ((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaUtilUUID = paramQFileMultiOperateCallback.jdField_a_of_type_JavaUtilUUID;
      ((TroopFileStatusInfo)localObject).jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      ((TroopFileStatusInfo)localObject).h = paramQFileMultiOperateCallback.jdField_a_of_type_Int;
      ((TroopFileStatusInfo)localObject).e = paramQFileMultiOperateCallback.jdField_b_of_type_JavaLangString;
      ((TroopFileStatusInfo)localObject).f = paramQFileMultiOperateCallback.jdField_d_of_type_JavaLangString;
      ((TroopFileStatusInfo)localObject).jdField_b_of_type_JavaLangString = paramQFileMultiOperateCallback.j;
      ((TroopFileStatusInfo)localObject).jdField_c_of_type_JavaLangString = paramQFileMultiOperateCallback.k;
      ((TroopFileStatusInfo)localObject).jdField_d_of_type_JavaLangString = paramQFileMultiOperateCallback.l;
      ((TroopFileStatusInfo)localObject).jdField_b_of_type_Int = paramQFileMultiOperateCallback.e;
      TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaUtilUUID);
      localObject = FileManagerUtil.a((TroopFileStatusInfo)localObject);
      if (paramQFileMultiOperateCallback.jdField_b_of_type_Long != 0L)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramQFileMultiOperateCallback.jdField_b_of_type_Long);
        ((FileManagerEntity)localObject).selfUin = localStringBuilder.toString();
      }
      if (paramQFileMultiOperateCallback.jdField_c_of_type_Int != 0) {
        ((FileManagerEntity)localObject).lastTime = paramQFileMultiOperateCallback.jdField_c_of_type_Int;
      }
      ((FileManagerEntity)localObject).bSend = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equals(((FileManagerEntity)localObject).selfUin);
      if (!new QfavBuilder(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject, null, false)) {
        i = 1;
      }
    }
    if (i != 0) {
      FileManagerUtil.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131698195));
    }
  }
  
  private void b(List<TroopFileInfo> paramList)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694475, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299168));
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    while (localIterator.hasNext())
    {
      Object localObject = (TroopFileInfo)localIterator.next();
      localObject = QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, (TroopFileInfo)localObject);
      if (localObject != null) {
        bool = QFileUtils.a(false, ((TroopFileStatusInfo)localObject).jdField_c_of_type_Long, ((TroopFileStatusInfo)localObject).e);
      }
    }
    if (bool)
    {
      FMDialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131692561, 2131692566, new TroopFileMultiOperate.3(this, paramList));
      return;
    }
    QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long);
  }
  
  private void b(List<TroopFileInfo> paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    if (TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long) == 0) {
      return;
    }
    paramQFileMultiOperateCallback = TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    if (paramQFileMultiOperateCallback == null) {
      return;
    }
    int i = 0;
    boolean bool1 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopFileInfo localTroopFileInfo = (TroopFileInfo)paramList.next();
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localTroopFileInfo.b());
      if ((localTroopFileInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, true)) && ((bool2) || (bool1)))
      {
        paramQFileMultiOperateCallback.b(localTroopFileInfo);
        i = 1;
      }
    }
    if (bool1)
    {
      FMToastUtil.b(2131692404);
      return;
    }
    if (i != 0)
    {
      FMToastUtil.b(2131692406);
      return;
    }
    FMToastUtil.c(2131692405);
  }
  
  private void c(List<TroopFileInfo> paramList)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694475, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299168));
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    while (localIterator.hasNext())
    {
      Object localObject = (TroopFileInfo)localIterator.next();
      localObject = QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, (TroopFileInfo)localObject);
      if (localObject != null) {
        bool = QFileUtils.a(false, ((TroopFileStatusInfo)localObject).jdField_c_of_type_Long, ((TroopFileStatusInfo)localObject).e);
      }
    }
    if (bool)
    {
      if (FreeWifiHelper.a(this.jdField_a_of_type_AndroidAppActivity, 5, new TroopFileMultiOperate.4(this, paramList))) {
        FMDialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131692561, 2131692564, new TroopFileMultiOperate.5(this, paramList));
      }
    }
    else
    {
      FMToastUtil.d(this.jdField_a_of_type_AndroidAppActivity.getString(2131692690));
      TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, paramList);
    }
  }
  
  private void c(List<TroopFileInfo> paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694475, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299168));
      return;
    }
    long l = 0L;
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext()) {
      l += ((TroopFileInfo)((Iterator)localObject).next()).jdField_a_of_type_Long;
    }
    TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    if ((FileManagerUtil.a()) && (l > 3145728L))
    {
      if (FreeWifiHelper.a(this.jdField_a_of_type_AndroidAppActivity, 1, new TroopFileMultiOperate.1(this, paramList, paramQFileMultiOperateCallback)))
      {
        paramList = new TroopFileMultiOperate.2(this, paramList, paramQFileMultiOperateCallback);
        paramQFileMultiOperateCallback = this.jdField_a_of_type_AndroidAppActivity.getString(2131697397);
        localObject = this.jdField_a_of_type_AndroidAppActivity;
        DialogUtil.a((Context)localObject, 230, ((Activity)localObject).getString(2131697613), paramQFileMultiOperateCallback, 2131690728, 2131697333, paramList, paramList).show();
      }
    }
    else
    {
      a(paramList);
      if (paramQFileMultiOperateCallback != null) {
        paramQFileMultiOperateCallback.a(1, 0);
      }
    }
  }
  
  public void a(List<TroopFileInfo> paramList, int paramInt, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doFileMultiOperate. operateType[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.i("TroopFileMultiOperate", 1, localStringBuilder.toString());
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return;
              }
              a(paramList, paramQFileMultiOperateCallback);
              return;
            }
            c(paramList);
            return;
          }
          b(paramList, paramQFileMultiOperateCallback);
          return;
        }
        b(paramList);
        return;
      }
      c(paramList, paramQFileMultiOperateCallback);
      return;
    }
    QLog.i("TroopFileMultiOperate", 1, "doFileMultiOperate. file list is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multioperate.TroopFileMultiOperate
 * JD-Core Version:    0.7.0.1
 */