package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import bcef;
import bfyz;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.hiboom.RichTextPanel;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class EmotionHotPicSearchAdapter
  extends BaseEmotionAdapter
{
  private static final int IMG_HEIGHT_SPACE = 2;
  private static final String TAG = "EmotionHotPicSearchAdapter";
  protected final BaseChatPie mBaseChatPie;
  private boolean mIsEmoPanelSearch;
  private boolean mIsRichPanelSearch;
  private List<String> mReportedMD5List = new ArrayList();
  
  public EmotionHotPicSearchAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.mBaseChatPie = paramBaseChatPie;
  }
  
  private URLImageView getHotPicSearchEmoView(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionHotPicSearchAdapter", 2, "getCameraEmoView");
    }
    int i = (int)(this.widthPixels - 2.0F * this.density * (this.columnNum - 1));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i / this.columnNum, i / this.columnNum);
    if (paramInt == 0)
    {
      localLayoutParams.rightMargin = ((int)(this.density * 1.0F));
      localLayoutParams.leftMargin = 0;
    }
    for (;;)
    {
      URLImageView localURLImageView = new URLImageView(this.mContext);
      localURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localURLImageView.setAdjustViewBounds(false);
      localURLImageView.setLayoutParams(localLayoutParams);
      localURLImageView.setContentDescription(this.mContext.getString(2131691134));
      return localURLImageView;
      if (paramInt == this.columnNum - 1)
      {
        localLayoutParams.leftMargin = ((int)(this.density * 1.0F));
        localLayoutParams.rightMargin = 0;
        localLayoutParams.width = -1;
      }
      else
      {
        localLayoutParams.rightMargin = ((int)(this.density * 1.0F));
        localLayoutParams.leftMargin = ((int)(this.density * 1.0F));
      }
    }
  }
  
  private void reportExposeEvent(EmotionPanelData paramEmotionPanelData, int paramInt)
  {
    if ((!(paramEmotionPanelData instanceof HotPicSearchEmoticonInfo)) || (((HotPicSearchEmoticonInfo)paramEmotionPanelData).mSearchItem == null)) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
          str = ((HotPicSearchEmoticonInfo)paramEmotionPanelData).mSearchItem.getEmoMd5();
        } while ((this.mReportedMD5List.contains(str)) || (this.mBaseChatPie == null));
        if ((((HotPicSearchEmoticonInfo)paramEmotionPanelData).mPageType != 1) || (this.mBaseChatPie.getEmoPanel() == null) || (!this.mIsEmoPanelSearch)) {
          break;
        }
        int i = ((EmoticonPanelMallHelper)this.mBaseChatPie.getEmoPanel().getEmoController().getHelper(5)).getFromType();
        if ((i != 0) && (TextUtils.isEmpty(((HotPicSearchEmoticonInfo)paramEmotionPanelData).mSearchWord)))
        {
          this.mReportedMD5List.add(str);
          bcef.b(this.mBaseChatPie.app, "dc00898", "", "", "0X800AE1D", "0X800AE1D", i, 0, "2", "", ((HotPicSearchEmoticonInfo)paramEmotionPanelData).mSearchItem.getEmoMd5(), String.valueOf(paramInt + 1));
          return;
        }
      } while (TextUtils.isEmpty(((HotPicSearchEmoticonInfo)paramEmotionPanelData).mSearchWord));
      this.mReportedMD5List.add(str);
      bcef.b(this.mBaseChatPie.app, "dc00898", "", "", "0X800AE2D", "0X800AE2D", 0, 0, "2", "", ((HotPicSearchEmoticonInfo)paramEmotionPanelData).mSearchItem.getEmoMd5(), String.valueOf(paramInt + 1));
      return;
    } while ((((HotPicSearchEmoticonInfo)paramEmotionPanelData).mPageType != 2) || (!this.mIsRichPanelSearch));
    this.mReportedMD5List.add(str);
    bcef.b(this.mBaseChatPie.app, "dc00898", "", "", "0X800AE35", "0X800AE35", RichTextPanel.a, 0, "2", "", ((HotPicSearchEmoticonInfo)paramEmotionPanelData).mSearchItem.getEmoMd5(), String.valueOf(paramInt + 1));
  }
  
  private void updateUI(View paramView, EmotionPanelData paramEmotionPanelData, int paramInt)
  {
    if ((paramView == null) || (!(paramEmotionPanelData instanceof EmoticonInfo))) {
      QLog.e("EmotionHotPicSearchAdapter", 1, "emotionInfo or contentView = null");
    }
    URLImageView localURLImageView;
    EmoticonInfo localEmoticonInfo;
    do
    {
      return;
      localURLImageView = (URLImageView)paramView;
      localEmoticonInfo = (EmoticonInfo)paramEmotionPanelData;
      paramView.setTag(localEmoticonInfo);
      paramView.setVisibility(0);
      if ((QLog.isColorLevel()) && (!StringUtil.isEmpty(localEmoticonInfo.action))) {
        QLog.d("EmotionHotPicSearchAdapter", 2, "updateUI info = " + localEmoticonInfo.action);
      }
    } while (localURLImageView.getTag(2131380831) == paramEmotionPanelData);
    reportExposeEvent(paramEmotionPanelData, paramInt);
    localURLImageView.setTag(2131380831, paramEmotionPanelData);
    localURLImageView.setVisibility(0);
    localURLImageView.setURLDrawableDownListener(null);
    paramView = localEmoticonInfo.getBigDrawable(this.mContext, this.density);
    if ((paramView instanceof URLDrawable)) {
      localURLImageView.setURLDrawableDownListener(new EmotionHotPicSearchAdapter.1(this, localEmoticonInfo));
    }
    localURLImageView.setImageDrawable(paramView);
  }
  
  public void clearReportedMD5List()
  {
    this.mReportedMD5List.clear();
  }
  
  public View getEmotionView(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    paramViewGroup = (EmotionHotPicSearchAdapter.HotPicSearchEmotionViewHolder)paramViewHolder;
    int i;
    if (paramView == null)
    {
      paramView = EmotionPanelViewPool.getInstance().getView(this.panelType);
      paramViewHolder = paramView;
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionHotPicSearchAdapter", 2, "getEmotionView position = " + paramInt + "; view from inflater");
        }
        paramView = new EmoticonPanelLinearLayout(this.mContext, this.mBaseChatPie, -1);
        paramView.setPanelType(EmoticonPanelLinearLayout.PANEL_TYPE_HOTPIC_EMOTION);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramView.setOrientation(0);
        paramView.setPadding(0, (int)(2.0F * this.density), 0, 0);
        i = 0;
        for (;;)
        {
          paramViewHolder = paramView;
          if (i >= this.columnNum) {
            break;
          }
          paramViewHolder = getHotPicSearchEmoView(i);
          paramViewHolder.setVisibility(8);
          paramViewHolder.setFocusable(true);
          paramViewHolder.setFocusableInTouchMode(true);
          paramView.addView(paramViewHolder);
          i += 1;
        }
      }
      ((EmoticonPanelLinearLayout)paramViewHolder).setCallBack(this.callback);
      recycleView(this.panelType, paramViewHolder);
      paramView = (ViewGroup)paramViewHolder;
      paramViewGroup.contentViews = new URLImageView[this.columnNum];
      i = 0;
      while (i < this.columnNum)
      {
        paramViewGroup.contentViews[i] = ((URLImageView)paramView.getChildAt(i));
        i += 1;
      }
      paramViewHolder.setTag(paramViewGroup);
      i = j;
    }
    for (;;)
    {
      if (i < this.columnNum)
      {
        j = this.columnNum * paramInt + i;
        if (j > this.data.size() - 1)
        {
          paramViewGroup.contentViews[i].setTag(null);
          paramViewGroup.contentViews[i].setVisibility(8);
        }
        for (;;)
        {
          i += 1;
          break;
          updateUI(paramViewGroup.contentViews[i], (EmotionPanelData)this.data.get(j), j);
        }
      }
      return paramViewHolder;
      paramViewHolder = paramView;
      i = j;
    }
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new EmotionHotPicSearchAdapter.HotPicSearchEmotionViewHolder();
  }
  
  public void reportDefaultExposeEvent(int paramInt1, int paramInt2)
  {
    if ((this.data == null) || (this.data.isEmpty()) || (paramInt1 < 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionHotPicSearchAdapter", 4, "reportDefaultExposeEvent data is null");
      }
      return;
    }
    int i = (paramInt2 + 1) * 4;
    paramInt2 = paramInt1;
    if (QLog.isColorLevel())
    {
      QLog.d("EmotionHotPicSearchAdapter", 4, "reportDefaultExposeEvent lastVisiblePosition: " + i + " firstVisiblePosition: " + paramInt1);
      paramInt2 = paramInt1;
    }
    label91:
    EmotionPanelData localEmotionPanelData;
    if ((paramInt2 < i) && (paramInt2 < this.data.size()))
    {
      localEmotionPanelData = (EmotionPanelData)this.data.get(paramInt2);
      if (((localEmotionPanelData instanceof HotPicSearchEmoticonInfo)) && (((HotPicSearchEmoticonInfo)localEmotionPanelData).mSearchItem != null)) {
        break label165;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmotionHotPicSearchAdapter", 4, "searchItem is null ");
      }
    }
    for (;;)
    {
      paramInt2 += 1;
      break label91;
      break;
      label165:
      String str = ((HotPicSearchEmoticonInfo)localEmotionPanelData).mSearchItem.getEmoMd5();
      if (!this.mReportedMD5List.contains(str)) {
        break label210;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmotionHotPicSearchAdapter", 4, "emoMd5 contains ");
      }
    }
    label210:
    if (((HotPicSearchEmoticonInfo)localEmotionPanelData).mPageType == 2) {
      this.mIsRichPanelSearch = true;
    }
    for (;;)
    {
      reportExposeEvent(localEmotionPanelData, paramInt2);
      break;
      if (((HotPicSearchEmoticonInfo)localEmotionPanelData).mPageType == 1) {
        this.mIsEmoPanelSearch = true;
      }
    }
  }
  
  public void setData(List<EmotionPanelData> paramList)
  {
    updateSearchEnable(paramList);
    super.setData(paramList);
  }
  
  public void updateSearchEnable(List<EmotionPanelData> paramList)
  {
    this.mIsRichPanelSearch = false;
    this.mIsEmoPanelSearch = false;
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      do
      {
        do
        {
          return;
          paramList = (EmotionPanelData)paramList.get(0);
        } while ((!(paramList instanceof HotPicSearchEmoticonInfo)) || (((HotPicSearchEmoticonInfo)paramList).mSearchItem == null));
        if (((HotPicSearchEmoticonInfo)paramList).mPageType != 2) {
          break;
        }
      } while (bfyz.aK(this.mBaseChatPie.app.getApp(), this.mBaseChatPie.app.getCurrentAccountUin()) != 5);
      this.mIsRichPanelSearch = true;
      return;
    } while ((((HotPicSearchEmoticonInfo)paramList).mPageType != 1) || (this.mBaseChatPie.getEmoPanel().getEmoController().findIndexByPanelType(12) != EmoticonPanelController.sLastSelectedSecondTabIndex));
    this.mIsEmoPanelSearch = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionHotPicSearchAdapter
 * JD-Core Version:    0.7.0.1
 */