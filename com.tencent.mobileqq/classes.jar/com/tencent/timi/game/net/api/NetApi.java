package com.tencent.timi.game.net.api;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.timi.game.router.IService;
import mqq.app.NewIntent;

public abstract interface NetApi
  extends IService
{
  public abstract <T extends MessageMicro> void a(NewIntent paramNewIntent, Class<T> paramClass, RequestListener<T> paramRequestListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.net.api.NetApi
 * JD-Core Version:    0.7.0.1
 */