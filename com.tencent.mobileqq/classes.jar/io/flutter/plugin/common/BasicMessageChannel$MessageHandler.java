package io.flutter.plugin.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract interface BasicMessageChannel$MessageHandler<T>
{
  public abstract void onMessage(@Nullable T paramT, @NonNull BasicMessageChannel.Reply<T> paramReply);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugin.common.BasicMessageChannel.MessageHandler
 * JD-Core Version:    0.7.0.1
 */