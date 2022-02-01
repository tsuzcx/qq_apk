package com.tencent.upload.network.session;

import android.util.SparseArray;
import com.tencent.upload.request.IActionRequest;

class UploadSession$7
  implements Runnable
{
  UploadSession$7(UploadSession paramUploadSession, int paramInt) {}
  
  public void run()
  {
    this.this$0.recordLastActiveTime();
    IActionRequest localIActionRequest = (IActionRequest)UploadSession.access$800(this.this$0).get(this.val$sendSequence);
    UploadSession.access$1000(this.this$0, localIActionRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.network.session.UploadSession.7
 * JD-Core Version:    0.7.0.1
 */