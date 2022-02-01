package dov.com.qq.im.ae.gif;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import dov.com.qq.im.ae.data.AEGifMaterialManager;
import dov.com.qq.im.ae.util.AEQLog;

class AEGIFStickerListPart$10
  implements DialogInterface.OnCancelListener
{
  AEGIFStickerListPart$10(AEGIFStickerListPart paramAEGIFStickerListPart) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    AEQLog.a("AEGIFStickerListPart", "[mTakeSameLoadingDialog.onCancel]");
    AEGIFStickerListPart.a(this.a, null);
    AEGifMaterialManager.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.AEGIFStickerListPart.10
 * JD-Core Version:    0.7.0.1
 */