import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper;

public class nzp
{
  public int a;
  public CommentEntry a;
  private int b = -1;
  
  public nzp(DetailCommentHelper paramDetailCommentHelper)
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = null;
    this.jdField_a_of_type_Int = -1;
    this.b = -1;
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
    this.b = paramCommentEntry.commentId;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a(CommentEntry paramCommentEntry)
  {
    return paramCommentEntry.commentId != this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzp
 * JD-Core Version:    0.7.0.1
 */