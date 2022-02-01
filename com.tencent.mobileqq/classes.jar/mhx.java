import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;

class mhx
  extends BroadcastReceiver
{
  mhx(mhw parammhw) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("QavDoubleVideoSharpnessMangaer", 2, "onReceive SVIPPayResultReceiver");
    }
    if (("tencent.video.q2v.SVIP.PAY".equals(paramContext)) && (mhw.a(this.a) != null))
    {
      paramContext = mhw.a(this.a).a();
      if ((paramContext != null) && (paramContext.jdField_d_of_type_Int == 2)) {
        mhw.a(this.a).a(Long.valueOf(paramContext.jdField_d_of_type_JavaLangString).longValue(), mhw.a(this.a));
      }
      this.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mhx
 * JD-Core Version:    0.7.0.1
 */