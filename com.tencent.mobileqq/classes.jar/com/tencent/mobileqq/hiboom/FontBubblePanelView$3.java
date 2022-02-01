package com.tencent.mobileqq.hiboom;

import QC.BubbleRecommendRsp;
import QC.CommonRsp;
import QC.FontRecommendRsp;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class FontBubblePanelView$3
  extends SVIPObserver
{
  FontBubblePanelView$3(FontBubblePanelView paramFontBubblePanelView) {}
  
  public void onGetBubbleRecommend(boolean paramBoolean, BubbleRecommendRsp paramBubbleRecommendRsp)
  {
    if (FontBubblePanelView.a(this.a) == 4)
    {
      if ((paramBoolean) && (paramBubbleRecommendRsp.vItems.size() > 0))
      {
        FontBubblePanelView.a(this.a, paramBubbleRecommendRsp);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("onGetBubbleRecommend failed, ");
      if ((paramBubbleRecommendRsp != null) && (paramBubbleRecommendRsp.stRet != null))
      {
        localStringBuilder.append("ret:");
        localStringBuilder.append(paramBubbleRecommendRsp.stRet.ret);
        localStringBuilder.append("err:");
        localStringBuilder.append(paramBubbleRecommendRsp.stRet.err);
      }
      QLog.e("FontBubblePanelView", 1, localStringBuilder.toString());
    }
  }
  
  public void onGetFontRecommend(boolean paramBoolean, FontRecommendRsp paramFontRecommendRsp)
  {
    if (FontBubblePanelView.a(this.a) == 3)
    {
      if ((paramBoolean) && (paramFontRecommendRsp.vItems.size() > 0))
      {
        FontBubblePanelView.a(this.a, paramFontRecommendRsp);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("onGetFontRecommend failed, ");
      if ((paramFontRecommendRsp != null) && (paramFontRecommendRsp.stRet != null))
      {
        localStringBuilder.append("ret:");
        localStringBuilder.append(paramFontRecommendRsp.stRet.ret);
        localStringBuilder.append("err:");
        localStringBuilder.append(paramFontRecommendRsp.stRet.err);
      }
      QLog.e("FontBubblePanelView", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubblePanelView.3
 * JD-Core Version:    0.7.0.1
 */