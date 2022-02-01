package dov.com.qq.im.ae.cmshow;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.utils.NavigationBarUtil;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityCallBackInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.ae.play.FaceChangeUtils;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.view.AECMShowFaceScanView;
import dov.com.qq.im.ae.view.AECMShowFaceScanView.FaceRectData;
import dov.com.qq.im.ae.view.AECMShowFaceScanView.ScanViewListener;
import dov.com.qq.im.capture.text.DynamicTextItem.Pair;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mqq.os.MqqHandler;

public class AECMShowPhotoPreviewFragment
  extends PublicBaseFragment
  implements View.OnClickListener, PublicFragmentActivityCallBackInterface, AECMShowFaceScanView.ScanViewListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AECMShowLoadingView jdField_a_of_type_DovComQqImAeCmshowAECMShowLoadingView;
  private AECMShowRequestController.CmShowDataWrapper jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper;
  private AECMShowRequestController jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController;
  private AECMShowFaceScanView jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private int c = 0;
  private int d = 0;
  
  private AECMShowFaceScanView.FaceRectData a(@NonNull List<PointF> paramList)
  {
    PointF localPointF1 = (PointF)paramList.get(0);
    PointF localPointF2 = (PointF)paramList.get(1);
    localPointF2 = (PointF)paramList.get(2);
    Object localObject = (PointF)paramList.get(3);
    paramList = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F);
    float f1 = TAVStickerUtil.getDistance(paramList, (PointF)localObject);
    float f2 = TAVStickerUtil.getDistance(localPointF1, localPointF2) / 2.0F;
    localObject = new AECMShowFaceScanView.FaceRectData();
    RectF localRectF = new RectF();
    localRectF.left = (paramList.x - f2);
    localRectF.right = (f2 + paramList.x);
    localRectF.top = (paramList.y - f1);
    localRectF.bottom = (f1 + paramList.y);
    ((AECMShowFaceScanView.FaceRectData)localObject).a(localRectF);
    f1 = localPointF2.y;
    f2 = localPointF1.y;
    float f3 = localPointF2.x;
    float f4 = localPointF1.x;
    ((AECMShowFaceScanView.FaceRectData)localObject).a((float)Math.toDegrees(Math.atan2(f1 - f2, f3 - f4)));
    return localObject;
  }
  
  @NonNull
  private DynamicTextItem.Pair<Boolean, List<PointF>> a(@Nullable Bitmap paramBitmap, @Nullable String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null))
    {
      AEQLog.a("AECMShowPhotoPreviewFragment", "[detectFaceLocally] invalid data");
      return new DynamicTextItem.Pair(Boolean.valueOf(false), null);
    }
    paramBitmap = FaceChangeUtils.detectBiggestFaceInGLThread(paramBitmap);
    if ((paramBitmap == null) || (paramBitmap.a == null) || (((Integer)paramBitmap.a).intValue() != 1) || (CollectionUtils.isEmpty((Collection)paramBitmap.b)))
    {
      AEQLog.b("AECMShowPhotoPreviewFragment", "[detectFaceLocally] no face detected");
      return new DynamicTextItem.Pair(Boolean.valueOf(false), null);
    }
    AEQLog.b("AECMShowPhotoPreviewFragment", "[detectFaceLocally] face detected");
    return new DynamicTextItem.Pair(Boolean.valueOf(true), FaceChangeUtils.transFromImageSpace2ContainerSpace(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight(), (List)paramBitmap.b));
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = DisplayUtil.a(getActivity());
    this.jdField_b_of_type_Int = DisplayUtil.b(getActivity());
    Object localObject = getArguments().getStringArrayList("PhotoConst.SELECTED_PATHS");
    if (!CollectionUtils.isEmpty((Collection)localObject)) {
      this.jdField_a_of_type_JavaLangString = ((String)((ArrayList)localObject).get(0));
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapUtils.decodeSampledBitmapFromFileCheckExif(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        localObject = this.jdField_a_of_type_AndroidWidgetImageView.getViewTreeObserver();
        if (((ViewTreeObserver)localObject).isAlive()) {
          ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(new AECMShowPhotoPreviewFragment.2(this));
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    PublicFragmentActivity.Launcher.a(paramActivity, paramIntent, PublicFragmentActivityForPeak.class, AECMShowPhotoPreviewFragment.class);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131377274));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369745));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369613));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380578));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380501));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131367081));
    this.jdField_a_of_type_DovComQqImAeCmshowAECMShowLoadingView = ((AECMShowLoadingView)paramView.findViewById(2131364915));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131381107);
    this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView = ((AECMShowFaceScanView)paramView.findViewById(2131366567));
    this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView.setListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(false);
  }
  
  private void a(List<PointF> paramList)
  {
    paramList = a(paramList);
    this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView.a(1001, paramList);
  }
  
  private void b()
  {
    ThreadManager.getSubThreadHandler().post(new AECMShowPhotoPreviewFragment.3(this));
    this.d = 1;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_a_of_type_DovComQqImAeCmshowAECMShowLoadingView.a(1, null);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private static void b(@NonNull Activity paramActivity, @NonNull AECMShowRequestController.CmShowDataWrapper paramCmShowDataWrapper)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("edit_video_type", 10027);
    localBundle.putInt("ability_flag", 2);
    localBundle.putInt("PeakConstants.ARG_FORCE_CAMERA", 1);
    localBundle.putSerializable("KEY_CMSHOW_DATA", paramCmShowDataWrapper);
    paramCmShowDataWrapper = QIMCameraCaptureActivity.a(paramActivity, localBundle);
    paramCmShowDataWrapper.addFlags(603979776);
    paramActivity.startActivity(paramCmShowDataWrapper);
    paramActivity.finish();
  }
  
  public void F()
  {
    this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView.a(1003, null);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130837674);
    b();
  }
  
  public void G() {}
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFlags(1024, 1024);
    if (Build.VERSION.SDK_INT >= 29) {
      NavigationBarUtil.a(paramActivity.getWindow());
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onBackPressed()
  {
    if (this.d == 2) {
      AEBaseDataReporter.a().a(1, System.currentTimeMillis() - this.jdField_a_of_type_Long);
    }
    getActivity().finish();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131380501) {
      onBackPressed();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131369613) {
        onBackPressed();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController = new AECMShowRequestController(2, new AECMShowPhotoPreviewFragment.1(this));
    this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558507, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      BitmapUtils.recycle(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController.b();
    this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper = null;
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper != null)
    {
      b(getActivity(), this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper);
      this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper = null;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    a(paramView);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.cmshow.AECMShowPhotoPreviewFragment
 * JD-Core Version:    0.7.0.1
 */