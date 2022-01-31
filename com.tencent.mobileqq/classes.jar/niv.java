import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.mobileqq.widget.QQToast;

public class niv
  extends QQStoryObserver
{
  public niv(MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    super.a(paramBoolean1, paramBoolean2, paramInt, paramString);
    if ((paramBoolean1) && (paramBoolean2)) {
      QQToast.a(this.a.a.a, 2, "已关注，可随时查看对方的最新视频", 0).a();
    }
    do
    {
      return;
      if ((!paramBoolean1) && (paramBoolean2))
      {
        QQToast.a(this.a.a.a, 1, "关注失败，请稍后重试", 0).a();
        return;
      }
    } while ((paramBoolean1) || (paramBoolean2));
    QQToast.a(this.a.a.a, 1, "取消关注失败，请稍后重试", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     niv
 * JD-Core Version:    0.7.0.1
 */