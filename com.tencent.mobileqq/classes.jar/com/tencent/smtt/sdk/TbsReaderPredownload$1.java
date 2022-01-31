package com.tencent.smtt.sdk;

class TbsReaderPredownload$1
  implements TbsReaderView.ReaderCallback
{
  TbsReaderPredownload$1(TbsReaderPredownload paramTbsReaderPredownload) {}
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    switch (paramInteger.intValue())
    {
    }
    int i;
    do
    {
      return;
      i = ((Integer)paramObject1).intValue();
    } while (5014 == i);
    if (5013 == i) {
      this.this$0.notifyCallback(0);
    }
    for (;;)
    {
      this.this$0.mPluginExt = "";
      this.this$0.sendDelayed(3, 100);
      return;
      if (i == 0) {
        this.this$0.notifyCallback(0);
      } else {
        this.this$0.notifyCallback(-1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsReaderPredownload.1
 * JD-Core Version:    0.7.0.1
 */