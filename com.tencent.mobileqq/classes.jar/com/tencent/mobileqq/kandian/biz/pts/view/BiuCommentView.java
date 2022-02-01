package com.tencent.mobileqq.kandian.biz.pts.view;

import android.graphics.Color;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeBiuCommentView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;

public class BiuCommentView
  extends ArticleCommentView
{
  private NativeBiuCommentView a;
  
  public BiuCommentView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mTextSize = Utils.dp2px(16.0D);
    this.mLineSpaceExtra = Utils.rp2px(5.0D);
    this.a = new NativeBiuCommentView(paramVafContext.getContext());
    this.a.setTextColor(-16578534);
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    this.a.setModel(paramIReadInJoyModel);
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
  
  protected boolean setAttribute(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      default: 
        return super.setAttribute(paramInt, paramString);
      case 1195: 
        try
        {
          paramInt = Color.parseColor(paramString);
          this.a.setLinkedTextColor(paramInt);
          paramString = new StringBuilder();
          paramString.append("BiuCommentView | setLinkTextColor: ");
          paramString.append(paramInt);
          QLog.d("BiuCommentView", 1, paramString.toString());
          return true;
        }
        catch (Exception paramString)
        {
          QLog.e("BiuCommentView", 1, paramString, new Object[0]);
          return false;
        }
      case 1194: 
        try
        {
          this.mLineSpaceExtra = Utils.rp2px(Float.valueOf(String.valueOf(paramString)).floatValue());
          paramString = new StringBuilder();
          paramString.append("setEmotionlineSpace: ");
          paramString.append(this.mLineSpaceExtra);
          QLog.d("BiuCommentView", 1, paramString.toString());
          return true;
        }
        catch (NumberFormatException paramString)
        {
          QLog.e("BiuCommentView", 1, paramString, new Object[0]);
          return false;
        }
      case 1193: 
        try
        {
          paramInt = Color.parseColor(paramString);
          this.a.setTextColor(paramInt);
          paramString = new StringBuilder();
          paramString.append("setEmotionFontColor: ");
          paramString.append(paramInt);
          QLog.d("BiuCommentView", 1, paramString.toString());
          return true;
        }
        catch (Exception paramString)
        {
          QLog.e("BiuCommentView", 1, paramString, new Object[0]);
          return false;
        }
      }
      try
      {
        this.mTextSize = Utils.dp2px(Integer.valueOf(paramString).intValue());
        paramString = new StringBuilder();
        paramString.append("setEmotionFontSize: ");
        paramString.append(this.mTextSize);
        QLog.d("BiuCommentView", 1, paramString.toString());
        return true;
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("BiuCommentView", 1, paramString, new Object[0]);
        return false;
      }
    case 1179: 
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
    case 1178: 
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
    }
    try
    {
      this.a.setPreBlankNum(Integer.valueOf(paramString).intValue());
      return true;
    }
    catch (NumberFormatException paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.BiuCommentView
 * JD-Core Version:    0.7.0.1
 */