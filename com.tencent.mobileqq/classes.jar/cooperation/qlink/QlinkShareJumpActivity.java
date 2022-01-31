package cooperation.qlink;

import amvf;
import amvg;
import amvh;
import amvi;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class QlinkShareJumpActivity
  extends BaseActivity
{
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private String a(Uri paramUri)
  {
    String str = paramUri.getScheme();
    if ("file".equals(str)) {
      return new File(paramUri.getPath()).getAbsolutePath();
    }
    if ("content".equals(str)) {
      try
      {
        paramUri = getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
        int i = paramUri.getColumnIndexOrThrow("_data");
        paramUri.moveToFirst();
        str = paramUri.getString(i);
        paramUri.close();
        return str;
      }
      catch (Exception paramUri)
      {
        paramUri.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  private ArrayList a()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (this.jdField_a_of_type_JavaLangString.equals("android.intent.action.SEND"))
    {
      localObject = (Uri)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      if (localObject == null) {
        return null;
      }
      localObject = a((Uri)localObject);
      if (FileUtil.a((String)localObject)) {
        localArrayList.add(localObject);
      }
    }
    for (;;)
    {
      return localArrayList;
      localObject = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = a((Uri)((Iterator)localObject).next());
          if (FileUtil.a(str)) {
            localArrayList.add(str);
          }
        }
      }
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList = a();
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      DialogUtil.b(this, 230, getString(2131431977), getString(2131432035), 2131431935, 2131431935, new amvg(this), null).show();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 50)
      {
        DialogUtil.b(this, 230, getString(2131431977), getString(2131432036), 2131431935, 2131431935, new amvh(this), null).show();
        return;
      }
    } while ((a()) || (a(false)));
    b();
  }
  
  private boolean a()
  {
    Intent localIntent1 = getIntent();
    if (localIntent1.getExtras() == null) {
      new Bundle();
    }
    if (!this.app.isLogin())
    {
      Intent localIntent2 = new Intent(this, LoginActivity.class);
      localIntent2.addFlags(67371008);
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        localIntent1.putStringArrayListExtra("qlink_share_filepaths", this.jdField_a_of_type_JavaUtilArrayList);
      }
      localIntent2.putExtra("qlink_share_intent_data", localIntent1);
      localIntent2.putExtra("from_register_guide", true);
      startActivity(localIntent2);
      finish();
      overridePendingTransition(0, 0);
      return true;
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean)
  {
    Intent localIntent = getIntent();
    Object localObject2 = localIntent.getExtras();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    if ((GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())) && ((paramBoolean) || (!GesturePWDUtils.getAppForground(this))))
    {
      localObject2 = new Intent(getActivity(), GesturePWDUnlockActivity.class);
      ((Intent)localObject2).putExtra("key_gesture_from_jumpactivity", true);
      ((Intent)localObject2).setAction(localIntent.getAction());
      ((Intent)localObject2).putExtra("isActionSend", true);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).putExtras(localIntent);
      startActivityForResult((Intent)localObject2, 4097);
      return true;
    }
    return false;
  }
  
  private void b()
  {
    Bundle localBundle;
    ArrayList localArrayList;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      this.app.a().a("0X8004F47", this.jdField_a_of_type_JavaUtilArrayList.size());
      localBundle = new Bundle();
      localBundle.putStringArrayList("string_filepaths", this.jdField_a_of_type_JavaUtilArrayList);
      localArrayList = FMDataCache.b();
      if (localArrayList == null) {
        break label125;
      }
    }
    label125:
    for (int i = localArrayList.size();; i = 0)
    {
      localBundle.putInt("string_beforeshare_selectedfile_count", i);
      QQProxyForQlink.a(this, 10, localBundle);
      finish();
      return;
      DialogUtil.b(this, 230, getString(2131431977), getString(2131432035), 2131431935, 2131431935, new amvi(this), null).show();
      return;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 == 4097)
      {
        b();
        return;
      }
      finish();
      return;
    }
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      try
      {
        this.jdField_a_of_type_JavaLangString = paramBundle.getAction();
        this.jdField_a_of_type_AndroidOsBundle = paramBundle.getExtras();
        if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || ((!this.jdField_a_of_type_JavaLangString.equals("android.intent.action.SEND")) && (!this.jdField_a_of_type_JavaLangString.equals("android.intent.action.SEND_MULTIPLE")))) {
          break label220;
        }
        if (!paramBundle.getBooleanExtra("qlink_share_login_suc_flag", false)) {
          break label213;
        }
        paramBundle = paramBundle.getStringArrayListExtra("qlink_share_filepaths");
        if ((paramBundle != null) && (paramBundle.size() > 0))
        {
          paramBundle = paramBundle.iterator();
          while (paramBundle.hasNext())
          {
            String str = (String)paramBundle.next();
            if (FileUtil.a(str))
            {
              if (this.jdField_a_of_type_JavaUtilArrayList == null) {
                this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
              }
              this.jdField_a_of_type_JavaUtilArrayList.add(str);
            }
          }
        }
        if (a(true)) {
          break label232;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        DialogUtil.b(this, 230, getString(2131431977), getString(2131432035), 2131431935, 2131431935, new amvf(this), null).show();
        return false;
      }
      b();
      break label232;
      label213:
      a();
    }
    else
    {
      label220:
      finish();
      overridePendingTransition(0, 0);
      return false;
    }
    label232:
    return true;
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qlink.QlinkShareJumpActivity
 * JD-Core Version:    0.7.0.1
 */