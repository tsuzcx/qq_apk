package com.tencent.mobileqq.weiyun.api.impl;

import android.os.Bundle;
import android.os.Process;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.service.message.MessageCache;

class WeiyunGrayTipHelperImpl$1
  implements Runnable
{
  WeiyunGrayTipHelperImpl$1(WeiyunGrayTipHelperImpl paramWeiyunGrayTipHelperImpl, AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, String paramString5) {}
  
  public void run()
  {
    if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
      return;
    }
    Process.setThreadPriority(10);
    UniteGrayTipParam localUniteGrayTipParam = new UniteGrayTipParam(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.jdField_a_of_type_Int, -5023, 2424833, MessageCache.a());
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("key_action", 1);
    ((Bundle)localObject).putString("key_action_DATA", this.d);
    int i = this.jdField_b_of_type_Int;
    localUniteGrayTipParam.a(i, this.e.length() + i, (Bundle)localObject);
    localObject = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject).initGrayTipMsg((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, localUniteGrayTipParam);
    UniteGrayTipMsgUtil.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, (MessageForUniteGrayTip)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.impl.WeiyunGrayTipHelperImpl.1
 * JD-Core Version:    0.7.0.1
 */