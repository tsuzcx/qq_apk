import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class tfc
  extends pvq
{
  public tfc(FastWebActivity paramFastWebActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tfc
 * JD-Core Version:    0.7.0.1
 */