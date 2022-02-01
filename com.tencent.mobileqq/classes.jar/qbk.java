import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAwesomeCommentView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;

public class qbk
  extends ViewBase
{
  private NativeAwesomeCommentView a;
  
  public qbk(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new NativeAwesomeCommentView(paramVafContext.getContext());
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
    if (this.a != null) {
      this.a.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    if (this.a != null) {
      this.a.measure(paramInt1, paramInt2);
    }
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return super.setAttribute(paramInt, paramObject);
      if (((paramObject instanceof qvm)) && (this.a != null)) {
        this.a.setAwesomeCommentInfo((qvm)paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qbk
 * JD-Core Version:    0.7.0.1
 */