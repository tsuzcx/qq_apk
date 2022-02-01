package com.tencent.tkd.weibo.data;

import com.tencent.tkd.weibo.bean.TweetTopicItem;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public abstract interface IDataTransfer$TopicCallback
{
  public abstract void a(int paramInt, String paramString, @Nullable byte[] paramArrayOfByte, boolean paramBoolean, @Nullable List<TweetTopicItem> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.data.IDataTransfer.TopicCallback
 * JD-Core Version:    0.7.0.1
 */