package dov.com.qq.im.ae.play;

import adxr;
import adxs;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import blup;
import blur;
import blvr;
import bmbc;
import bnnl;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import javax.annotation.Nullable;
import zjv;

public class AETakeFacePhotoPreviewFragment
  extends PublicBaseFragment
  implements adxs, View.OnClickListener
{
  public static final String INTENT_KEY_PHOTO_PATH = "photo_path";
  public static final String INTENT_RESULT_KEY_TAKE_PHOTO_PATH = "take_photo_path";
  private static String detectFacePath = "";
  private long faceDetectStartTime;
  private AppInterface mAppInterface = QQStoryContext.a();
  private blup mHandler = (blup)this.mAppInterface.getBusinessHandler(3);
  private ImageView mImgFacePreview;
  private Dialog mLoadingDialog;
  private blur mObserver;
  private Bitmap mPhotoBitmap;
  private String mPhotoPath;
  private TextView mTvAgain;
  private TextView mTvConfirm;
  private int screenHeight;
  private int screenWidth;
  
  private void choosePhotoAndBack()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("take_photo_path", this.mPhotoPath);
    getActivity().setResult(-1, localIntent);
    onBackPressed();
  }
  
  public static String getDetectFacePath()
  {
    return detectFacePath;
  }
  
  private void handleSensitiveFaceDetectResult(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      if (paramInt == 0) {
        choosePhotoAndBack();
      }
    }
    for (;;)
    {
      hideLoading();
      return;
      if (paramInt == -1)
      {
        QQToast.a(getActivity(), 2131689765, 0).a();
      }
      else if (paramInt == -2)
      {
        QQToast.a(getActivity(), 2131697223, 0).a();
        continue;
        QQToast.a(getActivity(), 2131697223, 0).a();
      }
    }
  }
  
  private void hideLoading()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()) && (this.mLoadingDialog != null) && (this.mLoadingDialog.isShowing())) {
      this.mLoadingDialog.dismiss();
    }
  }
  
  private void initData()
  {
    this.screenWidth = bnnl.a(getActivity());
    this.screenHeight = bnnl.b(getActivity());
    this.mPhotoPath = getArguments().getString("photo_path");
    if (!TextUtils.isEmpty(this.mPhotoPath))
    {
      this.mPhotoBitmap = BitmapUtils.decodeSampleBitmap(getActivity(), this.mPhotoPath, this.screenWidth, this.screenHeight);
      if (this.mPhotoBitmap != null)
      {
        this.mImgFacePreview.setImageBitmap(this.mPhotoBitmap);
        initDetectData();
        this.mTvAgain.setOnClickListener(this);
        this.mTvConfirm.setOnClickListener(this);
      }
    }
  }
  
  private void initDetectData()
  {
    detectFacePath = "";
    if (!FaceChangeUtils.hasFaceInPic(this.mPhotoBitmap)) {
      return;
    }
    FaceChangeUtils.cropFace(this.mPhotoBitmap, new AETakeFacePhotoPreviewFragment.1(this));
  }
  
  private void initView(View paramView)
  {
    this.mImgFacePreview = ((ImageView)paramView.findViewById(2131362274));
    this.mTvAgain = ((TextView)paramView.findViewById(2131362288));
    this.mTvConfirm = ((TextView)paramView.findViewById(2131362289));
  }
  
  public static void jumpToMeForResult(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    adxr.a(paramActivity, paramIntent, PublicFragmentActivityForPeak.class, AETakeFacePhotoPreviewFragment.class, paramInt);
  }
  
  private void onPressConfirmBtn(@Nullable Bitmap paramBitmap, @Nullable String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null)) {
      return;
    }
    AEVideoShelfEditFragment.keepScreenOn(getActivity(), true);
    showLoading();
    Intent localIntent = getActivity().getIntent();
    if (((!localIntent.getBooleanExtra("key_disable_face_detect", false)) || (blvr.h(localIntent))) && (!FaceChangeUtils.hasFaceInPic(paramBitmap)))
    {
      QQToast.a(getActivity(), 2131689767, 0).a();
      hideLoading();
      onBackPressed();
      return;
    }
    if ((localIntent.getBooleanExtra("key_need_check_sensitive", false)) || (blvr.h(localIntent)))
    {
      removeOldObserver();
      this.mObserver = new AETakeFacePhotoPreviewFragment.2(this);
      this.faceDetectStartTime = System.currentTimeMillis();
      this.mAppInterface.addObserver(this.mObserver);
      this.mHandler.b(paramString);
      return;
    }
    handleSensitiveFaceDetectResult(true, 0);
  }
  
  private void removeOldObserver()
  {
    if (this.mObserver != null)
    {
      this.mAppInterface.removeObserver(this.mObserver);
      this.mObserver = null;
    }
  }
  
  private void showLoading()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
    {
      if (this.mLoadingDialog == null)
      {
        this.mLoadingDialog = new ReportDialog(localFragmentActivity, 2131755826);
        this.mLoadingDialog.setContentView(2131559574);
        ((TextView)this.mLoadingDialog.findViewById(2131372546)).setText(2131689764);
        this.mLoadingDialog.setCancelable(true);
        this.mLoadingDialog.setCanceledOnTouchOutside(false);
        this.mLoadingDialog.setOnDismissListener(new AETakeFacePhotoPreviewFragment.3(this));
      }
      this.mLoadingDialog.show();
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFlags(1024, 1024);
    if (Build.VERSION.SDK_INT >= 29) {
      zjv.a(paramActivity.getWindow());
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
    getActivity().finish();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131362289) {
      if ((!TextUtils.isEmpty(this.mPhotoPath)) || (this.mPhotoBitmap != null))
      {
        bmbc.a().Y();
        onPressConfirmBtn(this.mPhotoBitmap, this.mPhotoPath);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131362288)
      {
        bmbc.a().Z();
        onBackPressed();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558492, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mPhotoBitmap != null) {
      BitmapUtils.recycle(this.mPhotoBitmap);
    }
    if ((detectFacePath != null) && (detectFacePath.length() > 0)) {
      FileUtils.delete(detectFacePath);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    hideLoading();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    initView(paramView);
    initData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AETakeFacePhotoPreviewFragment
 * JD-Core Version:    0.7.0.1
 */