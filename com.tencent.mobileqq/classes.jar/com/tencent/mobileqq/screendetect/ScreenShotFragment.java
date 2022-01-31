package com.tencent.mobileqq.screendetect;

import adwz;
import ajjy;
import android.app.Activity;
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
import aphf;
import aphp;
import apjx;
import apto;
import apuh;
import avgj;
import avgk;
import avgr;
import avgs;
import avgt;
import avgu;
import avgx;
import awmc;
import azvq;
import bahx;
import bajq;
import bbmy;
import behi;
import bfqn;
import bjeh;
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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.DragView;
import com.tencent.widget.Gallery;
import com.tencent.widget.GridView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
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
  private aphp jdField_a_of_type_Aphp;
  private avgj jdField_a_of_type_Avgj;
  private avgk jdField_a_of_type_Avgk = new avgr(this);
  private avgx jdField_a_of_type_Avgx;
  protected behi a;
  private ElasticHorScrView jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DragView jdField_a_of_type_ComTencentWidgetDragView;
  private Gallery jdField_a_of_type_ComTencentWidgetGallery;
  private GridView jdField_a_of_type_ComTencentWidgetGridView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ScreenShotFragment.4(this);
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
  private int d;
  
  public ScreenShotFragment()
  {
    this.jdField_a_of_type_Behi = new avgt(this);
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
      b(((RecentBaseData)localObject3).a());
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
      ((Bundle)localObject3).putString("uin", ((RecentUserBaseData)localObject1).a());
      ((Bundle)localObject3).putString("troop_uin", ((RecentUserBaseData)localObject1).c());
      ((Bundle)localObject3).putString("uinname", ((RecentUserBaseData)localObject1).b());
      ((Bundle)localObject3).putInt("uintype", ((RecentUserBaseData)localObject1).a());
      ((Bundle)localObject3).putBoolean("key_help_forward_pic", true);
      ((Intent)localObject2).setData(Uri.parse(this.jdField_a_of_type_JavaLangString));
      ((Intent)localObject2).putExtra("forward_type", 1);
      ((Intent)localObject2).putExtra("key_share_from_screen_shot", true);
      if (this.jdField_a_of_type_Aphp == null) {
        this.jdField_a_of_type_Aphp = apjx.a((Intent)localObject2, getActivity().app, getActivity());
      }
      if (((RecentUserBaseData)localObject1).a() == 6000)
      {
        this.jdField_a_of_type_Aphp.a(aphf.f.intValue(), (Bundle)localObject3);
        return;
      }
      this.jdField_a_of_type_Aphp.a(aphf.a.intValue(), (Bundle)localObject3);
      return;
    }
    QLog.e("ScreenShotFragment", 2, "handleIconItemClick : position = " + paramInt + ", data is null!");
  }
  
  private void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_Avgx.a(paramActivity, paramQQAppInterface));
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131309877));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131309880));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131309873));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131309878));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajjy.a(2131647793));
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131309872));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131310236));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299872));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312422));
    Object localObject = this.jdField_c_of_type_AndroidWidgetTextView;
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_c_of_type_Boolean)) {}
    for (int i = 0;; i = 8)
    {
      bajq.b((View)localObject, i);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)paramView.findViewById(2131299824));
      this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)paramView.findViewById(2131301286));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131309874));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297457));
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(ajjy.a(2131647798));
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)paramView.findViewById(2131310256));
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
      this.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramView.findViewById(2131301556));
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetDragView.setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(new apuh(Collections.singletonList(this.jdField_a_of_type_JavaLangString)));
        this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131165934));
        this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(0);
        this.jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(true);
        this.jdField_a_of_type_ComTencentWidgetDragView.setEnableDrag(false);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingTop(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight(), 0);
        bbmy.a(getActivity(), 2131652996, 0).a();
        localObject = new File(this.jdField_a_of_type_JavaLangString);
        adwz.a(getActivity(), (File)localObject, Utils.Crc64String(((File)localObject).getName()));
        ((TextView)paramView.findViewById(2131309875)).setText(ajjy.a(2131629489));
      }
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(ajjy.a(2131653209));
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft(), ImmersiveUtils.getStatusBarHeight(getActivity()) + 15, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingBottom());
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131654156));
      return;
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
    bfqn.a(paramBaseActivity, getActivity(), localBundle, null, 2);
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
    if (this.jdField_b_of_type_Boolean)
    {
      QLog.d("ScreenShotFragment", 1, new Object[] { "long pic blur background change start, height is : ", Integer.valueOf(j) });
      k = this.jdField_a_of_type_AndroidViewView.getHeight();
      if ((k == 0) || (j <= k)) {
        break label318;
      }
      i = k;
    }
    Canvas localCanvas;
    for (;;)
    {
      QLog.d("ScreenShotFragment", 1, new Object[] { "long pic blur background change finish, height is : ", Integer.valueOf(i), " rootHeight is : ", Integer.valueOf(k) });
      try
      {
        paramString = Bitmap.createScaledBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, (int)(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * 0.0625F), (int)(i * 0.0625F), false);
        localCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
        localCanvas.drawColor(Color.parseColor("#33000000"));
        localCanvas.setBitmap(null);
        if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
          this.jdField_a_of_type_AndroidOsHandler.post(new ScreenShotFragment.5(this));
        }
        if (paramString == null)
        {
          QLog.e("ScreenShotFragment", 1, "run: scaledBitmap == null");
          return;
          label318:
          i = j;
          if (getActivity() == null) {
            continue;
          }
          i = j;
          if (j <= awmc.a(getActivity())) {
            continue;
          }
          i = awmc.a(getActivity());
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
        Bitmap localBitmap = new StackBlurManager(paramString).process(4);
        if (localBitmap == null)
        {
          QLog.e("ScreenShotFragment", 1, "run: blured bitmap is null");
          return;
        }
        localCanvas = new Canvas(paramString);
        localCanvas.drawColor(0);
        localCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
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
      this.jdField_a_of_type_AndroidOsHandler.post(new ScreenShotFragment.6(this, paramString));
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
    } while (!this.jdField_b_of_type_Boolean);
    avgx.a("0X800A9A8", "1", "");
  }
  
  private void b(int paramInt)
  {
    String str = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_Boolean) && (str != null)) {
        avgx.a("0X800A9A7", str, "1");
      }
      return;
      str = "1";
      avgx.a("0X8009FEE", 1);
      continue;
      str = "2";
      avgx.a("0X8009FEE", 2);
      continue;
      avgx.a("0X8009FEE", 3);
      continue;
      avgx.a("0X8009FEE", 4);
      continue;
      str = "3";
      avgx.a("0X8009FEE", 5);
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
    apto.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString, 101);
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
  
  private void e()
  {
    this.jdField_a_of_type_Boolean = getArguments().getBoolean("is_aio_page_with_msg", false);
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "handlerArg: mHasMsg = " + this.jdField_a_of_type_Boolean);
    }
  }
  
  private void f()
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
    this.jdField_a_of_type_Avgj = new avgj(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, 0);
    this.jdField_a_of_type_Avgj.a(this.jdField_a_of_type_Avgk);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Avgj);
    this.jdField_a_of_type_Avgj.a(this.jdField_a_of_type_JavaUtilList);
    List localList = a()[0];
    Object localObject1 = new TextPaint();
    ((TextPaint)localObject1).setTextSize(getActivity().getResources().getDimensionPixelSize(2131167716));
    localObject1 = new StaticLayout(a(a(localList), 6), (TextPaint)localObject1, this.jdField_a_of_type_Int, Layout.Alignment.ALIGN_CENTER, 1.0F, this.jdField_b_of_type_Int, true);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
    }
    Object localObject2 = localList.iterator();
    int i = 0;
    if (((Iterator)localObject2).hasNext())
    {
      if (((bahx)((Iterator)localObject2).next()).d != 0) {
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
      this.jdField_a_of_type_ComTencentWidgetGridView.setAdapter(new avgu(getActivity(), localList));
      this.jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
      this.jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_Behi);
      return;
    }
  }
  
  private void g()
  {
    if (ImmersiveUtils.a(getActivity()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onResume current is liuhai style!");
      }
      bjeh.c(getActivity());
    }
  }
  
  private void h()
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
          azvq.a(paramString.getAbsolutePath(), (BitmapFactory.Options)localObject);
          int i = ((BitmapFactory.Options)localObject).outHeight;
          ((BitmapFactory.Options)localObject).inSampleSize = ((i - this.d) / i);
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
          ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
          localObject = azvq.a(paramString.getAbsolutePath(), (BitmapFactory.Options)localObject).copy(Bitmap.Config.RGB_565, true);
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
  
  protected String a(List<bahx> paramList)
  {
    Object localObject = "";
    int i = 0;
    if (i < paramList.size())
    {
      String str = ((bahx)paramList.get(i)).jdField_a_of_type_JavaLangString;
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
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment finishActivity");
      }
      localFragmentActivity.overridePendingTransition(0, 0);
    }
    if (this.jdField_b_of_type_Boolean) {
      avgx.a("0X800A9AD", "1", "");
    }
  }
  
  public List<bahx>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    bahx localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = getActivity().getString(2131630983);
    localbahx.jdField_b_of_type_Int = 2130838732;
    localbahx.jdField_b_of_type_Boolean = true;
    localbahx.jdField_c_of_type_Int = 2;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = getActivity().getString(2131630996);
    localbahx.jdField_b_of_type_Int = 2130838733;
    localbahx.jdField_b_of_type_Boolean = true;
    localbahx.jdField_c_of_type_Int = 3;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = getActivity().getString(2131631003);
    localbahx.jdField_b_of_type_Int = 2130838736;
    localbahx.jdField_c_of_type_Int = 9;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = getActivity().getString(2131630986);
    localbahx.jdField_b_of_type_Int = 2130838730;
    localbahx.jdField_c_of_type_Int = 10;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = getActivity().getString(2131627272);
    localbahx.jdField_b_of_type_Int = 2130839594;
    localbahx.jdField_c_of_type_Int = 50;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment exitScreenShotScreen");
    }
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  public void c()
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
  
  public void d()
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
      b();
    }
    do
    {
      return;
      if (paramInt1 == 2)
      {
        b();
        return;
      }
      if (paramInt1 == 3)
      {
        b();
        return;
      }
    } while (paramInt1 != 101);
    b();
  }
  
  public boolean onBackEvent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131309878: 
    case 2131309880: 
    case 2131310236: 
    case 2131299872: 
    case 2131312422: 
      do
      {
        return;
        a();
        return;
        a(false);
        avgx.a("0X8009FEF", 0);
        return;
        if (this.jdField_b_of_type_Boolean)
        {
          d();
          avgx.a("0X800A9AA", "1", "");
          return;
        }
        c();
        avgx.a("0X8009FF4", 0);
        return;
        h();
        avgx.a("0X800A8BD", 0);
      } while (!this.jdField_c_of_type_Boolean);
      avgx.a("0X800A9A5", "1", "");
      return;
    case 2131297457: 
      a(true);
      return;
    }
    a();
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
    this.jdField_a_of_type_Avgx = new avgx();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Int = getActivity().getResources().getDimensionPixelSize(2131165597);
    this.jdField_b_of_type_Int = getActivity().getResources().getDimensionPixelOffset(2131165600);
    this.jdField_c_of_type_Int = getActivity().getResources().getDimensionPixelOffset(2131165599);
    paramBundle = getActivity().getIntent();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("screen_path");
      this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("is_web_screen_long_shot", false);
      this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("is_screen_shot_from_web", false);
      if (this.jdField_b_of_type_Boolean) {
        avgx.a("0X800A9A6", "1", "");
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onCreateView");
    }
    e();
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131495464, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#aa000000"));
    this.d = getActivity().getResources().getDimensionPixelSize(2131167572);
    a(this.jdField_a_of_type_AndroidViewView);
    f();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onDestroy");
    }
    if (this.jdField_a_of_type_Avgj != null) {
      this.jdField_a_of_type_Avgj.a();
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
      ViewCompat.setOnApplyWindowInsetsListener(localFragmentActivity.getWindow().getDecorView(), new avgs(this));
      return;
    }
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotFragment
 * JD-Core Version:    0.7.0.1
 */