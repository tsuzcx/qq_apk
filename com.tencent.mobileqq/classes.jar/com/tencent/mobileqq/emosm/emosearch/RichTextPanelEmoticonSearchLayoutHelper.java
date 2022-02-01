package com.tencent.mobileqq.emosm.emosearch;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.hiboom.RichTextPanelExtendHelper;
import com.tencent.widget.ListView;

public class RichTextPanelEmoticonSearchLayoutHelper
  extends EmoticonPanelHotPicSearchHelper
  implements IEmoticonSearchHelper
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQEmoticonMainPanelApp jdField_a_of_type_ComTencentMobileqqEmoticonviewIpcQQEmoticonMainPanelApp;
  private RichTextPanelExtendHelper jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper;
  private String jdField_a_of_type_JavaLangString;
  
  public RichTextPanelEmoticonSearchLayoutHelper(QQAppInterface paramQQAppInterface, Context paramContext, RichTextPanelExtendHelper paramRichTextPanelExtendHelper)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIpcQQEmoticonMainPanelApp = new QQEmoticonMainPanelApp(paramQQAppInterface);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper = paramRichTextPanelExtendHelper;
  }
  
  public void a(ListView paramListView, BaseEmotionAdapter paramBaseEmotionAdapter)
  {
    attach(paramListView, paramBaseEmotionAdapter);
    paramBaseEmotionAdapter = getFooterView();
    if (paramBaseEmotionAdapter.getParent() == null) {
      paramListView.addFooterView(paramBaseEmotionAdapter);
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
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper.onPullDown();
  }
  
  public void onPullUp() {}
  
  public void setSearchWords(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.emosearch.RichTextPanelEmoticonSearchLayoutHelper
 * JD-Core Version:    0.7.0.1
 */