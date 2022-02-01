package com.tencent.mobileqq.hiboom;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import arae;
import arai;
import aufg;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.emoticonview.EmoticonPanelOnScrollListener;
import com.tencent.mobileqq.emoticonview.EmotionHotPicSearchAdapter;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPool;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;

public class EmoticonHotPicSearchPanelView
  extends RichTextPanelView
{
  private arai jdField_a_of_type_Arai;
  private aufg jdField_a_of_type_Aufg;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private EmotionHotPicSearchAdapter jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionHotPicSearchAdapter;
  private EmotionPanelListView jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView;
  
  public EmoticonHotPicSearchPanelView(Context paramContext, BaseChatPie paramBaseChatPie, aufg paramaufg)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Aufg = paramaufg;
    this.jdField_a_of_type_Arai = new arai(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, paramContext, paramaufg);
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView = new EmotionPanelListView(getContext());
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setVerticalScrollBarEnabled(false);
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView, new RelativeLayout.LayoutParams(-1, -1));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    View localView = View.inflate(getContext(), 2131558600, null);
    localRelativeLayout.addView(localView, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionHotPicSearchAdapter = new EmotionHotPicSearchAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, getContext(), 4, 14, 12, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setDivider(null);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setEdgeEffectEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setSelector(2130850608);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionHotPicSearchAdapter.widthPixels = ViewUtils.getScreenWidth();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionHotPicSearchAdapter.setCurrentListView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView);
    this.jdField_a_of_type_Arai.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionHotPicSearchAdapter);
    this.jdField_a_of_type_Arai.setEmptyView(localView);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionHotPicSearchAdapter);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setEnableExtendPanle(true);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setPullAndFastScrollListener(this.jdField_a_of_type_Aufg);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setOnScrollListener(new EmoticonPanelOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView, this.jdField_a_of_type_Aufg, null));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.addOnScrollListener(this.jdField_a_of_type_Arai);
    addView(localRelativeLayout, new RelativeLayout.LayoutParams(-1, -1));
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getText() != null)) {
      this.jdField_a_of_type_Arai.startSearch(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getText().toString());
    }
  }
  
  public String a()
  {
    return getContext().getString(2131689876);
  }
  
  public void a()
  {
    String str2;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getText() != null))
    {
      String str1 = this.jdField_a_of_type_Arai.getSearchWord();
      str2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getText().toString();
      if ((!StringUtil.isEmpty(str1)) && (str1.equals(str2))) {
        this.jdField_a_of_type_Arai.setLoadingStatus(3);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionHotPicSearchAdapter.setData(new ArrayList());
    this.jdField_a_of_type_Arai.setSearchWords(str2);
    this.jdField_a_of_type_Arai.onShow();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHotPicSearchPanelView", 4, " reportDefaultExposedEvent ");
    }
    this.jdField_a_of_type_Arai.reportItemExposed();
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Arai.onHide(paramBoolean);
  }
  
  public void c()
  {
    super.c();
    if ((arae.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a() instanceof arai)) {
      this.jdField_a_of_type_Arai.resetEmoticonSearch();
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
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionHotPicSearchAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionHotPicSearchAdapter.widthPixels != paramInt1))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionHotPicSearchAdapter.widthPixels = paramInt1;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionHotPicSearchAdapter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.EmoticonHotPicSearchPanelView
 * JD-Core Version:    0.7.0.1
 */