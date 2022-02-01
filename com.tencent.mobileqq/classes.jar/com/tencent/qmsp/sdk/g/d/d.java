package com.tencent.qmsp.sdk.g.d;

import android.os.AsyncTask;

public class d
  extends AsyncTask<Void, Void, Boolean>
{
  public a a;
  public c b;
  
  public d(a parama, c paramc)
  {
    this.a = parama;
    this.b = paramc;
  }
  
  protected Boolean a(Void... paramVarArgs)
  {
    paramVarArgs = this.a;
    int i = 0;
    if (paramVarArgs == null) {
      return Boolean.valueOf(false);
    }
    for (;;)
    {
      try
      {
        boolean bool = this.a.c();
        if (!bool)
        {
          Thread.sleep(10L);
          int j = i + 1;
          i = j;
          if (j < 30) {}
        }
        else
        {
          if (bool)
          {
            paramVarArgs = this.b;
            if (paramVarArgs != null) {
              paramVarArgs.a(true);
            }
          }
          return Boolean.valueOf(bool);
        }
      }
      catch (InterruptedException paramVarArgs) {}
    }
  }
  
  protected void a(Boolean paramBoolean)
  {
    super.onPostExecute(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.d.d
 * JD-Core Version:    0.7.0.1
 */