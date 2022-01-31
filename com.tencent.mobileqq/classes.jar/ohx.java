import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;

class ohx
  implements bfph
{
  ohx(ohs paramohs, bfpc parambfpc, int[] paramArrayOfInt, Context paramContext, ohl paramohl) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bfpc.dismiss();
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfInt.length)) {
      return;
    }
    paramView = this.jdField_a_of_type_AndroidContentContext.getString(this.jdField_a_of_type_ArrayOfInt[paramInt]);
    bbgu localbbgu = new bbgu(this.jdField_a_of_type_AndroidContentContext, 2131755791);
    localbbgu.setContentView(2131558883);
    localbbgu.setMessage(String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131718363), new Object[] { paramView }));
    localbbgu.setTitle(2131718364);
    ViewGroup.LayoutParams localLayoutParams = localbbgu.getMessageTextView().getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = bbll.a(12.0F);
      ((ViewGroup.MarginLayoutParams)localLayoutParams).rightMargin = bbll.a(12.0F);
      localbbgu.getMessageTextView().setLayoutParams(localLayoutParams);
    }
    localbbgu.setTag(paramView);
    localbbgu.setPositiveButton(2131718366, new ohy(this, paramView, paramInt + 1));
    localbbgu.setNegativeButton(2131718365, new ohz(this));
    localbbgu.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ohx
 * JD-Core Version:    0.7.0.1
 */