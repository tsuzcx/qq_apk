package com.tencent.mobileqq.emosm;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emoticonview.EmotionKeywordAdapter;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

class AIOEmoticonUIHelper$3
  extends EmoticonObserver
{
  AIOEmoticonUIHelper$3(AIOEmoticonUIHelper paramAIOEmoticonUIHelper) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject = this.a.a();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((AIOEmoticonUIHelper.a(this.a) == null) || (paramObject == null) || (localObject == null) || (((BaseChatPie)localObject).jdField_a_of_type_ComTencentWidgetXEditTextEx == null));
        localObject = ((BaseChatPie)localObject).jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
        paramObject = (EmoticonResp)paramObject;
        AIOEmoticonUIHelper.a(this.a).handleCloudEmotionForKeywordResp(paramBoolean, paramInt, paramObject, (String)localObject);
        return;
      } while (localObject == null);
      if ((((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        ((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
    } while (paramObject == null);
    EmoticonResp localEmoticonResp = (EmoticonResp)paramObject;
    int i;
    if (paramBoolean)
    {
      i = localEmoticonResp.delEpId;
      if ((localEmoticonResp.keySeq == null) || (localEmoticonResp.keySeq.equals(""))) {
        paramObject = HardCodeUtil.a(2131701063);
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localEmoticonResp.emoticonId)) {
        break label248;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.a.getTag(), 2, "auth type emoticon id is null");
      return;
      paramObject = localEmoticonResp.keySeq;
      continue;
      paramObject = HardCodeUtil.a(2131701048);
      i = -404;
    }
    label248:
    ((EmoticonManager)((BaseChatPie)localObject).a().getManager(QQManagerFactory.EMOTICON_MANAGER)).a(String.valueOf(localEmoticonResp.epId), localEmoticonResp.emoticonId, new AIOEmoticonUIHelper.3.1(this, paramInt, i, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.AIOEmoticonUIHelper.3
 * JD-Core Version:    0.7.0.1
 */