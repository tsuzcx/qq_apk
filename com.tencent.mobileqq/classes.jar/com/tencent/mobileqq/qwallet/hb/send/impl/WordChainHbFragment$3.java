package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.qwallet.temp.ISoftKeyboardObserverTemp;
import com.tencent.mobileqq.qroute.QRoute;

class WordChainHbFragment$3
  implements View.OnFocusChangeListener
{
  WordChainHbFragment$3(WordChainHbFragment paramWordChainHbFragment) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      WordChainHbFragment.a(this.a, (ISoftKeyboardObserverTemp)QRoute.api(ISoftKeyboardObserverTemp.class));
      WordChainHbFragment.a(this.a).newSoftKeyboardObserverTempImpl(this.a.a, new WordChainHbFragment.3.1(this));
      WordChainHbFragment.a(this.a, 8);
      return;
    }
    WordChainHbFragment.a(this.a, 0);
    if (WordChainHbFragment.a(this.a) != null) {
      WordChainHbFragment.a(this.a).destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.WordChainHbFragment.3
 * JD-Core Version:    0.7.0.1
 */