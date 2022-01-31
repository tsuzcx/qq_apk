import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.business.manager.pendant.EffectPendantTips;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.shortvideo.gesture.GestureKeyInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.mobileqq.shortvideo.gesture.GestureUtil;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class jlv
{
  public EffectPendantTips a;
  String jdField_a_of_type_JavaLangString;
  Map jdField_a_of_type_JavaUtilMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public void a()
  {
    a(false);
    c();
    this.b = false;
    a("clearState", null);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    if (4 == paramInt1) {
      return;
    }
    if ((paramInt2 > 0) || (!paramBoolean2))
    {
      c();
      if (paramBoolean1)
      {
        GestureKeyInfo localGestureKeyInfo = GestureMgrRecognize.a().a();
        if ((!localGestureKeyInfo.jdField_a_of_type_Boolean) || (!localGestureKeyInfo.jdField_a_of_type_JavaLangString.equals(paramString2)))
        {
          b(paramString1, paramString2);
          return;
        }
        a(true);
        return;
      }
      a(false);
      return;
    }
    a(false);
    b();
  }
  
  public void a(String paramString)
  {
    Object localObject;
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      if (!GestureFilterManager.jdField_a_of_type_JavaLangString.equals("fivea")) {
        break label79;
      }
      localObject = VideoController.a().a().getResources().getDrawable(2130840243);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
      AVLog.e("FilterProcessRender", "ProcessGestureSDK pandentInfo.gestureType drawable insert, drawable" + String.valueOf(localObject));
      return;
      label79:
      if (GestureFilterManager.jdField_a_of_type_JavaLangString.equals("palmup")) {
        localObject = VideoController.a().a().getResources().getDrawable(2130840244);
      } else if (GestureFilterManager.jdField_a_of_type_JavaLangString.equals("qheart")) {
        localObject = VideoController.a().a().getResources().getDrawable(2130840245);
      } else {
        localObject = new BitmapDrawable(FileUtil.a(GestureUtil.a() + paramString + ".png"));
      }
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FilterProcessRender", 1, "setGestureType[" + paramString1 + "], GestureTips[" + this.jdField_a_of_type_JavaLangString + "->" + paramString2 + "]");
    }
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      return;
    }
    a("hideGestureTips", null);
    if (paramBoolean) {
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips.b(77);
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips.b(77, 0);
  }
  
  void b()
  {
    if (this.b) {
      return;
    }
    AVLog.c("FilterProcessRender", "processTips showfaceTips");
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips.a(78, EffectPendantTips.a);
    this.b = true;
  }
  
  void b(String paramString1, String paramString2)
  {
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString2)) {}
    do
    {
      return;
      AVLog.c("FilterProcessRender", "showGestureTips showGestureTips mHasGestureTipsShow[" + this.jdField_a_of_type_Boolean + "]");
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips.a(77, paramString1);
        a("showGestureTips1", paramString2);
        return;
      }
    } while (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString2));
    Drawable localDrawable = (Drawable)this.jdField_a_of_type_JavaUtilMap.get(paramString2);
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips.a(77, localDrawable, paramString1);
    a("showGestureTips2", paramString2);
  }
  
  void c()
  {
    if (!this.b) {
      return;
    }
    AVLog.c("FilterProcessRender", "processTips hideFaceTips");
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips.b(78, 0);
    this.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jlv
 * JD-Core Version:    0.7.0.1
 */