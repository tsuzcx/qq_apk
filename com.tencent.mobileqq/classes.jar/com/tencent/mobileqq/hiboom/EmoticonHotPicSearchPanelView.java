package com.tencent.mobileqq.hiboom;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchManager;
import com.tencent.mobileqq.emosm.emosearch.RichTextPanelEmoticonSearchLayoutHelper;
import com.tencent.mobileqq.emoticonview.AIOEmoticonPanelHelper;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonPanelOnScrollListener;
import com.tencent.mobileqq.emoticonview.EmotionHotPicSearchAdapter;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPool;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;

public class EmoticonHotPicSearchPanelView
  extends RichTextPanelView
{
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private RichTextPanelEmoticonSearchLayoutHelper jdField_a_of_type_ComTencentMobileqqEmosmEmosearchRichTextPanelEmoticonSearchLayoutHelper;
  private EmotionHotPicSearchAdapter jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionHotPicSearchAdapter;
  private EmotionPanelListView jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView;
  private RichTextPanelExtendHelper jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper;
  
  public EmoticonHotPicSearchPanelView(Context paramContext, BaseChatPie paramBaseChatPie, RichTextPanelExtendHelper paramRichTextPanelExtendHelper)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper = paramRichTextPanelExtendHelper;
    this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchRichTextPanelEmoticonSearchLayoutHelper = new RichTextPanelEmoticonSearchLayoutHelper(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, paramRichTextPanelExtendHelper);
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView = new EmotionPanelListView(getContext());
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setVerticalScrollBarEnabled(false);
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView, new RelativeLayout.LayoutParams(-1, -1));
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    View localView = View.inflate(getContext(), 2131558636, null);
    localRelativeLayout.addView(localView, (ViewGroup.LayoutParams)localObject);
    localObject = (AIOEmoticonPanelHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(104);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionHotPicSearchAdapter = new EmotionHotPicSearchAdapter(new QQEmoticonMainPanelApp(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), getContext(), 4, 14, 12, (EmoticonCallback)localObject);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setDivider(null);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setEdgeEffectEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setSelector(2130851165);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionHotPicSearchAdapter.widthPixels = ViewUtils.a();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionHotPicSearchAdapter.setCurrentListView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView);
    this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchRichTextPanelEmoticonSearchLayoutHelper.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionHotPicSearchAdapter);
    this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchRichTextPanelEmoticonSearchLayoutHelper.setEmptyView(localView);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionHotPicSearchAdapter);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setEnableExtendPanle(true);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setPullAndFastScrollListener(this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setOnScrollListener(new EmoticonPanelOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView, this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper, null));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.addOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchRichTextPanelEmoticonSearchLayoutHelper);
    addView(localRelativeLayout, new RelativeLayout.LayoutParams(-1, -1));
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchRichTextPanelEmoticonSearchLayoutHelper.startSearch(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
    }
  }
  
  public String a()
  {
    return getContext().getString(2131689946);
  }
  
  public void a()
  {
    String str2;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null))
    {
      String str1 = this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchRichTextPanelEmoticonSearchLayoutHelper.getSearchWord();
      str2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      if ((!StringUtil.a(str1)) && (str1.equals(str2))) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchRichTextPanelEmoticonSearchLayoutHelper.setLoadingStatus(3);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionHotPicSearchAdapter.setData(new ArrayList());
    this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchRichTextPanelEmoticonSearchLayoutHelper.setSearchWords(str2);
    this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchRichTextPanelEmoticonSearchLayoutHelper.onShow();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHotPicSearchPanelView", 4, " reportDefaultExposedEvent ");
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchRichTextPanelEmoticonSearchLayoutHelper.reportItemExposed();
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchRichTextPanelEmoticonSearchLayoutHelper.onHide(paramBoolean);
  }
  
  public void c()
  {
    super.c();
    if ((EmotionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a() instanceof RichTextPanelEmoticonSearchLayoutHelper)) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchRichTextPanelEmoticonSearchLayoutHelper.resetEmoticonSearch();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    EmotionPanelViewPool.getInstance().destory();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredWidth();
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionHotPicSearchAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionHotPicSearchAdapter.widthPixels != paramInt1))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionHotPicSearchAdapter.widthPixels = paramInt1;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionHotPicSearchAdapter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.EmoticonHotPicSearchPanelView
 * JD-Core Version:    0.7.0.1
 */