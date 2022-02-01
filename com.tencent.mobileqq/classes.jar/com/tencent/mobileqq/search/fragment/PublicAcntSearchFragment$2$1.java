package com.tencent.mobileqq.search.fragment;

import android.view.View;
import java.util.List;

class PublicAcntSearchFragment$2$1
  implements Runnable
{
  PublicAcntSearchFragment$2$1(PublicAcntSearchFragment.2 param2, boolean paramBoolean) {}
  
  public void run()
  {
    PublicAcntSearchFragment.c(this.b.a).setVisibility(8);
    if ((this.a) && (this.b.a.r != null) && (this.b.a.r.size() > 0)) {
      PublicAcntSearchFragment.b(this.b.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.PublicAcntSearchFragment.2.1
 * JD-Core Version:    0.7.0.1
 */