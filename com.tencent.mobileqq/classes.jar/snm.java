import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class snm
  extends sod
{
  public static final String a;
  public static final String b = skt.a("StorySvc.like_feed");
  protected snr a;
  private boolean a;
  protected String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = skt.a("StorySvc.feed_like_list_715");
  }
  
  public snm(snr paramsnr, boolean paramBoolean)
  {
    this.jdField_a_of_type_Snr = paramsnr;
    this.c = this.jdField_a_of_type_Snr.a.feedId;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a(CommentLikeFeedItem paramCommentLikeFeedItem, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    sof.a().a(new snp(paramCommentLikeFeedItem.feedId, paramBoolean, paramInt1, paramInt2), new snq());
  }
  
  public void a()
  {
    a(this.c, this.jdField_a_of_type_Boolean);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    sof.a().a(new snn(this, paramString, paramBoolean), new sno(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     snm
 * JD-Core Version:    0.7.0.1
 */