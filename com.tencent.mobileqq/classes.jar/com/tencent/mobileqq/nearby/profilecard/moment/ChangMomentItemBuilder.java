package com.tencent.mobileqq.nearby.profilecard.moment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ChangMomentFeedInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;

public class ChangMomentItemBuilder
  extends BaseMomentItemBuilder
{
  public ChangMomentItemBuilder(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public View a(ViewGroup paramViewGroup, BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    paramMomentViewHolder = (ChangMomentItemBuilder.ChangViewHolder)paramMomentViewHolder;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131627579, paramViewGroup, false);
    paramMomentViewHolder.t = ((TextView)paramViewGroup.findViewById(2131448801));
    paramMomentViewHolder.u = ((ImageView)paramViewGroup.findViewById(2131436334));
    paramMomentViewHolder.v = ((ImageView)paramViewGroup.findViewById(2131436497));
    paramMomentViewHolder.w = paramViewGroup.findViewById(2131432982);
    paramMomentViewHolder.x = paramViewGroup.findViewById(2131432983);
    return paramViewGroup;
  }
  
  public BaseMomentItemBuilder.MomentViewHolder a()
  {
    return new ChangMomentItemBuilder.ChangViewHolder(this);
  }
  
  public void f(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    paramMomentViewHolder = (ChangMomentItemBuilder.ChangViewHolder)paramMomentViewHolder;
    Object localObject1 = (ChangMomentFeedInfo)paramMomentViewHolder.a;
    if (((ChangMomentFeedInfo)localObject1).e > 1)
    {
      paramMomentViewHolder.w.setVisibility(0);
      paramMomentViewHolder.x.setVisibility(0);
    }
    else
    {
      paramMomentViewHolder.w.setVisibility(8);
      paramMomentViewHolder.x.setVisibility(8);
    }
    paramMomentViewHolder.t.setMovementMethod(LinkMovementMethod.getInstance());
    if (TextUtils.isEmpty(((ChangMomentFeedInfo)localObject1).s))
    {
      paramMomentViewHolder.t.setVisibility(8);
    }
    else
    {
      paramMomentViewHolder.t.setVisibility(0);
      paramMomentViewHolder.t.setText(((ChangMomentFeedInfo)localObject1).s);
    }
    int k = UIUtils.a(this.a, 200.0F);
    int i;
    if ((((ChangMomentFeedInfo)localObject1).b > 0) && (((ChangMomentFeedInfo)localObject1).c > 0)) {
      i = ((ChangMomentFeedInfo)localObject1).c * k / ((ChangMomentFeedInfo)localObject1).b;
    } else {
      i = k;
    }
    int m = k * 4;
    int j = i;
    if (i * 3 > m) {
      j = m / 3;
    }
    if (!TextUtils.equals((String)paramMomentViewHolder.u.getTag(2131446833), ((ChangMomentFeedInfo)localObject1).d))
    {
      paramMomentViewHolder.u.setTag(2131446833, ((ChangMomentFeedInfo)localObject1).d);
      Object localObject2 = (FrameLayout.LayoutParams)paramMomentViewHolder.u.getLayoutParams();
      if (localObject2 == null)
      {
        localObject2 = new FrameLayout.LayoutParams(k, j);
        paramMomentViewHolder.u.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      else if ((((FrameLayout.LayoutParams)localObject2).width != k) || (((FrameLayout.LayoutParams)localObject2).height != j))
      {
        ((FrameLayout.LayoutParams)localObject2).width = k;
        ((FrameLayout.LayoutParams)localObject2).height = j;
        paramMomentViewHolder.u.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      try
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.a.getResources().getDrawable(2130847114);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.a.getResources().getDrawable(2130847114);
        localObject1 = URLDrawable.getDrawable(((ChangMomentFeedInfo)localObject1).d, (URLDrawable.URLDrawableOptions)localObject2);
        ((URLDrawable)localObject1).setTag(URLDrawableDecodeHandler.b(k, j, DisplayUtil.a(this.a, 3.0F)));
        ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.e);
        paramMomentViewHolder.u.setImageDrawable((Drawable)localObject1);
        return;
      }
      catch (Exception localException)
      {
        paramMomentViewHolder.u.setImageDrawable(this.a.getResources().getDrawable(2130847114));
        if (QLog.isColorLevel()) {
          QLog.i("BaseMomentItemBuilder", 1, localException.toString());
        }
      }
    }
  }
  
  public int g(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return 3;
  }
  
  public String j(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return ((ChangMomentFeedInfo)((ChangMomentItemBuilder.ChangViewHolder)paramMomentViewHolder).a).a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.ChangMomentItemBuilder
 * JD-Core Version:    0.7.0.1
 */