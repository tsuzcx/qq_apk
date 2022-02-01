package com.tencent.mobileqq.qwallet.hb.emoji.impl;

public class HandRecognizer$DoHandTracking
  implements Runnable
{
  public int a;
  public HandRecognizer.OnPreviewFrameHandlerListener a;
  
  public void run()
  {
    Object localObject = new YtHandClassifyResult();
    if (this.this$0.a.e >= 0.01D)
    {
      HandRecognizer localHandRecognizer = this.this$0;
      int j = localHandRecognizer.doHandAlignment(localHandRecognizer.a, this.this$0.a);
      i = j;
      if (j == 0)
      {
        i = j;
        if (this.this$0.a.e >= 0.9908F)
        {
          localHandRecognizer = this.this$0;
          i = localHandRecognizer.doHandClassifyWithGesture(localHandRecognizer.a, this.jdField_a_of_type_Int, (YtHandClassifyResult)localObject);
        }
      }
    }
    else
    {
      i = -1;
    }
    if (i != 0) {
      this.this$0.a = new YtHandBox();
    }
    if (i != 0) {
      this.this$0.a = new YtHandBox();
    }
    int i = (int)(((YtHandClassifyResult)localObject).a * 100.0F);
    localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbEmojiImplHandRecognizer$OnPreviewFrameHandlerListener;
    if (localObject != null) {
      ((HandRecognizer.OnPreviewFrameHandlerListener)localObject).a(i);
    }
    if (this.this$0.a.e >= 0.9908F)
    {
      localObject = this.this$0;
      ((HandRecognizer)localObject).doHandStable(((HandRecognizer)localObject).a, this.this$0.b);
    }
    this.this$0.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.emoji.impl.HandRecognizer.DoHandTracking
 * JD-Core Version:    0.7.0.1
 */