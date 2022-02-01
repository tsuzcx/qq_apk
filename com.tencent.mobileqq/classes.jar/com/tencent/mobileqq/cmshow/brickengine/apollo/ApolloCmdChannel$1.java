package com.tencent.mobileqq.cmshow.brickengine.apollo;

import com.tencent.mobileqq.apollo.channel.IRequestHandler;
import java.util.Comparator;

class ApolloCmdChannel$1
  implements Comparator<IRequestHandler>
{
  ApolloCmdChannel$1(ApolloCmdChannel paramApolloCmdChannel) {}
  
  public int a(IRequestHandler paramIRequestHandler1, IRequestHandler paramIRequestHandler2)
  {
    return paramIRequestHandler1.a() - paramIRequestHandler2.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel.1
 * JD-Core Version:    0.7.0.1
 */