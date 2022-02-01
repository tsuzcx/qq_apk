package com.tencent.tbs.one.impl.e;

import android.content.Context;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.a;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.common.d;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

final class i$4
  extends a<e<d>>
{
  i$4(i parami, Context paramContext, String paramString, File paramFile) {}
  
  public final void a()
  {
    Object localObject4 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    try
    {
      InputStream localInputStream = c.a(this.b, this.c, "DEPS");
      localObject2 = localInputStream;
      localObject4 = localInputStream;
      localObject1 = localInputStream;
      d locald = d.a(c.a(localInputStream, "utf-8", this.d));
      c.a(localInputStream);
      a(e.a(e.a.c, locald));
      return;
    }
    catch (IOException localIOException)
    {
      localObject1 = localObject2;
      a(303, "Failed to copy local DEPS from " + this.c + " to " + this.d.getAbsolutePath(), localIOException);
      c.a(localObject2);
      return;
    }
    catch (TBSOneException localTBSOneException)
    {
      localObject1 = localIOException;
      a(localTBSOneException.getErrorCode(), localTBSOneException.getMessage(), localTBSOneException.getCause());
      c.a(localIOException);
      return;
    }
    finally
    {
      c.a((Closeable)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.i.4
 * JD-Core Version:    0.7.0.1
 */