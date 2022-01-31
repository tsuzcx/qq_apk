import android.os.Handler;
import android.widget.ImageView;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoMembersListviewAvtivity;

class kah
  implements Runnable
{
  kah(kag paramkag, kaj paramkaj, VideoController.GAudioFriends paramGAudioFriends) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Kaj.jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentAvVideoController$GAudioFriends.jdField_a_of_type_Long) && (this.jdField_a_of_type_ComTencentAvVideoController$GAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      this.jdField_a_of_type_ComTencentAvVideoController$GAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_Kag.a(String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController$GAudioFriends.jdField_a_of_type_Long));
      if (this.jdField_a_of_type_ComTencentAvVideoController$GAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        break label104;
      }
      if (this.jdField_a_of_type_Kag.a.a != null) {
        this.jdField_a_of_type_Kag.a.a.a().postDelayed(new kai(this), 1000L);
      }
    }
    return;
    label104:
    this.jdField_a_of_type_Kaj.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentAvVideoController$GAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kah
 * JD-Core Version:    0.7.0.1
 */