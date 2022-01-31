import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.tencent.biz.qqstory.comment.FeedCommentEventHandler.OnActionSheetButtonClickListener.1;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.qphone.base.util.QLog;

public class smw
  implements begw
{
  private final int jdField_a_of_type_Int;
  private final begr jdField_a_of_type_Begr;
  private final CommentEntry jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
  
  public smw(smt paramsmt, begr parambegr, CommentEntry paramCommentEntry, int paramInt)
  {
    this.jdField_a_of_type_Begr = parambegr;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Begr.a(paramInt);
    if (QLog.isDevelopLevel()) {
      QLog.d("FeedCommentEventHandler", 2, "onCommentItemClick.ActionSheet click: which=" + paramInt + ", text = " + paramView);
    }
    if (ajjy.a(2131638641).equals(paramView))
    {
      this.jdField_a_of_type_Smt.jdField_a_of_type_Smz.a(this.jdField_a_of_type_Int);
      paramView = this.jdField_a_of_type_Smt.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
      if ((paramView != null) && (paramView.isVip()))
      {
        paramInt = 1;
        if (!this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorUin.equals(this.jdField_a_of_type_Smt.jdField_a_of_type_JavaLangString)) {
          break label177;
        }
        paramView = "2";
        label124:
        urp.a("play_video", "del_reply", paramInt, 0, new String[] { paramView, "", "", this.jdField_a_of_type_Smt.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      }
    }
    label171:
    label177:
    do
    {
      for (;;)
      {
        this.jdField_a_of_type_Begr.dismiss();
        return;
        paramInt = 2;
        break;
        paramView = "1";
        break label124;
        if (ajjy.a(2131638630).equals(paramView))
        {
          this.jdField_a_of_type_Smt.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedCommentEventHandler.OnActionSheetButtonClickListener.1(this), 500L);
        }
        else if (ajjy.a(2131638622).equals(paramView))
        {
          tfy.a(this.jdField_a_of_type_Smt.jdField_a_of_type_Smz.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
          urp.a("play_video", "report_reply", urp.a(this.jdField_a_of_type_Smt.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { "", urp.a(this.jdField_a_of_type_Smt.jdField_a_of_type_Smz.jdField_a_of_type_Int), "", this.jdField_a_of_type_Smt.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
        }
        else
        {
          if (!ajjy.a(2131638645).equals(paramView)) {
            break label407;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 1;
          this.jdField_a_of_type_Smt.jdField_a_of_type_Smz.e();
          this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.pbType = this.jdField_a_of_type_Smt.jdField_a_of_type_Smz.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getCommentLikeType();
          sob.a().jdField_a_of_type_JavaLangString = "";
          smz.a(this.jdField_a_of_type_Smt.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, false, this.jdField_a_of_type_Smt.jdField_a_of_type_Smz.jdField_a_of_type_Int, new smx(this));
        }
      }
    } while (!ajjy.a(2131638617).equals(paramView));
    label407:
    label487:
    for (;;)
    {
      try
      {
        paramView = this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.content;
        if (!axku.a(paramView)) {
          break label487;
        }
        paramView = awbk.b(paramView);
        ((ClipboardManager)this.jdField_a_of_type_Smt.jdField_a_of_type_Smz.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("comment content", paramView));
      }
      catch (Exception paramView) {}
      if (!QLog.isColorLevel()) {
        break label171;
      }
      QLog.e("FeedCommentEventHandler", 2, paramView.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     smw
 * JD-Core Version:    0.7.0.1
 */