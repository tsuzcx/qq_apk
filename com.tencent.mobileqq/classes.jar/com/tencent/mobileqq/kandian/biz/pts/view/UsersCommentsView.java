package com.tencent.mobileqq.kandian.biz.pts.view;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeUsersCommentsView;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;

public class UsersCommentsView
  extends ViewBase
{
  private static String a = "UsersCommentsView";
  private NativeUsersCommentsView b;
  
  public UsersCommentsView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.b = new NativeUsersCommentsView(paramVafContext.getContext());
    this.b.setOrientation(1);
  }
  
  public void clearDynamicData()
  {
    this.b.setComments(null);
    this.b.setCommentAllLink(null);
  }
  
  public int getComMeasuredHeight()
  {
    return this.b.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.b.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.b;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.b.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    this.b.a();
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if (!super.setAttribute(paramInt, paramObject))
    {
      if (paramInt != 1017) {
        return false;
      }
      try
      {
        this.b.setComments((JSONArray)paramObject);
      }
      catch (Exception paramObject)
      {
        QLog.e(a, 2, "UsersCommentsView", paramObject);
      }
    }
    return true;
  }
  
  protected boolean setAttribute(int paramInt, String paramString)
  {
    if (!super.setAttribute(paramInt, paramString))
    {
      if (paramInt != 1018) {
        return false;
      }
      this.b.setCommentAllLink(paramString);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.UsersCommentsView
 * JD-Core Version:    0.7.0.1
 */