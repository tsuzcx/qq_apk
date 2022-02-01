package com.tencent.mobileqq.litelivesdk.afwraper.event.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class EventImpl
{
  static EventImpl b = new EventImpl();
  ConcurrentHashMap<Integer, ConcurrentLinkedQueue<OnEvent>> a = new ConcurrentHashMap();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.afwraper.event.impl.EventImpl
 * JD-Core Version:    0.7.0.1
 */