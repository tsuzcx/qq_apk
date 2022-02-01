package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.core.SystemEmotionPanelManager;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.api.IApolloDependListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.HashMap;
import java.util.List;

public class SystemAndEmojiAdapter
  extends BaseEmotionAdapter
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
  private boolean mPopupGuideHided;
  protected int spaceWidth;
  
  public SystemAndEmojiAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback, int paramInt4)
  {
    super(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.businessType = paramInt4;
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
    this.spaceWidth = ((this.widthPixels - (int)(18.0F * this.density) * 2 - this.emojiWidth * this.columnNum) / (this.columnNum - 1));
    long l1 = System.currentTimeMillis();
    SystemAndEmojiAdapter.SystemAndEmojiHolder localSystemAndEmojiHolder = (SystemAndEmojiAdapter.SystemAndEmojiHolder)paramViewHolder;
    if (getItemViewType(paramInt) == 0)
    {
      paramViewHolder = paramView;
      if (paramView == null)
      {
        paramViewHolder = new LinearLayout(this.mContext);
        paramView = new LinearLayout.LayoutParams(-2, -2);
        paramView.topMargin = ((int)(6.0F * this.density));
        paramView.leftMargin = ((int)(18.0F * this.density));
        paramViewGroup = new TextView(this.mContext);
        paramViewGroup.setTextSize(8.0F);
        paramViewGroup.setTextColor(this.mContext.getResources().getColor(2131167117));
        paramViewHolder.addView(paramViewGroup, paramView);
        localSystemAndEmojiHolder.titleTxt = paramViewGroup;
        paramViewHolder.setTag(localSystemAndEmojiHolder);
      }
      paramView = (EmotionPanelData)this.data.get(this.columnNum * paramInt);
      if (!(paramView instanceof SystemAndEmojiEmoticonInfo)) {
        break label1252;
      }
    }
    label1042:
    label1208:
    label1243:
    label1252:
    for (paramView = (SystemAndEmojiEmoticonInfo)paramView;; paramView = null)
    {
      if (paramView != null) {}
      for (paramView = paramView.title;; paramView = "")
      {
        localSystemAndEmojiHolder.titleTxt.setText(paramView);
        paramView = paramViewHolder;
        int i;
        long l2;
        label756:
        do
        {
          if ((paramInt == getCount() - 1) && (this.lastItemAddPaddingBottom != 0)) {
            paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getPaddingRight(), paramView.getPaddingBottom() + this.lastItemAddPaddingBottom);
          }
          if (QLog.isColorLevel()) {
            QLog.d("SystemAndEmojiAdapter", 2, "getEmoticonView cost = " + (System.currentTimeMillis() - l1));
          }
          return paramView;
          paramViewHolder = paramView;
          if (paramView == null)
          {
            paramView = EmotionPanelViewPool.getInstance().getView(this.panelType);
            if (paramView == null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("SystemAndEmojiAdapter", 2, "getEmotionView position = " + paramInt + ";view from inflater");
              }
              paramViewHolder = new EmoticonPanelLinearLayout(this.mContext, SystemEmotionPanelManager.a().a(this.mContext, true), this.businessType);
              paramViewHolder.setPanelType(0);
              paramViewHolder.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
              paramViewHolder.setOrientation(0);
              i = this.emojiWidth + (int)(12.0F * this.density);
              if (paramInt == getCount() - 1) {
                i = this.emojiWidth;
              }
              j = 0;
              if (j < this.columnNum)
              {
                paramView = new EmoticonImageView(this.mContext);
                paramViewGroup = new LinearLayout.LayoutParams(this.emojiWidth, i);
                if (j == 0) {}
                for (paramViewGroup.leftMargin = ((int)(18.0F * this.density));; paramViewGroup.leftMargin = this.spaceWidth)
                {
                  paramView.setLayoutParams(paramViewGroup);
                  paramView.setVisibility(8);
                  paramView.setScaleType(ImageView.ScaleType.FIT_START);
                  paramView.setAdjustViewBounds(false);
                  paramView.setFocusable(true);
                  paramView.setFocusableInTouchMode(true);
                  paramViewHolder.addView(paramView);
                  j += 1;
                  break;
                }
              }
            }
            for (;;)
            {
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
              paramViewHolder = paramView;
              if (QLog.isColorLevel())
              {
                QLog.d("SystemAndEmojiAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
                paramViewHolder = paramView;
              }
            }
            paramViewHolder.setTag(localSystemAndEmojiHolder);
          }
          i = 0;
          if (!this.isOnlySysEmotion) {
            break;
          }
          if (paramInt == 0) {
            i = (int)(7.0F * this.density);
          }
          paramViewHolder.setPadding(0, i, 0, 0);
          l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("SystemAndEmojiAdapter", 2, "inflater view cost = " + (l2 - l1));
          }
          i = 0;
          paramView = paramViewHolder;
        } while (i >= this.columnNum);
        int j = this.columnNum * paramInt + i;
        if (j > this.data.size() - 1) {
          localSystemAndEmojiHolder.contentViews[i].setVisibility(8);
        }
        for (;;)
        {
          i += 1;
          break label756;
          if ((paramInt != 1) && (paramInt != 5)) {
            break;
          }
          i = (int)(7.0F * this.density);
          break;
          EmoticonImageView localEmoticonImageView = localSystemAndEmojiHolder.contentViews[i];
          paramViewGroup = (EmotionPanelData)this.data.get(j);
          paramView = null;
          if ((paramViewGroup instanceof SystemAndEmojiEmoticonInfo)) {
            paramView = (SystemAndEmojiEmoticonInfo)paramViewGroup;
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
              if (paramViewGroup != localEmoticonImageView.getTag(2131381651))
              {
                localEmoticonImageView.setTag(2131381651, paramViewGroup);
                if ((SystemEmotionPanelManager.a().a() != null) && (SystemEmotionPanelManager.a().a().shouldShowNewIcon(paramView.code)))
                {
                  localEmoticonImageView.setNewIconVisible(true);
                  SystemEmotionPanelManager.a().a().onEmoticonNewIconShown(paramView.code);
                  if ((SystemEmotionPanelManager.a().a() != null) && (!this.mPopupGuideHided))
                  {
                    this.mPopupGuideHided = true;
                    ThreadManagerV2.getUIHandlerV2().postDelayed(new SystemAndEmojiAdapter.2(this), 100L);
                  }
                  l2 = System.currentTimeMillis();
                  paramViewGroup = paramView.getDrawable(false);
                  if (QLog.isColorLevel()) {
                    QLog.d("SystemAndEmojiAdapter", 2, "getdrawable cost = " + (System.currentTimeMillis() - l2));
                  }
                  localEmoticonImageView.setImageDrawable(paramViewGroup);
                  if (paramView.emotionType != 1) {
                    break label1208;
                  }
                  String str = QQSysFaceUtil.getFaceDescription(paramView.code);
                  paramViewGroup = str;
                  if (str != null)
                  {
                    paramViewGroup = str;
                    if (str.startsWith("/"))
                    {
                      paramViewGroup = str;
                      if (str.length() > 1) {
                        paramViewGroup = str.substring(1);
                      }
                    }
                  }
                  if (paramViewGroup != null) {
                    localEmoticonImageView.setContentDescription(paramViewGroup);
                  }
                }
                for (;;)
                {
                  if (SystemEmotionPanelManager.a().a() == null) {
                    break label1243;
                  }
                  SystemEmotionPanelManager.a().a().apolloCmEmojiDtReport(paramView.code);
                  break;
                  localEmoticonImageView.setNewIconVisible(false);
                  break label1042;
                  if (paramView.emotionType == 2) {
                    localEmoticonImageView.setContentDescription(QQEmojiUtil.getEmojiDescription(paramView.code));
                  } else {
                    localEmoticonImageView.setContentDescription(HardCodeUtil.a(2131719713));
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = this.columnNum;
    Object localObject = (EmotionPanelData)this.data.get(i * paramInt);
    if ((localObject instanceof SystemAndEmojiEmoticonInfo)) {}
    for (localObject = (SystemAndEmojiEmoticonInfo)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        if (((SystemAndEmojiEmoticonInfo)localObject).emotionType == 3) {
          return 0;
        }
        return 1;
      }
      return -1;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new SystemAndEmojiAdapter.SystemAndEmojiHolder();
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
    if (SystemEmoticonInfo.sNewApolloEmoticonMap.containsKey("8.5.5"))
    {
      List localList = (List)SystemEmoticonInfo.sNewApolloEmoticonMap.get("8.5.5");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiAdapter
 * JD-Core Version:    0.7.0.1
 */