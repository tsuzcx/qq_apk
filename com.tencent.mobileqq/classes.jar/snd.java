import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.List;

public class snd
  extends vqe<CommentEntry>
{
  boolean jdField_a_of_type_Boolean;
  
  public snd(int paramInt, List<CommentEntry> paramList, boolean paramBoolean)
  {
    super(paramList, paramBoolean);
    boolean bool;
    this.jdField_a_of_type_Boolean = bool;
  }
  
  public void a(int paramInt, CommentEntry paramCommentEntry, unw paramunw)
  {
    if (paramCommentEntry == null) {
      urk.e("FeedCommentLego", "FeedComment getView. data is null.");
    }
    Object localObject2;
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject2 = (TextView)paramunw.a(2131298909);
        paramunw = paramCommentEntry.commentId + paramCommentEntry.feedId + paramCommentEntry.status;
        localObject1 = sob.a().a(paramunw);
        if ((localObject1 != null) && (this.jdField_a_of_type_Boolean))
        {
          ((TextView)localObject2).setText((CharSequence)localObject1);
          ((TextView)localObject2).setSpannableFactory(axkd.a);
          ((TextView)localObject2).setOnTouchListener(smz.a(this.jdField_a_of_type_Smz));
          return;
        }
        localObject1 = udd.a(this.jdField_a_of_type_Smz.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Smz.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, paramCommentEntry, smz.a(this.jdField_a_of_type_Smz));
        if (QQStoryContext.a()) {
          ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.jdField_a_of_type_Smz.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100758)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
        }
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setSpannableFactory(axkd.a);
        ((TextView)localObject2).setOnTouchListener(smz.a(this.jdField_a_of_type_Smz));
        sqs localsqs = (sqs)sqg.a(2);
        localObject2 = localsqs.b(paramCommentEntry.authorUnionId);
        if (!paramCommentEntry.isReply()) {
          break;
        }
        paramCommentEntry = localsqs.b(paramCommentEntry.replierUnionId);
      } while ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()) || (paramCommentEntry == null) || (!paramCommentEntry.isAvailable()));
      sob.a().a(paramunw, (CharSequence)localObject1);
      return;
    } while ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()));
    sob.a().a(paramunw, (CharSequence)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     snd
 * JD-Core Version:    0.7.0.1
 */