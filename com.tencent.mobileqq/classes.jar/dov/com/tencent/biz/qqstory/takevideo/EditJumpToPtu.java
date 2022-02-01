package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.dataline.util.file.FileUtil;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.pm.PackageUtil;
import dov.com.qq.im.capture.data.CaptureComboManager.CaptureRecord;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import java.io.File;

public class EditJumpToPtu
  extends EditVideoPart
{
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public EditJumpToPtu.UIHandler a;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  
  public EditJumpToPtu(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b())
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
        return 3;
      }
      return 4;
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
      return 1;
    }
    return 2;
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getResources().getDisplayMetrics();
    int i = EditPicRawImage.a((BitmapFactory.Options)localObject, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    ((BitmapFactory.Options)localObject).inSampleSize = i;
    try
    {
      localObject = ImageUtil.a(paramString, (BitmapFactory.Options)localObject);
      if (localObject == null)
      {
        QLog.e("EditJumpToPtu", 1, "decode" + null);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(0, null, 2130772034, 0);
        return null;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Bitmap localBitmap;
      for (;;)
      {
        SLog.e("EditJumpToPtu", "decodeoom");
        localBitmap = null;
      }
      SLog.b("EditJumpToPtu", "sampleSize" + i + " w " + localBitmap.getWidth() + " h " + localBitmap.getHeight());
      i = ImageUtil.c(paramString);
      paramString = localBitmap;
      if (i != 0)
      {
        paramString = localBitmap;
        if (i % 90 == 0)
        {
          SLog.b("EditJumpToPtu", "has exif rotate" + i);
          int j = localBitmap.getWidth();
          int k = localBitmap.getHeight();
          paramString = new Matrix();
          paramString.postRotate(i, j / 2.0F, k / 2.0F);
          paramString = Bitmap.createBitmap(localBitmap, 0, 0, j, k, paramString, true);
        }
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditJumpToPtu$UIHandler.obtainMessage(2, paramString).sendToTarget();
    }
    return paramString;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditJumpToPtu$UIHandler = new EditJumpToPtu.UIHandler(this);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
    if (!EditVideoPartManager.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c, 131072)) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    }
    if (paramInt1 == 100)
    {
      if (paramInt2 != -1) {
        break label205;
      }
      localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a().getActivity();
      if (localObject != null) {}
    }
    else
    {
      return;
    }
    ((dov.com.qq.im.capture.data.CaptureComboManager)dov.com.qq.im.capture.QIMManager.a(5)).a[a()].c((Activity)localObject);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.clear();
    }
    for (;;)
    {
      try
      {
        paramIntent = ((Uri)paramIntent.getParcelableExtra("android.intent.extra.STREAM")).toString();
        SLog.b("EditJumpToPtu", "onActivityResult PI_TU, new path " + paramIntent);
        if (!TextUtils.isEmpty(paramIntent)) {
          ThreadManager.excute(new EditJumpToPtu.2(this, paramIntent), 64, null, true);
        }
        if (this.jdField_a_of_type_JavaLangString == null) {
          break;
        }
        FileUtil.a(new File(this.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_JavaLangString = null;
        return;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        continue;
      }
      label205:
      SLog.b("EditJumpToPtu", "onActivityResult cancel ");
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      paramGenerateContext = paramGenerateContext.a;
      paramGenerateContext.a += 1;
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    VideoEditReport.b("0X80080E2", VideoEditReport.a);
    if (a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a()))
    {
      ThreadManager.post(new EditJumpToPtu.1(this), 5, null, true);
      a(HardCodeUtil.a(2131703668));
      return;
    }
    VideoEditReport.b("0X80080E4", VideoEditReport.a);
    paramObject = new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserActivity");
    Intent localIntent = new Intent();
    localIntent.putExtra("url", "https://tu.qq.com/websites/guide/sticker.html");
    localIntent.putExtra("big_brother_source_key", "biz_src_jc_editor");
    localIntent.setComponent(paramObject);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().startActivityForResult(localIntent, 101);
  }
  
  void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(a(), a().getDimensionPixelSize(2131299166));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public boolean a(Context paramContext)
  {
    if (PackageUtil.a(paramContext, "com.tencent.ttpic")) {
      try
      {
        int i = PackageUtil.a(paramContext, "com.tencent.ttpic");
        if (i >= 490) {
          return true;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    DoodleLayout localDoodleLayout = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a();
    if (localDoodleLayout != null)
    {
      Bitmap localBitmap3 = localDoodleLayout.a(0, false);
      Bitmap localBitmap2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a();
      if (localBitmap2 == null) {
        return false;
      }
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap3 != null)
      {
        localBitmap1 = BitmapUtils.c(localBitmap2, localBitmap3);
        localDoodleLayout.a(localBitmap3);
      }
      return BitmapUtils.a(localBitmap1, paramString);
    }
    return false;
  }
  
  void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditJumpToPtu
 * JD-Core Version:    0.7.0.1
 */