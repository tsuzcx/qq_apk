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
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import com.tencent.mobileqq.qqexpand.bean.profile.ExtendFriendInfo;
import com.tencent.mobileqq.qqexpand.config.ExpandConfig;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.utils.BackgroundUtil;
import com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoiceView;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.activity.AudioRecordFragment;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.troop.data.MediaInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.MD5Utils;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;

public class ExpandProfileEditFragment
  extends QBaseFragment
  implements View.OnClickListener
{
  public static final ColorDrawable a = new ColorDrawable(-657931);
  private ImageView A;
  private ProgressBar B;
  private boolean C;
  private int D = 0;
  private boolean E;
  private boolean F = false;
  private int G = 0;
  private int H;
  private int I = -1;
  private String[] J;
  private QQToast K;
  public XEditTextEx b;
  public ETTextView c;
  public View d;
  public ExtendFriendInfo e;
  public boolean f = false;
  public boolean g = false;
  public int h = 20;
  public String i;
  public boolean j = false;
  protected ExpandVoiceView k;
  String l = "";
  TextWatcher m = new ExpandProfileEditFragment.1(this);
  private View n;
  private QQAppInterface o;
  private ExpandEditFragment p;
  private MediaInfo q;
  private RelativeLayout r;
  private ImageView s;
  private View t;
  private View u;
  private TextView v;
  private Drawable w;
  private Drawable x;
  private ImageView y;
  private TextView z;
  
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
    i();
  }
  
  private void h()
  {
    this.b = ((XEditTextEx)this.n.findViewById(2131432625));
    this.b.setVisibility(8);
    this.r = ((RelativeLayout)this.n.findViewById(2131445001));
    this.s = ((ImageView)this.n.findViewById(2131429909));
    this.v = ((TextView)this.n.findViewById(2131447590));
    this.u = this.n.findViewById(2131433309);
    this.t = this.n.findViewById(2131437983);
    this.w = new BitmapDrawable(BackgroundUtil.a(AIOUtils.b(27.0F, getResources()), -15550475, 1.0F));
    this.x = new BitmapDrawable(BackgroundUtil.a(AIOUtils.b(27.0F, getResources()), -16777216, 0.08F));
    this.s.setBackgroundDrawable(this.w);
    this.c = ((ETTextView)this.n.findViewById(2131432644));
    this.c.setOnClickListener(this);
    this.c.setVisibility(0);
    this.c.setTextColor(-16777216);
    this.d = this.n.findViewById(2131449306);
    this.b.setOnClickListener(this);
    this.b.addTextChangedListener(this.m);
    Object localObject = getParentFragment();
    if ((localObject != null) && ((localObject instanceof ExpandEditFragment))) {
      this.b.setOnTouchListener((ExpandEditFragment)localObject);
    }
    m();
    this.b.setBackgroundDrawable(new ColorDrawable(-526345));
    this.r.setBackgroundDrawable(a);
    this.c.setBackgroundDrawable(new ColorDrawable(-526345));
    this.t.setBackgroundDrawable(this.x);
    this.s.setOnTouchListener(new ExpandProfileEditFragment.2(this));
    this.s.setOnClickListener(this);
    this.y = ((ImageView)this.n.findViewById(2131435528));
    this.z = ((TextView)this.n.findViewById(2131448370));
    this.A = ((ImageView)this.n.findViewById(2131429985));
    this.B = ((ProgressBar)this.n.findViewById(2131439917));
    this.A.setOnClickListener(this);
    this.n.getViewTreeObserver().addOnGlobalLayoutListener(new ExpandProfileEditFragment.3(this));
    this.C = true;
    localObject = this.e;
    if (localObject != null) {
      a((ExtendFriendInfo)localObject);
    }
  }
  
  private void i()
  {
    if (this.J == null) {
      this.J = getResources().getStringArray(2130968621);
    }
    if (this.I == -1) {
      this.I = new Random().nextInt(this.J.length);
    }
    this.I += 1;
    int i1 = this.I;
    Object localObject = this.J;
    this.I = (i1 % localObject.length);
    this.z.setText(localObject[this.I]);
    localObject = String.format("https://down.qq.com/innovate/qqexpand/avatarList/expand_avatar_%d.jpg", new Object[] { Integer.valueOf(new Random().nextInt(299) + 1) });
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = ImageUtil.j();
    localURLDrawableOptions.mLoadingDrawable = ImageUtil.j();
    localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
    ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.b);
    this.y.setImageDrawable((Drawable)localObject);
  }
  
  private void j()
  {
    this.A.setVisibility(8);
    this.B.setVisibility(0);
  }
  
  private void k()
  {
    this.A.setVisibility(0);
    this.B.setVisibility(8);
  }
  
  private void l()
  {
    if (this.J == null) {
      return;
    }
    j();
    ThreadManager.getUIHandler().postDelayed(new ExpandProfileEditFragment.4(this), 1000L);
  }
  
  private void m()
  {
    this.k = ((ExpandVoiceView)this.n.findViewById(2131435621));
    this.k.setOnClickListener(this);
    this.k.setActivity(getQBaseActivity());
    this.k.setDeleteIconEnable(true, new ExpandProfileEditFragment.5(this));
  }
  
  private void n()
  {
    this.f = false;
    q();
    if (!TextUtils.isEmpty(this.l)) {
      this.k.setVisibility(0);
    } else {
      this.u.setVisibility(0);
    }
    ExpandEditFragment localExpandEditFragment = this.p;
    if ((localExpandEditFragment != null) && (localExpandEditFragment.a == 0)) {
      this.p.a();
    }
  }
  
  private void o()
  {
    this.f = true;
    XEditTextEx localXEditTextEx = this.b;
    localXEditTextEx.setSelection(localXEditTextEx.getText().length());
    p();
    this.k.setVisibility(8);
    this.u.setVisibility(8);
  }
  
  private void p()
  {
    int i1 = getResources().getDisplayMetrics().heightPixels;
    int i2 = this.H;
    int i3 = ImmersiveUtils.getStatusBarHeight(getQBaseActivity());
    int i4 = this.v.getHeight();
    int i5 = AIOUtils.b(96.0F, getResources());
    this.b.setMaxHeight(i1 - i2 - i3 - i4 - i5);
  }
  
  private void q()
  {
    this.b.setMaxHeight(2147483647);
  }
  
  private void r()
  {
    if (this.C)
    {
      this.k.setVisibility(0);
      this.u.setVisibility(8);
    }
  }
  
  private void s()
  {
    if (this.C)
    {
      this.k.setVisibility(8);
      this.u.setVisibility(0);
    }
  }
  
  public void a()
  {
    if (this.f)
    {
      XEditTextEx localXEditTextEx = this.b;
      if (localXEditTextEx != null) {
        InputMethodUtil.b(localXEditTextEx);
      }
    }
  }
  
  public void a(ExtendFriendInfo paramExtendFriendInfo)
  {
    if (this.C)
    {
      if (!TextUtils.isEmpty(paramExtendFriendInfo.a))
      {
        this.i = paramExtendFriendInfo.a;
      }
      else
      {
        this.i = "";
        paramExtendFriendInfo.a = "";
      }
      this.b.setText(paramExtendFriendInfo.a);
      this.c.setText(new QQText(QzoneEmotionUtils.emCodesToQQcodes(paramExtendFriendInfo.a), 3, 24));
      int i1 = paramExtendFriendInfo.a.length();
      this.b.setSelection(i1);
      a();
      if (!TextUtils.isEmpty(paramExtendFriendInfo.d))
      {
        r();
        this.l = paramExtendFriendInfo.d;
        this.D = paramExtendFriendInfo.e;
        this.k.setVoiceDuration(this.D);
        this.k.setVoiceUrl(this.l);
        if (this.l.indexOf("file_md5=") <= 0) {
          this.k.setVoiceFileMD5(MD5Utils.encodeFileHexStr(this.l));
        }
        this.E = true;
      }
      else
      {
        s();
        this.E = false;
      }
      this.e = paramExtendFriendInfo;
      return;
    }
    this.e = paramExtendFriendInfo;
  }
  
  public void a(ExpandEditFragment paramExpandEditFragment)
  {
    this.p = paramExpandEditFragment;
  }
  
  public void a(AudioInfo paramAudioInfo)
  {
    this.q = paramAudioInfo;
    if (!TextUtils.isEmpty(paramAudioInfo.path))
    {
      this.l = paramAudioInfo.path;
      this.D = paramAudioInfo.duration;
      r();
      this.k.setVoiceDuration(this.D / 1000);
      this.k.setVoiceUrl(this.l);
      if (this.l.indexOf("file_md5=") <= 0) {
        this.k.setVoiceFileMD5(MD5Utils.encodeFileHexStr(this.l));
      }
      this.F = true;
    }
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
    localExtendFriendInfo.d = this.l;
    localExtendFriendInfo.a = d(this.b.getText().toString());
    MediaInfo localMediaInfo = this.q;
    if ((localMediaInfo != null) && ((localMediaInfo instanceof AudioInfo)))
    {
      localExtendFriendInfo.e = (((AudioInfo)localMediaInfo).duration / 1000);
      return localExtendFriendInfo;
    }
    localExtendFriendInfo.e = this.D;
    return localExtendFriendInfo;
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.l = paramString;
    }
  }
  
  public boolean c()
  {
    String str2 = this.b.getText().toString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    str2 = this.i;
    return ((str2 != null) && (!str2.equals(str1))) || (this.F);
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
    localObject1 = ((IExpandManager)this.o.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).t();
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
    this.j = true;
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
    ExpandVoiceView localExpandVoiceView = this.k;
    if ((localExpandVoiceView != null) && (localExpandVoiceView.a())) {
      this.k.c();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131449972: 
      if (this.k.a())
      {
        this.k.c();
        return;
      }
      this.k.b();
      return;
    case 2131432644: 
      this.c.setVisibility(8);
      this.b.setVisibility(0);
    case 2131432625: 
      this.g = true;
      this.b.setFocusableInTouchMode(true);
      this.b.setFocusable(true);
      this.b.requestFocus();
      InputMethodUtil.a(this.b);
      return;
    case 2131429985: 
      l();
      return;
    }
    d();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.n = paramLayoutInflater.inflate(2131627424, paramViewGroup, false);
    this.o = ((QQAppInterface)getQBaseActivity().getAppRuntime());
    h();
    g();
    return this.n;
  }
  
  public void onPause()
  {
    super.onPause();
    ExpandVoiceView localExpandVoiceView = this.k;
    if ((localExpandVoiceView != null) && (localExpandVoiceView.a())) {
      this.k.c();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.G = this.c.getLineCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandProfileEditFragment
 * JD-Core Version:    0.7.0.1
 */