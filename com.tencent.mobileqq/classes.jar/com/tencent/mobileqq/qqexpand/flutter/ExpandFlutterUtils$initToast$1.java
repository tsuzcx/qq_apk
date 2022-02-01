package com.tencent.mobileqq.qqexpand.flutter;

import android.content.Context;
import com.qflutter.qflutter_qtoast.QFlutterToast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/qqexpand/flutter/ExpandFlutterUtils$initToast$1", "Lcom/qflutter/qflutter_qtoast/QFlutterToast;", "error", "", "msg", "", "show", "success", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandFlutterUtils$initToast$1
  implements QFlutterToast
{
  public void error(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "msg");
    QQToast.a((Context)BaseApplicationImpl.context, 1, (CharSequence)paramString, 0).a();
  }
  
  public void show(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "msg");
    QQToast.a((Context)BaseApplicationImpl.context, 0, (CharSequence)paramString, 0).a();
  }
  
  public void success(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "msg");
    QQToast.a((Context)BaseApplicationImpl.context, 2, (CharSequence)paramString, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.ExpandFlutterUtils.initToast.1
 * JD-Core Version:    0.7.0.1
 */