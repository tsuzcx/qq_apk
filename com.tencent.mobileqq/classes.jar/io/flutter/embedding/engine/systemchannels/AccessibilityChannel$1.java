package io.flutter.embedding.engine.systemchannels;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
    paramReply = (String)paramObject.get("type");
    HashMap localHashMap = (HashMap)paramObject.get("data");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Received ");
    localStringBuilder.append(paramReply);
    localStringBuilder.append(" message.");
    Log.v("AccessibilityChannel", localStringBuilder.toString());
    int i = paramReply.hashCode();
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
      default: 
        return;
      case 0: 
        paramObject = (String)localHashMap.get("message");
        if (paramObject == null) {
          break;
        }
        AccessibilityChannel.access$000(this.this$0).announce(paramObject);
        return;
        if (paramReply.equals("longPress"))
        {
          i = 2;
          continue;
          if (paramReply.equals("tap"))
          {
            i = 1;
            continue;
            if (paramReply.equals("announce"))
            {
              i = 0;
              continue;
              if (paramReply.equals("tooltip")) {
                i = 3;
              }
            }
          }
        }
        break;
      case 3: 
        paramObject = (String)localHashMap.get("message");
        if (paramObject == null) {
          break;
        }
        AccessibilityChannel.access$000(this.this$0).onTooltip(paramObject);
        return;
      case 2: 
        paramObject = (Integer)paramObject.get("nodeId");
        if (paramObject == null) {
          break;
        }
        AccessibilityChannel.access$000(this.this$0).onLongPress(paramObject.intValue());
        return;
      case 1: 
        paramObject = (Integer)paramObject.get("nodeId");
        if (paramObject == null) {
          break;
        }
        AccessibilityChannel.access$000(this.this$0).onTap(paramObject.intValue());
        return;
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.AccessibilityChannel.1
 * JD-Core Version:    0.7.0.1
 */