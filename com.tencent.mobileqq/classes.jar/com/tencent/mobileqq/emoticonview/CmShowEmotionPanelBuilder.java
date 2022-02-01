package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.ui.ICmShowEmotionAdapterBuilder;
import com.tencent.mobileqq.emoticon.IEmotionPanelBuilder;
import com.tencent.mobileqq.qroute.QRoute;

public class CmShowEmotionPanelBuilder
  implements IEmotionPanelBuilder
{
  private BaseChatPie baseChatPie;
  private EmoticonCallback callback;
  private int columnNum;
  private int emotionType;
  private IEmoticonMainPanelApp mApp;
  private Context mContext;
  private int panelType;
  
  public CmShowEmotionPanelBuilder(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback, BaseChatPie paramBaseChatPie)
  {
    this.mApp = paramIEmoticonMainPanelApp;
    this.mContext = paramContext;
    this.columnNum = paramInt1;
    this.panelType = paramInt2;
    this.emotionType = paramInt3;
    this.callback = paramEmoticonCallback;
    this.baseChatPie = paramBaseChatPie;
  }
  
  public BaseEmotionAdapter buildComplete()
  {
    return ((ICmShowEmotionAdapterBuilder)QRoute.api(ICmShowEmotionAdapterBuilder.class)).build(this.mApp, this.mContext, this.columnNum, this.panelType, this.emotionType, this.callback, this.baseChatPie);
  }
  
  public void buildData() {}
  
  public void buildParams() {}
  
  public void buildView() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.CmShowEmotionPanelBuilder
 * JD-Core Version:    0.7.0.1
 */