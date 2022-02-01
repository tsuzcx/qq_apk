package com.tencent.mobileqq.qqexpand.entrance.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qqexpand.config.IConfigCallback;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.utils.ExpandSharePreUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Ref.LongRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ExpandEntranceImpl$checkABTestPassTime$1
  implements Runnable
{
  ExpandEntranceImpl$checkABTestPassTime$1(ExpandEntranceImpl paramExpandEntranceImpl, AppInterface paramAppInterface) {}
  
  public final void run()
  {
    Object localObject = this.a.getCurrentAccountUin();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.d("ExpandEntranceImpl", 1, "checkABTestPassTime uin is empty");
      return;
    }
    if (!ExpandSharePreUtils.b((String)localObject))
    {
      ExpandSharePreUtils.a((String)localObject, System.currentTimeMillis());
      localObject = this.a.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (localObject != null)
      {
        localObject = (IExpandManager)localObject;
        Ref.LongRef localLongRef = new Ref.LongRef();
        localLongRef.element = System.currentTimeMillis();
        ExpandEntranceImpl.access$reportData(this.this$0, "expand_quality#exp_info#exp_request", null);
        ((IExpandManager)localObject).a((IConfigCallback)new ExpandEntranceImpl.checkABTestPassTime.1.1(this, localLongRef));
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.qqexpand.manager.IExpandManager");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.entrance.impl.ExpandEntranceImpl.checkABTestPassTime.1
 * JD-Core Version:    0.7.0.1
 */