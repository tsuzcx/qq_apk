import android.view.View;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;

public class tgk
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  
  private IMiniMsgUnreadCallback a()
  {
    return new tgl(this);
  }
  
  public MiniMsgUserParam a()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 6;
    localMiniMsgUserParam.accessType = 2;
    localMiniMsgUserParam.filterMsgType = 0;
    localMiniMsgUserParam.unreadCallback = a();
    return localMiniMsgUserParam;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(MiniMsgUser paramMiniMsgUser)
  {
    if ((this.jdField_a_of_type_Int > 0) && (paramMiniMsgUser != null) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      paramMiniMsgUser.onClick(this.jdField_a_of_type_AndroidViewView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tgk
 * JD-Core Version:    0.7.0.1
 */