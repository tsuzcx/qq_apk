import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.share.AVSchema;
import com.tencent.mobileqq.activity.ChatActivityUtils;

class lyl
  implements DialogInterface.OnClickListener
{
  lyl(lyk paramlyk, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Lyk.jdField_a_of_type_ComTencentAvShareAVSchema.a("checkQAVPermission.callback", this.jdField_a_of_type_Long)) {
      return;
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Lyk.jdField_a_of_type_ComTencentAvShareAVSchema.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_Lyk.jdField_a_of_type_JavaLangString);
      return;
    }
    ChatActivityUtils.a(this.jdField_a_of_type_Lyk.jdField_a_of_type_ComTencentAvShareAVSchema.getActivity(), true, new lym(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lyl
 * JD-Core Version:    0.7.0.1
 */