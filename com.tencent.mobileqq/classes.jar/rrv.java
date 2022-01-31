import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.AssociatedAccountManageActivity;
import com.tencent.mobileqq.util.FaceDrawable;

class rrv
  implements Runnable
{
  rrv(rru paramrru, String paramString, View paramView) {}
  
  public void run()
  {
    try
    {
      FaceDrawable localFaceDrawable = FaceDrawable.a(this.jdField_a_of_type_Rru.a.app, this.jdField_a_of_type_JavaLangString, (byte)3);
      ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362724);
      if (localImageView != null) {
        localImageView.setImageDrawable(localFaceDrawable);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rrv
 * JD-Core Version:    0.7.0.1
 */