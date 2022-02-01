import android.graphics.Color;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeBiuCommentView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;

public class qil
  extends qih
{
  private NativeBiuCommentView a;
  
  public qil(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mTextSize = Utils.dp2px(16.0D);
    this.mLineSpaceExtra = Utils.rp2px(5.0D);
    this.a = new NativeBiuCommentView(paramVafContext.getContext());
    this.a.setTextColor(-16578534);
  }
  
  public void a(pxk parampxk)
  {
    this.a.setModel(parampxk);
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
    this.a.setTextSize(0, this.mTextSize);
    this.a.setLineSpacing(Utils.rp2px(5.0D), 1.0F);
    this.a.setIncludeFontPadding(false);
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return super.setAttribute(paramInt, paramString);
    case 1173: 
      try
      {
        this.a.setPreBlankNum(Integer.valueOf(paramString).intValue());
        return true;
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("BiuCommentView", 1, paramString, new Object[0]);
        return false;
      }
    case 1174: 
      try
      {
        this.a.setPreAccountUin(Long.parseLong(paramString));
        return true;
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("BiuCommentView", 1, paramString, new Object[0]);
        return false;
      }
    case 1175: 
      try
      {
        this.a.a("1".equals(paramString));
        return true;
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("BiuCommentView", 1, paramString, new Object[0]);
        return false;
      }
    case 1189: 
      try
      {
        paramInt = Color.parseColor(paramString);
        this.a.setTextColor(paramInt);
        QLog.d("BiuCommentView", 1, "setEmotionFontColor: " + paramInt);
        return true;
      }
      catch (Exception paramString)
      {
        QLog.e("BiuCommentView", 1, paramString, new Object[0]);
        return false;
      }
    case 1188: 
      try
      {
        this.mTextSize = Utils.dp2px(Integer.valueOf(paramString).intValue());
        QLog.d("BiuCommentView", 1, "setEmotionFontSize: " + this.mTextSize);
        return true;
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("BiuCommentView", 1, paramString, new Object[0]);
        return false;
      }
    case 1190: 
      try
      {
        this.mLineSpaceExtra = Utils.rp2px(Float.valueOf(String.valueOf(paramString)).floatValue());
        QLog.d("BiuCommentView", 1, "setEmotionlineSpace: " + this.mLineSpaceExtra);
        return true;
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("BiuCommentView", 1, paramString, new Object[0]);
        return false;
      }
    }
    try
    {
      paramInt = Color.parseColor(paramString);
      this.a.setLinkedTextColor(paramInt);
      QLog.d("BiuCommentView", 1, "BiuCommentView | setLinkTextColor: " + paramInt);
      return true;
    }
    catch (Exception paramString)
    {
      QLog.e("BiuCommentView", 1, paramString, new Object[0]);
    }
    return false;
  }
  
  public void setTextColor(int paramInt)
  {
    this.a.setTextColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qil
 * JD-Core Version:    0.7.0.1
 */