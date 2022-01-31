import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ntw
  implements ViewBase.OnClickListener
{
  ntw(ntu paramntu) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramViewBase.getEventAttachedData());
    QLog.d("CommentProteusUtil", 2, "comment media url : " + paramViewBase.getEventAttachedData());
    azcm.a(this.a.jdField_a_of_type_Nwk.a(), 0, localArrayList, true, "", 1888);
    if (this.a.jdField_a_of_type_Nwk.a() != null) {
      this.a.jdField_a_of_type_Nwk.a().f(this.a.jdField_a_of_type_Nwx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ntw
 * JD-Core Version:    0.7.0.1
 */