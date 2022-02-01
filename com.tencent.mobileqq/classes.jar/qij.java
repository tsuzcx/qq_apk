import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAvatarView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;

public class qij
  extends ViewBase
{
  private NativeAvatarView a;
  
  public qij(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new NativeAvatarView(paramVafContext.getContext());
  }
  
  private boolean a(Object paramObject)
  {
    if ((paramObject instanceof Long))
    {
      this.a.setUin(((Long)paramObject).longValue());
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    this.a.setLiveStatusUrl(paramString);
    return true;
  }
  
  private boolean b(String paramString)
  {
    this.a.setLiveRingUrl(paramString);
    return true;
  }
  
  private boolean c(String paramString)
  {
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
  
  public void a(pxk parampxk)
  {
    this.a.setModel(parampxk);
  }
  
  public void a(pxk parampxk, boolean paramBoolean)
  {
    this.a.setModel(parampxk, paramBoolean);
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
    boolean bool2 = false;
    switch (paramInt)
    {
    }
    for (boolean bool1 = false;; bool1 = a(paramObject))
    {
      if (!bool1)
      {
        bool1 = bool2;
        if (!super.setAttribute(paramInt, paramObject)) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    switch (paramInt)
    {
    case 1076: 
    default: 
      bool1 = false;
    }
    for (;;)
    {
      if (!bool1)
      {
        bool1 = bool2;
        if (!super.setAttribute(paramInt, paramString)) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      bool1 = c(paramString);
      continue;
      bool1 = b(paramString);
      continue;
      bool1 = a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qij
 * JD-Core Version:    0.7.0.1
 */