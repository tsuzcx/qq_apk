package com.tencent.mobileqq.qwallet.hb.grap.voice.impl;

import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;

public class KSongView$InitTask
  extends AsyncTask<String, Void, KSHelper.Config>
{
  public KSongView$InitTask(KSongView paramKSongView) {}
  
  protected KSHelper.Config a(String... paramVarArgs)
  {
    String str = paramVarArgs[0];
    paramVarArgs = paramVarArgs[1];
    for (;;)
    {
      try
      {
        KSongView.a(this.a, KSongView.a(this.a, paramVarArgs));
        if ((KSongView.c(this.a) != null) && (KSongView.b(this.a, str)))
        {
          paramVarArgs = KSongView.c(this.a);
          return paramVarArgs;
        }
      }
      finally {}
      paramVarArgs = null;
    }
  }
  
  protected void a(KSHelper.Config paramConfig)
  {
    boolean bool = false;
    if (paramConfig != null)
    {
      if (KSongView.d(this.a) != null) {
        KSongView.d(this.a).a(paramConfig);
      }
      KSongView.e(this.a).notifyDataSetChanged();
      KSongView.a(this.a, 0);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("InitTask config = ");
    ((StringBuilder)localObject).append(paramConfig);
    QLog.i("KSongView", 2, ((StringBuilder)localObject).toString());
    if (KSongView.b(this.a) != null)
    {
      localObject = KSongView.b(this.a);
      if (paramConfig != null) {
        bool = true;
      }
      ((KSHelper.KListener)localObject).a(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongView.InitTask
 * JD-Core Version:    0.7.0.1
 */