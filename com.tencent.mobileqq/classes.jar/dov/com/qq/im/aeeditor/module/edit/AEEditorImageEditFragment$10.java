package dov.com.qq.im.aeeditor.module.edit;

import dov.com.qq.im.ae.util.AEQLog;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class AEEditorImageEditFragment$10
  implements WtTicketPromise
{
  AEEditorImageEditFragment$10(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void Done(Ticket paramTicket)
  {
    AEQLog.b("AEEditorImageEditFragment", "psKey success.");
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    AEQLog.d("AEEditorImageEditFragment", paramErrMsg.toString());
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    AEQLog.d("AEEditorImageEditFragment", paramErrMsg.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.10
 * JD-Core Version:    0.7.0.1
 */