package com.tencent.mobileqq.shortvideo;

class ShortVideoPreDownloader$4
  implements Runnable
{
  ShortVideoPreDownloader$4(ShortVideoPreDownloader paramShortVideoPreDownloader, ShortVideoReq paramShortVideoReq) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start pre download short video type=");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append(" uniseq=");
    localStringBuilder.append(this.a.e.g);
    localStringBuilder.append(", uuid=");
    localStringBuilder.append(this.a.e.a);
    ShortVideoPreDownloader.a("consumeShortVideo", localStringBuilder.toString());
    this.this$0.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.4
 * JD-Core Version:    0.7.0.1
 */