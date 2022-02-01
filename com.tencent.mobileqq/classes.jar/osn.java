import android.text.Editable;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuNicknameSpan;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
import java.util.Comparator;

public class osn
  implements Comparator<BiuNicknameSpan>
{
  private Editable jdField_a_of_type_AndroidTextEditable;
  
  public osn(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment, Editable paramEditable)
  {
    this.jdField_a_of_type_AndroidTextEditable = paramEditable;
  }
  
  public int a(BiuNicknameSpan paramBiuNicknameSpan1, BiuNicknameSpan paramBiuNicknameSpan2)
  {
    int i = this.jdField_a_of_type_AndroidTextEditable.getSpanStart(paramBiuNicknameSpan1);
    int j = this.jdField_a_of_type_AndroidTextEditable.getSpanStart(paramBiuNicknameSpan2);
    if (i > j) {
      return 1;
    }
    if (i < j) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     osn
 * JD-Core Version:    0.7.0.1
 */