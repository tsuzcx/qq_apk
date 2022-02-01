package dov.com.qq.im.ae.play;

import android.app.Activity;
import bnju;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataRsp;
import com.tencent.common.app.AppInterface;

class EditTextViewer$4
  extends bnju
{
  EditTextViewer$4(EditTextViewer paramEditTextViewer, AppInterface paramAppInterface, String paramString) {}
  
  public void onGetFontData(boolean paramBoolean, GetFontDataRsp paramGetFontDataRsp)
  {
    this.val$app.removeObserver(this);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBoolean)
    {
      bool1 = bool2;
      if (paramGetFontDataRsp != null)
      {
        if (paramGetFontDataRsp.Code != 0) {
          break label74;
        }
        EditTextViewer.access$202(this.this$0, this.val$userValue);
        bool1 = true;
        EditTextViewer.access$300(this.this$0, paramGetFontDataRsp);
      }
    }
    for (;;)
    {
      EditTextViewer.access$900(this.this$0).runOnUiThread(new EditTextViewer.4.1(this, bool1));
      return;
      label74:
      if (paramGetFontDataRsp.Code == -10002)
      {
        EditTextViewer.access$400(this.this$0, 2131689781);
        bool1 = bool2;
      }
      else
      {
        EditTextViewer.access$400(this.this$0, 2131689783);
        bool1 = bool2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.EditTextViewer.4
 * JD-Core Version:    0.7.0.1
 */