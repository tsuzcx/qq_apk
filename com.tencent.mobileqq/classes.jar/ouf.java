import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;

class ouf
  implements bjoe
{
  ouf(ouc paramouc, bjnw parambjnw, int[] paramArrayOfInt, Context paramContext, otu paramotu) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bjnw.dismiss();
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfInt.length)) {
      return;
    }
    paramView = this.jdField_a_of_type_AndroidContentContext.getString(this.jdField_a_of_type_ArrayOfInt[paramInt]);
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this.jdField_a_of_type_AndroidContentContext, 2131755826);
    localQQCustomDialog.setContentView(2131558992);
    localQQCustomDialog.setMessage(String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131717275), new Object[] { paramView }));
    localQQCustomDialog.setTitle(2131717276);
    ViewGroup.LayoutParams localLayoutParams = localQQCustomDialog.getMessageTextView().getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = ViewUtils.dip2px(12.0F);
      ((ViewGroup.MarginLayoutParams)localLayoutParams).rightMargin = ViewUtils.dip2px(12.0F);
      localQQCustomDialog.getMessageTextView().setLayoutParams(localLayoutParams);
    }
    localQQCustomDialog.setTag(paramView);
    localQQCustomDialog.setPositiveButton(2131717278, new oug(this, paramView, paramInt + 1));
    localQQCustomDialog.setNegativeButton(2131717277, new ouh(this));
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ouf
 * JD-Core Version:    0.7.0.1
 */