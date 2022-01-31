import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase;

public class pla
  extends ButtonBase
{
  LinearLayout a;
  
  public pla(VafContext paramVafContext)
  {
    super(paramVafContext);
    a(paramVafContext);
  }
  
  private void a()
  {
    plb localplb = new plb(this);
    this.a.addOnAttachStateChangeListener(new plc(this, localplb));
  }
  
  private void a(VafContext paramVafContext)
  {
    this.a = ((LinearLayout)LayoutInflater.from(paramVafContext.getContext()).inflate(2131559915, null, false));
    TextView localTextView = (TextView)this.a.findViewById(2131363288);
    localTextView.setText(rmc.a().a(paramVafContext.getContext()));
    localTextView.setPadding(localTextView.getPaddingLeft(), localTextView.getPaddingTop(), localTextView.getPaddingRight(), bawz.a(paramVafContext.getContext(), 4.0F));
    a();
  }
  
  public int getComMeasuredHeight()
  {
    return this.a.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.a.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.a;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.a.measure(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.a.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
  }
  
  public void setBackgroundColorForStates() {}
  
  public void setBackgroundForStates() {}
  
  public void setCompoundDrawableForStates() {}
  
  public void setTextColorForStates() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pla
 * JD-Core Version:    0.7.0.1
 */