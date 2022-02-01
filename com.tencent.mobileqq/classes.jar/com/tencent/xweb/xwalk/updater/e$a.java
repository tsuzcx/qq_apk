package com.tencent.xweb.xwalk.updater;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.xweb.xwalk.p;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

class e$a
  extends AsyncTask<String, Integer, String>
{
  Context a;
  
  public e$a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  protected String a(String... paramVarArgs)
  {
    Log.i("XWalkCleaner", "XWalkCleaner tryClean start");
    if (!XWalkEnvironment.isTestVersion(XWalkEnvironment.getInstalledNewstVersionForCurAbi())) {
      p.a(false);
    }
    p.d();
    p.a(this.a, false);
    p.a(this.a);
    p.a();
    e.a = false;
    Log.i("XWalkCleaner", "XWalkCleaner tryClean finished");
    return null;
  }
  
  protected void a(String paramString) {}
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.e.a
 * JD-Core Version:    0.7.0.1
 */