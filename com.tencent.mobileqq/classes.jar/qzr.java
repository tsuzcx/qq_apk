import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qzr
  implements View.OnClickListener
{
  qzr(qzq paramqzq, boolean paramBoolean, aanz paramaanz, String paramString, int paramInt1, int paramInt2, ViewGroup paramViewGroup) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Qzq.b();
    Object localObject;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aanz != null))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("from", String.valueOf(16));
      ((Bundle)localObject).putString("redpackid", this.jdField_a_of_type_JavaLangString);
      ((Bundle)localObject).putInt("redpack_type", this.jdField_a_of_type_Int);
      ((Bundle)localObject).putInt("plat_source", this.b);
      ((Bundle)localObject).putBoolean("open_readinjoy_tab", true);
      this.jdField_a_of_type_Aanz.a(127, (Bundle)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bmqa.d(1);
      bmqa.a(true);
      bmqa.a(true);
      localObject = this.jdField_a_of_type_AndroidViewViewGroup.getContext();
      Intent localIntent = ohp.a((Context)localObject, 16);
      localIntent.putExtra("redpackid", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("redpack_type", this.jdField_a_of_type_Int);
      localIntent.putExtra("plat_source", this.b);
      ((Context)localObject).startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qzr
 * JD-Core Version:    0.7.0.1
 */