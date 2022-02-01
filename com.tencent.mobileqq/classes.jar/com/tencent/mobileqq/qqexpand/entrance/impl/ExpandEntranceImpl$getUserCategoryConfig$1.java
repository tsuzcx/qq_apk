package com.tencent.mobileqq.qqexpand.entrance.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqexpand.manager.config.ExpandConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ExpandEntranceImpl$getUserCategoryConfig$1
  implements Runnable
{
  ExpandEntranceImpl$getUserCategoryConfig$1(AppInterface paramAppInterface) {}
  
  public final void run()
  {
    AppInterface localAppInterface = this.a;
    if (localAppInterface == null)
    {
      QLog.d("ExpandEntranceImpl", 1, "getUserCategoryConfig app is empty");
      return;
    }
    if (localAppInterface != null)
    {
      new ExpandConfigManager((QQAppInterface)localAppInterface).b();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.entrance.impl.ExpandEntranceImpl.getUserCategoryConfig.1
 * JD-Core Version:    0.7.0.1
 */