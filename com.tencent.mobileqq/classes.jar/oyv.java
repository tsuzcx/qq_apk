import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.tencent.biz.troopgift.GridListAdapter;
import com.tencent.biz.troopgift.GridListAdapter.Holder;
import com.tencent.biz.troopgift.TroopGiftAioItemData;
import com.tencent.mobileqq.util.DisplayUtil;

public class oyv
  implements Runnable
{
  public oyv(GridListAdapter paramGridListAdapter, GridListAdapter.Holder paramHolder, TroopGiftAioItemData paramTroopGiftAioItemData, int paramInt) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentBizTroopgiftGridListAdapter$Holder.a.getWidth();
    int j = this.jdField_a_of_type_ComTencentBizTroopgiftGridListAdapter$Holder.a.getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    int k = DisplayUtil.a(this.jdField_a_of_type_ComTencentBizTroopgiftGridListAdapter.a, 5.0F);
    Paint localPaint = new Paint();
    localPaint.setTextSize(DisplayUtil.a(this.jdField_a_of_type_ComTencentBizTroopgiftGridListAdapter.a, 11.0F));
    float f1 = localPaint.measureText(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData.d);
    float f2 = DisplayUtil.a(this.jdField_a_of_type_ComTencentBizTroopgiftGridListAdapter.a, 2.0F);
    int m = DisplayUtil.a(this.jdField_a_of_type_ComTencentBizTroopgiftGridListAdapter.a, 1.0F);
    this.jdField_a_of_type_ComTencentBizTroopgiftGridListAdapter$Holder.a.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_ComTencentBizTroopgiftGridListAdapter.a.getResources(), GridListAdapter.a(i, j, k, f1 + f2, m, this.jdField_a_of_type_Int)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyv
 * JD-Core Version:    0.7.0.1
 */