package com.tencent.mobileqq.flashshow.part;

class FSRichMediaDownLoadPart$1
  implements Runnable
{
  FSRichMediaDownLoadPart$1(FSRichMediaDownLoadPart paramFSRichMediaDownLoadPart, String paramString, Object paramObject) {}
  
  public void run()
  {
    if ("rich_media_download_show".equals(this.a))
    {
      FSRichMediaDownLoadPart.a(this.this$0);
      return;
    }
    Object localObject;
    if ("rich_media_download_status".equals(this.a))
    {
      localObject = this.b;
      if ((localObject instanceof Boolean)) {
        FSRichMediaDownLoadPart.a(this.this$0, ((Boolean)localObject).booleanValue());
      }
    }
    else if ("rich_meida_download_progress".equals(this.a))
    {
      localObject = this.b;
      if ((localObject instanceof Integer)) {
        FSRichMediaDownLoadPart.a(this.this$0, ((Integer)localObject).intValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSRichMediaDownLoadPart.1
 * JD-Core Version:    0.7.0.1
 */