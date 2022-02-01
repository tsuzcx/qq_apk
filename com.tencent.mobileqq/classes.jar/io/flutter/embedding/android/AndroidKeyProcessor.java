package io.flutter.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel.FlutterKeyEvent;
import io.flutter.plugin.editing.TextInputPlugin;

public class AndroidKeyProcessor
{
  private static final String TAG = "AndroidKeyProcessor";
  private static long eventIdSerial;
  private int combiningCharacter;
  @NonNull
  private AndroidKeyProcessor.EventResponder eventResponder;
  @NonNull
  private final KeyEventChannel keyEventChannel;
  @NonNull
  private final TextInputPlugin textInputPlugin;
  
  public AndroidKeyProcessor(@NonNull View paramView, @NonNull KeyEventChannel paramKeyEventChannel, @NonNull TextInputPlugin paramTextInputPlugin)
  {
    this.keyEventChannel = paramKeyEventChannel;
    this.textInputPlugin = paramTextInputPlugin;
    this.eventResponder = new AndroidKeyProcessor.EventResponder(paramView);
    this.keyEventChannel.setEventResponseHandler(this.eventResponder);
  }
  
  @Nullable
  private Character applyCombiningCharacterToBaseCharacter(int paramInt)
  {
    if (paramInt == 0) {
      return null;
    }
    char c1 = (char)paramInt;
    int i;
    char c2;
    if ((0x80000000 & paramInt) != 0)
    {
      i = 1;
      if (i == 0) {
        break label71;
      }
      paramInt = 0x7FFFFFFF & paramInt;
      if (this.combiningCharacter == 0) {
        break label61;
      }
      this.combiningCharacter = KeyCharacterMap.getDeadChar(this.combiningCharacter, paramInt);
      c2 = c1;
    }
    for (;;)
    {
      return Character.valueOf(c2);
      i = 0;
      break;
      label61:
      this.combiningCharacter = paramInt;
      c2 = c1;
      continue;
      label71:
      c2 = c1;
      if (this.combiningCharacter != 0)
      {
        paramInt = KeyCharacterMap.getDeadChar(this.combiningCharacter, paramInt);
        if (paramInt > 0) {
          c1 = (char)paramInt;
        }
        this.combiningCharacter = 0;
        c2 = c1;
      }
    }
  }
  
  public void destroy()
  {
    this.keyEventChannel.setEventResponseHandler(null);
  }
  
  public boolean onKeyDown(@NonNull KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if (this.eventResponder.dispatchingKeyEvent) {
      bool = false;
    }
    while ((this.textInputPlugin.getLastInputConnection() != null) && (this.textInputPlugin.getInputMethodManager().isAcceptingText()) && (this.textInputPlugin.getLastInputConnection().sendKeyEvent(paramKeyEvent))) {
      return bool;
    }
    Object localObject = applyCombiningCharacterToBaseCharacter(paramKeyEvent.getUnicodeChar());
    long l = eventIdSerial;
    eventIdSerial = 1L + l;
    localObject = new KeyEventChannel.FlutterKeyEvent(paramKeyEvent, (Character)localObject, l);
    this.keyEventChannel.keyDown((KeyEventChannel.FlutterKeyEvent)localObject);
    this.eventResponder.addEvent(((KeyEventChannel.FlutterKeyEvent)localObject).eventId, paramKeyEvent);
    return true;
  }
  
  public boolean onKeyUp(@NonNull KeyEvent paramKeyEvent)
  {
    if (this.eventResponder.dispatchingKeyEvent) {
      return false;
    }
    Object localObject = applyCombiningCharacterToBaseCharacter(paramKeyEvent.getUnicodeChar());
    long l = eventIdSerial;
    eventIdSerial = 1L + l;
    localObject = new KeyEventChannel.FlutterKeyEvent(paramKeyEvent, (Character)localObject, l);
    this.keyEventChannel.keyUp((KeyEventChannel.FlutterKeyEvent)localObject);
    this.eventResponder.addEvent(((KeyEventChannel.FlutterKeyEvent)localObject).eventId, paramKeyEvent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.android.AndroidKeyProcessor
 * JD-Core Version:    0.7.0.1
 */