package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.Nullable;
import io.flutter.Log;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import org.json.JSONException;
import org.json.JSONObject;

class KeyEventChannel$1
  implements BasicMessageChannel.Reply<Object>
{
  public void reply(@Nullable Object paramObject)
  {
    if (KeyEventChannel.access$000(this.this$0) == null) {
      return;
    }
    if (paramObject == null) {}
    try
    {
      KeyEventChannel.access$000(this.this$0).onKeyEventNotHandled(this.val$eventId);
      return;
    }
    catch (JSONException paramObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to unpack JSON message: ");
      localStringBuilder.append(paramObject);
      Log.e("KeyEventChannel", localStringBuilder.toString());
      KeyEventChannel.access$000(this.this$0).onKeyEventNotHandled(this.val$eventId);
    }
    if (((JSONObject)paramObject).getBoolean("handled"))
    {
      KeyEventChannel.access$000(this.this$0).onKeyEventHandled(this.val$eventId);
      return;
    }
    KeyEventChannel.access$000(this.this$0).onKeyEventNotHandled(this.val$eventId);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.KeyEventChannel.1
 * JD-Core Version:    0.7.0.1
 */