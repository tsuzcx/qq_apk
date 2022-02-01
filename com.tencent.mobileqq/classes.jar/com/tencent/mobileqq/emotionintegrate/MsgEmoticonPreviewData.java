package com.tencent.mobileqq.emotionintegrate;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class MsgEmoticonPreviewData
  extends EmoticonPreviewData
{
  public MessageRecord a;
  private boolean b;
  
  public MsgEmoticonPreviewData(MessageRecord paramMessageRecord)
  {
    this.a = paramMessageRecord;
  }
  
  public int a(List<EmoticonPreviewData> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      EmoticonPreviewData localEmoticonPreviewData = (EmoticonPreviewData)localIterator.next();
      if ((localEmoticonPreviewData instanceof MsgEmoticonPreviewData))
      {
        Object localObject = ((MsgEmoticonPreviewData)localEmoticonPreviewData).a;
        if (((MessageRecord)localObject).uniseq == this.a.uniseq)
        {
          if (((localObject instanceof MessageForPic)) && ((this.a instanceof MessageForPic)))
          {
            localObject = (MessageForPic)localObject;
            if (((MessageForPic)localObject).md5 != null)
            {
              if (!((MessageForPic)localObject).md5.equals(((MessageForPic)this.a).md5)) {
                continue;
              }
              return paramList.indexOf(localEmoticonPreviewData);
            }
          }
          return paramList.indexOf(localEmoticonPreviewData);
        }
      }
    }
    return paramList.size() - 1;
  }
  
  public Drawable a(Context paramContext)
  {
    EmotionPreviewData localEmotionPreviewData = new EmotionPreviewData(this.a);
    paramContext = EmotionDataManager.a(paramContext, localEmotionPreviewData);
    this.b = localEmotionPreviewData.d;
    return paramContext;
  }
  
  public void a(Bundle paramBundle, int paramInt)
  {
    super.a(paramBundle, paramInt);
    paramBundle.putString("cur_msg_uin", this.a.frienduin);
    paramBundle.putInt("cur_msg_uin_type", this.a.istroop);
    paramBundle.putLong("cur_msg_uniseq", this.a.uniseq);
  }
  
  public boolean a()
  {
    return this.a instanceof MessageForMarketFace;
  }
  
  public boolean a(EmoticonPreviewData paramEmoticonPreviewData)
  {
    boolean bool3 = paramEmoticonPreviewData instanceof MsgEmoticonPreviewData;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramEmoticonPreviewData = ((MsgEmoticonPreviewData)paramEmoticonPreviewData).a;
      bool1 = bool2;
      if (paramEmoticonPreviewData != null)
      {
        bool1 = bool2;
        if (this.a != null)
        {
          bool1 = bool2;
          if (paramEmoticonPreviewData.shmsgseq == this.a.shmsgseq)
          {
            bool1 = bool2;
            if (paramEmoticonPreviewData.msgUid == this.a.msgUid) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public long b()
  {
    return this.a.uniseq;
  }
  
  public EmoticonPreviewData b(Bundle paramBundle)
  {
    if (paramBundle.containsKey("cur_msg_uniseq"))
    {
      QLog.d("MsgEmoticonPreviewData", 1, "doRestoreSaveInstanceState");
      String str = paramBundle.getString("cur_msg_uin");
      int i = paramBundle.getInt("cur_msg_uin_type");
      long l = paramBundle.getLong("cur_msg_uniseq");
      paramBundle = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramBundle instanceof QQAppInterface)) {
        return new MsgEmoticonPreviewData(((QQAppInterface)paramBundle).getMessageFacade().b(str, i, l));
      }
    }
    return null;
  }
  
  public EmoticonInfo c()
  {
    MessageRecord localMessageRecord = this.a;
    if ((localMessageRecord instanceof MessageForMarketFace)) {
      return (EmoticonInfo)EmotionDataManager.a((MessageForMarketFace)localMessageRecord);
    }
    return null;
  }
  
  public CustomEmotionData d()
  {
    Object localObject = this.a;
    if (((localObject instanceof MessageForPic)) && (((MessageForPic)localObject).md5 != null))
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((IFavroamingDBManagerService)((QQAppInterface)localObject).getRuntimeService(IFavroamingDBManagerService.class)).getEmoticonDataList();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject).next();
            if (((MessageForPic)this.a).md5.equalsIgnoreCase(localCustomEmotionData.md5)) {
              return localCustomEmotionData;
            }
          }
        }
      }
    }
    return null;
  }
  
  public boolean e()
  {
    return this.b;
  }
  
  public boolean f()
  {
    MessageRecord localMessageRecord = this.a;
    if (((localMessageRecord instanceof MessageForPic)) && (((MessageForPic)localMessageRecord).picExtraData != null))
    {
      int i = ((MessageForPic)this.a).picExtraData.from;
      if ((i == 1) || (i == 2)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean g()
  {
    MessageRecord localMessageRecord = this.a;
    if (((localMessageRecord instanceof MessageForPic)) && (((MessageForPic)localMessageRecord).picExtraData != null)) {
      return ((MessageForPic)this.a).picExtraData.isSelfieFace();
    }
    return false;
  }
  
  public String h()
  {
    MessageRecord localMessageRecord = this.a;
    if (((localMessageRecord instanceof MessageForPic)) && (((MessageForPic)localMessageRecord).picExtraData != null)) {
      return ((MessageForPic)this.a).picExtraData.mTemplateId;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.MsgEmoticonPreviewData
 * JD-Core Version:    0.7.0.1
 */