package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.api.IApolloDependApi;
import com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService;
import com.tencent.mobileqq.qqemoticon.api.IPanelController;
import com.tencent.mobileqq.qqemoticon.api.IPanelListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class SystemAndEmojiAdapter
  extends BaseEmotionAdapter
  implements View.OnClickListener
{
  public static final int EMOJI_WIDTH = 30;
  public static final int ITEM_TYPE_PIC = 1;
  public static final int ITEM_TYPE_TITLE = 0;
  public static final String TAG = "SystemAndEmojiAdapter";
  private int apolloEmoticonRow = -1;
  private int businessType;
  protected int emojiWidth;
  public boolean isOnlySysEmotion = false;
  private int lastItemAddPaddingBottom;
  int mEmotionType = -1;
  int mLocalId = -1;
  @Nullable
  private IPanelController mPanelController;
  private IPanelListener mPanelListener;
  private boolean mPopupGuideHided;
  private boolean showDescribeInPreview = false;
  protected int spaceWidth;
  
  public SystemAndEmojiAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, IPanelListener paramIPanelListener, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback, int paramInt4)
  {
    super(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.businessType = paramInt4;
    this.mPanelListener = paramIPanelListener;
    this.emojiWidth = ((int)(this.density * 30.0F));
  }
  
  private int findEmoticonIndex(List<EmotionPanelData> paramList, int paramInt)
  {
    return findEmoticonIndex(paramList, -1, paramInt);
  }
  
  private int findEmoticonIndex(List<EmotionPanelData> paramList, int paramInt1, int paramInt2)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      int j = paramList.size();
      while (i < j)
      {
        Object localObject = (EmotionPanelData)paramList.get(i);
        if ((localObject instanceof SystemAndEmojiEmoticonInfo))
        {
          localObject = (SystemAndEmojiEmoticonInfo)localObject;
          if ((!((SystemAndEmojiEmoticonInfo)localObject).isCommonUsed) && (((SystemAndEmojiEmoticonInfo)localObject).code == paramInt2) && ((paramInt1 == -1) || (paramInt1 == ((SystemAndEmojiEmoticonInfo)localObject).emotionType))) {
            return i;
          }
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public View getEmotionView(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.spaceWidth = ((this.widthPixels - (int)(this.density * 18.0F) * 2 - this.emojiWidth * this.columnNum) / (this.columnNum - 1));
    long l1 = System.currentTimeMillis();
    SystemAndEmojiAdapter.SystemAndEmojiHolder localSystemAndEmojiHolder = (SystemAndEmojiAdapter.SystemAndEmojiHolder)paramViewHolder;
    if (getItemViewType(paramInt) == 0)
    {
      if (paramView == null)
      {
        paramViewHolder = new LinearLayout(this.mContext);
        paramView = new LinearLayout.LayoutParams(-2, -2);
        paramView.topMargin = ((int)(this.density * 6.0F));
        paramView.leftMargin = ((int)(this.density * 18.0F));
        paramViewGroup = new TextView(this.mContext);
        paramViewGroup.setTextSize(8.0F);
        paramViewGroup.setTextColor(this.mContext.getResources().getColor(2131168122));
        paramViewHolder.addView(paramViewGroup, paramView);
        localSystemAndEmojiHolder.titleTxt = paramViewGroup;
        paramViewHolder.setTag(localSystemAndEmojiHolder);
      }
      else
      {
        paramViewHolder = paramView;
      }
      paramView = (EmotionPanelData)this.data.get(this.columnNum * paramInt);
      if ((paramView instanceof SystemAndEmojiEmoticonInfo)) {
        paramView = (SystemAndEmojiEmoticonInfo)paramView;
      } else {
        paramView = null;
      }
      if (paramView != null) {
        paramView = paramView.title;
      } else {
        paramView = "";
      }
      localSystemAndEmojiHolder.titleTxt.setText(paramView);
      paramView = paramViewHolder;
    }
    else
    {
      int j;
      if (paramView == null)
      {
        paramView = EmotionPanelViewPool.getInstance().getView(this.panelType);
        if (paramView == null)
        {
          if (QLog.isColorLevel())
          {
            paramViewHolder = new StringBuilder();
            paramViewHolder.append("getEmotionView position = ");
            paramViewHolder.append(paramInt);
            paramViewHolder.append(";view from inflater");
            QLog.d("SystemAndEmojiAdapter", 2, paramViewHolder.toString());
          }
          paramViewHolder = ((IEmoticonInfoService)QRoute.api(IEmoticonInfoService.class)).createEmoticonPanelLayoutHelper(this.mContext, this.mPanelListener);
          paramViewHolder.setShowDescribeInPreview(this.showDescribeInPreview);
          paramViewHolder = new EmoticonPanelLinearLayout(this.mContext, paramViewHolder, this.businessType);
          paramViewHolder.setPanelType(0);
          paramViewHolder.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
          paramViewHolder.setOrientation(0);
          i = this.emojiWidth + (int)(this.density * 12.0F);
          if (paramInt == getCount() - 1) {
            i = this.emojiWidth;
          }
          j = 0;
          while (j < this.columnNum)
          {
            paramView = new EmoticonImageView(this.mContext);
            paramViewGroup = new LinearLayout.LayoutParams(this.emojiWidth, i);
            if (j == 0) {
              paramViewGroup.leftMargin = ((int)(this.density * 18.0F));
            } else {
              paramViewGroup.leftMargin = this.spaceWidth;
            }
            paramView.setLayoutParams(paramViewGroup);
            paramView.setVisibility(8);
            paramView.setScaleType(ImageView.ScaleType.FIT_START);
            paramView.setAdjustViewBounds(false);
            paramView.setFocusable(true);
            paramView.setFocusableInTouchMode(true);
            paramViewHolder.addView(paramView);
            j += 1;
          }
        }
        else
        {
          paramViewHolder = paramView;
          if (QLog.isColorLevel())
          {
            paramViewHolder = new StringBuilder();
            paramViewHolder.append("getEmotionView position = ");
            paramViewHolder.append(paramInt);
            paramViewHolder.append(";view from cache");
            QLog.d("SystemAndEmojiAdapter", 2, paramViewHolder.toString());
            paramViewHolder = paramView;
          }
        }
        ((EmoticonPanelLinearLayout)paramViewHolder).setCallBack(this.callback);
        recycleView(this.panelType, paramViewHolder);
        paramView = (ViewGroup)paramViewHolder;
        localSystemAndEmojiHolder.contentViews = new EmoticonImageView[this.columnNum];
        i = 0;
        while (i < this.columnNum)
        {
          localSystemAndEmojiHolder.contentViews[i] = ((EmoticonImageView)paramView.getChildAt(i));
          i += 1;
        }
        paramViewHolder.setTag(localSystemAndEmojiHolder);
      }
      else
      {
        paramViewHolder = paramView;
      }
      if (this.isOnlySysEmotion)
      {
        if (paramInt == 0)
        {
          f = this.density;
          break label701;
        }
      }
      else {
        if ((paramInt == 1) || (paramInt == 5)) {
          break label695;
        }
      }
      int i = 0;
      break label710;
      label695:
      float f = this.density;
      label701:
      i = (int)(f * 7.0F);
      label710:
      paramViewHolder.setPadding(0, i, 0, 0);
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("inflater view cost = ");
        paramView.append(l2 - l1);
        QLog.d("SystemAndEmojiAdapter", 2, paramView.toString());
      }
      i = 0;
      for (;;)
      {
        paramView = paramViewHolder;
        if (i >= this.columnNum) {
          break;
        }
        j = this.columnNum * paramInt + i;
        if (j > this.data.size() - 1) {
          localSystemAndEmojiHolder.contentViews[i].setVisibility(8);
        }
        for (;;)
        {
          break;
          EmoticonImageView localEmoticonImageView = localSystemAndEmojiHolder.contentViews[i];
          paramViewGroup = (EmotionPanelData)this.data.get(j);
          if ((paramViewGroup instanceof SystemAndEmojiEmoticonInfo)) {
            paramView = (SystemAndEmojiEmoticonInfo)paramViewGroup;
          } else {
            paramView = null;
          }
          if (paramView == null)
          {
            localEmoticonImageView.setVisibility(8);
          }
          else
          {
            localSystemAndEmojiHolder.contentViews[i].setTag(paramView);
            if (paramView.code == -1)
            {
              localEmoticonImageView.setVisibility(8);
            }
            else
            {
              localEmoticonImageView.setVisibility(0);
              if (paramViewGroup != localEmoticonImageView.getTag(2131449867))
              {
                localEmoticonImageView.setTag(2131449867, paramViewGroup);
                if (((IApolloDependApi)QRoute.api(IApolloDependApi.class)).shouldShowNewIcon(paramView.code))
                {
                  localEmoticonImageView.setNewIconVisible(true);
                  ((IApolloDependApi)QRoute.api(IApolloDependApi.class)).onEmoticonNewIconShown(paramView.code);
                  if ((this.mPanelController != null) && (!this.mPopupGuideHided))
                  {
                    this.mPopupGuideHided = true;
                    ThreadManagerV2.getUIHandlerV2().postDelayed(new SystemAndEmojiAdapter.2(this), 100L);
                  }
                }
                else
                {
                  localEmoticonImageView.setNewIconVisible(false);
                }
                l2 = System.currentTimeMillis();
                paramViewGroup = paramView.getDrawable(false);
                Object localObject;
                if (QLog.isColorLevel())
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("getdrawable cost = ");
                  ((StringBuilder)localObject).append(System.currentTimeMillis() - l2);
                  QLog.d("SystemAndEmojiAdapter", 2, ((StringBuilder)localObject).toString());
                }
                localEmoticonImageView.setImageDrawable(paramViewGroup);
                if (paramView.emotionType == 1)
                {
                  localObject = QQSysFaceUtil.getFaceDescription(paramView.code);
                  paramViewGroup = (ViewGroup)localObject;
                  if (localObject != null)
                  {
                    paramViewGroup = (ViewGroup)localObject;
                    if (((String)localObject).startsWith("/"))
                    {
                      paramViewGroup = (ViewGroup)localObject;
                      if (((String)localObject).length() > 1) {
                        paramViewGroup = ((String)localObject).substring(1);
                      }
                    }
                  }
                  if (paramViewGroup != null) {
                    localEmoticonImageView.setContentDescription(paramViewGroup);
                  }
                }
                else if (paramView.emotionType == 2)
                {
                  localEmoticonImageView.setContentDescription(QQEmojiUtil.getEmojiDescription(paramView.code));
                }
                else
                {
                  localEmoticonImageView.setContentDescription(HardCodeUtil.a(2131916994));
                }
                ((IApolloDependApi)QRoute.api(IApolloDependApi.class)).apolloCmEmojiDtReport(paramView.code);
                paramViewGroup = this.mPanelController;
                if ((paramViewGroup != null) && (paramViewGroup.isInAIO()))
                {
                  localEmoticonImageView.setOnClickListener(this);
                  localEmoticonImageView.setClickable(false);
                  EmotionReportDtImpl.bindSystemAndEmojiFaceView(localEmoticonImageView, paramView, j, this.columnNum);
                }
                if (paramView.emotionType == 1) {
                  ReportController.b(null, "dc00898", "", "", "0X800BB9D", "0X800BB9D", QQSysFaceUtil.convertToServer(paramView.code), 0, "", "", "", "");
                }
              }
            }
          }
        }
        i += 1;
      }
    }
    if ((paramInt == getCount() - 1) && (this.lastItemAddPaddingBottom != 0)) {
      paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getPaddingRight(), paramView.getPaddingBottom() + this.lastItemAddPaddingBottom);
    }
    if (QLog.isColorLevel())
    {
      paramViewHolder = new StringBuilder();
      paramViewHolder.append("getEmoticonView cost = ");
      paramViewHolder.append(System.currentTimeMillis() - l1);
      QLog.d("SystemAndEmojiAdapter", 2, paramViewHolder.toString());
    }
    return paramView;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = this.columnNum;
    Object localObject = (EmotionPanelData)this.data.get(paramInt * i);
    if ((localObject instanceof SystemAndEmojiEmoticonInfo)) {
      localObject = (SystemAndEmojiEmoticonInfo)localObject;
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      if (((SystemAndEmojiEmoticonInfo)localObject).emotionType == 3) {
        return 0;
      }
      return 1;
    }
    return -1;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new SystemAndEmojiAdapter.SystemAndEmojiHolder();
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SystemAndEmojiAdapter", 2, "SystemAndEmojiAdapter itemView onClicked");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void refreshPanelData()
  {
    super.refreshPanelData();
    this.data = this.dataHasWhiteFace;
    notifyDataSetChanged();
  }
  
  public void setData(List<EmotionPanelData> paramList)
  {
    super.setData(paramList);
    this.dataHasWhiteFace = paramList;
    refreshPanelData();
    if (SystemEmoticonInfo.sNewApolloEmoticonMap.containsKey("8.8.17"))
    {
      List localList = (List)SystemEmoticonInfo.sNewApolloEmoticonMap.get("8.8.17");
      if ((localList != null) && (localList.size() > 0))
      {
        int i = findEmoticonIndex(paramList, ((Integer)localList.get(0)).intValue());
        if (i != -1) {
          this.apolloEmoticonRow = (i / this.columnNum);
        }
      }
    }
    if ((this.mLocalId != -1) && (this.mEmotionType != -1) && (this.currentView != null))
    {
      setSelectionToEmoticonByLocalId(this.mEmotionType, this.mLocalId);
      this.mLocalId = -1;
      this.mEmotionType = -1;
    }
  }
  
  public void setLastItemAddPaddingBottom(int paramInt)
  {
    this.lastItemAddPaddingBottom = paramInt;
  }
  
  public void setPanelController(IPanelController paramIPanelController)
  {
    this.mPanelController = paramIPanelController;
  }
  
  public void setSelectionToApolloEmoticon()
  {
    setSelectionToEmoticon(this.apolloEmoticonRow);
  }
  
  public void setSelectionToEmoticon(int paramInt)
  {
    if ((this.currentView != null) && (paramInt >= 0))
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      this.currentView.abordFling();
      this.currentView.setSelection(i);
    }
  }
  
  public void setSelectionToEmoticonByLocalId(int paramInt1, int paramInt2)
  {
    if ((paramInt2 != -1) && (this.currentView != null))
    {
      paramInt1 = findEmoticonIndex(this.data, paramInt1, paramInt2);
      if (paramInt1 != -1)
      {
        paramInt1 /= this.columnNum;
        this.currentView.post(new SystemAndEmojiAdapter.1(this, paramInt1));
      }
    }
  }
  
  public void setShowDescribeInPreview(boolean paramBoolean)
  {
    this.showDescribeInPreview = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiAdapter
 * JD-Core Version:    0.7.0.1
 */