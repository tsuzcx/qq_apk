package com.tencent.mobileqq.vas.updatesystem.business;

import com.tencent.mobileqq.vas.updatesystem.callback.RemoteVasUpdateListener;
import com.tencent.mobileqq.vas.updatesystem.entity.VasUpdateParcelableParams;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import com.tencent.vas.update.callback.listener.IUpdateListener;

class QQVasUpdateBusiness$1
  extends RemoteVasUpdateListener
{
  QQVasUpdateBusiness$1(QQVasUpdateBusiness paramQQVasUpdateBusiness) {}
  
  public void a(VasUpdateParcelableParams paramVasUpdateParcelableParams)
  {
    if (QQVasUpdateBusiness.a(this.a) != null) {
      QQVasUpdateBusiness.a(this.a).onLoadSuccess(QQVasUpdateBusinessUtil.a(paramVasUpdateParcelableParams));
    }
  }
  
  public void b(VasUpdateParcelableParams paramVasUpdateParcelableParams)
  {
    if (QQVasUpdateBusiness.a(this.a) != null) {
      QQVasUpdateBusiness.a(this.a).onLoadFail(QQVasUpdateBusinessUtil.a(paramVasUpdateParcelableParams));
    }
  }
  
  public void c(VasUpdateParcelableParams paramVasUpdateParcelableParams)
  {
    if (QQVasUpdateBusiness.a(this.a) != null) {
      QQVasUpdateBusiness.a(this.a).onProgress(QQVasUpdateBusinessUtil.a(paramVasUpdateParcelableParams));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness.1
 * JD-Core Version:    0.7.0.1
 */