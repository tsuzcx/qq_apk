package io.flutter.embedding.engine.systemchannels;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.InputDevice;
import android.view.KeyEvent;

public class KeyEventChannel$FlutterKeyEvent
{
  public final int codePoint;
  @Nullable
  public final Character complexCharacter;
  public final int deviceId;
  public final int flags;
  public final int keyCode;
  public final int metaState;
  public final int plainCodePoint;
  public final int productId;
  public final int scanCode;
  public final int source;
  public final int vendorId;
  
  public KeyEventChannel$FlutterKeyEvent(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @Nullable Character paramCharacter, int paramInt6, int paramInt7, int paramInt8)
  {
    this.deviceId = paramInt1;
    this.flags = paramInt2;
    this.plainCodePoint = paramInt3;
    this.codePoint = paramInt4;
    this.keyCode = paramInt5;
    this.complexCharacter = paramCharacter;
    this.scanCode = paramInt6;
    this.metaState = paramInt7;
    this.source = paramInt8;
    paramCharacter = InputDevice.getDevice(paramInt1);
    if (paramCharacter != null)
    {
      if (Build.VERSION.SDK_INT >= 19)
      {
        this.vendorId = paramCharacter.getVendorId();
        this.productId = paramCharacter.getProductId();
        return;
      }
      this.vendorId = 0;
      this.productId = 0;
      return;
    }
    this.vendorId = 0;
    this.productId = 0;
  }
  
  public KeyEventChannel$FlutterKeyEvent(@NonNull KeyEvent paramKeyEvent)
  {
    this(paramKeyEvent, null);
  }
  
  public KeyEventChannel$FlutterKeyEvent(@NonNull KeyEvent paramKeyEvent, @Nullable Character paramCharacter)
  {
    this(paramKeyEvent.getDeviceId(), paramKeyEvent.getFlags(), paramKeyEvent.getUnicodeChar(0), paramKeyEvent.getUnicodeChar(), paramKeyEvent.getKeyCode(), paramCharacter, paramKeyEvent.getScanCode(), paramKeyEvent.getMetaState(), paramKeyEvent.getSource());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.KeyEventChannel.FlutterKeyEvent
 * JD-Core Version:    0.7.0.1
 */