import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.ui.RedPacketRollNumberView;
import com.tencent.av.redpacket.ui.RedPacketShareFragment;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.redbag.ResultUI.2;
import com.tencent.mobileqq.activity.PublicFragmentActivityForVideo;
import com.tencent.mobileqq.portal.StrokeTextView;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class msr
  extends mta
  implements View.OnClickListener
{
  public Bitmap a;
  public meu a;
  public msq a;
  public msx a;
  public boolean a;
  public Bitmap b;
  public boolean b;
  public Bitmap c;
  public Bitmap d;
  public Bitmap e;
  public Bitmap f;
  private Bitmap g;
  private Bitmap h;
  
  msr(mrt parammrt)
  {
    super(parammrt);
  }
  
  private String a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    paramContext = paramContext.getString(paramInt1);
    return paramContext + paramInt2 + "/" + paramInt3;
  }
  
  RelativeLayout a(AVActivity paramAVActivity)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramAVActivity.findViewById(2131375725);
    if (localRelativeLayout != null) {
      return localRelativeLayout;
    }
    paramAVActivity = (RelativeLayout)paramAVActivity.getLayoutInflater().inflate(2131559622, (RelativeLayout)paramAVActivity.findViewById(2131372566)).findViewById(2131375725);
    a(paramAVActivity);
    return paramAVActivity;
  }
  
  com.tencent.util.Pair<String, String> a(msq parammsq)
  {
    alud.a(2131713832);
    String str2;
    String str1;
    switch (parammsq.jdField_e_of_type_Int)
    {
    case 7: 
    case 9: 
    default: 
      str2 = "网络异常，\n无法领取红包。";
      str1 = "请到消息窗口点击红包补领。\n";
      str3 = str1;
      if (TextUtils.isEmpty(str1)) {
        if (!TextUtils.isEmpty(parammsq.h)) {
          break label290;
        }
      }
      break;
    }
    label290:
    for (String str3 = "请到消息窗口点击红包补领。\n";; str3 = parammsq.h)
    {
      QLog.w(this.i, 1, "getErrorTips, resultCode[" + parammsq.jdField_e_of_type_JavaLangString + "], js_state[" + parammsq.jdField_f_of_type_JavaLangString + "], mRedbagErrorType[" + parammsq.jdField_e_of_type_Int + "], defMsg[" + parammsq.h + "], title[" + str2 + "], err[" + str3 + "]");
      return new com.tencent.util.Pair(str2, str3);
      if (this.jdField_a_of_type_Msq.jdField_b_of_type_Boolean)
      {
        str2 = alud.a(2131713831);
        str1 = alud.a(2131713829);
        break;
      }
      str2 = "未同意服务协议，\n无法领取红包。";
      str1 = "请到消息窗口点击红包补领。\n";
      break;
      if (this.jdField_a_of_type_Msq.jdField_b_of_type_Boolean)
      {
        str2 = alud.a(2131713830);
        str1 = alud.a(2131713835);
        break;
      }
      str2 = "因政策要求，\n无法领取红包。";
      str1 = "请到消息窗口点击红包补领。\n";
      break;
      if (this.jdField_a_of_type_Msq.jdField_b_of_type_Boolean)
      {
        str2 = "对方未实名认证，\n红包金额无法到账。";
        str1 = alud.a(2131713825);
        break;
      }
      str2 = "未作实名认证，\n无法领取红包。";
      str1 = alud.a(2131713828);
      break;
      str2 = "因收起到悬浮窗，\n无法领取红包。";
      str1 = "请到消息窗口点击红包补领。\n";
      break;
    }
  }
  
  String a()
  {
    if (a())
    {
      if (this.jdField_a_of_type_Msq.jdField_b_of_type_Boolean) {
        return "对方演技爆棚，\n领到了你的红包。";
      }
      return alud.a(2131713826);
    }
    if (this.jdField_a_of_type_Msq.jdField_b_of_type_Boolean) {
      return alud.a(2131713824);
    }
    return alud.a(2131713834);
  }
  
  String a(String paramString)
  {
    String str1 = "-.--";
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.length() != 1) {
        break label87;
      }
      str1 = "0.0" + paramString;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.i, 1, "formatShowMoney, src[" + paramString + "], dest[" + str1 + "]");
      }
      return str1;
      label87:
      if (paramString.length() == 2)
      {
        str1 = "0." + paramString;
      }
      else
      {
        str1 = paramString.substring(paramString.length() - 2);
        String str2 = paramString.substring(0, paramString.length() - 2);
        str1 = str2 + "." + str1;
      }
    }
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Meu != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Meu);
      this.jdField_a_of_type_Meu = null;
    }
  }
  
  void a(RelativeLayout paramRelativeLayout)
  {
    paramRelativeLayout.setOnTouchListener(new msu(this));
  }
  
  public void a(AVActivity paramAVActivity)
  {
    RelativeLayout localRelativeLayout = a(paramAVActivity);
    paramAVActivity = msp.c();
    if (this.jdField_a_of_type_Msq.jdField_b_of_type_Boolean) {}
    for (paramAVActivity = paramAVActivity + "avredbag_error_sender.png";; paramAVActivity = paramAVActivity + "avredbag_error_player.png")
    {
      paramAVActivity = bdal.a(paramAVActivity);
      ((ImageView)localRelativeLayout.findViewById(2131375719)).setImageBitmap(paramAVActivity);
      ((RelativeLayout)localRelativeLayout.findViewById(2131369196)).setVisibility(0);
      return;
    }
  }
  
  void a(AVActivity paramAVActivity, RelativeLayout paramRelativeLayout)
  {
    View localView = paramRelativeLayout.findViewById(2131372842);
    AVRedPacketManager localAVRedPacketManager = (AVRedPacketManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(6);
    if (this.c == null) {
      this.c = localAVRedPacketManager.a("qav_redpacket_result_close.png");
    }
    if (this.c != null) {
      localView.setBackgroundDrawable(mwj.a(paramAVActivity.getResources(), this.c, 2131165958));
    }
    localView.setOnClickListener(this);
    paramRelativeLayout.findViewById(2131372846).setOnTouchListener(new mst(this));
  }
  
  public void a(AVActivity paramAVActivity, msq parammsq)
  {
    Object localObject1 = (RelativeLayout)paramAVActivity.findViewById(2131375725);
    if ((localObject1 == null) || (parammsq == null))
    {
      paramAVActivity = this.i;
      localObject1 = new StringBuilder().append("showNormal_Result, result_root is null, ResultData[");
      if (parammsq != null)
      {
        bool = true;
        QLog.w(paramAVActivity, 1, bool + "]");
      }
    }
    int i;
    for (;;)
    {
      return;
      bool = false;
      break;
      localObject1 = (RelativeLayout)((RelativeLayout)localObject1).findViewById(2131372846);
      localObject2 = (AVRedPacketManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(6);
      localObject3 = ((RelativeLayout)localObject1).findViewById(2131372849);
      ((View)localObject3).setAnimation(null);
      ((View)localObject3).setVisibility(8);
      paramAVActivity = paramAVActivity.getResources();
      i = aepi.a(4.0F, paramAVActivity);
      if (parammsq.jdField_e_of_type_Int == 0)
      {
        StrokeTextView localStrokeTextView = (StrokeTextView)((RelativeLayout)localObject1).findViewById(2131372848);
        localObject3 = (RedPacketRollNumberView)((RelativeLayout)localObject1).findViewById(2131372850);
        localObject4 = (StrokeTextView)((RelativeLayout)localObject1).findViewById(2131372854);
        localObject5 = (TextView)((RelativeLayout)localObject1).findViewById(2131372853);
        localStrokeTextView.setVisibility(0);
        localStrokeTextView.setStrokeEnable(true);
        localStrokeTextView.setStrokeColor(-3109366);
        localStrokeTextView.setInnerTextColor(-1);
        localStrokeTextView.setStrokeSize(i);
        i = aepi.a(6.0F, paramAVActivity);
        try
        {
          f1 = Float.parseFloat(a(parammsq.i));
          ((RedPacketRollNumberView)localObject3).b(f1);
          ((RedPacketRollNumberView)localObject3).a();
          ((StrokeTextView)localObject4).setVisibility(0);
          ((StrokeTextView)localObject4).setStrokeEnable(true);
          ((StrokeTextView)localObject4).setStrokeColor(-1);
          ((StrokeTextView)localObject4).setStrokeSize(i);
          ((StrokeTextView)localObject4).setInnerTextColor(-2094274);
          ((TextView)localObject5).setText(a());
          if (a())
          {
            if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
              this.jdField_b_of_type_AndroidGraphicsBitmap = ((AVRedPacketManager)localObject2).a("qav_redpacket_result_bqd.png");
            }
            if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
              ((RelativeLayout)localObject1).findViewById(2131372840).setBackgroundDrawable(new BitmapDrawable(paramAVActivity, this.jdField_b_of_type_AndroidGraphicsBitmap));
            }
          }
          if (this.e == null) {
            this.e = ((AVRedPacketManager)localObject2).a("qav_redpacket_result_button_normal.png");
          }
          if (this.f == null) {
            this.f = ((AVRedPacketManager)localObject2).a("qav_redpacket_result_button_pressed.png");
          }
          if ((this.e != null) && (this.f != null))
          {
            parammsq = ((RelativeLayout)localObject1).findViewById(2131372841);
            parammsq.setVisibility(0);
            localObject3 = new StateListDrawable();
            localObject4 = new BitmapDrawable(paramAVActivity, this.f);
            ((StateListDrawable)localObject3).addState(new int[] { 16842919 }, (Drawable)localObject4);
            localObject4 = new BitmapDrawable(paramAVActivity, this.e);
            ((StateListDrawable)localObject3).addState(new int[] { -16842919 }, (Drawable)localObject4);
            parammsq.setOnClickListener(this);
            parammsq.setBackgroundDrawable((Drawable)localObject3);
          }
          if (this.g == null) {
            this.g = ((AVRedPacketManager)localObject2).a("qav_redpacket_result_share_normal.png");
          }
          if (this.h == null) {
            this.h = ((AVRedPacketManager)localObject2).a("qav_redpacket_result_share_pressed.png");
          }
          if ((this.g != null) && (this.h != null))
          {
            parammsq = ((RelativeLayout)localObject1).findViewById(2131372852);
            parammsq.setVisibility(0);
            localObject1 = new StateListDrawable();
            localObject2 = new BitmapDrawable(paramAVActivity, this.h);
            ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
            paramAVActivity = new BitmapDrawable(paramAVActivity, this.g);
            ((StateListDrawable)localObject1).addState(new int[] { -16842919 }, paramAVActivity);
            parammsq.setOnClickListener(this);
            parammsq.setBackgroundDrawable((Drawable)localObject1);
            return;
          }
        }
        catch (NumberFormatException parammsq)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e(this.i, 2, "showNormal_Result e = " + parammsq);
            }
            float f1 = 0.0F;
          }
        }
      }
    }
    Object localObject2 = a(parammsq);
    Object localObject3 = parammsq.g;
    Object localObject4 = (String)((com.tencent.util.Pair)localObject2).second;
    Object localObject5 = new ForegroundColorSpan(-7447805);
    if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (parammsq.jdField_e_of_type_Int == 8)) {
      paramAVActivity = alud.a(2131713833);
    }
    for (boolean bool = true;; bool = false)
    {
      parammsq = new SpannableString((String)localObject4 + paramAVActivity);
      int j = ((String)localObject4).length();
      int k = paramAVActivity.length() + j;
      parammsq.setSpan(new msw(this, bool, paramAVActivity, (String)localObject3), j, k, 33);
      parammsq.setSpan(localObject5, j, k, 17);
      paramAVActivity = (StrokeTextView)((RelativeLayout)localObject1).findViewById(2131372844);
      paramAVActivity.setText((CharSequence)((com.tencent.util.Pair)localObject2).first);
      paramAVActivity.setStrokeEnable(true);
      paramAVActivity.setStrokeColor(-3109366);
      paramAVActivity.setInnerTextColor(-1);
      paramAVActivity.setStrokeSize(i);
      paramAVActivity = (TextView)((RelativeLayout)localObject1).findViewById(2131372843);
      paramAVActivity.setVisibility(0);
      paramAVActivity.setText(parammsq);
      parammsq = (lwl)lwl.a();
      parammsq.jdField_a_of_type_Int = -10864125;
      parammsq.jdField_b_of_type_Int = -7447805;
      paramAVActivity.setMovementMethod(parammsq);
      paramAVActivity.setHighlightColor(0);
      return;
      paramAVActivity = alud.a(2131713827);
    }
  }
  
  void a(msq parammsq)
  {
    AVActivity localAVActivity = a();
    if (localAVActivity == null)
    {
      QLog.w(this.i, 1, "onGetResult, AVActivity为空");
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      QLog.w(this.i, 1, "onGetResult, 显示结果");
      a(localAVActivity, parammsq);
      return;
    }
    this.jdField_a_of_type_Msq = parammsq;
    QLog.w(this.i, 1, "onGetResult, 窗口还没显示");
  }
  
  void a(msq parammsq, msx parammsx)
  {
    this.jdField_a_of_type_Msq = parammsq;
    parammsq = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_Msq.jdField_b_of_type_Boolean = TextUtils.equals(parammsq, this.jdField_a_of_type_Msq.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Msx = parammsx;
    parammsq = a();
    QLog.w(this.i, 1, "show, mStarter[" + this.jdField_a_of_type_Msq.jdField_b_of_type_Boolean + "], mGotMoney[" + this.jdField_a_of_type_Msq.i + "], avActivity[" + parammsq + "]");
    c();
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Msq.jdField_b_of_type_Int - this.jdField_a_of_type_Msq.jdField_a_of_type_Int <= this.jdField_a_of_type_Msq.jdField_a_of_type_Int;
  }
  
  public boolean a(String paramString)
  {
    a();
    AVActivity localAVActivity = a();
    if (localAVActivity != null)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)localAVActivity.findViewById(2131375725);
      if (localRelativeLayout != null)
      {
        localRelativeLayout.setOnTouchListener(null);
        ((RelativeLayout)localAVActivity.findViewById(2131372566)).removeView(localRelativeLayout);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      QLog.w(this.i, 1, "closeUI[" + paramString + "], bret[" + bool + "]");
      if (this.jdField_a_of_type_Msx != null)
      {
        this.jdField_a_of_type_Msx.a();
        this.jdField_a_of_type_Msx = null;
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_b_of_type_AndroidGraphicsBitmap = null;
      }
      if (this.c != null)
      {
        this.c.recycle();
        this.c = null;
      }
      if (this.d != null)
      {
        this.d.recycle();
        this.d = null;
      }
      if (this.e != null)
      {
        this.e.recycle();
        this.e = null;
      }
      if (this.f != null)
      {
        this.f.recycle();
        this.f = null;
      }
      if (this.g != null)
      {
        this.g.recycle();
        this.g = null;
      }
      if (this.h != null)
      {
        this.h.recycle();
        this.h = null;
      }
      return bool;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Meu != null) {
      return;
    }
    QLog.w(this.i, 1, "listenOnActivityEvent,  mStarter[" + this.jdField_a_of_type_Msq.jdField_b_of_type_Boolean + "], mPlayUin[" + this.jdField_a_of_type_Msq.jdField_b_of_type_JavaLangString + "], mStartUin[" + this.jdField_a_of_type_Msq.jdField_a_of_type_JavaLangString + "]");
    this.jdField_a_of_type_Meu = new mss(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Meu);
  }
  
  public void b(AVActivity paramAVActivity)
  {
    int j = 0;
    Object localObject2 = null;
    AVRedPacketManager localAVRedPacketManager = (AVRedPacketManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(6);
    Object localObject3;
    Object localObject1;
    int i;
    Object localObject4;
    if (this.jdField_a_of_type_Msq.b()) {
      if (this.jdField_a_of_type_Msq.jdField_e_of_type_Int == 0)
      {
        localObject3 = (a(this.jdField_a_of_type_Msq.i) + '$').toCharArray();
        localObject1 = localObject2;
        i = j;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          i = j;
          if (localObject3.length > 0)
          {
            localObject2 = new ArrayList();
            j = localObject3.length;
            i = 0;
            if (i < j)
            {
              localObject4 = Character.valueOf(localObject3[i]);
              localObject1 = "";
              if (((Character)localObject4).charValue() == '.') {
                localObject1 = "qav_redpacket_result_starter_" + "dot.png";
              }
              for (;;)
              {
                ((List)localObject2).add(new android.util.Pair(localObject4, localObject1));
                i += 1;
                break;
                if (((Character)localObject4).charValue() == '$') {
                  localObject1 = "qav_redpacket_result_starter_" + "yuan.png";
                } else if (Character.isDigit(((Character)localObject4).charValue())) {
                  localObject1 = "qav_redpacket_result_starter_" + localObject4 + ".png";
                }
              }
            }
            localObject1 = localObject2;
            i = 1;
          }
        }
        if (this.jdField_a_of_type_Msq.jdField_a_of_type_Int * 1.0F / this.jdField_a_of_type_Msq.jdField_b_of_type_Int >= 0.5F)
        {
          j = 1;
          if (j == 0) {
            break label572;
          }
          localObject2 = "avredbag_suc1_sender.png";
        }
      }
    }
    for (;;)
    {
      label313:
      localObject3 = a(paramAVActivity);
      ((RelativeLayout)localObject3).findViewById(2131369266).setOnTouchListener(new msv(this));
      localObject4 = (ViewGroup)((RelativeLayout)localObject3).findViewById(2131375723);
      ((ViewGroup)localObject4).removeAllViews();
      ((ImageView)((RelativeLayout)localObject3).findViewById(2131375727)).setImageBitmap(localAVRedPacketManager.a((String)localObject2));
      localObject2 = (ImageView)((RelativeLayout)localObject3).findViewById(2131375728);
      ((ImageView)localObject2).setImageBitmap(localAVRedPacketManager.a("qav_redpacket_result_close.png"));
      ((ImageView)localObject2).setOnClickListener(this);
      label415:
      label437:
      android.util.Pair localPair;
      if (i != 0)
      {
        i = 0;
        ((ViewGroup)localObject4).setVisibility(i);
        if ((localObject1 == null) || ("qav_redpacket_result_starter_".isEmpty())) {
          break label771;
        }
        j = 0;
        if (j >= ((List)localObject1).size()) {
          break label771;
        }
        localPair = (android.util.Pair)((List)localObject1).get(j);
        localObject2 = (Character)localPair.first;
        if (((Character)localObject2).charValue() != '.') {
          break label645;
        }
        localObject2 = new LinearLayout.LayoutParams(aepi.a(12.0F, paramAVActivity.getResources()), aepi.a(12.0F, paramAVActivity.getResources()));
        ((LinearLayout.LayoutParams)localObject2).gravity = 80;
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          ImageView localImageView = new ImageView(paramAVActivity);
          localImageView.setImageBitmap(localAVRedPacketManager.a((String)localPair.second));
          ((ViewGroup)localObject4).addView(localImageView, (ViewGroup.LayoutParams)localObject2);
        }
        j += 1;
        break label437;
        j = 0;
        break;
        label572:
        localObject2 = "avredbag_suc2_sender.png";
        break label313;
        localObject1 = null;
        localObject2 = "avredbag_error2_sender.png";
        i = 0;
        break label313;
        if (this.jdField_a_of_type_Msq.a())
        {
          localObject1 = null;
          localObject2 = "avredbag_error_sender.png";
          i = 0;
          break label313;
        }
        if (this.jdField_a_of_type_Msq.jdField_f_of_type_Int != 4) {
          break label787;
        }
        localObject1 = null;
        localObject2 = "avredbag_error2_sender.png";
        i = 0;
        break label313;
        i = 8;
        break label415;
        label645:
        if (((Character)localObject2).charValue() == '$')
        {
          localObject2 = new LinearLayout.LayoutParams(aepi.a(22.0F, paramAVActivity.getResources()), aepi.a(20.0F, paramAVActivity.getResources()));
          ((LinearLayout.LayoutParams)localObject2).leftMargin = aepi.a(5.0F, paramAVActivity.getResources());
          ((LinearLayout.LayoutParams)localObject2).gravity = 80;
          i = 1;
        }
        else if (Character.isDigit(((Character)localObject2).charValue()))
        {
          localObject2 = new LinearLayout.LayoutParams(aepi.a(27.0F, paramAVActivity.getResources()), aepi.a(37.0F, paramAVActivity.getResources()));
          ((LinearLayout.LayoutParams)localObject2).gravity = 16;
          i = 1;
        }
        else
        {
          i = 0;
          localObject2 = null;
        }
      }
      label771:
      ((RelativeLayout)((RelativeLayout)localObject3).findViewById(2131369266)).setVisibility(0);
      return;
      label787:
      localObject1 = null;
      localObject2 = "";
      i = 0;
    }
  }
  
  void c()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new ResultUI.2(this));
  }
  
  public void c(AVActivity paramAVActivity)
  {
    Object localObject2 = a(paramAVActivity);
    a(paramAVActivity, (RelativeLayout)localObject2);
    RelativeLayout localRelativeLayout = (RelativeLayout)((RelativeLayout)localObject2).findViewById(2131372846);
    localRelativeLayout.setVisibility(0);
    Object localObject1 = (AVRedPacketManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(6);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = ((AVRedPacketManager)localObject1).a("qav_redpacket_result_background.png");
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      localRelativeLayout.findViewById(2131372847).setBackgroundDrawable(new BitmapDrawable(paramAVActivity.getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap));
    }
    ((TextView)localRelativeLayout.findViewById(2131372851)).setText(a(paramAVActivity, 2131696299, this.jdField_a_of_type_Msq.c, this.jdField_a_of_type_Msq.d) + "\n" + a(paramAVActivity, 2131696301, this.jdField_a_of_type_Msq.jdField_a_of_type_Int, this.jdField_a_of_type_Msq.jdField_b_of_type_Int));
    ((RelativeLayout)localObject2).findViewById(2131372845).setBackgroundDrawable(new BitmapDrawable(paramAVActivity.getResources(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, this.jdField_a_of_type_Msq.jdField_b_of_type_JavaLangString, null, true, true)));
    localObject2 = localRelativeLayout.findViewById(2131372849);
    if (this.d == null) {
      this.d = ((AVRedPacketManager)localObject1).a("qav_redpacket_result_loading.png");
    }
    if (this.d != null) {
      ((View)localObject2).setBackgroundDrawable(new BitmapDrawable(paramAVActivity.getResources(), this.d));
    }
    localObject1 = new RotateAnimation(0.0F, -360.0F, 1, 0.5F, 1, 0.5F);
    ((RotateAnimation)localObject1).setInterpolator(new LinearInterpolator());
    ((RotateAnimation)localObject1).setDuration(1800L);
    ((RotateAnimation)localObject1).setRepeatCount(-1);
    ((RotateAnimation)localObject1).setRepeatMode(1);
    ((View)localObject2).setAnimation((Animation)localObject1);
    if (this.jdField_a_of_type_Msq.jdField_b_of_type_Boolean)
    {
      a(paramAVActivity, this.jdField_a_of_type_Msq);
      return;
    }
    if ((this.jdField_a_of_type_Msq.jdField_e_of_type_Int != 1) && (this.jdField_a_of_type_Msq.jdField_e_of_type_Int != -1))
    {
      QLog.w(this.i, 1, "showNormal_Result, 抢红包回调早就来了");
      a(paramAVActivity, this.jdField_a_of_type_Msq);
      return;
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onClick(View paramView)
  {
    long l = AudioHelper.b();
    QLog.w(this.i, 1, "onClick, seq[" + l + "]");
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131372842: 
      a("qav_result_close");
      return;
    case 2131375728: 
      a("result_starter_close");
      return;
    case 2131372841: 
      a("qav_result_button");
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(126), Boolean.valueOf(true), Integer.valueOf(7), Long.valueOf(l) });
      mso.m();
      return;
    }
    paramView = a();
    if (paramView != null)
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(603979776);
      localIntent.putExtra("score", this.jdField_a_of_type_Msq.jdField_a_of_type_Int);
      localIntent.putExtra("count", this.jdField_a_of_type_Msq.c);
      localIntent.putExtra("isGoodScore", a());
      adpn.a(paramView, localIntent, PublicFragmentActivityForVideo.class, RedPacketShareFragment.class);
      paramView.finish();
      RedPacketShareFragment.a("0X8008CF4");
    }
    a("qav_result_share");
  }
  
  public String toString()
  {
    return "mResultData[" + this.jdField_a_of_type_Msq + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     msr
 * JD-Core Version:    0.7.0.1
 */