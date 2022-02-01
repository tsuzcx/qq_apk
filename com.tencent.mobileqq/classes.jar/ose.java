import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class ose
  implements onp
{
  public ose(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void a(ons paramons)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onBiuAndCommentSend fragment");
    if (paramons == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(paramons.a()))
    {
      QLog.d("ReadInJoyCommentListFragment", 1, localObject);
      if ((paramons == null) || (paramons.a() != 0)) {
        break;
      }
      ono.a(paramons.c(), paramons.a(), paramons.c(), paramons.b(), paramons.a(), paramons.d(), paramons.e(), paramons.a());
      return;
    }
    QQToast.a(BaseApplication.getContext(), 1, anzj.a(2131711767), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ose
 * JD-Core Version:    0.7.0.1
 */