package com.tencent.tbs.one.impl.b;

import android.content.Context;
import android.view.View;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneDebugger;
import java.util.Map;

public final class b
  implements TBSOneDebugger
{
  private final String a;
  
  public b(String paramString)
  {
    this.a = paramString;
  }
  
  public final View createPanelView(Context paramContext)
  {
    return new a(paramContext, this.a);
  }
  
  public final void executeCommand(Context paramContext, String paramString, Map<String, Object> paramMap, TBSOneCallback<Void> paramTBSOneCallback)
  {
    com.tencent.tbs.one.impl.common.a.a(paramContext, new b.1(this, paramContext, paramString, paramMap, paramTBSOneCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.b.b
 * JD-Core Version:    0.7.0.1
 */