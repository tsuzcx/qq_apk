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
  private Context jdField_a_of_type_AndroidContentContext;
  private QQEmoticonMainPanelApp jdField_a_of_type_ComTencentMobileqqEmoticonviewIpcQQEmoticonMainPanelApp = new QQEmoticonMainPanelApp();
  private IRichTextPanelExtendHelper jdField_a_of_type_ComTencentMobileqqHiboomIRichTextPanelExtendHelper;
  private String jdField_a_of_type_JavaLangString;
  
  public RichTextPanelEmoticonSearchLayoutHelper(IPanelInteractionListener paramIPanelInteractionListener, Context paramContext, IRichTextPanelExtendHelper paramIRichTextPanelExtendHelper)
  {
    super(paramIPanelInteractionListener);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqHiboomIRichTextPanelExtendHelper = paramIRichTextPanelExtendHelper;
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
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public QQEmoticonMainPanelApp getApp()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIpcQQEmoticonMainPanelApp;
  }
  
  public Context getContext()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public int getPageType()
  {
    return 2;
  }
  
  public String getSearchWord()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String getTag()
  {
    return "RichTextPanelEmoticonSearchLayoutHelper";
  }
  
  public void onPullDown()
  {
    this.jdField_a_of_type_ComTencentMobileqqHiboomIRichTextPanelExtendHelper.onPullDown();
  }
  
  public void onPullUp() {}
  
  public void setSearchWords(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.emosearch.RichTextPanelEmoticonSearchLayoutHelper
 * JD-Core Version:    0.7.0.1
 */