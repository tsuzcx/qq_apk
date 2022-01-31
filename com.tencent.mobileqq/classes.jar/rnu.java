import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ScreenShotShareHelper.1;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ScreenShotShareHelper.2;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ScreenShotShareHelper.3;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import mqq.app.AppRuntime;
import org.json.JSONArray;

public class rnu
  implements Handler.Callback, AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler = new bfnk(Looper.getMainLooper(), this);
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener;
  private bbjc jdField_a_of_type_Bbjc;
  private bcpq jdField_a_of_type_Bcpq;
  private String jdField_a_of_type_JavaLangString;
  private JSONArray jdField_a_of_type_OrgJsonJSONArray;
  private wxu jdField_a_of_type_Wxu;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString = "";
  private String e = "";
  private String f = "";
  
  public rnu(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if (this.jdField_a_of_type_Wxu == null)
    {
      this.jdField_a_of_type_Wxu = wxu.a();
      this.jdField_a_of_type_Wxu.a();
    }
    this.jdField_b_of_type_Int = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298865);
    this.jdField_c_of_type_JavaLangString = "";
    paramActivity = new DisplayMetrics();
    this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay().getMetrics(paramActivity);
    this.jdField_d_of_type_Int = paramActivity.widthPixels;
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public Bitmap a(String paramString)
  {
    paramString = rnt.a(paramString, this.jdField_d_of_type_Int, this.jdField_c_of_type_JavaLangString, "QRCode_");
    this.jdField_a_of_type_JavaLangString = ((String)paramString.first);
    paramString = (Bitmap)paramString.second;
    if (QLog.isDevelopLevel()) {
      QLog.d("", 2, "generateScreenShotImageWithQRCode->end time:" + System.currentTimeMillis());
    }
    this.jdField_a_of_type_Boolean = false;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Int > 0)) {}
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return paramString;
    case 1: 
      c();
      return paramString;
    case 2: 
      this.jdField_a_of_type_AndroidOsHandler.post(new ScreenShotShareHelper.2(this));
      return paramString;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ScreenShotShareHelper.3(this));
    return paramString;
  }
  
  public bbjc a()
  {
    return this.jdField_a_of_type_Bbjc;
  }
  
  public bcpq a()
  {
    if (this.jdField_a_of_type_Bcpq == null)
    {
      this.jdField_a_of_type_Bcpq = new bcpq(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Bcpq.c(2131694099);
    }
    return this.jdField_a_of_type_Bcpq;
  }
  
  public String a()
  {
    String str2 = ajyc.a(2131713579);
    String str1 = str2;
    try
    {
      if (this.jdField_a_of_type_OrgJsonJSONArray != null)
      {
        int i = this.jdField_a_of_type_OrgJsonJSONArray.length();
        i = new Random().nextInt(i);
        str1 = this.jdField_a_of_type_OrgJsonJSONArray.getString(i);
      }
      return str1;
    }
    catch (Exception localException)
    {
      do
      {
        str1 = str2;
      } while (!QLog.isColorLevel());
      QLog.d("", 2, "actionSheet.show exception=" + localException);
    }
    return str2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Wxu != null) {
      this.jdField_a_of_type_Wxu.b();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void a(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.contains("ShotCache_"))) {
      this.jdField_c_of_type_Int = 3;
    }
    if ((this.jdField_c_of_type_Int == 0) && (paramInt > 0)) {
      this.jdField_c_of_type_Int = paramInt;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("", 2, "doOnPhotoPlusActivityEditResult->mScreenshotFromType:" + this.jdField_c_of_type_Int + ", mEditScreenshotPath:" + this.jdField_b_of_type_JavaLangString + ", originImagePath:" + paramString2);
    }
    if (this.jdField_c_of_type_Int == 3)
    {
      d(this.jdField_b_of_type_JavaLangString);
      return;
    }
    b();
  }
  
  public void a(JSONArray paramJSONArray)
  {
    this.jdField_a_of_type_OrgJsonJSONArray = paramJSONArray;
  }
  
  public List<bbje>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    bbje localbbje = new bbje();
    localbbje.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131696695);
    localbbje.jdField_b_of_type_Int = 2130838754;
    localbbje.jdField_b_of_type_Boolean = true;
    localbbje.jdField_c_of_type_Int = 2;
    localbbje.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbje);
    localbbje = new bbje();
    localbbje.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131696708);
    localbbje.jdField_b_of_type_Int = 2130838755;
    localbbje.jdField_b_of_type_Boolean = true;
    localbbje.jdField_c_of_type_Int = 3;
    localbbje.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbje);
    localbbje = new bbje();
    localbbje.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131696715);
    localbbje.jdField_b_of_type_Int = 2130838758;
    localbbje.jdField_c_of_type_Int = 9;
    localbbje.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbje);
    localbbje = new bbje();
    localbbje.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131696698);
    localbbje.jdField_b_of_type_Int = 2130838752;
    localbbje.jdField_c_of_type_Int = 10;
    localbbje.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbje);
    localbbje = new bbje();
    localbbje.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131696712);
    localbbje.jdField_b_of_type_Int = 2130838757;
    localbbje.jdField_c_of_type_Int = 12;
    localbbje.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbje);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public String b()
  {
    return this.f;
  }
  
  public void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("", 2, "showShareActionSheet->mEditScreenshotPath:" + this.jdField_b_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      return;
    }
    if (this.jdField_a_of_type_Bbjc == null) {
      this.jdField_a_of_type_Bbjc = new bbjc(this.jdField_a_of_type_AndroidAppActivity);
    }
    if ((sgj.b(this.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(a()))) {
      this.jdField_a_of_type_Bbjc.a(a());
    }
    for (;;)
    {
      this.jdField_a_of_type_Bbjc.a(a());
      this.jdField_a_of_type_Bbjc.a(this);
      try
      {
        this.jdField_a_of_type_Bbjc.a();
        if (QLog.isDevelopLevel()) {
          QLog.d("", 2, "showShareActionSheet->post runnable generate screenshot with QRcode! time:" + System.currentTimeMillis());
        }
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_a_of_type_Int = 0;
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
          this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        }
        ThreadManager.executeOnSubThread(new ScreenShotShareHelper.1(this));
        return;
        this.jdField_a_of_type_Bbjc.a(BaseApplicationImpl.getContext().getString(2131719497));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("", 2, "actionSheet.show exception=" + localException);
          }
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public String c()
  {
    if (this.jdField_c_of_type_JavaLangString != null) {
      return this.jdField_c_of_type_JavaLangString;
    }
    return "";
  }
  
  public void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("", 2, "shareScreenShotToQZone!");
    }
    if ((!this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      bgyf localbgyf = bgyf.a();
      localbgyf.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      bgxy.a(this.jdField_a_of_type_AndroidAppActivity, localbgyf, this.jdField_a_of_type_JavaLangString, BaseApplicationImpl.getContext().getString(2131720904), "", -1);
      return;
    }
    this.jdField_a_of_type_Int = 1;
    bcpw.a(BaseApplicationImpl.getContext(), 0, 2131695590, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298865));
  }
  
  public void c(String paramString)
  {
    this.f = paramString;
  }
  
  public void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("", 2, "shareScreenShotToWechat!");
    }
    int i;
    if (!WXShareHelper.a().a()) {
      i = 2131720906;
    }
    for (;;)
    {
      if (i != -1)
      {
        wim.a(0, i);
        return;
        if (!WXShareHelper.a().b()) {
          i = 2131720907;
        }
      }
      else
      {
        try
        {
          if ((!this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_Wxu.d(new rnv(this));
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        this.jdField_a_of_type_Int = 2;
        bcpw.a(BaseApplicationImpl.getContext(), 0, 2131695590, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298865));
        return;
      }
      i = -1;
    }
  }
  
  public void d(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("", 2, "shareScreenShotToQQ->imgPath:" + paramString);
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ForwardRecentActivity.class);
    localIntent.putExtra("req_share_id", 1478164480L);
    localIntent.putExtra("image_url", paramString);
    localIntent.putExtra("forward_type", -3);
    String str;
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
    {
      paramString = this.jdField_c_of_type_JavaLangString;
      if (!TextUtils.isEmpty(this.f)) {
        break label285;
      }
      str = BaseApplicationImpl.getContext().getResources().getString(2131695588);
      label115:
      paramString = "ScreenShotShare|" + paramString + "|" + str;
      if (this.jdField_c_of_type_Int != 3) {
        break label293;
      }
    }
    label285:
    label293:
    for (paramString = paramString.concat("|1");; paramString = paramString.concat("|0"))
    {
      localIntent.putExtra("struct_share_key_content_action_DATA", paramString);
      localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
      localIntent.putExtra("req_type", 5);
      localIntent.putExtra("brief_key", ajyc.a(2131713578));
      localIntent.putExtra("struct_share_key_source_icon", "http://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0");
      localIntent.putExtra("struct_share_key_source_name", "QQ看点");
      localIntent.putExtra("struct_share_key_source_action", "plugin");
      localIntent.putExtra("struct_share_key_source_action_data", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
      localIntent.putExtra("stuctmsg_bytes", axuy.a(localIntent.getExtras()).getBytes());
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 1);
      return;
      paramString = this.jdField_d_of_type_JavaLangString;
      break;
      str = this.f;
      break label115;
    }
  }
  
  public void e()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("", 2, "shareScreenShotToWechatCircle!");
    }
    int i;
    if (!WXShareHelper.a().a()) {
      i = 2131720906;
    }
    for (;;)
    {
      if (i != -1)
      {
        wim.a(0, i);
        return;
        if (!WXShareHelper.a().b()) {
          i = 2131720907;
        }
      }
      else
      {
        try
        {
          if ((!this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_Wxu.d(new rnw(this));
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        this.jdField_a_of_type_Int = 3;
        bcpw.a(BaseApplicationImpl.getContext(), 0, 2131695590, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298865));
        return;
      }
      i = -1;
    }
  }
  
  public void e(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "shareMsgToSina start!");
    }
    if (this.jdField_a_of_type_Bcpq == null)
    {
      this.jdField_a_of_type_Bcpq = new bcpq(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Bcpq.c(2131694099);
    }
    this.jdField_a_of_type_Bcpq.show();
    Object localObject = BaseApplicationImpl.getContext().getPackageManager();
    for (;;)
    {
      try
      {
        ApplicationInfo localApplicationInfo = ((PackageManager)localObject).getApplicationInfo("com.sina.weibo", 8192);
        if (QLog.isColorLevel()) {
          QLog.d("", 2, "shareMsgToSina installSinaWeibo:true");
        }
        if (!TextUtils.isEmpty(this.f)) {
          continue;
        }
        localObject = BaseApplicationImpl.getContext().getResources().getString(2131695588);
        this.e = ((String)localObject);
        if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
          continue;
        }
        localObject = this.jdField_c_of_type_JavaLangString;
        Intent localIntent = new Intent("android.intent.action.SEND");
        localIntent.setFlags(268435456);
        localIntent.setType("image/*");
        localIntent.putExtra("android.intent.extra.TEXT", this.e + (String)localObject);
        if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.jdField_b_of_type_JavaLangString)));
        }
        localIntent.setPackage(localApplicationInfo.packageName);
        this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
        if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing())) {
          this.jdField_a_of_type_Bcpq.dismiss();
        }
        if (QLog.isColorLevel()) {
          QLog.d("", 2, "shareMsgToSina start weibo!");
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("", 2, "shareMsgToSina installSinaWeibo:false");
        if ((this.jdField_a_of_type_Bcpq == null) || (!this.jdField_a_of_type_Bcpq.isShowing())) {
          continue;
        }
        this.jdField_a_of_type_Bcpq.dismiss();
        bcpw.a(BaseApplicationImpl.getContext(), 0, 2131695598, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298865));
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "shareMsgToSina end!");
      }
      return;
      localObject = this.f;
      continue;
      localObject = this.jdField_d_of_type_JavaLangString;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "onScreenShotItemClick->begin!");
    }
    Object localObject = paramView.getTag();
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "onScreenShotItemClick->tag null!");
      }
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_Bbjc.b();
      switch (((bbjh)localObject).a.jdField_c_of_type_Int)
      {
      }
      while (this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener != null)
      {
        this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        return;
        d(this.jdField_b_of_type_JavaLangString);
        continue;
        c();
        continue;
        d();
        continue;
        e();
        continue;
        f();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rnu
 * JD-Core Version:    0.7.0.1
 */