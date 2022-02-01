package com.tencent.tkd.weibo.data;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface IDataTransfer
{
  public abstract void a(int paramInt, @NotNull IDataTransfer.TopicCallback paramTopicCallback);
  
  public abstract void a(@NotNull String paramString, int paramInt, @NotNull IDataTransfer.TopicCallback paramTopicCallback);
  
  public abstract void a(@Nullable byte[] paramArrayOfByte, @NotNull IDataTransfer.ContactCallback paramContactCallback);
  
  public abstract void b(@Nullable byte[] paramArrayOfByte, @NotNull IDataTransfer.ContactCallback paramContactCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.data.IDataTransfer
 * JD-Core Version:    0.7.0.1
 */