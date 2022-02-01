import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class otd
  implements opa
{
  public otd(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void a(opd paramopd)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onBiuAndCommentSend fragment");
    if (paramopd == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(paramopd.a()))
    {
      QLog.d("ReadInJoyCommentListFragment", 1, localObject);
      if ((paramopd == null) || (paramopd.a() != 0)) {
        break;
      }
      ooz.a(paramopd.c(), paramopd.a(), paramopd.c(), paramopd.b(), paramopd.a(), paramopd.d(), paramopd.e(), paramopd.a());
      return;
    }
    QQToast.a(BaseApplication.getContext(), 1, amtj.a(2131711999), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     otd
 * JD-Core Version:    0.7.0.1
 */