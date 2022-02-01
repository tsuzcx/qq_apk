import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class snq
  extends pfh
{
  public snq(FastWebActivity paramFastWebActivity) {}
  
  public void b(String paramString)
  {
    super.b(paramString);
    paramString = FastWebActivity.a(this.a).a(paramString, FastWebActivity.c(this.a));
    if (paramString != null) {
      this.a.a(true, paramString.a.commentId, null);
    }
    FastWebActivity.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     snq
 * JD-Core Version:    0.7.0.1
 */