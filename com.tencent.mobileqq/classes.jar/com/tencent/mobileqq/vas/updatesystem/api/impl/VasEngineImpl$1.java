package com.tencent.mobileqq.vas.updatesystem.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemVersionCallback;
import com.tencent.mobileqq.vas.updatesystem.impl.VasDbManagerImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.db.ItemLocalVerPrt;
import com.tencent.vas.update.util.CommonUtil;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;

class VasEngineImpl$1
  implements Runnable
{
  VasEngineImpl$1(VasEngineImpl paramVasEngineImpl, QueryItemVersionCallback paramQueryItemVersionCallback, int paramInt, String paramString) {}
  
  public void run()
  {
    Object localObject = VasUpdateWrapper.getDbManager();
    if ((localObject == null) || (!(localObject instanceof VasDbManagerImpl)) || (this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackQueryItemVersionCallback == null))
    {
      QLog.e("VasUpdate_VasUpdateEngineV2", 1, "setWeakHandler cmdManager == null or != VasCmdImpl or callback == null");
      return;
    }
    localObject = ((VasDbManagerImpl)localObject).selectItem(0, CommonUtil.sComposeItemId(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString));
    if (QLog.isColorLevel()) {
      QLog.i("VasUpdate_VasUpdateEngineV2", 2, "queryItemVersion bid = " + this.jdField_a_of_type_Int + " , scid = " + this.jdField_a_of_type_JavaLangString);
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackQueryItemVersionCallback.onQueryItemVer(false, this.jdField_a_of_type_JavaLangString, "");
      return;
    }
    localObject = ItemLocalVerPrt.parseJsonToItemLocalVerPrt((String)localObject);
    if (localObject == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackQueryItemVersionCallback.onQueryItemVer(false, this.jdField_a_of_type_JavaLangString, "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackQueryItemVersionCallback.onQueryItemVer(true, this.jdField_a_of_type_JavaLangString, ((ItemLocalVerPrt)localObject).mMd5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.api.impl.VasEngineImpl.1
 * JD-Core Version:    0.7.0.1
 */