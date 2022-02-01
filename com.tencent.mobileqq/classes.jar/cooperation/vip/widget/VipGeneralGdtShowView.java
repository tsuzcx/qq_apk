package cooperation.vip.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi;
import com.tencent.mobileqq.vas.adv.qzone.data.VasAdMetaReportParam.Builder;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;

public class VipGeneralGdtShowView
{
  VipGeneralGdtShowView.VipGeneralGdtClickListner a;
  View.OnClickListener b = new VipGeneralGdtShowView.1(this);
  private Context c;
  private int d = -1;
  private ImageView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private View i;
  private RelativeLayout j;
  private Handler k;
  private AlumBasicData l;
  private GdtAppReceiver m;
  private TextView n;
  private TextView o;
  private ImageView p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  
  public VipGeneralGdtShowView(Context paramContext, int paramInt1, int paramInt2, int paramInt3, GdtAppReceiver paramGdtAppReceiver)
  {
    this.c = paramContext;
    this.d = paramInt1;
    this.r = paramInt2;
    this.i = LayoutInflater.from(paramContext).inflate(paramInt1, null);
    this.k = new Handler(Looper.getMainLooper());
    if (paramGdtAppReceiver == null)
    {
      this.m = new GdtAppReceiver();
      this.m.register(this.c);
    }
    else
    {
      this.m = paramGdtAppReceiver;
    }
    this.s = paramInt3;
  }
  
