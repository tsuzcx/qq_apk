package com.tencent.mobileqq.qwallet.hb.grap.impl;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qqpay.ui.R.color;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.aio.impl.QQWalletHbItemApiImpl;
import com.tencent.mobileqq.qwallet.widget.ImmersionBar;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import mqq.app.AppRuntime;

public class RedPacketPopFragment
  extends QPublicBaseFragment
  implements View.OnClickListener
{
  protected ImageButton a;
  protected RelativeLayout a;
  protected BaseSessionInfo a;
  protected MessageForQQWalletMsg a;
  protected RoundImageView a;
  int c;
  protected View c;
  protected View d;
  protected TextView d;
  protected View e;
  protected ImageView e;
  protected boolean e;
  protected ImageView f;
  
  public RedPacketPopFragment()
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = true;
  }
  
  private String a()
  {
    return "{\"v\":\"5.3.1\",\"fr\":25,\"ip\":0,\"op\":35,\"w\":270,\"h\":270,\"nm\":\"预合成 3\",\"ddd\":0,\"assets\":[],\"layers\":[{\"ddd\":0,\"ind\":3,\"ty\":4,\"nm\":\"“图层 6”轮廓 4\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[135,136,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[135,135,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-71.797,0],[0,71.797],[71.797,0],[0,-71.797]],\"o\":[[71.797,0],[0,-71.797],[-71.797,0],[0,71.797]],\"v\":[[0,130],[130,0],[0,-130],[-130,0]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,0.949019670486,0.701960802078,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[135,135],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":17,\"s\":[69,69],\"e\":[75,75]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":20,\"s\":[75,75],\"e\":[100,100]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":41,\"s\":[100,100],\"e\":[104,104]},{\"t\":44}],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":19,\"s\":[75],\"e\":[10]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":39,\"s\":[10],\"e\":[0]},{\"t\":41}],\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":17,\"op\":44,\"st\":19,\"bm\":0},{\"ddd\":0,\"ind\":4,\"ty\":4,\"nm\":\"“图层 6”轮廓 3\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[135,136,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[135,135,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-71.797,0],[0,71.797],[71.797,0],[0,-71.797]],\"o\":[[71.797,0],[0,-71.797],[-71.797,0],[0,71.797]],\"v\":[[0,130],[130,0],[0,-130],[-130,0]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,0.949019670486,0.701960802078,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[135,135],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":-20,\"s\":[69,69],\"e\":[75,75]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":-17,\"s\":[75,75],\"e\":[100,100]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":4,\"s\":[100,100],\"e\":[104,104]},{\"t\":7}],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":-18,\"s\":[75],\"e\":[10]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":2,\"s\":[10],\"e\":[0]},{\"t\":4}],\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":-20,\"op\":7,\"st\":-18,\"bm\":0},{\"ddd\":0,\"ind\":5,\"ty\":4,\"nm\":\"“图层 6”轮廓 2\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[135,136,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[135,135,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-71.797,0],[0,71.797],[71.797,0],[0,-71.797]],\"o\":[[71.797,0],[0,-71.797],[-71.797,0],[0,71.797]],\"v\":[[0,130],[130,0],[0,-130],[-130,0]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,0.949019670486,0.701960802078,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[135,135],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":33,\"s\":[69,69],\"e\":[75,75]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":36,\"s\":[75,75],\"e\":[100,100]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":57,\"s\":[100,100],\"e\":[104,104]},{\"t\":60}],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":35,\"s\":[75],\"e\":[10]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":55,\"s\":[10],\"e\":[0]},{\"t\":57}],\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":33,\"op\":60,\"st\":35,\"bm\":0},{\"ddd\":0,\"ind\":6,\"ty\":4,\"nm\":\"“图层 6”轮廓\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[135,136,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[135,135,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-71.797,0],[0,71.797],[71.797,0],[0,-71.797]],\"o\":[[71.797,0],[0,-71.797],[-71.797,0],[0,71.797]],\"v\":[[0,130],[130,0],[0,-130],[-130,0]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,0.949019670486,0.701960802078,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[135,135],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":-2,\"s\":[69,69],\"e\":[75,75]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":1,\"s\":[75,75],\"e\":[100,100]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":22,\"s\":[100,100],\"e\":[104,104]},{\"t\":25}],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":0,\"s\":[75],\"e\":[10]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":20,\"s\":[10],\"e\":[0]},{\"t\":22}],\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":-2,\"op\":25,\"st\":0,\"bm\":0}],\"markers\":[]}";
  }
  
  private void a()
  {
    this.jdField_c_of_type_AndroidViewView.post(new RedPacketPopFragment.1(this));
  }
  
  public void a(Context paramContext)
  {
    if (((paramContext instanceof Activity)) && ((paramContext == null) || (((Activity)paramContext).isFinishing())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedPacketPopFragment", 2, "showAbnormalRecordDlg failed, mContext not valid");
      }
      return;
    }
    Object localObject = Build.MANUFACTURER;
    int i;
    if (((String)localObject).equalsIgnoreCase("meizu")) {
      i = R.string.ah;
    } else if (((String)localObject).equalsIgnoreCase("xiaomi")) {
      i = R.string.aj;
    } else if (((String)localObject).equalsIgnoreCase("vivo")) {
      i = R.string.ai;
    } else {
      i = R.string.ag;
    }
    try
    {
      localObject = new SpannableString(paramContext.getString(i));
      DialogUtil.a(paramContext, 230, HardCodeUtil.a(R.string.cA), ((SpannableString)localObject).toString(), HardCodeUtil.a(R.string.cb), "", null, new RedPacketPopFragment.2(this)).show();
      return;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("show showAbnormalRecordDlg error : ");
        ((StringBuilder)localObject).append(paramContext.getMessage());
        QLog.d("RedPacketPopFragment", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  protected void a(View paramView)
  {
    new ImmersionBar(getQBaseActivity(), 0, paramView.findViewById(R.id.bX));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(R.id.e);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(R.id.aU);
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(R.id.r));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(R.id.s));
    this.f = ((ImageView)paramView.findViewById(R.id.ae));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(R.id.bb));
    this.jdField_e_of_type_AndroidViewView = paramView.findViewById(R.id.bc);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(R.id.aL));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)paramView.findViewById(R.id.aV));
  }
  
  protected void a(ImageView paramImageView)
  {
    String str = a();
    if ((!TextUtils.isEmpty(str)) && (paramImageView != null)) {
      LottieComposition.Factory.fromJsonString(str, new RedPacketPopFragment.3(this, paramImageView));
    }
  }
  
  protected boolean a()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageDrawable(getResources().getDrawable(R.drawable.s));
    }
    catch (Throwable localThrowable)
    {
      label20:
      Object localObject1;
      Object localObject2;
      break label20;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setBackgroundColor(getResources().getColor(R.color.b));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    AccessibilityUtil.a(this.jdField_e_of_type_AndroidWidgetImageView, getQBaseActivity().getResources().getString(R.string.o), null);
    AccessibilityUtil.a(this.jdField_a_of_type_AndroidWidgetImageButton, getQBaseActivity().getResources().getString(R.string.o), null);
    if (((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).isCanShowNewCloseBtn(getQBaseActivity()))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    else
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
    localObject1 = getArguments();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = ((BaseSessionInfo)((Bundle)localObject1).getParcelable("session"));
      long l = ((Bundle)localObject1).getLong("uniseq", 0L);
      this.jdField_c_of_type_Int = ((Bundle)localObject1).getInt("fromHBList", 0);
      if (this.jdField_c_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = QQWalletHbItemApiImpl.getMessageForQQWalletMsg(((Bundle)localObject1).getString("redPacketId"));
      }
      else
      {
        localObject1 = ((IMessageFacade)QWalletHelperImpl.getAppRuntime().getRuntimeService(IMessageFacade.class, "all")).queryMsgItemByUniseq(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, l);
        if ((localObject1 instanceof MessageForQQWalletMsg)) {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = ((MessageForQQWalletMsg)localObject1);
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null) {
      return false;
    }
    localObject2 = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getAppInterface();
    if (localObject2 != null)
    {
      localObject2 = FaceDrawable.getUserFaceDrawable((AppInterface)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, (byte)4);
      this.f.setImageDrawable((Drawable)localObject2);
    }
    return true;
  }
  
  protected void b(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      paramImageView = paramImageView.getDrawable();
      if ((paramImageView instanceof LottieDrawable)) {
        ((LottieDrawable)paramImageView).recycleBitmaps();
      }
    }
  }
  
  protected boolean b()
  {
    return true;
  }
  
  public boolean d()
  {
    return (getQBaseActivity() == null) || (getQBaseActivity().isFinishing());
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void o()
  {
    if (getQBaseActivity() != null) {
      getQBaseActivity().finish();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.e)
    {
      if (!b()) {
        return;
      }
      this.jdField_e_of_type_Boolean = false;
      getQBaseActivity().doOnBackPressed();
      return;
    }
    if ((i == R.id.r) || (i == R.id.s))
    {
      this.jdField_e_of_type_Boolean = false;
      getQBaseActivity().doOnBackPressed();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    try
    {
      paramLayoutInflater = paramLayoutInflater.inflate(R.layout.u, paramViewGroup, false);
      return paramLayoutInflater;
    }
    catch (Throwable paramLayoutInflater)
    {
      paramLayoutInflater.printStackTrace();
      getQBaseActivity().finish();
    }
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    try
    {
      a(paramView);
      if (!a()) {
        getQBaseActivity().finish();
      }
      a();
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("RedPacketPopFragment", 1, paramView, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketPopFragment
 * JD-Core Version:    0.7.0.1
 */