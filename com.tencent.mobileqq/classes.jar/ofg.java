import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ofg
  implements ViewBase.OnClickListener
{
  ofg(ofe paramofe) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramViewBase.getEventAttachedData());
    QLog.d("CommentProteusUtil", 2, "comment media url : " + paramViewBase.getEventAttachedData());
    badh.a(this.a.jdField_a_of_type_Ohv.a(), 0, localArrayList, true, "", 1888);
    if (this.a.jdField_a_of_type_Ohv.a() != null) {
      this.a.jdField_a_of_type_Ohv.a().f(this.a.jdField_a_of_type_Oii);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ofg
 * JD-Core Version:    0.7.0.1
 */