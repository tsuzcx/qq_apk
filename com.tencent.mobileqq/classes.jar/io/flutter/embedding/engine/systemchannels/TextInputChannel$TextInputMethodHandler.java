package io.flutter.embedding.engine.systemchannels;

import android.support.annotation.NonNull;

public abstract interface TextInputChannel$TextInputMethodHandler
{
  public abstract void clearClient();
  
  public abstract void hide();
  
  public abstract void setClient(int paramInt, @NonNull TextInputChannel.Configuration paramConfiguration);
  
  public abstract void setEditingState(@NonNull TextInputChannel.TextEditState paramTextEditState);
  
  public abstract void setPlatformViewClient(int paramInt);
  
  public abstract void show();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
 * JD-Core Version:    0.7.0.1
 */