package dov.com.qq.im.aeeditor.module.edit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper;

class AEEditorVideoEditFragment$1
  extends BroadcastReceiver
{
  AEEditorVideoEditFragment$1(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AEQLog.b(AEEditorVideoEditFragment.g(), "[musicBroadcastReceiver.onReceive]");
    if (!"com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction())) {}
    do
    {
      return;
      AEEditorVideoEditFragment.a(this.a, AEEditorMusicHelper.a(paramIntent));
    } while (AEEditorVideoEditFragment.a(this.a) == null);
    if (!this.a.a)
    {
      AEEditorVideoEditFragment.a(this.a, AEEditorVideoEditFragment.a(this.a));
      return;
    }
    AEQLog.b(AEEditorVideoEditFragment.g(), "[musicBroadcastReceiver.onReceive], fragment not resumed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment.1
 * JD-Core Version:    0.7.0.1
 */