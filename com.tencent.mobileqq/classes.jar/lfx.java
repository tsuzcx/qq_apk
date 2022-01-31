import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.mobileqq.shortvideo.gesture.GestureKeyInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class lfx
{
  private String jdField_a_of_type_JavaLangString;
  private Map<String, Drawable> jdField_a_of_type_JavaUtilMap = new HashMap();
  public kyc a;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void a(long paramLong)
  {
    a(false);
    c();
    a("clearState_" + paramLong, null);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    Object localObject;
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      if (!GestureFilterManager.sGestureType.equals("fivea")) {
        break label79;
      }
      localObject = VideoController.a().a().getResources().getDrawable(2130841538);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
      krx.e("TipsInfo", "ProcessGestureSDK pandentInfo.gestureType drawable insert, drawable" + String.valueOf(localObject));
      return;
      label79:
      if (GestureFilterManager.sGestureType.equals("palmup")) {
        localObject = VideoController.a().a().getResources().getDrawable(2130841539);
      } else if (GestureFilterManager.sGestureType.equals("qheart")) {
        localObject = VideoController.a().a().getResources().getDrawable(2130841540);
      } else {
        localObject = new BitmapDrawable(apdh.a(awhq.a() + paramString + ".png"));
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsInfo", 1, "setGestureType[" + paramString1 + "], GestureTips[" + this.jdField_a_of_type_JavaLangString + "->" + paramString2 + "]");
    }
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public void a(lfi paramlfi, int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    if (4 == paramlfi.a())
    {
      a(false);
      return;
    }
    if ((paramInt > 0) || (!paramBoolean2))
    {
      c();
      if (paramBoolean1)
      {
        paramlfi = GestureMgrRecognize.getInstance().getGestureInfo();
        if ((!paramlfi.vaild) || (!paramlfi.type.equals(paramString2)))
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
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TipsInfo", 1, "hideGestureTips, bGettureShown[" + paramBoolean + "], mCurGestureType[" + this.jdField_a_of_type_JavaLangString + "]");
    }
    if (this.jdField_a_of_type_JavaLangString == null) {
      return;
    }
    a("hideGestureTips", null);
    if (paramBoolean) {
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Kyc.c(0);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
  {
    if (!a()) {}
    while (this.b) {
      return;
    }
    krx.c("TipsInfo", "processTips showfaceTips");
    this.jdField_a_of_type_Kyc.b(kyc.a);
    this.b = true;
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (!a()) {}
    do
    {
      do
      {
        return;
      } while (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString2));
      krx.c("TipsInfo", "showGestureTips showGestureTips mHasGestureTipsShow[" + this.jdField_a_of_type_Boolean + "]");
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Kyc.a(paramString1);
        a("showGestureTips1", paramString2);
        return;
      }
    } while (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString2));
    Drawable localDrawable = (Drawable)this.jdField_a_of_type_JavaUtilMap.get(paramString2);
    this.jdField_a_of_type_Kyc.a(localDrawable, paramString1);
    a("showGestureTips2", paramString2);
  }
  
  public void c()
  {
    if (!this.b) {
      return;
    }
    krx.c("TipsInfo", "processTips hideFaceTips");
    this.jdField_a_of_type_Kyc.c(0);
    this.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lfx
 * JD-Core Version:    0.7.0.1
 */