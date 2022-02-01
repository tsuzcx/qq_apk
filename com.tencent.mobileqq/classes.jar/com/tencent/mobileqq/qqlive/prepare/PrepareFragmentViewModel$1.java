package com.tencent.mobileqq.qqlive.prepare;

import androidx.lifecycle.MutableLiveData;
import java.util.ArrayList;
import java.util.List;

class PrepareFragmentViewModel$1
  extends GameListCallback
{
  PrepareFragmentViewModel$1(PrepareFragmentViewModel paramPrepareFragmentViewModel, boolean paramBoolean) {}
  
  public void a(List<GameItem> paramList)
  {
    super.a(paramList);
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.b.c.setValue(paramList);
      if (this.a) {
        this.b.h.setValue(((List)this.b.c.getValue()).get(0));
      }
    }
  }
  
  public void onFailed(int paramInt, String paramString)
  {
    super.onFailed(paramInt, paramString);
    this.b.c.setValue(new ArrayList());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.PrepareFragmentViewModel.1
 * JD-Core Version:    0.7.0.1
 */