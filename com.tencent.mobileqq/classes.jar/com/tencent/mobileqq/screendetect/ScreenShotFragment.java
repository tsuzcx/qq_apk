package com.tencent.mobileqq.screendetect;

import ahsl;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anvx;
import aupp;
import aupt;
import ausc;
import avay;
import bbql;
import bbxb;
import bbxc;
import bbxj;
import bbxk;
import bbxl;
import bbxm;
import bbxn;
import bbxq;
import bgyo;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.DragView;
import com.tencent.widget.Gallery;
import com.tencent.widget.GridView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.QZoneShareManager;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ScreenShotFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aupt jdField_a_of_type_Aupt;
  private bbxb jdField_a_of_type_Bbxb;
  private bbxc jdField_a_of_type_Bbxc = new bbxj(this);
  private bbxq jdField_a_of_type_Bbxq;
  private ElasticHorScrView jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected AdapterView.OnItemClickListener a;
  private DragView jdField_a_of_type_ComTencentWidgetDragView;
  private Gallery jdField_a_of_type_ComTencentWidgetGallery;
  private GridView jdField_a_of_type_ComTencentWidgetGridView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ScreenShotFragment.5(this);
  private String jdField_a_of_type_JavaLangString;
  private List<RecentBaseData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private TextView e;
  
  public ScreenShotFragment()
  {
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new bbxm(this);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    float f2;
    if (paramInt == 90) {
      f2 = paramBitmap.getHeight();
    }
    for (float f1 = 0.0F;; f1 = paramBitmap.getWidth())
    {
      Object localObject = new float[9];
      localMatrix.getValues((float[])localObject);
      localMatrix.postTranslate(f2 - localObject[2], f1 - localObject[5]);
      localObject = Bitmap.createBitmap(paramBitmap.getHeight(), paramBitmap.getWidth(), Bitmap.Config.RGB_565);
      Paint localPaint = new Paint();
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      localCanvas.drawBitmap(paramBitmap, localMatrix, localPaint);
      localCanvas.setBitmap(null);
      return localObject;
      f2 = paramBitmap.getHeight();
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > paramInt) {
        str = paramString.substring(0, paramInt) + "\n" + paramString.substring(paramInt);
      }
    }
    return str;
  }
  
  private void a(int paramInt)
  {
    Object localObject3 = (RecentBaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if ((localObject3 instanceof RecentUserBaseData))
    {
      b(((RecentBaseData)localObject3).getRecentUserType());
      Object localObject1 = null;
      if (getActivity().getIntent() != null) {
        localObject1 = getActivity().getIntent();
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Intent();
      }
      localObject1 = (RecentUserBaseData)localObject3;
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment handleIconItemClick");
      }
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("uin", ((RecentUserBaseData)localObject1).getRecentUserUin());
      ((Bundle)localObject3).putString("troop_uin", ((RecentUserBaseData)localObject1).getRecentUserTroopUin());
      ((Bundle)localObject3).putString("uinname", ((RecentUserBaseData)localObject1).getTitleName());
      ((Bundle)localObject3).putInt("uintype", ((RecentUserBaseData)localObject1).getRecentUserType());
      ((Bundle)localObject3).putBoolean("key_help_forward_pic", true);
      ((Intent)localObject2).setData(Uri.parse(this.jdField_a_of_type_JavaLangString));
      ((Intent)localObject2).putExtra("forward_type", 1);
      ((Intent)localObject2).putExtra("key_share_from_screen_shot", true);
      if (this.jdField_a_of_type_Aupt == null) {
        this.jdField_a_of_type_Aupt = ausc.a((Intent)localObject2, getActivity().app, getActivity());
      }
      if (((RecentUserBaseData)localObject1).getRecentUserType() == 6000)
      {
        this.jdField_a_of_type_Aupt.a(aupp.f.intValue(), (Bundle)localObject3);
        return;
      }
      this.jdField_a_of_type_Aupt.a(aupp.a.intValue(), (Bundle)localObject3);
      return;
    }
    QLog.e("ScreenShotFragment", 2, "handleIconItemClick : position = " + paramInt + ", data is null!");
  }
  
  private void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_Bbxq.a(paramActivity, paramQQAppInterface));
  }
  
  private void a(View paramView)
  {
    boolean bool = false;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131377116));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377119));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377112));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377117));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131713042));
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131377111));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377525));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365945));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380021));
    Object localObject = this.jdField_c_of_type_AndroidWidgetTextView;
    int i;
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_Boolean))
    {
      i = 0;
      ViewUtils.setVisible((View)localObject, i);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380030));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.e = ((TextView)paramView.findViewById(2131380093));
      this.e.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)paramView.findViewById(2131365898));
      this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)paramView.findViewById(2131367490));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377113));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363337));
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131713047));
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)paramView.findViewById(2131377554));
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
      this.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramView.findViewById(2131367851));
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetDragView.setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(new avay(Collections.singletonList(this.jdField_a_of_type_JavaLangString)));
        this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131297147));
        this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(0);
        this.jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(true);
        this.jdField_a_of_type_ComTencentWidgetDragView.setEnableDrag(false);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingTop(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight(), 0);
        if (!CheckPermission.isHasStoragePermission(getActivity())) {
          break label715;
        }
        i();
      }
    }
    for (;;)
    {
      ((TextView)paramView.findViewById(2131377114)).setText(anvx.a(2131694669));
      if (this.jdField_d_of_type_Boolean) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(anvx.a(2131718329));
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft(), ImmersiveUtils.getStatusBarHeight(getActivity()) + 15, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingBottom());
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131719177));
      localObject = getActivity();
      Uri localUri = Uri.fromFile(new File(this.jdField_a_of_type_JavaLangString));
      TextView localTextView1 = this.e;
      TextView localTextView2 = this.jdField_d_of_type_AndroidWidgetTextView;
      if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        bool = true;
      }
      bbxq.a((Context)localObject, localUri, localTextView1, localTextView2, bool);
      paramView.findViewById(2131367563).setVisibility(this.jdField_c_of_type_AndroidWidgetTextView.getVisibility());
      paramView.findViewById(2131367564).setVisibility(this.jdField_d_of_type_AndroidWidgetTextView.getVisibility());
      paramView.findViewById(2131367565).setVisibility(this.e.getVisibility());
      h();
      return;
      i = 8;
      break;
      label715:
      CheckPermission.requestStoragePermission(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, new bbxk(this));
    }
  }
  
  private void a(BaseActivity paramBaseActivity, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment shareToQzone");
    }
    paramBaseActivity = (QQAppInterface)paramBaseActivity.getAppRuntime();
    Bundle localBundle = new Bundle();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localBundle.putStringArrayList("images", localArrayList);
    QZoneShareManager.publishToQzone(paramBaseActivity, getActivity(), localBundle, null, 2);
  }
  
  private void a(String paramString)
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidGraphicsBitmap = a(paramString);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        QLog.e("ScreenShotFragment", 1, "run: screenBitmap == null");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotFragment", 2, "screenBitmap : width = " + this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() + ", height = " + this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
      }
    } while ((this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() <= 16) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() <= 16));
    int j = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    int i = j;
    int k;
    if (this.jdField_c_of_type_Boolean)
    {
      QLog.d("ScreenShotFragment", 1, new Object[] { "long pic blur background change start, height is : ", Integer.valueOf(j) });
      k = this.jdField_a_of_type_AndroidViewView.getHeight();
      if ((k == 0) || (j <= k)) {
        break label318;
      }
      i = k;
    }
    label318:
    Canvas localCanvas;
    for (;;)
    {
      QLog.d("ScreenShotFragment", 1, new Object[] { "long pic blur background change finish, height is : ", Integer.valueOf(i), " rootHeight is : ", Integer.valueOf(k) });
      try
      {
        paramString = Bitmap.createScaledBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, (int)(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * 0.0625F), (int)(i * 0.0625F), false);
        localObject = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
        ((Canvas)localObject).drawColor(Color.parseColor("#33000000"));
        ((Canvas)localObject).setBitmap(null);
        if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
          this.jdField_a_of_type_AndroidOsHandler.post(new ScreenShotFragment.6(this));
        }
        if (paramString == null)
        {
          QLog.e("ScreenShotFragment", 1, "run: scaledBitmap == null");
          return;
          i = j;
          if (getActivity() == null) {
            continue;
          }
          i = j;
          if (j <= ScreenUtil.getInstantScreenHeight(getActivity())) {
            continue;
          }
          i = ScreenUtil.getInstantScreenHeight(getActivity());
        }
      }
      catch (OutOfMemoryError paramString)
      {
        for (;;)
        {
          if (0 != 0) {
            throw new NullPointerException();
          }
          QLog.e("ScreenShotFragment", 1, "create scale Bitmap error : out of memory");
          paramString = null;
        }
        Object localObject = new StackBlurManager(paramString).process(4);
        if (localObject == null)
        {
          QLog.e("ScreenShotFragment", 1, "run: blured bitmap is null");
          return;
        }
        localCanvas = new Canvas(paramString);
        localCanvas.drawColor(0);
        localCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, null);
        if (!"1103".equals(ThemeUtil.curThemeId)) {
          break label487;
        }
      }
    }
    localCanvas.drawColor(Color.parseColor("#4DEBEDF5"));
    for (;;)
    {
      localCanvas.setBitmap(null);
      if (this.jdField_a_of_type_AndroidViewView == null) {
        break;
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new ScreenShotFragment.7(this, paramString));
      return;
      label487:
      localCanvas.drawColor(Color.parseColor("#7F03081A"));
    }
  }
  
  private void a(String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment shareToWXFriend");
    }
    WXShareHelper.a().a(paramString, paramBitmap, 0, false);
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    } while (!this.jdField_c_of_type_Boolean);
    bbxq.a("0X800A9A8", "1", "");
  }
  
  private void b(int paramInt)
  {
    String str = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((this.jdField_c_of_type_Boolean) && (str != null)) {
        bbxq.a("0X800A9A7", str, "1");
      }
      return;
      str = "1";
      bbxq.a("0X8009FEE", 1);
      continue;
      str = "2";
      bbxq.a("0X8009FEE", 2);
      continue;
      bbxq.a("0X8009FEE", 3);
      continue;
      bbxq.a("0X8009FEE", 4);
      continue;
      str = "3";
      bbxq.a("0X8009FEE", 5);
    }
  }
  
  private static void b(Activity paramActivity, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment launchFriendPicker path = " + paramString);
    }
    Intent localIntent = new Intent(paramActivity, ForwardRecentActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_help_forward_pic", true);
    localIntent.putExtras(localBundle);
    localIntent.putExtra("forward_type", 1);
    localIntent.putExtra("key_allow_multiple_forward_from_limit", false);
    localIntent.putExtra("key_share_from_screen_shot", true);
    localIntent.putExtra("key_share_from_screen_need_finish", true);
    localIntent.setData(Uri.parse(paramString));
    paramActivity.startActivityForResult(localIntent, 3);
  }
  
  private void b(String paramString)
  {
    bbql.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString, 101);
  }
  
  private void b(String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment shareToFriendCircle");
    }
    WXShareHelper.a().a(paramString, paramBitmap, 1, false);
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  private void f()
  {
    this.jdField_b_of_type_Boolean = getArguments().getBoolean("is_aio_page_with_msg", false);
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "handlerArg: mHasMsg = " + this.jdField_b_of_type_Boolean);
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment bindData");
    }
    if (this.jdField_a_of_type_JavaLangString != null) {
      ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getActivity());
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_Bbxb = new bbxb(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, 0);
    this.jdField_a_of_type_Bbxb.a(this.jdField_a_of_type_Bbxc);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bbxb);
    this.jdField_a_of_type_Bbxb.a(this.jdField_a_of_type_JavaUtilList);
    List localList = a()[0];
    Object localObject1 = new TextPaint();
    ((TextPaint)localObject1).setTextSize(getActivity().getResources().getDimensionPixelSize(2131299008));
    localObject1 = new StaticLayout(a(a(localList), 6), (TextPaint)localObject1, this.jdField_a_of_type_Int, Layout.Alignment.ALIGN_CENTER, 1.0F, this.jdField_b_of_type_Int, true);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
    }
    Object localObject2 = localList.iterator();
    int i = 0;
    if (((Iterator)localObject2).hasNext())
    {
      if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject2).next()).visibility != 0) {
        break label408;
      }
      i += 1;
    }
    label408:
    for (;;)
    {
      break;
      int j = 20 + (this.jdField_a_of_type_Int + 20);
      this.jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(j);
      this.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(i);
      localObject2 = this.jdField_a_of_type_ComTencentWidgetGridView.getLayoutParams();
      this.jdField_a_of_type_ComTencentWidgetGridView.setPadding(16, this.jdField_a_of_type_ComTencentWidgetGridView.getPaddingTop(), 16, this.jdField_a_of_type_ComTencentWidgetGridView.getPaddingBottom());
      ((ViewGroup.LayoutParams)localObject2).width = (j * i + 0 + 0);
      i = this.jdField_a_of_type_Int;
      j = this.jdField_c_of_type_Int;
      ((ViewGroup.LayoutParams)localObject2).height = (((StaticLayout)localObject1).getHeight() + (i + j));
      this.jdField_a_of_type_ComTencentWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_ComTencentWidgetGridView.setAdapter(new bbxn(getActivity(), localList));
      this.jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
      this.jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
      return;
    }
  }
  
  private void h()
  {
    int n = 1;
    int i;
    int j;
    label27:
    int k;
    label39:
    int m;
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      i = 1;
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break label135;
      }
      j = 1;
      if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break label140;
      }
      k = 1;
      if (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break label145;
      }
      m = 1;
      label52:
      if (this.e.getVisibility() != 0) {
        break label151;
      }
    }
    for (;;)
    {
      if (m + (0 + i + j + k) + n >= 4)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(12.0F);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(12.0F);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(12.0F);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(12.0F);
        this.e.setTextSize(12.0F);
      }
      return;
      i = 0;
      break;
      label135:
      j = 0;
      break label27;
      label140:
      k = 0;
      break label39;
      label145:
      m = 0;
      break label52;
      label151:
      n = 0;
    }
  }
  
  private void i()
  {
    QQToast.a(getActivity(), 2131718157, 0).a();
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    ahsl.a(getActivity(), localFile, Utils.Crc64String(localFile.getName()));
  }
  
  private void j()
  {
    if (ImmersiveUtils.a(getActivity()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onResume current is liuhai style!");
      }
      LiuHaiUtils.enableNotch(getActivity());
    }
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment#screenShotLong");
    }
    if (getActivity() != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("click_long_screen_shot", true);
      getActivity().setResult(-1, localIntent);
      getActivity().finish();
    }
  }
  
  public Bitmap a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = new File(paramString);
        if (paramString.exists())
        {
          Object localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          bgyo.a(paramString.getAbsolutePath(), (BitmapFactory.Options)localObject);
          int i = ((BitmapFactory.Options)localObject).outHeight;
          ((BitmapFactory.Options)localObject).inSampleSize = ((i - this.jdField_d_of_type_Int) / i);
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
          ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
          localObject = bgyo.a(paramString.getAbsolutePath(), (BitmapFactory.Options)localObject).copy(Bitmap.Config.RGB_565, true);
          paramString = (String)localObject;
          if (((Bitmap)localObject).getWidth() > ((Bitmap)localObject).getHeight()) {
            paramString = a((Bitmap)localObject, 90);
          }
        }
      }
      catch (OutOfMemoryError paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ScreenShotFragment", 2, "makeShareBitmap", paramString);
          }
          paramString = null;
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ScreenShotFragment", 2, "makeShareBitmap", paramString);
          }
          paramString = null;
        }
      }
    }
    return paramString;
  }
  
  protected String a(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    Object localObject = "";
    int i = 0;
    if (i < paramList.size())
    {
      String str = ((ShareActionSheetBuilder.ActionSheetItem)paramList.get(i)).label;
      if (str.length() <= ((String)localObject).length()) {
        break label55;
      }
      localObject = str;
    }
    label55:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  public void a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      localFragmentActivity.finish();
      localFragmentActivity.overridePendingTransition(0, 0);
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment finishActivity, because app is null!");
      }
    }
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = getActivity().getString(2131696130);
    localActionSheetItem.icon = 2130839146;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = getActivity().getString(2131696143);
    localActionSheetItem.icon = 2130839147;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = getActivity().getString(2131696150);
    localActionSheetItem.icon = 2130839150;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = getActivity().getString(2131696133);
    localActionSheetItem.icon = 2130839144;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = getActivity().getString(2131692678);
    localActionSheetItem.icon = 2130840214;
    localActionSheetItem.action = 50;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void b()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      localFragmentActivity.finish();
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment finishActivity");
      }
      localFragmentActivity.overridePendingTransition(0, 0);
    }
    if (this.jdField_c_of_type_Boolean) {
      bbxq.a("0X800A9AD", "1", "");
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment exitScreenShotScreen");
    }
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment startEdit");
    }
    if (this.jdField_a_of_type_JavaLangString == null) {
      return;
    }
    Intent localIntent = EditPicActivity.a(getActivity(), this.jdField_a_of_type_JavaLangString, true, true, true, true, true, false, false, false, 2, 122, 0, false, null);
    getActivity().startActivityForResult(localIntent, 1);
  }
  
  public void e()
  {
    QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment startCrop");
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      QLog.e("ScreenShotFragment", 1, "crop error : mCurrentPath is null");
      return;
    }
    Intent localIntent = EditPicActivity.a(getActivity(), this.jdField_a_of_type_JavaLangString, true, true, true, true, true, false, false, false, 2, 133, 0, false, null);
    getActivity().startActivityForResult(localIntent, 5);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, new Object[] { "ScreenShotShareFragment onActivityResult requestCode = ", paramInt1 + ", resultCode = " + paramInt2 });
    }
    if (paramInt1 == 1) {
      c();
    }
    do
    {
      return;
      if (paramInt1 == 2)
      {
        c();
        return;
      }
      if (paramInt1 == 3)
      {
        c();
        return;
      }
    } while (paramInt1 != 101);
    c();
  }
  
  public boolean onBackEvent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b();
      continue;
      a(false);
      bbxq.a("0X8009FEF", 0);
      continue;
      if (this.jdField_c_of_type_Boolean)
      {
        e();
        bbxq.a("0X800A9AA", "1", "");
      }
      else
      {
        d();
        bbxq.a("0X8009FF4", 0);
        continue;
        k();
        if (this.jdField_b_of_type_Boolean) {
          bbxq.a("0X800A8BD", 0);
        }
        if (this.jdField_d_of_type_Boolean)
        {
          bbxq.a("0X800A9A5", "1", "");
          continue;
          a(true);
          continue;
          b();
          continue;
          Intent localIntent = new Intent();
          localIntent.putExtra("preResult", (String)this.jdField_d_of_type_AndroidWidgetTextView.getTag());
          bbxq.a(getActivity(), this.jdField_a_of_type_JavaLangString, 2, localIntent);
          bbxq.a("0X800AC94", 0);
          this.jdField_a_of_type_Boolean = true;
          continue;
          localIntent = new Intent();
          localIntent.putExtra("preResult", (String)this.e.getTag());
          bbxq.a(getActivity(), this.jdField_a_of_type_JavaLangString, 1, localIntent);
          bbxq.a("0X800AC93", 0);
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onCreate");
    }
    if (getActivity() == null) {
      QLog.e("ScreenShotFragment", 2, "ScreenShotShareFragment onCreate activity has gone!");
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    this.jdField_a_of_type_Bbxq = new bbxq();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      a();
    }
    do
    {
      do
      {
        return;
        a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_Int = getActivity().getResources().getDimensionPixelSize(2131296796);
        this.jdField_b_of_type_Int = getActivity().getResources().getDimensionPixelOffset(2131296799);
        this.jdField_c_of_type_Int = getActivity().getResources().getDimensionPixelOffset(2131296798);
        paramBundle = getActivity().getIntent();
      } while (paramBundle == null);
      this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("screen_path");
      this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("is_web_screen_long_shot", false);
      this.jdField_d_of_type_Boolean = paramBundle.getBooleanExtra("is_screen_shot_from_web", false);
    } while (!this.jdField_c_of_type_Boolean);
    bbxq.a("0X800A9A6", "1", "");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onCreateView");
    }
    f();
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131561465, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#aa000000"));
    this.jdField_d_of_type_Int = getActivity().getResources().getDimensionPixelSize(2131298858);
    a(this.jdField_a_of_type_AndroidViewView);
    g();
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onDestroy");
    }
    if (this.jdField_a_of_type_Bbxb != null) {
      this.jdField_a_of_type_Bbxb.a();
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onPause");
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onResume");
    }
    FragmentActivity localFragmentActivity = getActivity();
    SystemBarCompact localSystemBarCompact = localFragmentActivity.mSystemBarComp;
    if (localSystemBarCompact != null) {
      localSystemBarCompact.setgetStatusBarVisible(false, 0);
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      ViewCompat.setOnApplyWindowInsetsListener(localFragmentActivity.getWindow().getDecorView(), new bbxl(this));
      return;
    }
    j();
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotFragment
 * JD-Core Version:    0.7.0.1
 */