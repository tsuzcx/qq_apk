package com.tencent.mobileqq.pic.api.impl;

import android.content.Intent;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.transfile.chatpic.PicUploadFileSizeLimit;
import java.util.ArrayList;

public class PicBusImpl
  implements IPicBus
{
  public CompressInfo createCompressInfo(int paramInt, Intent paramIntent)
  {
    return PicBusiManager.a(paramInt, paramIntent);
  }
  
  public PicFowardInfo createForwardPicInfo(int paramInt, Intent paramIntent)
  {
    return PicBusiManager.a(paramInt, paramIntent);
  }
  
  public PicFowardInfo createForwardPicInfo(int paramInt1, MessageForPic paramMessageForPic, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    return PicBusiManager.a(paramInt1, paramMessageForPic, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public ArrayList<PicFowardInfo> createForwardPicInfos(int paramInt1, MessageRecord paramMessageRecord, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    return PicBusiManager.a(paramInt1, paramMessageRecord, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public PicReq createPicReq(int paramInt1, int paramInt2)
  {
    return PicBusiManager.a(paramInt1, paramInt2);
  }
  
  public PicReq createPicReq(int paramInt1, int paramInt2, int paramInt3)
  {
    return PicBusiManager.a(paramInt1, paramInt2, paramInt3);
  }
  
  public PicUploadInfo createPicUploadInfo(int paramInt, Intent paramIntent)
  {
    return PicBusiManager.a(paramInt, paramIntent);
  }
  
  public long getC2CPicSizeLimit()
  {
    return PicUploadFileSizeLimit.getLimitC2C();
  }
  
  public long getGroupPicSizeLimit()
  {
    return PicUploadFileSizeLimit.getLimitGroup();
  }
  
  public void launch(PicReq paramPicReq)
  {
    PicBusiManager.a(paramPicReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.api.impl.PicBusImpl
 * JD-Core Version:    0.7.0.1
 */