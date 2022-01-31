package com.tencent.mobileqq.nearby.now.send;

import aeum;
import aeup;
import aeur;
import aeus;
import aeut;
import aeuu;
import aeuv;
import aeuw;
import aeux;
import aeuy;
import aeuz;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.now.view.widget.RoundRelativeLayout;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LogUtil;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class SmallVideoSendFragment
  extends PublicBaseFragment
  implements View.OnLayoutChangeListener, EditVideoUi
{
  private static LocationInfo jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = new LocationInfo();
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  public EditText a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private EditVideoParams jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams;
  private PublishParam jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam;
  public PublishManager a;
  private RoundRelativeLayout jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout;
  public QQProgressDialog a;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = true;
  View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private boolean jdField_b_of_type_Boolean;
  public View c;
  
  private String a()
  {
    JSONObject localJSONObject = new JSONObject();
    File localFile1 = new File(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendPublishManager.jdField_a_of_type_JavaLangString + "");
    File localFile2 = new File(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam.c + "");
    File localFile3 = new File(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam.d + "");
    try
    {
      localJSONObject.put("videoUrl", localFile1.toURI() + "");
      localJSONObject.put("coverUrl", localFile2.toURI() + "");
      localJSONObject.put("doodleUrl", localFile3.toURI() + "");
      localJSONObject.put("is_local", "1");
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if ((paramInt == 101) || (paramIntent == null)) {
      return;
    }
    paramIntent = (LocationInfo)paramIntent.getExtras().getParcelable("seleted");
    if (paramIntent == null)
    {
      LogUtil.e("PublishActivity", "dealLocationResult: locationInfo is null!");
      return;
    }
    LogUtil.d("PublishActivity", "dealLocationResult: " + paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendPublishManager.b(paramIntent);
    if ((paramIntent.isCityEmpty()) && (paramIntent.isNameEmpty()))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendPublishManager.a(jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo);
      b();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendPublishManager.a(new LocationInfo(paramIntent));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842833);
    StringBuilder localStringBuilder = new StringBuilder(paramIntent.getCity());
    if (!TextUtils.isEmpty(paramIntent.getName()))
    {
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append("·");
      }
      localStringBuilder.append(paramIntent.getName());
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
  }
  
  private void a(LocationInfo paramLocationInfo)
  {
    if ((paramLocationInfo == null) || ((paramLocationInfo.isCityEmpty()) && (paramLocationInfo.isNameEmpty())))
    {
      b();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842833);
    StringBuilder localStringBuilder = new StringBuilder(paramLocationInfo.getCity());
    if (!TextUtils.isEmpty(paramLocationInfo.getName()))
    {
      localStringBuilder.append("·");
      localStringBuilder.append(paramLocationInfo.getName());
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
  }
  
  private void d()
  {
    this.c.findViewById(2131364405).setVisibility(8);
  }
  
  private void e()
  {
    this.c.findViewById(2131364405).setVisibility(0);
  }
  
  private void f()
  {
    a("处理中", false);
    d();
    ThreadManager.post(new aeum(this), 5, null, true);
  }
  
  private void g()
  {
    LocationInfo localLocationInfo = this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendPublishManager.b();
    View localView = a(2131370608);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370610));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370609));
    if (localLocationInfo != null)
    {
      LogUtil.d("PublishActivity", "initLocationView: last :" + localLocationInfo.toString());
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendPublishManager.a(localLocationInfo);
      a(localLocationInfo);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendPublishManager.a();
      localView.setOnClickListener(new aeus(this));
      return;
      LogUtil.d("PublishActivity", "initLocationView: get last error.");
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendPublishManager.a(new LocationInfo());
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131370604));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout = ((RoundRelativeLayout)a(2131370605));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131370606));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131364405));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)a(2131370603));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new aeut(this));
    ThreadManager.getUIHandler().postDelayed(new aeuu(this), 500L);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131370612));
    this.jdField_b_of_type_AndroidViewView = a(2131370613);
    this.jdField_a_of_type_AndroidViewView = a(2131370611);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new aeuv(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new aeuw(this) });
    this.c = a(2131362892);
    this.c.setOnTouchListener(new aeux(this));
    this.c.addOnLayoutChangeListener(this);
  }
  
  private void i()
  {
    try
    {
      URLDrawable localURLDrawable = URLDrawable.getDrawable(new URL("file:///" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam.c), URLDrawable.URLDrawableOptions.obtain());
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout.setBackgroundDrawable(localURLDrawable);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(new aeuy(this));
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        localMalformedURLException.printStackTrace();
      }
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam.c))) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    try
    {
      URLDrawable localURLDrawable = URLDrawable.getDrawable(new URL("file:///" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam.c), URLDrawable.URLDrawableOptions.obtain());
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout.setBackgroundDrawable(localURLDrawable);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(new aeuz(this));
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        localMalformedURLException.printStackTrace();
      }
    }
  }
  
  @NonNull
  public Context a()
  {
    return getActivity();
  }
  
  public Intent a()
  {
    if (getActivity() == null) {
      return null;
    }
    return getActivity().getIntent();
  }
  
  public FragmentActivity a()
  {
    return super.getActivity();
  }
  
  public View a()
  {
    return this.c;
  }
  
  public View a(int paramInt)
  {
    return this.c.findViewById(paramInt);
  }
  
  public void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3)
  {
    if (getActivity() != null)
    {
      FragmentActivity localFragmentActivity = getActivity();
      localFragmentActivity.setResult(paramInt1, paramIntent);
      localFragmentActivity.finish();
    }
  }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new aeup(this, paramCharSequence, paramBoolean));
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842832);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131431626);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c()
  {
    ThreadManager.getUIHandler().post(new aeur(this));
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendPublishManager.a();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1001) {
      a(paramInt2, paramIntent);
    }
    while (paramIntent == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendPublishManager.a(paramInt1, paramInt2, paramIntent);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.i("PublishActivity", 2, "onCreateView ");
    }
    super.onCreate(paramBundle);
    this.c = paramLayoutInflater.inflate(2130970455, null);
    h();
    this.jdField_a_of_type_Int = (getResources().getDisplayMetrics().heightPixels / 4);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam = ((PublishParam)a().getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_JavaLangString = a().getStringExtra("_from");
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendPublishManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendPublishManager = new PublishManager(getActivity(), getActivity().app);
    }
    g();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = ((EditVideoParams)a().getParcelableExtra("edit_video_params"));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendPublishManager.a(this.jdField_a_of_type_JavaLangString);
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendPublishManager;
    boolean bool1;
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam.l == 1)
    {
      bool1 = true;
      paramLayoutInflater.a(bool1);
      paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendPublishManager;
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam.h == 1) {
        bool1 = true;
      }
      paramLayoutInflater.b(bool1);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendPublishManager.a(this, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendPublishManager.b();
      paramLayoutInflater = new NowVideoReporter().h("video_public").i("exp_public");
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam.h != 1) {
        break label317;
      }
      i = 2;
      label254:
      paramLayoutInflater.a(i).d(this.jdField_a_of_type_JavaLangString).b(getActivity().app);
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam.h != 1) {
        break label323;
      }
      i();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper());
      return this.c;
      bool1 = false;
      break;
      label317:
      i = 1;
      break label254;
      label323:
      j();
      f();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendPublishManager.c();
    this.c.removeOnLayoutChangeListener(this);
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt8 != 0) && (paramInt4 != 0))
    {
      if (paramInt8 - paramInt4 <= this.jdField_a_of_type_Int) {
        break label28;
      }
      this.jdField_b_of_type_Boolean = true;
    }
    label28:
    do
    {
      do
      {
        return;
      } while (paramInt4 - paramInt8 <= this.jdField_a_of_type_Int);
      this.jdField_b_of_type_Boolean = false;
    } while (this.jdField_b_of_type_AndroidViewView.getVisibility() != 8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStop()
  {
    super.onStop();
    AudioManager localAudioManager = (AudioManager)getActivity().getSystemService("audio");
    if (localAudioManager != null) {
      localAudioManager.abandonAudioFocus(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.send.SmallVideoSendFragment
 * JD-Core Version:    0.7.0.1
 */