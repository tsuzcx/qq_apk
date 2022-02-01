import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class srr
  extends pkt
{
  public srr(FastWebActivity paramFastWebActivity) {}
  
  public void b(String paramString)
  {
    super.b(paramString);
    paramString = FastWebActivity.a(this.a).a(paramString, FastWebActivity.d(this.a));
    if (paramString != null) {
      this.a.a(true, paramString.a.commentId, null);
    }
    FastWebActivity.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     srr
 * JD-Core Version:    0.7.0.1
 */