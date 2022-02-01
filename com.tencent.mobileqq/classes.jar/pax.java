import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class pax
  implements owy
{
  public pax(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void a(oxb paramoxb)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onBiuAndCommentSend fragment");
    if (paramoxb == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(paramoxb.a()))
    {
      QLog.d("ReadInJoyCommentListFragment", 1, localObject);
      if ((paramoxb == null) || (paramoxb.a() != 0)) {
        break;
      }
      owx.a(paramoxb.c(), paramoxb.a(), paramoxb.c(), paramoxb.b(), paramoxb.a(), paramoxb.d(), paramoxb.e(), paramoxb.a());
      return;
    }
    QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131712346), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pax
 * JD-Core Version:    0.7.0.1
 */