package com.tencent.mobileqq.forward;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ForwardPreviewTroopMemberController
  extends ForwardPreviewBaseController
{
  public static int e = 0;
  public static int f = 1;
  private RecyclerView g;
  private QQAppInterface h;
  private String i = "";
  private ForwardPreviewTroopMemberController.TroopMemberRecyclerViewAdapter j;
  private GridLayoutManager k;
  private IFaceDecoder l;
  private TroopObserver m = new ForwardPreviewTroopMemberController.2(this);
  private DecodeTaskCompletionListener n = new ForwardPreviewTroopMemberController.3(this);
  private RecyclerView.OnScrollListener o = new ForwardPreviewTroopMemberController.4(this);
  
  public ForwardPreviewTroopMemberController(QQCustomDialog paramQQCustomDialog)
  {
    super(paramQQCustomDialog);
  }
  
  private void b(String paramString)
  {
    ThreadManager.getFileThreadHandler().post(new ForwardPreviewTroopMemberController.1(this, paramString));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bindData title: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" uin: ");
    localStringBuilder.append(paramString2);
    QLog.i("Forward.Preview.Dialog", 1, localStringBuilder.toString());
    this.h = paramQQAppInterface;
    paramQQAppInterface = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramQQAppInterface = "";
    }
    this.i = paramQQAppInterface;
    a(paramString1);
    this.h.addObserver(this.m);
    this.l = ((IQQAvatarService)this.h.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.h);
    this.l.setDecodeTaskCompletionListener(this.n);
    this.j = new ForwardPreviewTroopMemberController.TroopMemberRecyclerViewAdapter(this.h, this.b, this.l);
    this.g.setAdapter(this.j);
    this.g.addOnScrollListener(this.o);
    g();
    if (paramInt == 1)
    {
      ((ITroopMemberListHandler)this.h.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER)).a(this.i);
      return;
    }
    if (paramInt == 3000) {
      b(this.i);
    }
  }
  
  protected View c()
  {
    if (this.g == null)
    {
      this.g = new RecyclerView(this.b);
      this.k = new GridLayoutManager(this.b, 5);
      this.g.setLayoutManager(this.k);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      int i1 = AIOUtils.b(5.0F, this.b.getResources());
      localLayoutParams.rightMargin = i1;
      localLayoutParams.leftMargin = i1;
      this.g.setLayoutParams(localLayoutParams);
      this.g.setOverScrollMode(2);
    }
    return this.g;
  }
  
  protected int d()
  {
    return 380;
  }
  
  protected void e()
  {
    QLog.i("Forward.Preview.Dialog", 1, "onDestroy.");
    this.h.removeObserver(this.m);
    IFaceDecoder localIFaceDecoder = this.l;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPreviewTroopMemberController
 * JD-Core Version:    0.7.0.1
 */