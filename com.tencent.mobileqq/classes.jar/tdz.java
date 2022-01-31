import NS_KING_SOCIALIZE_META.stMetaComment;
import NS_KING_SOCIALIZE_META.stMetaReply;
import android.view.View;
import android.view.View.OnClickListener;

class tdz
  implements View.OnClickListener
{
  tdz(tdu paramtdu, stMetaComment paramstMetaComment, stMetaReply paramstMetaReply) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Tdu.a.a().a(tdn.a(this.jdField_a_of_type_Tdu.a), this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment, this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaReply);
    this.jdField_a_of_type_Tdu.a.a = true;
    tlo.d("comment", "6 mCommentListChanged:" + this.jdField_a_of_type_Tdu.a.a);
    tdn.a(this.jdField_a_of_type_Tdu.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tdz
 * JD-Core Version:    0.7.0.1
 */