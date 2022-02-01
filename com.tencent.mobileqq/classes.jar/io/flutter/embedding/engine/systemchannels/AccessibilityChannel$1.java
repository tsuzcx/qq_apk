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
    int i = str.hashCode();
    if (i != -1140076541) {
      if (i != -649620375) {
        if (i != 114595) {
          if (i != 114203431) {
            i = -1;
          }
        }
      }
    }
    for (;;)
    {
      switch (i)
      {
      }
      for (;;)
      {
        paramReply.reply(null);
        return;
        if (!str.equals("longPress")) {
          break label340;
        }
        i = 2;
        break;
        if (!str.equals("tap")) {
          break label340;
        }
        i = 1;
        break;
        if (!str.equals("announce")) {
          break label340;
        }
        i = 0;
        break;
        if (!str.equals("tooltip")) {
          break label340;
        }
        i = 3;
        break;
        paramObject = (String)localHashMap.get("message");
        if (paramObject != null)
        {
          AccessibilityChannel.access$000(this.this$0).onTooltip(paramObject);
          continue;
          paramObject = (Integer)paramObject.get("nodeId");
          if (paramObject != null)
          {
            AccessibilityChannel.access$000(this.this$0).onLongPress(paramObject.intValue());
            continue;
            paramObject = (Integer)paramObject.get("nodeId");
            if (paramObject != null)
            {
              AccessibilityChannel.access$000(this.this$0).onTap(paramObject.intValue());
              continue;
              paramObject = (String)localHashMap.get("message");
              if (paramObject != null) {
                AccessibilityChannel.access$000(this.this$0).announce(paramObject);
              }
            }
          }
        }
      }
      label340:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.AccessibilityChannel.1
 * JD-Core Version:    0.7.0.1
 */