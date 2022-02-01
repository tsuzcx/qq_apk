package com.tencent.mobileqq.teamworkforgroup;

import android.os.Handler;
import java.util.ArrayList;
import java.util.List;

class TroopTeamWorkFileSearchDialog$9
  extends GroupTeamWorkObserver
{
  TroopTeamWorkFileSearchDialog$9(TroopTeamWorkFileSearchDialog paramTroopTeamWorkFileSearchDialog) {}
  
  public void a(boolean paramBoolean1, int paramInt1, String arg3, List<GPadInfo> paramList, int paramInt2, boolean paramBoolean2)
  {
    ??? = this.a;
    ???.u -= 1;
    if ((paramBoolean1) && (paramInt1 == 0)) {
      synchronized (this.a.p)
      {
        if (this.a.B != null) {
          this.a.B.clear();
        } else {
          this.a.B = new ArrayList();
        }
        ??? = this.a;
        ???.A = paramInt2;
        ???.v = paramBoolean2;
        if (paramList != null)
        {
          ???.w = paramList.size();
          synchronized (this.a.p)
          {
            this.a.B.addAll(paramList);
            ??? = this.a.m.obtainMessage(5);
            this.a.m.sendMessage(???);
            return;
          }
        }
      }
    }
    if (this.a.q) {
      ??? = this.a.m.obtainMessage(3);
    } else {
      ??? = this.a.m.obtainMessage(5);
    }
    this.a.m.sendMessage(???);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.9
 * JD-Core Version:    0.7.0.1
 */