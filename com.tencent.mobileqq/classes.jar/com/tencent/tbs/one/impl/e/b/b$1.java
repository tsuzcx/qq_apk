package com.tencent.tbs.one.impl.e.b;

import android.content.Context;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.f;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.tbs.one.impl.e.e.a;
import java.io.File;
import java.io.IOException;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    b localb = this.a;
    Object localObject2 = localb.b;
    String str = this.a.c;
    Object localObject1 = this.a.d;
    localObject2 = f.a((Context)localObject2);
    try
    {
      c.a(f.c((File)localObject2, str), (File)localObject1);
      try
      {
        localObject1 = d.a((File)localObject1);
        localb.a(e.a(e.a.b, localObject1));
        return;
      }
      catch (TBSOneException localTBSOneException)
      {
        localb.a(localTBSOneException.getErrorCode(), localTBSOneException.getMessage(), localTBSOneException.getCause());
        return;
      }
      StringBuilder localStringBuilder;
      return;
    }
    catch (IOException localIOException)
    {
      localStringBuilder = new StringBuilder("Failed to copy builtin DEPS from ");
      localStringBuilder.append(((File)localObject2).getAbsolutePath());
      localStringBuilder.append(" to ");
      localStringBuilder.append(localTBSOneException.getAbsolutePath());
      localb.a(302, localStringBuilder.toString(), localIOException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.b.b.1
 * JD-Core Version:    0.7.0.1
 */