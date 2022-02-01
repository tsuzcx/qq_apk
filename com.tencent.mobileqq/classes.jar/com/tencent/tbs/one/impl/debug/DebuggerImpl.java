package com.tencent.tbs.one.impl.debug;

import android.content.Context;
import android.view.View;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneDebugger;
import com.tencent.tbs.one.impl.common.CommonUtils;
import java.util.Map;

public class DebuggerImpl
  implements TBSOneDebugger
{
  private final String mCategory;
  
  public DebuggerImpl(String paramString)
  {
    this.mCategory = paramString;
  }
  
  public View createPanelView(Context paramContext)
  {
    return new DebugPanelView(paramContext, this.mCategory);
  }
  
  public void executeCommand(Context paramContext, String paramString, Map<String, Object> paramMap, TBSOneCallback<Void> paramTBSOneCallback)
  {
    CommonUtils.loadDebugPlugin(paramContext, new DebuggerImpl.1(this, paramContext, paramString, paramMap, paramTBSOneCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.debug.DebuggerImpl
 * JD-Core Version:    0.7.0.1
 */