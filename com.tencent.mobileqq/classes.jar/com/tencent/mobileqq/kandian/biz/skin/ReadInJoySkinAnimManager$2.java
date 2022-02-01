package com.tencent.mobileqq.kandian.biz.skin;

import com.tencent.mobileqq.kandian.base.view.widget.pullrefresh.SkinPullRefreshHeader;
import java.util.ArrayList;

class ReadInJoySkinAnimManager$2
  implements Runnable
{
  int a = 0;
  
  ReadInJoySkinAnimManager$2(ReadInJoySkinAnimManager paramReadInJoySkinAnimManager) {}
  
  public void run()
  {
    if ((ReadInJoySkinAnimManager.a(this.this$0) != null) && (ReadInJoySkinAnimManager.a(this.this$0).size() > 0))
    {
      if (this.a >= ReadInJoySkinAnimManager.a(this.this$0).size()) {
        this.a = 0;
      }
      ReadInJoySkinAnimManager localReadInJoySkinAnimManager = this.this$0;
      ArrayList localArrayList = ReadInJoySkinAnimManager.a(localReadInJoySkinAnimManager);
      int i = this.a;
      this.a = (i + 1);
      ReadInJoySkinAnimManager.a(localReadInJoySkinAnimManager, ((ReadInJoySkinAnimManager.PngWrapper)localArrayList.get(i)).a);
      ((SkinPullRefreshHeader)ReadInJoySkinAnimManager.a(this.this$0)).requestLayout();
      ((SkinPullRefreshHeader)ReadInJoySkinAnimManager.b(this.this$0)).postDelayed(this, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinAnimManager.2
 * JD-Core Version:    0.7.0.1
 */