package com.tencent.richframework.text.rich.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class RichTextPreloadEvent
  extends SimpleBaseEvent
{
  public static final int EVENT_PRELOAD_AT_CLICK_CALLBACK = 2;
  public static final int EVENT_PRELOAD_EMOJI_CALLBACK = 1;
  public static final int EVENT_PRELOAD_HASH_TAG_CLICK_CALLBACK = 3;
  public String businessTag;
  public String cacheKey;
  public int eventType;
  public String tagName;
  public String uin;
  
  public RichTextPreloadEvent(int paramInt, String paramString1, String paramString2)
  {
    this.eventType = paramInt;
    this.businessTag = paramString1;
    this.cacheKey = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.text.rich.event.RichTextPreloadEvent
 * JD-Core Version:    0.7.0.1
 */