package com.tencent.tbs.one.impl.common;

import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.optional.TBSOneDebugPlugin;

final class CommonUtils$1
  extends TBSOneCallback<TBSOneComponent>
{
  CommonUtils$1(TBSOneCallback paramTBSOneCallback) {}
  
  public void onCompleted(TBSOneComponent paramTBSOneComponent)
  {
    paramTBSOneComponent = paramTBSOneComponent.getEntryObject();
    if ((paramTBSOneComponent instanceof TBSOneDebugPlugin))
    {
      paramTBSOneComponent = (TBSOneDebugPlugin)paramTBSOneComponent;
      this.val$callback.onCompleted(paramTBSOneComponent);
      return;
    }
    this.val$callback.onError(505, "Failed to cast the entry object of debug plugin");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.CommonUtils.1
 * JD-Core Version:    0.7.0.1
 */