package com.tencent.mobileqq.emosm.favroaming;

import com.tencent.mobileqq.emosm.api.IEmoticonFromGroupDBManagerService;

class EmoticonFromGroupManager$4
  implements Runnable
{
  EmoticonFromGroupManager$4(EmoticonFromGroupManager paramEmoticonFromGroupManager) {}
  
  public void run()
  {
    EmoticonFromGroupManager.a(this.this$0).setCountOfSpare(FavEmoConstant.a - this.this$0.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager.4
 * JD-Core Version:    0.7.0.1
 */