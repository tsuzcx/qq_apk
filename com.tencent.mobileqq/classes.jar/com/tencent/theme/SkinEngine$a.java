package com.tencent.theme;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Process;
import android.util.Log;

class SkinEngine$a
  extends AsyncTask<Context, Void, Context>
{
  private SkinEngine$a(SkinEngine paramSkinEngine) {}
  
  protected Context a(Context... paramVarArgs)
  {
    if (SkinEngine.SWITCH_DEBUG) {
      Log.d("SkinEngine.switch", "UpdateTask.doInBackground start");
    }
    i.a("SkinEngine", 1, "UpdateTask switch theme start");
    this.a.a(paramVarArgs[0]);
    System.gc();
    Thread.yield();
    System.gc();
    if (SkinEngine.SWITCH_DEBUG) {
      Log.d("SkinEngine.switch", "UpdateTask.doInBackground done");
    }
    return paramVarArgs[0];
  }
  
  protected void a(Context paramContext)
  {
    if (SkinEngine.SWITCH_DEBUG) {
      Log.d("SkinEngine.switch", "UpdateTask.onPostExecute start");
    }
    i.a("SkinEngine", 1, "UpdateTask switch theme end");
    SkinEngine.a(this.a, null);
    SkinEngine.a(this.a, SkinEngine.a(this.a));
    Intent localIntent = new Intent("com.tencent.qplus.THEME_INVALIDATE");
    localIntent.putExtra("pid", Process.myPid());
    paramContext.sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
    if (SkinEngine.SWITCH_DEBUG)
    {
      Log.d("SkinEngine.switch", "UpdateTask.onPostExecute sendBroadcast(ACTION_THEME_INVALIDATE)");
      Log.d("SkinEngine.switch", "UpdateTask.onPostExecute done");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.theme.SkinEngine.a
 * JD-Core Version:    0.7.0.1
 */