import android.app.Activity;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class qxv
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private qpy jdField_a_of_type_Qpy;
  private qxb jdField_a_of_type_Qxb;
  private six jdField_a_of_type_Six;
  
  qxv(Activity paramActivity, qxb paramqxb)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Qxb = paramqxb;
    this.jdField_a_of_type_Six = ((six)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(126));
    this.jdField_a_of_type_Qpy = new qpy(paramActivity, 1);
  }
  
  void a()
  {
    this.jdField_a_of_type_Qpy.a();
  }
  
  void a(VideoInfo paramVideoInfo)
  {
    int i = 0;
    boolean bool;
    if (!paramVideoInfo.l)
    {
      bool = true;
      paramVideoInfo.l = bool;
      if (!paramVideoInfo.l) {
        break label53;
      }
      i = paramVideoInfo.u + 1;
    }
    for (;;)
    {
      paramVideoInfo.u = i;
      this.jdField_a_of_type_Six.a(paramVideoInfo, paramVideoInfo.l);
      return;
      bool = false;
      break;
      label53:
      if (paramVideoInfo.u > 0) {
        i = paramVideoInfo.u - 1;
      }
    }
  }
  
  void a(VideoInfo paramVideoInfo, int paramInt1, int paramInt2)
  {
    if (!paramVideoInfo.l) {
      a(paramVideoInfo);
    }
    if ((paramInt1 >= 0) && (paramInt2 >= 0)) {
      this.jdField_a_of_type_Qpy.a(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qxv
 * JD-Core Version:    0.7.0.1
 */