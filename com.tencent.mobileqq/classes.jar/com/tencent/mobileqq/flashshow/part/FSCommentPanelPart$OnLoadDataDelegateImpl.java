package com.tencent.mobileqq.flashshow.part;

import com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class FSCommentPanelPart$OnLoadDataDelegateImpl
  implements MultiViewBlock.OnLoadDataDelegate
{
  private final WeakReference<FSCommentPanelPart> a;
  
  public FSCommentPanelPart$OnLoadDataDelegateImpl(FSCommentPanelPart paramFSCommentPanelPart)
  {
    this.a = new WeakReference(paramFSCommentPanelPart);
  }
  
  public void a(LoadInfo paramLoadInfo, Object paramObject)
  {
    paramObject = (FSCommentPanelPart)this.a.get();
    if (paramObject == null)
    {
      QLog.d("OnLoadDataDelegateImpl", 1, "[onLoadData] panel part should not is null.");
      return;
    }
    if (paramLoadInfo.e()) {
      FSCommentPanelPart.a(paramObject, paramLoadInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSCommentPanelPart.OnLoadDataDelegateImpl
 * JD-Core Version:    0.7.0.1
 */