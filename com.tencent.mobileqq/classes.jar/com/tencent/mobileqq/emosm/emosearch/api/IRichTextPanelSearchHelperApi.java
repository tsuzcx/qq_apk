package com.tencent.mobileqq.emosm.emosearch.api;

import android.content.Context;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.emosm.emosearch.IEmoticonSearchHelper;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.IEmotionHotPicSearchAdapter;
import com.tencent.mobileqq.hiboom.IRichTextPanelExtendHelper;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IRichTextPanelSearchHelperApi
  extends QRouteApi
{
  public abstract IEmotionHotPicSearchAdapter createSearchAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, IPanelInteractionListener paramIPanelInteractionListener, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback);
  
  public abstract IEmoticonSearchHelper createSearchHelper(IPanelInteractionListener paramIPanelInteractionListener, Context paramContext, IRichTextPanelExtendHelper paramIRichTextPanelExtendHelper);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.emosearch.api.IRichTextPanelSearchHelperApi
 * JD-Core Version:    0.7.0.1
 */