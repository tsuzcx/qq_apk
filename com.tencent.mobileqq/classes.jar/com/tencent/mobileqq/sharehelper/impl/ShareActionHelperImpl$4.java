package com.tencent.mobileqq.sharehelper.impl;

import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;

class ShareActionHelperImpl$4
  implements WXShareHelper.WXShareListener
{
  ShareActionHelperImpl$4(ShareActionHelperImpl paramShareActionHelperImpl, String paramString1, WXShareHelper.WXShareListener[] paramArrayOfWXShareListener, String paramString2, int paramInt) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((paramBaseResp != null) && (paramBaseResp.transaction != null))
    {
      if (!paramBaseResp.transaction.equals(this.jdField_a_of_type_JavaLangString))
      {
        QLog.e("ShareActionHelperImpl", 1, "onWXShareResp: mWXTransaction is wrong");
        return;
      }
      WXShareHelper.a().b(this.jdField_a_of_type_ArrayOfComTencentMobileqqWxapiWXShareHelper$WXShareListener[0]);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqWxapiWXShareHelper$WXShareListener[0] = null;
      int i = paramBaseResp.errCode;
      if (i != -2)
      {
        if (i != 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqSharehelperImplShareActionHelperImpl.dispatchHandleWXPicRespDenied(this.b, this.jdField_a_of_type_Int);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqSharehelperImplShareActionHelperImpl.dispatchHandleWXPicRespOK(this.b, this.jdField_a_of_type_Int);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqSharehelperImplShareActionHelperImpl.dispatchHandleWXPicRespCancel(this.b, this.jdField_a_of_type_Int);
      return;
    }
    QLog.e("ShareActionHelperImpl", 1, "onWXShareResp: respData is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.sharehelper.impl.ShareActionHelperImpl.4
 * JD-Core Version:    0.7.0.1
 */