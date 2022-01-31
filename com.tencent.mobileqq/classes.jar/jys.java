import android.os.Handler;
import android.widget.ImageView;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoMembersListviewAvtivity;

class jys
  implements Runnable
{
  jys(jyr paramjyr, jyu paramjyu, VideoController.GAudioFriends paramGAudioFriends) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Jyu.jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentAvVideoController$GAudioFriends.jdField_a_of_type_Long) && (this.jdField_a_of_type_ComTencentAvVideoController$GAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      this.jdField_a_of_type_ComTencentAvVideoController$GAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_Jyr.a(String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController$GAudioFriends.jdField_a_of_type_Long));
      if (this.jdField_a_of_type_ComTencentAvVideoController$GAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        break label104;
      }
      if (this.jdField_a_of_type_Jyr.a.a != null) {
        this.jdField_a_of_type_Jyr.a.a.a().postDelayed(new jyt(this), 1000L);
      }
    }
    return;
    label104:
    this.jdField_a_of_type_Jyu.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentAvVideoController$GAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jys
 * JD-Core Version:    0.7.0.1
 */