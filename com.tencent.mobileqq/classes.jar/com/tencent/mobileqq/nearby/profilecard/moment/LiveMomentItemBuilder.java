package com.tencent.mobileqq.nearby.profilecard.moment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.moment.data.LiveMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class LiveMomentItemBuilder
  extends BaseMomentItemBuilder
{
  public LiveMomentItemBuilder(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return 4;
  }
  
  public View a(ViewGroup paramViewGroup, BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    paramMomentViewHolder = (LiveMomentItemBuilder.LiveViewHolder)paramMomentViewHolder;
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970474, paramViewGroup, false);
    paramMomentViewHolder.j = ((TextView)paramViewGroup.findViewById(2131367129));
    paramMomentViewHolder.f = ((ImageView)paramViewGroup.findViewById(2131366378));
    paramMomentViewHolder.g = ((ImageView)paramViewGroup.findViewById(2131370666));
    return paramViewGroup;
  }
  
  public LiveMomentItemBuilder.LiveViewHolder a()
  {
    return new LiveMomentItemBuilder.LiveViewHolder(this);
  }
  
  public boolean c(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return false;
  }
  
  public void d(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, "网络异常，无法观看", 0).a();
    }
    do
    {
      return;
      JumpAction localJumpAction = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMomentViewHolder.a.h);
      if (localJumpAction != null) {
        localJumpAction.b();
      }
    } while (!QLog.isColorLevel());
    QLog.i("LiveMomentItemBuilder", 2, "handleContentClick, liveUrl=" + paramMomentViewHolder.a.h);
  }
  
  public boolean d(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return false;
  }
  
  public void f(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    paramMomentViewHolder = (LiveMomentItemBuilder.LiveViewHolder)paramMomentViewHolder;
    Object localObject2 = (LiveMomentFeedInfo)paramMomentViewHolder.a;
    if (!TextUtils.isEmpty(((LiveMomentFeedInfo)localObject2).i))
    {
      paramMomentViewHolder.j.setVisibility(0);
      paramMomentViewHolder.j.setText(((LiveMomentFeedInfo)localObject2).i);
    }
    for (;;)
    {
      Object localObject1 = (String)paramMomentViewHolder.f.getTag(2131362360);
      localObject2 = ((LiveMomentFeedInfo)localObject2).a;
      if (!TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject2)) {}
      try
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842814);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842814);
        localObject1 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setTag(URLDrawableDecodeHandler.a(UIUtils.a(BaseApplicationImpl.getContext(), 200.0F), UIUtils.a(BaseApplicationImpl.getContext(), 200.0F), DisplayUtil.a(paramMomentViewHolder.f.getContext(), 4.0F)));
        ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.b);
        paramMomentViewHolder.f.setImageDrawable((Drawable)localObject1);
        localObject1 = NearbyImgDownloader.a("http://pub.idqqimg.com/pc/misc/files/20171219/4ed0e5a61d2f4024ac6886ee826ac51c.gif");
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        paramMomentViewHolder.g.setImageDrawable((Drawable)localObject1);
        return;
        paramMomentViewHolder.j.setVisibility(8);
      }
      catch (Exception localException)
      {
        do
        {
          paramMomentViewHolder.f.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842814));
        } while (!QLog.isColorLevel());
        QLog.i("LiveMomentItemBuilder", 2, "convertURL, e=" + localException.toString(), localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.LiveMomentItemBuilder
 * JD-Core Version:    0.7.0.1
 */