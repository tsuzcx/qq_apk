package com.tencent.mobileqq.microapp.a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public final class a$a
{
  private final a.b b;
  private final boolean[] c;
  private boolean d;
  
  private a$a(a parama, a.b paramb)
  {
    this.b = paramb;
    if (a.b.d(paramb)) {}
    for (parama = null;; parama = new boolean[a.e(parama)])
    {
      this.c = parama;
      return;
    }
  }
  
  public OutputStream a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= a.e(this.a))) {
      throw new IllegalArgumentException("Expected index " + paramInt + " to be greater than 0 and less than the maximum value count of " + a.e(this.a));
    }
    synchronized (this.a)
    {
      if (a.b.a(this.b) != this) {
        throw new IllegalStateException();
      }
    }
    if (!a.b.d(this.b)) {
      this.c[paramInt] = true;
    }
    File localFile = this.b.b(paramInt);
    try
    {
      Object localObject2 = new FileOutputStream(localFile);
      localObject2 = new a.a.a(this, (OutputStream)localObject2, null);
      return localObject2;
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      for (;;)
      {
        a.f(this.a).mkdirs();
        try
        {
          FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          OutputStream localOutputStream = a.g();
          return localOutputStream;
        }
      }
    }
  }
  
  public void a()
  {
    if (this.d)
    {
      a.a(this.a, this, false);
      this.a.c(a.b.c(this.b));
      return;
    }
    a.a(this.a, this, true);
  }
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(a(paramInt), i.b);
      i.a(localOutputStreamWriter);
    }
    finally
    {
      try
      {
        localOutputStreamWriter.write(paramString);
        i.a(localOutputStreamWriter);
        return;
      }
      finally {}
      paramString = finally;
      localOutputStreamWriter = null;
    }
    throw paramString;
  }
  
  public void b()
  {
    a.a(this.a, this, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.a.a.a
 * JD-Core Version:    0.7.0.1
 */