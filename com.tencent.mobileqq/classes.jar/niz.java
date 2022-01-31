import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.utils.DynamicUnitUtils;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.QQAppInterface;

public class niz
  implements Runnable
{
  public niz(MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate, String paramString) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.a.a.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.a.a.getChildAt(i);
        if ((TextUtils.equals(this.jdField_a_of_type_JavaLangString, String.valueOf(((View)localObject1).getTag()))) && ((localObject1 instanceof StoryMsgNodeFrameLayout)))
        {
          Object localObject2 = (StoryMsgNodeFrameLayout)localObject1;
          if (localObject2 != null)
          {
            localObject1 = new Rect();
            ((StoryMsgNodeFrameLayout)localObject2).getGlobalVisibleRect((Rect)localObject1);
            MsgTabStoryManager localMsgTabStoryManager = (MsgTabStoryManager)this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(250);
            localMsgTabStoryManager.a = (((Rect)localObject1).left + ((StoryMsgNodeFrameLayout)localObject2).getWidth() / 2);
            localMsgTabStoryManager.b = (((Rect)localObject1).top + ((StoryMsgNodeFrameLayout)localObject2).getHeight() / 2);
            SLog.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "handlePlayModeSwitchNode findView. x=%d, y=%d, rect=%s", Integer.valueOf(localMsgTabStoryManager.a), Integer.valueOf(localMsgTabStoryManager.b), String.valueOf(localObject1));
            localObject2 = ((StoryMsgNodeFrameLayout)localObject2).a;
            ((View)localObject2).getGlobalVisibleRect((Rect)localObject1);
            localMsgTabStoryManager.c = (((Rect)localObject1).top + ((View)localObject2).getPaddingTop());
            localMsgTabStoryManager.d = (((Rect)localObject1).left + ((View)localObject2).getPaddingLeft());
            localMsgTabStoryManager.e = (((Rect)localObject1).width() - ((View)localObject2).getPaddingLeft() - ((View)localObject2).getPaddingRight());
            localMsgTabStoryManager.f = (((Rect)localObject1).height() - ((View)localObject2).getPaddingTop() - ((View)localObject2).getPaddingBottom());
            localMsgTabStoryManager.g = DynamicUnitUtils.a(8.0F);
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
 * Qualified Name:     niz
 * JD-Core Version:    0.7.0.1
 */