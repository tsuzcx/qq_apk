package com.tencent.mobileqq.vas.updatesystem;

import android.text.TextUtils;
import bhdi;
import bhdo;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.QueryItemVersionCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.db.ItemLocalVerPrt;
import com.tencent.vas.update.util.CommonUtil;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;

public class VasUpdateEngineV2$1
  implements Runnable
{
  public VasUpdateEngineV2$1(bhdi parambhdi, VasQuickUpdateManager.QueryItemVersionCallback paramQueryItemVersionCallback, int paramInt, String paramString) {}
  
  public void run()
  {
    Object localObject = VasUpdateWrapper.getDbManager();
    if ((localObject == null) || (!(localObject instanceof bhdo)) || (this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$QueryItemVersionCallback == null))
    {
      QLog.e("VasUpdate_VasUpdateEngineV2", 1, "setWeakHandler cmdManager == null or != VasCmdImpl or callback == null");
      return;
    }
    localObject = ((bhdo)localObject).selectItem(0, CommonUtil.sComposeItemId(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString));
    if (QLog.isColorLevel()) {
      QLog.i("VasUpdate_VasUpdateEngineV2", 2, "queryItemVersion bid = " + this.jdField_a_of_type_Int + " , scid = " + this.jdField_a_of_type_JavaLangString);
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$QueryItemVersionCallback.onQueryItemVer(false, this.jdField_a_of_type_JavaLangString, "");
      return;
    }
    localObject = ItemLocalVerPrt.parseJsonToItemLocalVerPrt((String)localObject);
    if (localObject == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$QueryItemVersionCallback.onQueryItemVer(false, this.jdField_a_of_type_JavaLangString, "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$QueryItemVersionCallback.onQueryItemVer(true, this.jdField_a_of_type_JavaLangString, ((ItemLocalVerPrt)localObject).mMd5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.VasUpdateEngineV2.1
 * JD-Core Version:    0.7.0.1
 */