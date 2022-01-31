import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView;
import com.tencent.mobileqq.app.QQAppInterface;

public class ndq
  implements Runnable
{
  public ndq(MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate, String paramString) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.a.a.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.a.a.getChildAt(i);
        if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, String.valueOf(((View)localObject).getTag())))
        {
          localObject = (ImageView)((View)localObject).findViewById(2131371737);
          if (localObject != null)
          {
            Rect localRect = new Rect();
            ((ImageView)localObject).getGlobalVisibleRect(localRect);
            MsgTabStoryManager localMsgTabStoryManager = (MsgTabStoryManager)this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(250);
            localMsgTabStoryManager.a = (localRect.left + ((ImageView)localObject).getWidth() / 2);
            i = localRect.top;
            localMsgTabStoryManager.b = (((ImageView)localObject).getHeight() / 2 + i);
          }
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ndq
 * JD-Core Version:    0.7.0.1
 */