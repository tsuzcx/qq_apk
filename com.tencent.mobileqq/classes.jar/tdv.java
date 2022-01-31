import NS_KING_SOCIALIZE_META.stMetaComment;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

class tdv
  implements View.OnClickListener
{
  tdv(tdu paramtdu, stMetaComment paramstMetaComment) {}
  
  public void onClick(View paramView)
  {
    paramView = (ClipboardManager)tdn.a(this.jdField_a_of_type_Tdu.a).getSystemService("clipboard");
    if (paramView != null)
    {
      paramView.setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.wording));
      tdn.a(this.jdField_a_of_type_Tdu.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tdv
 * JD-Core Version:    0.7.0.1
 */