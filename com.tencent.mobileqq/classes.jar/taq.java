import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;

public class taq
  extends szp
{
  ShareGroupItem jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public taq(szv paramszv, ShareGroupItem paramShareGroupItem)
  {
    super(paramszv);
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
    bfol localbfol = bfol.a(this.jdField_a_of_type_Szv.a);
    if (paramCommentEntry.authorUnionId.equals(paramView)) {
      if (paramCommentEntry.status == 2)
      {
        localbfol.c(ajyc.a(2131713932));
        localbfol.a(ajyc.a(2131713926), 3);
      }
    }
    for (;;)
    {
      localbfol.d(ajyc.a(2131713908));
      localbfol.a(new szs(this, localbfol, paramCommentEntry, paramInt));
      localbfol.show();
      return;
      localbfol.c(ajyc.a(2131713909));
      break;
      if ((this.b) && (this.jdField_a_of_type_Boolean))
      {
        localbfol.c(ajyc.a(2131713920));
        localbfol.a(ajyc.a(2131713929), 3);
        localbfol.c(ajyc.a(2131713936));
      }
      else
      {
        localbfol.c(ajyc.a(2131713919));
        localbfol.c(ajyc.a(2131713927));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     taq
 * JD-Core Version:    0.7.0.1
 */