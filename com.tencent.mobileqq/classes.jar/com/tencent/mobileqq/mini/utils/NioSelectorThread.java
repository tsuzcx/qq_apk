package com.tencent.mobileqq.mini.utils;

import android.support.annotation.NonNull;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

public class NioSelectorThread
{
  private static NioSelectorThread INSTANCE;
  private volatile boolean registerSpin;
  private final Selector selector = Selector.open();
  
  private NioSelectorThread()
  {
    new Thread(new NioSelectorThread.1(this), "NioThread").start();
  }
  
  @NonNull
  public static NioSelectorThread getInstance()
  {
    try
    {
      if (INSTANCE == null) {
        INSTANCE = new NioSelectorThread();
      }
      return INSTANCE;
    }
    finally {}
  }
  
  private void loopSelect()
  {
    for (;;)
    {
      if (!this.selector.isOpen()) {
        return;
      }
      try
      {
        this.selector.select();
        Iterator localIterator = this.selector.selectedKeys().iterator();
        while (localIterator.hasNext())
        {
          SelectionKey localSelectionKey = (SelectionKey)localIterator.next();
          if (((NioSelectorThread.NioHandler)localSelectionKey.attachment()).handle(localSelectionKey)) {
            localIterator.remove();
          }
        }
        if (!this.registerSpin) {}
      }
      catch (IOException localIOException) {}
    }
    for (;;) {}
  }
  
  public void registerChannel(SelectableChannel paramSelectableChannel, int paramInt, NioSelectorThread.NioHandler paramNioHandler)
  {
    try
    {
      this.registerSpin = true;
      this.selector.wakeup();
      paramSelectableChannel.register(this.selector, paramInt, paramNioHandler);
      return;
    }
    finally
    {
      this.registerSpin = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.NioSelectorThread
 * JD-Core Version:    0.7.0.1
 */