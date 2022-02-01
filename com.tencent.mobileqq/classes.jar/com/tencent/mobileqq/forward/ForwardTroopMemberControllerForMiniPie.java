package com.tencent.mobileqq.forward;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ForwardTroopMemberControllerForMiniPie
{
  public static int a = 0;
  public static int b = 1;
  private RecyclerView c;
  private RelativeLayout d;
  private TextView e;
  private QQAppInterface f;
  private String g = "";
  private ForwardTroopMemberControllerForMiniPie.TroopMemberRecyclerViewAdapter h;
  private GridLayoutManager i;
  private IFaceDecoder j;
  private Context k;
  private float l = 1.0F;
  private TroopObserver m = new ForwardTroopMemberControllerForMiniPie.2(this);
  private DecodeTaskCompletionListener n = new ForwardTroopMemberControllerForMiniPie.3(this);
  private RecyclerView.OnScrollListener o = new ForwardTroopMemberControllerForMiniPie.4(this);
  
  public ForwardTroopMemberControllerForMiniPie(Context paramContext)
  {
    this.k = paramContext;
    e();
  }
  
  private void a(String paramString)
  {
    ThreadManager.getFileThreadHandler().post(new ForwardTroopMemberControllerForMiniPie.1(this, paramString));
  }
  
  private void c()
  {
    Object localObject = this.e;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.c;
    if (localObject != null) {
      ((RecyclerView)localObject).setVisibility(4);
    }
  }
  
  private void d()
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((RecyclerView)localObject).setVisibility(0);
    }
    localObject = this.e;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(4);
    }
  }
  
  private void e()
  {
    if (this.d == null)
    {
      this.d = new RelativeLayout(this.k);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int i1;
    if (this.e == null)
    {
      this.e = new TextView(this.k);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.e.setText(HardCodeUtil.a(2131902843));
      double d1 = this.l;
      Double.isNaN(d1);
      i1 = (int)(16.0D / d1);
      this.e.setTextSize(2, i1);
      this.e.setTextColor(this.k.getResources().getColor(2131168135));
    }
    if (this.c == null)
    {
      this.c = new RecyclerView(this.k);
      localObject = this.k;
      i1 = 5;
      this.i = new GridLayoutManager((Context)localObject, 5);
      this.c.setLayoutManager(this.i);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      float f1 = this.l;
      if (f1 != 0.0F) {
        i1 = (int)(5 / f1);
      }
      i1 = AIOUtils.b(i1, this.k.getResources());
      ((RelativeLayout.LayoutParams)localObject).rightMargin = i1;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = i1;
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.c.setOverScrollMode(2);
    }
    Object localObject = this.d;
    if (localObject != null)
    {
      ((RelativeLayout)localObject).addView(this.c);
      this.d.addView(this.e);
    }
  }
  
  public View a()
  {
    return this.d;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setTroopInfo  uin: ");
    localStringBuilder.append(paramString);
    QLog.i("ForwardTroopMemberControllerForMiniPie", 1, localStringBuilder.toString());
    this.f = paramQQAppInterface;
    paramQQAppInterface = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramQQAppInterface = "";
    }
    this.g = paramQQAppInterface;
    paramQQAppInterface = this.f;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.addObserver(this.m);
      this.j = ((IQQAvatarService)this.f.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.f);
      this.j.setDecodeTaskCompletionListener(this.n);
      this.l = paramFloat;
      this.h = new ForwardTroopMemberControllerForMiniPie.TroopMemberRecyclerViewAdapter(this.k, this.j, this.l);
      this.c.setAdapter(this.h);
      this.c.addOnScrollListener(this.o);
      c();
      if (paramInt == 1)
      {
        ((ITroopMemberListHandler)this.f.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER)).a(this.g);
        return;
      }
      if (paramInt == 3000) {
        a(this.g);
      }
    }
  }
  
  public void b()
  {
    QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "destroy.");
    Object localObject = this.f;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeObserver(this.m);
    }
    localObject = this.j;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    this.f = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardTroopMemberControllerForMiniPie
 * JD-Core Version:    0.7.0.1
 */