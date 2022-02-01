import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nsl
  implements View.OnClickListener
{
  nsl(nsj paramnsj, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
    nsj.a(this.jdField_a_of_type_Nsj).startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nsl
 * JD-Core Version:    0.7.0.1
 */