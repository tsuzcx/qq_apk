package io.flutter.embedding.engine.systemchannels;

import android.os.Bundle;
import androidx.annotation.NonNull;

public abstract interface TextInputChannel$TextInputMethodHandler
{
  public abstract void clearClient();
  
  public abstract void finishAutofillContext(boolean paramBoolean);
  
  public abstract void hide();
  
  public abstract void requestAutofill();
  
  public abstract void sendAppPrivateCommand(String paramString, Bundle paramBundle);
  
  public abstract void setClient(int paramInt, @NonNull TextInputChannel.Configuration paramConfiguration);
  
  public abstract void setEditableSizeAndTransform(double paramDouble1, double paramDouble2, double[] paramArrayOfDouble);
  
  public abstract void setEditingState(@NonNull TextInputChannel.TextEditState paramTextEditState);
  
  public abstract void setPlatformViewClient(int paramInt);
  
  public abstract void show();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
 * JD-Core Version:    0.7.0.1
 */