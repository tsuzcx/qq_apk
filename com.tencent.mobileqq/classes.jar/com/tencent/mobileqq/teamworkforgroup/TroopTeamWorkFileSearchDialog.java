package com.tencent.mobileqq.teamworkforgroup;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.rely.CountdownTimeTask;
import com.tencent.mobileqq.rely.SingleLineHotwordTextView;
import com.tencent.mobileqq.teamwork.OnItemLongClickListener;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.teamwork.api.IGroupTeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.VersionUtils;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.List;
import mqq.os.MqqHandler;

public class TroopTeamWorkFileSearchDialog
  extends ReportDialog
  implements Handler.Callback, OnItemLongClickListener
{
  public static int D = 10;
  public static int E = 16;
  protected int A;
  protected List<GPadInfo> B = null;
  protected GroupTeamWorkObserver C = new TroopTeamWorkFileSearchDialog.9(this);
  private Bitmap F;
  protected XListView a;
  public GroupTeamWordkMoreView b;
  protected ViewGroup c;
  protected TextView d;
  protected TextView e;
  protected View f;
  protected ImageButton g;
  protected EditText h;
  protected RelativeLayout i;
  protected GroupTeamWorkAdapter j;
  protected AppInterface k;
  protected Activity l;
  protected Handler m = null;
  protected CountdownTimeTask n = null;
  protected boolean o = true;
  protected Object p = new Object();
  protected boolean q = false;
  protected boolean r = false;
  protected boolean s = false;
  protected String t = "";
  protected int u = 0;
  protected boolean v = false;
  protected int w = 0;
  protected long x = 0L;
  protected long y = 0L;
  protected IGroupTeamWorkHandler z;
  
  public TroopTeamWorkFileSearchDialog(Activity paramActivity, View paramView, AppInterface paramAppInterface, long paramLong)
  {
    super(paramActivity, 2131952330);
    this.l = paramActivity;
    this.k = paramAppInterface;
    this.z = ((IGroupTeamWorkHandler)this.k.getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getGroupTeamWorkHandlerName()));
    this.x = paramLong;
    a(paramActivity);
    this.i = ((RelativeLayout)findViewById(2131444724));
    this.a = ((XListView)findViewById(2131445451));
    this.c = ((ViewGroup)findViewById(2131437624));
    this.d = ((TextView)findViewById(2131437626));
    this.e = ((TextView)findViewById(2131448723));
    this.f = findViewById(2131430753);
    this.g = ((ImageButton)findViewById(2131435215));
    this.m = new Handler(this);
    a();
    f();
    a(paramActivity, paramAppInterface);
    this.k.addObserver(this.C);
    a(paramView);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject1 = paramString1;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return paramString1;
      }
      if (paramString1.contains("#"))
      {
        Object localObject2 = paramString1.split("\\#");
        localObject1 = localObject2[0];
        int i2 = localObject2.length;
        int i1 = 1;
        paramString1 = "";
        StringBuilder localStringBuilder;
        while (i1 < i2)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString1);
          localStringBuilder.append("#");
          localStringBuilder.append(localObject2[i1]);
          paramString1 = localStringBuilder.toString();
          i1 += 1;
        }
        if (((String)localObject1).contains("?"))
        {
          localObject2 = new StringBuilder();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("?");
          localStringBuilder.append(paramString2);
          localStringBuilder.append("&");
          ((StringBuilder)localObject2).append(((String)localObject1).replace("?", localStringBuilder.toString()));
          ((StringBuilder)localObject2).append(paramString1);
          return ((StringBuilder)localObject2).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("?");
        ((StringBuilder)localObject2).append(paramString2);
        ((StringBuilder)localObject2).append(paramString1);
        return ((StringBuilder)localObject2).toString();
      }
      if (paramString1.contains("?"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("?");
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append("&");
        return paramString1.replace("?", ((StringBuilder)localObject1).toString());
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append("?");
      ((StringBuilder)localObject1).append(paramString2);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    return localObject1;
  }
  
  private void f()
  {
    this.g.setOnClickListener(new TroopTeamWorkFileSearchDialog.7(this));
    Button localButton = (Button)findViewById(2131429816);
    localButton.setVisibility(0);
    localButton.setOnClickListener(new TroopTeamWorkFileSearchDialog.8(this));
  }
  
  protected String a(int paramInt)
  {
    if (paramInt > 1000) {
      return this.l.getString(2131895135);
    }
    return this.l.getString(2131895133, new Object[] { Integer.valueOf(paramInt) });
  }
  
  protected void a()
  {
    this.h = ((EditText)findViewById(2131432634));
    this.h.setHint(this.l.getResources().getString(2131916107));
    this.h.setImeOptions(3);
    this.h.setOnEditorActionListener(new TroopTeamWorkFileSearchDialog.5(this));
    this.h.addTextChangedListener(new TroopTeamWorkFileSearchDialog.6(this));
    this.h.setSelection(0);
    this.h.requestFocus();
  }
  
  public final void a(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      int i1 = this.u;
      if (i1 > 0) {
        return;
      }
      if (TextUtils.isEmpty(paramString))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("doReqTroopFileSearch err keyWord =");
          localStringBuilder.append(paramString);
          QLog.i("TroopTeamWorkFileSearchDialog", 4, localStringBuilder.toString());
        }
      }
      else
      {
        this.y = System.currentTimeMillis();
        this.u += 1;
        if (this.z != null) {
          this.z.reqSearchGroupTeamWorkList(paramLong, paramString, paramInt1, paramInt2, paramInt3);
        }
      }
      return;
    }
    finally {}
  }
  
  protected void a(Activity paramActivity)
  {
    requestWindowFeature(1);
    getWindow().setSoftInputMode(36);
    if (!VersionUtils.e()) {
      getWindow().setBackgroundDrawable(new ColorDrawable());
    } else {
      getWindow().setBackgroundDrawable(new ColorDrawable(paramActivity.getResources().getColor(2131166286)));
    }
    setContentView(2131625948);
    findViewById(2131437674).setOnClickListener(new TroopTeamWorkFileSearchDialog.1(this));
    Object localObject = getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = 0;
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject).gravity = 51;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      getWindow().addFlags(67108864);
      int i1 = paramActivity.getResources().getColor(2131168092);
      if (ImmersiveUtils.setStatusBarDarkMode(getWindow(), true)) {
        i1 = paramActivity.getResources().getColor(2131168334);
      }
      new SystemBarCompact(this, true, i1).init();
      localObject = (LinearLayout)findViewById(2131437674);
      ((LinearLayout)localObject).setFitsSystemWindows(true);
      ((LinearLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(paramActivity), 0, 0);
    }
  }
  
  protected void a(Activity paramActivity, AppInterface paramAppInterface)
  {
    this.b = new GroupTeamWordkMoreView(paramActivity);
    this.b.setBackgroundResource(2130838958);
    this.b.setTextColor(paramActivity.getResources().getColor(2131167993));
    this.a.addFooterView(this.b);
    this.b.setVisibility(8);
    this.j = new GroupTeamWorkAdapter(this.k, this.l, this, this.m);
    this.a.setAdapter(this.j);
    this.a.setOnScrollListener(new TroopTeamWorkFileSearchDialog.2(this));
    this.a.setOnTouchListener(new TroopTeamWorkFileSearchDialog.3(this));
    this.j.a(new TroopTeamWorkFileSearchDialog.4(this));
  }
  
  public void a(View paramView)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setBackgroundViewBlur, view :");
      ((StringBuilder)localObject1).append(paramView.getHeight());
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(paramView.getWidth());
      QLog.d("TroopTeamWorkFileSearchDialog", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTeamWorkFileSearchDialog", 2, "setBackgroundViewBlur, isDrawingCacheEnabled");
    }
    boolean bool = paramView.isDrawingCacheEnabled();
    if (!bool) {
      paramView.setDrawingCacheEnabled(true);
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopTeamWorkFileSearchDialog", 2, "setBackgroundViewBlur, getDrawingCache");
      }
      localObject1 = paramView.getDrawingCache(true);
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopTeamWorkFileSearchDialog", 2, "getDrawingCache is return null");
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopTeamWorkFileSearchDialog", 2, "setBackgroundViewBlur, start thread");
      }
      Object localObject2 = null;
      try
      {
        localObject1 = Bitmap.createBitmap((Bitmap)localObject1);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("TroopTeamWorkFileSearchDialog", 2, "blurBitmap error", localOutOfMemoryError);
          localObject1 = localObject2;
        }
      }
      a(paramView, bool, (Bitmap)localObject1);
      return;
    }
    catch (Exception paramView)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getDrawingCache exception, ");
        ((StringBuilder)localObject1).append(paramView.getMessage());
        QLog.d("TroopTeamWorkFileSearchDialog", 2, ((StringBuilder)localObject1).toString());
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopTeamWorkFileSearchDialog", 2, "getDrawingCache is return null");
      }
      return;
      label258:
      if (QLog.isColorLevel()) {
        QLog.d("TroopTeamWorkFileSearchDialog", 2, "getDrawingCache is return null");
      }
      return;
    }
    finally
    {
      break label258;
    }
  }
  
  protected void a(View paramView, boolean paramBoolean, Bitmap paramBitmap)
  {
    ThreadManager.post(new TroopTeamWorkFileSearchDialog.10(this, paramBitmap, paramView, paramBoolean), 8, null, true);
  }
  
  public void a(PadInfo paramPadInfo) {}
  
  protected void a(String paramString)
  {
    try
    {
      boolean bool = this.r;
      if (bool) {
        return;
      }
      this.m.sendEmptyMessage(1);
      a(this.x, paramString, 0, 50, 0);
      return;
    }
    finally {}
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (this.w <= 0)
    {
      this.e.setVisibility(8);
      return;
    }
    long l1 = System.currentTimeMillis();
    TextPaint localTextPaint = this.h.getPaint();
    float f1 = c() - localTextPaint.measureText(paramString);
    if (f1 < 0.0F)
    {
      this.e.setVisibility(8);
    }
    else if (paramBoolean)
    {
      this.e.setText(a(this.w));
      this.e.setVisibility(0);
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("resetResultNumTextVisible compareWidth = ");
      paramString.append(f1);
      paramString.append(", time = ");
      paramString.append(System.currentTimeMillis() - l1);
      QLog.e("zivonchen", 2, paramString.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Drawable localDrawable;
    if (paramBoolean)
    {
      if (this.i.getVisibility() != 0) {
        this.i.setVisibility(0);
      }
      this.c.setVisibility(0);
      this.d.setVisibility(0);
      this.a.setVisibility(8);
      this.d.setCompoundDrawablesWithIntrinsicBounds(2130839587, 0, 0, 0);
      this.d.setText(2131892582);
      localDrawable = this.d.getCompoundDrawables()[0];
      if ((localDrawable instanceof Animatable)) {
        ((Animatable)localDrawable).start();
      }
    }
    else
    {
      this.a.setVisibility(0);
      localDrawable = this.d.getCompoundDrawables()[0];
      if ((localDrawable instanceof Animatable)) {
        ((Animatable)localDrawable).stop();
      }
      this.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      this.c.setVisibility(8);
      this.d.setVisibility(8);
    }
  }
  
  protected String b(String paramString)
  {
    float f1 = c();
    TextPaint localTextPaint = this.h.getPaint();
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (localTextPaint.measureText(paramString) <= f1) {
        return paramString;
      }
      paramString = new StringBuilder(paramString.substring(0, localTextPaint.breakText(paramString, true, f1 - localTextPaint.measureText("…"), null)));
      paramString.append("…");
      str = paramString.toString();
    }
    return str;
  }
  
  public void b()
  {
    if (this.i.getVisibility() != 0) {
      this.i.setVisibility(0);
    }
    this.c.setVisibility(0);
    this.d.setVisibility(0);
    this.a.setVisibility(8);
    this.d.setText(this.l.getString(2131892104));
    this.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  protected void b(View paramView, boolean paramBoolean, Bitmap paramBitmap)
  {
    ThreadManager.getUIHandler().post(new TroopTeamWorkFileSearchDialog.11(this, paramView, paramBoolean));
    if (paramBitmap != null) {
      paramBitmap.recycle();
    }
  }
  
  public void b(PadInfo paramPadInfo) {}
  
  public void b(boolean paramBoolean)
  {
    a(false);
    if (paramBoolean)
    {
      if (this.i.getVisibility() != 0) {
        this.i.setVisibility(0);
      }
      this.c.setVisibility(0);
      this.d.setVisibility(0);
      this.a.setVisibility(8);
      this.d.setText(this.l.getString(2131895130, new Object[] { this.t }));
      this.d.setCompoundDrawablesWithIntrinsicBounds(0, 2130844847, 0, 0);
      return;
    }
    this.a.setVisibility(0);
    Drawable localDrawable = this.d.getCompoundDrawables()[0];
    if ((localDrawable instanceof Animatable)) {
      ((Animatable)localDrawable).stop();
    }
    this.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    this.c.setVisibility(8);
    this.d.setVisibility(8);
  }
  
  protected float c()
  {
    float f2 = this.h.getWidth() - DisplayUtils.a(this.l, 20.0F);
    float f1 = f2;
    if (this.w > 0) {
      f1 = f2 - (this.h.getPaint().measureText(a(this.w)) + DisplayUtils.a(this.l, 16.0F));
    }
    f2 = f1;
    if (this.g.getVisibility() == 0) {
      f2 = f1 - (this.g.getWidth() + DisplayUtils.a(this.l, 8.0F));
    }
    return f2;
  }
  
  protected void c(boolean paramBoolean)
  {
    if (this.a.getFirstVisiblePosition() == 0)
    {
      this.b.setVisibility(8);
      return;
    }
    this.b.setVisibility(0);
    if (paramBoolean)
    {
      this.b.setText(2131916806);
      this.b.a();
      return;
    }
    this.b.setText(2131892582);
    this.b.setTextLeftDrawable(2130839587);
  }
  
  protected void d()
  {
    this.e.setVisibility(8);
    this.r = true;
    this.m.removeCallbacksAndMessages(null);
    CountdownTimeTask localCountdownTimeTask = this.n;
    if (localCountdownTimeTask != null)
    {
      localCountdownTimeTask.b();
      this.n = null;
    }
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.a.setVisibility(8);
    InputMethodUtil.a(this.h);
  }
  
  public void dismiss()
  {
    this.r = true;
    InputMethodUtil.b(this.h);
    SingleLineHotwordTextView.a();
    Object localObject = this.B;
    if (localObject != null)
    {
      ((List)localObject).clear();
      this.B = null;
    }
    localObject = this.n;
    if (localObject != null)
    {
      ((CountdownTimeTask)localObject).b();
      this.n = null;
    }
    localObject = this.m;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.j;
    if (localObject != null)
    {
      ((GroupTeamWorkAdapter)localObject).a();
      this.j = null;
    }
    this.k.removeObserver(this.C);
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void e()
  {
    if (this.e.getVisibility() != 0)
    {
      this.e.setText(a(this.w));
      this.e.setVisibility(0);
      this.s = true;
      String str = b(this.h.getText().toString());
      if (!TextUtils.isEmpty(str))
      {
        this.h.setText(str);
        this.h.setSelection(str.length());
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.r) {
      return true;
    }
    int i1 = paramMessage.what;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4)
          {
            if (i1 != 5) {
              return false;
            }
            a(false);
            a(this.h.getText().toString(), true);
            if (this.i.getVisibility() != 0) {
              this.i.setVisibility(0);
            }
            if (this.q) {
              this.j.a();
            }
            if (this.o)
            {
              this.o = false;
              InputMethodUtil.b(this.h);
            }
            c(this.v);
            this.j.b(this.B);
            this.j.notifyDataSetChanged();
            if (this.q) {
              this.q = false;
            }
            long l1 = System.currentTimeMillis() - this.y;
            paramMessage = this.h.getText().toString().trim().toLowerCase();
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("REFRESH_LIST text = ");
              localStringBuilder.append(paramMessage);
              localStringBuilder.append(", lastHotword = ");
              localStringBuilder.append(this.t);
              localStringBuilder.append(", time = ");
              localStringBuilder.append(l1);
              QLog.e("zivonchen", 2, localStringBuilder.toString());
            }
            if ((!paramMessage.equals(this.t)) && (l1 >= 800L))
            {
              this.q = true;
              this.t = paramMessage;
              a(this.t);
              this.n = null;
              return false;
            }
          }
          else
          {
            b(false);
            return false;
          }
        }
        else
        {
          b(true);
          return false;
        }
      }
      else
      {
        a(false);
        return false;
      }
    }
    else {
      a(true);
    }
    return false;
  }
  
  protected void onStop()
  {
    super.onStop();
    Object localObject = this.m;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.F;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      this.F.recycle();
      this.F = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog
 * JD-Core Version:    0.7.0.1
 */