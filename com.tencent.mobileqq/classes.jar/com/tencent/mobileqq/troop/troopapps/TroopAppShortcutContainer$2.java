package com.tencent.mobileqq.troop.troopapps;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class TroopAppShortcutContainer$2
  implements AbsListView.OnScrollListener
{
  int a = 0;
  int b = 0;
  
  TroopAppShortcutContainer$2(TroopAppShortcutContainer paramTroopAppShortcutContainer) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = (paramInt1 + paramInt2 - 1);
    this.b = paramInt3;
    TroopAppShortcutContainer.a(this.c, this.a);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.a == this.b - 1))
    {
      if (!TroopAppShortcutContainer.a(this.c).b()) {
        return;
      }
      if (QLog.isColorLevel())
      {
        paramAbsListView = new StringBuilder();
        paramAbsListView.append("needLoad mCurPage:");
        paramAbsListView.append(TroopAppShortcutContainer.a(this.c).c());
        QLog.d("TroopAppShortcutContainer", 2, paramAbsListView.toString());
      }
      paramAbsListView = this.c;
      TroopAppShortcutContainer.a(paramAbsListView, TroopAppShortcutContainer.a(paramAbsListView).c() + 1, 30, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer.2
 * JD-Core Version:    0.7.0.1
 */