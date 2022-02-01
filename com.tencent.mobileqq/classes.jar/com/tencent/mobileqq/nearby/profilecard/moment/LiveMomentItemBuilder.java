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
import com.tencent.mobileqq.nearby.report.IODReportTask;
import com.tencent.mobileqq.now.utils.UrlUtil;
import com.tencent.mobileqq.qroute.QRoute;
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
  private boolean i;
  
  public LiveMomentItemBuilder(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  private void a(LiveMomentFeedInfo paramLiveMomentFeedInfo)
  {
    if (this.i) {
      return;
    }
    String str = UrlUtil.a(paramLiveMomentFeedInfo.r, "roomid");
    paramLiveMomentFeedInfo = UrlUtil.a(paramLiveMomentFeedInfo.r, "anchor");
    ((IODReportTask)QRoute.api(IODReportTask.class)).setModule("personal_page").setAction("view").addKeyValue("res6", this.h).addKeyValue("roomid", str).addKeyValue("anchor", paramLiveMomentFeedInfo).addKeyValue("reporttime", System.currentTimeMillis()).setUin(this.c.getCurrentAccountUin()).report();
    this.i = true;
  }
  
  public View a(ViewGroup paramViewGroup, BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    paramMomentViewHolder = (LiveMomentItemBuilder.LiveViewHolder)paramMomentViewHolder;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131627575, paramViewGroup, false);
    paramMomentViewHolder.t = ((TextView)paramViewGroup.findViewById(2131448801));
    paramMomentViewHolder.u = ((ImageView)paramViewGroup.findViewById(2131436334));
    paramMomentViewHolder.v = ((ImageView)paramViewGroup.findViewById(2131437364));
    return paramViewGroup;
  }
  
  public LiveMomentItemBuilder.LiveViewHolder b()
  {
    return new LiveMomentItemBuilder.LiveViewHolder(this);
  }
  
  public void d(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    if (!NetworkUtil.isNetworkAvailable(this.a))
    {
      QQToast.makeText(this.a, 1, HardCodeUtil.a(2131904138), 0).show();
      return;
    }
    Object localObject = JumpParser.a(this.c, this.a, paramMomentViewHolder.a.r);
    if (localObject != null) {
      ((JumpAction)localObject).a();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleContentClick, liveUrl=");
      ((StringBuilder)localObject).append(paramMomentViewHolder.a.r);
      QLog.i("LiveMomentItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void f(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    Object localObject1 = (LiveMomentItemBuilder.LiveViewHolder)paramMomentViewHolder;
    paramMomentViewHolder = (LiveMomentFeedInfo)((LiveMomentItemBuilder.LiveViewHolder)localObject1).a;
    ((LiveMomentItemBuilder.LiveViewHolder)localObject1).t.setMovementMethod(LinkMovementMethod.getInstance());
    if (!TextUtils.isEmpty(paramMomentViewHolder.s))
    {
      ((LiveMomentItemBuilder.LiveViewHolder)localObject1).t.setVisibility(0);
      ((LiveMomentItemBuilder.LiveViewHolder)localObject1).t.setText(paramMomentViewHolder.s);
    }
    else
    {
      ((LiveMomentItemBuilder.LiveViewHolder)localObject1).t.setVisibility(8);
    }
    Object localObject3 = (String)((LiveMomentItemBuilder.LiveViewHolder)localObject1).u.getTag(2131446833);
    Object localObject2 = paramMomentViewHolder.a;
    if (!TextUtils.equals((CharSequence)localObject3, (CharSequence)localObject2)) {
      try
      {
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = this.a.getResources().getDrawable(2130847114);
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = this.a.getResources().getDrawable(2130847114);
        localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
        ((URLDrawable)localObject2).setTag(URLDrawableDecodeHandler.b(UIUtils.a(BaseApplicationImpl.getContext(), 180.0F), UIUtils.a(BaseApplicationImpl.getContext(), 180.0F), DisplayUtil.a(((LiveMomentItemBuilder.LiveViewHolder)localObject1).u.getContext(), 4.0F)));
        ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.d);
        ((LiveMomentItemBuilder.LiveViewHolder)localObject1).u.setImageDrawable((Drawable)localObject2);
        localObject2 = NearbyImgDownloader.convertURL("https://pub.idqqimg.com/pc/misc/files/20171219/4ed0e5a61d2f4024ac6886ee826ac51c.gif");
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
        localObject2 = URLDrawable.getDrawable((URL)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
        ((LiveMomentItemBuilder.LiveViewHolder)localObject1).v.setImageDrawable((Drawable)localObject2);
      }
      catch (Exception localException)
      {
        ((LiveMomentItemBuilder.LiveViewHolder)localObject1).u.setImageDrawable(this.a.getResources().getDrawable(2130847114));
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("convertURL, e=");
          ((StringBuilder)localObject1).append(localException.toString());
          QLog.i("LiveMomentItemBuilder", 2, ((StringBuilder)localObject1).toString(), localException);
        }
      }
    }
    a(paramMomentViewHolder);
  }
  
  public int g(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return 4;
  }
  
  public boolean i(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.LiveMomentItemBuilder
 * JD-Core Version:    0.7.0.1
 */