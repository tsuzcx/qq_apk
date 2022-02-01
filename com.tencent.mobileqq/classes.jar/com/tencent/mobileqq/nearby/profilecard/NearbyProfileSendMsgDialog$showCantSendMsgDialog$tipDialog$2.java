package com.tencent.mobileqq.nearby.profilecard;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k=3, mv={1, 1, 16})
final class NearbyProfileSendMsgDialog$showCantSendMsgDialog$tipDialog$2
  implements DialogInterface.OnClickListener
{
  NearbyProfileSendMsgDialog$showCantSendMsgDialog$tipDialog$2(NearbyProfileSendMsgDialog paramNearbyProfileSendMsgDialog) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    NearbyProfileSendMsgDialog.Companion.a(NearbyProfileSendMsgDialog.a, (Function1)new NearbyProfileSendMsgDialog.showCantSendMsgDialog.tipDialog.2.1(this));
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileSendMsgDialog.showCantSendMsgDialog.tipDialog.2
 * JD-Core Version:    0.7.0.1
 */