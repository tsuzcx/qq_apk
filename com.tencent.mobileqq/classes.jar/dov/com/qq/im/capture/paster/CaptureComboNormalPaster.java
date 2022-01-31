package dov.com.qq.im.capture.paster;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import anms;
import anmt;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.qq.im.capture.data.CaptureComboBase;
import dov.com.qq.im.capture.data.IFaceSelectedListener;
import dov.com.qq.im.capture.util.DoodleLayoutConnector;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.model.SelectedItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage;
import java.io.File;
import java.util.HashMap;
import java.util.List;

public class CaptureComboNormalPaster
  extends CaptureComboBase
  implements IEventReceiver
{
  public static HashMap a;
  private float jdField_a_of_type_Float;
  private CaptureComboNormalPaster.DoodleEmojiDownloadEventReceiver jdField_a_of_type_DovComQqImCapturePasterCaptureComboNormalPaster$DoodleEmojiDownloadEventReceiver;
  public NormalFacePackage a;
  private final String jdField_a_of_type_JavaLangString;
  private float jdField_b_of_type_Float;
  private String jdField_b_of_type_JavaLangString;
  private float jdField_c_of_type_Float;
  int jdField_c_of_type_Int = 2;
  
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
    this.jdField_c_of_type_Float = paramFloat3;
    if (QLog.isColorLevel()) {
      QLog.d("QComboNPaster", 2, "create id=" + paramString1 + " name=" + paramString2);
    }
  }
  
  public static void a(NormalFacePackage paramNormalFacePackage, String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper, IFaceSelectedListener paramIFaceSelectedListener)
  {
    if (paramIFaceSelectedListener == null) {
      throw new IllegalStateException("applyNormalPaster listener is null!");
    }
    int i = paramNormalFacePackage.a(paramString);
    paramString = paramNormalFacePackage.a(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str1 = Uri.parse(paramString).getPath();
    String str2 = new File(str1).getName();
    if (i != 1) {}
    for (;;)
    {
      int j;
      try
      {
        paramString = Drawable.createFromPath(str1);
        if (paramString == null) {
          break label361;
        }
        paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
        j = paramString.getIntrinsicWidth();
        paramFloat3 = paramInt1 * paramFloat3 / j;
        if (QLog.isColorLevel()) {
          QLog.d("QComboNPaster", 2, "applyNormalPaster w=" + j + " scale=" + paramFloat3 + " px=" + paramFloat1 + " py=" + paramFloat2);
        }
        paramIFaceSelectedListener.a(new SelectedItem(paramNormalFacePackage.jdField_b_of_type_JavaLangString, str2, paramString, i), paramInt1 * paramFloat1, paramInt2 * paramFloat2, paramFloat3, str1, paramSegmentKeeper);
        return;
      }
      catch (OutOfMemoryError paramString)
      {
        SLog.c("QComboNPaster", "createFromPath error", paramString);
        paramString = null;
        continue;
      }
      paramString = VasApngUtil.a(BaseApplicationImpl.sApplication.getRuntime(), str1, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
      if (paramString != null)
      {
        j = paramString.getStatus();
        if (j != 1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QComboNPaster", 2, "urlDrawable is not  SUCCESSED :" + j);
          }
          if (j == 2) {
            paramString.restartDownload();
          }
          for (;;)
          {
            paramString.setURLDrawableListener(new anmt(str1, paramInt1, paramFloat3, str2, paramNormalFacePackage, i, paramIFaceSelectedListener, paramFloat1, paramInt2, paramFloat2, paramSegmentKeeper));
            jdField_a_of_type_JavaUtilHashMap.put(str1, paramString);
            paramString = null;
            break;
            paramString.startDownload();
          }
        }
        continue;
        label361:
        SLog.e("QComboNPaster", "can not create drawable from name:" + str2);
      }
      else
      {
        paramString = null;
      }
    }
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
        if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.jdField_c_of_type_Int != 100.0F) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.jdField_c_of_type_Int > 0.0F))
        {
          f = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.d;
          int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.jdField_c_of_type_Int;
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
    //   3: getfield 37	dov/com/qq/im/capture/paster/CaptureComboNormalPaster:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/face/NormalFacePackage;
    //   6: getfield 222	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/face/NormalFacePackage:g	Ljava/lang/String;
    //   9: invokestatic 227	com/tencent/mobileqq/utils/StringUtil:a	(Ljava/lang/String;)Z
    //   12: ifne +17 -> 29
    //   15: aload_0
    //   16: iconst_3
    //   17: putfield 31	dov/com/qq/im/capture/paster/CaptureComboNormalPaster:jdField_c_of_type_Int	I
    //   20: aload_0
    //   21: getfield 31	dov/com/qq/im/capture/paster/CaptureComboNormalPaster:jdField_c_of_type_Int	I
    //   24: istore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_1
    //   28: ireturn
    //   29: aload_0
    //   30: getfield 37	dov/com/qq/im/capture/paster/CaptureComboNormalPaster:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/face/NormalFacePackage;
    //   33: getfield 236	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/face/NormalFacePackage:jdField_b_of_type_Boolean	Z
    //   36: ifeq -16 -> 20
    //   39: aload_0
    //   40: iconst_1
    //   41: putfield 31	dov/com/qq/im/capture/paster/CaptureComboNormalPaster:jdField_c_of_type_Int	I
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
    ThreadManager.postImmediately(new anms(this, paramInt), null, true);
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
      ((DoodleEmojiManager)SuperManager.a(36)).a(this.jdField_a_of_type_JavaLangString, false);
      a();
      Dispatcher localDispatcher = Dispatchers.get();
      CaptureComboNormalPaster.DoodleEmojiDownloadEventReceiver localDoodleEmojiDownloadEventReceiver = new CaptureComboNormalPaster.DoodleEmojiDownloadEventReceiver(this);
      this.jdField_a_of_type_DovComQqImCapturePasterCaptureComboNormalPaster$DoodleEmojiDownloadEventReceiver = localDoodleEmojiDownloadEventReceiver;
      localDispatcher.registerSubscriber(localDoodleEmojiDownloadEventReceiver);
      this.jdField_c_of_type_Int = 1;
      if (QLog.isColorLevel()) {
        QLog.d("QComboNPaster", 2, "create mState=" + this.jdField_c_of_type_Int + " id=" + this.jdField_a_of_type_JavaLangString);
      }
      int i = this.jdField_c_of_type_Int;
      return i;
    }
    finally {}
  }
  
  public boolean isValidate()
  {
    return this.jdField_c_of_type_Int == 1;
  }
  
  public String toString()
  {
    return "NP@" + this.jdField_a_of_type_JavaLangString + "@" + hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.CaptureComboNormalPaster
 * JD-Core Version:    0.7.0.1
 */