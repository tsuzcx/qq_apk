package com.tencent.xweb.xwalk.updater;

import android.os.AsyncTask;
import com.tencent.xweb.a;
import com.tencent.xweb.util.h;
import com.tencent.xweb.xwalk.p;
import org.xwalk.core.XWalkEnvironment;

class g$1$1
  extends AsyncTask<Void, Void, Integer>
{
  g$1$1(g.1 param1, a.b paramb, j.c paramc) {}
  
  protected Integer a(Void... paramVarArgs)
  {
    try
    {
      a.a(this.a.e, this.a.c);
      p.a("cfg_update", 0);
    }
    catch (Exception paramVarArgs)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("apply cmds failed , ");
      localStringBuilder.append(paramVarArgs.getMessage());
      XWalkEnvironment.addXWalkInitializeLog(localStringBuilder.toString());
    }
    XWalkEnvironment.addXWalkInitializeLog("doFetchUpdateConfigNew onTaskSucceed!!");
    h.d(this.b.g);
    paramVarArgs = new StringBuilder();
    paramVarArgs.append(this.a.c);
    paramVarArgs.append(",");
    paramVarArgs.append(201201);
    paramVarArgs.append(",");
    paramVarArgs.append(this.b.c);
    paramVarArgs.append(",");
    paramVarArgs.append(this.b.d);
    paramVarArgs.append(",");
    paramVarArgs.append(this.b.f);
    paramVarArgs.append(",");
    paramVarArgs.append(this.b.g);
    paramVarArgs.append(",");
    paramVarArgs.append(this.b.h);
    paramVarArgs.append(",");
    paramVarArgs.append(g.g());
    h.a(15123, paramVarArgs.toString());
    XWebCoreScheduler.z().a(this.a);
    i.y().a(this.a);
    g.f();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.g.1.1
 * JD-Core Version:    0.7.0.1
 */