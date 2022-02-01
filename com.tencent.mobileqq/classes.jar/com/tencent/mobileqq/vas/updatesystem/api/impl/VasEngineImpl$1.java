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
    if ((localObject != null) && ((localObject instanceof VasDbManagerImpl)) && (this.a != null))
    {
      localObject = ((VasDbManagerImpl)localObject).a(0, CommonUtil.sComposeItemId(this.b, this.c));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("queryItemVersion bid = ");
        localStringBuilder.append(this.b);
        localStringBuilder.append(" , scid = ");
        localStringBuilder.append(this.c);
        QLog.i("VasUpdate_VasUpdateEngineV2", 2, localStringBuilder.toString());
      }
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.a.onQueryItemVer(false, this.c, "");
        return;
      }
      localObject = ItemLocalVerPrt.parseJsonToItemLocalVerPrt((String)localObject);
      if (localObject == null)
      {
        this.a.onQueryItemVer(false, this.c, "");
        return;
      }
      this.a.onQueryItemVer(true, this.c, ((ItemLocalVerPrt)localObject).mMd5);
      return;
    }
    QLog.e("VasUpdate_VasUpdateEngineV2", 1, "setWeakHandler cmdManager == null or != VasCmdImpl or callback == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.api.impl.VasEngineImpl.1
 * JD-Core Version:    0.7.0.1
 */