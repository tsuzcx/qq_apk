import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class pxl
  extends pwy
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "https://pub.idqqimg.com/pc/misc/files/20200416/3c376048a60b488d998e1ef31153db5e.png", "https://pub.idqqimg.com/pc/misc/files/20200416/54aaad879a4042899540fafd969395f6.png", "https://pub.idqqimg.com/pc/misc/files/20200416/8b787675714740eeb21c7fc5b15712c0.png", "https://pub.idqqimg.com/pc/misc/files/20200416/1263e35cec174f0db53e0fc3bb8e7df2.png", "https://pub.idqqimg.com/pc/misc/files/20200430/21b88f2ba3bd43919173a767982d649d.png", "https://pub.idqqimg.com/pc/misc/files/20200430/eb40275894c9455f9ab438dd91081678.png" };
  private Activity jdField_a_of_type_AndroidAppActivity;
  private boolean jdField_a_of_type_Boolean;
  
  public pxl(@NonNull pwz parampwz, Activity paramActivity)
  {
    super(parampwz, "RIJUGCAccountPopupStep");
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    j();
  }
  
  private boolean b()
  {
    boolean bool2 = bdvn.a();
    boolean bool3 = rth.a();
    boolean bool4 = rad.a().a();
    if ((!bool2) && (bool3) && (bool4)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.i("RIJUGCAccountPopupStep", 2, "[handleUGCAccountCreate], isStudyMode = " + bool2 + "isPopupEnable = " + bool3 + ", isPtsLiteEnable = " + bool4);
      if (bool1) {
        rth.a(this.jdField_a_of_type_AndroidAppActivity, new rtq(this.jdField_a_of_type_AndroidAppActivity, 0));
      }
      return bool1;
    }
  }
  
  public static void i()
  {
    if (!rth.a()) {
      return;
    }
    ReadInJoyUserInfoModule.a(pkh.a(), null);
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject1 = arrayOfString[i];
      try
      {
        localObject1 = new URL((String)localObject1);
        if (localObject1 != null)
        {
          tlw localtlw = new tlw();
          localtlw.a = ((URL)localObject1);
          localtlw.b = true;
          tlv.a().a(localtlw, null);
          if ((QLog.isDebugVersion()) || (QLog.isColorLevel())) {
            QLog.i("RIJUGCAccountPopupStep", 2, "[preload] url = " + localObject1);
          }
        }
        i += 1;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          QLog.e("RIJUGCAccountPopupStep", 1, "[preload] error, e = " + localMalformedURLException);
          Object localObject2 = null;
        }
      }
    }
  }
  
  private void j()
  {
    if (!rth.a()) {
      return;
    }
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject1 = arrayOfString[i];
      try
      {
        localObject1 = new URL((String)localObject1);
        if ((QLog.isDebugVersion()) || (QLog.isColorLevel())) {
          QLog.i("RIJUGCAccountPopupStep", 2, "[preloadResources] url = " + localObject1);
        }
        if (localObject1 != null)
        {
          tlw localtlw = new tlw();
          localtlw.a = ((URL)localObject1);
          tlv.a().a(localtlw, null);
        }
        i += 1;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          QLog.i("RIJUGCAccountPopupStep", 1, "[preloadResources] error, e = " + localMalformedURLException);
          Object localObject2 = null;
        }
      }
    }
  }
  
  protected void g()
  {
    a(this.jdField_a_of_type_Boolean);
    QLog.i("RIJUGCAccountPopupStep", 1, "[doStepFromOnResume], needShow = " + this.jdField_a_of_type_Boolean);
  }
  
  protected void h()
  {
    this.jdField_a_of_type_Boolean = b();
    a(this.jdField_a_of_type_Boolean);
    QLog.i("RIJUGCAccountPopupStep", 1, "[doStepFromOnShowSelf], needShow = " + this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pxl
 * JD-Core Version:    0.7.0.1
 */