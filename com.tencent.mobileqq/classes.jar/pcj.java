import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;

class pcj
  implements bkzq
{
  pcj(pcf parampcf, bkzi parambkzi, int[] paramArrayOfInt, Context paramContext, pbx parampbx) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bkzi.dismiss();
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfInt.length)) {
      return;
    }
    paramView = this.jdField_a_of_type_AndroidContentContext.getString(this.jdField_a_of_type_ArrayOfInt[paramInt]);
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this.jdField_a_of_type_AndroidContentContext, 2131755829);
    localQQCustomDialog.setContentView(2131559019);
    localQQCustomDialog.setMessage(String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131717639), new Object[] { paramView }));
    localQQCustomDialog.setTitle(2131717640);
    ViewGroup.LayoutParams localLayoutParams = localQQCustomDialog.getMessageTextView().getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = ViewUtils.dip2px(12.0F);
      ((ViewGroup.MarginLayoutParams)localLayoutParams).rightMargin = ViewUtils.dip2px(12.0F);
      localQQCustomDialog.getMessageTextView().setLayoutParams(localLayoutParams);
    }
    localQQCustomDialog.setTag(paramView);
    localQQCustomDialog.setPositiveButton(2131717642, new pck(this, paramView, paramInt + 1));
    localQQCustomDialog.setNegativeButton(2131717641, new pcl(this));
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pcj
 * JD-Core Version:    0.7.0.1
 */