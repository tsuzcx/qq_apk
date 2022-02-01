package io.flutter.plugin.mouse;

import android.annotation.TargetApi;
import android.view.PointerIcon;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import io.flutter.embedding.engine.systemchannels.MouseCursorChannel;
import java.util.HashMap;

@TargetApi(24)
@RequiresApi(24)
public class MouseCursorPlugin
{
  @NonNull
  private static HashMap<String, Integer> systemCursorConstants;
  @NonNull
  private final MouseCursorPlugin.MouseCursorViewDelegate mView;
  @NonNull
  private final MouseCursorChannel mouseCursorChannel;
  
  public MouseCursorPlugin(@NonNull MouseCursorPlugin.MouseCursorViewDelegate paramMouseCursorViewDelegate, @NonNull MouseCursorChannel paramMouseCursorChannel)
  {
    this.mView = paramMouseCursorViewDelegate;
    this.mouseCursorChannel = paramMouseCursorChannel;
    paramMouseCursorChannel.setMethodHandler(new MouseCursorPlugin.1(this));
  }
  
  private PointerIcon resolveSystemCursor(@NonNull String paramString)
  {
    if (systemCursorConstants == null) {
      systemCursorConstants = new MouseCursorPlugin.2(this);
    }
    int i = ((Integer)systemCursorConstants.getOrDefault(paramString, Integer.valueOf(1000))).intValue();
    return this.mView.getSystemPointerIcon(i);
  }
  
  public void destroy()
  {
    this.mouseCursorChannel.setMethodHandler(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.plugin.mouse.MouseCursorPlugin
 * JD-Core Version:    0.7.0.1
 */