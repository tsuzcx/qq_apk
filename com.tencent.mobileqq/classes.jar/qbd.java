import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ticker.TickerView;

public class qbd
  extends TextBase
{
  private TickerView a;
  
  public qbd(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new TickerView(paramVafContext.getContext());
    this.a.setCharacterLists(new String[] { "1234567890" });
    this.a.setAnimationDuration(500L);
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
    super.onParseValueFinished();
    this.a.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.a.setTextSize(this.mTextSize);
    this.a.setBackgroundColor(this.mBackground);
    this.a.setTextColor(this.mTextColor);
    if ((this.mTextStyle & 0x2) != 0) {
      this.a.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
    }
    int i = 0;
    int j;
    if ((this.mGravity & 0x4) != 0)
    {
      i = 1;
      if ((this.mGravity & 0x20) == 0) {
        break label187;
      }
      j = i | 0x10;
    }
    for (;;)
    {
      this.a.setGravity(j);
      if ((TextUtils.isEmpty(this.mText)) || (!(this.mText instanceof String))) {
        break label225;
      }
      this.a.setText((String)this.mText);
      return;
      if ((this.mGravity & 0x1) != 0)
      {
        i = 3;
        break;
      }
      if ((this.mGravity & 0x2) == 0) {
        break;
      }
      i = 5;
      break;
      label187:
      if ((this.mGravity & 0x8) != 0)
      {
        j = i | 0x30;
      }
      else
      {
        j = i;
        if ((this.mGravity & 0x10) != 0) {
          j = i | 0x50;
        }
      }
    }
    label225:
    this.a.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qbd
 * JD-Core Version:    0.7.0.1
 */