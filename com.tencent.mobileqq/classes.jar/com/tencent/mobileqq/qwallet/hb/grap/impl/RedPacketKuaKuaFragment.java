package com.tencent.mobileqq.qwallet.hb.grap.impl;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qqpay.ui.R.color;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.impl.QQWalletHbItemApiImpl;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.PasswdRedBagInfo;
import com.tencent.mobileqq.qwallet.hb.impl.RedPacketManagerImpl;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.qqwallet.kua_kua_hb_srv.ClientAttr;
import tencent.im.qqwallet.kua_kua_hb_srv.TopicMatchRequest;

public class RedPacketKuaKuaFragment
  extends QPublicBaseFragment
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 1L;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private Handler jdField_a_of_type_AndroidOsHandler = new RedPacketKuaKuaFragment.4(this);
  private View jdField_a_of_type_AndroidViewView;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  private MessageForQQWalletMsg jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg;
  private Runnable jdField_a_of_type_JavaLangRunnable = new RedPacketKuaKuaFragment.7(this);
  private String jdField_a_of_type_JavaLangString;
  private JSONArray jdField_a_of_type_OrgJsonJSONArray;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 0L;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private long jdField_c_of_type_Long = 0L;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString = "";
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString = null;
  
  private String a()
  {
    return "{\"v\":\"5.3.1\",\"fr\":25,\"ip\":0,\"op\":35,\"w\":270,\"h\":270,\"nm\":\"预合成 3\",\"ddd\":0,\"assets\":[],\"layers\":[{\"ddd\":0,\"ind\":3,\"ty\":4,\"nm\":\"“图层 6”轮廓 4\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[135,136,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[135,135,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-71.797,0],[0,71.797],[71.797,0],[0,-71.797]],\"o\":[[71.797,0],[0,-71.797],[-71.797,0],[0,71.797]],\"v\":[[0,130],[130,0],[0,-130],[-130,0]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,0.949019670486,0.701960802078,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[135,135],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":17,\"s\":[69,69],\"e\":[75,75]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":20,\"s\":[75,75],\"e\":[100,100]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":41,\"s\":[100,100],\"e\":[104,104]},{\"t\":44}],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":19,\"s\":[75],\"e\":[10]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":39,\"s\":[10],\"e\":[0]},{\"t\":41}],\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":17,\"op\":44,\"st\":19,\"bm\":0},{\"ddd\":0,\"ind\":4,\"ty\":4,\"nm\":\"“图层 6”轮廓 3\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[135,136,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[135,135,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-71.797,0],[0,71.797],[71.797,0],[0,-71.797]],\"o\":[[71.797,0],[0,-71.797],[-71.797,0],[0,71.797]],\"v\":[[0,130],[130,0],[0,-130],[-130,0]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,0.949019670486,0.701960802078,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[135,135],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":-20,\"s\":[69,69],\"e\":[75,75]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":-17,\"s\":[75,75],\"e\":[100,100]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":4,\"s\":[100,100],\"e\":[104,104]},{\"t\":7}],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":-18,\"s\":[75],\"e\":[10]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":2,\"s\":[10],\"e\":[0]},{\"t\":4}],\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":-20,\"op\":7,\"st\":-18,\"bm\":0},{\"ddd\":0,\"ind\":5,\"ty\":4,\"nm\":\"“图层 6”轮廓 2\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[135,136,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[135,135,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-71.797,0],[0,71.797],[71.797,0],[0,-71.797]],\"o\":[[71.797,0],[0,-71.797],[-71.797,0],[0,71.797]],\"v\":[[0,130],[130,0],[0,-130],[-130,0]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,0.949019670486,0.701960802078,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[135,135],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":33,\"s\":[69,69],\"e\":[75,75]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":36,\"s\":[75,75],\"e\":[100,100]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":57,\"s\":[100,100],\"e\":[104,104]},{\"t\":60}],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":35,\"s\":[75],\"e\":[10]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":55,\"s\":[10],\"e\":[0]},{\"t\":57}],\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":33,\"op\":60,\"st\":35,\"bm\":0},{\"ddd\":0,\"ind\":6,\"ty\":4,\"nm\":\"“图层 6”轮廓\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[135,136,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[135,135,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-71.797,0],[0,71.797],[71.797,0],[0,-71.797]],\"o\":[[71.797,0],[0,-71.797],[-71.797,0],[0,71.797]],\"v\":[[0,130],[130,0],[0,-130],[-130,0]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,0.949019670486,0.701960802078,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[135,135],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":-2,\"s\":[69,69],\"e\":[75,75]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":1,\"s\":[75,75],\"e\":[100,100]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":22,\"s\":[100,100],\"e\":[104,104]},{\"t\":25}],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":0,\"s\":[75],\"e\":[10]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":20,\"s\":[10],\"e\":[0]},{\"t\":22}],\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":-2,\"op\":25,\"st\":0,\"bm\":0}],\"markers\":[]}";
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = new StringBuilder(50);
    ((StringBuilder)localObject).append("msgType=19");
    ((StringBuilder)localObject).append("&isOffline=");
    ((StringBuilder)localObject).append(false);
    long l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendByEmoji", ((StringBuilder)localObject).toString(), 0, null, SystemClock.uptimeMillis());
    IPasswdRedBagService localIPasswdRedBagService = (IPasswdRedBagService)getQBaseActivity().getAppRuntime().getRuntimeService(IPasswdRedBagService.class, "");
    localObject = localIPasswdRedBagService.getPasswdRedBagInfoById(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
    localIPasswdRedBagService.setPasswdRedBagOpen(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop);
    QWalletTools.a(getQBaseActivity().getAppRuntime(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
    Bundle localBundle = new Bundle();
    localBundle.putString("wishing", this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.jdField_a_of_type_JavaLangString);
    localBundle.putString("answer", paramString);
    localBundle.putInt("channel", 1000002);
    localBundle.putString("matchToken", this.jdField_c_of_type_JavaLangString);
    localIPasswdRedBagService.openPasswdBagByTenpay(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, (PasswdRedBagInfo)localObject, l, 1000002, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.i, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.fromHBList, localBundle);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("click open passwdredbag, isPasswdRedBagOpen=");
      paramString.append(((PasswdRedBagInfo)localObject).a);
      paramString.append(",isPasswdRedBagFinish=");
      paramString.append(((PasswdRedBagInfo)localObject).b);
      paramString.append(",isPasswdRedBagOverDue=");
      paramString.append(((PasswdRedBagInfo)localObject).a());
      QLog.d("PasswdRedBagSgervice", 2, paramString.toString());
    }
  }
  
  private void f()
  {
    label267:
    label691:
    String str;
    for (Object localObject3 = "@%s";; localObject3 = str)
    {
      try
      {
        Object localObject1 = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).ContactUtils$getBuddyNickName(getQBaseActivity().getAppRuntime(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, true);
        Object localObject5 = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).ContactUtils$getMemberDisplaynameByIstroop(((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getAppInterface(), this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin);
        Object localObject4 = localObject5;
        if (TextUtils.isEmpty((CharSequence)localObject5)) {
          localObject4 = localObject1;
        }
        ArrayList localArrayList = new ArrayList();
        if (this.jdField_d_of_type_JavaLangString == null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(QQSysFaceUtil.getFaceString(36));
          ((StringBuilder)localObject1).append(localObject4);
          ((StringBuilder)localObject1).append("，");
          this.jdField_d_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
        }
        else if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
        {
          int j = 0;
          while (j < 100)
          {
            int k = this.jdField_d_of_type_JavaLangString.indexOf("%[");
            int m = this.jdField_d_of_type_JavaLangString.indexOf("]%");
            if ((k < 0) || (m <= k)) {
              break;
            }
            try
            {
              i = Integer.valueOf(this.jdField_d_of_type_JavaLangString.substring(k + 2, m)).intValue();
              try
              {
                boolean bool = QQSysFaceUtil.isValidFaceId(i);
                if (bool) {
                  break label267;
                }
                i = 36;
              }
              catch (Throwable localThrowable1) {}
              localThrowable2.printStackTrace();
            }
            catch (Throwable localThrowable2)
            {
              i = 36;
            }
            this.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString.replace(this.jdField_d_of_type_JavaLangString.substring(k, m + 2), QQSysFaceUtil.getFaceString(i));
            j += 1;
          }
          int i = this.jdField_d_of_type_JavaLangString.lastIndexOf("@%s");
          if (i >= 0)
          {
            localObject5 = this.jdField_d_of_type_JavaLangString.substring(0, this.jdField_d_of_type_JavaLangString.lastIndexOf("@%s"));
            localObject2 = localObject3;
            localObject3 = localObject5;
          }
          else
          {
            if (this.jdField_d_of_type_JavaLangString.lastIndexOf("＠%s") < 0) {
              break label691;
            }
            localObject3 = this.jdField_d_of_type_JavaLangString.substring(0, this.jdField_d_of_type_JavaLangString.lastIndexOf("＠%s"));
            localObject2 = "＠%s";
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject3 = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).AtTroopMemberSpan$createAtSpannableString(getQBaseActivity().getAppRuntime(), getQBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, localObject4, false, true, (String)localObject3, localArrayList);
            localObject5 = new StringBuilder(this.jdField_d_of_type_JavaLangString);
            ((StringBuilder)localObject5).replace(0, this.jdField_d_of_type_JavaLangString.lastIndexOf((String)localObject2) + ((String)localObject2).length(), (String)localObject3);
            this.jdField_d_of_type_JavaLangString = ((StringBuilder)localObject5).toString();
          }
          this.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString.replace("%s", localObject4);
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.jdField_d_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
        localObject2 = ((StringBuilder)localObject2).toString();
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int != 3000)) {
          ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).ChatActivityFacade$sendMessage(getQBaseActivity().getAppRuntime(), getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, (String)localObject2, null);
        } else {
          ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).ChatActivityFacade$sendMessage(getQBaseActivity().getAppRuntime(), getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, (String)localObject2, localArrayList);
        }
        ReportController.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "kuakua.get.open", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.jdField_a_of_type_JavaLangString, "", "", "");
        e();
        return;
      }
      catch (Throwable localThrowable3)
      {
        localThrowable3.printStackTrace();
        return;
      }
      str = "";
    }
  }
  
  public kua_kua_hb_srv.TopicMatchRequest a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg;
    if ((localObject != null) && (((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg != null))
    {
      localObject = new kua_kua_hb_srv.TopicMatchRequest();
      ((kua_kua_hb_srv.TopicMatchRequest)localObject).clientAttr.osType.set(0L);
      ((kua_kua_hb_srv.TopicMatchRequest)localObject).clientAttr.qqVer.set("8.7.0");
      ((kua_kua_hb_srv.TopicMatchRequest)localObject).clientAttr.skeyType.set(2L);
      if (!TextUtils.isEmpty(paramString1)) {
        ((kua_kua_hb_srv.TopicMatchRequest)localObject).clientAttr.skey.set(paramString1);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.jdField_a_of_type_JavaLangString))) {
        ((kua_kua_hb_srv.TopicMatchRequest)localObject).hbTopic.set(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.jdField_a_of_type_JavaLangString);
      }
      paramString1 = this.jdField_a_of_type_AndroidWidgetEditText;
      if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.getText().toString()))) {
        ((kua_kua_hb_srv.TopicMatchRequest)localObject).userAnswer.set(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId)) {
        ((kua_kua_hb_srv.TopicMatchRequest)localObject).hbListId.set(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        ((kua_kua_hb_srv.TopicMatchRequest)localObject).grapUin.set(paramString2);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin)) {
        ((kua_kua_hb_srv.TopicMatchRequest)localObject).sendUin.set(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin);
      }
      ((kua_kua_hb_srv.TopicMatchRequest)localObject).fromType.set(paramInt);
      if (!TextUtils.isEmpty(paramString3)) {
        ((kua_kua_hb_srv.TopicMatchRequest)localObject).groupId.set(paramString3);
      }
      return localObject;
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.makeHbExtend;
      String str1 = "";
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        str1 = new JSONObject((String)localObject1).optString("type_id");
      }
      localObject1 = RedPacketManagerImpl.getHbPannelConfig(15);
      if (localObject1 != null)
      {
        this.jdField_a_of_type_OrgJsonJSONArray = ((JSONObject)localObject1).optJSONArray("subjectList");
        int i = 0;
        try
        {
          Object localObject2;
          while (i < this.jdField_a_of_type_OrgJsonJSONArray.length())
          {
            localObject2 = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(i);
            String str2 = ((JSONObject)localObject2).optString("typeId");
            if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (str2.equals(str1)))
            {
              this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("guide");
              if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
                this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
              }
              this.jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).optString("hint");
              if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
                this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_b_of_type_JavaLangString);
              }
            }
            i += 1;
          }
          TextView localTextView;
          this.jdField_d_of_type_JavaLangString = ((JSONObject)localObject1).optString("kuaPrefix");
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          this.jdField_b_of_type_Int = ((JSONObject)localObject1).optInt("wordLimit");
          if (this.jdField_b_of_type_Int > 0)
          {
            localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("0/");
            ((StringBuilder)localObject2).append(this.jdField_b_of_type_Int);
            localTextView.setText(((StringBuilder)localObject2).toString());
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.jdField_b_of_type_Int) });
          }
          else
          {
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          this.jdField_a_of_type_Long = ((JSONObject)localObject1).optLong("matchDelay");
          if (this.jdField_a_of_type_Long <= 0L) {
            this.jdField_a_of_type_Long = 1L;
          }
          if (!((JSONObject)localObject1).has("kuaPrefix")) {
            return;
          }
        }
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void a(View paramView)
  {
    ((LinearLayout)getQBaseActivity().findViewById(R.id.G)).setOnClickListener(new RedPacketKuaKuaFragment.1(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)getQBaseActivity().findViewById(R.id.cH));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)getQBaseActivity().findViewById(R.id.cG));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)getQBaseActivity().findViewById(R.id.cB));
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)getQBaseActivity().findViewById(R.id.cC));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)getQBaseActivity().findViewById(R.id.cF));
    this.jdField_b_of_type_AndroidViewView = getQBaseActivity().findViewById(R.id.am);
    this.jdField_a_of_type_AndroidViewView = getQBaseActivity().findViewById(R.id.l);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)getQBaseActivity().findViewById(R.id.al));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)getQBaseActivity().findViewById(R.id.bI));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(R.id.i));
    QWalletTools.a(this.jdField_a_of_type_AndroidWidgetButton, 0.3F);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  protected void a(ImageView paramImageView)
  {
    String str = a();
    try
    {
      if ((!TextUtils.isEmpty(str)) && (paramImageView != null))
      {
        LottieComposition.Factory.fromJsonString(str, new RedPacketKuaKuaFragment.5(this, paramImageView));
        return;
      }
    }
    catch (Throwable paramImageView)
    {
      paramImageView.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(R.color.h));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(R.drawable.S);
    this.jdField_a_of_type_AndroidViewView.setAlpha(0.5F);
    this.jdField_b_of_type_AndroidViewView.setAlpha(0.5F);
    b(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidViewView.setClickable(false);
    d();
  }
  
  protected boolean a()
  {
    Object localObject = getArguments();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = ((BaseSessionInfo)((Bundle)localObject).getParcelable("session"));
      long l = ((Bundle)localObject).getLong("uniseq", 0L);
      this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("fromHBList", 0);
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = QQWalletHbItemApiImpl.getMessageForQQWalletMsg(((Bundle)localObject).getString("redPacketId"));
      }
      else
      {
        localObject = ((IMessageFacade)getQBaseActivity().getAppRuntime().getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, l);
        if ((localObject instanceof MessageForQQWalletMsg)) {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = ((MessageForQQWalletMsg)localObject);
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg != null))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem == null) {
          return false;
        }
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("【");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("】");
        ((TextView)localObject).setText(localStringBuilder.toString());
        a();
        this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new RedPacketKuaKuaFragment.2(this));
      }
      else
      {
        return false;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      ThreadManager.getSubThreadHandler().post(new RedPacketKuaKuaFragment.3(this));
    }
    return true;
  }
  
  public void b()
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(R.color.i));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(R.string.bl));
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(R.drawable.Q);
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    this.jdField_b_of_type_AndroidViewView.setAlpha(1.0F);
    a(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidViewView.setClickable(true);
    c();
    InputMethodManager localInputMethodManager = this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(getQBaseActivity().getWindow().getDecorView().getWindowToken(), 0);
    }
  }
  
  protected void b(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      paramImageView = paramImageView.getDrawable();
      if ((paramImageView instanceof LottieDrawable)) {
        ((LottieDrawable)paramImageView).stop();
      }
    }
  }
  
  public boolean b()
  {
    return (getQBaseActivity() == null) || (getQBaseActivity().isFinishing());
  }
  
  protected void c()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    int i = DisplayUtil.a(getQBaseActivity(), 75.0F);
    int j = DisplayUtil.a(getQBaseActivity(), 75.0F);
    this.jdField_b_of_type_AndroidViewView.setPivotX(i / 2);
    this.jdField_b_of_type_AndroidViewView.setPivotY(j / 2 + DisplayUtil.a(getQBaseActivity(), 15.0F));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "rotation", new float[] { -5.0F, 20.0F });
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(200L);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setRepeatMode(2);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new RedPacketKuaKuaFragment.6(this));
  }
  
  protected void d()
  {
    ObjectAnimator localObjectAnimator = this.jdField_a_of_type_AndroidAnimationObjectAnimator;
    if ((localObjectAnimator != null) && (localObjectAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
    }
  }
  
  public void e()
  {
    if (getQBaseActivity() != null) {
      getQBaseActivity().finish();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.i)
    {
      e();
      return;
    }
    if (i == R.id.bI)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      ReportController.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "kuakua.get.cancel", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.jdField_a_of_type_JavaLangString, "", "", "");
      return;
    }
    if (i == R.id.l)
    {
      paramView = this.jdField_a_of_type_AndroidWidgetEditText;
      if (paramView != null)
      {
        if (TextUtils.isEmpty(paramView.getText().toString())) {
          return;
        }
        if (b())
        {
          if (QLog.isColorLevel()) {
            QLog.i("RedPacketKuaKuaFragment", 2, "getActivity() == null || getActivity().isFinishing()");
          }
          return;
        }
        b(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
        f();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    try
    {
      paramLayoutInflater = paramLayoutInflater.inflate(R.layout.v, paramViewGroup, false);
      return paramLayoutInflater;
    }
    catch (Throwable paramLayoutInflater)
    {
      paramLayoutInflater.printStackTrace();
      e();
    }
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null)
    {
      localObject = ((ImageView)localObject).getDrawable();
      if ((localObject instanceof LottieDrawable)) {
        ((LottieDrawable)localObject).recycleBitmaps();
      }
    }
    d();
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    try
    {
      paramBundle = getQBaseActivity();
      getQBaseActivity();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)paramBundle.getSystemService("input_method"));
      getQBaseActivity().getWindow().setSoftInputMode(5);
      a(paramView);
      if (!a())
      {
        e();
        return;
      }
    }
    catch (Throwable paramView)
    {
      QLog.e("RedPacketKuaKuaFragment", 1, paramView, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketKuaKuaFragment
 * JD-Core Version:    0.7.0.1
 */