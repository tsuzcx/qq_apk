import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class rdj
  implements View.OnClickListener
{
  rdj(rdd paramrdd) {}
  
  public void onClick(View paramView)
  {
    pnw localpnw = this.a.jdField_a_of_type_Szd.a().a();
    if (localpnw != null) {
      localpnw.a(null, ((qfw)this.a.jdField_a_of_type_JavaLangObject).a(), 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rdj
 * JD-Core Version:    0.7.0.1
 */