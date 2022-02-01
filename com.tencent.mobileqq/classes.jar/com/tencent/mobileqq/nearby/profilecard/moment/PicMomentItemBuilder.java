package com.tencent.mobileqq.nearby.profilecard.moment;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.PicMomentFeedInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.TopicHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class PicMomentItemBuilder
  extends PublishableMomentItemBuilder
{
  public PicMomentItemBuilder(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public View a(ViewGroup paramViewGroup, BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    paramMomentViewHolder = (PicMomentItemBuilder.PicViewHolder)paramMomentViewHolder;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131627578, paramViewGroup, false);
    paramMomentViewHolder.t = ((TextView)paramViewGroup.findViewById(2131448801));
    paramMomentViewHolder.u = ((ImageView)paramViewGroup.findViewById(2131436489));
    return paramViewGroup;
  }
  
  public BaseMomentItemBuilder.MomentViewHolder a()
  {
    return new PicMomentItemBuilder.PicViewHolder(this);
  }
  
  public void d(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    PicMomentFeedInfo localPicMomentFeedInfo = (PicMomentFeedInfo)paramMomentViewHolder.a;
    if ((localPicMomentFeedInfo.d != null) && (localPicMomentFeedInfo.d.publishState != 0))
    {
      NearbyMomentUtils.a(this.a, localPicMomentFeedInfo.d, 4);
      return;
    }
    super.d(paramMomentViewHolder);
  }
  
  public void f(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    PicMomentItemBuilder.PicViewHolder localPicViewHolder = (PicMomentItemBuilder.PicViewHolder)paramMomentViewHolder;
    Object localObject1 = (PicMomentFeedInfo)localPicViewHolder.a;
    paramMomentViewHolder = ((PicMomentFeedInfo)localObject1).s;
    paramMomentViewHolder = TopicHelper.a(this.a, localPicViewHolder.a.y, paramMomentViewHolder);
    if (TextUtils.isEmpty(paramMomentViewHolder))
    {
      localPicViewHolder.t.setVisibility(8);
    }
    else
    {
      localPicViewHolder.t.setVisibility(0);
      if ((paramMomentViewHolder instanceof SpannableString)) {
        localPicViewHolder.t.setMovementMethod(LinkMovementMethod.getInstance());
      }
      localPicViewHolder.t.setText(paramMomentViewHolder);
    }
    Object localObject2 = (String)localPicViewHolder.u.getTag(2131446833);
    paramMomentViewHolder = null;
    boolean bool;
    if (((PicMomentFeedInfo)localObject1).d != null)
    {
      paramMomentViewHolder = new StringBuilder();
      paramMomentViewHolder.append(((PicMomentFeedInfo)localObject1).d.thumbPath);
      paramMomentViewHolder.append("");
      paramMomentViewHolder = new File(paramMomentViewHolder.toString());
      bool = paramMomentViewHolder.exists();
    }
    else
    {
      bool = false;
    }
    if (bool) {
      localObject1 = ((PicMomentFeedInfo)localObject1).d.thumbPath;
    } else {
      localObject1 = ((PicMomentFeedInfo)localObject1).c;
    }
    if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
    {
      localPicViewHolder.u.setTag(2131446833, localObject1);
      localObject2 = (LinearLayout.LayoutParams)localPicViewHolder.u.getLayoutParams();
      int i = UIUtils.a(BaseApplicationImpl.getContext(), 180.0F);
      if (localObject2 == null)
      {
        localObject2 = new LinearLayout.LayoutParams(-2, -2);
        localPicViewHolder.u.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      else if ((((LinearLayout.LayoutParams)localObject2).width <= i) && (((LinearLayout.LayoutParams)localObject2).height <= i))
      {
        if (((LinearLayout.LayoutParams)localObject2).weight < ((LinearLayout.LayoutParams)localObject2).height) {
          ((LinearLayout.LayoutParams)localObject2).height = i;
        } else {
          ((LinearLayout.LayoutParams)localObject2).width = i;
        }
        localPicViewHolder.u.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      try
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.a.getResources().getDrawable(2130847114);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.a.getResources().getDrawable(2130847114);
        ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "profileCard";
        if (bool) {
          paramMomentViewHolder = URLDrawable.getDrawable(paramMomentViewHolder, (URLDrawable.URLDrawableOptions)localObject2);
        } else {
          paramMomentViewHolder = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        }
        paramMomentViewHolder.setTag(URLDrawableDecodeHandler.a(DisplayUtil.a(localPicViewHolder.u.getContext(), 3.0F), 0, 0));
        paramMomentViewHolder.setDecodeHandler(URLDrawableDecodeHandler.f);
        localPicViewHolder.u.setImageDrawable(paramMomentViewHolder);
      }
      catch (Exception paramMomentViewHolder)
      {
        localPicViewHolder.u.setImageDrawable(this.a.getResources().getDrawable(2130847114));
        QLog.i("PicMomentItemBuilder", 1, paramMomentViewHolder.toString());
      }
    }
    localPicViewHolder.u.setTag(localPicViewHolder);
    localPicViewHolder.u.setOnClickListener(this);
  }
  
  public int g(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.PicMomentItemBuilder
 * JD-Core Version:    0.7.0.1
 */