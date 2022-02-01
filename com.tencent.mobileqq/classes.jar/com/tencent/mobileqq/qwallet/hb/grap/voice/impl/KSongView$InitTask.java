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
        if ((KSongView.a(this.a) != null) && (KSongView.a(this.a, str)))
        {
          paramVarArgs = KSongView.a(this.a);
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
      if (KSongView.a(this.a) != null) {
        KSongView.a(this.a).a(paramConfig);
      }
      KSongView.a(this.a).notifyDataSetChanged();
      KSongView.a(this.a, 0);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("InitTask config = ");
    ((StringBuilder)localObject).append(paramConfig);
    QLog.i("KSongView", 2, ((StringBuilder)localObject).toString());
    if (KSongView.a(this.a) != null)
    {
      localObject = KSongView.a(this.a);
      if (paramConfig != null) {
        bool = true;
      }
      ((KSHelper.KListener)localObject).a(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongView.InitTask
 * JD-Core Version:    0.7.0.1
 */