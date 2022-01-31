import NS_KING_SOCIALIZE_META.stMetaComment;
import android.view.View;
import android.view.View.OnClickListener;

class tdw
  implements View.OnClickListener
{
  tdw(tdu paramtdu, stMetaComment paramstMetaComment) {}
  
  public void onClick(View paramView)
  {
    if (tdn.a(this.jdField_a_of_type_Tdu.a) != null)
    {
      this.jdField_a_of_type_Tdu.a.a().a(tdn.a(this.jdField_a_of_type_Tdu.a), this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment);
      this.jdField_a_of_type_Tdu.a.a = true;
      tlo.d("comment", "5 mCommentListChanged:" + this.jdField_a_of_type_Tdu.a.a);
    }
    tdn.a(this.jdField_a_of_type_Tdu.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tdw
 * JD-Core Version:    0.7.0.1
 */