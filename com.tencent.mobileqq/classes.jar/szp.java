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

public class szp
  extends tba
  implements View.OnClickListener, wcy, wcz
{
  protected Handler a;
  public CommentLikeFeedItem a;
  public String a;
  private szq a;
  protected szv a;
  
  public szp(szv paramszv)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Szv = paramszv;
    this.jdField_a_of_type_JavaLangString = QQStoryContext.a().a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = this.jdField_a_of_type_Szv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    this.jdField_a_of_type_Szq = new szq(this);
  }
  
  private void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_Szv.jdField_a_of_type_Szr != null) {
      this.jdField_a_of_type_Szv.jdField_a_of_type_Szr.a(this.jdField_a_of_type_Szv, this.jdField_a_of_type_Szq.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_Szq.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Szq.jdField_a_of_type_Int, paramCommentEntry);
    }
    tab localtab = (tab)this.jdField_a_of_type_Szv.a();
    paramInt = vel.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      vel.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, vel.a(localtab.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  protected void a(View paramView, CommentEntry paramCommentEntry, int paramInt)
  {
    paramView = QQStoryContext.a().b();
    bfol localbfol = bfol.a(this.jdField_a_of_type_Szv.jdField_a_of_type_AndroidAppActivity);
    if (paramCommentEntry.authorUnionId.equals(paramView)) {
      if (paramCommentEntry.status == 2)
      {
        localbfol.c(ajyc.a(2131704423));
        localbfol.a(ajyc.a(2131704391), 3);
      }
    }
    for (;;)
    {
      localbfol.d(ajyc.a(2131704396));
      localbfol.a(new szs(this, localbfol, paramCommentEntry, paramInt));
      localbfol.show();
      return;
      localbfol.c(ajyc.a(2131704411));
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe())
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isVip()) {
          localbfol.a(ajyc.a(2131704421), 3);
        }
        localbfol.c(ajyc.a(2131704420));
        localbfol.c(ajyc.a(2131704418));
      }
      else
      {
        localbfol.c(ajyc.a(2131704392));
        localbfol.c(ajyc.a(2131704410));
      }
    }
  }
  
  protected void a(CommentEntry paramCommentEntry, int paramInt)
  {
    if (paramCommentEntry.commentType == 5)
    {
      paramCommentEntry = new OpenPlayerBuilder(new VidListPlayInfo(paramCommentEntry.togetherFeedId, paramCommentEntry.togetherVid), 126);
      tvf.a(this.jdField_a_of_type_Szv.jdField_a_of_type_AndroidAppActivity, paramCommentEntry.a(), null);
      vel.a("play_video", "multishoot_icon", 0, 0, new String[0]);
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
    tvf.b(this.jdField_a_of_type_Szv.jdField_a_of_type_AndroidContentContext, (String)localObject, paramCommentEntry, 74);
    return;
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
    {
      localObject = bfol.a(this.jdField_a_of_type_Szv.jdField_a_of_type_AndroidAppActivity);
      if (paramCommentEntry.status == 2) {
        ((bfol)localObject).c(ajyc.a(2131704425));
      }
      for (;;)
      {
        ((bfol)localObject).a(ajyc.a(2131704428), 3);
        ((bfol)localObject).d(ajyc.a(2131704406));
        ((bfol)localObject).a(new szs(this, (bfol)localObject, paramCommentEntry, paramInt));
        ((bfol)localObject).show();
        return;
        ((bfol)localObject).c(ajyc.a(2131704412));
      }
    }
    b(paramCommentEntry, paramInt);
    paramInt = vel.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      vel.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, vel.a(this.jdField_a_of_type_Szv.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
  }
  
  public void a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Szv.jdField_a_of_type_JavaUtilList.get(paramInt);
    this.jdField_a_of_type_Szq.jdField_a_of_type_AndroidViewViewGroup = paramInnerListView;
    this.jdField_a_of_type_Szq.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Szq.jdField_a_of_type_Int = paramInt;
    if (!bbev.d(this.jdField_a_of_type_Szv.jdField_a_of_type_AndroidContentContext))
    {
      bcpw.a(BaseApplication.getContext(), 1, ajyc.a(2131704400), 0).a();
      return;
    }
    a(localCommentEntry, paramInt);
  }
  
  public boolean a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    a(paramView, (CommentEntry)this.jdField_a_of_type_Szv.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
    this.jdField_a_of_type_Szq.jdField_a_of_type_AndroidViewViewGroup = paramInnerListView;
    this.jdField_a_of_type_Szq.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Szq.jdField_a_of_type_Int = paramInt;
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
      paramView = (CommentEntry)this.jdField_a_of_type_Szv.jdField_a_of_type_JavaUtilList.get(i);
      bfol localbfol = bfol.a(this.jdField_a_of_type_Szv.jdField_a_of_type_AndroidAppActivity);
      localbfol.c(ajyc.a(2131704403));
      localbfol.a(ajyc.a(2131704389), 3);
      localbfol.c(2131690596);
      localbfol.a(new szs(this, localbfol, paramView, i));
      localbfol.show();
      return;
      this.jdField_a_of_type_Szv.a().a();
    } while (!QLog.isColorLevel());
    QLog.d("FeedCommentEventHandler", 2, "onClick retry_btn");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     szp
 * JD-Core Version:    0.7.0.1
 */