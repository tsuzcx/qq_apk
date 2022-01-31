import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

class qgj
  implements View.OnClickListener
{
  qgj(qgi paramqgi, boolean paramBoolean, ymk paramymk, String paramString, int paramInt1, int paramInt2, ViewGroup paramViewGroup) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Qgi.b();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ymk != null))
    {
      paramView = new Bundle();
      paramView.putString("from", String.valueOf(16));
      paramView.putString("redpackid", this.jdField_a_of_type_JavaLangString);
      paramView.putInt("redpack_type", this.jdField_a_of_type_Int);
      paramView.putInt("plat_source", this.b);
      paramView.putBoolean("open_readinjoy_tab", true);
      this.jdField_a_of_type_Ymk.a(127, paramView);
      return;
    }
    bjxj.e(1);
    bjxj.a(true);
    bjxj.a(true);
    paramView = this.jdField_a_of_type_AndroidViewViewGroup.getContext();
    Intent localIntent = nxu.a(paramView, 16);
    localIntent.putExtra("redpackid", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("redpack_type", this.jdField_a_of_type_Int);
    localIntent.putExtra("plat_source", this.b);
    paramView.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qgj
 * JD-Core Version:    0.7.0.1
 */