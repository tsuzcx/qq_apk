import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.SplashActivity;

class shq
  extends shb
{
  shq(shk paramshk) {}
  
  protected boolean a(Integer paramInteger)
  {
    shp localshp = shk.a(this.a, paramInteger.intValue());
    if (localshp == null) {
      return false;
    }
    if (localshp.jdField_a_of_type_Boolean)
    {
      this.a.b(localshp.jdField_a_of_type_JavaLangString);
      return true;
    }
    if (paramInteger.intValue() == 1) {
      this.a.b(localshp.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      return super.a(paramInteger);
      if (paramInteger.intValue() == 2)
      {
        shk.a(this.a, paramInteger.intValue());
      }
      else if (paramInteger.intValue() == 3)
      {
        shk.a(this.a, paramInteger.intValue());
      }
      else if (paramInteger.intValue() == 4)
      {
        shk.a(this.a, paramInteger.intValue());
      }
      else if (paramInteger.intValue() == 5)
      {
        shk.a(this.a, paramInteger.intValue());
      }
      else if (paramInteger.intValue() == 6)
      {
        shk.a(this.a, paramInteger.intValue());
      }
      else if (paramInteger.intValue() == 7)
      {
        shk.a(this.a).a(shk.a(this.a).c);
        shk.a(this.a, localshp.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 8)
      {
        shk.a(this.a).b(shk.a(this.a).c);
        shk.a(this.a, localshp.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 9)
      {
        shk.a(this.a).c();
        shk.a(this.a, localshp.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 10)
      {
        shk.a(this.a).a(this.a);
        shk.a(this.a, localshp.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 12)
      {
        shk.a(this.a);
        shk.a(this.a, localshp.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 28)
      {
        if (!TextUtils.isEmpty(shk.a(this.a).c))
        {
          ayec.a(1, 3);
          ayec.a(shk.a(this.a).c, shk.a(this.a).jdField_a_of_type_JavaLangString);
          shk.a(this.a, localshp.jdField_a_of_type_JavaLangString, true);
        }
      }
      else if (paramInteger.intValue() == 13)
      {
        if (!TextUtils.isEmpty(shk.a(this.a).c)) {
          this.a.a.d(shk.a(this.a).c, new shr(this, localshp));
        }
      }
      else if (paramInteger.intValue() == 14)
      {
        shk.a(this.a).c(shk.a(this.a).c);
        shk.a(this.a, localshp.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 20)
      {
        shk.b(this.a);
        shk.a(this.a, localshp.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 19)
      {
        this.a.b("not_care");
      }
      else
      {
        Intent localIntent;
        if (paramInteger.intValue() == 17)
        {
          if (!TextUtils.isEmpty(shk.a(this.a).e))
          {
            localIntent = AddFriendLogicActivity.a(this.a.a(), 1, shk.a(this.a).e + "", null, 3096, 1, shk.a(this.a).f, null, null, null, null);
            this.a.a().startActivity(localIntent);
          }
          shk.a(this.a, localshp.jdField_a_of_type_JavaLangString, true);
        }
        else if (paramInteger.intValue() == 16)
        {
          if (!TextUtils.isEmpty(shk.a(this.a).e))
          {
            localIntent = actn.a(new Intent(this.a.a(), SplashActivity.class), null);
            localIntent.putExtra("uin", shk.a(this.a).e);
            localIntent.putExtra("uintype", 0);
            this.a.a().startActivity(localIntent);
            shk.a(this.a, localshp.jdField_a_of_type_JavaLangString, true);
          }
        }
        else if (paramInteger.intValue() == 21)
        {
          if (!TextUtils.isEmpty(shk.a(this.a).e))
          {
            localIntent = new Intent(this.a.a(), AccountDetailActivity.class);
            localIntent.putExtra("uin", shk.a(this.a).e);
            localIntent.putExtra("from_js", true);
            this.a.a().startActivity(localIntent);
            shk.a(this.a, localshp.jdField_a_of_type_JavaLangString, true);
          }
        }
        else if (paramInteger.intValue() == 22)
        {
          this.a.b("personal_c2c");
        }
        else if (paramInteger.intValue() == 23)
        {
          this.a.b("unfollow");
        }
        else
        {
          this.a.b(localshp.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     shq
 * JD-Core Version:    0.7.0.1
 */