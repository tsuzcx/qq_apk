import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.ugc.account.RIJUGCAddAccountFragment;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class pod
  extends pnq
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "https://pub.idqqimg.com/pc/misc/files/20200416/3c376048a60b488d998e1ef31153db5e.png", "https://pub.idqqimg.com/pc/misc/files/20200416/54aaad879a4042899540fafd969395f6.png", "https://pub.idqqimg.com/pc/misc/files/20200416/8b787675714740eeb21c7fc5b15712c0.png", "https://pub.idqqimg.com/pc/misc/files/20200416/1263e35cec174f0db53e0fc3bb8e7df2.png", "https://pub.idqqimg.com/pc/misc/files/20200430/21b88f2ba3bd43919173a767982d649d.png", "https://pub.idqqimg.com/pc/misc/files/20200430/eb40275894c9455f9ab438dd91081678.png" };
  private Activity jdField_a_of_type_AndroidAppActivity;
  private boolean jdField_a_of_type_Boolean;
  
  public pod(@NonNull pnr parampnr, Activity paramActivity)
  {
    super(parampnr, "RIJUGCAccountPopupStep");
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    j();
  }
  
  private boolean c()
  {
    boolean bool2 = bdch.a();
    boolean bool3 = rjh.a();
    boolean bool4 = qph.a().a();
    if ((!bool2) && (bool3) && (bool4)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.i("RIJUGCAccountPopupStep", 2, "[handleUGCAccountCreate], isStudyMode = " + bool2 + "isPopupEnable = " + bool3 + ", isPtsLiteEnable = " + bool4);
      if (bool1)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("public_fragment_window_feature", 1);
        aevv.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, PublicTransFragmentActivity.class, RIJUGCAddAccountFragment.class, 10000);
      }
      return bool1;
    }
  }
  
  public static void i()
  {
    if (!rjh.a()) {
      return;
    }
    ReadInJoyUserInfoModule.a(pha.a(), null);
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
          tdw localtdw = new tdw();
          localtdw.a = ((URL)localObject1);
          localtdw.b = true;
          tdv.a().a(localtdw, null);
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
    if (!rjh.a()) {
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
          tdw localtdw = new tdw();
          localtdw.a = ((URL)localObject1);
          tdv.a().a(localtdw, null);
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
    this.jdField_a_of_type_Boolean = c();
    a(this.jdField_a_of_type_Boolean);
    QLog.i("RIJUGCAccountPopupStep", 1, "[doStepFromOnShowSelf], needShow = " + this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pod
 * JD-Core Version:    0.7.0.1
 */