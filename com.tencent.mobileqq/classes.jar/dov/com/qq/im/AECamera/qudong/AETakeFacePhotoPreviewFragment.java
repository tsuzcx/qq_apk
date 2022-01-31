package dov.com.qq.im.AECamera.qudong;

import abju;
import abjv;
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
import avzm;
import avzo;
import bbmy;
import bhan;
import bhao;
import bhap;
import bhbv;
import bhci;
import biqy;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import javax.annotation.Nullable;
import wed;

public class AETakeFacePhotoPreviewFragment
  extends PublicBaseFragment
  implements abjv, View.OnClickListener
{
  private static String jdField_a_of_type_JavaLangString = "";
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private avzm jdField_a_of_type_Avzm = (avzm)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(3);
  private avzo jdField_a_of_type_Avzo;
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
    this.jdField_a_of_type_Int = biqy.a(getActivity());
    this.jdField_b_of_type_Int = biqy.b(getActivity());
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
  
  public static void a(Activity paramActivity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("photo_path", paramString);
    abju.a(paramActivity, localIntent, PublicFragmentActivityForPeak.class, AETakeFacePhotoPreviewFragment.class, paramInt);
  }
  
  private void a(@Nullable Bitmap paramBitmap, @Nullable String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null)) {
      return;
    }
    AEVideoShelfEditFragment.a(getActivity(), true);
    e();
    if (!bhbv.a(paramBitmap))
    {
      bbmy.a(getActivity(), 2131624260, 0).a();
      f();
      onBackPressed();
      return;
    }
    d();
    this.jdField_a_of_type_Avzo = new bhao(this);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_Avzo);
    this.jdField_a_of_type_Avzm.b(paramString);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296632));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296646));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296647));
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
        bbmy.a(getActivity(), 2131624258, 0).a();
      }
      else if (paramInt == -2)
      {
        bbmy.a(getActivity(), 2131632268, 0).a();
        continue;
        bbmy.a(getActivity(), 2131632268, 0).a();
      }
    }
  }
  
  private void b()
  {
    jdField_a_of_type_JavaLangString = "";
    if (!bhbv.a(this.jdField_a_of_type_AndroidGraphicsBitmap)) {
      return;
    }
    bhbv.a(this.jdField_a_of_type_AndroidGraphicsBitmap, new bhan(this));
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
    if (this.jdField_a_of_type_Avzo != null)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_Avzo);
      this.jdField_a_of_type_Avzo = null;
    }
  }
  
  private void e()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
    {
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new Dialog(localFragmentActivity, 2131690181);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131493818);
        ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131305861)).setText(2131624257);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new bhap(this));
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
      wed.a(paramActivity.getWindow());
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
    if (i == 2131296647) {
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_AndroidGraphicsBitmap != null))
      {
        bhci.a().x();
        a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_JavaLangString);
      }
    }
    while (i != 2131296646) {
      return;
    }
    bhci.a().y();
    onBackPressed();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2131492939, paramViewGroup, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.qudong.AETakeFacePhotoPreviewFragment
 * JD-Core Version:    0.7.0.1
 */