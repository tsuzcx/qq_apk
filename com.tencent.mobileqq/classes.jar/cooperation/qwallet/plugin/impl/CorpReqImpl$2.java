package cooperation.qwallet.plugin.impl;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import cooperation.qwallet.plugin.ipc.CorpReq.ICallBack;
import cooperation.qwallet.plugin.ipc.CorpResp;

class CorpReqImpl$2
  implements DecodeTaskCompletionListener
{
  CorpReqImpl$2(CorpReqImpl paramCorpReqImpl, AppInterface paramAppInterface, String paramString, CorpResp paramCorpResp, CorpReq.ICallBack paramICallBack) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramBitmap = CorpReqImpl.access$000(this.this$0, this.val$appInterface, paramInt2, this.val$strUin, 0);
    paramString = new Bundle();
    paramString.putString("avatar_path", paramBitmap);
    this.val$resp.toBundle(paramString);
    paramBitmap = this.val$listener;
    if (paramBitmap != null) {
      paramBitmap.callBack(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qwallet.plugin.impl.CorpReqImpl.2
 * JD-Core Version:    0.7.0.1
 */