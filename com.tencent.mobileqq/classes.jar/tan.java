import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;

public class tan
  extends szm
{
  ShareGroupItem jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public tan(szs paramszs, ShareGroupItem paramShareGroupItem)
  {
    super(paramszs);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = paramShareGroupItem;
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.isOwner();
    this.b = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.isPublic();
  }
  
  protected void a(View paramView, CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem == null) {
      super.a(paramView, paramCommentEntry, paramInt);
    }
    paramView = QQStoryContext.a().b();
    bfpc localbfpc = bfpc.a(this.jdField_a_of_type_Szs.a);
    if (paramCommentEntry.authorUnionId.equals(paramView)) {
      if (paramCommentEntry.status == 2)
      {
        localbfpc.c(ajya.a(2131713943));
        localbfpc.a(ajya.a(2131713937), 3);
      }
    }
    for (;;)
    {
      localbfpc.d(ajya.a(2131713919));
      localbfpc.a(new szp(this, localbfpc, paramCommentEntry, paramInt));
      localbfpc.show();
      return;
      localbfpc.c(ajya.a(2131713920));
      break;
      if ((this.b) && (this.jdField_a_of_type_Boolean))
      {
        localbfpc.c(ajya.a(2131713931));
        localbfpc.a(ajya.a(2131713940), 3);
        localbfpc.c(ajya.a(2131713947));
      }
      else
      {
        localbfpc.c(ajya.a(2131713930));
        localbfpc.c(ajya.a(2131713938));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tan
 * JD-Core Version:    0.7.0.1
 */