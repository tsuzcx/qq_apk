package com.tencent.tbs.one.impl.b;

import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.optional.TBSOneDebugPlugin;

final class a$1
  extends TBSOneCallback<TBSOneDebugPlugin>
{
  a$1(a parama) {}
  
  public final void onError(int paramInt, String paramString)
  {
    a.a(this.a, new a.1.3(this));
  }
  
  public final void onProgressChanged(int paramInt1, int paramInt2)
  {
    a.a(this.a, new a.1.1(this, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.b.a.1
 * JD-Core Version:    0.7.0.1
 */