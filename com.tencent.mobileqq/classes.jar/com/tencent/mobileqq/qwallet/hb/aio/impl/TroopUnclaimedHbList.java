package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.qwallet.temp.IBaseChatPieProxy;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi.ITroopUnclaimedHbList;
import com.tencent.mobileqq.qwallet.hb.IRedPacketManager;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;

public class TroopUnclaimedHbList
  extends FrameLayout
  implements IQWalletHbApi.ITroopUnclaimedHbList
{
  public PopupWindow a;
  private RelativeLayout b;
  private BaseQQAppInterface c;
  private IBaseChatPieProxy d;
  private TextView e;
  private TroopUnclaimedHbList.HbListAdapter f;
  private RecyclerView g;
  private ImageView h;
  private String i;
  private int j;
  private boolean k = false;
  private Context l;
  private Animator m;
  private ImageView n;
  private TroopUnclaimedHbList.RedPacketRefreshReceiver o;
  private boolean p;
  
  public TroopUnclaimedHbList(BaseQQAppInterface paramBaseQQAppInterface, IBaseChatPieProxy paramIBaseChatPieProxy)
  {
    super(paramIBaseChatPieProxy.b().getApplicationContext());
    try
    {
      this.l = paramIBaseChatPieProxy.b().getApplicationContext();
      this.c = paramBaseQQAppInterface;
      this.d = paramIBaseChatPieProxy;
      this.b = new RelativeLayout(this.l);
      addView(this.b);
      this.b.getLayoutParams().width = -1;
      this.b.getLayoutParams().height = -1;
      this.b.setBackgroundColor(Color.parseColor("#b2000000"));
      this.b.setOnClickListener(new TroopUnclaimedHbList.1(this));
      this.h = new ImageView(this.l);
      this.b.addView(this.h);
      this.h.setImageResource(R.drawable.o);
      AccessibilityUtil.a(this.h, HardCodeUtil.a(R.string.dj));
      paramBaseQQAppInterface = (RelativeLayout.LayoutParams)this.h.getLayoutParams();
      paramBaseQQAppInterface.leftMargin = ScreenUtil.dip2px(12.5F);
      paramBaseQQAppInterface.topMargin = ScreenUtil.dip2px(37.5F);
      this.h.setLayoutParams(paramBaseQQAppInterface);
      this.h.setOnClickListener(new TroopUnclaimedHbList.2(this));
      this.n = new ImageView(this.l);
      this.b.addView(this.n);
      paramBaseQQAppInterface = (RelativeLayout.LayoutParams)this.n.getLayoutParams();
      paramBaseQQAppInterface.width = ScreenUtil.dip2px(80.0F);
      paramBaseQQAppInterface.height = ScreenUtil.dip2px(32.0F);
      paramBaseQQAppInterface.addRule(13);
      this.e = new TextView(this.l);
      this.b.addView(this.e);
      paramBaseQQAppInterface = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
      paramBaseQQAppInterface.width = -1;
      paramBaseQQAppInterface.height = -2;
      paramBaseQQAppInterface.addRule(15);
      this.e.setLayoutParams(paramBaseQQAppInterface);
      paramBaseQQAppInterface = this.l.getResources().getDrawable(R.drawable.n);
      paramBaseQQAppInterface.setBounds(0, 0, ScreenUtil.dip2px(100.0F), ScreenUtil.dip2px(100.0F));
      this.e.setCompoundDrawables(null, paramBaseQQAppInterface, null, null);
      this.e.setCompoundDrawablePadding(ScreenUtil.dip2px(20.0F));
      this.e.setTextColor(Color.parseColor("#FFFFFF"));
      this.e.setTextSize(1, 14.0F);
      this.e.setGravity(1);
      this.e.setVisibility(8);
      this.f = new TroopUnclaimedHbList.HbListAdapter(this, this.l);
      this.g = new RecyclerView(this.l);
      this.b.addView(this.g);
      paramBaseQQAppInterface = (RelativeLayout.LayoutParams)this.g.getLayoutParams();
      paramBaseQQAppInterface.width = -1;
      paramBaseQQAppInterface.height = ScreenUtil.dip2px(300.0F);
      paramBaseQQAppInterface.addRule(15);
      this.g.setLayoutManager(new LinearLayoutManager(this.l, 0, false));
      this.g.setAdapter(this.f);
      int i1 = (ScreenUtil.getInstantScreenWidth(this.l) - ScreenUtil.dip2px(160.0F)) / 2;
      this.g.addItemDecoration(new TroopUnclaimedHbList.HbListItemDecoration(i1, ScreenUtil.dip2px(3.5F), null));
      this.g.setHasFixedSize(false);
      this.g.getItemAnimator().setRemoveDuration(300L);
      this.g.getItemAnimator().setChangeDuration(300L);
      this.g.setOnScrollListener(new TroopUnclaimedHbList.3(this));
      this.m = ObjectAnimator.ofFloat(this.g, "translationX", new float[] { i1, 0.0F });
      this.m.setInterpolator(new LinearInterpolator());
      this.m.setDuration(300L);
      this.g.setVisibility(8);
      return;
    }
    catch (Throwable paramBaseQQAppInterface)
    {
      if (QLog.isColorLevel())
      {
        paramIBaseChatPieProxy = new StringBuilder();
        paramIBaseChatPieProxy.append("init faile because has occur an exception: ");
        paramIBaseChatPieProxy.append(paramBaseQQAppInterface);
        QLog.e("TroopUnclaimedRedPacketList", 2, paramIBaseChatPieProxy.toString());
      }
    }
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a = null;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    BaseQQAppInterface localBaseQQAppInterface = this.c;
    if (localBaseQQAppInterface != null) {
      QWalletTools.a(localBaseQQAppInterface, localBaseQQAppInterface.getCurrentAccountUin(), 2, "", 0L, 162, "aio.hongbaolist.show", "", "");
    }
    try
    {
      if (this.n != null) {
        LottieComposition.Factory.fromJsonString(getLoadingLottieJson(), new TroopUnclaimedHbList.4(this));
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    this.i = paramString;
    this.j = paramInt;
    if (this.a == null) {
      this.a = new PopupWindow(this, -1, -1);
    }
    this.a.setBackgroundDrawable(new ColorDrawable());
    this.a.setOutsideTouchable(true);
    this.a.setFocusable(true);
    this.a.showAtLocation(this.d.d(), 17, 0, 0);
    this.a.setOnDismissListener(new TroopUnclaimedHbList.5(this));
    ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).reqGroupAvailableList(this.i, this.j, new TroopUnclaimedHbList.6(this));
  }
  
  public String getLoadingLottieJson()
  {
    return "{\"v\":\"5.5.3\",\"fr\":25,\"ip\":0,\"op\":12,\"w\":156,\"h\":60,\"nm\":\"预合成 1\",\"ddd\":0,\"assets\":[],\"layers\":[{\"ddd\":0,\"ind\":1,\"ty\":4,\"nm\":\"形状图层 2\",\"sr\":1,\"ks\":{\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"t\":0,\"s\":[0]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"t\":8,\"s\":[72]},{\"t\":10,\"s\":[80]}],\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":1,\"k\":[{\"i\":{\"x\":0.833,\"y\":0.833},\"o\":{\"x\":0.167,\"y\":0.167},\"t\":0,\"s\":[130,30,0],\"to\":[-4.838,0,0],\"ti\":[10.78,0,0]},{\"i\":{\"x\":0.833,\"y\":0.833},\"o\":{\"x\":0.167,\"y\":0.167},\"t\":2,\"s\":[124.6,30,0],\"to\":[-25.839,0,0],\"ti\":[12.231,0,0]},{\"i\":{\"x\":0.833,\"y\":0.833},\"o\":{\"x\":0.167,\"y\":0.167},\"t\":8,\"s\":[94.8,30,0],\"to\":[-17.333,0,0],\"ti\":[2.8,0,0]},{\"t\":10,\"s\":[78,30,0]}],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-0.42,-1.76],[14.266,-0.006],[3.48,4.502],[-1.923,0],[0,0]],\"o\":[[-3.513,4.387],[-14.368,0.344],[0.383,-1.809],[0,0],[1.889,0]],\"v\":[[25.891,-26.931],[0,-15],[-25.913,-26.834],[-22,-30],[22,-30]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,1,1,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"bm\":0,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[0,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"形状 2\",\"np\":2,\"cix\":2,\"bm\":0,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false},{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-4.464,2.15],[0,0],[2.209,0],[0,0],[0,2.209],[0,0],[-9.878,0.003]],\"o\":[[0,0],[0,2.209],[0,0],[-2.209,0],[0,0],[4.565,1.866],[10.339,-0.003]],\"v\":[[26,-16.992],[26,26],[22,30],[-22,30],[-26,26],[-26,-16.148],[0,-10]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,1,1,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"bm\":0,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[0,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"形状 1\",\"np\":2,\"cix\":2,\"bm\":0,\"ix\":2,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":0,\"op\":12,\"st\":0,\"bm\":0},{\"ddd\":0,\"ind\":2,\"ty\":4,\"nm\":\"形状图层 1\",\"sr\":1,\"ks\":{\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"t\":0,\"s\":[80]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"t\":8,\"s\":[8]},{\"t\":10,\"s\":[0]}],\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":1,\"k\":[{\"i\":{\"x\":0.833,\"y\":0.833},\"o\":{\"x\":0.167,\"y\":0.167},\"t\":0,\"s\":[78,30,0],\"to\":[-7.767,0,0],\"ti\":[8.667,0,0]},{\"i\":{\"x\":0.833,\"y\":0.833},\"o\":{\"x\":0.167,\"y\":0.167},\"t\":8,\"s\":[31.4,30,0],\"to\":[-8.667,0,0],\"ti\":[0.9,0,0]},{\"t\":10,\"s\":[26,30,0]}],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-0.42,-1.76],[14.266,-0.006],[3.48,4.502],[-1.923,0],[0,0]],\"o\":[[-3.513,4.387],[-14.368,0.344],[0.383,-1.809],[0,0],[1.889,0]],\"v\":[[25.891,-26.931],[0,-15],[-25.913,-26.834],[-22,-30],[22,-30]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,1,1,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"bm\":0,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[0,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"形状 2\",\"np\":2,\"cix\":2,\"bm\":0,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false},{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-4.464,2.15],[0,0],[2.209,0],[0,0],[0,2.209],[0,0],[-9.878,0.003]],\"o\":[[0,0],[0,2.209],[0,0],[-2.209,0],[0,0],[4.565,1.866],[10.339,-0.003]],\"v\":[[26,-16.992],[26,26],[22,30],[-22,30],[-26,26],[-26,-16.148],[0,-10]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,1,1,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"bm\":0,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[0,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"形状 1\",\"np\":2,\"cix\":2,\"bm\":0,\"ix\":2,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":0,\"op\":12,\"st\":0,\"bm\":0}],\"markers\":[]}";
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.p = true;
    this.o = new TroopUnclaimedHbList.RedPacketRefreshReceiver(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("troop_hblist_broadcast_action");
    this.l.registerReceiver(this.o, localIntentFilter);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.p = false;
    Object localObject = this.m;
    if ((localObject != null) && (((Animator)localObject).isRunning())) {
      this.m.cancel();
    }
    localObject = this.o;
    if (localObject != null)
    {
      this.l.unregisterReceiver((BroadcastReceiver)localObject);
      this.o = null;
    }
    QQWalletHbItemApiImpl.cleanMessageForQQWalletMsgMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.TroopUnclaimedHbList
 * JD-Core Version:    0.7.0.1
 */