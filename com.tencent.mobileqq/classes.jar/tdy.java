import NS_KING_SOCIALIZE_META.stMetaReply;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

class tdy
  implements View.OnClickListener
{
  tdy(tdu paramtdu, stMetaReply paramstMetaReply) {}
  
  public void onClick(View paramView)
  {
    paramView = (ClipboardManager)tdn.a(this.jdField_a_of_type_Tdu.a).getSystemService("clipboard");
    if (paramView != null)
    {
      paramView.setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaReply.wording));
      tdn.a(this.jdField_a_of_type_Tdu.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tdy
 * JD-Core Version:    0.7.0.1
 */