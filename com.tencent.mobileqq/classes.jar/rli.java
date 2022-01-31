import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.util.FaceDrawable;

class rli
  implements Runnable
{
  rli(rlh paramrlh, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      FaceDrawable localFaceDrawable = FaceDrawable.a(this.jdField_a_of_type_Rlh.a.app, this.jdField_a_of_type_JavaLangString, (byte)3);
      ((ImageView)this.jdField_a_of_type_Rlh.a.a.getChildAt(this.jdField_a_of_type_Int).findViewById(2131362724)).setImageDrawable(localFaceDrawable);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rli
 * JD-Core Version:    0.7.0.1
 */