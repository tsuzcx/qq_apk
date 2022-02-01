package cooperation.qzone.plugin;

import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;

public abstract interface PluginIntent$OnResultListner
{
  public abstract void onRecieve(Intent paramIntent, FromServiceMsg paramFromServiceMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.plugin.PluginIntent.OnResultListner
 * JD-Core Version:    0.7.0.1
 */