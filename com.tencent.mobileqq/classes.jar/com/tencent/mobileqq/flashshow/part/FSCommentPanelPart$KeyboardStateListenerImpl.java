package com.tencent.mobileqq.flashshow.part;

import com.tencent.mobileqq.flashshow.widgets.comment.dialog.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class FSCommentPanelPart$KeyboardStateListenerImpl
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  private WeakReference<FSCommentPanelPart> a;
  
  public FSCommentPanelPart$KeyboardStateListenerImpl(FSCommentPanelPart paramFSCommentPanelPart)
  {
    this.a = new WeakReference(paramFSCommentPanelPart);
  }
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (FSCommentPanelPart)((WeakReference)localObject).get();
    }
    if (localObject == null)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[onSoftKeyboardClosed] panel part should not be null.");
      return;
    }
    FSCommentPanelPart.f((FSCommentPanelPart)localObject);
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (FSCommentPanelPart)((WeakReference)localObject).get();
    }
    if (localObject == null)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[onSoftKeyboardOpened] panel part should not be null.");
      return;
    }
    FSCommentPanelPart.a((FSCommentPanelPart)localObject, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSCommentPanelPart.KeyboardStateListenerImpl
 * JD-Core Version:    0.7.0.1
 */