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
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ShortVideoMomentFeedInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.TopicHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ShortVideoMomentItemBuilder
  extends PublishableMomentItemBuilder
{
  public ShortVideoMomentItemBuilder(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public View a(ViewGroup paramViewGroup, BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    paramMomentViewHolder = (ShortVideoMomentItemBuilder.ShortVideoViewHolder)paramMomentViewHolder;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131627579, paramViewGroup, false);
    paramMomentViewHolder.t = ((TextView)paramViewGroup.findViewById(2131448801));
    paramMomentViewHolder.u = ((ImageView)paramViewGroup.findViewById(2131436334));
    paramMomentViewHolder.v = ((ImageView)paramViewGroup.findViewById(2131436497));
    return paramViewGroup;
  }
  
  public BaseMomentItemBuilder.MomentViewHolder a()
  {
    return new ShortVideoMomentItemBuilder.ShortVideoViewHolder(this);
  }
  
  public void d(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    ShortVideoMomentFeedInfo localShortVideoMomentFeedInfo = (ShortVideoMomentFeedInfo)paramMomentViewHolder.a;
    if ((localShortVideoMomentFeedInfo.d != null) && (localShortVideoMomentFeedInfo.d.publishState != 0))
    {
      NearbyMomentUtils.a(this.a, localShortVideoMomentFeedInfo.d, 2);
      return;
    }
    super.d(paramMomentViewHolder);
  }
  
  public void f(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    ShortVideoMomentItemBuilder.ShortVideoViewHolder localShortVideoViewHolder = (ShortVideoMomentItemBuilder.ShortVideoViewHolder)paramMomentViewHolder;
    ShortVideoMomentFeedInfo localShortVideoMomentFeedInfo = (ShortVideoMomentFeedInfo)localShortVideoViewHolder.a;
    paramMomentViewHolder = TopicHelper.a(this.a, localShortVideoViewHolder.a.y, localShortVideoMomentFeedInfo.s);
    boolean bool2 = TextUtils.isEmpty(paramMomentViewHolder);
    boolean bool1 = false;
    if (bool2)
    {
      localShortVideoViewHolder.t.setVisibility(8);
    }
    else
    {
      localShortVideoViewHolder.t.setVisibility(0);
      if ((paramMomentViewHolder instanceof SpannableString)) {
        localShortVideoViewHolder.t.setMovementMethod(LinkMovementMethod.getInstance());
      }
      localShortVideoViewHolder.t.setText(paramMomentViewHolder);
    }
    int k = UIUtils.a(this.a, 180.0F);
    String str = (String)localShortVideoViewHolder.u.getTag(2131446833);
    File localFile = null;
    if (localShortVideoMomentFeedInfo.d != null)
    {
      paramMomentViewHolder = new StringBuilder();
      paramMomentViewHolder.append(localShortVideoMomentFeedInfo.d.thumbPath);
      paramMomentViewHolder.append("");
      localFile = new File(paramMomentViewHolder.toString());
      bool1 = localFile.exists();
    }
    Object localObject;
    if (bool1)
    {
      localObject = localShortVideoMomentFeedInfo.d.thumbPath;
      paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
      if (localShortVideoMomentFeedInfo.d.videoWidth > 0)
      {
        paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
        if (localShortVideoMomentFeedInfo.d.videoHeight > 0)
        {
          i = localShortVideoMomentFeedInfo.d.videoHeight * k / localShortVideoMomentFeedInfo.d.videoWidth;
          paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
          break label308;
        }
      }
    }
    else
    {
      localObject = localShortVideoMomentFeedInfo.c;
      paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
      if (localShortVideoMomentFeedInfo.a > 0)
      {
        paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
        if (localShortVideoMomentFeedInfo.b > 0)
        {
          i = localShortVideoMomentFeedInfo.b * k / localShortVideoMomentFeedInfo.a;
          paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
          break label308;
        }
      }
    }
    int i = k;
    label308:
    int m = k * 4;
    int j = i;
    if (i * 3 > m) {
      j = m / 3;
    }
    if (!TextUtils.equals(str, paramMomentViewHolder))
    {
      localShortVideoViewHolder.u.setTag(2131446833, paramMomentViewHolder);
      localObject = (FrameLayout.LayoutParams)localShortVideoViewHolder.u.getLayoutParams();
      if (localObject == null)
      {
        localObject = new FrameLayout.LayoutParams(k, j);
        localShortVideoViewHolder.u.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      else if ((((FrameLayout.LayoutParams)localObject).width != k) || (((FrameLayout.LayoutParams)localObject).height != j))
      {
        ((FrameLayout.LayoutParams)localObject).width = k;
        ((FrameLayout.LayoutParams)localObject).height = j;
        localShortVideoViewHolder.u.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      try
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.a.getResources().getDrawable(2130847114);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.a.getResources().getDrawable(2130847114);
        if (bool1) {
          paramMomentViewHolder = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject);
        } else {
          paramMomentViewHolder = URLDrawable.getDrawable(paramMomentViewHolder, (URLDrawable.URLDrawableOptions)localObject);
        }
        paramMomentViewHolder.setTag(URLDrawableDecodeHandler.b(k, j, DisplayUtil.a(this.a, 3.0F)));
        paramMomentViewHolder.setDecodeHandler(URLDrawableDecodeHandler.e);
        localShortVideoViewHolder.u.setImageDrawable(paramMomentViewHolder);
        return;
      }
      catch (Exception paramMomentViewHolder)
      {
        localShortVideoViewHolder.u.setImageDrawable(this.a.getResources().getDrawable(2130847114));
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoMomentItemBuilder", 1, paramMomentViewHolder.toString());
        }
      }
    }
  }
  
  public int g(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return 1;
  }
  
  public String h(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    long l = ((ShortVideoMomentFeedInfo)((ShortVideoMomentItemBuilder.ShortVideoViewHolder)paramMomentViewHolder).a).e;
    int i;
    if (l % 1000L > 500L) {
      i = (int)l / 1000 + 1;
    } else {
      i = (int)l / 1000;
    }
    return String.valueOf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.ShortVideoMomentItemBuilder
 * JD-Core Version:    0.7.0.1
 */