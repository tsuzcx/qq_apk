package com.tencent.mobileqq.qqexpand.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqexpand.utils.IColdPalaceUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.List;

public class ExtendFriendBottomBarView
  extends FrameLayout
{
  boolean a;
  boolean b;
  boolean c;
  private BaseQQAppInterface d;
  private RelativeLayout e;
  private RelativeLayout f;
  private ArrayList<ImageView> g;
  private QQBlurView h;
  private int i;
  
  public ExtendFriendBottomBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExtendFriendBottomBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExtendFriendBottomBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflate(paramContext, 2131627409, this);
    a();
  }
  
  private void a()
  {
    this.i = DisplayUtil.a(getContext(), 66.0F);
    this.e = ((RelativeLayout)findViewById(2131429641));
    this.e.setOnTouchListener(UITools.a);
    this.e.setTranslationY(this.i);
    this.h = ((QQBlurView)findViewById(2131429645));
    this.h.setTranslationY(this.i);
    this.g = new ArrayList();
    this.f = ((RelativeLayout)findViewById(2131434924));
    int j = 0;
    while (j < this.f.getChildCount())
    {
      localObject = (ImageView)this.f.getChildAt(j);
      ((ImageView)localObject).setVisibility(8);
      this.g.add(localObject);
      j += 1;
    }
    ImageView localImageView = (ImageView)findViewById(2131428779);
    Object localObject = localImageView.getDrawable();
    if ((localObject instanceof SkinnableBitmapDrawable)) {
      localObject = ((SkinnableBitmapDrawable)localObject).mutate2();
    } else {
      localObject = ((Drawable)localObject).mutate();
    }
    ((Drawable)localObject).setColorFilter(-16578534, PorterDuff.Mode.SRC_ATOP);
    localImageView.setImageDrawable((Drawable)localObject);
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBottomBarView", 2, "showBottomBar ");
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.e, "translationY", new float[] { this.i, 0.0F });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.start();
    if (this.c)
    {
      localObjectAnimator = ObjectAnimator.ofFloat(this.h, "translationY", new float[] { this.i, 0.0F });
      localObjectAnimator.setDuration(500L);
      localObjectAnimator.start();
    }
    ReportController.b(this.d, "dc00898", "", "", "0X8009E2E", "0X8009E2E", 0, 0, "", "", "", "");
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBottomBarView", 2, "hideBottomBar ");
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.e, "translationY", new float[] { 0.0F, this.i });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.start();
    if (this.c)
    {
      localObjectAnimator = ObjectAnimator.ofFloat(this.h, "translationY", new float[] { 0.0F, this.i });
      localObjectAnimator.setDuration(500L);
      localObjectAnimator.start();
    }
  }
  
  void a(View paramView)
  {
    if (!this.c)
    {
      boolean bool;
      if (Build.VERSION.SDK_INT >= 24) {
        bool = true;
      } else {
        bool = false;
      }
      this.h.setVisibility(0);
      this.h.a(paramView);
      paramView = this.h;
      paramView.b(paramView);
      this.h.c(-1);
      this.h.setEnableBlur(bool);
      this.h.b(0);
      this.h.a(8.0F);
      this.h.a(8);
      this.h.setDisableBlurDrawableRes(2130853592);
      this.h.d();
      this.h.a();
      this.c = true;
    }
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, View paramView)
  {
    this.d = paramBaseQQAppInterface;
    if (paramView != null) {
      a(paramView);
    }
  }
  
  public void a(List<String> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBottomBarView", 2, String.format("updateUinList uinList=%s", new Object[] { paramList }));
    }
    if (paramList != null)
    {
      int k = paramList.size();
      if (k > 0)
      {
        int m = this.g.size();
        int j = 0;
        while (j < m)
        {
          ImageView localImageView = (ImageView)this.g.get(j);
          String str;
          if (j < k) {
            str = (String)paramList.get(j);
          } else {
            str = null;
          }
          if (!TextUtils.isEmpty(str))
          {
            localImageView.setImageDrawable(((IColdPalaceUtils)QRoute.api(IColdPalaceUtils.class)).getFaceHeadDrawable(this.d, str));
            localImageView.setVisibility(0);
          }
          else
          {
            localImageView.setVisibility(8);
          }
          j += 1;
        }
        this.f.setVisibility(0);
        return;
      }
      this.f.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.b)
    {
      this.b = true;
      this.a = paramBoolean;
      if (!this.a) {
        b();
      }
    }
    else
    {
      if ((!this.a) && (paramBoolean)) {
        c();
      }
      if ((this.a) && (!paramBoolean)) {
        b();
      }
      if (this.a != paramBoolean) {
        this.a = paramBoolean;
      }
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    RelativeLayout localRelativeLayout = this.e;
    if (localRelativeLayout != null) {
      localRelativeLayout.setOnClickListener(paramOnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.ExtendFriendBottomBarView
 * JD-Core Version:    0.7.0.1
 */