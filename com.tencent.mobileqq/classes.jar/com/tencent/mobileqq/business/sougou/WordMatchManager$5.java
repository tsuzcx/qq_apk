package com.tencent.mobileqq.business.sougou;

import com.tencent.mobileqq.app.ThreadManager;

class WordMatchManager$5
  implements Runnable
{
  WordMatchManager$5(WordMatchManager paramWordMatchManager, int paramInt) {}
  
  public void run()
  {
    if (this.a == 2) {
      this.this$0.a(this.this$0.a, 1);
    }
    do
    {
      return;
      if (this.a == 1)
      {
        if (this.this$0.e)
        {
          ThreadManager.post(new WordMatchManager.TaskHttpDownload(this.this$0, 3), 8, null, true);
          return;
        }
        this.this$0.a(true);
        return;
      }
      if (this.a == 3)
      {
        if (this.this$0.e)
        {
          ThreadManager.post(new WordMatchManager.TaskHttpDownload(this.this$0, 4), 8, null, true);
          return;
        }
        this.this$0.a(true);
        return;
      }
    } while (this.a != 4);
    this.this$0.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.WordMatchManager.5
 * JD-Core Version:    0.7.0.1
 */