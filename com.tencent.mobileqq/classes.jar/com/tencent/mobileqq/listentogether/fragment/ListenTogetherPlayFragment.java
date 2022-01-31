package com.tencent.mobileqq.listentogether.fragment;

import abju;
import aciy;
import ajjy;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aome;
import aora;
import aqvd;
import aqvp;
import aqvv;
import aqwm;
import aqwn;
import aqwo;
import aqxa;
import arey;
import arfg;
import arfr;
import arzv;
import arzw;
import arzy;
import asas;
import awmc;
import awqx;
import axwd;
import azwp;
import azzz;
import babh;
import bacm;
import badq;
import bajq;
import bbmy;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.lyric.widget.LyricViewDetail;
import com.tencent.mobileqq.lyric.widget.LyricViewInternal;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListenTogetherPlayFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new aqwo(this);
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  aora jdField_a_of_type_Aora;
  public aqvd a;
  aqvp jdField_a_of_type_Aqvp = new aqwn(this);
  arfr jdField_a_of_type_Arfr;
  arzw jdField_a_of_type_Arzw = new aqwm(this);
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ListenTogetherManager jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager;
  public ListenTogetherSession a;
  public ISong a;
  LyricViewDetail jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail;
  AvatarLayout jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
  public String a;
  boolean jdField_a_of_type_Boolean;
  ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[5];
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  View jdField_d_of_type_AndroidViewView;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  ImageView e;
  ImageView f;
  
  private String a(int paramInt)
  {
    if (paramInt == 1) {
      return "Grp_AIO";
    }
    if (paramInt == 2) {
      return "c2c_AIO";
    }
    return "";
  }
  
  private List<String> a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.c();
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("getC2CUins status=%d msg=%s", new Object[] { Integer.valueOf(i), this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_a_of_type_JavaLangString }));
    }
    ArrayList localArrayList = new ArrayList();
    switch (i)
    {
    default: 
      return localArrayList;
    case 3: 
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_JavaLangString);
      return localArrayList;
    case 2: 
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_JavaLangString);
      return localArrayList;
    }
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    return localArrayList;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager = ((ListenTogetherManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(331));
    this.jdField_a_of_type_Aqvd = ((aqvd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aqvp);
    int[] arrayOfInt = arzy.a(-1315339);
    a(arrayOfInt[0], arrayOfInt[1], true);
    a(this.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong.a());
    a(this.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong.a(), this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.g, this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_Int == 1) {
      this.jdField_a_of_type_Aqvd.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_JavaLangString);
    }
    a(a(), this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_a_of_type_JavaLangString);
    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a().b(true);
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = getActivity();
    if ((localObject == null) || (((Activity)localObject).isFinishing()) || (!isAdded())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("onGetColors [0x%x 0x%x]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    int i = Color.argb(0, Color.red(paramInt1), Color.green(paramInt1), Color.blue(paramInt1));
    localObject = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt1, i, i, i, i, i, paramInt1 });
    this.e.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(paramInt1);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundColor(paramInt1);
      this.e.setImageResource(2130840179);
      this.e.setScaleType(ImageView.ScaleType.CENTER);
    }
    for (;;)
    {
      paramInt1 = Color.argb(128, Color.red(paramInt2), Color.green(paramInt2), Color.blue(paramInt2));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt2);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramInt2);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramInt2);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.a().setLyricHilightColor(paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.a().setLyricColor(paramInt1);
      this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      this.jdField_b_of_type_AndroidWidgetImageView.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      this.jdField_c_of_type_AndroidWidgetImageView.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      this.jdField_d_of_type_AndroidWidgetImageView.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      this.f.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      if (this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout != null) {
        a(((DynamicAvatarView)this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131297539)).getBackground(), paramInt2);
      }
      paramInt1 = 0;
      while (paramInt1 < this.jdField_a_of_type_ArrayOfAndroidWidgetImageView.length)
      {
        localObject = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[paramInt1];
        a(((ImageView)localObject).getBackground(), paramInt2);
        ((ImageView)localObject).setTag(Integer.valueOf(paramInt2));
        paramInt1 += 1;
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundColor(0);
      this.e.setImageDrawable(null);
    }
    localObject = getResources().getDrawable(2130840180);
    ((Drawable)localObject).setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
    this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject, null);
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_Int == 1) {
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject, null);
    }
    for (;;)
    {
      localObject = this.jdField_c_of_type_AndroidWidgetTextView.getBackground();
      if (localObject == null) {
        break;
      }
      ((Drawable)localObject).setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      return;
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (paramInt == 1) {}
    awqx.b(null, "dc00899", a(paramInt), "", paramString2, paramString3, 0, 0, paramString1, "", "", "");
  }
  
  public static void a(Context paramContext, ListenTogetherSession paramListenTogetherSession, ISong paramISong, boolean paramBoolean, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("session", paramListenTogetherSession);
    localIntent.putExtra("song", paramISong);
    localIntent.putExtra("isAdmin", paramBoolean);
    abju.a(paramContext, localIntent, PublicFragmentActivity.class, ListenTogetherPlayFragment.class);
  }
  
  private void a(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable instanceof ShapeDrawable)) {
      ((ShapeDrawable)paramDrawable).getPaint().setColor(paramInt);
    }
    for (;;)
    {
      if (paramDrawable != null) {
        paramDrawable.invalidateSelf();
      }
      return;
      if ((paramDrawable instanceof GradientDrawable)) {
        ((GradientDrawable)paramDrawable).setColor(paramInt);
      }
    }
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131310524));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131310548));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131306058));
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail = ((LyricViewDetail)paramView.findViewById(2131303944));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131304916));
    this.e = ((ImageView)paramView.findViewById(2131304907));
    this.f = ((ImageView)paramView.findViewById(2131304906));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131302532);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131309754);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131311720));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131311714);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131303746);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131306053));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131306047));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131306046));
    int i = 0;
    while (i < 5)
    {
      ImageView localImageView = (ImageView)this.jdField_c_of_type_AndroidViewView.findViewWithTag("head" + i);
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i] = localImageView;
      i += 1;
    }
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299794));
    ((ViewGroup.MarginLayoutParams)this.f.getLayoutParams()).topMargin = aciy.a(31.0F, getResources());
    this.f.setImageResource(2130844442);
    this.f.setBackgroundResource(2130838484);
    a(this.f.getBackground(), 1275068416);
    if (!b())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.2F);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.f.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_c_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_Arfr = new arfr(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail);
    if (awmc.a > 0) {
      paramView.findViewById(2131304905).getLayoutParams().height = awmc.a;
    }
    b();
  }
  
  private void a(ISong paramISong)
  {
    int j = 0;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramISong.b());
    String str = paramISong.d();
    Object localObject1;
    Object localObject2;
    int i;
    if ((!TextUtils.isEmpty(str)) && (Patterns.WEB_URL.matcher(str).matches()))
    {
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = axwd.a;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = axwd.a;
      ((URLDrawable.URLDrawableOptions)localObject1).mMemoryCacheKeySuffix = "original";
      localObject1 = URLDrawable.getDrawable(paramISong.d(), (URLDrawable.URLDrawableOptions)localObject1);
      localObject2 = arzv.a(paramISong.d());
      if (localObject2 != null)
      {
        a(((Integer)((List)localObject2).get(0)).intValue(), ((Integer)((List)localObject2).get(1)).intValue(), false);
        i = 1;
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ListenTogetherPlayFragment", 2, String.format("updateSongInfo type=%d album=%s", new Object[] { Integer.valueOf(i), str }));
      }
      str = MusicInfo.a(paramISong.b());
      i = MusicInfo.a(paramISong.b());
      if (paramISong.a() > 0L)
      {
        paramISong = MusicInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_JavaLangString, paramISong.a());
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        i = j;
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramISong);
        if (i == 0) {
          break label376;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(i), null, null, null);
        return;
        localObject2 = new arzv(str, this.jdField_a_of_type_Arzw, null);
        if (((URLDrawable)localObject1).getStatus() == 1)
        {
          Drawable localDrawable = ((URLDrawable)localObject1).getCurrDrawable();
          if ((localDrawable instanceof RegionDrawable)) {
            ThreadManager.postImmediately(new ListenTogetherPlayFragment.2(this, (arzv)localObject2, ((RegionDrawable)localDrawable).getBitmap()), null, true);
          }
          i = 2;
          break;
        }
        i = 3;
        ((URLDrawable)localObject1).setDecodeHandler((DownloadParams.DecodeHandler)localObject2);
        break;
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramISong = str;
      }
      label376:
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      return;
      i = 0;
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    String str = (String)this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.getTag();
    if (TextUtils.isEmpty(paramString2))
    {
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(4);
      this.jdField_a_of_type_Arfr.b();
      if (paramInt == 1)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840183);
        label49:
        if (b()) {
          break label356;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.2F);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
      }
    }
    else
    {
      label90:
      switch (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.c)
      {
      default: 
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.a().b() == null) || (!azzz.a(str, paramString1)))
        {
          a(paramString2, this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail);
          this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setTag(paramString1);
        }
        break;
      }
    }
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(0);
      long l = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.b();
      int j = (int)l;
      if (paramInt == 1)
      {
        boolean bool = this.jdField_a_of_type_Arfr.a();
        if (!bool) {
          this.jdField_a_of_type_Arfr.a();
        }
        QLog.i("ListenTogetherPlayFragment", 1, "updateLyricPosition() try to seek! playPosition:" + l + " seekPosition:" + j + " isPlaying:" + bool);
        if ((j < 0) && (i == 0)) {
          break;
        }
        paramString1 = this.jdField_a_of_type_Arfr;
        if (j >= 0) {}
        for (i = j;; i = 0)
        {
          paramString1.a(i);
          break;
        }
      }
      if (2 == paramInt)
      {
        if (j >= 0) {
          this.jdField_a_of_type_Arfr.a(j);
        }
        this.jdField_a_of_type_Arfr.c();
        break;
      }
      this.jdField_a_of_type_Arfr.b();
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840184);
      break label49;
      label356:
      this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      break label90;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840190);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription("切换播放模式 当前为单曲循环");
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840186);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription("切换播放模式 当前为顺序播放");
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840189);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription("切换播放模式 当前为随机播放");
      return;
    }
  }
  
  private void a(String paramString, ImageView paramImageView)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break label130;
      }
      Drawable localDrawable = bacm.a(true);
      paramString = azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString, 4, localDrawable, localDrawable);
      localDrawable = paramImageView.getDrawable();
      if ((localDrawable != null) && (localDrawable != paramString) && ((localDrawable instanceof azwp))) {
        ((azwp)localDrawable).a();
      }
      paramImageView.setImageDrawable(paramString);
      paramImageView.setVisibility(0);
      if ((paramImageView.getBackground() != null) && ((paramImageView.getBackground() instanceof ShapeDrawable)))
      {
        paramString = paramImageView.getTag();
        if ((paramString instanceof Integer))
        {
          int i = ((Integer)paramString).intValue();
          ((ShapeDrawable)paramImageView.getBackground()).getPaint().setColor(i);
        }
      }
    }
    return;
    label130:
    paramImageView.setImageDrawable(bacm.a(true));
    paramImageView.setVisibility(0);
  }
  
  private void a(String paramString, LyricViewDetail paramLyricViewDetail)
  {
    if (TextUtils.isEmpty(paramString)) {}
    arey localarey1;
    do
    {
      return;
      arey localarey2 = arfg.a(paramString, true);
      localarey1 = localarey2;
      if (localarey2 == null) {
        localarey1 = arfg.a(paramString, false);
      }
    } while (localarey1 == null);
    this.jdField_a_of_type_Arfr.b();
    paramLyricViewDetail.a().setHighlightCurrentLine(true);
    paramLyricViewDetail.a().setHighlightLineNumber(2);
    this.jdField_a_of_type_Arfr.a(paramLyricViewDetail);
    this.jdField_a_of_type_Arfr.a(localarey1, localarey1, null);
  }
  
  private void a(List<String> paramList, String paramString)
  {
    int i;
    int j;
    if (paramList == null)
    {
      i = 0;
      j = 0;
      label9:
      if (j >= 5) {
        break label99;
      }
      if (j >= i) {
        break label73;
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[j].setVisibility(0);
      a((String)paramList.get(j), this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[j]);
    }
    for (;;)
    {
      j += 1;
      break label9;
      i = paramList.size();
      break;
      label73:
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[j].setVisibility(8);
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[j].setImageDrawable(null);
    }
    label99:
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_Int == 1)
    {
      this.jdField_c_of_type_AndroidViewView.setClickable(true);
      this.jdField_c_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
      return;
      this.jdField_c_of_type_AndroidViewView.setClickable(true);
      this.jdField_c_of_type_AndroidViewView.setOnTouchListener(null);
    }
  }
  
  private boolean a()
  {
    Bundle localBundle = getArguments();
    this.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong = ((ISong)localBundle.getParcelable("song"));
    this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession = ((ListenTogetherSession)localBundle.getParcelable("session"));
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("isAdmin");
    return (this.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong != null) && (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession != null);
  }
  
  private void b()
  {
    int i = bajq.a();
    int j = bajq.b();
    if ((j > 0) && (i > 0))
    {
      i = j - i - bajq.a(312.0F);
      if (i < 0)
      {
        if (i <= bajq.a(50.0F) * -1) {
          break label58;
        }
        ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).topMargin = i;
      }
    }
    return;
    label58:
    ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).topMargin = (i + bajq.a(34.0F));
  }
  
  private void b(View paramView)
  {
    int i = 1;
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)paramView.findViewById(2131301766));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    paramView = paramView.findViewById(2131301783);
    paramView.setVisibility(0);
    ((ViewGroup.MarginLayoutParams)paramView.getLayoutParams()).topMargin = aciy.a(28.0F, getResources());
    paramView = bacm.a(true);
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_Int == 2) {}
    for (;;)
    {
      Object localObject = azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_JavaLangString, 4, paramView, paramView);
      paramView = (DynamicAvatarView)this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131297539);
      paramView.setImageDrawable((Drawable)localObject);
      i = aciy.a(1.5F, getResources());
      paramView.setPadding(i, i, i, i);
      paramView.setBackgroundResource(2130838484);
      localObject = (ImageView)((View)this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getParent()).findViewById(2131301806);
      this.jdField_a_of_type_Aora = new aora(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_Aora.a((View)localObject);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, paramView, false);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(this);
      return;
      i = 4;
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.f));
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().addFlags(256);
    paramActivity.overridePendingTransition(2130771997, 2130771990);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    int j = 1;
    int i = 1;
    boolean bool = badq.g(getActivity());
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131306058: 
      if (!b())
      {
        bbmy.a(getActivity(), ajjy.a(2131640383), 1).a();
        return;
      }
      if (!bool)
      {
        bbmy.a(getActivity(), 1, getActivity().getString(2131629228), 0).a();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.g == 1)
      {
        ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.g = 2;
      }
      break;
    }
    while (i != 0)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong.a(), this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.g, this.jdField_a_of_type_JavaLangString);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.g == 2)
      {
        ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.g = 1;
        continue;
        if (!b()) {
          break;
        }
        if (!bool)
        {
          bbmy.a(getActivity(), 1, getActivity().getString(2131629228), 0).a();
          return;
        }
        i = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.c + 1;
        if (i > 3) {
          i = 1;
        }
        for (;;)
        {
          ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).f(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_JavaLangString, i);
          awqx.b(null, "dc00899", a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_Int), "", "music_tab", "clk_mode", 0, 0, "", "", "" + i, "");
          return;
          if (!b()) {
            break;
          }
          if (!bool)
          {
            bbmy.a(getActivity(), 1, getActivity().getString(2131629228), 0).a();
            return;
          }
          ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).e(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_JavaLangString, 2);
          awqx.b(null, "dc00899", a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_Int), "", "music_tab", "clk_cut", 0, 0, "", "", "", "");
          return;
          if (!b()) {
            break;
          }
          if (!bool)
          {
            bbmy.a(getActivity(), 1, getActivity().getString(2131629228), 0).a();
            return;
          }
          ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).e(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_JavaLangString, 1);
          awqx.b(null, "dc00899", a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_Int), "", "music_tab", "clk_cut", 0, 0, "", "", "", "");
          return;
          getActivity().finish();
          return;
          if (!bool)
          {
            bbmy.a(getActivity(), 1, getActivity().getString(2131629228), 0).a();
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_Int == 1) {
            aqvv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_JavaLangString);
          }
          a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_JavaLangString, "music_tab", "clk_member");
          return;
          if (asas.a(getActivity(), "com.tencent.qqmusic"))
          {
            paramView = new Intent("android.intent.action.VIEW", Uri.parse(asas.jdField_a_of_type_JavaLangString));
            paramView.putExtra("big_brother_source_key", "biz_src_qqmusic");
            getActivity().startActivity(paramView);
            a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_JavaLangString, "music_tab", "clk_openmusic");
            return;
          }
          if (!bool)
          {
            bbmy.a(getActivity(), 1, getActivity().getString(2131629228), 0).a();
            return;
          }
          if (!aome.a().a("http://misc.wcd.qq.com/app?packageName=com.tencent.qqmusic&channelId=10034308")) {
            ThreadManager.post(new ListenTogetherPlayFragment.5(this), 5, null, true);
          }
          a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_JavaLangString, "music_tab", "clk_downloadmusic");
          return;
          paramView = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_JavaLangString;
          if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_e_of_type_Int == 1) {}
          for (i = j;; i = 0)
          {
            if (this.jdField_a_of_type_Aora != null) {
              this.jdField_a_of_type_Aora.a();
            }
            String str = babh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, i);
            MiniChatActivity.a(getActivity(), i, paramView, str);
            return;
          }
        }
      }
      i = 0;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    View localView = paramLayoutInflater.inflate(2131495262, paramViewGroup, false);
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (!a())
    {
      getActivity().finish();
      return localView;
    }
    localView.setClickable(true);
    a(localView);
    a();
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aqvp);
    }
    if (this.jdField_a_of_type_Arfr != null) {
      this.jdField_a_of_type_Arfr.b();
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a().c(false);
      this.jdField_b_of_type_Boolean = false;
    }
    this.jdField_a_of_type_Aora.d();
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(2130771990, 2130772001);
    if (this.jdField_b_of_type_Boolean)
    {
      ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a().c(false);
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Aora.c();
  }
  
  public void onResume()
  {
    super.onResume();
    boolean bool2 = asas.a(getActivity());
    boolean bool1;
    if (!bool2)
    {
      bool1 = true;
      localObject = this.jdField_c_of_type_AndroidWidgetTextView.getTag();
      if ((localObject instanceof Boolean)) {
        bool1 = ((Boolean)localObject).booleanValue();
      }
      if (bool1 != bool2) {
        if (!bool2) {
          break label89;
        }
      }
    }
    label89:
    for (Object localObject = ajjy.a(2131640381);; localObject = ajjy.a(2131640384))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_c_of_type_AndroidWidgetTextView.setTag(Boolean.valueOf(bool2));
      this.jdField_a_of_type_Aora.b();
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment
 * JD-Core Version:    0.7.0.1
 */