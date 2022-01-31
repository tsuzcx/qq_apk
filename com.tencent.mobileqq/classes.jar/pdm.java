import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import com.tencent.biz.troopgift.GridListAdapter;
import com.tencent.biz.troopgift.GridListAdapter.Holder;
import com.tencent.mobileqq.util.DisplayUtil;

public class pdm
  implements Runnable
{
  public pdm(GridListAdapter paramGridListAdapter, GridListAdapter.Holder paramHolder) {}
  
  public void run()
  {
    int i = DisplayUtil.a(this.jdField_a_of_type_ComTencentBizTroopgiftGridListAdapter.a, 5.0F);
    new Paint().setTextSize(DisplayUtil.a(this.jdField_a_of_type_ComTencentBizTroopgiftGridListAdapter.a, 11.0F));
    int j = this.jdField_a_of_type_ComTencentBizTroopgiftGridListAdapter$Holder.a.getWidth();
    int k = this.jdField_a_of_type_ComTencentBizTroopgiftGridListAdapter$Holder.a.getHeight();
    if ((j == 0) || (k == 0)) {
      return;
    }
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadii(new float[] { i, i, i, i, i, i, i, i });
    localGradientDrawable.setColor(Color.argb(35, 0, 0, 0));
    this.jdField_a_of_type_ComTencentBizTroopgiftGridListAdapter$Holder.a.setBackgroundDrawable(localGradientDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pdm
 * JD-Core Version:    0.7.0.1
 */