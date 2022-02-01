package com.tencent.mobileqq.qqexpand.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.etrump.mixlayout.ETTextView;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.IModule;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteVasAdapter;
import com.tencent.mobileqq.qqexpand.bean.profile.ExtendFriendInfo;
import com.tencent.mobileqq.qqexpand.config.ExpandConfig;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.utils.BackgroundUtil;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;
import com.tencent.mobileqq.qqexpand.widget.voice.OldExpandVoiceView;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.troop.activity.AudioRecordFragment;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.troop.data.MediaInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.MD5Utils;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;

public class ExtendFriendOldProfileEditFragment
  extends QBaseFragment
  implements View.OnClickListener
{
  public static final ColorDrawable a = new ColorDrawable(-657931);
  private View A;
  private TextView B;
  private Drawable C;
  private Drawable D;
  private ImageView E;
  private TextView F;
  private ImageView G;
  private ProgressBar H;
  private boolean I;
  private int J = 0;
  private boolean K;
  private boolean L = false;
  private int M = 0;
  private int N;
  private int O = -1;
  private String[] P;
  private QQToast Q;
  public XEditTextEx b;
  public ETTextView c;
  public View d;
  public LinearLayout e;
  public ImageView f;
  public ExtendFriendInfo g;
  public boolean h = false;
  public boolean i = false;
  public int j = 20;
  public String k;
  public boolean l = false;
  protected OldExpandVoiceView m;
  String n = "";
  TextWatcher o = new ExtendFriendOldProfileEditFragment.1(this);
  private View p;
  private QQAppInterface q;
  private ExpandOldEditFragment r;
  private RelativeLayout s;
  private ImageView t;
  private TextView u;
  private TextView v;
  private MediaInfo w;
  private RelativeLayout x;
  private ImageView y;
  private View z;
  
  private boolean c(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  private String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i2 = paramString.length();
    int i1 = i2 - 1;
    while (i1 >= 0)
    {
      int i3 = paramString.charAt(i1);
      if ((i3 != 32) && (i3 != 10)) {
        break;
      }
      i2 -= 1;
      i1 -= 1;
    }
    return paramString.substring(0, i2);
  }
  
  private void g()
  {
    ExpandConfig localExpandConfig = ((IExpandManager)this.q.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).t();
    if (localExpandConfig != null)
    {
      this.b.setHint(localExpandConfig.defaultDecleration);
      this.c.setHint(localExpandConfig.defaultDecleration);
      this.j = localExpandConfig.declerationMinLen;
    }
    i();
  }
  
  private void h()
  {
    this.b = ((XEditTextEx)this.p.findViewById(2131432625));
    this.b.setVisibility(8);
    this.x = ((RelativeLayout)this.p.findViewById(2131445001));
    this.y = ((ImageView)this.p.findViewById(2131429909));
    this.B = ((TextView)this.p.findViewById(2131447590));
    this.A = this.p.findViewById(2131433309);
    this.z = this.p.findViewById(2131437983);
    this.C = new BitmapDrawable(BackgroundUtil.a(AIOUtils.b(27.0F, getResources()), -15550475, 1.0F));
    this.D = new BitmapDrawable(BackgroundUtil.a(AIOUtils.b(27.0F, getResources()), -16777216, 0.08F));
    this.y.setBackgroundDrawable(this.C);
    this.c = ((ETTextView)this.p.findViewById(2131432644));
    this.c.setOnClickListener(this);
    this.c.setVisibility(0);
    this.c.setTextColor(-16777216);
    this.d = this.p.findViewById(2131449306);
    this.b.setOnClickListener(this);
    this.b.addTextChangedListener(this.o);
    Object localObject = getParentFragment();
    if ((localObject != null) && ((localObject instanceof ExpandOldEditFragment))) {
      this.b.setOnTouchListener((ExpandOldEditFragment)localObject);
    }
    m();
    this.b.setBackgroundDrawable(new ColorDrawable(-526345));
    this.x.setBackgroundDrawable(a);
    this.c.setBackgroundDrawable(new ColorDrawable(-526345));
    this.z.setBackgroundDrawable(this.D);
    this.y.setOnTouchListener(new ExtendFriendOldProfileEditFragment.2(this));
    this.y.setOnClickListener(this);
    this.e = ((LinearLayout)this.p.findViewById(2131437403));
    this.s = ((RelativeLayout)this.p.findViewById(2131445018));
    this.f = ((ImageView)this.p.findViewById(2131436251));
    this.t = ((ImageView)this.p.findViewById(2131436267));
    this.u = ((TextView)this.p.findViewById(2131448720));
    this.v = ((TextView)this.p.findViewById(2131448275));
    this.e.setBackgroundDrawable(a);
    this.s.setBackgroundDrawable(a);
    this.E = ((ImageView)this.p.findViewById(2131435528));
    this.F = ((TextView)this.p.findViewById(2131448370));
    this.G = ((ImageView)this.p.findViewById(2131429985));
    this.H = ((ProgressBar)this.p.findViewById(2131439917));
    this.G.setOnClickListener(this);
    this.p.getViewTreeObserver().addOnGlobalLayoutListener(new ExtendFriendOldProfileEditFragment.3(this));
    this.I = true;
    localObject = this.g;
    if (localObject != null) {
      a((ExtendFriendInfo)localObject);
    }
  }
  
  private void i()
  {
    if (this.P == null) {
      this.P = getResources().getStringArray(2130968621);
    }
    if (this.O == -1) {
      this.O = new Random().nextInt(this.P.length);
    }
    this.O += 1;
    int i1 = this.O;
    Object localObject = this.P;
    this.O = (i1 % localObject.length);
    this.F.setText(localObject[this.O]);
    localObject = String.format("https://down.qq.com/innovate/qqexpand/avatarList/expand_avatar_%d.jpg", new Object[] { Integer.valueOf(new Random().nextInt(299) + 1) });
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = ImageUtil.j();
    localURLDrawableOptions.mLoadingDrawable = ImageUtil.j();
    localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
    ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.b);
    this.E.setImageDrawable((Drawable)localObject);
  }
  
  private void j()
  {
    this.G.setVisibility(8);
    this.H.setVisibility(0);
  }
  
  private void k()
  {
    this.G.setVisibility(0);
    this.H.setVisibility(8);
  }
  
  private void l()
  {
    if (this.P == null) {
      return;
    }
    j();
    ThreadManager.getUIHandler().postDelayed(new ExtendFriendOldProfileEditFragment.4(this), 1000L);
  }
  
  private void m()
  {
    this.m = ((OldExpandVoiceView)this.p.findViewById(2131435621));
    this.m.setMode(1);
    this.m.setOnClickListener(this);
    this.m.setActivity(getQBaseActivity());
    this.m.setDeleteIconEnable(true, new ExtendFriendOldProfileEditFragment.5(this));
  }
  
  private void n()
  {
    this.h = false;
    q();
    if (!TextUtils.isEmpty(this.n)) {
      this.m.setVisibility(0);
    } else {
      this.A.setVisibility(0);
    }
    ExpandOldEditFragment localExpandOldEditFragment = this.r;
    if ((localExpandOldEditFragment != null) && (localExpandOldEditFragment.a == 0)) {
      this.r.d();
    }
  }
  
  private void o()
  {
    this.h = true;
    XEditTextEx localXEditTextEx = this.b;
    localXEditTextEx.setSelection(localXEditTextEx.getText().length());
    p();
    this.m.setVisibility(8);
    this.A.setVisibility(8);
  }
  
  private void p()
  {
    int i1 = getResources().getDisplayMetrics().heightPixels;
    int i2 = this.N;
    int i3 = ImmersiveUtils.getStatusBarHeight(getQBaseActivity());
    int i4 = this.B.getHeight();
    int i5 = AIOUtils.b(96.0F, getResources());
    this.b.setMaxHeight(i1 - i2 - i3 - i4 - i5);
  }
  
  private void q()
  {
    this.b.setMaxHeight(2147483647);
  }
  
  private void r()
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof ExpandOldEditFragment))) {
      ((ExpandOldEditFragment)localFragment).a();
    }
  }
  
  private void s()
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof ExpandOldEditFragment))) {
      ((ExpandOldEditFragment)localFragment).b();
    }
  }
  
  private void t()
  {
    if (this.I)
    {
      this.m.setVisibility(0);
      this.A.setVisibility(8);
    }
  }
  
  private void u()
  {
    if (this.I)
    {
      this.m.setVisibility(8);
      this.A.setVisibility(0);
    }
  }
  
  public void a()
  {
    if (this.h)
    {
      XEditTextEx localXEditTextEx = this.b;
      if (localXEditTextEx != null) {
        InputMethodUtil.b(localXEditTextEx);
      }
    }
  }
  
  public void a(ExtendFriendInfo paramExtendFriendInfo)
  {
    if (this.I)
    {
      if (!TextUtils.isEmpty(paramExtendFriendInfo.a))
      {
        this.k = paramExtendFriendInfo.a;
      }
      else
      {
        this.k = "";
        paramExtendFriendInfo.a = "";
      }
      this.b.setText(paramExtendFriendInfo.a);
      this.c.setText(paramExtendFriendInfo.a);
      int i1 = paramExtendFriendInfo.a.length();
      this.b.setSelection(i1);
      a();
      if (!TextUtils.isEmpty(paramExtendFriendInfo.d))
      {
        t();
        this.n = paramExtendFriendInfo.d;
        this.J = paramExtendFriendInfo.e;
        this.m.setVoiceDuration(this.J);
        this.m.setVoiceUrl(this.n);
        if (this.n.indexOf("file_md5=") <= 0) {
          this.m.setVoiceFileMD5(MD5Utils.encodeFileHexStr(this.n));
        }
        this.K = true;
      }
      else
      {
        u();
        this.K = false;
      }
      b(paramExtendFriendInfo);
      if (!SimpleUIUtil.e())
      {
        ExpandOldEditFragment localExpandOldEditFragment = this.r;
        if ((localExpandOldEditFragment != null) && (localExpandOldEditFragment.e() != null) && (this.r.e().getmAdapter() != null))
        {
          i1 = paramExtendFriendInfo.f;
          if (paramExtendFriendInfo.h != 0) {
            i1 = paramExtendFriendInfo.h;
          }
          this.r.e().setUsingItem(i1);
          this.r.e().getmAdapter().b(i1);
          this.r.a = 3;
        }
        localExpandOldEditFragment = this.r;
        if ((localExpandOldEditFragment != null) && (localExpandOldEditFragment.f() != null) && (this.r.f().getmAdapter() != null))
        {
          i1 = paramExtendFriendInfo.g;
          if (paramExtendFriendInfo.i != 0) {
            i1 = paramExtendFriendInfo.i;
          }
          this.r.f().setUsingItem(i1);
          this.r.f().getmAdapter().b(i1);
          this.r.a = 2;
        }
      }
      this.g = paramExtendFriendInfo;
      if ((paramExtendFriendInfo.k) || (paramExtendFriendInfo.j)) {
        this.c.performClick();
      }
      return;
    }
    this.g = paramExtendFriendInfo;
  }
  
  public void a(ExpandOldEditFragment paramExpandOldEditFragment)
  {
    this.r = paramExpandOldEditFragment;
  }
  
  public void a(AudioInfo paramAudioInfo)
  {
    this.w = paramAudioInfo;
    if (!TextUtils.isEmpty(paramAudioInfo.path))
    {
      this.n = paramAudioInfo.path;
      this.J = paramAudioInfo.duration;
      t();
      this.m.setVoiceDuration(this.J / 1000);
      this.m.setVoiceUrl(this.n);
      if (this.n.indexOf("file_md5=") <= 0) {
        this.m.setVoiceFileMD5(MD5Utils.encodeFileHexStr(this.n));
      }
      this.L = true;
      r();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    TextView localTextView = this.v;
    if (localTextView == null) {
      return;
    }
    if (paramBoolean)
    {
      localTextView.setTextColor(-11692801);
      this.v.setOnClickListener(this);
      this.v.setClickable(true);
      return;
    }
    localTextView.setTextColor(-3355444);
    this.v.setOnClickListener(null);
    this.v.setClickable(false);
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (c(paramString)) {
        return false;
      }
      HashSet localHashSet = new HashSet();
      int i1 = 0;
      while (i1 < paramString.length())
      {
        char c1 = paramString.charAt(i1);
        if (!localHashSet.contains(Character.valueOf(c1)))
        {
          if (localHashSet.size() >= 3) {
            return true;
          }
          localHashSet.add(Character.valueOf(c1));
        }
        i1 += 1;
      }
    }
    return false;
  }
  
  public ExtendFriendInfo b()
  {
    ExtendFriendInfo localExtendFriendInfo = new ExtendFriendInfo();
    localExtendFriendInfo.d = this.n;
    localExtendFriendInfo.a = d(this.b.getText().toString());
    MediaInfo localMediaInfo = this.w;
    if ((localMediaInfo != null) && ((localMediaInfo instanceof AudioInfo)))
    {
      localExtendFriendInfo.e = (((AudioInfo)localMediaInfo).duration / 1000);
      return localExtendFriendInfo;
    }
    localExtendFriendInfo.e = this.J;
    return localExtendFriendInfo;
  }
  
  public void b(ExtendFriendInfo paramExtendFriendInfo)
  {
    if (getQBaseActivity() != null)
    {
      if (paramExtendFriendInfo == null) {
        return;
      }
      if ((!TextUtils.isEmpty(paramExtendFriendInfo.l)) && (!TextUtils.isEmpty(paramExtendFriendInfo.m)))
      {
        this.s.setVisibility(0);
        this.e.setVisibility(8);
        TextView localTextView = this.u;
        String str = paramExtendFriendInfo.m;
        int i1;
        if (paramExtendFriendInfo.n == 2L) {
          i1 = 2130846614;
        } else {
          i1 = 2130846615;
        }
        localTextView.setText(ProfileCardUtil.a(str, false, i1, 2131299145, 2131299144, getQBaseActivity(), this.q, null));
        if (paramExtendFriendInfo.n == 2L)
        {
          this.v.setVisibility(8);
        }
        else if (paramExtendFriendInfo.n == 0L)
        {
          this.v.setVisibility(0);
          this.v.setText(2131896746);
          a(true);
        }
        else if (paramExtendFriendInfo.n == 1L)
        {
          this.v.setVisibility(0);
          this.v.setText(2131896747);
          a(false);
        }
        else
        {
          this.v.setVisibility(0);
          this.v.setText(2131896746);
          a(true);
        }
        this.s.post(new ExtendFriendOldProfileEditFragment.7(this, paramExtendFriendInfo));
        this.s.setOnClickListener(new ExtendFriendOldProfileEditFragment.8(this, paramExtendFriendInfo));
      }
      else
      {
        this.v.setVisibility(8);
        this.s.setVisibility(8);
        this.e.setVisibility(0);
        this.f.setImageResource(2130846569);
        this.f.setOnClickListener(new ExtendFriendOldProfileEditFragment.6(this));
      }
      this.g = paramExtendFriendInfo;
    }
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.n = paramString;
    }
  }
  
  public boolean c()
  {
    String str2 = this.b.getText().toString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    str2 = this.k;
    return ((str2 != null) && (!str2.equals(str1))) || (this.L);
  }
  
  public void d()
  {
    Object localObject1 = AVBizModuleFactory.getModuleByName("默认");
    if (!"true".equals(((IModule)localObject1).checkAVFocus()))
    {
      Object localObject2 = ((IModule)localObject1).getFocusBusiness().keySet().iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject2).next();
        localObject1 = (String)((IModule)localObject1).getFocusBusiness().get(localObject2);
      }
      else
      {
        localObject1 = "音频正忙";
      }
      QQToast.makeText(getContext(), String.format(getResources().getString(2131887170), new Object[] { localObject1 }), 1).show();
      return;
    }
    localObject1 = ((IExpandManager)this.q.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).t();
    int i1;
    if (localObject1 == null) {
      i1 = 11000;
    } else {
      i1 = ((ExpandConfig)localObject1).voiceMaxLength * 1000;
    }
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("audio_max_length", i1);
    ((Intent)localObject1).putExtra("auto_start", true);
    ((Intent)localObject1).putExtra("public_fragment_window_feature", 1);
    ((Intent)localObject1).putExtra("click_space_cancel", false);
    PublicFragmentActivity.Launcher.a(getQBaseActivity(), (Intent)localObject1, PublicTransFragmentActivity.class, AudioRecordFragment.class, 1003);
    this.l = true;
    r();
  }
  
  public boolean e()
  {
    XEditTextEx localXEditTextEx = this.b;
    boolean bool = false;
    if (localXEditTextEx == null) {
      return false;
    }
    int i1 = localXEditTextEx.getScrollY();
    int i2 = this.b.getLayout().getHeight() - (this.b.getHeight() - this.b.getCompoundPaddingTop() - this.b.getCompoundPaddingBottom());
    if (i2 == 0) {
      return false;
    }
    if ((i1 > 0) || (i1 < i2 - 1)) {
      bool = true;
    }
    return bool;
  }
  
  public void f()
  {
    OldExpandVoiceView localOldExpandVoiceView = this.m;
    if ((localOldExpandVoiceView != null) && (localOldExpandVoiceView.a())) {
      this.m.c();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131449972: 
      if (this.m.a())
      {
        this.m.c();
        return;
      }
      this.m.b();
      return;
    case 2131448275: 
      if ((getQBaseActivity() != null) && (this.g != null))
      {
        CampusHelper.a(getQBaseActivity(), this.g.o, this.g.m, this.g.l);
        return;
      }
      break;
    case 2131432644: 
      this.c.setVisibility(8);
      this.b.setVisibility(0);
    case 2131432625: 
      this.i = true;
      this.b.setFocusableInTouchMode(true);
      this.b.setFocusable(true);
      this.b.requestFocus();
      InputMethodUtil.a(this.b);
      if (this.r != null)
      {
        paramView = this.g;
        if ((paramView != null) && (!paramView.j) && (!this.g.k))
        {
          this.r.b(0);
          return;
        }
      }
      break;
    case 2131429985: 
      l();
      return;
    case 2131429909: 
      d();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.p = paramLayoutInflater.inflate(2131627438, paramViewGroup, false);
    this.q = ((QQAppInterface)getQBaseActivity().getAppRuntime());
    h();
    g();
    if ((getActivity() != null) && (CampusHelper.d(this.q)))
    {
      CampusHelper.a(this.q, false);
      getActivity().setResult(8193);
    }
    return this.p;
  }
  
  public void onPause()
  {
    super.onPause();
    OldExpandVoiceView localOldExpandVoiceView = this.m;
    if ((localOldExpandVoiceView != null) && (localOldExpandVoiceView.a())) {
      this.m.c();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.M = this.c.getLineCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendOldProfileEditFragment
 * JD-Core Version:    0.7.0.1
 */