import NS_KING_SOCIALIZE_META.stMetaComment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentView;
import com.tencent.biz.pubaccount.weishi_new.comment.WsReplyContainer;
import java.util.ArrayList;

public class teb
  implements View.OnClickListener
{
  public teb(WsCommentView paramWsCommentView) {}
  
  public void onClick(View paramView)
  {
    if ((WsCommentView.a(this.a) != null) && (WsCommentView.a(this.a).replyList.size() > 0))
    {
      WsCommentView.a(this.a).a(paramView, 10, WsCommentView.a(this.a), WsCommentView.a(this.a));
      this.a.jdField_a_of_type_Tec.b.setVisibility(8);
      this.a.jdField_a_of_type_Tec.a.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     teb
 * JD-Core Version:    0.7.0.1
 */