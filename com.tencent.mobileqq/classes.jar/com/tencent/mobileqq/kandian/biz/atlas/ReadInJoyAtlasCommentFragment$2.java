package com.tencent.mobileqq.kandian.biz.atlas;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;

class ReadInJoyAtlasCommentFragment$2
  implements Runnable
{
  ReadInJoyAtlasCommentFragment$2(ReadInJoyAtlasCommentFragment paramReadInJoyAtlasCommentFragment) {}
  
  public void run()
  {
    if ((!this.this$0.d) && (this.this$0.getView() != null))
    {
      int i = this.this$0.getView().getHeight() - UIUtils.f(this.this$0.getBaseActivity());
      View localView = this.this$0.getView().findViewById(2131444267);
      if (localView != null)
      {
        ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
        if (localLayoutParams != null)
        {
          if (ReadInJoyAtlasCommentFragment.a(this.this$0) > 0) {
            i = ReadInJoyAtlasCommentFragment.a(this.this$0);
          }
          if (i > 0)
          {
            localLayoutParams.height = i;
            localView.setLayoutParams(localLayoutParams);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasCommentFragment.2
 * JD-Core Version:    0.7.0.1
 */