import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.view.widget.InnerListView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONObject;

public class szm
  extends tax
  implements View.OnClickListener, wcv, wcw
{
  protected Handler a;
  public CommentLikeFeedItem a;
  public String a;
  private szn a;
  protected szs a;
  
  public szm(szs paramszs)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Szs = paramszs;
    this.jdField_a_of_type_JavaLangString = QQStoryContext.a().a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = this.jdField_a_of_type_Szs.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    this.jdField_a_of_type_Szn = new szn(this);
  }
  
  private void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_Szs.jdField_a_of_type_Szo != null) {
      this.jdField_a_of_type_Szs.jdField_a_of_type_Szo.a(this.jdField_a_of_type_Szs, this.jdField_a_of_type_Szn.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_Szn.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Szn.jdField_a_of_type_Int, paramCommentEntry);
    }
    szy localszy = (szy)this.jdField_a_of_type_Szs.a();
    paramInt = vei.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      vei.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, vei.a(localszy.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  protected void a(View paramView, CommentEntry paramCommentEntry, int paramInt)
  {
    paramView = QQStoryContext.a().b();
    bfpc localbfpc = bfpc.a(this.jdField_a_of_type_Szs.jdField_a_of_type_AndroidAppActivity);
    if (paramCommentEntry.authorUnionId.equals(paramView)) {
      if (paramCommentEntry.status == 2)
      {
        localbfpc.c(ajya.a(2131704434));
        localbfpc.a(ajya.a(2131704402), 3);
      }
    }
    for (;;)
    {
      localbfpc.d(ajya.a(2131704407));
      localbfpc.a(new szp(this, localbfpc, paramCommentEntry, paramInt));
      localbfpc.show();
      return;
      localbfpc.c(ajya.a(2131704422));
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe())
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isVip()) {
          localbfpc.a(ajya.a(2131704432), 3);
        }
        localbfpc.c(ajya.a(2131704431));
        localbfpc.c(ajya.a(2131704429));
      }
      else
      {
        localbfpc.c(ajya.a(2131704403));
        localbfpc.c(ajya.a(2131704421));
      }
    }
  }
  
  protected void a(CommentEntry paramCommentEntry, int paramInt)
  {
    if (paramCommentEntry.commentType == 5)
    {
      paramCommentEntry = new OpenPlayerBuilder(new VidListPlayInfo(paramCommentEntry.togetherFeedId, paramCommentEntry.togetherVid), 126);
      tvc.a(this.jdField_a_of_type_Szs.jdField_a_of_type_AndroidAppActivity, paramCommentEntry.a(), null);
      vei.a("play_video", "multishoot_icon", 0, 0, new String[0]);
    }
    Object localObject;
    do
    {
      return;
      if (paramCommentEntry.commentType != 4) {
        break;
      }
      localObject = paramCommentEntry.getExtraJson().optString("vid");
      paramCommentEntry = paramCommentEntry.getExtraJson().optString("feedid");
    } while ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(paramCommentEntry)));
    tvc.b(this.jdField_a_of_type_Szs.jdField_a_of_type_AndroidContentContext, (String)localObject, paramCommentEntry, 74);
    return;
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
    {
      localObject = bfpc.a(this.jdField_a_of_type_Szs.jdField_a_of_type_AndroidAppActivity);
      if (paramCommentEntry.status == 2) {
        ((bfpc)localObject).c(ajya.a(2131704436));
      }
      for (;;)
      {
        ((bfpc)localObject).a(ajya.a(2131704439), 3);
        ((bfpc)localObject).d(ajya.a(2131704417));
        ((bfpc)localObject).a(new szp(this, (bfpc)localObject, paramCommentEntry, paramInt));
        ((bfpc)localObject).show();
        return;
        ((bfpc)localObject).c(ajya.a(2131704423));
      }
    }
    b(paramCommentEntry, paramInt);
    paramInt = vei.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      vei.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, vei.a(this.jdField_a_of_type_Szs.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
  }
  
  public void a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Szs.jdField_a_of_type_JavaUtilList.get(paramInt);
    this.jdField_a_of_type_Szn.jdField_a_of_type_AndroidViewViewGroup = paramInnerListView;
    this.jdField_a_of_type_Szn.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Szn.jdField_a_of_type_Int = paramInt;
    if (!bbfj.d(this.jdField_a_of_type_Szs.jdField_a_of_type_AndroidContentContext))
    {
      bcql.a(BaseApplication.getContext(), 1, ajya.a(2131704411), 0).a();
      return;
    }
    a(localCommentEntry, paramInt);
  }
  
  public boolean a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    a(paramView, (CommentEntry)this.jdField_a_of_type_Szs.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
    this.jdField_a_of_type_Szn.jdField_a_of_type_AndroidViewViewGroup = paramInnerListView;
    this.jdField_a_of_type_Szn.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Szn.jdField_a_of_type_Int = paramInt;
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      int i = ((Integer)paramView.getTag()).intValue();
      paramView = (CommentEntry)this.jdField_a_of_type_Szs.jdField_a_of_type_JavaUtilList.get(i);
      bfpc localbfpc = bfpc.a(this.jdField_a_of_type_Szs.jdField_a_of_type_AndroidAppActivity);
      localbfpc.c(ajya.a(2131704414));
      localbfpc.a(ajya.a(2131704400), 3);
      localbfpc.c(2131690596);
      localbfpc.a(new szp(this, localbfpc, paramView, i));
      localbfpc.show();
      return;
      this.jdField_a_of_type_Szs.a().a();
    } while (!QLog.isColorLevel());
    QLog.d("FeedCommentEventHandler", 2, "onClick retry_btn");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     szm
 * JD-Core Version:    0.7.0.1
 */