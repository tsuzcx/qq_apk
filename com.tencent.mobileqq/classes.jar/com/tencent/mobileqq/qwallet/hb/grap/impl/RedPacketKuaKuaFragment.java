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
  private BaseSessionInfo a;
  private MessageForQQWalletMsg b;
  private int c = 0;
  private Button d;
  private TextView e;
  private TextView f;
  private EditText g;
  private TextView h;
  private TextView i;
  private Button j;
  private View k;
  private ImageView l;
  private View m;
  private ObjectAnimator n;
  private String o;
  private String p;
  private JSONArray q;
  private int r;
  private long s = 1L;
  private long t = 0L;
  private long u = 0L;
  private String v = "";
  private String w = null;
  private InputMethodManager x;
  private Handler y = new RedPacketKuaKuaFragment.4(this);
  private Runnable z = new RedPacketKuaKuaFragment.7(this);
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = new StringBuilder(50);
    ((StringBuilder)localObject).append("msgType=19");
    ((StringBuilder)localObject).append("&isOffline=");
    ((StringBuilder)localObject).append(false);
    long l1 = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendByEmoji", ((StringBuilder)localObject).toString(), 0, null, SystemClock.uptimeMillis());
    IPasswdRedBagService localIPasswdRedBagService = (IPasswdRedBagService)getQBaseActivity().getAppRuntime().getRuntimeService(IPasswdRedBagService.class, "");
    localObject = localIPasswdRedBagService.getPasswdRedBagInfoById(this.b.mQQWalletRedPacketMsg.redPacketId);
    localIPasswdRedBagService.setPasswdRedBagOpen(this.b.mQQWalletRedPacketMsg.redPacketId, this.b.frienduin, this.b.istroop);
    QWalletTools.a(getQBaseActivity().getAppRuntime(), this.b);
    Bundle localBundle = new Bundle();
    localBundle.putString("wishing", this.b.mQQWalletRedPacketMsg.elem.c);
    localBundle.putString("answer", paramString);
    localBundle.putInt("channel", 1000002);
    localBundle.putString("matchToken", this.v);
    localIPasswdRedBagService.openPasswdBagByTenpay(this.a, (PasswdRedBagInfo)localObject, l1, 1000002, "", this.b.mQQWalletRedPacketMsg.elem.v, this.b.fromHBList, localBundle);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("click open passwdredbag, isPasswdRedBagOpen=");
      paramString.append(((PasswdRedBagInfo)localObject).f);
      paramString.append(",isPasswdRedBagFinish=");
      paramString.append(((PasswdRedBagInfo)localObject).g);
      paramString.append(",isPasswdRedBagOverDue=");
      paramString.append(((PasswdRedBagInfo)localObject).a());
      QLog.d("PasswdRedBagSgervice", 2, paramString.toString());
    }
  }
  
  private String h()
  {
    return "{\"v\":\"5.3.1\",\"fr\":25,\"ip\":0,\"op\":35,\"w\":270,\"h\":270,\"nm\":\"预合成 3\",\"ddd\":0,\"assets\":[],\"layers\":[{\"ddd\":0,\"ind\":3,\"ty\":4,\"nm\":\"“图层 6”轮廓 4\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[135,136,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[135,135,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-71.797,0],[0,71.797],[71.797,0],[0,-71.797]],\"o\":[[71.797,0],[0,-71.797],[-71.797,0],[0,71.797]],\"v\":[[0,130],[130,0],[0,-130],[-130,0]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,0.949019670486,0.701960802078,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[135,135],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":17,\"s\":[69,69],\"e\":[75,75]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":20,\"s\":[75,75],\"e\":[100,100]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":41,\"s\":[100,100],\"e\":[104,104]},{\"t\":44}],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":19,\"s\":[75],\"e\":[10]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":39,\"s\":[10],\"e\":[0]},{\"t\":41}],\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":17,\"op\":44,\"st\":19,\"bm\":0},{\"ddd\":0,\"ind\":4,\"ty\":4,\"nm\":\"“图层 6”轮廓 3\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[135,136,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[135,135,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-71.797,0],[0,71.797],[71.797,0],[0,-71.797]],\"o\":[[71.797,0],[0,-71.797],[-71.797,0],[0,71.797]],\"v\":[[0,130],[130,0],[0,-130],[-130,0]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,0.949019670486,0.701960802078,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[135,135],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":-20,\"s\":[69,69],\"e\":[75,75]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":-17,\"s\":[75,75],\"e\":[100,100]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":4,\"s\":[100,100],\"e\":[104,104]},{\"t\":7}],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":-18,\"s\":[75],\"e\":[10]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":2,\"s\":[10],\"e\":[0]},{\"t\":4}],\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":-20,\"op\":7,\"st\":-18,\"bm\":0},{\"ddd\":0,\"ind\":5,\"ty\":4,\"nm\":\"“图层 6”轮廓 2\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[135,136,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[135,135,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-71.797,0],[0,71.797],[71.797,0],[0,-71.797]],\"o\":[[71.797,0],[0,-71.797],[-71.797,0],[0,71.797]],\"v\":[[0,130],[130,0],[0,-130],[-130,0]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,0.949019670486,0.701960802078,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[135,135],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":33,\"s\":[69,69],\"e\":[75,75]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":36,\"s\":[75,75],\"e\":[100,100]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":57,\"s\":[100,100],\"e\":[104,104]},{\"t\":60}],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":35,\"s\":[75],\"e\":[10]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":55,\"s\":[10],\"e\":[0]},{\"t\":57}],\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":33,\"op\":60,\"st\":35,\"bm\":0},{\"ddd\":0,\"ind\":6,\"ty\":4,\"nm\":\"“图层 6”轮廓\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[135,136,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[135,135,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-71.797,0],[0,71.797],[71.797,0],[0,-71.797]],\"o\":[[71.797,0],[0,-71.797],[-71.797,0],[0,71.797]],\"v\":[[0,130],[130,0],[0,-130],[-130,0]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,0.949019670486,0.701960802078,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[135,135],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":-2,\"s\":[69,69],\"e\":[75,75]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":1,\"s\":[75,75],\"e\":[100,100]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":22,\"s\":[100,100],\"e\":[104,104]},{\"t\":25}],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":0,\"s\":[75],\"e\":[10]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":20,\"s\":[10],\"e\":[0]},{\"t\":22}],\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":-2,\"op\":25,\"st\":0,\"bm\":0}],\"markers\":[]}";
  }
  
  private void i()
  {
    label270:
    label699:
    String str;
    for (Object localObject3 = "@%s";; localObject3 = str)
    {
      try
      {
        Object localObject1 = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).ContactUtils$getBuddyNickName(getQBaseActivity().getAppRuntime(), this.b.senderuin, true);
        Object localObject5 = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).ContactUtils$getMemberDisplaynameByIstroop(((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getAppInterface(), this.a.a, this.a.b, this.b.senderuin);
        Object localObject4 = localObject5;
        if (TextUtils.isEmpty((CharSequence)localObject5)) {
          localObject4 = localObject1;
        }
        ArrayList localArrayList = new ArrayList();
        if (this.w == null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(QQSysFaceUtil.getFaceString(36));
          ((StringBuilder)localObject1).append(localObject4);
          ((StringBuilder)localObject1).append("，");
          this.w = ((StringBuilder)localObject1).toString();
        }
        else if (!TextUtils.isEmpty(this.w))
        {
          int i2 = 0;
          while (i2 < 100)
          {
            int i3 = this.w.indexOf("%[");
            int i4 = this.w.indexOf("]%");
            if ((i3 < 0) || (i4 <= i3)) {
              break;
            }
            try
            {
              i1 = Integer.valueOf(this.w.substring(i3 + 2, i4)).intValue();
              try
              {
                boolean bool = QQSysFaceUtil.isValidFaceId(i1);
                if (bool) {
                  break label270;
                }
                i1 = 36;
              }
              catch (Throwable localThrowable1) {}
              localThrowable2.printStackTrace();
            }
            catch (Throwable localThrowable2)
            {
              i1 = 36;
            }
            this.w = this.w.replace(this.w.substring(i3, i4 + 2), QQSysFaceUtil.getFaceString(i1));
            i2 += 1;
          }
          int i1 = this.w.lastIndexOf("@%s");
          if (i1 >= 0)
          {
            localObject5 = this.w.substring(0, this.w.lastIndexOf("@%s"));
            localObject2 = localObject3;
            localObject3 = localObject5;
          }
          else
          {
            if (this.w.lastIndexOf("＠%s") < 0) {
              break label699;
            }
            localObject3 = this.w.substring(0, this.w.lastIndexOf("＠%s"));
            localObject2 = "＠%s";
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject3 = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).AtTroopMemberSpan$createAtSpannableString(getQBaseActivity().getAppRuntime(), getQBaseActivity(), this.b.frienduin, this.b.senderuin, localObject4, false, true, (String)localObject3, localArrayList);
            localObject5 = new StringBuilder(this.w);
            ((StringBuilder)localObject5).replace(0, this.w.lastIndexOf((String)localObject2) + ((String)localObject2).length(), (String)localObject3);
            this.w = ((StringBuilder)localObject5).toString();
          }
          this.w = this.w.replace("%s", localObject4);
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.w);
        ((StringBuilder)localObject2).append(this.g.getText().toString());
        localObject2 = ((StringBuilder)localObject2).toString();
        if ((this.a.a != 1) && (this.a.a != 3000)) {
          ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).ChatActivityFacade$sendMessage(getQBaseActivity().getAppRuntime(), getActivity(), this.a, (String)localObject2, null);
        } else {
          ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).ChatActivityFacade$sendMessage(getQBaseActivity().getAppRuntime(), getActivity(), this.a, (String)localObject2, localArrayList);
        }
        ReportController.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "kuakua.get.open", 0, 0, this.b.mQQWalletRedPacketMsg.elem.c, "", "", "");
        g();
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
    Object localObject = this.b;
    if ((localObject != null) && (((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg != null))
    {
      localObject = new kua_kua_hb_srv.TopicMatchRequest();
      ((kua_kua_hb_srv.TopicMatchRequest)localObject).clientAttr.osType.set(0L);
      ((kua_kua_hb_srv.TopicMatchRequest)localObject).clientAttr.qqVer.set("8.8.17");
      ((kua_kua_hb_srv.TopicMatchRequest)localObject).clientAttr.skeyType.set(2L);
      if (!TextUtils.isEmpty(paramString1)) {
        ((kua_kua_hb_srv.TopicMatchRequest)localObject).clientAttr.skey.set(paramString1);
      }
      if ((this.b.mQQWalletRedPacketMsg.elem != null) && (!TextUtils.isEmpty(this.b.mQQWalletRedPacketMsg.elem.c))) {
        ((kua_kua_hb_srv.TopicMatchRequest)localObject).hbTopic.set(this.b.mQQWalletRedPacketMsg.elem.c);
      }
      paramString1 = this.g;
      if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.getText().toString()))) {
        ((kua_kua_hb_srv.TopicMatchRequest)localObject).userAnswer.set(this.g.getText().toString());
      }
      if (!TextUtils.isEmpty(this.b.mQQWalletRedPacketMsg.redPacketId)) {
        ((kua_kua_hb_srv.TopicMatchRequest)localObject).hbListId.set(this.b.mQQWalletRedPacketMsg.redPacketId);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        ((kua_kua_hb_srv.TopicMatchRequest)localObject).grapUin.set(paramString2);
      }
      if (!TextUtils.isEmpty(this.b.senderuin)) {
        ((kua_kua_hb_srv.TopicMatchRequest)localObject).sendUin.set(this.b.senderuin);
      }
      ((kua_kua_hb_srv.TopicMatchRequest)localObject).fromType.set(paramInt);
      if (!TextUtils.isEmpty(paramString3)) {
        ((kua_kua_hb_srv.TopicMatchRequest)localObject).groupId.set(paramString3);
      }
      return localObject;
    }
    return null;
  }
  
  protected void a(View paramView)
  {
    ((LinearLayout)getQBaseActivity().findViewById(R.id.L)).setOnClickListener(new RedPacketKuaKuaFragment.1(this));
    this.e = ((TextView)getQBaseActivity().findViewById(R.id.cY));
    this.f = ((TextView)getQBaseActivity().findViewById(R.id.cX));
    this.g = ((EditText)getQBaseActivity().findViewById(R.id.cS));
    this.g.requestFocus();
    this.h = ((TextView)getQBaseActivity().findViewById(R.id.cT));
    this.i = ((TextView)getQBaseActivity().findViewById(R.id.cW));
    this.m = getQBaseActivity().findViewById(R.id.at);
    this.k = getQBaseActivity().findViewById(R.id.q);
    this.k.setOnClickListener(this);
    this.l = ((ImageView)getQBaseActivity().findViewById(R.id.as));
    this.j = ((Button)getQBaseActivity().findViewById(R.id.bU));
    this.j.setOnClickListener(this);
    this.d = ((Button)paramView.findViewById(R.id.n));
    QWalletTools.a(this.d, 0.3F);
    this.d.setOnClickListener(this);
  }
  
  protected void a(ImageView paramImageView)
  {
    String str = h();
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
    this.i.setTextColor(getResources().getColor(R.color.h));
    this.i.setText(paramString);
    this.m.setBackgroundResource(R.drawable.T);
    this.k.setAlpha(0.5F);
    this.m.setAlpha(0.5F);
    b(this.l);
    this.k.setClickable(false);
    e();
  }
  
  protected boolean a()
  {
    Object localObject = getArguments();
    try
    {
      this.a = ((BaseSessionInfo)((Bundle)localObject).getParcelable("session"));
      long l1 = ((Bundle)localObject).getLong("uniseq", 0L);
      this.c = ((Bundle)localObject).getInt("fromHBList", 0);
      if (this.c == 1)
      {
        this.b = QQWalletHbItemApiImpl.getMessageForQQWalletMsg(((Bundle)localObject).getString("redPacketId"));
      }
      else
      {
        localObject = ((IMessageFacade)getQBaseActivity().getAppRuntime().getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(this.a.b, this.a.a, l1);
        if ((localObject instanceof MessageForQQWalletMsg)) {
          this.b = ((MessageForQQWalletMsg)localObject);
        }
      }
      if ((this.b != null) && (this.b.mQQWalletRedPacketMsg != null))
      {
        if (this.b.mQQWalletRedPacketMsg.elem == null) {
          return false;
        }
        localObject = this.e;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("【");
        localStringBuilder.append(this.b.mQQWalletRedPacketMsg.elem.c);
        localStringBuilder.append("】");
        ((TextView)localObject).setText(localStringBuilder.toString());
        b();
        this.g.addTextChangedListener(new RedPacketKuaKuaFragment.2(this));
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
    try
    {
      Object localObject1 = this.b.mQQWalletRedPacketMsg.body.makeHbExtend;
      String str1 = "";
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        str1 = new JSONObject((String)localObject1).optString("type_id");
      }
      localObject1 = RedPacketManagerImpl.getHbPannelConfig(15);
      if (localObject1 != null)
      {
        this.q = ((JSONObject)localObject1).optJSONArray("subjectList");
        int i1 = 0;
        try
        {
          Object localObject2;
          while (i1 < this.q.length())
          {
            localObject2 = this.q.getJSONObject(i1);
            String str2 = ((JSONObject)localObject2).optString("typeId");
            if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (str2.equals(str1)))
            {
              this.o = ((JSONObject)localObject2).optString("guide");
              if (!TextUtils.isEmpty(this.o)) {
                this.f.setText(this.o);
              }
              this.p = ((JSONObject)localObject2).optString("hint");
              if (!TextUtils.isEmpty(this.p)) {
                this.g.setHint(this.p);
              }
            }
            i1 += 1;
          }
          TextView localTextView;
          this.w = ((JSONObject)localObject1).optString("kuaPrefix");
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          this.r = ((JSONObject)localObject1).optInt("wordLimit");
          if (this.r > 0)
          {
            localTextView = this.h;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("0/");
            ((StringBuilder)localObject2).append(this.r);
            localTextView.setText(((StringBuilder)localObject2).toString());
            this.h.setVisibility(0);
            this.g.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.r) });
          }
          else
          {
            this.h.setVisibility(8);
          }
          this.s = ((JSONObject)localObject1).optLong("matchDelay");
          if (this.s <= 0L) {
            this.s = 1L;
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
  
  public void c()
  {
    this.i.setTextColor(getResources().getColor(R.color.i));
    this.i.setText(HardCodeUtil.a(R.string.bp));
    this.m.setBackgroundResource(R.drawable.R);
    this.k.setAlpha(1.0F);
    this.m.setAlpha(1.0F);
    a(this.l);
    this.k.setClickable(true);
    d();
    InputMethodManager localInputMethodManager = this.x;
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(getQBaseActivity().getWindow().getDecorView().getWindowToken(), 0);
    }
  }
  
  protected void d()
  {
    if (this.m == null) {
      return;
    }
    int i1 = DisplayUtil.a(getQBaseActivity(), 75.0F);
    int i2 = DisplayUtil.a(getQBaseActivity(), 75.0F);
    this.m.setPivotX(i1 / 2);
    this.m.setPivotY(i2 / 2 + DisplayUtil.a(getQBaseActivity(), 15.0F));
    this.n = ObjectAnimator.ofFloat(this.m, "rotation", new float[] { -5.0F, 20.0F });
    this.n.setDuration(200L);
    this.n.setRepeatMode(2);
    this.n.setRepeatCount(-1);
    this.n.setInterpolator(new AccelerateDecelerateInterpolator());
    this.n.start();
    this.n.addListener(new RedPacketKuaKuaFragment.6(this));
  }
  
  protected void e()
  {
    ObjectAnimator localObjectAnimator = this.n;
    if ((localObjectAnimator != null) && (localObjectAnimator.isRunning())) {
      this.n.cancel();
    }
  }
  
  public boolean f()
  {
    return (getQBaseActivity() == null) || (getQBaseActivity().isFinishing());
  }
  
  public void g()
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
    int i1 = paramView.getId();
    if (i1 == R.id.n)
    {
      g();
      return;
    }
    if (i1 == R.id.bU)
    {
      this.g.setText("");
      ReportController.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "kuakua.get.cancel", 0, 0, this.b.mQQWalletRedPacketMsg.elem.c, "", "", "");
      return;
    }
    if (i1 == R.id.q)
    {
      paramView = this.g;
      if (paramView != null)
      {
        if (TextUtils.isEmpty(paramView.getText().toString())) {
          return;
        }
        if (f())
        {
          if (QLog.isColorLevel()) {
            QLog.i("RedPacketKuaKuaFragment", 2, "getActivity() == null || getActivity().isFinishing()");
          }
          return;
        }
        b(this.g.getText().toString());
        i();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    try
    {
      paramLayoutInflater = paramLayoutInflater.inflate(R.layout.y, paramViewGroup, false);
      return paramLayoutInflater;
    }
    catch (Throwable paramLayoutInflater)
    {
      paramLayoutInflater.printStackTrace();
      g();
    }
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.l;
    if (localObject != null)
    {
      localObject = ((ImageView)localObject).getDrawable();
      if ((localObject instanceof LottieDrawable)) {
        ((LottieDrawable)localObject).recycleBitmaps();
      }
    }
    e();
    localObject = this.y;
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
      this.x = ((InputMethodManager)paramBundle.getSystemService("input_method"));
      getQBaseActivity().getWindow().setSoftInputMode(5);
      a(paramView);
      if (!a())
      {
        g();
        return;
      }
    }
    catch (Throwable paramView)
    {
      QLog.e("RedPacketKuaKuaFragment", 1, paramView, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketKuaKuaFragment
 * JD-Core Version:    0.7.0.1
 */