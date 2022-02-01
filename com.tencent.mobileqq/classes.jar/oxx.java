import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.ui.ReadInJoyCommentLikeView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;

public class oxx
  extends ViewBase
{
  private ReadInJoyCommentLikeView a;
  
  public oxx(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new ReadInJoyCommentLikeView(paramVafContext.getContext());
  }
  
  public void a(oyu paramoyu)
  {
    this.a.setOnLikeListener(paramoyu);
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
    this.a.setVisibility(0);
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return super.setAttribute(paramInt, paramObject);
    }
    if (((paramObject instanceof ouo)) && (((ouo)paramObject).a != null)) {
      this.a.a(((ouo)paramObject).a);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oxx
 * JD-Core Version:    0.7.0.1
 */