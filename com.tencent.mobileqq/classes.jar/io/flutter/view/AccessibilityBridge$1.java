package io.flutter.view;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

class AccessibilityBridge$1
  implements AccessibilityChannel.AccessibilityMessageHandler
{
  AccessibilityBridge$1(AccessibilityBridge paramAccessibilityBridge) {}
  
  public void announce(@NonNull String paramString)
  {
    AccessibilityBridge.access$000(this.this$0).announceForAccessibility(paramString);
  }
  
  public void onLongPress(int paramInt)
  {
    AccessibilityBridge.access$100(this.this$0, paramInt, 2);
  }
  
  public void onTap(int paramInt)
  {
    AccessibilityBridge.access$100(this.this$0, paramInt, 1);
  }
  
  public void onTooltip(@NonNull String paramString)
  {
    AccessibilityEvent localAccessibilityEvent = AccessibilityBridge.access$200(this.this$0, 0, 32);
    localAccessibilityEvent.getText().add(paramString);
    AccessibilityBridge.access$300(this.this$0, localAccessibilityEvent);
  }
  
  public void updateCustomAccessibilityActions(ByteBuffer paramByteBuffer, String[] paramArrayOfString)
  {
    paramByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    this.this$0.updateCustomAccessibilityActions(paramByteBuffer, paramArrayOfString);
  }
  
  public void updateSemantics(ByteBuffer paramByteBuffer, String[] paramArrayOfString)
  {
    paramByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    this.this$0.updateSemantics(paramByteBuffer, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.view.AccessibilityBridge.1
 * JD-Core Version:    0.7.0.1
 */