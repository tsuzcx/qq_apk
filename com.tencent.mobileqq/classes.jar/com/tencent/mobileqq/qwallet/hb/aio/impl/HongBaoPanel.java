package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qwallet.temp.IBaseChatPieProxy;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi.ITroopUnclaimedHbList;
import com.tencent.mobileqq.qwallet.hb.IRedPacketManager;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.hb.emoji.impl.EmojiRedpacketUserGuideDialog;
import com.tencent.mobileqq.qwallet.hb.send.PanelData;
import com.tencent.mobileqq.qwallet.hb.send.PanelTabData;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.qwallet.red.IQWalletRedService;
import com.tencent.mobileqq.qwallet.red.IQWalletRedService.ShowInfo;
import com.tencent.mobileqq.qwallet.report.impl.ReportUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class HongBaoPanel
  extends RelativeLayout
  implements View.OnClickListener
{
  private String A;
  private String B = "#5B6175";
  private String C = "#27BEF6";
  private String D = "#000000";
  private boolean E = false;
  private boolean F = false;
  private int G = 0;
  private List<Integer> H = new ArrayList();
  private View.OnClickListener I = new HongBaoPanel.3(this);
  private Integer J = null;
  private IQWalletHbApi.ITroopUnclaimedHbList K;
  public BaseQQAppInterface a;
  protected Context b;
  protected QBaseActivity c;
  GridLayoutManager d;
  HongBaoPanel.HongBaoAdapter e;
  ViewGroup f;
  IBaseChatPieProxy g;
  BaseSessionInfo h;
  boolean i = false;
  int j = 4;
  IQWalletRedService k;
  int l = ImmersiveUtils.dpToPx(14.0F);
  ICustomizeStrategyFactory.OnCustomizeListener m = new HongBaoPanel.1(this);
  HongBaoPanel.OnHolderItemClickListener n = new HongBaoPanel.5(this);
  List<Integer> o = new ArrayList();
  private ImageView p;
  private RecyclerView q;
  private RelativeLayout r;
  private ImageView s;
  private RelativeLayout t;
  private TextView u;
  private ImageView v;
  private LinearLayout w;
  private String x;
  private String y;
  private String z;
  
  public HongBaoPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public HongBaoPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private RedPacketInfo a(int paramInt, String paramString, ImageView paramImageView)
  {
    RedPacketInfo localRedPacketInfo = new RedPacketInfo();
    localRedPacketInfo.type = 7;
    localRedPacketInfo.templateId = paramString;
    return ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a(this.a, localRedPacketInfo, new HongBaoPanel.4(this, paramString, paramImageView, paramInt));
  }
  
  private void a(TextView paramTextView, String paramString, int paramInt1, int paramInt2)
  {
    int i2;
    if (paramTextView != null) {
      i2 = paramInt1;
    }
    for (;;)
    {
      try
      {
        paramTextView.setText(paramString);
        i1 = paramInt1;
        i2 = paramInt1;
        if (i()) {
          if (paramInt2 != 0)
          {
            if (paramInt2 != 1)
            {
              if (paramInt2 != 2)
              {
                i1 = paramInt1;
              }
              else
              {
                i2 = paramInt1;
                paramInt1 = Color.parseColor("#737373");
                break label138;
              }
            }
            else
            {
              i2 = paramInt1;
              paramInt1 = Color.parseColor("#004080");
              break label138;
            }
          }
          else
          {
            i2 = paramInt1;
            paramInt1 = getNightModeIconTxtColor();
            break label138;
          }
        }
        i2 = i1;
        paramTextView.setTextColor(i1);
        return;
      }
      catch (Throwable paramTextView)
      {
        paramTextView.printStackTrace();
        if (QLog.isColorLevel())
        {
          paramTextView = new StringBuilder();
          paramTextView.append("maybe parseColor failed--------,color=");
          paramTextView.append(i2);
          QLog.d("HongBaoPanel", 2, paramTextView.toString());
        }
      }
      return;
      label138:
      int i1 = paramInt1;
    }
  }
  
  private void a(RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo == null) {
      return;
    }
    try
    {
      switch (paramRedPacketInfo.skinType)
      {
      case 102: 
        if ((paramRedPacketInfo == null) || (paramRedPacketInfo.icon == null)) {
          break label288;
        }
        this.v.setImageBitmap(paramRedPacketInfo.icon);
        return;
      }
    }
    catch (Throwable paramRedPacketInfo)
    {
      if (!QLog.isColorLevel()) {
        break label288;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updatePanelPictures exception =");
      ((StringBuilder)localObject).append(paramRedPacketInfo.toString());
      QLog.i("HongBaoPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (i())
    {
      this.r.setBackgroundResource(R.drawable.ak);
      return;
    }
    if ((paramRedPacketInfo != null) && (paramRedPacketInfo.icon != null))
    {
      if (Build.VERSION.SDK_INT < 16)
      {
        this.r.setBackgroundDrawable(new BitmapDrawable(this.b.getResources(), paramRedPacketInfo.icon));
        return;
      }
      this.r.setBackground(new BitmapDrawable(this.b.getResources(), paramRedPacketInfo.icon));
      return;
      if ((paramRedPacketInfo != null) && (!TextUtils.isEmpty(paramRedPacketInfo.resPath)))
      {
        this.p.setVisibility(0);
        localObject = QWalletPicHelper.getDrawableForAIO(paramRedPacketInfo.resPath, URLDrawableHelperConstants.a);
        ((URLDrawable)localObject).setURLDrawableListener(new HongBaoPanel.2(this, paramRedPacketInfo, (Drawable)localObject));
        this.p.setImageDrawable((Drawable)localObject);
      }
      else if (this.E)
      {
        setBackgroundColor(Color.parseColor("#000000"));
        this.F = true;
      }
      if (f())
      {
        this.p.setBackgroundColor(-1);
        return;
      }
    }
    label288:
    return;
  }
  
  private void a(String paramString)
  {
    if (!StringUtil.isEmpty(paramString))
    {
      Object localObject = this.k;
      if (localObject != null)
      {
        paramString = ((IQWalletRedService)localObject).getShowInfo(paramString);
        if (paramString != null)
        {
          localObject = this.s;
          int i1;
          if (paramString.a) {
            i1 = 0;
          } else {
            i1 = 8;
          }
          ((ImageView)localObject).setVisibility(i1);
        }
      }
    }
  }
  
  private boolean a(IQWalletConfigService paramIQWalletConfigService, String paramString1, String paramString2)
  {
    if (paramIQWalletConfigService == null) {
      return false;
    }
    try
    {
      boolean bool = ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).isValidDate(paramString1, paramString2);
      return bool;
    }
    catch (Throwable paramIQWalletConfigService)
    {
      paramIQWalletConfigService.printStackTrace();
    }
    return false;
  }
  
  private boolean f()
  {
    BaseSessionInfo localBaseSessionInfo = this.h;
    if (localBaseSessionInfo == null) {
      return true;
    }
    return localBaseSessionInfo.a != 10014;
  }
  
  private void g()
  {
    Object localObject2 = (IQWalletConfigService)this.a.getRuntimeService(IQWalletConfigService.class, "");
    if (a((IQWalletConfigService)localObject2, ((IQWalletConfigService)localObject2).getString("redPackPanel", "", new String[] { "themeInfo", "begintime" }), ((IQWalletConfigService)localObject2).getString("redPackPanel", "", new String[] { "themeInfo", "endtime" })))
    {
      this.B = ((IQWalletConfigService)localObject2).getString("redPackPanel", "#5B6175", new String[] { "themeInfo", "fontColorIcon" });
      this.D = ((IQWalletConfigService)localObject2).getString("redPackPanel", "#000000", new String[] { "themeInfo", "fontColorAct" });
      this.C = ((IQWalletConfigService)localObject2).getString("redPackPanel", "#27BEF6", new String[] { "themeInfo", "fontColorTab" });
      this.z = ((IQWalletConfigService)localObject2).getString("redPackPanel", "", new String[] { "themeInfo", "panelPic" });
      this.y = ((IQWalletConfigService)localObject2).getString("redPackPanel", "#FFFFFF", new String[] { "themeInfo", "panelColor" });
    }
    if (QQTheme.isCustomTheme(VasUtil.e(), false))
    {
      this.C = "#27BEF6";
      this.B = "#5B6175";
      this.y = "";
    }
    if (!StringUtil.isEmpty(this.y)) {
      try
      {
        setBackgroundColor(Color.parseColor(this.y));
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    if (!StringUtil.isEmpty(this.z))
    {
      localObject1 = new RedPacketInfo();
      ((RedPacketInfo)localObject1).skinType = 100;
      ((RedPacketInfo)localObject1).templateId = this.z;
      ((RedPacketInfo)localObject1).type = 7;
      localObject1 = ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a(this.a, (RedPacketInfo)localObject1, this.m);
      if (localObject1 != null) {
        a((RedPacketInfo)localObject1);
      }
    }
    else if (this.E)
    {
      setBackgroundColor(Color.parseColor("#000000"));
      this.F = true;
    }
    else
    {
      setBackgroundResource(R.drawable.as);
    }
    if (!f()) {
      setBackgroundColor(-1);
    }
    Object localObject1 = ((IQWalletConfigService)localObject2).getObj("redPackPanel", new String[] { "panelAct" });
    if (localObject1 != null) {
      if (a((IQWalletConfigService)localObject2, ((IQWalletConfigService)localObject2).getString("redPackPanel", "", new String[] { "panelAct", "params", "begintime" }), ((IQWalletConfigService)localObject2).getString("redPackPanel", "", new String[] { "panelAct", "params", "endtime" })))
      {
        localObject2 = ((JSONObject)localObject1).optJSONObject("params");
        if (localObject2 != null) {
          this.x = ((JSONObject)localObject2).optString("url");
        }
        if ((!StringUtil.isEmpty(this.x)) && (this.h.a != 10014))
        {
          this.r.setVisibility(0);
          a(this.u, ((JSONObject)localObject1).optString("name"), Color.parseColor(this.D), 2);
          localObject2 = ((JSONObject)localObject1).optString("bubble_pic");
          RedPacketInfo localRedPacketInfo = new RedPacketInfo();
          localRedPacketInfo.skinType = 101;
          localRedPacketInfo.templateId = ((String)localObject2);
          localRedPacketInfo.type = 7;
          localObject2 = ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a(this.a, localRedPacketInfo, this.m);
          if (localObject2 != null) {
            a((RedPacketInfo)localObject2);
          }
          localObject2 = ((JSONObject)localObject1).optString("icon_pic");
          localRedPacketInfo = new RedPacketInfo();
          localRedPacketInfo.skinType = 102;
          localRedPacketInfo.templateId = ((String)localObject2);
          localRedPacketInfo.type = 7;
          localObject2 = ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a(this.a, localRedPacketInfo, this.m);
          if (localObject2 != null) {
            a((RedPacketInfo)localObject2);
          }
          this.A = ((JSONObject)localObject1).optString("id");
          a(this.A);
        }
      }
    }
  }
  
  private int getNightModeIconTxtColor()
  {
    if (this.J == null) {
      this.J = Integer.valueOf(getResources().getColor(com.tencent.mobileqq.qqpay.ui.R.color.k));
    }
    return this.J.intValue();
  }
  
  private void h()
  {
    List localList;
    if (this.h != null) {
      localList = ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).getPanelTabList(this.h.a, this.h.b, this.h.c);
    } else {
      localList = null;
    }
    if ((localList != null) && (localList.size() > 0))
    {
      int i1 = 0;
      while (i1 < localList.size())
      {
        Object localObject2 = (PanelTabData)localList.get(i1);
        if (i1 != 0)
        {
          localObject3 = new View(this.b);
          localObject1 = new LinearLayout.LayoutParams(ImmersiveUtils.dpToPx(0.5F), ImmersiveUtils.dpToPx(15.0F));
          ((LinearLayout.LayoutParams)localObject1).leftMargin = ImmersiveUtils.dpToPx(9.0F);
          ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          if (i()) {
            localObject1 = "#737373";
          } else {
            localObject1 = "#DEDEDE";
          }
          ((View)localObject3).setBackgroundColor(Color.parseColor((String)localObject1));
          this.w.addView((View)localObject3);
        }
        Object localObject1 = new TextView(this.b);
        this.w.addView((View)localObject1);
        ((TextView)localObject1).setTag(localObject2);
        ((TextView)localObject1).setOnClickListener(this.I);
        ((TextView)localObject1).setTextSize(2, 12.0F);
        Object localObject3 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject3).gravity = 16;
        ((TextView)localObject1).setGravity(1);
        if (i1 != 0) {
          ((LinearLayout.LayoutParams)localObject3).leftMargin = ImmersiveUtils.dpToPx(10.0F);
        }
        if (StringUtil.isEmpty(this.C)) {
          this.C = "#27BEF6";
        }
        localObject2 = ((PanelTabData)localObject2).c;
        int i2;
        if ("#27BEF6".equals(this.C)) {
          i2 = this.b.getResources().getColor(com.tencent.mobileqq.qqui.R.color.a);
        } else {
          i2 = Color.parseColor(this.C);
        }
        a((TextView)localObject1, (String)localObject2, i2, 1);
        i1 += 1;
      }
      return;
    }
    this.w.setVisibility(8);
  }
  
  private boolean i()
  {
    return (this.E) && (this.F);
  }
  
  private void j()
  {
    Object localObject = this.g;
    if ((localObject != null) && (((IBaseChatPieProxy)localObject).b() != null))
    {
      localObject = this.h;
      if (localObject != null) {
        try
        {
          localObject = ((BaseSessionInfo)localObject).b;
          int i1 = this.h.a;
          if (this.K == null) {
            this.K = ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getTroopUnclaimedHbList(this.a, this.g);
          }
          this.K.a((String)localObject, i1);
          return;
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("open troop red package fail: ");
          localStringBuilder.append(localThrowable);
          QLog.e("HongBaoPanel", 2, localStringBuilder.toString());
          return;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("HongBaoPanel", 2, "open troop red package fail!!!");
    }
  }
  
  private void k()
  {
    try
    {
      Rect localRect = new Rect();
      this.q.getHitRect(localRect);
      Iterator localIterator = this.o.iterator();
      while (localIterator.hasNext())
      {
        int i1 = ((Integer)localIterator.next()).intValue();
        Object localObject = this.q.getChildAt(i1);
        if ((localObject != null) && (((View)localObject).getLocalVisibleRect(localRect)) && (localRect.height() == ((View)localObject).getHeight()))
        {
          localObject = this.e.a(i1);
          if (localObject != null) {
            ReportUtils.a(this.a, "aio.lucky.show", this.h, ((PanelData)localObject).c);
          }
          localIterator.remove();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("HongBaoPanel", 1, localException, new Object[0]);
    }
  }
  
  public void a()
  {
    Object localObject = this.e.a();
    if (localObject != null)
    {
      if (((List)localObject).size() <= 0) {
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PanelData localPanelData = (PanelData)((Iterator)localObject).next();
        if ((localPanelData != null) && (localPanelData.b == 8)) {
          PreloadStaticApi.a().getResPath(EmojiRedpacketUserGuideDialog.a, null);
        }
      }
    }
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, IBaseChatPieProxy paramIBaseChatPieProxy)
  {
    this.a = paramBaseQQAppInterface;
    this.b = paramContext;
    this.h = paramIBaseChatPieProxy.e();
    boolean bool3 = f();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (ThemeUtil.isNowThemeIsNight(this.a, false, null)) {
        bool1 = true;
      }
    }
    this.E = bool1;
    this.g = paramIBaseChatPieProxy;
    this.c = paramIBaseChatPieProxy.b();
    this.k = ((IQWalletRedService)this.a.getRuntimeService(IQWalletRedService.class));
    this.f = paramIBaseChatPieProxy.d();
    this.p = ((ImageView)findViewById(R.id.ao));
    this.q = ((RecyclerView)findViewById(R.id.an));
    this.q.setHasFixedSize(true);
    this.t = ((RelativeLayout)findViewById(R.id.aO));
    this.w = ((LinearLayout)findViewById(R.id.aP));
    this.v = ((ImageView)findViewById(R.id.ar));
    this.r = ((RelativeLayout)findViewById(R.id.am));
    this.r.setVisibility(8);
    this.s = ((ImageView)findViewById(R.id.a));
    this.s.setVisibility(8);
    this.r.setOnClickListener(this);
    this.u = ((TextView)findViewById(R.id.cx));
    this.d = new GridLayoutManager(this.b, this.j);
    this.d.setOrientation(1);
    this.q.setLayoutManager(this.d);
    this.q.getItemAnimator().setChangeDuration(0L);
    this.q.addItemDecoration(new HongBaoPanel.SpaceItemDecoration(this));
    this.e = new HongBaoPanel.HongBaoAdapter(this);
    this.q.setAdapter(this.e);
    this.e.a(this.n);
    g();
    h();
    paramBaseQQAppInterface = ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).getPanelList(this.h);
    this.e.a(paramBaseQQAppInterface);
    b();
    a();
  }
  
  public void b()
  {
    Object localObject = this.e.a();
    if (localObject != null)
    {
      if (((List)localObject).size() <= 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      int i1 = 0;
      while (i1 < ((List)localObject).size())
      {
        localArrayList.add(((PanelData)((List)localObject).get(i1)).a);
        i1 += 1;
      }
      localObject = ((IQWalletConfigService)this.a.getRuntimeService(IQWalletConfigService.class, "")).getObj("redPackPanel", new String[] { "panelAct" });
      if (localObject != null) {
        localArrayList.add(((JSONObject)localObject).optString("id"));
      }
      this.k.doShowReport(localArrayList);
    }
  }
  
  public void c()
  {
    this.G = 0;
    IQWalletHbApi.ITroopUnclaimedHbList localITroopUnclaimedHbList = this.K;
    if (localITroopUnclaimedHbList != null) {
      localITroopUnclaimedHbList.a();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("failedImageReTryTimes=");
      ((StringBuilder)localObject).append(this.G);
      ((StringBuilder)localObject).append(",failedPositionList=");
      ((StringBuilder)localObject).append(this.H.toString());
      QLog.d("HongBaoPanel", 2, ((StringBuilder)localObject).toString());
    }
    int i1 = this.G + 1;
    this.G = i1;
    if (i1 > 3) {
      return;
    }
    Object localObject = this.H;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      i1 = 0;
      while (i1 < this.H.size())
      {
        localObject = this.e;
        if (localObject != null) {
          ((HongBaoPanel.HongBaoAdapter)localObject).notifyItemChanged(i1);
        }
        i1 += 1;
      }
      this.H.clear();
    }
  }
  
  public void e()
  {
    try
    {
      List localList = this.e.a();
      if (localList != null)
      {
        int i1 = 0;
        while (i1 < localList.size())
        {
          this.o.add(Integer.valueOf(i1));
          i1 += 1;
        }
        this.q.postDelayed(new HongBaoPanel.6(this), 300L);
        this.q.addOnScrollListener(new HongBaoPanel.7(this));
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("HongBaoPanel", 1, localException, new Object[0]);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.am)
    {
      if ((this.b != null) && (!StringUtil.isEmpty(this.x))) {
        ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).doStartBrowser(this.b, this.x);
      }
      paramView = this.k;
      if (paramView != null) {
        paramView.doClick(this.A);
      }
      a(this.A);
      if ((this.h.a != 0) && (this.h.a != 1000) && (this.h.a != 1004) && (this.h.a != 1001) && (this.h.a != 10002) && (this.h.a != 10004) && (this.h.a != 10008))
      {
        if (this.h.a == 3000) {
          paramView = "entrance.click.group";
        } else if (this.h.a == 1) {
          paramView = "entrance.click.chatgroup";
        } else {
          paramView = "";
        }
      }
      else {
        paramView = "entrance.click.c2c";
      }
      int i1 = ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getPanelFrom();
      Object localObject;
      if (i1 == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramView);
        ((StringBuilder)localObject).append(".plus");
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = paramView;
        if (i1 == 1)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramView);
          ((StringBuilder)localObject).append(".quick");
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      ReportController.b(this.a, "P_CliOper", "Vip_pay_mywallet", "", "wallet", (String)localObject, 0, 0, "10000", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.HongBaoPanel
 * JD-Core Version:    0.7.0.1
 */