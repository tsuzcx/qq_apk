import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;

public class osy
  extends pkt
{
  public osy(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void b(String paramString)
  {
    super.b(paramString);
    paramString = ReadInJoyCommentListFragment.a(this.a).a(paramString, ReadInJoyCommentListFragment.a(this.a));
    if (paramString != null) {
      ReadInJoyCommentListFragment.a(this.a).a(paramString, orx.a(paramString, 0), 2);
    }
    ReadInJoyCommentListFragment.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     osy
 * JD-Core Version:    0.7.0.1
 */