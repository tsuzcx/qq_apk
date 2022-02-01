package com.tencent.mobileqq.musicgene;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class MusicGeneWebViewPlugin$3
  extends BroadcastReceiver
{
  MusicGeneWebViewPlugin$3(MusicGeneWebViewPlugin paramMusicGeneWebViewPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("BROAD_CAST_CALL_PAGE_SHARE".equals(paramIntent.getAction()))) {
      MusicGeneWebViewPlugin.d(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin.3
 * JD-Core Version:    0.7.0.1
 */