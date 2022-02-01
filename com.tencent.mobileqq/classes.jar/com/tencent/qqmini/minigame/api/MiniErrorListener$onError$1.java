package com.tencent.qqmini.minigame.api;

import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class MiniErrorListener$onError$1
  implements Runnable
{
  MiniErrorListener$onError$1(MiniErrorListener paramMiniErrorListener) {}
  
  public final void run()
  {
    MiniCustomDialog localMiniCustomDialog = DialogUtil.createCustomDialog(MiniErrorListener.access$getContext$p(this.this$0), 230, null, (CharSequence)GameWnsUtils.getGameErrorDialogContent(), "取消", "确定", (DialogInterface.OnClickListener)new MiniErrorListener.onError.1.dialog.1(this), (DialogInterface.OnClickListener)MiniErrorListener.onError.1.dialog.2.INSTANCE);
    localMiniCustomDialog.setCanceledOnTouchOutside(false);
    localMiniCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.api.MiniErrorListener.onError.1
 * JD-Core Version:    0.7.0.1
 */