  private void a(AlumBasicData paramAlumBasicData)
  {
    URLDrawable localURLDrawable = URLDrawable.getDrawable(paramAlumBasicData.advimageUrl, null);
    if (localURLDrawable != null)
    {
      this.t = paramAlumBasicData.imageWith;
      this.u = paramAlumBasicData.imageHeight;
      int i2 = this.c.getResources().getDisplayMetrics().widthPixels - ViewUtils.dpToPx(56.0F);
      int i1 = this.t;
      if (i1 != 0)
      {
        int i3 = this.u;
        if (i3 != 0)
        {
          double d1 = i3;
          double d2 = i1;
          Double.isNaN(d2);
          Double.isNaN(d1);
          d1 /= d2 * 1.0D;
          d2 = i2;
          Double.isNaN(d2);
          i1 = (int)(d1 * d2);
          break label125;
        }
      }
      i1 = 0;
      label125:
      if (i1 != 0)
      {
        Object localObject = this.e.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = i1;
        this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" @getGdtInfo height  =");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append("contrlwith =");
        ((StringBuilder)localObject).append(i2);
        ((StringBuilder)localObject).append("imagewith =");
        ((StringBuilder)localObject).append(this.t);
        ((StringBuilder)localObject).append("imageheight =");
        ((StringBuilder)localObject).append(this.u);
        QZLog.i("VipGeneralGdtShowView", ((StringBuilder)localObject).toString());
      }
      this.e.setImageDrawable(localURLDrawable);
      if (paramAlumBasicData.hasExposed == 0)
      {
        paramAlumBasicData.hasExposed = 1;
        a(paramAlumBasicData.qqbexposureInfor);
        a(1, paramAlumBasicData.recCookie, 0);
      }
    }
  }
  
  private void b(AlumBasicData paramAlumBasicData)
  {
    Drawable localDrawable = this.f.getResources().getDrawable(2130841060);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mUseMemoryCache = false;
    paramAlumBasicData = URLDrawable.getDrawable(paramAlumBasicData.advLogoUrl, localURLDrawableOptions);
    if ((this.r == 3) && (!SimpleUIUtil.e()))
    {
      paramAlumBasicData.setTag(URLDrawableDecodeHandler.a(ViewUtils.dip2px(40.0F), ViewUtils.dip2px(40.0F)));
      paramAlumBasicData.setDecodeHandler(URLDrawableDecodeHandler.o);
    }
    else
    {
      paramAlumBasicData.setTag(URLDrawableDecodeHandler.b(ViewUtils.dip2px(40.0F), ViewUtils.dip2px(40.0F), ViewUtils.dip2px(3.5F)));
      paramAlumBasicData.setDecodeHandler(URLDrawableDecodeHandler.j);
    }
    if (paramAlumBasicData != null) {
      this.p.setImageDrawable(paramAlumBasicData);
    }
  }
  
  public View a()
  {
    return this.i;
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      long l1 = 0L;
      if ((localObject instanceof QQAppInterface)) {
        l1 = ((QQAppInterface)localObject).getLongAccountUin();
      }
      localObject = new VasAdMetaReportParam.Builder();
      ((VasAdMetaReportParam.Builder)localObject).setAdvPos(Integer.valueOf(this.r));
      ((VasAdMetaReportParam.Builder)localObject).setUin(Long.valueOf(l1));
      ((VasAdMetaReportParam.Builder)localObject).setActionType(Integer.valueOf(paramInt1));
      ((VasAdMetaReportParam.Builder)localObject).setRecommendCookie(paramString);
      ((VasAdMetaReportParam.Builder)localObject).setFeedIndex(Integer.valueOf(paramInt2));
      ((VasAdMetaReportParam.Builder)localObject).setActionType(Integer.valueOf(1));
      ((IVasQZoneApi)QRoute.api(IVasQZoneApi.class)).reportAdvAsync(((VasAdMetaReportParam.Builder)localObject).build());
      return;
    }
    QZLog.i("VipGeneralGdtShowView", " @getGdtInfo sendBusinessReport");
  }
  
  public void a(View paramView, VipGeneralGdtShowView.VipGeneralGdtClickListner paramVipGeneralGdtClickListner)
  {
    if (paramView == null) {
      return;
    }
    this.a = paramVipGeneralGdtClickListner;
    QZLog.i("VipGeneralGdtShowView", " @getGdtInfo initAdvView");
    this.j = ((RelativeLayout)paramView.findViewById(2131434150));
    this.e = ((ImageView)paramView.findViewById(2131434159));
    this.h = ((TextView)paramView.findViewById(2131434160));
    this.f = ((TextView)paramView.findViewById(2131434162));
    this.g = ((TextView)paramView.findViewById(2131434158));
    this.n = ((TextView)paramView.findViewById(2131434163));
    this.o = ((TextView)paramView.findViewById(2131434164));
    this.p = ((ImageView)paramView.findViewById(2131434161));
    this.j.setOnClickListener(this.b);
    this.h.setOnClickListener(this.b);
  }
  
  public void a(AlumBasicData paramAlumBasicData, int paramInt)
  {
    try
    {
      this.l = paramAlumBasicData;
      this.q = (paramInt + 1);
      if ((paramAlumBasicData != null) && (!TextUtils.isEmpty(paramAlumBasicData.advimageUrl)) && (this.j != null) && (this.e != null) && (this.h != null) && (this.f != null) && (this.g != null))
      {
        b(paramAlumBasicData);
        a(paramAlumBasicData);
        this.n.setText(paramAlumBasicData.leftBottomText);
        this.o.setText(paramAlumBasicData.rightBottomButton);
        this.f.setText(paramAlumBasicData.advTextTitle);
        this.g.setText(paramAlumBasicData.advTextText);
        this.j.setVisibility(0);
        if (QZLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setDataChanged titile =");
          localStringBuilder.append(paramAlumBasicData.advTextTitle);
          localStringBuilder.append(" desc =");
          localStringBuilder.append(paramAlumBasicData.advTextText);
          localStringBuilder.append(" url =");
          localStringBuilder.append(paramAlumBasicData.advimageUrl);
          QZLog.i("VipGeneralGdtShowView", localStringBuilder.toString());
        }
      }
      else
      {
        if (this.j != null) {
          this.j.setVisibility(8);
        }
        QZLog.i("VipGeneralGdtShowView", " @getGdtInfo setDataChanged is null");
        return;
      }
    }
    catch (Exception paramAlumBasicData)
    {
      QZLog.e("VipGeneralGdtShowView", paramAlumBasicData.toString());
    }
  }
  
  public void a(String paramString)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").postDelayed(new VipGeneralGdtShowView.2(this, paramString), 0L);
  }
  
  public void a(WeakReference<Activity> paramWeakReference, int paramInt)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.q = paramInt;
    if (paramWeakReference != null)
    {
      localParams.r = paramWeakReference;
      localParams.a = new GdtAd(this.l.adInfo);
      localParams.s = new WeakReference(this.m);
      localParams.b = true;
      localParams.e = true;
      localParams.p = new Bundle();
      if (this.r == 3) {
        localParams.p.putString("big_brother_ref_source_key", "biz_src_jc_kuolie");
      }
      GdtHandler.a(localParams);
      QZLog.i("VipGeneralGdtShowView", " @getGdtInfo clickAdvInfoToQiQiaoBan");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.widget.VipGeneralGdtShowView
 * JD-Core Version:    0.7.0.1
 */