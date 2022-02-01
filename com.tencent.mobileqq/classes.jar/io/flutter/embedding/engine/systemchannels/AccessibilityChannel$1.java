package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.Log;
import io.flutter.plugin.common.BasicMessageChannel.MessageHandler;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import java.util.HashMap;

class AccessibilityChannel$1
  implements BasicMessageChannel.MessageHandler<Object>
{
  AccessibilityChannel$1(AccessibilityChannel paramAccessibilityChannel) {}
  
  public void onMessage(@Nullable Object paramObject, @NonNull BasicMessageChannel.Reply<Object> paramReply)
  {
    if (AccessibilityChannel.access$000(this.this$0) == null) {
      return;
    }
    paramObject = (HashMap)paramObject;
    String str = (String)paramObject.get("type");
    HashMap localHashMap = (HashMap)paramObject.get("data");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Received ");
    localStringBuilder.append(str);
    localStringBuilder.append(" message.");
    Log.v("AccessibilityChannel", localStringBuilder.toString());
    int i = -1;
    int j = str.hashCode();
    if (j != -1140076541)
    {
      if (j != -649620375)
      {
        if (j != 114595)
        {
          if ((j == 114203431) && (str.equals("longPress"))) {
            i = 2;
          }
        }
        else if (str.equals("tap")) {
          i = 1;
        }
      }
      else if (str.equals("announce")) {
        i = 0;
      }
    }
    else if (str.equals("tooltip")) {
      i = 3;
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            paramObject = (String)localHashMap.get("message");
            if (paramObject != null) {
              AccessibilityChannel.access$000(this.this$0).onTooltip(paramObject);
            }
          }
        }
        else
        {
          paramObject = (Integer)paramObject.get("nodeId");
          if (paramObject != null) {
            AccessibilityChannel.access$000(this.this$0).onLongPress(paramObject.intValue());
          }
        }
      }
      else
      {
        paramObject = (Integer)paramObject.get("nodeId");
        if (paramObject != null) {
          AccessibilityChannel.access$000(this.this$0).onTap(paramObject.intValue());
        }
      }
    }
    else
    {
      paramObject = (String)localHashMap.get("message");
      if (paramObject != null) {
        AccessibilityChannel.access$000(this.this$0).announce(paramObject);
      }
    }
    paramReply.reply(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.AccessibilityChannel.1
 * JD-Core Version:    0.7.0.1
 */