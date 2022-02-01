package com.tencent.mobileqq.kandian.biz.viola.view;

import android.os.Bundle;
import com.tencent.mobileqq.colornote.OnColorNoteCurdListener;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaFragmentPresenter;

class ViolaFragment$3
  extends OnColorNoteCurdListener
{
  ViolaFragment$3(ViolaFragment paramViolaFragment) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    if (this.a.mPresenter.a(paramBundle, paramBoolean) != 1) {
      ViolaFragment.access$100(this.a);
    }
  }
  
  public void onDeleteColorNote(int paramInt, String paramString, boolean paramBoolean)
  {
    super.onDeleteColorNote(paramInt, paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment.3
 * JD-Core Version:    0.7.0.1
 */