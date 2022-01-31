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

public class smt
  extends soe
  implements View.OnClickListener, vqc, vqd
{
  protected Handler a;
  public CommentLikeFeedItem a;
  public String a;
  private smu a;
  protected smz a;
  
  public smt(smz paramsmz)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Smz = paramsmz;
    this.jdField_a_of_type_JavaLangString = QQStoryContext.a().a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = this.jdField_a_of_type_Smz.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    this.jdField_a_of_type_Smu = new smu(this);
  }
  
  private void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_Smz.jdField_a_of_type_Smv != null) {
      this.jdField_a_of_type_Smz.jdField_a_of_type_Smv.a(this.jdField_a_of_type_Smz, this.jdField_a_of_type_Smu.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_Smu.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Smu.jdField_a_of_type_Int, paramCommentEntry);
    }
    snf localsnf = (snf)this.jdField_a_of_type_Smz.a();
    paramInt = urp.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      urp.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, urp.a(localsnf.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  protected void a(View paramView, CommentEntry paramCommentEntry, int paramInt)
  {
    paramView = QQStoryContext.a().b();
    begr localbegr = begr.a(this.jdField_a_of_type_Smz.jdField_a_of_type_AndroidAppActivity);
    if (paramCommentEntry.authorUnionId.equals(paramView)) {
      if (paramCommentEntry.status == 2)
      {
        localbegr.c(ajjy.a(2131638638));
        localbegr.a(ajjy.a(2131638606), 3);
      }
    }
    for (;;)
    {
      localbegr.d(ajjy.a(2131638611));
      localbegr.a(new smw(this, localbegr, paramCommentEntry, paramInt));
      localbegr.show();
      return;
      localbegr.c(ajjy.a(2131638626));
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe())
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isVip()) {
          localbegr.a(ajjy.a(2131638636), 3);
        }
        localbegr.c(ajjy.a(2131638635));
        localbegr.c(ajjy.a(2131638633));
      }
      else
      {
        localbegr.c(ajjy.a(2131638607));
        localbegr.c(ajjy.a(2131638625));
      }
    }
  }
  
  protected void a(CommentEntry paramCommentEntry, int paramInt)
  {
    if (paramCommentEntry.commentType == 5)
    {
      paramCommentEntry = new OpenPlayerBuilder(new VidListPlayInfo(paramCommentEntry.togetherFeedId, paramCommentEntry.togetherVid), 126);
      tij.a(this.jdField_a_of_type_Smz.jdField_a_of_type_AndroidAppActivity, paramCommentEntry.a(), null);
      urp.a("play_video", "multishoot_icon", 0, 0, new String[0]);
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
    tij.b(this.jdField_a_of_type_Smz.jdField_a_of_type_AndroidContentContext, (String)localObject, paramCommentEntry, 74);
    return;
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
    {
      localObject = begr.a(this.jdField_a_of_type_Smz.jdField_a_of_type_AndroidAppActivity);
      if (paramCommentEntry.status == 2) {
        ((begr)localObject).c(ajjy.a(2131638640));
      }
      for (;;)
      {
        ((begr)localObject).a(ajjy.a(2131638643), 3);
        ((begr)localObject).d(ajjy.a(2131638621));
        ((begr)localObject).a(new smw(this, (begr)localObject, paramCommentEntry, paramInt));
        ((begr)localObject).show();
        return;
        ((begr)localObject).c(ajjy.a(2131638627));
      }
    }
    b(paramCommentEntry, paramInt);
    paramInt = urp.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      urp.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, urp.a(this.jdField_a_of_type_Smz.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
  }
  
  public void a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Smz.jdField_a_of_type_JavaUtilList.get(paramInt);
    this.jdField_a_of_type_Smu.jdField_a_of_type_AndroidViewViewGroup = paramInnerListView;
    this.jdField_a_of_type_Smu.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Smu.jdField_a_of_type_Int = paramInt;
    if (!badq.d(this.jdField_a_of_type_Smz.jdField_a_of_type_AndroidContentContext))
    {
      bbmy.a(BaseApplication.getContext(), 1, ajjy.a(2131638615), 0).a();
      return;
    }
    a(localCommentEntry, paramInt);
  }
  
  public boolean a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    a(paramView, (CommentEntry)this.jdField_a_of_type_Smz.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
    this.jdField_a_of_type_Smu.jdField_a_of_type_AndroidViewViewGroup = paramInnerListView;
    this.jdField_a_of_type_Smu.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Smu.jdField_a_of_type_Int = paramInt;
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
      paramView = (CommentEntry)this.jdField_a_of_type_Smz.jdField_a_of_type_JavaUtilList.get(i);
      begr localbegr = begr.a(this.jdField_a_of_type_Smz.jdField_a_of_type_AndroidAppActivity);
      localbegr.c(ajjy.a(2131638618));
      localbegr.a(ajjy.a(2131638604), 3);
      localbegr.c(2131625035);
      localbegr.a(new smw(this, localbegr, paramView, i));
      localbegr.show();
      return;
      this.jdField_a_of_type_Smz.a().a();
    } while (!QLog.isColorLevel());
    QLog.d("FeedCommentEventHandler", 2, "onClick retry_btn");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     smt
 * JD-Core Version:    0.7.0.1
 */