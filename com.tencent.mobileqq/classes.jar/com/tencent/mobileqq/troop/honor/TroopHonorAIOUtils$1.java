package com.tencent.mobileqq.troop.honor;

import android.app.Activity;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.ITroopInfoCallback;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import java.util.ArrayList;
import java.util.List;

final class TroopHonorAIOUtils$1
  implements ITroopInfoCallback
{
  TroopHonorAIOUtils$1(ImageView paramImageView1, ImageView paramImageView2, QQAppInterface paramQQAppInterface, Activity paramActivity, boolean paramBoolean, NavBarAIO paramNavBarAIO) {}
  
  public void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ArrayList();
    localArrayList.add(this.a);
    localArrayList.add(this.b);
    if (!TroopHonorAIOUtils.a(this.c, this.d, localArrayList, (List)localObject, paramTroopInfo, this.e)) {
      TroopHonorAIOUtils.b(this.c, this.d, localArrayList, (List)localObject, paramTroopInfo, this.e);
    } else {
      ReportController.b(this.c, "dc00899", "Grp_AIO", "", "Grp_AIO_display", "AIO_Luckyword_exp", 0, 0, "", "", "", "");
    }
    if (((List)localObject).size() > 0) {
      paramTroopInfo = (MutualMarkForDisplayInfo)((List)localObject).get(0);
    } else {
      paramTroopInfo = null;
    }
    if (((List)localObject).size() > 1) {
      localObject = (MutualMarkForDisplayInfo)((List)localObject).get(1);
    } else {
      localObject = null;
    }
    if (paramTroopInfo == null) {
      this.a.setOnTouchListener(null);
    }
    if (localObject == null) {
      this.b.setOnTouchListener(null);
    }
    this.f.setTitleIconLeftForMutualMark(paramTroopInfo, (MutualMarkForDisplayInfo)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.TroopHonorAIOUtils.1
 * JD-Core Version:    0.7.0.1
 */