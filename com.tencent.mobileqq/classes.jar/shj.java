import android.content.Intent;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public class shj
  implements Runnable
{
  public shj(Conversation paramConversation, ApolloSurfaceView paramApolloSurfaceView, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender() != null) {
      ApolloRender.selectPhotoFromSystem(this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_AndroidContentIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     shj
 * JD-Core Version:    0.7.0.1
 */