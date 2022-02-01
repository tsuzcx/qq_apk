package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticonview.api.IHotPicSearchService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class EmotionHotPicSearchAdapter
  extends BaseEmotionAdapter
  implements IEmotionHotPicSearchAdapter
{
  private static final int IMG_HEIGHT_SPACE = 2;
  public static final String REPORT_TAG_0X800AE2D = "0X800AE2D";
  private static final String TAG = "EmotionHotPicSearchAdapter";
  private IEmoticonPanelController mEmoPanelController;
  private IPanelInteractionListener mInteractionListener;
  private boolean mIsEmoPanelSearch = false;
  private boolean mIsRichPanelSearch = false;
  private List<String> mReportedMD5List = new ArrayList();
  
  public EmotionHotPicSearchAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, IPanelInteractionListener paramIPanelInteractionListener, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback)
  {
    super(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.mInteractionListener = paramIPanelInteractionListener;
  }
  
  private URLImageView getHotPicSearchEmoView(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionHotPicSearchAdapter", 2, "getCameraEmoView");
    }
    int i = (int)(this.widthPixels - this.density * 2.0F * (this.columnNum - 1));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i / this.columnNum, i / this.columnNum);
    if (paramInt == 0)
    {
      localLayoutParams.rightMargin = ((int)(this.density * 1.0F));
      localLayoutParams.leftMargin = 0;
    }
    else if (paramInt == this.columnNum - 1)
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
    URLImageView localURLImageView = new URLImageView(this.mContext);
    localURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localURLImageView.setAdjustViewBounds(false);
    localURLImageView.setLayoutParams(localLayoutParams);
    localURLImageView.setContentDescription(this.mContext.getString(2131699753));
    return localURLImageView;
  }
  
  private void reportExposeEvent(EmotionPanelData paramEmotionPanelData, int paramInt)
  {
    if ((paramEmotionPanelData instanceof HotPicSearchEmoticonInfo))
    {
      paramEmotionPanelData = (HotPicSearchEmoticonInfo)paramEmotionPanelData;
      if (paramEmotionPanelData.mSearchItem == null) {
        return;
      }
      String str = paramEmotionPanelData.mSearchItem.getEmoMd5();
      if (this.mReportedMD5List.contains(str)) {
        return;
      }
      if (paramEmotionPanelData.mPageType == 1)
      {
        IEmoticonPanelController localIEmoticonPanelController = this.mEmoPanelController;
        if ((localIEmoticonPanelController != null) && (this.mIsEmoPanelSearch))
        {
          int i = getFromType(localIEmoticonPanelController);
          if ((i != 0) && (TextUtils.isEmpty(paramEmotionPanelData.mSearchWord)))
          {
            this.mReportedMD5List.add(str);
            ReportController.b(this.app.getAppRuntime(), "dc00898", "", "", "0X800AE1D", "0X800AE1D", i, 0, "2", "", paramEmotionPanelData.mSearchItem.getEmoMd5(), String.valueOf(paramInt + 1));
            return;
          }
          if (TextUtils.isEmpty(paramEmotionPanelData.mSearchWord)) {
            return;
          }
          this.mReportedMD5List.add(str);
          ReportController.b(this.app.getAppRuntime(), "dc00898", "", "", "0X800AE2D", "0X800AE2D", 0, 0, "2", "", paramEmotionPanelData.mSearchItem.getEmoMd5(), String.valueOf(paramInt + 1));
          return;
        }
      }
      if ((paramEmotionPanelData.mPageType == 2) && (this.mIsRichPanelSearch))
      {
        this.mReportedMD5List.add(str);
        ReportController.b(this.app.getAppRuntime(), "dc00898", "", "", "0X800AE35", "0X800AE35", ((IHotPicSearchService)QRoute.api(IHotPicSearchService.class)).getReportFromType(), 0, "2", "", paramEmotionPanelData.mSearchItem.getEmoMd5(), String.valueOf(paramInt + 1));
      }
    }
  }
  
  private void updateUI(View paramView, EmotionPanelData paramEmotionPanelData, int paramInt)
  {
    if ((paramView != null) && ((paramEmotionPanelData instanceof EmoticonInfo)))
    {
      URLImageView localURLImageView = (URLImageView)paramView;
      EmoticonInfo localEmoticonInfo = (EmoticonInfo)paramEmotionPanelData;
      paramView.setTag(localEmoticonInfo);
      paramView.setVisibility(0);
      if ((QLog.isColorLevel()) && (!StringUtil.a(localEmoticonInfo.action)))
      {
        paramView = new StringBuilder();
        paramView.append("updateUI info = ");
        paramView.append(localEmoticonInfo.action);
        QLog.d("EmotionHotPicSearchAdapter", 2, paramView.toString());
      }
      if (localURLImageView.getTag(2131380884) == paramEmotionPanelData) {
        return;
      }
      reportExposeEvent(paramEmotionPanelData, paramInt);
      localURLImageView.setTag(2131380884, paramEmotionPanelData);
      localURLImageView.setVisibility(0);
      localURLImageView.setURLDrawableDownListener(null);
      paramView = localEmoticonInfo.getBigDrawable(this.mContext, this.density);
      if ((paramView instanceof URLDrawable)) {
        localURLImageView.setURLDrawableDownListener(new EmotionHotPicSearchAdapter.1(this, localEmoticonInfo));
      }
      localURLImageView.setImageDrawable(paramView);
      return;
    }
    QLog.e("EmotionHotPicSearchAdapter", 1, "emotionInfo or contentView = null");
  }
  
  public void clearReportedMD5List()
  {
    this.mReportedMD5List.clear();
  }
  
  public View getEmotionView(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (EmotionHotPicSearchAdapter.HotPicSearchEmotionViewHolder)paramViewHolder;
    int j = 0;
    int i = j;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramView = EmotionPanelViewPool.getInstance().getView(this.panelType);
      paramViewHolder = paramView;
      if (paramView == null)
      {
        if (QLog.isColorLevel())
        {
          paramViewHolder = new StringBuilder();
          paramViewHolder.append("getEmotionView position = ");
          paramViewHolder.append(paramInt);
          paramViewHolder.append("; view from inflater");
          QLog.d("EmotionHotPicSearchAdapter", 2, paramViewHolder.toString());
        }
        paramView = new EmoticonPanelLinearLayout(this.mContext, new QQEmoticonPanelLinearLayoutHelper(this.mContext, this.mInteractionListener), -1);
        paramView.setPanelType(6);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramView.setOrientation(0);
        paramView.setPadding(0, (int)(this.density * 2.0F), 0, 0);
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
    while (i < this.columnNum)
    {
      j = this.columnNum * paramInt + i;
      if (j > this.data.size() - 1)
      {
        paramViewGroup.contentViews[i].setTag(null);
        paramViewGroup.contentViews[i].setVisibility(8);
      }
      else
      {
        updateUI(paramViewGroup.contentViews[i], (EmotionPanelData)this.data.get(j), j);
      }
      i += 1;
    }
    return paramViewHolder;
  }
  
  protected int getFromType(IEmoticonPanelController paramIEmoticonPanelController)
  {
    if ((paramIEmoticonPanelController instanceof EmoticonPanelController)) {
      return ((EmoticonPanelMallHelper)((EmoticonPanelController)paramIEmoticonPanelController).getHelper(5)).getFromType();
    }
    return 0;
  }
  
  public int getWidthPixels()
  {
    return this.widthPixels;
  }
  
  protected boolean isEmoPanelSearch(IEmoticonPanelController paramIEmoticonPanelController)
  {
    boolean bool3 = paramIEmoticonPanelController instanceof EmoticonPanelController;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (((EmoticonPanelController)paramIEmoticonPanelController).findIndexByPanelType(12) == BasePanelModel.sLastSelectedSecondTabIndex) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new EmotionHotPicSearchAdapter.HotPicSearchEmotionViewHolder();
  }
  
  public void reportDefaultExposeEvent(int paramInt1, int paramInt2)
  {
    if ((this.data != null) && (!this.data.isEmpty()) && (paramInt1 >= 0))
    {
      int i = (paramInt2 + 1) * 4;
      paramInt2 = paramInt1;
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportDefaultExposeEvent lastVisiblePosition: ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" firstVisiblePosition: ");
        ((StringBuilder)localObject).append(paramInt1);
        QLog.d("EmotionHotPicSearchAdapter", 4, ((StringBuilder)localObject).toString());
        paramInt2 = paramInt1;
      }
      while (paramInt2 < i)
      {
        if (paramInt2 >= this.data.size()) {
          return;
        }
        localObject = (EmotionPanelData)this.data.get(paramInt2);
        if ((localObject instanceof HotPicSearchEmoticonInfo))
        {
          HotPicSearchEmoticonInfo localHotPicSearchEmoticonInfo = (HotPicSearchEmoticonInfo)localObject;
          if (localHotPicSearchEmoticonInfo.mSearchItem != null)
          {
            String str = localHotPicSearchEmoticonInfo.mSearchItem.getEmoMd5();
            if (this.mReportedMD5List.contains(str))
            {
              if (!QLog.isColorLevel()) {
                break label252;
              }
              QLog.d("EmotionHotPicSearchAdapter", 4, "emoMd5 contains ");
              break label252;
            }
            if (localHotPicSearchEmoticonInfo.mPageType == 2) {
              this.mIsRichPanelSearch = true;
            } else if (localHotPicSearchEmoticonInfo.mPageType == 1) {
              this.mIsEmoPanelSearch = true;
            }
            reportExposeEvent((EmotionPanelData)localObject, paramInt2);
            break label252;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("EmotionHotPicSearchAdapter", 4, "searchItem is null ");
        }
        label252:
        paramInt2 += 1;
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmotionHotPicSearchAdapter", 4, "reportDefaultExposeEvent data is null");
    }
  }
  
  public void setData(List<EmotionPanelData> paramList)
  {
    updateSearchEnable(paramList);
    super.setData(paramList);
  }
  
  public void setEmoPanelController(IEmoticonPanelController paramIEmoticonPanelController)
  {
    this.mEmoPanelController = paramIEmoticonPanelController;
  }
  
  public void setWidthPixels(int paramInt)
  {
    this.widthPixels = paramInt;
  }
  
  public void updateSearchEnable(List<EmotionPanelData> paramList)
  {
    this.mIsRichPanelSearch = false;
    this.mIsEmoPanelSearch = false;
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = (EmotionPanelData)paramList.get(0);
      if ((paramList instanceof HotPicSearchEmoticonInfo))
      {
        paramList = (HotPicSearchEmoticonInfo)paramList;
        if (paramList.mSearchItem == null) {
          return;
        }
        if (paramList.mPageType == 2)
        {
          if (((IHotPicSearchService)QRoute.api(IHotPicSearchService.class)).isRichTextLastTab(this.app.getApplication(), this.app.getCurrentAccountUin())) {
            this.mIsRichPanelSearch = true;
          }
        }
        else if ((paramList.mPageType == 1) && (isEmoPanelSearch(this.mEmoPanelController))) {
          this.mIsEmoPanelSearch = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionHotPicSearchAdapter
 * JD-Core Version:    0.7.0.1
 */