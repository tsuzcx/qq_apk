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
    h.a("SkinEngine", 1, "UpdateTask switch theme start");
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
    h.a("SkinEngine", 1, "UpdateTask switch theme end");
    SkinEngine.a(this.a, null);
    Object localObject = this.a;
    SkinEngine.a((SkinEngine)localObject, SkinEngine.a((SkinEngine)localObject));
    localObject = new Intent("com.tencent.qplus.THEME_INVALIDATE");
    ((Intent)localObject).putExtra("pid", Process.myPid());
    paramContext.sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    if (SkinEngine.SWITCH_DEBUG)
    {
      Log.d("SkinEngine.switch", "UpdateTask.onPostExecute sendBroadcast(ACTION_THEME_INVALIDATE)");
      Log.d("SkinEngine.switch", "UpdateTask.onPostExecute done");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.theme.SkinEngine.a
 * JD-Core Version:    0.7.0.1
 */