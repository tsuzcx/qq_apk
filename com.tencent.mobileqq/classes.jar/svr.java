import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.msgTabNode.view.viewholder.FriendNodeViewHolder.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class svr
  extends svu
{
  public svr(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131495711);
  }
  
  public void a(ssm paramssm)
  {
    urk.a("FriendNodeViewHolder", "bindData %s", paramssm);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    QQAppInterface localQQAppInterface;
    String str;
    if ((localObject instanceof QQAppInterface))
    {
      localQQAppInterface = (QQAppInterface)localObject;
      str = String.valueOf(paramssm.b);
      b(vmp.b(paramssm.g));
      if (!svc.h) {
        break label180;
      }
    }
    label180:
    for (localObject = babh.m(localQQAppInterface, str);; localObject = str)
    {
      this.a.setNodeName((String)localObject, false);
      ThreadManager.post(new FriendNodeViewHolder.1(this, localQQAppInterface, str), 8, null, true);
      if (QLog.isColorLevel())
      {
        QLog.e("FriendNodeViewHolder", 2, new Object[] { "userItem = " + paramssm.b + ", name = " + (String)localObject, " list: ", String.valueOf(paramssm.a) });
        QLog.e("FriendNodeViewHolder", 2, new Object[] { "data: ", String.valueOf(paramssm) });
      }
      super.a(paramssm);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     svr
 * JD-Core Version:    0.7.0.1
 */