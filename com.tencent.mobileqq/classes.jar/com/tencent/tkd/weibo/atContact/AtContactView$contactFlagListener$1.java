package com.tencent.tkd.weibo.atContact;

import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/weibo/atContact/AtContactView$contactFlagListener$1", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "hasFollowFlag", "hasFansFlag", "", "Lcom/tencent/tkd/weibo/data/ContactFlagListener;", "invoke", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class AtContactView$contactFlagListener$1
  implements Function2<Integer, Integer, Unit>
{
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 1)) {
      AtContactView.a(this.a).setCurrentItem(1, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.atContact.AtContactView.contactFlagListener.1
 * JD-Core Version:    0.7.0.1
 */