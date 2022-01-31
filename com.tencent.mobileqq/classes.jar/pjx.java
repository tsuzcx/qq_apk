import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAvatarView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;

public class pjx
  extends ViewBase
{
  private NativeAvatarView a;
  
  public pjx(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new NativeAvatarView(paramVafContext.getContext());
  }
  
  public void a(pax parampax)
  {
    this.a.setModel(parampax);
  }
  
  public void a(pax parampax, boolean paramBoolean)
  {
    this.a.setModel(parampax, paramBoolean);
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
  
  public boolean onClick()
  {
    super.onClick();
    return true;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.a.measureComponent(paramInt1, paramInt2);
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return super.setAttribute(paramInt, paramObject);
    }
    if ((paramObject instanceof Long)) {
      this.a.setUin(((Long)paramObject).longValue());
    }
    return true;
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return super.setAttribute(paramInt, paramString);
    }
    try
    {
      this.a.setUin(Long.valueOf(paramString).longValue());
      return true;
    }
    catch (NumberFormatException paramString)
    {
      QLog.e("AvatarView", 1, paramString, new Object[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pjx
 * JD-Core Version:    0.7.0.1
 */