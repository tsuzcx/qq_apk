import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;

public class pba
  extends pvq
{
  public pba(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void b(String paramString)
  {
    super.b(paramString);
    if (ReadInJoyCommentListFragment.a(this.a) != null)
    {
      paramString = ReadInJoyCommentListFragment.a(this.a).a(paramString, ReadInJoyCommentListFragment.a(this.a));
      if (paramString != null) {
        ReadInJoyCommentListFragment.a(this.a).a(paramString, ozx.a(paramString, 0), 2);
      }
      ReadInJoyCommentListFragment.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pba
 * JD-Core Version:    0.7.0.1
 */