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
    localArrayList.add(this.jdField_a_of_type_AndroidWidgetImageView);
    localArrayList.add(this.b);
    if (!TroopHonorAIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localArrayList, (List)localObject, paramTroopInfo, this.jdField_a_of_type_Boolean))
    {
      TroopHonorAIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localArrayList, (List)localObject, paramTroopInfo, this.jdField_a_of_type_Boolean);
      if (((List)localObject).size() <= 0) {
        break label187;
      }
      paramTroopInfo = (MutualMarkForDisplayInfo)((List)localObject).get(0);
      label102:
      if (((List)localObject).size() <= 1) {
        break label192;
      }
    }
    label187:
    label192:
    for (localObject = (MutualMarkForDisplayInfo)((List)localObject).get(1);; localObject = null)
    {
      if (paramTroopInfo == null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      }
      if (localObject == null) {
        this.b.setOnTouchListener(null);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setTitleIconLeftForMutualMark(paramTroopInfo, (MutualMarkForDisplayInfo)localObject);
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "Grp_AIO_display", "AIO_Luckyword_exp", 0, 0, "", "", "", "");
      break;
      paramTroopInfo = null;
      break label102;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.TroopHonorAIOUtils.1
 * JD-Core Version:    0.7.0.1
 */