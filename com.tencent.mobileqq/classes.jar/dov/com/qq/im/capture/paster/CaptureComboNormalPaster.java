package dov.com.qq.im.capture.paster;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.qq.im.capture.data.CaptureComboBase;
import dov.com.qq.im.capture.data.IFaceSelectedListener;
import dov.com.qq.im.capture.util.DoodleLayoutConnector;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.model.SelectedItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CaptureComboNormalPaster
  extends CaptureComboBase
  implements IEventReceiver
{
  public static HashMap<String, Drawable> a;
  private float jdField_a_of_type_Float;
  private CaptureComboNormalPaster.DoodleEmojiDownloadEventReceiver jdField_a_of_type_DovComQqImCapturePasterCaptureComboNormalPaster$DoodleEmojiDownloadEventReceiver;
  NormalFacePackage jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage;
  private final String jdField_a_of_type_JavaLangString;
  private float jdField_b_of_type_Float;
  private String jdField_b_of_type_JavaLangString;
  private float c;
  int d = 2;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public CaptureComboNormalPaster(NormalFacePackage paramNormalFacePackage, String paramString1, String paramString2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(null);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage = paramNormalFacePackage;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.c = paramFloat3;
    if (QLog.isColorLevel()) {
      QLog.d("QComboNPaster", 2, "create id=" + paramString1 + " name=" + paramString2);
    }
  }
  
  private static Drawable a(String paramString, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    new File(paramString).getName();
    URLDrawable localURLDrawable = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), paramString, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
    if (localURLDrawable != null)
    {
      int i = localURLDrawable.getStatus();
      if (i == 1) {
        return localURLDrawable;
      }
      if (QLog.isColorLevel()) {
        QLog.e("QComboNPaster", 2, "urlDrawable is not  SUCCESSED :" + i);
      }
      localURLDrawable.setURLDrawableListener(paramURLDrawableListener);
      if (i != 2) {
        break label107;
      }
      localURLDrawable.restartDownload();
    }
    for (;;)
    {
      jdField_a_of_type_JavaUtilHashMap.put(paramString, localURLDrawable);
      return null;
      label107:
      localURLDrawable.startDownload();
    }
    return localURLDrawable;
  }
  
  public static void a(NormalFacePackage paramNormalFacePackage, String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper, IFaceSelectedListener paramIFaceSelectedListener)
  {
    if (paramIFaceSelectedListener == null) {
      throw new IllegalStateException("applyNormalPaster listener is null!");
    }
    int i = paramNormalFacePackage.a(paramString);
    paramString = paramNormalFacePackage.a(paramString);
    if (TextUtils.isEmpty(paramString)) {}
    try
    {
      FileUtils.d(paramNormalFacePackage.g);
      label43:
      if (QLog.isColorLevel()) {
        QLog.e("QComboNPaster", 2, "applyNormalPaster uriString error!");
      }
      for (;;)
      {
        return;
        paramString = Uri.parse(paramString).getPath();
        String str = new File(paramString).getName();
        CaptureComboNormalPaster.2 local2 = new CaptureComboNormalPaster.2(str, paramString, paramNormalFacePackage, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramSegmentKeeper, paramIFaceSelectedListener, i);
        if (i != 1) {
          try
          {
            b(Drawable.createFromPath(paramString), str, paramString, paramNormalFacePackage, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramSegmentKeeper, paramIFaceSelectedListener, i);
            return;
          }
          catch (OutOfMemoryError paramNormalFacePackage)
          {
            SLog.c("QComboNPaster", "createFromPath error", paramNormalFacePackage);
            return;
          }
        }
        File localFile = new File(paramString);
        try
        {
          if (!ApngDrawable.isApngFile(localFile))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("QComboNPaster", 2, "applyNormalPaster isApngFile not valid path=" + paramString);
            return;
          }
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
          b(a(paramString, local2), str, paramString, paramNormalFacePackage, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramSegmentKeeper, paramIFaceSelectedListener, i);
          return;
        }
      }
    }
    catch (Exception paramNormalFacePackage)
    {
      break label43;
    }
  }
  
  private static void b(Drawable paramDrawable, String paramString1, String paramString2, NormalFacePackage paramNormalFacePackage, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper, IFaceSelectedListener paramIFaceSelectedListener, int paramInt3)
  {
    if (paramDrawable != null)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
      int i = paramDrawable.getIntrinsicWidth();
      paramFloat3 = paramInt1 * paramFloat3 / i;
      if (QLog.isColorLevel()) {
        QLog.d("QComboNPaster", 2, "applyNormalPaster w=" + i + " scale=" + paramFloat3 + " px=" + paramFloat1 + " py=" + paramFloat2);
      }
      paramIFaceSelectedListener.a(new SelectedItem(paramNormalFacePackage.jdField_b_of_type_JavaLangString, paramString1, paramDrawable, paramInt3), paramInt1 * paramFloat1, paramInt2 * paramFloat2, paramFloat3, paramString2, paramSegmentKeeper);
      return;
    }
    SLog.e("QComboNPaster", "can not create drawable from name:" + paramString1);
  }
  
  public float a()
  {
    float f = 1.0F;
    for (;;)
    {
      try
      {
        if (!StringUtil.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.g))
        {
          a();
          return f;
        }
        if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.c != 100.0F) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.c > 0.0F))
        {
          f = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.d;
          int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.c;
          f = 1.0F * f / i;
        }
        else
        {
          f = 0.0F;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	dov/com/qq/im/capture/paster/CaptureComboNormalPaster:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/face/NormalFacePackage;
    //   6: getfield 167	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/face/NormalFacePackage:g	Ljava/lang/String;
    //   9: invokestatic 256	com/tencent/mobileqq/utils/StringUtil:a	(Ljava/lang/String;)Z
    //   12: ifne +17 -> 29
    //   15: aload_0
    //   16: iconst_3
    //   17: putfield 33	dov/com/qq/im/capture/paster/CaptureComboNormalPaster:d	I
    //   20: aload_0
    //   21: getfield 33	dov/com/qq/im/capture/paster/CaptureComboNormalPaster:d	I
    //   24: istore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_1
    //   28: ireturn
    //   29: aload_0
    //   30: getfield 39	dov/com/qq/im/capture/paster/CaptureComboNormalPaster:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/face/NormalFacePackage;
    //   33: getfield 265	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/face/NormalFacePackage:jdField_b_of_type_Boolean	Z
    //   36: ifeq -16 -> 20
    //   39: aload_0
    //   40: iconst_1
    //   41: putfield 33	dov/com/qq/im/capture/paster/CaptureComboNormalPaster:d	I
    //   44: goto -24 -> 20
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_2
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	CaptureComboNormalPaster
    //   24	4	1	i	int
    //   47	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	47	finally
    //   20	25	47	finally
    //   29	44	47	finally
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.a == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.a.size() == 0)) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.a());
    }
    ThreadManager.excute(new CaptureComboNormalPaster.1(this, paramInt), 64, null, true);
    if (QLog.isColorLevel()) {
      QLog.d("QComboNPaster", 2, "apply id=" + this.jdField_a_of_type_JavaLangString + " name=" + this.jdField_b_of_type_JavaLangString);
    }
    return 0;
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.a == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.a.size() == 0)) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.a());
    }
    paramActivity = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.a(this.jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("QComboNPaster", 2, "unApply id=" + this.jdField_a_of_type_JavaLangString + " name=" + this.jdField_b_of_type_JavaLangString + "url=" + paramActivity);
    }
    if (TextUtils.isEmpty(paramActivity)) {}
    for (;;)
    {
      return;
      try
      {
        paramActivity = new File(Uri.parse(paramActivity).getPath()).getName();
        DoodleLayout localDoodleLayout = DoodleLayoutConnector.a().a(paramInt);
        if (localDoodleLayout != null)
        {
          localDoodleLayout.a().a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.jdField_b_of_type_JavaLangString, paramActivity);
          return;
        }
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
      }
    }
  }
  
  public int b()
  {
    try
    {
      ((DoodleEmojiManager)SuperManager.a(39)).a(this.jdField_a_of_type_JavaLangString, false);
      a();
      Dispatcher localDispatcher = StoryDispatcher.a();
      CaptureComboNormalPaster.DoodleEmojiDownloadEventReceiver localDoodleEmojiDownloadEventReceiver = new CaptureComboNormalPaster.DoodleEmojiDownloadEventReceiver(this);
      this.jdField_a_of_type_DovComQqImCapturePasterCaptureComboNormalPaster$DoodleEmojiDownloadEventReceiver = localDoodleEmojiDownloadEventReceiver;
      localDispatcher.registerSubscriber(localDoodleEmojiDownloadEventReceiver);
      this.d = 1;
      if (QLog.isColorLevel()) {
        QLog.d("QComboNPaster", 2, "create mState=" + this.d + " id=" + this.jdField_a_of_type_JavaLangString);
      }
      int i = this.d;
      return i;
    }
    finally {}
  }
  
  public boolean isValidate()
  {
    return this.d == 1;
  }
  
  public String toString()
  {
    return "NP@" + this.jdField_a_of_type_JavaLangString + "@" + hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.CaptureComboNormalPaster
 * JD-Core Version:    0.7.0.1
 */