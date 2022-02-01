package com.tencent.mobileqq.hiboom;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService;
import com.tencent.mobileqq.emosm.emosearch.IEmoticonSearchHelper;
import com.tencent.mobileqq.emosm.emosearch.IRichTextPanelEmoticonSearchLayoutHelper;
import com.tencent.mobileqq.emosm.emosearch.api.IRichTextPanelSearchHelperApi;
import com.tencent.mobileqq.emoticonview.AIOEmoticonPanelHelper;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonPanelOnScrollListener;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPool;
import com.tencent.mobileqq.emoticonview.IEmotionHotPicSearchAdapter;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelAppService;
import com.tencent.mobileqq.emoticonview.api.impl.AIOPanelInteractionListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;

public class EmoticonHotPicSearchPanelView
  extends RichTextPanelView
{
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private IEmoticonSearchHelper jdField_a_of_type_ComTencentMobileqqEmosmEmosearchIEmoticonSearchHelper;
  private EmotionPanelListView jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView;
  private IEmotionHotPicSearchAdapter jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmotionHotPicSearchAdapter;
  private RichTextPanelExtendHelper jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper;
  
  public EmoticonHotPicSearchPanelView(Context paramContext, BaseChatPie paramBaseChatPie, RichTextPanelExtendHelper paramRichTextPanelExtendHelper)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper = paramRichTextPanelExtendHelper;
    this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchIEmoticonSearchHelper = ((IRichTextPanelSearchHelperApi)QRoute.api(IRichTextPanelSearchHelperApi.class)).createSearchHelper(new AIOPanelInteractionListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie), paramContext, paramRichTextPanelExtendHelper);
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView = new EmotionPanelListView(getContext());
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setVerticalScrollBarEnabled(false);
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView, new RelativeLayout.LayoutParams(-1, -1));
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    Object localObject1 = View.inflate(getContext(), 2131558536, null);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = (AIOEmoticonPanelHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(104);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmotionHotPicSearchAdapter = ((IRichTextPanelSearchHelperApi)QRoute.api(IRichTextPanelSearchHelperApi.class)).createSearchAdapter(((IEmoticonMainPanelAppService)QRoute.api(IEmoticonMainPanelAppService.class)).createEmoticonMainPanelApp(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), new AIOPanelInteractionListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie), getContext(), 4, 14, 12, (EmoticonCallback)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setDivider(null);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setEdgeEffectEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setSelector(2130851081);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmotionHotPicSearchAdapter.setWidthPixels(ViewUtils.a());
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmotionHotPicSearchAdapter.setCurrentListView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView);
    ((IRichTextPanelEmoticonSearchLayoutHelper)this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchIEmoticonSearchHelper).a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmotionHotPicSearchAdapter);
    this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchIEmoticonSearchHelper.setEmptyView((View)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmotionHotPicSearchAdapter);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setEnableExtendPanle(true);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setPullAndFastScrollListener(this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView;
    ((EmotionPanelListView)localObject1).setOnScrollListener(new EmoticonPanelOnScrollListener((EmotionPanelListView)localObject1, this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper, null));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.addOnScrollListener((AbsListView.OnScrollListener)this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchIEmoticonSearchHelper);
    addView(localRelativeLayout, new RelativeLayout.LayoutParams(-1, -1));
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchIEmoticonSearchHelper.startSearch(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
    }
  }
  
  public String a()
  {
    return getContext().getString(2131689861);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null))
    {
      String str1 = this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchIEmoticonSearchHelper.getSearchWord();
      String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      if ((!StringUtil.a(str1)) && (str1.equals(str2)))
      {
        this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchIEmoticonSearchHelper.setLoadingStatus(3);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmotionHotPicSearchAdapter.setData(new ArrayList());
      this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchIEmoticonSearchHelper.setSearchWords(str2);
      this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchIEmoticonSearchHelper.onShow();
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHotPicSearchPanelView", 4, " reportDefaultExposedEvent ");
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchIEmoticonSearchHelper.reportItemExposed();
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchIEmoticonSearchHelper.onHide(paramBoolean);
  }
  
  public void c()
  {
    super.c();
    if ((((IEmotionSearchManagerService)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmotionSearchManagerService.class)).getSearchCallBack() instanceof IRichTextPanelEmoticonSearchLayoutHelper)) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchIEmoticonSearchHelper.resetEmoticonSearch();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    EmotionPanelViewPool.getInstance().destory();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredWidth();
    IEmotionHotPicSearchAdapter localIEmotionHotPicSearchAdapter = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmotionHotPicSearchAdapter;
    if ((localIEmotionHotPicSearchAdapter != null) && (localIEmotionHotPicSearchAdapter.getWidthPixels() != paramInt1))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmotionHotPicSearchAdapter.setWidthPixels(paramInt1);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmotionHotPicSearchAdapter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.EmoticonHotPicSearchPanelView
 * JD-Core Version:    0.7.0.1
 */