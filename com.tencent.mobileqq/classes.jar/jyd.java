import android.os.Handler;
import android.widget.ImageView;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoMembersListviewAvtivity;

class jyd
  implements Runnable
{
  jyd(jyc paramjyc, jyf paramjyf, VideoController.GAudioFriends paramGAudioFriends) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Jyf.jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentAvVideoController$GAudioFriends.jdField_a_of_type_Long) && (this.jdField_a_of_type_ComTencentAvVideoController$GAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      this.jdField_a_of_type_ComTencentAvVideoController$GAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_Jyc.a(String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController$GAudioFriends.jdField_a_of_type_Long));
      if (this.jdField_a_of_type_ComTencentAvVideoController$GAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        break label104;
      }
      if (this.jdField_a_of_type_Jyc.a.a != null) {
        this.jdField_a_of_type_Jyc.a.a.a().postDelayed(new jye(this), 1000L);
      }
    }
    return;
    label104:
    this.jdField_a_of_type_Jyf.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentAvVideoController$GAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jyd
 * JD-Core Version:    0.7.0.1
 */