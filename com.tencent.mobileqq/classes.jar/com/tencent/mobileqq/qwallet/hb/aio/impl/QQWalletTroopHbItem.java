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
  int jdField_a_of_type_Int;
  RedPackGrapInfo jdField_a_of_type_WalletRedPackGrapInfo;
  public Context a;
  IBaseChatPieProxy jdField_a_of_type_ComQwalletTempIBaseChatPieProxy;
  private BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
  BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  MessageForQQWalletMsg jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = null;
  QQWalletHbItemApiImpl jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplQQWalletHbItemApiImpl;
  QWalletMsgHolderBase jdField_a_of_type_ComTencentMobileqqQwalletHbAioViewholderQWalletMsgHolderBase;
  
  public QQWalletTroopHbItem(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, IBaseChatPieProxy paramIBaseChatPieProxy)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComQwalletTempIBaseChatPieProxy = paramIBaseChatPieProxy;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramIBaseChatPieProxy.a();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramBaseQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramBaseQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplQQWalletHbItemApiImpl = new QQWalletHbItemApiImpl();
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
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null) {
        return null;
      }
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioViewholderQWalletMsgHolderBase = new QWalletMsgHolderBase();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioViewholderQWalletMsgHolderBase;
      ((QWalletMsgHolderBase)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg;
      ((QWalletMsgHolderBase)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplQQWalletHbItemApiImpl.createRedPacketWithOutGrayBar((IQWalletMsgHolder)localObject1, this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioViewholderQWalletMsgHolderBase.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
      localObject1 = paramLinearLayout.findViewById(R.id.bs);
      if (QLog.isColorLevel()) {
        QLog.d("TroopUnAccalimedRedPacketList", 2, new Object[] { Boolean.valueOf(localObject1 instanceof RelativeLayout) });
      }
      float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
      int i = (int)(173.0F * f + 0.5F);
      int j = (int)(255.0F * f + 0.5F);
      int k = (int)(6.5F * f + 0.5F);
      int m = (int)(f * 7.5F + 0.5F);
      Object localObject3;
      if (localObject1 == null)
      {
        localObject2 = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioViewholderQWalletMsgHolderBase;
        ((QWalletMsgHolderBase)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplQQWalletHbItemApiImpl.createRedPacketWithOutGrayBar((IQWalletMsgHolder)localObject1, this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioViewholderQWalletMsgHolderBase.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
        ((FrameLayout)localObject2).addView(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioViewholderQWalletMsgHolderBase.jdField_a_of_type_AndroidWidgetRelativeLayout, a(i, j, k, m));
        localObject3 = paramLinearLayout.findViewById(R.id.bC);
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioViewholderQWalletMsgHolderBase.b != null)
        {
          localObject1 = new RelativeLayout.LayoutParams(i, j);
          if (localObject3 != null) {
            ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          } else {
            ((FrameLayout)localObject2).addView(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioViewholderQWalletMsgHolderBase.b, (ViewGroup.LayoutParams)localObject1);
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
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioViewholderQWalletMsgHolderBase;
          ((QWalletMsgHolderBase)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplQQWalletHbItemApiImpl.createRedPacketWithOutGrayBar((IQWalletMsgHolder)localObject2, this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioViewholderQWalletMsgHolderBase.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
          ((FrameLayout)localObject1).addView(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioViewholderQWalletMsgHolderBase.jdField_a_of_type_AndroidWidgetRelativeLayout, a(i, j, k, m));
          localObject2 = new RelativeLayout.LayoutParams(i, j);
          paramLinearLayout = paramLinearLayout.findViewById(R.id.bC);
          if (paramLinearLayout != null) {
            paramLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          } else {
            ((FrameLayout)localObject1).addView(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioViewholderQWalletMsgHolderBase.b, (ViewGroup.LayoutParams)localObject2);
          }
        }
      }
      a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
    }
    return localObject1;
  }
  
  public void a(int paramInt, RedPacketInfo paramRedPacketInfo)
  {
    if ((paramRedPacketInfo != null) && ((paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForQQWalletMsg)))
    {
      MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
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
        else if ((paramRedPacketInfo.a()) || (paramRedPacketInfo.jdField_a_of_type_AndroidGraphicsBitmap != null)) {
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
    this.jdField_a_of_type_WalletRedPackGrapInfo = paramRedPackGrapInfo;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = new MessageForQQWalletMsg();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramRedPackGrapInfo.lUin);
    localStringBuilder.append("");
    ((MessageForQQWalletMsg)localObject).senderuin = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.messageType = paramRedPackGrapInfo.iMsgType;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg = new QQWalletRedPacketMsg();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId = paramRedPackGrapInfo.sBiilNo;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey = paramRedPackGrapInfo.sAuthKey;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redtype = paramRedPackGrapInfo.iRedType;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redChannel = paramRedPackGrapInfo.iRedChannel;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.envelopeid = paramRedPackGrapInfo.iEnvelopeId;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.envelopeName = paramRedPackGrapInfo.sName;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList = paramRedPackGrapInfo.vecGrapUin;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem = new QQWalletBaseMsgElem();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.jdField_a_of_type_JavaLangString = paramRedPackGrapInfo.sTitle;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.l = paramRedPackGrapInfo.iSubjectId;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.h = paramRedPackGrapInfo.iResourceType;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.jdField_i_of_type_Int = paramRedPackGrapInfo.iSkinId;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.j = paramRedPackGrapInfo.iEffectsId;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.k = paramRedPackGrapInfo.iSpecialPopId;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.jdField_g_of_type_Int = paramRedPackGrapInfo.iSoundRecordDuration;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.c = paramRedPackGrapInfo.sContent;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.jdField_g_of_type_JavaLangString = "3|2|1";
    localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("red?id=");
    localStringBuilder.append(paramRedPackGrapInfo.sBiilNo);
    ((QQWalletBaseMsgElem)localObject).jdField_i_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.jdField_n_of_type_Int = paramRedPackGrapInfo.iSongId;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.o = paramRedPackGrapInfo.iSongFlag;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.jdField_n_of_type_JavaLangString = paramRedPackGrapInfo.hbIdiomLastPY;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.body = new QQWalletAioBodyReserve(paramRedPackGrapInfo.sReserve);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramRedPackGrapInfo.lUin);
    localStringBuilder.append("");
    if (((String)localObject).equals(localStringBuilder.toString())) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.issend = 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.messageType != 6) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.fromHBList = 1;
    }
    this.jdField_a_of_type_Int = ((IViewHolderFactory)QRoute.api(IViewHolderFactory.class)).getRedPkgType(paramRedPackGrapInfo.iMsgType);
    if ((this.jdField_a_of_type_Int == 4) && (paramRedPackGrapInfo.iSkinId > 0)) {
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public void a(MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    int i = ((IViewHolderFactory)QRoute.api(IViewHolderFactory.class)).getRedPkgType(paramMessageForQQWalletMsg.messageType);
    paramMessageForQQWalletMsg = ((IViewHolderFactory)QRoute.api(IViewHolderFactory.class)).createViewHolder(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioViewholderQWalletMsgHolderBase, paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem, i, this);
    try
    {
      paramMessageForQQWalletMsg.a();
      paramMessageForQQWalletMsg.c();
      paramMessageForQQWalletMsg.d();
      paramMessageForQQWalletMsg.e();
      paramMessageForQQWalletMsg.b();
      paramMessageForQQWalletMsg.f();
      paramMessageForQQWalletMsg.h();
      return;
    }
    catch (Throwable paramMessageForQQWalletMsg) {}
  }
  
  public boolean a(FrameLayout paramFrameLayout, RedPackGrapInfo paramRedPackGrapInfo, QQWalletHbItemApiImpl.HbItemClickListener paramHbItemClickListener)
  {
    if (paramFrameLayout == null) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplQQWalletHbItemApiImpl.setHbItemClickListener(paramHbItemClickListener);
    paramFrameLayout = (RelativeLayout)paramFrameLayout.findViewById(R.id.bs);
    if (paramFrameLayout == null) {
      return false;
    }
    if ((MessageForQQWalletMsg)paramFrameLayout.getTag() == null) {
      return false;
    }
    paramHbItemClickListener = this.jdField_a_of_type_AndroidContentContext;
    if (paramHbItemClickListener != null) {
      paramHbItemClickListener.getString(R.string.dj);
    }
    return this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplQQWalletHbItemApiImpl.setHbOnClickListener(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, this.jdField_a_of_type_ComQwalletTempIBaseChatPieProxy, paramFrameLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, this.jdField_a_of_type_Int, paramRedPackGrapInfo.iSkinId, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.QQWalletTroopHbItem
 * JD-Core Version:    0.7.0.1
 */