package com.tencent.mobileqq.emoticonview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.core.SystemEmotionPanelManager;
import com.tencent.mobileqq.emoticonview.api.IPanelDependListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class EmoticonLinearLayout$1
  implements EmoticonLinearLayout.DataObserver
{
  private int column;
  private int row;
  private boolean viewInited;
  
  EmoticonLinearLayout$1(EmoticonLinearLayout paramEmoticonLinearLayout) {}
  
  public void onDataChanged()
  {
    long l = System.currentTimeMillis();
    int m = this.this$0.mAdapter.getColumnNum();
    int n = this.this$0.mAdapter.getRowNum();
    int j = 0;
    int i = 0;
    int k;
    if (j < n)
    {
      k = 0;
      label41:
      if (k < m) {
        if (this.this$0.viewCache.size() > i) {}
      }
    }
    do
    {
      return;
      RelativeLayout localRelativeLayout = (RelativeLayout)this.this$0.viewCache.get(i);
      this.this$0.mAdapter.bindView(i, localRelativeLayout, this.this$0);
      i += 1;
      k += 1;
      break label41;
      j += 1;
      break;
      this.this$0.requestLayout();
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonLinearLayout", 2, "[Performance] EmoticonLinearLayout onDataChanged, bindView duration: " + (System.currentTimeMillis() - l) + ", type=" + this.this$0.panelViewType);
  }
  
  public void onStructChanged(int paramInt1, int paramInt2)
  {
    if ((this.row == paramInt1) && (this.column == paramInt2) && (this.viewInited)) {}
    long l;
    label322:
    do
    {
      return;
      this.row = paramInt1;
      this.column = paramInt2;
      l = System.currentTimeMillis();
      this.this$0.removeAllViews();
      paramInt2 = 0;
      paramInt1 = paramInt2;
      if (SystemEmotionPanelManager.a().a() != null)
      {
        paramInt1 = paramInt2;
        if (SystemEmotionPanelManager.a().a().getmAddedHeight() > 0) {
          paramInt1 = SystemEmotionPanelManager.a().a().getmAddedHeight() / 3;
        }
      }
      paramInt2 = paramInt1;
      if (paramInt1 > 60) {
        paramInt2 = 60;
      }
      this.this$0.setPadding(0, paramInt2, 0, paramInt2);
      paramInt1 = 0;
      paramInt2 = 0;
      while (paramInt2 < this.row)
      {
        LinearLayout localLinearLayout = new LinearLayout(this.this$0.context);
        LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -1);
        localLayoutParams1.weight = 1.0F;
        localLinearLayout.setOrientation(0);
        localLinearLayout.setPadding(0, 0, 0, 0);
        int i = 0;
        if (i < this.column)
        {
          System.currentTimeMillis();
          LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -1);
          localLayoutParams2.weight = 1.0F;
          RelativeLayout localRelativeLayout = null;
          if (paramInt1 < this.this$0.viewCache.size()) {
            localRelativeLayout = (RelativeLayout)this.this$0.viewCache.get(paramInt1);
          }
          Object localObject;
          if (localRelativeLayout == null)
          {
            localRelativeLayout = new RelativeLayout(this.this$0.context);
            localObject = new URLImageView(this.this$0.context);
            ((URLImageView)localObject).setId(2131378813);
            switch (this.this$0.panelViewType)
            {
            default: 
              if (QLog.isColorLevel()) {
                QLog.e("EmoticonLinearLayout", 2, "Should not reach here, check your code!!!");
              }
              this.this$0.viewCache.add(localRelativeLayout);
            }
          }
          for (;;)
          {
            localLinearLayout.addView(localRelativeLayout, localLayoutParams2);
            paramInt1 += 1;
            i += 1;
            break;
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(13, -1);
            ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
            ((URLImageView)localObject).setAdjustViewBounds(false);
            localRelativeLayout.addView((View)localObject, localLayoutParams);
            break label322;
            localObject = (ViewGroup)localRelativeLayout.getParent();
            if (localObject != null) {
              ((ViewGroup)localObject).removeAllViews();
            }
          }
        }
        this.this$0.addView(localLinearLayout, localLayoutParams1);
        paramInt2 += 1;
      }
      this.viewInited = true;
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonLinearLayout", 2, "[Performance] EmoticonLinearLayout create duration: " + (System.currentTimeMillis() - l) + ", type=" + this.this$0.panelViewType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.1
 * JD-Core Version:    0.7.0.1
 */