package com.tencent.mobileqq.emosm.emosearch.api.impl;

import android.content.Context;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.emosm.emosearch.IEmoticonSearchHelper;
import com.tencent.mobileqq.emosm.emosearch.RichTextPanelEmoticonSearchLayoutHelper;
import com.tencent.mobileqq.emosm.emosearch.api.IRichTextPanelSearchHelperApi;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmotionHotPicSearchAdapter;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.IEmotionHotPicSearchAdapter;
import com.tencent.mobileqq.hiboom.IRichTextPanelExtendHelper;

public class RichTextPanelSearchHelperApiImpl
  implements IRichTextPanelSearchHelperApi
{
  public IEmotionHotPicSearchAdapter createSearchAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, IPanelInteractionListener paramIPanelInteractionListener, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback)
  {
    return new EmotionHotPicSearchAdapter(paramIEmoticonMainPanelApp, paramIPanelInteractionListener, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
  }
  
  public IEmoticonSearchHelper createSearchHelper(IPanelInteractionListener paramIPanelInteractionListener, Context paramContext, IRichTextPanelExtendHelper paramIRichTextPanelExtendHelper)
  {
    return new RichTextPanelEmoticonSearchLayoutHelper(paramIPanelInteractionListener, paramContext, paramIRichTextPanelExtendHelper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.emosearch.api.impl.RichTextPanelSearchHelperApiImpl
 * JD-Core Version:    0.7.0.1
 */