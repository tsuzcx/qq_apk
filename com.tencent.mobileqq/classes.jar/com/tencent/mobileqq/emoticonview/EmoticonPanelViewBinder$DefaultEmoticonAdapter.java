package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.text.EmotcationConstants;

class EmoticonPanelViewBinder$DefaultEmoticonAdapter
  extends EmoticonLinearLayout.EmoticonAdapter
{
  private static final int SIZE_CLASSIC_EMOTICON = 30;
  private int classicEmoticonSize;
  private int panelViewType;
  
  public EmoticonPanelViewBinder$DefaultEmoticonAdapter(EmoticonPanelViewBinder paramEmoticonPanelViewBinder, int paramInt)
  {
    this.classicEmoticonSize = ((int)(paramEmoticonPanelViewBinder.context.getResources().getDisplayMetrics().density * 30.0F));
    this.panelViewType = paramInt;
  }
  
  public void bindView(int paramInt, RelativeLayout paramRelativeLayout, ViewGroup paramViewGroup)
  {
    ImageView localImageView = (ImageView)paramRelativeLayout.findViewById(2131378202);
    localImageView.setVisibility(0);
    localImageView.setTag(Boolean.valueOf(false));
    EmoticonInfo localEmoticonInfo = getItem(paramInt);
    paramRelativeLayout.setTag(localEmoticonInfo);
    if ((localEmoticonInfo != null) && ((localEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)))
    {
      paramViewGroup = (SystemAndEmojiEmoticonInfo)localEmoticonInfo;
      paramInt = paramViewGroup.code;
      if (paramViewGroup.emotionType == 1)
      {
        if ((paramInt >= 0) && (paramInt < EmotcationConstants.SYS_EMOTICON_SYMBOL.length))
        {
          String str = EmotcationConstants.SYS_EMOTICON_SYMBOL[paramInt];
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
            paramRelativeLayout.setContentDescription(paramViewGroup);
          }
        }
      }
      else if (paramViewGroup.emotionType == 2) {
        paramRelativeLayout.setContentDescription(EmotcationConstants.getEmojiDesc(paramInt));
      }
    }
    paramViewGroup = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    float f = this.this$0.context.getResources().getDisplayMetrics().density;
    if (localEmoticonInfo != null)
    {
      if ((localEmoticonInfo.type == 1) || (localEmoticonInfo.type == 2) || (localEmoticonInfo.type == 7))
      {
        paramInt = this.classicEmoticonSize;
        paramViewGroup.width = paramInt;
        paramViewGroup.height = paramInt;
      }
      if (localEmoticonInfo.type != -1)
      {
        paramRelativeLayout = localEmoticonInfo.getDrawable(this.this$0.context, f);
        if (paramRelativeLayout != null) {
          localImageView.setImageDrawable(paramRelativeLayout);
        } else {
          localImageView.setVisibility(4);
        }
        localImageView.setBackgroundDrawable(null);
        return;
      }
      if ("delete".equals(localEmoticonInfo.action))
      {
        localImageView.setImageResource(2130850873);
        paramRelativeLayout.setContentDescription(this.this$0.context.getString(2131719424));
      }
    }
    else
    {
      localImageView.setImageDrawable(null);
      localImageView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelViewBinder.DefaultEmoticonAdapter
 * JD-Core Version:    0.7.0.1
 */