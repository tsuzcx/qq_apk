import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;

public class snu
  extends smt
{
  ShareGroupItem jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public snu(smz paramsmz, ShareGroupItem paramShareGroupItem)
  {
    super(paramsmz);
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
    begr localbegr = begr.a(this.jdField_a_of_type_Smz.a);
    if (paramCommentEntry.authorUnionId.equals(paramView)) {
      if (paramCommentEntry.status == 2)
      {
        localbegr.c(ajjy.a(2131648144));
        localbegr.a(ajjy.a(2131648138), 3);
      }
    }
    for (;;)
    {
      localbegr.d(ajjy.a(2131648120));
      localbegr.a(new smw(this, localbegr, paramCommentEntry, paramInt));
      localbegr.show();
      return;
      localbegr.c(ajjy.a(2131648121));
      break;
      if ((this.b) && (this.jdField_a_of_type_Boolean))
      {
        localbegr.c(ajjy.a(2131648132));
        localbegr.a(ajjy.a(2131648141), 3);
        localbegr.c(ajjy.a(2131648148));
      }
      else
      {
        localbegr.c(ajjy.a(2131648131));
        localbegr.c(ajjy.a(2131648139));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     snu
 * JD-Core Version:    0.7.0.1
 */