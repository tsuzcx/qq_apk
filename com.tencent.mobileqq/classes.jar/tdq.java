import NS_KING_SOCIALIZE_META.stMetaComment;
import NS_KING_SOCIALIZE_META.stMetaPerson;
import NS_KING_SOCIALIZE_META.stMetaReply;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ListView;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Map;

class tdq
  implements ybf
{
  tdq(tdn paramtdn, stMetaComment paramstMetaComment, stMetaReply paramstMetaReply) {}
  
  public void a()
  {
    tlo.b(tdn.a(this.jdField_a_of_type_Tdn), 1, "onCommentSend()");
    if (tdn.a(this.jdField_a_of_type_Tdn) == null)
    {
      tlo.b(tdn.a(this.jdField_a_of_type_Tdn), 1, "onCommentSend(): mCommentInputPopupWindow null");
      return;
    }
    String str = tdn.a(this.jdField_a_of_type_Tdn).a();
    if (TextUtils.isEmpty(str.trim()))
    {
      QQToast.a(tdn.a(this.jdField_a_of_type_Tdn), tdn.a(this.jdField_a_of_type_Tdn).getString(2131692456), 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(tdn.a(this.jdField_a_of_type_Tdn)))
    {
      QQToast.a(tdn.a(this.jdField_a_of_type_Tdn), 1, tdn.a(this.jdField_a_of_type_Tdn).getString(2131694777), 0).a();
      return;
    }
    if (tdn.a(this.jdField_a_of_type_Tdn) == null)
    {
      tlo.d(tdn.a(this.jdField_a_of_type_Tdn), 1, "feed is null");
      return;
    }
    Object localObject;
    if (this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment != null)
    {
      if (tdn.a(this.jdField_a_of_type_Tdn) == null) {
        tdn.a(this.jdField_a_of_type_Tdn, new stMetaReply());
      }
      tdn.a(this.jdField_a_of_type_Tdn).wording = str;
      localObject = new stMetaReply();
      ((stMetaReply)localObject).id = ("fakeId_" + System.currentTimeMillis());
      ((stMetaReply)localObject).wording = str;
      ((stMetaReply)localObject).createtime = ((int)(System.currentTimeMillis() / 1000L));
      ((stMetaReply)localObject).poster = tdn.a(this.jdField_a_of_type_Tdn);
      if (this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaReply != null)
      {
        ((stMetaReply)localObject).receiver = this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaReply.poster;
        ((stMetaReply)localObject).beReplyReplyId = this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaReply.id;
        if (tdn.a(this.jdField_a_of_type_Tdn).receiver != null) {
          tdn.a(this.jdField_a_of_type_Tdn).put(Long.valueOf(tdn.a(this.jdField_a_of_type_Tdn)), tdn.a(this.jdField_a_of_type_Tdn).receiver);
        }
        tlo.d("comment", "回复请求前,发送者:" + ((stMetaReply)localObject).poster.nick + ",接受者:" + ((stMetaReply)localObject).receiver.nick);
        tdn.a(this.jdField_a_of_type_Tdn, this.jdField_a_of_type_Tdn.a().a(tdn.a(this.jdField_a_of_type_Tdn), this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment, (stMetaReply)localObject));
        this.jdField_a_of_type_Tdn.jdField_a_of_type_Boolean = true;
        tlo.d("comment", "1 mCommentListChanged:" + this.jdField_a_of_type_Tdn.jdField_a_of_type_Boolean);
        tdn.b(this.jdField_a_of_type_Tdn, true);
        if (tdn.b(this.jdField_a_of_type_Tdn) != null) {
          tdn.b(this.jdField_a_of_type_Tdn).put(Long.valueOf(tdn.a(this.jdField_a_of_type_Tdn)), tdn.a(this.jdField_a_of_type_Tdn));
        }
        tdn.a(this.jdField_a_of_type_Tdn, null);
        if (tdn.a(this.jdField_a_of_type_Tdn) != null)
        {
          tdn.a(this.jdField_a_of_type_Tdn).a(this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.id, (stMetaReply)localObject);
          tdn.a(this.jdField_a_of_type_Tdn).notifyDataSetChanged();
        }
      }
    }
    for (;;)
    {
      tdn.a(this.jdField_a_of_type_Tdn).a("");
      tdn.a(this.jdField_a_of_type_Tdn).b(null);
      tdn.a(this.jdField_a_of_type_Tdn).dismiss();
      return;
      ((stMetaReply)localObject).receiver = this.jdField_a_of_type_NS_KING_SOCIALIZE_METAStMetaComment.poster;
      break;
      if (tdn.a(this.jdField_a_of_type_Tdn) == null) {
        tdn.a(this.jdField_a_of_type_Tdn, new stMetaComment());
      }
      tdn.a(this.jdField_a_of_type_Tdn).wording = str;
      localObject = new stMetaComment();
      ((stMetaComment)localObject).id = ("fakeId_" + System.currentTimeMillis());
      ((stMetaComment)localObject).wording = str;
      ((stMetaComment)localObject).createtime = ((int)(System.currentTimeMillis() / 1000L));
      ((stMetaComment)localObject).poster = tdn.a(this.jdField_a_of_type_Tdn);
      ((stMetaComment)localObject).replyList = new ArrayList();
      this.jdField_a_of_type_Tdn.a().a(tdn.a(this.jdField_a_of_type_Tdn), (stMetaComment)localObject);
      this.jdField_a_of_type_Tdn.jdField_a_of_type_Boolean = true;
      tlo.d("comment", "2 mCommentListChanged:" + this.jdField_a_of_type_Tdn.jdField_a_of_type_Boolean);
      if ((tdn.a(this.jdField_a_of_type_Tdn) instanceof WSFollowFragment)) {
        ((WSFollowFragment)tdn.a(this.jdField_a_of_type_Tdn)).a(tdn.a(this.jdField_a_of_type_Tdn), tdn.a(this.jdField_a_of_type_Tdn));
      }
      tdn.b(this.jdField_a_of_type_Tdn, true);
      tdn.a(this.jdField_a_of_type_Tdn, null);
      if (tdn.a(this.jdField_a_of_type_Tdn) != null)
      {
        tdn.a(this.jdField_a_of_type_Tdn).a(0, (stMetaComment)localObject);
        tdn.a(this.jdField_a_of_type_Tdn).notifyDataSetChanged();
      }
      tlo.d(tdn.a(this.jdField_a_of_type_Tdn), "onCommentSend, lastPosition:" + tdn.b(this.jdField_a_of_type_Tdn) + ",currentPosition:" + tdn.a(this.jdField_a_of_type_Tdn));
      if (this.jdField_a_of_type_Tdn.jdField_a_of_type_AndroidWidgetListView != null) {
        this.jdField_a_of_type_Tdn.jdField_a_of_type_AndroidWidgetListView.setSelection(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tdq
 * JD-Core Version:    0.7.0.1
 */