package com.tencent.mobileqq.hiboom;

import QC.BubbleInfo;
import QC.BubbleRecommendRsp;
import QC.ItemBase;
import android.content.Context;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BubbleController
  implements FontBubblePanelView.Controller<BubbleRecommendRsp>
{
  public int a()
  {
    return 4;
  }
  
  public String a(Context paramContext)
  {
    return IndividuationUrlHelper.a(paramContext, "bubble", "mvip.gongneng.android.bubble.index_dynamic_tab");
  }
  
  public String a(FontBubble paramFontBubble)
  {
    return IndividuationUrlHelper.a("bubblePreview").replace("[id]", Integer.toString(paramFontBubble.bubbleId));
  }
  
  public List<FontBubble> a(QQAppInterface paramQQAppInterface, BubbleRecommendRsp paramBubbleRecommendRsp)
  {
    paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramQQAppInterface.getAccount());
    int i = 0;
    int j;
    if (paramQQAppInterface == null)
    {
      QLog.e("FontBubbleManager", 1, "BubbleController no ExtensionInfo");
      j = 0;
    }
    else
    {
      i = (int)paramQQAppInterface.uVipFont;
      j = paramQQAppInterface.vipFontType;
    }
    paramQQAppInterface = new ArrayList();
    if (paramBubbleRecommendRsp.vItems != null)
    {
      paramBubbleRecommendRsp = paramBubbleRecommendRsp.vItems.iterator();
      while (paramBubbleRecommendRsp.hasNext())
      {
        BubbleInfo localBubbleInfo = (BubbleInfo)paramBubbleRecommendRsp.next();
        FontBubble localFontBubble = new FontBubble();
        localFontBubble.viewType = 1;
        localFontBubble.fontId = i;
        localFontBubble.engine = j;
        localFontBubble.bubbleId = localBubbleInfo.item.itemId;
        localFontBubble.name = localBubbleInfo.name;
        localFontBubble.feeType = localBubbleInfo.feeType;
        localFontBubble.payUrl = localBubbleInfo.payUrl;
        localFontBubble.title = localBubbleInfo.title;
        localFontBubble.msg = localBubbleInfo.msg;
        localFontBubble.btn = localBubbleInfo.btn;
        localFontBubble.picUrl = localBubbleInfo.strPicUrl;
        localFontBubble.panelType = 4;
        paramQQAppInterface.add(localFontBubble);
      }
    }
    return paramQQAppInterface;
  }
  
  public void a(ISVIPHandler paramISVIPHandler)
  {
    paramISVIPHandler.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.BubbleController
 * JD-Core Version:    0.7.0.1
 */