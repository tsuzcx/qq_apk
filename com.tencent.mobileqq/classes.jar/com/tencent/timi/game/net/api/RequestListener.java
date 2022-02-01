package com.tencent.timi.game.net.api;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;

public abstract interface RequestListener<T extends MessageMicro>
{
  public abstract void a(T paramT, FromServiceMsg paramFromServiceMsg);
  
  public abstract void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, @Nullable T paramT, @Nullable FromServiceMsg paramFromServiceMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.net.api.RequestListener
 * JD-Core Version:    0.7.0.1
 */