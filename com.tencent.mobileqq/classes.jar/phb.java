import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.ugc.account.RIJUGCAddAccountFragment;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class phb
  extends pgp
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "https://pub.idqqimg.com/pc/misc/files/20200416/3c376048a60b488d998e1ef31153db5e.png", "https://pub.idqqimg.com/pc/misc/files/20200416/54aaad879a4042899540fafd969395f6.png", "https://pub.idqqimg.com/pc/misc/files/20200416/8b787675714740eeb21c7fc5b15712c0.png", "https://pub.idqqimg.com/pc/misc/files/20200416/1263e35cec174f0db53e0fc3bb8e7df2.png", "https://pub.idqqimg.com/pc/misc/files/20200430/21b88f2ba3bd43919173a767982d649d.png", "https://pub.idqqimg.com/pc/misc/files/20200430/eb40275894c9455f9ab438dd91081678.png" };
  private Activity jdField_a_of_type_AndroidAppActivity;
  private boolean jdField_a_of_type_Boolean;
  
  public phb(@NonNull pgq parampgq, Activity paramActivity)
  {
    super(parampgq, "RIJUGCAccountPopupStep");
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    j();
  }
  
  private boolean b()
  {
    boolean bool2 = bduy.a();
    boolean bool3 = rab.a();
    boolean bool4 = qhv.a().a();
    if ((!bool2) && (bool3) && (bool4)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.i("RIJUGCAccountPopupStep", 2, "[handleUGCAccountCreate], isStudyMode = " + bool2 + "isPopupEnable = " + bool3 + ", isPtsLiteEnable = " + bool4);
      if (bool1)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("public_fragment_window_feature", 1);
        afez.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, PublicTransFragmentActivity.class, RIJUGCAddAccountFragment.class, 10000);
      }
      return bool1;
    }
  }
  
  public static void i()
  {
    if (!rab.a()) {
      return;
    }
    ReadInJoyUserInfoModule.a(ozs.a(), null);
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
          suo localsuo = new suo();
          localsuo.a = ((URL)localObject1);
          localsuo.b = true;
          sun.a().a(localsuo, null);
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
    if (!rab.a()) {
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
          suo localsuo = new suo();
          localsuo.a = ((URL)localObject1);
          sun.a().a(localsuo, null);
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
  }
  
  protected void h()
  {
    this.jdField_a_of_type_Boolean = b();
    a(this.jdField_a_of_type_Boolean);
    QLog.i("RIJUGCAccountPopupStep", 1, "[doStepFromOnShowSelf], needShow = " + this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phb
 * JD-Core Version:    0.7.0.1
 */