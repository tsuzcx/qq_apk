import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ofd
  implements ViewBase.OnClickListener
{
  ofd(ofb paramofb) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramViewBase.getEventAttachedData());
    QLog.d("CommentProteusUtil", 2, "comment media url : " + paramViewBase.getEventAttachedData());
    badv.a(this.a.jdField_a_of_type_Ohs.a(), 0, localArrayList, true, "", 1888);
    if (this.a.jdField_a_of_type_Ohs.a() != null) {
      this.a.jdField_a_of_type_Ohs.a().f(this.a.jdField_a_of_type_Oif);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ofd
 * JD-Core Version:    0.7.0.1
 */