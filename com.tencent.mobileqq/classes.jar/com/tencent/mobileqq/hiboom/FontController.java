package com.tencent.mobileqq.hiboom;

import QC.FontInfo;
import QC.FontRecommendRsp;
import QC.ItemBase;
import android.content.Context;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FontController
  implements FontBubblePanelView.Controller<FontRecommendRsp>
{
  public int a()
  {
    return 3;
  }
  
  public String a(Context paramContext)
  {
    return IndividuationUrlHelper.a(paramContext, "font", "mvip.gexinghua.mobile.font.client_tab_store");
  }
  
  public String a(FontBubble paramFontBubble)
  {
    return IndividuationUrlHelper.a("fontPreview").replace("[id]", Integer.toString(paramFontBubble.fontId));
  }
  
  public List<FontBubble> a(QQAppInterface paramQQAppInterface, FontRecommendRsp paramFontRecommendRsp)
  {
    int j = ((ISVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).b();
    paramQQAppInterface = new ArrayList();
    if (paramFontRecommendRsp.vItems != null)
    {
      paramFontRecommendRsp = paramFontRecommendRsp.vItems.iterator();
      while (paramFontRecommendRsp.hasNext())
      {
        FontInfo localFontInfo = (FontInfo)paramFontRecommendRsp.next();
        FontBubble localFontBubble = new FontBubble();
        localFontBubble.viewType = 1;
        localFontBubble.fontId = localFontInfo.item.itemId;
        int i;
        if (localFontInfo.linkBubbleID > 0) {
          i = localFontInfo.linkBubbleID;
        } else {
          i = j;
        }
        localFontBubble.bubbleId = i;
        localFontBubble.name = localFontInfo.name;
        localFontBubble.engine = localFontInfo.engine;
        localFontBubble.feeType = localFontInfo.feeType;
        localFontBubble.payUrl = localFontInfo.payUrl;
        localFontBubble.title = localFontInfo.title;
        localFontBubble.msg = localFontInfo.msg;
        localFontBubble.btn = localFontInfo.btn;
        localFontBubble.picUrl = localFontInfo.strPicUrl;
        localFontBubble.panelType = 3;
        paramQQAppInterface.add(localFontBubble);
      }
    }
    return paramQQAppInterface;
  }
  
  public void a(ISVIPHandler paramISVIPHandler)
  {
    paramISVIPHandler.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontController
 * JD-Core Version:    0.7.0.1
 */