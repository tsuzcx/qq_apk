package com.tencent.mobileqq.tinyid;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.tinyid.impl.TinyIDHandler.Listener;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.Nullable;

@Service(process={""})
public abstract interface ITinyIDHandler
  extends IRuntimeService
{
  @Nullable
  public abstract String getClassName();
  
  public abstract void removeListener(String paramString, @Nullable TinyIDHandler.Listener paramListener);
  
  public abstract void reqGetTinyID(@Nullable TinyIDHandler.Listener paramListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tinyid.ITinyIDHandler
 * JD-Core Version:    0.7.0.1
 */