package com.tencent.mobileqq.screendetect;

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
import com.enrique.stackblur.StackBlurManager;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gallery.view.BigImageAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.DragView;
import com.tencent.widget.Gallery;
import com.tencent.widget.GridView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.QZoneShareManager;
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
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ElasticHorScrView jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ForwardBaseOption jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption;
  private ScreenShotAdapter.OnHolderItemClickListener jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotAdapter$OnHolderItemClickListener = new ScreenShotFragment.1(this);
  private ScreenShotAdapter jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotAdapter;
  private ScreenShotHelper jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotHelper;
  protected AdapterView.OnItemClickListener a;
  private DragView jdField_a_of_type_ComTencentWidgetDragView;
  private Gallery jdField_a_of_type_ComTencentWidgetGallery;
  private GridView jdField_a_of_type_ComTencentWidgetGridView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ScreenShotFragment.5(this);
  private String jdField_a_of_type_JavaLangString;
  private List<RecentBaseData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
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
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  
  public ScreenShotFragment()
  {
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new ScreenShotFragment.4(this);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    float f2;
    float f1;
    if (paramInt == 90)
    {
      f2 = paramBitmap.getHeight();
      f1 = 0.0F;
    }
    else
    {
      f2 = paramBitmap.getHeight();
      f1 = paramBitmap.getWidth();
    }
    Object localObject = new float[9];
    localMatrix.getValues((float[])localObject);
    localMatrix.postTranslate(f2 - localObject[2], f1 - localObject[5]);
    localObject = Bitmap.createBitmap(paramBitmap.getHeight(), paramBitmap.getWidth(), Bitmap.Config.RGB_565);
    Paint localPaint = new Paint();
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    localCanvas.drawBitmap(paramBitmap, localMatrix, localPaint);
    localCanvas.setBitmap(null);
    return localObject;
  }
  
  protected static String a(String paramString, int paramInt)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() > paramInt)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.substring(0, paramInt));
        ((StringBuilder)localObject).append("\n");
        ((StringBuilder)localObject).append(paramString.substring(paramInt));
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  private void a(int paramInt)
  {
    Object localObject3 = (RecentBaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if ((localObject3 instanceof RecentUserBaseData))
    {
      b(((RecentBaseData)localObject3).getRecentUserType());
      localObject1 = null;
      if (getBaseActivity().getIntent() != null) {
        localObject1 = getBaseActivity().getIntent();
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
      ((Bundle)localObject3).putString("troop_uin", ((RecentUserBaseData)localObject1).a());
      ((Bundle)localObject3).putString("uinname", ((RecentUserBaseData)localObject1).getTitleName());
      ((Bundle)localObject3).putInt("uintype", ((RecentUserBaseData)localObject1).getRecentUserType());
      ((Bundle)localObject3).putBoolean("key_help_forward_pic", true);
      ((Intent)localObject2).setData(Uri.parse(this.jdField_a_of_type_JavaLangString));
      ((Intent)localObject2).putExtra("forward_type", 1);
      ((Intent)localObject2).putExtra("key_share_from_screen_shot", true);
      if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption == null) {
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption = ForwardOptionBuilder.a((Intent)localObject2, getBaseActivity().app, getBaseActivity());
      }
      if (((RecentUserBaseData)localObject1).getRecentUserType() == 6000)
      {
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.f.intValue(), (Bundle)localObject3);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.a.intValue(), (Bundle)localObject3);
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("handleIconItemClick : position = ");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(", data is null!");
    QLog.e("ScreenShotFragment", 2, ((StringBuilder)localObject1).toString());
  }
  
  private void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotHelper.a(paramActivity, paramQQAppInterface));
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376979));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376982));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376975));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376980));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131713505));
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131376974));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377360));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366027));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379765));
    Object localObject = this.jdField_c_of_type_AndroidWidgetTextView;
    int i;
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_e_of_type_Boolean)) {
      i = 8;
    } else {
      i = 0;
    }
    ViewUtils.b((View)localObject, i);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379774));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379827));
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)paramView.findViewById(2131365892));
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)paramView.findViewById(2131367431));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376976));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363347));
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131713510));
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)paramView.findViewById(2131377386));
    localObject = this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView;
    boolean bool = true;
    ((ElasticHorScrView)localObject).setMove(true);
    this.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramView.findViewById(2131367811));
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetDragView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(new BigImageAdapter(Collections.singletonList(this.jdField_a_of_type_JavaLangString)));
      this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131297150));
      this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(0);
      this.jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(true);
      this.jdField_a_of_type_ComTencentWidgetDragView.setEnableDrag(false);
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      ((RelativeLayout)localObject).setPadding(((RelativeLayout)localObject).getPaddingLeft(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingTop(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight(), 0);
      if (CheckPermission.isHasStoragePermission(getBaseActivity())) {
        i();
      } else {
        CheckPermission.requestStoragePermission(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, new ScreenShotFragment.2(this));
      }
      ((TextView)paramView.findViewById(2131376977)).setText(HardCodeUtil.a(2131694895));
    }
    if (this.jdField_e_of_type_Boolean) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131718548));
    }
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    ((RelativeLayout)localObject).setPadding(((RelativeLayout)localObject).getPaddingLeft(), ImmersiveUtils.getStatusBarHeight(getBaseActivity()) + 15, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingBottom());
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131719458));
    localObject = getBaseActivity();
    Uri localUri = Uri.fromFile(new File(this.jdField_a_of_type_JavaLangString));
    TextView localTextView1 = this.jdField_e_of_type_AndroidWidgetTextView;
    TextView localTextView2 = this.jdField_d_of_type_AndroidWidgetTextView;
    if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      bool = false;
    }
    ScreenShotHelper.a((Context)localObject, localUri, localTextView1, localTextView2, bool);
    paramView.findViewById(2131367513).setVisibility(this.jdField_c_of_type_AndroidWidgetTextView.getVisibility());
    paramView.findViewById(2131367514).setVisibility(this.jdField_d_of_type_AndroidWidgetTextView.getVisibility());
    paramView.findViewById(2131367515).setVisibility(this.jdField_e_of_type_AndroidWidgetTextView.getVisibility());
    h();
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
    QZoneShareManager.publishToQzone(paramBaseActivity, getBaseActivity(), localBundle, null, 2);
  }
  
  private void a(String paramString)
  {
    int i;
    if (getBaseActivity() != null)
    {
      if (getBaseActivity().isFinishing()) {
        return;
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = a(paramString);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        QLog.e("ScreenShotFragment", 1, "run: screenBitmap == null");
        return;
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("screenBitmap : width = ");
        paramString.append(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth());
        paramString.append(", height = ");
        paramString.append(this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
        QLog.d("ScreenShotFragment", 2, paramString.toString());
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() > 16)
      {
        if (this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() <= 16) {
          return;
        }
        int j = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
        i = j;
        if (this.jdField_d_of_type_Boolean)
        {
          QLog.d("ScreenShotFragment", 1, new Object[] { "long pic blur background change start, height is : ", Integer.valueOf(j) });
          int k = this.jdField_a_of_type_AndroidViewView.getHeight();
          if ((k != 0) && (j > k))
          {
            i = k;
          }
          else
          {
            i = j;
            if (getBaseActivity() != null)
            {
              i = j;
              if (j > ScreenUtil.getInstantScreenHeight(getBaseActivity())) {
                i = ScreenUtil.getInstantScreenHeight(getBaseActivity());
              }
            }
          }
          QLog.d("ScreenShotFragment", 1, new Object[] { "long pic blur background change finish, height is : ", Integer.valueOf(i), " rootHeight is : ", Integer.valueOf(k) });
        }
      }
    }
    try
    {
      paramString = Bitmap.createScaledBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, (int)(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * 0.0625F), (int)(i * 0.0625F), false);
    }
    catch (OutOfMemoryError paramString)
    {
      label298:
      Object localObject;
      Canvas localCanvas;
      break label298;
    }
    QLog.e("ScreenShotFragment", 1, "create scale Bitmap error : out of memory");
    paramString = null;
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
    }
    localObject = new StackBlurManager(paramString).process(4);
    if (localObject == null)
    {
      QLog.e("ScreenShotFragment", 1, "run: blured bitmap is null");
      return;
    }
    localCanvas = new Canvas(paramString);
    localCanvas.drawColor(0);
    localCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, null);
    if ("1103".equals(ThemeUtil.curThemeId)) {
      localCanvas.drawColor(Color.parseColor("#4DEBEDF5"));
    } else {
      localCanvas.drawColor(Color.parseColor("#7F03081A"));
    }
    localCanvas.setBitmap(null);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new ScreenShotFragment.7(this, paramString));
    }
  }
  
  private void a(String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment shareToWXFriend");
    }
    WXShareHelper.a().a(paramString, paramBitmap, 0, false);
    if (getBaseActivity() != null) {
      getBaseActivity().finish();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (this.jdField_d_of_type_Boolean) {
      ScreenShotHelper.a("0X800A9A8", "1", "");
    }
  }
  
  private void b(int paramInt)
  {
    String str;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 1006)
        {
          if (paramInt != 3000)
          {
            if (paramInt == 6000)
            {
              ScreenShotHelper.a("0X8009FEE", 5);
              str = "3";
              break label94;
            }
          }
          else {
            ScreenShotHelper.a("0X8009FEE", 3);
          }
        }
        else {
          ScreenShotHelper.a("0X8009FEE", 4);
        }
        str = null;
      }
      else
      {
        ScreenShotHelper.a("0X8009FEE", 2);
        str = "2";
      }
    }
    else
    {
      ScreenShotHelper.a("0X8009FEE", 1);
      str = "1";
    }
    label94:
    if ((this.jdField_d_of_type_Boolean) && (str != null)) {
      ScreenShotHelper.a("0X800A9A7", str, "1");
    }
  }
  
  private static void b(Activity paramActivity, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ScreenShotShareFragment launchFriendPicker path = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ScreenShotFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent(paramActivity, ForwardRecentActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_help_forward_pic", true);
    ((Intent)localObject).putExtras(localBundle);
    ((Intent)localObject).putExtra("forward_type", 1);
    ((Intent)localObject).putExtra("key_allow_multiple_forward_from_limit", false);
    ((Intent)localObject).putExtra("key_share_from_screen_shot", true);
    ((Intent)localObject).putExtra("key_share_from_screen_need_finish", true);
    ((Intent)localObject).setData(Uri.parse(paramString));
    paramActivity.startActivityForResult((Intent)localObject, 3);
  }
  
  private void b(String paramString)
  {
    com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString, 101);
  }
  
  private void b(String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment shareToFriendCircle");
    }
    WXShareHelper.a().a(paramString, paramBitmap, 1, false);
    if (getBaseActivity() != null) {
      getBaseActivity().finish();
    }
  }
  
  private void f()
  {
    Object localObject = getArguments();
    this.jdField_b_of_type_Boolean = ((Bundle)localObject).getBoolean("is_aio_page_with_msg", false);
    this.jdField_c_of_type_Boolean = ((Bundle)localObject).getBoolean("switch_bottom_layout", false);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlerArg: mHasMsg = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject).append(", mSwitchLayout = ");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
      QLog.d("ScreenShotFragment", 2, ((StringBuilder)localObject).toString());
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
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getBaseActivity());
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotAdapter = new ScreenShotAdapter(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, 0);
    this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotAdapter.a(this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotAdapter$OnHolderItemClickListener);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotAdapter);
    this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotAdapter.a(this.jdField_a_of_type_JavaUtilList);
    List localList = a()[0];
    Object localObject1 = new TextPaint();
    ((TextPaint)localObject1).setTextSize(getBaseActivity().getResources().getDimensionPixelSize(2131299101));
    localObject1 = new StaticLayout(a(a(localList), 6), (TextPaint)localObject1, this.jdField_a_of_type_Int, Layout.Alignment.ALIGN_CENTER, 1.0F, this.jdField_b_of_type_Int, true);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
    }
    Object localObject2 = localList.iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext()) {
      if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject2).next()).visibility == 0) {
        i += 1;
      }
    }
    int j = this.jdField_a_of_type_Int + 20 + 20;
    this.jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(j);
    this.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(i);
    localObject2 = this.jdField_a_of_type_ComTencentWidgetGridView.getLayoutParams();
    GridView localGridView = this.jdField_a_of_type_ComTencentWidgetGridView;
    localGridView.setPadding(16, localGridView.getPaddingTop(), 16, this.jdField_a_of_type_ComTencentWidgetGridView.getPaddingBottom());
    ((ViewGroup.LayoutParams)localObject2).width = (i * j + 0 + 0);
    ((ViewGroup.LayoutParams)localObject2).height = (this.jdField_a_of_type_Int + this.jdField_c_of_type_Int + ((StaticLayout)localObject1).getHeight());
    this.jdField_a_of_type_ComTencentWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_ComTencentWidgetGridView.setAdapter(new ScreenShotFragment.ActionSheetItemAdapter(getBaseActivity(), localList));
    this.jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
    this.jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
  }
  
  private void h()
  {
    int i = this.jdField_a_of_type_AndroidWidgetTextView.getVisibility();
    int n = 1;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      k = 1;
    } else {
      k = 0;
    }
    int m;
    if (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      m = 1;
    } else {
      m = 0;
    }
    if (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() != 0) {
      n = 0;
    }
    if (i + 0 + j + k + m + n >= 4)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(12.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(12.0F);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(12.0F);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(12.0F);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(12.0F);
    }
  }
  
  private void i()
  {
    QQToast.a(getBaseActivity(), 2131718379, 0).a();
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils.a(getBaseActivity(), localFile, Utils.Crc64String(localFile.getName()));
  }
  
  private void j()
  {
    if (LiuHaiUtils.b(getBaseActivity()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onResume current is liuhai style!");
      }
      LiuHaiUtils.enableNotch(getBaseActivity());
    }
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment#screenShotLong");
    }
    if (getBaseActivity() != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("click_long_screen_shot", true);
      getBaseActivity().setResult(-1, localIntent);
      getBaseActivity().finish();
    }
  }
  
  public Bitmap a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = new File(paramString);
      if (!paramString.exists()) {
        return null;
      }
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapManager.a(paramString.getAbsolutePath(), (BitmapFactory.Options)localObject);
      int i = ((BitmapFactory.Options)localObject).outHeight;
      ((BitmapFactory.Options)localObject).inSampleSize = ((i - this.jdField_d_of_type_Int) / i);
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
      localObject = BitmapManager.a(paramString.getAbsolutePath(), (BitmapFactory.Options)localObject).copy(Bitmap.Config.RGB_565, true);
      paramString = (String)localObject;
      if (((Bitmap)localObject).getWidth() > ((Bitmap)localObject).getHeight()) {
        paramString = a((Bitmap)localObject, 90);
      }
      return paramString;
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("ScreenShotFragment", 2, "makeShareBitmap", paramString);
        return null;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotFragment", 2, "makeShareBitmap", paramString);
      }
    }
    return null;
  }
  
  protected String a(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    Object localObject1 = "";
    int i = 0;
    while (i < paramList.size())
    {
      String str = ((ShareActionSheetBuilder.ActionSheetItem)paramList.get(i)).label;
      Object localObject2 = localObject1;
      if (str.length() > ((String)localObject1).length()) {
        localObject2 = str;
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public void a()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity != null)
    {
      localBaseActivity.finish();
      localBaseActivity.overridePendingTransition(0, 0);
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment finishActivity, because app is null!");
      }
    }
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = getBaseActivity().getString(2131696399);
    localActionSheetItem.icon = 2130839067;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = getBaseActivity().getString(2131696413);
    localActionSheetItem.icon = 2130839068;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = getBaseActivity().getString(2131696420);
    localActionSheetItem.icon = 2130839071;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = getBaseActivity().getString(2131696402);
    localActionSheetItem.icon = 2130839065;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = getBaseActivity().getString(2131692771);
    localActionSheetItem.icon = 2130840164;
    localActionSheetItem.action = 50;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = getBaseActivity().getString(2131693262);
    localActionSheetItem.icon = 2130840170;
    localActionSheetItem.action = 39;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void b()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity != null)
    {
      localBaseActivity.finish();
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment finishActivity");
      }
      localBaseActivity.overridePendingTransition(0, 0);
    }
    if (this.jdField_d_of_type_Boolean) {
      ScreenShotHelper.a("0X800A9AD", "1", "");
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment exitScreenShotScreen");
    }
    if (getBaseActivity() != null) {
      getBaseActivity().finish();
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
    Intent localIntent = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(getBaseActivity(), this.jdField_a_of_type_JavaLangString, true, true, true, true, true, false, false, false, 2, 122, 0, false, null);
    getBaseActivity().startActivityForResult(localIntent, 1);
  }
  
  public void e()
  {
    QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment startCrop");
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      QLog.e("ScreenShotFragment", 1, "crop error : mCurrentPath is null");
      return;
    }
    Intent localIntent = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(getBaseActivity(), this.jdField_a_of_type_JavaLangString, true, true, true, true, true, false, false, false, 2, 133, 0, false, null);
    getBaseActivity().startActivityForResult(localIntent, 5);
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
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append(paramInt1);
      paramIntent.append(", resultCode = ");
      paramIntent.append(paramInt2);
      QLog.d("ScreenShotFragment", 2, new Object[] { "ScreenShotShareFragment onActivityResult requestCode = ", paramIntent.toString() });
    }
    if (paramInt1 == 1)
    {
      c();
      return;
    }
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
    if (paramInt1 == 101) {
      c();
    }
  }
  
  public boolean onBackEvent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131379827: 
      localIntent = new Intent();
      localIntent.putExtra("preResult", (String)this.jdField_e_of_type_AndroidWidgetTextView.getTag());
      ScreenShotHelper.a(getBaseActivity(), this.jdField_a_of_type_JavaLangString, 1, localIntent);
      ScreenShotHelper.a("0X800AC93", 0);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      break;
    case 2131379774: 
      localIntent = new Intent();
      localIntent.putExtra("preResult", (String)this.jdField_d_of_type_AndroidWidgetTextView.getTag());
      ScreenShotHelper.a(getBaseActivity(), this.jdField_a_of_type_JavaLangString, 2, localIntent);
      ScreenShotHelper.a("0X800AC94", 0);
      this.jdField_a_of_type_Boolean = true;
      break;
    case 2131379765: 
      k();
      if (this.jdField_b_of_type_Boolean) {
        ScreenShotHelper.a("0X800A8BD", 0);
      }
      if (this.jdField_e_of_type_Boolean) {
        ScreenShotHelper.a("0X800A9A5", "1", "");
      }
      break;
    case 2131377360: 
      a(false);
      ScreenShotHelper.a("0X8009FEF", 0);
      break;
    case 2131376980: 
    case 2131376982: 
      b();
      break;
    case 2131376979: 
      b();
      break;
    case 2131366027: 
      if (this.jdField_d_of_type_Boolean)
      {
        e();
        ScreenShotHelper.a("0X800A9AA", "1", "");
      }
      else
      {
        d();
        ScreenShotHelper.a("0X8009FF4", 0);
      }
      break;
    case 2131363347: 
      a(true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onCreate");
    }
    if (getBaseActivity() == null) {
      QLog.e("ScreenShotFragment", 2, "ScreenShotShareFragment onCreate activity has gone!");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getBaseActivity();
    this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotHelper = new ScreenShotHelper();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getBaseActivity().app;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      a();
      return;
    }
    a(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Int = getBaseActivity().getResources().getDimensionPixelSize(2131296796);
    this.jdField_b_of_type_Int = getBaseActivity().getResources().getDimensionPixelOffset(2131296799);
    this.jdField_c_of_type_Int = getBaseActivity().getResources().getDimensionPixelOffset(2131296798);
    paramBundle = getBaseActivity().getIntent();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("screen_path");
      this.jdField_d_of_type_Boolean = paramBundle.getBooleanExtra("is_web_screen_long_shot", false);
      this.jdField_e_of_type_Boolean = paramBundle.getBooleanExtra("is_screen_shot_from_web", false);
      if (this.jdField_d_of_type_Boolean) {
        ScreenShotHelper.a("0X800A9A6", "1", "");
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onCreateView");
    }
    f();
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131561415, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#aa000000"));
    this.jdField_d_of_type_Int = getBaseActivity().getResources().getDimensionPixelSize(2131298950);
    a(this.jdField_a_of_type_AndroidViewView);
    g();
    a(this.jdField_c_of_type_Boolean ^ true);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onDestroy");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotAdapter;
    if (localObject != null) {
      ((ScreenShotAdapter)localObject).a();
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject != null)
    {
      ((Bitmap)localObject).recycle();
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
    BaseActivity localBaseActivity = getBaseActivity();
    SystemBarCompact localSystemBarCompact = localBaseActivity.mSystemBarComp;
    if (localSystemBarCompact != null) {
      localSystemBarCompact.setgetStatusBarVisible(false, 0);
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      ViewCompat.setOnApplyWindowInsetsListener(localBaseActivity.getWindow().getDecorView(), new ScreenShotFragment.3(this));
      return;
    }
    j();
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotFragment
 * JD-Core Version:    0.7.0.1
 */