import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.List;

public class szw
  extends wcx<CommentEntry>
{
  boolean jdField_a_of_type_Boolean;
  
  public szw(int paramInt, List<CommentEntry> paramList, boolean paramBoolean)
  {
    super(paramList, paramBoolean);
    boolean bool;
    this.jdField_a_of_type_Boolean = bool;
  }
  
  public void a(int paramInt, CommentEntry paramCommentEntry, vap paramvap)
  {
    if (paramCommentEntry == null) {
      ved.e("FeedCommentLego", "FeedComment getView. data is null.");
    }
    Object localObject2;
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject2 = (TextView)paramvap.a(2131364468);
        paramvap = paramCommentEntry.commentId + paramCommentEntry.feedId + paramCommentEntry.status;
        localObject1 = tau.a().a(paramvap);
        if ((localObject1 != null) && (this.jdField_a_of_type_Boolean))
        {
          ((TextView)localObject2).setText((CharSequence)localObject1);
          ((TextView)localObject2).setSpannableFactory(aykk.a);
          ((TextView)localObject2).setOnTouchListener(szs.a(this.jdField_a_of_type_Szs));
          return;
        }
        localObject1 = upw.a(this.jdField_a_of_type_Szs.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Szs.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, paramCommentEntry, szs.a(this.jdField_a_of_type_Szs));
        if (QQStoryContext.a()) {
          ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.jdField_a_of_type_Szs.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
        }
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setSpannableFactory(aykk.a);
        ((TextView)localObject2).setOnTouchListener(szs.a(this.jdField_a_of_type_Szs));
        tdl localtdl = (tdl)tcz.a(2);
        localObject2 = localtdl.b(paramCommentEntry.authorUnionId);
        if (!paramCommentEntry.isReply()) {
          break;
        }
        paramCommentEntry = localtdl.b(paramCommentEntry.replierUnionId);
      } while ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()) || (paramCommentEntry == null) || (!paramCommentEntry.isAvailable()));
      tau.a().a(paramvap, (CharSequence)localObject1);
      return;
    } while ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()));
    tau.a().a(paramvap, (CharSequence)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     szw
 * JD-Core Version:    0.7.0.1
 */