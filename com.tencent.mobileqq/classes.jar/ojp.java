import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ojp
  implements ViewBase.OnClickListener
{
  ojp(ojn paramojn) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramViewBase.getEventAttachedData());
    QLog.d("CommentProteusUtil", 2, "comment media url : " + paramViewBase.getEventAttachedData());
    bcgq.a(this.a.jdField_a_of_type_Omg.a(), 0, localArrayList, true, "", 1888);
    if (this.a.jdField_a_of_type_Omg.a() != null) {
      this.a.jdField_a_of_type_Omg.a().f(this.a.jdField_a_of_type_Omt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ojp
 * JD-Core Version:    0.7.0.1
 */