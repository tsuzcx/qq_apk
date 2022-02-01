package com.tencent.mobileqq.kandian.biz.pts.view;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeAvatarView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;

public class AvatarView
  extends ViewBase
{
  private NativeAvatarView a;
  
  public AvatarView(VafContext paramVafContext)
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
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    this.a.setModel(paramIReadInJoyModel);
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel, boolean paramBoolean)
  {
    this.a.setModel(paramIReadInJoyModel, paramBoolean);
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
  
  protected boolean onClick()
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
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramInt != 1011) && (paramInt != 1076)) {
      bool1 = false;
    } else {
      bool1 = a(paramObject);
    }
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
  
  protected boolean setAttribute(int paramInt, String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt != 1076)
    {
      if (paramInt != 1078)
      {
        if (paramInt != 1079) {
          bool1 = false;
        } else {
          bool1 = a(paramString);
        }
      }
      else {
        bool1 = b(paramString);
      }
    }
    else {
      bool1 = c(paramString);
    }
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.AvatarView
 * JD-Core Version:    0.7.0.1
 */