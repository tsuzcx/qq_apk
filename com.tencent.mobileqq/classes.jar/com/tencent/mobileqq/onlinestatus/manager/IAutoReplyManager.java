package com.tencent.mobileqq.onlinestatus.manager;

import com.tencent.mobileqq.data.AutoReplyText;
import java.util.List;

public abstract interface IAutoReplyManager
  extends IStatusManager
{
  public abstract void a(List<AutoReplyText> paramList, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.IAutoReplyManager
 * JD-Core Version:    0.7.0.1
 */