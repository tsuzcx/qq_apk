package com.tencent.tbs.one.impl.debug;

import android.content.Context;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.optional.TBSOneDebugPlugin;
import java.util.Map;

class DebuggerImpl$1
  extends TBSOneCallback<TBSOneDebugPlugin>
{
  DebuggerImpl$1(DebuggerImpl paramDebuggerImpl, Context paramContext, String paramString, Map paramMap, TBSOneCallback paramTBSOneCallback) {}
  
  public void onCompleted(TBSOneDebugPlugin paramTBSOneDebugPlugin)
  {
    try
    {
      paramTBSOneDebugPlugin.executeCommand(this.val$context, DebuggerImpl.access$000(this.this$0), this.val$command, this.val$params, this.val$callback);
      return;
    }
    catch (UnsupportedOperationException paramTBSOneDebugPlugin)
    {
      while (this.val$callback == null) {}
      this.val$callback.onError(102, "Unimplemented method");
    }
  }
  
  public void onError(int paramInt, String paramString)
  {
    if (this.val$callback != null) {
      this.val$callback.onError(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.debug.DebuggerImpl.1
 * JD-Core Version:    0.7.0.1
 */