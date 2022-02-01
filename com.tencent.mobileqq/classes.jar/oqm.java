import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class oqm
  implements ViewBase.OnClickListener
{
  oqm(oql paramoql) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (paramViewBase.getEventAttachedData() == null)
    {
      QLog.e("DailyHeaderViewController", 1, "[onClick] attach event data is null");
      return;
    }
    oqb.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_OrgJsonJSONObject);
    pkh.a(paramViewBase.getNativeView().getContext(), paramViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oqm
 * JD-Core Version:    0.7.0.1
 */