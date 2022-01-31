package dov.com.tencent.biz.qqstory.takevideo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ansm;
import ansn;
import anso;
import ansp;
import ansq;
import ansr;
import anss;
import anst;
import ansu;
import com.tencent.biz.qqstory.model.AddressDataProvider;
import com.tencent.biz.qqstory.model.AddressDataProvider.AddressInfo;
import com.tencent.biz.qqstory.model.DataProviderManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.QIMReportController;
import com.tencent.mobileqq.statistics.reportitem.QIMReadWriteReportItem;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.BubblePopupWindow;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.QIMStoryEffectCameraCaptureUnit;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.paster.PasterDataManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.util.QIMAnimationUtils;
import dov.com.qq.im.capture.util.QIMAnimationUtils.AnimatorParams;
import dov.com.qq.im.capture.view.PressScaleAnimDelegate;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import java.util.ArrayList;
import mqq.app.AppRuntime;

@TargetApi(11)
public class EditVideoButton
  extends EditVideoPart
  implements View.OnClickListener, EditButtonExport
{
  public static int a;
  public static final SparseArray a;
  public static final int[] a;
  public static int b;
  private long jdField_a_of_type_Long;
  private LayoutTransition jdField_a_of_type_AndroidAnimationLayoutTransition = new LayoutTransition();
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private HorizontalScrollView jdField_a_of_type_AndroidWidgetHorizontalScrollView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  public boolean a;
  private ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView;
  private SparseArray jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private CheckBox jdField_b_of_type_AndroidWidgetCheckBox;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  public int c;
  private View jdField_c_of_type_AndroidViewView;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  boolean jdField_c_of_type_Boolean = false;
  private View jdField_d_of_type_AndroidViewView;
  private ViewGroup jdField_d_of_type_AndroidViewViewGroup;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  public boolean d;
  private View jdField_e_of_type_AndroidViewView;
  private ViewGroup jdField_e_of_type_AndroidViewViewGroup;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  public boolean e;
  private View jdField_f_of_type_AndroidViewView;
  private ViewGroup jdField_f_of_type_AndroidViewViewGroup;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean;
  private ViewGroup jdField_g_of_type_AndroidViewViewGroup;
  private boolean jdField_g_of_type_Boolean;
  private ViewGroup h;
  private ViewGroup i;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131364465, 2131364466, 2131364467, 2131364468, 2131364469, 2131364470, 2131364471, 2131364472, 2131364473, 2131364474, 2131364475, 2131364457, 2131364458 };
    jdField_a_of_type_Int = 103;
    jdField_b_of_type_Int = 536870920;
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_AndroidUtilSparseArray.put(4, new EditVideoButton.EntryButtonInfo(4, 2130841818, "添加背景音乐"));
    jdField_a_of_type_AndroidUtilSparseArray.put(32, new EditVideoButton.EntryButtonInfo(32, 2130841816, "涂鸦画笔"));
    jdField_a_of_type_AndroidUtilSparseArray.put(8, new EditVideoButton.EntryButtonInfo(8, 2130841814, "添加文字"));
    jdField_a_of_type_AndroidUtilSparseArray.put(2, new EditVideoButton.EntryButtonInfo(2, 2130841820, "添加贴纸"));
    jdField_a_of_type_AndroidUtilSparseArray.put(512, new EditVideoButton.EntryButtonInfo(512, 2130843623, "添加标签"));
    jdField_a_of_type_AndroidUtilSparseArray.put(128, new EditVideoButton.EntryButtonInfo(128, 2130841813, "艺术化滤镜"));
    jdField_a_of_type_AndroidUtilSparseArray.put(64, new EditVideoButton.EntryButtonInfo(64, 2130841812, "裁剪"));
    jdField_a_of_type_AndroidUtilSparseArray.put(1048576, new EditVideoButton.EntryButtonInfo(1048576, 2130843742, "分享到群"));
    jdField_a_of_type_AndroidUtilSparseArray.put(8192, new EditVideoButton.EntryButtonInfo(8192, 2130843160, "保存到手机"));
    jdField_a_of_type_AndroidUtilSparseArray.put(32768, new EditVideoButton.EntryButtonInfo(32768, 2130841819, "GIF快慢"));
    jdField_a_of_type_AndroidUtilSparseArray.put(65536, new EditVideoButton.EntryButtonInfo(65536, 2130843484, "生成GIF"));
    jdField_a_of_type_AndroidUtilSparseArray.put(4194304, new EditVideoButton.EntryButtonInfo(4194304, 2130841819, "镜头速度"));
    jdField_a_of_type_AndroidUtilSparseArray.put(16, new EditVideoButton.EntryButtonInfo(16, 2130841813, "滤镜"));
    jdField_a_of_type_AndroidUtilSparseArray.put(1, new EditVideoButton.EntryButtonInfo(1, 2130841810, "套餐"));
    jdField_a_of_type_AndroidUtilSparseArray.put(8388608, new EditVideoButton.EntryButtonInfo(8388608, 2130841817, "多人分享"));
    jdField_a_of_type_AndroidUtilSparseArray.put(536870912, new EditVideoButton.EntryButtonInfo(536870912, 2130841815, "好友互动"));
  }
  
  public EditVideoButton(@NonNull EditVideoPartManager paramEditVideoPartManager, int paramInt)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Int = paramInt;
  }
  
  private void a(@Nullable ImageView paramImageView)
  {
    int j = 0;
    while (j < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(j);
      if (localImageView != null) {
        localImageView.clearColorFilter();
      }
      j += 1;
    }
    if (paramImageView != null) {
      paramImageView.setColorFilter(a().getColor(2131493442), PorterDuff.Mode.SRC_IN);
    }
    if (this.jdField_f_of_type_Boolean)
    {
      paramImageView = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(4);
      if (paramImageView != null) {
        paramImageView.setColorFilter(a().getColor(2131493442), PorterDuff.Mode.SRC_IN);
      }
    }
  }
  
  private void a(View... paramVarArgs)
  {
    float f1 = FontSettingManager.a();
    int k;
    int j;
    if (f1 > 16.0F)
    {
      k = paramVarArgs.length;
      j = 0;
    }
    for (;;)
    {
      View localView;
      if (j < k)
      {
        localView = paramVarArgs[j];
        if ((localView != null) && (localView.getLayoutParams() != null)) {}
      }
      else
      {
        return;
      }
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      if (localView.getId() != 2131364460) {
        localLayoutParams.height = ((int)(localLayoutParams.height * (16.0F / f1)));
      }
      localLayoutParams.width = ((int)(localLayoutParams.width * (16.0F / f1)));
      SLog.b("Q.qqstory.record.EditVideoButton", "new size : " + localView.toString() + ", height=" + localLayoutParams.height + ", width=" + localLayoutParams.width);
      localView.setLayoutParams(localLayoutParams);
      if ((localView instanceof TextView))
      {
        float f2 = ((TextView)localView).getTextSize();
        float f3 = 16.0F / f1;
        ((TextView)localView).setTextSize(0, f2 * f3);
      }
      j += 1;
    }
  }
  
  private ImageView[] a(int paramInt, @NonNull ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 102) {
      this.jdField_c_of_type_Boolean = true;
    }
    int m = jdField_a_of_type_ArrayOfInt.length;
    if (((PasterDataManager)QIMManager.a(4)).a()) {
      jdField_a_of_type_AndroidUtilSparseArray.put(1, new EditVideoButton.EntryButtonInfo(1, 2130841811, "套餐"));
    }
    int i1;
    int n;
    for (;;)
    {
      i1 = 0x205182FF & paramInt & (jdField_a_of_type_Int | jdField_b_of_type_Int);
      j = 0;
      paramInt = 0;
      while (paramInt < 31)
      {
        n = 1 << paramInt;
        k = j;
        if ((i1 & n & jdField_a_of_type_Int) == n) {
          k = j + 1;
        }
        paramInt += 1;
        j = k;
      }
      jdField_a_of_type_AndroidUtilSparseArray.put(1, new EditVideoButton.EntryButtonInfo(1, 2130841810, "套餐"));
    }
    SLog.a("Q.qqstory.record.EditVideoButton", "initEditButtons, needFirstStepButtonCount = %d", Integer.valueOf(j));
    if (m < j) {
      throw new IllegalArgumentException("too many parts, there is no enough view to show");
    }
    ImageView[] arrayOfImageView = new ImageView[m];
    paramInt = 0;
    while (paramInt < m)
    {
      paramViewGroup = a(jdField_a_of_type_ArrayOfInt[paramInt]);
      if ((paramViewGroup instanceof ImageView))
      {
        arrayOfImageView[paramInt] = ((ImageView)paramViewGroup);
        paramInt += 1;
      }
      else
      {
        throw new IllegalArgumentException("can not find ImageView by id : " + jdField_a_of_type_ArrayOfInt[paramInt] + ", view : " + paramViewGroup);
      }
    }
    this.jdField_a_of_type_AndroidUtilSparseIntArray.clear();
    int j = 0;
    paramInt = 11;
    int k = 0;
    for (;;)
    {
      m = j;
      if (k < 31)
      {
        int i2 = 1 << k;
        n = paramInt;
        m = j;
        label340:
        EditVideoButton.EntryButtonInfo localEntryButtonInfo;
        if ((i1 & i2) == i2)
        {
          if ((jdField_a_of_type_Int & i2) != i2) {
            break label436;
          }
          paramViewGroup = arrayOfImageView[j];
          j += 1;
          localEntryButtonInfo = (EditVideoButton.EntryButtonInfo)jdField_a_of_type_AndroidUtilSparseArray.get(i2);
        }
        try
        {
          paramViewGroup.setImageDrawable(new BitmapDrawable(BitmapFactory.decodeResource(a(), localEntryButtonInfo.jdField_b_of_type_Int)));
          paramViewGroup.setContentDescription(localEntryButtonInfo.a);
          paramViewGroup.setOnClickListener(paramOnClickListener);
          this.jdField_a_of_type_AndroidUtilSparseIntArray.put(paramViewGroup.getId(), i2);
          this.jdField_b_of_type_AndroidUtilSparseArray.put(i2, paramViewGroup);
          m = j;
          n = paramInt;
          for (;;)
          {
            k += 1;
            paramInt = n;
            j = m;
            break;
            label436:
            if (((jdField_b_of_type_Int & i2) == i2) && (paramInt < jdField_a_of_type_ArrayOfInt.length))
            {
              paramViewGroup = jdField_a_of_type_ArrayOfInt;
              m = paramInt + 1;
              paramViewGroup = (ImageView)a(paramViewGroup[paramInt]);
              paramInt = m;
              break label340;
            }
            SLog.e("Q.qqstory.record.EditVideoButton", "initEditButtons second step buttons not enough");
            n = paramInt;
            m = j;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            SLog.e("Q.qqstory.record.EditVideoButton", "decodeResource OutOfMemoryError : %s", new Object[] { localEntryButtonInfo.a });
          }
        }
      }
    }
    for (;;)
    {
      j = paramInt;
      if (m >= 11) {
        break;
      }
      arrayOfImageView[m].setOnClickListener(null);
      arrayOfImageView[m].setVisibility(8);
      m += 1;
    }
    while (j < jdField_a_of_type_ArrayOfInt.length)
    {
      arrayOfImageView[j].setOnClickListener(null);
      arrayOfImageView[j].setVisibility(8);
      j += 1;
    }
    return arrayOfImageView;
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e()) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.f()))
    {
      if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.jdField_d_of_type_Boolean) {
        break label79;
      }
      a(true, false);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.a.removeMessages(994);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.a.sendEmptyMessage(995);
    }
    label79:
    do
    {
      return;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.a.sendEmptyMessageDelayed(994, 0L);
    } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.jdField_b_of_type_Boolean);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText("0%");
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844701);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      View localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362500);
      if (localView != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.removeView(localView);
      }
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.g();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    this.jdField_e_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_e_of_type_AndroidViewViewGroup.setAlpha(0.0F);
    this.jdField_f_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_f_of_type_AndroidViewViewGroup.setAlpha(0.0F);
    this.i.setVisibility(0);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new QIMAnimationUtils.AnimatorParams(this.jdField_d_of_type_AndroidViewViewGroup, "translationY", 0.0F, a().getDimension(2131559493), 300L, 0L));
    localArrayList.add(new QIMAnimationUtils.AnimatorParams(this.jdField_d_of_type_AndroidViewViewGroup, "alpha", 1.0F, 0.0F, 300L, 0L));
    localArrayList.add(new QIMAnimationUtils.AnimatorParams(this.jdField_e_of_type_AndroidViewViewGroup, "translationY", UIUtils.a(a(), 160.0F), 0.0F, 300L, 300L));
    localArrayList.add(new QIMAnimationUtils.AnimatorParams(this.jdField_e_of_type_AndroidViewViewGroup, "alpha", 0.0F, 1.0F, 300L, 300L));
    localArrayList.add(new QIMAnimationUtils.AnimatorParams(this.jdField_b_of_type_AndroidWidgetTextView, "translationY", 0.0F, -1.0F * a().getDimension(2131559494), 300L, 0L));
    localArrayList.add(new QIMAnimationUtils.AnimatorParams(this.jdField_b_of_type_AndroidWidgetTextView, "alpha", 1.0F, 0.0F, 300L, 0L));
    localArrayList.add(new QIMAnimationUtils.AnimatorParams(this.i, "translationY", -1.0F * a().getDimension(2131559494), 0.0F, 300L, 300L));
    localArrayList.add(new QIMAnimationUtils.AnimatorParams(this.i, "alpha", 0.0F, 1.0F, 300L, 300L));
    localArrayList.add(new QIMAnimationUtils.AnimatorParams(this.jdField_f_of_type_AndroidViewViewGroup, "translationY", -1.0F * a().getDimension(2131559494), 0.0F, 300L, 300L));
    localArrayList.add(new QIMAnimationUtils.AnimatorParams(this.jdField_f_of_type_AndroidViewViewGroup, "alpha", 0.0F, 1.0F, 300L, 300L));
    QIMAnimationUtils.a(localArrayList, new anst(this));
    this.jdField_c_of_type_Long = (System.currentTimeMillis() + 600L);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 11, Long.valueOf(this.jdField_c_of_type_Long)));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 12, 2, (int)this.jdField_c_of_type_Long));
  }
  
  private void m()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.z();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.g();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_d_of_type_AndroidViewViewGroup.setAlpha(0.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new QIMAnimationUtils.AnimatorParams(this.jdField_e_of_type_AndroidViewViewGroup, "translationY", 0.0F, UIUtils.a(a(), 160.0F), 300L, 0L));
    localArrayList.add(new QIMAnimationUtils.AnimatorParams(this.jdField_e_of_type_AndroidViewViewGroup, "alpha", 1.0F, 0.0F, 300L, 0L));
    localArrayList.add(new QIMAnimationUtils.AnimatorParams(this.jdField_d_of_type_AndroidViewViewGroup, "translationY", a().getDimension(2131559493), 0.0F, 300L, 300L));
    localArrayList.add(new QIMAnimationUtils.AnimatorParams(this.jdField_d_of_type_AndroidViewViewGroup, "alpha", 0.0F, 1.0F, 300L, 300L));
    localArrayList.add(new QIMAnimationUtils.AnimatorParams(this.jdField_b_of_type_AndroidWidgetTextView, "translationY", -1.0F * a().getDimension(2131559494), 0.0F, 300L, 300L));
    localArrayList.add(new QIMAnimationUtils.AnimatorParams(this.jdField_b_of_type_AndroidWidgetTextView, "alpha", 0.0F, 1.0F, 300L, 300L));
    localArrayList.add(new QIMAnimationUtils.AnimatorParams(this.i, "translationY", 0.0F, -1.0F * a().getDimension(2131559494), 300L, 0L));
    localArrayList.add(new QIMAnimationUtils.AnimatorParams(this.i, "alpha", 1.0F, 0.0F, 300L, 0L));
    localArrayList.add(new QIMAnimationUtils.AnimatorParams(this.jdField_f_of_type_AndroidViewViewGroup, "translationY", 0.0F, -1.0F * a().getDimension(2131559494), 300L, 0L));
    localArrayList.add(new QIMAnimationUtils.AnimatorParams(this.jdField_f_of_type_AndroidViewViewGroup, "alpha", 1.0F, 0.0F, 300L, 0L));
    QIMAnimationUtils.a(localArrayList, new ansu(this));
    this.jdField_c_of_type_Long = (System.currentTimeMillis() + 600L);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 11, Long.valueOf(this.jdField_c_of_type_Long)));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 12, 1, (int)this.jdField_c_of_type_Long));
  }
  
  QQAppInterface a()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi != null) {
      return ((BaseActivity)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi).app;
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131364426));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131364452));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131364460));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = a(2131364464);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = a(2131364443);
    this.jdField_f_of_type_AndroidViewView = a(2131364442);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131363408));
    this.jdField_g_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131364463));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = a(this.jdField_c_of_type_Int, this.jdField_g_of_type_AndroidViewViewGroup, this);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131364424));
    this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131364459));
    this.jdField_e_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131364451));
    this.jdField_f_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131364441));
    this.jdField_c_of_type_AndroidViewViewGroup = this.jdField_d_of_type_AndroidViewViewGroup;
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)a(2131364462));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getViewTreeObserver().addOnScrollChangedListener(new ansm(this));
    this.h = ((ViewGroup)a(2131364456));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131364454));
    this.i = ((ViewGroup)a(2131364425));
    this.i.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = a(2131364439);
    Object localObject1;
    Object localObject2;
    boolean bool;
    if ((this.jdField_c_of_type_Int & 0x4000) != 0)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      localObject1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle;
      localObject2 = this.jdField_a_of_type_AndroidWidgetCheckBox;
      if ((localObject1 != null) && (((Bundle)localObject1).getBoolean("sync_story_checked", false))) {
        bool = true;
      }
    }
    for (;;)
    {
      a((CheckBox)localObject2, bool);
      this.jdField_d_of_type_Boolean = this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked();
      label398:
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131364427));
      if (SharedPreUtils.aY(a(), a().getCurrentAccountUin()) == 0)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        label438:
        if ((this.jdField_c_of_type_Int & 0x2000) != 0) {
          localObject1 = (EditVideoButton.EntryButtonInfo)jdField_a_of_type_AndroidUtilSparseArray.get(8192);
        }
      }
      try
      {
        localObject2 = BitmapFactory.decodeResource(a(), ((EditVideoButton.EntryButtonInfo)localObject1).jdField_b_of_type_Int);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable((Bitmap)localObject2));
        this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(((EditVideoButton.EntryButtonInfo)localObject1).a);
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131364431));
        if ((this.jdField_c_of_type_Int & 0x40000000) != 0)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject1 = (EditVideoButton.EntryButtonInfo)jdField_a_of_type_AndroidUtilSparseArray.get(1073741824);
          if (localObject1 == null) {}
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          localObject2 = BitmapFactory.decodeResource(a(), ((EditVideoButton.EntryButtonInfo)localObject1).jdField_b_of_type_Int);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable((Bitmap)localObject2));
          this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
          if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 102) {
            this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
          }
          this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)a(2131364428));
          this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)a(2131364430));
          this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)a(2131364429));
          if (((this.jdField_c_of_type_Int & 0x4000000) != 0) && (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() != 0))
          {
            this.jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(0);
            this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
            localObject1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle;
            localObject2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent();
            if ((localObject1 != null) && (((Bundle)localObject1).getBoolean("extra_enable_flash_pic", false)))
            {
              bool = true;
              this.jdField_b_of_type_Boolean = bool;
              a(this.jdField_b_of_type_AndroidWidgetCheckBox, this.jdField_b_of_type_Boolean);
              this.jdField_e_of_type_Boolean = this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked();
              this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new ansn(this, (Intent)localObject2));
              this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131364434));
              this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)a(2131364438));
              this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131364435));
              this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131364436));
              this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131364437));
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
              this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
              this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
              a(new View[] { this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_c_of_type_AndroidWidgetTextView });
              a(this.jdField_a_of_type_ArrayOfAndroidWidgetImageView);
              this.jdField_a_of_type_AndroidAnimationLayoutTransition.setAnimator(3, ObjectAnimator.ofFloat(null, "alpha", new float[] { 1.0F, 0.0F }));
              this.jdField_a_of_type_AndroidAnimationLayoutTransition.setDuration(3, 500L);
              this.jdField_a_of_type_AndroidAnimationLayoutTransition.setAnimator(2, ObjectAnimator.ofFloat(null, "alpha", new float[] { 0.0F, 1.0F }));
              this.jdField_a_of_type_AndroidAnimationLayoutTransition.setDuration(2, 500L);
              if ((this.jdField_c_of_type_Int & 0x20000) == 0) {
                break label1318;
              }
              this.jdField_f_of_type_AndroidViewView.setVisibility(0);
              this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
              StoryReportor.a("pub_control", "exp_entry", 0, 0, new String[0]);
              this.jdField_d_of_type_AndroidViewView = a(2131364447);
              this.jdField_e_of_type_AndroidViewView = a(2131364422);
              if ((this.jdField_c_of_type_Int & 0x8000000) == 0) {
                break label1330;
              }
              this.jdField_d_of_type_AndroidViewView.setVisibility(0);
              this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
              this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
              if (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeGifSource)) {
                break label1351;
              }
              this.jdField_b_of_type_AndroidWidgetTextView.setText("重拍");
              this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription("重拍");
              a(EditButtonExport.class, this);
              this.jdField_g_of_type_Boolean = false;
              this.jdField_a_of_type_Boolean = BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).getBoolean("showFlashPic", true);
              if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
                this.jdField_a_of_type_AndroidWidgetTextView.setText("给图片贴上文字");
              }
              ((View)this.jdField_a_of_type_AndroidWidgetButton.getParent()).post(new anso(this));
              return;
              bool = false;
              continue;
              this.jdField_b_of_type_AndroidViewView.setVisibility(8);
              break label398;
              this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
              break label438;
              localOutOfMemoryError1 = localOutOfMemoryError1;
              SLog.e("Q.qqstory.record.EditVideoButton", "decodeResource OutOfMemoryError : %s", new Object[] { ((EditVideoButton.EntryButtonInfo)localObject1).a });
            }
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          for (;;)
          {
            SLog.e("Q.qqstory.record.EditVideoButton", "decodeResource OutOfMemoryError : %s", new Object[] { ((EditVideoButton.EntryButtonInfo)localObject1).a });
            continue;
            bool = false;
            continue;
            this.jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
            this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
            continue;
            label1318:
            this.jdField_f_of_type_AndroidViewView.setVisibility(8);
            continue;
            label1330:
            this.jdField_d_of_type_AndroidViewView.setVisibility(8);
            this.jdField_e_of_type_AndroidViewView.setVisibility(8);
            continue;
            label1351:
            if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource))
            {
              this.jdField_b_of_type_AndroidWidgetTextView.setText("返回");
              this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription("返回");
            }
            else if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.g())
            {
              this.jdField_b_of_type_AndroidWidgetTextView.setText("取消");
              this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription("取消");
            }
            else if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c())
            {
              this.jdField_b_of_type_AndroidWidgetTextView.setText("重拍");
              this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription("重拍");
            }
            else
            {
              this.jdField_b_of_type_AndroidWidgetTextView.setText("取消");
              this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription("取消");
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(4);
    if (localImageView != null) {
      localImageView.setImageResource(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
    }
    int j;
    switch (paramInt2)
    {
    case 20: 
    case 22: 
    case 25: 
    case 26: 
    case 33: 
    case 35: 
    default: 
    case 0: 
    case 27: 
    case 31: 
    case 32: 
      do
      {
        return;
        a(null);
        this.jdField_c_of_type_AndroidViewViewGroup.setBackgroundColor(0);
        if (paramInt1 == 9)
        {
          paramInt2 = 1;
          if (paramInt1 != 23) {
            break label242;
          }
        }
        for (j = 1;; j = 0)
        {
          if ((j | paramInt2) == 0) {
            break label248;
          }
          b(true, true);
          return;
          paramInt2 = 0;
          break;
        }
        if (paramInt1 == 27)
        {
          a(true, true, false);
          return;
        }
        b(true, false);
        return;
        a(false, true, false);
        VideoEditReport.b("0X80080E5", VideoEditReport.jdField_a_of_type_Int);
        return;
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
        return;
      } while (paramInt1 != 31);
      this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
    case 10: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 19: 
    case 24: 
      a(null);
      b(true, false);
      return;
    case 7: 
      a((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(32));
      this.jdField_c_of_type_AndroidViewViewGroup.setBackgroundColor(a().getColor(2131492916));
      if (paramInt1 == 8)
      {
        if ((paramObject != null) && ((paramObject instanceof Boolean)))
        {
          a(true, true, ((Boolean)paramObject).booleanValue());
          return;
        }
        b(true, true);
        return;
      }
      b(true, false);
      return;
    case 5: 
      if ((paramInt1 != paramInt2) && (this.jdField_c_of_type_Boolean)) {
        a((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(8));
      }
      int k = -1;
      j = k;
      if (paramObject != null)
      {
        j = k;
        if ((paramObject instanceof Integer)) {
          j = ((Integer)paramObject).intValue();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.record.EditVideoButton", 2, "editVideoStateChanged text old:" + paramInt1 + " new:" + paramInt2 + " softInputMode:" + j);
      }
      if (j == 0) {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      for (;;)
      {
        b(false, false, true);
        return;
        b(true, false);
      }
    case 6: 
      a((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(2));
      b(false, false, true);
      return;
    case 18: 
      a((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(1024));
      return;
    case 8: 
      if ((paramObject != null) && ((paramObject instanceof Boolean)))
      {
        b(false, ((Boolean)paramObject).booleanValue());
        return;
      }
      b(false, true);
      return;
    case 9: 
    case 23: 
      b(false, true);
      return;
    case 1: 
    case 3: 
    case 4: 
    case 12: 
    case 34: 
    case 37: 
      b(false, false);
      return;
    case 11: 
      a((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(64));
      b(false, false);
      return;
    case 21: 
      a((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(32768));
      b(false, false);
      return;
    case 28: 
      a((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(4194304));
      return;
    case 2: 
      a((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(4));
      b(false, false, true);
      return;
    case 29: 
      a((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(16));
      return;
    case 30: 
      label242:
      label248:
      a((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(1));
      b(false, false, true);
      return;
    }
    b(false, false, true);
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    String str1;
    if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d())
    {
      paramGenerateContext.jdField_d_of_type_Boolean = this.jdField_d_of_type_Boolean;
      SharedPreUtils.d(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity(), this.jdField_d_of_type_Boolean);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle == null) {
        break label128;
      }
      paramInt = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getInt("curType", 1);
      if (paramInt != 1) {
        break label133;
      }
      str1 = "1";
      label83:
      if (!this.jdField_d_of_type_Boolean) {
        break label140;
      }
    }
    label128:
    label133:
    label140:
    for (String str2 = "2";; str2 = "1")
    {
      StoryReportor.a("aio_shoot", "clk_send", 0, 0, new String[] { str1, str2 });
      paramGenerateContext.jdField_e_of_type_Boolean = this.jdField_e_of_type_Boolean;
      return;
      paramInt = 1;
      break;
      str1 = "2";
      break label83;
    }
  }
  
  public void a(CheckBox paramCheckBox, boolean paramBoolean)
  {
    paramCheckBox.setChecked(paramBoolean);
    if (paramBoolean)
    {
      paramCheckBox.setButtonDrawable(2130842985);
      return;
    }
    paramCheckBox.setButtonDrawable(2130842983);
  }
  
  public void a(boolean paramBoolean)
  {
    int j = 1;
    int k = 0;
    if (paramBoolean) {}
    for (;;)
    {
      SLog.d("Q.qqstory.record.EditVideoButton", "setEnableButtonEnable: %d", new Object[] { Integer.valueOf(j) });
      this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
      j = k;
      while (j < this.jdField_b_of_type_AndroidUtilSparseArray.size())
      {
        k = this.jdField_b_of_type_AndroidUtilSparseArray.keyAt(j);
        ((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(k)).setEnabled(paramBoolean);
        j += 1;
      }
      j = 0;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    if (!paramBoolean2)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844374);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844375);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int k = 8;
    if (paramBoolean2)
    {
      this.jdField_c_of_type_Long = (System.currentTimeMillis() + 500L);
      if (paramBoolean3) {
        this.jdField_c_of_type_Long += 500L;
      }
      if (paramBoolean1) {
        TakeVideoUtils.b(this.jdField_a_of_type_AndroidViewViewGroup, paramBoolean3);
      }
      for (;;)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 11, Long.valueOf(this.jdField_c_of_type_Long)));
        if (!paramBoolean1) {
          break;
        }
        j = 0;
        while (j < this.jdField_b_of_type_AndroidUtilSparseArray.size())
        {
          ((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(j)).setVisibility(0);
          j += 1;
        }
        TakeVideoUtils.a(this.jdField_a_of_type_AndroidViewViewGroup, paramBoolean3);
      }
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setAnimation(null);
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramBoolean1) {}
    for (int j = 0;; j = 8)
    {
      ((ViewGroup)localObject).setVisibility(j);
      this.jdField_c_of_type_Long = 0L;
      break;
    }
    if ((this.jdField_c_of_type_Int & 0x20000) != 0)
    {
      localObject = this.jdField_f_of_type_AndroidViewView;
      if (!paramBoolean1) {
        break label273;
      }
    }
    label273:
    for (j = 0;; j = 8)
    {
      ((View)localObject).setVisibility(j);
      if ((this.jdField_c_of_type_Int & 0x4000) != 0)
      {
        localObject = this.jdField_b_of_type_AndroidViewView;
        j = k;
        if (paramBoolean1) {
          j = 0;
        }
        ((View)localObject).setVisibility(j);
      }
      if (paramBoolean1)
      {
        if (this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() != 0) {
          this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        }
        if (this.jdField_c_of_type_AndroidViewViewGroup.getVisibility() != 0) {
          this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
        }
      }
      return;
    }
  }
  
  public boolean a()
  {
    if (System.currentTimeMillis() < this.jdField_c_of_type_Long) {
      return true;
    }
    if (this.jdField_c_of_type_AndroidViewViewGroup == this.jdField_e_of_type_AndroidViewViewGroup)
    {
      m();
      k();
      return true;
    }
    return false;
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.a(paramMessage);
      ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramMessage.arg1);
      if (localImageView != null)
      {
        SLog.b("Q.qqstory.record.EditVideoButton", "perform button click %s", localImageView);
        localImageView.performClick();
      }
      else
      {
        SLog.d("Q.qqstory.record.EditVideoButton", "can not find view performing click by enable mask %d", new Object[] { Integer.valueOf(paramMessage.arg1) });
      }
    }
  }
  
  public void aE_()
  {
    super.aE_();
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_b_of_type_Int == 0) && (!this.jdField_g_of_type_Boolean))
    {
      if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource)))
      {
        int j = AIOUtils.a(-48.0F, a());
        ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewViewGroup, "translationY", new float[] { j, 0.0F });
        localObjectAnimator1.setDuration(800L);
        j = AIOUtils.a(a().getDimension(2131559493), a());
        ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_c_of_type_AndroidViewViewGroup, "translationY", new float[] { j, 0.0F });
        localObjectAnimator2.setDuration(800L);
        AnimatorSet localAnimatorSet = new AnimatorSet();
        localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
        localAnimatorSet.start();
      }
      this.jdField_g_of_type_Boolean = true;
    }
  }
  
  public void b(int paramInt)
  {
    ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(1048576);
    if (localImageView != null) {
      localImageView.setImageResource(paramInt);
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramBoolean1, paramBoolean2, true);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int k = 0;
    if (paramBoolean2)
    {
      this.jdField_c_of_type_Long = (System.currentTimeMillis() + 500L);
      if (paramBoolean3) {
        this.jdField_c_of_type_Long += 500L;
      }
      if (paramBoolean1) {
        TakeVideoUtils.b(this.jdField_c_of_type_AndroidViewViewGroup, paramBoolean3);
      }
      for (;;)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 11, Long.valueOf(this.jdField_c_of_type_Long)));
        if (!paramBoolean1) {
          break;
        }
        j = 0;
        while (j < this.jdField_b_of_type_AndroidUtilSparseArray.size())
        {
          ((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(j)).setVisibility(0);
          j += 1;
        }
        TakeVideoUtils.a(this.jdField_c_of_type_AndroidViewViewGroup, paramBoolean3);
      }
    }
    this.jdField_c_of_type_AndroidViewViewGroup.setAnimation(null);
    Object localObject = this.jdField_c_of_type_AndroidViewViewGroup;
    if (paramBoolean1) {}
    for (int j = 0;; j = 8)
    {
      ((ViewGroup)localObject).setVisibility(j);
      this.jdField_c_of_type_Long = 0L;
      break;
    }
    if ((this.jdField_c_of_type_Int & 0x20000) != 0)
    {
      localObject = this.jdField_f_of_type_AndroidViewView;
      if (paramBoolean1)
      {
        j = 0;
        ((View)localObject).setVisibility(j);
      }
    }
    else if ((this.jdField_c_of_type_Int & 0x4000) != 0)
    {
      localObject = this.jdField_b_of_type_AndroidViewView;
      if (!paramBoolean1) {
        break label236;
      }
    }
    label236:
    for (j = k;; j = 8)
    {
      ((View)localObject).setVisibility(j);
      return;
      j = 8;
      break;
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(33))
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(33, Integer.valueOf(1001));
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(paramInt);
  }
  
  public void onClick(View paramView)
  {
    int k;
    if (Math.abs(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) > 500L)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      k = paramView.getId();
      if (this.jdField_c_of_type_Long <= System.currentTimeMillis()) {
        break label82;
      }
      SLog.d("Q.qqstory.record.EditVideoButton", "animation is playing, please wait, animation end time: %d, now: %d.", new Object[] { Long.valueOf(this.jdField_c_of_type_Long), Long.valueOf(System.currentTimeMillis()) });
    }
    label82:
    int j;
    label360:
    label362:
    boolean bool;
    label472:
    label487:
    label886:
    do
    {
      return;
      SLog.d("Q.qqstory.record.EditVideoButton", "you click button too fast, ignore it !");
      return;
      localObject1 = jdField_a_of_type_ArrayOfInt;
      int m = localObject1.length;
      j = 0;
      for (;;)
      {
        if (j >= m) {
          break label1741;
        }
        if (localObject1[j] == k)
        {
          k = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(k);
          SLog.d("Q.qqstory.record.EditVideoButton", "onClick : mask=%d, view=%s", new Object[] { Integer.valueOf(k), paramView });
          VideoEditReport.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X8007822");
          k();
          j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 1, k, 0, paramView));
          if (j > 0)
          {
            SLog.c("Q.qqstory.record.EditVideoButton", "%d parts intercept the click event : " + j);
            return;
          }
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.z();
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.q();
          switch (k)
          {
          default: 
            j = -1;
          }
          for (;;)
          {
            localObject1 = null;
            if (j != -1) {
              localObject1 = new ansp(this, j);
            }
            if ((jdField_a_of_type_Int & k) != k) {
              break;
            }
            PressScaleAnimDelegate.a(paramView, 200L, (View.OnClickListener)localObject1);
            return;
            if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(2))
            {
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
              j = -1;
            }
            else
            {
              bool = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b(4);
              localObject1 = (AddressDataProvider)((DataProviderManager)SuperManager.a(20)).a(1);
              if (((AddressDataProvider)localObject1).a((AddressDataProvider.AddressInfo)((AddressDataProvider)localObject1).a()))
              {
                localObject1 = "2";
                if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
                  break label546;
                }
                localObject2 = "2";
                if (!bool) {
                  break label554;
                }
              }
              for (String str = "1";; str = "0")
              {
                StoryReportor.a("video_edit", "clk_music", 0, 0, new String[] { localObject2, localObject1, str, "" });
                j = 2;
                break;
                localObject1 = "1";
                break label472;
                localObject2 = "1";
                break label487;
              }
              bool = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b(5);
              if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a())
              {
                localObject1 = "2";
                if (!bool) {
                  break label769;
                }
                localObject2 = "1";
                StoryReportor.a("video_edit", "clk_graffiti", 0, 0, new String[] { localObject1, "", localObject2, "" });
                VideoEditReport.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X8007821");
                this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a("608", "10", "0", true);
                VideoEditReport.b("0X80075C4", VideoEditReport.jdField_a_of_type_Int);
                VideoEditReport.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X800781E");
                if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3))
                {
                  if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e()) {
                    break label777;
                  }
                  LpReportInfo_pf00064.allReport(628, 3);
                }
              }
              for (;;)
              {
                if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(7)) {
                  break label787;
                }
                this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
                j = -1;
                break;
                localObject1 = "1";
                break label587;
                localObject2 = "0";
                break label597;
                LpReportInfo_pf00064.report(615, 1);
              }
              j = 7;
              continue;
              VideoEditReport.b("0X80075C6", VideoEditReport.jdField_a_of_type_Int);
              VideoEditReport.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X8007820");
              if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3))
              {
                if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e()) {
                  break label886;
                }
                LpReportInfo_pf00064.allReport(628, 2);
              }
              for (;;)
              {
                if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(5)) {
                  break label896;
                }
                this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
                j = -1;
                break;
                LpReportInfo_pf00064.report(615, 3);
              }
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.u();
              j = -1;
              continue;
              bool = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b(3);
              if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a())
              {
                localObject1 = "2";
                if (!bool) {
                  break label1099;
                }
                localObject2 = "1";
                StoryReportor.a("video_edit", "add_face", 0, 0, new String[] { localObject1, "", localObject2, "" });
                VideoEditReport.b("0X80075C7", VideoEditReport.jdField_a_of_type_Int);
                if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3))
                {
                  if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e()) {
                    break label1107;
                  }
                  LpReportInfo_pf00064.allReport(628, 4);
                }
              }
              for (;;)
              {
                this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a("608", "11", "0", true);
                VideoEditReport.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X800781D");
                if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(6)) {
                  break label1117;
                }
                this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
                j = -1;
                break;
                localObject1 = "1";
                break label933;
                localObject2 = "0";
                break label943;
                LpReportInfo_pf00064.report(615, 4);
              }
              j = 6;
              continue;
              Object localObject2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
              if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {}
              for (localObject1 = "2";; localObject1 = "1")
              {
                ((EditVideoPartManager)localObject2).a("add_tag", 0, 0, new String[] { localObject1 });
                this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(1);
                j = -1;
                break;
              }
              VideoEditReport.b("0X80075C8", VideoEditReport.jdField_a_of_type_Int);
              if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
                LpReportInfo_pf00064.report(615, 5);
              }
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.t();
              j = -1;
              continue;
              VideoEditReport.b("0X80075C5", VideoEditReport.jdField_a_of_type_Int);
              if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
                LpReportInfo_pf00064.report(615, 2);
              }
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.r();
              j = -1;
              continue;
              StoryReportor.a("video_edit", "edit_alt", 0, 0, new String[0]);
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(18);
              j = -1;
              continue;
              StoryReportor.a("video_edit", "share_to_group", 0, 0, new String[0]);
              StoryReportor.a("story_grp", "clk_share_grp", 0, 0, new String[] { "", "", "", "" });
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(25);
              j = -1;
              continue;
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(19);
              j = -1;
              continue;
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(21);
              if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 3)) {
                break label360;
              }
              if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e())
              {
                LpReportInfo_pf00064.allReport(628, 5, 1);
                j = -1;
              }
              else
              {
                LpReportInfo_pf00064.report(615, 5);
                j = -1;
                continue;
                if (!this.jdField_f_of_type_Boolean) {}
                for (bool = true;; bool = false)
                {
                  this.jdField_f_of_type_Boolean = bool;
                  this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.d(this.jdField_f_of_type_Boolean);
                  localObject1 = (ImageView)paramView;
                  localObject2 = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(4);
                  if (!this.jdField_f_of_type_Boolean) {
                    break label1564;
                  }
                  ((ImageView)localObject1).setImageResource(2130843485);
                  if (localObject2 == null) {
                    break;
                  }
                  ((ImageView)localObject2).setColorFilter(a().getColor(2131493442), PorterDuff.Mode.SRC_IN);
                  j = -1;
                  break label362;
                }
                ((ImageView)localObject1).setImageResource(2130843484);
                if (localObject2 == null) {
                  break label360;
                }
                ((ImageView)localObject2).clearColorFilter();
                j = -1;
                continue;
                if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(28))
                {
                  this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
                  j = -1;
                }
                else
                {
                  this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(28);
                  j = -1;
                  continue;
                  if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(29))
                  {
                    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
                    j = -1;
                  }
                  else
                  {
                    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(29);
                    j = -1;
                    continue;
                    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(30))
                    {
                      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
                      j = -1;
                    }
                    else
                    {
                      j = 30;
                      continue;
                      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(37))
                      {
                        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
                        j = -1;
                      }
                      else
                      {
                        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(37);
                        j = -1;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        j += 1;
      }
      switch (k)
      {
      default: 
        return;
      case 2131364422: 
        PressScaleAnimDelegate.a(paramView, 200L, new anss(this));
        return;
      case 2131364460: 
        if (this.jdField_c_of_type_Boolean) {
          break label1920;
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.z();
        k();
        l();
        paramView = (DynamicTextConfigManager)QIMManager.a(7);
      }
    } while (paramView.a());
    label546:
    label554:
    label587:
    label597:
    label1117:
    ThreadManager.post(new ansq(this, paramView), 8, null, true);
    label769:
    label777:
    label787:
    label933:
    label943:
    label1099:
    label1107:
    return;
    label896:
    label1564:
    label1741:
    paramView = (EditInteractPasterExport)a(EditInteractPasterExport.class);
    label1920:
    if ((paramView != null) && (!paramView.b()))
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.q();
      return;
    }
    k();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 102)
    {
      DataReporter.a().a(a(), DataReporter.a().a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager, DataReporter.T.PIC_PUBLISH, DataReporter.T.VIDEO_PUBLISH), "", DataReporter.Destination.PROFILE);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(19);
      return;
    }
    switch (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())
    {
    default: 
      DataReporter.a().a(a(), DataReporter.a().a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager, DataReporter.T.PIC_PUBLISH, DataReporter.T.VIDEO_PUBLISH));
    }
    for (;;)
    {
      if (((PasterDataManager)QIMManager.a(4)).a())
      {
        paramView = new QIMReadWriteReportItem();
        paramView.d = "0X800894E";
        QIMReportController.a(null, paramView);
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.d();
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.f() != 7) {
        break;
      }
      QIMStoryEffectCameraCaptureUnit.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a());
      StoryReportor.a("video_edit_slides", "clk_pub", 0, 0, new String[] { "0" });
      return;
      DataReporter.a().a(a(), DataReporter.a().a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager, DataReporter.T.PIC_PUBLISH, DataReporter.T.VIDEO_PUBLISH), "FEED", DataReporter.Destination.MOMENTS);
      continue;
      DataReporter.a().a(a(), DataReporter.a().a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager, DataReporter.T.PIC_PUBLISH, DataReporter.T.VIDEO_PUBLISH));
    }
    k();
    DataReporter.a().a(a(), DataReporter.a().a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager, DataReporter.T.PIC_RETAKE, DataReporter.T.VIDEO_RETAKE));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.c();
    return;
    m();
    k();
    return;
    k();
    if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
    {
      bool = true;
      a(this.jdField_a_of_type_AndroidWidgetCheckBox, bool);
      this.jdField_d_of_type_Boolean = bool;
      if ((bool) && (SharedPreUtils.d(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a()))) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(20);
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle == null) {
        break label2478;
      }
      j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getInt("curType", 1);
      label2428:
      if (j != 1) {
        break label2483;
      }
      paramView = "1";
      label2437:
      if (!bool) {
        break label2490;
      }
    }
    label2478:
    label2483:
    label2490:
    for (Object localObject1 = "2";; localObject1 = "1")
    {
      StoryReportor.a("aio_shoot", "clk_sync", 0, 0, new String[] { paramView, localObject1 });
      return;
      bool = false;
      break;
      j = 1;
      break label2428;
      paramView = "2";
      break label2437;
    }
    PressScaleAnimDelegate.a(paramView, 200L, new ansr(this));
    return;
    j();
    return;
    PressScaleAnimDelegate.a(this.jdField_c_of_type_AndroidWidgetImageView, 200L, null);
    DataReporter.a().a(a(), DataReporter.a().a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager, DataReporter.T.PIC_SAVE, DataReporter.T.VIDEO_SAVE));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.p();
    return;
    k();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b(true);
    return;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(34);
    return;
    WeishiGuideUtils.a(a(), paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoButton
 * JD-Core Version:    0.7.0.1
 */