package com.tencent.mobileqq.guild.message.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.message.api.IGuildAioMsgFilterApi;
import com.tencent.mobileqq.guild.message.api.IGuildAioMsgFilterApi.MsgSeqItem;
import java.util.HashMap;

public class GuildAioMsgFilterApiImpl
  implements IGuildAioMsgFilterApi
{
  public IGuildAioMsgFilterApi.MsgSeqItem mCurAIOLatestMsgSeqItem;
  public IGuildAioMsgFilterApi.MsgSeqItem mLatestMsgSeqItem;
  public HashMap<String, IGuildAioMsgFilterApi.MsgSeqItem> mOnlinePushLatestMsgSeqMap = new HashMap();
  public IGuildAioMsgFilterApi.MsgSeqItem mReadLatestMsgSeqItem;
  
  public IGuildAioMsgFilterApi.MsgSeqItem getCurAioLatestMsgSeqItem()
  {
    try
    {
      IGuildAioMsgFilterApi.MsgSeqItem localMsgSeqItem = this.mCurAIOLatestMsgSeqItem;
      return localMsgSeqItem;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public IGuildAioMsgFilterApi.MsgSeqItem getLatestMsgSeqItem()
  {
    try
    {
      IGuildAioMsgFilterApi.MsgSeqItem localMsgSeqItem = this.mLatestMsgSeqItem;
      return localMsgSeqItem;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public IGuildAioMsgFilterApi.MsgSeqItem getOnlinePushLatestMsgSeqItem(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return null;
      }
      bool = this.mOnlinePushLatestMsgSeqMap.containsKey(paramString);
      if (!bool) {
        return null;
      }
      paramString = (IGuildAioMsgFilterApi.MsgSeqItem)this.mOnlinePushLatestMsgSeqMap.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  public IGuildAioMsgFilterApi.MsgSeqItem getReadLatestMsgSeqItem()
  {
    try
    {
      IGuildAioMsgFilterApi.MsgSeqItem localMsgSeqItem = this.mReadLatestMsgSeqItem;
      return localMsgSeqItem;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void resetCurAioLatestMsgSeqItem()
  {
    try
    {
      this.mLatestMsgSeqItem = null;
      this.mCurAIOLatestMsgSeqItem = null;
      this.mReadLatestMsgSeqItem = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void updateCurAioLatestMsgSeqItem(IGuildAioMsgFilterApi.MsgSeqItem paramMsgSeqItem, boolean paramBoolean)
  {
    if (paramMsgSeqItem == null) {
      return;
    }
    try
    {
      if ((this.mCurAIOLatestMsgSeqItem == null) || (paramMsgSeqItem.b >= this.mCurAIOLatestMsgSeqItem.b) || (paramBoolean)) {
        this.mCurAIOLatestMsgSeqItem = paramMsgSeqItem;
      }
      return;
    }
    finally {}
  }
  
  public void updateLatestMsgSeqItem(IGuildAioMsgFilterApi.MsgSeqItem paramMsgSeqItem, boolean paramBoolean)
  {
    if (paramMsgSeqItem == null) {
      return;
    }
    try
    {
      if ((this.mLatestMsgSeqItem == null) || (paramMsgSeqItem.b >= this.mLatestMsgSeqItem.b) || (paramBoolean)) {
        this.mLatestMsgSeqItem = paramMsgSeqItem;
      }
      return;
    }
    finally {}
  }
  
  public void updateOnlinePushLatestMsgSeqItem(String paramString, IGuildAioMsgFilterApi.MsgSeqItem paramMsgSeqItem, boolean paramBoolean)
  {
    if ((paramMsgSeqItem != null) && (paramString != null)) {
      try
      {
        if ((!this.mOnlinePushLatestMsgSeqMap.containsKey(paramString)) || (paramMsgSeqItem.b >= ((IGuildAioMsgFilterApi.MsgSeqItem)this.mOnlinePushLatestMsgSeqMap.get(paramString)).b) || (paramBoolean)) {
          this.mOnlinePushLatestMsgSeqMap.put(paramString, paramMsgSeqItem);
        }
        return;
      }
      finally {}
    }
  }
  
  public void updateReadLatestMsgSeqItem(IGuildAioMsgFilterApi.MsgSeqItem paramMsgSeqItem, boolean paramBoolean)
  {
    if (paramMsgSeqItem == null) {
      return;
    }
    try
    {
      if ((this.mReadLatestMsgSeqItem == null) || (paramMsgSeqItem.b >= this.mReadLatestMsgSeqItem.b) || (paramBoolean)) {
        this.mReadLatestMsgSeqItem = paramMsgSeqItem;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.GuildAioMsgFilterApiImpl
 * JD-Core Version:    0.7.0.1
 */