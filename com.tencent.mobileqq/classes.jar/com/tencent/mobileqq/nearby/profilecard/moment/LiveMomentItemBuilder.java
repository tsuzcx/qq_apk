package com.tencent.mobileqq.nearby.profilecard.moment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.moment.data.LiveMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.nearby.report.ODReportTask;
import com.tencent.mobileqq.now.utils.UrlUtil;
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
  private boolean b;
  
  public LiveMomentItemBuilder(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  private void a(LiveMomentFeedInfo paramLiveMomentFeedInfo)
  {
    if (this.b) {
      return;
    }
    String str = UrlUtil.a(paramLiveMomentFeedInfo.m, "roomid");
    paramLiveMomentFeedInfo = UrlUtil.a(paramLiveMomentFeedInfo.m, "anchor");
    new ODReportTask().b("personal_page").c("view").a("res6", this.jdField_a_of_type_Int).a("roomid", str).a("anchor", paramLiveMomentFeedInfo).a("reporttime", System.currentTimeMillis()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).a();
    this.b = true;
  }
  
  public int a(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return 4;
  }
  
  public View a(ViewGroup paramViewGroup, BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    paramMomentViewHolder = (LiveMomentItemBuilder.LiveViewHolder)paramMomentViewHolder;
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561382, paramViewGroup, false);
    paramMomentViewHolder.g = ((TextView)paramViewGroup.findViewById(2131380639));
    paramMomentViewHolder.e = ((ImageView)paramViewGroup.findViewById(2131369628));
    paramMomentViewHolder.f = ((ImageView)paramViewGroup.findViewById(2131370533));
    return paramViewGroup;
  }
  
  public LiveMomentItemBuilder.LiveViewHolder a()
  {
    return new LiveMomentItemBuilder.LiveViewHolder(this);
  }
  
  public boolean a(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return false;
  }
  
  public void d(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, HardCodeUtil.a(2131706228), 0).a();
    }
    do
    {
      return;
      JumpAction localJumpAction = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMomentViewHolder.a.m);
      if (localJumpAction != null) {
        localJumpAction.a();
      }
    } while (!QLog.isColorLevel());
    QLog.i("LiveMomentItemBuilder", 2, "handleContentClick, liveUrl=" + paramMomentViewHolder.a.m);
  }
  
  public void f(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    paramMomentViewHolder = (LiveMomentItemBuilder.LiveViewHolder)paramMomentViewHolder;
    LiveMomentFeedInfo localLiveMomentFeedInfo = (LiveMomentFeedInfo)paramMomentViewHolder.a;
    paramMomentViewHolder.g.setMovementMethod(LinkMovementMethod.getInstance());
    if (!TextUtils.isEmpty(localLiveMomentFeedInfo.n))
    {
      paramMomentViewHolder.g.setVisibility(0);
      paramMomentViewHolder.g.setText(localLiveMomentFeedInfo.n);
    }
    for (;;)
    {
      Object localObject2 = (String)paramMomentViewHolder.e.getTag(2131378926);
      Object localObject1 = localLiveMomentFeedInfo.a;
      if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1)) {}
      try
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845777);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845777);
        localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        ((URLDrawable)localObject1).setTag(URLDrawableDecodeHandler.b(UIUtils.a(BaseApplicationImpl.getContext(), 180.0F), UIUtils.a(BaseApplicationImpl.getContext(), 180.0F), DisplayUtil.a(paramMomentViewHolder.e.getContext(), 4.0F)));
        ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.c);
        paramMomentViewHolder.e.setImageDrawable((Drawable)localObject1);
        localObject1 = NearbyImgDownloader.convertURL("https://pub.idqqimg.com/pc/misc/files/20171219/4ed0e5a61d2f4024ac6886ee826ac51c.gif");
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        paramMomentViewHolder.f.setImageDrawable((Drawable)localObject1);
        a(localLiveMomentFeedInfo);
        return;
        paramMomentViewHolder.g.setVisibility(8);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramMomentViewHolder.e.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845777));
          if (QLog.isColorLevel()) {
            QLog.i("LiveMomentItemBuilder", 2, "convertURL, e=" + localException.toString(), localException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.LiveMomentItemBuilder
 * JD-Core Version:    0.7.0.1
 */