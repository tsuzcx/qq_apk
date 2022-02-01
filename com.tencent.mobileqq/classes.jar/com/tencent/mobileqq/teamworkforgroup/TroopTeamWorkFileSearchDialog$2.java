package com.tencent.mobileqq.teamworkforgroup;

import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class TroopTeamWorkFileSearchDialog$2
  implements AbsListView.OnScrollListener
{
  int a = 0;
  int b = 0;
  
  TroopTeamWorkFileSearchDialog$2(TroopTeamWorkFileSearchDialog paramTroopTeamWorkFileSearchDialog) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt3;
    this.a = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    try
    {
      int i = this.c.u;
      if (i > 0) {
        return;
      }
      if ((paramInt == 0) && (this.c.B != null) && (this.a == this.b - 2)) {
        if (this.c.v)
        {
          this.c.c(true);
        }
        else
        {
          this.c.c(false);
          this.c.a(this.c.x, this.c.t, this.c.A, 50, 0);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.2
 * JD-Core Version:    0.7.0.1
 */