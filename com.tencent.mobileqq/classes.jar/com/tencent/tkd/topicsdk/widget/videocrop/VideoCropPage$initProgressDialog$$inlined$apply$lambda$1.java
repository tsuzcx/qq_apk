package com.tencent.tkd.topicsdk.widget.videocrop;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel", "com/tencent/tkd/topicsdk/widget/videocrop/VideoCropPage$initProgressDialog$1$1"}, k=3, mv={1, 1, 16})
final class VideoCropPage$initProgressDialog$$inlined$apply$lambda$1
  implements DialogInterface.OnCancelListener
{
  VideoCropPage$initProgressDialog$$inlined$apply$lambda$1(VideoCropPage paramVideoCropPage) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    VideoCropPage.b(this.a).f();
    ThreadManagerKt.a((Function0)VideoCropPage.initProgressDialog.1.1.1.INSTANCE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.VideoCropPage.initProgressDialog..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */