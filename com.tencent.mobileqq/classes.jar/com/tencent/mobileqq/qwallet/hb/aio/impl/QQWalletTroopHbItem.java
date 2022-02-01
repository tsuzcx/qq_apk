package com.tencent.mobileqq.qwallet.hb.aio.impl;

import Wallet.RedPackGrapInfo;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.qwallet.temp.IBaseChatPieProxy;
import com.qwallet.temp.IQWalletMsgHolder;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.hb.aio.viewholder.IFBaseViewHolder;
import com.tencent.mobileqq.qwallet.hb.aio.viewholder.IViewHolderFactory;
import com.tencent.mobileqq.qwallet.hb.aio.viewholder.QWalletMsgHolderBase;
import com.tencent.qphone.base.util.QLog;

public class QQWalletTroopHbItem
  implements ICustomizeStrategyFactory.OnCustomizeListener
{
  public Context a;
  QQWalletHbItemApiImpl b;
  BaseSessionInfo c;
  RedPackGrapInfo d;
  MessageForQQWalletMsg e = null;
  IBaseChatPieProxy f;
  IFaceDecoder g;
  int h;
  QWalletMsgHolderBase i;
  private BaseQQAppInterface j;
  
  public QQWalletTroopHbItem(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, IBaseChatPieProxy paramIBaseChatPieProxy)
  {
    this.j = paramBaseQQAppInterface;
    this.a = paramContext;
    this.f = paramIBaseChatPieProxy;
    this.c = paramIBaseChatPieProxy.e();
    this.g = ((IQQAvatarService)paramBaseQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramBaseQQAppInterface);
    this.b = new QQWalletHbItemApiImpl();
  }
  
  public FrameLayout.LayoutParams a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams.gravity = 48;
    localLayoutParams.leftMargin = paramInt3;
    localLayoutParams.topMargin = paramInt4;
    return localLayoutParams;
  }
  
  public FrameLayout a(LinearLayout paramLinearLayout)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramLinearLayout != null)
    {
      if (this.e == null) {
        return null;
      }
      this.i = new QWalletMsgHolderBase();
      localObject1 = this.i;
      ((QWalletMsgHolderBase)localObject1).p = this.e;
      ((QWalletMsgHolderBase)localObject1).a = this.b.createRedPacketWithOutGrayBar((IQWalletMsgHolder)localObject1, this.a);
      this.i.a.setTag(this.e);
      localObject1 = paramLinearLayout.findViewById(R.id.bC);
      if (QLog.isColorLevel()) {
        QLog.d("TroopUnAccalimedRedPacketList", 2, new Object[] { Boolean.valueOf(localObject1 instanceof RelativeLayout) });
      }
      float f1 = this.a.getResources().getDisplayMetrics().density;
      int k = (int)(173.0F * f1 + 0.5F);
      int m = (int)(255.0F * f1 + 0.5F);
      int n = (int)(6.5F * f1 + 0.5F);
      int i1 = (int)(f1 * 7.5F + 0.5F);
      Object localObject3;
      if (localObject1 == null)
      {
        localObject2 = new FrameLayout(this.a);
        localObject1 = this.i;
        ((QWalletMsgHolderBase)localObject1).a = this.b.createRedPacketWithOutGrayBar((IQWalletMsgHolder)localObject1, this.a);
        this.i.a.setTag(this.e);
        ((FrameLayout)localObject2).addView(this.i.a, a(k, m, n, i1));
        localObject3 = paramLinearLayout.findViewById(R.id.bM);
        localObject1 = localObject2;
        if (this.i.k != null)
        {
          localObject1 = new RelativeLayout.LayoutParams(k, m);
          if (localObject3 != null) {
            ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          } else {
            ((FrameLayout)localObject2).addView(this.i.k, (ViewGroup.LayoutParams)localObject1);
          }
          paramLinearLayout.addView((View)localObject2, -1, -1);
          localObject1 = localObject2;
        }
      }
      else
      {
        localObject3 = ((View)localObject1).getParent();
        localObject1 = localObject2;
        if ((localObject3 instanceof FrameLayout))
        {
          localObject1 = (FrameLayout)localObject3;
          ((FrameLayout)localObject1).removeAllViews();
          localObject2 = this.i;
          ((QWalletMsgHolderBase)localObject2).a = this.b.createRedPacketWithOutGrayBar((IQWalletMsgHolder)localObject2, this.a);
          this.i.a.setTag(this.e);
          ((FrameLayout)localObject1).addView(this.i.a, a(k, m, n, i1));
          localObject2 = new RelativeLayout.LayoutParams(k, m);
          paramLinearLayout = paramLinearLayout.findViewById(R.id.bM);
          if (paramLinearLayout != null) {
            paramLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          } else {
            ((FrameLayout)localObject1).addView(this.i.k, (ViewGroup.LayoutParams)localObject2);
          }
        }
      }
      a(this.e);
    }
    return localObject1;
  }
  
  public void a(int paramInt, RedPacketInfo paramRedPacketInfo)
  {
    if ((paramRedPacketInfo != null) && ((paramRedPacketInfo.a instanceof MessageForQQWalletMsg)))
    {
      MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramRedPacketInfo.a;
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return;
            }
            if (paramRedPacketInfo.skinType == 1) {
              a(localMessageForQQWalletMsg);
            }
            if ((paramRedPacketInfo.skinType == 3) && (paramRedPacketInfo.specailBackgroundAnimInfo != null)) {
              a(localMessageForQQWalletMsg);
            }
          }
          else if (paramRedPacketInfo.animInfo != null)
          {
            a(localMessageForQQWalletMsg);
          }
        }
        else if ((paramRedPacketInfo.a()) || (paramRedPacketInfo.e != null)) {
          a(localMessageForQQWalletMsg);
        }
      }
      else if (paramRedPacketInfo.background != null) {
        a(localMessageForQQWalletMsg);
      }
    }
  }
  
  public void a(RedPackGrapInfo paramRedPackGrapInfo)
  {
    this.d = paramRedPackGrapInfo;
    this.e = new MessageForQQWalletMsg();
    this.e.frienduin = this.c.b;
    Object localObject = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramRedPackGrapInfo.lUin);
    localStringBuilder.append("");
    ((MessageForQQWalletMsg)localObject).senderuin = localStringBuilder.toString();
    this.e.messageType = paramRedPackGrapInfo.iMsgType;
    this.e.mQQWalletRedPacketMsg = new QQWalletRedPacketMsg();
    this.e.mQQWalletRedPacketMsg.redPacketId = paramRedPackGrapInfo.sBiilNo;
    this.e.mQQWalletRedPacketMsg.authkey = paramRedPackGrapInfo.sAuthKey;
    this.e.mQQWalletRedPacketMsg.redtype = paramRedPackGrapInfo.iRedType;
    this.e.mQQWalletRedPacketMsg.redChannel = paramRedPackGrapInfo.iRedChannel;
    this.e.mQQWalletRedPacketMsg.envelopeid = paramRedPackGrapInfo.iEnvelopeId;
    this.e.mQQWalletRedPacketMsg.envelopeName = paramRedPackGrapInfo.sName;
    this.e.mQQWalletRedPacketMsg.specifyUinList = paramRedPackGrapInfo.vecGrapUin;
    this.e.mQQWalletRedPacketMsg.elem = new QQWalletBaseMsgElem();
    this.e.mQQWalletRedPacketMsg.elem.c = paramRedPackGrapInfo.sTitle;
    this.e.mQQWalletRedPacketMsg.elem.z = paramRedPackGrapInfo.iSubjectId;
    this.e.mQQWalletRedPacketMsg.elem.u = paramRedPackGrapInfo.iResourceType;
    this.e.mQQWalletRedPacketMsg.elem.v = paramRedPackGrapInfo.iSkinId;
    this.e.mQQWalletRedPacketMsg.elem.w = paramRedPackGrapInfo.iEffectsId;
    this.e.mQQWalletRedPacketMsg.elem.x = paramRedPackGrapInfo.iSpecialPopId;
    this.e.mQQWalletRedPacketMsg.elem.t = paramRedPackGrapInfo.iSoundRecordDuration;
    this.e.mQQWalletRedPacketMsg.elem.e = paramRedPackGrapInfo.sContent;
    this.e.mQQWalletRedPacketMsg.elem.k = "3|2|1";
    localObject = this.e.mQQWalletRedPacketMsg.elem;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("red?id=");
    localStringBuilder.append(paramRedPackGrapInfo.sBiilNo);
    ((QQWalletBaseMsgElem)localObject).m = localStringBuilder.toString();
    this.e.mQQWalletRedPacketMsg.elem.B = paramRedPackGrapInfo.iSongId;
    this.e.mQQWalletRedPacketMsg.elem.C = paramRedPackGrapInfo.iSongFlag;
    this.e.mQQWalletRedPacketMsg.elem.D = paramRedPackGrapInfo.hbIdiomLastPY;
    this.e.mQQWalletRedPacketMsg.body = new QQWalletAioBodyReserve(paramRedPackGrapInfo.sReserve);
    localObject = this.c.b;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramRedPackGrapInfo.lUin);
    localStringBuilder.append("");
    if (((String)localObject).equals(localStringBuilder.toString())) {
      this.e.issend = 1;
    }
    this.e.istroop = this.c.a;
    if (this.e.messageType != 6) {
      this.e.fromHBList = 1;
    }
    this.h = ((IViewHolderFactory)QRoute.api(IViewHolderFactory.class)).getRedPkgType(paramRedPackGrapInfo.iMsgType);
    if ((this.h == 4) && (paramRedPackGrapInfo.iSkinId > 0)) {
      this.h = 0;
    }
  }
  
  public void a(MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    int k = ((IViewHolderFactory)QRoute.api(IViewHolderFactory.class)).getRedPkgType(paramMessageForQQWalletMsg.messageType);
    paramMessageForQQWalletMsg = ((IViewHolderFactory)QRoute.api(IViewHolderFactory.class)).createViewHolder(this.j, this.c, this.i, paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem, k, this);
    try
    {
      paramMessageForQQWalletMsg.a();
      paramMessageForQQWalletMsg.c();
      paramMessageForQQWalletMsg.d();
      paramMessageForQQWalletMsg.e();
      paramMessageForQQWalletMsg.b();
      paramMessageForQQWalletMsg.f();
      paramMessageForQQWalletMsg.i();
      return;
    }
    catch (Throwable paramMessageForQQWalletMsg) {}
  }
  
  public boolean a(FrameLayout paramFrameLayout, RedPackGrapInfo paramRedPackGrapInfo, QQWalletHbItemApiImpl.HbItemClickListener paramHbItemClickListener)
  {
    if (paramFrameLayout == null) {
      return false;
    }
    this.b.setHbItemClickListener(paramHbItemClickListener);
    paramFrameLayout = (RelativeLayout)paramFrameLayout.findViewById(R.id.bC);
    if (paramFrameLayout == null) {
      return false;
    }
    if ((MessageForQQWalletMsg)paramFrameLayout.getTag() == null) {
      return false;
    }
    paramHbItemClickListener = this.a;
    if (paramHbItemClickListener != null) {
      paramHbItemClickListener.getString(R.string.dm);
    }
    return this.b.setHbOnClickListener(this.j, this.f, paramFrameLayout, this.c, this.h, paramRedPackGrapInfo.iSkinId, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.QQWalletTroopHbItem
 * JD-Core Version:    0.7.0.1
 */