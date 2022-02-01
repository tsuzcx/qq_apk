package com.tencent.tbs.one.impl.e;

import android.os.Bundle;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneOnlineService;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.a.m;

public final class g
  implements TBSOneOnlineService
{
  j a;
  private i b;
  
  public g(i parami)
  {
    this.b = parami;
  }
  
  private void a(com.tencent.tbs.one.impl.a.j paramj)
  {
    this.a = null;
    paramj.a();
  }
  
  public final void cancelUpdate()
  {
    f.a("[%s] Canceling update", new Object[] { this.b.b });
    m.a(new g.2(this));
  }
  
  public final void update(Bundle paramBundle, TBSOneCallback<Void> paramTBSOneCallback)
  {
    String str = this.b.b;
    f.a("[%s] Updating", new Object[] { str });
    if (this.b.i())
    {
      f.a("[%s] No need to update because the last update has not applied", new Object[] { str });
      if (paramTBSOneCallback != null) {
        paramTBSOneCallback.onCompleted(null);
      }
      return;
    }
    m.a(new g.1(this, paramBundle, paramTBSOneCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.g
 * JD-Core Version:    0.7.0.1
 */