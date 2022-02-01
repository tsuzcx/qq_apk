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
  private volatile boolean registerSpin = false;
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
    if (this.selector.isOpen()) {
      for (;;)
      {
        try
        {
          this.selector.select();
          Iterator localIterator = this.selector.selectedKeys().iterator();
          if (localIterator.hasNext())
          {
            SelectionKey localSelectionKey = (SelectionKey)localIterator.next();
            if (!((NioSelectorThread.NioHandler)localSelectionKey.attachment()).handle(localSelectionKey)) {
              continue;
            }
            localIterator.remove();
            continue;
          }
        }
        catch (IOException localIOException)
        {
          continue;
        }
        if (!this.registerSpin) {
          break;
        }
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.NioSelectorThread
 * JD-Core Version:    0.7.0.1
 */