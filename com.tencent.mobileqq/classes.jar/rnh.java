import android.app.Activity;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class rnh
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private rez jdField_a_of_type_Rez;
  private rmn jdField_a_of_type_Rmn;
  private tap jdField_a_of_type_Tap;
  
  rnh(Activity paramActivity, rmn paramrmn)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Rmn = paramrmn;
    this.jdField_a_of_type_Tap = ((tap)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(126));
    this.jdField_a_of_type_Rez = new rez(paramActivity, 1);
  }
  
  void a()
  {
    this.jdField_a_of_type_Rez.a();
  }
  
  void a(VideoInfo paramVideoInfo)
  {
    int i = 0;
    boolean bool;
    if (!paramVideoInfo.p)
    {
      bool = true;
      paramVideoInfo.p = bool;
      if (!paramVideoInfo.p) {
        break label53;
      }
      i = paramVideoInfo.r + 1;
    }
    for (;;)
    {
      paramVideoInfo.r = i;
      this.jdField_a_of_type_Tap.a(paramVideoInfo, paramVideoInfo.p);
      return;
      bool = false;
      break;
      label53:
      if (paramVideoInfo.r > 0) {
        i = paramVideoInfo.r - 1;
      }
    }
  }
  
  void a(VideoInfo paramVideoInfo, int paramInt1, int paramInt2)
  {
    if (!paramVideoInfo.p) {
      a(paramVideoInfo);
    }
    if ((paramInt1 >= 0) && (paramInt2 >= 0)) {
      this.jdField_a_of_type_Rez.a(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rnh
 * JD-Core Version:    0.7.0.1
 */