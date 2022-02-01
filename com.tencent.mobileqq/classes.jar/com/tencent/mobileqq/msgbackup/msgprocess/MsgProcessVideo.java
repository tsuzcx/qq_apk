package com.tencent.mobileqq.msgbackup.msgprocess;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.shortvideo.SVUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.im.msg.im_msg_body.RichText;

public class MsgProcessVideo
  extends MsgProcessRichMedia<MessageForShortVideo>
{
  public MsgProcessVideo(MessageForShortVideo paramMessageForShortVideo)
  {
    super(paramMessageForShortVideo);
  }
  
  protected MsgBackupResEntity a(String paramString, int paramInt)
  {
    if (!a(paramString)) {
      return null;
    }
    MsgBackupResEntity localMsgBackupResEntity = f();
    localMsgBackupResEntity.msgSubType = paramInt;
    localMsgBackupResEntity.filePath = paramString;
    a(paramString, localMsgBackupResEntity);
    paramString = a(paramInt);
    paramString.put("selfuin", ((MessageForShortVideo)this.b).selfuin);
    paramString.put("md5", ((MessageForShortVideo)this.b).md5);
    paramString.put("thumbMd5", ((MessageForShortVideo)this.b).thumbMD5);
    localMsgBackupResEntity.extraDataStr = a(paramString);
    return localMsgBackupResEntity;
  }
  
  public void a()
  {
    im_msg_body.RichText localRichText = ((MessageForShortVideo)this.b).getRichText();
    ((MessageForShortVideo)this.b).richText = localRichText;
  }
  
  public List<MsgBackupResEntity> b()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = SVUtils.a((MessageForShortVideo)this.b, "mp4");
    Object localObject1 = SVUtils.a(((MessageForShortVideo)this.b).thumbMD5, "jpg");
    int i;
    int j;
    if ((((MessageForShortVideo)this.b).busiType != 0) && (((MessageForShortVideo)this.b).busiType != 1))
    {
      if (((MessageForShortVideo)this.b).subBusiType == 2)
      {
        i = 5;
        j = 8;
      }
      else
      {
        return null;
      }
    }
    else
    {
      i = 4;
      j = 7;
    }
    localObject2 = a((String)localObject2, i);
    if (localObject2 != null) {
      localArrayList.add(localObject2);
    }
    localObject1 = a((String)localObject1, j);
    if (localObject1 != null) {
      localArrayList.add(localObject1);
    }
    return localArrayList;
  }
  
  protected int c()
  {
    return 2;
  }
  
  public void d()
  {
    if (((MessageForShortVideo)this.b).isSendFromLocal()) {
      ((MessageForShortVideo)this.b).issend = 2;
    }
    ((MessageForShortVideo)this.b).serial();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessVideo
 * JD-Core Version:    0.7.0.1
 */