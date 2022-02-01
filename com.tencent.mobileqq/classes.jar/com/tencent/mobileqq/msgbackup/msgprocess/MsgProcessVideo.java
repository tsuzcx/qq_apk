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
  
  protected int a()
  {
    return 2;
  }
  
  protected MsgBackupResEntity a(String paramString, int paramInt)
  {
    if (!a(paramString)) {
      return null;
    }
    MsgBackupResEntity localMsgBackupResEntity = a();
    localMsgBackupResEntity.msgSubType = paramInt;
    localMsgBackupResEntity.filePath = paramString;
    a(paramString, localMsgBackupResEntity);
    paramString = a(paramInt);
    paramString.put("selfuin", ((MessageForShortVideo)this.a).selfuin);
    paramString.put("md5", ((MessageForShortVideo)this.a).md5);
    paramString.put("thumbMd5", ((MessageForShortVideo)this.a).thumbMD5);
    localMsgBackupResEntity.extraDataStr = a(paramString);
    return localMsgBackupResEntity;
  }
  
  public List<MsgBackupResEntity> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = SVUtils.a((MessageForShortVideo)this.a, "mp4");
    Object localObject1 = SVUtils.a(((MessageForShortVideo)this.a).thumbMD5, "jpg");
    int i;
    int j;
    if ((((MessageForShortVideo)this.a).busiType != 0) && (((MessageForShortVideo)this.a).busiType != 1))
    {
      if (((MessageForShortVideo)this.a).subBusiType == 2)
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
  
  public void a()
  {
    im_msg_body.RichText localRichText = ((MessageForShortVideo)this.a).getRichText();
    ((MessageForShortVideo)this.a).richText = localRichText;
  }
  
  public void b()
  {
    if (((MessageForShortVideo)this.a).isSendFromLocal()) {
      ((MessageForShortVideo)this.a).issend = 2;
    }
    ((MessageForShortVideo)this.a).serial();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessVideo
 * JD-Core Version:    0.7.0.1
 */