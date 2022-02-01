import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeSummaryView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase;
import com.tencent.qphone.base.util.QLog;

public class qvj
  extends TextBase
{
  private NativeSummaryView a;
  
  public qvj(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mTextSize = Utils.dp2px(16.0D);
    this.mLineSpaceExtra = Utils.rp2px(5.0D);
    this.a = new NativeSummaryView(paramVafContext.getContext());
    this.a.setTextColor(-11644322);
  }
  
  public void a(qfw paramqfw)
  {
    if (this.a.getLayoutParams() == null)
    {
      Object localObject = getComLayoutParams();
      localObject = new ViewGroup.LayoutParams(((Layout.Params)localObject).mLayoutWidth, ((Layout.Params)localObject).mLayoutHeight);
      this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.a.setModel(paramqfw);
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
    this.a.setBackgroundColor(this.mBackground);
    this.a.setTextSize(0, this.mTextSize);
    this.a.setLineSpacing(this.mLineSpaceExtra, 1.0F);
    this.a.setIncludeFontPadding(false);
    this.a.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    if ((paramObject instanceof qfw)) {
      a((qfw)paramObject);
    }
    return true;
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return super.setAttribute(paramInt, paramString);
    case 1188: 
      try
      {
        paramInt = Color.parseColor(String.valueOf(paramString));
        this.a.setTextColor(paramInt);
        QLog.d("SummaryView", 1, "setEmotionFontColor: " + paramInt);
        return true;
      }
      catch (Exception paramString)
      {
        QLog.e("SummaryView", 1, paramString, new Object[0]);
        return false;
      }
    case 1187: 
      try
      {
        this.mTextSize = Utils.dp2px(Integer.valueOf(String.valueOf(paramString)).intValue());
        QLog.d("SummaryView", 1, "setEmotionFontSize: " + this.mTextSize);
        return true;
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("SummaryView", 1, paramString, new Object[0]);
        return false;
      }
    case 1189: 
      try
      {
        this.mLineSpaceExtra = Utils.rp2px(Float.valueOf(String.valueOf(paramString)).floatValue());
        QLog.d("SummaryView", 1, "setEmotionlineSpace: " + this.mLineSpaceExtra);
        return true;
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("SummaryView", 1, paramString, new Object[0]);
        return false;
      }
    }
    try
    {
      paramInt = Color.parseColor(paramString);
      this.a.setLinkedTextColor(paramInt);
      QLog.d("SummaryView", 1, "SummaryView | setLinkTextColor: " + paramInt);
      return true;
    }
    catch (Exception paramString)
    {
      QLog.e("SummaryView", 1, paramString, new Object[0]);
    }
    return false;
  }
  
  public void setTextColor(int paramInt)
  {
    this.a.setTextColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qvj
 * JD-Core Version:    0.7.0.1
 */