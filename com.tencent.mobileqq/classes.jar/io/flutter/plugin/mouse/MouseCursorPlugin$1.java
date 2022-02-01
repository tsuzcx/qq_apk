package io.flutter.plugin.mouse;

import androidx.annotation.NonNull;
import io.flutter.embedding.engine.systemchannels.MouseCursorChannel.MouseCursorMethodHandler;

class MouseCursorPlugin$1
  implements MouseCursorChannel.MouseCursorMethodHandler
{
  MouseCursorPlugin$1(MouseCursorPlugin paramMouseCursorPlugin) {}
  
  public void activateSystemCursor(@NonNull String paramString)
  {
    MouseCursorPlugin.access$100(this.this$0).setPointerIcon(MouseCursorPlugin.access$000(this.this$0, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugin.mouse.MouseCursorPlugin.1
 * JD-Core Version:    0.7.0.1
 */