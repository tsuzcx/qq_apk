import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
import com.tencent.qphone.base.util.QLog;

public class oyv
  extends bdzm
{
  public oyv(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    bduk localbduk = (bduk)paramMessage.obj;
    if ((localbduk == null) || (localbduk.b != 24) || (localbduk.c != 10)) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1003: 
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "mTransProcessorHandler send finished!");
      }
      break;
    }
    try
    {
      ReadInJoyCommentComponentFragment.a(this.a).c = true;
      ReadInJoyCommentComponentFragment.a(this.a).f = localbduk.i;
      ReadInJoyCommentComponentFragment.a(this.a).g = localbduk.f;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "mTransProcessorHandler url=" + ReadInJoyCommentComponentFragment.a(this.a).f + ", md5=" + ReadInJoyCommentComponentFragment.a(this.a).g);
      }
      label172:
      this.a.f();
      ReadInJoyCommentComponentFragment.a(this.a).setResult(-1, ReadInJoyCommentComponentFragment.a(this.a));
      ReadInJoyCommentComponentFragment.a(this.a).finish();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "mTransProcessorHandler send error or cancel!");
      }
      this.a.f();
      this.a.a(1, this.a.getString(2131716990));
      return;
    }
    catch (Exception paramMessage)
    {
      break label172;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oyv
 * JD-Core Version:    0.7.0.1
 */