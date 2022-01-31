package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.tavcut.view.TAVCutImageView;
import java.lang.ref.WeakReference;

class TAVCutImageSession$2
  implements Runnable
{
  TAVCutImageSession$2(TAVCutImageSession paramTAVCutImageSession, int paramInt, TAVCutImageView paramTAVCutImageView) {}
  
  public void run()
  {
    TAVCutImageSession.access$200(this.this$0).put(this.val$index, new WeakReference(this.val$tavCutImageView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.2
 * JD-Core Version:    0.7.0.1
 */