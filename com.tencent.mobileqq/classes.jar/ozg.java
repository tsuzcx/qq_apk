import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeGifView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;

public class ozg
  extends ViewBase
{
  private NativeGifView a;
  
  public ozg(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new NativeGifView(paramVafContext.getContext());
  }
  
  private boolean a()
  {
    return this.mParams.mLayoutHeight * this.mParams.mLayoutWidth > 2000000;
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
    this.a.setGifHeight(this.mParams.mLayoutHeight);
    this.a.setGifWidth(this.mParams.mLayoutWidth);
    this.a.setIsBigImg(a());
    this.a.setBackgroundColor(this.mBackground);
    this.a.a();
    refresh();
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return super.setAttribute(paramInt, paramObject);
      try
      {
        this.mParams.mLayoutWidth = ((Integer)paramObject).intValue();
        this.a.requestLayout();
        return true;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          QLog.d("ReadInJoyGifView", 2, paramObject.getMessage());
        }
      }
      try
      {
        this.mParams.mLayoutHeight = ((Integer)paramObject).intValue();
        this.a.requestLayout();
        return true;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          QLog.d("ReadInJoyGifView", 2, paramObject.getMessage());
        }
      }
      try
      {
        Integer localInteger = Utils.toInteger(paramObject);
        if ((this.a != null) && (localInteger != null)) {
          this.a.setScaleType(localInteger.intValue());
        }
      }
      catch (Exception localException)
      {
        QLog.d("ReadInJoyGifView", 2, localException.getMessage());
      }
    }
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return super.setAttribute(paramInt, paramString);
    case 1141: 
      this.a.setGifUrl(paramString);
      return true;
    }
    this.a.setCoverUrl(paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ozg
 * JD-Core Version:    0.7.0.1
 */