package com.tencent.mobileqq.troop.quickat.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.observer.TroopMessageObserver;
import com.tencent.mobileqq.troop.troopmessage.api.ITroopMessageHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AllMemberItemViewWrapper
{
  private final String a;
  private final boolean b;
  private final String c;
  private final float d;
  private final QuickAtListAdapter e;
  private Drawable f;
  private TroopChatPie g;
  private TroopInfo h;
  private QQAppInterface i;
  private View j;
  private String k;
  private String l;
  private boolean m;
  private TroopMessageObserver n;
  private String o;
  private boolean p;
  
  public AllMemberItemViewWrapper(TroopChatPie paramTroopChatPie, TroopInfo paramTroopInfo, QQAppInterface paramQQAppInterface, QuickAtListAdapter paramQuickAtListAdapter)
  {
    this.g = paramTroopChatPie;
    this.h = paramTroopInfo;
    this.i = paramQQAppInterface;
    this.a = this.h.Administrator;
    if (!paramQQAppInterface.getCurrentAccountUin().equals(this.h.troopowneruin))
    {
      paramTroopChatPie = this.a;
      if ((paramTroopChatPie == null) || (!paramTroopChatPie.contains(paramQQAppInterface.getCurrentAccountUin())))
      {
        bool = false;
        break label79;
      }
    }
    boolean bool = true;
    label79:
    this.b = bool;
    this.f = this.g.aX().getResources().getDrawable(2130839590);
    this.l = this.h.troopcode;
    this.c = this.g.ah.b;
    this.d = f().getDisplayMetrics().density;
    this.e = paramQuickAtListAdapter;
    g();
  }
  
  private String a(int paramInt)
  {
    return BaseApplication.getContext().getString(paramInt);
  }
  
  private Activity e()
  {
    return this.g.aX();
  }
  
  private Resources f()
  {
    return e().getResources();
  }
  
  private void g()
  {
    this.n = new AllMemberItemViewWrapper.3(this);
    this.i.addObserver(this.n);
  }
  
  public void a()
  {
    ITroopMessageHandler localITroopMessageHandler = (ITroopMessageHandler)this.i.getBusinessHandler(BusinessHandlerFactory.TROOP_MESSAGE_HANDLER);
    if (localITroopMessageHandler != null)
    {
      localITroopMessageHandler.a(this.i.getCurrentAccountUin(), this.c);
      if (QLog.isColorLevel()) {
        QLog.d("AllMemberItem", 2, "fetchRemainCountInfo: invoked. ");
      }
    }
  }
  
  public void a(View paramView)
  {
    this.j = paramView;
  }
  
  public void a(String paramString)
  {
    a(true, paramString, this.m, 0, 0, this.o, this.k, this.p);
  }
  
  public void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, int paramInt1, int paramInt2, String paramString2, String paramString3, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AllMemberItem", 2, new Object[] { "updateUIForAtAllRemainedCount: invoked. ", " isSuccess: ", Boolean.valueOf(paramBoolean1), " bCanAtAll: ", Boolean.valueOf(paramBoolean2), " troopCode: ", paramString1, " remainCount: ", Integer.valueOf(paramInt1), " discRemainCount: ", Integer.valueOf(paramInt2), " remainTips: ", paramString2, " noRemainTips: ", paramString3, " allowMemberAtAll:", Boolean.valueOf(paramBoolean3) });
    }
    this.m = paramBoolean2;
    this.k = paramString3;
    this.o = paramString2;
    this.p = paramBoolean3;
    if ((!this.b) && (paramBoolean3))
    {
      paramString3 = this.j;
      if (paramString3 != null)
      {
        ((TextView)paramString3.findViewById(2131448598)).setText(a(2131917558));
        paramString3 = (TextView)this.j.findViewById(2131444603);
        paramString3.setTextSize(12.0F);
        paramString3.setText("");
        ((ImageView)this.j.findViewById(2131436404)).setBackgroundDrawable(ImageUtil.b());
        this.j.setVisibility(0);
        this.j.setEnabled(false);
      }
    }
    if (this.b)
    {
      paramString3 = this.j;
      if (paramString3 != null)
      {
        paramString3 = (ImageView)paramString3.findViewById(2131440982);
        paramString3.setVisibility(0);
        paramString3.setOnClickListener(new AllMemberItemViewWrapper.1(this));
      }
    }
    if (this.j != null)
    {
      paramString3 = this.f;
      if (paramString3 != null)
      {
        ((Animatable)paramString3).stop();
        this.f = null;
        ((TextView)this.j.findViewById(2131444603)).setCompoundDrawables(null, null, null, null);
      }
    }
    paramString3 = this.j;
    if ((paramString3 != null) && (paramString3.getVisibility() != 8))
    {
      this.j.setEnabled(true);
      if (paramBoolean1)
      {
        if (paramString1 == null) {
          return;
        }
        ((TextView)this.j.findViewById(2131448598)).setTextColor(f().getColor(2131167993));
        TextView localTextView = (TextView)this.j.findViewById(2131444603);
        paramString3 = HardCodeUtil.a(2131898475);
        Button localButton = (Button)this.j.findViewById(2131439589);
        localButton.setVisibility(8);
        localButton.setOnClickListener(new AllMemberItemViewWrapper.2(this));
        paramInt1 = ((ISVIPHandler)this.i.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).j();
        if (!paramString1.equals(this.c)) {
          return;
        }
        if (TextUtils.isEmpty(paramString2))
        {
          QLog.e("AllMemberItem", 1, "updateUIForAtAllRemainedCount remainTips empty");
          return;
        }
        if ((!this.m) && (paramInt1 != 3)) {
          localButton.setVisibility(0);
        }
        paramString1 = new SpannableString(this.o);
        paramString2 = Pattern.compile("[^0-9]").matcher(this.o).replaceAll("").trim();
        if (!TextUtils.isEmpty(paramString2))
        {
          paramInt1 = this.o.indexOf(paramString2);
          paramInt2 = paramString2.length();
          paramString1.setSpan(new ForegroundColorSpan(-48606), paramInt1, paramInt2 + paramInt1, 33);
        }
        if (this.o.contains(HardCodeUtil.a(2131898477)))
        {
          paramInt1 = this.o.indexOf(HardCodeUtil.a(2131898480));
          paramInt2 = HardCodeUtil.a(2131898476).length();
          paramString1.setSpan(new ForegroundColorSpan(-48606), paramInt1, paramInt2 + paramInt1, 33);
        }
        localTextView.setText(paramString1);
        paramString1 = new StringBuilder();
        paramString1.append(paramString3);
        paramString1.append(",");
        paramString1.append(this.o);
        paramString1 = paramString1.toString();
        this.j.setContentDescription(paramString1);
      }
    }
  }
  
  void b()
  {
    if (this.m) {
      return;
    }
    if (!TextUtils.isEmpty(this.k))
    {
      QQToast.makeText(e(), this.k, 0).show();
      return;
    }
    QQToast.makeText(e(), HardCodeUtil.a(2131898479), 0).show();
  }
  
  boolean c()
  {
    return this.m;
  }
  
  public void d()
  {
    this.i.removeObserver(this.n);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AllMemberItemViewWrapper
 * JD-Core Version:    0.7.0.1
 */