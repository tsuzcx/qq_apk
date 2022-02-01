package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qqgamepub.data.GamePubAccountConstant;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.view.IHeaderView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qphone.base.util.QLog;

public class TextHeaderView
  extends RelativeLayout
  implements IHeaderView, HippyViewBase
{
  private RelativeLayout a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private ImageView f;
  private Button g;
  private ImageView h;
  private String i;
  private HippyMap j;
  
  public TextHeaderView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a() {}
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, Context paramContext, int paramInt, String paramString)
  {
    try
    {
      this.i = paramQQGameMsgInfo.url;
      this.a = new RelativeLayout(getContext());
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(AIOUtils.b(355.0F, getResources()), -1);
      localLayoutParams1.addRule(14);
      this.h = new ImageView(getContext());
      Object localObject = new RelativeLayout.LayoutParams(-1, AIOUtils.b(293.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.b(46.0F, getResources());
      this.h.setScaleType(ImageView.ScaleType.FIT_XY);
      this.a.addView(this.h, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout(getContext());
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, AIOUtils.b(283.0F, getResources()));
      localLayoutParams2.topMargin = AIOUtils.b(46.0F, getResources());
      ((RelativeLayout)localObject).setPadding(AIOUtils.b(20.0F, getResources()), 0, AIOUtils.b(20.0F, getResources()), 0);
      this.a.addView((View)localObject, localLayoutParams2);
      this.b = new TextView(getContext());
      localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.topMargin = AIOUtils.b(60.0F, getResources());
      localLayoutParams2.addRule(10);
      localLayoutParams2.addRule(14);
      this.b.setTextColor(-16777216);
      this.b.setTextSize(18.0F);
      this.b.setId(2131433973);
      ((RelativeLayout)localObject).addView(this.b, localLayoutParams2);
      this.c = new TextView(getContext());
      localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.topMargin = AIOUtils.b(6.0F, getResources());
      localLayoutParams2.addRule(14);
      localLayoutParams2.addRule(3, 2131433973);
      this.c.setTextSize(14.0F);
      this.c.setTextColor(-7829368);
      ((RelativeLayout)localObject).addView(this.c, localLayoutParams2);
      this.d = new TextView(getContext());
      localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.addRule(3, 2131433973);
      localLayoutParams2.topMargin = AIOUtils.b(56.0F, getResources());
      this.d.setTextColor(-16777216);
      this.d.setTextSize(14.0F);
      ((RelativeLayout)localObject).addView(this.d, localLayoutParams2);
      this.e = new TextView(getContext());
      localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.topMargin = AIOUtils.b(106.0F, getResources());
      localLayoutParams2.addRule(3, 2131433973);
      this.e.setTextSize(14.0F);
      this.e.setTextColor(-7829368);
      ((RelativeLayout)localObject).addView(this.e, localLayoutParams2);
      this.g = new Button(getContext());
      localObject = new RelativeLayout.LayoutParams(AIOUtils.b(188.0F, getResources()), AIOUtils.b(51.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.b(296.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.g.setText(HardCodeUtil.a(2131912171));
      this.g.setTextColor(-1);
      this.g.setBackgroundResource(2130839460);
      this.a.addView(this.g, (ViewGroup.LayoutParams)localObject);
      this.f = new ImageView(getContext());
      localObject = new RelativeLayout.LayoutParams(AIOUtils.b(92.0F, getResources()), AIOUtils.b(92.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.f.setBackgroundColor(0);
      this.a.addView(this.f, (ViewGroup.LayoutParams)localObject);
      localObject = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20190412143112_EarvNaW2y5.png");
      this.h.setBackgroundDrawable((Drawable)localObject);
      this.b.setText(paramQQGameMsgInfo.title);
      this.c.setText(paramQQGameMsgInfo.dateTitle);
      this.d.setText(paramQQGameMsgInfo.contentText);
      this.e.setText(paramQQGameMsgInfo.limitText);
      localObject = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20190408192858_cRS59qwdjG.png");
      this.f.setImageDrawable((Drawable)localObject);
      this.g.setBackgroundDrawable(GamePubAccountConstant.a("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big_click@2x.png", "https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big@2x.png", getContext()));
      this.g.setOnClickListener(new TextHeaderView.3(this, paramContext, paramQQGameMsgInfo, paramInt, paramString));
      this.a.setOnClickListener(new TextHeaderView.4(this, paramContext, paramQQGameMsgInfo, paramInt, paramString));
      addView(this.a, localLayoutParams1);
      return;
    }
    catch (Throwable paramQQGameMsgInfo)
    {
      paramContext = new StringBuilder();
      paramContext.append("textHeader parse error ");
      paramContext.append(paramQQGameMsgInfo.toString());
      QLog.e("TextHeaderView", 2, paramContext.toString());
    }
  }
  
  public void a(HippyArray paramHippyArray)
  {
    QQGameMsgInfo localQQGameMsgInfo = new QQGameMsgInfo();
    localQQGameMsgInfo.coverUrl = paramHippyArray.getString(0);
    localQQGameMsgInfo.title = paramHippyArray.getString(1);
    localQQGameMsgInfo.url = paramHippyArray.getString(2);
    localQQGameMsgInfo.contentText = paramHippyArray.getString(3);
    localQQGameMsgInfo.limitText = paramHippyArray.getString(4);
    localQQGameMsgInfo.dateTitle = paramHippyArray.getString(5);
    localQQGameMsgInfo.paMsgid = paramHippyArray.getString(6);
    localQQGameMsgInfo.gameAppId = paramHippyArray.getString(7);
    localQQGameMsgInfo.frienduin = paramHippyArray.getString(8);
    localQQGameMsgInfo.uniseq = paramHippyArray.getLong(9);
    localQQGameMsgInfo.advId = paramHippyArray.getString(10);
    localQQGameMsgInfo.triggerInfo = paramHippyArray.getString(11);
    int k = paramHippyArray.getInt(12);
    a(localQQGameMsgInfo, BaseApplicationImpl.getContext(), k, GamePubAccountHelper.a());
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
    layout(getLeft(), getTop(), getRight(), getBottom());
  }
  
  public void e()
  {
    a(((IQQGameHippyApi)QRoute.api(IQQGameHippyApi.class)).getMsgInfoByHippyMap(this.j), BaseApplicationImpl.getContext(), ((IQQGameHippyApi)QRoute.api(IQQGameHippyApi.class)).getMsgPosByHippyMap(this.j), GamePubAccountHelper.a());
  }
  
  public String getAppName()
  {
    return "";
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return null;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildAt(0) != null) {
      getChildAt(0).layout(0, 0, getWidth(), getHeight());
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (getChildAt(0) != null) {
      getChildAt(0).measure(paramInt1, paramInt2);
    }
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher) {}
  
  public void setSrc(HippyMap paramHippyMap)
  {
    this.j = paramHippyMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.TextHeaderView
 * JD-Core Version:    0.7.0.1
 */