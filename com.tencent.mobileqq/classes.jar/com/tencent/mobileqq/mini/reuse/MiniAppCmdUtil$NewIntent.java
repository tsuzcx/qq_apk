package com.tencent.mobileqq.mini.reuse;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.SenderListener;
import mqq.app.NewIntent;
import mqq.app.Servlet;

public class MiniAppCmdUtil$NewIntent
  extends NewIntent
{
  public MiniAppCmdUtil$NewIntent(Context paramContext, Class<? extends Servlet> paramClass, MiniAppCmdInterface paramMiniAppCmdInterface, String paramString)
  {
    super(paramClass, paramMiniAppCmdInterface);
    String str;
    putExtra("key_index", MiniAppCmdUtil.access$000(paramContext, paramString, str));
    setObserver(MiniAppCmdUtil.access$100(paramContext));
  }
  
  public MiniAppCmdUtil$NewIntent(Context paramContext, Class<? extends Servlet> paramClass, MiniAppProxy.SenderListener paramSenderListener, String paramString)
  {
    super(paramClass, paramSenderListener);
    String str;
    putExtra("key_index", MiniAppCmdUtil.access$200(paramContext, paramString, str));
    setObserver(MiniAppCmdUtil.access$100(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil.NewIntent
 * JD-Core Version:    0.7.0.1
 */