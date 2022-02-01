package com.tencent.mobileqq.troop.quickat.ui;

import java.util.List;

class AllMemberItemViewWrapper$3$1
  implements Runnable
{
  AllMemberItemViewWrapper$3$1(AllMemberItemViewWrapper.3 param3, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, boolean paramBoolean3) {}
  
  public void run()
  {
    this.g.a.a(this.a, this.b, this.c, 0, 0, this.d, this.e, this.f);
    if ((!this.f) && (AllMemberItemViewWrapper.c(this.g.a).c()))
    {
      List localList = AllMemberItemViewWrapper.c(this.g.a).e();
      if (localList.size() >= 1) {
        localList.remove(0);
      }
      AllMemberItemViewWrapper.c(this.g.a).a(localList);
      return;
    }
    AllMemberItemViewWrapper.c(this.g.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AllMemberItemViewWrapper.3.1
 * JD-Core Version:    0.7.0.1
 */