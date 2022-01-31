package me.ele.uetool;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;

final class UETool$2
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("show", false);
    int i = paramIntent.getIntExtra("pid", 0);
    Log.i("ContentValues", "onReceive: " + paramContext.getPackageName() + " Show: " + bool + " pid: " + i + " curPid: " + Process.myPid() + " interrupt: " + UETool.access$000() + " isShowNow: " + UETool.access$100());
    if ((!UETool.access$200()) || (Process.myPid() == i) || (!paramContext.getPackageName().equals(paramIntent.getStringExtra("PackageName")))) {}
    do
    {
      return;
      if ((UETool.access$000()) && (bool) && (!UETool.access$100()))
      {
        Log.i("ContentValues", "onReceive: 显示 " + i);
        UETool.access$300(UETool.getInstance());
        return;
      }
    } while ((bool) || (UETool.access$000()) || (!UETool.access$100()));
    Log.i("ContentValues", "onReceive: 关闭 " + i);
    UETool.access$400(UETool.getInstance());
    UETool.access$002(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.UETool.2
 * JD-Core Version:    0.7.0.1
 */