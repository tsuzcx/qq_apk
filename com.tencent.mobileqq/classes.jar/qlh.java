import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeCommentView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

public class qlh
  extends qkz
{
  public qlh(NativeCommentView paramNativeCommentView, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  public void onClick(View paramView)
  {
    paramView = this.a.a.a.a();
    if (paramView.isPGCShortContent())
    {
      pha.b(this.a.getContext(), paramView, (int)paramView.mChannelID);
      qib.a(this.a.getContext(), paramView);
      return;
    }
    pha.a(this.a.getContext(), this.a.a.a.a(), 1, false, 8, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qlh
 * JD-Core Version:    0.7.0.1
 */