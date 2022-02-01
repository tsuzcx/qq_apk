import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeGridImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;

public class qbb
  extends ViewBase
{
  private NativeGridImageView a;
  
  public qbb(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new NativeGridImageView(paramVafContext.getContext());
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    this.a.a(paramArticleInfo);
  }
  
  public int getComMeasuredHeight()
  {
    return this.a.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.a.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.a;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.a.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.a.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qbb
 * JD-Core Version:    0.7.0.1
 */