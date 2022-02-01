package com.tencent.mobileqq.flashshow.part;

import com.tencent.mobileqq.flashshow.manager.FSRichMediaDownLoadManager.IRichMediaListener;

class FSSharePart$6
  implements FSRichMediaDownLoadManager.IRichMediaListener
{
  FSSharePart$6(FSSharePart paramFSSharePart) {}
  
  public void a(int paramInt)
  {
    if (this.a.E() != null) {
      this.a.c("rich_meida_download_progress", Integer.valueOf(paramInt));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a.E() != null) {
      this.a.c("rich_media_download_status", Boolean.valueOf(paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSSharePart.6
 * JD-Core Version:    0.7.0.1
 */