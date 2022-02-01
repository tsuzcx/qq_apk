package com.tencent.tbs.one.impl.c;

import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.impl.a.a.c;
import java.io.File;

final class b$3$1$1
  extends TBSOneCallback<File>
{
  b$3$1$1(b.3.1 param1) {}
  
  public final void onError(int paramInt, String paramString)
  {
    c localc = this.a.a;
    StringBuilder localStringBuilder = new StringBuilder("Failed to install dependency ");
    localStringBuilder.append(this.a.b.f);
    localStringBuilder.append(", error: ");
    localStringBuilder.append(paramString);
    localc.a(paramInt, localStringBuilder.toString(), null);
  }
  
  public final void onProgressChanged(int paramInt1, int paramInt2)
  {
    b.a(this.a.b.j, paramInt1, paramInt2, this.a.b.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.b.3.1.1
 * JD-Core Version:    0.7.0.1
 */