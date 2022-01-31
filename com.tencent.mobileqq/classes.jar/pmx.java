import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeCommentView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

public class pmx
  extends pmp
{
  public pmx(NativeCommentView paramNativeCommentView, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  public void onClick(View paramView)
  {
    paramView = this.a.a.a.a();
    if (paramView.isPGCShortContent())
    {
      onh.b(this.a.getContext(), paramView, (int)paramView.mChannelID);
      pjr.a(this.a.getContext(), paramView);
      return;
    }
    onh.a(this.a.getContext(), this.a.a.a.a(), 1, false, 8, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pmx
 * JD-Core Version:    0.7.0.1
 */