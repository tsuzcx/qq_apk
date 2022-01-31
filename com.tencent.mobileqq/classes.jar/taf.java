import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class taf
  extends taw
{
  public static final String a;
  public static final String b = sxm.a("StorySvc.like_feed");
  protected tak a;
  private boolean a;
  protected String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = sxm.a("StorySvc.feed_like_list_715");
  }
  
  public taf(tak paramtak, boolean paramBoolean)
  {
    this.jdField_a_of_type_Tak = paramtak;
    this.c = this.jdField_a_of_type_Tak.a.feedId;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a(CommentLikeFeedItem paramCommentLikeFeedItem, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    tay.a().a(new tai(paramCommentLikeFeedItem.feedId, paramBoolean, paramInt1, paramInt2), new taj());
  }
  
  public void a()
  {
    a(this.c, this.jdField_a_of_type_Boolean);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    tay.a().a(new tag(this, paramString, paramBoolean), new tah(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     taf
 * JD-Core Version:    0.7.0.1
 */