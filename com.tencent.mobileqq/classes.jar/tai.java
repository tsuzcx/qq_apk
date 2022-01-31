import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class tai
  extends taz
{
  public static final String a;
  public static final String b = sxp.a("StorySvc.like_feed");
  protected tan a;
  private boolean a;
  protected String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = sxp.a("StorySvc.feed_like_list_715");
  }
  
  public tai(tan paramtan, boolean paramBoolean)
  {
    this.jdField_a_of_type_Tan = paramtan;
    this.c = this.jdField_a_of_type_Tan.a.feedId;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a(CommentLikeFeedItem paramCommentLikeFeedItem, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    tbb.a().a(new tal(paramCommentLikeFeedItem.feedId, paramBoolean, paramInt1, paramInt2), new tam());
  }
  
  public void a()
  {
    a(this.c, this.jdField_a_of_type_Boolean);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    tbb.a().a(new taj(this, paramString, paramBoolean), new tak(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tai
 * JD-Core Version:    0.7.0.1
 */