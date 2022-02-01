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
import com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoiceView;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.text.QQText;
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
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;

public class ExpandProfileEditFragment
  extends QBaseFragment
  implements View.OnClickListener
{
  public static final ColorDrawable a;
  public int a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new ExpandProfileEditFragment.1(this);
  public View a;
  public ImageView a;
  public LinearLayout a;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public ETTextView a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ExtendFriendInfo a;
  private ExpandEditFragment jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandEditFragment;
  protected ExpandVoiceView a;
  private MediaInfo jdField_a_of_type_ComTencentMobileqqTroopDataMediaInfo;
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  public XEditTextEx a;
  public String a;
  public boolean a;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int = 0;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString = "";
  public boolean b;
  private int jdField_c_of_type_Int = 0;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public boolean c;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private boolean jdField_e_of_type_Boolean;
  private boolean f = false;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-657931);
  }
  
  public ExpandProfileEditFragment()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 20;
    this.jdField_c_of_type_Boolean = false;
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int j = paramString.length();
    int i = j - 1;
    while (i >= 0)
    {
      int k = paramString.charAt(i);
      if ((k != 32) && (k != 10)) {
        break;
      }
      j -= 1;
      i -= 1;
    }
    return paramString.substring(0, j);
  }
  
  private boolean b(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  private void d()
  {
    ExpandConfig localExpandConfig = ((IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a();
    if (localExpandConfig != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(localExpandConfig.defaultDecleration);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setHint(localExpandConfig.defaultDecleration);
      this.jdField_a_of_type_Int = localExpandConfig.declerationMinLen;
    }
    f();
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)this.jdField_b_of_type_AndroidViewView.findViewById(2131366323));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131376719));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131363953));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378888));
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131366949);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370706);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(BackgroundUtil.a(AIOUtils.b(27.0F, getResources()), -15550475, 1.0F));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(BackgroundUtil.a(AIOUtils.b(27.0F, getResources()), -16777216, 0.08F));
    this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366343));
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(0);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131380361);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    Object localObject = getParentFragment();
    if ((localObject != null) && ((localObject instanceof ExpandEditFragment))) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener((ExpandEditFragment)localObject);
    }
    j();
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundDrawable(new ColorDrawable(-526345));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setBackgroundDrawable(new ColorDrawable(-526345));
    this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(new ExpandProfileEditFragment.2(this));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131370218));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131376733));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369272));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369282));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379862));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379524));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368616));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379608));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131364030));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_b_of_type_AndroidViewView.findViewById(2131372397));
    this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new ExpandProfileEditFragment.3(this));
    this.jdField_d_of_type_Boolean = true;
    localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo;
    if (localObject != null) {
      a((ExtendFriendInfo)localObject);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
      this.jdField_a_of_type_ArrayOfJavaLangString = getResources().getStringArray(2130968621);
    }
    if (this.jdField_e_of_type_Int == -1) {
      this.jdField_e_of_type_Int = new Random().nextInt(this.jdField_a_of_type_ArrayOfJavaLangString.length);
    }
    this.jdField_e_of_type_Int += 1;
    int i = this.jdField_e_of_type_Int;
    Object localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_e_of_type_Int = (i % localObject.length);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(localObject[this.jdField_e_of_type_Int]);
    localObject = String.format("https://down.qq.com/innovate/qqexpand/avatarList/expand_avatar_%d.jpg", new Object[] { Integer.valueOf(new Random().nextInt(299) + 1) });
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = ImageUtil.e();
    localURLDrawableOptions.mLoadingDrawable = ImageUtil.e();
    localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
    ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.a);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
  }
  
  private void g()
  {
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  private void h()
  {
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
      return;
    }
    g();
    ThreadManager.getUIHandler().postDelayed(new ExpandProfileEditFragment.4(this), 1000L);
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView = ((ExpandVoiceView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368708));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.setMode(1);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.setActivity(getQBaseActivity());
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.setDeleteIconEnable(true, new ExpandProfileEditFragment.5(this));
  }
  
  private void k()
  {
    this.jdField_a_of_type_Boolean = false;
    n();
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.setVisibility(0);
    } else {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
    ExpandEditFragment localExpandEditFragment = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandEditFragment;
    if ((localExpandEditFragment != null) && (localExpandEditFragment.jdField_a_of_type_Int == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandEditFragment.d();
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_Boolean = true;
    XEditTextEx localXEditTextEx = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
    localXEditTextEx.setSelection(localXEditTextEx.getText().length());
    m();
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void m()
  {
    int i = getResources().getDisplayMetrics().heightPixels;
    int j = this.jdField_d_of_type_Int;
    int k = ImmersiveUtils.getStatusBarHeight(getQBaseActivity());
    int m = this.jdField_c_of_type_AndroidWidgetTextView.getHeight();
    int n = AIOUtils.b(96.0F, getResources());
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxHeight(i - j - k - m - n);
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxHeight(2147483647);
  }
  
  private void o()
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof ExpandEditFragment))) {
      ((ExpandEditFragment)localFragment).a();
    }
  }
  
  private void p()
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof ExpandEditFragment))) {
      ((ExpandEditFragment)localFragment).b();
    }
  }
  
  private void q()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void r()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public ExtendFriendInfo a()
  {
    ExtendFriendInfo localExtendFriendInfo = new ExtendFriendInfo();
    localExtendFriendInfo.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localExtendFriendInfo.jdField_a_of_type_JavaLangString = a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
    MediaInfo localMediaInfo = this.jdField_a_of_type_ComTencentMobileqqTroopDataMediaInfo;
    if ((localMediaInfo != null) && ((localMediaInfo instanceof AudioInfo)))
    {
      localExtendFriendInfo.jdField_b_of_type_Int = (((AudioInfo)localMediaInfo).duration / 1000);
      return localExtendFriendInfo;
    }
    localExtendFriendInfo.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    return localExtendFriendInfo;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      XEditTextEx localXEditTextEx = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
      if (localXEditTextEx != null) {
        InputMethodUtil.b(localXEditTextEx);
      }
    }
  }
  
  public void a(ExtendFriendInfo paramExtendFriendInfo)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      if (!TextUtils.isEmpty(paramExtendFriendInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaLangString = paramExtendFriendInfo.jdField_a_of_type_JavaLangString;
      }
      else
      {
        this.jdField_a_of_type_JavaLangString = "";
        paramExtendFriendInfo.jdField_a_of_type_JavaLangString = "";
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramExtendFriendInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(new QQText(QzoneEmotionUtils.emCodesToQQcodes(paramExtendFriendInfo.jdField_a_of_type_JavaLangString), 3, 24));
      int i = paramExtendFriendInfo.jdField_a_of_type_JavaLangString.length();
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(i);
      a();
      if (!TextUtils.isEmpty(paramExtendFriendInfo.jdField_b_of_type_JavaLangString))
      {
        q();
        this.jdField_b_of_type_JavaLangString = paramExtendFriendInfo.jdField_b_of_type_JavaLangString;
        this.jdField_b_of_type_Int = paramExtendFriendInfo.jdField_b_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.setVoiceDuration(this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.setVoiceUrl(this.jdField_b_of_type_JavaLangString);
        if (this.jdField_b_of_type_JavaLangString.indexOf("file_md5=") <= 0) {
          this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.setVoiceFileMD5(MD5Utils.encodeFileHexStr(this.jdField_b_of_type_JavaLangString));
        }
        this.jdField_e_of_type_Boolean = true;
      }
      else
      {
        r();
        this.jdField_e_of_type_Boolean = false;
      }
      b(paramExtendFriendInfo);
      if (!SimpleUIUtil.a())
      {
        ExpandEditFragment localExpandEditFragment = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandEditFragment;
        if ((localExpandEditFragment != null) && (localExpandEditFragment.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandEditFragment.a().a() != null))
        {
          i = paramExtendFriendInfo.jdField_c_of_type_Int;
          if (paramExtendFriendInfo.jdField_e_of_type_Int != 0) {
            i = paramExtendFriendInfo.jdField_e_of_type_Int;
          }
          this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandEditFragment.a().setUsingItem(i);
          this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandEditFragment.a().a().b(i);
          this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandEditFragment.jdField_a_of_type_Int = 3;
        }
        localExpandEditFragment = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandEditFragment;
        if ((localExpandEditFragment != null) && (localExpandEditFragment.b() != null) && (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandEditFragment.b().a() != null))
        {
          i = paramExtendFriendInfo.jdField_d_of_type_Int;
          if (paramExtendFriendInfo.f != 0) {
            i = paramExtendFriendInfo.f;
          }
          this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandEditFragment.b().setUsingItem(i);
          this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandEditFragment.b().a().b(i);
          this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandEditFragment.jdField_a_of_type_Int = 2;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo = paramExtendFriendInfo;
      if ((paramExtendFriendInfo.jdField_c_of_type_Boolean) || (paramExtendFriendInfo.jdField_b_of_type_Boolean)) {
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.performClick();
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo = paramExtendFriendInfo;
  }
  
  public void a(ExpandEditFragment paramExpandEditFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandEditFragment = paramExpandEditFragment;
  }
  
  public void a(AudioInfo paramAudioInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataMediaInfo = paramAudioInfo;
    if (!TextUtils.isEmpty(paramAudioInfo.path))
    {
      this.jdField_b_of_type_JavaLangString = paramAudioInfo.path;
      this.jdField_b_of_type_Int = paramAudioInfo.duration;
      q();
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.setVoiceDuration(this.jdField_b_of_type_Int / 1000);
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.setVoiceUrl(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_b_of_type_JavaLangString.indexOf("file_md5=") <= 0) {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.setVoiceFileMD5(MD5Utils.encodeFileHexStr(this.jdField_b_of_type_JavaLangString));
      }
      this.f = true;
      o();
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_b_of_type_JavaLangString = paramString;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      return;
    }
    if (paramBoolean)
    {
      localTextView.setTextColor(-11692801);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
      return;
    }
    localTextView.setTextColor(-3355444);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
    this.jdField_b_of_type_AndroidWidgetTextView.setClickable(false);
  }
  
  public boolean a()
  {
    String str2 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    str2 = this.jdField_a_of_type_JavaLangString;
    return ((str2 != null) && (!str2.equals(str1))) || (this.f);
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (b(paramString)) {
        return false;
      }
      HashSet localHashSet = new HashSet();
      int i = 0;
      while (i < paramString.length())
      {
        char c1 = paramString.charAt(i);
        if (!localHashSet.contains(Character.valueOf(c1)))
        {
          if (localHashSet.size() >= 3) {
            return true;
          }
          localHashSet.add(Character.valueOf(c1));
        }
        i += 1;
      }
    }
    return false;
  }
  
  public void b()
  {
    Object localObject = ((IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a();
    int i;
    if (localObject == null) {
      i = 11000;
    } else {
      i = ((ExpandConfig)localObject).voiceMaxLength * 1000;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("audio_max_length", i);
    ((Intent)localObject).putExtra("auto_start", true);
    ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
    ((Intent)localObject).putExtra("click_space_cancel", false);
    PublicFragmentActivity.Launcher.a(getQBaseActivity(), (Intent)localObject, PublicTransFragmentActivity.class, AudioRecordFragment.class, 1003);
    this.jdField_c_of_type_Boolean = true;
    o();
  }
  
  public void b(ExtendFriendInfo paramExtendFriendInfo)
  {
    if (getQBaseActivity() != null)
    {
      if (paramExtendFriendInfo == null) {
        return;
      }
      if ((!TextUtils.isEmpty(paramExtendFriendInfo.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramExtendFriendInfo.jdField_d_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
        String str = paramExtendFriendInfo.jdField_d_of_type_JavaLangString;
        int i;
        if (paramExtendFriendInfo.jdField_a_of_type_Long == 2L) {
          i = 2130845173;
        } else {
          i = 2130845174;
        }
        localTextView.setText(ProfileCardUtil.a(str, false, i, 2131298431, 2131298430, getQBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null));
        if (paramExtendFriendInfo.jdField_a_of_type_Long == 2L)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        else if (paramExtendFriendInfo.jdField_a_of_type_Long == 0L)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698784);
          a(true);
        }
        else if (paramExtendFriendInfo.jdField_a_of_type_Long == 1L)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698785);
          a(false);
        }
        else
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698784);
          a(true);
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new ExpandProfileEditFragment.7(this, paramExtendFriendInfo));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new ExpandProfileEditFragment.8(this, paramExtendFriendInfo));
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845129);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ExpandProfileEditFragment.6(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo = paramExtendFriendInfo;
    }
  }
  
  public boolean b()
  {
    XEditTextEx localXEditTextEx = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
    boolean bool = false;
    if (localXEditTextEx == null) {
      return false;
    }
    int i = localXEditTextEx.getScrollY();
    int j = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayout().getHeight() - (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getHeight() - this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getCompoundPaddingTop() - this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getCompoundPaddingBottom());
    if (j == 0) {
      return false;
    }
    if ((i > 0) || (i < j - 1)) {
      bool = true;
    }
    return bool;
  }
  
  public void c()
  {
    ExpandVoiceView localExpandVoiceView = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView;
    if ((localExpandVoiceView != null) && (localExpandVoiceView.a())) {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.b();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131380981: 
      if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.b();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.a();
      return;
    case 2131379524: 
      if ((getQBaseActivity() != null) && (this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo != null))
      {
        CampusHelper.a(getQBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo.g, this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo.jdField_c_of_type_JavaLangString);
        return;
      }
      break;
    case 2131366343: 
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
    case 2131366323: 
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
      InputMethodUtil.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      if (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandEditFragment != null)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo;
        if ((paramView != null) && (!paramView.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo.jdField_c_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandEditFragment.b(0);
          return;
        }
      }
      break;
    case 2131364030: 
      i();
      return;
    case 2131363953: 
      b();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131561076, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getQBaseActivity().getAppRuntime());
    e();
    d();
    if ((getActivity() != null) && (CampusHelper.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      CampusHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
      getActivity().setResult(8193);
    }
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public void onPause()
  {
    super.onPause();
    ExpandVoiceView localExpandVoiceView = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView;
    if ((localExpandVoiceView != null) && (localExpandVoiceView.a())) {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLineCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandProfileEditFragment
 * JD-Core Version:    0.7.0.1
 */