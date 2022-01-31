import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.script.SpriteScriptManager;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.qphone.base.util.QLog;

public class rui
  extends GestureDetector.SimpleOnGestureListener
{
  public rui(BaseChatPie paramBaseChatPie) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      SpriteUIHandler localSpriteUIHandler = ((SpriteScriptManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(248)).a();
      if (localSpriteUIHandler != null) {
        localSpriteUIHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return super.onDown(paramMotionEvent);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((BaseChatPie.h() == 1) && (!BaseChatPie.a(this.a).booleanValue())) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getCount() != 0) {}
    }
    do
    {
      return false;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) && (this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition() >= this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getCount() - 1))
      {
        paramMotionEvent1 = new int[2];
        this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1).getLocationOnScreen(paramMotionEvent1);
        int i = paramMotionEvent1[1];
        if (BaseChatPie.i(this.a) == i)
        {
          this.a.q(1);
          BaseChatPie.a(this.a, Boolean.valueOf(true));
          BaseChatPie.g(this.a, -1);
        }
        BaseChatPie.g(this.a, i);
      }
      if (BaseChatPie.c(this.a)) {
        this.a.ay();
      }
    } while (paramFloat2 >= 0.0F);
    this.a.D = false;
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "onShowPress");
    }
    this.a.g(false);
    this.a.ay();
    super.onShowPress(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    this.a.g(false);
    this.a.ay();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rui
 * JD-Core Version:    0.7.0.1
 */