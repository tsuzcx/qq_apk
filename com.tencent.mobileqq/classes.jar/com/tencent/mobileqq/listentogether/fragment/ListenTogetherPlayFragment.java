package com.tencent.mobileqq.listentogether.fragment;

import aeow;
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
import anvx;
import atth;
import auht;
import awev;
import awfk;
import awfq;
import awgj;
import awgk;
import awgl;
import awgx;
import awpy;
import awqg;
import awqr;
import axkp;
import axkq;
import axks;
import axlm;
import bdla;
import bhbx;
import bheg;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.lyric.widget.LyricViewDetail;
import com.tencent.mobileqq.lyric.widget.LyricViewInternal;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListenTogetherPlayFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new awgl(this);
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  atth jdField_a_of_type_Atth;
  public awev a;
  awfk jdField_a_of_type_Awfk = new awgk(this);
  awqr jdField_a_of_type_Awqr;
  axkq jdField_a_of_type_Axkq = new awgj(this);
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
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e);
      return localArrayList;
    case 2: 
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e);
      return localArrayList;
    }
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    return localArrayList;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager = ((ListenTogetherManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER));
    this.jdField_a_of_type_Awev = ((awev)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Awfk);
    int[] arrayOfInt = axks.a(-1315339);
    a(arrayOfInt[0], arrayOfInt[1], true);
    a(this.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong.a());
    a(this.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong.a(), this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.h, this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int == 1) {
      this.jdField_a_of_type_Awev.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e);
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
      this.e.setImageResource(2130840590);
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
        a(((DynamicAvatarView)this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363426)).getBackground(), paramInt2);
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
    localObject = getResources().getDrawable(2130840591);
    ((Drawable)localObject).setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
    this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject, null);
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int == 1) {
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
    bdla.b(null, "dc00899", a(paramInt), "", paramString2, paramString3, 0, 0, paramString1, "", "", "");
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
    aeow.a(paramContext, localIntent, PublicFragmentActivity.class, ListenTogetherPlayFragment.class);
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377881));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377906));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372936));
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail = ((LyricViewDetail)paramView.findViewById(2131370597));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131371731));
    this.e = ((ImageView)paramView.findViewById(2131371722));
    this.f = ((ImageView)paramView.findViewById(2131371721));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131368873);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376967);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379197));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131379191);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131370363);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372931));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372925));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372924));
    int i = 0;
    while (i < 5)
    {
      ImageView localImageView = (ImageView)this.jdField_c_of_type_AndroidViewView.findViewWithTag("head" + i);
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i] = localImageView;
      i += 1;
    }
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365857));
    ((ViewGroup.MarginLayoutParams)this.f.getLayoutParams()).topMargin = AIOUtils.dp2px(31.0F, getResources());
    this.f.setImageResource(2130845339);
    this.f.setBackgroundResource(2130838722);
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
    this.jdField_a_of_type_Awqr = new awqr(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail);
    if (ScreenUtil.SCREEN_WIDTH > 0) {
      paramView.findViewById(2131371720).getLayoutParams().height = ScreenUtil.SCREEN_WIDTH;
    }
    b();
  }
  
  private void a(ISong paramISong)
  {
    boolean bool = true;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramISong.b());
    Object localObject1 = paramISong.d();
    Object localObject2;
    Object localObject3;
    int i;
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (Patterns.WEB_URL.matcher((CharSequence)localObject1).matches()))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "original";
      localObject2 = URLDrawable.getDrawable(paramISong.d(), (URLDrawable.URLDrawableOptions)localObject2);
      localObject3 = axkp.a(paramISong.d());
      if (localObject3 != null)
      {
        a(((Integer)((List)localObject3).get(0)).intValue(), ((Integer)((List)localObject3).get(1)).intValue(), false);
        i = 1;
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ListenTogetherPlayFragment", 2, String.format("updateSongInfo type=%d album=%s", new Object[] { Integer.valueOf(i), localObject1 }));
      }
      localObject1 = MusicInfo.a(paramISong.b());
      i = MusicInfo.a(paramISong.b());
      if (paramISong.a() > 0L)
      {
        paramISong = MusicInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e, paramISong.a());
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        i = 0;
        label251:
        localObject1 = this.jdField_c_of_type_AndroidWidgetTextView;
        if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) {
          break label398;
        }
      }
      for (;;)
      {
        ((TextView)localObject1).setClickable(bool);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramISong);
        if (i == 0) {
          break label403;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(i), null, null, null);
        return;
        localObject3 = new axkp((String)localObject1, this.jdField_a_of_type_Axkq, null);
        if (((URLDrawable)localObject2).getStatus() == 1)
        {
          Drawable localDrawable = ((URLDrawable)localObject2).getCurrDrawable();
          if ((localDrawable instanceof RegionDrawable)) {
            ThreadManager.postImmediately(new ListenTogetherPlayFragment.2(this, (axkp)localObject3, ((RegionDrawable)localDrawable).getBitmap()), null, true);
          }
          i = 2;
          break;
        }
        i = 3;
        ((URLDrawable)localObject2).setDecodeHandler((DownloadParams.DecodeHandler)localObject3);
        break;
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramISong = (ISong)localObject1;
        break label251;
        label398:
        bool = false;
      }
      label403:
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
      this.jdField_a_of_type_Awqr.b();
      if (paramInt == 1)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840594);
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
        if ((this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.a().b() == null) || (!bhbx.a(str, paramString1)))
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
        boolean bool = this.jdField_a_of_type_Awqr.a();
        if (!bool) {
          this.jdField_a_of_type_Awqr.a();
        }
        QLog.i("ListenTogetherPlayFragment", 1, "updateLyricPosition() try to seek! playPosition:" + l + " seekPosition:" + j + " isPlaying:" + bool);
        if ((j < 0) && (i == 0)) {
          break;
        }
        paramString1 = this.jdField_a_of_type_Awqr;
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
          this.jdField_a_of_type_Awqr.a(j);
        }
        this.jdField_a_of_type_Awqr.c();
        break;
      }
      this.jdField_a_of_type_Awqr.b();
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840595);
      break label49;
      label356:
      this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      break label90;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840601);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription("切换播放模式 当前为单曲循环");
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840597);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription("切换播放模式 当前为顺序播放");
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840600);
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
      Drawable localDrawable = bheg.a(true);
      paramString = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString, 4, localDrawable, localDrawable);
      localDrawable = paramImageView.getDrawable();
      if ((localDrawable != null) && (localDrawable != paramString) && ((localDrawable instanceof FaceDrawable))) {
        ((FaceDrawable)localDrawable).cancel();
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
    paramImageView.setImageDrawable(bheg.a(true));
    paramImageView.setVisibility(0);
  }
  
  private void a(String paramString, LyricViewDetail paramLyricViewDetail)
  {
    if (TextUtils.isEmpty(paramString)) {}
    awpy localawpy1;
    do
    {
      return;
      awpy localawpy2 = awqg.a(paramString, true);
      localawpy1 = localawpy2;
      if (localawpy2 == null) {
        localawpy1 = awqg.a(paramString, false);
      }
    } while (localawpy1 == null);
    this.jdField_a_of_type_Awqr.b();
    paramLyricViewDetail.a().setHighlightCurrentLine(true);
    paramLyricViewDetail.a().setHighlightLineNumber(2);
    this.jdField_a_of_type_Awqr.a(paramLyricViewDetail);
    this.jdField_a_of_type_Awqr.a(localawpy1, localawpy1, null);
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
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int == 1)
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
    int i = ViewUtils.getScreenWidth();
    int j = ViewUtils.getScreenHeight();
    if ((j > 0) && (i > 0))
    {
      i = j - i - ViewUtils.dip2px(312.0F);
      if (i < 0)
      {
        if (i <= ViewUtils.dip2px(50.0F) * -1) {
          break label58;
        }
        ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).topMargin = i;
      }
    }
    return;
    label58:
    ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).topMargin = (i + ViewUtils.dip2px(34.0F));
  }
  
  private void b(View paramView)
  {
    int i = 1;
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)paramView.findViewById(2131368063));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    paramView = paramView.findViewById(2131368079);
    paramView.setVisibility(0);
    ((ViewGroup.MarginLayoutParams)paramView.getLayoutParams()).topMargin = AIOUtils.dp2px(28.0F, getResources());
    paramView = bheg.a(true);
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int == 2) {}
    for (;;)
    {
      Object localObject = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e, 4, paramView, paramView);
      paramView = (DynamicAvatarView)this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363426);
      paramView.setImageDrawable((Drawable)localObject);
      i = AIOUtils.dp2px(1.5F, getResources());
      paramView.setPadding(i, i, i, i);
      paramView.setBackgroundResource(2130838722);
      localObject = (ImageView)((View)this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getParent()).findViewById(2131368105);
      this.jdField_a_of_type_Atth = new atth(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e);
      this.jdField_a_of_type_Atth.a((View)localObject);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, paramView, false);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(this);
      return;
      i = 4;
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_JavaLangString));
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
    if ((getActivity() == null) || (getActivity().isFinishing()) || (!isAdded())) {}
    boolean bool;
    Object localObject;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = NetworkUtil.isNetworkAvailable(getActivity());
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131365857: 
        if (!axlm.a(getActivity(), "com.tencent.qqmusic")) {
          break label829;
        }
        localObject = new Intent("android.intent.action.VIEW", Uri.parse("qqmusic://qq.com/ui/myTab?p=%7B%22tab%22%3A%22home%22%7D&source=https%3A%2F%2Fy.qq.com%2Fm%2Findex.html%3FADTAG%3DYIQITING"));
        ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_qqmusic");
        getActivity().startActivity((Intent)localObject);
        a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e, "music_tab", "clk_openmusic");
        break;
      case 2131372936: 
        if (!b())
        {
          QQToast.a(getActivity(), anvx.a(2131705662), 1).a();
        }
        else
        {
          if (bool) {
            break label265;
          }
          QQToast.a(getActivity(), 1, getActivity().getString(2131694461), 0).a();
        }
        break;
      }
    }
    label265:
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.h == 1)
    {
      ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e);
      this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.h = 2;
    }
    while (i != 0)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong.a(), this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.h, this.jdField_a_of_type_JavaLangString);
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.h == 2)
      {
        ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e);
        this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.h = 1;
        continue;
        if (!b()) {
          break;
        }
        if (!bool)
        {
          QQToast.a(getActivity(), 1, getActivity().getString(2131694461), 0).a();
          break;
        }
        i = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.c + 1;
        if (i > 3) {
          i = 1;
        }
        for (;;)
        {
          ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).f(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e, i);
          bdla.b(null, "dc00899", a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int), "", "music_tab", "clk_mode", 0, 0, "", "", "" + i, "");
          break;
          if (!b()) {
            break;
          }
          if (!bool)
          {
            QQToast.a(getActivity(), 1, getActivity().getString(2131694461), 0).a();
            break;
          }
          ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).e(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e, 2);
          bdla.b(null, "dc00899", a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int), "", "music_tab", "clk_cut", 0, 0, "", "", "", "");
          break;
          if (!b()) {
            break;
          }
          if (!bool)
          {
            QQToast.a(getActivity(), 1, getActivity().getString(2131694461), 0).a();
            break;
          }
          ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).e(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e, 1);
          bdla.b(null, "dc00899", a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int), "", "music_tab", "clk_cut", 0, 0, "", "", "", "");
          break;
          getActivity().finish();
          break;
          if (!bool)
          {
            QQToast.a(getActivity(), 1, getActivity().getString(2131694461), 0).a();
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int == 1) {
            awfq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e);
          }
          a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e, "music_tab", "clk_member");
          break;
          label829:
          if (!bool)
          {
            QQToast.a(getActivity(), 1, getActivity().getString(2131694461), 0).a();
            break;
          }
          if (!auht.a().a("https://misc.wcd.qq.com/app?packageName=com.tencent.qqmusic&channelId=10034308")) {
            ThreadManager.post(new ListenTogetherPlayFragment.5(this), 5, null, true);
          }
          a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e, "music_tab", "clk_downloadmusic");
          break;
          localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e;
          if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int == 1) {}
          for (i = j;; i = 0)
          {
            if (this.jdField_a_of_type_Atth != null) {
              this.jdField_a_of_type_Atth.a();
            }
            String str = ContactUtils.getNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, i);
            MiniChatActivity.a(getActivity(), i, (String)localObject, str);
            break;
          }
        }
      }
      i = 0;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    View localView = paramLayoutInflater.inflate(2131561229, paramViewGroup, false);
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (!a()) {
      getActivity().finish();
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, localView);
      return localView;
      localView.setClickable(true);
      a(localView);
      a();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Awfk);
    }
    if (this.jdField_a_of_type_Awqr != null) {
      this.jdField_a_of_type_Awqr.b();
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a().c(false);
      this.jdField_b_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_Atth != null) {
      this.jdField_a_of_type_Atth.d();
    }
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
    if (this.jdField_a_of_type_Atth != null) {
      this.jdField_a_of_type_Atth.c();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    boolean bool2 = axlm.a(getActivity());
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
          break label96;
        }
      }
    }
    label96:
    for (Object localObject = anvx.a(2131705660);; localObject = anvx.a(2131705663))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_c_of_type_AndroidWidgetTextView.setTag(Boolean.valueOf(bool2));
      if (this.jdField_a_of_type_Atth != null) {
        this.jdField_a_of_type_Atth.b();
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment
 * JD-Core Version:    0.7.0.1
 */