import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;

class mhg
  extends BroadcastReceiver
{
  mhg(mhf parammhf) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("QavDoubleVideoSharpnessMangaer", 2, "onReceive SVIPPayResultReceiver");
    }
    if (("tencent.video.q2v.SVIP.PAY".equals(paramContext)) && (mhf.a(this.a) != null))
    {
      paramContext = mhf.a(this.a).a();
      if ((paramContext != null) && (paramContext.jdField_d_of_type_Int == 2)) {
        mhf.a(this.a).a(Long.valueOf(paramContext.jdField_d_of_type_JavaLangString).longValue(), mhf.a(this.a));
      }
      this.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mhg
 * JD-Core Version:    0.7.0.1
 */