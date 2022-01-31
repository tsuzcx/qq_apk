package dov.com.qq.im.ae.play;

import adpn;
import adpo;
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
import bkzt;
import bkzv;
import blat;
import blgp;
import blgq;
import blgr;
import blhy;
import bliu;
import bmyg;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import javax.annotation.Nullable;
import ylw;

public class AETakeFacePhotoPreviewFragment
  extends PublicBaseFragment
  implements adpo, View.OnClickListener
{
  private static String jdField_a_of_type_JavaLangString = "";
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bkzt jdField_a_of_type_Bkzt = (bkzt)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(3);
  private bkzv jdField_a_of_type_Bkzv;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = QQStoryContext.a();
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  
  public static String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = bmyg.a(getActivity());
    this.jdField_b_of_type_Int = bmyg.b(getActivity());
    this.jdField_b_of_type_JavaLangString = getArguments().getString("photo_path");
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapUtils.decodeSampleBitmap(getActivity(), this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        b();
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      }
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    adpn.a(paramActivity, paramIntent, PublicFragmentActivityForPeak.class, AETakeFacePhotoPreviewFragment.class, paramInt);
  }
  
  private void a(@Nullable Bitmap paramBitmap, @Nullable String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null)) {
      return;
    }
    AEVideoShelfEditFragment.a(getActivity(), true);
    e();
    Intent localIntent = getActivity().getIntent();
    if (((!localIntent.getBooleanExtra("key_disable_face_detect", false)) || (blat.g(localIntent))) && (!blhy.a(paramBitmap)))
    {
      QQToast.a(getActivity(), 2131689846, 0).a();
      f();
      onBackPressed();
      return;
    }
    if ((localIntent.getBooleanExtra("key_need_check_sensitive", false)) || (blat.g(localIntent)))
    {
      d();
      this.jdField_a_of_type_Bkzv = new blgq(this);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_Bkzv);
      this.jdField_a_of_type_Bkzt.b(paramString);
      return;
    }
    a(true, 0);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362189));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362203));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362204));
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      if (paramInt == 0) {
        c();
      }
    }
    for (;;)
    {
      f();
      return;
      if (paramInt == -1)
      {
        QQToast.a(getActivity(), 2131689844, 0).a();
      }
      else if (paramInt == -2)
      {
        QQToast.a(getActivity(), 2131698182, 0).a();
        continue;
        QQToast.a(getActivity(), 2131698182, 0).a();
      }
    }
  }
  
  private void b()
  {
    jdField_a_of_type_JavaLangString = "";
    if (!blhy.a(this.jdField_a_of_type_AndroidGraphicsBitmap)) {
      return;
    }
    blhy.a(this.jdField_a_of_type_AndroidGraphicsBitmap, new blgp(this));
  }
  
  private void c()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("take_photo_path", this.jdField_b_of_type_JavaLangString);
    getActivity().setResult(-1, localIntent);
    onBackPressed();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bkzv != null)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_Bkzv);
      this.jdField_a_of_type_Bkzv = null;
    }
  }
  
  private void e()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
    {
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new Dialog(localFragmentActivity, 2131755801);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559437);
        ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371894)).setText(2131689843);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new blgr(this));
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void f()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()) && (this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFlags(1024, 1024);
    if (Build.VERSION.SDK_INT >= 29) {
      ylw.a(paramActivity.getWindow());
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
    if (i == 2131362204) {
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_AndroidGraphicsBitmap != null))
      {
        bliu.a().F();
        a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_JavaLangString);
      }
    }
    while (i != 2131362203) {
      return;
    }
    bliu.a().G();
    onBackPressed();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2131558480, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      BitmapUtils.recycle(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    if ((jdField_a_of_type_JavaLangString != null) && (jdField_a_of_type_JavaLangString.length() > 0)) {
      FileUtils.delete(jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    f();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    a(paramView);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AETakeFacePhotoPreviewFragment
 * JD-Core Version:    0.7.0.1
 */