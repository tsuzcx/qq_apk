import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import java.io.File;
import java.util.List;

public class mpf
{
  private int jdField_a_of_type_Int;
  private Uri jdField_a_of_type_AndroidNetUri;
  private ValueCallback<Uri> jdField_a_of_type_ComTencentSmttSdkValueCallback;
  private ValueCallback<Uri[]> b;
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentSmttSdkValueCallback != null)
    {
      this.jdField_a_of_type_ComTencentSmttSdkValueCallback.onReceiveValue(Uri.EMPTY);
      this.jdField_a_of_type_Int = -2147483648;
      this.jdField_a_of_type_ComTencentSmttSdkValueCallback = null;
      this.jdField_a_of_type_AndroidNetUri = null;
    }
    if (this.b != null)
    {
      this.b.onReceiveValue(null);
      this.b = null;
      this.jdField_a_of_type_AndroidNetUri = null;
      this.jdField_a_of_type_Int = -2147483648;
    }
  }
  
  private void a(Activity paramActivity)
  {
    File localFile = new File(ajed.aU + "photo/");
    if ((!localFile.exists()) && (!localFile.mkdirs()))
    {
      a();
      bbmy.a(paramActivity, 1, paramActivity.getString(2131625046), 0).a();
      return;
    }
    Intent localIntent = new Intent();
    this.jdField_a_of_type_AndroidNetUri = FileProvider7Helper.setSystemCapture(paramActivity, new File(localFile, "IMG_" + System.currentTimeMillis() + ".jpg"), localIntent);
    a(paramActivity, localIntent, 2131625029);
  }
  
  private void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if ((paramActivity != null) && (paramIntent != null) && (paramInt > 0))
    {
      List localList = paramActivity.getPackageManager().queryIntentActivities(paramIntent, 0);
      if ((localList == null) || (localList.isEmpty())) {}
    }
    else
    {
      try
      {
        paramActivity.startActivityForResult(paramIntent, this.jdField_a_of_type_Int);
        return;
      }
      catch (Exception paramIntent)
      {
        if (QLog.isColorLevel()) {
          QLog.w("FileChooserHelper", 2, "Caution: activity for intent was queried but can't started because " + paramIntent.getMessage());
        }
      }
    }
    a();
    bbmy.a(paramActivity, 1, paramInt, 0).a();
  }
  
  private void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
    localIntent.addCategory("android.intent.category.OPENABLE");
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "*/*";
    }
    localIntent.setType(str);
    a(paramActivity, localIntent, 2131625047);
  }
  
  private void b(Activity paramActivity)
  {
    Object localObject = new File(ajed.aU + "photo/");
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
    {
      a();
      bbmy.a(paramActivity, 1, paramActivity.getString(2131625046), 0).a();
      return;
    }
    this.jdField_a_of_type_AndroidNetUri = Uri.fromFile(new File((File)localObject, "VID_" + System.currentTimeMillis() + ".mp4"));
    localObject = new Intent("android.media.action.VIDEO_CAPTURE");
    ((Intent)localObject).putExtra("output", this.jdField_a_of_type_AndroidNetUri);
    ((Intent)localObject).putExtra("android.intent.extra.videoQuality", 1);
    a(paramActivity, (Intent)localObject, 2131625029);
  }
  
  private void c(Activity paramActivity)
  {
    a(paramActivity, new Intent("android.provider.MediaStore.RECORD_SOUND"), 2131625048);
  }
  
  public void a(Activity paramActivity, int paramInt, ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    if ((paramActivity == null) || ((paramValueCallback == null) && (this.b == null))) {
      return;
    }
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentSmttSdkValueCallback != null)) {
      QLog.w("FileChooserHelper", 2, "Caution: mFilePathCallback not null, Plz call doOnActivityResult in the onActivityResult method of caller");
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentSmttSdkValueCallback = paramValueCallback;
    this.jdField_a_of_type_AndroidNetUri = null;
    if (paramString1 != null)
    {
      paramString1 = paramString1.toLowerCase();
      if (paramString2 == null) {
        break label97;
      }
    }
    label97:
    for (paramValueCallback = paramString2.toLowerCase();; paramValueCallback = "")
    {
      if (!TextUtils.isEmpty(paramValueCallback)) {
        break label103;
      }
      a(paramActivity, paramString1);
      return;
      paramString1 = "";
      break;
    }
    label103:
    if (("camera".equals(paramValueCallback)) || ("camcorder".equals(paramValueCallback)) || ("microphone".equals(paramValueCallback)))
    {
      paramInt = 1;
      if (paramInt != 0) {
        break label409;
      }
      if (!paramString1.contains("image/")) {
        break label251;
      }
      paramValueCallback = "camera";
      paramInt = 1;
    }
    label151:
    label409:
    for (;;)
    {
      if (paramInt != 0)
      {
        paramString2 = begr.a(paramActivity);
        paramString2.a(new mpg(this));
        paramString2.setOnCancelListener(new mph(this));
        if (paramValueCallback.equals("camera"))
        {
          paramString2.a(paramActivity.getString(2131654151), 0);
          paramString2.a(paramActivity.getString(2131626898), 0);
          paramString2.a(new mpi(this, paramActivity, paramString1, paramString2));
        }
        for (;;)
        {
          paramString2.show();
          return;
          paramInt = 0;
          break;
          label251:
          if (paramString1.contains("video/"))
          {
            paramValueCallback = "camcorder";
            paramInt = 1;
            break label151;
          }
          if (!paramString1.contains("audio/")) {
            break label409;
          }
          paramValueCallback = "microphone";
          paramInt = 1;
          break label151;
          if (paramValueCallback.equals("camcorder"))
          {
            paramString2.a(paramActivity.getString(2131653448), 0);
            paramString2.a(paramActivity.getString(2131626898), 0);
            paramString2.a(new mpj(this, paramActivity, paramString1, paramString2));
          }
          else if (paramValueCallback.equals("microphone"))
          {
            paramString2.a(paramActivity.getString(2131652832), 0);
            paramString2.a(paramActivity.getString(2131626898), 0);
            paramString2.a(new mpk(this, paramActivity, paramString1, paramString2));
          }
        }
      }
      a(paramActivity, paramString1);
      return;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_Int == paramInt1) {
      if (this.jdField_a_of_type_ComTencentSmttSdkValueCallback != null)
      {
        if (-1 != paramInt2) {
          break label193;
        }
        localObject2 = this.jdField_a_of_type_AndroidNetUri;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          if (paramIntent == null) {
            break label79;
          }
          localObject1 = paramIntent.getData();
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentSmttSdkValueCallback.onReceiveValue(localObject1);
      this.jdField_a_of_type_Int = -2147483648;
      this.jdField_a_of_type_ComTencentSmttSdkValueCallback = null;
      this.jdField_a_of_type_AndroidNetUri = null;
      this.b = null;
      return true;
      label79:
      localObject1 = Uri.EMPTY;
      continue;
      if (this.b != null)
      {
        if (-1 != paramInt2) {
          break label187;
        }
        localObject2 = this.jdField_a_of_type_AndroidNetUri;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          if (paramIntent == null) {
            break label156;
          }
          localObject1 = paramIntent.getData();
        }
      }
      for (;;)
      {
        label124:
        localObject2 = this.b;
        if (localObject1 != null) {}
        for (paramIntent = new Uri[] { localObject1 };; paramIntent = null)
        {
          ((ValueCallback)localObject2).onReceiveValue(paramIntent);
          break;
          label156:
          localObject1 = null;
          break label124;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("FileChooserHelper", 2, "Caution: mFilePathCallback should not be null!");
        break;
        return false;
        label187:
        localObject1 = null;
      }
      label193:
      localObject1 = null;
    }
  }
  
  @TargetApi(21)
  public boolean a(Activity paramActivity, int paramInt, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramActivity != null)
    {
      bool1 = bool2;
      if (paramValueCallback != null)
      {
        this.b = paramValueCallback;
        paramValueCallback = paramFileChooserParams.getAcceptTypes();
        if (paramValueCallback == null) {
          break label67;
        }
        paramValueCallback = paramValueCallback[0];
        if (!paramFileChooserParams.isCaptureEnabled()) {
          break label73;
        }
      }
    }
    label67:
    label73:
    for (paramFileChooserParams = "*";; paramFileChooserParams = "")
    {
      a(paramActivity, paramInt, null, paramValueCallback, paramFileChooserParams);
      bool1 = true;
      return bool1;
      paramValueCallback = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     mpf
 * JD-Core Version:    0.7.0.1
 */