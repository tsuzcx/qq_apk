package com.tencent.qapmsdk.impl.e;

import android.os.Handler;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.resource.meta.SingleItem;
import com.tencent.qapmsdk.resource.meta.TagItem;
import java.util.Vector;

public class a
{
  static volatile boolean a = false;
  private static volatile a b = null;
  private Vector<TagItem> c = new Vector();
  private Vector<SingleItem> d = new Vector();
  
  public static a a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new a();
      }
      return b;
    }
    finally {}
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramLong3 - paramLong2 < 0L) {
      return;
    }
    TagItem localTagItem = new TagItem();
    localTagItem.duringTime = 0.0D;
    localTagItem.stage = paramString1;
    localTagItem.subStage = paramString2;
    localTagItem.extraInfo = "";
    localTagItem.eventTime = (paramLong2 / 1000.0D);
    localTagItem.tagId = paramLong1;
    localTagItem.type = 0;
    localTagItem.isSlow = paramBoolean;
    this.c.add(localTagItem);
    localTagItem = new TagItem();
    localTagItem.duringTime = (paramLong3 - paramLong2);
    localTagItem.stage = paramString1;
    localTagItem.subStage = paramString2;
    localTagItem.extraInfo = "";
    localTagItem.eventTime = (paramLong3 / 1000.0D);
    localTagItem.tagId = paramLong1;
    localTagItem.isSlow = paramBoolean;
    localTagItem.type = 1;
    this.c.add(localTagItem);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    SingleItem localSingleItem = new SingleItem();
    localSingleItem.costTime = paramLong1;
    localSingleItem.stage = paramString1;
    localSingleItem.extraData = paramString2;
    localSingleItem.eventTime = paramLong2;
    this.d.add(localSingleItem);
  }
  
  Vector<TagItem> b()
  {
    return this.c;
  }
  
  Vector<SingleItem> c()
  {
    return this.d;
  }
  
  public void d()
  {
    if (!a)
    {
      new Handler(ThreadManager.getMonitorThreadLooper()).postDelayed(b.a(), 5000L);
      a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.e.a
 * JD-Core Version:    0.7.0.1
 */