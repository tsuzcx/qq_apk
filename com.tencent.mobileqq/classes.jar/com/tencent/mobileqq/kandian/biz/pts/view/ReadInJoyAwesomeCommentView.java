package com.tencent.mobileqq.kandian.biz.pts.view;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeAwesomeCommentView;
import com.tencent.mobileqq.kandian.repo.db.struct.AwesomeCommentInfo;

public class ReadInJoyAwesomeCommentView
  extends ViewBase
{
  private NativeAwesomeCommentView a;
  
  public ReadInJoyAwesomeCommentView(VafContext paramVafContext)
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
    NativeAwesomeCommentView localNativeAwesomeCommentView = this.a;
    if (localNativeAwesomeCommentView != null) {
      localNativeAwesomeCommentView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    NativeAwesomeCommentView localNativeAwesomeCommentView = this.a;
    if (localNativeAwesomeCommentView != null) {
      localNativeAwesomeCommentView.measure(paramInt1, paramInt2);
    }
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if ((paramInt == 1064) && ((paramObject instanceof AwesomeCommentInfo)))
    {
      NativeAwesomeCommentView localNativeAwesomeCommentView = this.a;
      if (localNativeAwesomeCommentView != null) {
        localNativeAwesomeCommentView.setAwesomeCommentInfo((AwesomeCommentInfo)paramObject);
      }
    }
    return super.setAttribute(paramInt, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyAwesomeCommentView
 * JD-Core Version:    0.7.0.1
 */