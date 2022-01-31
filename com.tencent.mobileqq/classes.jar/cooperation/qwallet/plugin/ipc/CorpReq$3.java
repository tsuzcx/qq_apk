package cooperation.qwallet.plugin.ipc;

import android.graphics.Bitmap;
import android.os.Bundle;
import baxz;
import com.tencent.mobileqq.app.QQAppInterface;

class CorpReq$3
  implements baxz
{
  CorpReq$3(CorpReq paramCorpReq, QQAppInterface paramQQAppInterface, String paramString, CorpResp paramCorpResp) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramString = this.val$appInterface.a(paramInt2, this.val$strUin, 0);
    paramBitmap = new Bundle();
    paramBitmap.putString("avatar_path", paramString);
    this.val$resp.toBundle(paramBitmap);
    this.this$0.doCallback(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.CorpReq.3
 * JD-Core Version:    0.7.0.1
 */