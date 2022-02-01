package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryCallback;

class EmoticonManagerServiceImpl$3
  implements QueryCallback<PicEmoticonInfo>
{
  EmoticonManagerServiceImpl$3(EmoticonManagerServiceImpl paramEmoticonManagerServiceImpl, boolean paramBoolean, BaseSessionInfo paramBaseSessionInfo) {}
  
  public void a(PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramPicEmoticonInfo != null) && (paramPicEmoticonInfo.emoticon != null))
    {
      if (this.a)
      {
        EmoticonOperateReport.reportNewSoundEvent(this.c.app, "0X800A937", this.b.a, paramPicEmoticonInfo.emoticon.epId);
        return;
      }
      EmoticonOperateReport.reportNewSoundEvent(this.c.app, "0X800A936", this.b.a, paramPicEmoticonInfo.emoticon.epId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */