package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.diamondwall.AnimatorHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class QVipMedalView
  extends ViewGroup
{
  protected QVipMedalView.Adapter a;
  protected int b;
  protected int c;
  protected List<ImageView> d;
  
  public QVipMedalView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QVipMedalView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QVipMedalView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a(ImageView paramImageView, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QVipSettingMe.QVipMedalView", 1, "bindData with null value!!");
      return;
    }
    paramString = VasApngUtil.getApngURLDrawable(paramString, VasApngUtil.VIP_APNG_TAGS, URLDrawableHelperConstants.a, null, null);
    ProfileCardUtils.setNightModeFilterForImageView((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramImageView);
    paramImageView.setImageDrawable(paramString);
    paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramString != null) {
      paramInt1 = VipInfoHandler.a(paramString, paramString.getCurrentUin(), false);
    } else {
      paramInt1 = 98;
    }
    if (paramInt2 != 0)
    {
      AnimatorHandler localAnimatorHandler = new AnimatorHandler();
      Message localMessage = Message.obtain();
      localMessage.arg1 = 1;
      localMessage.obj = paramImageView;
      localMessage.what = 0;
      paramImageView = new Bundle();
      paramImageView.putInt("iTipsTimes", paramInt3);
      localMessage.setData(paramImageView);
      localAnimatorHandler.removeMessages(localMessage.what);
      localAnimatorHandler.sendMessage(localMessage);
      ReportController.b(paramString, "dc00898", "", paramString.getCurrentUin(), "0X800B2B3", "0X800B2B3", paramInt1, 0, String.valueOf(paramInt1), "", "", "");
      return;
    }
    ReportController.b(paramString, "dc00898", "", paramString.getCurrentUin(), "0X800B2B2", "0X800B2B2", paramInt1, 0, String.valueOf(paramInt1), "", "", "");
  }
  
  private void b()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    if (((QVipMedalView.Adapter)localObject).a() == getChildCount()) {
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("consistency check failed ! adapter count=");
    ((StringBuilder)localObject).append(this.a.a());
    ((StringBuilder)localObject).append(" view list size=");
    ((StringBuilder)localObject).append(this.d.size());
    ((StringBuilder)localObject).append(" child count=");
    ((StringBuilder)localObject).append(getChildCount());
    localObject = ((StringBuilder)localObject).toString();
    int i = 0;
    AssertUtils.fail((String)localObject, new Object[0]);
    int j = this.a.a();
    removeAllViews();
    while (i < j)
    {
      if (this.d.size() > i) {
        ((ImageView)this.d.get(i)).setImageDrawable(null);
      } else {
        this.d.add(new ImageView(getContext()));
      }
      a((ImageView)this.d.get(i), this.a.a(i), this.a.b(i), this.a.c(i), this.a.d(i));
      addView((View)this.d.get(i));
      i += 1;
    }
  }
  
  protected void a()
  {
    this.b = UIUtils.a(getContext(), 4.0F);
    this.d = new ArrayList();
  }
  
  public void a(String paramString, int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null) {
      ReportController.b(localQQAppInterface, "dc00898", "", localQQAppInterface.getCurrentUin(), paramString, paramString, paramInt, 0, String.valueOf(paramInt), "", "", "");
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    int i = ((QVipMedalView.Adapter)localObject).a();
    int j = getPaddingTop();
    int k = getPaddingBottom();
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      int m = (this.c + this.b) * paramInt2 + getPaddingLeft();
      int n = this.c + m;
      if (n > paramInt3 - paramInt1)
      {
        if (paramInt2 == 0)
        {
          QLog.e("QVipMedalView", 1, "illegal size to layout the medal!! no one can layout");
          return;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("It only can layout ");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append("medal");
        QLog.d("QVipMedalView", 1, ((StringBuilder)localObject).toString());
        return;
      }
      ((ImageView)this.d.get(paramInt2)).layout(m, j, n, paramInt4 - k);
      paramInt2 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    QVipMedalView.Adapter localAdapter = this.a;
    int i = 0;
    if (localAdapter == null)
    {
      setMeasuredDimension(0, 0);
      return;
    }
    int k = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    if (m == 1073741824)
    {
      this.c = (paramInt1 - getPaddingTop() - getPaddingBottom());
    }
    else
    {
      this.c = UIUtils.a(getContext(), 20.0F);
      paramInt1 = this.c + getPaddingBottom() + getPaddingTop();
    }
    if (k == 1073741824)
    {
      paramInt2 = j;
    }
    else
    {
      paramInt2 = this.a.a();
      j = this.c;
      k = this.b;
      m = getPaddingLeft();
      paramInt2 = getPaddingRight() + (j * paramInt2 + (paramInt2 - 1) * k + m);
    }
    j = this.a.a();
    b();
    while (i < j)
    {
      ((ImageView)this.d.get(i)).measure(View.MeasureSpec.makeMeasureSpec(this.c, 1073741824), View.MeasureSpec.makeMeasureSpec(this.c, 1073741824));
      i += 1;
    }
    setMeasuredDimension(paramInt2, paramInt1);
  }
  
  public void setAdapter(QVipMedalView.Adapter paramAdapter)
  {
    this.a = paramAdapter;
    removeAllViews();
    paramAdapter = this.a;
    if (paramAdapter != null)
    {
      int j = paramAdapter.a();
      int i = 0;
      while (i < j)
      {
        if (this.d.size() > i) {
          ((ImageView)this.d.get(i)).setImageDrawable(null);
        } else {
          this.d.add(new ImageView(getContext()));
        }
        a((ImageView)this.d.get(i), this.a.a(i), this.a.b(i), this.a.c(i), this.a.d(i));
        addView((View)this.d.get(i));
        i += 1;
      }
    }
    requestLayout();
  }
  
  public void setData(MedalList paramMedalList)
  {
    if (this.a == null) {
      this.a = new QVipMedalView.Adapter();
    }
    this.a.a(paramMedalList);
    setAdapter(this.a);
  }
  
  public void setItemMargin(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setItemWidth(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QVipMedalView
 * JD-Core Version:    0.7.0.1
 */