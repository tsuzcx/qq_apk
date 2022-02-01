import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

public class pbd
  implements pfw
{
  public pbd(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void a(int paramInt)
  {
    if (paramInt != 2) {
      this.a.d();
    }
    pqg localpqg1 = new pqg();
    pqg localpqg2 = localpqg1.i().b("rowkey", ReadInJoyCommentListFragment.a(this.a).innerUniqueID).b("entry", "2");
    if (paramInt == 2) {}
    for (String str = "1";; str = "0")
    {
      localpqg2.b("result", str);
      pbq.a("0X800A00F", ReadInJoyCommentListFragment.a(this.a), localpqg1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pbd
 * JD-Core Version:    0.7.0.1
 */