package com.tencent.mobileqq.flashshow.fragment;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.flashshow.basedata.FSFeedData;
import com.tencent.mobileqq.flashshow.personal.adapter.FSPersonalInfoBlock;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;

class FSPersonalHomeFragment$3
  implements Observer<UIStateData<List<FSFeedData>>>
{
  FSPersonalHomeFragment$3(FSPersonalHomeFragment paramFSPersonalHomeFragment) {}
  
  public void a(UIStateData<List<FSFeedData>> paramUIStateData)
  {
    if (paramUIStateData.c() != 1)
    {
      if (paramUIStateData.c() == 2) {
        return;
      }
      FSPersonalHomeFragment.a(this.a).notifyLoadingComplete(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.fragment.FSPersonalHomeFragment.3
 * JD-Core Version:    0.7.0.1
 */