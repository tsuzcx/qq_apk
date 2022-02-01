package com.tencent.mobileqq.emoticonview;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService;
import com.tencent.mobileqq.qroute.QRoute;
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
    Object localObject;
    while (j < n)
    {
      int k = 0;
      while (k < m)
      {
        if (this.this$0.viewCache.size() <= i) {
          return;
        }
        localObject = (RelativeLayout)this.this$0.viewCache.get(i);
        this.this$0.mAdapter.bindView(i, (RelativeLayout)localObject, this.this$0);
        i += 1;
        k += 1;
      }
      j += 1;
    }
    this.this$0.requestLayout();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[Performance] EmoticonLinearLayout onDataChanged, bindView duration: ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      ((StringBuilder)localObject).append(", type=");
      ((StringBuilder)localObject).append(this.this$0.panelViewType);
      QLog.d("EmoticonLinearLayout", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onStructChanged(int paramInt1, int paramInt2)
  {
    if ((this.row == paramInt1) && (this.column == paramInt2) && (this.viewInited)) {
      return;
    }
    this.row = paramInt1;
    this.column = paramInt2;
    long l = System.currentTimeMillis();
    this.this$0.removeAllViews();
    paramInt1 = ((IEmoticonInfoService)QRoute.api(IEmoticonInfoService.class)).getAddedHeight();
    if (paramInt1 > 0) {
      paramInt1 /= 3;
    } else {
      paramInt1 = 0;
    }
    paramInt2 = paramInt1;
    if (paramInt1 > 60) {
      paramInt2 = 60;
    }
    this.this$0.setPadding(0, paramInt2, 0, paramInt2);
    paramInt2 = 0;
    paramInt1 = 0;
    Object localObject1;
    while (paramInt2 < this.row)
    {
      LinearLayout localLinearLayout = new LinearLayout(this.this$0.context);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -1);
      localLayoutParams1.weight = 1.0F;
      localLinearLayout.setOrientation(0);
      localLinearLayout.setPadding(0, 0, 0, 0);
      int i = 0;
      while (i < this.column)
      {
        System.currentTimeMillis();
        LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        localLayoutParams2.weight = 1.0F;
        localObject1 = null;
        if (paramInt1 < this.this$0.viewCache.size()) {
          localObject1 = (RelativeLayout)this.this$0.viewCache.get(paramInt1);
        }
        Object localObject2;
        Object localObject3;
        if (localObject1 == null)
        {
          localObject2 = new RelativeLayout(this.this$0.context);
          localObject1 = new URLImageView(this.this$0.context);
          ((URLImageView)localObject1).setId(2131446720);
          if (this.this$0.panelViewType != 2007)
          {
            if (QLog.isColorLevel()) {
              QLog.e("EmoticonLinearLayout", 2, "Should not reach here, check your code!!!");
            }
          }
          else
          {
            localObject3 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject3).addRule(13, -1);
            ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
            ((URLImageView)localObject1).setAdjustViewBounds(false);
            ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
          }
          this.this$0.viewCache.add(localObject2);
        }
        else
        {
          localObject3 = (ViewGroup)((RelativeLayout)localObject1).getParent();
          localObject2 = localObject1;
          if (localObject3 != null)
          {
            ((ViewGroup)localObject3).removeAllViews();
            localObject2 = localObject1;
          }
        }
        localLinearLayout.addView((View)localObject2, localLayoutParams2);
        paramInt1 += 1;
        i += 1;
      }
      this.this$0.addView(localLinearLayout, localLayoutParams1);
      paramInt2 += 1;
    }
    this.viewInited = true;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[Performance] EmoticonLinearLayout create duration: ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
      ((StringBuilder)localObject1).append(", type=");
      ((StringBuilder)localObject1).append(this.this$0.panelViewType);
      QLog.d("EmoticonLinearLayout", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.1
 * JD-Core Version:    0.7.0.1
 */