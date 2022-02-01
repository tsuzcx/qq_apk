package com.tencent.mobileqq.emosm.emosearch;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper;
import com.tencent.mobileqq.emoticonview.IEmotionHotPicSearchAdapter;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.hiboom.IRichTextPanelExtendHelper;
import com.tencent.widget.ListView;

public class RichTextPanelEmoticonSearchLayoutHelper
  extends EmoticonPanelHotPicSearchHelper
  implements IEmoticonSearchHelper, IRichTextPanelEmoticonSearchLayoutHelper
{
  private QQEmoticonMainPanelApp a = new QQEmoticonMainPanelApp();
  private Context b;
  private String c;
  private IRichTextPanelExtendHelper d;
  
  public RichTextPanelEmoticonSearchLayoutHelper(IPanelInteractionListener paramIPanelInteractionListener, Context paramContext, IRichTextPanelExtendHelper paramIRichTextPanelExtendHelper)
  {
    super(paramIPanelInteractionListener);
    this.b = paramContext;
    this.d = paramIRichTextPanelExtendHelper;
  }
  
  public void a(ViewGroup paramViewGroup, IEmotionHotPicSearchAdapter paramIEmotionHotPicSearchAdapter)
  {
    paramViewGroup = (ListView)paramViewGroup;
    attach(paramViewGroup, (BaseEmotionAdapter)paramIEmotionHotPicSearchAdapter);
    paramIEmotionHotPicSearchAdapter = getFooterView();
    if (paramIEmotionHotPicSearchAdapter.getParent() == null) {
      paramViewGroup.addFooterView(paramIEmotionHotPicSearchAdapter);
    }
  }
  
  public void clearSearchWords()
  {
    this.c = null;
  }
  
  public QQEmoticonMainPanelApp getApp()
  {
    return this.a;
  }
  
  public Context getContext()
  {
    return this.b;
  }
  
  public int getPageType()
  {
    return 2;
  }
  
  public String getSearchWord()
  {
    return this.c;
  }
  
  public String getTag()
  {
    return "RichTextPanelEmoticonSearchLayoutHelper";
  }
  
  public void onPullDown()
  {
    this.d.onPullDown();
  }
  
  public void onPullUp() {}
  
  public void setSearchWords(String paramString)
  {
    this.c = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.emosearch.RichTextPanelEmoticonSearchLayoutHelper
 * JD-Core Version:    0.7.0.1
 */