package com.tencent.mobileqq.theme.diy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class ItemView
  extends RelativeLayout
{
  static final String TAG = "ThemeIDY_ItemView";
  View bgView;
  ImageView mFlagFeetype;
  TextView mNameTv;
  ImageView mThumImg;
  TextView mUsedTv;
  public ResSuitData resSuitData;
  
  public ItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void init(ResSuitData paramResSuitData1, ResSuitData paramResSuitData2, ResSuitData paramResSuitData3, boolean paramBoolean)
  {
    if (this.mThumImg == null)
    {
      this.mThumImg = ((ImageView)super.findViewById(2131378659));
      this.mUsedTv = ((TextView)super.findViewById(2131380341));
      this.mUsedTv.setVisibility(8);
      this.mNameTv = ((TextView)super.findViewById(2131371552));
      this.bgView = super.findViewById(2131380339);
      this.mFlagFeetype = ((ImageView)super.findViewById(2131366733));
    }
    if (paramResSuitData1 == null)
    {
      QLog.e("ThemeIDY_ItemView", 1, "init resData = null");
      return;
    }
    this.resSuitData = paramResSuitData1;
    Object localObject1;
    int i;
    if (!paramBoolean)
    {
      localObject1 = DIYThemeUtils.getResData(null, paramResSuitData1, 117, paramResSuitData1.thumbnail);
      if (!(paramResSuitData1 instanceof ResSuitData.BgSuit)) {
        break label414;
      }
      if (!"99".equals(paramResSuitData1.id)) {
        break label334;
      }
      ((ResData)localObject1).resID = 2130846093;
      i = super.getResources().getColor(2131166567);
    }
    for (;;)
    {
      localObject1 = DIYThemeUtils.getDIYDrawable(super.getContext(), (ResData)localObject1, this.mThumImg.getWidth(), this.mThumImg.getHeight(), -1, false);
      label178:
      label200:
      Object localObject2;
      if (i == 0)
      {
        this.mThumImg.setImageDrawable(null);
        this.mThumImg.setBackgroundDrawable((Drawable)localObject1);
        localObject2 = paramResSuitData1.name;
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() > 5) {
            localObject1 = ((String)localObject2).substring(0, 4) + "...";
          }
        }
        this.mNameTv.setText((CharSequence)localObject1);
        if (paramResSuitData1.feeType != 5) {
          break label475;
        }
        this.mFlagFeetype.setImageResource(2130847052);
        label281:
        if ((paramResSuitData2 == null) || (!paramResSuitData1.id.equals(paramResSuitData2.id))) {
          break label506;
        }
        this.bgView.setVisibility(0);
      }
      for (;;)
      {
        if ((paramResSuitData3 == null) || (!paramResSuitData1.id.equals(paramResSuitData3.id))) {
          break label518;
        }
        this.mUsedTv.setVisibility(0);
        return;
        label334:
        if ("100".equals(paramResSuitData1.id))
        {
          if (paramResSuitData1.resID > 0) {}
          for (i = paramResSuitData1.resID;; i = 2130846093)
          {
            ((ResData)localObject1).resID = i;
            i = 0;
            break;
          }
        }
        localObject2 = ((ResSuitData.BgSuit)paramResSuitData1).resData;
        if ((localObject2 == null) || (TextUtils.isEmpty(((ResData)localObject2).path))) {
          break label528;
        }
        i = 0;
        localObject1 = localObject2;
        break;
        label414:
        if ("999".equals(paramResSuitData1.id)) {
          ((ResData)localObject1).resID = 2130846048;
        }
        localObject1 = DIYThemeUtils.getDIYDrawable(super.getContext(), (ResData)localObject1, 0, 0, -1, false);
        i = 0;
        break label178;
        this.mThumImg.setImageDrawable((Drawable)localObject1);
        this.mThumImg.setBackgroundColor(i);
        break label200;
        label475:
        if (paramResSuitData1.feeType == 4)
        {
          this.mFlagFeetype.setImageResource(2130847053);
          break label281;
        }
        this.mFlagFeetype.setImageDrawable(null);
        break label281;
        label506:
        this.bgView.setVisibility(8);
      }
      label518:
      this.mUsedTv.setVisibility(8);
      return;
      label528:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ItemView
 * JD-Core Version:    0.7.0.1
 */